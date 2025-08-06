package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

public class KXTSBlockCipher extends BufferedBlockCipher {
    private static final long RED_POLY_128 = 135;
    private static final long RED_POLY_256 = 1061;
    private static final long RED_POLY_512 = 293;
    private final int blockSize;
    private int counter = -1;
    private final long reductionPolynomial;
    private final long[] tw_current;
    private final long[] tw_init;

    public KXTSBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.reductionPolynomial = getReductionPolynomial(blockSize2);
        this.tw_init = new long[(blockSize2 >>> 3)];
        this.tw_current = new long[(blockSize2 >>> 3)];
    }

    private static void GF_double(long j11, long[] jArr) {
        long j12 = 0;
        int i11 = 0;
        while (i11 < jArr.length) {
            long j13 = jArr[i11];
            jArr[i11] = j12 ^ (j13 << 1);
            i11++;
            j12 = j13 >>> 63;
        }
        jArr[0] = (j11 & (-j12)) ^ jArr[0];
    }

    public static long getReductionPolynomial(int i11) {
        if (i11 == 16) {
            return RED_POLY_128;
        }
        if (i11 == 32) {
            return RED_POLY_256;
        }
        if (i11 == 64) {
            return RED_POLY_512;
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    private void processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = this.counter;
        if (i13 != -1) {
            this.counter = i13 + 1;
            GF_double(this.reductionPolynomial, this.tw_current);
            byte[] bArr3 = new byte[this.blockSize];
            Pack.longToLittleEndian(this.tw_current, bArr3, 0);
            int i14 = this.blockSize;
            byte[] bArr4 = new byte[i14];
            System.arraycopy(bArr3, 0, bArr4, 0, i14);
            for (int i15 = 0; i15 < this.blockSize; i15++) {
                bArr4[i15] = (byte) (bArr4[i15] ^ bArr[i11 + i15]);
            }
            this.cipher.processBlock(bArr4, 0, bArr4, 0);
            for (int i16 = 0; i16 < this.blockSize; i16++) {
                bArr2[i12 + i16] = (byte) (bArr4[i16] ^ bArr3[i16]);
            }
            return;
        }
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    public int doFinal(byte[] bArr, int i11) {
        reset();
        return 0;
    }

    public int getOutputSize(int i11) {
        return i11;
    }

    public int getUpdateOutputSize(int i11) {
        return i11;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            CipherParameters parameters = parametersWithIV.getParameters();
            byte[] iv2 = parametersWithIV.getIV();
            int length = iv2.length;
            int i11 = this.blockSize;
            if (length == i11) {
                byte[] bArr = new byte[i11];
                System.arraycopy(iv2, 0, bArr, 0, i11);
                this.cipher.init(true, parameters);
                this.cipher.processBlock(bArr, 0, bArr, 0);
                this.cipher.init(z11, parameters);
                Pack.littleEndianToLong(bArr, 0, this.tw_init);
                long[] jArr = this.tw_init;
                System.arraycopy(jArr, 0, this.tw_current, 0, jArr.length);
                this.counter = 0;
                return;
            }
            throw new IllegalArgumentException("Currently only support IVs of exactly one block");
        }
        throw new IllegalArgumentException("Invalid parameters passed");
    }

    public int processByte(byte b11, byte[] bArr, int i11) {
        throw new IllegalStateException("unsupported operation");
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        if (bArr.length - i11 < i12) {
            throw new DataLengthException("Input buffer too short");
        } else if (bArr2.length - i11 < i12) {
            throw new OutputLengthException("Output buffer too short");
        } else if (i12 % this.blockSize == 0) {
            int i14 = 0;
            while (i14 < i12) {
                processBlock(bArr, i11 + i14, bArr2, i13 + i14);
                i14 += this.blockSize;
            }
            return i12;
        } else {
            throw new IllegalArgumentException("Partial blocks not supported");
        }
    }

    public void reset() {
        this.cipher.reset();
        long[] jArr = this.tw_init;
        System.arraycopy(jArr, 0, this.tw_current, 0, jArr.length);
        this.counter = 0;
    }
}
