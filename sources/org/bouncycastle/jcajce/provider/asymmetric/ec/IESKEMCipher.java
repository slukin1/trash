package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.KeyEncoder;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
import org.bouncycastle.crypto.engines.IESEngine;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.IESKEMParameterSpec;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.ECKey;
import org.bouncycastle.jce.spec.IESParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

public class IESKEMCipher extends BaseCipherSpi {
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private final ECDHCBasicAgreement agreement;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private boolean dhaesMode = false;
    private IESEngine engine;
    private AlgorithmParameters engineParam = null;
    private IESKEMParameterSpec engineSpec = null;
    private final Mac hMac;
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private int ivLength;
    private final KDF2BytesGenerator kdf;
    private AsymmetricKeyParameter key;
    private final int macKeyLength;
    private final int macLength;
    private AsymmetricKeyParameter otherKeyParameter = null;
    private SecureRandom random;
    private int state = -1;

    public static class KEM extends IESKEMCipher {
        public KEM(Digest digest, Digest digest2, int i11, int i12) {
            super(new ECDHCBasicAgreement(), new KDF2BytesGenerator(digest), new HMac(digest2), i11, i12);
        }
    }

    public static class KEMwithSHA256 extends KEM {
        public KEMwithSHA256() {
            super(DigestFactory.createSHA256(), DigestFactory.createSHA256(), 32, 16);
        }
    }

    public IESKEMCipher(ECDHCBasicAgreement eCDHCBasicAgreement, KDF2BytesGenerator kDF2BytesGenerator, Mac mac, int i11, int i12) {
        this.agreement = eCDHCBasicAgreement;
        this.kdf = kDF2BytesGenerator;
        this.hMac = mac;
        this.macKeyLength = i11;
        this.macLength = i12;
    }

    public int engineDoFinal(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i11, i12);
        System.arraycopy(engineDoFinal, 0, bArr2, i13, engineDoFinal.length);
        return engineDoFinal.length;
    }

    public byte[] engineDoFinal(byte[] bArr, int i11, int i12) throws IllegalBlockSizeException, BadPaddingException {
        if (i12 != 0) {
            this.buffer.write(bArr, i11, i12);
        }
        this.buffer.toByteArray();
        this.buffer.reset();
        ECDomainParameters parameters = ((ECKeyParameters) this.key).getParameters();
        int i13 = this.state;
        if (i13 == 1 || i13 == 3) {
            ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
            eCKeyPairGenerator.init(new ECKeyGenerationParameters(parameters, this.random));
            final boolean hasUsePointCompression = this.engineSpec.hasUsePointCompression();
            EphemeralKeyPair generate = new EphemeralKeyPairGenerator(eCKeyPairGenerator, new KeyEncoder() {
                public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter) {
                    return ((ECPublicKeyParameters) asymmetricKeyParameter).getQ().getEncoded(hasUsePointCompression);
                }
            }).generate();
            this.agreement.init(generate.getKeyPair().getPrivate());
            X9IntegerConverter x9IntegerConverter = converter;
            byte[] integerToBytes = x9IntegerConverter.integerToBytes(this.agreement.calculateAgreement(this.key), x9IntegerConverter.getByteLength(parameters.getCurve()));
            int i14 = this.macKeyLength + i12;
            byte[] bArr2 = new byte[i14];
            this.kdf.init(new KDFParameters(integerToBytes, this.engineSpec.getRecipientInfo()));
            this.kdf.generateBytes(bArr2, 0, i14);
            byte[] bArr3 = new byte[(this.macLength + i12)];
            for (int i15 = 0; i15 != i12; i15++) {
                bArr3[i15] = (byte) (bArr[i11 + i15] ^ bArr2[i15]);
            }
            KeyParameter keyParameter = new KeyParameter(bArr2, i12, i14 - i12);
            this.hMac.init(keyParameter);
            this.hMac.update(bArr3, 0, i12);
            byte[] bArr4 = new byte[this.hMac.getMacSize()];
            this.hMac.doFinal(bArr4, 0);
            Arrays.clear(keyParameter.getKey());
            Arrays.clear(bArr2);
            System.arraycopy(bArr4, 0, bArr3, i12, this.macLength);
            return Arrays.concatenate(generate.getEncodedPublicKey(), bArr3);
        } else if (i13 == 2 || i13 == 4) {
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.key;
            ECCurve curve = eCPrivateKeyParameters.getParameters().getCurve();
            int fieldSize = (curve.getFieldSize() + 7) / 8;
            if (bArr[i11] == 4) {
                fieldSize *= 2;
            }
            int i16 = fieldSize + 1;
            int i17 = i12 - (this.macLength + i16);
            int i18 = i16 + i11;
            ECPoint decodePoint = curve.decodePoint(Arrays.copyOfRange(bArr, i11, i18));
            this.agreement.init(this.key);
            X9IntegerConverter x9IntegerConverter2 = converter;
            byte[] integerToBytes2 = x9IntegerConverter2.integerToBytes(this.agreement.calculateAgreement(new ECPublicKeyParameters(decodePoint, eCPrivateKeyParameters.getParameters())), x9IntegerConverter2.getByteLength(parameters.getCurve()));
            int i19 = this.macKeyLength + i17;
            byte[] bArr5 = new byte[i19];
            this.kdf.init(new KDFParameters(integerToBytes2, this.engineSpec.getRecipientInfo()));
            this.kdf.generateBytes(bArr5, 0, i19);
            byte[] bArr6 = new byte[i17];
            for (int i21 = 0; i21 != i17; i21++) {
                bArr6[i21] = (byte) (bArr[i18 + i21] ^ bArr5[i21]);
            }
            KeyParameter keyParameter2 = new KeyParameter(bArr5, i17, i19 - i17);
            this.hMac.init(keyParameter2);
            this.hMac.update(bArr, i18, i17);
            byte[] bArr7 = new byte[this.hMac.getMacSize()];
            this.hMac.doFinal(bArr7, 0);
            Arrays.clear(keyParameter2.getKey());
            Arrays.clear(bArr5);
            int i22 = this.macLength;
            if (Arrays.constantTimeAreEqual(i22, bArr7, 0, bArr, i11 + (i12 - i22))) {
                return bArr6;
            }
            throw new BadPaddingException("mac field");
        } else {
            throw new IllegalStateException("cipher not initialised");
        }
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
        return null;
    }

    public int engineGetKeySize(Key key2) {
        if (key2 instanceof ECKey) {
            return ((ECKey) key2).getParameters().getCurve().getFieldSize();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    public int engineGetOutputSize(int i11) {
        BufferedBlockCipher bufferedBlockCipher;
        if (this.key != null) {
            int macSize = this.engine.getMac().getMacSize();
            int fieldSize = this.otherKeyParameter == null ? ((((ECKeyParameters) this.key).getParameters().getCurve().getFieldSize() + 7) / 8) * 2 : 0;
            int size = this.buffer.size() + i11;
            if (this.engine.getCipher() != null) {
                int i12 = this.state;
                if (i12 == 1 || i12 == 3) {
                    bufferedBlockCipher = this.engine.getCipher();
                } else if (i12 == 2 || i12 == 4) {
                    bufferedBlockCipher = this.engine.getCipher();
                    size = (size - macSize) - fieldSize;
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
                size = bufferedBlockCipher.getOutputSize(size);
            }
            int i13 = this.state;
            if (i13 == 1 || i13 == 3) {
                return macSize + fieldSize + size;
            }
            if (i13 == 2 || i13 == 4) {
                return size;
            }
            throw new IllegalStateException("cipher not initialised");
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParam == null && this.engineSpec != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.helper.createAlgorithmParameters("IES");
                this.engineParam = createAlgorithmParameters;
                createAlgorithmParameters.init(this.engineSpec);
            } catch (Exception e11) {
                throw new RuntimeException(e11.toString());
            }
        }
        return this.engineParam;
    }

    public void engineInit(int i11, Key key2, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (Exception e11) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e11.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.engineParam = algorithmParameters;
        engineInit(i11, key2, algorithmParameterSpec, secureRandom);
    }

    public void engineInit(int i11, Key key2, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i11, key2, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e11) {
            throw new IllegalArgumentException("cannot handle supplied parameter spec: " + e11.getMessage());
        }
    }

    public void engineInit(int i11, Key key2, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.otherKeyParameter = null;
        this.engineSpec = (IESKEMParameterSpec) algorithmParameterSpec;
        if (i11 == 1 || i11 == 3) {
            if (key2 instanceof PublicKey) {
                asymmetricKeyParameter = ECUtils.generatePublicKeyParameter((PublicKey) key2);
            } else {
                throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
            }
        } else if (i11 != 2 && i11 != 4) {
            throw new InvalidKeyException("must be passed EC key");
        } else if (key2 instanceof PrivateKey) {
            asymmetricKeyParameter = ECUtil.generatePrivateKeyParameter((PrivateKey) key2);
        } else {
            throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
        }
        this.key = asymmetricKeyParameter;
        this.random = secureRandom;
        this.state = i11;
        this.buffer.reset();
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("padding not available with IESCipher");
    }

    public int engineUpdate(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        this.buffer.write(bArr, i11, i12);
        return 0;
    }

    public byte[] engineUpdate(byte[] bArr, int i11, int i12) {
        this.buffer.write(bArr, i11, i12);
        return null;
    }
}
