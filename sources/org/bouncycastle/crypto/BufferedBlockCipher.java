package org.bouncycastle.crypto;

public class BufferedBlockCipher {
    public byte[] buf;
    public int bufOff;
    public BlockCipher cipher;
    public boolean forEncryption;
    public boolean partialBlockOkay;
    public boolean pgpCFB;

    public BufferedBlockCipher() {
    }

    public BufferedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.buf = new byte[blockCipher.getBlockSize()];
        boolean z11 = false;
        this.bufOff = 0;
        String algorithmName = blockCipher.getAlgorithmName();
        int indexOf = algorithmName.indexOf(47) + 1;
        boolean z12 = indexOf > 0 && algorithmName.startsWith("PGP", indexOf);
        this.pgpCFB = z12;
        if (z12 || (blockCipher instanceof StreamCipher)) {
            this.partialBlockOkay = true;
            return;
        }
        if (indexOf > 0 && algorithmName.startsWith("OpenPGP", indexOf)) {
            z11 = true;
        }
        this.partialBlockOkay = z11;
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        try {
            int i12 = this.bufOff;
            if (i11 + i12 <= bArr.length) {
                int i13 = 0;
                if (i12 != 0) {
                    if (this.partialBlockOkay) {
                        BlockCipher blockCipher = this.cipher;
                        byte[] bArr2 = this.buf;
                        blockCipher.processBlock(bArr2, 0, bArr2, 0);
                        int i14 = this.bufOff;
                        this.bufOff = 0;
                        System.arraycopy(this.buf, 0, bArr, i11, i14);
                        i13 = i14;
                    } else {
                        throw new DataLengthException("data not block size aligned");
                    }
                }
                return i13;
            }
            throw new OutputLengthException("output buffer too short for doFinal()");
        } finally {
            reset();
        }
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public int getOutputSize(int i11) {
        return i11 + this.bufOff;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int getUpdateOutputSize(int i11) {
        int i12;
        int i13;
        int i14 = i11 + this.bufOff;
        if (!this.pgpCFB) {
            i13 = this.buf.length;
        } else if (this.forEncryption) {
            i12 = (i14 % this.buf.length) - (this.cipher.getBlockSize() + 2);
            return i14 - i12;
        } else {
            i13 = this.buf.length;
        }
        i12 = i14 % i13;
        return i14 - i12;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = z11;
        reset();
        this.cipher.init(z11, cipherParameters);
    }

    public int processByte(byte b11, byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        byte[] bArr2 = this.buf;
        int i12 = this.bufOff;
        int i13 = i12 + 1;
        this.bufOff = i13;
        bArr2[i12] = b11;
        if (i13 != bArr2.length) {
            return 0;
        }
        int processBlock = this.cipher.processBlock(bArr2, 0, bArr, i11);
        this.bufOff = 0;
        return processBlock;
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException, IllegalStateException {
        int i14;
        if (i12 >= 0) {
            int blockSize = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i12);
            if (updateOutputSize <= 0 || updateOutputSize + i13 <= bArr2.length) {
                byte[] bArr3 = this.buf;
                int length = bArr3.length;
                int i15 = this.bufOff;
                int i16 = length - i15;
                if (i12 > i16) {
                    System.arraycopy(bArr, i11, bArr3, i15, i16);
                    i14 = this.cipher.processBlock(this.buf, 0, bArr2, i13) + 0;
                    this.bufOff = 0;
                    i12 -= i16;
                    i11 += i16;
                    while (i12 > this.buf.length) {
                        i14 += this.cipher.processBlock(bArr, i11, bArr2, i13 + i14);
                        i12 -= blockSize;
                        i11 += blockSize;
                    }
                } else {
                    i14 = 0;
                }
                System.arraycopy(bArr, i11, this.buf, this.bufOff, i12);
                int i17 = this.bufOff + i12;
                this.bufOff = i17;
                byte[] bArr4 = this.buf;
                if (i17 != bArr4.length) {
                    return i14;
                }
                int processBlock = i14 + this.cipher.processBlock(bArr4, 0, bArr2, i13 + i14);
                this.bufOff = 0;
                return processBlock;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public void reset() {
        int i11 = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i11 < bArr.length) {
                bArr[i11] = 0;
                i11++;
            } else {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            }
        }
    }
}
