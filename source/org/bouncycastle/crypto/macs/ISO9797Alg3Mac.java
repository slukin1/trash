package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class ISO9797Alg3Mac implements Mac {
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private KeyParameter lastKey2;
    private KeyParameter lastKey3;
    private byte[] mac;
    private int macSize;
    private BlockCipherPadding padding;

    public ISO9797Alg3Mac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8, (BlockCipherPadding) null);
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, int i11) {
        this(blockCipher, i11, (BlockCipherPadding) null);
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, int i11, BlockCipherPadding blockCipherPadding) {
        if (i11 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (blockCipher instanceof DESEngine) {
            this.cipher = new CBCBlockCipher(blockCipher);
            this.padding = blockCipherPadding;
            this.macSize = i11 / 8;
            this.mac = new byte[blockCipher.getBlockSize()];
            this.buf = new byte[blockCipher.getBlockSize()];
            this.bufOff = 0;
        } else {
            throw new IllegalArgumentException("cipher must be instance of DESEngine");
        }
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, blockCipher.getBlockSize() * 8, blockCipherPadding);
    }

    public int doFinal(byte[] bArr, int i11) {
        int blockSize = this.cipher.getBlockSize();
        if (this.padding == null) {
            while (true) {
                int i12 = this.bufOff;
                if (i12 >= blockSize) {
                    break;
                }
                this.buf[i12] = 0;
                this.bufOff = i12 + 1;
            }
        } else {
            if (this.bufOff == blockSize) {
                this.cipher.processBlock(this.buf, 0, this.mac, 0);
                this.bufOff = 0;
            }
            this.padding.addPadding(this.buf, this.bufOff);
        }
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        DESEngine dESEngine = new DESEngine();
        dESEngine.init(false, this.lastKey2);
        byte[] bArr2 = this.mac;
        dESEngine.processBlock(bArr2, 0, bArr2, 0);
        dESEngine.init(true, this.lastKey3);
        byte[] bArr3 = this.mac;
        dESEngine.processBlock(bArr3, 0, bArr3, 0);
        System.arraycopy(this.mac, 0, bArr, i11, this.macSize);
        reset();
        return this.macSize;
    }

    public String getAlgorithmName() {
        return "ISO9797Alg3";
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        reset();
        boolean z11 = cipherParameters instanceof KeyParameter;
        if (z11 || (cipherParameters instanceof ParametersWithIV)) {
            byte[] key = (z11 ? (KeyParameter) cipherParameters : (KeyParameter) ((ParametersWithIV) cipherParameters).getParameters()).getKey();
            if (key.length == 16) {
                keyParameter = new KeyParameter(key, 0, 8);
                this.lastKey2 = new KeyParameter(key, 8, 8);
                this.lastKey3 = keyParameter;
            } else if (key.length == 24) {
                keyParameter = new KeyParameter(key, 0, 8);
                this.lastKey2 = new KeyParameter(key, 8, 8);
                this.lastKey3 = new KeyParameter(key, 16, 8);
            } else {
                throw new IllegalArgumentException("Key must be either 112 or 168 bit long");
            }
            if (cipherParameters instanceof ParametersWithIV) {
                this.cipher.init(true, new ParametersWithIV(keyParameter, ((ParametersWithIV) cipherParameters).getIV()));
            } else {
                this.cipher.init(true, keyParameter);
            }
        } else {
            throw new IllegalArgumentException("params must be an instance of KeyParameter or ParametersWithIV");
        }
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
