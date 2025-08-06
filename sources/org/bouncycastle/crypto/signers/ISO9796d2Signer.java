package org.bouncycastle.crypto.signers;

import com.google.common.primitives.SignedBytes;
import net.sf.scuba.smartcards.ISO7816;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

public class ISO9796d2Signer implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private byte[] preSig;
    private byte[] recoveredMessage;
    private int trailer;

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2) {
        this(asymmetricBlockCipher, digest2, false);
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2, boolean z11) {
        int intValue;
        this.cipher = asymmetricBlockCipher;
        this.digest = digest2;
        if (z11) {
            intValue = 188;
        } else {
            Integer trailer2 = ISOTrailers.getTrailer(digest2);
            if (trailer2 != null) {
                intValue = trailer2.intValue();
            } else {
                throw new IllegalArgumentException("no valid trailer for digest: " + digest2.getAlgorithmName());
            }
        }
        this.trailer = intValue;
    }

    private void clearBlock(byte[] bArr) {
        for (int i11 = 0; i11 != bArr.length; i11++) {
            bArr[i11] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        int i11 = this.messageLength;
        byte[] bArr3 = this.mBuf;
        boolean z11 = true;
        if (i11 > bArr3.length) {
            if (bArr3.length > bArr2.length) {
                z11 = false;
            }
            for (int i12 = 0; i12 != this.mBuf.length; i12++) {
                if (bArr[i12] != bArr2[i12]) {
                    z11 = false;
                }
            }
        } else {
            if (i11 != bArr2.length) {
                z11 = false;
            }
            for (int i13 = 0; i13 != bArr2.length; i13++) {
                if (bArr[i13] != bArr2[i13]) {
                    z11 = false;
                }
            }
        }
        return z11;
    }

    private boolean returnFalse(byte[] bArr) {
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(bArr);
        return false;
    }

    public byte[] generateSignature() throws CryptoException {
        int i11;
        int i12;
        int i13;
        byte b11;
        int digestSize = this.digest.getDigestSize();
        boolean z11 = true;
        if (this.trailer == 188) {
            byte[] bArr = this.block;
            i11 = (bArr.length - digestSize) - 1;
            this.digest.doFinal(bArr, i11);
            byte[] bArr2 = this.block;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i12 = 8;
        } else {
            i12 = 16;
            byte[] bArr3 = this.block;
            int length = (bArr3.length - digestSize) - 2;
            this.digest.doFinal(bArr3, length);
            byte[] bArr4 = this.block;
            int i14 = this.trailer;
            bArr4[bArr4.length - 2] = (byte) (i14 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i14;
            i11 = length;
        }
        int i15 = this.messageLength;
        int i16 = ((((digestSize + i15) * 8) + i12) + 4) - this.keyBits;
        if (i16 > 0) {
            int i17 = i15 - ((i16 + 7) / 8);
            b11 = 96;
            i13 = i11 - i17;
            System.arraycopy(this.mBuf, 0, this.block, i13, i17);
            this.recoveredMessage = new byte[i17];
        } else {
            b11 = SignedBytes.MAX_POWER_OF_TWO;
            i13 = i11 - i15;
            System.arraycopy(this.mBuf, 0, this.block, i13, i15);
            this.recoveredMessage = new byte[this.messageLength];
        }
        int i18 = i13 - 1;
        if (i18 > 0) {
            for (int i19 = i18; i19 != 0; i19--) {
                this.block[i19] = -69;
            }
            byte[] bArr5 = this.block;
            bArr5[i18] = (byte) (bArr5[i18] ^ 1);
            bArr5[0] = 11;
            bArr5[0] = (byte) (bArr5[0] | b11);
        } else {
            byte[] bArr6 = this.block;
            bArr6[0] = 10;
            bArr6[0] = (byte) (bArr6[0] | b11);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.cipher;
        byte[] bArr7 = this.block;
        byte[] processBlock = asymmetricBlockCipher.processBlock(bArr7, 0, bArr7.length);
        if ((b11 & 32) != 0) {
            z11 = false;
        }
        this.fullMessage = z11;
        byte[] bArr8 = this.mBuf;
        byte[] bArr9 = this.recoveredMessage;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(this.block);
        return processBlock;
    }

    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.cipher.init(z11, rSAKeyParameters);
        int bitLength = rSAKeyParameters.getModulus().bitLength();
        this.keyBits = bitLength;
        byte[] bArr = new byte[((bitLength + 7) / 8)];
        this.block = bArr;
        int i11 = this.trailer;
        int length = bArr.length;
        if (i11 == 188) {
            this.mBuf = new byte[((length - this.digest.getDigestSize()) - 2)];
        } else {
            this.mBuf = new byte[((length - this.digest.getDigestSize()) - 3)];
        }
        reset();
    }

    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        clearBlock(this.mBuf);
        byte[] bArr = this.recoveredMessage;
        if (bArr != null) {
            clearBlock(bArr);
        }
        this.recoveredMessage = null;
        this.fullMessage = false;
        if (this.preSig != null) {
            this.preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    public void update(byte b11) {
        this.digest.update(b11);
        int i11 = this.messageLength;
        byte[] bArr = this.mBuf;
        if (i11 < bArr.length) {
            bArr[i11] = b11;
        }
        this.messageLength = i11 + 1;
    }

    public void update(byte[] bArr, int i11, int i12) {
        while (i12 > 0 && this.messageLength < this.mBuf.length) {
            update(bArr[i11]);
            i11++;
            i12--;
        }
        this.digest.update(bArr, i11, i12);
        this.messageLength += i12;
    }

    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        if (((processBlock[0] & ISO7816.INS_GET_RESPONSE) ^ SignedBytes.MAX_POWER_OF_TWO) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        } else if (((processBlock[processBlock.length - 1] & 15) ^ 12) == 0) {
            int i11 = 2;
            if (((processBlock[processBlock.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
                i11 = 1;
            } else {
                byte b11 = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
                Integer trailer2 = ISOTrailers.getTrailer(this.digest);
                if (trailer2 != null) {
                    int intValue = trailer2.intValue();
                    if (!(b11 == intValue || (intValue == 15052 && b11 == 16588))) {
                        throw new IllegalStateException("signer initialised with wrong digest for trailer " + b11);
                    }
                } else {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                }
            }
            int i12 = 0;
            while (i12 != processBlock.length && ((processBlock[i12] & 15) ^ 10) != 0) {
                i12++;
            }
            int i13 = i12 + 1;
            int length = ((processBlock.length - i11) - this.digest.getDigestSize()) - i13;
            if (length > 0) {
                if ((processBlock[0] & 32) == 0) {
                    this.fullMessage = true;
                    byte[] bArr2 = new byte[length];
                    this.recoveredMessage = bArr2;
                    System.arraycopy(processBlock, i13, bArr2, 0, bArr2.length);
                } else {
                    this.fullMessage = false;
                    byte[] bArr3 = new byte[length];
                    this.recoveredMessage = bArr3;
                    System.arraycopy(processBlock, i13, bArr3, 0, bArr3.length);
                }
                this.preSig = bArr;
                this.preBlock = processBlock;
                Digest digest2 = this.digest;
                byte[] bArr4 = this.recoveredMessage;
                digest2.update(bArr4, 0, bArr4.length);
                byte[] bArr5 = this.recoveredMessage;
                this.messageLength = bArr5.length;
                System.arraycopy(bArr5, 0, this.mBuf, 0, bArr5.length);
                return;
            }
            throw new InvalidCipherTextException("malformed block");
        } else {
            throw new InvalidCipherTextException("malformed signature");
        }
    }

    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3 = this.preSig;
        if (bArr3 == null) {
            try {
                bArr2 = this.cipher.processBlock(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else if (Arrays.areEqual(bArr3, bArr)) {
            bArr2 = this.preBlock;
            this.preSig = null;
            this.preBlock = null;
        } else {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        if (((bArr2[0] & ISO7816.INS_GET_RESPONSE) ^ SignedBytes.MAX_POWER_OF_TWO) != 0) {
            return returnFalse(bArr2);
        }
        if (((bArr2[bArr2.length - 1] & 15) ^ 12) != 0) {
            return returnFalse(bArr2);
        }
        int i11 = 2;
        if (((bArr2[bArr2.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
            i11 = 1;
        } else {
            byte b11 = ((bArr2[bArr2.length - 2] & 255) << 8) | (bArr2[bArr2.length - 1] & 255);
            Integer trailer2 = ISOTrailers.getTrailer(this.digest);
            if (trailer2 != null) {
                int intValue = trailer2.intValue();
                if (!(b11 == intValue || (intValue == 15052 && b11 == 16588))) {
                    throw new IllegalStateException("signer initialised with wrong digest for trailer " + b11);
                }
            } else {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
        }
        int i12 = 0;
        while (i12 != bArr2.length && ((bArr2[i12] & 15) ^ 10) != 0) {
            i12++;
        }
        int i13 = i12 + 1;
        int digestSize = this.digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        int length = (bArr2.length - i11) - digestSize;
        int i14 = length - i13;
        if (i14 <= 0) {
            return returnFalse(bArr2);
        }
        if ((bArr2[0] & 32) == 0) {
            this.fullMessage = true;
            if (this.messageLength > i14) {
                return returnFalse(bArr2);
            }
            this.digest.reset();
            this.digest.update(bArr2, i13, i14);
            this.digest.doFinal(bArr4, 0);
            boolean z11 = true;
            for (int i15 = 0; i15 != digestSize; i15++) {
                int i16 = length + i15;
                bArr2[i16] = (byte) (bArr2[i16] ^ bArr4[i15]);
                if (bArr2[i16] != 0) {
                    z11 = false;
                }
            }
            if (!z11) {
                return returnFalse(bArr2);
            }
            byte[] bArr5 = new byte[i14];
            this.recoveredMessage = bArr5;
            System.arraycopy(bArr2, i13, bArr5, 0, bArr5.length);
        } else {
            this.fullMessage = false;
            this.digest.doFinal(bArr4, 0);
            boolean z12 = true;
            for (int i17 = 0; i17 != digestSize; i17++) {
                int i18 = length + i17;
                bArr2[i18] = (byte) (bArr2[i18] ^ bArr4[i17]);
                if (bArr2[i18] != 0) {
                    z12 = false;
                }
            }
            if (!z12) {
                return returnFalse(bArr2);
            }
            byte[] bArr6 = new byte[i14];
            this.recoveredMessage = bArr6;
            System.arraycopy(bArr2, i13, bArr6, 0, bArr6.length);
        }
        if (this.messageLength != 0 && !isSameAs(this.mBuf, this.recoveredMessage)) {
            return returnFalse(bArr2);
        }
        clearBlock(this.mBuf);
        clearBlock(bArr2);
        this.messageLength = 0;
        return true;
    }
}
