package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.MessageSigner;

public class HSSSigner implements MessageSigner {
    private HSSPrivateKeyParameters privKey;
    private HSSPublicKeyParameters pubKey;

    public byte[] generateSignature(byte[] bArr) {
        try {
            return HSS.generateSignature(this.privKey, bArr).getEncoded();
        } catch (IOException e11) {
            throw new IllegalStateException("unable to encode signature: " + e11.getMessage());
        }
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (z11) {
            this.privKey = (HSSPrivateKeyParameters) cipherParameters;
        } else {
            this.pubKey = (HSSPublicKeyParameters) cipherParameters;
        }
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        try {
            HSSPublicKeyParameters hSSPublicKeyParameters = this.pubKey;
            return HSS.verifySignature(hSSPublicKeyParameters, HSSSignature.getInstance(bArr2, hSSPublicKeyParameters.getL()), bArr);
        } catch (IOException e11) {
            throw new IllegalStateException("unable to decode signature: " + e11.getMessage());
        }
    }
}
