package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;

@Beta
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    public static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        public final byte[] bytes;

        public BytesHashCode(byte[] bArr) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
        }

        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        public int asInt() {
            byte[] bArr = this.bytes;
            Preconditions.checkState(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.bytes;
            return ((bArr2[3] & 255) << Ascii.CAN) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        public long asLong() {
            byte[] bArr = this.bytes;
            Preconditions.checkState(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return padToLong();
        }

        public int bits() {
            return this.bytes.length * 8;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            if (this.bytes.length != hashCode.getBytesInternal().length) {
                return false;
            }
            boolean z11 = true;
            int i11 = 0;
            while (true) {
                byte[] bArr = this.bytes;
                if (i11 >= bArr.length) {
                    return z11;
                }
                z11 &= bArr[i11] == hashCode.getBytesInternal()[i11];
                i11++;
            }
        }

        public byte[] getBytesInternal() {
            return this.bytes;
        }

        public long padToLong() {
            long j11 = (long) (this.bytes[0] & 255);
            for (int i11 = 1; i11 < Math.min(this.bytes.length, 8); i11++) {
                j11 |= (((long) this.bytes[i11]) & 255) << (i11 * 8);
            }
            return j11;
        }

        public void writeBytesToImpl(byte[] bArr, int i11, int i12) {
            System.arraycopy(this.bytes, 0, bArr, i11, i12);
        }
    }

    public static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        public final int hash;

        public IntHashCode(int i11) {
            this.hash = i11;
        }

        public byte[] asBytes() {
            int i11 = this.hash;
            return new byte[]{(byte) i11, (byte) (i11 >> 8), (byte) (i11 >> 16), (byte) (i11 >> 24)};
        }

        public int asInt() {
            return this.hash;
        }

        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        public int bits() {
            return 32;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asInt();
        }

        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        public void writeBytesToImpl(byte[] bArr, int i11, int i12) {
            for (int i13 = 0; i13 < i12; i13++) {
                bArr[i11 + i13] = (byte) (this.hash >> (i13 * 8));
            }
        }
    }

    public static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        public final long hash;

        public LongHashCode(long j11) {
            this.hash = j11;
        }

        public byte[] asBytes() {
            long j11 = this.hash;
            return new byte[]{(byte) ((int) j11), (byte) ((int) (j11 >> 8)), (byte) ((int) (j11 >> 16)), (byte) ((int) (j11 >> 24)), (byte) ((int) (j11 >> 32)), (byte) ((int) (j11 >> 40)), (byte) ((int) (j11 >> 48)), (byte) ((int) (j11 >> 56))};
        }

        public int asInt() {
            return (int) this.hash;
        }

        public long asLong() {
            return this.hash;
        }

        public int bits() {
            return 64;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asLong();
        }

        public long padToLong() {
            return this.hash;
        }

        public void writeBytesToImpl(byte[] bArr, int i11, int i12) {
            for (int i13 = 0; i13 < i12; i13++) {
                bArr[i11 + i13] = (byte) ((int) (this.hash >> (i13 * 8)));
            }
        }
    }

    private static int decode(char c11) {
        if (c11 >= '0' && c11 <= '9') {
            return c11 - '0';
        }
        if (c11 >= 'a' && c11 <= 'f') {
            return (c11 - 'a') + 10;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c11);
    }

    public static HashCode fromBytes(byte[] bArr) {
        boolean z11 = true;
        if (bArr.length < 1) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) bArr.clone());
    }

    public static HashCode fromBytesNoCopy(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode fromInt(int i11) {
        return new IntHashCode(i11);
    }

    public static HashCode fromLong(long j11) {
        return new LongHashCode(j11);
    }

    public static HashCode fromString(String str) {
        boolean z11 = true;
        Preconditions.checkArgument(str.length() >= 2, "input string (%s) must have at least 2 characters", (Object) str);
        if (str.length() % 2 != 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "input string (%s) must have an even number of characters", (Object) str);
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i11 = 0; i11 < str.length(); i11 += 2) {
            bArr[i11 / 2] = (byte) ((decode(str.charAt(i11)) << 4) + decode(str.charAt(i11 + 1)));
        }
        return fromBytesNoCopy(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (bits() != hashCode.bits() || !equalsSameBits(hashCode)) {
            return false;
        }
        return true;
    }

    public abstract boolean equalsSameBits(HashCode hashCode);

    public byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] bytesInternal = getBytesInternal();
        byte b11 = bytesInternal[0] & 255;
        for (int i11 = 1; i11 < bytesInternal.length; i11++) {
            b11 |= (bytesInternal[i11] & 255) << (i11 * 8);
        }
        return b11;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] bytesInternal = getBytesInternal();
        StringBuilder sb2 = new StringBuilder(bytesInternal.length * 2);
        for (byte b11 : bytesInternal) {
            char[] cArr = hexDigits;
            sb2.append(cArr[(b11 >> 4) & 15]);
            sb2.append(cArr[b11 & 15]);
        }
        return sb2.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] bArr, int i11, int i12) {
        int min = Ints.min(i12, bits() / 8);
        Preconditions.checkPositionIndexes(i11, i11 + min, bArr.length);
        writeBytesToImpl(bArr, i11, min);
        return min;
    }

    public abstract void writeBytesToImpl(byte[] bArr, int i11, int i12);
}
