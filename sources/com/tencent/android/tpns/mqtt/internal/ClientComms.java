package com.tencent.android.tpns.mqtt.internal;

import com.jumio.sdk.reject.JumioRejectReason;
import com.tencent.android.tpns.mqtt.BufferedMessage;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.IMqttMessageListener;
import com.tencent.android.tpns.mqtt.MqttCallback;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttConnectOptions;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttPingSender;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ClientComms {
    public static String BUILD_LEVEL = "L${build.level}";
    private static final String CLASS_NAME = "ClientComms";
    private static final byte CLOSED = 4;
    private static final byte CONNECTED = 0;
    private static final byte CONNECTING = 1;
    private static final byte DISCONNECTED = 3;
    private static final byte DISCONNECTING = 2;
    private static final String TAG = "ClientComms";
    public static String VERSION = "${project.version}";
    /* access modifiers changed from: private */
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, "ClientComms");
    /* access modifiers changed from: private */
    public CommsCallback callback;
    private IMqttAsyncClient client;
    /* access modifiers changed from: private */
    public ClientState clientState;
    private boolean closePending = false;
    private Object conLock = new Object();
    private MqttConnectOptions conOptions;
    private byte conState = 3;
    private DisconnectBG discbg;
    private DisconnectedMessageBuffer disconnectedMessageBuffer;
    /* access modifiers changed from: private */
    public ExecutorService executorService;
    /* access modifiers changed from: private */
    public int networkModuleIndex;
    /* access modifiers changed from: private */
    public NetworkModule[] networkModules;
    private MqttClientPersistence persistence;
    private MqttPingSender pingSender;
    /* access modifiers changed from: private */
    public CommsReceiver receiver;
    private boolean resting = false;
    /* access modifiers changed from: private */
    public CommsSender sender;
    private boolean stoppingComms = false;
    /* access modifiers changed from: private */
    public CommsTokenStore tokenStore;

    public class ConnectBG extends TTask {
        public ClientComms clientComms = null;
        public MqttConnect conPacket;
        public MqttToken conToken;
        private String threadName;

        public ConnectBG(ClientComms clientComms2, MqttToken mqttToken, MqttConnect mqttConnect, ExecutorService executorService) {
            this.clientComms = clientComms2;
            this.conToken = mqttToken;
            this.conPacket = mqttConnect;
            this.threadName = "MQTT Con: " + ClientComms.this.getClient().getClientId();
        }

        public void TRun() {
            TBaseLogger.dd("ClientComms", "ConnectBG mqtt thread");
            Thread.currentThread().setName(this.threadName);
            ClientComms.log.fine("ClientComms", "connectBG:run", "220");
            MqttException e11 = null;
            try {
                MqttDeliveryToken[] outstandingDelTokens = ClientComms.this.tokenStore.getOutstandingDelTokens();
                for (MqttDeliveryToken mqttDeliveryToken : outstandingDelTokens) {
                    mqttDeliveryToken.internalTok.setException((MqttException) null);
                }
                ClientComms.this.tokenStore.saveToken(this.conToken, (MqttWireMessage) this.conPacket);
                NetworkModule networkModule = ClientComms.this.networkModules[ClientComms.this.networkModuleIndex];
                networkModule.start();
                CommsReceiver unused = ClientComms.this.receiver = new CommsReceiver(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getInputStream());
                ClientComms.this.receiver.start("MQTT Rec: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                CommsSender unused2 = ClientComms.this.sender = new CommsSender(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getOutputStream());
                ClientComms.this.sender.start("MQTT Snd: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.callback.start("MQTT Call: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.internalSend(this.conPacket, this.conToken);
            } catch (MqttException e12) {
                e11 = e12;
                ClientComms.log.fine("ClientComms", "connectBG:run", "212", (Object[]) null, e11);
            } catch (Throwable th2) {
                ClientComms.log.fine("ClientComms", "connectBG:run", "209", (Object[]) null, th2);
                e11 = ExceptionHelper.createMqttException(th2);
            }
            if (e11 != null) {
                ClientComms.this.shutdownConnection(this.conToken, e11);
            }
        }

        public void start() {
            ClientComms.this.executorService.execute(this);
        }
    }

    public class DisconnectBG extends TTask {
        public MqttDisconnect disconnect;
        public long quiesceTimeout;
        private String threadName;
        public MqttToken token;

        public DisconnectBG(MqttDisconnect mqttDisconnect, long j11, MqttToken mqttToken, ExecutorService executorService) {
            this.disconnect = mqttDisconnect;
            this.quiesceTimeout = j11;
            this.token = mqttToken;
        }

        public void TRun() {
            Thread.currentThread().setName(this.threadName);
            ClientComms.log.fine("ClientComms", "disconnectBG:run", "221");
            TBaseLogger.i("disconnectBG:run", "disconnectBG:run");
            ClientComms.this.clientState.quiesce(this.quiesceTimeout);
            try {
                ClientComms.this.internalSend(this.disconnect, this.token);
                this.token.internalTok.waitUntilSent();
            } catch (Throwable th2) {
                this.token.internalTok.markComplete((MqttWireMessage) null, (MqttException) null);
                ClientComms.this.shutdownConnection(this.token, (MqttException) null);
                throw th2;
            }
            this.token.internalTok.markComplete((MqttWireMessage) null, (MqttException) null);
            ClientComms.this.shutdownConnection(this.token, (MqttException) null);
        }

        public void start() {
            this.threadName = "MQTT Disc: " + ClientComms.this.getClient().getClientId();
            ClientComms.this.executorService.execute(this);
        }
    }

    public class ReconnectDisconnectedBufferCallback implements IDisconnectedBufferCallback {
        public final String methodName;

        public ReconnectDisconnectedBufferCallback(String str) {
            this.methodName = str;
        }

        public void publishBufferedMessage(BufferedMessage bufferedMessage) throws MqttException {
            if (ClientComms.this.isConnected()) {
                while (ClientComms.this.clientState.getActualInFlight() >= ClientComms.this.clientState.getMaxInFlight() - 1) {
                    Thread.yield();
                }
                ClientComms.log.fine("ClientComms", this.methodName, "510", new Object[]{bufferedMessage.getMessage().getKey()});
                ClientComms.this.internalSend(bufferedMessage.getMessage(), bufferedMessage.getToken());
                ClientComms.this.clientState.unPersistBufferedMessage(bufferedMessage.getMessage());
                return;
            }
            ClientComms.log.fine("ClientComms", this.methodName, "208");
            throw ExceptionHelper.createMqttException(32104);
        }
    }

    public ClientComms(IMqttAsyncClient iMqttAsyncClient, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender, ExecutorService executorService2) throws MqttException {
        TBaseLogger.d("ClientComms", "init ClientComms");
        this.conState = 3;
        this.client = iMqttAsyncClient;
        this.persistence = mqttClientPersistence;
        this.pingSender = mqttPingSender;
        if (mqttPingSender != null) {
            mqttPingSender.init(this);
        }
        this.executorService = executorService2;
        this.tokenStore = new CommsTokenStore(getClient().getClientId());
        this.callback = new CommsCallback(this);
        ClientState clientState2 = new ClientState(mqttClientPersistence, this.tokenStore, this.callback, this, mqttPingSender);
        this.clientState = clientState2;
        this.callback.setClientState(clientState2);
        log.setResourceName(getClient().getClientId());
    }

    private MqttToken handleOldTokens(MqttToken mqttToken, MqttException mqttException) {
        log.fine("ClientComms", "handleOldTokens", "222");
        MqttToken mqttToken2 = null;
        if (mqttToken != null) {
            try {
                if (this.tokenStore.getToken(mqttToken.internalTok.getKey()) == null) {
                    this.tokenStore.saveToken(mqttToken, mqttToken.internalTok.getKey());
                }
            } catch (Exception unused) {
            }
        }
        Enumeration elements = this.clientState.resolveOldTokens(mqttException).elements();
        while (elements.hasMoreElements()) {
            MqttToken mqttToken3 = (MqttToken) elements.nextElement();
            if (!mqttToken3.internalTok.getKey().equals(MqttDisconnect.KEY)) {
                if (!mqttToken3.internalTok.getKey().equals("Con")) {
                    CommsCallback commsCallback = this.callback;
                    if (commsCallback != null) {
                        commsCallback.asyncOperationComplete(mqttToken3);
                    }
                }
            }
            mqttToken2 = mqttToken3;
        }
        return mqttToken2;
    }

    private void handleRunException(Exception exc) {
        MqttException mqttException;
        log.fine("ClientComms", "handleRunException", "804", (Object[]) null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        shutdownConnection((MqttToken) null, mqttException);
    }

    private void shutdownExecutorService() {
        this.executorService.shutdown();
        try {
            ExecutorService executorService2 = this.executorService;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService2.awaitTermination(1, timeUnit)) {
                this.executorService.shutdownNow();
                if (!this.executorService.awaitTermination(1, timeUnit)) {
                    log.fine("ClientComms", "shutdownExecutorService", "executorService did not terminate");
                }
            }
        } catch (InterruptedException unused) {
            this.executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public MqttToken checkForActivity() {
        return checkForActivity((IMqttActionListener) null);
    }

    public void close(boolean z11) throws MqttException {
        synchronized (this.conLock) {
            if (!isClosed()) {
                if (!isDisconnected() || z11) {
                    log.fine("ClientComms", "close", "224");
                    if (isConnecting()) {
                        TBaseLogger.e("ClientComms", "close when is isConnecting");
                    } else if (isConnected()) {
                        TBaseLogger.e("ClientComms", "close when is isConnected");
                    } else if (isDisconnecting()) {
                        this.closePending = true;
                    }
                }
                this.conState = 4;
                shutdownExecutorService();
                this.clientState.close();
                this.clientState = null;
                this.callback = null;
                this.persistence = null;
                this.sender = null;
                this.pingSender = null;
                this.receiver = null;
                this.networkModules = null;
                this.conOptions = null;
                this.tokenStore = null;
            }
        }
    }

    public void connect(MqttConnectOptions mqttConnectOptions, MqttToken mqttToken) throws MqttException {
        synchronized (this.conLock) {
            if (!isDisconnected() || this.closePending) {
                log.fine("ClientComms", "connect", "207", new Object[]{new Byte(this.conState)});
                if (isClosed() || this.closePending) {
                    throw new MqttException(32111);
                } else if (isConnecting()) {
                    throw new MqttException(32110);
                } else if (isDisconnecting()) {
                    throw new MqttException(32102);
                } else {
                    throw ExceptionHelper.createMqttException(32100);
                }
            } else {
                log.fine("ClientComms", "connect", JumioRejectReason.MISSING_FRONT);
                this.conState = 1;
                this.conOptions = mqttConnectOptions;
                MqttConnect mqttConnect = new MqttConnect(this.client.getClientId(), this.conOptions.getMqttVersion(), this.conOptions.isCleanSession(), this.conOptions.getKeepAliveInterval(), this.conOptions.getUserName(), this.conOptions.getPassword(), this.conOptions.getWillMessage(), this.conOptions.getWillDestination());
                this.clientState.setKeepAliveSecs((long) this.conOptions.getKeepAliveInterval());
                this.clientState.setCleanSession(this.conOptions.isCleanSession());
                this.clientState.setMaxInflight(this.conOptions.getMaxInflight());
                this.tokenStore.open();
                new ConnectBG(this, mqttToken, mqttConnect, this.executorService).start();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r9 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        log.fine("ClientComms", "connectComplete", "204", new java.lang.Object[]{new java.lang.Integer(r8)});
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connectComplete(com.tencent.android.tpns.mqtt.internal.wire.MqttConnack r8, com.tencent.android.tpns.mqtt.MqttException r9) throws com.tencent.android.tpns.mqtt.MqttException {
        /*
            r7 = this;
            int r8 = r8.getReturnCode()
            java.lang.Object r0 = r7.conLock
            monitor-enter(r0)
            r1 = 0
            if (r8 != 0) goto L_0x0019
            com.tencent.android.tpns.mqtt.logging.Logger r8 = log     // Catch:{ all -> 0x0033 }
            java.lang.String r9 = "ClientComms"
            java.lang.String r2 = "connectComplete"
            java.lang.String r3 = "215"
            r8.fine(r9, r2, r3)     // Catch:{ all -> 0x0033 }
            r7.conState = r1     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            com.tencent.android.tpns.mqtt.logging.Logger r0 = log
            java.lang.String r2 = "ClientComms"
            java.lang.String r3 = "connectComplete"
            java.lang.String r4 = "204"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r8)
            r5[r1] = r6
            r0.fine(r2, r3, r4, r5)
            if (r9 != 0) goto L_0x0032
            return
        L_0x0032:
            throw r9
        L_0x0033:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.ClientComms.connectComplete(com.tencent.android.tpns.mqtt.internal.wire.MqttConnack, com.tencent.android.tpns.mqtt.MqttException):void");
    }

    public void deleteBufferedMessage(int i11) {
        this.disconnectedMessageBuffer.deleteMessage(i11);
    }

    public void deliveryComplete(MqttPublish mqttPublish) throws MqttPersistenceException {
        this.clientState.deliveryComplete(mqttPublish);
    }

    public void disconnect(MqttDisconnect mqttDisconnect, long j11, MqttToken mqttToken) throws MqttException {
        synchronized (this.conLock) {
            if (isClosed()) {
                log.fine("ClientComms", "disconnect", "223");
                throw ExceptionHelper.createMqttException(32111);
            } else if (isDisconnected()) {
                log.fine("ClientComms", "disconnect", "211");
                throw ExceptionHelper.createMqttException(32101);
            } else if (!isDisconnecting()) {
                if (Thread.currentThread() == this.callback.getThread()) {
                    log.fine("ClientComms", "disconnect", "210");
                }
                log.fine("ClientComms", "disconnect", "218");
                this.conState = 2;
                new DisconnectBG(mqttDisconnect, j11, mqttToken, this.executorService).start();
            } else {
                log.fine("ClientComms", "disconnect", "219");
                throw ExceptionHelper.createMqttException(32102);
            }
        }
    }

    public void disconnectForcibly(long j11, long j12) throws MqttException {
        disconnectForcibly(j11, j12, true);
    }

    public int getActualInFlight() {
        return this.clientState.getActualInFlight();
    }

    public MqttMessage getBufferedMessage(int i11) {
        return ((MqttPublish) this.disconnectedMessageBuffer.getMessage(i11).getMessage()).getMessage();
    }

    public int getBufferedMessageCount() {
        return this.disconnectedMessageBuffer.getMessageCount();
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public ClientState getClientState() {
        return this.clientState;
    }

    public MqttConnectOptions getConOptions() {
        return this.conOptions;
    }

    public Properties getDebug() {
        Properties properties = new Properties();
        properties.put("conState", new Integer(this.conState));
        properties.put("serverURI", getClient().getServerURI());
        properties.put(TUIConstants.TUIChat.CALL_BACK, this.callback);
        properties.put("stoppingComms", new Boolean(this.stoppingComms));
        return properties;
    }

    public long getKeepAlive() {
        return this.clientState.getKeepAlive();
    }

    public int getNetworkModuleIndex() {
        return this.networkModuleIndex;
    }

    public NetworkModule[] getNetworkModules() {
        return this.networkModules;
    }

    public MqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.tokenStore.getOutstandingDelTokens();
    }

    public CommsReceiver getReceiver() {
        return this.receiver;
    }

    public MqttTopic getTopic(String str) {
        return new MqttTopic(str, this);
    }

    public void internalSend(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        TBaseLogger.d("ClientComms", "action - internalSend");
        Logger logger = log;
        logger.fine("ClientComms", "internalSend", JumioRejectReason.NOT_READABLE, new Object[]{mqttWireMessage.getKey(), mqttWireMessage, mqttToken});
        if (mqttToken.getClient() == null) {
            mqttToken.internalTok.setClient(getClient());
            ClientState clientState2 = this.clientState;
            if (clientState2 != null) {
                try {
                    clientState2.send(mqttWireMessage, mqttToken);
                } catch (MqttException e11) {
                    if (mqttWireMessage instanceof MqttPublish) {
                        this.clientState.undo((MqttPublish) mqttWireMessage);
                    }
                    throw e11;
                }
            }
        } else {
            logger.fine("ClientComms", "internalSend", "213", new Object[]{mqttWireMessage.getKey(), mqttWireMessage, mqttToken});
            throw new MqttException(32201);
        }
    }

    public boolean isClosed() {
        boolean z11;
        synchronized (this.conLock) {
            z11 = this.conState == 4;
        }
        return z11;
    }

    public boolean isConnected() {
        boolean z11;
        synchronized (this.conLock) {
            z11 = this.conState == 0;
        }
        return z11;
    }

    public boolean isConnecting() {
        boolean z11;
        synchronized (this.conLock) {
            z11 = true;
            if (this.conState != 1) {
                z11 = false;
            }
        }
        return z11;
    }

    public boolean isDisconnected() {
        boolean z11;
        synchronized (this.conLock) {
            z11 = this.conState == 3;
        }
        return z11;
    }

    public boolean isDisconnecting() {
        boolean z11;
        synchronized (this.conLock) {
            z11 = this.conState == 2;
        }
        return z11;
    }

    public boolean isResting() {
        boolean z11;
        synchronized (this.conLock) {
            z11 = this.resting;
        }
        return z11;
    }

    public void messageArrivedComplete(int i11, int i12) throws MqttException {
        this.callback.messageArrivedComplete(i11, i12);
    }

    public void notifyConnect() {
        if (this.disconnectedMessageBuffer != null) {
            log.fine("ClientComms", "notifyConnect", "509");
            this.disconnectedMessageBuffer.setPublishCallback(new ReconnectDisconnectedBufferCallback("notifyConnect"));
            this.executorService.execute(this.disconnectedMessageBuffer);
        }
    }

    public void removeMessageListener(String str) {
        this.callback.removeMessageListener(str);
    }

    public void sendNoWait(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        if (isConnected() || ((!isConnected() && (mqttWireMessage instanceof MqttConnect)) || (isDisconnecting() && (mqttWireMessage instanceof MqttDisconnect)))) {
            DisconnectedMessageBuffer disconnectedMessageBuffer2 = this.disconnectedMessageBuffer;
            if (disconnectedMessageBuffer2 == null || disconnectedMessageBuffer2.getMessageCount() == 0) {
                internalSend(mqttWireMessage, mqttToken);
                return;
            }
            log.fine("ClientComms", "sendNoWait", "507", new Object[]{mqttWireMessage.getKey()});
            if (this.disconnectedMessageBuffer.isPersistBuffer()) {
                this.clientState.persistBufferedMessage(mqttWireMessage);
            }
            this.disconnectedMessageBuffer.putMessage(mqttWireMessage, mqttToken);
        } else if (this.disconnectedMessageBuffer != null) {
            log.fine("ClientComms", "sendNoWait", "508", new Object[]{mqttWireMessage.getKey()});
            if (this.disconnectedMessageBuffer.isPersistBuffer()) {
                this.clientState.persistBufferedMessage(mqttWireMessage);
            }
            this.disconnectedMessageBuffer.putMessage(mqttWireMessage, mqttToken);
        } else {
            log.fine("ClientComms", "sendNoWait", "208");
            throw ExceptionHelper.createMqttException(32104);
        }
    }

    public void setCallback(MqttCallback mqttCallback) {
        CommsCallback commsCallback = this.callback;
        if (commsCallback != null) {
            commsCallback.setCallback(mqttCallback);
        }
    }

    public void setDisconnectedMessageBuffer(DisconnectedMessageBuffer disconnectedMessageBuffer2) {
        this.disconnectedMessageBuffer = disconnectedMessageBuffer2;
    }

    public void setManualAcks(boolean z11) {
        this.callback.setManualAcks(z11);
    }

    public void setMessageListener(String str, IMqttMessageListener iMqttMessageListener) {
        this.callback.setMessageListener(str, iMqttMessageListener);
    }

    public void setNetworkModuleIndex(int i11) {
        this.networkModuleIndex = i11;
    }

    public void setNetworkModules(NetworkModule[] networkModuleArr) {
        this.networkModules = networkModuleArr;
    }

    public void setReconnectCallback(MqttCallbackExtended mqttCallbackExtended) {
        this.callback.setReconnectCallback(mqttCallbackExtended);
    }

    public void setRestingState(boolean z11) {
        this.resting = z11;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x00d4 */
    public void shutdownConnection(com.tencent.android.tpns.mqtt.MqttToken r9, com.tencent.android.tpns.mqtt.MqttException r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.conLock
            monitor-enter(r0)
            boolean r1 = r8.stoppingComms     // Catch:{ all -> 0x00de }
            if (r1 != 0) goto L_0x00dc
            boolean r1 = r8.closePending     // Catch:{ all -> 0x00de }
            if (r1 != 0) goto L_0x00dc
            boolean r1 = r8.isClosed()     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x0013
            goto L_0x00dc
        L_0x0013:
            r1 = 1
            r8.stoppingComms = r1     // Catch:{ all -> 0x00de }
            com.tencent.android.tpns.mqtt.logging.Logger r2 = log     // Catch:{ all -> 0x00de }
            java.lang.String r3 = "ClientComms"
            java.lang.String r4 = "shutdownConnection"
            java.lang.String r5 = "216"
            r2.fine(r3, r4, r5)     // Catch:{ all -> 0x00de }
            boolean r2 = r8.isConnected()     // Catch:{ all -> 0x00de }
            r3 = 0
            if (r2 != 0) goto L_0x0031
            boolean r2 = r8.isDisconnecting()     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r2 = r3
            goto L_0x0032
        L_0x0031:
            r2 = r1
        L_0x0032:
            r4 = 2
            r8.conState = r4     // Catch:{ all -> 0x00de }
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            if (r9 == 0) goto L_0x0043
            boolean r0 = r9.isComplete()
            if (r0 != 0) goto L_0x0043
            com.tencent.android.tpns.mqtt.internal.Token r0 = r9.internalTok
            r0.setException(r10)
        L_0x0043:
            com.tencent.android.tpns.mqtt.internal.CommsCallback r0 = r8.callback
            if (r0 == 0) goto L_0x004a
            r0.stop()
        L_0x004a:
            com.tencent.android.tpns.mqtt.internal.CommsReceiver r0 = r8.receiver
            if (r0 == 0) goto L_0x0051
            r0.stop()
        L_0x0051:
            com.tencent.android.tpns.mqtt.internal.NetworkModule[] r0 = r8.networkModules     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x005e
            int r4 = r8.networkModuleIndex     // Catch:{ all -> 0x005e }
            r0 = r0[r4]     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x005e
            r0.stop()     // Catch:{ all -> 0x005e }
        L_0x005e:
            com.tencent.android.tpns.mqtt.internal.CommsTokenStore r0 = r8.tokenStore
            com.tencent.android.tpns.mqtt.MqttException r4 = new com.tencent.android.tpns.mqtt.MqttException
            r5 = 32102(0x7d66, float:4.4984E-41)
            r4.<init>((int) r5)
            r0.quiesce(r4)
            com.tencent.android.tpns.mqtt.MqttToken r9 = r8.handleOldTokens(r9, r10)
            com.tencent.android.tpns.mqtt.internal.ClientState r0 = r8.clientState     // Catch:{ Exception -> 0x0084 }
            r0.disconnected(r10)     // Catch:{ Exception -> 0x0084 }
            com.tencent.android.tpns.mqtt.internal.CommsCallback r0 = r8.callback     // Catch:{ Exception -> 0x0084 }
            if (r0 == 0) goto L_0x0084
            com.tencent.android.tpns.mqtt.internal.ClientState r0 = r8.clientState     // Catch:{ Exception -> 0x0084 }
            boolean r0 = r0.getCleanSession()     // Catch:{ Exception -> 0x0084 }
            if (r0 == 0) goto L_0x0084
            com.tencent.android.tpns.mqtt.internal.CommsCallback r0 = r8.callback     // Catch:{ Exception -> 0x0084 }
            r0.removeMessageListeners()     // Catch:{ Exception -> 0x0084 }
        L_0x0084:
            com.tencent.android.tpns.mqtt.internal.CommsSender r0 = r8.sender
            if (r0 == 0) goto L_0x008b
            r0.stop()
        L_0x008b:
            com.tencent.android.tpns.mqtt.MqttPingSender r0 = r8.pingSender
            if (r0 == 0) goto L_0x0092
            r0.stop()
        L_0x0092:
            com.tencent.android.tpns.mqtt.internal.DisconnectedMessageBuffer r0 = r8.disconnectedMessageBuffer     // Catch:{ Exception -> 0x009d }
            if (r0 != 0) goto L_0x009d
            com.tencent.android.tpns.mqtt.MqttClientPersistence r0 = r8.persistence     // Catch:{ Exception -> 0x009d }
            if (r0 == 0) goto L_0x009d
            r0.close()     // Catch:{ Exception -> 0x009d }
        L_0x009d:
            java.lang.Object r4 = r8.conLock
            monitor-enter(r4)
            com.tencent.android.tpns.mqtt.logging.Logger r0 = log     // Catch:{ all -> 0x00d9 }
            java.lang.String r5 = "ClientComms"
            java.lang.String r6 = "shutdownConnection"
            java.lang.String r7 = "217"
            r0.fine(r5, r6, r7)     // Catch:{ all -> 0x00d9 }
            r0 = 3
            r8.conState = r0     // Catch:{ all -> 0x00d9 }
            r8.stoppingComms = r3     // Catch:{ all -> 0x00d9 }
            monitor-exit(r4)     // Catch:{ all -> 0x00d9 }
            if (r9 == 0) goto L_0x00b5
            r0 = r1
            goto L_0x00b6
        L_0x00b5:
            r0 = r3
        L_0x00b6:
            com.tencent.android.tpns.mqtt.internal.CommsCallback r4 = r8.callback
            if (r4 == 0) goto L_0x00bb
            r3 = r1
        L_0x00bb:
            r0 = r0 & r3
            if (r0 == 0) goto L_0x00c1
            r4.asyncOperationComplete(r9)
        L_0x00c1:
            if (r2 == 0) goto L_0x00ca
            com.tencent.android.tpns.mqtt.internal.CommsCallback r9 = r8.callback
            if (r9 == 0) goto L_0x00ca
            r9.connectionLost(r10)
        L_0x00ca:
            java.lang.Object r9 = r8.conLock
            monitor-enter(r9)
            boolean r10 = r8.closePending     // Catch:{ all -> 0x00d6 }
            if (r10 == 0) goto L_0x00d4
            r8.close(r1)     // Catch:{ all -> 0x00d4 }
        L_0x00d4:
            monitor-exit(r9)     // Catch:{ all -> 0x00d6 }
            return
        L_0x00d6:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00d6 }
            throw r10
        L_0x00d9:
            r9 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00d9 }
            throw r9
        L_0x00dc:
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            return
        L_0x00de:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.ClientComms.shutdownConnection(com.tencent.android.tpns.mqtt.MqttToken, com.tencent.android.tpns.mqtt.MqttException):void");
    }

    public MqttToken checkForActivity(IMqttActionListener iMqttActionListener) {
        try {
            return this.clientState.checkForActivity(iMqttActionListener);
        } catch (MqttException e11) {
            handleRunException(e11);
            return null;
        } catch (Exception e12) {
            handleRunException(e12);
            return null;
        }
    }

    public void deliveryComplete(int i11) throws MqttPersistenceException {
        this.clientState.deliveryComplete(i11);
    }

    public void disconnectForcibly(long j11, long j12, boolean z11) throws MqttException {
        ClientState clientState2 = this.clientState;
        if (clientState2 != null) {
            clientState2.quiesce(j11);
        }
        MqttToken mqttToken = new MqttToken(this.client.getClientId());
        if (z11) {
            try {
                internalSend(new MqttDisconnect(), mqttToken);
                mqttToken.waitForCompletion(j12);
            } catch (Throwable unused) {
            }
        }
        mqttToken.internalTok.markComplete((MqttWireMessage) null, (MqttException) null);
        shutdownConnection(mqttToken, (MqttException) null);
    }
}
