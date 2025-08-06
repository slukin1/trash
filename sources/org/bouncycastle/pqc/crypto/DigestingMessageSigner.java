package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DigestingMessageSigner implements Signer {
    private boolean forSigning;
    private final Digest messDigest;
    private final MessageSigner messSigner;

    public DigestingMessageSigner(MessageSigner messageSigner, Digest digest) {
        this.messSigner = messageSigner;
        this.messDigest = digest;
    }

    public byte[] generateSignature() {
        if (this.forSigning) {
            byte[] bArr = new byte[this.messDigest.getDigestSize()];
            this.messDigest.doFinal(bArr, 0);
            return this.messSigner.generateSignature(bArr);
        }
        throw new IllegalStateException("DigestingMessageSigner not initialised for signature generation.");
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        this.forSigning = z11;
        AsymmetricKeyParameter asymmetricKeyParameter = cipherParameters instanceof ParametersWithRandom ? (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters() : (AsymmetricKeyParameter) cipherParameters;
        if (z11 && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Signing Requires Private Key.");
        } else if (z11 || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.messSigner.init(z11, cipherParameters);
        } else {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        }
    }

    public void reset() {
        this.messDigest.reset();
    }

    public void update(byte b11) {
        this.messDigest.update(b11);
    }

    public void update(byte[] bArr, int i11, int i12) {
        this.messDigest.update(bArr, i11, i12);
    }

    public boolean verifySignature(byte[] bArr) {
        if (!this.forSigning) {
            byte[] bArr2 = new byte[this.messDigest.getDigestSize()];
            this.messDigest.doFinal(bArr2, 0);
            return this.messSigner.verifySignature(bArr2, bArr);
        }
        throw new IllegalStateException("DigestingMessageSigner not initialised for verification");
    }
}
