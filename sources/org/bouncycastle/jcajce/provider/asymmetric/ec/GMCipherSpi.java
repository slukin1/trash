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
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.digests.Blake2sDigest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.WhirlpoolDigest;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.ECKey;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class GMCipherSpi extends CipherSpi {
    private ErasableOutputStream buffer = new ErasableOutputStream();
    private SM2Engine engine;
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private AsymmetricKeyParameter key;
    private SecureRandom random;
    private int state = -1;

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        public void erase() {
            Arrays.fill(this.buf, (byte) 0);
            reset();
        }

        public byte[] getBuf() {
            return this.buf;
        }
    }

    public static class SM2 extends GMCipherSpi {
        public SM2() {
            super(new SM2Engine());
        }
    }

    public static class SM2withBlake2b extends GMCipherSpi {
        public SM2withBlake2b() {
            super(new SM2Engine((Digest) new Blake2bDigest(512)));
        }
    }

    public static class SM2withBlake2s extends GMCipherSpi {
        public SM2withBlake2s() {
            super(new SM2Engine((Digest) new Blake2sDigest(256)));
        }
    }

    public static class SM2withMD5 extends GMCipherSpi {
        public SM2withMD5() {
            super(new SM2Engine((Digest) new MD5Digest()));
        }
    }

    public static class SM2withRMD extends GMCipherSpi {
        public SM2withRMD() {
            super(new SM2Engine((Digest) new RIPEMD160Digest()));
        }
    }

    public static class SM2withSha1 extends GMCipherSpi {
        public SM2withSha1() {
            super(new SM2Engine((Digest) new SHA1Digest()));
        }
    }

    public static class SM2withSha224 extends GMCipherSpi {
        public SM2withSha224() {
            super(new SM2Engine((Digest) new SHA224Digest()));
        }
    }

    public static class SM2withSha256 extends GMCipherSpi {
        public SM2withSha256() {
            super(new SM2Engine((Digest) new SHA256Digest()));
        }
    }

    public static class SM2withSha384 extends GMCipherSpi {
        public SM2withSha384() {
            super(new SM2Engine((Digest) new SHA384Digest()));
        }
    }

    public static class SM2withSha512 extends GMCipherSpi {
        public SM2withSha512() {
            super(new SM2Engine((Digest) new SHA512Digest()));
        }
    }

    public static class SM2withWhirlpool extends GMCipherSpi {
        public SM2withWhirlpool() {
            super(new SM2Engine((Digest) new WhirlpoolDigest()));
        }
    }

    public GMCipherSpi(SM2Engine sM2Engine) {
        this.engine = sM2Engine;
    }

    public int engineDoFinal(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i11, i12);
        System.arraycopy(engineDoFinal, 0, bArr2, i13, engineDoFinal.length);
        return engineDoFinal.length;
    }

    public byte[] engineDoFinal(byte[] bArr, int i11, int i12) throws IllegalBlockSizeException, BadPaddingException {
        byte[] processBlock;
        if (i12 != 0) {
            this.buffer.write(bArr, i11, i12);
        }
        try {
            int i13 = this.state;
            if (i13 == 1 || i13 == 3) {
                this.engine.init(true, new ParametersWithRandom(this.key, this.random));
                processBlock = this.engine.processBlock(this.buffer.getBuf(), 0, this.buffer.size());
            } else if (i13 == 2 || i13 == 4) {
                this.engine.init(false, this.key);
                processBlock = this.engine.processBlock(this.buffer.getBuf(), 0, this.buffer.size());
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
            this.buffer.erase();
            return processBlock;
        } catch (Exception e11) {
            throw new BadBlockException("unable to process block", e11);
        } catch (Exception e12) {
            throw new BadBlockException("unable to process block", e12);
        } catch (Throwable th2) {
            this.buffer.erase();
            throw th2;
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
        int i12 = this.state;
        if (i12 == 1 || i12 == 3 || i12 == 2 || i12 == 4) {
            return this.engine.getOutputSize(i11);
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    public void engineInit(int i11, Key key2, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInit(i11, key2, (AlgorithmParameterSpec) null, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + algorithmParameters.getClass().getName());
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
        if (i11 == 1 || i11 == 3) {
            if (key2 instanceof PublicKey) {
                asymmetricKeyParameter = ECUtils.generatePublicKeyParameter((PublicKey) key2);
            } else {
                throw new InvalidKeyException("must be passed public EC key for encryption");
            }
        } else if (i11 != 2 && i11 != 4) {
            throw new InvalidKeyException("must be passed EC key");
        } else if (key2 instanceof PrivateKey) {
            asymmetricKeyParameter = ECUtil.generatePrivateKeyParameter((PrivateKey) key2);
        } else {
            throw new InvalidKeyException("must be passed private EC key for decryption");
        }
        this.key = asymmetricKeyParameter;
        if (secureRandom != null) {
            this.random = secureRandom;
        } else {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        this.state = i11;
        this.buffer.reset();
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        if (!Strings.toUpperCase(str).equals("NONE")) {
            throw new IllegalArgumentException("can't support mode " + str);
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (!Strings.toUpperCase(str).equals("NOPADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
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
