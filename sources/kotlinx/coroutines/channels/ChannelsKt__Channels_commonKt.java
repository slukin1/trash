package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.d1;

public final /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static final void a(ReceiveChannel<?> receiveChannel, Throwable th2) {
        CancellationException cancellationException = null;
        if (th2 != null) {
            if (th2 instanceof CancellationException) {
                cancellationException = (CancellationException) th2;
            }
            if (cancellationException == null) {
                cancellationException = d1.a("Channel was consumed, consumer had failed", th2);
            }
        }
        receiveChannel.b(cancellationException);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object b(kotlinx.coroutines.channels.b<E> r6, d10.l<? super E, kotlin.Unit> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r4) goto L_0x003d
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            d10.l r2 = (d10.l) r2
            kotlin.k.b(r8)     // Catch:{ all -> 0x003b }
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0038:
            r2 = r1
            r1 = r5
            goto L_0x0066
        L_0x003b:
            r6 = move-exception
            goto L_0x008f
        L_0x003d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0045:
            kotlin.k.b(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = r6.i()
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x008b }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0053:
            r0.L$0 = r7     // Catch:{ all -> 0x0088 }
            r0.L$1 = r8     // Catch:{ all -> 0x0088 }
            r0.L$2 = r6     // Catch:{ all -> 0x0088 }
            r0.label = r4     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0088 }
            if (r2 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0038
        L_0x0066:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0085 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0085 }
            if (r8 == 0) goto L_0x0079
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0085 }
            r7.invoke(r8)     // Catch:{ all -> 0x0085 }
            r8 = r0
            r0 = r1
            r1 = r2
            goto L_0x0053
        L_0x0079:
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0085 }
            kotlin.jvm.internal.InlineMarker.b(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r0, r3, r4, r3)
            kotlin.jvm.internal.InlineMarker.a(r4)
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
            kotlin.jvm.internal.InlineMarker.b(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r7, r3, r4, r3)
            kotlin.jvm.internal.InlineMarker.a(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.b(kotlinx.coroutines.channels.b, d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object c(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r6, d10.l<? super E, kotlin.Unit> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            d10.l r2 = (d10.l) r2
            kotlin.k.b(r8)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r6 = move-exception
            goto L_0x007e
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            kotlin.k.b(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x007a }
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L_0x004a:
            r0.L$0 = r8     // Catch:{ all -> 0x0035 }
            r0.L$1 = r7     // Catch:{ all -> 0x0035 }
            r0.L$2 = r6     // Catch:{ all -> 0x0035 }
            r0.label = r3     // Catch:{ all -> 0x0035 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0035 }
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r5 = r2
            r2 = r8
            r8 = r5
        L_0x005c:
            r4 = 0
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0035 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r8 == 0) goto L_0x006e
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0035 }
            r2.invoke(r8)     // Catch:{ all -> 0x0035 }
            r8 = r2
            goto L_0x004a
        L_0x006e:
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0035 }
            kotlin.jvm.internal.InlineMarker.b(r3)
            kotlinx.coroutines.channels.h.b(r7, r4)
            kotlin.jvm.internal.InlineMarker.a(r3)
            return r6
        L_0x007a:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x007e:
            throw r6     // Catch:{ all -> 0x007f }
        L_0x007f:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r3)
            kotlinx.coroutines.channels.h.b(r7, r6)
            kotlin.jvm.internal.InlineMarker.a(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.c(kotlinx.coroutines.channels.ReceiveChannel, d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object d(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r8, kotlin.coroutines.c<? super java.util.List<? extends E>> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.k.b(r9)     // Catch:{ all -> 0x0039 }
            goto L_0x0067
        L_0x0039:
            r8 = move-exception
            r9 = r2
            goto L_0x0089
        L_0x003c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0044:
            kotlin.k.b(r9)
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsJVMKt.c()
            kotlinx.coroutines.channels.ChannelIterator r2 = r8.iterator()     // Catch:{ all -> 0x0085 }
            r4 = r9
            r5 = r4
            r9 = r8
            r8 = r2
        L_0x0053:
            r0.L$0 = r5     // Catch:{ all -> 0x0083 }
            r0.L$1 = r4     // Catch:{ all -> 0x0083 }
            r0.L$2 = r9     // Catch:{ all -> 0x0083 }
            r0.L$3 = r8     // Catch:{ all -> 0x0083 }
            r0.label = r3     // Catch:{ all -> 0x0083 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x0083 }
            if (r2 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r7 = r2
            r2 = r9
            r9 = r7
        L_0x0067:
            r6 = 0
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0039 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0039 }
            if (r9 == 0) goto L_0x0079
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0039 }
            r4.add(r9)     // Catch:{ all -> 0x0039 }
            r9 = r2
            goto L_0x0053
        L_0x0079:
            kotlin.Unit r8 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0039 }
            kotlinx.coroutines.channels.h.b(r2, r6)
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsJVMKt.a(r5)
            return r8
        L_0x0083:
            r8 = move-exception
            goto L_0x0089
        L_0x0085:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x0089:
            throw r8     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            kotlinx.coroutines.channels.h.b(r9, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.d(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.c):java.lang.Object");
    }
}
