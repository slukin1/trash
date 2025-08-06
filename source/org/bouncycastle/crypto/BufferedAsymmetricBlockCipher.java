package org.bouncycastle.crypto;

public class BufferedAsymmetricBlockCipher {
    public byte[] buf;
    public int bufOff;
    private final AsymmetricBlockCipher cipher;

    public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.cipher = asymmetricBlockCipher;
    }

    public byte[] doFinal() throws InvalidCipherTextException {
        byte[] processBlock = this.cipher.processBlock(this.buf, 0, this.bufOff);
        reset();
        return processBlock;
    }

    public int getBufferPosition() {
        return this.bufOff;
    }

    public int getInputBlockSize() {
        return this.cipher.getInputBlockSize();
    }

    public int getOutputBlockSize() {
        return this.cipher.getOutputBlockSize();
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        reset();
        this.cipher.init(z11, cipherParameters);
        this.buf = new byte[(this.cipher.getInputBlockSize() + (z11 ? 1 : 0))];
        this.bufOff = 0;
    }

    public void processByte(byte b11) {
        int i11 = this.bufOff;
        byte[] bArr = this.buf;
        if (i11 < bArr.length) {
            this.bufOff = i11 + 1;
            bArr[i11] = b11;
            return;
        }
        throw new DataLengthException("attempt to process message too long for cipher");
    }

    public void processBytes(byte[] bArr, int i11, int i12) {
        if (i12 != 0) {
            if (i12 >= 0) {
                int i13 = this.bufOff;
                int i14 = i13 + i12;
                byte[] bArr2 = this.buf;
                if (i14 <= bArr2.length) {
                    System.arraycopy(bArr, i11, bArr2, i13, i12);
                    this.bufOff += i12;
                    return;
                }
                throw new DataLengthException("attempt to process message too long for cipher");
            }
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
    }

    public void reset() {
        if (this.buf != null) {
            int i11 = 0;
            while (true) {
                byte[] bArr = this.buf;
                if (i11 >= bArr.length) {
                    break;
                }
                bArr[i11] = 0;
                i11++;
            }
        }
        this.bufOff = 0;
    }
}
