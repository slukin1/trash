package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class SICBlockCipher extends StreamBlockCipher implements SkippingStreamCipher {
    private byte[] IV;
    private final int blockSize;
    private int byteCount = 0;
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    public SICBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.IV = new byte[blockSize2];
        this.counter = new byte[blockSize2];
        this.counterOut = new byte[blockSize2];
    }

    private void adjustCounter(long j11) {
        int i11 = 5;
        if (j11 >= 0) {
            long j12 = (((long) this.byteCount) + j11) / ((long) this.blockSize);
            long j13 = j12;
            if (j12 > 255) {
                while (i11 >= 1) {
                    long j14 = 1 << (i11 * 8);
                    while (j13 >= j14) {
                        incrementCounterAt(i11);
                        j13 -= j14;
                    }
                    i11--;
                }
            }
            incrementCounter((int) j13);
            this.byteCount = (int) ((j11 + ((long) this.byteCount)) - (((long) this.blockSize) * j12));
            return;
        }
        long j15 = ((-j11) - ((long) this.byteCount)) / ((long) this.blockSize);
        long j16 = j15;
        if (j15 > 255) {
            while (i11 >= 1) {
                long j17 = 1 << (i11 * 8);
                while (j16 > j17) {
                    decrementCounterAt(i11);
                    j16 -= j17;
                }
                i11--;
            }
        }
        for (long j18 = 0; j18 != j16; j18++) {
            decrementCounterAt(0);
        }
        int i12 = (int) (((long) this.byteCount) + j11 + (((long) this.blockSize) * j15));
        if (i12 >= 0) {
            this.byteCount = 0;
            return;
        }
        decrementCounterAt(0);
        this.byteCount = this.blockSize + i12;
    }

    private void checkCounter() {
        if (this.IV.length < this.blockSize) {
            int i11 = 0;
            while (true) {
                byte[] bArr = this.IV;
                if (i11 == bArr.length) {
                    return;
                }
                if (this.counter[i11] == bArr[i11]) {
                    i11++;
                } else {
                    throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                }
            }
        }
    }

    private void decrementCounterAt(int i11) {
        byte b11;
        int length = this.counter.length - i11;
        do {
            length--;
            if (length >= 0) {
                byte[] bArr = this.counter;
                b11 = (byte) (bArr[length] - 1);
                bArr[length] = b11;
            } else {
                return;
            }
        } while (b11 == -1);
    }

    private void incrementCounter(int i11) {
        byte[] bArr = this.counter;
        byte b11 = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] + i11);
        if (b11 != 0 && bArr[bArr.length - 1] < b11) {
            incrementCounterAt(1);
        }
    }

    private void incrementCounterAt(int i11) {
        byte b11;
        int length = this.counter.length - i11;
        do {
            length--;
            if (length >= 0) {
                byte[] bArr = this.counter;
                b11 = (byte) (bArr[length] + 1);
                bArr[length] = b11;
            } else {
                return;
            }
        } while (b11 == 0);
    }

    private void incrementCounterChecked() {
        byte b11;
        int length = this.counter.length;
        do {
            length--;
            if (length < 0) {
                break;
            }
            byte[] bArr = this.counter;
            b11 = (byte) (bArr[length] + 1);
            bArr[length] = b11;
        } while (b11 == 0);
        byte[] bArr2 = this.IV;
        if (length < bArr2.length && bArr2.length < this.blockSize) {
            throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
        }
    }

    public byte calculateByte(byte b11) throws DataLengthException, IllegalStateException {
        int i11 = this.byteCount;
        if (i11 == 0) {
            this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
            byte[] bArr = this.counterOut;
            int i12 = this.byteCount;
            this.byteCount = i12 + 1;
            return (byte) (b11 ^ bArr[i12]);
        }
        byte[] bArr2 = this.counterOut;
        int i13 = i11 + 1;
        this.byteCount = i13;
        byte b12 = (byte) (b11 ^ bArr2[i11]);
        if (i13 == this.counter.length) {
            this.byteCount = 0;
            incrementCounterChecked();
        }
        return b12;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/SIC";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public long getPosition() {
        byte[] bArr = this.counter;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i11 = length - 1;
        while (i11 >= 1) {
            byte[] bArr3 = this.IV;
            int i12 = i11 < bArr3.length ? (bArr2[i11] & 255) - (bArr3[i11] & 255) : bArr2[i11] & 255;
            if (i12 < 0) {
                int i13 = i11 - 1;
                bArr2[i13] = (byte) (bArr2[i13] - 1);
                i12 += 256;
            }
            bArr2[i11] = (byte) i12;
            i11--;
        }
        return (Pack.bigEndianToLong(bArr2, length - 8) * ((long) this.blockSize)) + ((long) this.byteCount);
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] clone = Arrays.clone(parametersWithIV.getIV());
            this.IV = clone;
            int i11 = this.blockSize;
            if (i11 >= clone.length) {
                int i12 = 8;
                if (8 > i11 / 2) {
                    i12 = i11 / 2;
                }
                if (i11 - clone.length <= i12) {
                    if (parametersWithIV.getParameters() != null) {
                        this.cipher.init(true, parametersWithIV.getParameters());
                    }
                    reset();
                    return;
                }
                throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.blockSize - i12) + " bytes.");
            }
            throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + this.blockSize + " bytes.");
        }
        throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (this.byteCount != 0) {
            processBytes(bArr, i11, this.blockSize, bArr2, i12);
        } else {
            int i13 = this.blockSize;
            if (i11 + i13 > bArr.length) {
                throw new DataLengthException("input buffer too small");
            } else if (i13 + i12 <= bArr2.length) {
                this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
                for (int i14 = 0; i14 < this.blockSize; i14++) {
                    bArr2[i12 + i14] = (byte) (bArr[i11 + i14] ^ this.counterOut[i14]);
                }
                incrementCounterChecked();
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        }
        return this.blockSize;
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException {
        byte b11;
        if (i11 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        } else if (i13 + i12 <= bArr2.length) {
            for (int i14 = 0; i14 < i12; i14++) {
                int i15 = this.byteCount;
                if (i15 == 0) {
                    this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
                    byte b12 = bArr[i11 + i14];
                    byte[] bArr3 = this.counterOut;
                    int i16 = this.byteCount;
                    this.byteCount = i16 + 1;
                    b11 = (byte) (b12 ^ bArr3[i16]);
                } else {
                    byte b13 = bArr[i11 + i14];
                    byte[] bArr4 = this.counterOut;
                    int i17 = i15 + 1;
                    this.byteCount = i17;
                    b11 = (byte) (bArr4[i15] ^ b13);
                    if (i17 == this.counter.length) {
                        this.byteCount = 0;
                        incrementCounterChecked();
                    }
                }
                bArr2[i13 + i14] = b11;
            }
            return i12;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        Arrays.fill(this.counter, (byte) 0);
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.counter, 0, bArr.length);
        this.cipher.reset();
        this.byteCount = 0;
    }

    public long seekTo(long j11) {
        reset();
        return skip(j11);
    }

    public long skip(long j11) {
        adjustCounter(j11);
        checkCounter();
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        return j11;
    }
}
