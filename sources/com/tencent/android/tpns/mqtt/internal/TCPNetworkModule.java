package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class TCPNetworkModule implements NetworkModule {
    private static final String CLASS_NAME = "TCPNetworkModule";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private int conTimeout;
    private SocketFactory factory;
    private String host;
    private int port;
    public Socket socket;
    public Socket tempsocket;

    public TCPNetworkModule(SocketFactory socketFactory, String str, int i11, String str2) {
        log.setResourceName(str2);
        this.factory = socketFactory;
        this.host = str;
        this.port = i11;
    }

    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    public String getServerURI() {
        return "tcp://" + this.host + ":" + this.port;
    }

    public void setConnectTimeout(int i11) {
        this.conTimeout = i11;
    }

    public void start() throws IOException, MqttException {
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.host, this.port);
            SocketFactory socketFactory = this.factory;
            if (socketFactory instanceof SSLSocketFactory) {
                Socket socket2 = new Socket();
                this.tempsocket = socket2;
                socket2.connect(inetSocketAddress, this.conTimeout * 1000);
                this.socket = ((SSLSocketFactory) this.factory).createSocket(this.tempsocket, this.host, this.port, true);
                return;
            }
            Socket createSocket = socketFactory.createSocket();
            this.socket = createSocket;
            createSocket.connect(inetSocketAddress, this.conTimeout * 1000);
        } catch (ConnectException e11) {
            log.fine(CLASS_NAME, "start", "250", (Object[]) null, e11);
            throw new MqttException(32103, e11);
        }
    }

    public void stop() throws IOException {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.shutdownInput();
            this.socket.close();
        }
        Socket socket3 = this.tempsocket;
        if (socket3 != null) {
            try {
                socket3.shutdownInput();
                this.tempsocket.close();
            } catch (Throwable unused) {
            }
        }
    }
}
