package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLNetworkModule extends TCPNetworkModule {
    private static final String CLASS_NAME = "SSLNetworkModule";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private String[] enabledCiphers;
    private int handshakeTimeoutSecs;
    private String host;
    private HostnameVerifier hostnameVerifier;
    private int port;

    public SSLNetworkModule(SSLSocketFactory sSLSocketFactory, String str, int i11, String str2) {
        super(sSLSocketFactory, str, i11, str2);
        this.host = str;
        this.port = i11;
        log.setResourceName(str2);
    }

    public String[] getEnabledCiphers() {
        return this.enabledCiphers;
    }

    public HostnameVerifier getSSLHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public String getServerURI() {
        return "ssl://" + this.host + ":" + this.port;
    }

    public void setEnabledCiphers(String[] strArr) {
        this.enabledCiphers = strArr;
        if (this.socket != null && strArr != null) {
            if (log.isLoggable(5)) {
                String str = "";
                for (int i11 = 0; i11 < strArr.length; i11++) {
                    if (i11 > 0) {
                        str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
                    }
                    str = str + strArr[i11];
                }
                log.fine(CLASS_NAME, "setEnabledCiphers", "260", new Object[]{str});
            }
            ((SSLSocket) this.socket).setEnabledCipherSuites(strArr);
        }
    }

    public void setSSLHostnameVerifier(HostnameVerifier hostnameVerifier2) {
        this.hostnameVerifier = hostnameVerifier2;
    }

    public void setSSLhandshakeTimeout(int i11) {
        super.setConnectTimeout(i11);
        this.handshakeTimeoutSecs = i11;
    }

    public void start() throws IOException, MqttException {
        super.start();
        setEnabledCiphers(this.enabledCiphers);
        int soTimeout = this.socket.getSoTimeout();
        this.socket.setSoTimeout(this.handshakeTimeoutSecs * 1000);
        ((SSLSocket) this.socket).startHandshake();
        if (this.hostnameVerifier != null) {
            this.hostnameVerifier.verify(this.host, ((SSLSocket) this.socket).getSession());
        }
        this.socket.setSoTimeout(soTimeout);
    }
}
