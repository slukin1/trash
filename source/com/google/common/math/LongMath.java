package com.google.common.math;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import java.math.RoundingMode;
import okhttp3.internal.connection.RealConnection;

@GwtCompatible(emulated = true)
public final class LongMath {
    @VisibleForTesting
    public static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    @VisibleForTesting
    public static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    @VisibleForTesting
    public static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    public static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting
    public static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    public static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    @GwtIncompatible
    @VisibleForTesting
    public static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    @VisibleForTesting
    public static final byte[] maxLog10ForLeadingZeros = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    @GwtIncompatible
    @VisibleForTesting
    public static final long[] powersOf10 = {1, 10, 100, 1000, 10000, IndexSeeker.MIN_TIME_BETWEEN_POINTS_US, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.AnonymousClass1.<clinit>():void");
        }
    }

    public enum MillerRabinTester {
        SMALL {
            public long mulMod(long j11, long j12, long j13) {
                return (j11 * j12) % j13;
            }

            public long squareMod(long j11, long j12) {
                return (j11 * j11) % j12;
            }
        },
        LARGE {
            private long plusMod(long j11, long j12, long j13) {
                int i11 = (j11 > (j13 - j12) ? 1 : (j11 == (j13 - j12) ? 0 : -1));
                long j14 = j11 + j12;
                return i11 >= 0 ? j14 - j13 : j14;
            }

            private long times2ToThe32Mod(long j11, long j12) {
                int i11 = 32;
                do {
                    int min = Math.min(i11, Long.numberOfLeadingZeros(j11));
                    j11 = UnsignedLongs.remainder(j11 << min, j12);
                    i11 -= min;
                } while (i11 > 0);
                return j11;
            }

            public long mulMod(long j11, long j12, long j13) {
                long j14 = j13;
                long j15 = j11 >>> 32;
                long j16 = j12 >>> 32;
                long j17 = j11 & 4294967295L;
                long j18 = j12 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j15 * j16, j14) + (j15 * j18);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j14);
                }
                Long.signum(j17);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j16 * j17), j14), UnsignedLongs.remainder(j17 * j18, j14), j13);
            }

            public long squareMod(long j11, long j12) {
                long j13 = j11 >>> 32;
                long j14 = j11 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j13 * j13, j12);
                long j15 = j13 * j14 * 2;
                if (j15 < 0) {
                    j15 = UnsignedLongs.remainder(j15, j12);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j15, j12), UnsignedLongs.remainder(j14 * j14, j12), j12);
            }
        };

        private long powMod(long j11, long j12, long j13) {
            long j14 = 1;
            while (j12 != 0) {
                if ((j12 & 1) != 0) {
                    j14 = mulMod(j14, j11, j13);
                }
                j11 = squareMod(j11, j13);
                j12 >>= 1;
            }
            return j14;
        }

        public static boolean test(long j11, long j12) {
            return (j12 <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(j11, j12);
        }

        private boolean testWitness(long j11, long j12) {
            long j13 = j12;
            long j14 = j13 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j14);
            long j15 = j14 >> numberOfTrailingZeros;
            long j16 = j11 % j13;
            if (j16 == 0) {
                return true;
            }
            long powMod = powMod(j16, j15, j12);
            if (powMod == 1) {
                return true;
            }
            int i11 = 0;
            while (powMod != j14) {
                i11++;
                if (i11 == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j13);
            }
            return true;
        }

        public abstract long mulMod(long j11, long j12, long j13);

        public abstract long squareMod(long j11, long j12);
    }

    private LongMath() {
    }

    public static long binomial(int i11, int i12) {
        MathPreconditions.checkNonNegative(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, i11);
        MathPreconditions.checkNonNegative("k", i12);
        Preconditions.checkArgument(i12 <= i11, "k (%s) > n (%s)", i12, i11);
        if (i12 > (i11 >> 1)) {
            i12 = i11 - i12;
        }
        long j11 = 1;
        if (i12 == 0) {
            return 1;
        }
        if (i12 == 1) {
            return (long) i11;
        }
        long[] jArr = factorials;
        if (i11 < jArr.length) {
            return jArr[i11] / (jArr[i12] * jArr[i11 - i12]);
        }
        int[] iArr = biggestBinomials;
        if (i12 >= iArr.length || i11 > iArr[i12]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i12 >= iArr2.length || i11 > iArr2[i12]) {
            long j12 = (long) i11;
            int log2 = log2(j12, RoundingMode.CEILING);
            int i13 = i11 - 1;
            int i14 = log2;
            int i15 = 2;
            long j13 = j12;
            long j14 = 1;
            while (i15 <= i12) {
                i14 += log2;
                if (i14 < 63) {
                    j13 *= (long) i13;
                    j14 *= (long) i15;
                } else {
                    j11 = multiplyFraction(j11, j13, j14);
                    j13 = (long) i13;
                    j14 = (long) i15;
                    i14 = log2;
                }
                i15++;
                i13--;
            }
            return multiplyFraction(j11, j13, j14);
        }
        int i16 = i11 - 1;
        long j15 = (long) i11;
        for (int i17 = 2; i17 <= i12; i17++) {
            j15 = (j15 * ((long) i16)) / ((long) i17);
            i16--;
        }
        return j15;
    }

    @Beta
    public static long ceilingPowerOfTwo(long j11) {
        MathPreconditions.checkPositive("x", j11);
        if (j11 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j11 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j11 + ") is not representable as a long");
    }

    @GwtIncompatible
    public static long checkedAdd(long j11, long j12) {
        long j13 = j11 + j12;
        boolean z11 = true;
        boolean z12 = (j11 ^ j12) < 0;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        MathPreconditions.checkNoOverflow(z12 | z11, "checkedAdd", j11, j12);
        return j13;
    }

    public static long checkedMultiply(long j11, long j12) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j12) + Long.numberOfLeadingZeros(~j12);
        if (numberOfLeadingZeros > 65) {
            return j11 * j12;
        }
        MathPreconditions.checkNoOverflow(numberOfLeadingZeros >= 64, "checkedMultiply", j11, j12);
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        MathPreconditions.checkNoOverflow((i11 >= 0) | (j12 != Long.MIN_VALUE), "checkedMultiply", j11, j12);
        long j13 = j11 * j12;
        MathPreconditions.checkNoOverflow(i11 == 0 || j13 / j11 == j12, "checkedMultiply", j11, j12);
        return j13;
    }

    @GwtIncompatible
    public static long checkedPow(long j11, int i11) {
        MathPreconditions.checkNonNegative("exponent", i11);
        long j12 = 1;
        if ((j11 >= -2) && (j11 <= 2)) {
            int i12 = (int) j11;
            if (i12 == -2) {
                MathPreconditions.checkNoOverflow(i11 < 64, "checkedPow", j11, (long) i11);
                return (i11 & 1) == 0 ? 1 << i11 : -1 << i11;
            } else if (i12 != -1) {
                if (i12 != 0) {
                    if (i12 == 1) {
                        return 1;
                    }
                    if (i12 == 2) {
                        MathPreconditions.checkNoOverflow(i11 < 63, "checkedPow", j11, (long) i11);
                        return 1 << i11;
                    }
                    throw new AssertionError();
                } else if (i11 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i11 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            long j13 = j11;
            int i13 = i11;
            while (i13 != 0) {
                if (i13 == 1) {
                    return checkedMultiply(j12, j13);
                }
                if ((i13 & 1) != 0) {
                    j12 = checkedMultiply(j12, j13);
                }
                long j14 = j12;
                int i14 = i13 >> 1;
                if (i14 > 0) {
                    MathPreconditions.checkNoOverflow(-3037000499L <= j13 && j13 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j13, (long) i14);
                    j13 *= j13;
                }
                i13 = i14;
                j12 = j14;
            }
            return j12;
        }
    }

    @GwtIncompatible
    public static long checkedSubtract(long j11, long j12) {
        long j13 = j11 - j12;
        boolean z11 = true;
        boolean z12 = (j11 ^ j12) >= 0;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        MathPreconditions.checkNoOverflow(z12 | z11, "checkedSubtract", j11, j12);
        return j13;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r11 > 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r9 > 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r9 < 0) goto L_0x0062;
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long divide(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            return r0
        L_0x0010:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r9 = (int) r9
            r10 = 1
            r9 = r9 | r10
            int[] r7 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r8 = r13.ordinal()
            r7 = r7[r8]
            r8 = 0
            switch(r7) {
                case 1: goto L_0x005a;
                case 2: goto L_0x0061;
                case 3: goto L_0x0057;
                case 4: goto L_0x0062;
                case 5: goto L_0x0054;
                case 6: goto L_0x0029;
                case 7: goto L_0x0029;
                case 8: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x0029:
            long r2 = java.lang.Math.abs(r2)
            long r11 = java.lang.Math.abs(r11)
            long r11 = r11 - r2
            long r2 = r2 - r11
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x0051
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r13 != r11) goto L_0x003d
            r11 = r10
            goto L_0x003e
        L_0x003d:
            r11 = r8
        L_0x003e:
            java.math.RoundingMode r12 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r12) goto L_0x0044
            r12 = r10
            goto L_0x0045
        L_0x0044:
            r12 = r8
        L_0x0045:
            r2 = 1
            long r2 = r2 & r0
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r10 = r8
        L_0x004e:
            r10 = r10 & r12
            r10 = r10 | r11
            goto L_0x0062
        L_0x0051:
            if (r11 <= 0) goto L_0x0061
            goto L_0x0062
        L_0x0054:
            if (r9 <= 0) goto L_0x0061
            goto L_0x0062
        L_0x0057:
            if (r9 >= 0) goto L_0x0061
            goto L_0x0062
        L_0x005a:
            if (r6 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r10 = r8
        L_0x005e:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r10)
        L_0x0061:
            r10 = r8
        L_0x0062:
            if (r10 == 0) goto L_0x0066
            long r9 = (long) r9
            long r0 = r0 + r9
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    @GwtIncompatible
    public static long factorial(int i11) {
        MathPreconditions.checkNonNegative(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, i11);
        long[] jArr = factorials;
        if (i11 < jArr.length) {
            return jArr[i11];
        }
        return Long.MAX_VALUE;
    }

    public static boolean fitsInInt(long j11) {
        return ((long) ((int) j11)) == j11;
    }

    @Beta
    public static long floorPowerOfTwo(long j11) {
        MathPreconditions.checkPositive("x", j11);
        return 1 << (63 - Long.numberOfLeadingZeros(j11));
    }

    public static long gcd(long j11, long j12) {
        MathPreconditions.checkNonNegative("a", j11);
        MathPreconditions.checkNonNegative("b", j12);
        if (j11 == 0) {
            return j12;
        }
        if (j12 == 0) {
            return j11;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j11);
        long j13 = j11 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j12);
        long j14 = j12 >> numberOfTrailingZeros2;
        while (j13 != j14) {
            long j15 = j13 - j14;
            long j16 = (j15 >> 63) & j15;
            long j17 = (j15 - j16) - j16;
            j14 += j16;
            j13 = j17 >> Long.numberOfTrailingZeros(j17);
        }
        return j13 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j11) {
        boolean z11 = true;
        boolean z12 = j11 > 0;
        if ((j11 & (j11 - 1)) != 0) {
            z11 = false;
        }
        return z12 & z11;
    }

    @GwtIncompatible
    @Beta
    public static boolean isPrime(long j11) {
        int i11 = (j11 > 2 ? 1 : (j11 == 2 ? 0 : -1));
        if (i11 < 0) {
            MathPreconditions.checkNonNegative(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, j11);
            return false;
        } else if (i11 == 0 || j11 == 3 || j11 == 5 || j11 == 7 || j11 == 11 || j11 == 13) {
            return true;
        } else {
            if ((SIEVE_30 & (1 << ((int) (j11 % 30)))) != 0 || j11 % 7 == 0 || j11 % 11 == 0 || j11 % 13 == 0) {
                return false;
            }
            if (j11 < 289) {
                return true;
            }
            for (long[] jArr : millerRabinBaseSets) {
                if (j11 <= jArr[0]) {
                    for (int i12 = 1; i12 < jArr.length; i12++) {
                        if (!MillerRabinTester.test(jArr[i12], j11)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long j11, long j12) {
        return (int) ((~(~(j11 - j12))) >>> 63);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r0 + r4;
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int log10(long r4, java.math.RoundingMode r6) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.checkPositive((java.lang.String) r0, (long) r4)
            int r0 = log10Floor(r4)
            long[] r1 = powersOf10
            r2 = r1[r0]
            int[] r1 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r6 = r6.ordinal()
            r6 = r1[r6]
            switch(r6) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0037;
                case 3: goto L_0x0037;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x001e;
                case 7: goto L_0x001e;
                case 8: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x001e:
            long[] r6 = halfPowersOf10
            r1 = r6[r0]
            int r4 = lessThanBranchFree(r1, r4)
        L_0x0026:
            int r0 = r0 + r4
            return r0
        L_0x0028:
            int r4 = lessThanBranchFree(r2, r4)
            goto L_0x0026
        L_0x002d:
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r4)
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.log10(long, java.math.RoundingMode):int");
    }

    @GwtIncompatible
    public static int log10Floor(long j11) {
        byte b11 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j11)];
        return b11 - lessThanBranchFree(j11, powersOf10[b11]);
    }

    public static int log2(long j11, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j11);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j11));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j11 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j11);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j11);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j11);
    }

    public static long mean(long j11, long j12) {
        return (j11 & j12) + ((j11 ^ j12) >> 1);
    }

    @GwtIncompatible
    public static int mod(long j11, int i11) {
        return (int) mod(j11, (long) i11);
    }

    public static long multiplyFraction(long j11, long j12, long j13) {
        if (j11 == 1) {
            return j12 / j13;
        }
        long gcd = gcd(j11, j13);
        return (j11 / gcd) * (j12 / (j13 / gcd));
    }

    @GwtIncompatible
    public static long pow(long j11, int i11) {
        MathPreconditions.checkNonNegative("exponent", i11);
        if (-2 > j11 || j11 > 2) {
            long j12 = 1;
            while (i11 != 0) {
                if (i11 == 1) {
                    return j12 * j11;
                }
                j12 *= (i11 & 1) == 0 ? 1 : j11;
                j11 *= j11;
                i11 >>= 1;
            }
            return j12;
        }
        int i12 = (int) j11;
        if (i12 != -2) {
            if (i12 != -1) {
                if (i12 != 0) {
                    if (i12 == 1) {
                        return 1;
                    }
                    if (i12 != 2) {
                        throw new AssertionError();
                    } else if (i11 < 64) {
                        return 1 << i11;
                    } else {
                        return 0;
                    }
                } else if (i11 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i11 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i11 < 64) {
            return (i11 & 1) == 0 ? 1 << i11 : -(1 << i11);
        } else {
            return 0;
        }
    }

    @Beta
    public static long saturatedAdd(long j11, long j12) {
        long j13 = j11 + j12;
        boolean z11 = true;
        boolean z12 = (j12 ^ j11) < 0;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        return z12 | z11 ? j13 : ((j13 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long saturatedMultiply(long j11, long j12) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j12) + Long.numberOfLeadingZeros(~j12);
        if (numberOfLeadingZeros > 65) {
            return j11 * j12;
        }
        long j13 = ((j11 ^ j12) >>> 63) + Long.MAX_VALUE;
        boolean z11 = true;
        boolean z12 = numberOfLeadingZeros < 64;
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        boolean z13 = i11 < 0;
        if (j12 != Long.MIN_VALUE) {
            z11 = false;
        }
        if (z12 || (z11 & z13)) {
            return j13;
        }
        long j14 = j11 * j12;
        return (i11 == 0 || j14 / j11 == j12) ? j14 : j13;
    }

    @Beta
    public static long saturatedPow(long j11, int i11) {
        MathPreconditions.checkNonNegative("exponent", i11);
        long j12 = 1;
        if ((j11 >= -2) && (j11 <= 2)) {
            int i12 = (int) j11;
            if (i12 != -2) {
                if (i12 != -1) {
                    if (i12 != 0) {
                        if (i12 == 1) {
                            return 1;
                        }
                        if (i12 != 2) {
                            throw new AssertionError();
                        } else if (i11 >= 63) {
                            return Long.MAX_VALUE;
                        } else {
                            return 1 << i11;
                        }
                    } else if (i11 == 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else if ((i11 & 1) == 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (i11 >= 64) {
                return ((long) (i11 & 1)) + Long.MAX_VALUE;
            } else {
                return (i11 & 1) == 0 ? 1 << i11 : -1 << i11;
            }
        } else {
            long j13 = ((j11 >>> 63) & ((long) (i11 & 1))) + Long.MAX_VALUE;
            while (i11 != 0) {
                if (i11 == 1) {
                    return saturatedMultiply(j12, j11);
                }
                if ((i11 & 1) != 0) {
                    j12 = saturatedMultiply(j12, j11);
                }
                i11 >>= 1;
                if (i11 > 0) {
                    if ((-3037000499L > j11) || (j11 > FLOOR_SQRT_MAX_LONG)) {
                        return j13;
                    }
                    j11 *= j11;
                }
            }
            return j12;
        }
    }

    @Beta
    public static long saturatedSubtract(long j11, long j12) {
        long j13 = j11 - j12;
        boolean z11 = true;
        boolean z12 = (j12 ^ j11) >= 0;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        return z12 | z11 ? j13 : ((j13 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    public static long sqrt(long j11, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j11);
        if (fitsInInt(j11)) {
            return (long) IntMath.sqrt((int) j11, roundingMode);
        }
        long sqrt = (long) Math.sqrt((double) j11);
        long j12 = sqrt * sqrt;
        boolean z11 = true;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (j12 != j11) {
                    z11 = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z11);
                return sqrt;
            case 2:
            case 3:
                return j11 < j12 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j11 > j12 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                if (j11 >= j12) {
                    z11 = false;
                }
                long j13 = sqrt - (z11 ? 1 : 0);
                return j13 + ((long) lessThanBranchFree((j13 * j13) + j13, j11));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long mod(long j11, long j12) {
        if (j12 > 0) {
            long j13 = j11 % j12;
            return j13 >= 0 ? j13 : j13 + j12;
        }
        throw new ArithmeticException("Modulus must be positive");
    }
}
