package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class RFC5649WrapEngine implements Wrapper {
    private BlockCipher engine;
    private byte[] extractedAIV = null;
    private boolean forWrapping;
    private byte[] highOrderIV;
    private KeyParameter param;
    private byte[] preIV;

    public RFC5649WrapEngine(BlockCipher blockCipher) {
        byte[] bArr = {-90, 89, 89, -90};
        this.highOrderIV = bArr;
        this.preIV = bArr;
        this.engine = blockCipher;
    }

    private byte[] padPlaintext(byte[] bArr) {
        int length = bArr.length;
        int i11 = (8 - (length % 8)) % 8;
        byte[] bArr2 = new byte[(length + i11)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        if (i11 != 0) {
            System.arraycopy(new byte[i11], 0, bArr2, length, i11);
        }
        return bArr2;
    }

    private byte[] rfc3394UnwrapNoIvCheck(byte[] bArr, int i11, int i12) {
        int i13 = i12 - 8;
        byte[] bArr2 = new byte[i13];
        byte[] bArr3 = new byte[8];
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr, i11, bArr3, 0, 8);
        System.arraycopy(bArr, i11 + 8, bArr2, 0, i13);
        this.engine.init(false, this.param);
        int i14 = (i12 / 8) - 1;
        for (int i15 = 5; i15 >= 0; i15--) {
            for (int i16 = i14; i16 >= 1; i16--) {
                System.arraycopy(bArr3, 0, bArr4, 0, 8);
                int i17 = (i16 - 1) * 8;
                System.arraycopy(bArr2, i17, bArr4, 8, 8);
                int i18 = (i14 * i15) + i16;
                int i19 = 1;
                while (i18 != 0) {
                    int i21 = 8 - i19;
                    bArr4[i21] = (byte) (((byte) i18) ^ bArr4[i21]);
                    i18 >>>= 8;
                    i19++;
                }
                this.engine.processBlock(bArr4, 0, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr3, 0, 8);
                System.arraycopy(bArr4, 8, bArr2, i17, 8);
            }
        }
        this.extractedAIV = bArr3;
        return bArr2;
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName();
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        this.forWrapping = z11;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.param = (KeyParameter) cipherParameters;
            this.preIV = this.highOrderIV;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.preIV = parametersWithIV.getIV();
            this.param = (KeyParameter) parametersWithIV.getParameters();
            if (this.preIV.length != 4) {
                throw new IllegalArgumentException("IV length not equal to 4");
            }
        }
    }

    public byte[] unwrap(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        byte[] bArr2;
        if (!this.forWrapping) {
            int i13 = i12 / 8;
            if (i13 * 8 != i12) {
                throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
            } else if (i13 > 1) {
                byte[] bArr3 = new byte[i12];
                System.arraycopy(bArr, i11, bArr3, 0, i12);
                byte[] bArr4 = new byte[i12];
                if (i13 == 2) {
                    this.engine.init(false, this.param);
                    int i14 = 0;
                    while (i14 < i12) {
                        this.engine.processBlock(bArr3, i14, bArr4, i14);
                        i14 += this.engine.getBlockSize();
                    }
                    byte[] bArr5 = new byte[8];
                    this.extractedAIV = bArr5;
                    System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
                    byte[] bArr6 = this.extractedAIV;
                    int length = i12 - bArr6.length;
                    bArr2 = new byte[length];
                    System.arraycopy(bArr4, bArr6.length, bArr2, 0, length);
                } else {
                    bArr2 = rfc3394UnwrapNoIvCheck(bArr, i11, i12);
                }
                int i15 = 4;
                byte[] bArr7 = new byte[4];
                byte[] bArr8 = new byte[4];
                System.arraycopy(this.extractedAIV, 0, bArr7, 0, 4);
                System.arraycopy(this.extractedAIV, 4, bArr8, 0, 4);
                int bigEndianToInt = Pack.bigEndianToInt(bArr8, 0);
                boolean constantTimeAreEqual = Arrays.constantTimeAreEqual(bArr7, this.preIV);
                int length2 = bArr2.length;
                if (bigEndianToInt <= length2 - 8) {
                    constantTimeAreEqual = false;
                }
                if (bigEndianToInt > length2) {
                    constantTimeAreEqual = false;
                }
                int i16 = length2 - bigEndianToInt;
                if (i16 >= 8 || i16 < 0) {
                    constantTimeAreEqual = false;
                } else {
                    i15 = i16;
                }
                byte[] bArr9 = new byte[i15];
                System.arraycopy(bArr2, bArr2.length - i15, bArr9, 0, i15);
                if (!Arrays.constantTimeAreEqual(bArr9, new byte[i15])) {
                    constantTimeAreEqual = false;
                }
                if (constantTimeAreEqual) {
                    byte[] bArr10 = new byte[bigEndianToInt];
                    System.arraycopy(bArr2, 0, bArr10, 0, bigEndianToInt);
                    return bArr10;
                }
                throw new InvalidCipherTextException("checksum failed");
            } else {
                throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
            }
        } else {
            throw new IllegalStateException("not set for unwrapping");
        }
    }

    public byte[] wrap(byte[] bArr, int i11, int i12) {
        if (this.forWrapping) {
            byte[] bArr2 = new byte[8];
            byte[] intToBigEndian = Pack.intToBigEndian(i12);
            byte[] bArr3 = this.preIV;
            int i13 = 0;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            System.arraycopy(intToBigEndian, 0, bArr2, this.preIV.length, intToBigEndian.length);
            byte[] bArr4 = new byte[i12];
            System.arraycopy(bArr, i11, bArr4, 0, i12);
            byte[] padPlaintext = padPlaintext(bArr4);
            if (padPlaintext.length == 8) {
                int length = padPlaintext.length + 8;
                byte[] bArr5 = new byte[length];
                System.arraycopy(bArr2, 0, bArr5, 0, 8);
                System.arraycopy(padPlaintext, 0, bArr5, 8, padPlaintext.length);
                this.engine.init(true, this.param);
                while (i13 < length) {
                    this.engine.processBlock(bArr5, i13, bArr5, i13);
                    i13 += this.engine.getBlockSize();
                }
                return bArr5;
            }
            RFC3394WrapEngine rFC3394WrapEngine = new RFC3394WrapEngine(this.engine);
            rFC3394WrapEngine.init(true, new ParametersWithIV(this.param, bArr2));
            return rFC3394WrapEngine.wrap(padPlaintext, 0, padPlaintext.length);
        }
        throw new IllegalStateException("not set for wrapping");
    }
}
