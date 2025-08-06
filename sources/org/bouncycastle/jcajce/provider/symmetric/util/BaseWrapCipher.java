package org.bouncycastle.jcajce.provider.symmetric.util;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;
import org.bouncycastle.jcajce.spec.GOST28147WrapParameterSpec;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

public abstract class BaseWrapCipher extends CipherSpi implements PBE {
    private Class[] availableSpecs;
    public AlgorithmParameters engineParams;
    private boolean forWrapping;
    private final JcaJceHelper helper;

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59345iv;
    private int ivSize;
    public int pbeHash;
    public int pbeIvSize;
    public int pbeKeySize;
    public int pbeType;
    public Wrapper wrapEngine;
    private ErasableOutputStream wrapStream;

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        public void erase() {
            Arrays.fill(this.buf, (byte) 0);
            reset();
        }

        public byte[] getBuf() {
            return this.buf;
        }
    }

    public static class InvalidKeyOrParametersException extends InvalidKeyException {
        private final Throwable cause;

        public InvalidKeyOrParametersException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    public BaseWrapCipher() {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.helper = new BCJcaJceHelper();
    }

    public BaseWrapCipher(Wrapper wrapper) {
        this(wrapper, 0);
    }

    public BaseWrapCipher(Wrapper wrapper, int i11) {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.helper = new BCJcaJceHelper();
        this.wrapEngine = wrapper;
        this.ivSize = i11;
    }

    public final AlgorithmParameters createParametersInstance(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.helper.createAlgorithmParameters(str);
    }

    public int engineDoFinal(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream != null) {
            erasableOutputStream.write(bArr, i11, i12);
            try {
                byte[] wrap = this.forWrapping ? this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size()) : this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());
                if (wrap.length + i13 <= bArr2.length) {
                    System.arraycopy(wrap, 0, bArr2, i13, wrap.length);
                    int length = wrap.length;
                    this.wrapStream.erase();
                    return length;
                }
                throw new ShortBufferException("output buffer too short for input.");
            } catch (InvalidCipherTextException e11) {
                throw new BadPaddingException(e11.getMessage());
            } catch (Exception e12) {
                throw new IllegalBlockSizeException(e12.getMessage());
            } catch (Throwable th2) {
                this.wrapStream.erase();
                throw th2;
            }
        } else {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
    }

    public byte[] engineDoFinal(byte[] bArr, int i11, int i12) throws IllegalBlockSizeException, BadPaddingException {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream != null) {
            if (bArr != null) {
                erasableOutputStream.write(bArr, i11, i12);
            }
            try {
                byte[] wrap = this.forWrapping ? this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size()) : this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());
                this.wrapStream.erase();
                return wrap;
            } catch (InvalidCipherTextException e11) {
                throw new BadPaddingException(e11.getMessage());
            } catch (Exception e12) {
                throw new IllegalBlockSizeException(e12.getMessage());
            } catch (Throwable th2) {
                this.wrapStream.erase();
                throw th2;
            }
        } else {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
        return Arrays.clone(this.f59345iv);
    }

    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    public int engineGetOutputSize(int i11) {
        return -1;
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.f59345iv != null) {
            String algorithmName = this.wrapEngine.getAlgorithmName();
            if (algorithmName.indexOf(47) >= 0) {
                algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
            }
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance(algorithmName);
                this.engineParams = createParametersInstance;
                createParametersInstance.init(new IvParameterSpec(this.f59345iv));
            } catch (Exception e11) {
                throw new RuntimeException(e11.toString());
            }
        }
        return this.engineParams;
    }

    public void engineInit(int i11, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            algorithmParameterSpec = SpecUtil.extractSpec(algorithmParameters, this.availableSpecs);
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.engineParams = algorithmParameters;
        engineInit(i11, key, algorithmParameterSpec, secureRandom);
    }

    public void engineInit(int i11, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i11, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e11) {
            throw new InvalidKeyOrParametersException(e11.getMessage(), e11);
        }
    }

    public void engineInit(int i11, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        int i12;
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                parametersWithIV = PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.wrapEngine.getAlgorithmName());
            } else if (bCPBEKey.getParam() != null) {
                parametersWithIV = bCPBEKey.getParam();
            } else {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
        } else {
            parametersWithIV = new KeyParameter(key.getEncoded());
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            byte[] iv2 = ((IvParameterSpec) algorithmParameterSpec).getIV();
            this.f59345iv = iv2;
            parametersWithIV = new ParametersWithIV(parametersWithIV, iv2);
        }
        if (algorithmParameterSpec instanceof GOST28147WrapParameterSpec) {
            GOST28147WrapParameterSpec gOST28147WrapParameterSpec = (GOST28147WrapParameterSpec) algorithmParameterSpec;
            byte[] sBox = gOST28147WrapParameterSpec.getSBox();
            if (sBox != null) {
                parametersWithIV = new ParametersWithSBox(parametersWithIV, sBox);
            }
            parametersWithIV = new ParametersWithUKM(parametersWithIV, gOST28147WrapParameterSpec.getUKM());
        }
        if ((parametersWithIV instanceof KeyParameter) && (i12 = this.ivSize) != 0 && (i11 == 3 || i11 == 1)) {
            byte[] bArr = new byte[i12];
            this.f59345iv = bArr;
            secureRandom.nextBytes(bArr);
            parametersWithIV = new ParametersWithIV(parametersWithIV, this.f59345iv);
        }
        if (secureRandom != null) {
            parametersWithIV = new ParametersWithRandom(parametersWithIV, secureRandom);
        }
        if (i11 != 1) {
            if (i11 == 2) {
                this.wrapEngine.init(false, parametersWithIV);
                this.wrapStream = new ErasableOutputStream();
            } else if (i11 == 3) {
                this.wrapEngine.init(true, parametersWithIV);
                this.wrapStream = null;
            } else if (i11 == 4) {
                try {
                    this.wrapEngine.init(false, parametersWithIV);
                    this.wrapStream = null;
                } catch (Exception e11) {
                    throw new InvalidKeyOrParametersException(e11.getMessage(), e11);
                }
            } else {
                throw new InvalidParameterException("Unknown mode parameter passed to init.");
            }
            this.forWrapping = false;
            return;
        }
        this.wrapEngine.init(true, parametersWithIV);
        this.wrapStream = new ErasableOutputStream();
        this.forWrapping = true;
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    public Key engineUnwrap(byte[] bArr, String str, int i11) throws InvalidKeyException, NoSuchAlgorithmException {
        try {
            Wrapper wrapper = this.wrapEngine;
            byte[] engineDoFinal = wrapper == null ? engineDoFinal(bArr, 0, bArr.length) : wrapper.unwrap(bArr, 0, bArr.length);
            if (i11 == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            if (!str.equals("") || i11 != 2) {
                try {
                    KeyFactory createKeyFactory = this.helper.createKeyFactory(str);
                    if (i11 == 1) {
                        return createKeyFactory.generatePublic(new X509EncodedKeySpec(engineDoFinal));
                    }
                    if (i11 == 2) {
                        return createKeyFactory.generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
                    }
                    throw new InvalidKeyException("Unknown key type " + i11);
                } catch (NoSuchProviderException e11) {
                    throw new InvalidKeyException("Unknown key type " + e11.getMessage());
                } catch (InvalidKeySpecException e12) {
                    throw new InvalidKeyException("Unknown key type " + e12.getMessage());
                }
            } else {
                try {
                    PrivateKeyInfo instance = PrivateKeyInfo.getInstance(engineDoFinal);
                    PrivateKey privateKey = BouncyCastleProvider.getPrivateKey(instance);
                    if (privateKey != null) {
                        return privateKey;
                    }
                    throw new InvalidKeyException("algorithm " + instance.getPrivateKeyAlgorithm().getAlgorithm() + " not supported");
                } catch (Exception unused) {
                    throw new InvalidKeyException("Invalid key encoding.");
                }
            }
        } catch (InvalidCipherTextException e13) {
            throw new InvalidKeyException(e13.getMessage());
        } catch (BadPaddingException e14) {
            throw new InvalidKeyException(e14.getMessage());
        } catch (IllegalBlockSizeException e15) {
            throw new InvalidKeyException(e15.getMessage());
        }
    }

    public int engineUpdate(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws ShortBufferException {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream != null) {
            erasableOutputStream.write(bArr, i11, i12);
            return 0;
        }
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    public byte[] engineUpdate(byte[] bArr, int i11, int i12) {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream != null) {
            erasableOutputStream.write(bArr, i11, i12);
            return null;
        }
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            try {
                Wrapper wrapper = this.wrapEngine;
                return wrapper == null ? engineDoFinal(encoded, 0, encoded.length) : wrapper.wrap(encoded, 0, encoded.length);
            } catch (BadPaddingException e11) {
                throw new IllegalBlockSizeException(e11.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }
}
