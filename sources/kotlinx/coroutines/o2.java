package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.l;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.y;

public final class o2<T> extends y<T> {

    /* renamed from: f  reason: collision with root package name */
    public final ThreadLocal<Pair<CoroutineContext, Object>> f57387f;
    private volatile boolean threadLocalIsSet;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o2(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.c<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.p2 r0 = kotlinx.coroutines.p2.f57389b
            kotlin.coroutines.CoroutineContext$a r1 = r3.get(r0)
            if (r1 != 0) goto L_0x000d
            kotlin.coroutines.CoroutineContext r0 = r3.plus(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r3
        L_0x000e:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f57387f = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.d$b r0 = kotlin.coroutines.d.f56672p0
            kotlin.coroutines.CoroutineContext$a r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L_0x0031
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r4)
            r2.g1(r3, r4)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.o2.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.c):void");
    }

    public void b1(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = this.f57387f.get();
            if (pair != null) {
                ThreadContextKt.a((CoroutineContext) pair.component1(), pair.component2());
            }
            this.f57387f.remove();
        }
        Object a11 = a0.a(obj, this.f57351e);
        c<T> cVar = this.f57351e;
        CoroutineContext context = cVar.getContext();
        o2<?> o2Var = null;
        Object c11 = ThreadContextKt.c(context, o2Var);
        if (c11 != ThreadContextKt.f57289a) {
            o2Var = CoroutineContextKt.g(cVar, context, c11);
        }
        try {
            this.f57351e.resumeWith(a11);
            Unit unit = Unit.f56620a;
        } finally {
            if (o2Var == null || o2Var.f1()) {
                ThreadContextKt.a(context, c11);
            }
        }
    }

    public final boolean f1() {
        boolean z11 = this.threadLocalIsSet && this.f57387f.get() == null;
        this.f57387f.remove();
        return !z11;
    }

    public final void g1(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f57387f.set(l.a(coroutineContext, obj));
    }
}
