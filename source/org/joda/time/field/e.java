package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

public class e {
    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static int b(int i11, int i12, int i13) {
        if (i12 < i13) {
            int i14 = (i13 - i12) + 1;
            int i15 = i11 - i12;
            if (i15 >= 0) {
                return (i15 % i14) + i12;
            }
            int i16 = (-i15) % i14;
            return i16 == 0 ? i12 + 0 : (i14 - i16) + i12;
        }
        throw new IllegalArgumentException("MIN > MAX");
    }

    public static int c(int i11, int i12, int i13, int i14) {
        return b(i11 + i12, i13, i14);
    }

    public static int d(int i11, int i12) {
        int i13 = i11 + i12;
        if ((i11 ^ i13) >= 0 || (i11 ^ i12) < 0) {
            return i13;
        }
        throw new ArithmeticException("The calculation caused an overflow: " + i11 + " + " + i12);
    }

    public static long e(long j11, long j12) {
        long j13 = j11 + j12;
        if ((j11 ^ j13) >= 0 || (j11 ^ j12) < 0) {
            return j13;
        }
        throw new ArithmeticException("The calculation caused an overflow: " + j11 + " + " + j12);
    }

    public static long f(long j11, long j12) {
        if (j11 != Long.MIN_VALUE || j12 != -1) {
            return j11 / j12;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j11 + " / " + j12);
    }

    public static int g(int i11, int i12) {
        long j11 = ((long) i11) * ((long) i12);
        if (j11 >= -2147483648L && j11 <= 2147483647L) {
            return (int) j11;
        }
        throw new ArithmeticException("Multiplication overflows an int: " + i11 + " * " + i12);
    }

    public static long h(long j11, int i11) {
        if (i11 != -1) {
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 1) {
                return j11;
            }
            long j12 = (long) i11;
            long j13 = j11 * j12;
            if (j13 / j12 == j11) {
                return j13;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j11 + " * " + i11);
        } else if (j11 != Long.MIN_VALUE) {
            return -j11;
        } else {
            throw new ArithmeticException("Multiplication overflows a long: " + j11 + " * " + i11);
        }
    }

    public static long i(long j11, long j12) {
        if (j12 == 1) {
            return j11;
        }
        if (j11 == 1) {
            return j12;
        }
        if (j11 == 0 || j12 == 0) {
            return 0;
        }
        long j13 = j11 * j12;
        if (j13 / j12 == j11 && ((j11 != Long.MIN_VALUE || j12 != -1) && (j12 != Long.MIN_VALUE || j11 != -1))) {
            return j13;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j11 + " * " + j12);
    }

    public static int j(int i11) {
        if (i11 != Integer.MIN_VALUE) {
            return -i11;
        }
        throw new ArithmeticException("Integer.MIN_VALUE cannot be negated");
    }

    public static long k(long j11, long j12) {
        long j13 = j11 - j12;
        if ((j11 ^ j13) >= 0 || (j11 ^ j12) >= 0) {
            return j13;
        }
        throw new ArithmeticException("The calculation caused an overflow: " + j11 + " - " + j12);
    }

    public static int l(long j11) {
        if (-2147483648L <= j11 && j11 <= 2147483647L) {
            return (int) j11;
        }
        throw new ArithmeticException("Value cannot fit in an int: " + j11);
    }

    public static void m(DateTimeField dateTimeField, int i11, int i12, int i13) {
        if (i11 < i12 || i11 > i13) {
            throw new IllegalFieldValueException(dateTimeField.getType(), (Number) Integer.valueOf(i11), (Number) Integer.valueOf(i12), (Number) Integer.valueOf(i13));
        }
    }

    public static void n(DateTimeFieldType dateTimeFieldType, int i11, int i12, int i13) {
        if (i11 < i12 || i11 > i13) {
            throw new IllegalFieldValueException(dateTimeFieldType, (Number) Integer.valueOf(i11), (Number) Integer.valueOf(i12), (Number) Integer.valueOf(i13));
        }
    }
}
