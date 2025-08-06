package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
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
public final class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    @GwtCompatible
    public static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final int[] array;
        public final int end;
        public final int start;

        public IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != intArrayAsList.array[intArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i11 = 1;
            for (int i12 = this.start; i12 < this.end; i12++) {
                i11 = (i11 * 31) + Ints.hashCode(this.array[i12]);
            }
            return i11;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Integer) || (access$000 = Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Integer) || (access$100 = Ints.lastIndexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Integer> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i13 = this.start;
            return new IntArrayAsList(iArr, i11 + i13, i13 + i12);
        }

        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
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

        public IntArrayAsList(int[] iArr, int i11, int i12) {
            this.array = iArr;
            this.start = i11;
            this.end = i12;
        }

        public Integer get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Integer.valueOf(this.array[this.start + i11]);
        }

        public Integer set(int i11, Integer num) {
            Preconditions.checkElementIndex(i11, size());
            int[] iArr = this.array;
            int i12 = this.start;
            int i13 = iArr[i12 + i11];
            iArr[i12 + i11] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i13);
        }
    }

    public static final class IntConverter extends Converter<String, Integer> implements Serializable {
        public static final IntConverter INSTANCE = new IntConverter();
        private static final long serialVersionUID = 1;

        private IntConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Ints.stringConverter()";
        }

        public String doBackward(Integer num) {
            return num.toString();
        }

        public Integer doForward(String str) {
            return Integer.decode(str);
        }
    }

    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        public String toString() {
            return "Ints.lexicographicalComparator()";
        }

        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Ints.compare(iArr[i11], iArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    private Ints() {
    }

    public static List<Integer> asList(int... iArr) {
        if (iArr.length == 0) {
            return Collections.emptyList();
        }
        return new IntArrayAsList(iArr);
    }

    public static int checkedCast(long j11) {
        int i11 = (int) j11;
        Preconditions.checkArgument(((long) i11) == j11, "Out of range: %s", j11);
        return i11;
    }

    public static int compare(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 > i12 ? 1 : 0;
    }

    public static int[] concat(int[]... iArr) {
        int i11 = 0;
        for (int[] length : iArr) {
            i11 += length.length;
        }
        int[] iArr2 = new int[i11];
        int i12 = 0;
        for (int[] iArr3 : iArr) {
            System.arraycopy(iArr3, 0, iArr2, i12, iArr3.length);
            i12 += iArr3.length;
        }
        return iArr2;
    }

    @Beta
    public static int constrainToRange(int i11, int i12, int i13) {
        Preconditions.checkArgument(i12 <= i13, "min (%s) must be less than or equal to max (%s)", i12, i13);
        return Math.min(Math.max(i11, i12), i13);
    }

    public static boolean contains(int[] iArr, int i11) {
        for (int i12 : iArr) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static int[] ensureCapacity(int[] iArr, int i11, int i12) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 >= 0, "Invalid minLength: %s", i11);
        if (i12 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid padding: %s", i12);
        return iArr.length < i11 ? Arrays.copyOf(iArr, i11 + i12) : iArr;
    }

    public static int fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int fromBytes(byte b11, byte b12, byte b13, byte b14) {
        return (b11 << Ascii.CAN) | ((b12 & 255) << 16) | ((b13 & 255) << 8) | (b14 & 255);
    }

    public static int hashCode(int i11) {
        return i11;
    }

    public static int indexOf(int[] iArr, int i11) {
        return indexOf(iArr, i11, 0, iArr.length);
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(iArr.length * 5);
        sb2.append(iArr[0]);
        for (int i11 = 1; i11 < iArr.length; i11++) {
            sb2.append(str);
            sb2.append(iArr[i11]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(int[] iArr, int i11) {
        return lastIndexOf(iArr, i11, 0, iArr.length);
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i11 = iArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            if (iArr[i12] > i11) {
                i11 = iArr[i12];
            }
        }
        return i11;
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i11 = iArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            if (iArr[i12] < i11) {
                i11 = iArr[i12];
            }
        }
        return i11;
    }

    public static void reverse(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        reverse(iArr, 0, iArr.length);
    }

    public static int saturatedCast(long j11) {
        if (j11 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j11 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j11;
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    @Beta
    public static Converter<String, Integer> stringConverter() {
        return IntConverter.INSTANCE;
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = ((Number) Preconditions.checkNotNull(array[i11])).intValue();
        }
        return iArr;
    }

    public static byte[] toByteArray(int i11) {
        return new byte[]{(byte) (i11 >> 24), (byte) (i11 >> 16), (byte) (i11 >> 8), (byte) i11};
    }

    @Beta
    public static Integer tryParse(String str) {
        return tryParse(str, 10);
    }

    /* access modifiers changed from: private */
    public static int indexOf(int[] iArr, int i11, int i12, int i13) {
        while (i12 < i13) {
            if (iArr[i12] == i11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(int[] iArr, int i11, int i12, int i13) {
        for (int i14 = i13 - 1; i14 >= i12; i14--) {
            if (iArr[i14] == i11) {
                return i14;
            }
        }
        return -1;
    }

    @Beta
    public static Integer tryParse(String str, int i11) {
        Long tryParse = Longs.tryParse(str, i11);
        if (tryParse == null || tryParse.longValue() != ((long) tryParse.intValue())) {
            return null;
        }
        return Integer.valueOf(tryParse.intValue());
    }

    public static int indexOf(int[] iArr, int[] iArr2) {
        Preconditions.checkNotNull(iArr, "array");
        Preconditions.checkNotNull(iArr2, "target");
        if (iArr2.length == 0) {
            return 0;
        }
        int i11 = 0;
        while (i11 < (iArr.length - iArr2.length) + 1) {
            int i12 = 0;
            while (i12 < iArr2.length) {
                if (iArr[i11 + i12] != iArr2[i12]) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return i11;
        }
        return -1;
    }

    public static void reverse(int[] iArr, int i11, int i12) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i11, i12, iArr.length);
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            int i14 = iArr[i11];
            iArr[i11] = iArr[i13];
            iArr[i13] = i14;
            i11++;
        }
    }

    public static void sortDescending(int[] iArr, int i11, int i12) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i11, i12, iArr.length);
        Arrays.sort(iArr, i11, i12);
        reverse(iArr, i11, i12);
    }
}
