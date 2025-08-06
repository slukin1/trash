package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.KGCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class KGMac implements Mac {
    private final KGCMBlockCipher cipher;
    private final int macSizeBits;

    public KGMac(KGCMBlockCipher kGCMBlockCipher) {
        this.cipher = kGCMBlockCipher;
        this.macSizeBits = kGCMBlockCipher.getUnderlyingCipher().getBlockSize() * 8;
    }

    public KGMac(KGCMBlockCipher kGCMBlockCipher, int i11) {
        this.cipher = kGCMBlockCipher;
        this.macSizeBits = i11;
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        try {
            return this.cipher.doFinal(bArr, i11);
        } catch (InvalidCipherTextException e11) {
            throw new IllegalStateException(e11.toString());
        }
    }

    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "-KGMAC";
    }

    public int getMacSize() {
        return this.macSizeBits / 8;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.cipher.init(true, new AEADParameters((KeyParameter) parametersWithIV.getParameters(), this.macSizeBits, parametersWithIV.getIV()));
            return;
        }
        throw new IllegalArgumentException("KGMAC requires ParametersWithIV");
    }

    public void reset() {
        this.cipher.reset();
    }

    public void update(byte b11) throws IllegalStateException {
        this.cipher.processAADByte(b11);
    }

    public void update(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalStateException {
        this.cipher.processAADBytes(bArr, i11, i12);
    }
}
