package kotlinx.coroutines.rx3;

import h00.g;
import h00.j;
import kotlinx.coroutines.channels.ReceiveChannel;

public final class RxChannelKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object a(h00.g<T> r6, d10.l<? super T, kotlin.Unit> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.rx3.RxChannelKt$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.rx3.RxChannelKt$collect$1 r0 = (kotlinx.coroutines.rx3.RxChannelKt$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxChannelKt$collect$1 r0 = new kotlinx.coroutines.rx3.RxChannelKt$collect$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            d10.l r2 = (d10.l) r2
            kotlin.k.b(r8)     // Catch:{ all -> 0x003a }
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0037:
            r2 = r1
            r1 = r5
            goto L_0x0065
        L_0x003a:
            r6 = move-exception
            goto L_0x008f
        L_0x003c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0044:
            kotlin.k.b(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = c(r6)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x008b }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0052:
            r0.L$0 = r7     // Catch:{ all -> 0x0088 }
            r0.L$1 = r8     // Catch:{ all -> 0x0088 }
            r0.L$2 = r6     // Catch:{ all -> 0x0088 }
            r0.label = r3     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0088 }
            if (r2 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0037
        L_0x0065:
            r4 = 0
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0085 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0085 }
            if (r8 == 0) goto L_0x0079
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0085 }
            r7.invoke(r8)     // Catch:{ all -> 0x0085 }
            r8 = r0
            r0 = r1
            r1 = r2
            goto L_0x0052
        L_0x0079:
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0085 }
            kotlin.jvm.internal.InlineMarker.b(r3)
            kotlinx.coroutines.channels.h.b(r0, r4)
            kotlin.jvm.internal.InlineMarker.a(r3)
            return r6
        L_0x0085:
            r6 = move-exception
            r7 = r0
            goto L_0x008f
        L_0x0088:
            r6 = move-exception
            r7 = r8
            goto L_0x008f
        L_0x008b:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x008f:
            throw r6     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r3)
            kotlinx.coroutines.channels.h.b(r7, r6)
            kotlin.jvm.internal.InlineMarker.a(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxChannelKt.a(h00.g, d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object b(h00.j<T> r6, d10.l<? super T, kotlin.Unit> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.rx3.RxChannelKt$collect$2
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.rx3.RxChannelKt$collect$2 r0 = (kotlinx.coroutines.rx3.RxChannelKt$collect$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxChannelKt$collect$2 r0 = new kotlinx.coroutines.rx3.RxChannelKt$collect$2
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            d10.l r2 = (d10.l) r2
            kotlin.k.b(r8)     // Catch:{ all -> 0x003a }
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0037:
            r2 = r1
            r1 = r5
            goto L_0x0065
        L_0x003a:
            r6 = move-exception
            goto L_0x008f
        L_0x003c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0044:
            kotlin.k.b(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = d(r6)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x008b }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0052:
            r0.L$0 = r7     // Catch:{ all -> 0x0088 }
            r0.L$1 = r8     // Catch:{ all -> 0x0088 }
            r0.L$2 = r6     // Catch:{ all -> 0x0088 }
            r0.label = r3     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0088 }
            if (r2 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0037
        L_0x0065:
            r4 = 0
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0085 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0085 }
            if (r8 == 0) goto L_0x0079
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0085 }
            r7.invoke(r8)     // Catch:{ all -> 0x0085 }
            r8 = r0
            r0 = r1
            r1 = r2
            goto L_0x0052
        L_0x0079:
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0085 }
            kotlin.jvm.internal.InlineMarker.b(r3)
            kotlinx.coroutines.channels.h.b(r0, r4)
            kotlin.jvm.internal.InlineMarker.a(r3)
            return r6
        L_0x0085:
            r6 = move-exception
            r7 = r0
            goto L_0x008f
        L_0x0088:
            r6 = move-exception
            r7 = r8
            goto L_0x008f
        L_0x008b:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x008f:
            throw r6     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r3)
            kotlinx.coroutines.channels.h.b(r7, r6)
            kotlin.jvm.internal.InlineMarker.a(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxChannelKt.b(h00.j, d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> ReceiveChannel<T> c(g<T> gVar) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        gVar.a(subscriptionChannel);
        return subscriptionChannel;
    }

    public static final <T> ReceiveChannel<T> d(j<T> jVar) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        jVar.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }
}
