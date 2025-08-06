package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref$ObjectRef;

public final class DistinctFlowImpl$collect$2<T> implements e {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl<T> f57125b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Object> f57126c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e<T> f57127d;

    public DistinctFlowImpl$collect$2(DistinctFlowImpl<T> distinctFlowImpl, Ref$ObjectRef<Object> ref$ObjectRef, e<? super T> eVar) {
        this.f57125b = distinctFlowImpl;
        this.f57126c = ref$ObjectRef;
        this.f57127d = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(T r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)
            goto L_0x0067
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.k.b(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r7 = r5.f57125b
            d10.l<T, java.lang.Object> r7 = r7.f57123c
            java.lang.Object r7 = r7.invoke(r6)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f57126c
            T r2 = r2.element
            kotlinx.coroutines.internal.c0 r4 = kotlinx.coroutines.flow.internal.k.f57265a
            if (r2 == r4) goto L_0x0058
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r4 = r5.f57125b
            d10.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.f57124d
            java.lang.Object r2 = r4.invoke(r2, r7)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0055
            goto L_0x0058
        L_0x0055:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        L_0x0058:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f57126c
            r2.element = r7
            kotlinx.coroutines.flow.e<T> r7 = r5.f57127d
            r0.label = r3
            java.lang.Object r6 = r7.emit(r6, r0)
            if (r6 != r1) goto L_0x0067
            return r1
        L_0x0067:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
