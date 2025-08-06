package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.ClientState;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MqttOutputStream extends OutputStream {
    private static final String CLASS_NAME = "MqttOutputStream";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientState clientState = null;
    private BufferedOutputStream out;

    public MqttOutputStream(ClientState clientState2, OutputStream outputStream) {
        this.clientState = clientState2;
        this.out = new BufferedOutputStream(outputStream);
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        this.clientState.notifySentBytes(bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.out.write(bArr, i11, i12);
        this.clientState.notifySentBytes(i12);
    }

    public void write(int i11) throws IOException {
        this.out.write(i11);
    }

    public void write(MqttWireMessage mqttWireMessage) throws IOException, MqttException {
        byte[] header = mqttWireMessage.getHeader();
        byte[] payload = mqttWireMessage.getPayload();
        this.out.write(header, 0, header.length);
        this.clientState.notifySentBytes(header.length);
        int i11 = 0;
        while (i11 < payload.length) {
            int min = Math.min(1024, payload.length - i11);
            this.out.write(payload, i11, min);
            i11 += 1024;
            this.clientState.notifySentBytes(min);
        }
        log.fine(CLASS_NAME, "write", "529", new Object[]{mqttWireMessage});
    }
}
