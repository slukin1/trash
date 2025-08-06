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
public final class ImmutableLongArray implements Serializable {
    /* access modifiers changed from: private */
    public static final ImmutableLongArray EMPTY = new ImmutableLongArray(new long[0]);
    /* access modifiers changed from: private */
    public final long[] array;
    private final int end;
    /* access modifiers changed from: private */
    public final transient int start;

    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray parent;

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
                if (next instanceof Long) {
                    int i11 = access$100 + 1;
                    if (this.parent.array[access$100] == ((Long) next).longValue()) {
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
            if (obj instanceof Long) {
                return this.parent.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        public int size() {
            return this.parent.length();
        }

        public List<Long> subList(int i11, int i12) {
            return this.parent.subArray(i11, i12).asList();
        }

        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
        }

        public Long get(int i11) {
            return Long.valueOf(this.parent.get(i11));
        }
    }

    public static Builder builder(int i11) {
        Preconditions.checkArgument(i11 >= 0, "Invalid initialCapacity: %s", i11);
        return new Builder(i11);
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        if (jArr.length == 0) {
            return EMPTY;
        }
        return new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public List<Long> asList() {
        return new AsList();
    }

    public boolean contains(long j11) {
        return indexOf(j11) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length(); i11++) {
            if (get(i11) != immutableLongArray.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public long get(int i11) {
        Preconditions.checkElementIndex(i11, length());
        return this.array[this.start + i11];
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = this.start; i12 < this.end; i12++) {
            i11 = (i11 * 31) + Longs.hashCode(this.array[i12]);
        }
        return i11;
    }

    public int indexOf(long j11) {
        for (int i11 = this.start; i11 < this.end; i11++) {
            if (this.array[i11] == j11) {
                return i11 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(long j11) {
        int i11 = this.end;
        while (true) {
            i11--;
            int i12 = this.start;
            if (i11 < i12) {
                return -1;
            }
            if (this.array[i11] == j11) {
                return i11 - i12;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableLongArray subArray(int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i12, length());
        if (i11 == i12) {
            return EMPTY;
        }
        long[] jArr = this.array;
        int i13 = this.start;
        return new ImmutableLongArray(jArr, i11 + i13, i13 + i12);
    }

    public long[] toArray() {
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

    public ImmutableLongArray trimmed() {
        return isPartialView() ? new ImmutableLongArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    public static ImmutableLongArray of(long j11) {
        return new ImmutableLongArray(new long[]{j11});
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        private long[] array;
        private int count = 0;

        public Builder(int i11) {
            this.array = new long[i11];
        }

        private void ensureRoomFor(int i11) {
            int i12 = this.count + i11;
            long[] jArr = this.array;
            if (i12 > jArr.length) {
                long[] jArr2 = new long[expandedCapacity(jArr.length, i12)];
                System.arraycopy(this.array, 0, jArr2, 0, this.count);
                this.array = jArr2;
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

        public Builder add(long j11) {
            ensureRoomFor(1);
            long[] jArr = this.array;
            int i11 = this.count;
            jArr[i11] = j11;
            this.count = i11 + 1;
            return this;
        }

        public Builder addAll(long[] jArr) {
            ensureRoomFor(jArr.length);
            System.arraycopy(jArr, 0, this.array, this.count, jArr.length);
            this.count += jArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableLongArray build() {
            return this.count == 0 ? ImmutableLongArray.EMPTY : new ImmutableLongArray(this.array, 0, this.count);
        }

        public Builder addAll(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Long>) (Collection) iterable);
            }
            for (Long longValue : iterable) {
                add(longValue.longValue());
            }
            return this;
        }

        public Builder addAll(Collection<Long> collection) {
            ensureRoomFor(collection.size());
            for (Long longValue : collection) {
                long[] jArr = this.array;
                int i11 = this.count;
                this.count = i11 + 1;
                jArr[i11] = longValue.longValue();
            }
            return this;
        }

        public Builder addAll(ImmutableLongArray immutableLongArray) {
            ensureRoomFor(immutableLongArray.length());
            System.arraycopy(immutableLongArray.array, immutableLongArray.start, this.array, this.count, immutableLongArray.length());
            this.count += immutableLongArray.length();
            return this;
        }
    }

    private ImmutableLongArray(long[] jArr, int i11, int i12) {
        this.array = jArr;
        this.start = i11;
        this.end = i12;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableLongArray(Longs.toArray(collection));
    }

    public static ImmutableLongArray of(long j11, long j12) {
        return new ImmutableLongArray(new long[]{j11, j12});
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Long>) (Collection) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableLongArray of(long j11, long j12, long j13) {
        return new ImmutableLongArray(new long[]{j11, j12, j13});
    }

    public static ImmutableLongArray of(long j11, long j12, long j13, long j14) {
        return new ImmutableLongArray(new long[]{j11, j12, j13, j14});
    }

    public static ImmutableLongArray of(long j11, long j12, long j13, long j14, long j15) {
        return new ImmutableLongArray(new long[]{j11, j12, j13, j14, j15});
    }

    public static ImmutableLongArray of(long j11, long j12, long j13, long j14, long j15, long j16) {
        return new ImmutableLongArray(new long[]{j11, j12, j13, j14, j15, j16});
    }

    public static ImmutableLongArray of(long j11, long... jArr) {
        Preconditions.checkArgument(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[(jArr.length + 1)];
        jArr2[0] = j11;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }
}
