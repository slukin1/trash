package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

public class LMSContext implements Digest {
    private final byte[] C;
    private volatile Digest digest;
    private final LMOtsPrivateKey key;
    private final byte[][] path;
    private final LMOtsPublicKey publicKey;
    private final LMSigParameters sigParams;
    private final Object signature;
    private LMSSignedPubKey[] signedPubKeys;

    public LMSContext(LMOtsPrivateKey lMOtsPrivateKey, LMSigParameters lMSigParameters, Digest digest2, byte[] bArr, byte[][] bArr2) {
        this.key = lMOtsPrivateKey;
        this.sigParams = lMSigParameters;
        this.digest = digest2;
        this.C = bArr;
        this.path = bArr2;
        this.publicKey = null;
        this.signature = null;
    }

    public LMSContext(LMOtsPublicKey lMOtsPublicKey, Object obj, Digest digest2) {
        this.publicKey = lMOtsPublicKey;
        this.signature = obj;
        this.digest = digest2;
        this.C = null;
        this.key = null;
        this.sigParams = null;
        this.path = null;
    }

    public int doFinal(byte[] bArr, int i11) {
        return this.digest.doFinal(bArr, i11);
    }

    public String getAlgorithmName() {
        return this.digest.getAlgorithmName();
    }

    public byte[] getC() {
        return this.C;
    }

    public int getDigestSize() {
        return this.digest.getDigestSize();
    }

    public byte[][] getPath() {
        return this.path;
    }

    public LMOtsPrivateKey getPrivateKey() {
        return this.key;
    }

    public LMOtsPublicKey getPublicKey() {
        return this.publicKey;
    }

    public byte[] getQ() {
        byte[] bArr = new byte[34];
        this.digest.doFinal(bArr, 0);
        this.digest = null;
        return bArr;
    }

    public LMSigParameters getSigParams() {
        return this.sigParams;
    }

    public Object getSignature() {
        return this.signature;
    }

    public LMSSignedPubKey[] getSignedPubKeys() {
        return this.signedPubKeys;
    }

    public void reset() {
        this.digest.reset();
    }

    public void update(byte b11) {
        this.digest.update(b11);
    }

    public void update(byte[] bArr, int i11, int i12) {
        this.digest.update(bArr, i11, i12);
    }

    public LMSContext withSignedPublicKeys(LMSSignedPubKey[] lMSSignedPubKeyArr) {
        this.signedPubKeys = lMSSignedPubKeyArr;
        return this;
    }
}
