package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttPersistable;

public class MqttPersistentData implements MqttPersistable {
    private int hLength = 0;
    private int hOffset = 0;
    private byte[] header = null;
    private String key = null;
    private int pLength = 0;
    private int pOffset = 0;
    private byte[] payload = null;

    public MqttPersistentData(String str, byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14) {
        this.key = str;
        this.header = bArr;
        this.hOffset = i11;
        this.hLength = i12;
        this.payload = bArr2;
        this.pOffset = i13;
        this.pLength = i14;
    }

    public byte[] getHeaderBytes() {
        return this.header;
    }

    public int getHeaderLength() {
        return this.hLength;
    }

    public int getHeaderOffset() {
        return this.hOffset;
    }

    public String getKey() {
        return this.key;
    }

    public byte[] getPayloadBytes() {
        return this.payload;
    }

    public int getPayloadLength() {
        if (this.payload == null) {
            return 0;
        }
        return this.pLength;
    }

    public int getPayloadOffset() {
        return this.pOffset;
    }
}
