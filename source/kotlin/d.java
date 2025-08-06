package kotlin;

import d10.q;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;

public final class d<T, R> extends c<T, R> implements c<R> {

    /* renamed from: b  reason: collision with root package name */
    public q<? super c<?, ?>, Object, ? super c<Object>, ? extends Object> f56685b;

    /* renamed from: c  reason: collision with root package name */
    public Object f56686c;

    /* renamed from: d  reason: collision with root package name */
    public c<Object> f56687d = this;

    /* renamed from: e  reason: collision with root package name */
    public Object f56688e = b.f56622a;

    public d(q<? super c<T, R>, ? super T, ? super c<? super R>, ? extends Object> qVar, T t11) {
        super((r) null);
        this.f56685b = qVar;
        this.f56686c = t11;
    }

    public Object b(T t11, c<? super R> cVar) {
        this.f56687d = cVar;
        this.f56686c = t11;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        if (d11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return d11;
    }

    public final R d() {
        while (true) {
            R r11 = this.f56688e;
            c<Object> cVar = this.f56687d;
            if (cVar == null) {
                k.b(r11);
                return r11;
            } else if (Result.m3074equalsimpl0(b.f56622a, r11)) {
                try {
                    q<? super c<?, ?>, Object, ? super c<Object>, ? extends Object> qVar = this.f56685b;
                    Object invoke = ((q) TypeIntrinsics.e(qVar, 3)).invoke(this, this.f56686c, cVar);
                    if (invoke != IntrinsicsKt__IntrinsicsKt.d()) {
                        Result.a aVar = Result.Companion;
                        cVar.resumeWith(Result.m3072constructorimpl(invoke));
                    }
                } catch (Throwable th2) {
                    Result.a aVar2 = Result.Companion;
                    cVar.resumeWith(Result.m3072constructorimpl(k.a(th2)));
                }
            } else {
                this.f56688e = b.f56622a;
                cVar.resumeWith(r11);
            }
        }
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public void resumeWith(Object obj) {
        this.f56687d = null;
        this.f56688e = obj;
    }
}
