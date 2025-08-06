package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import net.sf.scuba.smartcards.ISO7816;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class DESedeWrapEngine implements Wrapper {
    private static final byte[] IV2 = {74, -35, -94, ISO7816.INS_UNBLOCK_CHV, 121, -24, Framer.ENTER_FRAME_PREFIX, 5};
    public byte[] digest = new byte[20];
    private CBCBlockCipher engine;
    private boolean forWrapping;

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59167iv;
    private KeyParameter param;
    private ParametersWithIV paramPlusIV;
    public Digest sha1 = DigestFactory.createSHA1();

    private byte[] calculateCMSKeyChecksum(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        this.sha1.update(bArr, 0, bArr.length);
        this.sha1.doFinal(this.digest, 0);
        System.arraycopy(this.digest, 0, bArr2, 0, 8);
        return bArr2;
    }

    private boolean checkCMSKeyChecksum(byte[] bArr, byte[] bArr2) {
        return Arrays.constantTimeAreEqual(calculateCMSKeyChecksum(bArr), bArr2);
    }

    private static byte[] reverse(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i11 = 0;
        while (i11 < bArr.length) {
            int i12 = i11 + 1;
            bArr2[i11] = bArr[bArr.length - i12];
            i11 = i12;
        }
        return bArr2;
    }

    public String getAlgorithmName() {
        return "DESede";
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        this.forWrapping = z11;
        this.engine = new CBCBlockCipher(new DESedeEngine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            CipherParameters parameters = parametersWithRandom.getParameters();
            SecureRandom random = parametersWithRandom.getRandom();
            cipherParameters = parameters;
            secureRandom = random;
        } else {
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.param = (KeyParameter) cipherParameters;
            if (this.forWrapping) {
                byte[] bArr = new byte[8];
                this.f59167iv = bArr;
                secureRandom.nextBytes(bArr);
                this.paramPlusIV = new ParametersWithIV(this.param, this.f59167iv);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.paramPlusIV = parametersWithIV;
            this.f59167iv = parametersWithIV.getIV();
            this.param = (KeyParameter) this.paramPlusIV.getParameters();
            if (this.forWrapping) {
                byte[] bArr2 = this.f59167iv;
                if (bArr2 == null || bArr2.length != 8) {
                    throw new IllegalArgumentException("IV is not 8 octets");
                }
                return;
            }
            throw new IllegalArgumentException("You should not supply an IV for unwrapping");
        }
    }

    public byte[] unwrap(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr != null) {
            int blockSize = this.engine.getBlockSize();
            if (i12 % blockSize == 0) {
                this.engine.init(false, new ParametersWithIV(this.param, IV2));
                byte[] bArr2 = new byte[i12];
                for (int i13 = 0; i13 != i12; i13 += blockSize) {
                    this.engine.processBlock(bArr, i11 + i13, bArr2, i13);
                }
                byte[] reverse = reverse(bArr2);
                byte[] bArr3 = new byte[8];
                this.f59167iv = bArr3;
                int length = reverse.length - 8;
                byte[] bArr4 = new byte[length];
                System.arraycopy(reverse, 0, bArr3, 0, 8);
                System.arraycopy(reverse, 8, bArr4, 0, reverse.length - 8);
                ParametersWithIV parametersWithIV = new ParametersWithIV(this.param, this.f59167iv);
                this.paramPlusIV = parametersWithIV;
                this.engine.init(false, parametersWithIV);
                byte[] bArr5 = new byte[length];
                for (int i14 = 0; i14 != length; i14 += blockSize) {
                    this.engine.processBlock(bArr4, i14, bArr5, i14);
                }
                int i15 = length - 8;
                byte[] bArr6 = new byte[i15];
                byte[] bArr7 = new byte[8];
                System.arraycopy(bArr5, 0, bArr6, 0, i15);
                System.arraycopy(bArr5, i15, bArr7, 0, 8);
                if (checkCMSKeyChecksum(bArr6, bArr7)) {
                    return bArr6;
                }
                throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
            }
            throw new InvalidCipherTextException("Ciphertext not multiple of " + blockSize);
        } else {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        }
    }

    public byte[] wrap(byte[] bArr, int i11, int i12) {
        if (this.forWrapping) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            byte[] calculateCMSKeyChecksum = calculateCMSKeyChecksum(bArr2);
            int length = calculateCMSKeyChecksum.length + i12;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr2, 0, bArr3, 0, i12);
            System.arraycopy(calculateCMSKeyChecksum, 0, bArr3, i12, calculateCMSKeyChecksum.length);
            int blockSize = this.engine.getBlockSize();
            if (length % blockSize == 0) {
                this.engine.init(true, this.paramPlusIV);
                byte[] bArr4 = new byte[length];
                for (int i13 = 0; i13 != length; i13 += blockSize) {
                    this.engine.processBlock(bArr3, i13, bArr4, i13);
                }
                byte[] bArr5 = this.f59167iv;
                byte[] bArr6 = new byte[(bArr5.length + length)];
                System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
                System.arraycopy(bArr4, 0, bArr6, this.f59167iv.length, length);
                byte[] reverse = reverse(bArr6);
                this.engine.init(true, new ParametersWithIV(this.param, IV2));
                for (int i14 = 0; i14 != reverse.length; i14 += blockSize) {
                    this.engine.processBlock(reverse, i14, reverse, i14);
                }
                return reverse;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
