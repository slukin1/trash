package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.ClientState;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;

public class MqttInputStream extends InputStream {
    private static final String CLASS_NAME = "MqttInputStream";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ByteArrayOutputStream bais;
    private ClientState clientState = null;

    /* renamed from: in  reason: collision with root package name */
    private DataInputStream f40472in;
    private byte[] packet;
    private long packetLen;
    private long remLen;

    public MqttInputStream(ClientState clientState2, InputStream inputStream) {
        this.clientState = clientState2;
        this.f40472in = new DataInputStream(inputStream);
        this.bais = new ByteArrayOutputStream();
        this.remLen = -1;
    }

    private void readFully() throws IOException {
        int size = this.bais.size();
        long j11 = this.packetLen;
        int i11 = size + ((int) j11);
        int i12 = (int) (this.remLen - j11);
        if (i12 >= 0) {
            int i13 = 0;
            while (i13 < i12) {
                try {
                    int read = this.f40472in.read(this.packet, i11 + i13, i12 - i13);
                    this.clientState.notifyReceivedBytes(read);
                    if (read >= 0) {
                        i13 += read;
                    } else {
                        throw new EOFException();
                    }
                } catch (SocketTimeoutException e11) {
                    this.packetLen += (long) i13;
                    throw e11;
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public int available() throws IOException {
        return this.f40472in.available();
    }

    public void close() throws IOException {
        this.f40472in.close();
    }

    public int read() throws IOException {
        return this.f40472in.read();
    }

    public MqttWireMessage readMqttWireMessage() throws IOException, MqttException {
        TBaseLogger.d(CLASS_NAME, "action - readMqttWireMessage");
        try {
            if (this.remLen < 0) {
                this.bais.reset();
                byte readByte = this.f40472in.readByte();
                this.clientState.notifyReceivedBytes(1);
                byte b11 = (byte) ((readByte >>> 4) & 15);
                if (b11 < 1 || b11 > 14) {
                    throw ExceptionHelper.createMqttException(32108);
                }
                this.remLen = MqttWireMessage.readMBI(this.f40472in).getValue();
                this.bais.write(readByte);
                this.bais.write(MqttWireMessage.encodeMBI(this.remLen));
                this.packet = new byte[((int) (((long) this.bais.size()) + this.remLen))];
                this.packetLen = 0;
            }
            if (this.remLen < 0) {
                return null;
            }
            readFully();
            this.remLen = -1;
            byte[] byteArray = this.bais.toByteArray();
            System.arraycopy(byteArray, 0, this.packet, 0, byteArray.length);
            MqttWireMessage createWireMessage = MqttWireMessage.createWireMessage(this.packet);
            log.fine(CLASS_NAME, "readMqttWireMessage", "501", new Object[]{createWireMessage});
            return createWireMessage;
        } catch (SocketTimeoutException unused) {
            return null;
        }
    }
}
