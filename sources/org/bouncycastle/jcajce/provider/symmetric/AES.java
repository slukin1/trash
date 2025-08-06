package org.bouncycastle.jcajce.provider.symmetric;

import com.google.android.gms.stats.CodePackage;
import com.sumsub.sns.prooface.network.b;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.AESWrapEngine;
import org.bouncycastle.crypto.engines.AESWrapPadEngine;
import org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import org.bouncycastle.crypto.engines.RFC5649WrapEngine;
import org.bouncycastle.crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.macs.GMac;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.internal.asn1.cms.CCMParameters;
import org.bouncycastle.internal.asn1.cms.GCMParameters;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.GcmSpecUtil;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.bouncycastle.jcajce.spec.AEADParameterSpec;

public final class AES {
    /* access modifiers changed from: private */
    public static final Map<String, String> generalAesAttributes;

    public static class AESCCMMAC extends BaseMac {

        public static class CCMMac implements Mac {
            private final CCMBlockCipher ccm;
            private int macLength;

            private CCMMac() {
                this.ccm = new CCMBlockCipher(new AESEngine());
                this.macLength = 8;
            }

            public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
                try {
                    return this.ccm.doFinal(bArr, 0);
                } catch (InvalidCipherTextException e11) {
                    throw new IllegalStateException("exception on doFinal(): " + e11.toString());
                }
            }

            public String getAlgorithmName() {
                return this.ccm.getAlgorithmName() + "Mac";
            }

            public int getMacSize() {
                return this.macLength;
            }

            public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
                this.ccm.init(true, cipherParameters);
                this.macLength = this.ccm.getMac().length;
            }

            public void reset() {
                this.ccm.reset();
            }

            public void update(byte b11) throws IllegalStateException {
                this.ccm.processAADByte(b11);
            }

            public void update(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalStateException {
                this.ccm.processAADBytes(bArr, i11, i12);
            }
        }

        public AESCCMMAC() {
            super(new CCMMac());
        }
    }

    public static class AESCMAC extends BaseMac {
        public AESCMAC() {
            super(new CMac(new AESEngine()));
        }
    }

    public static class AESGMAC extends BaseMac {
        public AESGMAC() {
            super(new GMac(new GCMBlockCipher(new AESEngine())));
        }
    }

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance(b.f40261d);
                createParametersInstance.init(new IvParameterSpec(bArr));
                return createParametersInstance;
            } catch (Exception e11) {
                throw new RuntimeException(e11.getMessage());
            }
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParamGenCCM extends BaseAlgorithmParameterGenerator {
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("CCM");
                createParametersInstance.init(new CCMParameters(bArr, 12).getEncoded());
                return createParametersInstance;
            } catch (Exception e11) {
                throw new RuntimeException(e11.getMessage());
            }
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParamGenGCM extends BaseAlgorithmParameterGenerator {
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance(CodePackage.GCM);
                createParametersInstance.init(new GCMParameters(bArr, 16).getEncoded());
                return createParametersInstance;
            } catch (Exception e11) {
                throw new RuntimeException(e11.getMessage());
            }
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "AES IV";
        }
    }

    public static class AlgParamsCCM extends BaseAlgorithmParameters {
        private CCMParameters ccmParams;

        public byte[] engineGetEncoded() throws IOException {
            return this.ccmParams.getEncoded();
        }

        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return this.ccmParams.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (GcmSpecUtil.isGcmSpec(algorithmParameterSpec)) {
                this.ccmParams = CCMParameters.getInstance(GcmSpecUtil.extractGcmParameters(algorithmParameterSpec));
            } else if (algorithmParameterSpec instanceof AEADParameterSpec) {
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
                this.ccmParams = new CCMParameters(aEADParameterSpec.getNonce(), aEADParameterSpec.getMacSizeInBits() / 8);
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
            }
        }

        public void engineInit(byte[] bArr) throws IOException {
            this.ccmParams = CCMParameters.getInstance(bArr);
        }

        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                this.ccmParams = CCMParameters.getInstance(bArr);
                return;
            }
            throw new IOException("unknown format specified");
        }

        public String engineToString() {
            return "CCM";
        }

        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == AlgorithmParameterSpec.class || GcmSpecUtil.isGcmSpec(cls)) {
                return GcmSpecUtil.gcmSpecExists() ? GcmSpecUtil.extractGcmSpec(this.ccmParams.toASN1Primitive()) : new AEADParameterSpec(this.ccmParams.getNonce(), this.ccmParams.getIcvLen() * 8);
            }
            if (cls == AEADParameterSpec.class) {
                return new AEADParameterSpec(this.ccmParams.getNonce(), this.ccmParams.getIcvLen() * 8);
            }
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.ccmParams.getNonce());
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }
    }

    public static class AlgParamsGCM extends BaseAlgorithmParameters {
        private GCMParameters gcmParams;

        public byte[] engineGetEncoded() throws IOException {
            return this.gcmParams.getEncoded();
        }

        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return this.gcmParams.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (GcmSpecUtil.isGcmSpec(algorithmParameterSpec)) {
                this.gcmParams = GcmSpecUtil.extractGcmParameters(algorithmParameterSpec);
            } else if (algorithmParameterSpec instanceof AEADParameterSpec) {
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
                this.gcmParams = new GCMParameters(aEADParameterSpec.getNonce(), aEADParameterSpec.getMacSizeInBits() / 8);
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
            }
        }

        public void engineInit(byte[] bArr) throws IOException {
            this.gcmParams = GCMParameters.getInstance(bArr);
        }

        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                this.gcmParams = GCMParameters.getInstance(bArr);
                return;
            }
            throw new IOException("unknown format specified");
        }

        public String engineToString() {
            return CodePackage.GCM;
        }

        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == AlgorithmParameterSpec.class || GcmSpecUtil.isGcmSpec(cls)) {
                return GcmSpecUtil.gcmSpecExists() ? GcmSpecUtil.extractGcmSpec(this.gcmParams.toASN1Primitive()) : new AEADParameterSpec(this.gcmParams.getNonce(), this.gcmParams.getIcvLen() * 8);
            }
            if (cls == AEADParameterSpec.class) {
                return new AEADParameterSpec(this.gcmParams.getNonce(), this.gcmParams.getIcvLen() * 8);
            }
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.gcmParams.getNonce());
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new AESEngine()), 128);
        }
    }

    public static class CCM extends BaseBlockCipher {
        public CCM() {
            super((AEADBlockCipher) new CCMBlockCipher(new AESEngine()), false, 12);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new AESEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public BlockCipher get() {
                    return new AESEngine();
                }
            });
        }
    }

    public static class GCM extends BaseBlockCipher {
        public GCM() {
            super((AEADBlockCipher) new GCMBlockCipher(new AESEngine()));
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super(b.f40261d, (ASN1ObjectIdentifier) null);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(192);
        }

        public KeyGen(int i11) {
            super(b.f40261d, i11, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen192 extends KeyGen {
        public KeyGen192() {
            super(192);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        private static final String PREFIX = AES.class.getName();
        private static final String wrongAES128 = "2.16.840.1.101.3.4.2";
        private static final String wrongAES192 = "2.16.840.1.101.3.4.22";
        private static final String wrongAES256 = "2.16.840.1.101.3.4.42";

        public void configure(ConfigurableProvider configurableProvider) {
            ConfigurableProvider configurableProvider2 = configurableProvider;
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$AlgParams");
            configurableProvider2.addAlgorithm("AlgorithmParameters.AES", sb2.toString());
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", b.f40261d);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes128_CBC;
            sb3.append(aSN1ObjectIdentifier);
            configurableProvider2.addAlgorithm(sb3.toString(), b.f40261d);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes192_CBC;
            sb4.append(aSN1ObjectIdentifier2);
            configurableProvider2.addAlgorithm(sb4.toString(), b.f40261d);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes256_CBC;
            sb5.append(aSN1ObjectIdentifier3);
            configurableProvider2.addAlgorithm(sb5.toString(), b.f40261d);
            configurableProvider2.addAlgorithm("AlgorithmParameters.GCM", str + "$AlgParamsGCM");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_aes128_GCM;
            sb6.append(aSN1ObjectIdentifier4);
            configurableProvider2.addAlgorithm(sb6.toString(), CodePackage.GCM);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_aes192_GCM;
            sb7.append(aSN1ObjectIdentifier5);
            configurableProvider2.addAlgorithm(sb7.toString(), CodePackage.GCM);
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_aes256_GCM;
            sb8.append(aSN1ObjectIdentifier6);
            configurableProvider2.addAlgorithm(sb8.toString(), CodePackage.GCM);
            configurableProvider2.addAlgorithm("AlgorithmParameters.CCM", str + "$AlgParamsCCM");
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_aes128_CCM;
            sb9.append(aSN1ObjectIdentifier7);
            configurableProvider2.addAlgorithm(sb9.toString(), "CCM");
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_aes192_CCM;
            sb10.append(aSN1ObjectIdentifier8);
            configurableProvider2.addAlgorithm(sb10.toString(), "CCM");
            StringBuilder sb11 = new StringBuilder();
            sb11.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_aes256_CCM;
            sb11.append(aSN1ObjectIdentifier9);
            configurableProvider2.addAlgorithm(sb11.toString(), "CCM");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator.AES", str + "$AlgParamGen");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier2, b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier3, b.f40261d);
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = aSN1ObjectIdentifier6;
            configurableProvider2.addAttributes("Cipher.AES", AES.generalAesAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = aSN1ObjectIdentifier5;
            configurableProvider2.addAlgorithm("Cipher.AES", str + "$ECB");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", b.f40261d);
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", b.f40261d);
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.id_aes128_ECB;
            String str2 = b.f40261d;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier12, str + "$ECB");
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.id_aes192_ECB;
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = aSN1ObjectIdentifier12;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier13, str + "$ECB");
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NISTObjectIdentifiers.id_aes256_ECB;
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier13;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier15, str + "$ECB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier, str + "$CBC");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier2, str + "$CBC");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier3, str + "$CBC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = NISTObjectIdentifiers.id_aes128_OFB;
            StringBuilder sb12 = new StringBuilder();
            sb12.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier3;
            sb12.append("$OFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier17, sb12.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = NISTObjectIdentifiers.id_aes192_OFB;
            StringBuilder sb13 = new StringBuilder();
            sb13.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier15;
            sb13.append("$OFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier19, sb13.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = NISTObjectIdentifiers.id_aes256_OFB;
            StringBuilder sb14 = new StringBuilder();
            sb14.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier19;
            sb14.append("$OFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier21, sb14.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = NISTObjectIdentifiers.id_aes128_CFB;
            StringBuilder sb15 = new StringBuilder();
            sb15.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier21;
            sb15.append("$CFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier23, sb15.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier25 = NISTObjectIdentifiers.id_aes192_CFB;
            StringBuilder sb16 = new StringBuilder();
            sb16.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier2;
            sb16.append("$CFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier25, sb16.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier27 = NISTObjectIdentifiers.id_aes256_CFB;
            StringBuilder sb17 = new StringBuilder();
            sb17.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier28 = aSN1ObjectIdentifier25;
            sb17.append("$CFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier27, sb17.toString());
            configurableProvider2.addAttributes("Cipher.AESWRAP", AES.generalAesAttributes);
            configurableProvider2.addAlgorithm("Cipher.AESWRAP", str + "$Wrap");
            ASN1ObjectIdentifier aSN1ObjectIdentifier29 = NISTObjectIdentifiers.id_aes128_wrap;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier29, "AESWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier29;
            ASN1ObjectIdentifier aSN1ObjectIdentifier31 = NISTObjectIdentifiers.id_aes192_wrap;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier31, "AESWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier32 = aSN1ObjectIdentifier31;
            ASN1ObjectIdentifier aSN1ObjectIdentifier33 = NISTObjectIdentifiers.id_aes256_wrap;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier33, "AESWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier34 = aSN1ObjectIdentifier33;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.AESKW", "AESWRAP");
            configurableProvider2.addAttributes("Cipher.AESWRAPPAD", AES.generalAesAttributes);
            configurableProvider2.addAlgorithm("Cipher.AESWRAPPAD", str + "$WrapPad");
            ASN1ObjectIdentifier aSN1ObjectIdentifier35 = NISTObjectIdentifiers.id_aes128_wrap_pad;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier35, "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier36 = aSN1ObjectIdentifier35;
            ASN1ObjectIdentifier aSN1ObjectIdentifier37 = NISTObjectIdentifiers.id_aes192_wrap_pad;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier37, "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier38 = aSN1ObjectIdentifier37;
            ASN1ObjectIdentifier aSN1ObjectIdentifier39 = NISTObjectIdentifiers.id_aes256_wrap_pad;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier39, "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier40 = aSN1ObjectIdentifier39;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.AESKWP", "AESWRAPPAD");
            configurableProvider2.addAlgorithm("Cipher.AESRFC3211WRAP", str + "$RFC3211Wrap");
            configurableProvider2.addAlgorithm("Cipher.AESRFC5649WRAP", str + "$RFC5649Wrap");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator.CCM", str + "$AlgParamGenCCM");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier7, "CCM");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier8, "CCM");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier9, "CCM");
            configurableProvider2.addAttributes("Cipher.CCM", AES.generalAesAttributes);
            configurableProvider2.addAlgorithm("Cipher.CCM", str + "$CCM");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier7, "CCM");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier8, "CCM");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier9, "CCM");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator.GCM", str + "$AlgParamGenGCM");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier4, CodePackage.GCM);
            StringBuilder sb18 = new StringBuilder();
            sb18.append("Alg.Alias.AlgorithmParameterGenerator.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier41 = aSN1ObjectIdentifier11;
            sb18.append(aSN1ObjectIdentifier41);
            configurableProvider2.addAlgorithm(sb18.toString(), CodePackage.GCM);
            StringBuilder sb19 = new StringBuilder();
            sb19.append("Alg.Alias.AlgorithmParameterGenerator.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier42 = aSN1ObjectIdentifier10;
            sb19.append(aSN1ObjectIdentifier42);
            configurableProvider2.addAlgorithm(sb19.toString(), CodePackage.GCM);
            configurableProvider2.addAttributes("Cipher.GCM", AES.generalAesAttributes);
            configurableProvider2.addAlgorithm("Cipher.GCM", str + "$GCM");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier4, CodePackage.GCM);
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier41, CodePackage.GCM);
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier42, CodePackage.GCM);
            configurableProvider2.addAlgorithm("KeyGenerator.AES", str + "$KeyGen");
            configurableProvider2.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.2", str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.22", str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.42", str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier14, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier17, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier23, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier16, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier26, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier22, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier28, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier20, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier18, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier24, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier27, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator.AESWRAP", str + "$KeyGen");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier30, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier32, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier34, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier4, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier41, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier42, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier7, str + "$KeyGen128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier43 = aSN1ObjectIdentifier8;
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier43, str + "$KeyGen192");
            ASN1ObjectIdentifier aSN1ObjectIdentifier44 = aSN1ObjectIdentifier9;
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier44, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator.AESWRAPPAD", str + "$KeyGen");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier36, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier38, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier40, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("Mac.AESCMAC", str + "$AESCMAC");
            configurableProvider2.addAlgorithm("Mac.AESCCMMAC", str + "$AESCCMMAC");
            configurableProvider2.addAlgorithm("Alg.Alias.Mac." + aSN1ObjectIdentifier7.getId(), "AESCCMMAC");
            configurableProvider2.addAlgorithm("Alg.Alias.Mac." + aSN1ObjectIdentifier43.getId(), "AESCCMMAC");
            configurableProvider2.addAlgorithm("Alg.Alias.Mac." + aSN1ObjectIdentifier44.getId(), "AESCCMMAC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier45 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc;
            String str3 = "Alg.Alias.Cipher";
            configurableProvider2.addAlgorithm(str3, aSN1ObjectIdentifier45, "PBEWITHSHAAND128BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier46 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc;
            configurableProvider2.addAlgorithm(str3, aSN1ObjectIdentifier46, "PBEWITHSHAAND192BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier47 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc;
            configurableProvider2.addAlgorithm(str3, aSN1ObjectIdentifier47, "PBEWITHSHAAND256BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier48 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc;
            configurableProvider2.addAlgorithm(str3, aSN1ObjectIdentifier48, "PBEWITHSHA256AND128BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier49 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc;
            configurableProvider2.addAlgorithm(str3, aSN1ObjectIdentifier49, "PBEWITHSHA256AND192BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier50 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc;
            configurableProvider2.addAlgorithm(str3, aSN1ObjectIdentifier50, "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", str + "$PBEWithSHA1AESCBC128");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", str + "$PBEWithSHA1AESCBC192");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", str + "$PBEWithSHA1AESCBC256");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", str + "$PBEWithSHA256AESCBC128");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", str + "$PBEWithSHA256AESCBC192");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", str + "$PBEWithSHA256AESCBC256");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            configurableProvider2.addAlgorithm("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            configurableProvider2.addAlgorithm("SecretKeyFactory.AES", str + "$KeyFactory");
            configurableProvider2.addAlgorithm("SecretKeyFactory", NISTObjectIdentifiers.aes, str + "$KeyFactory");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", str + "$PBEWithMD5And128BitAESCBCOpenSSL");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", str + "$PBEWithMD5And192BitAESCBCOpenSSL");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", str + "$PBEWithMD5And256BitAESCBCOpenSSL");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", str + "$PBEWithSHAAnd128BitAESBC");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", str + "$PBEWithSHAAnd192BitAESBC");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", str + "$PBEWithSHAAnd256BitAESBC");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", str + "$PBEWithSHA256And128BitAESBC");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", str + "$PBEWithSHA256And192BitAESBC");
            configurableProvider2.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", str + "$PBEWithSHA256And256BitAESBC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier45, "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier46, "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier47, "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier48, "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier49, "PBEWITHSHA256AND192BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier51 = aSN1ObjectIdentifier50;
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier51, "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
            StringBuilder sb20 = new StringBuilder();
            String str4 = "Alg.Alias.AlgorithmParameters.";
            sb20.append(str4);
            sb20.append(aSN1ObjectIdentifier45.getId());
            configurableProvider2.addAlgorithm(sb20.toString(), "PKCS12PBE");
            configurableProvider2.addAlgorithm(str4 + aSN1ObjectIdentifier46.getId(), "PKCS12PBE");
            configurableProvider2.addAlgorithm(str4 + aSN1ObjectIdentifier47.getId(), "PKCS12PBE");
            configurableProvider2.addAlgorithm(str4 + aSN1ObjectIdentifier48.getId(), "PKCS12PBE");
            configurableProvider2.addAlgorithm(str4 + aSN1ObjectIdentifier49.getId(), "PKCS12PBE");
            configurableProvider2.addAlgorithm(str4 + aSN1ObjectIdentifier51.getId(), "PKCS12PBE");
            String str5 = str2;
            addGMacAlgorithm(configurableProvider2, str5, str + "$AESGMAC", str + "$KeyGen128");
            addPoly1305Algorithm(configurableProvider2, str5, str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new AESEngine(), 128)), 128);
        }
    }

    public static class PBEWithAESCBC extends BaseBlockCipher {
        public PBEWithAESCBC() {
            super((BlockCipher) new CBCBlockCipher(new AESEngine()));
        }
    }

    public static class PBEWithMD5And128BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And128BitAESCBCOpenSSL() {
            super("PBEWithMD5And128BitAES-CBC-OpenSSL", (ASN1ObjectIdentifier) null, true, 3, 0, 128, 128);
        }
    }

    public static class PBEWithMD5And192BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And192BitAESCBCOpenSSL() {
            super("PBEWithMD5And192BitAES-CBC-OpenSSL", (ASN1ObjectIdentifier) null, true, 3, 0, 192, 128);
        }
    }

    public static class PBEWithMD5And256BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And256BitAESCBCOpenSSL() {
            super("PBEWithMD5And256BitAES-CBC-OpenSSL", (ASN1ObjectIdentifier) null, true, 3, 0, 256, 128);
        }
    }

    public static class PBEWithSHA1AESCBC128 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC128() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 128, 16);
        }
    }

    public static class PBEWithSHA1AESCBC192 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC192() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 192, 16);
        }
    }

    public static class PBEWithSHA1AESCBC256 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC256() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 256, 16);
        }
    }

    public static class PBEWithSHA256AESCBC128 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC128() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 128, 16);
        }
    }

    public static class PBEWithSHA256AESCBC192 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC192() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 192, 16);
        }
    }

    public static class PBEWithSHA256AESCBC256 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC256() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 256, 16);
        }
    }

    public static class PBEWithSHA256And128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And128BitAESBC() {
            super("PBEWithSHA256And128BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 4, 128, 128);
        }
    }

    public static class PBEWithSHA256And192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And192BitAESBC() {
            super("PBEWithSHA256And192BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 4, 192, 128);
        }
    }

    public static class PBEWithSHA256And256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And256BitAESBC() {
            super("PBEWithSHA256And256BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 4, 256, 128);
        }
    }

    public static class PBEWithSHAAnd128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd128BitAESBC() {
            super("PBEWithSHA1And128BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 1, 128, 128);
        }
    }

    public static class PBEWithSHAAnd192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd192BitAESBC() {
            super("PBEWithSHA1And192BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 1, 192, 128);
        }
    }

    public static class PBEWithSHAAnd256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd256BitAESBC() {
            super("PBEWithSHA1And256BitAES-CBC-BC", (ASN1ObjectIdentifier) null, true, 2, 1, 256, 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.bouncycastle.crypto.macs.Poly1305(new AESEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-AES", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new AESEngine()), 16);
        }
    }

    public static class RFC5649Wrap extends BaseWrapCipher {
        public RFC5649Wrap() {
            super(new RFC5649WrapEngine(new AESEngine()));
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new AESWrapEngine());
        }
    }

    public static class WrapPad extends BaseWrapCipher {
        public WrapPad() {
            super(new AESWrapPadEngine());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        generalAesAttributes = hashMap;
        hashMap.put("SupportedKeyClasses", "javax.crypto.SecretKey");
        hashMap.put("SupportedKeyFormats", "RAW");
    }

    private AES() {
    }
}
