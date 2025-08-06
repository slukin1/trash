package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.a;
import kotlin.coroutines.b;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.o;

public abstract class CoroutineDispatcher extends a implements d {

    /* renamed from: b  reason: collision with root package name */
    public static final Key f56941b = new Key((r) null);

    public static final class Key extends b<d, CoroutineDispatcher> {
        public Key() {
            super(d.f56672p0, AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Key(r rVar) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(d.f56672p0);
    }

    public boolean B(CoroutineContext coroutineContext) {
        return true;
    }

    public CoroutineDispatcher D(int i11) {
        o.a(i11);
        return new n(this, i11);
    }

    public final void e(c<?> cVar) {
        ((i) cVar).r();
    }

    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return d.a.a(this, bVar);
    }

    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return d.a.b(this, bVar);
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this);
    }

    public abstract void w(CoroutineContext coroutineContext, Runnable runnable);

    public void x(CoroutineContext coroutineContext, Runnable runnable) {
        w(coroutineContext, runnable);
    }

    public final <T> c<T> y(c<? super T> cVar) {
        return new i(this, cVar);
    }
}
