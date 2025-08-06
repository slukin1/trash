package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MqttSubscribe extends MqttWireMessage {
    private int count;
    private String[] names;
    private int[] qos;

    public MqttSubscribe(byte b11, byte[] bArr) throws IOException {
        super((byte) 8);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        boolean z11 = false;
        this.count = 0;
        this.names = new String[10];
        this.qos = new int[10];
        while (!z11) {
            try {
                this.names[this.count] = decodeUTF8(dataInputStream);
                int[] iArr = this.qos;
                int i11 = this.count;
                this.count = i11 + 1;
                iArr[i11] = dataInputStream.readByte();
            } catch (Throwable unused) {
                z11 = true;
            }
        }
        dataInputStream.close();
    }

    public byte getMessageInfo() {
        return (byte) ((this.duplicate ? 8 : 0) | 2);
    }

    public byte[] getPayload() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i11 = 0;
            while (true) {
                String[] strArr = this.names;
                if (i11 < strArr.length) {
                    encodeUTF8(dataOutputStream, strArr[i11]);
                    dataOutputStream.writeByte(this.qos[i11]);
                    i11++;
                } else {
                    dataOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e11) {
            throw new MqttException((Throwable) e11);
        }
    }

    public byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.msgId);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            throw new MqttException((Throwable) e11);
        }
    }

    public boolean isRetryable() {
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" names:[");
        for (int i11 = 0; i11 < this.count; i11++) {
            if (i11 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("\"");
            stringBuffer.append(this.names[i11]);
            stringBuffer.append("\"");
        }
        stringBuffer.append("] qos:[");
        for (int i12 = 0; i12 < this.count; i12++) {
            if (i12 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.qos[i12]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public MqttSubscribe(String[] strArr, int[] iArr) {
        super((byte) 8);
        this.names = strArr;
        this.qos = iArr;
        if (strArr.length == iArr.length) {
            this.count = strArr.length;
            for (int validateQos : iArr) {
                MqttMessage.validateQos(validateQos);
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}
