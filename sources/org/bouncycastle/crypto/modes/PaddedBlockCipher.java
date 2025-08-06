package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

public class PaddedBlockCipher extends BufferedBlockCipher {
    public PaddedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.buf = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int i12;
        int i13;
        int blockSize = this.cipher.getBlockSize();
        if (this.forEncryption) {
            if (this.bufOff != blockSize) {
                i13 = 0;
            } else if ((blockSize * 2) + i11 <= bArr.length) {
                i13 = this.cipher.processBlock(this.buf, 0, bArr, i11);
                this.bufOff = 0;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
            byte b11 = (byte) (blockSize - this.bufOff);
            while (true) {
                int i14 = this.bufOff;
                if (i14 >= blockSize) {
                    break;
                }
                this.buf[i14] = b11;
                this.bufOff = i14 + 1;
            }
            i12 = i13 + this.cipher.processBlock(this.buf, 0, bArr, i11 + i13);
        } else if (this.bufOff == blockSize) {
            BlockCipher blockCipher = this.cipher;
            byte[] bArr2 = this.buf;
            int processBlock = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            this.bufOff = 0;
            byte[] bArr3 = this.buf;
            byte b12 = bArr3[blockSize - 1] & 255;
            if (b12 <= blockSize) {
                i12 = processBlock - b12;
                System.arraycopy(bArr3, 0, bArr, i11, i12);
            } else {
                throw new InvalidCipherTextException("pad block corrupted");
            }
        } else {
            throw new DataLengthException("last block incomplete in decryption");
        }
        reset();
        return i12;
    }

    public int getOutputSize(int i11) {
        int i12 = i11 + this.bufOff;
        byte[] bArr = this.buf;
        int length = i12 % bArr.length;
        if (length != 0) {
            i12 -= length;
        } else if (!this.forEncryption) {
            return i12;
        }
        return i12 + bArr.length;
    }

    public int getUpdateOutputSize(int i11) {
        int i12 = i11 + this.bufOff;
        byte[] bArr = this.buf;
        int length = i12 % bArr.length;
        return length == 0 ? i12 - bArr.length : i12 - length;
    }

    public int processByte(byte b11, byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        int i12 = this.bufOff;
        byte[] bArr2 = this.buf;
        int i13 = 0;
        if (i12 == bArr2.length) {
            int processBlock = this.cipher.processBlock(bArr2, 0, bArr, i11);
            this.bufOff = 0;
            i13 = processBlock;
        }
        byte[] bArr3 = this.buf;
        int i14 = this.bufOff;
        this.bufOff = i14 + 1;
        bArr3[i14] = b11;
        return i13;
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException, IllegalStateException {
        if (i12 >= 0) {
            int blockSize = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i12);
            if (updateOutputSize <= 0 || updateOutputSize + i13 <= bArr2.length) {
                byte[] bArr3 = this.buf;
                int length = bArr3.length;
                int i14 = this.bufOff;
                int i15 = length - i14;
                int i16 = 0;
                if (i12 > i15) {
                    System.arraycopy(bArr, i11, bArr3, i14, i15);
                    this.bufOff = 0;
                    i12 -= i15;
                    i11 += i15;
                    i16 = this.cipher.processBlock(this.buf, 0, bArr2, i13) + 0;
                    while (i12 > this.buf.length) {
                        i16 += this.cipher.processBlock(bArr, i11, bArr2, i13 + i16);
                        i12 -= blockSize;
                        i11 += blockSize;
                    }
                }
                System.arraycopy(bArr, i11, this.buf, this.bufOff, i12);
                this.bufOff += i12;
                return i16;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
