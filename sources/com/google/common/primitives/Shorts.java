package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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

@GwtCompatible(emulated = true)
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    public enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        public int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Shorts.compare(sArr[i11], sArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return sArr.length - sArr2.length;
        }
    }

    @GwtCompatible
    public static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final short[] array;
        public final int end;
        public final int start;

        public ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Short) && Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != shortArrayAsList.array[shortArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i11 = 1;
            for (int i12 = this.start; i12 < this.end; i12++) {
                i11 = (i11 * 31) + Shorts.hashCode(this.array[i12]);
            }
            return i11;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Short) || (access$000 = Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Short) || (access$100 = Shorts.lastIndexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Short> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i13 = this.start;
            return new ShortArrayAsList(sArr, i11 + i13, i13 + i12);
        }

        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 6);
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

        public ShortArrayAsList(short[] sArr, int i11, int i12) {
            this.array = sArr;
            this.start = i11;
            this.end = i12;
        }

        public Short get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Short.valueOf(this.array[this.start + i11]);
        }

        public Short set(int i11, Short sh2) {
            Preconditions.checkElementIndex(i11, size());
            short[] sArr = this.array;
            int i12 = this.start;
            short s11 = sArr[i12 + i11];
            sArr[i12 + i11] = ((Short) Preconditions.checkNotNull(sh2)).shortValue();
            return Short.valueOf(s11);
        }
    }

    public static final class ShortConverter extends Converter<String, Short> implements Serializable {
        public static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        public String doBackward(Short sh2) {
            return sh2.toString();
        }

        public Short doForward(String str) {
            return Short.decode(str);
        }
    }

    private Shorts() {
    }

    public static List<Short> asList(short... sArr) {
        if (sArr.length == 0) {
            return Collections.emptyList();
        }
        return new ShortArrayAsList(sArr);
    }

    public static short checkedCast(long j11) {
        short s11 = (short) ((int) j11);
        Preconditions.checkArgument(((long) s11) == j11, "Out of range: %s", j11);
        return s11;
    }

    public static int compare(short s11, short s12) {
        return s11 - s12;
    }

    public static short[] concat(short[]... sArr) {
        int i11 = 0;
        for (short[] length : sArr) {
            i11 += length.length;
        }
        short[] sArr2 = new short[i11];
        int i12 = 0;
        for (short[] sArr3 : sArr) {
            System.arraycopy(sArr3, 0, sArr2, i12, sArr3.length);
            i12 += sArr3.length;
        }
        return sArr2;
    }

    @Beta
    public static short constrainToRange(short s11, short s12, short s13) {
        Preconditions.checkArgument(s12 <= s13, "min (%s) must be less than or equal to max (%s)", (int) s12, (int) s13);
        if (s11 < s12) {
            return s12;
        }
        return s11 < s13 ? s11 : s13;
    }

    public static boolean contains(short[] sArr, short s11) {
        for (short s12 : sArr) {
            if (s12 == s11) {
                return true;
            }
        }
        return false;
    }

    public static short[] ensureCapacity(short[] sArr, int i11, int i12) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 >= 0, "Invalid minLength: %s", i11);
        if (i12 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid padding: %s", i12);
        return sArr.length < i11 ? Arrays.copyOf(sArr, i11 + i12) : sArr;
    }

    @GwtIncompatible
    public static short fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static short fromBytes(byte b11, byte b12) {
        return (short) ((b11 << 8) | (b12 & 255));
    }

    public static int hashCode(short s11) {
        return s11;
    }

    public static int indexOf(short[] sArr, short s11) {
        return indexOf(sArr, s11, 0, sArr.length);
    }

    public static String join(String str, short... sArr) {
        Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(sArr.length * 6);
        sb2.append(sArr[0]);
        for (int i11 = 1; i11 < sArr.length; i11++) {
            sb2.append(str);
            sb2.append(sArr[i11]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(short[] sArr, short s11) {
        return lastIndexOf(sArr, s11, 0, sArr.length);
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static short max(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s11 = sArr[0];
        for (int i11 = 1; i11 < sArr.length; i11++) {
            if (sArr[i11] > s11) {
                s11 = sArr[i11];
            }
        }
        return s11;
    }

    public static short min(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s11 = sArr[0];
        for (int i11 = 1; i11 < sArr.length; i11++) {
            if (sArr[i11] < s11) {
                s11 = sArr[i11];
            }
        }
        return s11;
    }

    public static void reverse(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static short saturatedCast(long j11) {
        if (j11 > 32767) {
            return Short.MAX_VALUE;
        }
        if (j11 < -32768) {
            return Short.MIN_VALUE;
        }
        return (short) ((int) j11);
    }

    public static void sortDescending(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    @Beta
    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i11 = 0; i11 < length; i11++) {
            sArr[i11] = ((Number) Preconditions.checkNotNull(array[i11])).shortValue();
        }
        return sArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(short s11) {
        return new byte[]{(byte) (s11 >> 8), (byte) s11};
    }

    /* access modifiers changed from: private */
    public static int indexOf(short[] sArr, short s11, int i11, int i12) {
        while (i11 < i12) {
            if (sArr[i11] == s11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(short[] sArr, short s11, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (sArr[i13] == s11) {
                return i13;
            }
        }
        return -1;
    }

    public static int indexOf(short[] sArr, short[] sArr2) {
        Preconditions.checkNotNull(sArr, "array");
        Preconditions.checkNotNull(sArr2, "target");
        if (sArr2.length == 0) {
            return 0;
        }
        int i11 = 0;
        while (i11 < (sArr.length - sArr2.length) + 1) {
            int i12 = 0;
            while (i12 < sArr2.length) {
                if (sArr[i11 + i12] != sArr2[i12]) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return i11;
        }
        return -1;
    }

    public static void reverse(short[] sArr, int i11, int i12) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i11, i12, sArr.length);
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            short s11 = sArr[i11];
            sArr[i11] = sArr[i13];
            sArr[i13] = s11;
            i11++;
        }
    }

    public static void sortDescending(short[] sArr, int i11, int i12) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i11, i12, sArr.length);
        Arrays.sort(sArr, i11, i12);
        reverse(sArr, i11, i12);
    }
}
