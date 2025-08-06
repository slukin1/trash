package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

class RegularImmutableList<E> extends ImmutableList<E> {
    public static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);
    public final transient Object[] array;
    private final transient int size;

    public RegularImmutableList(Object[] objArr, int i11) {
        this.array = objArr;
        this.size = i11;
    }

    public int copyIntoArray(Object[] objArr, int i11) {
        System.arraycopy(this.array, 0, objArr, i11, this.size);
        return i11 + this.size;
    }

    public E get(int i11) {
        Preconditions.g(i11, this.size);
        return this.array[i11];
    }

    public Object[] internalArray() {
        return this.array;
    }

    public int internalArrayEnd() {
        return this.size;
    }

    public int internalArrayStart() {
        return 0;
    }

    public int size() {
        return this.size;
    }
}
