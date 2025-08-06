package com.tencent.android.tpns.mqtt.internal.wire;

public abstract class MqttAck extends MqttWireMessage {
    public MqttAck(byte b11) {
        super(b11);
    }

    public byte getMessageInfo() {
        return 0;
    }

    public String toString() {
        return super.toString() + " msgId " + this.msgId;
    }
}
