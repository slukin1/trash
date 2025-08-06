package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.ArrayDeque;
import kotlin.collections.d;
import kotlin.jvm.internal.x;

public final class ListBuilder<E> extends d<E> implements RandomAccess, Serializable {
    /* access modifiers changed from: private */
    public E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    /* access modifiers changed from: private */
    public int length;
    /* access modifiers changed from: private */
    public int offset;
    private final ListBuilder<E> root;

    public static final class a<E> implements ListIterator<E>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final ListBuilder<E> f56641b;

        /* renamed from: c  reason: collision with root package name */
        public int f56642c;

        /* renamed from: d  reason: collision with root package name */
        public int f56643d = -1;

        public a(ListBuilder<E> listBuilder, int i11) {
            this.f56641b = listBuilder;
            this.f56642c = i11;
        }

        public void add(E e11) {
            ListBuilder<E> listBuilder = this.f56641b;
            int i11 = this.f56642c;
            this.f56642c = i11 + 1;
            listBuilder.add(i11, e11);
            this.f56643d = -1;
        }

        public boolean hasNext() {
            return this.f56642c < this.f56641b.length;
        }

        public boolean hasPrevious() {
            return this.f56642c > 0;
        }

        public E next() {
            if (this.f56642c < this.f56641b.length) {
                int i11 = this.f56642c;
                this.f56642c = i11 + 1;
                this.f56643d = i11;
                return this.f56641b.array[this.f56641b.offset + this.f56643d];
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.f56642c;
        }

        public E previous() {
            int i11 = this.f56642c;
            if (i11 > 0) {
                int i12 = i11 - 1;
                this.f56642c = i12;
                this.f56643d = i12;
                return this.f56641b.array[this.f56641b.offset + this.f56643d];
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.f56642c - 1;
        }

        public void remove() {
            int i11 = this.f56643d;
            if (i11 != -1) {
                this.f56641b.remove(i11);
                this.f56642c = this.f56643d;
                this.f56643d = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        public void set(E e11) {
            int i11 = this.f56643d;
            if (i11 != -1) {
                this.f56641b.set(i11, e11);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i11, int i12, boolean z11, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i11;
        this.length = i12;
        this.isReadOnly = z11;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void addAllInternal(int i11, Collection<? extends E> collection, int i12) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i11, collection, i12);
            this.array = this.backing.array;
            this.length += i12;
            return;
        }
        insertAtInternal(i11, i12);
        Iterator<? extends E> it2 = collection.iterator();
        for (int i13 = 0; i13 < i12; i13++) {
            this.array[i11 + i13] = it2.next();
        }
    }

    private final void addAtInternal(int i11, E e11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i11, e11);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i11, 1);
        this.array[i11] = e11;
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        return a.h(this.array, this.offset, this.length, list);
    }

    private final void ensureCapacity(int i11) {
        if (this.backing != null) {
            throw new IllegalStateException();
        } else if (i11 >= 0) {
            E[] eArr = this.array;
            if (i11 > eArr.length) {
                this.array = a.e(this.array, ArrayDeque.f56626e.a(eArr.length, i11));
            }
        } else {
            throw new OutOfMemoryError();
        }
    }

    private final void ensureExtraCapacity(int i11) {
        ensureCapacity(this.length + i11);
    }

    private final void insertAtInternal(int i11, int i12) {
        ensureExtraCapacity(i12);
        E[] eArr = this.array;
        Object[] unused = ArraysKt___ArraysJvmKt.f(eArr, eArr, i11 + i12, i11, this.offset + this.length);
        this.length += i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.root;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isEffectivelyReadOnly() {
        /*
            r1 = this;
            boolean r0 = r1.isReadOnly
            if (r0 != 0) goto L_0x000f
            kotlin.collections.builders.ListBuilder<E> r0 = r1.root
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.isReadOnly
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.ListBuilder.isEffectivelyReadOnly():boolean");
    }

    private final E removeAtInternal(int i11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i11);
        }
        E[] eArr = this.array;
        E e11 = eArr[i11];
        Object[] unused = ArraysKt___ArraysJvmKt.f(eArr, eArr, i11, i11 + 1, this.offset + this.length);
        a.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e11;
    }

    private final void removeRangeInternal(int i11, int i12) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i11, i12);
        } else {
            E[] eArr = this.array;
            Object[] unused = ArraysKt___ArraysJvmKt.f(eArr, eArr, i11, i11 + i12, this.length);
            E[] eArr2 = this.array;
            int i13 = this.length;
            a.g(eArr2, i13 - i12, i13);
        }
        this.length -= i12;
    }

    private final int retainOrRemoveAllInternal(int i11, int i12, Collection<? extends E> collection, boolean z11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i11, i12, collection, z11);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int i15 = i11 + i13;
            if (collection.contains(this.array[i15]) == z11) {
                E[] eArr = this.array;
                i13++;
                eArr[i14 + i11] = eArr[i15];
                i14++;
            } else {
                i13++;
            }
        }
        int i16 = i12 - i14;
        E[] eArr2 = this.array;
        Object[] unused = ArraysKt___ArraysJvmKt.f(eArr2, eArr2, i11 + i14, i12 + i11, this.length);
        E[] eArr3 = this.array;
        int i17 = this.length;
        a.g(eArr3, i17 - i16, i17);
        this.length -= i16;
        return i16;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    public boolean add(E e11) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e11);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        checkIsMutable();
        int size = collection.size();
        addAllInternal(this.offset + this.length, collection, size);
        return size > 0;
    }

    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    public E get(int i11) {
        kotlin.collections.a.Companion.b(i11, this.length);
        return this.array[this.offset + i11];
    }

    public int getSize() {
        return this.length;
    }

    public int hashCode() {
        return a.i(this.array, this.offset, this.length);
    }

    public int indexOf(Object obj) {
        for (int i11 = 0; i11 < this.length; i11++) {
            if (x.b(this.array[this.offset + i11], obj)) {
                return i11;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    public int lastIndexOf(Object obj) {
        for (int i11 = this.length - 1; i11 >= 0; i11--) {
            if (x.b(this.array[this.offset + i11], obj)) {
                return i11;
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0;
    }

    public E removeAt(int i11) {
        checkIsMutable();
        kotlin.collections.a.Companion.b(i11, this.length);
        return removeAtInternal(this.offset + i11);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0;
    }

    public E set(int i11, E e11) {
        checkIsMutable();
        kotlin.collections.a.Companion.b(i11, this.length);
        E[] eArr = this.array;
        int i12 = this.offset;
        E e12 = eArr[i12 + i11];
        eArr[i12 + i11] = e11;
        return e12;
    }

    public List<E> subList(int i11, int i12) {
        kotlin.collections.a.Companion.d(i11, i12, this.length);
        E[] eArr = this.array;
        int i13 = this.offset + i11;
        int i14 = i12 - i11;
        boolean z11 = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i13, i14, z11, this, listBuilder == null ? this : listBuilder);
    }

    public <T> T[] toArray(T[] tArr) {
        int length2 = tArr.length;
        int i11 = this.length;
        if (length2 < i11) {
            E[] eArr = this.array;
            int i12 = this.offset;
            return Arrays.copyOfRange(eArr, i12, i11 + i12, tArr.getClass());
        }
        E[] eArr2 = this.array;
        int i13 = this.offset;
        Object[] unused = ArraysKt___ArraysJvmKt.f(eArr2, tArr, 0, i13, i11 + i13);
        int length3 = tArr.length;
        int i14 = this.length;
        if (length3 > i14) {
            tArr[i14] = null;
        }
        return tArr;
    }

    public String toString() {
        return a.j(this.array, this.offset, this.length);
    }

    public ListIterator<E> listIterator(int i11) {
        kotlin.collections.a.Companion.c(i11, this.length);
        return new a(this, i11);
    }

    public void add(int i11, E e11) {
        checkIsMutable();
        kotlin.collections.a.Companion.c(i11, this.length);
        addAtInternal(this.offset + i11, e11);
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        checkIsMutable();
        kotlin.collections.a.Companion.c(i11, this.length);
        int size = collection.size();
        addAllInternal(this.offset + i11, collection, size);
        return size > 0;
    }

    public Object[] toArray() {
        E[] eArr = this.array;
        int i11 = this.offset;
        return ArraysKt___ArraysJvmKt.j(eArr, i11, this.length + i11);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i11) {
        this(a.d(i11), 0, 0, false, (ListBuilder) null, (ListBuilder) null);
    }
}
