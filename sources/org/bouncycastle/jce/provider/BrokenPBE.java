package org.bouncycastle.jce.provider;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;

public interface BrokenPBE {
    public static final int MD5 = 0;
    public static final int OLD_PKCS12 = 3;
    public static final int PKCS12 = 2;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S2 = 1;
    public static final int RIPEMD160 = 2;
    public static final int SHA1 = 1;

    public static class Util {
        private static PBEParametersGenerator makePBEGenerator(int i11, int i12) {
            if (i11 == 0) {
                if (i12 == 0) {
                    return new PKCS5S1ParametersGenerator(new MD5Digest());
                }
                if (i12 == 1) {
                    return new PKCS5S1ParametersGenerator(new SHA1Digest());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports only MD5 and SHA1.");
            } else if (i11 == 1) {
                return new PKCS5S2ParametersGenerator();
            } else {
                if (i11 == 3) {
                    if (i12 == 0) {
                        return new OldPKCS12ParametersGenerator(new MD5Digest());
                    }
                    if (i12 == 1) {
                        return new OldPKCS12ParametersGenerator(new SHA1Digest());
                    }
                    if (i12 == 2) {
                        return new OldPKCS12ParametersGenerator(new RIPEMD160Digest());
                    }
                    throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                } else if (i12 == 0) {
                    return new PKCS12ParametersGenerator(new MD5Digest());
                } else {
                    if (i12 == 1) {
                        return new PKCS12ParametersGenerator(new SHA1Digest());
                    }
                    if (i12 == 2) {
                        return new PKCS12ParametersGenerator(new RIPEMD160Digest());
                    }
                    throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                }
            }
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, int i11, int i12, int i13) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i11, i12);
            byte[] encoded = bCPBEKey.getEncoded();
            makePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters generateDerivedMacParameters = makePBEGenerator.generateDerivedMacParameters(i13);
            for (int i14 = 0; i14 != encoded.length; i14++) {
                encoded[i14] = 0;
            }
            return generateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, int i11, int i12, String str, int i13, int i14) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i11, i12);
            byte[] encoded = bCPBEKey.getEncoded();
            makePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters generateDerivedParameters = i14 != 0 ? makePBEGenerator.generateDerivedParameters(i13, i14) : makePBEGenerator.generateDerivedParameters(i13);
            if (str.startsWith("DES")) {
                if (generateDerivedParameters instanceof ParametersWithIV) {
                    setOddParity(((KeyParameter) ((ParametersWithIV) generateDerivedParameters).getParameters()).getKey());
                } else {
                    setOddParity(((KeyParameter) generateDerivedParameters).getKey());
                }
            }
            for (int i15 = 0; i15 != encoded.length; i15++) {
                encoded[i15] = 0;
            }
            return generateDerivedParameters;
        }

        private static void setOddParity(byte[] bArr) {
            for (int i11 = 0; i11 < bArr.length; i11++) {
                byte b11 = bArr[i11];
                bArr[i11] = (byte) ((((b11 >> 7) ^ ((((((b11 >> 1) ^ (b11 >> 2)) ^ (b11 >> 3)) ^ (b11 >> 4)) ^ (b11 >> 5)) ^ (b11 >> 6))) ^ 1) | (b11 & 254));
            }
        }
    }
}
