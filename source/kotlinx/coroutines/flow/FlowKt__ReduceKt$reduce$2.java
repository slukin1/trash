package kotlinx.coroutines.flow;

import d10.q;
import kotlin.coroutines.c;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class FlowKt__ReduceKt$reduce$2<T> implements e {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Object> f57167b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q<S, T, c<? super S>, Object> f57168c;

    public FlowKt__ReduceKt$reduce$2(Ref$ObjectRef<Object> ref$ObjectRef, q<? super S, ? super T, ? super c<? super S>, ? extends Object> qVar) {
        this.f57167b = ref$ObjectRef;
        this.f57168c = qVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(T r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            kotlin.k.b(r8)
            goto L_0x0050
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            kotlin.k.b(r8)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r8 = r6.f57167b
            T r2 = r8.element
            kotlinx.coroutines.internal.c0 r4 = kotlinx.coroutines.flow.internal.k.f57265a
            if (r2 == r4) goto L_0x0053
            d10.q<S, T, kotlin.coroutines.c<? super S>, java.lang.Object> r4 = r6.f57168c
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r4.invoke(r2, r7, r0)
            if (r7 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0050:
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0053:
            r8.element = r7
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
