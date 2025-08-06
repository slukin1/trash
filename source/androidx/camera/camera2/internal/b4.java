package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import p.l;
import r.f;
import r.g;
import r.o;

public final class b4 {

    /* renamed from: a  reason: collision with root package name */
    public final b f5026a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Executor f5027a;

        /* renamed from: b  reason: collision with root package name */
        public final ScheduledExecutorService f5028b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f5029c;

        /* renamed from: d  reason: collision with root package name */
        public final e2 f5030d;

        /* renamed from: e  reason: collision with root package name */
        public final Quirks f5031e;

        /* renamed from: f  reason: collision with root package name */
        public final Quirks f5032f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f5033g;

        public a(Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler, e2 e2Var, Quirks quirks, Quirks quirks2) {
            this.f5027a = executor;
            this.f5028b = scheduledExecutorService;
            this.f5029c = handler;
            this.f5030d = e2Var;
            this.f5031e = quirks;
            this.f5032f = quirks2;
            this.f5033g = new g(quirks, quirks2).b() || new o(quirks).i() || new f(quirks2).d();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.camera.camera2.internal.a4} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.camera.camera2.internal.v3} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.camera.camera2.internal.a4} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.camera.camera2.internal.a4} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.camera.camera2.internal.b4 a() {
            /*
                r9 = this;
                androidx.camera.camera2.internal.b4 r0 = new androidx.camera.camera2.internal.b4
                boolean r1 = r9.f5033g
                if (r1 == 0) goto L_0x0019
                androidx.camera.camera2.internal.a4 r1 = new androidx.camera.camera2.internal.a4
                androidx.camera.core.impl.Quirks r3 = r9.f5031e
                androidx.camera.core.impl.Quirks r4 = r9.f5032f
                androidx.camera.camera2.internal.e2 r5 = r9.f5030d
                java.util.concurrent.Executor r6 = r9.f5027a
                java.util.concurrent.ScheduledExecutorService r7 = r9.f5028b
                android.os.Handler r8 = r9.f5029c
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7, r8)
                goto L_0x0026
            L_0x0019:
                androidx.camera.camera2.internal.v3 r1 = new androidx.camera.camera2.internal.v3
                androidx.camera.camera2.internal.e2 r2 = r9.f5030d
                java.util.concurrent.Executor r3 = r9.f5027a
                java.util.concurrent.ScheduledExecutorService r4 = r9.f5028b
                android.os.Handler r5 = r9.f5029c
                r1.<init>(r2, r3, r4, r5)
            L_0x0026:
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.b4.a.a():androidx.camera.camera2.internal.b4");
        }
    }

    public interface b {
        Executor c();

        l j(int i11, List<p.f> list, SynchronizedCaptureSession.StateCallback stateCallback);

        ListenableFuture<List<Surface>> k(List<DeferrableSurface> list, long j11);

        ListenableFuture<Void> l(CameraDevice cameraDevice, l lVar, List<DeferrableSurface> list);

        boolean stop();
    }

    public b4(b bVar) {
        this.f5026a = bVar;
    }

    public l a(int i11, List<p.f> list, SynchronizedCaptureSession.StateCallback stateCallback) {
        return this.f5026a.j(i11, list, stateCallback);
    }

    public Executor b() {
        return this.f5026a.c();
    }

    public ListenableFuture<Void> c(CameraDevice cameraDevice, l lVar, List<DeferrableSurface> list) {
        return this.f5026a.l(cameraDevice, lVar, list);
    }

    public ListenableFuture<List<Surface>> d(List<DeferrableSurface> list, long j11) {
        return this.f5026a.k(list, j11);
    }

    public boolean e() {
        return this.f5026a.stop();
    }
}
