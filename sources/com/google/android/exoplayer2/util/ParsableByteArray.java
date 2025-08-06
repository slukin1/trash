package com.google.android.exoplayer2.util;

import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;
import okio.Utf8;

public final class ParsableByteArray {
    private byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public int bytesLeft() {
        return this.limit - this.position;
    }

    public int capacity() {
        return this.data.length;
    }

    public void ensureCapacity(int i11) {
        if (i11 > capacity()) {
            this.data = Arrays.copyOf(this.data, i11);
        }
    }

    public byte[] getData() {
        return this.data;
    }

    public int getPosition() {
        return this.position;
    }

    public int limit() {
        return this.limit;
    }

    public char peekChar() {
        byte[] bArr = this.data;
        int i11 = this.position;
        return (char) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i11) {
        readBytes(parsableBitArray.data, 0, i11);
        parsableBitArray.setPosition(0);
    }

    public String readDelimiterTerminatedString(char c11) {
        if (bytesLeft() == 0) {
            return null;
        }
        int i11 = this.position;
        while (i11 < this.limit && this.data[i11] != c11) {
            i11++;
        }
        byte[] bArr = this.data;
        int i12 = this.position;
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr, i12, i11 - i12);
        this.position = i11;
        if (i11 < this.limit) {
            this.position = i11 + 1;
        }
        return fromUtf8Bytes;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = (bArr[i11] & 255) << Ascii.CAN;
        int i14 = i12 + 1;
        this.position = i14;
        byte b11 = i13 | ((bArr[i12] & 255) << 16);
        int i15 = i14 + 1;
        this.position = i15;
        byte b12 = b11 | ((bArr[i14] & 255) << 8);
        this.position = i15 + 1;
        return (bArr[i15] & 255) | b12;
    }

    public int readInt24() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        byte b11 = (((bArr[i11] & 255) << Ascii.CAN) >> 8) | ((bArr[i12] & 255) << 8);
        this.position = i13 + 1;
        return (bArr[i13] & 255) | b11;
    }

    public String readLine() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i11 = this.position;
        while (i11 < this.limit && !Util.isLinebreak(this.data[i11])) {
            i11++;
        }
        int i12 = this.position;
        if (i11 - i12 >= 3) {
            byte[] bArr = this.data;
            if (bArr[i12] == -17 && bArr[i12 + 1] == -69 && bArr[i12 + 2] == -65) {
                this.position = i12 + 3;
            }
        }
        byte[] bArr2 = this.data;
        int i13 = this.position;
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr2, i13, i11 - i13);
        this.position = i11;
        int i14 = this.limit;
        if (i11 == i14) {
            return fromUtf8Bytes;
        }
        byte[] bArr3 = this.data;
        if (bArr3[i11] == 13) {
            int i15 = i11 + 1;
            this.position = i15;
            if (i15 == i14) {
                return fromUtf8Bytes;
            }
        }
        int i16 = this.position;
        if (bArr3[i16] == 10) {
            this.position = i16 + 1;
        }
        return fromUtf8Bytes;
    }

    public int readLittleEndianInt() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        byte b11 = (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
        int i14 = i13 + 1;
        this.position = i14;
        byte b12 = b11 | ((bArr[i13] & 255) << 16);
        this.position = i14 + 1;
        return ((bArr[i14] & 255) << Ascii.CAN) | b12;
    }

    public int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        byte b11 = (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
        this.position = i13 + 1;
        return ((bArr[i13] & 255) << 16) | b11;
    }

    public long readLittleEndianLong() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        int i14 = i13 + 1;
        this.position = i14;
        int i15 = i14 + 1;
        this.position = i15;
        int i16 = i15 + 1;
        this.position = i16;
        int i17 = i16 + 1;
        this.position = i17;
        int i18 = i17 + 1;
        this.position = i18;
        this.position = i18 + 1;
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i12]) & 255) << 8) | ((((long) bArr[i13]) & 255) << 16) | ((((long) bArr[i14]) & 255) << 24) | ((((long) bArr[i15]) & 255) << 32) | ((((long) bArr[i16]) & 255) << 40) | ((((long) bArr[i17]) & 255) << 48) | ((((long) bArr[i18]) & 255) << 56);
    }

    public short readLittleEndianShort() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        this.position = i12 + 1;
        return (short) (((bArr[i12] & 255) << 8) | (bArr[i11] & 255));
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        int i14 = i13 + 1;
        this.position = i14;
        this.position = i14 + 1;
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i12]) & 255) << 8) | ((((long) bArr[i13]) & 255) << 16) | ((((long) bArr[i14]) & 255) << 24);
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        byte b11 = (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
        this.position = i13 + 1;
        return ((bArr[i13] & 255) << 16) | b11;
    }

    public int readLittleEndianUnsignedIntToInt() {
        int readLittleEndianInt = readLittleEndianInt();
        if (readLittleEndianInt >= 0) {
            return readLittleEndianInt;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("Top bit not zero: ");
        sb2.append(readLittleEndianInt);
        throw new IllegalStateException(sb2.toString());
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        this.position = i12 + 1;
        return ((bArr[i12] & 255) << 8) | (bArr[i11] & 255);
    }

    public long readLong() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        int i14 = i13 + 1;
        this.position = i14;
        int i15 = i14 + 1;
        this.position = i15;
        int i16 = i15 + 1;
        this.position = i16;
        int i17 = i16 + 1;
        this.position = i17;
        int i18 = i17 + 1;
        this.position = i18;
        this.position = i18 + 1;
        return ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i12]) & 255) << 48) | ((((long) bArr[i13]) & 255) << 40) | ((((long) bArr[i14]) & 255) << 32) | ((((long) bArr[i15]) & 255) << 24) | ((((long) bArr[i16]) & 255) << 16) | ((((long) bArr[i17]) & 255) << 8) | (((long) bArr[i18]) & 255);
    }

    public String readNullTerminatedString(int i11) {
        if (i11 == 0) {
            return "";
        }
        int i12 = this.position;
        int i13 = (i12 + i11) - 1;
        String fromUtf8Bytes = Util.fromUtf8Bytes(this.data, i12, (i13 >= this.limit || this.data[i13] != 0) ? i11 : i11 - 1);
        this.position += i11;
        return fromUtf8Bytes;
    }

    public short readShort() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        this.position = i12 + 1;
        return (short) ((bArr[i12] & 255) | ((bArr[i11] & 255) << 8));
    }

    public String readString(int i11) {
        return readString(i11, Charsets.UTF_8);
    }

    public int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int readUnsignedByte() {
        byte[] bArr = this.data;
        int i11 = this.position;
        this.position = i11 + 1;
        return bArr[i11] & 255;
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        byte b11 = (bArr[i12] & 255) | ((bArr[i11] & 255) << 8);
        this.position = i13 + 2;
        return b11;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        int i14 = i13 + 1;
        this.position = i14;
        this.position = i14 + 1;
        return ((((long) bArr[i11]) & 255) << 24) | ((((long) bArr[i12]) & 255) << 16) | ((((long) bArr[i13]) & 255) << 8) | (((long) bArr[i14]) & 255);
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        int i13 = i12 + 1;
        this.position = i13;
        byte b11 = ((bArr[i11] & 255) << 16) | ((bArr[i12] & 255) << 8);
        this.position = i13 + 1;
        return (bArr[i13] & 255) | b11;
    }

    public int readUnsignedIntToInt() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("Top bit not zero: ");
        sb2.append(readInt);
        throw new IllegalStateException(sb2.toString());
    }

    public long readUnsignedLongToLong() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("Top bit not zero: ");
        sb2.append(readLong);
        throw new IllegalStateException(sb2.toString());
    }

    public int readUnsignedShort() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        this.position = i12 + 1;
        return (bArr[i12] & 255) | ((bArr[i11] & 255) << 8);
    }

    public long readUtf8EncodedLong() {
        int i11;
        int i12;
        long j11 = (long) this.data[this.position];
        int i13 = 7;
        while (true) {
            i11 = 1;
            if (i13 < 0) {
                break;
            }
            int i14 = 1 << i13;
            if ((((long) i14) & j11) != 0) {
                i13--;
            } else if (i13 < 6) {
                j11 &= (long) (i14 - 1);
                i12 = 7 - i13;
            } else if (i13 == 7) {
                i12 = 1;
            }
        }
        i12 = 0;
        if (i12 != 0) {
            while (i11 < i12) {
                byte b11 = this.data[this.position + i11];
                if ((b11 & ISO7816.INS_GET_RESPONSE) == 128) {
                    j11 = (j11 << 6) | ((long) (b11 & Utf8.REPLACEMENT_BYTE));
                    i11++;
                } else {
                    StringBuilder sb2 = new StringBuilder(62);
                    sb2.append("Invalid UTF-8 sequence continuation byte: ");
                    sb2.append(j11);
                    throw new NumberFormatException(sb2.toString());
                }
            }
            this.position += i12;
            return j11;
        }
        StringBuilder sb3 = new StringBuilder(55);
        sb3.append("Invalid UTF-8 sequence first byte: ");
        sb3.append(j11);
        throw new NumberFormatException(sb3.toString());
    }

    public void reset(int i11) {
        reset(capacity() < i11 ? new byte[i11] : this.data, i11);
    }

    public void setLimit(int i11) {
        Assertions.checkArgument(i11 >= 0 && i11 <= this.data.length);
        this.limit = i11;
    }

    public void setPosition(int i11) {
        Assertions.checkArgument(i11 >= 0 && i11 <= this.limit);
        this.position = i11;
    }

    public void skipBytes(int i11) {
        setPosition(this.position + i11);
    }

    public String readString(int i11, Charset charset) {
        String str = new String(this.data, this.position, i11, charset);
        this.position += i11;
        return str;
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public ParsableByteArray(int i11) {
        this.data = new byte[i11];
        this.limit = i11;
    }

    public void readBytes(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.data, this.position, bArr, i11, i12);
        this.position += i12;
    }

    public void reset(byte[] bArr, int i11) {
        this.data = bArr;
        this.limit = i11;
        this.position = 0;
    }

    public void readBytes(ByteBuffer byteBuffer, int i11) {
        byteBuffer.put(this.data, this.position, i11);
        this.position += i11;
    }

    public String readNullTerminatedString() {
        return readDelimiterTerminatedString(0);
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i11) {
        this.data = bArr;
        this.limit = i11;
    }
}
