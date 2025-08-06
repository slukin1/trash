package kotlinx.coroutines.rx3;

import d10.l;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.disposables.b;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.x0;

public final class RxSchedulerKt {
    public static final /* synthetic */ i d(Scheduler scheduler) {
        return new i(scheduler);
    }

    public static final b e(h0 h0Var, Runnable runnable, long j11, l<? super l<? super c<? super Unit>, ? extends Object>, ? extends Runnable> lVar) {
        CoroutineContext coroutineContext = h0Var.getCoroutineContext();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        b b11 = a.b(new c(ref$ObjectRef));
        Runnable runnable2 = (Runnable) lVar.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(b11, coroutineContext, o00.a.p(runnable)));
        if (!i0.i(h0Var)) {
            return a.a();
        }
        if (j11 <= 0) {
            runnable2.run();
        } else {
            ref$ObjectRef.element = DelayKt.c(coroutineContext).u(j11, runnable2, coroutineContext);
        }
        return b11;
    }

    public static final void f(Ref$ObjectRef ref$ObjectRef) {
        x0 x0Var = (x0) ref$ObjectRef.element;
        if (x0Var != null) {
            x0Var.dispose();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.coroutines.CoroutineContext} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(io.reactivex.rxjava3.disposables.b r4, kotlin.coroutines.CoroutineContext r5, java.lang.Runnable r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1 r0 = (kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1 r0 = new kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlin.k.b(r7)     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.k.b(r7)
            boolean r4 = r4.isDisposed()
            if (r4 == 0) goto L_0x0042
            kotlin.Unit r4 = kotlin.Unit.f56620a
            return r4
        L_0x0042:
            kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$2 r4 = new kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$2     // Catch:{ all -> 0x0053 }
            r4.<init>(r6)     // Catch:{ all -> 0x0053 }
            r0.L$0 = r5     // Catch:{ all -> 0x0053 }
            r0.label = r3     // Catch:{ all -> 0x0053 }
            r6 = 0
            java.lang.Object r4 = kotlinx.coroutines.InterruptibleKt.c(r6, r4, r0, r3, r6)     // Catch:{ all -> 0x0053 }
            if (r4 != r1) goto L_0x0057
            return r1
        L_0x0053:
            r4 = move-exception
            kotlinx.coroutines.rx3.b.a(r4, r5)
        L_0x0057:
            kotlin.Unit r4 = kotlin.Unit.f56620a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxSchedulerKt.g(io.reactivex.rxjava3.disposables.b, kotlin.coroutines.CoroutineContext, java.lang.Runnable, kotlin.coroutines.c):java.lang.Object");
    }
}
