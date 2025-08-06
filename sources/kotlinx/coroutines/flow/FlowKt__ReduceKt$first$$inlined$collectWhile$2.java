package kotlinx.coroutines.flow;

import d10.p;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class FlowKt__ReduceKt$first$$inlined$collectWhile$2 implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f57155b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f57156c;

    public FlowKt__ReduceKt$first$$inlined$collectWhile$2(p pVar, Ref$ObjectRef ref$ObjectRef) {
        this.f57155b = pVar;
        this.f57156c = ref$ObjectRef;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(T r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2) r0
            kotlin.k.b(r6)
            goto L_0x0052
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.k.b(r6)
            d10.p r6 = r4.f57155b
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            r2 = 6
            kotlin.jvm.internal.InlineMarker.c(r2)
            java.lang.Object r6 = r6.invoke(r5, r0)
            r0 = 7
            kotlin.jvm.internal.InlineMarker.c(r0)
            if (r6 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r0 = r4
        L_0x0052:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x005f
            kotlin.jvm.internal.Ref$ObjectRef r6 = r0.f57156c
            r6.element = r5
            r3 = 0
        L_0x005f:
            if (r3 == 0) goto L_0x0064
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        L_0x0064:
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
