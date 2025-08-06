package com.tencent.android.tpns.mqtt.internal.wire;

import com.google.common.base.Ascii;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public abstract class MqttWireMessage {
    public static final byte MESSAGE_TYPE_CONNACK = 2;
    public static final byte MESSAGE_TYPE_CONNECT = 1;
    public static final byte MESSAGE_TYPE_DISCONNECT = 14;
    public static final byte MESSAGE_TYPE_PINGREQ = 12;
    public static final byte MESSAGE_TYPE_PINGRESP = 13;
    public static final byte MESSAGE_TYPE_PUBACK = 4;
    public static final byte MESSAGE_TYPE_PUBCOMP = 7;
    public static final byte MESSAGE_TYPE_PUBLISH = 3;
    public static final byte MESSAGE_TYPE_PUBREC = 5;
    public static final byte MESSAGE_TYPE_PUBREL = 6;
    public static final byte MESSAGE_TYPE_SUBACK = 9;
    public static final byte MESSAGE_TYPE_SUBSCRIBE = 8;
    public static final byte MESSAGE_TYPE_UNSUBACK = 11;
    public static final byte MESSAGE_TYPE_UNSUBSCRIBE = 10;
    private static final String[] PACKET_NAMES = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};
    public static final String STRING_ENCODING = "UTF-8";
    public boolean duplicate = false;
    public int msgId;
    private byte type;

    public MqttWireMessage(byte b11) {
        this.type = b11;
        this.msgId = 0;
    }

    public static MqttWireMessage createWireMessage(MqttPersistable mqttPersistable) throws MqttException {
        byte[] payloadBytes = mqttPersistable.getPayloadBytes();
        if (payloadBytes == null) {
            payloadBytes = new byte[0];
        }
        return createWireMessage((InputStream) new MultiByteArrayInputStream(mqttPersistable.getHeaderBytes(), mqttPersistable.getHeaderOffset(), mqttPersistable.getHeaderLength(), payloadBytes, mqttPersistable.getPayloadOffset(), mqttPersistable.getPayloadLength()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] encodeMBI(long r6) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x0006:
            r2 = 128(0x80, double:6.32E-322)
            long r4 = r6 % r2
            int r4 = (int) r4
            byte r4 = (byte) r4
            long r6 = r6 / r2
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0016
            r3 = r4 | 128(0x80, float:1.794E-43)
            byte r4 = (byte) r3
        L_0x0016:
            r0.write(r4)
            int r1 = r1 + 1
            if (r2 <= 0) goto L_0x0020
            r2 = 4
            if (r1 < r2) goto L_0x0006
        L_0x0020:
            byte[] r6 = r0.toByteArray()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage.encodeMBI(long):byte[]");
    }

    public static MultiByteInteger readMBI(DataInputStream dataInputStream) throws IOException {
        byte readByte;
        long j11 = 0;
        int i11 = 0;
        int i12 = 1;
        do {
            readByte = dataInputStream.readByte();
            i11++;
            j11 += (long) ((readByte & Ascii.DEL) * i12);
            i12 *= 128;
        } while ((readByte & 128) != 0);
        return new MultiByteInteger(j11, i11);
    }

    public String decodeUTF8(DataInputStream dataInputStream) throws MqttException {
        try {
            byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
            dataInputStream.readFully(bArr);
            return new String(bArr, "UTF-8");
        } catch (IOException e11) {
            throw new MqttException((Throwable) e11);
        }
    }

    public byte[] encodeMessageId() throws MqttException {
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

    public void encodeUTF8(DataOutputStream dataOutputStream, String str) throws MqttException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            dataOutputStream.write((byte) ((bytes.length >>> 8) & 255));
            dataOutputStream.write((byte) ((bytes.length >>> 0) & 255));
            dataOutputStream.write(bytes);
        } catch (UnsupportedEncodingException e11) {
            throw new MqttException((Throwable) e11);
        } catch (IOException e12) {
            throw new MqttException((Throwable) e12);
        }
    }

    public byte[] getHeader() throws MqttException {
        try {
            byte type2 = ((getType() & 15) << 4) ^ (getMessageInfo() & 15);
            byte[] variableHeader = getVariableHeader();
            int length = variableHeader.length + getPayload().length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(type2);
            dataOutputStream.write(encodeMBI((long) length));
            dataOutputStream.write(variableHeader);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            throw new MqttException((Throwable) e11);
        }
    }

    public String getKey() {
        return new Integer(getMessageId()).toString();
    }

    public int getMessageId() {
        return this.msgId;
    }

    public abstract byte getMessageInfo();

    public byte[] getPayload() throws MqttException {
        return new byte[0];
    }

    public byte getType() {
        return this.type;
    }

    public abstract byte[] getVariableHeader() throws MqttException;

    public boolean isMessageIdRequired() {
        return true;
    }

    public boolean isRetryable() {
        return false;
    }

    public void setDuplicate(boolean z11) {
        this.duplicate = z11;
    }

    public void setMessageId(int i11) {
        this.msgId = i11;
    }

    public String toString() {
        return PACKET_NAMES[this.type];
    }

    public static MqttWireMessage createWireMessage(byte[] bArr) throws MqttException {
        return createWireMessage((InputStream) new ByteArrayInputStream(bArr));
    }

    private static MqttWireMessage createWireMessage(InputStream inputStream) throws MqttException {
        try {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            DataInputStream dataInputStream = new DataInputStream(countingInputStream);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte b11 = (byte) (readUnsignedByte >> 4);
            byte b12 = (byte) (readUnsignedByte & 15);
            long counter = (((long) countingInputStream.getCounter()) + readMBI(dataInputStream).getValue()) - ((long) countingInputStream.getCounter());
            byte[] bArr = new byte[0];
            if (counter > 0) {
                int i11 = (int) counter;
                byte[] bArr2 = new byte[i11];
                dataInputStream.readFully(bArr2, 0, i11);
                bArr = bArr2;
            }
            if (b11 == 1) {
                return new MqttConnect(b12, bArr);
            }
            if (b11 == 3) {
                return new MqttPublish(b12, bArr);
            }
            if (b11 == 4) {
                return new MqttPubAck(b12, bArr);
            }
            if (b11 == 7) {
                return new MqttPubComp(b12, bArr);
            }
            if (b11 == 2) {
                return new MqttConnack(b12, bArr);
            }
            if (b11 == 12) {
                return new MqttPingReq(b12, bArr);
            }
            if (b11 == 13) {
                return new MqttPingResp(b12, bArr);
            }
            if (b11 == 8) {
                return new MqttSubscribe(b12, bArr);
            }
            if (b11 == 9) {
                return new MqttSuback(b12, bArr);
            }
            if (b11 == 10) {
                return new MqttUnsubscribe(b12, bArr);
            }
            if (b11 == 11) {
                return new MqttUnsubAck(b12, bArr);
            }
            if (b11 == 6) {
                return new MqttPubRel(b12, bArr);
            }
            if (b11 == 5) {
                return new MqttPubRec(b12, bArr);
            }
            if (b11 == 14) {
                return new MqttDisconnect(b12, bArr);
            }
            throw ExceptionHelper.createMqttException(6);
        } catch (IOException e11) {
            throw new MqttException((Throwable) e11);
        }
    }
}
