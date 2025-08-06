package kotlinx.coroutines.flow;

import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;

public final class SubscribedSharedFlow<T> implements f1<T> {

    /* renamed from: b  reason: collision with root package name */
    public final f1<T> f57212b;

    /* renamed from: c  reason: collision with root package name */
    public final p<e<? super T>, c<? super Unit>, Object> f57213c;

    public SubscribedSharedFlow(f1<? extends T> f1Var, p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        this.f57212b = f1Var;
        this.f57213c = pVar;
    }

    public List<T> a() {
        return this.f57212b.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.e<? super T> r6, kotlin.coroutines.c<?> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 r0 = (kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 r0 = new kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002d:
            kotlin.k.b(r7)
            goto L_0x0046
        L_0x0031:
            kotlin.k.b(r7)
            kotlinx.coroutines.flow.f1<T> r7 = r5.f57212b
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = new kotlinx.coroutines.flow.SubscribedFlowCollector
            d10.p<kotlinx.coroutines.flow.e<? super T>, kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r4 = r5.f57213c
            r2.<init>(r6, r4)
            r0.label = r3
            java.lang.Object r6 = r7.collect(r2, r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedSharedFlow.collect(kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }
}
