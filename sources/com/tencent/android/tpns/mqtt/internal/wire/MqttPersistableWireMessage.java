package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;

public abstract class MqttPersistableWireMessage extends MqttWireMessage implements MqttPersistable {
    public MqttPersistableWireMessage(byte b11) {
        super(b11);
    }

    public byte[] getHeaderBytes() throws MqttPersistenceException {
        try {
            return getHeader();
        } catch (Throwable th2) {
            throw new MqttPersistenceException(th2.getCause());
        }
    }

    public int getHeaderLength() throws MqttPersistenceException {
        return getHeaderBytes().length;
    }

    public int getHeaderOffset() throws MqttPersistenceException {
        return 0;
    }

    public byte[] getPayloadBytes() throws MqttPersistenceException {
        try {
            return getPayload();
        } catch (Throwable th2) {
            throw new MqttPersistenceException(th2.getCause());
        }
    }

    public int getPayloadLength() throws MqttPersistenceException {
        return 0;
    }

    public int getPayloadOffset() throws MqttPersistenceException {
        return 0;
    }
}
