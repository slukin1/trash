package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class KeccakDigest implements ExtendedDigest {
    private static long[] KeccakRoundConstants = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
    public int bitsInQueue;
    public byte[] dataQueue;
    public int fixedOutputLength;
    public int rate;
    public boolean squeezing;
    public long[] state;

    public KeccakDigest() {
        this(288);
    }

    public KeccakDigest(int i11) {
        this.state = new long[25];
        this.dataQueue = new byte[192];
        init(i11);
    }

    public KeccakDigest(KeccakDigest keccakDigest) {
        long[] jArr = new long[25];
        this.state = jArr;
        this.dataQueue = new byte[192];
        long[] jArr2 = keccakDigest.state;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        byte[] bArr = keccakDigest.dataQueue;
        System.arraycopy(bArr, 0, this.dataQueue, 0, bArr.length);
        this.rate = keccakDigest.rate;
        this.bitsInQueue = keccakDigest.bitsInQueue;
        this.fixedOutputLength = keccakDigest.fixedOutputLength;
        this.squeezing = keccakDigest.squeezing;
    }

    private void KeccakAbsorb(byte[] bArr, int i11) {
        int i12 = this.rate >>> 6;
        for (int i13 = 0; i13 < i12; i13++) {
            long[] jArr = this.state;
            jArr[i13] = jArr[i13] ^ Pack.littleEndianToLong(bArr, i11);
            i11 += 8;
        }
        KeccakPermutation();
    }

    private void KeccakExtract() {
        KeccakPermutation();
        Pack.longToLittleEndian(this.state, 0, this.rate >>> 6, this.dataQueue, 0);
        this.bitsInQueue = this.rate;
    }

    private void KeccakPermutation() {
        long[] jArr = this.state;
        int i11 = 0;
        long j11 = jArr[0];
        boolean z11 = true;
        long j12 = jArr[1];
        long j13 = jArr[2];
        char c11 = 3;
        long j14 = jArr[3];
        long j15 = jArr[4];
        long j16 = jArr[5];
        long j17 = jArr[6];
        long j18 = jArr[7];
        long j19 = jArr[8];
        long j21 = jArr[9];
        long j22 = jArr[10];
        long j23 = jArr[11];
        long j24 = jArr[12];
        long j25 = jArr[13];
        long j26 = jArr[14];
        long j27 = jArr[15];
        long j28 = jArr[16];
        long j29 = jArr[17];
        long j30 = jArr[18];
        long j31 = jArr[19];
        long j32 = jArr[20];
        long j33 = jArr[21];
        long j34 = jArr[22];
        long j35 = jArr[23];
        int i12 = 24;
        long j36 = jArr[24];
        while (i11 < i12) {
            long j37 = (((j11 ^ j16) ^ j22) ^ j27) ^ j32;
            long j38 = (((j12 ^ j17) ^ j23) ^ j28) ^ j33;
            long j39 = (((j13 ^ j18) ^ j24) ^ j29) ^ j34;
            long j40 = (((j14 ^ j19) ^ j25) ^ j30) ^ j35;
            long j41 = (((j15 ^ j21) ^ j26) ^ j31) ^ j36;
            long j42 = ((j38 << (z11 ? 1 : 0)) | (j38 >>> -1)) ^ j41;
            long j43 = ((j39 << z11) | (j39 >>> -1)) ^ j37;
            long j44 = ((j40 << z11) | (j40 >>> -1)) ^ j38;
            long j45 = ((j41 << z11) | (j41 >>> -1)) ^ j39;
            long j46 = ((j37 << z11) | (j37 >>> -1)) ^ j40;
            long j47 = j11 ^ j42;
            long j48 = j16 ^ j42;
            long j49 = j22 ^ j42;
            long j50 = j27 ^ j42;
            long j51 = j32 ^ j42;
            long j52 = j12 ^ j43;
            long j53 = j17 ^ j43;
            long j54 = j23 ^ j43;
            long j55 = j28 ^ j43;
            long j56 = j33 ^ j43;
            long j57 = j18 ^ j44;
            long j58 = j24 ^ j44;
            long j59 = j29 ^ j44;
            long j60 = j34 ^ j44;
            long j61 = j19 ^ j45;
            long j62 = j25 ^ j45;
            long j63 = j30 ^ j45;
            long j64 = j35 ^ j45;
            long j65 = j21 ^ j46;
            long j66 = j26 ^ j46;
            long j67 = j31 ^ j46;
            long j68 = j36 ^ j46;
            long j69 = (j52 << z11) | (j52 >>> 63);
            long j70 = (j53 << 44) | (j53 >>> 20);
            long j71 = j15 ^ j46;
            long j72 = (j65 << 20) | (j65 >>> 44);
            long j73 = j60 << 61;
            long j74 = j60 >>> c11;
            long j75 = j14 ^ j45;
            long j76 = j73 | j74;
            long j77 = j13 ^ j44;
            long j78 = (j66 << 39) | (j66 >>> 25);
            long j79 = (j58 << 43) | (j58 >>> 21);
            long j80 = (j77 << 62) | (j77 >>> 2);
            long j81 = (j62 << 25) | (j62 >>> 39);
            long j82 = (j51 << 18) | (j51 >>> 46);
            long j83 = (j67 << 8) | (j67 >>> 56);
            long j84 = j50 << 41;
            long j85 = j50 >>> 23;
            long j86 = (j64 << 56) | (j64 >>> 8);
            long j87 = j84 | j85;
            long j88 = (j71 << 27) | (j71 >>> 37);
            long j89 = (j68 << 14) | (j68 >>> 50);
            long j90 = j56 << 2;
            long j91 = j56 >>> 62;
            long j92 = j81;
            long j93 = j90 | j91;
            long j94 = (j61 << 55) | (j61 >>> 9);
            long j95 = j55 << 45;
            long j96 = j55 >>> 19;
            long j97 = j94;
            long j98 = j95 | j96;
            long j99 = j76;
            long j100 = (j48 << 36) | (j48 >>> 28);
            long j101 = j75 << 28;
            long j102 = j75 >>> 36;
            long j103 = j100;
            long j104 = j101 | j102;
            long j105 = j63 << 21;
            long j106 = j63 >>> 43;
            long j107 = j98;
            long j108 = j105 | j106;
            long j109 = j59 << 15;
            long j110 = j59 >>> 49;
            long j111 = j104;
            long j112 = j109 | j110;
            long j113 = j54 << 10;
            long j114 = j54 >>> 54;
            long j115 = j112;
            long j116 = j113 | j114;
            long j117 = j57 << 6;
            long j118 = j57 >>> 58;
            long j119 = j116;
            long j120 = j117 | j118;
            long j121 = j49 << 3;
            long j122 = j49 >>> 61;
            long j123 = j121 | j122;
            long j124 = ((~j70) & j79) ^ j47;
            long j125 = ((~j79) & j108) ^ j70;
            j13 = j79 ^ ((~j108) & j89);
            j14 = j108 ^ ((~j89) & j47);
            long j126 = j89 ^ ((~j47) & j70);
            long j127 = j123;
            long j128 = ((~j127) & j107) ^ j72;
            long j129 = j126;
            long j130 = j107;
            long j131 = j111 ^ ((~j72) & j123);
            long j132 = ((~j130) & j99) ^ j127;
            long j133 = j99;
            long j134 = j132;
            long j135 = j130 ^ ((~j133) & j111);
            long j136 = ((~j111) & j72) ^ j133;
            long j137 = j120;
            j22 = j69 ^ ((~j137) & j92);
            long j138 = j135;
            long j139 = j92;
            long j140 = ((~j139) & j83) ^ j137;
            long j141 = j83;
            long j142 = j136;
            long j143 = ((~j141) & j82) ^ j139;
            long j144 = j82;
            long j145 = j143;
            long j146 = j141 ^ ((~j144) & j69);
            long j147 = ((~j69) & j137) ^ j144;
            long j148 = j103;
            long j149 = j88 ^ ((~j148) & j119);
            long j150 = j146;
            long j151 = j119;
            long j152 = j147;
            long j153 = ((~j151) & j115) ^ j148;
            long j154 = j115;
            long j155 = j128;
            long j156 = j86;
            long j157 = j151 ^ ((~j154) & j86);
            long j158 = ((~j156) & j88) ^ j154;
            long j159 = ((~j88) & j148) ^ j156;
            long j160 = j97;
            long j161 = j158;
            long j162 = j78;
            long j163 = j159;
            long j164 = ((~j162) & j87) ^ j160;
            long j165 = j87;
            j32 = j80 ^ ((~j160) & j78);
            long j166 = j93;
            long j167 = j162 ^ ((~j165) & j93);
            long j168 = ((~j166) & j80) ^ j165;
            long j169 = j124 ^ KeccakRoundConstants[i11];
            i11++;
            j17 = j155;
            j24 = j145;
            j23 = j140;
            j25 = j150;
            j33 = j164;
            c11 = 3;
            j35 = j168;
            j34 = j167;
            j21 = j142;
            jArr = jArr;
            j31 = j163;
            j26 = j152;
            j18 = j134;
            j19 = j138;
            j29 = j157;
            j27 = j149;
            j15 = j129;
            j16 = j131;
            i12 = 24;
            j30 = j161;
            j28 = j153;
            long j170 = j169;
            z11 = true;
            j12 = j125;
            j36 = ((~j80) & j160) ^ j166;
            j11 = j170;
        }
        long[] jArr2 = jArr;
        jArr2[0] = j11;
        jArr2[1] = j12;
        jArr2[2] = j13;
        jArr2[3] = j14;
        jArr2[4] = j15;
        jArr2[5] = j16;
        jArr2[6] = j17;
        jArr2[7] = j18;
        jArr2[8] = j19;
        jArr2[9] = j21;
        jArr2[10] = j22;
        jArr2[11] = j23;
        jArr2[12] = j24;
        jArr2[13] = j25;
        jArr2[14] = j26;
        jArr2[15] = j27;
        jArr2[16] = j28;
        jArr2[17] = j29;
        jArr2[18] = j30;
        jArr2[19] = j31;
        jArr2[20] = j32;
        jArr2[21] = j33;
        jArr2[22] = j34;
        jArr2[23] = j35;
        jArr2[24] = j36;
    }

    private void init(int i11) {
        if (i11 == 128 || i11 == 224 || i11 == 256 || i11 == 288 || i11 == 384 || i11 == 512) {
            initSponge(1600 - (i11 << 1));
            return;
        }
        throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
    }

    private void initSponge(int i11) {
        if (i11 <= 0 || i11 >= 1600 || i11 % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        }
        this.rate = i11;
        int i12 = 0;
        while (true) {
            long[] jArr = this.state;
            if (i12 < jArr.length) {
                jArr[i12] = 0;
                i12++;
            } else {
                Arrays.fill(this.dataQueue, (byte) 0);
                this.bitsInQueue = 0;
                this.squeezing = false;
                this.fixedOutputLength = (1600 - i11) / 2;
                return;
            }
        }
    }

    private void padAndSwitchToSqueezingPhase() {
        byte[] bArr = this.dataQueue;
        int i11 = this.bitsInQueue;
        int i12 = i11 >>> 3;
        bArr[i12] = (byte) (bArr[i12] | ((byte) (1 << (i11 & 7))));
        int i13 = i11 + 1;
        this.bitsInQueue = i13;
        if (i13 == this.rate) {
            KeccakAbsorb(bArr, 0);
        } else {
            int i14 = i13 >>> 6;
            int i15 = i13 & 63;
            int i16 = 0;
            for (int i17 = 0; i17 < i14; i17++) {
                long[] jArr = this.state;
                jArr[i17] = jArr[i17] ^ Pack.littleEndianToLong(this.dataQueue, i16);
                i16 += 8;
            }
            if (i15 > 0) {
                long[] jArr2 = this.state;
                jArr2[i14] = (((1 << i15) - 1) & Pack.littleEndianToLong(this.dataQueue, i16)) ^ jArr2[i14];
            }
        }
        long[] jArr3 = this.state;
        int i18 = (this.rate - 1) >>> 6;
        jArr3[i18] = jArr3[i18] ^ Long.MIN_VALUE;
        this.bitsInQueue = 0;
        this.squeezing = true;
    }

    public void absorb(byte b11) {
        int i11 = this.bitsInQueue;
        if (i11 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            byte[] bArr = this.dataQueue;
            bArr[i11 >>> 3] = b11;
            int i12 = i11 + 8;
            this.bitsInQueue = i12;
            if (i12 == this.rate) {
                KeccakAbsorb(bArr, 0);
                this.bitsInQueue = 0;
            }
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public void absorb(byte[] bArr, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16 = this.bitsInQueue;
        if (i16 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            int i17 = i16 >>> 3;
            int i18 = this.rate >>> 3;
            int i19 = i18 - i17;
            if (i12 < i19) {
                System.arraycopy(bArr, i11, this.dataQueue, i17, i12);
                i15 = this.bitsInQueue + (i12 << 3);
            } else {
                if (i17 > 0) {
                    System.arraycopy(bArr, i11, this.dataQueue, i17, i19);
                    i13 = i19 + 0;
                    KeccakAbsorb(this.dataQueue, 0);
                } else {
                    i13 = 0;
                }
                while (true) {
                    i14 = i12 - i13;
                    if (i14 < i18) {
                        break;
                    }
                    KeccakAbsorb(bArr, i11 + i13);
                    i13 += i18;
                }
                System.arraycopy(bArr, i11 + i13, this.dataQueue, 0, i14);
                i15 = i14 << 3;
            }
            this.bitsInQueue = i15;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public void absorbBits(int i11, int i12) {
        if (i12 < 1 || i12 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i13 = this.bitsInQueue;
        if (i13 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            this.dataQueue[i13 >>> 3] = (byte) (i11 & ((1 << i12) - 1));
            this.bitsInQueue = i13 + i12;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public int doFinal(byte[] bArr, int i11) {
        squeeze(bArr, i11, (long) this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    public int doFinal(byte[] bArr, int i11, byte b11, int i12) {
        if (i12 > 0) {
            absorbBits(b11, i12);
        }
        squeeze(bArr, i11, (long) this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    public String getAlgorithmName() {
        return "Keccak-" + this.fixedOutputLength;
    }

    public int getByteLength() {
        return this.rate / 8;
    }

    public int getDigestSize() {
        return this.fixedOutputLength / 8;
    }

    public void reset() {
        init(this.fixedOutputLength);
    }

    public void squeeze(byte[] bArr, int i11, long j11) {
        if (!this.squeezing) {
            padAndSwitchToSqueezingPhase();
        }
        long j12 = 0;
        if (j11 % 8 == 0) {
            while (j12 < j11) {
                if (this.bitsInQueue == 0) {
                    KeccakExtract();
                }
                int min = (int) Math.min((long) this.bitsInQueue, j11 - j12);
                System.arraycopy(this.dataQueue, (this.rate - this.bitsInQueue) / 8, bArr, ((int) (j12 / 8)) + i11, min / 8);
                this.bitsInQueue -= min;
                j12 += (long) min;
            }
            return;
        }
        throw new IllegalStateException("outputLength not a multiple of 8");
    }

    public void update(byte b11) {
        absorb(b11);
    }

    public void update(byte[] bArr, int i11, int i12) {
        absorb(bArr, i11, i12);
    }
}
