package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import okhttp3.HttpUrl;

@GwtCompatible
@Immutable
@Beta
public final class ImmutableDoubleArray implements Serializable {
    /* access modifiers changed from: private */
    public static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    /* access modifiers changed from: private */
    public final double[] array;
    private final int end;
    /* access modifiers changed from: private */
    public final transient int start;

    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int access$100 = this.parent.start;
            for (Object next : list) {
                if (next instanceof Double) {
                    int i11 = access$100 + 1;
                    if (ImmutableDoubleArray.areEqual(this.parent.array[access$100], ((Double) next).doubleValue())) {
                        access$100 = i11;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.parent.hashCode();
        }

        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        public int size() {
            return this.parent.length();
        }

        public List<Double> subList(int i11, int i12) {
            return this.parent.subArray(i11, i12).asList();
        }

        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }

        public Double get(int i11) {
            return Double.valueOf(this.parent.get(i11));
        }
    }

    /* access modifiers changed from: private */
    public static boolean areEqual(double d11, double d12) {
        return Double.doubleToLongBits(d11) == Double.doubleToLongBits(d12);
    }

    public static Builder builder(int i11) {
        Preconditions.checkArgument(i11 >= 0, "Invalid initialCapacity: %s", i11);
        return new Builder(i11);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        if (dArr.length == 0) {
            return EMPTY;
        }
        return new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public List<Double> asList() {
        return new AsList();
    }

    public boolean contains(double d11) {
        return indexOf(d11) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length(); i11++) {
            if (!areEqual(get(i11), immutableDoubleArray.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public double get(int i11) {
        Preconditions.checkElementIndex(i11, length());
        return this.array[this.start + i11];
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = this.start; i12 < this.end; i12++) {
            i11 = (i11 * 31) + Doubles.hashCode(this.array[i12]);
        }
        return i11;
    }

    public int indexOf(double d11) {
        for (int i11 = this.start; i11 < this.end; i11++) {
            if (areEqual(this.array[i11], d11)) {
                return i11 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d11) {
        int i11 = this.end;
        while (true) {
            i11--;
            if (i11 < this.start) {
                return -1;
            }
            if (areEqual(this.array[i11], d11)) {
                return i11 - this.start;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableDoubleArray subArray(int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i12, length());
        if (i11 == i12) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i13 = this.start;
        return new ImmutableDoubleArray(dArr, i11 + i13, i13 + i12);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder(length() * 5);
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

    public ImmutableDoubleArray trimmed() {
        return isPartialView() ? new ImmutableDoubleArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    public static ImmutableDoubleArray of(double d11) {
        return new ImmutableDoubleArray(new double[]{d11});
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        private double[] array;
        private int count = 0;

        public Builder(int i11) {
            this.array = new double[i11];
        }

        private void ensureRoomFor(int i11) {
            int i12 = this.count + i11;
            double[] dArr = this.array;
            if (i12 > dArr.length) {
                double[] dArr2 = new double[expandedCapacity(dArr.length, i12)];
                System.arraycopy(this.array, 0, dArr2, 0, this.count);
                this.array = dArr2;
            }
        }

        private static int expandedCapacity(int i11, int i12) {
            if (i12 >= 0) {
                int i13 = i11 + (i11 >> 1) + 1;
                if (i13 < i12) {
                    i13 = Integer.highestOneBit(i12 - 1) << 1;
                }
                if (i13 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i13;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public Builder add(double d11) {
            ensureRoomFor(1);
            double[] dArr = this.array;
            int i11 = this.count;
            dArr[i11] = d11;
            this.count = i11 + 1;
            return this;
        }

        public Builder addAll(double[] dArr) {
            ensureRoomFor(dArr.length);
            System.arraycopy(dArr, 0, this.array, this.count, dArr.length);
            this.count += dArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableDoubleArray build() {
            return this.count == 0 ? ImmutableDoubleArray.EMPTY : new ImmutableDoubleArray(this.array, 0, this.count);
        }

        public Builder addAll(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Double>) (Collection) iterable);
            }
            for (Double doubleValue : iterable) {
                add(doubleValue.doubleValue());
            }
            return this;
        }

        public Builder addAll(Collection<Double> collection) {
            ensureRoomFor(collection.size());
            for (Double doubleValue : collection) {
                double[] dArr = this.array;
                int i11 = this.count;
                this.count = i11 + 1;
                dArr[i11] = doubleValue.doubleValue();
            }
            return this;
        }

        public Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
            ensureRoomFor(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.array, immutableDoubleArray.start, this.array, this.count, immutableDoubleArray.length());
            this.count += immutableDoubleArray.length();
            return this;
        }
    }

    private ImmutableDoubleArray(double[] dArr, int i11, int i12) {
        this.array = dArr;
        this.start = i11;
        this.end = i12;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.toArray(collection));
    }

    public static ImmutableDoubleArray of(double d11, double d12) {
        return new ImmutableDoubleArray(new double[]{d11, d12});
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) (Collection) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableDoubleArray of(double d11, double d12, double d13) {
        return new ImmutableDoubleArray(new double[]{d11, d12, d13});
    }

    public static ImmutableDoubleArray of(double d11, double d12, double d13, double d14) {
        return new ImmutableDoubleArray(new double[]{d11, d12, d13, d14});
    }

    public static ImmutableDoubleArray of(double d11, double d12, double d13, double d14, double d15) {
        return new ImmutableDoubleArray(new double[]{d11, d12, d13, d14, d15});
    }

    public static ImmutableDoubleArray of(double d11, double d12, double d13, double d14, double d15, double d16) {
        return new ImmutableDoubleArray(new double[]{d11, d12, d13, d14, d15, d16});
    }

    public static ImmutableDoubleArray of(double d11, double... dArr) {
        Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[(dArr.length + 1)];
        dArr2[0] = d11;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }
}
