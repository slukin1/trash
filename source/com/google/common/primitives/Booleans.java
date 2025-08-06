package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
public final class Booleans {

    @GwtCompatible
    public static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final boolean[] array;
        public final int end;
        public final int start;

        public BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Boolean) && Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) != -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != booleanArrayAsList.array[booleanArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i11 = 1;
            for (int i12 = this.start; i12 < this.end; i12++) {
                i11 = (i11 * 31) + Booleans.hashCode(this.array[i12]);
            }
            return i11;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Boolean) || (access$000 = Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Boolean) || (access$100 = Booleans.lastIndexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Boolean> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.array;
            int i13 = this.start;
            return new BooleanArrayAsList(zArr, i11 + i13, i13 + i12);
        }

        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 7);
            sb2.append(this.array[this.start] ? "[true" : "[false");
            int i11 = this.start;
            while (true) {
                i11++;
                if (i11 < this.end) {
                    sb2.append(this.array[i11] ? ", true" : ", false");
                } else {
                    sb2.append(']');
                    return sb2.toString();
                }
            }
        }

        public BooleanArrayAsList(boolean[] zArr, int i11, int i12) {
            this.array = zArr;
            this.start = i11;
            this.end = i12;
        }

        public Boolean get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Boolean.valueOf(this.array[this.start + i11]);
        }

        public Boolean set(int i11, Boolean bool) {
            Preconditions.checkElementIndex(i11, size());
            boolean[] zArr = this.array;
            int i12 = this.start;
            boolean z11 = zArr[i12 + i11];
            zArr[i12 + i11] = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
            return Boolean.valueOf(z11);
        }
    }

    public enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");
        
        private final String toString;
        private final int trueValue;

        private BooleanComparator(int i11, String str) {
            this.trueValue = i11;
            this.toString = str;
        }

        public String toString() {
            return this.toString;
        }

        public int compare(Boolean bool, Boolean bool2) {
            int i11 = 0;
            int i12 = bool.booleanValue() ? this.trueValue : 0;
            if (bool2.booleanValue()) {
                i11 = this.trueValue;
            }
            return i11 - i12;
        }
    }

    public enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }

        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Booleans.compare(zArr[i11], zArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return zArr.length - zArr2.length;
        }
    }

    private Booleans() {
    }

    public static List<Boolean> asList(boolean... zArr) {
        if (zArr.length == 0) {
            return Collections.emptyList();
        }
        return new BooleanArrayAsList(zArr);
    }

    public static int compare(boolean z11, boolean z12) {
        if (z11 == z12) {
            return 0;
        }
        return z11 ? 1 : -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i11 = 0;
        for (boolean[] length : zArr) {
            i11 += length.length;
        }
        boolean[] zArr2 = new boolean[i11];
        int i12 = 0;
        for (boolean[] zArr3 : zArr) {
            System.arraycopy(zArr3, 0, zArr2, i12, zArr3.length);
            i12 += zArr3.length;
        }
        return zArr2;
    }

    public static boolean contains(boolean[] zArr, boolean z11) {
        for (boolean z12 : zArr) {
            if (z12 == z11) {
                return true;
            }
        }
        return false;
    }

    @Beta
    public static int countTrue(boolean... zArr) {
        int i11 = 0;
        for (boolean z11 : zArr) {
            if (z11) {
                i11++;
            }
        }
        return i11;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i11, int i12) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 >= 0, "Invalid minLength: %s", i11);
        if (i12 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid padding: %s", i12);
        return zArr.length < i11 ? Arrays.copyOf(zArr, i11 + i12) : zArr;
    }

    @Beta
    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int indexOf(boolean[] zArr, boolean z11) {
        return indexOf(zArr, z11, 0, zArr.length);
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(zArr.length * 7);
        sb2.append(zArr[0]);
        for (int i11 = 1; i11 < zArr.length; i11++) {
            sb2.append(str);
            sb2.append(zArr[i11]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(boolean[] zArr, boolean z11) {
        return lastIndexOf(zArr, z11, 0, zArr.length);
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).toBooleanArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            zArr[i11] = ((Boolean) Preconditions.checkNotNull(array[i11])).booleanValue();
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    /* access modifiers changed from: private */
    public static int indexOf(boolean[] zArr, boolean z11, int i11, int i12) {
        while (i11 < i12) {
            if (zArr[i11] == z11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(boolean[] zArr, boolean z11, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (zArr[i13] == z11) {
                return i13;
            }
        }
        return -1;
    }

    public static int indexOf(boolean[] zArr, boolean[] zArr2) {
        Preconditions.checkNotNull(zArr, "array");
        Preconditions.checkNotNull(zArr2, "target");
        if (zArr2.length == 0) {
            return 0;
        }
        int i11 = 0;
        while (i11 < (zArr.length - zArr2.length) + 1) {
            int i12 = 0;
            while (i12 < zArr2.length) {
                if (zArr[i11 + i12] != zArr2[i12]) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return i11;
        }
        return -1;
    }

    public static void reverse(boolean[] zArr, int i11, int i12) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i11, i12, zArr.length);
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            boolean z11 = zArr[i11];
            zArr[i11] = zArr[i13];
            zArr[i13] = z11;
            i11++;
        }
    }
}
