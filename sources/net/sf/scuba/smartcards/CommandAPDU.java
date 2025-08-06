package net.sf.scuba.smartcards;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class CommandAPDU implements Serializable {
    private static final int MAX_APDU_SIZE = 65544;
    private static final long serialVersionUID = 398698301286670877L;
    private byte[] apdu;
    private transient int dataOffset;

    /* renamed from: nc  reason: collision with root package name */
    private transient int f58530nc;

    /* renamed from: ne  reason: collision with root package name */
    private transient int f58531ne;

    public CommandAPDU(byte[] bArr) {
        this.apdu = (byte[]) bArr.clone();
        parse();
    }

    private static int arrayLength(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    private void checkArrayBounds(byte[] bArr, int i11, int i12) {
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Offset and length must not be negative");
        } else if (bArr == null) {
            if (i11 != 0 && i12 != 0) {
                throw new IllegalArgumentException("offset and length must be 0 if array is null");
            }
        } else if (i11 > bArr.length - i12) {
            throw new IllegalArgumentException("Offset plus length exceed array size");
        }
    }

    private void parse() {
        byte[] bArr = this.apdu;
        if (bArr.length < 4) {
            throw new IllegalArgumentException("apdu must be at least 4 bytes long");
        } else if (bArr.length != 4) {
            byte b11 = bArr[4] & 255;
            byte b12 = 256;
            if (bArr.length == 5) {
                if (b11 == 0) {
                    b11 = 256;
                }
                this.f58531ne = b11;
            } else if (b11 != 0) {
                if (bArr.length == b11 + 5) {
                    this.f58530nc = b11;
                    this.dataOffset = 5;
                } else if (bArr.length == b11 + 6) {
                    this.f58530nc = b11;
                    this.dataOffset = 5;
                    byte b13 = bArr[bArr.length - 1] & 255;
                    if (b13 != 0) {
                        b12 = b13;
                    }
                    this.f58531ne = b12;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + b11);
                }
            } else if (bArr.length >= 7) {
                byte b14 = ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                byte b15 = 65536;
                if (bArr.length == 7) {
                    if (b14 == 0) {
                        b14 = 65536;
                    }
                    this.f58531ne = b14;
                } else if (b14 == 0) {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + b11 + ", b2||b3=" + b14);
                } else if (bArr.length == b14 + 7) {
                    this.f58530nc = b14;
                    this.dataOffset = 7;
                } else if (bArr.length == b14 + 9) {
                    this.f58530nc = b14;
                    this.dataOffset = 7;
                    int length = bArr.length - 2;
                    byte b16 = (bArr[length + 1] & 255) | ((bArr[length] & 255) << 8);
                    if (b16 != 0) {
                        b15 = b16;
                    }
                    this.f58531ne = b15;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + b11 + ", b2||b3=" + b14);
                }
            } else {
                throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + b11);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.apdu = (byte[]) objectInputStream.readUnshared();
        parse();
    }

    private void setHeader(int i11, int i12, int i13, int i14) {
        byte[] bArr = this.apdu;
        bArr[0] = (byte) i11;
        bArr[1] = (byte) i12;
        bArr[2] = (byte) i13;
        bArr[3] = (byte) i14;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandAPDU)) {
            return false;
        }
        return Arrays.equals(this.apdu, ((CommandAPDU) obj).apdu);
    }

    public byte[] getBytes() {
        return (byte[]) this.apdu.clone();
    }

    public int getCLA() {
        return this.apdu[0] & 255;
    }

    public byte[] getData() {
        int i11 = this.f58530nc;
        byte[] bArr = new byte[i11];
        System.arraycopy(this.apdu, this.dataOffset, bArr, 0, i11);
        return bArr;
    }

    public int getINS() {
        return this.apdu[1] & 255;
    }

    public int getNc() {
        return this.f58530nc;
    }

    public int getNe() {
        return this.f58531ne;
    }

    public int getP1() {
        return this.apdu[2] & 255;
    }

    public int getP2() {
        return this.apdu[3] & 255;
    }

    public int hashCode() {
        return Arrays.hashCode(this.apdu);
    }

    public String toString() {
        return "CommmandAPDU: " + this.apdu.length + " bytes, nc=" + this.f58530nc + ", ne=" + this.f58531ne;
    }

    public CommandAPDU(byte[] bArr, int i11, int i12) {
        checkArrayBounds(bArr, i11, i12);
        byte[] bArr2 = new byte[i12];
        this.apdu = bArr2;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        parse();
    }

    public CommandAPDU(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.apdu = bArr;
        byteBuffer.get(bArr);
        parse();
    }

    public CommandAPDU(int i11, int i12, int i13, int i14) {
        this(i11, i12, i13, i14, (byte[]) null, 0, 0, 0);
    }

    public CommandAPDU(int i11, int i12, int i13, int i14, int i15) {
        this(i11, i12, i13, i14, (byte[]) null, 0, 0, i15);
    }

    public CommandAPDU(int i11, int i12, int i13, int i14, byte[] bArr) {
        this(i11, i12, i13, i14, bArr, 0, arrayLength(bArr), 0);
    }

    public CommandAPDU(int i11, int i12, int i13, int i14, byte[] bArr, int i15, int i16) {
        this(i11, i12, i13, i14, bArr, i15, i16, 0);
    }

    public CommandAPDU(int i11, int i12, int i13, int i14, byte[] bArr, int i15) {
        this(i11, i12, i13, i14, bArr, 0, arrayLength(bArr), i15);
    }

    public CommandAPDU(int i11, int i12, int i13, int i14, byte[] bArr, int i15, int i16, int i17) {
        byte b11;
        byte[] bArr2 = bArr;
        int i18 = i15;
        int i19 = i16;
        int i21 = i17;
        checkArrayBounds(bArr2, i18, i19);
        if (i19 > 65535) {
            throw new IllegalArgumentException("dataLength is too large");
        } else if (i21 < 0) {
            throw new IllegalArgumentException("ne must not be negative");
        } else if (i21 <= 65536) {
            this.f58531ne = i21;
            this.f58530nc = i19;
            byte b12 = 0;
            if (i19 == 0) {
                if (i21 == 0) {
                    this.apdu = new byte[4];
                    setHeader(i11, i12, i13, i14);
                } else if (i21 <= 256) {
                    b12 = i21 != 256 ? (byte) i21 : b12;
                    this.apdu = new byte[5];
                    setHeader(i11, i12, i13, i14);
                    this.apdu[4] = b12;
                } else {
                    if (i21 == 65536) {
                        b11 = 0;
                    } else {
                        b12 = (byte) (i21 >> 8);
                        b11 = (byte) i21;
                    }
                    this.apdu = new byte[7];
                    setHeader(i11, i12, i13, i14);
                    byte[] bArr3 = this.apdu;
                    bArr3[5] = b12;
                    bArr3[6] = b11;
                }
            } else if (i21 == 0) {
                if (i19 <= 255) {
                    this.apdu = new byte[(i19 + 5)];
                    setHeader(i11, i12, i13, i14);
                    byte[] bArr4 = this.apdu;
                    bArr4[4] = (byte) i19;
                    this.dataOffset = 5;
                    System.arraycopy(bArr2, i18, bArr4, 5, i19);
                    return;
                }
                this.apdu = new byte[(i19 + 7)];
                setHeader(i11, i12, i13, i14);
                byte[] bArr5 = this.apdu;
                bArr5[4] = 0;
                bArr5[5] = (byte) (i19 >> 8);
                bArr5[6] = (byte) i19;
                this.dataOffset = 7;
                System.arraycopy(bArr2, i18, bArr5, 7, i19);
            } else if (i19 > 255 || i21 > 256) {
                this.apdu = new byte[(i19 + 9)];
                setHeader(i11, i12, i13, i14);
                byte[] bArr6 = this.apdu;
                bArr6[4] = 0;
                bArr6[5] = (byte) (i19 >> 8);
                bArr6[6] = (byte) i19;
                this.dataOffset = 7;
                System.arraycopy(bArr2, i18, bArr6, 7, i19);
                if (i21 != 65536) {
                    byte[] bArr7 = this.apdu;
                    int length = bArr7.length - 2;
                    bArr7[length] = (byte) (i21 >> 8);
                    bArr7[length + 1] = (byte) i21;
                }
            } else {
                this.apdu = new byte[(i19 + 6)];
                setHeader(i11, i12, i13, i14);
                byte[] bArr8 = this.apdu;
                bArr8[4] = (byte) i19;
                this.dataOffset = 5;
                System.arraycopy(bArr2, i18, bArr8, 5, i19);
                byte[] bArr9 = this.apdu;
                bArr9[bArr9.length - 1] = i21 != 256 ? (byte) i21 : b12;
            }
        } else {
            throw new IllegalArgumentException("ne is too large");
        }
    }
}
