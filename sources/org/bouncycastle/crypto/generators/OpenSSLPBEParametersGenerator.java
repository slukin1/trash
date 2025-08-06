package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    private final Digest digest;

    public OpenSSLPBEParametersGenerator() {
        this(DigestFactory.createMD5());
    }

    public OpenSSLPBEParametersGenerator(Digest digest2) {
        this.digest = digest2;
    }

    private byte[] generateDerivedKey(int i11) {
        int digestSize = this.digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        byte[] bArr2 = new byte[i11];
        int i12 = 0;
        while (true) {
            Digest digest2 = this.digest;
            byte[] bArr3 = this.password;
            digest2.update(bArr3, 0, bArr3.length);
            Digest digest3 = this.digest;
            byte[] bArr4 = this.salt;
            digest3.update(bArr4, 0, bArr4.length);
            this.digest.doFinal(bArr, 0);
            int i13 = i11 > digestSize ? digestSize : i11;
            System.arraycopy(bArr, 0, bArr2, i12, i13);
            i12 += i13;
            i11 -= i13;
            if (i11 == 0) {
                return bArr2;
            }
            this.digest.reset();
            this.digest.update(bArr, 0, digestSize);
        }
    }

    public CipherParameters generateDerivedMacParameters(int i11) {
        return generateDerivedParameters(i11);
    }

    public CipherParameters generateDerivedParameters(int i11) {
        int i12 = i11 / 8;
        return new KeyParameter(generateDerivedKey(i12), 0, i12);
    }

    public CipherParameters generateDerivedParameters(int i11, int i12) {
        int i13 = i11 / 8;
        int i14 = i12 / 8;
        byte[] generateDerivedKey = generateDerivedKey(i13 + i14);
        return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i13), generateDerivedKey, i13, i14);
    }

    public void init(byte[] bArr, byte[] bArr2) {
        super.init(bArr, bArr2, 1);
    }
}
