package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttPubRel extends MqttPersistableWireMessage {
    public MqttPubRel(MqttPubRec mqttPubRec) {
        super((byte) 6);
        setMessageId(mqttPubRec.getMessageId());
    }

    public byte getMessageInfo() {
        return (byte) ((this.duplicate ? 8 : 0) | 2);
    }

    public byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }

    public String toString() {
        return super.toString() + " msgId " + this.msgId;
    }

    public MqttPubRel(byte b11, byte[] bArr) throws IOException {
        super((byte) 6);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }
}
