package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

public abstract class BaseCipherSpi extends CipherSpi {
    private Class[] availableSpecs = {IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
    public AlgorithmParameters engineParams = null;
    private final JcaJceHelper helper = new BCJcaJceHelper();

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59334iv;
    private int ivSize;
    public Wrapper wrapEngine = null;

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        public void erase() {
            Arrays.fill(this.buf, (byte) 0);
            reset();
        }

        public byte[] getBuf() {
            return this.buf;
        }
    }

    public final AlgorithmParameters createParametersInstance(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.helper.createAlgorithmParameters(str);
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
        return null;
    }

    public int engineGetKeySize(Key key) {
        return key.getEncoded().length;
    }

    public int engineGetOutputSize(int i11) {
        return -1;
    }

    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    public Key engineUnwrap(byte[] bArr, String str, int i11) throws InvalidKeyException {
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
                } catch (NoSuchAlgorithmException e11) {
                    throw new InvalidKeyException("Unknown key type " + e11.getMessage());
                } catch (InvalidKeySpecException e12) {
                    throw new InvalidKeyException("Unknown key type " + e12.getMessage());
                } catch (NoSuchProviderException e13) {
                    throw new InvalidKeyException("Unknown key type " + e13.getMessage());
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
        } catch (InvalidCipherTextException e14) {
            throw new InvalidKeyException(e14.getMessage());
        } catch (BadPaddingException e15) {
            throw new InvalidKeyException("unable to unwrap") {
                public synchronized Throwable getCause() {
                    return e15;
                }
            };
        } catch (IllegalBlockSizeException e16) {
            throw new InvalidKeyException(e16.getMessage());
        }
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
