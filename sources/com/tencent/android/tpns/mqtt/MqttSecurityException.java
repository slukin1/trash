package com.tencent.android.tpns.mqtt;

public class MqttSecurityException extends MqttException {
    private static final long serialVersionUID = 300;

    public MqttSecurityException(int i11) {
        super(i11);
    }

    public MqttSecurityException(Throwable th2) {
        super(th2);
    }

    public MqttSecurityException(int i11, Throwable th2) {
        super(i11, th2);
    }
}
