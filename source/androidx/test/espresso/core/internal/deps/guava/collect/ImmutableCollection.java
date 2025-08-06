package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    public static abstract class ArrayBasedBuilder<E> extends Builder<E> {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f11309a;

        /* renamed from: b  reason: collision with root package name */
        public int f11310b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11311c;

        public ArrayBasedBuilder(int i11) {
            CollectPreconditions.b(i11, "initialCapacity");
            this.f11309a = new Object[i11];
        }

        public ArrayBasedBuilder<E> b(E e11) {
            Preconditions.i(e11);
            d(this.f11310b + 1);
            Object[] objArr = this.f11309a;
            int i11 = this.f11310b;
            this.f11310b = i11 + 1;
            objArr[i11] = e11;
            return this;
        }

        public Builder<E> c(E... eArr) {
            ObjectArrays.b(eArr);
            d(this.f11310b + eArr.length);
            System.arraycopy(eArr, 0, this.f11309a, this.f11310b, eArr.length);
            this.f11310b += eArr.length;
            return this;
        }

        public final void d(int i11) {
            Object[] objArr = this.f11309a;
            if (objArr.length < i11) {
                this.f11309a = Arrays.copyOf(objArr, Builder.a(objArr.length, i11));
                this.f11311c = false;
            } else if (this.f11311c) {
                this.f11309a = (Object[]) objArr.clone();
                this.f11311c = false;
            }
        }
    }

    public static abstract class Builder<E> {
        public static int a(int i11, int i12) {
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
    }

    @Deprecated
    public final boolean add(E e11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i11) {
        UnmodifiableIterator it2 = iterator();
        while (it2.hasNext()) {
            objArr[i11] = it2.next();
            i11++;
        }
        return i11;
    }

    /* access modifiers changed from: package-private */
    public Object[] internalArray() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract UnmodifiableIterator<E> iterator();

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    public final <T> T[] toArray(T[] tArr) {
        Preconditions.i(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return Platform.a(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = ObjectArrays.d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
