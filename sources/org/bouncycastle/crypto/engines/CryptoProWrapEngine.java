package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.modes.GCFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.util.Pack;

public class CryptoProWrapEngine extends GOST28147WrapEngine {
    private static boolean bitSet(byte b11, int i11) {
        return (b11 & (1 << i11)) != 0;
    }

    private static byte[] cryptoProDiversify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i11 = 0; i11 != 8; i11++) {
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 != 8; i14++) {
                int littleEndianToInt = Pack.littleEndianToInt(bArr, i14 * 4);
                if (bitSet(bArr2[i11], i14)) {
                    i12 += littleEndianToInt;
                } else {
                    i13 += littleEndianToInt;
                }
            }
            byte[] bArr4 = new byte[8];
            Pack.intToLittleEndian(i12, bArr4, 0);
            Pack.intToLittleEndian(i13, bArr4, 4);
            GCFBBlockCipher gCFBBlockCipher = new GCFBBlockCipher(new GOST28147Engine());
            gCFBBlockCipher.init(true, new ParametersWithIV(new ParametersWithSBox(new KeyParameter(bArr), bArr3), bArr4));
            gCFBBlockCipher.processBlock(bArr, 0, bArr, 0);
            gCFBBlockCipher.processBlock(bArr, 8, bArr, 8);
            gCFBBlockCipher.processBlock(bArr, 16, bArr, 16);
            gCFBBlockCipher.processBlock(bArr, 24, bArr, 24);
        }
        return bArr;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        byte[] bArr;
        KeyParameter keyParameter;
        ParametersWithUKM parametersWithUKM;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        ParametersWithUKM parametersWithUKM2 = (ParametersWithUKM) cipherParameters;
        if (parametersWithUKM2.getParameters() instanceof ParametersWithSBox) {
            keyParameter = (KeyParameter) ((ParametersWithSBox) parametersWithUKM2.getParameters()).getParameters();
            bArr = ((ParametersWithSBox) parametersWithUKM2.getParameters()).getSBox();
        } else {
            bArr = null;
            keyParameter = (KeyParameter) parametersWithUKM2.getParameters();
        }
        KeyParameter keyParameter2 = new KeyParameter(cryptoProDiversify(keyParameter.getKey(), parametersWithUKM2.getUKM(), bArr));
        if (bArr != null) {
            ParametersWithSBox parametersWithSBox = new ParametersWithSBox(keyParameter2, bArr);
            byte[] ukm = parametersWithUKM2.getUKM();
        } else {
            parametersWithUKM = new ParametersWithUKM(keyParameter2, parametersWithUKM2.getUKM());
        }
        super.init(z11, parametersWithUKM);
    }
}
