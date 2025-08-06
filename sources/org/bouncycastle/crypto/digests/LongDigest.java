package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public abstract class LongDigest implements ExtendedDigest, Memoable, EncodableDigest {
    private static final int BYTE_LENGTH = 128;
    public static final long[] K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    public long H1;
    public long H2;
    public long H3;
    public long H4;
    public long H5;
    public long H6;
    public long H7;
    public long H8;
    private long[] W;
    private long byteCount1;
    private long byteCount2;
    private int wOff;
    private byte[] xBuf;
    private int xBufOff;

    public LongDigest() {
        this.xBuf = new byte[8];
        this.W = new long[80];
        this.xBufOff = 0;
        reset();
    }

    public LongDigest(LongDigest longDigest) {
        this.xBuf = new byte[8];
        this.W = new long[80];
        copyIn(longDigest);
    }

    private long Ch(long j11, long j12, long j13) {
        return ((~j11) & j13) ^ (j12 & j11);
    }

    private long Maj(long j11, long j12, long j13) {
        return ((j11 & j13) ^ (j11 & j12)) ^ (j12 & j13);
    }

    private long Sigma0(long j11) {
        return (j11 >>> 7) ^ (((j11 << 63) | (j11 >>> 1)) ^ ((j11 << 56) | (j11 >>> 8)));
    }

    private long Sigma1(long j11) {
        return (j11 >>> 6) ^ (((j11 << 45) | (j11 >>> 19)) ^ ((j11 << 3) | (j11 >>> 61)));
    }

    private long Sum0(long j11) {
        return ((j11 >>> 39) | (j11 << 25)) ^ (((j11 << 36) | (j11 >>> 28)) ^ ((j11 << 30) | (j11 >>> 34)));
    }

    private long Sum1(long j11) {
        return ((j11 >>> 41) | (j11 << 23)) ^ (((j11 << 50) | (j11 >>> 14)) ^ ((j11 << 46) | (j11 >>> 18)));
    }

    private void adjustByteCounts() {
        long j11 = this.byteCount1;
        if (j11 > 2305843009213693951L) {
            this.byteCount2 += j11 >>> 61;
            this.byteCount1 = j11 & 2305843009213693951L;
        }
    }

    public void copyIn(LongDigest longDigest) {
        byte[] bArr = longDigest.xBuf;
        System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
        this.xBufOff = longDigest.xBufOff;
        this.byteCount1 = longDigest.byteCount1;
        this.byteCount2 = longDigest.byteCount2;
        this.H1 = longDigest.H1;
        this.H2 = longDigest.H2;
        this.H3 = longDigest.H3;
        this.H4 = longDigest.H4;
        this.H5 = longDigest.H5;
        this.H6 = longDigest.H6;
        this.H7 = longDigest.H7;
        this.H8 = longDigest.H8;
        long[] jArr = longDigest.W;
        System.arraycopy(jArr, 0, this.W, 0, jArr.length);
        this.wOff = longDigest.wOff;
    }

    public void finish() {
        adjustByteCounts();
        long j11 = this.byteCount1 << 3;
        long j12 = this.byteCount2;
        byte b11 = Byte.MIN_VALUE;
        while (true) {
            update(b11);
            if (this.xBufOff != 0) {
                b11 = 0;
            } else {
                processLength(j11, j12);
                processBlock();
                return;
            }
        }
    }

    public int getByteLength() {
        return 128;
    }

    public int getEncodedStateSize() {
        return (this.wOff * 8) + 96;
    }

    public void populateState(byte[] bArr) {
        System.arraycopy(this.xBuf, 0, bArr, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, bArr, 8);
        Pack.longToBigEndian(this.byteCount1, bArr, 12);
        Pack.longToBigEndian(this.byteCount2, bArr, 20);
        Pack.longToBigEndian(this.H1, bArr, 28);
        Pack.longToBigEndian(this.H2, bArr, 36);
        Pack.longToBigEndian(this.H3, bArr, 44);
        Pack.longToBigEndian(this.H4, bArr, 52);
        Pack.longToBigEndian(this.H5, bArr, 60);
        Pack.longToBigEndian(this.H6, bArr, 68);
        Pack.longToBigEndian(this.H7, bArr, 76);
        Pack.longToBigEndian(this.H8, bArr, 84);
        Pack.intToBigEndian(this.wOff, bArr, 92);
        for (int i11 = 0; i11 < this.wOff; i11++) {
            Pack.longToBigEndian(this.W[i11], bArr, (i11 * 8) + 96);
        }
    }

    public void processBlock() {
        adjustByteCounts();
        for (int i11 = 16; i11 <= 79; i11++) {
            long[] jArr = this.W;
            long Sigma1 = Sigma1(jArr[i11 - 2]);
            long[] jArr2 = this.W;
            jArr[i11] = Sigma1 + jArr2[i11 - 7] + Sigma0(jArr2[i11 - 15]) + this.W[i11 - 16];
        }
        long j11 = this.H1;
        long j12 = this.H2;
        long j13 = this.H3;
        long j14 = this.H4;
        long j15 = this.H5;
        long j16 = this.H6;
        long j17 = this.H7;
        long j18 = j16;
        long j19 = j14;
        int i12 = 0;
        long j21 = j12;
        long j22 = j13;
        long j23 = j15;
        int i13 = 0;
        long j24 = this.H8;
        long j25 = j17;
        long j26 = j11;
        long j27 = j25;
        while (i13 < 10) {
            int i14 = i13;
            long j28 = j23;
            long[] jArr3 = K;
            int i15 = i12 + 1;
            long Sum1 = j24 + Sum1(j23) + Ch(j23, j18, j27) + jArr3[i12] + this.W[i12];
            long Sum0 = Sum1 + Sum0(j26) + Maj(j26, j21, j22);
            long j29 = j19 + Sum1;
            long j30 = j29;
            int i16 = i15 + 1;
            long Sum12 = j27 + Sum1(j29) + Ch(j29, j28, j18) + jArr3[i15] + this.W[i15];
            long j31 = Sum0;
            long j32 = j22 + Sum12;
            long Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, j26, j21);
            long Sum13 = Sum1(j32);
            long j33 = j32;
            long j34 = Sum02;
            int i17 = i16 + 1;
            long Ch = j18 + Sum13 + Ch(j32, j30, j28) + jArr3[i16] + this.W[i16];
            long j35 = j21 + Ch;
            long Sum03 = Ch + Sum0(j34) + Maj(j34, j31, j26);
            long Sum14 = Sum1(j35);
            long j36 = j35;
            long j37 = Sum03;
            int i18 = i17 + 1;
            long Ch2 = j28 + Sum14 + Ch(j35, j33, j30) + jArr3[i17] + this.W[i17];
            long j38 = j26 + Ch2;
            long Sum04 = Ch2 + Sum0(j37) + Maj(j37, j34, j31);
            long Sum15 = Sum1(j38);
            long j39 = j38;
            long j40 = Sum04;
            int i19 = i18 + 1;
            long Ch3 = j30 + Sum15 + Ch(j38, j36, j33) + jArr3[i18] + this.W[i18];
            long j41 = j37;
            long j42 = j37;
            long j43 = j31 + Ch3;
            long Sum05 = Ch3 + Sum0(j40) + Maj(j40, j41, j34);
            long Sum16 = Sum1(j43);
            long j44 = j43;
            long j45 = Sum05;
            int i21 = i19 + 1;
            long Ch4 = j33 + Sum16 + Ch(j43, j39, j36) + jArr3[i19] + this.W[i19];
            long j46 = j34 + Ch4;
            long Sum06 = Ch4 + Sum0(j45) + Maj(j45, j40, j42);
            long Sum17 = Sum1(j46);
            j27 = j46;
            long j47 = Sum06;
            int i22 = i21 + 1;
            long Ch5 = j36 + Sum17 + Ch(j46, j44, j39) + jArr3[i21] + this.W[i21];
            long j48 = j42 + Ch5;
            long j49 = j45;
            long j50 = j45;
            long j51 = j48;
            long Sum07 = Ch5 + Sum0(j47) + Maj(j47, j49, j40);
            long Sum18 = Sum1(j51);
            j18 = j51;
            j21 = Sum07;
            long Ch6 = j39 + Sum18 + Ch(j51, j27, j44) + jArr3[i22] + this.W[i22];
            long Sum08 = Ch6 + Sum0(j21) + Maj(j21, j47, j50);
            i13 = i14 + 1;
            j23 = j40 + Ch6;
            j22 = j47;
            j24 = j44;
            j19 = j50;
            i12 = i22 + 1;
            j26 = Sum08;
        }
        this.H1 += j26;
        this.H2 += j21;
        this.H3 += j22;
        this.H4 += j19;
        this.H5 += j23;
        this.H6 += j18;
        this.H7 += j27;
        this.H8 += j24;
        this.wOff = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            this.W[i23] = 0;
        }
    }

    public void processLength(long j11, long j12) {
        if (this.wOff > 14) {
            processBlock();
        }
        long[] jArr = this.W;
        jArr[14] = j12;
        jArr[15] = j11;
    }

    public void processWord(byte[] bArr, int i11) {
        this.W[this.wOff] = Pack.bigEndianToLong(bArr, i11);
        int i12 = this.wOff + 1;
        this.wOff = i12;
        if (i12 == 16) {
            processBlock();
        }
    }

    public void reset() {
        this.byteCount1 = 0;
        this.byteCount2 = 0;
        int i11 = 0;
        this.xBufOff = 0;
        int i12 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i12 >= bArr.length) {
                break;
            }
            bArr[i12] = 0;
            i12++;
        }
        this.wOff = 0;
        while (true) {
            long[] jArr = this.W;
            if (i11 != jArr.length) {
                jArr[i11] = 0;
                i11++;
            } else {
                return;
            }
        }
    }

    public void restoreState(byte[] bArr) {
        int bigEndianToInt = Pack.bigEndianToInt(bArr, 8);
        this.xBufOff = bigEndianToInt;
        System.arraycopy(bArr, 0, this.xBuf, 0, bigEndianToInt);
        this.byteCount1 = Pack.bigEndianToLong(bArr, 12);
        this.byteCount2 = Pack.bigEndianToLong(bArr, 20);
        this.H1 = Pack.bigEndianToLong(bArr, 28);
        this.H2 = Pack.bigEndianToLong(bArr, 36);
        this.H3 = Pack.bigEndianToLong(bArr, 44);
        this.H4 = Pack.bigEndianToLong(bArr, 52);
        this.H5 = Pack.bigEndianToLong(bArr, 60);
        this.H6 = Pack.bigEndianToLong(bArr, 68);
        this.H7 = Pack.bigEndianToLong(bArr, 76);
        this.H8 = Pack.bigEndianToLong(bArr, 84);
        this.wOff = Pack.bigEndianToInt(bArr, 92);
        for (int i11 = 0; i11 < this.wOff; i11++) {
            this.W[i11] = Pack.bigEndianToLong(bArr, (i11 * 8) + 96);
        }
    }

    public void update(byte b11) {
        byte[] bArr = this.xBuf;
        int i11 = this.xBufOff;
        int i12 = i11 + 1;
        this.xBufOff = i12;
        bArr[i11] = b11;
        if (i12 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount1++;
    }

    public void update(byte[] bArr, int i11, int i12) {
        while (this.xBufOff != 0 && i12 > 0) {
            update(bArr[i11]);
            i11++;
            i12--;
        }
        while (i12 > this.xBuf.length) {
            processWord(bArr, i11);
            byte[] bArr2 = this.xBuf;
            i11 += bArr2.length;
            i12 -= bArr2.length;
            this.byteCount1 += (long) bArr2.length;
        }
        while (i12 > 0) {
            update(bArr[i11]);
            i11++;
            i12--;
        }
    }
}
