package kotlin.coroutines.intrinsics;

import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.f;

class IntrinsicsKt__IntrinsicsJvmKt {
    public static <T> c<Unit> a(l<? super c<? super T>, ? extends Object> lVar, c<? super T> cVar) {
        c<? super T> a11 = f.a(cVar);
        if (lVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) lVar).create(a11);
        }
        CoroutineContext context = a11.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(a11, lVar);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(a11, context, lVar);
    }

    public static <R, T> c<Unit> b(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r11, c<? super T> cVar) {
        c<? super T> a11 = f.a(cVar);
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).create(r11, a11);
        }
        CoroutineContext context = a11.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(a11, pVar, r11);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(a11, context, pVar, r11);
    }

    public static <T> c<T> c(c<? super T> cVar) {
        c<Object> intercepted;
        ContinuationImpl continuationImpl = cVar instanceof ContinuationImpl ? (ContinuationImpl) cVar : null;
        return (continuationImpl == null || (intercepted = continuationImpl.intercepted()) == null) ? cVar : intercepted;
    }
}
