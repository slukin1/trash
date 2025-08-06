package androidx.test.espresso.core.internal.deps.guava.collect;

final class RegularImmutableSet<E> extends ImmutableSet<E> {
    public static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet(new Object[0], 0, (Object[]) null, 0, 0);
    public final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;
    public final transient Object[] table;

    public RegularImmutableSet(Object[] objArr, int i11, Object[] objArr2, int i12, int i13) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = i12;
        this.hashCode = i11;
        this.size = i13;
    }

    public boolean contains(Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int b11 = Hashing.b(obj);
        while (true) {
            int i11 = b11 & this.mask;
            Object obj2 = objArr[i11];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            b11 = i11 + 1;
        }
    }

    public int copyIntoArray(Object[] objArr, int i11) {
        System.arraycopy(this.elements, 0, objArr, i11, this.size);
        return i11 + this.size;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.elements, this.size);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public Object[] internalArray() {
        return this.elements;
    }

    public int internalArrayEnd() {
        return this.size;
    }

    public int internalArrayStart() {
        return 0;
    }

    public boolean isHashCodeFast() {
        return true;
    }

    public int size() {
        return this.size;
    }

    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }
}
