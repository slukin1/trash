package kotlinx.coroutines.flow;

import d10.p;
import d10.r;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", l = {95}, m = "invokeSuspend")
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements r<e<Object>, Throwable, Long, c<? super Boolean>, Object> {
    public final /* synthetic */ p<Throwable, c<? super Boolean>, Object> $predicate;
    public final /* synthetic */ long $retries;
    public /* synthetic */ long J$0;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$retry$3(long j11, p<? super Throwable, ? super c<? super Boolean>, ? extends Object> pVar, c<? super FlowKt__ErrorsKt$retry$3> cVar) {
        super(4, cVar);
        this.$retries = j11;
        this.$predicate = pVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((e<Object>) (e) obj, (Throwable) obj2, ((Number) obj3).longValue(), (c<? super Boolean>) (c) obj4);
    }

    public final Object invoke(e<Object> eVar, Throwable th2, long j11, c<? super Boolean> cVar) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, cVar);
        flowKt__ErrorsKt$retry$3.L$0 = th2;
        flowKt__ErrorsKt$retry$3.J$0 = j11;
        return flowKt__ErrorsKt$retry$3.invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.k.b(r8)
            goto L_0x0031
        L_0x000f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0017:
            kotlin.k.b(r8)
            java.lang.Object r8 = r7.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            long r3 = r7.J$0
            long r5 = r7.$retries
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x003a
            d10.p<java.lang.Throwable, kotlin.coroutines.c<? super java.lang.Boolean>, java.lang.Object> r1 = r7.$predicate
            r7.label = r2
            java.lang.Object r8 = r1.invoke(r8, r7)
            if (r8 != r0) goto L_0x0031
            return r0
        L_0x0031:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.a.a(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
