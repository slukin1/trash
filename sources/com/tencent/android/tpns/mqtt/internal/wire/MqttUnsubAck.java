package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttUnsubAck extends MqttAck {
    public MqttUnsubAck(byte b11, byte[] bArr) throws IOException {
        super((byte) 11);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }
}
