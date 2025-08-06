package kotlin.sequences;

import d10.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class f<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d10.a<T> f56882a;

    /* renamed from: b  reason: collision with root package name */
    public final l<T, T> f56883b;

    public static final class a implements Iterator<T>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public T f56884b;

        /* renamed from: c  reason: collision with root package name */
        public int f56885c = -2;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f<T> f56886d;

        public a(f<T> fVar) {
            this.f56886d = fVar;
        }

        public final void a() {
            T invoke = this.f56885c == -2 ? this.f56886d.f56882a.invoke() : this.f56886d.f56883b.invoke(this.f56884b);
            this.f56884b = invoke;
            this.f56885c = invoke == null ? 0 : 1;
        }

        public boolean hasNext() {
            if (this.f56885c < 0) {
                a();
            }
            return this.f56885c == 1;
        }

        public T next() {
            if (this.f56885c < 0) {
                a();
            }
            if (this.f56885c != 0) {
                T t11 = this.f56884b;
                this.f56885c = -1;
                return t11;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(d10.a<? extends T> aVar, l<? super T, ? extends T> lVar) {
        this.f56882a = aVar;
        this.f56883b = lVar;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
