package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class GSKKFDGenerator implements DigestDerivationFunction {
    private byte[] buf;
    private int counter;
    private final Digest digest;

    /* renamed from: r  reason: collision with root package name */
    private byte[] f59113r;

    /* renamed from: z  reason: collision with root package name */
    private byte[] f59114z;

    public GSKKFDGenerator(Digest digest2) {
        this.digest = digest2;
        this.buf = new byte[digest2.getDigestSize()];
    }

    public int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException {
        if (i11 + i12 <= bArr.length) {
            Digest digest2 = this.digest;
            byte[] bArr2 = this.f59114z;
            digest2.update(bArr2, 0, bArr2.length);
            int i13 = this.counter;
            this.counter = i13 + 1;
            byte[] intToBigEndian = Pack.intToBigEndian(i13);
            this.digest.update(intToBigEndian, 0, intToBigEndian.length);
            byte[] bArr3 = this.f59113r;
            if (bArr3 != null) {
                this.digest.update(bArr3, 0, bArr3.length);
            }
            this.digest.doFinal(this.buf, 0);
            System.arraycopy(this.buf, 0, bArr, i11, i12);
            Arrays.clear(this.buf);
            return i12;
        }
        throw new DataLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof GSKKDFParameters) {
            GSKKDFParameters gSKKDFParameters = (GSKKDFParameters) derivationParameters;
            this.f59114z = gSKKDFParameters.getZ();
            this.counter = gSKKDFParameters.getStartCounter();
            this.f59113r = gSKKDFParameters.getNonce();
            return;
        }
        throw new IllegalArgumentException("unkown parameters type");
    }
}
