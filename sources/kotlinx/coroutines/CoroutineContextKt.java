package kotlinx.coroutines;

import com.sumsub.sns.internal.core.common.n0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CoroutineContextKt {
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z11) {
        boolean c11 = c(coroutineContext);
        boolean c12 = c(coroutineContext2);
        if (!c11 && !c12) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new CoroutineContextKt$foldCopies$folded$1(ref$ObjectRef, z11));
        if (c12) {
            ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).fold(emptyCoroutineContext, CoroutineContextKt$foldCopies$1.INSTANCE);
        }
        return coroutineContext3.plus((CoroutineContext) ref$ObjectRef.element);
    }

    public static final String b(CoroutineContext coroutineContext) {
        f0 f0Var;
        String str;
        if (!j0.c() || (f0Var = (f0) coroutineContext.get(f0.f57119c)) == null) {
            return null;
        }
        g0 g0Var = (g0) coroutineContext.get(g0.f57275c);
        if (g0Var == null || (str = g0Var.w()) == null) {
            str = "coroutine";
        }
        return str + n0.h.f32179b + f0Var.w();
    }

    public static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        if (!c(coroutineContext2)) {
            return coroutineContext.plus(coroutineContext2);
        }
        return a(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext e(h0 h0Var, CoroutineContext coroutineContext) {
        CoroutineContext a11 = a(h0Var.getCoroutineContext(), coroutineContext, true);
        CoroutineContext plus = j0.c() ? a11.plus(new f0(j0.b().incrementAndGet())) : a11;
        return (a11 == v0.a() || a11.get(d.f56672p0) != null) ? plus : plus.plus(v0.a());
    }

    public static final o2<?> f(c cVar) {
        while (!(cVar instanceof r0) && (cVar = cVar.getCallerFrame()) != null) {
            if (cVar instanceof o2) {
                return (o2) cVar;
            }
        }
        return null;
    }

    public static final o2<?> g(kotlin.coroutines.c<?> cVar, CoroutineContext coroutineContext, Object obj) {
        if (!(cVar instanceof c)) {
            return null;
        }
        if (!(coroutineContext.get(p2.f57389b) != null)) {
            return null;
        }
        o2<?> f11 = f((c) cVar);
        if (f11 != null) {
            f11.g1(coroutineContext, obj);
        }
        return f11;
    }
}
