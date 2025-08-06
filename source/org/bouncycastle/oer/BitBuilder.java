package org.bouncycastle.oer;

import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class BitBuilder {
    private static final byte[] bits = {Byte.MIN_VALUE, SignedBytes.MAX_POWER_OF_TWO, 32, 16, 8, 4, 2, 1};
    public byte[] buf = new byte[1];
    public int pos = 0;

    public void finalize() throws Throwable {
        zero();
        super.finalize();
    }

    public void pad() {
        int i11 = this.pos;
        this.pos = i11 + (i11 % 8);
    }

    public int write(OutputStream outputStream) throws IOException {
        int i11 = this.pos;
        int i12 = (i11 + (i11 % 8)) / 8;
        outputStream.write(this.buf, 0, i12);
        outputStream.flush();
        return i12;
    }

    public void write7BitBytes(int i11) {
        boolean z11 = false;
        for (int i12 = 4; i12 >= 0; i12--) {
            if (!z11 && (-33554432 & i11) != 0) {
                z11 = true;
            }
            if (z11) {
                writeBit(i12).writeBits((long) i11, 32, 7);
            }
            i11 <<= 7;
        }
    }

    public void write7BitBytes(BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + (bigInteger.bitLength() % 8)) / 8;
        int i11 = bitLength * 8;
        BigInteger shiftLeft = BigInteger.valueOf(254).shiftLeft(i11);
        boolean z11 = false;
        while (bitLength >= 0) {
            if (!z11 && bigInteger.and(shiftLeft).compareTo(BigInteger.ZERO) != 0) {
                z11 = true;
            }
            if (z11) {
                writeBit(bitLength).writeBits((long) bigInteger.and(shiftLeft).shiftRight(i11 - 8).intValue(), 8, 7);
            }
            bigInteger = bigInteger.shiftLeft(7);
            bitLength--;
        }
    }

    public int writeAndClear(OutputStream outputStream) throws IOException {
        int i11 = this.pos;
        int i12 = (i11 + (i11 % 8)) / 8;
        outputStream.write(this.buf, 0, i12);
        outputStream.flush();
        zero();
        return i12;
    }

    public BitBuilder writeBit(int i11) {
        int i12 = this.pos;
        int i13 = i12 / 8;
        byte[] bArr = this.buf;
        if (i13 >= bArr.length) {
            byte[] bArr2 = new byte[(bArr.length + 4)];
            System.arraycopy(bArr, 0, bArr2, 0, i12 / 8);
            Arrays.clear(this.buf);
            this.buf = bArr2;
        }
        if (i11 == 0) {
            byte[] bArr3 = this.buf;
            int i14 = this.pos;
            int i15 = i14 / 8;
            bArr3[i15] = (byte) ((~bits[i14 % 8]) & bArr3[i15]);
        } else {
            byte[] bArr4 = this.buf;
            int i16 = this.pos;
            int i17 = i16 / 8;
            bArr4[i17] = (byte) (bits[i16 % 8] | bArr4[i17]);
        }
        this.pos++;
        return this;
    }

    public BitBuilder writeBits(long j11, int i11) {
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            writeBit(((1 << i12) & j11) > 0 ? 1 : 0);
        }
        return this;
    }

    public BitBuilder writeBits(long j11, int i11, int i12) {
        for (int i13 = i11 - 1; i13 >= i11 - i12; i13--) {
            writeBit(((1 << i13) & j11) != 0 ? 1 : 0);
        }
        return this;
    }

    public void zero() {
        Arrays.clear(this.buf);
        this.pos = 0;
    }
}
