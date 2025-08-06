package com.tencent.android.tpns.mqtt;

import com.google.android.gms.common.internal.ImagesContract;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.android.tpns.mqtt.util.Debug;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;

public class MqttConnectOptions {
    public static final boolean CLEAN_SESSION_DEFAULT = true;
    public static final int CONNECTION_TIMEOUT_DEFAULT = 30;
    public static final int KEEP_ALIVE_INTERVAL_DEFAULT = 60;
    public static final int MAX_INFLIGHT_DEFAULT = 10;
    public static final int MQTT_VERSION_3_1 = 3;
    public static final int MQTT_VERSION_3_1_1 = 4;
    public static final int MQTT_VERSION_DEFAULT = 0;
    public static final int URI_TYPE_LOCAL = 2;
    public static final int URI_TYPE_SSL = 1;
    public static final int URI_TYPE_TCP = 0;
    public static final int URI_TYPE_WS = 3;
    public static final int URI_TYPE_WSS = 4;
    private int MqttVersion = 0;
    private boolean automaticReconnect = false;
    private boolean cleanSession = true;
    private int connectionTimeout = 30;
    private int keepAliveInterval = 60;
    private int maxInflight = 10;
    private char[] password;
    private String[] serverURIs = null;
    private SocketFactory socketFactory;
    private Properties sslClientProps = null;
    private HostnameVerifier sslHostnameVerifier = null;
    private String userName;
    private String willDestination = null;
    private MqttMessage willMessage = null;

    public static int validateURI(String str) {
        try {
            URI uri = new URI(str);
            if ("ws".equals(uri.getScheme())) {
                return 3;
            }
            if ("wss".equals(uri.getScheme())) {
                return 4;
            }
            if (uri.getPath() != null) {
                if (!uri.getPath().isEmpty()) {
                    throw new IllegalArgumentException(str);
                }
            }
            if ("tcp".equals(uri.getScheme())) {
                return 0;
            }
            if ("ssl".equals(uri.getScheme())) {
                return 1;
            }
            if (ImagesContract.LOCAL.equals(uri.getScheme())) {
                return 2;
            }
            throw new IllegalArgumentException(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException(str);
        }
    }

    private void validateWill(String str, Object obj) {
        if (str == null || obj == null) {
            throw new IllegalArgumentException();
        }
        MqttTopic.validate(str, false);
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public Properties getDebug() {
        Properties properties = new Properties();
        properties.put("MqttVersion", new Integer(getMqttVersion()));
        properties.put("CleanSession", Boolean.valueOf(isCleanSession()));
        properties.put("ConTimeout", new Integer(getConnectionTimeout()));
        properties.put("KeepAliveInterval", new Integer(getKeepAliveInterval()));
        properties.put("UserName", getUserName() == null ? OptionsBridge.NULL_VALUE : getUserName());
        properties.put("WillDestination", getWillDestination() == null ? OptionsBridge.NULL_VALUE : getWillDestination());
        if (getSocketFactory() == null) {
            properties.put("SocketFactory", OptionsBridge.NULL_VALUE);
        } else {
            properties.put("SocketFactory", getSocketFactory());
        }
        if (getSSLProperties() == null) {
            properties.put("SSLProperties", OptionsBridge.NULL_VALUE);
        } else {
            properties.put("SSLProperties", getSSLProperties());
        }
        return properties;
    }

    public int getKeepAliveInterval() {
        return this.keepAliveInterval;
    }

    public int getMaxInflight() {
        return this.maxInflight;
    }

    public int getMqttVersion() {
        return this.MqttVersion;
    }

    public char[] getPassword() {
        return this.password;
    }

    public HostnameVerifier getSSLHostnameVerifier() {
        return this.sslHostnameVerifier;
    }

    public Properties getSSLProperties() {
        return this.sslClientProps;
    }

    public String[] getServerURIs() {
        return this.serverURIs;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWillDestination() {
        return this.willDestination;
    }

    public MqttMessage getWillMessage() {
        return this.willMessage;
    }

    public boolean isAutomaticReconnect() {
        return this.automaticReconnect;
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    public void setAutomaticReconnect(boolean z11) {
        this.automaticReconnect = z11;
    }

    public void setCleanSession(boolean z11) {
        this.cleanSession = z11;
    }

    public void setConnectionTimeout(int i11) {
        if (i11 >= 0) {
            this.connectionTimeout = i11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setKeepAliveInterval(int i11) throws IllegalArgumentException {
        if (i11 >= 0) {
            this.keepAliveInterval = i11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setMaxInflight(int i11) {
        if (i11 >= 0) {
            this.maxInflight = i11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setMqttVersion(int i11) throws IllegalArgumentException {
        if (i11 == 0 || i11 == 3 || i11 == 4) {
            this.MqttVersion = i11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }

    public void setSSLHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.sslHostnameVerifier = hostnameVerifier;
    }

    public void setSSLProperties(Properties properties) {
        this.sslClientProps = properties;
    }

    public void setServerURIs(String[] strArr) {
        for (String validateURI : strArr) {
            validateURI(validateURI);
        }
        this.serverURIs = strArr;
    }

    public void setSocketFactory(SocketFactory socketFactory2) {
        this.socketFactory = socketFactory2;
    }

    public void setUserName(String str) {
        if (str == null || !str.trim().equals("")) {
            this.userName = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setWill(MqttTopic mqttTopic, byte[] bArr, int i11, boolean z11) {
        String name = mqttTopic.getName();
        validateWill(name, bArr);
        setWill(name, new MqttMessage(bArr), i11, z11);
    }

    public String toString() {
        return Debug.dumpProperties(getDebug(), "Connection options");
    }

    public void setWill(String str, byte[] bArr, int i11, boolean z11) {
        validateWill(str, bArr);
        setWill(str, new MqttMessage(bArr), i11, z11);
    }

    public void setWill(String str, MqttMessage mqttMessage, int i11, boolean z11) {
        this.willDestination = str;
        this.willMessage = mqttMessage;
        mqttMessage.setQos(i11);
        this.willMessage.setRetained(z11);
        this.willMessage.setMutable(false);
    }
}
