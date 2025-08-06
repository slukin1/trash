package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;

public class MqttPingReq extends MqttWireMessage {
    public static final String KEY = "Ping";

    public MqttPingReq() {
        super((byte) 12);
    }

    public String getKey() {
        return "Ping";
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

    public MqttPingReq(byte b11, byte[] bArr) throws IOException {
        super((byte) 12);
    }
}
