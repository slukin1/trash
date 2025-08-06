package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttSuback extends MqttAck {
    private int[] grantedQos;

    public MqttSuback(byte b11, byte[] bArr) throws IOException {
        super((byte) 9);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        this.grantedQos = new int[(bArr.length - 2)];
        int i11 = 0;
        for (int read = dataInputStream.read(); read != -1; read = dataInputStream.read()) {
            this.grantedQos[i11] = read;
            i11++;
        }
        dataInputStream.close();
    }

    public int[] getGrantedQos() {
        return this.grantedQos;
    }

    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" granted Qos");
        for (int append : this.grantedQos) {
            stringBuffer.append(" ");
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }
}
