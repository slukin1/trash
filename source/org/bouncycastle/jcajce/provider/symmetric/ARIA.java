package org.bouncycastle.jcajce.provider.symmetric;

import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nsri.NSRIObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.engines.ARIAEngine;
import org.bouncycastle.crypto.engines.ARIAWrapEngine;
import org.bouncycastle.crypto.engines.ARIAWrapPadEngine;
import org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import org.bouncycastle.crypto.generators.Poly1305KeyGenerator;
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
import org.bouncycastle.jcajce.spec.AEADParameterSpec;

public final class ARIA {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("ARIA");
                createParametersInstance.init(new IvParameterSpec(bArr));
                return createParametersInstance;
            } catch (Exception e11) {
                throw new RuntimeException(e11.getMessage());
            }
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for ARIA parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public String engineToString() {
            return "ARIA IV";
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
            super((BlockCipher) new CBCBlockCipher(new ARIAEngine()), 128);
        }
    }

    public static class CCM extends BaseBlockCipher {
        public CCM() {
            super((AEADBlockCipher) new CCMBlockCipher(new ARIAEngine()), false, 12);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new ARIAEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public BlockCipher get() {
                    return new ARIAEngine();
                }
            });
        }
    }

    public static class GCM extends BaseBlockCipher {
        public GCM() {
            super((AEADBlockCipher) new GCMBlockCipher(new ARIAEngine()));
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new ARIAEngine())));
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("ARIA", (ASN1ObjectIdentifier) null);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i11) {
            super("ARIA", i11, new CipherKeyGenerator());
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
        private static final String PREFIX = ARIA.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            ConfigurableProvider configurableProvider2 = configurableProvider;
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$AlgParams");
            configurableProvider2.addAlgorithm("AlgorithmParameters.ARIA", sb2.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NSRIObjectIdentifiers.id_aria128_cbc;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NSRIObjectIdentifiers.id_aria192_cbc;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier2, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NSRIObjectIdentifiers.id_aria256_cbc;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier3, "ARIA");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator.ARIA", str + "$AlgParamGen");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier, "ARIA");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier2, "ARIA");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier3, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NSRIObjectIdentifiers.id_aria128_ofb;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier4, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NSRIObjectIdentifiers.id_aria192_ofb;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier5, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NSRIObjectIdentifiers.id_aria256_ofb;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier6, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NSRIObjectIdentifiers.id_aria128_cfb;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier7, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NSRIObjectIdentifiers.id_aria192_cfb;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier8, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NSRIObjectIdentifiers.id_aria256_cfb;
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier9, "ARIA");
            configurableProvider2.addAlgorithm("Cipher.ARIA", str + "$ECB");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NSRIObjectIdentifiers.id_aria128_ecb;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier10, str + "$ECB");
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NSRIObjectIdentifiers.id_aria192_ecb;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier11, str + "$ECB");
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NSRIObjectIdentifiers.id_aria256_ecb;
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = aSN1ObjectIdentifier11;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier12, str + "$ECB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier, str + "$CBC");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier2, str + "$CBC");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier3, str + "$CBC");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier7, str + "$CFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier8, str + "$CFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier9, str + "$CFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier4, str + "$OFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier5, str + "$OFB");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier6, str + "$OFB");
            configurableProvider2.addAlgorithm("Cipher.ARIARFC3211WRAP", str + "$RFC3211Wrap");
            configurableProvider2.addAlgorithm("Cipher.ARIAWRAP", str + "$Wrap");
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NSRIObjectIdentifiers.id_aria128_kw;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier14, "ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = aSN1ObjectIdentifier6;
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NSRIObjectIdentifiers.id_aria192_kw;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier16, "ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = aSN1ObjectIdentifier5;
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = NSRIObjectIdentifiers.id_aria256_kw;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier18, "ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = aSN1ObjectIdentifier4;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.ARIAKW", "ARIAWRAP");
            configurableProvider2.addAlgorithm("Cipher.ARIAWRAPPAD", str + "$WrapPad");
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = NSRIObjectIdentifiers.id_aria128_kwp;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier20, "ARIAWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = aSN1ObjectIdentifier9;
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = NSRIObjectIdentifiers.id_aria192_kwp;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier22, "ARIAWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = aSN1ObjectIdentifier8;
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = NSRIObjectIdentifiers.id_aria256_kwp;
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier24, "ARIAWRAPPAD");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.ARIAKWP", "ARIAWRAPPAD");
            configurableProvider2.addAlgorithm("KeyGenerator.ARIA", str + "$KeyGen");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier14, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier16, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier18, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier20, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier22, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier24, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier10, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier13, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier12, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier2, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier3, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier7, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier23, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier21, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier19, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier17, str + "$KeyGen192");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier15, str + "$KeyGen256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier25 = NSRIObjectIdentifiers.id_aria128_ccm;
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier25, str + "$KeyGen128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = NSRIObjectIdentifiers.id_aria192_ccm;
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier26, str + "$KeyGen192");
            ASN1ObjectIdentifier aSN1ObjectIdentifier27 = NSRIObjectIdentifiers.id_aria256_ccm;
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier27, str + "$KeyGen256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier28 = NSRIObjectIdentifiers.id_aria128_gcm;
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier28, str + "$KeyGen128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier29 = NSRIObjectIdentifiers.id_aria192_gcm;
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier29, str + "$KeyGen192");
            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = NSRIObjectIdentifiers.id_aria256_gcm;
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier30, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("SecretKeyFactory.ARIA", str + "$KeyFactory");
            String str2 = "ARIA";
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier, str2);
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier2, str2);
            configurableProvider2.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier3, str2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            String str3 = "$AlgParamGen";
            sb3.append(str3);
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator.ARIACCM", sb3.toString());
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier25, "ARIACCM");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier26, "ARIACCM");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier27, "ARIACCM");
            configurableProvider2.addAlgorithm("Cipher.ARIACCM", str + "$CCM");
            String str4 = "Alg.Alias.Cipher";
            configurableProvider2.addAlgorithm(str4, aSN1ObjectIdentifier25, "CCM");
            configurableProvider2.addAlgorithm(str4, aSN1ObjectIdentifier26, "CCM");
            configurableProvider2.addAlgorithm(str4, aSN1ObjectIdentifier27, "CCM");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator.ARIAGCM", str + str3);
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier28, "ARIAGCM");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier29, "ARIAGCM");
            configurableProvider2.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier30, "ARIAGCM");
            configurableProvider2.addAlgorithm("Cipher.ARIAGCM", str + "$GCM");
            configurableProvider2.addAlgorithm(str4, aSN1ObjectIdentifier28, "ARIAGCM");
            configurableProvider2.addAlgorithm(str4, aSN1ObjectIdentifier29, "ARIAGCM");
            configurableProvider2.addAlgorithm(str4, aSN1ObjectIdentifier30, "ARIAGCM");
            addGMacAlgorithm(configurableProvider2, str2, str + "$GMAC", str + "$KeyGen");
            addPoly1305Algorithm(configurableProvider2, str2, str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new ARIAEngine(), 128)), 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.bouncycastle.crypto.macs.Poly1305(new ARIAEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-ARIA", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new ARIAEngine()), 16);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new ARIAWrapEngine());
        }
    }

    public static class WrapPad extends BaseWrapCipher {
        public WrapPad() {
            super(new ARIAWrapPadEngine());
        }
    }

    private ARIA() {
    }
}
