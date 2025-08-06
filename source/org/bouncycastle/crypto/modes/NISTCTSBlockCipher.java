package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

public class NISTCTSBlockCipher extends BufferedBlockCipher {
    public static final int CS1 = 1;
    public static final int CS2 = 2;
    public static final int CS3 = 3;
    private final int blockSize;
    private final int type;

    public NISTCTSBlockCipher(int i11, BlockCipher blockCipher) {
        this.type = i11;
        this.cipher = new CBCBlockCipher(blockCipher);
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.buf = new byte[(blockSize2 * 2)];
        this.bufOff = 0;
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        if (this.bufOff + i11 <= bArr.length) {
            int blockSize2 = this.cipher.getBlockSize();
            int i12 = this.bufOff;
            int i13 = i12 - blockSize2;
            byte[] bArr2 = new byte[blockSize2];
            if (this.forEncryption) {
                if (i12 < blockSize2) {
                    throw new DataLengthException("need at least one block of input for NISTCTS");
                } else if (i12 > blockSize2) {
                    byte[] bArr3 = new byte[blockSize2];
                    int i14 = this.type;
                    if (i14 == 2 || i14 == 3) {
                        this.cipher.processBlock(this.buf, 0, bArr2, 0);
                        System.arraycopy(this.buf, blockSize2, bArr3, 0, i13);
                        this.cipher.processBlock(bArr3, 0, bArr3, 0);
                        if (this.type == 2 && i13 == blockSize2) {
                            System.arraycopy(bArr2, 0, bArr, i11, blockSize2);
                            System.arraycopy(bArr3, 0, bArr, i11 + blockSize2, i13);
                        } else {
                            System.arraycopy(bArr3, 0, bArr, i11, blockSize2);
                            System.arraycopy(bArr2, 0, bArr, i11 + blockSize2, i13);
                        }
                        int i15 = this.bufOff;
                        reset();
                        return i15;
                    }
                    System.arraycopy(this.buf, 0, bArr2, 0, blockSize2);
                    this.cipher.processBlock(bArr2, 0, bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i11, i13);
                    System.arraycopy(this.buf, this.bufOff - i13, bArr3, 0, i13);
                    this.cipher.processBlock(bArr3, 0, bArr3, 0);
                    System.arraycopy(bArr3, 0, bArr, i11 + i13, blockSize2);
                    int i152 = this.bufOff;
                    reset();
                    return i152;
                } else {
                    this.cipher.processBlock(this.buf, 0, bArr2, 0);
                }
            } else if (i12 >= blockSize2) {
                byte[] bArr4 = new byte[blockSize2];
                if (i12 > blockSize2) {
                    int i16 = this.type;
                    if (i16 == 3 || (i16 == 2 && (this.buf.length - i12) % blockSize2 != 0)) {
                        BlockCipher blockCipher = this.cipher;
                        if (blockCipher instanceof CBCBlockCipher) {
                            ((CBCBlockCipher) blockCipher).getUnderlyingCipher().processBlock(this.buf, 0, bArr2, 0);
                        } else {
                            blockCipher.processBlock(this.buf, 0, bArr2, 0);
                        }
                        for (int i17 = blockSize2; i17 != this.bufOff; i17++) {
                            int i18 = i17 - blockSize2;
                            bArr4[i18] = (byte) (bArr2[i18] ^ this.buf[i17]);
                        }
                        System.arraycopy(this.buf, blockSize2, bArr2, 0, i13);
                        this.cipher.processBlock(bArr2, 0, bArr, i11);
                    } else {
                        ((CBCBlockCipher) this.cipher).getUnderlyingCipher().processBlock(this.buf, this.bufOff - blockSize2, bArr4, 0);
                        System.arraycopy(this.buf, 0, bArr2, 0, blockSize2);
                        if (i13 != blockSize2) {
                            System.arraycopy(bArr4, i13, bArr2, i13, blockSize2 - i13);
                        }
                        this.cipher.processBlock(bArr2, 0, bArr2, 0);
                        System.arraycopy(bArr2, 0, bArr, i11, blockSize2);
                        for (int i19 = 0; i19 != i13; i19++) {
                            bArr4[i19] = (byte) (bArr4[i19] ^ this.buf[i19]);
                        }
                    }
                    System.arraycopy(bArr4, 0, bArr, i11 + blockSize2, i13);
                    int i1522 = this.bufOff;
                    reset();
                    return i1522;
                }
                this.cipher.processBlock(this.buf, 0, bArr2, 0);
            } else {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            System.arraycopy(bArr2, 0, bArr, i11, blockSize2);
            int i15222 = this.bufOff;
            reset();
            return i15222;
        }
        throw new OutputLengthException("output buffer to small in doFinal");
    }

    public int getOutputSize(int i11) {
        return i11 + this.bufOff;
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
            byte[] bArr3 = this.buf;
            int i14 = this.blockSize;
            System.arraycopy(bArr3, i14, bArr3, 0, i14);
            this.bufOff = this.blockSize;
            i13 = processBlock;
        }
        byte[] bArr4 = this.buf;
        int i15 = this.bufOff;
        this.bufOff = i15 + 1;
        bArr4[i15] = b11;
        return i13;
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException, IllegalStateException {
        if (i12 >= 0) {
            int blockSize2 = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i12);
            if (updateOutputSize <= 0 || updateOutputSize + i13 <= bArr2.length) {
                byte[] bArr3 = this.buf;
                int length = bArr3.length;
                int i14 = this.bufOff;
                int i15 = length - i14;
                int i16 = 0;
                if (i12 > i15) {
                    System.arraycopy(bArr, i11, bArr3, i14, i15);
                    int processBlock = this.cipher.processBlock(this.buf, 0, bArr2, i13) + 0;
                    byte[] bArr4 = this.buf;
                    System.arraycopy(bArr4, blockSize2, bArr4, 0, blockSize2);
                    this.bufOff = blockSize2;
                    i12 -= i15;
                    i11 += i15;
                    while (i12 > blockSize2) {
                        System.arraycopy(bArr, i11, this.buf, this.bufOff, blockSize2);
                        processBlock += this.cipher.processBlock(this.buf, 0, bArr2, i13 + processBlock);
                        byte[] bArr5 = this.buf;
                        System.arraycopy(bArr5, blockSize2, bArr5, 0, blockSize2);
                        i12 -= blockSize2;
                        i11 += blockSize2;
                    }
                    i16 = processBlock;
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
