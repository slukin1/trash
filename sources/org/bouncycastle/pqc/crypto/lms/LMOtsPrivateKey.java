package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

class LMOtsPrivateKey {
    private final byte[] I;
    private final byte[] masterSecret;
    private final LMOtsParameters parameter;

    /* renamed from: q  reason: collision with root package name */
    private final int f59541q;

    public LMOtsPrivateKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i11, byte[] bArr2) {
        this.parameter = lMOtsParameters;
        this.I = bArr;
        this.f59541q = i11;
        this.masterSecret = bArr2;
    }

    public SeedDerive getDerivationFunction() {
        SeedDerive seedDerive = new SeedDerive(this.I, this.masterSecret, DigestUtil.getDigest(this.parameter.getDigestOID()));
        seedDerive.setQ(this.f59541q);
        return seedDerive;
    }

    public byte[] getI() {
        return this.I;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.f59541q;
    }

    public LMSContext getSignatureContext(LMSigParameters lMSigParameters, byte[][] bArr) {
        byte[] bArr2 = new byte[32];
        SeedDerive derivationFunction = getDerivationFunction();
        derivationFunction.setJ(-3);
        derivationFunction.deriveSeed(bArr2, false);
        Digest digest = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(getI(), digest);
        LmsUtils.u32str(getQ(), digest);
        LmsUtils.u16str(LM_OTS.D_MESG, digest);
        LmsUtils.byteArray(bArr2, digest);
        return new LMSContext(this, lMSigParameters, digest, bArr2, bArr);
    }
}
