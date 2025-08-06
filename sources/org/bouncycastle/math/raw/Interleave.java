package org.bouncycastle.math.raw;

public class Interleave {
    private static final long M32 = 1431655765;
    private static final long M64 = 6148914691236517205L;
    private static final long M64R = -6148914691236517206L;

    public static int expand16to32(int i11) {
        int i12 = i11 & 65535;
        int i13 = (i12 | (i12 << 8)) & 16711935;
        int i14 = (i13 | (i13 << 4)) & 252645135;
        int i15 = (i14 | (i14 << 2)) & 858993459;
        return (i15 | (i15 << 1)) & 1431655765;
    }

    public static long expand32to64(int i11) {
        int bitPermuteStep = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i11, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
        return ((((long) (bitPermuteStep >>> 1)) & M32) << 32) | (M32 & ((long) bitPermuteStep));
    }

    public static void expand64To128(long j11, long[] jArr, int i11) {
        long bitPermuteStep = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j11, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i11] = bitPermuteStep & M64;
        jArr[i11 + 1] = (bitPermuteStep >>> 1) & M64;
    }

    public static void expand64To128(long[] jArr, int i11, int i12, long[] jArr2, int i13) {
        for (int i14 = 0; i14 < i12; i14++) {
            expand64To128(jArr[i11 + i14], jArr2, i13);
            i13 += 2;
        }
    }

    public static void expand64To128Rev(long j11, long[] jArr, int i11) {
        long bitPermuteStep = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j11, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i11] = bitPermuteStep & M64R;
        jArr[i11 + 1] = (bitPermuteStep << 1) & M64R;
    }

    public static int expand8to16(int i11) {
        int i12 = i11 & 255;
        int i13 = (i12 | (i12 << 4)) & 3855;
        int i14 = (i13 | (i13 << 2)) & 13107;
        return (i14 | (i14 << 1)) & 21845;
    }

    public static int shuffle(int i11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i11, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
    }

    public static long shuffle(long j11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j11, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
    }

    public static int shuffle2(int i11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i11, 11141290, 7), 52428, 14), 15728880, 4), 65280, 8);
    }

    public static long shuffle2(long j11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j11, 4278255360L, 24), 57421771435671756L, 6), 264913582878960L, 12), 723401728380766730L, 3);
    }

    public static long shuffle3(long j11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j11, 47851476196393130L, 7), 225176545447116L, 14), 4042322160L, 28);
    }

    public static int unshuffle(int i11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i11, 572662306, 1), 202116108, 2), 15728880, 4), 65280, 8);
    }

    public static long unshuffle(long j11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j11, 2459565876494606882L, 1), 868082074056920076L, 2), 67555025218437360L, 4), 280375465148160L, 8), 4294901760L, 16);
    }

    public static int unshuffle2(int i11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(i11, 65280, 8), 15728880, 4), 52428, 14), 11141290, 7);
    }

    public static long unshuffle2(long j11) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(j11, 723401728380766730L, 3), 264913582878960L, 12), 57421771435671756L, 6), 4278255360L, 24);
    }

    public static long unshuffle3(long j11) {
        return shuffle3(j11);
    }
}
