package kotlinx.coroutines.stream;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlinx.coroutines.flow.d;

public final class StreamFlow<T> implements d<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57539c = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");

    /* renamed from: b  reason: collision with root package name */
    public final Stream<T> f57540b;
    private volatile int consumed;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c A[Catch:{ all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.e<? super T> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.stream.StreamFlow$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.stream.StreamFlow$collect$1 r0 = (kotlinx.coroutines.stream.StreamFlow$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.stream.StreamFlow$collect$1 r0 = new kotlinx.coroutines.stream.StreamFlow$collect$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.stream.StreamFlow r4 = (kotlinx.coroutines.stream.StreamFlow) r4
            kotlin.k.b(r8)     // Catch:{ all -> 0x0036 }
            r8 = r2
            goto L_0x0056
        L_0x0036:
            r7 = move-exception
            goto L_0x0079
        L_0x0038:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0040:
            kotlin.k.b(r8)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r8 = f57539c
            r2 = 0
            boolean r8 = r8.compareAndSet(r6, r2, r3)
            if (r8 == 0) goto L_0x007f
            java.util.stream.Stream<T> r8 = r6.f57540b     // Catch:{ all -> 0x0077 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0077 }
            r4 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0056:
            boolean r2 = r7.hasNext()     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x006f
            java.lang.Object r2 = r7.next()     // Catch:{ all -> 0x0036 }
            r0.L$0 = r4     // Catch:{ all -> 0x0036 }
            r0.L$1 = r8     // Catch:{ all -> 0x0036 }
            r0.L$2 = r7     // Catch:{ all -> 0x0036 }
            r0.label = r3     // Catch:{ all -> 0x0036 }
            java.lang.Object r2 = r8.emit(r2, r0)     // Catch:{ all -> 0x0036 }
            if (r2 != r1) goto L_0x0056
            return r1
        L_0x006f:
            java.util.stream.Stream<T> r7 = r4.f57540b
            r7.close()
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        L_0x0077:
            r7 = move-exception
            r4 = r6
        L_0x0079:
            java.util.stream.Stream<T> r8 = r4.f57540b
            r8.close()
            throw r7
        L_0x007f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Stream.consumeAsFlow can be collected only once"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.stream.StreamFlow.collect(kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }
}
