package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class OAEPEncoding implements AsymmetricBlockCipher {
    private byte[] defHash;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private Digest mgf1Hash;
    private SecureRandom random;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, DigestFactory.createSHA1(), (byte[]) null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, (byte[]) null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this.engine = asymmetricBlockCipher;
        this.mgf1Hash = digest2;
        this.defHash = new byte[digest.getDigestSize()];
        digest.reset();
        if (bArr != null) {
            digest.update(bArr, 0, bArr.length);
        }
        digest.doFinal(this.defHash, 0);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr);
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i11, int i12, int i13) {
        byte[] bArr2 = new byte[i13];
        int digestSize = this.mgf1Hash.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        byte[] bArr4 = new byte[4];
        this.mgf1Hash.reset();
        int i14 = 0;
        while (i14 < i13 / digestSize) {
            Pack.intToBigEndian(i14, bArr4, 0);
            this.mgf1Hash.update(bArr, i11, i12);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i14 * digestSize, digestSize);
            i14++;
        }
        int i15 = digestSize * i14;
        if (i15 < i13) {
            Pack.intToBigEndian(i14, bArr4, 0);
            this.mgf1Hash.update(bArr, i11, i12);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i15, i13 - i15);
        }
        return bArr2;
    }

    public byte[] decodeBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        byte[] processBlock = this.engine.processBlock(bArr, i11, i12);
        int outputBlockSize = this.engine.getOutputBlockSize();
        byte[] bArr4 = new byte[outputBlockSize];
        byte length = (outputBlockSize - ((this.defHash.length * 2) + 1)) >> 31;
        if (processBlock.length <= outputBlockSize) {
            System.arraycopy(processBlock, 0, bArr4, outputBlockSize - processBlock.length, processBlock.length);
        } else {
            System.arraycopy(processBlock, 0, bArr4, 0, outputBlockSize);
            length |= 1;
        }
        byte[] bArr5 = this.defHash;
        byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, bArr5.length, outputBlockSize - bArr5.length, bArr5.length);
        int i13 = 0;
        while (true) {
            bArr2 = this.defHash;
            if (i13 == bArr2.length) {
                break;
            }
            bArr4[i13] = (byte) (bArr4[i13] ^ maskGeneratorFunction1[i13]);
            i13++;
        }
        byte[] maskGeneratorFunction12 = maskGeneratorFunction1(bArr4, 0, bArr2.length, outputBlockSize - bArr2.length);
        for (int length2 = this.defHash.length; length2 != outputBlockSize; length2++) {
            bArr4[length2] = (byte) (bArr4[length2] ^ maskGeneratorFunction12[length2 - this.defHash.length]);
        }
        int i14 = 0;
        while (true) {
            bArr3 = this.defHash;
            if (i14 == bArr3.length) {
                break;
            }
            length |= bArr4[bArr3.length + i14] ^ bArr3[i14];
            i14++;
        }
        int i15 = -1;
        for (int length3 = bArr3.length * 2; length3 != outputBlockSize; length3++) {
            i15 += (((-(bArr4[length3] & 255)) & i15) >> 31) & length3;
        }
        int i16 = i15 + 1;
        if ((length | (i15 >> 31) | (bArr4[i16] ^ 1)) == 0) {
            int i17 = i16 + 1;
            int i18 = outputBlockSize - i17;
            byte[] bArr6 = new byte[i18];
            System.arraycopy(bArr4, i17, bArr6, 0, i18);
            Arrays.fill(bArr4, (byte) 0);
            return bArr6;
        }
        Arrays.fill(bArr4, (byte) 0);
        throw new InvalidCipherTextException("data wrong");
    }

    public byte[] encodeBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        if (i12 <= getInputBlockSize()) {
            int inputBlockSize = getInputBlockSize() + 1 + (this.defHash.length * 2);
            byte[] bArr2 = new byte[inputBlockSize];
            int i13 = inputBlockSize - i12;
            System.arraycopy(bArr, i11, bArr2, i13, i12);
            bArr2[i13 - 1] = 1;
            byte[] bArr3 = this.defHash;
            System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
            int length = this.defHash.length;
            byte[] bArr4 = new byte[length];
            this.random.nextBytes(bArr4);
            byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, length, inputBlockSize - this.defHash.length);
            for (int length2 = this.defHash.length; length2 != inputBlockSize; length2++) {
                bArr2[length2] = (byte) (bArr2[length2] ^ maskGeneratorFunction1[length2 - this.defHash.length]);
            }
            System.arraycopy(bArr4, 0, bArr2, 0, this.defHash.length);
            byte[] bArr5 = this.defHash;
            byte[] maskGeneratorFunction12 = maskGeneratorFunction1(bArr2, bArr5.length, inputBlockSize - bArr5.length, bArr5.length);
            for (int i14 = 0; i14 != this.defHash.length; i14++) {
                bArr2[i14] = (byte) (bArr2[i14] ^ maskGeneratorFunction12[i14]);
            }
            return this.engine.processBlock(bArr2, 0, inputBlockSize);
        }
        throw new DataLengthException("input data too long");
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize - 1) - (this.defHash.length * 2) : inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : (outputBlockSize - 1) - (this.defHash.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        this.random = cipherParameters instanceof ParametersWithRandom ? ((ParametersWithRandom) cipherParameters).getRandom() : CryptoServicesRegistrar.getSecureRandom();
        this.engine.init(z11, cipherParameters);
        this.forEncryption = z11;
    }

    public byte[] processBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        return this.forEncryption ? encodeBlock(bArr, i11, i12) : decodeBlock(bArr, i11, i12);
    }
}
