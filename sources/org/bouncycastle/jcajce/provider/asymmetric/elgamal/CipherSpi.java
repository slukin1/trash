package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.huochat.community.util.FileTool;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.ISO9796d1Encoding;
import org.bouncycastle.crypto.encodings.OAEPEncoding;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.ElGamalEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jce.interfaces.ElGamalKey;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Strings;

public class CipherSpi extends BaseCipherSpi {
    private BaseCipherSpi.ErasableOutputStream bOut = new BaseCipherSpi.ErasableOutputStream();
    private AsymmetricBlockCipher cipher;
    private AlgorithmParameters engineParams;
    private AlgorithmParameterSpec paramSpec;

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super(new ElGamalEngine());
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new ElGamalEngine()));
        }
    }

    public CipherSpi(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.cipher = asymmetricBlockCipher;
    }

    private byte[] getOutput() throws BadPaddingException {
        try {
            byte[] processBlock = this.cipher.processBlock(this.bOut.getBuf(), 0, this.bOut.size());
            this.bOut.erase();
            return processBlock;
        } catch (InvalidCipherTextException e11) {
            throw new BadBlockException("unable to decrypt block", e11);
        } catch (ArrayIndexOutOfBoundsException e12) {
            throw new BadBlockException("unable to decrypt block", e12);
        } catch (Throwable th2) {
            this.bOut.erase();
            throw th2;
        }
    }

    private void initFromSpec(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        Digest digest = DigestFactory.getDigest(mGF1ParameterSpec.getDigestAlgorithm());
        if (digest != null) {
            this.cipher = new OAEPEncoding(new ElGamalEngine(), digest, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.paramSpec = oAEPParameterSpec;
            return;
        }
        throw new NoSuchPaddingException("no match on OAEP constructor for digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
    }

    public int engineDoFinal(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        if (engineGetOutputSize(i12) + i13 <= bArr2.length) {
            if (bArr != null) {
                this.bOut.write(bArr, i11, i12);
            }
            if (this.cipher instanceof ElGamalEngine) {
                if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
                    throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
                }
            } else if (this.bOut.size() > this.cipher.getInputBlockSize()) {
                throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
            }
            byte[] output = getOutput();
            for (int i14 = 0; i14 != output.length; i14++) {
                bArr2[i13 + i14] = output[i14];
            }
            return output.length;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    public byte[] engineDoFinal(byte[] bArr, int i11, int i12) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            this.bOut.write(bArr, i11, i12);
        }
        if (this.cipher instanceof ElGamalEngine) {
            if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
            }
        } else if (this.bOut.size() > this.cipher.getInputBlockSize()) {
            throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
        }
        return getOutput();
    }

    public int engineGetBlockSize() {
        return this.cipher.getInputBlockSize();
    }

    public int engineGetKeySize(Key key) {
        BigInteger p11;
        if (key instanceof ElGamalKey) {
            p11 = ((ElGamalKey) key).getParameters().getP();
        } else if (key instanceof DHKey) {
            p11 = ((DHKey) key).getParams().getP();
        } else {
            throw new IllegalArgumentException("not an ElGamal key!");
        }
        return p11.bitLength();
    }

    public int engineGetOutputSize(int i11) {
        return this.cipher.getOutputBlockSize();
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.paramSpec != null) {
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("OAEP");
                this.engineParams = createParametersInstance;
                createParametersInstance.init(this.paramSpec);
            } catch (Exception e11) {
                throw new RuntimeException(e11.toString());
            }
        }
        return this.engineParams;
    }

    public void engineInit(int i11, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
    }

    public void engineInit(int i11, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i11, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e11) {
            throw new InvalidKeyException("Eeeek! " + e11.toString(), e11);
        }
    }

    public void engineInit(int i11, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom parametersWithRandom;
        AsymmetricBlockCipher asymmetricBlockCipher;
        if (key instanceof DHPublicKey) {
            parametersWithRandom = ElGamalUtil.generatePublicKeyParameter((PublicKey) key);
        } else if (key instanceof DHPrivateKey) {
            parametersWithRandom = ElGamalUtil.generatePrivateKeyParameter((PrivateKey) key);
        } else {
            throw new InvalidKeyException("unknown key type passed to ElGamal");
        }
        if (algorithmParameterSpec instanceof OAEPParameterSpec) {
            OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
            this.paramSpec = algorithmParameterSpec;
            if (!oAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !oAEPParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId())) {
                throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
            } else if (oAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                Digest digest = DigestFactory.getDigest(oAEPParameterSpec.getDigestAlgorithm());
                if (digest != null) {
                    MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
                    Digest digest2 = DigestFactory.getDigest(mGF1ParameterSpec.getDigestAlgorithm());
                    if (digest2 != null) {
                        this.cipher = new OAEPEncoding(new ElGamalEngine(), digest, digest2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
                    } else {
                        throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("no match on digest algorithm: " + oAEPParameterSpec.getDigestAlgorithm());
                }
            } else {
                throw new InvalidAlgorithmParameterException("unkown MGF parameters");
            }
        } else if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("unknown parameter type.");
        }
        if (secureRandom != null) {
            parametersWithRandom = new ParametersWithRandom(parametersWithRandom, secureRandom);
        }
        boolean z11 = true;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        throw new InvalidParameterException("unknown opmode " + i11 + " passed to ElGamal");
                    }
                }
            }
            asymmetricBlockCipher = this.cipher;
            z11 = false;
            asymmetricBlockCipher.init(z11, parametersWithRandom);
        }
        asymmetricBlockCipher = this.cipher;
        asymmetricBlockCipher.init(z11, parametersWithRandom);
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NONE") && !upperCase.equals("ECB")) {
            throw new NoSuchAlgorithmException("can't support mode " + str);
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        OAEPParameterSpec oAEPParameterSpec;
        AsymmetricBlockCipher iSO9796d1Encoding;
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            iSO9796d1Encoding = new ElGamalEngine();
        } else if (upperCase.equals("PKCS1PADDING")) {
            iSO9796d1Encoding = new PKCS1Encoding(new ElGamalEngine());
        } else if (upperCase.equals("ISO9796-1PADDING")) {
            iSO9796d1Encoding = new ISO9796d1Encoding(new ElGamalEngine());
        } else {
            if (!upperCase.equals("OAEPPADDING")) {
                if (upperCase.equals("OAEPWITHMD5ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec(FileTool.HASH_TYPE_MD5, "MGF1", new MGF1ParameterSpec(FileTool.HASH_TYPE_MD5), PSource.PSpecified.DEFAULT);
                } else if (!upperCase.equals("OAEPWITHSHA1ANDMGF1PADDING")) {
                    if (upperCase.equals("OAEPWITHSHA224ANDMGF1PADDING")) {
                        oAEPParameterSpec = new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), PSource.PSpecified.DEFAULT);
                    } else if (upperCase.equals("OAEPWITHSHA256ANDMGF1PADDING")) {
                        oAEPParameterSpec = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
                    } else if (upperCase.equals("OAEPWITHSHA384ANDMGF1PADDING")) {
                        oAEPParameterSpec = new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT);
                    } else if (upperCase.equals("OAEPWITHSHA512ANDMGF1PADDING")) {
                        oAEPParameterSpec = new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT);
                    } else if (upperCase.equals("OAEPWITHSHA3-224ANDMGF1PADDING")) {
                        oAEPParameterSpec = new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT);
                    } else if (upperCase.equals("OAEPWITHSHA3-256ANDMGF1PADDING")) {
                        oAEPParameterSpec = new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT);
                    } else if (upperCase.equals("OAEPWITHSHA3-384ANDMGF1PADDING")) {
                        oAEPParameterSpec = new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT);
                    } else if (upperCase.equals("OAEPWITHSHA3-512ANDMGF1PADDING")) {
                        oAEPParameterSpec = new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT);
                    } else {
                        throw new NoSuchPaddingException(str + " unavailable with ElGamal.");
                    }
                }
                initFromSpec(oAEPParameterSpec);
                return;
            }
            oAEPParameterSpec = OAEPParameterSpec.DEFAULT;
            initFromSpec(oAEPParameterSpec);
            return;
        }
        this.cipher = iSO9796d1Encoding;
    }

    public int engineUpdate(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        this.bOut.write(bArr, i11, i12);
        return 0;
    }

    public byte[] engineUpdate(byte[] bArr, int i11, int i12) {
        this.bOut.write(bArr, i11, i12);
        return null;
    }
}
