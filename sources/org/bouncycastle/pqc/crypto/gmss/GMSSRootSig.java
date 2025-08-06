package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.encoders.Hex;

public class GMSSRootSig {
    private long big8;
    private int checksum;
    private int counter;
    private GMSSRandom gmssRandom;
    private byte[] hash;
    private int height;

    /* renamed from: ii  reason: collision with root package name */
    private int f59529ii;

    /* renamed from: k  reason: collision with root package name */
    private int f59530k;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[] privateKeyOTS;

    /* renamed from: r  reason: collision with root package name */
    private int f59531r;
    private byte[] seed;
    private byte[] sign;
    private int steps;
    private int test;
    private long test8;

    /* renamed from: w  reason: collision with root package name */
    private int f59532w;

    public GMSSRootSig(Digest digest, int i11, int i12) {
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        this.f59532w = i11;
        this.height = i12;
        this.f59530k = (1 << i11) - 1;
        this.messagesize = (int) Math.ceil(((double) (digestSize << 3)) / ((double) i11));
    }

    public GMSSRootSig(Digest digest, byte[][] bArr, int[] iArr) {
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        this.counter = iArr[0];
        this.test = iArr[1];
        this.f59529ii = iArr[2];
        this.f59531r = iArr[3];
        this.steps = iArr[4];
        this.keysize = iArr[5];
        this.height = iArr[6];
        this.f59532w = iArr[7];
        this.checksum = iArr[8];
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        int i11 = this.f59532w;
        this.f59530k = (1 << i11) - 1;
        this.messagesize = (int) Math.ceil(((double) (digestSize << 3)) / ((double) i11));
        this.privateKeyOTS = bArr[0];
        this.seed = bArr[1];
        this.hash = bArr[2];
        this.sign = bArr[3];
        this.test8 = (((long) (bArr[4][1] & 255)) << 8) | ((long) (bArr[4][0] & 255)) | (((long) (bArr[4][2] & 255)) << 16) | (((long) (bArr[4][3] & 255)) << 24) | (((long) (bArr[4][4] & 255)) << 32) | (((long) (bArr[4][5] & 255)) << 40) | (((long) (bArr[4][6] & 255)) << 48) | (((long) (bArr[4][7] & 255)) << 56);
        this.big8 = ((long) (bArr[4][8] & 255)) | (((long) (bArr[4][9] & 255)) << 8) | (((long) (bArr[4][10] & 255)) << 16) | (((long) (bArr[4][11] & 255)) << 24) | (((long) (bArr[4][12] & 255)) << 32) | (((long) (bArr[4][13] & 255)) << 40) | (((long) (bArr[4][14] & 255)) << 48) | (((long) (bArr[4][15] & 255)) << 56);
    }

    private void oneStep() {
        long j11;
        int i11;
        int i12 = this.f59532w;
        if (8 % i12 == 0) {
            int i13 = this.test;
            if (i13 == 0) {
                this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
                int i14 = this.f59529ii;
                if (i14 < this.mdsize) {
                    byte[] bArr = this.hash;
                    this.test = bArr[i14] & this.f59530k;
                    bArr[i14] = (byte) (bArr[i14] >>> this.f59532w);
                } else {
                    int i15 = this.checksum;
                    this.test = this.f59530k & i15;
                    this.checksum = i15 >>> this.f59532w;
                }
            } else if (i13 > 0) {
                Digest digest = this.messDigestOTS;
                byte[] bArr2 = this.privateKeyOTS;
                digest.update(bArr2, 0, bArr2.length);
                byte[] bArr3 = new byte[this.messDigestOTS.getDigestSize()];
                this.privateKeyOTS = bArr3;
                this.messDigestOTS.doFinal(bArr3, 0);
                this.test--;
            }
            if (this.test == 0) {
                byte[] bArr4 = this.privateKeyOTS;
                byte[] bArr5 = this.sign;
                int i16 = this.counter;
                int i17 = this.mdsize;
                System.arraycopy(bArr4, 0, bArr5, i16 * i17, i17);
                int i18 = this.counter + 1;
                this.counter = i18;
                if (i18 % (8 / this.f59532w) == 0) {
                    this.f59529ii++;
                    return;
                }
                return;
            }
            return;
        }
        if (i12 < 8) {
            int i19 = this.test;
            if (i19 == 0) {
                int i21 = this.counter;
                if (i21 % 8 == 0 && this.f59529ii < (i11 = this.mdsize)) {
                    this.big8 = 0;
                    if (i21 < ((i11 / i12) << 3)) {
                        for (int i22 = 0; i22 < this.f59532w; i22++) {
                            long j12 = this.big8;
                            byte[] bArr6 = this.hash;
                            int i23 = this.f59529ii;
                            this.big8 = j12 ^ ((long) ((bArr6[i23] & 255) << (i22 << 3)));
                            this.f59529ii = i23 + 1;
                        }
                    } else {
                        for (int i24 = 0; i24 < this.mdsize % this.f59532w; i24++) {
                            long j13 = this.big8;
                            byte[] bArr7 = this.hash;
                            int i25 = this.f59529ii;
                            this.big8 = j13 ^ ((long) ((bArr7[i25] & 255) << (i24 << 3)));
                            this.f59529ii = i25 + 1;
                        }
                    }
                }
                if (this.counter == this.messagesize) {
                    this.big8 = (long) this.checksum;
                }
                this.test = (int) (this.big8 & ((long) this.f59530k));
                this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
            } else if (i19 > 0) {
                Digest digest2 = this.messDigestOTS;
                byte[] bArr8 = this.privateKeyOTS;
                digest2.update(bArr8, 0, bArr8.length);
                byte[] bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                this.privateKeyOTS = bArr9;
                this.messDigestOTS.doFinal(bArr9, 0);
                this.test--;
            }
            if (this.test == 0) {
                byte[] bArr10 = this.privateKeyOTS;
                byte[] bArr11 = this.sign;
                int i26 = this.counter;
                int i27 = this.mdsize;
                System.arraycopy(bArr10, 0, bArr11, i26 * i27, i27);
                this.big8 >>>= this.f59532w;
            } else {
                return;
            }
        } else if (i12 < 57) {
            long j14 = this.test8;
            if (j14 == 0) {
                this.big8 = 0;
                this.f59529ii = 0;
                int i28 = this.f59531r;
                int i29 = i28 % 8;
                int i30 = i28 >>> 3;
                int i31 = this.mdsize;
                if (i30 < i31) {
                    if (i28 <= (i31 << 3) - i12) {
                        int i32 = i28 + i12;
                        this.f59531r = i32;
                        i31 = (i32 + 7) >>> 3;
                    } else {
                        this.f59531r = i28 + i12;
                    }
                    while (true) {
                        j11 = this.big8;
                        if (i30 >= i31) {
                            break;
                        }
                        int i33 = this.f59529ii;
                        this.big8 = j11 ^ ((long) ((this.hash[i30] & 255) << (i33 << 3)));
                        this.f59529ii = i33 + 1;
                        i30++;
                    }
                    long j15 = j11 >>> i29;
                    this.big8 = j15;
                    this.test8 = j15 & ((long) this.f59530k);
                } else {
                    int i34 = this.checksum;
                    this.test8 = (long) (this.f59530k & i34);
                    this.checksum = i34 >>> i12;
                }
                this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
            } else if (j14 > 0) {
                Digest digest3 = this.messDigestOTS;
                byte[] bArr12 = this.privateKeyOTS;
                digest3.update(bArr12, 0, bArr12.length);
                byte[] bArr13 = new byte[this.messDigestOTS.getDigestSize()];
                this.privateKeyOTS = bArr13;
                this.messDigestOTS.doFinal(bArr13, 0);
                this.test8--;
            }
            if (this.test8 == 0) {
                byte[] bArr14 = this.privateKeyOTS;
                byte[] bArr15 = this.sign;
                int i35 = this.counter;
                int i36 = this.mdsize;
                System.arraycopy(bArr14, 0, bArr15, i35 * i36, i36);
            } else {
                return;
            }
        } else {
            return;
        }
        this.counter++;
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

    public byte[] getSig() {
        return this.sign;
    }

    public byte[][] getStatByte() {
        int[] iArr = new int[2];
        iArr[1] = this.mdsize;
        iArr[0] = 5;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        bArr[0] = this.privateKeyOTS;
        bArr[1] = this.seed;
        bArr[2] = this.hash;
        bArr[3] = this.sign;
        bArr[4] = getStatLong();
        return bArr;
    }

    public int[] getStatInt() {
        return new int[]{this.counter, this.test, this.f59529ii, this.f59531r, this.steps, this.keysize, this.height, this.f59532w, this.checksum};
    }

    public byte[] getStatLong() {
        long j11 = this.test8;
        long j12 = this.big8;
        return new byte[]{(byte) ((int) (j11 & 255)), (byte) ((int) ((j11 >> 8) & 255)), (byte) ((int) ((j11 >> 16) & 255)), (byte) ((int) ((j11 >> 24) & 255)), (byte) ((int) ((j11 >> 32) & 255)), (byte) ((int) ((j11 >> 40) & 255)), (byte) ((int) ((j11 >> 48) & 255)), (byte) ((int) ((j11 >> 56) & 255)), (byte) ((int) (j12 & 255)), (byte) ((int) ((j12 >> 8) & 255)), (byte) ((int) ((j12 >> 16) & 255)), (byte) ((int) ((j12 >> 24) & 255)), (byte) ((int) ((j12 >> 32) & 255)), (byte) ((int) ((j12 >> 40) & 255)), (byte) ((int) ((j12 >> 48) & 255)), (byte) ((int) ((j12 >> 56) & 255))};
    }

    public void initSign(byte[] bArr, byte[] bArr2) {
        int i11;
        int i12;
        byte[] bArr3 = bArr2;
        this.hash = new byte[this.mdsize];
        this.messDigestOTS.update(bArr3, 0, bArr3.length);
        byte[] bArr4 = new byte[this.messDigestOTS.getDigestSize()];
        this.hash = bArr4;
        this.messDigestOTS.doFinal(bArr4, 0);
        int i13 = this.mdsize;
        byte[] bArr5 = new byte[i13];
        System.arraycopy(this.hash, 0, bArr5, 0, i13);
        int log = getLog((this.messagesize << this.f59532w) + 1);
        int i14 = this.f59532w;
        int i15 = 8;
        if (8 % i14 == 0) {
            int i16 = 8 / i14;
            i11 = 0;
            for (int i17 = 0; i17 < this.mdsize; i17++) {
                for (int i18 = 0; i18 < i16; i18++) {
                    i11 += bArr5[i17] & this.f59530k;
                    bArr5[i17] = (byte) (bArr5[i17] >>> this.f59532w);
                }
            }
            int i19 = (this.messagesize << this.f59532w) - i11;
            this.checksum = i19;
            int i21 = 0;
            while (i21 < log) {
                i11 += this.f59530k & i19;
                int i22 = this.f59532w;
                i19 >>>= i22;
                i21 += i22;
            }
        } else if (i14 < 8) {
            int i23 = this.mdsize / i14;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            while (i24 < i23) {
                long j11 = 0;
                for (int i27 = 0; i27 < this.f59532w; i27++) {
                    j11 ^= (long) ((bArr5[i25] & 255) << (i27 << 3));
                    i25++;
                }
                int i28 = 0;
                while (i28 < i15) {
                    i26 += (int) (((long) this.f59530k) & j11);
                    j11 >>>= this.f59532w;
                    i28++;
                    i23 = i23;
                    i15 = 8;
                }
                int i29 = i23;
                i24++;
                i15 = 8;
            }
            int i30 = this.mdsize % this.f59532w;
            long j12 = 0;
            for (int i31 = 0; i31 < i30; i31++) {
                j12 ^= (long) ((bArr5[i25] & 255) << (i31 << 3));
                i25++;
            }
            int i32 = i30 << 3;
            int i33 = 0;
            while (i33 < i32) {
                i26 += (int) (((long) this.f59530k) & j12);
                int i34 = this.f59532w;
                j12 >>>= i34;
                i33 += i34;
            }
            int i35 = (this.messagesize << this.f59532w) - i26;
            this.checksum = i35;
            int i36 = 0;
            int i37 = i26;
            while (i36 < log) {
                i37 = i11 + (this.f59530k & i35);
                int i38 = this.f59532w;
                i35 >>>= i38;
                i36 += i38;
            }
        } else if (i14 < 57) {
            int i39 = 0;
            int i40 = 0;
            while (true) {
                i12 = this.mdsize;
                int i41 = this.f59532w;
                if (i39 > (i12 << 3) - i41) {
                    break;
                }
                int i42 = i39 % 8;
                i39 += i41;
                int i43 = (i39 + 7) >>> 3;
                int i44 = 0;
                long j13 = 0;
                for (int i45 = i39 >>> 3; i45 < i43; i45++) {
                    j13 ^= (long) ((bArr5[i45] & 255) << (i44 << 3));
                    i44++;
                }
                i40 = (int) (((long) i40) + ((j13 >>> i42) & ((long) this.f59530k)));
            }
            int i46 = i39 >>> 3;
            if (i46 < i12) {
                int i47 = i39 % 8;
                int i48 = 0;
                long j14 = 0;
                while (i46 < this.mdsize) {
                    j14 ^= (long) ((bArr5[i46] & 255) << (i48 << 3));
                    i48++;
                    i46++;
                }
                i40 = (int) (((long) i40) + ((j14 >>> i47) & ((long) this.f59530k)));
            }
            int i49 = (this.messagesize << this.f59532w) - i40;
            this.checksum = i49;
            int i50 = 0;
            int i51 = i40;
            while (i50 < log) {
                i51 = i11 + (this.f59530k & i49);
                int i52 = this.f59532w;
                i49 >>>= i52;
                i50 += i52;
            }
        } else {
            i11 = 0;
        }
        int ceil = this.messagesize + ((int) Math.ceil(((double) log) / ((double) this.f59532w)));
        this.keysize = ceil;
        this.steps = (int) Math.ceil(((double) (ceil + i11)) / ((double) (1 << this.height)));
        int i53 = this.keysize;
        int i54 = this.mdsize;
        this.sign = new byte[(i53 * i54)];
        this.counter = 0;
        this.test = 0;
        this.f59529ii = 0;
        this.test8 = 0;
        this.f59531r = 0;
        this.privateKeyOTS = new byte[i54];
        byte[] bArr6 = new byte[i54];
        this.seed = bArr6;
        System.arraycopy(bArr, 0, bArr6, 0, i54);
    }

    public String toString() {
        String str = "" + this.big8 + "  ";
        int[] statInt = getStatInt();
        int[] iArr = new int[2];
        iArr[1] = this.mdsize;
        iArr[0] = 5;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        byte[][] statByte = getStatByte();
        for (int i11 = 0; i11 < 9; i11++) {
            str = str + statInt[i11] + " ";
        }
        for (int i12 = 0; i12 < 5; i12++) {
            str = str + new String(Hex.encode(statByte[i12])) + " ";
        }
        return str;
    }

    public boolean updateSign() {
        for (int i11 = 0; i11 < this.steps; i11++) {
            if (this.counter < this.keysize) {
                oneStep();
            }
            if (this.counter == this.keysize) {
                return true;
            }
        }
        return false;
    }
}
