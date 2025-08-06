package kotlin.sequences;

import d10.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class i<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    public final g<T> f56887a;

    /* renamed from: b  reason: collision with root package name */
    public final l<T, Boolean> f56888b;

    public static final class a implements Iterator<T>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final Iterator<T> f56889b;

        /* renamed from: c  reason: collision with root package name */
        public int f56890c = -1;

        /* renamed from: d  reason: collision with root package name */
        public T f56891d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i<T> f56892e;

        public a(i<T> iVar) {
            this.f56892e = iVar;
            this.f56889b = iVar.f56887a.iterator();
        }

        public final void a() {
            if (this.f56889b.hasNext()) {
                T next = this.f56889b.next();
                if (((Boolean) this.f56892e.f56888b.invoke(next)).booleanValue()) {
                    this.f56890c = 1;
                    this.f56891d = next;
                    return;
                }
            }
            this.f56890c = 0;
        }

        public boolean hasNext() {
            if (this.f56890c == -1) {
                a();
            }
            return this.f56890c == 1;
        }

        public T next() {
            if (this.f56890c == -1) {
                a();
            }
            if (this.f56890c != 0) {
                T t11 = this.f56891d;
                this.f56891d = null;
                this.f56890c = -1;
                return t11;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i(g<? extends T> gVar, l<? super T, Boolean> lVar) {
        this.f56887a = gVar;
        this.f56888b = lVar;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
