package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    private Mac hMac;
    private byte[] state;

    public PKCS5S2ParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    public PKCS5S2ParametersGenerator(Digest digest) {
        HMac hMac2 = new HMac(digest);
        this.hMac = hMac2;
        this.state = new byte[hMac2.getMacSize()];
    }

    private void F(byte[] bArr, int i11, byte[] bArr2, byte[] bArr3, int i12) {
        if (i11 != 0) {
            if (bArr != null) {
                this.hMac.update(bArr, 0, bArr.length);
            }
            this.hMac.update(bArr2, 0, bArr2.length);
            this.hMac.doFinal(this.state, 0);
            byte[] bArr4 = this.state;
            System.arraycopy(bArr4, 0, bArr3, i12, bArr4.length);
            for (int i13 = 1; i13 < i11; i13++) {
                Mac mac = this.hMac;
                byte[] bArr5 = this.state;
                mac.update(bArr5, 0, bArr5.length);
                this.hMac.doFinal(this.state, 0);
                int i14 = 0;
                while (true) {
                    byte[] bArr6 = this.state;
                    if (i14 == bArr6.length) {
                        break;
                    }
                    int i15 = i12 + i14;
                    bArr3[i15] = (byte) (bArr6[i14] ^ bArr3[i15]);
                    i14++;
                }
            }
            return;
        }
        throw new IllegalArgumentException("iteration count must be at least 1.");
    }

    private byte[] generateDerivedKey(int i11) {
        int macSize = this.hMac.getMacSize();
        int i12 = ((i11 + macSize) - 1) / macSize;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[(i12 * macSize)];
        this.hMac.init(new KeyParameter(this.password));
        int i13 = 0;
        for (int i14 = 1; i14 <= i12; i14++) {
            int i15 = 3;
            while (true) {
                byte b11 = (byte) (bArr[i15] + 1);
                bArr[i15] = b11;
                if (b11 != 0) {
                    break;
                }
                i15--;
            }
            F(this.salt, this.iterationCount, bArr, bArr2, i13);
            i13 += macSize;
        }
        return bArr2;
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
}
