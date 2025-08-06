package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final UnmodifiableListIterator<Object> EMPTY_ITR = new Itr(RegularImmutableList.EMPTY, 0);

    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        public Builder(int i11) {
            super(i11);
        }
    }

    public static class Itr<E> extends AbstractIndexedListIterator<E> {

        /* renamed from: d  reason: collision with root package name */
        public final ImmutableList<E> f11312d;

        public Itr(ImmutableList<E> immutableList, int i11) {
            super(immutableList.size(), i11);
            this.f11312d = immutableList;
        }

        public E a(int i11) {
            return this.f11312d.get(i11);
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    public class SubList extends ImmutableList<E> {
        public final transient int length;
        public final transient int offset;

        public SubList(int i11, int i12) {
            this.offset = i11;
            this.length = i12;
        }

        public E get(int i11) {
            Preconditions.g(i11, this.length);
            return ImmutableList.this.get(i11 + this.offset);
        }

        public Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        public int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        public int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        public int size() {
            return this.length;
        }

        public ImmutableList<E> subList(int i11, int i12) {
            Preconditions.n(i11, i12, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i13 = this.offset;
            return immutableList.subList(i11 + i13, i12 + i13);
        }
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(ObjectArrays.b(objArr));
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        return construct((Object[]) eArr.clone());
    }

    public static <E> ImmutableList<E> of() {
        return RegularImmutableList.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Deprecated
    public final void add(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i11, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final ImmutableList<E> asList() {
        return this;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int copyIntoArray(Object[] objArr, int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i11 + i12] = get(i12);
        }
        return i11 + size;
    }

    public boolean equals(Object obj) {
        return Lists.b(this, obj);
    }

    public int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = ~(~((i11 * 31) + get(i12).hashCode()));
        }
        return i11;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.c(this, obj);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.e(this, obj);
    }

    @Deprecated
    public final E remove(int i11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> subListUnchecked(int i11, int i12) {
        return new SubList(i11, i12 - i11);
    }

    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i11) {
        if (i11 == 0) {
            return of();
        }
        return new RegularImmutableList(objArr, i11);
    }

    public static <E> ImmutableList<E> of(E e11) {
        return construct(e11);
    }

    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    public ImmutableList<E> subList(int i11, int i12) {
        Preconditions.n(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        if (i13 == 0) {
            return of();
        }
        return subListUnchecked(i11, i12);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14) {
        return construct(e11, e12, e13, e14);
    }

    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16) {
        return construct(e11, e12, e13, e14, e15, e16);
    }

    public UnmodifiableListIterator<E> listIterator(int i11) {
        Preconditions.l(i11, size());
        if (isEmpty()) {
            return EMPTY_ITR;
        }
        return new Itr(this, i11);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18) {
        return construct(e11, e12, e13, e14, e15, e16, e17, e18);
    }

    public static <E> ImmutableList<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19) {
        return construct(e11, e12, e13, e14, e15, e16, e17, e18, e19);
    }
}
