package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlinx.coroutines.scheduling.Task;

public abstract class s0<T> extends Task {

    /* renamed from: d  reason: collision with root package name */
    public int f57458d;

    public s0(int i11) {
        this.f57458d = i11;
    }

    public void d(Object obj, Throwable th2) {
    }

    public abstract c<T> e();

    public Throwable f(Object obj) {
        y yVar = obj instanceof y ? (y) obj : null;
        if (yVar != null) {
            return yVar.f57583a;
        }
        return null;
    }

    public <T> T g(Object obj) {
        return obj;
    }

    public final void i(Throwable th2, Throwable th3) {
        if (th2 != null || th3 != null) {
            if (!(th2 == null || th3 == null)) {
                ExceptionsKt__ExceptionsKt.a(th2, th3);
            }
            if (th2 == null) {
                th2 = th3;
            }
            e0.a(e().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
        }
    }

    public abstract Object j();

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00aa, code lost:
        if (r4.f1() != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d3, code lost:
        if (r4.f1() != false) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            boolean r0 = kotlinx.coroutines.j0.a()
            if (r0 == 0) goto L_0x0017
            int r0 = r10.f57458d
            r1 = -1
            if (r0 == r1) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0017:
            g10.d r0 = r10.f57494c
            kotlin.coroutines.c r1 = r10.e()     // Catch:{ all -> 0x00d9 }
            kotlinx.coroutines.internal.i r1 = (kotlinx.coroutines.internal.i) r1     // Catch:{ all -> 0x00d9 }
            kotlin.coroutines.c<T> r2 = r1.f57311f     // Catch:{ all -> 0x00d9 }
            java.lang.Object r1 = r1.f57313h     // Catch:{ all -> 0x00d9 }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r1)     // Catch:{ all -> 0x00d9 }
            kotlinx.coroutines.internal.c0 r4 = kotlinx.coroutines.internal.ThreadContextKt.f57289a     // Catch:{ all -> 0x00d9 }
            r5 = 0
            if (r1 == r4) goto L_0x0035
            kotlinx.coroutines.o2 r4 = kotlinx.coroutines.CoroutineContextKt.g(r2, r3, r1)     // Catch:{ all -> 0x00d9 }
            goto L_0x0036
        L_0x0035:
            r4 = r5
        L_0x0036:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x00cc }
            java.lang.Object r7 = r10.j()     // Catch:{ all -> 0x00cc }
            java.lang.Throwable r8 = r10.f(r7)     // Catch:{ all -> 0x00cc }
            if (r8 != 0) goto L_0x0055
            int r9 = r10.f57458d     // Catch:{ all -> 0x00cc }
            boolean r9 = kotlinx.coroutines.t0.b(r9)     // Catch:{ all -> 0x00cc }
            if (r9 == 0) goto L_0x0055
            kotlinx.coroutines.n1$b r9 = kotlinx.coroutines.n1.f57382r0     // Catch:{ all -> 0x00cc }
            kotlin.coroutines.CoroutineContext$a r6 = r6.get(r9)     // Catch:{ all -> 0x00cc }
            kotlinx.coroutines.n1 r6 = (kotlinx.coroutines.n1) r6     // Catch:{ all -> 0x00cc }
            goto L_0x0056
        L_0x0055:
            r6 = r5
        L_0x0056:
            if (r6 == 0) goto L_0x0085
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x00cc }
            if (r9 != 0) goto L_0x0085
            java.util.concurrent.CancellationException r6 = r6.A()     // Catch:{ all -> 0x00cc }
            r10.d(r7, r6)     // Catch:{ all -> 0x00cc }
            kotlin.Result$a r7 = kotlin.Result.Companion     // Catch:{ all -> 0x00cc }
            boolean r7 = kotlinx.coroutines.j0.d()     // Catch:{ all -> 0x00cc }
            if (r7 == 0) goto L_0x0079
            boolean r7 = r2 instanceof kotlin.coroutines.jvm.internal.c     // Catch:{ all -> 0x00cc }
            if (r7 != 0) goto L_0x0072
            goto L_0x0079
        L_0x0072:
            r7 = r2
            kotlin.coroutines.jvm.internal.c r7 = (kotlin.coroutines.jvm.internal.c) r7     // Catch:{ all -> 0x00cc }
            java.lang.Throwable r6 = kotlinx.coroutines.internal.b0.i(r6, r7)     // Catch:{ all -> 0x00cc }
        L_0x0079:
            java.lang.Object r6 = kotlin.k.a(r6)     // Catch:{ all -> 0x00cc }
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)     // Catch:{ all -> 0x00cc }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x0085:
            if (r8 == 0) goto L_0x0095
            kotlin.Result$a r6 = kotlin.Result.Companion     // Catch:{ all -> 0x00cc }
            java.lang.Object r6 = kotlin.k.a(r8)     // Catch:{ all -> 0x00cc }
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)     // Catch:{ all -> 0x00cc }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x0095:
            kotlin.Result$a r6 = kotlin.Result.Companion     // Catch:{ all -> 0x00cc }
            java.lang.Object r6 = r10.g(r7)     // Catch:{ all -> 0x00cc }
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)     // Catch:{ all -> 0x00cc }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00cc }
        L_0x00a2:
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00cc }
            if (r4 == 0) goto L_0x00ac
            boolean r4 = r4.f1()     // Catch:{ all -> 0x00d9 }
            if (r4 == 0) goto L_0x00af
        L_0x00ac:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x00d9 }
        L_0x00af:
            kotlin.Result$a r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00b9 }
            r0.a()     // Catch:{ all -> 0x00b9 }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r2)     // Catch:{ all -> 0x00b9 }
            goto L_0x00c4
        L_0x00b9:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.k.a(r0)
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)
        L_0x00c4:
            java.lang.Throwable r0 = kotlin.Result.m3075exceptionOrNullimpl(r0)
            r10.i(r5, r0)
            goto L_0x00f8
        L_0x00cc:
            r2 = move-exception
            if (r4 == 0) goto L_0x00d5
            boolean r4 = r4.f1()     // Catch:{ all -> 0x00d9 }
            if (r4 == 0) goto L_0x00d8
        L_0x00d5:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x00d9 }
        L_0x00d8:
            throw r2     // Catch:{ all -> 0x00d9 }
        L_0x00d9:
            r1 = move-exception
            kotlin.Result$a r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00e6 }
            r0.a()     // Catch:{ all -> 0x00e6 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00e6 }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ all -> 0x00e6 }
            goto L_0x00f1
        L_0x00e6:
            r0 = move-exception
            kotlin.Result$a r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.k.a(r0)
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)
        L_0x00f1:
            java.lang.Throwable r0 = kotlin.Result.m3075exceptionOrNullimpl(r0)
            r10.i(r1, r0)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.s0.run():void");
    }
}
