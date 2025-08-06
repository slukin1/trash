package com.google.common.math;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.huawei.hms.framework.common.ExceptionCode;
import com.jumio.analytics.MobileEvents;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;
import java.math.RoundingMode;

@GwtCompatible(emulated = true)
public final class IntMath {
    @VisibleForTesting
    public static final int FLOOR_SQRT_MAX_INT = 46340;
    @VisibleForTesting
    public static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    @VisibleForTesting
    public static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;
    @VisibleForTesting
    public static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, ImagePickerDelegate.REQUEST_CAMERA_IMAGE_PERMISSION, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    @VisibleForTesting
    public static final int[] halfPowersOf10 = {3, 31, MobileEvents.EVENTTYPE_REPORTING, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    @VisibleForTesting
    public static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    @VisibleForTesting
    public static final int[] powersOf10 = {1, 10, 100, 1000, 10000, AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, 1000000, ExceptionCode.CRASH_EXCEPTION, 100000000, 1000000000};

    /* renamed from: com.google.common.math.IntMath$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.AnonymousClass1.<clinit>():void");
        }
    }

    private IntMath() {
    }

    public static int binomial(int i11, int i12) {
        MathPreconditions.checkNonNegative(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, i11);
        MathPreconditions.checkNonNegative("k", i12);
        int i13 = 0;
        Preconditions.checkArgument(i12 <= i11, "k (%s) > n (%s)", i12, i11);
        if (i12 > (i11 >> 1)) {
            i12 = i11 - i12;
        }
        int[] iArr = biggestBinomials;
        if (i12 >= iArr.length || i11 > iArr[i12]) {
            return Integer.MAX_VALUE;
        }
        if (i12 == 0) {
            return 1;
        }
        if (i12 == 1) {
            return i11;
        }
        long j11 = 1;
        while (i13 < i12) {
            i13++;
            j11 = (j11 * ((long) (i11 - i13))) / ((long) i13);
        }
        return (int) j11;
    }

    @Beta
    public static int ceilingPowerOfTwo(int i11) {
        MathPreconditions.checkPositive("x", i11);
        if (i11 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i11 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i11 + ") not representable as an int");
    }

    public static int checkedAdd(int i11, int i12) {
        long j11 = ((long) i11) + ((long) i12);
        int i13 = (int) j11;
        MathPreconditions.checkNoOverflow(j11 == ((long) i13), "checkedAdd", i11, i12);
        return i13;
    }

    public static int checkedMultiply(int i11, int i12) {
        long j11 = ((long) i11) * ((long) i12);
        int i13 = (int) j11;
        MathPreconditions.checkNoOverflow(j11 == ((long) i13), "checkedMultiply", i11, i12);
        return i13;
    }

    public static int checkedPow(int i11, int i12) {
        MathPreconditions.checkNonNegative("exponent", i12);
        boolean z11 = false;
        if (i11 == -2) {
            if (i12 < 32) {
                z11 = true;
            }
            MathPreconditions.checkNoOverflow(z11, "checkedPow", i11, i12);
            return (i12 & 1) == 0 ? 1 << i12 : -1 << i12;
        } else if (i11 != -1) {
            if (i11 != 0) {
                if (i11 == 1) {
                    return 1;
                }
                if (i11 != 2) {
                    int i13 = 1;
                    while (i12 != 0) {
                        if (i12 == 1) {
                            return checkedMultiply(i13, i11);
                        }
                        if ((i12 & 1) != 0) {
                            i13 = checkedMultiply(i13, i11);
                        }
                        i12 >>= 1;
                        if (i12 > 0) {
                            MathPreconditions.checkNoOverflow((-46340 <= i11) & (i11 <= 46340), "checkedPow", i11, i12);
                            i11 *= i11;
                        }
                    }
                    return i13;
                }
                if (i12 < 31) {
                    z11 = true;
                }
                MathPreconditions.checkNoOverflow(z11, "checkedPow", i11, i12);
                return 1 << i12;
            } else if (i12 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if ((i12 & 1) == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int checkedSubtract(int i11, int i12) {
        long j11 = ((long) i11) - ((long) i12);
        int i13 = (int) j11;
        MathPreconditions.checkNoOverflow(j11 == ((long) i13), "checkedSubtract", i11, i12);
        return i13;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r5 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        if (r5 < 0) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int divide(int r5, int r6, java.math.RoundingMode r7) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r7)
            if (r6 == 0) goto L_0x005c
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.common.math.IntMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0057;
                case 3: goto L_0x004d;
                case 4: goto L_0x0058;
                case 5: goto L_0x004a;
                case 6: goto L_0x0025;
                case 7: goto L_0x0025;
                case 8: goto L_0x0025;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L_0x0025:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L_0x0047
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L_0x0058
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L_0x003b
            r6 = r2
            goto L_0x003c
        L_0x003b:
            r6 = r4
        L_0x003c:
            r7 = r0 & 1
            if (r7 == 0) goto L_0x0042
            r7 = r2
            goto L_0x0043
        L_0x0042:
            r7 = r4
        L_0x0043:
            r6 = r6 & r7
            if (r6 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0047:
            if (r1 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004a:
            if (r5 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004d:
            if (r5 >= 0) goto L_0x0057
            goto L_0x0058
        L_0x0050:
            if (r1 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r4
        L_0x0054:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r2)
        L_0x0057:
            r2 = r4
        L_0x0058:
            if (r2 == 0) goto L_0x005b
            int r0 = r0 + r5
        L_0x005b:
            return r0
        L_0x005c:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.divide(int, int, java.math.RoundingMode):int");
    }

    public static int factorial(int i11) {
        MathPreconditions.checkNonNegative(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, i11);
        int[] iArr = factorials;
        if (i11 < iArr.length) {
            return iArr[i11];
        }
        return Integer.MAX_VALUE;
    }

    @Beta
    public static int floorPowerOfTwo(int i11) {
        MathPreconditions.checkPositive("x", i11);
        return Integer.highestOneBit(i11);
    }

    public static int gcd(int i11, int i12) {
        MathPreconditions.checkNonNegative("a", i11);
        MathPreconditions.checkNonNegative("b", i12);
        if (i11 == 0) {
            return i12;
        }
        if (i12 == 0) {
            return i11;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i11);
        int i13 = i11 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i12);
        int i14 = i12 >> numberOfTrailingZeros2;
        while (i13 != i14) {
            int i15 = i13 - i14;
            int i16 = (i15 >> 31) & i15;
            int i17 = (i15 - i16) - i16;
            i14 += i16;
            i13 = i17 >> Integer.numberOfTrailingZeros(i17);
        }
        return i13 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(int i11) {
        boolean z11 = false;
        boolean z12 = i11 > 0;
        if ((i11 & (i11 - 1)) == 0) {
            z11 = true;
        }
        return z12 & z11;
    }

    @GwtIncompatible
    @Beta
    public static boolean isPrime(int i11) {
        return LongMath.isPrime((long) i11);
    }

    @VisibleForTesting
    public static int lessThanBranchFree(int i11, int i12) {
        return (~(~(i11 - i12))) >>> 31;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r0 + r3;
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int log10(int r3, java.math.RoundingMode r4) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.checkPositive((java.lang.String) r0, (int) r3)
            int r0 = log10Floor(r3)
            int[] r1 = powersOf10
            r1 = r1[r0]
            int[] r2 = com.google.common.math.IntMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r4 = r4.ordinal()
            r4 = r2[r4]
            switch(r4) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0035;
                case 3: goto L_0x0035;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x001e;
                case 7: goto L_0x001e;
                case 8: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            r3.<init>()
            throw r3
        L_0x001e:
            int[] r4 = halfPowersOf10
            r4 = r4[r0]
            int r3 = lessThanBranchFree(r4, r3)
        L_0x0026:
            int r0 = r0 + r3
            return r0
        L_0x0028:
            int r3 = lessThanBranchFree(r1, r3)
            goto L_0x0026
        L_0x002d:
            if (r3 != r1) goto L_0x0031
            r3 = 1
            goto L_0x0032
        L_0x0031:
            r3 = 0
        L_0x0032:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r3)
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.log10(int, java.math.RoundingMode):int");
    }

    private static int log10Floor(int i11) {
        byte b11 = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i11)];
        return b11 - lessThanBranchFree(i11, powersOf10[b11]);
    }

    public static int log2(int i11, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", i11);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(i11));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i11 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i11);
                return (31 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, i11);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i11);
    }

    public static int mean(int i11, int i12) {
        return (i11 & i12) + ((i11 ^ i12) >> 1);
    }

    public static int mod(int i11, int i12) {
        if (i12 > 0) {
            int i13 = i11 % i12;
            return i13 >= 0 ? i13 : i13 + i12;
        }
        throw new ArithmeticException("Modulus " + i12 + " must be > 0");
    }

    @GwtIncompatible
    public static int pow(int i11, int i12) {
        MathPreconditions.checkNonNegative("exponent", i12);
        if (i11 != -2) {
            if (i11 == -1) {
                return (i12 & 1) == 0 ? 1 : -1;
            }
            if (i11 == 0) {
                return i12 == 0 ? 1 : 0;
            }
            if (i11 == 1) {
                return 1;
            }
            if (i11 != 2) {
                int i13 = 1;
                while (i12 != 0) {
                    if (i12 == 1) {
                        return i11 * i13;
                    }
                    i13 *= (i12 & 1) == 0 ? 1 : i11;
                    i11 *= i11;
                    i12 >>= 1;
                }
                return i13;
            } else if (i12 < 32) {
                return 1 << i12;
            } else {
                return 0;
            }
        } else if (i12 < 32) {
            return (i12 & 1) == 0 ? 1 << i12 : -(1 << i12);
        } else {
            return 0;
        }
    }

    @Beta
    public static int saturatedAdd(int i11, int i12) {
        return Ints.saturatedCast(((long) i11) + ((long) i12));
    }

    @Beta
    public static int saturatedMultiply(int i11, int i12) {
        return Ints.saturatedCast(((long) i11) * ((long) i12));
    }

    @Beta
    public static int saturatedPow(int i11, int i12) {
        MathPreconditions.checkNonNegative("exponent", i12);
        if (i11 != -2) {
            if (i11 != -1) {
                if (i11 != 0) {
                    if (i11 == 1) {
                        return 1;
                    }
                    if (i11 != 2) {
                        int i13 = ((i11 >>> 31) & i12 & 1) + Integer.MAX_VALUE;
                        int i14 = 1;
                        while (i12 != 0) {
                            if (i12 == 1) {
                                return saturatedMultiply(i14, i11);
                            }
                            if ((i12 & 1) != 0) {
                                i14 = saturatedMultiply(i14, i11);
                            }
                            i12 >>= 1;
                            if (i12 > 0) {
                                if ((-46340 > i11) || (i11 > 46340)) {
                                    return i13;
                                }
                                i11 *= i11;
                            }
                        }
                        return i14;
                    } else if (i12 >= 31) {
                        return Integer.MAX_VALUE;
                    } else {
                        return 1 << i12;
                    }
                } else if (i12 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i12 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i12 >= 32) {
            return (i12 & 1) + Integer.MAX_VALUE;
        } else {
            return (i12 & 1) == 0 ? 1 << i12 : -1 << i12;
        }
    }

    @Beta
    public static int saturatedSubtract(int i11, int i12) {
        return Ints.saturatedCast(((long) i11) - ((long) i12));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        return r0 + r2;
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int sqrt(int r2, java.math.RoundingMode r3) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.checkNonNegative((java.lang.String) r0, (int) r2)
            int r0 = sqrtFloor(r2)
            int[] r1 = com.google.common.math.IntMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r3 = r3.ordinal()
            r3 = r1[r3]
            switch(r3) {
                case 1: goto L_0x002a;
                case 2: goto L_0x0034;
                case 3: goto L_0x0034;
                case 4: goto L_0x0023;
                case 5: goto L_0x0023;
                case 6: goto L_0x001a;
                case 7: goto L_0x001a;
                case 8: goto L_0x001a;
                default: goto L_0x0014;
            }
        L_0x0014:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x001a:
            int r3 = r0 * r0
            int r3 = r3 + r0
            int r2 = lessThanBranchFree(r3, r2)
        L_0x0021:
            int r0 = r0 + r2
            return r0
        L_0x0023:
            int r3 = r0 * r0
            int r2 = lessThanBranchFree(r3, r2)
            goto L_0x0021
        L_0x002a:
            int r3 = r0 * r0
            if (r3 != r2) goto L_0x0030
            r2 = 1
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r2)
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.sqrt(int, java.math.RoundingMode):int");
    }

    private static int sqrtFloor(int i11) {
        return (int) Math.sqrt((double) i11);
    }
}
