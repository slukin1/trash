package kotlinx.coroutines;

import d10.l;
import d10.p;
import f10.a;
import f10.b;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.y;

public final /* synthetic */ class i {
    public static final <T> n0<T> a(h0 h0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, p<? super h0, ? super c<? super T>, ? extends Object> pVar) {
        o0 o0Var;
        CoroutineContext e11 = CoroutineContextKt.e(h0Var, coroutineContext);
        if (coroutineStart.isLazy()) {
            o0Var = new t1(e11, pVar);
        } else {
            o0Var = new o0(e11, true);
        }
        o0Var.e1(coroutineStart, o0Var, pVar);
        return o0Var;
    }

    public static /* synthetic */ n0 b(h0 h0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return g.a(h0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final n1 c(h0 h0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, p<? super h0, ? super c<? super Unit>, ? extends Object> pVar) {
        a aVar;
        CoroutineContext e11 = CoroutineContextKt.e(h0Var, coroutineContext);
        if (coroutineStart.isLazy()) {
            aVar = new u1(e11, pVar);
        } else {
            aVar = new c2(e11, true);
        }
        aVar.e1(coroutineStart, aVar, pVar);
        return aVar;
    }

    public static /* synthetic */ n1 d(h0 h0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return g.c(h0Var, coroutineContext, coroutineStart, pVar);
    }

    /* JADX INFO: finally extract failed */
    public static final <T> Object e(CoroutineContext coroutineContext, p<? super h0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        Object obj;
        CoroutineContext context = cVar.getContext();
        CoroutineContext d11 = CoroutineContextKt.d(context, coroutineContext);
        p1.i(d11);
        if (d11 == context) {
            y yVar = new y(d11, cVar);
            obj = b.c(yVar, yVar, pVar);
        } else {
            d.b bVar = d.f56672p0;
            if (x.b(d11.get(bVar), context.get(bVar))) {
                o2 o2Var = new o2(d11, cVar);
                CoroutineContext context2 = o2Var.getContext();
                Object c11 = ThreadContextKt.c(context2, (Object) null);
                try {
                    Object c12 = b.c(o2Var, o2Var, pVar);
                    ThreadContextKt.a(context2, c11);
                    obj = c12;
                } catch (Throwable th2) {
                    ThreadContextKt.a(context2, c11);
                    throw th2;
                }
            } else {
                r0 r0Var = new r0(d11, cVar);
                a.e(pVar, r0Var, r0Var, (l) null, 4, (Object) null);
                obj = r0Var.f1();
            }
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return obj;
    }
}
