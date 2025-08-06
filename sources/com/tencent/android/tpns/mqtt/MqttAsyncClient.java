package com.tencent.android.tpns.mqtt;

import com.appsflyer.internal.ae;
import com.huobi.vulcan.model.VulcanInfo;
import com.jumio.sdk.reject.JumioRejectReason;
import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.internal.ConnectActionListener;
import com.tencent.android.tpns.mqtt.internal.DisconnectedMessageBuffer;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.tencent.android.tpns.mqtt.internal.NetworkModule;
import com.tencent.android.tpns.mqtt.internal.SSLNetworkModule;
import com.tencent.android.tpns.mqtt.internal.TCPNetworkModule;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import com.tencent.android.tpns.mqtt.internal.websocket.WebSocketNetworkModule;
import com.tencent.android.tpns.mqtt.internal.websocket.WebSocketSecureNetworkModule;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingReq;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubscribe;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpns.mqtt.persist.MemoryPersistence;
import com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence;
import com.tencent.android.tpns.mqtt.util.Debug;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class MqttAsyncClient implements IMqttAsyncClient {
    private static final String CLASS_NAME = "MqttAsyncClient";
    private static final String CLIENT_ID_PREFIX = "paho";
    private static final long DISCONNECT_TIMEOUT = 10000;
    private static final char MAX_HIGH_SURROGATE = '?';
    private static final char MIN_HIGH_SURROGATE = '?';
    private static final long QUIESCE_TIMEOUT = 30000;
    private static final String TAG = "MqttAsyncClient";
    /* access modifiers changed from: private */
    public static Object clientLock = new Object();
    /* access modifiers changed from: private */
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, "MqttAsyncClient");
    /* access modifiers changed from: private */
    public static int reconnectDelay = 1000;
    /* access modifiers changed from: private */
    public String clientId;
    public ClientComms comms;
    /* access modifiers changed from: private */
    public MqttConnectOptions connOpts;
    private ExecutorService executorService;
    private MqttCallback mqttCallback;
    private MqttClientPersistence persistence;
    /* access modifiers changed from: private */
    public Timer reconnectTimer;
    /* access modifiers changed from: private */
    public boolean reconnecting;
    private String serverURI;
    private Hashtable topics;
    private Object userContext;

    public class MqttReconnectActionListener implements IMqttActionListener {
        public final String methodName;

        public MqttReconnectActionListener(String str) {
            this.methodName = str;
        }

        private void rescheduleReconnectCycle(int i11) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName + ":rescheduleReconnectCycle", "505", new Object[]{MqttAsyncClient.this.clientId, String.valueOf(MqttAsyncClient.reconnectDelay)});
            synchronized (MqttAsyncClient.clientLock) {
                if (MqttAsyncClient.this.connOpts.isAutomaticReconnect()) {
                    if (MqttAsyncClient.this.reconnectTimer != null) {
                        MqttAsyncClient.this.reconnectTimer.schedule(new ReconnectTask(), (long) i11);
                    } else {
                        int unused = MqttAsyncClient.reconnectDelay = i11;
                        MqttAsyncClient.this.startReconnectCycle();
                    }
                }
            }
        }

        public void onFailure(IMqttToken iMqttToken, Throwable th2) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName, "502", new Object[]{iMqttToken.getClient().getClientId()});
            if (MqttAsyncClient.reconnectDelay < 128000) {
                int unused = MqttAsyncClient.reconnectDelay = MqttAsyncClient.reconnectDelay * 2;
            }
            rescheduleReconnectCycle(MqttAsyncClient.reconnectDelay);
        }

        public void onSuccess(IMqttToken iMqttToken) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName, "501", new Object[]{iMqttToken.getClient().getClientId()});
            MqttAsyncClient.this.comms.setRestingState(false);
            MqttAsyncClient.this.stopReconnectCycle();
        }
    }

    public class MqttReconnectCallback implements MqttCallbackExtended {
        public final boolean automaticReconnect;

        public MqttReconnectCallback(boolean z11) {
            this.automaticReconnect = z11;
        }

        public void connectComplete(boolean z11, String str) {
        }

        public void connectionLost(Throwable th2) {
            if (this.automaticReconnect) {
                MqttAsyncClient.this.comms.setRestingState(true);
                boolean unused = MqttAsyncClient.this.reconnecting = true;
                MqttAsyncClient.this.startReconnectCycle();
            }
        }

        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        }

        public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
        }
    }

    public class ReconnectTask extends TimerTask {
        private static final String methodName = "ReconnectTask.run";

        private ReconnectTask() {
        }

        public void run() {
            MqttAsyncClient.log.fine("MqttAsyncClient", methodName, "506");
            MqttAsyncClient.this.attemptReconnect();
        }
    }

    public MqttAsyncClient(String str, String str2) throws MqttException {
        this(str, str2, new MqttDefaultFilePersistence());
    }

    public static boolean Character_isHighSurrogate(char c11) {
        return c11 >= 55296 && c11 <= 56319;
    }

    /* access modifiers changed from: private */
    public void attemptReconnect() {
        log.fine("MqttAsyncClient", "attemptReconnect", "500", new Object[]{this.clientId});
        try {
            connect(this.connOpts, this.userContext, new MqttReconnectActionListener("attemptReconnect"));
        } catch (MqttSecurityException e11) {
            log.fine("MqttAsyncClient", "attemptReconnect", "804", (Object[]) null, e11);
        } catch (MqttException e12) {
            TBaseLogger.e("MqttAsyncClient", "attemptReconnect", e12);
        }
    }

    private NetworkModule createNetworkModule(String str, MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        SSLSocketFactoryFactory sSLSocketFactoryFactory;
        String[] enabledCipherSuites;
        SSLSocketFactoryFactory sSLSocketFactoryFactory2;
        String[] enabledCipherSuites2;
        Logger logger = log;
        logger.fine("MqttAsyncClient", "createNetworkModule", "115", new Object[]{str});
        SocketFactory socketFactory = mqttConnectOptions.getSocketFactory();
        int validateURI = MqttConnectOptions.validateURI(str);
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null && str.contains("_")) {
                Field declaredField = URI.class.getDeclaredField(VulcanInfo.HOST);
                declaredField.setAccessible(true);
                declaredField.set(uri, getHostName(str.substring(uri.getScheme().length() + 3)));
            }
            String host = uri.getHost();
            int port = uri.getPort();
            if (validateURI == 0) {
                if (port == -1) {
                    port = 1883;
                }
                if (socketFactory == null) {
                    socketFactory = SocketFactory.getDefault();
                } else if (socketFactory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                TCPNetworkModule tCPNetworkModule = new TCPNetworkModule(socketFactory, host, port, this.clientId);
                tCPNetworkModule.setConnectTimeout(mqttConnectOptions.getConnectionTimeout());
                return tCPNetworkModule;
            } else if (validateURI == 1) {
                if (port == -1) {
                    port = 8883;
                }
                if (socketFactory == null) {
                    sSLSocketFactoryFactory = new SSLSocketFactoryFactory();
                    Properties sSLProperties = mqttConnectOptions.getSSLProperties();
                    if (sSLProperties != null) {
                        sSLSocketFactoryFactory.initialize(sSLProperties, (String) null);
                    }
                    socketFactory = sSLSocketFactoryFactory.createSocketFactory((String) null);
                } else if (socketFactory instanceof SSLSocketFactory) {
                    sSLSocketFactoryFactory = null;
                } else {
                    throw ExceptionHelper.createMqttException(32105);
                }
                SSLNetworkModule sSLNetworkModule = new SSLNetworkModule((SSLSocketFactory) socketFactory, host, port, this.clientId);
                sSLNetworkModule.setSSLhandshakeTimeout(mqttConnectOptions.getConnectionTimeout());
                sSLNetworkModule.setSSLHostnameVerifier(mqttConnectOptions.getSSLHostnameVerifier());
                if (!(sSLSocketFactoryFactory == null || (enabledCipherSuites = sSLSocketFactoryFactory.getEnabledCipherSuites((String) null)) == null)) {
                    sSLNetworkModule.setEnabledCiphers(enabledCipherSuites);
                }
                return sSLNetworkModule;
            } else if (validateURI == 3) {
                int i11 = port == -1 ? 80 : port;
                if (socketFactory == null) {
                    socketFactory = SocketFactory.getDefault();
                } else if (socketFactory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                WebSocketNetworkModule webSocketNetworkModule = new WebSocketNetworkModule(socketFactory, str, host, i11, this.clientId);
                webSocketNetworkModule.setConnectTimeout(mqttConnectOptions.getConnectionTimeout());
                return webSocketNetworkModule;
            } else if (validateURI != 4) {
                logger.fine("MqttAsyncClient", "createNetworkModule", "119", new Object[]{str});
                return null;
            } else {
                int i12 = port == -1 ? 443 : port;
                if (socketFactory == null) {
                    SSLSocketFactoryFactory sSLSocketFactoryFactory3 = new SSLSocketFactoryFactory();
                    Properties sSLProperties2 = mqttConnectOptions.getSSLProperties();
                    if (sSLProperties2 != null) {
                        sSLSocketFactoryFactory3.initialize(sSLProperties2, (String) null);
                    }
                    socketFactory = sSLSocketFactoryFactory3.createSocketFactory((String) null);
                    sSLSocketFactoryFactory2 = sSLSocketFactoryFactory3;
                } else if (socketFactory instanceof SSLSocketFactory) {
                    sSLSocketFactoryFactory2 = null;
                } else {
                    throw ExceptionHelper.createMqttException(32105);
                }
                WebSocketSecureNetworkModule webSocketSecureNetworkModule = new WebSocketSecureNetworkModule((SSLSocketFactory) socketFactory, str, host, i12, this.clientId);
                webSocketSecureNetworkModule.setSSLhandshakeTimeout(mqttConnectOptions.getConnectionTimeout());
                if (!(sSLSocketFactoryFactory2 == null || (enabledCipherSuites2 = sSLSocketFactoryFactory2.getEnabledCipherSuites((String) null)) == null)) {
                    webSocketSecureNetworkModule.setEnabledCiphers(enabledCipherSuites2);
                }
                return webSocketSecureNetworkModule;
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e11) {
            throw ExceptionHelper.createMqttException(e11.getCause());
        } catch (URISyntaxException e12) {
            throw new IllegalArgumentException("Malformed URI: " + str + ", " + e12.getMessage());
        }
    }

    public static String generateClientId() {
        return CLIENT_ID_PREFIX + System.nanoTime();
    }

    private String getHostName(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            indexOf = str.indexOf(47);
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    /* access modifiers changed from: private */
    public void startReconnectCycle() {
        log.fine("MqttAsyncClient", "startReconnectCycle", "503", new Object[]{this.clientId, new Long((long) reconnectDelay)});
        Timer timer = new Timer("MQTT Reconnect: " + this.clientId);
        this.reconnectTimer = timer;
        timer.schedule(new ReconnectTask(), (long) reconnectDelay);
    }

    /* access modifiers changed from: private */
    public void stopReconnectCycle() {
        log.fine("MqttAsyncClient", "stopReconnectCycle", "504", new Object[]{this.clientId});
        synchronized (clientLock) {
            if (this.connOpts.isAutomaticReconnect()) {
                Timer timer = this.reconnectTimer;
                if (timer != null) {
                    timer.cancel();
                    this.reconnectTimer = null;
                }
                reconnectDelay = 1000;
            }
        }
    }

    public IMqttToken checkPing(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        log.fine("MqttAsyncClient", "ping", "117");
        return null;
    }

    public void close() throws MqttException {
        close(false);
    }

    public IMqttToken connect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException {
        return connect(new MqttConnectOptions(), obj, iMqttActionListener);
    }

    public NetworkModule[] createNetworkModules(String str, MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        log.fine("MqttAsyncClient", "createNetworkModules", "116", new Object[]{str});
        String[] serverURIs = mqttConnectOptions.getServerURIs();
        if (serverURIs == null) {
            serverURIs = new String[]{str};
        } else if (serverURIs.length == 0) {
            serverURIs = new String[]{str};
        }
        NetworkModule[] networkModuleArr = new NetworkModule[serverURIs.length];
        for (int i11 = 0; i11 < serverURIs.length; i11++) {
            networkModuleArr[i11] = createNetworkModule(serverURIs[i11], mqttConnectOptions);
        }
        log.fine("MqttAsyncClient", "createNetworkModules", "108");
        return networkModuleArr;
    }

    public void deleteBufferedMessage(int i11) {
        this.comms.deleteBufferedMessage(i11);
    }

    public void destroy() throws MqttException {
        close(true);
    }

    public IMqttToken disconnect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return disconnect(30000, obj, iMqttActionListener);
    }

    public void disconnectForcibly() throws MqttException {
        disconnectForcibly(30000, 10000);
    }

    public MqttMessage getBufferedMessage(int i11) {
        return this.comms.getBufferedMessage(i11);
    }

    public int getBufferedMessageCount() {
        return this.comms.getBufferedMessageCount();
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getCurrentServerURI() {
        return this.comms.getNetworkModules()[this.comms.getNetworkModuleIndex()].getServerURI();
    }

    public Debug getDebug() {
        return new Debug(this.clientId, this.comms);
    }

    public int getInFlightMessageCount() {
        return this.comms.getActualInFlight();
    }

    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.comms.getPendingDeliveryTokens();
    }

    public String getServerURI() {
        return this.serverURI;
    }

    public MqttTopic getTopic(String str) {
        MqttTopic.validate(str, false);
        MqttTopic mqttTopic = (MqttTopic) this.topics.get(str);
        if (mqttTopic != null) {
            return mqttTopic;
        }
        MqttTopic mqttTopic2 = new MqttTopic(str, this.comms);
        this.topics.put(str, mqttTopic2);
        return mqttTopic2;
    }

    public boolean isClosed() {
        return this.comms.isClosed();
    }

    public boolean isConnected() {
        return this.comms.isConnected();
    }

    public boolean isConnecting() {
        return this.comms.isConnecting();
    }

    public boolean isDisConnecting() {
        return this.comms.isDisconnecting();
    }

    public void messageArrivedComplete(int i11, int i12) throws MqttException {
        this.comms.messageArrivedComplete(i11, i12);
    }

    public MqttToken ping(IMqttActionListener iMqttActionListener) throws MqttException {
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        this.comms.sendNoWait(new MqttPingReq(), mqttToken);
        return mqttToken;
    }

    public IMqttDeliveryToken publish(String str, byte[] bArr, int i11, boolean z11, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i11);
        mqttMessage.setRetained(z11);
        return publish(str, mqttMessage, obj, iMqttActionListener);
    }

    public void reconnect() throws MqttException {
        log.fine("MqttAsyncClient", "reconnect", "500", new Object[]{this.clientId});
        if (this.comms.isConnected()) {
            throw ExceptionHelper.createMqttException(32100);
        } else if (this.comms.isConnecting()) {
            throw new MqttException(32110);
        } else if (this.comms.isDisconnecting()) {
            throw new MqttException(32102);
        } else if (!this.comms.isClosed()) {
            stopReconnectCycle();
            attemptReconnect();
        } else {
            throw new MqttException(32111);
        }
    }

    public void setBufferOpts(DisconnectedBufferOptions disconnectedBufferOptions) {
        this.comms.setDisconnectedMessageBuffer(new DisconnectedMessageBuffer(disconnectedBufferOptions));
    }

    public void setCallback(MqttCallback mqttCallback2) {
        this.mqttCallback = mqttCallback2;
        this.comms.setCallback(mqttCallback2);
    }

    public void setManualAcks(boolean z11) {
        this.comms.setManualAcks(z11);
    }

    public void shutdownConnection() {
        try {
            log.fine("MqttAsyncClient", "shutdownConnection", "run");
            this.comms.shutdownConnection((MqttToken) null, (MqttException) null);
        } catch (Throwable th2) {
            log.fine("MqttAsyncClient", "shutdownConnection", th2.toString());
        }
    }

    public IMqttToken subscribe(String str, int i11, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i11}, obj, iMqttActionListener);
    }

    public IMqttToken unsubscribe(String str, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return unsubscribe(new String[]{str}, obj, iMqttActionListener);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence) throws MqttException {
        this(str, str2, mqttClientPersistence, new TimerPingSender());
    }

    public void close(boolean z11) throws MqttException {
        Logger logger = log;
        logger.fine("MqttAsyncClient", "close", ae.AFInAppEventParameterName);
        this.comms.close(z11);
        logger.fine("MqttAsyncClient", "close", "114");
    }

    public IMqttToken connect() throws MqttException, MqttSecurityException {
        return connect((Object) null, (IMqttActionListener) null);
    }

    public IMqttToken disconnect() throws MqttException {
        return disconnect((Object) null, (IMqttActionListener) null);
    }

    public void disconnectForcibly(long j11) throws MqttException {
        disconnectForcibly(30000, j11);
    }

    public IMqttToken subscribe(String str, int i11) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i11}, (Object) null, (IMqttActionListener) null);
    }

    public IMqttToken unsubscribe(String str) throws MqttException {
        return unsubscribe(new String[]{str}, (Object) null, (IMqttActionListener) null);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender) throws MqttException {
        this(str, str2, mqttClientPersistence, mqttPingSender, (ExecutorService) null);
    }

    public IMqttToken connect(MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        return connect(mqttConnectOptions, (Object) null, (IMqttActionListener) null);
    }

    public IMqttToken disconnect(long j11) throws MqttException {
        return disconnect(j11, (Object) null, (IMqttActionListener) null);
    }

    public void disconnectForcibly(long j11, long j12) throws MqttException {
        this.comms.disconnectForcibly(j11, j12);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
    }

    public IMqttToken unsubscribe(String[] strArr) throws MqttException {
        return unsubscribe(strArr, (Object) null, (IMqttActionListener) null);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender, ExecutorService executorService2) throws MqttException {
        this.reconnecting = false;
        TBaseLogger.d("MqttAsyncClient", "init MqttAsyncClient");
        log.setResourceName(str2);
        if (str2 != null) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < str2.length() - 1) {
                if (Character_isHighSurrogate(str2.charAt(i11))) {
                    i11++;
                }
                i12++;
                i11++;
            }
            if (i12 <= 65535) {
                MqttConnectOptions.validateURI(str);
                this.serverURI = str;
                this.clientId = str2;
                this.persistence = mqttClientPersistence;
                if (mqttClientPersistence == null) {
                    this.persistence = new MemoryPersistence();
                }
                this.executorService = executorService2;
                if (executorService2 == null) {
                    this.executorService = Executors.newScheduledThreadPool(10);
                }
                log.fine("MqttAsyncClient", "MqttAsyncClient", "101", new Object[]{str2, str, mqttClientPersistence});
                this.persistence.open(str2, str);
                this.comms = new ClientComms(this, this.persistence, mqttPingSender, this.executorService);
                this.persistence.close();
                this.topics = new Hashtable();
                return;
            }
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        throw new IllegalArgumentException("Null clientId");
    }

    public IMqttToken connect(MqttConnectOptions mqttConnectOptions, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException {
        if (this.comms.isConnected()) {
            throw ExceptionHelper.createMqttException(32100);
        } else if (this.comms.isConnecting()) {
            throw new MqttException(32110);
        } else if (this.comms.isDisconnecting()) {
            throw new MqttException(32102);
        } else if (!this.comms.isClosed()) {
            if (mqttConnectOptions == null) {
                mqttConnectOptions = new MqttConnectOptions();
            }
            MqttConnectOptions mqttConnectOptions2 = mqttConnectOptions;
            this.connOpts = mqttConnectOptions2;
            this.userContext = obj;
            boolean isAutomaticReconnect = mqttConnectOptions2.isAutomaticReconnect();
            Logger logger = log;
            Object[] objArr = new Object[8];
            objArr[0] = Boolean.valueOf(mqttConnectOptions2.isCleanSession());
            objArr[1] = new Integer(mqttConnectOptions2.getConnectionTimeout());
            objArr[2] = new Integer(mqttConnectOptions2.getKeepAliveInterval());
            objArr[3] = mqttConnectOptions2.getUserName();
            String str = "[null]";
            objArr[4] = mqttConnectOptions2.getPassword() == null ? str : "[notnull]";
            if (mqttConnectOptions2.getWillMessage() != null) {
                str = "[notnull]";
            }
            objArr[5] = str;
            objArr[6] = obj;
            objArr[7] = iMqttActionListener;
            logger.fine("MqttAsyncClient", "connect", JumioRejectReason.COLOR_PHOTOCOPY, objArr);
            this.comms.setNetworkModules(createNetworkModules(this.serverURI, mqttConnectOptions2));
            this.comms.setReconnectCallback(new MqttReconnectCallback(isAutomaticReconnect));
            MqttToken mqttToken = new MqttToken(getClientId());
            ConnectActionListener connectActionListener = new ConnectActionListener(this, this.persistence, this.comms, mqttConnectOptions2, mqttToken, obj, iMqttActionListener, this.reconnecting);
            mqttToken.setActionCallback(connectActionListener);
            mqttToken.setUserContext(this);
            MqttCallback mqttCallback2 = this.mqttCallback;
            if (mqttCallback2 instanceof MqttCallbackExtended) {
                connectActionListener.setMqttCallbackExtended((MqttCallbackExtended) mqttCallback2);
            }
            this.comms.setNetworkModuleIndex(0);
            connectActionListener.connect();
            return mqttToken;
        } else {
            throw new MqttException(32111);
        }
    }

    public IMqttToken disconnect(long j11, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        mqttToken.setUserContext(obj);
        this.comms.disconnect(new MqttDisconnect(), j11, mqttToken);
        log.fine("MqttAsyncClient", "disconnect", "108");
        return mqttToken;
    }

    public void disconnectForcibly(long j11, long j12, boolean z11) throws MqttException {
        this.comms.disconnectForcibly(j11, j12, z11);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        TBaseLogger.d("MqttAsyncClient", "action - subscribe");
        if (strArr.length == iArr.length) {
            for (String removeMessageListener : strArr) {
                this.comms.removeMessageListener(removeMessageListener);
            }
            if (log.isLoggable(5)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i11 = 0; i11 < strArr.length; i11++) {
                    if (i11 > 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append("topic=");
                    stringBuffer.append(strArr[i11]);
                    stringBuffer.append(" qos=");
                    stringBuffer.append(iArr[i11]);
                    MqttTopic.validate(strArr[i11], true);
                }
                log.fine("MqttAsyncClient", "subscribe", "106", new Object[]{stringBuffer.toString(), obj, iMqttActionListener});
            }
            MqttToken mqttToken = new MqttToken(getClientId());
            mqttToken.setActionCallback(iMqttActionListener);
            mqttToken.setUserContext(obj);
            mqttToken.internalTok.setTopics(strArr);
            this.comms.sendNoWait(new MqttSubscribe(strArr, iArr), mqttToken);
            log.fine("MqttAsyncClient", "subscribe", "109");
            return mqttToken;
        }
        throw new IllegalArgumentException();
    }

    public IMqttToken unsubscribe(String[] strArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        if (log.isLoggable(5)) {
            String str = "";
            for (int i11 = 0; i11 < strArr.length; i11++) {
                if (i11 > 0) {
                    str = str + ", ";
                }
                str = str + strArr[i11];
            }
            log.fine("MqttAsyncClient", "unsubscribe", "107", new Object[]{str, obj, iMqttActionListener});
        }
        for (String validate : strArr) {
            MqttTopic.validate(validate, true);
        }
        for (String removeMessageListener : strArr) {
            this.comms.removeMessageListener(removeMessageListener);
        }
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        mqttToken.setUserContext(obj);
        mqttToken.internalTok.setTopics(strArr);
        this.comms.sendNoWait(new MqttUnsubscribe(strArr), mqttToken);
        log.fine("MqttAsyncClient", "unsubscribe", "110");
        return mqttToken;
    }

    public IMqttDeliveryToken publish(String str, byte[] bArr, int i11, boolean z11) throws MqttException, MqttPersistenceException {
        return publish(str, bArr, i11, z11, (Object) null, (IMqttActionListener) null);
    }

    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        return publish(str, mqttMessage, (Object) null, (IMqttActionListener) null);
    }

    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        Logger logger = log;
        logger.fine("MqttAsyncClient", "publish", "111", new Object[]{str, obj, iMqttActionListener});
        MqttTopic.validate(str, false);
        MqttDeliveryToken mqttDeliveryToken = new MqttDeliveryToken(getClientId());
        mqttDeliveryToken.setActionCallback(iMqttActionListener);
        mqttDeliveryToken.setUserContext(obj);
        mqttDeliveryToken.setMessage(mqttMessage);
        mqttDeliveryToken.internalTok.setTopics(new String[]{str});
        MqttPublish mqttPublish = new MqttPublish(str, mqttMessage);
        TBaseLogger.d("MqttAsyncClient", "action - publish, message is MqttPublish");
        this.comms.sendNoWait(mqttPublish, mqttDeliveryToken);
        logger.fine("MqttAsyncClient", "publish", "112");
        return mqttDeliveryToken;
    }

    public IMqttToken subscribe(String str, int i11, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i11}, obj, iMqttActionListener, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public IMqttToken subscribe(String str, int i11, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i11}, (Object) null, (IMqttActionListener) null, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null, iMqttMessageListenerArr);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        if (iMqttMessageListenerArr.length == iArr.length && iArr.length == strArr.length) {
            IMqttToken subscribe = subscribe(strArr, iArr, obj, iMqttActionListener);
            for (int i11 = 0; i11 < strArr.length; i11++) {
                this.comms.setMessageListener(strArr[i11], iMqttMessageListenerArr[i11]);
            }
            return subscribe;
        }
        throw new IllegalArgumentException();
    }
}
