package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;

public final class SemaphoreKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f57558a = f0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f57559b = new c0("PERMIT");

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f57560c = new c0("TAKEN");

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f57561d = new c0("BROKEN");

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f57562e = new c0("CANCELLED");

    /* renamed from: f  reason: collision with root package name */
    public static final int f57563f = f0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    public static final b a(int i11, int i12) {
        return new SemaphoreImpl(i11, i12);
    }

    public static final c i(long j11, c cVar) {
        return new c(j11, cVar, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: d10.a<? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object j(kotlinx.coroutines.sync.b r4, d10.a<? extends T> r5, kotlin.coroutines.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            d10.a r5 = (d10.a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.b r4 = (kotlinx.coroutines.sync.b) r4
            kotlin.k.b(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.k.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.c(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.Object r5 = r5.invoke()     // Catch:{ all -> 0x0058 }
            kotlin.jvm.internal.InlineMarker.b(r3)
            r4.release()
            kotlin.jvm.internal.InlineMarker.a(r3)
            return r5
        L_0x0058:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r3)
            r4.release()
            kotlin.jvm.internal.InlineMarker.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.j(kotlinx.coroutines.sync.b, d10.a, kotlin.coroutines.c):java.lang.Object");
    }
}
