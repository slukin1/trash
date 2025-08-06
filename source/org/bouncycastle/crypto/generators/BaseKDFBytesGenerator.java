package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ISO18033KDFParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Pack;

public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    private int counterStart;
    private Digest digest;

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59192iv;
    private byte[] shared;

    public BaseKDFBytesGenerator(int i11, Digest digest2) {
        this.counterStart = i11;
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException {
        byte[] bArr2 = bArr;
        int i13 = i12;
        int i14 = i11;
        if (bArr2.length - i13 >= i14) {
            long j11 = (long) i13;
            int digestSize = this.digest.getDigestSize();
            if (j11 <= 8589934591L) {
                long j12 = (long) digestSize;
                int i15 = (int) (((j11 + j12) - 1) / j12);
                byte[] bArr3 = new byte[this.digest.getDigestSize()];
                byte[] bArr4 = new byte[4];
                Pack.intToBigEndian(this.counterStart, bArr4, 0);
                int i16 = this.counterStart & -256;
                for (int i17 = 0; i17 < i15; i17++) {
                    Digest digest2 = this.digest;
                    byte[] bArr5 = this.shared;
                    digest2.update(bArr5, 0, bArr5.length);
                    this.digest.update(bArr4, 0, 4);
                    byte[] bArr6 = this.f59192iv;
                    if (bArr6 != null) {
                        this.digest.update(bArr6, 0, bArr6.length);
                    }
                    this.digest.doFinal(bArr3, 0);
                    if (i13 > digestSize) {
                        System.arraycopy(bArr3, 0, bArr2, i14, digestSize);
                        i14 += digestSize;
                        i13 -= digestSize;
                    } else {
                        System.arraycopy(bArr3, 0, bArr2, i14, i13);
                    }
                    byte b11 = (byte) (bArr4[3] + 1);
                    bArr4[3] = b11;
                    if (b11 == 0) {
                        i16 += 256;
                        Pack.intToBigEndian(i16, bArr4, 0);
                    }
                }
                this.digest.reset();
                return (int) j11;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            this.f59192iv = kDFParameters.getIV();
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
            this.f59192iv = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
    }
}
