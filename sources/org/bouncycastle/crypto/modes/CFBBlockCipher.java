package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CFBBlockCipher extends StreamBlockCipher {
    private byte[] IV;
    private int blockSize;
    private int byteCount;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher = null;
    private boolean encrypting;
    private byte[] inBuf;

    public CFBBlockCipher(BlockCipher blockCipher, int i11) {
        super(blockCipher);
        if (i11 > blockCipher.getBlockSize() * 8 || i11 < 8 || i11 % 8 != 0) {
            throw new IllegalArgumentException("CFB" + i11 + " not supported");
        }
        this.cipher = blockCipher;
        this.blockSize = i11 / 8;
        this.IV = new byte[blockCipher.getBlockSize()];
        this.cfbV = new byte[blockCipher.getBlockSize()];
        this.cfbOutV = new byte[blockCipher.getBlockSize()];
        this.inBuf = new byte[this.blockSize];
    }

    private byte decryptByte(byte b11) {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        }
        byte[] bArr = this.inBuf;
        int i11 = this.byteCount;
        bArr[i11] = b11;
        byte[] bArr2 = this.cfbOutV;
        int i12 = i11 + 1;
        this.byteCount = i12;
        byte b12 = (byte) (b11 ^ bArr2[i11]);
        int i13 = this.blockSize;
        if (i12 == i13) {
            this.byteCount = 0;
            byte[] bArr3 = this.cfbV;
            System.arraycopy(bArr3, i13, bArr3, 0, bArr3.length - i13);
            byte[] bArr4 = this.inBuf;
            byte[] bArr5 = this.cfbV;
            int length = bArr5.length;
            int i14 = this.blockSize;
            System.arraycopy(bArr4, 0, bArr5, length - i14, i14);
        }
        return b12;
    }

    private byte encryptByte(byte b11) {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        }
        byte[] bArr = this.cfbOutV;
        int i11 = this.byteCount;
        byte b12 = (byte) (b11 ^ bArr[i11]);
        byte[] bArr2 = this.inBuf;
        int i12 = i11 + 1;
        this.byteCount = i12;
        bArr2[i11] = b12;
        int i13 = this.blockSize;
        if (i12 == i13) {
            this.byteCount = 0;
            byte[] bArr3 = this.cfbV;
            System.arraycopy(bArr3, i13, bArr3, 0, bArr3.length - i13);
            byte[] bArr4 = this.inBuf;
            byte[] bArr5 = this.cfbV;
            int length = bArr5.length;
            int i14 = this.blockSize;
            System.arraycopy(bArr4, 0, bArr5, length - i14, i14);
        }
        return b12;
    }

    public byte calculateByte(byte b11) throws DataLengthException, IllegalStateException {
        return this.encrypting ? encryptByte(b11) : decryptByte(b11);
    }

    public int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i11, this.blockSize, bArr2, i12);
        return this.blockSize;
    }

    public int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i11, this.blockSize, bArr2, i12);
        return this.blockSize;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public byte[] getCurrentIV() {
        return Arrays.clone(this.cfbV);
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        this.encrypting = z11;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            int length = iv2.length;
            byte[] bArr = this.IV;
            if (length < bArr.length) {
                System.arraycopy(iv2, 0, bArr, bArr.length - iv2.length, iv2.length);
                int i11 = 0;
                while (true) {
                    byte[] bArr2 = this.IV;
                    if (i11 >= bArr2.length - iv2.length) {
                        break;
                    }
                    bArr2[i11] = 0;
                    i11++;
                }
            } else {
                System.arraycopy(iv2, 0, bArr, 0, bArr.length);
            }
            reset();
            if (parametersWithIV.getParameters() != null) {
                blockCipher = this.cipher;
                cipherParameters = parametersWithIV.getParameters();
            } else {
                return;
            }
        } else {
            reset();
            if (cipherParameters != null) {
                blockCipher = this.cipher;
            } else {
                return;
            }
        }
        blockCipher.init(true, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i11, this.blockSize, bArr2, i12);
        return this.blockSize;
    }

    public void reset() {
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.cfbV, 0, bArr.length);
        Arrays.fill(this.inBuf, (byte) 0);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
