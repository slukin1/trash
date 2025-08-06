package com.tencent.android.tpns.mqtt;

public class MqttPersistenceException extends MqttException {
    public static final short REASON_CODE_PERSISTENCE_IN_USE = 32200;
    private static final long serialVersionUID = 300;

    public MqttPersistenceException() {
        super(0);
    }

    public MqttPersistenceException(int i11) {
        super(i11);
    }

    public MqttPersistenceException(Throwable th2) {
        super(th2);
    }

    public MqttPersistenceException(int i11, Throwable th2) {
        super(i11, th2);
    }
}
