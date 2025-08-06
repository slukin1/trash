package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;

@GwtCompatible(emulated = true)
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    @GwtIncompatible
    public int copyIntoArray(Object[] objArr, int i11) {
        return this.delegateList.copyIntoArray(objArr, i11);
    }

    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    public E get(int i11) {
        return this.delegateList.get(i11);
    }

    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    public UnmodifiableListIterator<E> listIterator(int i11) {
        return this.delegateList.listIterator(i11);
    }

    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }

    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr, int i11) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr, i11));
    }
}
