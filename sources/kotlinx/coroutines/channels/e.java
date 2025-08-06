package kotlinx.coroutines.channels;

import d10.l;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.a;
import kotlinx.coroutines.selects.f;
import kotlinx.coroutines.selects.h;

public class e<E> extends a<Unit> implements d<E> {

    /* renamed from: e  reason: collision with root package name */
    public final d<E> f57048e;

    public e(CoroutineContext coroutineContext, d<E> dVar, boolean z11, boolean z12) {
        super(coroutineContext, z11, z12);
        this.f57048e = dVar;
    }

    public f<E> G() {
        return this.f57048e.G();
    }

    public void H(l<? super Throwable, Unit> lVar) {
        this.f57048e.H(lVar);
    }

    public Object J(c<? super E> cVar) {
        return this.f57048e.J(cVar);
    }

    public boolean K(Throwable th2) {
        return this.f57048e.K(th2);
    }

    public void Z(Throwable th2) {
        CancellationException U0 = JobSupport.U0(this, th2, (String) null, 1, (Object) null);
        this.f57048e.b(U0);
        X(U0);
    }

    public final void b(CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new JobCancellationException(c0(), (Throwable) null, this);
            }
            Z(cancellationException);
        }
    }

    public h<E, m<E>> d() {
        return this.f57048e.d();
    }

    public final d<E> f1() {
        return this;
    }

    public final d<E> g1() {
        return this.f57048e;
    }

    public ChannelIterator<E> iterator() {
        return this.f57048e.iterator();
    }

    public Object q(E e11) {
        return this.f57048e.q(e11);
    }

    public f<ChannelResult<E>> r() {
        return this.f57048e.r();
    }

    public Object s() {
        return this.f57048e.s();
    }

    public Object send(E e11, c<? super Unit> cVar) {
        return this.f57048e.send(e11, cVar);
    }

    public Object t(c<? super ChannelResult<? extends E>> cVar) {
        Object t11 = this.f57048e.t(cVar);
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        return t11;
    }

    public boolean u() {
        return this.f57048e.u();
    }
}
