package org.bouncycastle.pqc.crypto.frodo;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Exceptions;
import org.bouncycastle.util.Pack;

abstract class FrodoMatrixGenerator {

    /* renamed from: n  reason: collision with root package name */
    public int f59523n;

    /* renamed from: q  reason: collision with root package name */
    public int f59524q;

    public static class Aes128MatrixGenerator extends FrodoMatrixGenerator {
        public BufferedBlockCipher cipher = new BufferedBlockCipher(new AESEngine());

        public Aes128MatrixGenerator(int i11, int i12) {
            super(i11, i12);
        }

        public void aes128(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            try {
                this.cipher.init(true, new KeyParameter(bArr2));
                this.cipher.doFinal(bArr, this.cipher.processBytes(bArr3, 0, bArr3.length, bArr, 0));
            } catch (InvalidCipherTextException e11) {
                throw Exceptions.illegalStateException(e11.toString(), e11);
            }
        }

        public short[] genMatrix(byte[] bArr) {
            int i11 = this.f59523n;
            short[] sArr = new short[(i11 * i11)];
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[16];
            for (int i12 = 0; i12 < this.f59523n; i12++) {
                for (int i13 = 0; i13 < this.f59523n; i13 += 8) {
                    System.arraycopy(Pack.shortToLittleEndian((short) (i12 & 65535)), 0, bArr2, 0, 2);
                    System.arraycopy(Pack.shortToLittleEndian((short) (65535 & i13)), 0, bArr2, 2, 2);
                    aes128(bArr3, bArr, bArr2);
                    for (int i14 = 0; i14 < 8; i14++) {
                        sArr[(this.f59523n * i12) + i13 + i14] = (short) (Pack.littleEndianToShort(bArr3, i14 * 2) % this.f59524q);
                    }
                }
            }
            return sArr;
        }
    }

    public static class Shake128MatrixGenerator extends FrodoMatrixGenerator {
        public Shake128MatrixGenerator(int i11, int i12) {
            super(i11, i12);
        }

        public short[] genMatrix(byte[] bArr) {
            int i11 = this.f59523n;
            short[] sArr = new short[(i11 * i11)];
            int i12 = (i11 * 16) / 8;
            byte[] bArr2 = new byte[i12];
            for (short s11 = 0; s11 < this.f59523n; s11 = (short) (s11 + 1)) {
                byte[] concatenate = Arrays.concatenate(Pack.shortToLittleEndian(s11), bArr);
                SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
                sHAKEDigest.update(concatenate, 0, concatenate.length);
                sHAKEDigest.doFinal(bArr2, 0, i12);
                short s12 = 0;
                while (true) {
                    int i13 = this.f59523n;
                    if (s12 >= i13) {
                        break;
                    }
                    sArr[(i13 * s11) + s12] = (short) (Pack.littleEndianToShort(bArr2, s12 * 2) % this.f59524q);
                    s12 = (short) (s12 + 1);
                }
            }
            return sArr;
        }
    }

    public FrodoMatrixGenerator(int i11, int i12) {
        this.f59523n = i11;
        this.f59524q = i12;
    }

    public abstract short[] genMatrix(byte[] bArr);
}
