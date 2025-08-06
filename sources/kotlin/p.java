package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;

public final class p implements Collection<o>, e10.a {

    /* renamed from: b  reason: collision with root package name */
    public final int[] f56807b;

    public static final class a implements Iterator<o>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final int[] f56808b;

        /* renamed from: c  reason: collision with root package name */
        public int f56809c;

        public a(int[] iArr) {
            this.f56808b = iArr;
        }

        public int a() {
            int i11 = this.f56809c;
            int[] iArr = this.f56808b;
            if (i11 < iArr.length) {
                this.f56809c = i11 + 1;
                return o.b(iArr[i11]);
            }
            throw new NoSuchElementException(String.valueOf(this.f56809c));
        }

        public boolean hasNext() {
            return this.f56809c < this.f56808b.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return o.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ p(int[] iArr) {
        this.f56807b = iArr;
    }

    public static final /* synthetic */ p a(int[] iArr) {
        return new p(iArr);
    }

    public static int[] b(int i11) {
        return c(new int[i11]);
    }

    public static int[] c(int[] iArr) {
        return iArr;
    }

    public static boolean g(int[] iArr, int i11) {
        return ArraysKt___ArraysKt.A(iArr, i11);
    }

    public static boolean h(int[] iArr, Collection<o> collection) {
        boolean z11;
        if (!collection.isEmpty()) {
            for (T next : collection) {
                if (!(next instanceof o) || !ArraysKt___ArraysKt.A(iArr, ((o) next).g())) {
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

    public static boolean i(int[] iArr, Object obj) {
        return (obj instanceof p) && x.b(iArr, ((p) obj).r());
    }

    public static final int j(int[] iArr, int i11) {
        return o.b(iArr[i11]);
    }

    public static int l(int[] iArr) {
        return iArr.length;
    }

    public static int m(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean n(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator<o> o(int[] iArr) {
        return new a(iArr);
    }

    public static final void p(int[] iArr, int i11, int i12) {
        iArr[i11] = i12;
    }

    public static String q(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends o> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        return d(((o) obj).g());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return h(this.f56807b, collection);
    }

    public boolean d(int i11) {
        return g(this.f56807b, i11);
    }

    public boolean equals(Object obj) {
        return i(this.f56807b, obj);
    }

    public int hashCode() {
        return m(this.f56807b);
    }

    public boolean isEmpty() {
        return n(this.f56807b);
    }

    public Iterator<o> iterator() {
        return o(this.f56807b);
    }

    /* renamed from: k */
    public int size() {
        return l(this.f56807b);
    }

    public final /* synthetic */ int[] r() {
        return this.f56807b;
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
        return q(this.f56807b);
    }
}
