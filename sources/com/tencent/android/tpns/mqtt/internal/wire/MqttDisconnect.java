package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;

public class MqttDisconnect extends MqttWireMessage {
    public static final String KEY = "Disc";

    public MqttDisconnect() {
        super((byte) 14);
    }

    public String getKey() {
        return KEY;
    }

    public byte getMessageInfo() {
        return 0;
    }

    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    public boolean isMessageIdRequired() {
        return false;
    }

    public MqttDisconnect(byte b11, byte[] bArr) throws IOException {
        super((byte) 14);
    }
}
