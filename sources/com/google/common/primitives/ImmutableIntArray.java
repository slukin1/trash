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
public final class ImmutableIntArray implements Serializable {
    /* access modifiers changed from: private */
    public static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    /* access modifiers changed from: private */
    public final int[] array;
    private final int end;
    /* access modifiers changed from: private */
    public final transient int start;

    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

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
                if (next instanceof Integer) {
                    int i11 = access$100 + 1;
                    if (this.parent.array[access$100] == ((Integer) next).intValue()) {
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
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        public int size() {
            return this.parent.length();
        }

        public List<Integer> subList(int i11, int i12) {
            return this.parent.subArray(i11, i12).asList();
        }

        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        public Integer get(int i11) {
            return Integer.valueOf(this.parent.get(i11));
        }
    }

    public static Builder builder(int i11) {
        Preconditions.checkArgument(i11 >= 0, "Invalid initialCapacity: %s", i11);
        return new Builder(i11);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i11) {
        return indexOf(i11) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length(); i11++) {
            if (get(i11) != immutableIntArray.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i11) {
        Preconditions.checkElementIndex(i11, length());
        return this.array[this.start + i11];
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = this.start; i12 < this.end; i12++) {
            i11 = (i11 * 31) + Ints.hashCode(this.array[i12]);
        }
        return i11;
    }

    public int indexOf(int i11) {
        for (int i12 = this.start; i12 < this.end; i12++) {
            if (this.array[i12] == i11) {
                return i12 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i11) {
        int i12 = this.end;
        while (true) {
            i12--;
            int i13 = this.start;
            if (i12 < i13) {
                return -1;
            }
            if (this.array[i12] == i11) {
                return i12 - i13;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableIntArray subArray(int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i12, length());
        if (i11 == i12) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i13 = this.start;
        return new ImmutableIntArray(iArr, i11 + i13, i13 + i12);
    }

    public int[] toArray() {
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

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.toArray(collection));
    }

    public static ImmutableIntArray of(int i11) {
        return new ImmutableIntArray(new int[]{i11});
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        private int[] array;
        private int count = 0;

        public Builder(int i11) {
            this.array = new int[i11];
        }

        private void ensureRoomFor(int i11) {
            int i12 = this.count + i11;
            int[] iArr = this.array;
            if (i12 > iArr.length) {
                int[] iArr2 = new int[expandedCapacity(iArr.length, i12)];
                System.arraycopy(this.array, 0, iArr2, 0, this.count);
                this.array = iArr2;
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

        public Builder add(int i11) {
            ensureRoomFor(1);
            int[] iArr = this.array;
            int i12 = this.count;
            iArr[i12] = i11;
            this.count = i12 + 1;
            return this;
        }

        public Builder addAll(int[] iArr) {
            ensureRoomFor(iArr.length);
            System.arraycopy(iArr, 0, this.array, this.count, iArr.length);
            this.count += iArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableIntArray build() {
            return this.count == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(this.array, 0, this.count);
        }

        public Builder addAll(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Integer>) (Collection) iterable);
            }
            for (Integer intValue : iterable) {
                add(intValue.intValue());
            }
            return this;
        }

        public Builder addAll(Collection<Integer> collection) {
            ensureRoomFor(collection.size());
            for (Integer intValue : collection) {
                int[] iArr = this.array;
                int i11 = this.count;
                this.count = i11 + 1;
                iArr[i11] = intValue.intValue();
            }
            return this;
        }

        public Builder addAll(ImmutableIntArray immutableIntArray) {
            ensureRoomFor(immutableIntArray.length());
            System.arraycopy(immutableIntArray.array, immutableIntArray.start, this.array, this.count, immutableIntArray.length());
            this.count += immutableIntArray.length();
            return this;
        }
    }

    private ImmutableIntArray(int[] iArr, int i11, int i12) {
        this.array = iArr;
        this.start = i11;
        this.end = i12;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) (Collection) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableIntArray of(int i11, int i12) {
        return new ImmutableIntArray(new int[]{i11, i12});
    }

    public static ImmutableIntArray of(int i11, int i12, int i13) {
        return new ImmutableIntArray(new int[]{i11, i12, i13});
    }

    public static ImmutableIntArray of(int i11, int i12, int i13, int i14) {
        return new ImmutableIntArray(new int[]{i11, i12, i13, i14});
    }

    public static ImmutableIntArray of(int i11, int i12, int i13, int i14, int i15) {
        return new ImmutableIntArray(new int[]{i11, i12, i13, i14, i15});
    }

    public static ImmutableIntArray of(int i11, int i12, int i13, int i14, int i15, int i16) {
        return new ImmutableIntArray(new int[]{i11, i12, i13, i14, i15, i16});
    }

    public static ImmutableIntArray of(int i11, int... iArr) {
        Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[(iArr.length + 1)];
        iArr2[0] = i11;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
