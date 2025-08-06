package org.bouncycastle.jce.provider;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KDFParameters;

public class BrokenKDF2BytesGenerator implements DerivationFunction {
    private Digest digest;

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59354iv;
    private byte[] shared;

    public BrokenKDF2BytesGenerator(Digest digest2) {
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i12 >= i11) {
            long j11 = ((long) i12) * 8;
            if (j11 <= ((long) this.digest.getDigestSize()) * 8 * 2147483648L) {
                int digestSize = (int) (j11 / ((long) this.digest.getDigestSize()));
                int digestSize2 = this.digest.getDigestSize();
                byte[] bArr2 = new byte[digestSize2];
                for (int i13 = 1; i13 <= digestSize; i13++) {
                    Digest digest2 = this.digest;
                    byte[] bArr3 = this.shared;
                    digest2.update(bArr3, 0, bArr3.length);
                    this.digest.update((byte) (i13 & 255));
                    this.digest.update((byte) ((i13 >> 8) & 255));
                    this.digest.update((byte) ((i13 >> 16) & 255));
                    this.digest.update((byte) ((i13 >> 24) & 255));
                    Digest digest3 = this.digest;
                    byte[] bArr4 = this.f59354iv;
                    digest3.update(bArr4, 0, bArr4.length);
                    this.digest.doFinal(bArr2, 0);
                    int i14 = i12 - i11;
                    if (i14 > digestSize2) {
                        System.arraycopy(bArr2, 0, bArr, i11, digestSize2);
                        i11 += digestSize2;
                    } else {
                        System.arraycopy(bArr2, 0, bArr, i11, i14);
                    }
                }
                this.digest.reset();
                return i12;
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
            this.f59354iv = kDFParameters.getIV();
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for generator");
    }
}
