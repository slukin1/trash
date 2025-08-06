package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

class LMS {
    public static final short D_INTR = -31869;
    public static final short D_LEAF = -32126;

    public static LMSPrivateKeyParameters generateKeys(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i11, byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        if (bArr2 == null || bArr2.length < lMSigParameters.getM()) {
            throw new IllegalArgumentException("root seed is less than " + lMSigParameters.getM());
        }
        return new LMSPrivateKeyParameters(lMSigParameters, lMOtsParameters, i11, bArr, 1 << lMSigParameters.getH(), bArr2);
    }

    public static LMSSignature generateSign(LMSContext lMSContext) {
        return new LMSSignature(lMSContext.getPrivateKey().getQ(), LM_OTS.lm_ots_generate_signature(lMSContext.getPrivateKey(), lMSContext.getQ(), lMSContext.getC()), lMSContext.getSigParams(), lMSContext.getPath());
    }

    public static LMSSignature generateSign(LMSPrivateKeyParameters lMSPrivateKeyParameters, byte[] bArr) {
        LMSContext generateLMSContext = lMSPrivateKeyParameters.generateLMSContext();
        generateLMSContext.update(bArr, 0, bArr.length);
        return generateSign(generateLMSContext);
    }

    public static boolean verifySignature(LMSPublicKeyParameters lMSPublicKeyParameters, LMSContext lMSContext) {
        LMSSignature lMSSignature = (LMSSignature) lMSContext.getSignature();
        LMSigParameters parameter = lMSSignature.getParameter();
        int h11 = parameter.getH();
        byte[][] y11 = lMSSignature.getY();
        byte[] lm_ots_validate_signature_calculate = LM_OTS.lm_ots_validate_signature_calculate(lMSContext);
        int q11 = (1 << h11) + lMSSignature.getQ();
        byte[] i11 = lMSPublicKeyParameters.getI();
        Digest digest = DigestUtil.getDigest(parameter.getDigestOID());
        int digestSize = digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        digest.update(i11, 0, i11.length);
        LmsUtils.u32str(q11, digest);
        LmsUtils.u16str(D_LEAF, digest);
        digest.update(lm_ots_validate_signature_calculate, 0, lm_ots_validate_signature_calculate.length);
        digest.doFinal(bArr, 0);
        int i12 = 0;
        while (q11 > 1) {
            if ((q11 & 1) == 1) {
                digest.update(i11, 0, i11.length);
                LmsUtils.u32str(q11 / 2, digest);
                LmsUtils.u16str(D_INTR, digest);
                digest.update(y11[i12], 0, y11[i12].length);
                digest.update(bArr, 0, digestSize);
            } else {
                digest.update(i11, 0, i11.length);
                LmsUtils.u32str(q11 / 2, digest);
                LmsUtils.u16str(D_INTR, digest);
                digest.update(bArr, 0, digestSize);
                digest.update(y11[i12], 0, y11[i12].length);
            }
            digest.doFinal(bArr, 0);
            q11 /= 2;
            i12++;
        }
        return lMSPublicKeyParameters.matchesT1(bArr);
    }

    public static boolean verifySignature(LMSPublicKeyParameters lMSPublicKeyParameters, LMSSignature lMSSignature, byte[] bArr) {
        LMSContext generateOtsContext = lMSPublicKeyParameters.generateOtsContext(lMSSignature);
        LmsUtils.byteArray(bArr, generateOtsContext);
        return verifySignature(lMSPublicKeyParameters, generateOtsContext);
    }

    public static boolean verifySignature(LMSPublicKeyParameters lMSPublicKeyParameters, byte[] bArr, byte[] bArr2) {
        LMSContext generateLMSContext = lMSPublicKeyParameters.generateLMSContext(bArr);
        LmsUtils.byteArray(bArr2, generateLMSContext);
        return verifySignature(lMSPublicKeyParameters, generateLMSContext);
    }
}
