package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

class LM_OTS {
    public static final short D_MESG = -32383;
    private static final short D_PBLC = -32640;
    private static final int ITER_J = 22;
    private static final int ITER_K = 20;
    private static final int ITER_PREV = 23;
    public static final int MAX_HASH = 32;
    public static final int SEED_LEN = 32;
    public static final int SEED_RANDOMISER_INDEX = -3;

    public static int cksm(byte[] bArr, int i11, LMOtsParameters lMOtsParameters) {
        int w11 = (1 << lMOtsParameters.getW()) - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < (i11 * 8) / lMOtsParameters.getW(); i13++) {
            i12 = (i12 + w11) - coef(bArr, i13, lMOtsParameters.getW());
        }
        return i12 << lMOtsParameters.getLs();
    }

    public static int coef(byte[] bArr, int i11, int i12) {
        return (bArr[(i11 * i12) / 8] >>> (((~i11) & ((8 / i12) - 1)) * i12)) & ((1 << i12) - 1);
    }

    public static LMOtsSignature lm_ots_generate_signature(LMOtsPrivateKey lMOtsPrivateKey, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        LMOtsParameters parameter = lMOtsPrivateKey.getParameter();
        int n11 = parameter.getN();
        int p11 = parameter.getP();
        int w11 = parameter.getW();
        byte[] bArr4 = new byte[(p11 * n11)];
        Digest digest = DigestUtil.getDigest(parameter.getDigestOID());
        SeedDerive derivationFunction = lMOtsPrivateKey.getDerivationFunction();
        int cksm = cksm(bArr3, n11, parameter);
        bArr3[n11] = (byte) ((cksm >>> 8) & 255);
        bArr3[n11 + 1] = (byte) cksm;
        int i11 = n11 + 23;
        byte[] build = Composer.compose().bytes(lMOtsPrivateKey.getI()).u32str(lMOtsPrivateKey.getQ()).padUntil(0, i11).build();
        derivationFunction.setJ(0);
        int i12 = 0;
        while (i12 < p11) {
            Pack.shortToBigEndian((short) i12, build, 20);
            int i13 = 23;
            derivationFunction.deriveSeed(build, i12 < p11 + -1, 23);
            int coef = coef(bArr3, i12, w11);
            for (int i14 = 0; i14 < coef; i14++) {
                build[22] = (byte) i14;
                digest.update(build, 0, i11);
                i13 = 23;
                digest.doFinal(build, 23);
            }
            System.arraycopy(build, i13, bArr4, n11 * i12, n11);
            i12++;
        }
        return new LMOtsSignature(parameter, bArr2, bArr4);
    }

    public static LMOtsSignature lm_ots_generate_signature(LMSigParameters lMSigParameters, LMOtsPrivateKey lMOtsPrivateKey, byte[][] bArr, byte[] bArr2, boolean z11) {
        byte[] bArr3;
        byte[] bArr4 = new byte[34];
        if (!z11) {
            LMSContext signatureContext = lMOtsPrivateKey.getSignatureContext(lMSigParameters, bArr);
            LmsUtils.byteArray(bArr2, 0, bArr2.length, signatureContext);
            bArr3 = signatureContext.getC();
            bArr4 = signatureContext.getQ();
        } else {
            bArr3 = new byte[32];
            System.arraycopy(bArr2, 0, bArr4, 0, lMOtsPrivateKey.getParameter().getN());
        }
        return lm_ots_generate_signature(lMOtsPrivateKey, bArr4, bArr3);
    }

    public static boolean lm_ots_validate_signature(LMOtsPublicKey lMOtsPublicKey, LMOtsSignature lMOtsSignature, byte[] bArr, boolean z11) throws LMSException {
        if (lMOtsSignature.getType().equals(lMOtsPublicKey.getParameter())) {
            return Arrays.areEqual(lm_ots_validate_signature_calculate(lMOtsPublicKey, lMOtsSignature, bArr), lMOtsPublicKey.getK());
        }
        throw new LMSException("public key and signature ots types do not match");
    }

    public static byte[] lm_ots_validate_signature_calculate(LMOtsPublicKey lMOtsPublicKey, LMOtsSignature lMOtsSignature, byte[] bArr) {
        LMSContext createOtsContext = lMOtsPublicKey.createOtsContext(lMOtsSignature);
        LmsUtils.byteArray(bArr, createOtsContext);
        return lm_ots_validate_signature_calculate(createOtsContext);
    }

    public static byte[] lm_ots_validate_signature_calculate(LMSContext lMSContext) {
        LMOtsPublicKey publicKey = lMSContext.getPublicKey();
        LMOtsParameters parameter = publicKey.getParameter();
        Object signature = lMSContext.getSignature();
        LMOtsSignature otsSignature = signature instanceof LMSSignature ? ((LMSSignature) signature).getOtsSignature() : (LMOtsSignature) signature;
        int n11 = parameter.getN();
        int w11 = parameter.getW();
        int p11 = parameter.getP();
        byte[] q11 = lMSContext.getQ();
        int cksm = cksm(q11, n11, parameter);
        q11[n11] = (byte) ((cksm >>> 8) & 255);
        q11[n11 + 1] = (byte) cksm;
        byte[] i11 = publicKey.getI();
        int q12 = publicKey.getQ();
        Digest digest = DigestUtil.getDigest(parameter.getDigestOID());
        LmsUtils.byteArray(i11, digest);
        LmsUtils.u32str(q12, digest);
        LmsUtils.u16str(D_PBLC, digest);
        Composer u32str = Composer.compose().bytes(i11).u32str(q12);
        int i12 = n11 + 23;
        byte[] build = u32str.padUntil(0, i12).build();
        int i13 = (1 << w11) - 1;
        byte[] y11 = otsSignature.getY();
        Digest digest2 = DigestUtil.getDigest(parameter.getDigestOID());
        for (int i14 = 0; i14 < p11; i14++) {
            Pack.shortToBigEndian((short) i14, build, 20);
            System.arraycopy(y11, i14 * n11, build, 23, n11);
            for (int coef = coef(q11, i14, w11); coef < i13; coef++) {
                build[22] = (byte) coef;
                digest2.update(build, 0, i12);
                digest2.doFinal(build, 23);
            }
            digest.update(build, 23, n11);
        }
        byte[] bArr = new byte[n11];
        digest.doFinal(bArr, 0);
        return bArr;
    }

    public static LMOtsPublicKey lms_ots_generatePublicKey(LMOtsPrivateKey lMOtsPrivateKey) {
        return new LMOtsPublicKey(lMOtsPrivateKey.getParameter(), lMOtsPrivateKey.getI(), lMOtsPrivateKey.getQ(), lms_ots_generatePublicKey(lMOtsPrivateKey.getParameter(), lMOtsPrivateKey.getI(), lMOtsPrivateKey.getQ(), lMOtsPrivateKey.getMasterSecret()));
    }

    public static byte[] lms_ots_generatePublicKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i11, byte[] bArr2) {
        Digest digest = DigestUtil.getDigest(lMOtsParameters.getDigestOID());
        byte[] build = Composer.compose().bytes(bArr).u32str(i11).u16str(-32640).padUntil(0, 22).build();
        digest.update(build, 0, build.length);
        Digest digest2 = DigestUtil.getDigest(lMOtsParameters.getDigestOID());
        byte[] build2 = Composer.compose().bytes(bArr).u32str(i11).padUntil(0, digest2.getDigestSize() + 23).build();
        SeedDerive seedDerive = new SeedDerive(bArr, bArr2, DigestUtil.getDigest(lMOtsParameters.getDigestOID()));
        seedDerive.setQ(i11);
        seedDerive.setJ(0);
        int p11 = lMOtsParameters.getP();
        int n11 = lMOtsParameters.getN();
        int w11 = (1 << lMOtsParameters.getW()) - 1;
        int i12 = 0;
        while (i12 < p11) {
            seedDerive.deriveSeed(build2, i12 < p11 + -1, 23);
            Pack.shortToBigEndian((short) i12, build2, 20);
            for (int i13 = 0; i13 < w11; i13++) {
                build2[22] = (byte) i13;
                digest2.update(build2, 0, build2.length);
                digest2.doFinal(build2, 23);
            }
            digest.update(build2, 23, n11);
            i12++;
        }
        byte[] bArr3 = new byte[digest.getDigestSize()];
        digest.doFinal(bArr3, 0);
        return bArr3;
    }
}
