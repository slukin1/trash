package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;

public final class r implements Collection<q>, e10.a {

    /* renamed from: b  reason: collision with root package name */
    public final long[] f56815b;

    public static final class a implements Iterator<q>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final long[] f56816b;

        /* renamed from: c  reason: collision with root package name */
        public int f56817c;

        public a(long[] jArr) {
            this.f56816b = jArr;
        }

        public long a() {
            int i11 = this.f56817c;
            long[] jArr = this.f56816b;
            if (i11 < jArr.length) {
                this.f56817c = i11 + 1;
                return q.b(jArr[i11]);
            }
            throw new NoSuchElementException(String.valueOf(this.f56817c));
        }

        public boolean hasNext() {
            return this.f56817c < this.f56816b.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return q.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ r(long[] jArr) {
        this.f56815b = jArr;
    }

    public static final /* synthetic */ r a(long[] jArr) {
        return new r(jArr);
    }

    public static long[] b(int i11) {
        return c(new long[i11]);
    }

    public static long[] c(long[] jArr) {
        return jArr;
    }

    public static boolean g(long[] jArr, long j11) {
        return ArraysKt___ArraysKt.B(jArr, j11);
    }

    public static boolean h(long[] jArr, Collection<q> collection) {
        boolean z11;
        if (!collection.isEmpty()) {
            for (T next : collection) {
                if (!(next instanceof q) || !ArraysKt___ArraysKt.B(jArr, ((q) next).g())) {
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

    public static boolean i(long[] jArr, Object obj) {
        return (obj instanceof r) && x.b(jArr, ((r) obj).r());
    }

    public static final long j(long[] jArr, int i11) {
        return q.b(jArr[i11]);
    }

    public static int l(long[] jArr) {
        return jArr.length;
    }

    public static int m(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean n(long[] jArr) {
        return jArr.length == 0;
    }

    public static Iterator<q> o(long[] jArr) {
        return new a(jArr);
    }

    public static final void p(long[] jArr, int i11, long j11) {
        jArr[i11] = j11;
    }

    public static String q(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends q> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        return d(((q) obj).g());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return h(this.f56815b, collection);
    }

    public boolean d(long j11) {
        return g(this.f56815b, j11);
    }

    public boolean equals(Object obj) {
        return i(this.f56815b, obj);
    }

    public int hashCode() {
        return m(this.f56815b);
    }

    public boolean isEmpty() {
        return n(this.f56815b);
    }

    public Iterator<q> iterator() {
        return o(this.f56815b);
    }

    /* renamed from: k */
    public int size() {
        return l(this.f56815b);
    }

    public final /* synthetic */ long[] r() {
        return this.f56815b;
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
        return q(this.f56815b);
    }
}
