package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

public class WinternitzOTSignature {
    private int checksumsize;
    private GMSSRandom gmssRandom;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[][] privateKeyOTS;

    /* renamed from: w  reason: collision with root package name */
    private int f59534w;

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i11) {
        this.f59534w = i11;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        int i12 = (((digestSize << 3) + i11) - 1) / i11;
        this.messagesize = i12;
        int log = getLog((i12 << i11) + 1);
        this.checksumsize = log;
        int i13 = this.messagesize + (((log + i11) - 1) / i11);
        this.keysize = i13;
        this.privateKeyOTS = new byte[i13][];
        int i14 = this.mdsize;
        byte[] bArr2 = new byte[i14];
        System.arraycopy(bArr, 0, bArr2, 0, i14);
        for (int i15 = 0; i15 < this.keysize; i15++) {
            this.privateKeyOTS[i15] = this.gmssRandom.nextSeed(bArr2);
        }
    }

    private void hashPrivateKeyBlock(int i11, int i12, byte[] bArr, int i13) {
        if (i12 < 1) {
            System.arraycopy(this.privateKeyOTS[i11], 0, bArr, i13, this.mdsize);
            return;
        }
        this.messDigestOTS.update(this.privateKeyOTS[i11], 0, this.mdsize);
        while (true) {
            this.messDigestOTS.doFinal(bArr, i13);
            i12--;
            if (i12 > 0) {
                this.messDigestOTS.update(bArr, i13, this.mdsize);
            } else {
                return;
            }
        }
    }

    public int getLog(int i11) {
        int i12 = 1;
        int i13 = 2;
        while (i13 < i11) {
            i13 <<= 1;
            i12++;
        }
        return i12;
    }

    public byte[][] getPrivateKey() {
        return this.privateKeyOTS;
    }

    public byte[] getPublicKey() {
        int i11 = this.keysize * this.mdsize;
        byte[] bArr = new byte[i11];
        int i12 = (1 << this.f59534w) - 1;
        int i13 = 0;
        for (int i14 = 0; i14 < this.keysize; i14++) {
            hashPrivateKeyBlock(i14, i12, bArr, i13);
            i13 += this.mdsize;
        }
        this.messDigestOTS.update(bArr, 0, i11);
        byte[] bArr2 = new byte[this.mdsize];
        this.messDigestOTS.doFinal(bArr2, 0);
        return bArr2;
    }

    public byte[] getSignature(byte[] bArr) {
        int i11;
        byte[] bArr2 = bArr;
        int i12 = this.keysize;
        int i13 = this.mdsize;
        byte[] bArr3 = new byte[(i12 * i13)];
        byte[] bArr4 = new byte[i13];
        int i14 = 0;
        this.messDigestOTS.update(bArr2, 0, bArr2.length);
        this.messDigestOTS.doFinal(bArr4, 0);
        int i15 = this.f59534w;
        int i16 = 8;
        if (8 % i15 == 0) {
            int i17 = 8 / i15;
            int i18 = (1 << i15) - 1;
            int i19 = 0;
            int i21 = 0;
            for (int i22 = 0; i22 < i13; i22++) {
                for (int i23 = 0; i23 < i17; i23++) {
                    byte b11 = bArr4[i22] & i18;
                    i19 += b11;
                    hashPrivateKeyBlock(i21, b11, bArr3, this.mdsize * i21);
                    bArr4[i22] = (byte) (bArr4[i22] >>> this.f59534w);
                    i21++;
                }
            }
            int i24 = (this.messagesize << this.f59534w) - i19;
            while (i14 < this.checksumsize) {
                hashPrivateKeyBlock(i21, i24 & i18, bArr3, this.mdsize * i21);
                int i25 = this.f59534w;
                i24 >>>= i25;
                i21++;
                i14 += i25;
            }
        } else if (i15 < 8) {
            int i26 = this.mdsize / i15;
            int i27 = (1 << i15) - 1;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            while (i28 < i26) {
                long j11 = 0;
                for (int i32 = 0; i32 < this.f59534w; i32++) {
                    j11 ^= (long) ((bArr4[i29] & 255) << (i32 << 3));
                    i29++;
                }
                int i33 = 0;
                long j12 = j11;
                while (i33 < i16) {
                    int i34 = ((int) j12) & i27;
                    i31 += i34;
                    hashPrivateKeyBlock(i30, i34, bArr3, this.mdsize * i30);
                    j12 >>>= this.f59534w;
                    i30++;
                    i33++;
                    i16 = 8;
                }
                i28++;
                i16 = 8;
            }
            int i35 = this.mdsize % this.f59534w;
            long j13 = 0;
            for (int i36 = 0; i36 < i35; i36++) {
                j13 ^= (long) ((bArr4[i29] & 255) << (i36 << 3));
                i29++;
            }
            int i37 = i35 << 3;
            int i38 = 0;
            while (i38 < i37) {
                int i39 = ((int) j13) & i27;
                i31 += i39;
                hashPrivateKeyBlock(i30, i39, bArr3, this.mdsize * i30);
                int i40 = this.f59534w;
                j13 >>>= i40;
                i30++;
                i38 += i40;
            }
            int i41 = (this.messagesize << this.f59534w) - i31;
            while (i14 < this.checksumsize) {
                hashPrivateKeyBlock(i30, i41 & i27, bArr3, this.mdsize * i30);
                int i42 = this.f59534w;
                i41 >>>= i42;
                i30++;
                i14 += i42;
            }
        } else if (i15 < 57) {
            int i43 = this.mdsize;
            int i44 = (i43 << 3) - i15;
            int i45 = (1 << i15) - 1;
            byte[] bArr5 = new byte[i43];
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            while (i46 <= i44) {
                int i49 = i46 >>> 3;
                int i50 = i46 % 8;
                i46 += this.f59534w;
                int i51 = (i46 + 7) >>> 3;
                int i52 = i14;
                long j14 = 0;
                while (i49 < i51) {
                    j14 ^= (long) ((bArr4[i49] & 255) << (i52 << 3));
                    i52++;
                    i49++;
                    bArr4 = bArr4;
                    i44 = i44;
                }
                byte[] bArr6 = bArr4;
                int i53 = i44;
                long j15 = (j14 >>> i50) & ((long) i45);
                i48 = (int) (((long) i48) + j15);
                System.arraycopy(this.privateKeyOTS[i47], 0, bArr5, 0, this.mdsize);
                while (j15 > 0) {
                    this.messDigestOTS.update(bArr5, 0, i43);
                    this.messDigestOTS.doFinal(bArr5, 0);
                    j15--;
                }
                int i54 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i47 * i54, i54);
                i47++;
                bArr4 = bArr6;
                i44 = i53;
                i14 = 0;
            }
            byte[] bArr7 = bArr4;
            int i55 = i46 >>> 3;
            if (i55 < this.mdsize) {
                int i56 = i46 % 8;
                int i57 = 0;
                long j16 = 0;
                while (true) {
                    i11 = this.mdsize;
                    if (i55 >= i11) {
                        break;
                    }
                    j16 ^= (long) ((bArr7[i55] & 255) << (i57 << 3));
                    i57++;
                    i55++;
                }
                long j17 = (j16 >>> i56) & ((long) i45);
                i48 = (int) (((long) i48) + j17);
                System.arraycopy(this.privateKeyOTS[i47], 0, bArr5, 0, i11);
                while (j17 > 0) {
                    this.messDigestOTS.update(bArr5, 0, i43);
                    this.messDigestOTS.doFinal(bArr5, 0);
                    j17--;
                }
                int i58 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i47 * i58, i58);
                i47++;
            }
            int i59 = (this.messagesize << this.f59534w) - i48;
            int i60 = 0;
            while (i60 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i47], 0, bArr5, 0, this.mdsize);
                for (long j18 = (long) (i59 & i45); j18 > 0; j18--) {
                    this.messDigestOTS.update(bArr5, 0, i43);
                    this.messDigestOTS.doFinal(bArr5, 0);
                }
                int i61 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i47 * i61, i61);
                int i62 = this.f59534w;
                i59 >>>= i62;
                i47++;
                i60 += i62;
            }
        }
        return bArr3;
    }
}
