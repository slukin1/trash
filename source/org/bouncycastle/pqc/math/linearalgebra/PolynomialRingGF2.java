package org.bouncycastle.pqc.math.linearalgebra;

import java.io.PrintStream;

public final class PolynomialRingGF2 {
    private PolynomialRingGF2() {
    }

    public static int add(int i11, int i12) {
        return i11 ^ i12;
    }

    public static int degree(int i11) {
        int i12 = -1;
        while (i11 != 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    public static int degree(long j11) {
        int i11 = 0;
        while (j11 != 0) {
            i11++;
            j11 >>>= 1;
        }
        return i11 - 1;
    }

    public static int gcd(int i11, int i12) {
        while (true) {
            int i13 = i12;
            int i14 = i11;
            i11 = i13;
            if (i11 == 0) {
                return i14;
            }
            i12 = remainder(i14, i11);
        }
    }

    public static int getIrreduciblePolynomial(int i11) {
        PrintStream printStream;
        String str;
        if (i11 < 0) {
            printStream = System.err;
            str = "The Degree is negative";
        } else if (i11 > 31) {
            printStream = System.err;
            str = "The Degree is more then 31";
        } else if (i11 == 0) {
            return 1;
        } else {
            int i12 = 1 << (i11 + 1);
            for (int i13 = (1 << i11) + 1; i13 < i12; i13 += 2) {
                if (isIrreducible(i13)) {
                    return i13;
                }
            }
            return 0;
        }
        printStream.println(str);
        return 0;
    }

    public static boolean isIrreducible(int i11) {
        if (i11 == 0) {
            return false;
        }
        int degree = degree(i11) >>> 1;
        int i12 = 2;
        for (int i13 = 0; i13 < degree; i13++) {
            i12 = modMultiply(i12, i12, i11);
            if (gcd(i12 ^ 2, i11) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int modMultiply(int i11, int i12, int i13) {
        int remainder = remainder(i11, i13);
        int remainder2 = remainder(i12, i13);
        int i14 = 0;
        if (remainder2 != 0) {
            int degree = 1 << degree(i13);
            while (remainder != 0) {
                if (((byte) (remainder & 1)) == 1) {
                    i14 ^= remainder2;
                }
                remainder >>>= 1;
                remainder2 <<= 1;
                if (remainder2 >= degree) {
                    remainder2 ^= i13;
                }
            }
        }
        return i14;
    }

    public static long multiply(int i11, int i12) {
        long j11 = 0;
        if (i12 != 0) {
            long j12 = ((long) i12) & 4294967295L;
            while (i11 != 0) {
                if (((byte) (i11 & 1)) == 1) {
                    j11 ^= j12;
                }
                i11 >>>= 1;
                j12 <<= 1;
            }
        }
        return j11;
    }

    public static int remainder(int i11, int i12) {
        if (i12 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (degree(i11) >= degree(i12)) {
            i11 ^= i12 << (degree(i11) - degree(i12));
        }
        return i11;
    }

    public static int rest(long j11, int i11) {
        if (i11 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        long j12 = ((long) i11) & 4294967295L;
        while ((j11 >>> 32) != 0) {
            j11 ^= j12 << (degree(j11) - degree(j12));
        }
        int i12 = (int) (j11 & -1);
        while (degree(i12) >= degree(i11)) {
            i12 ^= i11 << (degree(i12) - degree(i11));
        }
        return i12;
    }
}
