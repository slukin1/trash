package com.tencent.android.tpns.mqtt.internal.wire;

import com.google.common.primitives.SignedBytes;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MqttConnect extends MqttWireMessage {
    public static final String KEY = "Con";
    private int MqttVersion;
    private boolean cleanSession;
    private String clientId;
    private int keepAliveInterval;
    private char[] password;
    private String userName;
    private String willDestination;
    private MqttMessage willMessage;

    public MqttConnect(byte b11, byte[] bArr) throws IOException, MqttException {
        super((byte) 1);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        decodeUTF8(dataInputStream);
        dataInputStream.readByte();
        dataInputStream.readByte();
        this.keepAliveInterval = dataInputStream.readUnsignedShort();
        this.clientId = decodeUTF8(dataInputStream);
        dataInputStream.close();
    }

    public String getKey() {
        return "Con";
    }

    public byte getMessageInfo() {
        return 0;
    }

    public byte[] getPayload() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            encodeUTF8(dataOutputStream, this.clientId);
            if (this.willMessage != null) {
                encodeUTF8(dataOutputStream, this.willDestination);
                dataOutputStream.writeShort(this.willMessage.getPayload().length);
                dataOutputStream.write(this.willMessage.getPayload());
            }
            String str = this.userName;
            if (str != null) {
                encodeUTF8(dataOutputStream, str);
                char[] cArr = this.password;
                if (cArr != null) {
                    encodeUTF8(dataOutputStream, new String(cArr));
                }
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            throw new MqttException((Throwable) e11);
        }
    }

    public byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i11 = this.MqttVersion;
            if (i11 == 3) {
                encodeUTF8(dataOutputStream, "MQIsdp");
            } else if (i11 == 4) {
                encodeUTF8(dataOutputStream, "MQTT");
            }
            dataOutputStream.write(this.MqttVersion);
            byte b11 = 0;
            if (this.cleanSession) {
                b11 = (byte) 2;
            }
            MqttMessage mqttMessage = this.willMessage;
            if (mqttMessage != null) {
                b11 = (byte) (((byte) (b11 | 4)) | (mqttMessage.getQos() << 3));
                if (this.willMessage.isRetained()) {
                    b11 = (byte) (b11 | 32);
                }
            }
            if (this.userName != null) {
                b11 = (byte) (b11 | 128);
                if (this.password != null) {
                    b11 = (byte) (b11 | SignedBytes.MAX_POWER_OF_TWO);
                }
            }
            dataOutputStream.write(b11);
            dataOutputStream.writeShort(this.keepAliveInterval);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            throw new MqttException((Throwable) e11);
        }
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    public boolean isMessageIdRequired() {
        return false;
    }

    public String toString() {
        String mqttWireMessage = super.toString();
        return mqttWireMessage + " clientId " + this.clientId + " keepAliveInterval " + this.keepAliveInterval;
    }

    public MqttConnect(String str, int i11, boolean z11, int i12, String str2, char[] cArr, MqttMessage mqttMessage, String str3) {
        super((byte) 1);
        this.clientId = str;
        this.cleanSession = z11;
        this.keepAliveInterval = i12;
        this.userName = str2;
        this.password = cArr;
        this.willMessage = mqttMessage;
        this.willDestination = str3;
        this.MqttVersion = i11;
    }
}
