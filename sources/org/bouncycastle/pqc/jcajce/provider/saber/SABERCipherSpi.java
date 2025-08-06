package org.bouncycastle.pqc.jcajce.provider.saber;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SecretWithEncapsulation;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jcajce.spec.KEMParameterSpec;
import org.bouncycastle.pqc.crypto.saber.SABERKEMExtractor;
import org.bouncycastle.pqc.crypto.saber.SABERKEMGenerator;
import org.bouncycastle.pqc.jcajce.provider.util.WrapUtil;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Exceptions;

class SABERCipherSpi extends CipherSpi {
    private final String algorithmName;
    private AlgorithmParameters engineParams;
    private SABERKEMGenerator kemGen;
    private KEMParameterSpec kemParameterSpec;
    private SecureRandom random;
    private BCSABERPrivateKey unwrapKey;
    private BCSABERPublicKey wrapKey;

    public static class Base extends SABERCipherSpi {
        public Base() throws NoSuchAlgorithmException {
            super("SABER");
        }
    }

    public SABERCipherSpi(String str) throws NoSuchAlgorithmException {
        this.algorithmName = str;
    }

    public int engineDoFinal(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    public byte[] engineDoFinal(byte[] bArr, int i11, int i12) throws IllegalBlockSizeException, BadPaddingException {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
        return null;
    }

    public int engineGetKeySize(Key key) {
        return 2048;
    }

    public int engineGetOutputSize(int i11) {
        return -1;
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance(this.algorithmName, "BCPQC");
                this.engineParams = instance;
                instance.init(this.kemParameterSpec);
            } catch (Exception e11) {
                throw Exceptions.illegalStateException(e11.toString(), e11);
            }
        }
        return this.engineParams;
    }

    public void engineInit(int i11, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(KEMParameterSpec.class);
            } catch (Exception unused) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        engineInit(i11, key, algorithmParameterSpec, this.random);
    }

    public void engineInit(int i11, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i11, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e11) {
            throw Exceptions.illegalArgumentException(e11.getMessage(), e11);
        }
    }

    public void engineInit(int i11, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        KEMParameterSpec kEMParameterSpec;
        if (secureRandom == null) {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        if (algorithmParameterSpec == null) {
            kEMParameterSpec = new KEMParameterSpec("AES-KWP");
        } else if (algorithmParameterSpec instanceof KEMParameterSpec) {
            kEMParameterSpec = (KEMParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException(this.algorithmName + " can only accept KTSParameterSpec");
        }
        this.kemParameterSpec = kEMParameterSpec;
        if (i11 == 3) {
            if (key instanceof BCSABERPublicKey) {
                this.wrapKey = (BCSABERPublicKey) key;
                this.kemGen = new SABERKEMGenerator(secureRandom);
                return;
            }
            throw new InvalidKeyException("Only an RSA public key can be used for wrapping");
        } else if (i11 != 4) {
            throw new InvalidParameterException("Cipher only valid for wrapping/unwrapping");
        } else if (key instanceof BCSABERPrivateKey) {
            this.unwrapKey = (BCSABERPrivateKey) key;
        } else {
            throw new InvalidKeyException("Only an RSA private key can be used for unwrapping");
        }
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("Cannot support mode " + str);
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown");
    }

    public Key engineUnwrap(byte[] bArr, String str, int i11) throws InvalidKeyException, NoSuchAlgorithmException {
        if (i11 == 3) {
            try {
                SABERKEMExtractor sABERKEMExtractor = new SABERKEMExtractor(this.unwrapKey.getKeyParams());
                byte[] extractSecret = sABERKEMExtractor.extractSecret(Arrays.copyOfRange(bArr, 0, sABERKEMExtractor.getInputSize()));
                Wrapper wrapper = WrapUtil.getWrapper(this.kemParameterSpec.getKeyAlgorithmName());
                KeyParameter keyParameter = new KeyParameter(extractSecret);
                Arrays.clear(extractSecret);
                wrapper.init(false, keyParameter);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, sABERKEMExtractor.getInputSize(), bArr.length);
                SecretKeySpec secretKeySpec = new SecretKeySpec(wrapper.unwrap(copyOfRange, 0, copyOfRange.length), str);
                Arrays.clear(keyParameter.getKey());
                return secretKeySpec;
            } catch (IllegalArgumentException e11) {
                throw new NoSuchAlgorithmException("unable to extract KTS secret: " + e11.getMessage());
            } catch (InvalidCipherTextException e12) {
                throw new InvalidKeyException("unable to extract KTS secret: " + e12.getMessage());
            }
        } else {
            throw new InvalidKeyException("only SECRET_KEY supported");
        }
    }

    public int engineUpdate(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws ShortBufferException {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    public byte[] engineUpdate(byte[] bArr, int i11, int i12) {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        if (key.getEncoded() != null) {
            try {
                SecretWithEncapsulation generateEncapsulated = this.kemGen.generateEncapsulated(this.wrapKey.getKeyParams());
                Wrapper wrapper = WrapUtil.getWrapper(this.kemParameterSpec.getKeyAlgorithmName());
                wrapper.init(true, new KeyParameter(generateEncapsulated.getSecret()));
                byte[] encapsulation = generateEncapsulated.getEncapsulation();
                generateEncapsulated.destroy();
                byte[] encoded = key.getEncoded();
                byte[] concatenate = Arrays.concatenate(encapsulation, wrapper.wrap(encoded, 0, encoded.length));
                Arrays.clear(encoded);
                return concatenate;
            } catch (IllegalArgumentException e11) {
                throw new IllegalBlockSizeException("unable to generate KTS secret: " + e11.getMessage());
            } catch (DestroyFailedException e12) {
                throw new IllegalBlockSizeException("unable to destroy interim values: " + e12.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }
}
