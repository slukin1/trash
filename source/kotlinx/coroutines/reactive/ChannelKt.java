package kotlinx.coroutines.reactive;

import kotlinx.coroutines.channels.ReceiveChannel;
import z20.b;

public final class ChannelKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object a(z20.b<T> r6, d10.l<? super T, kotlin.Unit> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.reactive.ChannelKt$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.reactive.ChannelKt$collect$1 r0 = (kotlinx.coroutines.reactive.ChannelKt$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.ChannelKt$collect$1 r0 = new kotlinx.coroutines.reactive.ChannelKt$collect$1
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
            goto L_0x0067
        L_0x003b:
            r6 = move-exception
            goto L_0x0090
        L_0x003d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0045:
            kotlin.k.b(r8)
            r8 = 0
            kotlinx.coroutines.channels.ReceiveChannel r6 = c(r6, r8, r4, r3)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x008c }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0054:
            r0.L$0 = r7     // Catch:{ all -> 0x0089 }
            r0.L$1 = r8     // Catch:{ all -> 0x0089 }
            r0.L$2 = r6     // Catch:{ all -> 0x0089 }
            r0.label = r4     // Catch:{ all -> 0x0089 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0089 }
            if (r2 != r1) goto L_0x0063
            return r1
        L_0x0063:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0038
        L_0x0067:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0086 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0086 }
            if (r8 == 0) goto L_0x007a
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0086 }
            r7.invoke(r8)     // Catch:{ all -> 0x0086 }
            r8 = r0
            r0 = r1
            r1 = r2
            goto L_0x0054
        L_0x007a:
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0086 }
            kotlin.jvm.internal.InlineMarker.b(r4)
            kotlinx.coroutines.channels.h.b(r0, r3)
            kotlin.jvm.internal.InlineMarker.a(r4)
            return r6
        L_0x0086:
            r6 = move-exception
            r7 = r0
            goto L_0x0090
        L_0x0089:
            r6 = move-exception
            r7 = r8
            goto L_0x0090
        L_0x008c:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0090:
            throw r6     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r4)
            kotlinx.coroutines.channels.h.b(r7, r6)
            kotlin.jvm.internal.InlineMarker.a(r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.ChannelKt.a(z20.b, d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> ReceiveChannel<T> b(b<T> bVar, int i11) {
        f fVar = new f(i11);
        bVar.subscribe(fVar);
        return fVar;
    }

    public static /* synthetic */ ReceiveChannel c(b bVar, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 1;
        }
        return b(bVar, i11);
    }
}
