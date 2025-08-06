package kotlinx.coroutines.internal;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.j0;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f57318a = new c0("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f57319b = new c0("REUSABLE_CLAIMED");

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        if (r8.f1() != false) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void b(kotlin.coroutines.c<? super T> r6, java.lang.Object r7, d10.l<? super java.lang.Throwable, kotlin.Unit> r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.i
            if (r0 == 0) goto L_0x00ba
            kotlinx.coroutines.internal.i r6 = (kotlinx.coroutines.internal.i) r6
            java.lang.Object r8 = kotlinx.coroutines.a0.b(r7, r8)
            kotlinx.coroutines.CoroutineDispatcher r0 = r6.f57310e
            kotlin.coroutines.CoroutineContext r1 = r6.getContext()
            boolean r0 = r0.B(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            r6.f57312g = r8
            r6.f57458d = r1
            kotlinx.coroutines.CoroutineDispatcher r7 = r6.f57310e
            kotlin.coroutines.CoroutineContext r8 = r6.getContext()
            r7.w(r8, r6)
            goto L_0x00bd
        L_0x0026:
            boolean r0 = kotlinx.coroutines.j0.a()
            kotlinx.coroutines.g2 r0 = kotlinx.coroutines.g2.f57278a
            kotlinx.coroutines.EventLoop r0 = r0.b()
            boolean r2 = r0.P()
            if (r2 == 0) goto L_0x003f
            r6.f57312g = r8
            r6.f57458d = r1
            r0.J(r6)
            goto L_0x00bd
        L_0x003f:
            r0.N(r1)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r6.getContext()     // Catch:{ all -> 0x00ad }
            kotlinx.coroutines.n1$b r4 = kotlinx.coroutines.n1.f57382r0     // Catch:{ all -> 0x00ad }
            kotlin.coroutines.CoroutineContext$a r3 = r3.get(r4)     // Catch:{ all -> 0x00ad }
            kotlinx.coroutines.n1 r3 = (kotlinx.coroutines.n1) r3     // Catch:{ all -> 0x00ad }
            if (r3 == 0) goto L_0x006d
            boolean r4 = r3.isActive()     // Catch:{ all -> 0x00ad }
            if (r4 != 0) goto L_0x006d
            java.util.concurrent.CancellationException r3 = r3.A()     // Catch:{ all -> 0x00ad }
            r6.d(r8, r3)     // Catch:{ all -> 0x00ad }
            kotlin.Result$a r8 = kotlin.Result.Companion     // Catch:{ all -> 0x00ad }
            java.lang.Object r8 = kotlin.k.a(r3)     // Catch:{ all -> 0x00ad }
            java.lang.Object r8 = kotlin.Result.m3072constructorimpl(r8)     // Catch:{ all -> 0x00ad }
            r6.resumeWith(r8)     // Catch:{ all -> 0x00ad }
            r8 = r1
            goto L_0x006e
        L_0x006d:
            r8 = 0
        L_0x006e:
            if (r8 != 0) goto L_0x00a6
            kotlin.coroutines.c<T> r8 = r6.f57311f     // Catch:{ all -> 0x00ad }
            java.lang.Object r3 = r6.f57313h     // Catch:{ all -> 0x00ad }
            kotlin.coroutines.CoroutineContext r4 = r8.getContext()     // Catch:{ all -> 0x00ad }
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.c(r4, r3)     // Catch:{ all -> 0x00ad }
            kotlinx.coroutines.internal.c0 r5 = kotlinx.coroutines.internal.ThreadContextKt.f57289a     // Catch:{ all -> 0x00ad }
            if (r3 == r5) goto L_0x0085
            kotlinx.coroutines.o2 r8 = kotlinx.coroutines.CoroutineContextKt.g(r8, r4, r3)     // Catch:{ all -> 0x00ad }
            goto L_0x0086
        L_0x0085:
            r8 = r2
        L_0x0086:
            kotlin.coroutines.c<T> r5 = r6.f57311f     // Catch:{ all -> 0x0099 }
            r5.resumeWith(r7)     // Catch:{ all -> 0x0099 }
            kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0099 }
            if (r8 == 0) goto L_0x0095
            boolean r7 = r8.f1()     // Catch:{ all -> 0x00ad }
            if (r7 == 0) goto L_0x00a6
        L_0x0095:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)     // Catch:{ all -> 0x00ad }
            goto L_0x00a6
        L_0x0099:
            r7 = move-exception
            if (r8 == 0) goto L_0x00a2
            boolean r8 = r8.f1()     // Catch:{ all -> 0x00ad }
            if (r8 == 0) goto L_0x00a5
        L_0x00a2:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)     // Catch:{ all -> 0x00ad }
        L_0x00a5:
            throw r7     // Catch:{ all -> 0x00ad }
        L_0x00a6:
            boolean r7 = r0.S()     // Catch:{ all -> 0x00ad }
            if (r7 != 0) goto L_0x00a6
            goto L_0x00b1
        L_0x00ad:
            r7 = move-exception
            r6.i(r7, r2)     // Catch:{ all -> 0x00b5 }
        L_0x00b1:
            r0.G(r1)
            goto L_0x00bd
        L_0x00b5:
            r6 = move-exception
            r0.G(r1)
            throw r6
        L_0x00ba:
            r6.resumeWith(r7)
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.j.b(kotlin.coroutines.c, java.lang.Object, d10.l):void");
    }

    public static /* synthetic */ void c(c cVar, Object obj, l lVar, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            lVar = null;
        }
        b(cVar, obj, lVar);
    }

    public static final boolean d(i<? super Unit> iVar) {
        Unit unit = Unit.f56620a;
        boolean a11 = j0.a();
        EventLoop b11 = g2.f57278a.b();
        if (b11.Q()) {
            return false;
        }
        if (b11.P()) {
            iVar.f57312g = unit;
            iVar.f57458d = 1;
            b11.J(iVar);
            return true;
        }
        b11.N(true);
        try {
            iVar.run();
            do {
            } while (b11.S());
        } catch (Throwable th2) {
            b11.G(true);
            throw th2;
        }
        b11.G(true);
        return false;
    }
}
