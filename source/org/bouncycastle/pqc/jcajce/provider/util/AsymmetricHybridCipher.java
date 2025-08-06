package org.bouncycastle.pqc.jcajce.provider.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

public abstract class AsymmetricHybridCipher extends CipherSpiExt {
    public AlgorithmParameterSpec paramSpec;

    public abstract int decryptOutputSize(int i11);

    public final int doFinal(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws ShortBufferException, BadPaddingException {
        if (bArr2.length >= getOutputSize(i12)) {
            byte[] doFinal = doFinal(bArr, i11, i12);
            System.arraycopy(doFinal, 0, bArr2, i13, doFinal.length);
            return doFinal.length;
        }
        throw new ShortBufferException("Output buffer too short.");
    }

    public abstract byte[] doFinal(byte[] bArr, int i11, int i12) throws BadPaddingException;

    public abstract int encryptOutputSize(int i11);

    public final int getBlockSize() {
        return 0;
    }

    public final byte[] getIV() {
        return null;
    }

    public final int getOutputSize(int i11) {
        return this.opMode == 1 ? encryptOutputSize(i11) : decryptOutputSize(i11);
    }

    public final AlgorithmParameterSpec getParameters() {
        return this.paramSpec;
    }

    public abstract void initCipherDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void initCipherEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public final void initDecrypt(Key key) throws InvalidKeyException {
        try {
            initDecrypt(key, (AlgorithmParameterSpec) null);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.opMode = 2;
        initCipherDecrypt(key, algorithmParameterSpec);
    }

    public final void initEncrypt(Key key) throws InvalidKeyException {
        try {
            initEncrypt(key, (AlgorithmParameterSpec) null, CryptoServicesRegistrar.getSecureRandom());
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initEncrypt(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            initEncrypt(key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        initEncrypt(key, algorithmParameterSpec, CryptoServicesRegistrar.getSecureRandom());
    }

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.opMode = 1;
        initCipherEncrypt(key, algorithmParameterSpec, secureRandom);
    }

    public final void setMode(String str) {
    }

    public final void setPadding(String str) {
    }

    public final int update(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws ShortBufferException {
        if (bArr2.length >= getOutputSize(i12)) {
            byte[] update = update(bArr, i11, i12);
            System.arraycopy(update, 0, bArr2, i13, update.length);
            return update.length;
        }
        throw new ShortBufferException("output");
    }

    public abstract byte[] update(byte[] bArr, int i11, int i12);
}
