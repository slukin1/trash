package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;

public class CFBBlockCipherMac implements Mac {
    private byte[] buf;
    private int bufOff;
    private MacCFBBlockCipher cipher;
    private byte[] mac;
    private int macSize;
    private BlockCipherPadding padding;

    public CFBBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, (BlockCipherPadding) null);
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i11, int i12) {
        this(blockCipher, i11, i12, (BlockCipherPadding) null);
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i11, int i12, BlockCipherPadding blockCipherPadding) {
        this.padding = null;
        if (i12 % 8 == 0) {
            this.mac = new byte[blockCipher.getBlockSize()];
            MacCFBBlockCipher macCFBBlockCipher = new MacCFBBlockCipher(blockCipher, i11);
            this.cipher = macCFBBlockCipher;
            this.padding = blockCipherPadding;
            this.macSize = i12 / 8;
            this.buf = new byte[macCFBBlockCipher.getBlockSize()];
            this.bufOff = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }

    public int doFinal(byte[] bArr, int i11) {
        int blockSize = this.cipher.getBlockSize();
        BlockCipherPadding blockCipherPadding = this.padding;
        if (blockCipherPadding == null) {
            while (true) {
                int i12 = this.bufOff;
                if (i12 >= blockSize) {
                    break;
                }
                this.buf[i12] = 0;
                this.bufOff = i12 + 1;
            }
        } else {
            blockCipherPadding.addPadding(this.buf, this.bufOff);
        }
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        this.cipher.getMacBlock(this.mac);
        System.arraycopy(this.mac, 0, bArr, i11, this.macSize);
        reset();
        return this.macSize;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) {
        reset();
        this.cipher.init(cipherParameters);
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

    public void update(byte b11) {
        int i11 = this.bufOff;
        byte[] bArr = this.buf;
        if (i11 == bArr.length) {
            this.cipher.processBlock(bArr, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i12 = this.bufOff;
        this.bufOff = i12 + 1;
        bArr2[i12] = b11;
    }

    public void update(byte[] bArr, int i11, int i12) {
        if (i12 >= 0) {
            int blockSize = this.cipher.getBlockSize();
            int i13 = this.bufOff;
            int i14 = blockSize - i13;
            if (i12 > i14) {
                System.arraycopy(bArr, i11, this.buf, i13, i14);
                this.cipher.processBlock(this.buf, 0, this.mac, 0);
                this.bufOff = 0;
                i12 -= i14;
                i11 += i14;
                while (i12 > blockSize) {
                    this.cipher.processBlock(bArr, i11, this.mac, 0);
                    i12 -= blockSize;
                    i11 += blockSize;
                }
            }
            System.arraycopy(bArr, i11, this.buf, this.bufOff, i12);
            this.bufOff += i12;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
