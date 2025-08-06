package org.bouncycastle.jce.provider;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.TwofishEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.RC5Parameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jce.provider.BrokenPBE;
import org.bouncycastle.util.Strings;

public class BrokenJCEBlockCipher implements BrokenPBE {
    private Class[] availableSpecs = {IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
    private BufferedBlockCipher cipher;
    private AlgorithmParameters engineParams = null;
    private int ivLength = 0;
    private ParametersWithIV ivParam;
    private int pbeHash = 1;
    private int pbeIvSize;
    private int pbeKeySize;
    private int pbeType = 2;

    public static class BrokePBEWithMD5AndDES extends BrokenJCEBlockCipher {
        public BrokePBEWithMD5AndDES() {
            super(new CBCBlockCipher(new DESEngine()), 0, 0, 64, 64);
        }
    }

    public static class BrokePBEWithSHA1AndDES extends BrokenJCEBlockCipher {
        public BrokePBEWithSHA1AndDES() {
            super(new CBCBlockCipher(new DESEngine()), 0, 1, 64, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES2Key extends BrokenJCEBlockCipher {
        public BrokePBEWithSHAAndDES2Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 128, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES3Key extends BrokenJCEBlockCipher {
        public BrokePBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 192, 64);
        }
    }

    public static class OldPBEWithSHAAndDES3Key extends BrokenJCEBlockCipher {
        public OldPBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 3, 1, 192, 64);
        }
    }

    public static class OldPBEWithSHAAndTwofish extends BrokenJCEBlockCipher {
        public OldPBEWithSHAAndTwofish() {
            super(new CBCBlockCipher(new TwofishEngine()), 3, 1, 256, 128);
        }
    }

    public BrokenJCEBlockCipher(BlockCipher blockCipher) {
        this.cipher = new PaddedBufferedBlockCipher(blockCipher);
    }

    public BrokenJCEBlockCipher(BlockCipher blockCipher, int i11, int i12, int i13, int i14) {
        this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        this.pbeType = i11;
        this.pbeHash = i12;
        this.pbeKeySize = i13;
        this.pbeIvSize = i14;
    }

    public int engineDoFinal(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws IllegalBlockSizeException, BadPaddingException {
        int processBytes = i12 != 0 ? this.cipher.processBytes(bArr, i11, i12, bArr2, i13) : 0;
        try {
            return processBytes + this.cipher.doFinal(bArr2, i13 + processBytes);
        } catch (DataLengthException e11) {
            throw new IllegalBlockSizeException(e11.getMessage());
        } catch (InvalidCipherTextException e12) {
            throw new BadPaddingException(e12.getMessage());
        }
    }

    public byte[] engineDoFinal(byte[] bArr, int i11, int i12) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[engineGetOutputSize(i12)];
        int processBytes = i12 != 0 ? this.cipher.processBytes(bArr, i11, i12, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.cipher.doFinal(bArr2, processBytes);
            byte[] bArr3 = new byte[doFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
            return bArr3;
        } catch (DataLengthException e11) {
            throw new IllegalBlockSizeException(e11.getMessage());
        } catch (InvalidCipherTextException e12) {
            throw new BadPaddingException(e12.getMessage());
        }
    }

    public int engineGetBlockSize() {
        return this.cipher.getBlockSize();
    }

    public byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    public int engineGetKeySize(Key key) {
        return key.getEncoded().length;
    }

    public int engineGetOutputSize(int i11) {
        return this.cipher.getOutputSize(i11);
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.ivParam != null) {
            String algorithmName = this.cipher.getUnderlyingCipher().getAlgorithmName();
            if (algorithmName.indexOf(47) >= 0) {
                algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
            }
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
                this.engineParams = instance;
                instance.init(this.ivParam.getIV());
            } catch (Exception e11) {
                throw new RuntimeException(e11.toString());
            }
        }
        return this.engineParams;
    }

    public void engineInit(int i11, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i12 = 0;
            while (true) {
                Class[] clsArr = this.availableSpecs;
                if (i12 == clsArr.length) {
                    break;
                }
                try {
                    algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i12]);
                    break;
                } catch (Exception unused) {
                    i12++;
                }
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        this.engineParams = algorithmParameters;
        engineInit(i11, key, algorithmParameterSpec, secureRandom);
    }

    public void engineInit(int i11, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i11, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e11) {
            throw new IllegalArgumentException(e11.getMessage());
        }
    }

    public void engineInit(int i11, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        KeyParameter keyParameter;
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        KeyParameter keyParameter2;
        if (key instanceof BCPBEKey) {
            CipherParameters makePBEParameters = BrokenPBE.Util.makePBEParameters((BCPBEKey) key, algorithmParameterSpec, this.pbeType, this.pbeHash, this.cipher.getUnderlyingCipher().getAlgorithmName(), this.pbeKeySize, this.pbeIvSize);
            keyParameter = makePBEParameters;
            if (this.pbeIvSize != 0) {
                this.ivParam = (ParametersWithIV) makePBEParameters;
                keyParameter = makePBEParameters;
            }
        } else {
            if (algorithmParameterSpec == null) {
                keyParameter2 = new KeyParameter(key.getEncoded());
            } else {
                if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
                    if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                        RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                        RC2Parameters rC2Parameters = new RC2Parameters(key.getEncoded(), rC2ParameterSpec.getEffectiveKeyBits());
                        parametersWithIV2 = rC2Parameters;
                        if (rC2ParameterSpec.getIV() != null) {
                            parametersWithIV2 = rC2Parameters;
                            if (this.ivLength != 0) {
                                parametersWithIV = new ParametersWithIV(rC2Parameters, rC2ParameterSpec.getIV());
                            }
                        }
                    } else if (algorithmParameterSpec instanceof RC5ParameterSpec) {
                        RC5ParameterSpec rC5ParameterSpec = (RC5ParameterSpec) algorithmParameterSpec;
                        RC5Parameters rC5Parameters = new RC5Parameters(key.getEncoded(), rC5ParameterSpec.getRounds());
                        if (rC5ParameterSpec.getWordSize() == 32) {
                            parametersWithIV2 = rC5Parameters;
                            if (rC5ParameterSpec.getIV() != null) {
                                parametersWithIV2 = rC5Parameters;
                                if (this.ivLength != 0) {
                                    parametersWithIV = new ParametersWithIV(rC5Parameters, rC5ParameterSpec.getIV());
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("can only accept RC5 word size 32 (at the moment...)");
                        }
                    } else {
                        throw new InvalidAlgorithmParameterException("unknown parameter type.");
                    }
                    this.ivParam = parametersWithIV;
                    keyParameter = parametersWithIV;
                } else if (this.ivLength != 0) {
                    ParametersWithIV parametersWithIV3 = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                    this.ivParam = parametersWithIV3;
                    parametersWithIV2 = parametersWithIV3;
                } else {
                    keyParameter2 = new KeyParameter(key.getEncoded());
                }
                keyParameter = parametersWithIV2;
            }
            keyParameter = keyParameter2;
        }
        ParametersWithIV parametersWithIV4 = keyParameter;
        if (this.ivLength != 0) {
            boolean z11 = keyParameter instanceof ParametersWithIV;
            parametersWithIV4 = keyParameter;
            if (!z11) {
                if (secureRandom == null) {
                    secureRandom = CryptoServicesRegistrar.getSecureRandom();
                }
                if (i11 == 1 || i11 == 3) {
                    byte[] bArr = new byte[this.ivLength];
                    secureRandom.nextBytes(bArr);
                    ParametersWithIV parametersWithIV5 = new ParametersWithIV(keyParameter, bArr);
                    this.ivParam = parametersWithIV5;
                    parametersWithIV4 = parametersWithIV5;
                } else {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
            }
        }
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        throw new IllegalArgumentException("unknown opmode: " + i11);
                    }
                }
            }
            this.cipher.init(false, parametersWithIV4);
            return;
        }
        this.cipher.init(true, parametersWithIV4);
    }

    public void engineSetMode(String str) {
        PaddedBufferedBlockCipher paddedBufferedBlockCipher;
        PaddedBufferedBlockCipher paddedBufferedBlockCipher2;
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("ECB")) {
            this.ivLength = 0;
            paddedBufferedBlockCipher = new PaddedBufferedBlockCipher(this.cipher.getUnderlyingCipher());
        } else if (upperCase.equals("CBC")) {
            this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
            paddedBufferedBlockCipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(this.cipher.getUnderlyingCipher()));
        } else {
            if (upperCase.startsWith("OFB")) {
                this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
                if (upperCase.length() != 3) {
                    paddedBufferedBlockCipher2 = new PaddedBufferedBlockCipher(new OFBBlockCipher(this.cipher.getUnderlyingCipher(), Integer.parseInt(upperCase.substring(3))));
                } else {
                    paddedBufferedBlockCipher = new PaddedBufferedBlockCipher(new OFBBlockCipher(this.cipher.getUnderlyingCipher(), this.cipher.getBlockSize() * 8));
                }
            } else if (upperCase.startsWith("CFB")) {
                this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
                if (upperCase.length() != 3) {
                    paddedBufferedBlockCipher2 = new PaddedBufferedBlockCipher(new CFBBlockCipher(this.cipher.getUnderlyingCipher(), Integer.parseInt(upperCase.substring(3))));
                } else {
                    paddedBufferedBlockCipher = new PaddedBufferedBlockCipher(new CFBBlockCipher(this.cipher.getUnderlyingCipher(), this.cipher.getBlockSize() * 8));
                }
            } else {
                throw new IllegalArgumentException("can't support mode " + str);
            }
            this.cipher = paddedBufferedBlockCipher2;
            return;
        }
        this.cipher = paddedBufferedBlockCipher;
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        BufferedBlockCipher paddedBufferedBlockCipher;
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            paddedBufferedBlockCipher = new BufferedBlockCipher(this.cipher.getUnderlyingCipher());
        } else if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING") || upperCase.equals("ISO10126PADDING")) {
            paddedBufferedBlockCipher = new PaddedBufferedBlockCipher(this.cipher.getUnderlyingCipher());
        } else if (upperCase.equals("WITHCTS")) {
            paddedBufferedBlockCipher = new CTSBlockCipher(this.cipher.getUnderlyingCipher());
        } else {
            throw new NoSuchPaddingException("Padding " + str + " unknown.");
        }
        this.cipher = paddedBufferedBlockCipher;
    }

    public Key engineUnwrap(byte[] bArr, String str, int i11) throws InvalidKeyException {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i11 == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            try {
                KeyFactory instance = KeyFactory.getInstance(str, BouncyCastleProvider.PROVIDER_NAME);
                if (i11 == 1) {
                    return instance.generatePublic(new X509EncodedKeySpec(engineDoFinal));
                }
                if (i11 == 2) {
                    return instance.generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
                }
                throw new InvalidKeyException("Unknown key type " + i11);
            } catch (NoSuchProviderException e11) {
                throw new InvalidKeyException("Unknown key type " + e11.getMessage());
            } catch (NoSuchAlgorithmException e12) {
                throw new InvalidKeyException("Unknown key type " + e12.getMessage());
            } catch (InvalidKeySpecException e13) {
                throw new InvalidKeyException("Unknown key type " + e13.getMessage());
            }
        } catch (BadPaddingException e14) {
            throw new InvalidKeyException(e14.getMessage());
        } catch (IllegalBlockSizeException e15) {
            throw new InvalidKeyException(e15.getMessage());
        }
    }

    public int engineUpdate(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        return this.cipher.processBytes(bArr, i11, i12, bArr2, i13);
    }

    public byte[] engineUpdate(byte[] bArr, int i11, int i12) {
        int updateOutputSize = this.cipher.getUpdateOutputSize(i12);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            this.cipher.processBytes(bArr, i11, i12, bArr2, 0);
            return bArr2;
        }
        this.cipher.processBytes(bArr, i11, i12, (byte[]) null, 0);
        return null;
    }

    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            try {
                return engineDoFinal(encoded, 0, encoded.length);
            } catch (BadPaddingException e11) {
                throw new IllegalBlockSizeException(e11.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }
}
