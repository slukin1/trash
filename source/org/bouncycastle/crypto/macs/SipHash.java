package org.bouncycastle.crypto.macs;

import com.xiaomi.mipush.sdk.Constants;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class SipHash implements Mac {

    /* renamed from: c  reason: collision with root package name */
    public final int f59222c;

    /* renamed from: d  reason: collision with root package name */
    public final int f59223d;

    /* renamed from: k0  reason: collision with root package name */
    public long f59224k0;

    /* renamed from: k1  reason: collision with root package name */
    public long f59225k1;

    /* renamed from: m  reason: collision with root package name */
    public long f59226m;

    /* renamed from: v0  reason: collision with root package name */
    public long f59227v0;

    /* renamed from: v1  reason: collision with root package name */
    public long f59228v1;

    /* renamed from: v2  reason: collision with root package name */
    public long f59229v2;

    /* renamed from: v3  reason: collision with root package name */
    public long f59230v3;
    public int wordCount;
    public int wordPos;

    public SipHash() {
        this.f59226m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f59222c = 2;
        this.f59223d = 4;
    }

    public SipHash(int i11, int i12) {
        this.f59226m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f59222c = i11;
        this.f59223d = i12;
    }

    public static long rotateLeft(long j11, int i11) {
        return (j11 >>> (-i11)) | (j11 << i11);
    }

    public void applySipRounds(int i11) {
        long j11 = this.f59227v0;
        long j12 = this.f59228v1;
        long j13 = this.f59229v2;
        long j14 = this.f59230v3;
        for (int i12 = 0; i12 < i11; i12++) {
            long j15 = j11 + j12;
            long j16 = j13 + j14;
            long rotateLeft = rotateLeft(j12, 13) ^ j15;
            long rotateLeft2 = rotateLeft(j14, 16) ^ j16;
            long j17 = j16 + rotateLeft;
            j11 = rotateLeft(j15, 32) + rotateLeft2;
            j12 = rotateLeft(rotateLeft, 17) ^ j17;
            j14 = rotateLeft(rotateLeft2, 21) ^ j11;
            j13 = rotateLeft(j17, 32);
        }
        this.f59227v0 = j11;
        this.f59228v1 = j12;
        this.f59229v2 = j13;
        this.f59230v3 = j14;
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        Pack.longToLittleEndian(doFinal(), bArr, i11);
        return 8;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        long j11 = this.f59226m;
        int i11 = this.wordPos;
        long j12 = j11 >>> ((7 - i11) << 3);
        this.f59226m = j12;
        long j13 = j12 >>> 8;
        this.f59226m = j13;
        this.f59226m = j13 | ((((long) ((this.wordCount << 3) + i11)) & 255) << 56);
        processMessageWord();
        this.f59229v2 ^= 255;
        applySipRounds(this.f59223d);
        long j14 = ((this.f59227v0 ^ this.f59228v1) ^ this.f59229v2) ^ this.f59230v3;
        reset();
        return j14;
    }

    public String getAlgorithmName() {
        return "SipHash-" + this.f59222c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f59223d;
    }

    public int getMacSize() {
        return 8;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                this.f59224k0 = Pack.littleEndianToLong(key, 0);
                this.f59225k1 = Pack.littleEndianToLong(key, 8);
                reset();
                return;
            }
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
    }

    public void processMessageWord() {
        this.wordCount++;
        this.f59230v3 ^= this.f59226m;
        applySipRounds(this.f59222c);
        this.f59227v0 ^= this.f59226m;
    }

    public void reset() {
        long j11 = this.f59224k0;
        this.f59227v0 = 8317987319222330741L ^ j11;
        long j12 = this.f59225k1;
        this.f59228v1 = 7237128888997146477L ^ j12;
        this.f59229v2 = j11 ^ 7816392313619706465L;
        this.f59230v3 = 8387220255154660723L ^ j12;
        this.f59226m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
    }

    public void update(byte b11) throws IllegalStateException {
        long j11 = this.f59226m >>> 8;
        this.f59226m = j11;
        this.f59226m = j11 | ((((long) b11) & 255) << 56);
        int i11 = this.wordPos + 1;
        this.wordPos = i11;
        if (i11 == 8) {
            processMessageWord();
            this.wordPos = 0;
        }
    }

    public void update(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalStateException {
        byte[] bArr2 = bArr;
        int i13 = i12;
        int i14 = i13 & -8;
        int i15 = this.wordPos;
        int i16 = 0;
        if (i15 == 0) {
            while (i16 < i14) {
                this.f59226m = Pack.littleEndianToLong(bArr2, i11 + i16);
                processMessageWord();
                i16 += 8;
            }
            while (i16 < i13) {
                long j11 = this.f59226m >>> 8;
                this.f59226m = j11;
                this.f59226m = j11 | ((((long) bArr2[i11 + i16]) & 255) << 56);
                i16++;
            }
            this.wordPos = i13 - i14;
            return;
        }
        int i17 = i15 << 3;
        int i18 = 0;
        while (i18 < i14) {
            long littleEndianToLong = Pack.littleEndianToLong(bArr2, i11 + i18);
            this.f59226m = (this.f59226m >>> (-i17)) | (littleEndianToLong << i17);
            processMessageWord();
            this.f59226m = littleEndianToLong;
            i18 += 8;
        }
        while (i18 < i13) {
            long j12 = this.f59226m >>> 8;
            this.f59226m = j12;
            this.f59226m = j12 | ((((long) bArr2[i11 + i18]) & 255) << 56);
            int i19 = this.wordPos + 1;
            this.wordPos = i19;
            if (i19 == 8) {
                processMessageWord();
                this.wordPos = 0;
            }
            i18++;
        }
    }
}
