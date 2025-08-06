package org.bouncycastle.pqc.crypto.lms;

import java.util.Arrays;
import java.util.List;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;

class HSS {

    public static class PlaceholderLMSPrivateKey extends LMSPrivateKeyParameters {
        public PlaceholderLMSPrivateKey(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i11, byte[] bArr, int i12, byte[] bArr2) {
            super(lMSigParameters, lMOtsParameters, i11, bArr, i12, bArr2);
        }

        public LMOtsPrivateKey getNextOtsPrivateKey() {
            throw new RuntimeException("placeholder only");
        }

        public LMSPublicKeyParameters getPublicKey() {
            throw new RuntimeException("placeholder only");
        }
    }

    public static HSSPrivateKeyParameters generateHSSKeyPair(HSSKeyGenerationParameters hSSKeyGenerationParameters) {
        int i11;
        byte[] bArr;
        int depth = hSSKeyGenerationParameters.getDepth();
        LMSPrivateKeyParameters[] lMSPrivateKeyParametersArr = new LMSPrivateKeyParameters[depth];
        LMSSignature[] lMSSignatureArr = new LMSSignature[(hSSKeyGenerationParameters.getDepth() - 1)];
        byte[] bArr2 = new byte[32];
        hSSKeyGenerationParameters.getRandom().nextBytes(bArr2);
        byte[] bArr3 = new byte[16];
        hSSKeyGenerationParameters.getRandom().nextBytes(bArr3);
        byte[] bArr4 = new byte[0];
        int i12 = 0;
        long j11 = 1;
        while (i12 < depth) {
            if (i12 == 0) {
                lMSPrivateKeyParametersArr[i12] = new LMSPrivateKeyParameters(hSSKeyGenerationParameters.getLmsParameters()[i12].getLMSigParam(), hSSKeyGenerationParameters.getLmsParameters()[i12].getLMOTSParam(), 0, bArr3, 1 << hSSKeyGenerationParameters.getLmsParameters()[i12].getLMSigParam().getH(), bArr2);
                i11 = i12;
                bArr = bArr4;
            } else {
                LMSigParameters lMSigParam = hSSKeyGenerationParameters.getLmsParameters()[i12].getLMSigParam();
                LMOtsParameters lMOTSParam = hSSKeyGenerationParameters.getLmsParameters()[i12].getLMOTSParam();
                int h11 = 1 << hSSKeyGenerationParameters.getLmsParameters()[i12].getLMSigParam().getH();
                i11 = i12;
                LMSigParameters lMSigParameters = lMSigParam;
                bArr = bArr4;
                lMSPrivateKeyParametersArr[i11] = new PlaceholderLMSPrivateKey(lMSigParameters, lMOTSParam, -1, bArr, h11, bArr);
            }
            j11 *= (long) (1 << hSSKeyGenerationParameters.getLmsParameters()[i11].getLMSigParam().getH());
            i12 = i11 + 1;
            bArr4 = bArr;
        }
        if (j11 == 0) {
            j11 = Long.MAX_VALUE;
        }
        return new HSSPrivateKeyParameters(hSSKeyGenerationParameters.getDepth(), Arrays.asList(lMSPrivateKeyParametersArr), Arrays.asList(lMSSignatureArr), 0, j11);
    }

    public static HSSSignature generateSignature(int i11, LMSContext lMSContext) {
        return new HSSSignature(i11 - 1, lMSContext.getSignedPubKeys(), LMS.generateSign(lMSContext));
    }

    public static HSSSignature generateSignature(HSSPrivateKeyParameters hSSPrivateKeyParameters, byte[] bArr) {
        LMSPrivateKeyParameters lMSPrivateKeyParameters;
        LMSSignedPubKey[] lMSSignedPubKeyArr;
        int l11 = hSSPrivateKeyParameters.getL();
        synchronized (hSSPrivateKeyParameters) {
            rangeTestKeys(hSSPrivateKeyParameters);
            List<LMSPrivateKeyParameters> keys = hSSPrivateKeyParameters.getKeys();
            List<LMSSignature> sig = hSSPrivateKeyParameters.getSig();
            int i11 = l11 - 1;
            lMSPrivateKeyParameters = hSSPrivateKeyParameters.getKeys().get(i11);
            lMSSignedPubKeyArr = new LMSSignedPubKey[i11];
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                lMSSignedPubKeyArr[i12] = new LMSSignedPubKey(sig.get(i12), keys.get(i13).getPublicKey());
                i12 = i13;
            }
            hSSPrivateKeyParameters.incIndex();
        }
        LMSContext withSignedPublicKeys = lMSPrivateKeyParameters.generateLMSContext().withSignedPublicKeys(lMSSignedPubKeyArr);
        withSignedPublicKeys.update(bArr, 0, bArr.length);
        return generateSignature(l11, withSignedPublicKeys);
    }

    public static void incrementIndex(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        synchronized (hSSPrivateKeyParameters) {
            rangeTestKeys(hSSPrivateKeyParameters);
            hSSPrivateKeyParameters.incIndex();
            hSSPrivateKeyParameters.getKeys().get(hSSPrivateKeyParameters.getL() - 1).incIndex();
        }
    }

    public static void rangeTestKeys(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        synchronized (hSSPrivateKeyParameters) {
            if (hSSPrivateKeyParameters.getIndex() >= hSSPrivateKeyParameters.getIndexLimit()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("hss private key");
                sb2.append(hSSPrivateKeyParameters.isShard() ? " shard" : "");
                sb2.append(" is exhausted");
                throw new ExhaustedPrivateKeyException(sb2.toString());
            }
            int l11 = hSSPrivateKeyParameters.getL();
            List<LMSPrivateKeyParameters> keys = hSSPrivateKeyParameters.getKeys();
            int i11 = l11;
            while (true) {
                int i12 = i11 - 1;
                if (keys.get(i12).getIndex() != (1 << keys.get(i12).getSigParameters().getH())) {
                    while (i11 < l11) {
                        hSSPrivateKeyParameters.replaceConsumedKey(i11);
                        i11++;
                    }
                } else if (i12 == 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("hss private key");
                    sb3.append(hSSPrivateKeyParameters.isShard() ? " shard" : "");
                    sb3.append(" is exhausted the maximum limit for this HSS private key");
                    throw new ExhaustedPrivateKeyException(sb3.toString());
                } else {
                    i11 = i12;
                }
            }
        }
    }

    public static boolean verifySignature(HSSPublicKeyParameters hSSPublicKeyParameters, HSSSignature hSSSignature, byte[] bArr) {
        int i11 = hSSSignature.getlMinus1();
        int i12 = i11 + 1;
        if (i12 != hSSPublicKeyParameters.getL()) {
            return false;
        }
        LMSSignature[] lMSSignatureArr = new LMSSignature[i12];
        LMSPublicKeyParameters[] lMSPublicKeyParametersArr = new LMSPublicKeyParameters[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            lMSSignatureArr[i13] = hSSSignature.getSignedPubKey()[i13].getSignature();
            lMSPublicKeyParametersArr[i13] = hSSSignature.getSignedPubKey()[i13].getPublicKey();
        }
        lMSSignatureArr[i11] = hSSSignature.getSignature();
        LMSPublicKeyParameters lMSPublicKey = hSSPublicKeyParameters.getLMSPublicKey();
        int i14 = 0;
        while (i14 < i11) {
            if (!LMS.verifySignature(lMSPublicKey, lMSSignatureArr[i14], lMSPublicKeyParametersArr[i14].toByteArray())) {
                return false;
            }
            try {
                lMSPublicKey = lMSPublicKeyParametersArr[i14];
                i14++;
            } catch (Exception e11) {
                throw new IllegalStateException(e11.getMessage(), e11);
            }
        }
        return LMS.verifySignature(lMSPublicKey, lMSSignatureArr[i11], bArr);
    }
}
