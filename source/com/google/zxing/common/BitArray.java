package com.google.zxing.common;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i11) {
        if (i11 > (this.bits.length << 5)) {
            int[] makeArray = makeArray(i11);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, makeArray, 0, iArr.length);
            this.bits = makeArray;
        }
    }

    private static int[] makeArray(int i11) {
        return new int[((i11 + 31) / 32)];
    }

    public void appendBit(boolean z11) {
        ensureCapacity(this.size + 1);
        if (z11) {
            int[] iArr = this.bits;
            int i11 = this.size;
            int i12 = i11 / 32;
            iArr[i12] = (1 << (i11 & 31)) | iArr[i12];
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i11 = bitArray.size;
        ensureCapacity(this.size + i11);
        for (int i12 = 0; i12 < i11; i12++) {
            appendBit(bitArray.get(i12));
        }
    }

    public void appendBits(int i11, int i12) {
        if (i12 < 0 || i12 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i12);
        while (i12 > 0) {
            boolean z11 = true;
            if (((i11 >> (i12 - 1)) & 1) != 1) {
                z11 = false;
            }
            appendBit(z11);
            i12--;
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.bits[i11] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        if (this.size != bitArray.size || !Arrays.equals(this.bits, bitArray.bits)) {
            return false;
        }
        return true;
    }

    public void flip(int i11) {
        int[] iArr = this.bits;
        int i12 = i11 / 32;
        iArr[i12] = (1 << (i11 & 31)) ^ iArr[i12];
    }

    public boolean get(int i11) {
        return ((1 << (i11 & 31)) & this.bits[i11 / 32]) != 0;
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public int getNextSet(int i11) {
        int i12 = this.size;
        if (i11 >= i12) {
            return i12;
        }
        int i13 = i11 / 32;
        int i14 = (~((1 << (i11 & 31)) - 1)) & this.bits[i13];
        while (i14 == 0) {
            i13++;
            int[] iArr = this.bits;
            if (i13 == iArr.length) {
                return this.size;
            }
            i14 = iArr[i13];
        }
        int numberOfTrailingZeros = (i13 << 5) + Integer.numberOfTrailingZeros(i14);
        int i15 = this.size;
        return numberOfTrailingZeros > i15 ? i15 : numberOfTrailingZeros;
    }

    public int getNextUnset(int i11) {
        int i12 = this.size;
        if (i11 >= i12) {
            return i12;
        }
        int i13 = i11 / 32;
        int i14 = (~((1 << (i11 & 31)) - 1)) & (~this.bits[i13]);
        while (i14 == 0) {
            i13++;
            int[] iArr = this.bits;
            if (i13 == iArr.length) {
                return this.size;
            }
            i14 = ~iArr[i13];
        }
        int numberOfTrailingZeros = (i13 << 5) + Integer.numberOfTrailingZeros(i14);
        int i15 = this.size;
        return numberOfTrailingZeros > i15 ? i15 : numberOfTrailingZeros;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public boolean isRange(int i11, int i12, boolean z11) {
        if (i12 < i11 || i11 < 0 || i12 > this.size) {
            throw new IllegalArgumentException();
        } else if (i12 == i11) {
            return true;
        } else {
            int i13 = i12 - 1;
            int i14 = i11 / 32;
            int i15 = i13 / 32;
            int i16 = i14;
            while (i16 <= i15) {
                int i17 = 31;
                int i18 = i16 > i14 ? 0 : i11 & 31;
                if (i16 >= i15) {
                    i17 = 31 & i13;
                }
                int i19 = (2 << i17) - (1 << i18);
                int i21 = this.bits[i16] & i19;
                if (!z11) {
                    i19 = 0;
                }
                if (i21 != i19) {
                    return false;
                }
                i16++;
            }
            return true;
        }
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i11 = (this.size - 1) / 32;
        int i12 = i11 + 1;
        for (int i13 = 0; i13 < i12; i13++) {
            long j11 = (long) this.bits[i13];
            long j12 = ((j11 & 1431655765) << 1) | ((j11 >> 1) & 1431655765);
            long j13 = ((j12 & 858993459) << 2) | ((j12 >> 2) & 858993459);
            long j14 = ((j13 & 252645135) << 4) | ((j13 >> 4) & 252645135);
            long j15 = ((j14 & 16711935) << 8) | ((j14 >> 8) & 16711935);
            iArr[i11 - i13] = (int) (((j15 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j15 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i14 = this.size;
        int i15 = i12 << 5;
        if (i14 != i15) {
            int i16 = i15 - i14;
            int i17 = iArr[0] >>> i16;
            for (int i18 = 1; i18 < i12; i18++) {
                int i19 = iArr[i18];
                iArr[i18 - 1] = i17 | (i19 << (32 - i16));
                i17 = i19 >>> i16;
            }
            iArr[i12 - 1] = i17;
        }
        this.bits = iArr;
    }

    public void set(int i11) {
        int[] iArr = this.bits;
        int i12 = i11 / 32;
        iArr[i12] = (1 << (i11 & 31)) | iArr[i12];
    }

    public void setBulk(int i11, int i12) {
        this.bits[i11 / 32] = i12;
    }

    public void setRange(int i11, int i12) {
        if (i12 < i11 || i11 < 0 || i12 > this.size) {
            throw new IllegalArgumentException();
        } else if (i12 != i11) {
            int i13 = i12 - 1;
            int i14 = i11 / 32;
            int i15 = i13 / 32;
            int i16 = i14;
            while (i16 <= i15) {
                int i17 = 31;
                int i18 = i16 > i14 ? 0 : i11 & 31;
                if (i16 >= i15) {
                    i17 = 31 & i13;
                }
                int i19 = (2 << i17) - (1 << i18);
                int[] iArr = this.bits;
                iArr[i16] = i19 | iArr[i16];
                i16++;
            }
        }
    }

    public void toBytes(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = 0;
            for (int i16 = 0; i16 < 8; i16++) {
                if (get(i11)) {
                    i15 |= 1 << (7 - i16);
                }
                i11++;
            }
            bArr[i12 + i14] = (byte) i15;
        }
    }

    public String toString() {
        int i11 = this.size;
        StringBuilder sb2 = new StringBuilder(i11 + (i11 / 8) + 1);
        for (int i12 = 0; i12 < this.size; i12++) {
            if ((i12 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(get(i12) ? 'X' : '.');
        }
        return sb2.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.size == bitArray.size) {
            int i11 = 0;
            while (true) {
                int[] iArr = this.bits;
                if (i11 < iArr.length) {
                    iArr[i11] = iArr[i11] ^ bitArray.bits[i11];
                    i11++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public BitArray clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }

    public BitArray(int i11) {
        this.size = i11;
        this.bits = makeArray(i11);
    }

    public BitArray(int[] iArr, int i11) {
        this.bits = iArr;
        this.size = i11;
    }
}
