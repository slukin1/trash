package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class RFC3211WrapEngine implements Wrapper {
    private CBCBlockCipher engine;
    private boolean forWrapping;
    private ParametersWithIV param;
    private SecureRandom rand;

    public RFC3211WrapEngine(BlockCipher blockCipher) {
        this.engine = new CBCBlockCipher(blockCipher);
    }

    public String getAlgorithmName() {
        return this.engine.getUnderlyingCipher().getAlgorithmName() + "/RFC3211Wrap";
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        this.forWrapping = z11;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.rand = parametersWithRandom.getRandom();
            if (parametersWithRandom.getParameters() instanceof ParametersWithIV) {
                this.param = (ParametersWithIV) parametersWithRandom.getParameters();
                return;
            }
            throw new IllegalArgumentException("RFC3211Wrap requires an IV");
        }
        if (z11) {
            this.rand = CryptoServicesRegistrar.getSecureRandom();
        }
        if (cipherParameters instanceof ParametersWithIV) {
            this.param = (ParametersWithIV) cipherParameters;
            return;
        }
        throw new IllegalArgumentException("RFC3211Wrap requires an IV");
    }

    public byte[] unwrap(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        if (!this.forWrapping) {
            int blockSize = this.engine.getBlockSize();
            if (i12 >= blockSize * 2) {
                byte[] bArr2 = new byte[i12];
                byte[] bArr3 = new byte[blockSize];
                boolean z11 = false;
                System.arraycopy(bArr, i11, bArr2, 0, i12);
                System.arraycopy(bArr, i11, bArr3, 0, blockSize);
                this.engine.init(false, new ParametersWithIV(this.param.getParameters(), bArr3));
                for (int i13 = blockSize; i13 < i12; i13 += blockSize) {
                    this.engine.processBlock(bArr2, i13, bArr2, i13);
                }
                System.arraycopy(bArr2, i12 - blockSize, bArr3, 0, blockSize);
                this.engine.init(false, new ParametersWithIV(this.param.getParameters(), bArr3));
                this.engine.processBlock(bArr2, 0, bArr2, 0);
                this.engine.init(false, this.param);
                for (int i14 = 0; i14 < i12; i14 += blockSize) {
                    this.engine.processBlock(bArr2, i14, bArr2, i14);
                }
                int i15 = i12 - 4;
                boolean z12 = (bArr2[0] & 255) > i15;
                if (!z12) {
                    i15 = bArr2[0] & 255;
                }
                byte[] bArr4 = new byte[i15];
                System.arraycopy(bArr2, 4, bArr4, 0, bArr4.length);
                int i16 = 0;
                byte b11 = 0;
                while (i16 != 3) {
                    int i17 = i16 + 1;
                    b11 |= bArr2[i16 + 4] ^ ((byte) (~bArr2[i17]));
                    i16 = i17;
                }
                Arrays.clear(bArr2);
                if (b11 != 0) {
                    z11 = true;
                }
                if (!z12 && !z11) {
                    return bArr4;
                }
                throw new InvalidCipherTextException("wrapped key corrupted");
            }
            throw new InvalidCipherTextException("input too short");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    public byte[] wrap(byte[] bArr, int i11, int i12) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        } else if (i12 > 255 || i12 < 0) {
            throw new IllegalArgumentException("input must be from 0 to 255 bytes");
        } else {
            this.engine.init(true, this.param);
            int blockSize = this.engine.getBlockSize();
            int i13 = i12 + 4;
            int i14 = blockSize * 2;
            if (i13 >= i14) {
                i14 = i13 % blockSize == 0 ? i13 : ((i13 / blockSize) + 1) * blockSize;
            }
            byte[] bArr2 = new byte[i14];
            bArr2[0] = (byte) i12;
            System.arraycopy(bArr, i11, bArr2, 4, i12);
            int length = bArr2.length - i13;
            byte[] bArr3 = new byte[length];
            this.rand.nextBytes(bArr3);
            System.arraycopy(bArr3, 0, bArr2, i13, length);
            bArr2[1] = (byte) (~bArr2[4]);
            bArr2[2] = (byte) (~bArr2[5]);
            bArr2[3] = (byte) (~bArr2[6]);
            for (int i15 = 0; i15 < bArr2.length; i15 += blockSize) {
                this.engine.processBlock(bArr2, i15, bArr2, i15);
            }
            for (int i16 = 0; i16 < bArr2.length; i16 += blockSize) {
                this.engine.processBlock(bArr2, i16, bArr2, i16);
            }
            return bArr2;
        }
    }
}
