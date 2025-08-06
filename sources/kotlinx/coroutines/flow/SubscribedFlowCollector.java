package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;

public final class SubscribedFlowCollector<T> implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    public final e<T> f57210b;

    /* renamed from: c  reason: collision with root package name */
    public final p<e<? super T>, c<? super Unit>, Object> f57211c;

    public SubscribedFlowCollector(e<? super T> eVar, p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        this.f57210b = eVar;
        this.f57211c = pVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r7)
            goto L_0x0077
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0034:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.internal.SafeCollector r2 = (kotlinx.coroutines.flow.internal.SafeCollector) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.SubscribedFlowCollector r4 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r4
            kotlin.k.b(r7)     // Catch:{ all -> 0x007d }
            goto L_0x005e
        L_0x0040:
            kotlin.k.b(r7)
            kotlinx.coroutines.flow.internal.SafeCollector r2 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlinx.coroutines.flow.e<T> r7 = r6.f57210b
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            r2.<init>(r7, r5)
            d10.p<kotlinx.coroutines.flow.e<? super T>, kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r7 = r6.f57211c     // Catch:{ all -> 0x007d }
            r0.L$0 = r6     // Catch:{ all -> 0x007d }
            r0.L$1 = r2     // Catch:{ all -> 0x007d }
            r0.label = r4     // Catch:{ all -> 0x007d }
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch:{ all -> 0x007d }
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r4 = r6
        L_0x005e:
            r2.releaseIntercepted()
            kotlinx.coroutines.flow.e<T> r7 = r4.f57210b
            boolean r2 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector
            if (r2 == 0) goto L_0x007a
            kotlinx.coroutines.flow.SubscribedFlowCollector r7 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r7
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L_0x0077
            return r1
        L_0x0077:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        L_0x007a:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        L_0x007d:
            r7 = move-exception
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.a(kotlin.coroutines.c):java.lang.Object");
    }

    public Object emit(T t11, c<? super Unit> cVar) {
        return this.f57210b.emit(t11, cVar);
    }
}
