package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    public static final class AsciiDigits {
        private static final byte[] asciiDigits;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i11 = 0; i11 <= 9; i11++) {
                bArr[i11 + 48] = (byte) i11;
            }
            for (int i12 = 0; i12 <= 26; i12++) {
                byte b11 = (byte) (i12 + 10);
                bArr[i12 + 65] = b11;
                bArr[i12 + 97] = b11;
            }
            asciiDigits = bArr;
        }

        private AsciiDigits() {
        }

        public static int digit(char c11) {
            if (c11 < 128) {
                return asciiDigits[c11];
            }
            return -1;
        }
    }

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public String toString() {
            return "Longs.lexicographicalComparator()";
        }

        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Longs.compare(jArr[i11], jArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    @GwtCompatible
    public static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final long[] array;
        public final int end;
        public final int start;

        public LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Long) && Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != longArrayAsList.array[longArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i11 = 1;
            for (int i12 = this.start; i12 < this.end; i12++) {
                i11 = (i11 * 31) + Longs.hashCode(this.array[i12]);
            }
            return i11;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Long) || (access$000 = Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Long) || (access$100 = Longs.lastIndexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Long> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            long[] jArr = this.array;
            int i13 = this.start;
            return new LongArrayAsList(jArr, i11 + i13, i13 + i12);
        }

        public long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 10);
            sb2.append('[');
            sb2.append(this.array[this.start]);
            int i11 = this.start;
            while (true) {
                i11++;
                if (i11 < this.end) {
                    sb2.append(", ");
                    sb2.append(this.array[i11]);
                } else {
                    sb2.append(']');
                    return sb2.toString();
                }
            }
        }

        public LongArrayAsList(long[] jArr, int i11, int i12) {
            this.array = jArr;
            this.start = i11;
            this.end = i12;
        }

        public Long get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Long.valueOf(this.array[this.start + i11]);
        }

        public Long set(int i11, Long l11) {
            Preconditions.checkElementIndex(i11, size());
            long[] jArr = this.array;
            int i12 = this.start;
            long j11 = jArr[i12 + i11];
            jArr[i12 + i11] = ((Long) Preconditions.checkNotNull(l11)).longValue();
            return Long.valueOf(j11);
        }
    }

    public static final class LongConverter extends Converter<String, Long> implements Serializable {
        public static final LongConverter INSTANCE = new LongConverter();
        private static final long serialVersionUID = 1;

        private LongConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Longs.stringConverter()";
        }

        public String doBackward(Long l11) {
            return l11.toString();
        }

        public Long doForward(String str) {
            return Long.decode(str);
        }
    }

    private Longs() {
    }

    public static List<Long> asList(long... jArr) {
        if (jArr.length == 0) {
            return Collections.emptyList();
        }
        return new LongArrayAsList(jArr);
    }

    public static int compare(long j11, long j12) {
        int i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 > 0 ? 1 : 0;
    }

    public static long[] concat(long[]... jArr) {
        int i11 = 0;
        for (long[] length : jArr) {
            i11 += length.length;
        }
        long[] jArr2 = new long[i11];
        int i12 = 0;
        for (long[] jArr3 : jArr) {
            System.arraycopy(jArr3, 0, jArr2, i12, jArr3.length);
            i12 += jArr3.length;
        }
        return jArr2;
    }

    @Beta
    public static long constrainToRange(long j11, long j12, long j13) {
        Preconditions.checkArgument(j12 <= j13, "min (%s) must be less than or equal to max (%s)", j12, j13);
        return Math.min(Math.max(j11, j12), j13);
    }

    public static boolean contains(long[] jArr, long j11) {
        for (long j12 : jArr) {
            if (j12 == j11) {
                return true;
            }
        }
        return false;
    }

    public static long[] ensureCapacity(long[] jArr, int i11, int i12) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 >= 0, "Invalid minLength: %s", i11);
        if (i12 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid padding: %s", i12);
        return jArr.length < i11 ? Arrays.copyOf(jArr, i11 + i12) : jArr;
    }

    public static long fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b11, byte b12, byte b13, byte b14, byte b15, byte b16, byte b17, byte b18) {
        return ((((long) b12) & 255) << 48) | ((((long) b11) & 255) << 56) | ((((long) b13) & 255) << 40) | ((((long) b14) & 255) << 32) | ((((long) b15) & 255) << 24) | ((((long) b16) & 255) << 16) | ((((long) b17) & 255) << 8) | (((long) b18) & 255);
    }

    public static int hashCode(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static int indexOf(long[] jArr, long j11) {
        return indexOf(jArr, j11, 0, jArr.length);
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(jArr.length * 10);
        sb2.append(jArr[0]);
        for (int i11 = 1; i11 < jArr.length; i11++) {
            sb2.append(str);
            sb2.append(jArr[i11]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(long[] jArr, long j11) {
        return lastIndexOf(jArr, j11, 0, jArr.length);
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j11 = jArr[0];
        for (int i11 = 1; i11 < jArr.length; i11++) {
            if (jArr[i11] > j11) {
                j11 = jArr[i11];
            }
        }
        return j11;
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j11 = jArr[0];
        for (int i11 = 1; i11 < jArr.length; i11++) {
            if (jArr[i11] < j11) {
                j11 = jArr[i11];
            }
        }
        return j11;
    }

    public static void reverse(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    @Beta
    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i11 = 0; i11 < length; i11++) {
            jArr[i11] = ((Number) Preconditions.checkNotNull(array[i11])).longValue();
        }
        return jArr;
    }

    public static byte[] toByteArray(long j11) {
        byte[] bArr = new byte[8];
        for (int i11 = 7; i11 >= 0; i11--) {
            bArr[i11] = (byte) ((int) (255 & j11));
            j11 >>= 8;
        }
        return bArr;
    }

    @Beta
    public static Long tryParse(String str) {
        return tryParse(str, 10);
    }

    /* access modifiers changed from: private */
    public static int indexOf(long[] jArr, long j11, int i11, int i12) {
        while (i11 < i12) {
            if (jArr[i11] == j11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(long[] jArr, long j11, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (jArr[i13] == j11) {
                return i13;
            }
        }
        return -1;
    }

    @Beta
    public static Long tryParse(String str, int i11) {
        String str2 = str;
        int i12 = i11;
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i12 < 2 || i12 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i12);
        }
        int i13 = 0;
        if (str2.charAt(0) == '-') {
            i13 = 1;
        }
        if (i13 == str.length()) {
            return null;
        }
        int i14 = i13 + 1;
        int digit = AsciiDigits.digit(str2.charAt(i13));
        if (digit < 0 || digit >= i12) {
            return null;
        }
        long j11 = (long) (-digit);
        long j12 = (long) i12;
        long j13 = Long.MIN_VALUE / j12;
        while (i14 < str.length()) {
            int i15 = i14 + 1;
            int digit2 = AsciiDigits.digit(str2.charAt(i14));
            if (digit2 < 0 || digit2 >= i12 || j11 < j13) {
                return null;
            }
            long j14 = j11 * j12;
            long j15 = (long) digit2;
            if (j14 < j15 - Long.MIN_VALUE) {
                return null;
            }
            j11 = j14 - j15;
            i14 = i15;
        }
        if (i13 != 0) {
            return Long.valueOf(j11);
        }
        if (j11 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j11);
    }

    public static int indexOf(long[] jArr, long[] jArr2) {
        Preconditions.checkNotNull(jArr, "array");
        Preconditions.checkNotNull(jArr2, "target");
        if (jArr2.length == 0) {
            return 0;
        }
        int i11 = 0;
        while (i11 < (jArr.length - jArr2.length) + 1) {
            int i12 = 0;
            while (i12 < jArr2.length) {
                if (jArr[i11 + i12] != jArr2[i12]) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return i11;
        }
        return -1;
    }

    public static void reverse(long[] jArr, int i11, int i12) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i11, i12, jArr.length);
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            long j11 = jArr[i11];
            jArr[i11] = jArr[i13];
            jArr[i13] = j11;
            i11++;
        }
    }

    public static void sortDescending(long[] jArr, int i11, int i12) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i11, i12, jArr.length);
        Arrays.sort(jArr, i11, i12);
        reverse(jArr, i11, i12);
    }
}
