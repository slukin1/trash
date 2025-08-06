package com.tencent.android.tpns.mqtt;

import java.util.Objects;

public class MqttMessage {
    private boolean dup = false;
    private int messageId;
    private boolean mutable = true;
    private byte[] payload;
    private int qos = 1;
    private boolean retained = false;

    public MqttMessage() {
        setPayload(new byte[0]);
    }

    public static void validateQos(int i11) {
        if (i11 < 0 || i11 > 2) {
            throw new IllegalArgumentException();
        }
    }

    public void checkMutable() throws IllegalStateException {
        if (!this.mutable) {
            throw new IllegalStateException();
        }
    }

    public void clearPayload() {
        checkMutable();
        this.payload = new byte[0];
    }

    public int getId() {
        return this.messageId;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public int getQos() {
        return this.qos;
    }

    public boolean isDuplicate() {
        return this.dup;
    }

    public boolean isRetained() {
        return this.retained;
    }

    public void setDuplicate(boolean z11) {
        this.dup = z11;
    }

    public void setId(int i11) {
        this.messageId = i11;
    }

    public void setMutable(boolean z11) {
        this.mutable = z11;
    }

    public void setPayload(byte[] bArr) {
        checkMutable();
        Objects.requireNonNull(bArr);
        this.payload = bArr;
    }

    public void setQos(int i11) {
        checkMutable();
        validateQos(i11);
        this.qos = i11;
    }

    public void setRetained(boolean z11) {
        checkMutable();
        this.retained = z11;
    }

    public String toString() {
        return new String(this.payload);
    }

    public MqttMessage(byte[] bArr) {
        setPayload(bArr);
    }
}
