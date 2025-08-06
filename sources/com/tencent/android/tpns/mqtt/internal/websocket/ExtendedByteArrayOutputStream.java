package com.tencent.android.tpns.mqtt.internal.websocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

class ExtendedByteArrayOutputStream extends ByteArrayOutputStream {
    public final WebSocketNetworkModule webSocketNetworkModule;
    public final WebSocketSecureNetworkModule webSocketSecureNetworkModule;

    public ExtendedByteArrayOutputStream(WebSocketNetworkModule webSocketNetworkModule2) {
        this.webSocketNetworkModule = webSocketNetworkModule2;
        this.webSocketSecureNetworkModule = null;
    }

    public void flush() throws IOException {
        ByteBuffer wrap;
        synchronized (this) {
            wrap = ByteBuffer.wrap(toByteArray());
            reset();
        }
        byte[] encodeFrame = new WebSocketFrame((byte) 2, true, wrap.array()).encodeFrame();
        OutputStream socketOutputStream = getSocketOutputStream();
        if (socketOutputStream != null) {
            socketOutputStream.write(encodeFrame);
            socketOutputStream.flush();
        }
    }

    public OutputStream getSocketOutputStream() throws IOException {
        WebSocketNetworkModule webSocketNetworkModule2 = this.webSocketNetworkModule;
        if (webSocketNetworkModule2 != null) {
            return webSocketNetworkModule2.getSocketOutputStream();
        }
        WebSocketSecureNetworkModule webSocketSecureNetworkModule2 = this.webSocketSecureNetworkModule;
        if (webSocketSecureNetworkModule2 != null) {
            return webSocketSecureNetworkModule2.getSocketOutputStream();
        }
        return null;
    }

    public ExtendedByteArrayOutputStream(WebSocketSecureNetworkModule webSocketSecureNetworkModule2) {
        this.webSocketNetworkModule = null;
        this.webSocketSecureNetworkModule = webSocketSecureNetworkModule2;
    }
}
