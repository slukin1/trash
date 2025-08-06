package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;

public final class u implements Collection<t>, e10.a {

    /* renamed from: b  reason: collision with root package name */
    public final short[] f56938b;

    public static final class a implements Iterator<t>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final short[] f56939b;

        /* renamed from: c  reason: collision with root package name */
        public int f56940c;

        public a(short[] sArr) {
            this.f56939b = sArr;
        }

        public short a() {
            int i11 = this.f56940c;
            short[] sArr = this.f56939b;
            if (i11 < sArr.length) {
                this.f56940c = i11 + 1;
                return t.b(sArr[i11]);
            }
            throw new NoSuchElementException(String.valueOf(this.f56940c));
        }

        public boolean hasNext() {
            return this.f56940c < this.f56939b.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return t.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ u(short[] sArr) {
        this.f56938b = sArr;
    }

    public static final /* synthetic */ u a(short[] sArr) {
        return new u(sArr);
    }

    public static short[] b(int i11) {
        return c(new short[i11]);
    }

    public static short[] c(short[] sArr) {
        return sArr;
    }

    public static boolean g(short[] sArr, short s11) {
        return ArraysKt___ArraysKt.D(sArr, s11);
    }

    public static boolean h(short[] sArr, Collection<t> collection) {
        boolean z11;
        if (!collection.isEmpty()) {
            for (T next : collection) {
                if (!(next instanceof t) || !ArraysKt___ArraysKt.D(sArr, ((t) next).g())) {
                    z11 = false;
                    continue;
                } else {
                    z11 = true;
                    continue;
                }
                if (!z11) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean i(short[] sArr, Object obj) {
        return (obj instanceof u) && x.b(sArr, ((u) obj).r());
    }

    public static final short j(short[] sArr, int i11) {
        return t.b(sArr[i11]);
    }

    public static int l(short[] sArr) {
        return sArr.length;
    }

    public static int m(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean n(short[] sArr) {
        return sArr.length == 0;
    }

    public static Iterator<t> o(short[] sArr) {
        return new a(sArr);
    }

    public static final void p(short[] sArr, int i11, short s11) {
        sArr[i11] = s11;
    }

    public static String q(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends t> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        return d(((t) obj).g());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return h(this.f56938b, collection);
    }

    public boolean d(short s11) {
        return g(this.f56938b, s11);
    }

    public boolean equals(Object obj) {
        return i(this.f56938b, obj);
    }

    public int hashCode() {
        return m(this.f56938b);
    }

    public boolean isEmpty() {
        return n(this.f56938b);
    }

    public Iterator<t> iterator() {
        return o(this.f56938b);
    }

    /* renamed from: k */
    public int size() {
        return l(this.f56938b);
    }

    public final /* synthetic */ short[] r() {
        return this.f56938b;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return q.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return q.b(this, tArr);
    }

    public String toString() {
        return q(this.f56938b);
    }
}
