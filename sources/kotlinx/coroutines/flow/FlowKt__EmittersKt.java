package kotlinx.coroutines.flow;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;

public final /* synthetic */ class FlowKt__EmittersKt {
    public static final void b(e<?> eVar) {
        if (eVar instanceof l1) {
            throw ((l1) eVar).f57273b;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object c(kotlinx.coroutines.flow.e<? super T> r4, d10.q<? super kotlinx.coroutines.flow.e<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.c<? super kotlin.Unit>, ? extends java.lang.Object> r5, java.lang.Throwable r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            kotlin.k.b(r7)     // Catch:{ all -> 0x0047 }
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.k.b(r7)
            r0.L$0 = r6     // Catch:{ all -> 0x0047 }
            r0.label = r3     // Catch:{ all -> 0x0047 }
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch:{ all -> 0x0047 }
            if (r4 != r1) goto L_0x0044
            return r1
        L_0x0044:
            kotlin.Unit r4 = kotlin.Unit.f56620a
            return r4
        L_0x0047:
            r4 = move-exception
            if (r6 == 0) goto L_0x004f
            if (r6 == r4) goto L_0x004f
            kotlin.ExceptionsKt__ExceptionsKt.a(r4, r6)
        L_0x004f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.c(kotlinx.coroutines.flow.e, d10.q, java.lang.Throwable, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> d<T> d(d<? extends T> dVar, q<? super e<? super T>, ? super Throwable, ? super c<? super Unit>, ? extends Object> qVar) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(dVar, qVar);
    }

    public static final <T> d<T> e(d<? extends T> dVar, p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(pVar, dVar);
    }
}
