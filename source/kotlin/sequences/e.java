package kotlin.sequences;

import d10.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class e<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    public final g<T> f56875a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f56876b;

    /* renamed from: c  reason: collision with root package name */
    public final l<T, Boolean> f56877c;

    public static final class a implements Iterator<T>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final Iterator<T> f56878b;

        /* renamed from: c  reason: collision with root package name */
        public int f56879c = -1;

        /* renamed from: d  reason: collision with root package name */
        public T f56880d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e<T> f56881e;

        public a(e<T> eVar) {
            this.f56881e = eVar;
            this.f56878b = eVar.f56875a.iterator();
        }

        public final void a() {
            while (this.f56878b.hasNext()) {
                T next = this.f56878b.next();
                if (((Boolean) this.f56881e.f56877c.invoke(next)).booleanValue() == this.f56881e.f56876b) {
                    this.f56880d = next;
                    this.f56879c = 1;
                    return;
                }
            }
            this.f56879c = 0;
        }

        public boolean hasNext() {
            if (this.f56879c == -1) {
                a();
            }
            return this.f56879c == 1;
        }

        public T next() {
            if (this.f56879c == -1) {
                a();
            }
            if (this.f56879c != 0) {
                T t11 = this.f56880d;
                this.f56880d = null;
                this.f56879c = -1;
                return t11;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(g<? extends T> gVar, boolean z11, l<? super T, Boolean> lVar) {
        this.f56875a = gVar;
        this.f56876b = z11;
        this.f56877c = lVar;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
