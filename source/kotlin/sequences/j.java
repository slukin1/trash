package kotlin.sequences;

import d10.l;
import java.util.Iterator;

public final class j<T, R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    public final g<T> f56893a;

    /* renamed from: b  reason: collision with root package name */
    public final l<T, R> f56894b;

    public static final class a implements Iterator<R>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final Iterator<T> f56895b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j<T, R> f56896c;

        public a(j<T, R> jVar) {
            this.f56896c = jVar;
            this.f56895b = jVar.f56893a.iterator();
        }

        public boolean hasNext() {
            return this.f56895b.hasNext();
        }

        public R next() {
            return this.f56896c.f56894b.invoke(this.f56895b.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public j(g<? extends T> gVar, l<? super T, ? extends R> lVar) {
        this.f56893a = gVar;
        this.f56894b = lVar;
    }

    public Iterator<R> iterator() {
        return new a(this);
    }
}
