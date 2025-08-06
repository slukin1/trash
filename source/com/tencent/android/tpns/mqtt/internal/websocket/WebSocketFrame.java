package com.tencent.android.tpns.mqtt.internal.websocket;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class WebSocketFrame {
    public static final int frameLengthOverhead = 6;
    private boolean closeFlag = false;
    private boolean fin;
    private byte opcode;
    private byte[] payload;

    public WebSocketFrame(byte b11, boolean z11, byte[] bArr) {
        this.opcode = b11;
        this.fin = z11;
        this.payload = bArr;
    }

    public static void appendFinAndOpCode(ByteBuffer byteBuffer, byte b11, boolean z11) {
        byteBuffer.put((byte) ((b11 & 15) | (z11 ? (byte) 128 : 0)));
    }

    private static void appendLength(ByteBuffer byteBuffer, int i11, boolean z11) {
        if (i11 >= 0) {
            int i12 = z11 ? -128 : 0;
            if (i11 > 65535) {
                byteBuffer.put((byte) (i12 | 127));
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) ((i11 >> 24) & 255));
                byteBuffer.put((byte) ((i11 >> 16) & 255));
                byteBuffer.put((byte) ((i11 >> 8) & 255));
                byteBuffer.put((byte) (i11 & 255));
            } else if (i11 >= 126) {
                byteBuffer.put((byte) (i12 | 126));
                byteBuffer.put((byte) (i11 >> 8));
                byteBuffer.put((byte) (i11 & 255));
            } else {
                byteBuffer.put((byte) (i11 | i12));
            }
        } else {
            throw new IllegalArgumentException("Length cannot be negative");
        }
    }

    public static void appendLengthAndMask(ByteBuffer byteBuffer, int i11, byte[] bArr) {
        if (bArr != null) {
            appendLength(byteBuffer, i11, true);
            byteBuffer.put(bArr);
            return;
        }
        appendLength(byteBuffer, i11, false);
    }

    public static byte[] generateMaskingKey() {
        SecureRandom secureRandom = new SecureRandom();
        return new byte[]{(byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255)};
    }

    private void setFinAndOpCode(byte b11) {
        this.fin = (b11 & 128) != 0;
        this.opcode = (byte) (b11 & 15);
    }

    public byte[] encodeFrame() {
        byte[] bArr = this.payload;
        int length = bArr.length + 6;
        if (bArr.length > 65535) {
            length += 8;
        } else if (bArr.length >= 126) {
            length += 2;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        appendFinAndOpCode(allocate, this.opcode, this.fin);
        byte[] generateMaskingKey = generateMaskingKey();
        appendLengthAndMask(allocate, this.payload.length, generateMaskingKey);
        int i11 = 0;
        while (true) {
            byte[] bArr2 = this.payload;
            if (i11 < bArr2.length) {
                byte b11 = (byte) (bArr2[i11] ^ generateMaskingKey[i11 % 4]);
                bArr2[i11] = b11;
                allocate.put(b11);
                i11++;
            } else {
                allocate.flip();
                return allocate.array();
            }
        }
    }

    public byte getOpcode() {
        return this.opcode;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public boolean isCloseFlag() {
        return this.closeFlag;
    }

    public boolean isFin() {
        return this.fin;
    }

    public WebSocketFrame(byte[] bArr) {
        int i11 = 0;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        setFinAndOpCode(wrap.get());
        byte b11 = wrap.get();
        boolean z11 = (b11 & 128) != 0;
        int i12 = (byte) (b11 & Ascii.DEL);
        int i13 = i12 == 127 ? 8 : i12 == 126 ? 2 : 0;
        while (true) {
            i13--;
            if (i13 <= 0) {
                break;
            }
            i12 |= (wrap.get() & 255) << (i13 * 8);
        }
        byte[] bArr2 = null;
        if (z11) {
            byte[] bArr3 = new byte[4];
            wrap.get(bArr3, 0, 4);
            bArr2 = bArr3;
        }
        byte[] bArr4 = new byte[i12];
        this.payload = bArr4;
        wrap.get(bArr4, 0, i12);
        if (z11) {
            while (true) {
                byte[] bArr5 = this.payload;
                if (i11 < bArr5.length) {
                    bArr5[i11] = (byte) (bArr5[i11] ^ bArr2[i11 % 4]);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public WebSocketFrame(InputStream inputStream) throws IOException {
        int i11 = 0;
        setFinAndOpCode((byte) inputStream.read());
        byte b11 = this.opcode;
        int i12 = 2;
        boolean z11 = true;
        if (b11 == 2) {
            byte read = (byte) inputStream.read();
            z11 = (read & 128) == 0 ? false : z11;
            int i13 = (byte) (read & Ascii.DEL);
            if (i13 == 127) {
                i12 = 8;
            } else if (i13 != 126) {
                i12 = 0;
            }
            i13 = i12 > 0 ? 0 : i13;
            while (true) {
                i12--;
                if (i12 < 0) {
                    break;
                }
                i13 |= (((byte) inputStream.read()) & 255) << (i12 * 8);
            }
            byte[] bArr = null;
            if (z11) {
                byte[] bArr2 = new byte[4];
                inputStream.read(bArr2, 0, 4);
                bArr = bArr2;
            }
            this.payload = new byte[i13];
            int i14 = 0;
            int i15 = i13;
            while (i14 != i13) {
                int read2 = inputStream.read(this.payload, i14, i15);
                i14 += read2;
                i15 -= read2;
            }
            if (z11) {
                while (true) {
                    byte[] bArr3 = this.payload;
                    if (i11 < bArr3.length) {
                        bArr3[i11] = (byte) (bArr3[i11] ^ bArr[i11 % 4]);
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        } else if (b11 == 8) {
            this.closeFlag = true;
        } else {
            throw new IOException("Invalid Frame: Opcode: " + this.opcode);
        }
    }
}
