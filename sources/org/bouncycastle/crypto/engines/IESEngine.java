package org.bouncycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;

public class IESEngine {
    private byte[] IV;
    public byte[] V;
    public BasicAgreement agree;
    public BufferedBlockCipher cipher;
    public boolean forEncryption;
    public DerivationFunction kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;
    public Mac mac;
    public byte[] macBuf;
    public IESParameters param;
    public CipherParameters privParam;
    public CipherParameters pubParam;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac2) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac2;
        this.macBuf = new byte[mac2.getMacSize()];
        this.cipher = null;
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac2, BufferedBlockCipher bufferedBlockCipher) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac2;
        this.macBuf = new byte[mac2.getMacSize()];
        this.cipher = bufferedBlockCipher;
    }

    private byte[] decryptBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int i13;
        if (i12 >= this.V.length + this.mac.getMacSize()) {
            if (this.cipher == null) {
                int length = (i12 - this.V.length) - this.mac.getMacSize();
                byte[] bArr4 = new byte[length];
                int macKeySize = this.param.getMacKeySize() / 8;
                bArr2 = new byte[macKeySize];
                int i14 = length + macKeySize;
                byte[] bArr5 = new byte[i14];
                this.kdf.generateBytes(bArr5, 0, i14);
                if (this.V.length != 0) {
                    System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                    System.arraycopy(bArr5, macKeySize, bArr4, 0, length);
                } else {
                    System.arraycopy(bArr5, 0, bArr4, 0, length);
                    System.arraycopy(bArr5, length, bArr2, 0, macKeySize);
                }
                bArr3 = new byte[length];
                for (int i15 = 0; i15 != length; i15++) {
                    bArr3[i15] = (byte) (bArr[(this.V.length + i11) + i15] ^ bArr4[i15]);
                }
                i13 = 0;
            } else {
                int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
                byte[] bArr6 = new byte[cipherKeySize];
                int macKeySize2 = this.param.getMacKeySize() / 8;
                bArr2 = new byte[macKeySize2];
                int i16 = cipherKeySize + macKeySize2;
                byte[] bArr7 = new byte[i16];
                this.kdf.generateBytes(bArr7, 0, i16);
                System.arraycopy(bArr7, 0, bArr6, 0, cipherKeySize);
                System.arraycopy(bArr7, cipherKeySize, bArr2, 0, macKeySize2);
                CipherParameters keyParameter = new KeyParameter(bArr6);
                byte[] bArr8 = this.IV;
                if (bArr8 != null) {
                    keyParameter = new ParametersWithIV(keyParameter, bArr8);
                }
                this.cipher.init(false, keyParameter);
                bArr3 = new byte[this.cipher.getOutputSize((i12 - this.V.length) - this.mac.getMacSize())];
                BufferedBlockCipher bufferedBlockCipher = this.cipher;
                byte[] bArr9 = this.V;
                i13 = bufferedBlockCipher.processBytes(bArr, i11 + bArr9.length, (i12 - bArr9.length) - this.mac.getMacSize(), bArr3, 0);
            }
            byte[] encodingV = this.param.getEncodingV();
            byte[] bArr10 = null;
            if (this.V.length != 0) {
                bArr10 = getLengthTag(encodingV);
            }
            int i17 = i11 + i12;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i17 - this.mac.getMacSize(), i17);
            int length2 = copyOfRange.length;
            byte[] bArr11 = new byte[length2];
            this.mac.init(new KeyParameter(bArr2));
            Mac mac2 = this.mac;
            byte[] bArr12 = this.V;
            mac2.update(bArr, i11 + bArr12.length, (i12 - bArr12.length) - length2);
            if (encodingV != null) {
                this.mac.update(encodingV, 0, encodingV.length);
            }
            if (this.V.length != 0) {
                this.mac.update(bArr10, 0, bArr10.length);
            }
            this.mac.doFinal(bArr11, 0);
            if (Arrays.constantTimeAreEqual(copyOfRange, bArr11)) {
                BufferedBlockCipher bufferedBlockCipher2 = this.cipher;
                return bufferedBlockCipher2 == null ? bArr3 : Arrays.copyOfRange(bArr3, 0, i13 + bufferedBlockCipher2.doFinal(bArr3, i13));
            }
            throw new InvalidCipherTextException("invalid MAC");
        }
        throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
    }

    private byte[] encryptBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        CipherParameters cipherParameters;
        BufferedBlockCipher bufferedBlockCipher;
        if (this.cipher == null) {
            byte[] bArr4 = new byte[i12];
            int macKeySize = this.param.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize];
            int i13 = i12 + macKeySize;
            byte[] bArr5 = new byte[i13];
            this.kdf.generateBytes(bArr5, 0, i13);
            if (this.V.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, i12);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, i12);
                System.arraycopy(bArr5, i12, bArr2, 0, macKeySize);
            }
            bArr3 = new byte[i12];
            for (int i14 = 0; i14 != i12; i14++) {
                bArr3[i14] = (byte) (bArr[i11 + i14] ^ bArr4[i14]);
            }
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.param.getMacKeySize() / 8;
            byte[] bArr7 = new byte[macKeySize2];
            int i15 = cipherKeySize + macKeySize2;
            byte[] bArr8 = new byte[i15];
            this.kdf.generateBytes(bArr8, 0, i15);
            System.arraycopy(bArr8, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr8, cipherKeySize, bArr7, 0, macKeySize2);
            if (this.IV != null) {
                bufferedBlockCipher = this.cipher;
                cipherParameters = new ParametersWithIV(new KeyParameter(bArr6), this.IV);
            } else {
                bufferedBlockCipher = this.cipher;
                cipherParameters = new KeyParameter(bArr6);
            }
            bufferedBlockCipher.init(true, cipherParameters);
            bArr3 = new byte[this.cipher.getOutputSize(i12)];
            int processBytes = this.cipher.processBytes(bArr, i11, i12, bArr3, 0);
            i12 = processBytes + this.cipher.doFinal(bArr3, processBytes);
            bArr2 = bArr7;
        }
        byte[] encodingV = this.param.getEncodingV();
        byte[] bArr9 = null;
        if (this.V.length != 0) {
            bArr9 = getLengthTag(encodingV);
        }
        int macSize = this.mac.getMacSize();
        byte[] bArr10 = new byte[macSize];
        this.mac.init(new KeyParameter(bArr2));
        this.mac.update(bArr3, 0, bArr3.length);
        if (encodingV != null) {
            this.mac.update(encodingV, 0, encodingV.length);
        }
        if (this.V.length != 0) {
            this.mac.update(bArr9, 0, bArr9.length);
        }
        this.mac.doFinal(bArr10, 0);
        byte[] bArr11 = this.V;
        byte[] bArr12 = new byte[(bArr11.length + i12 + macSize)];
        System.arraycopy(bArr11, 0, bArr12, 0, bArr11.length);
        System.arraycopy(bArr3, 0, bArr12, this.V.length, i12);
        System.arraycopy(bArr10, 0, bArr12, this.V.length + i12, macSize);
        return bArr12;
    }

    private void extractParams(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.IV = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            this.IV = null;
        }
        this.param = (IESParameters) cipherParameters;
    }

    public BufferedBlockCipher getCipher() {
        return this.cipher;
    }

    public byte[] getLengthTag(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            Pack.longToBigEndian(((long) bArr.length) * 8, bArr2, 0);
        }
        return bArr2;
    }

    public Mac getMac() {
        return this.mac;
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser2) {
        this.forEncryption = false;
        this.privParam = asymmetricKeyParameter;
        this.keyParser = keyParser2;
        extractParams(cipherParameters);
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.forEncryption = true;
        this.pubParam = asymmetricKeyParameter;
        this.keyPairGenerator = ephemeralKeyPairGenerator;
        extractParams(cipherParameters);
    }

    public void init(boolean z11, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z11;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.V = new byte[0];
        extractParams(cipherParameters3);
    }

    public byte[] processBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        if (this.forEncryption) {
            EphemeralKeyPairGenerator ephemeralKeyPairGenerator = this.keyPairGenerator;
            if (ephemeralKeyPairGenerator != null) {
                EphemeralKeyPair generate = ephemeralKeyPairGenerator.generate();
                this.privParam = generate.getKeyPair().getPrivate();
                this.V = generate.getEncodedPublicKey();
            }
        } else if (this.keyParser != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i11, i12);
            try {
                this.pubParam = this.keyParser.readKey(byteArrayInputStream);
                this.V = Arrays.copyOfRange(bArr, i11, (i12 - byteArrayInputStream.available()) + i11);
            } catch (IOException e11) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e11.getMessage(), e11);
            } catch (IllegalArgumentException e12) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e12.getMessage(), e12);
            }
        }
        this.agree.init(this.privParam);
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.agree.getFieldSize(), this.agree.calculateAgreement(this.pubParam));
        byte[] bArr2 = this.V;
        if (bArr2.length != 0) {
            byte[] concatenate = Arrays.concatenate(bArr2, asUnsignedByteArray);
            Arrays.fill(asUnsignedByteArray, (byte) 0);
            asUnsignedByteArray = concatenate;
        }
        try {
            this.kdf.init(new KDFParameters(asUnsignedByteArray, this.param.getDerivationV()));
            return this.forEncryption ? encryptBlock(bArr, i11, i12) : decryptBlock(bArr, i11, i12);
        } finally {
            Arrays.fill(asUnsignedByteArray, (byte) 0);
        }
    }
}
