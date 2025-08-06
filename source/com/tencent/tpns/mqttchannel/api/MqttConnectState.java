package com.tencent.tpns.mqttchannel.api;

public enum MqttConnectState {
    DISCONNECTED(0),
    CONNECTED(1),
    CONNECTFAIL(2),
    CONNECTING(3),
    DISCONNECTING(4),
    SUBTOPICS(5),
    UNKOWN(10);
    

    /* renamed from: a  reason: collision with root package name */
    private int f49925a;

    private MqttConnectState(int i11) {
        this.f49925a = i11;
    }

    public static MqttConnectState from(int i11) {
        if (i11 == 0) {
            return DISCONNECTED;
        }
        if (i11 == 1) {
            return CONNECTED;
        }
        if (i11 == 2) {
            return CONNECTFAIL;
        }
        if (i11 == 3) {
            return CONNECTING;
        }
        if (i11 == 4) {
            return DISCONNECTING;
        }
        if (i11 != 5) {
            return UNKOWN;
        }
        return SUBTOPICS;
    }

    public int getType() {
        return this.f49925a;
    }
}
