package kotlinx.coroutines;

import d10.l;
import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;

public abstract class a<T> extends JobSupport implements c<T>, h0 {

    /* renamed from: d  reason: collision with root package name */
    public final CoroutineContext f56976d;

    public a(CoroutineContext coroutineContext, boolean z11, boolean z12) {
        super(z12);
        if (z11) {
            v0((n1) coroutineContext.get(n1.f57382r0));
        }
        this.f56976d = coroutineContext.plus(this);
    }

    public String D0() {
        String b11 = CoroutineContextKt.b(this.f56976d);
        if (b11 == null) {
            return super.D0();
        }
        return '\"' + b11 + "\":" + super.D0();
    }

    public final void K0(Object obj) {
        if (obj instanceof y) {
            y yVar = (y) obj;
            c1(yVar.f57583a, yVar.a());
            return;
        }
        d1(obj);
    }

    public void b1(Object obj) {
        U(obj);
    }

    public String c0() {
        return k0.a(this) + " was cancelled";
    }

    public void c1(Throwable th2, boolean z11) {
    }

    public void d1(T t11) {
    }

    public final <R> void e1(CoroutineStart coroutineStart, R r11, p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        coroutineStart.invoke(pVar, r11, this);
    }

    public final CoroutineContext getContext() {
        return this.f56976d;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f56976d;
    }

    public boolean isActive() {
        return super.isActive();
    }

    public final void resumeWith(Object obj) {
        Object B0 = B0(a0.d(obj, (l) null, 1, (Object) null));
        if (B0 != s1.f57460b) {
            b1(B0);
        }
    }

    public final void u0(Throwable th2) {
        e0.a(this.f56976d, th2);
    }
}
