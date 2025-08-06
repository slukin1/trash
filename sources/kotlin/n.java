package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;

public final class n implements Collection<m>, e10.a {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f56802b;

    public static final class a implements Iterator<m>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f56803b;

        /* renamed from: c  reason: collision with root package name */
        public int f56804c;

        public a(byte[] bArr) {
            this.f56803b = bArr;
        }

        public byte a() {
            int i11 = this.f56804c;
            byte[] bArr = this.f56803b;
            if (i11 < bArr.length) {
                this.f56804c = i11 + 1;
                return m.b(bArr[i11]);
            }
            throw new NoSuchElementException(String.valueOf(this.f56804c));
        }

        public boolean hasNext() {
            return this.f56804c < this.f56803b.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return m.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ n(byte[] bArr) {
        this.f56802b = bArr;
    }

    public static final /* synthetic */ n a(byte[] bArr) {
        return new n(bArr);
    }

    public static byte[] b(int i11) {
        return c(new byte[i11]);
    }

    public static byte[] c(byte[] bArr) {
        return bArr;
    }

    public static boolean g(byte[] bArr, byte b11) {
        return ArraysKt___ArraysKt.z(bArr, b11);
    }

    public static boolean h(byte[] bArr, Collection<m> collection) {
        boolean z11;
        if (!collection.isEmpty()) {
            for (T next : collection) {
                if (!(next instanceof m) || !ArraysKt___ArraysKt.z(bArr, ((m) next).g())) {
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

    public static boolean i(byte[] bArr, Object obj) {
        return (obj instanceof n) && x.b(bArr, ((n) obj).r());
    }

    public static final byte j(byte[] bArr, int i11) {
        return m.b(bArr[i11]);
    }

    public static int l(byte[] bArr) {
        return bArr.length;
    }

    public static int m(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean n(byte[] bArr) {
        return bArr.length == 0;
    }

    public static Iterator<m> o(byte[] bArr) {
        return new a(bArr);
    }

    public static final void p(byte[] bArr, int i11, byte b11) {
        bArr[i11] = b11;
    }

    public static String q(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends m> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        return d(((m) obj).g());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return h(this.f56802b, collection);
    }

    public boolean d(byte b11) {
        return g(this.f56802b, b11);
    }

    public boolean equals(Object obj) {
        return i(this.f56802b, obj);
    }

    public int hashCode() {
        return m(this.f56802b);
    }

    public boolean isEmpty() {
        return n(this.f56802b);
    }

    public Iterator<m> iterator() {
        return o(this.f56802b);
    }

    /* renamed from: k */
    public int size() {
        return l(this.f56802b);
    }

    public final /* synthetic */ byte[] r() {
        return this.f56802b;
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
        return q(this.f56802b);
    }
}
