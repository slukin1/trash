package org.bouncycastle.crypto.macs;

import com.xiaomi.mipush.sdk.Constants;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Pack;

public class SipHash128 extends SipHash {
    public SipHash128() {
    }

    public SipHash128(int i11, int i12) {
        super(i11, i12);
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        long j11 = this.f59226m;
        int i12 = this.wordPos;
        long j12 = j11 >>> ((7 - i12) << 3);
        this.f59226m = j12;
        long j13 = j12 >>> 8;
        this.f59226m = j13;
        this.f59226m = j13 | ((((long) ((this.wordCount << 3) + i12)) & 255) << 56);
        processMessageWord();
        this.f59229v2 ^= 238;
        applySipRounds(this.f59223d);
        long j14 = this.f59227v0;
        long j15 = this.f59228v1;
        long j16 = ((j14 ^ j15) ^ this.f59229v2) ^ this.f59230v3;
        this.f59228v1 = j15 ^ 221;
        applySipRounds(this.f59223d);
        reset();
        Pack.longToLittleEndian(j16, bArr, i11);
        Pack.longToLittleEndian(((this.f59227v0 ^ this.f59228v1) ^ this.f59229v2) ^ this.f59230v3, bArr, i11 + 8);
        return 16;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }

    public String getAlgorithmName() {
        return "SipHash128-" + this.f59222c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f59223d;
    }

    public int getMacSize() {
        return 16;
    }

    public void reset() {
        super.reset();
        this.f59228v1 ^= 238;
    }
}
