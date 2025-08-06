package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;
import sun.misc.Unsafe;

@GwtIncompatible
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    @VisibleForTesting
    public static class LexicographicalComparatorHolder {
        public static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();
        public static final String UNSAFE_COMPARATOR_NAME = (LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator");

        public enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }

            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i11 = 0; i11 < min; i11++) {
                    int compare = UnsignedBytes.compare(bArr[i11], bArr2[i11]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return bArr.length - bArr2.length;
            }
        }

        @VisibleForTesting
        public enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;
            
            public static final boolean BIG_ENDIAN = false;
            public static final int BYTE_ARRAY_BASE_OFFSET = 0;
            public static final Unsafe theUnsafe = null;

            /* access modifiers changed from: public */
            static {
                Class<byte[]> cls;
                BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
                Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                int arrayBaseOffset = unsafe.arrayBaseOffset(cls);
                BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(cls) != 1) {
                    throw new Error();
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
                return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.AnonymousClass1());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
                throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static sun.misc.Unsafe getUnsafe() {
                /*
                    sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                    return r0
                L_0x0005:
                    com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1 r0 = new com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1     // Catch:{ PrivilegedActionException -> 0x0011 }
                    r0.<init>()     // Catch:{ PrivilegedActionException -> 0x0011 }
                    java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x0011 }
                    sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x0011 }
                    return r0
                L_0x0011:
                    r0 = move-exception
                    java.lang.RuntimeException r1 = new java.lang.RuntimeException
                    java.lang.Throwable r0 = r0.getCause()
                    java.lang.String r2 = "Could not initialize intrinsics"
                    r1.<init>(r2, r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.getUnsafe():sun.misc.Unsafe");
            }

            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i11 = min & -8;
                int i12 = 0;
                while (i12 < i11) {
                    Unsafe unsafe = theUnsafe;
                    int i13 = BYTE_ARRAY_BASE_OFFSET;
                    long j11 = (long) i12;
                    long j12 = unsafe.getLong(bArr, ((long) i13) + j11);
                    long j13 = unsafe.getLong(bArr2, ((long) i13) + j11);
                    if (j12 == j13) {
                        i12 += 8;
                    } else if (BIG_ENDIAN) {
                        return UnsignedLongs.compare(j12, j13);
                    } else {
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j12 ^ j13) & -8;
                        return ((int) ((j12 >>> numberOfTrailingZeros) & 255)) - ((int) ((j13 >>> numberOfTrailingZeros) & 255));
                    }
                }
                while (i12 < min) {
                    int compare = UnsignedBytes.compare(bArr[i12], bArr2[i12]);
                    if (compare != 0) {
                        return compare;
                    }
                    i12++;
                }
                return bArr.length - bArr2.length;
            }
        }

        public static Comparator<byte[]> getBestComparator() {
            try {
                return (Comparator) Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
            } catch (Throwable unused) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }
    }

    private UnsignedBytes() {
    }

    @CanIgnoreReturnValue
    public static byte checkedCast(long j11) {
        Preconditions.checkArgument((j11 >> 8) == 0, "out of range: %s", j11);
        return (byte) ((int) j11);
    }

    public static int compare(byte b11, byte b12) {
        return toInt(b11) - toInt(b12);
    }

    private static byte flip(byte b11) {
        return (byte) (b11 ^ 128);
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * (str.length() + 3));
        sb2.append(toInt(bArr[0]));
        for (int i11 = 1; i11 < bArr.length; i11++) {
            sb2.append(str);
            sb2.append(toString(bArr[i11]));
        }
        return sb2.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    @VisibleForTesting
    public static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        int i11 = toInt(bArr[0]);
        for (int i12 = 1; i12 < bArr.length; i12++) {
            int i13 = toInt(bArr[i12]);
            if (i13 > i11) {
                i11 = i13;
            }
        }
        return (byte) i11;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        int i11 = toInt(bArr[0]);
        for (int i12 = 1; i12 < bArr.length; i12++) {
            int i13 = toInt(bArr[i12]);
            if (i13 < i11) {
                i11 = i13;
            }
        }
        return (byte) i11;
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String str) {
        return parseUnsignedByte(str, 10);
    }

    public static byte saturatedCast(long j11) {
        if (j11 > ((long) toInt((byte) -1))) {
            return -1;
        }
        if (j11 < 0) {
            return 0;
        }
        return (byte) ((int) j11);
    }

    public static void sort(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sort(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static int toInt(byte b11) {
        return b11 & 255;
    }

    @Beta
    public static String toString(byte b11) {
        return toString(b11, 10);
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String str, int i11) {
        int parseInt = Integer.parseInt((String) Preconditions.checkNotNull(str), i11);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        throw new NumberFormatException("out of range: " + parseInt);
    }

    @Beta
    public static String toString(byte b11, int i11) {
        Preconditions.checkArgument(i11 >= 2 && i11 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i11);
        return Integer.toString(toInt(b11), i11);
    }

    public static void sort(byte[] bArr, int i11, int i12) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i11, i12, bArr.length);
        for (int i13 = i11; i13 < i12; i13++) {
            bArr[i13] = flip(bArr[i13]);
        }
        Arrays.sort(bArr, i11, i12);
        while (i11 < i12) {
            bArr[i11] = flip(bArr[i11]);
            i11++;
        }
    }

    public static void sortDescending(byte[] bArr, int i11, int i12) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i11, i12, bArr.length);
        for (int i13 = i11; i13 < i12; i13++) {
            bArr[i13] = (byte) (bArr[i13] ^ Ascii.DEL);
        }
        Arrays.sort(bArr, i11, i12);
        while (i11 < i12) {
            bArr[i11] = (byte) (bArr[i11] ^ Ascii.DEL);
            i11++;
        }
    }
}
