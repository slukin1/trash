package org.bouncycastle.crypto.encodings;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class ISO9796d1Encoding implements AsymmetricBlockCipher {
    private static final BigInteger SIX = BigInteger.valueOf(6);
    private static final BigInteger SIXTEEN = BigInteger.valueOf(16);
    private static byte[] inverse = {8, 15, 6, 1, 5, 2, 11, 12, 3, 4, 13, 10, 14, 9, 0, 7};
    private static byte[] shadows = {14, 3, 5, 8, 9, 4, 2, 15, 0, 13, 11, 6, 7, 10, 12, 1};
    private int bitSize;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private BigInteger modulus;
    private int padBits = 0;

    public ISO9796d1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.engine = asymmetricBlockCipher;
    }

    private static byte[] convertOutputDecryptOnly(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    private byte[] decodeBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        byte[] processBlock = this.engine.processBlock(bArr, i11, i12);
        int i13 = (this.bitSize + 13) / 16;
        BigInteger bigInteger = new BigInteger(1, processBlock);
        BigInteger bigInteger2 = SIXTEEN;
        BigInteger mod = bigInteger.mod(bigInteger2);
        BigInteger bigInteger3 = SIX;
        if (!mod.equals(bigInteger3)) {
            if (this.modulus.subtract(bigInteger).mod(bigInteger2).equals(bigInteger3)) {
                bigInteger = this.modulus.subtract(bigInteger);
            } else {
                throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
        }
        byte[] convertOutputDecryptOnly = convertOutputDecryptOnly(bigInteger);
        if ((convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] & 15) == 6) {
            convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] = (byte) (((convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] & 255) >>> 4) | (inverse[(convertOutputDecryptOnly[convertOutputDecryptOnly.length - 2] & 255) >> 4] << 4));
            byte[] bArr2 = shadows;
            convertOutputDecryptOnly[0] = (byte) (bArr2[convertOutputDecryptOnly[1] & 15] | (bArr2[(convertOutputDecryptOnly[1] & 255) >>> 4] << 4));
            byte b11 = 1;
            int i14 = 0;
            boolean z11 = false;
            for (int length = convertOutputDecryptOnly.length - 1; length >= convertOutputDecryptOnly.length - (i13 * 2); length -= 2) {
                byte[] bArr3 = shadows;
                byte b12 = bArr3[convertOutputDecryptOnly[length] & 15] | (bArr3[(convertOutputDecryptOnly[length] & 255) >>> 4] << 4);
                int i15 = length - 1;
                if (((convertOutputDecryptOnly[i15] ^ b12) & 255) != 0) {
                    if (!z11) {
                        b11 = (convertOutputDecryptOnly[i15] ^ b12) & 255;
                        z11 = true;
                        i14 = i15;
                    } else {
                        throw new InvalidCipherTextException("invalid tsums in block");
                    }
                }
            }
            convertOutputDecryptOnly[i14] = 0;
            int length2 = (convertOutputDecryptOnly.length - i14) / 2;
            byte[] bArr4 = new byte[length2];
            for (int i16 = 0; i16 < length2; i16++) {
                bArr4[i16] = convertOutputDecryptOnly[(i16 * 2) + i14 + 1];
            }
            this.padBits = b11 - 1;
            return bArr4;
        }
        throw new InvalidCipherTextException("invalid forcing byte in block");
    }

    private byte[] encodeBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        int i13 = this.bitSize;
        int i14 = (i13 + 7) / 8;
        byte[] bArr2 = new byte[i14];
        int i15 = 1;
        int i16 = this.padBits + 1;
        int i17 = (i13 + 13) / 16;
        int i18 = 0;
        while (i18 < i17) {
            if (i18 > i17 - i12) {
                int i19 = i17 - i18;
                System.arraycopy(bArr, (i11 + i12) - i19, bArr2, i14 - i17, i19);
            } else {
                System.arraycopy(bArr, i11, bArr2, i14 - (i18 + i12), i12);
            }
            i18 += i12;
        }
        for (int i21 = i14 - (i17 * 2); i21 != i14; i21 += 2) {
            byte b11 = bArr2[(i14 - i17) + (i21 / 2)];
            byte[] bArr3 = shadows;
            bArr2[i21] = (byte) (bArr3[b11 & 15] | (bArr3[(b11 & 255) >>> 4] << 4));
            bArr2[i21 + 1] = b11;
        }
        int i22 = i14 - (i12 * 2);
        bArr2[i22] = (byte) (bArr2[i22] ^ i16);
        int i23 = i14 - 1;
        bArr2[i23] = (byte) ((bArr2[i23] << 4) | 6);
        int i24 = 8 - ((this.bitSize - 1) % 8);
        if (i24 != 8) {
            bArr2[0] = (byte) (bArr2[0] & (255 >>> i24));
            bArr2[0] = (byte) ((128 >>> i24) | bArr2[0]);
            i15 = 0;
        } else {
            bArr2[0] = 0;
            bArr2[1] = (byte) (bArr2[1] | 128);
        }
        return this.engine.processBlock(bArr2, i15, i14 - i15);
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize + 1) / 2 : inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : (outputBlockSize + 1) / 2;
    }

    public int getPadBits() {
        return this.padBits;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = cipherParameters instanceof ParametersWithRandom ? (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters() : (RSAKeyParameters) cipherParameters;
        this.engine.init(z11, cipherParameters);
        BigInteger modulus2 = rSAKeyParameters.getModulus();
        this.modulus = modulus2;
        this.bitSize = modulus2.bitLength();
        this.forEncryption = z11;
    }

    public byte[] processBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException {
        return this.forEncryption ? encodeBlock(bArr, i11, i12) : decodeBlock(bArr, i11, i12);
    }

    public void setPadBits(int i11) {
        if (i11 <= 7) {
            this.padBits = i11;
            return;
        }
        throw new IllegalArgumentException("padBits > 7");
    }
}
