package kotlin.sequences;

import java.util.Iterator;

public final class b<T> implements g<T>, c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final g<T> f56870a;

    /* renamed from: b  reason: collision with root package name */
    public final int f56871b;

    public static final class a implements Iterator<T>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final Iterator<T> f56872b;

        /* renamed from: c  reason: collision with root package name */
        public int f56873c;

        public a(b<T> bVar) {
            this.f56872b = bVar.f56870a.iterator();
            this.f56873c = bVar.f56871b;
        }

        public final void a() {
            while (this.f56873c > 0 && this.f56872b.hasNext()) {
                this.f56872b.next();
                this.f56873c--;
            }
        }

        public boolean hasNext() {
            a();
            return this.f56872b.hasNext();
        }

        public T next() {
            a();
            return this.f56872b.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(g<? extends T> gVar, int i11) {
        this.f56870a = gVar;
        this.f56871b = i11;
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i11 + '.').toString());
        }
    }

    public g<T> a(int i11) {
        int i12 = this.f56871b + i11;
        return i12 < 0 ? new b(this, i11) : new b(this.f56870a, i12);
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
