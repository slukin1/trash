package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

public class OpenPGPCFBBlockCipher implements BlockCipher {
    private byte[] FR;
    private byte[] FRE;
    private byte[] IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;

    public OpenPGPCFBBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.IV = new byte[blockSize2];
        this.FR = new byte[blockSize2];
        this.FRE = new byte[blockSize2];
    }

    private int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        int i13;
        int i14;
        int i15;
        int i16 = this.blockSize;
        if (i11 + i16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i16 <= bArr2.length) {
            int i17 = this.count;
            int i18 = 2;
            int i19 = 0;
            if (i17 > i16) {
                byte b11 = bArr[i11];
                this.FR[i16 - 2] = b11;
                bArr2[i12] = encryptByte(b11, i16 - 2);
                byte b12 = bArr[i11 + 1];
                byte[] bArr3 = this.FR;
                int i21 = this.blockSize;
                bArr3[i21 - 1] = b12;
                bArr2[i12 + 1] = encryptByte(b12, i21 - 1);
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                while (i18 < this.blockSize) {
                    byte b13 = bArr[i11 + i18];
                    int i22 = i18 - 2;
                    this.FR[i22] = b13;
                    bArr2[i12 + i18] = encryptByte(b13, i22);
                    i18++;
                }
            } else {
                if (i17 == 0) {
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    while (true) {
                        i15 = this.blockSize;
                        if (i19 >= i15) {
                            break;
                        }
                        int i23 = i11 + i19;
                        this.FR[i19] = bArr[i23];
                        bArr2[i19] = encryptByte(bArr[i23], i19);
                        i19++;
                    }
                    i14 = this.count + i15;
                } else if (i17 == i16) {
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    byte b14 = bArr[i11];
                    byte b15 = bArr[i11 + 1];
                    bArr2[i12] = encryptByte(b14, 0);
                    bArr2[i12 + 1] = encryptByte(b15, 1);
                    byte[] bArr4 = this.FR;
                    System.arraycopy(bArr4, 2, bArr4, 0, this.blockSize - 2);
                    byte[] bArr5 = this.FR;
                    int i24 = this.blockSize;
                    bArr5[i24 - 2] = b14;
                    bArr5[i24 - 1] = b15;
                    this.cipher.processBlock(bArr5, 0, this.FRE, 0);
                    while (true) {
                        i13 = this.blockSize;
                        if (i18 >= i13) {
                            break;
                        }
                        byte b16 = bArr[i11 + i18];
                        int i25 = i18 - 2;
                        this.FR[i25] = b16;
                        bArr2[i12 + i18] = encryptByte(b16, i25);
                        i18++;
                    }
                    i14 = this.count + i13;
                }
                this.count = i14;
            }
            return this.blockSize;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    private int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        int i13;
        int i14 = this.blockSize;
        if (i11 + i14 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i14 <= bArr2.length) {
            int i15 = this.count;
            int i16 = 2;
            int i17 = 0;
            if (i15 > i14) {
                byte[] bArr3 = this.FR;
                int i18 = i14 - 2;
                byte encryptByte = encryptByte(bArr[i11], i14 - 2);
                bArr2[i12] = encryptByte;
                bArr3[i18] = encryptByte;
                byte[] bArr4 = this.FR;
                int i19 = this.blockSize;
                int i21 = i19 - 1;
                byte encryptByte2 = encryptByte(bArr[i11 + 1], i19 - 1);
                bArr2[i12 + 1] = encryptByte2;
                bArr4[i21] = encryptByte2;
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                while (i16 < this.blockSize) {
                    byte[] bArr5 = this.FR;
                    int i22 = i16 - 2;
                    byte encryptByte3 = encryptByte(bArr[i11 + i16], i22);
                    bArr2[i12 + i16] = encryptByte3;
                    bArr5[i22] = encryptByte3;
                    i16++;
                }
            } else {
                if (i15 != 0) {
                    if (i15 == i14) {
                        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                        bArr2[i12] = encryptByte(bArr[i11], 0);
                        bArr2[i12 + 1] = encryptByte(bArr[i11 + 1], 1);
                        byte[] bArr6 = this.FR;
                        System.arraycopy(bArr6, 2, bArr6, 0, this.blockSize - 2);
                        System.arraycopy(bArr2, i12, this.FR, this.blockSize - 2, 2);
                        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                        while (true) {
                            i13 = this.blockSize;
                            if (i16 >= i13) {
                                break;
                            }
                            byte[] bArr7 = this.FR;
                            int i23 = i16 - 2;
                            byte encryptByte4 = encryptByte(bArr[i11 + i16], i23);
                            bArr2[i12 + i16] = encryptByte4;
                            bArr7[i23] = encryptByte4;
                            i16++;
                        }
                    }
                } else {
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    while (true) {
                        i13 = this.blockSize;
                        if (i17 >= i13) {
                            break;
                        }
                        byte[] bArr8 = this.FR;
                        byte encryptByte5 = encryptByte(bArr[i11 + i17], i17);
                        bArr2[i12 + i17] = encryptByte5;
                        bArr8[i17] = encryptByte5;
                        i17++;
                    }
                }
                this.count += i13;
            }
            return this.blockSize;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    private byte encryptByte(byte b11, int i11) {
        return (byte) (b11 ^ this.FRE[i11]);
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OpenPGPCFB";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = z11;
        reset();
        this.cipher.init(true, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        return this.forEncryption ? encryptBlock(bArr, i11, bArr2, i12) : decryptBlock(bArr, i11, bArr2, i12);
    }

    public void reset() {
        this.count = 0;
        byte[] bArr = this.IV;
        byte[] bArr2 = this.FR;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.cipher.reset();
    }
}
