package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {
    private Digest digest;

    public PKCS5S1ParametersGenerator(Digest digest2) {
        this.digest = digest2;
    }

    private byte[] generateDerivedKey() {
        int digestSize = this.digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        Digest digest2 = this.digest;
        byte[] bArr2 = this.password;
        digest2.update(bArr2, 0, bArr2.length);
        Digest digest3 = this.digest;
        byte[] bArr3 = this.salt;
        digest3.update(bArr3, 0, bArr3.length);
        this.digest.doFinal(bArr, 0);
        for (int i11 = 1; i11 < this.iterationCount; i11++) {
            this.digest.update(bArr, 0, digestSize);
            this.digest.doFinal(bArr, 0);
        }
        return bArr;
    }

    public CipherParameters generateDerivedMacParameters(int i11) {
        return generateDerivedParameters(i11);
    }

    public CipherParameters generateDerivedParameters(int i11) {
        int i12 = i11 / 8;
        if (i12 <= this.digest.getDigestSize()) {
            return new KeyParameter(generateDerivedKey(), 0, i12);
        }
        throw new IllegalArgumentException("Can't generate a derived key " + i12 + " bytes long.");
    }

    public CipherParameters generateDerivedParameters(int i11, int i12) {
        int i13 = i11 / 8;
        int i14 = i12 / 8;
        int i15 = i13 + i14;
        if (i15 <= this.digest.getDigestSize()) {
            byte[] generateDerivedKey = generateDerivedKey();
            return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i13), generateDerivedKey, i13, i14);
        }
        throw new IllegalArgumentException("Can't generate a derived key " + i15 + " bytes long.");
    }
}
