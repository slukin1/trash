package kotlinx.coroutines.flow;

import d10.p;
import kotlin.coroutines.c;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class FlowKt__LimitKt$dropWhile$1$1<T> implements e {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f57151b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e<T> f57152c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ p<T, c<? super Boolean>, Object> f57153d;

    public FlowKt__LimitKt$dropWhile$1$1(Ref$BooleanRef ref$BooleanRef, e<? super T> eVar, p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        this.f57151b = ref$BooleanRef;
        this.f57152c = eVar;
        this.f57153d = pVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(T r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r5) goto L_0x0041
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.k.b(r8)
            goto L_0x0088
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            java.lang.Object r7 = r0.L$1
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1) r2
            kotlin.k.b(r8)
            goto L_0x006c
        L_0x0041:
            kotlin.k.b(r8)
            goto L_0x0059
        L_0x0045:
            kotlin.k.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f57151b
            boolean r8 = r8.element
            if (r8 == 0) goto L_0x005c
            kotlinx.coroutines.flow.e<T> r8 = r6.f57152c
            r0.label = r5
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L_0x0059
            return r1
        L_0x0059:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        L_0x005c:
            d10.p<T, kotlin.coroutines.c<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f57153d
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r2 = r6
        L_0x006c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x008b
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.f57151b
            r8.element = r5
            kotlinx.coroutines.flow.e<T> r8 = r2.f57152c
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L_0x0088
            return r1
        L_0x0088:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        L_0x008b:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
