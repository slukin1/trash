package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public final class Kangaroo {
    private static final int DIGESTLEN = 32;

    public static abstract class KangarooBase implements ExtendedDigest, Xof {
        private static final int BLKSIZE = 8192;
        private static final byte[] FINAL = {-1, -1, 6};
        private static final byte[] FIRST = {3, 0, 0, 0, 0, 0, 0, 0};
        private static final byte[] INTERMEDIATE = {11};
        private static final byte[] SINGLE = {7};
        private final byte[] singleByte = new byte[1];
        private boolean squeezing;
        private final int theChainLen;
        private int theCurrNode;
        private final KangarooSponge theLeaf;
        private byte[] thePersonal;
        private int theProcessed;
        private final KangarooSponge theTree;

        public KangarooBase(int i11, int i12, int i13) {
            this.theTree = new KangarooSponge(i11, i12);
            this.theLeaf = new KangarooSponge(i11, i12);
            this.theChainLen = i11 >> 2;
            buildPersonal((byte[]) null);
        }

        private void buildPersonal(byte[] bArr) {
            int length = bArr == null ? 0 : bArr.length;
            byte[] lengthEncode = lengthEncode((long) length);
            byte[] copyOf = bArr == null ? new byte[(lengthEncode.length + length)] : Arrays.copyOf(bArr, lengthEncode.length + length);
            this.thePersonal = copyOf;
            System.arraycopy(lengthEncode, 0, copyOf, length, lengthEncode.length);
        }

        private static byte[] lengthEncode(long j11) {
            byte b11;
            if (j11 != 0) {
                long j12 = j11;
                b11 = 1;
                while (true) {
                    j12 >>= 8;
                    if (j12 == 0) {
                        break;
                    }
                    b11 = (byte) (b11 + 1);
                }
            } else {
                b11 = 0;
            }
            byte[] bArr = new byte[(b11 + 1)];
            bArr[b11] = b11;
            for (int i11 = 0; i11 < b11; i11++) {
                bArr[i11] = (byte) ((int) (j11 >> (((b11 - i11) - 1) * 8)));
            }
            return bArr;
        }

        private void processData(byte[] bArr, int i11, int i12) {
            if (!this.squeezing) {
                KangarooSponge kangarooSponge = this.theCurrNode == 0 ? this.theTree : this.theLeaf;
                int i13 = 8192 - this.theProcessed;
                if (i13 >= i12) {
                    kangarooSponge.absorb(bArr, i11, i12);
                    this.theProcessed += i12;
                    return;
                }
                if (i13 > 0) {
                    kangarooSponge.absorb(bArr, i11, i13);
                    this.theProcessed += i13;
                }
                while (i13 < i12) {
                    if (this.theProcessed == 8192) {
                        switchLeaf(true);
                    }
                    int min = Math.min(i12 - i13, 8192);
                    this.theLeaf.absorb(bArr, i11 + i13, min);
                    this.theProcessed += min;
                    i13 += min;
                }
                return;
            }
            throw new IllegalStateException("attempt to absorb while squeezing");
        }

        private void switchFinal() {
            switchLeaf(false);
            byte[] lengthEncode = lengthEncode((long) this.theCurrNode);
            this.theTree.absorb(lengthEncode, 0, lengthEncode.length);
            KangarooSponge kangarooSponge = this.theTree;
            byte[] bArr = FINAL;
            kangarooSponge.absorb(bArr, 0, bArr.length);
            this.theTree.padAndSwitchToSqueezingPhase();
        }

        private void switchLeaf(boolean z11) {
            if (this.theCurrNode == 0) {
                KangarooSponge kangarooSponge = this.theTree;
                byte[] bArr = FIRST;
                kangarooSponge.absorb(bArr, 0, bArr.length);
            } else {
                KangarooSponge kangarooSponge2 = this.theLeaf;
                byte[] bArr2 = INTERMEDIATE;
                kangarooSponge2.absorb(bArr2, 0, bArr2.length);
                int i11 = this.theChainLen;
                byte[] bArr3 = new byte[i11];
                this.theLeaf.squeeze(bArr3, 0, i11);
                this.theTree.absorb(bArr3, 0, this.theChainLen);
                this.theLeaf.initSponge();
            }
            if (z11) {
                this.theCurrNode++;
            }
            this.theProcessed = 0;
        }

        private void switchSingle() {
            this.theTree.absorb(SINGLE, 0, 1);
            this.theTree.padAndSwitchToSqueezingPhase();
        }

        private void switchToSqueezing() {
            byte[] bArr = this.thePersonal;
            processData(bArr, 0, bArr.length);
            if (this.theCurrNode == 0) {
                switchSingle();
            } else {
                switchFinal();
            }
        }

        public int doFinal(byte[] bArr, int i11) {
            return doFinal(bArr, i11, getDigestSize());
        }

        public int doFinal(byte[] bArr, int i11, int i12) {
            if (!this.squeezing) {
                int doOutput = doOutput(bArr, i11, i12);
                reset();
                return doOutput;
            }
            throw new IllegalStateException("Already outputting");
        }

        public int doOutput(byte[] bArr, int i11, int i12) {
            if (!this.squeezing) {
                switchToSqueezing();
            }
            if (i12 >= 0) {
                this.theTree.squeeze(bArr, i11, i12);
                return i12;
            }
            throw new IllegalArgumentException("Invalid output length");
        }

        public int getByteLength() {
            return this.theTree.theRateBytes;
        }

        public int getDigestSize() {
            return this.theChainLen >> 1;
        }

        public void init(KangarooParameters kangarooParameters) {
            buildPersonal(kangarooParameters.getPersonalisation());
            reset();
        }

        public void reset() {
            this.theTree.initSponge();
            this.theLeaf.initSponge();
            this.theCurrNode = 0;
            this.theProcessed = 0;
            this.squeezing = false;
        }

        public void update(byte b11) {
            byte[] bArr = this.singleByte;
            bArr[0] = b11;
            update(bArr, 0, 1);
        }

        public void update(byte[] bArr, int i11, int i12) {
            processData(bArr, i11, i12);
        }
    }

    public static class KangarooParameters implements CipherParameters {
        /* access modifiers changed from: private */
        public byte[] thePersonal;

        public static class Builder {
            private byte[] thePersonal;

            public KangarooParameters build() {
                KangarooParameters kangarooParameters = new KangarooParameters();
                byte[] bArr = this.thePersonal;
                if (bArr != null) {
                    byte[] unused = kangarooParameters.thePersonal = bArr;
                }
                return kangarooParameters;
            }

            public Builder setPersonalisation(byte[] bArr) {
                this.thePersonal = Arrays.clone(bArr);
                return this;
            }
        }

        public byte[] getPersonalisation() {
            return Arrays.clone(this.thePersonal);
        }
    }

    public static class KangarooSponge {
        private static long[] KeccakRoundConstants = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
        private int bytesInQueue;
        private boolean squeezing;
        private final byte[] theQueue;
        /* access modifiers changed from: private */
        public final int theRateBytes;
        private final int theRounds;
        private final long[] theState = new long[25];

        public KangarooSponge(int i11, int i12) {
            int i13 = (1600 - (i11 << 1)) >> 3;
            this.theRateBytes = i13;
            this.theRounds = i12;
            this.theQueue = new byte[i13];
            initSponge();
        }

        private void KangarooAbsorb(byte[] bArr, int i11) {
            int i12 = this.theRateBytes >> 3;
            for (int i13 = 0; i13 < i12; i13++) {
                long[] jArr = this.theState;
                jArr[i13] = jArr[i13] ^ Pack.littleEndianToLong(bArr, i11);
                i11 += 8;
            }
            KangarooPermutation();
        }

        private void KangarooExtract() {
            Pack.longToLittleEndian(this.theState, 0, this.theRateBytes >> 3, this.theQueue, 0);
        }

        private void KangarooPermutation() {
            KangarooSponge kangarooSponge = this;
            long[] jArr = kangarooSponge.theState;
            long j11 = jArr[0];
            boolean z11 = true;
            long j12 = jArr[1];
            long j13 = jArr[2];
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
            long j36 = jArr[24];
            int length = KeccakRoundConstants.length - kangarooSponge.theRounds;
            int i11 = 0;
            while (i11 < kangarooSponge.theRounds) {
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
                long j57 = j13 ^ j44;
                long j58 = j18 ^ j44;
                long j59 = j24 ^ j44;
                long j60 = j29 ^ j44;
                long j61 = j34 ^ j44;
                long j62 = j19 ^ j45;
                long j63 = j25 ^ j45;
                long j64 = j30 ^ j45;
                long j65 = j35 ^ j45;
                long j66 = j15 ^ j46;
                long j67 = j21 ^ j46;
                long j68 = j26 ^ j46;
                long j69 = j31 ^ j46;
                long j70 = j36 ^ j46;
                long j71 = (j52 << z11) | (j52 >>> 63);
                long j72 = (j53 << 44) | (j53 >>> 20);
                long j73 = j14 ^ j45;
                long j74 = (j67 << 20) | (j67 >>> 44);
                int i12 = length;
                long j75 = (j68 << 39) | (j68 >>> 25);
                long j76 = (j59 << 43) | (j59 >>> 21);
                long j77 = (j57 << 62) | (j57 >>> 2);
                long j78 = (j63 << 25) | (j63 >>> 39);
                long j79 = (j51 << 18) | (j51 >>> 46);
                long j80 = (j69 << 8) | (j69 >>> 56);
                long j81 = j50 << 41;
                long j82 = j50 >>> 23;
                long j83 = (j65 << 56) | (j65 >>> 8);
                long j84 = j81 | j82;
                long j85 = (j66 << 27) | (j66 >>> 37);
                long j86 = (j70 << 14) | (j70 >>> 50);
                long j87 = j56 << 2;
                long j88 = j56 >>> 62;
                long j89 = j78;
                long j90 = j87 | j88;
                long j91 = j62 << 55;
                long j92 = j62 >>> 9;
                long j93 = j90;
                long j94 = j91 | j92;
                long j95 = j55 << 45;
                long j96 = j55 >>> 19;
                long j97 = j94;
                long j98 = j95 | j96;
                long j99 = (j61 << 61) | (j61 >>> 3);
                long j100 = (j48 << 36) | (j48 >>> 28);
                long j101 = j64 << 21;
                long j102 = j64 >>> 43;
                long j103 = j98;
                long j104 = j101 | j102;
                long j105 = j60 << 15;
                long j106 = j60 >>> 49;
                long j107 = (j73 << 28) | (j73 >>> 36);
                long j108 = j105 | j106;
                long j109 = j54 << 10;
                long j110 = j54 >>> 54;
                long j111 = j108;
                long j112 = j109 | j110;
                long j113 = j58 << 6;
                long j114 = j58 >>> 58;
                long j115 = j112;
                long j116 = j113 | j114;
                long j117 = j49 << 3;
                long j118 = j49 >>> 61;
                long j119 = j116;
                long j120 = j117 | j118;
                long j121 = ((~j72) & j76) ^ j47;
                long j122 = ((~j76) & j104) ^ j72;
                j13 = j76 ^ ((~j104) & j86);
                long j123 = ((~j86) & j47) ^ j104;
                long j124 = ((~j47) & j72) ^ j86;
                long j125 = j107 ^ ((~j74) & j120);
                long j126 = j120;
                long j127 = ((~j126) & j103) ^ j74;
                long j128 = j123;
                long j129 = j103;
                long j130 = j124;
                long j131 = ((~j129) & j99) ^ j126;
                long j132 = j99;
                long j133 = j131;
                long j134 = j129 ^ ((~j132) & j107);
                long j135 = ((~j107) & j74) ^ j132;
                long j136 = j119;
                j22 = j71 ^ ((~j136) & j89);
                long j137 = j134;
                long j138 = j89;
                long j139 = ((~j138) & j80) ^ j136;
                long j140 = j80;
                long j141 = j135;
                long j142 = ((~j140) & j79) ^ j138;
                long j143 = j79;
                long j144 = j142;
                long j145 = j140 ^ ((~j143) & j71);
                long j146 = ((~j71) & j136) ^ j143;
                long j147 = j100;
                long j148 = j85 ^ ((~j147) & j115);
                long j149 = j145;
                long j150 = j115;
                long j151 = j146;
                long j152 = ((~j150) & j111) ^ j147;
                long j153 = j111;
                long j154 = j125;
                long j155 = j83;
                long j156 = j150 ^ ((~j153) & j83);
                long j157 = ((~j155) & j85) ^ j153;
                long j158 = ((~j85) & j147) ^ j155;
                long j159 = j97;
                j32 = j77 ^ ((~j159) & j75);
                long j160 = j75;
                long j161 = j157;
                long j162 = ((~j160) & j84) ^ j159;
                long j163 = j84;
                long j164 = j158;
                long j165 = ((~j163) & j93) ^ j160;
                long j166 = j93;
                long j167 = j163 ^ ((~j166) & j77);
                long j168 = j121 ^ KeccakRoundConstants[i12 + i11];
                i11++;
                j16 = j154;
                j24 = j144;
                j23 = j139;
                j25 = j149;
                j34 = j165;
                j33 = j162;
                j19 = j137;
                j28 = j152;
                j36 = ((~j77) & j159) ^ j166;
                j11 = j168;
                j29 = j156;
                j12 = j122;
                z11 = true;
                j35 = j167;
                j27 = j148;
                jArr = jArr;
                kangarooSponge = this;
                length = i12;
                j14 = j128;
                j15 = j130;
                j30 = j161;
                j26 = j151;
                j18 = j133;
                j17 = j127;
                long j169 = j164;
                j21 = j141;
                j31 = j169;
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

        /* access modifiers changed from: private */
        public void absorb(byte[] bArr, int i11, int i12) {
            int i13;
            if (!this.squeezing) {
                int i14 = 0;
                while (i14 < i12) {
                    int i15 = this.bytesInQueue;
                    if (i15 != 0 || i14 > i12 - this.theRateBytes) {
                        int min = Math.min(this.theRateBytes - i15, i12 - i14);
                        System.arraycopy(bArr, i11 + i14, this.theQueue, this.bytesInQueue, min);
                        int i16 = this.bytesInQueue + min;
                        this.bytesInQueue = i16;
                        i14 += min;
                        if (i16 == this.theRateBytes) {
                            KangarooAbsorb(this.theQueue, 0);
                            this.bytesInQueue = 0;
                        }
                    } else {
                        do {
                            KangarooAbsorb(bArr, i11 + i14);
                            i13 = this.theRateBytes;
                            i14 += i13;
                        } while (i14 <= i12 - i13);
                    }
                }
                return;
            }
            throw new IllegalStateException("attempt to absorb while squeezing");
        }

        /* access modifiers changed from: private */
        public void initSponge() {
            Arrays.fill(this.theState, 0);
            Arrays.fill(this.theQueue, (byte) 0);
            this.bytesInQueue = 0;
            this.squeezing = false;
        }

        /* access modifiers changed from: private */
        public void padAndSwitchToSqueezingPhase() {
            int i11 = this.bytesInQueue;
            while (true) {
                int i12 = this.theRateBytes;
                if (i11 < i12) {
                    this.theQueue[i11] = 0;
                    i11++;
                } else {
                    byte[] bArr = this.theQueue;
                    int i13 = i12 - 1;
                    bArr[i13] = (byte) (bArr[i13] ^ 128);
                    KangarooAbsorb(bArr, 0);
                    KangarooExtract();
                    this.bytesInQueue = this.theRateBytes;
                    this.squeezing = true;
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public void squeeze(byte[] bArr, int i11, int i12) {
            if (!this.squeezing) {
                padAndSwitchToSqueezingPhase();
            }
            int i13 = 0;
            while (i13 < i12) {
                if (this.bytesInQueue == 0) {
                    KangarooPermutation();
                    KangarooExtract();
                    this.bytesInQueue = this.theRateBytes;
                }
                int min = Math.min(this.bytesInQueue, i12 - i13);
                System.arraycopy(this.theQueue, this.theRateBytes - this.bytesInQueue, bArr, i11 + i13, min);
                this.bytesInQueue -= min;
                i13 += min;
            }
        }
    }

    public static class KangarooTwelve extends KangarooBase {
        public KangarooTwelve() {
            this(32);
        }

        public KangarooTwelve(int i11) {
            super(128, 12, i11);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i11) {
            return super.doFinal(bArr, i11);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i11, int i12) {
            return super.doFinal(bArr, i11, i12);
        }

        public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i11, int i12) {
            return super.doOutput(bArr, i11, i12);
        }

        public String getAlgorithmName() {
            return "KangarooTwelve";
        }

        public /* bridge */ /* synthetic */ int getByteLength() {
            return super.getByteLength();
        }

        public /* bridge */ /* synthetic */ int getDigestSize() {
            return super.getDigestSize();
        }

        public /* bridge */ /* synthetic */ void init(KangarooParameters kangarooParameters) {
            super.init(kangarooParameters);
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public /* bridge */ /* synthetic */ void update(byte b11) {
            super.update(b11);
        }

        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i11, int i12) {
            super.update(bArr, i11, i12);
        }
    }

    public static class MarsupilamiFourteen extends KangarooBase {
        public MarsupilamiFourteen() {
            this(32);
        }

        public MarsupilamiFourteen(int i11) {
            super(256, 14, i11);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i11) {
            return super.doFinal(bArr, i11);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i11, int i12) {
            return super.doFinal(bArr, i11, i12);
        }

        public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i11, int i12) {
            return super.doOutput(bArr, i11, i12);
        }

        public String getAlgorithmName() {
            return "MarsupilamiFourteen";
        }

        public /* bridge */ /* synthetic */ int getByteLength() {
            return super.getByteLength();
        }

        public /* bridge */ /* synthetic */ int getDigestSize() {
            return super.getDigestSize();
        }

        public /* bridge */ /* synthetic */ void init(KangarooParameters kangarooParameters) {
            super.init(kangarooParameters);
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public /* bridge */ /* synthetic */ void update(byte b11) {
            super.update(b11);
        }

        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i11, int i12) {
            super.update(bArr, i11, i12);
        }
    }
}
