package com.facebook.stetho.websocket;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal.ws.WebSocketProtocol;

class Frame {
    public static final byte OPCODE_BINARY_FRAME = 2;
    public static final byte OPCODE_CONNECTION_CLOSE = 8;
    public static final byte OPCODE_CONNECTION_PING = 9;
    public static final byte OPCODE_CONNECTION_PONG = 10;
    public static final byte OPCODE_TEXT_FRAME = 1;
    public boolean fin;
    public boolean hasMask;
    public byte[] maskingKey;
    public byte opcode;
    public byte[] payloadData;
    public long payloadLen;
    public boolean rsv1;
    public boolean rsv2;
    public boolean rsv3;

    private void decodeFirstByte(byte b11) {
        boolean z11 = true;
        this.fin = (b11 & 128) != 0;
        this.rsv1 = (b11 & SignedBytes.MAX_POWER_OF_TWO) != 0;
        this.rsv2 = (b11 & 32) != 0;
        if ((b11 & 16) == 0) {
            z11 = false;
        }
        this.rsv3 = z11;
        this.opcode = (byte) (b11 & 15);
    }

    private long decodeLength(byte b11, InputStream inputStream) throws IOException {
        if (b11 <= 125) {
            return (long) b11;
        }
        if (b11 == 126) {
            return (long) (((readByteOrThrow(inputStream) & 255) << 8) | (readByteOrThrow(inputStream) & 255));
        }
        if (b11 == Byte.MAX_VALUE) {
            long j11 = 0;
            for (int i11 = 0; i11 < 8; i11++) {
                j11 = (j11 << 8) | ((long) (readByteOrThrow(inputStream) & 255));
            }
            return j11;
        }
        throw new IOException("Unexpected length byte: " + b11);
    }

    private static byte[] decodeMaskingKey(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        readBytesOrThrow(inputStream, bArr, 0, 4);
        return bArr;
    }

    private byte encodeFirstByte() {
        byte b11 = this.fin ? (byte) 128 : 0;
        if (this.rsv1) {
            b11 = (byte) (b11 | SignedBytes.MAX_POWER_OF_TWO);
        }
        if (this.rsv2) {
            b11 = (byte) (b11 | 32);
        }
        if (this.rsv3) {
            b11 = (byte) (b11 | 16);
        }
        return (byte) (b11 | (this.opcode & 15));
    }

    private static byte[] encodeLength(long j11) {
        if (j11 <= 125) {
            return new byte[]{(byte) ((int) j11)};
        } else if (j11 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return new byte[]{126, (byte) ((int) ((j11 >> 8) & 255)), (byte) ((int) (j11 & 255))};
        } else {
            return new byte[]{Ascii.DEL, (byte) ((int) ((j11 >> 56) & 255)), (byte) ((int) ((j11 >> 48) & 255)), (byte) ((int) ((j11 >> 40) & 255)), (byte) ((int) ((j11 >> 32) & 255)), (byte) ((int) ((j11 >> 24) & 255)), (byte) ((int) ((j11 >> 16) & 255)), (byte) ((int) ((j11 >> 8) & 255)), (byte) ((int) (j11 & 255))};
        }
    }

    private static byte readByteOrThrow(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return (byte) read;
        }
        throw new EOFException();
    }

    private static void readBytesOrThrow(InputStream inputStream, byte[] bArr, int i11, int i12) throws IOException {
        while (i12 > 0) {
            int read = inputStream.read(bArr, i11, i12);
            if (read != -1) {
                i12 -= read;
                i11 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public void readFrom(BufferedInputStream bufferedInputStream) throws IOException {
        decodeFirstByte(readByteOrThrow(bufferedInputStream));
        byte readByteOrThrow = readByteOrThrow(bufferedInputStream);
        this.hasMask = (readByteOrThrow & 128) != 0;
        this.payloadLen = decodeLength((byte) (readByteOrThrow & Ascii.DEL), bufferedInputStream);
        this.maskingKey = this.hasMask ? decodeMaskingKey(bufferedInputStream) : null;
        long j11 = this.payloadLen;
        byte[] bArr = new byte[((int) j11)];
        this.payloadData = bArr;
        readBytesOrThrow(bufferedInputStream, bArr, 0, (int) j11);
        MaskingHelper.unmask(this.maskingKey, this.payloadData, 0, (int) this.payloadLen);
    }

    public void writeTo(BufferedOutputStream bufferedOutputStream) throws IOException {
        bufferedOutputStream.write(encodeFirstByte());
        byte[] encodeLength = encodeLength(this.payloadLen);
        if (this.hasMask) {
            encodeLength[0] = (byte) (encodeLength[0] | 128);
        }
        bufferedOutputStream.write(encodeLength, 0, encodeLength.length);
        if (!this.hasMask) {
            bufferedOutputStream.write(this.payloadData, 0, (int) this.payloadLen);
            return;
        }
        throw new UnsupportedOperationException("Writing masked data not implemented");
    }
}
