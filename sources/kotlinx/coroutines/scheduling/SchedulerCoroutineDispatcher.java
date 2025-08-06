package kotlinx.coroutines.scheduling;

import g10.d;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    /* renamed from: d  reason: collision with root package name */
    public final int f57488d;

    /* renamed from: e  reason: collision with root package name */
    public final int f57489e;

    /* renamed from: f  reason: collision with root package name */
    public final long f57490f;

    /* renamed from: g  reason: collision with root package name */
    public final String f57491g;

    /* renamed from: h  reason: collision with root package name */
    public CoroutineScheduler f57492h;

    public SchedulerCoroutineDispatcher() {
        this(0, 0, 0, (String) null, 15, (r) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SchedulerCoroutineDispatcher(int r4, int r5, long r6, java.lang.String r8, int r9, kotlin.jvm.internal.r r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            int r4 = g10.g.f54783c
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            int r5 = g10.g.f54784d
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            long r6 = g10.g.f54785e
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            java.lang.String r8 = "CoroutineScheduler"
        L_0x001a:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher.<init>(int, int, long, java.lang.String, int, kotlin.jvm.internal.r):void");
    }

    public final CoroutineScheduler G() {
        return new CoroutineScheduler(this.f57488d, this.f57489e, this.f57490f, this.f57491g);
    }

    public final void H(Runnable runnable, d dVar, boolean z11) {
        this.f57492h.j(runnable, dVar, z11);
    }

    public void close() {
        this.f57492h.close();
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.k(this.f57492h, runnable, (d) null, false, 6, (Object) null);
    }

    public void x(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.k(this.f57492h, runnable, (d) null, true, 2, (Object) null);
    }

    public SchedulerCoroutineDispatcher(int i11, int i12, long j11, String str) {
        this.f57488d = i11;
        this.f57489e = i12;
        this.f57490f = j11;
        this.f57491g = str;
        this.f57492h = G();
    }
}
