package org.bouncycastle.crypto.macs;

import com.sumsub.sns.internal.ml.autocapture.b;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class CMac implements Mac {
    private byte[] Lu;
    private byte[] Lu2;
    private byte[] ZEROES;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] mac;
    private int macSize;
    private byte[] poly;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public CMac(BlockCipher blockCipher, int i11) {
        if (i11 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (i11 <= blockCipher.getBlockSize() * 8) {
            this.cipher = new CBCBlockCipher(blockCipher);
            this.macSize = i11 / 8;
            this.poly = lookupPoly(blockCipher.getBlockSize());
            this.mac = new byte[blockCipher.getBlockSize()];
            this.buf = new byte[blockCipher.getBlockSize()];
            this.ZEROES = new byte[blockCipher.getBlockSize()];
            this.bufOff = 0;
        } else {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (blockCipher.getBlockSize() * 8));
        }
    }

    private byte[] doubleLu(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        byte b11 = (-shiftLeft(bArr, bArr2)) & 255;
        int length = bArr.length - 3;
        byte b12 = bArr2[length];
        byte[] bArr3 = this.poly;
        bArr2[length] = (byte) (b12 ^ (bArr3[1] & b11));
        int length2 = bArr.length - 2;
        bArr2[length2] = (byte) ((bArr3[2] & b11) ^ bArr2[length2]);
        int length3 = bArr.length - 1;
        bArr2[length3] = (byte) ((b11 & bArr3[3]) ^ bArr2[length3]);
        return bArr2;
    }

    private static byte[] lookupPoly(int i11) {
        int i12 = i11 * 8;
        int i13 = 135;
        switch (i12) {
            case 64:
            case 320:
                i13 = 27;
                break;
            case 128:
            case 192:
                break;
            case 160:
                i13 = 45;
                break;
            case 224:
                i13 = 777;
                break;
            case 256:
                i13 = 1061;
                break;
            case b.f34945b:
                i13 = 4109;
                break;
            case 448:
                i13 = 2129;
                break;
            case 512:
                i13 = 293;
                break;
            case 768:
                i13 = 655377;
                break;
            case 1024:
                i13 = 524355;
                break;
            case 2048:
                i13 = 548865;
                break;
            default:
                throw new IllegalArgumentException("Unknown block size for CMAC: " + i12);
        }
        return Pack.intToBigEndian(i13);
    }

    private static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i11 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i11;
            }
            byte b11 = bArr[length] & 255;
            bArr2[length] = (byte) (i11 | (b11 << 1));
            i11 = (b11 >>> 7) & 1;
        }
    }

    public int doFinal(byte[] bArr, int i11) {
        byte[] bArr2;
        if (this.bufOff == this.cipher.getBlockSize()) {
            bArr2 = this.Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
            bArr2 = this.Lu2;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr3 = this.mac;
            if (i12 < bArr3.length) {
                byte[] bArr4 = this.buf;
                bArr4[i12] = (byte) (bArr4[i12] ^ bArr2[i12]);
                i12++;
            } else {
                this.cipher.processBlock(this.buf, 0, bArr3, 0);
                System.arraycopy(this.mac, 0, bArr, i11, this.macSize);
                reset();
                return this.macSize;
            }
        }
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) {
        validate(cipherParameters);
        this.cipher.init(true, cipherParameters);
        byte[] bArr = this.ZEROES;
        byte[] bArr2 = new byte[bArr.length];
        this.cipher.processBlock(bArr, 0, bArr2, 0);
        byte[] doubleLu = doubleLu(bArr2);
        this.Lu = doubleLu;
        this.Lu2 = doubleLu(doubleLu);
        reset();
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

    public void validate(CipherParameters cipherParameters) {
        if (cipherParameters != null && !(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }
}
