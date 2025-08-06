package com.tencent.android.tpns.mqtt.internal.websocket;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.SSLNetworkModule;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLSocketFactory;

public class WebSocketSecureNetworkModule extends SSLNetworkModule {
    private static final String CLASS_NAME = "WebSocketSecureNetworkModule";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private String host;
    private ByteArrayOutputStream outputStream = new ExtendedByteArrayOutputStream(this);
    private PipedInputStream pipedInputStream;
    private int port;
    public ByteBuffer recievedPayload;
    private String uri;
    private WebSocketReceiver webSocketReceiver;

    public WebSocketSecureNetworkModule(SSLSocketFactory sSLSocketFactory, String str, String str2, int i11, String str3) {
        super(sSLSocketFactory, str2, i11, str3);
        this.uri = str;
        this.host = str2;
        this.port = i11;
        this.pipedInputStream = new PipedInputStream();
        log.setResourceName(str3);
    }

    public InputStream getInputStream() throws IOException {
        return this.pipedInputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.outputStream;
    }

    public String getServerURI() {
        return "wss://" + this.host + ":" + this.port;
    }

    public InputStream getSocketInputStream() throws IOException {
        return super.getInputStream();
    }

    public OutputStream getSocketOutputStream() throws IOException {
        return super.getOutputStream();
    }

    public void start() throws IOException, MqttException {
        super.start();
        new WebSocketHandshake(super.getInputStream(), super.getOutputStream(), this.uri, this.host, this.port).execute();
        WebSocketReceiver webSocketReceiver2 = new WebSocketReceiver(getSocketInputStream(), this.pipedInputStream);
        this.webSocketReceiver = webSocketReceiver2;
        webSocketReceiver2.start("WssSocketReceiver");
    }

    public void stop() throws IOException {
        getSocketOutputStream().write(new WebSocketFrame((byte) 8, true, "1000".getBytes()).encodeFrame());
        getSocketOutputStream().flush();
        WebSocketReceiver webSocketReceiver2 = this.webSocketReceiver;
        if (webSocketReceiver2 != null) {
            webSocketReceiver2.stop();
        }
        super.stop();
    }
}
