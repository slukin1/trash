package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KDFParameters;

public class ConcatenationKDFGenerator implements DerivationFunction {
    private Digest digest;
    private int hLen;
    private byte[] otherInfo;
    private byte[] shared;

    public ConcatenationKDFGenerator(Digest digest2) {
        this.digest = digest2;
        this.hLen = digest2.getDigestSize();
    }

    private void ItoOSP(int i11, byte[] bArr) {
        bArr[0] = (byte) (i11 >>> 24);
        bArr[1] = (byte) (i11 >>> 16);
        bArr[2] = (byte) (i11 >>> 8);
        bArr[3] = (byte) (i11 >>> 0);
    }

    public int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException {
        int i13;
        int i14;
        if (bArr.length - i12 >= i11) {
            byte[] bArr2 = new byte[this.hLen];
            byte[] bArr3 = new byte[4];
            this.digest.reset();
            int i15 = 1;
            if (i12 > this.hLen) {
                i13 = 0;
                while (true) {
                    ItoOSP(i15, bArr3);
                    this.digest.update(bArr3, 0, 4);
                    Digest digest2 = this.digest;
                    byte[] bArr4 = this.shared;
                    digest2.update(bArr4, 0, bArr4.length);
                    Digest digest3 = this.digest;
                    byte[] bArr5 = this.otherInfo;
                    digest3.update(bArr5, 0, bArr5.length);
                    this.digest.doFinal(bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i11 + i13, this.hLen);
                    int i16 = this.hLen;
                    i13 += i16;
                    i14 = i15 + 1;
                    if (i15 >= i12 / i16) {
                        break;
                    }
                    i15 = i14;
                }
                i15 = i14;
            } else {
                i13 = 0;
            }
            if (i13 < i12) {
                ItoOSP(i15, bArr3);
                this.digest.update(bArr3, 0, 4);
                Digest digest4 = this.digest;
                byte[] bArr6 = this.shared;
                digest4.update(bArr6, 0, bArr6.length);
                Digest digest5 = this.digest;
                byte[] bArr7 = this.otherInfo;
                digest5.update(bArr7, 0, bArr7.length);
                this.digest.doFinal(bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i11 + i13, i12 - i13);
            }
            return i12;
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
            this.otherInfo = kDFParameters.getIV();
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for generator");
    }
}
