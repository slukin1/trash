package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.b4;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import o.f;
import o.z;
import p.l;

public class v3 extends SynchronizedCaptureSession.StateCallback implements SynchronizedCaptureSession, b4.b {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5373a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final e2 f5374b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f5375c;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f5376d;

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledExecutorService f5377e;

    /* renamed from: f  reason: collision with root package name */
    public SynchronizedCaptureSession.StateCallback f5378f;

    /* renamed from: g  reason: collision with root package name */
    public f f5379g;

    /* renamed from: h  reason: collision with root package name */
    public ListenableFuture<Void> f5380h;

    /* renamed from: i  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f5381i;

    /* renamed from: j  reason: collision with root package name */
    public ListenableFuture<List<Surface>> f5382j;

    /* renamed from: k  reason: collision with root package name */
    public List<DeferrableSurface> f5383k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5384l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f5385m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5386n = false;

    public class a implements FutureCallback<Void> {
        public a() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(Throwable th2) {
            v3.this.h();
            v3 v3Var = v3.this;
            v3Var.f5374b.j(v3Var);
        }
    }

    public class b extends CameraCaptureSession.StateCallback {
        public b() {
        }

        public void onActive(CameraCaptureSession cameraCaptureSession) {
            v3.this.y(cameraCaptureSession);
            v3 v3Var = v3.this;
            v3Var.a(v3Var);
        }

        public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
            v3.this.y(cameraCaptureSession);
            v3 v3Var = v3.this;
            v3Var.m(v3Var);
        }

        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            v3.this.y(cameraCaptureSession);
            v3 v3Var = v3.this;
            v3Var.n(v3Var);
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            CallbackToFutureAdapter.a<Void> aVar;
            try {
                v3.this.y(cameraCaptureSession);
                v3 v3Var = v3.this;
                v3Var.o(v3Var);
                synchronized (v3.this.f5373a) {
                    h.h(v3.this.f5381i, "OpenCaptureSession completer should not null");
                    v3 v3Var2 = v3.this;
                    aVar = v3Var2.f5381i;
                    v3Var2.f5381i = null;
                }
                aVar.f(new IllegalStateException("onConfigureFailed"));
            } catch (Throwable th2) {
                synchronized (v3.this.f5373a) {
                    h.h(v3.this.f5381i, "OpenCaptureSession completer should not null");
                    v3 v3Var3 = v3.this;
                    CallbackToFutureAdapter.a<Void> aVar2 = v3Var3.f5381i;
                    v3Var3.f5381i = null;
                    aVar2.f(new IllegalStateException("onConfigureFailed"));
                    throw th2;
                }
            }
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            CallbackToFutureAdapter.a<Void> aVar;
            try {
                v3.this.y(cameraCaptureSession);
                v3 v3Var = v3.this;
                v3Var.p(v3Var);
                synchronized (v3.this.f5373a) {
                    h.h(v3.this.f5381i, "OpenCaptureSession completer should not null");
                    v3 v3Var2 = v3.this;
                    aVar = v3Var2.f5381i;
                    v3Var2.f5381i = null;
                }
                aVar.c(null);
            } catch (Throwable th2) {
                synchronized (v3.this.f5373a) {
                    h.h(v3.this.f5381i, "OpenCaptureSession completer should not null");
                    v3 v3Var3 = v3.this;
                    CallbackToFutureAdapter.a<Void> aVar2 = v3Var3.f5381i;
                    v3Var3.f5381i = null;
                    aVar2.c(null);
                    throw th2;
                }
            }
        }

        public void onReady(CameraCaptureSession cameraCaptureSession) {
            v3.this.y(cameraCaptureSession);
            v3 v3Var = v3.this;
            v3Var.q(v3Var);
        }

        public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
            v3.this.y(cameraCaptureSession);
            v3 v3Var = v3.this;
            v3Var.s(v3Var, surface);
        }
    }

    public v3(e2 e2Var, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        this.f5374b = e2Var;
        this.f5375c = handler;
        this.f5376d = executor;
        this.f5377e = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B() {
        r(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.f5374b.h(this);
        r(synchronizedCaptureSession);
        Objects.requireNonNull(this.f5378f);
        this.f5378f.n(synchronizedCaptureSession);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f5378f);
        this.f5378f.r(synchronizedCaptureSession);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object E(List list, z zVar, l lVar, CallbackToFutureAdapter.a aVar) throws Exception {
        String str;
        synchronized (this.f5373a) {
            z(list);
            h.j(this.f5381i == null, "The openCaptureSessionCompleter can only set once!");
            this.f5381i = aVar;
            zVar.a(lVar);
            str = "openCaptureSession[session=" + this + "]";
        }
        return str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ListenableFuture F(List list, List list2) throws Exception {
        Logger.d("SyncCaptureSessionBase", "[" + this + "] getSurface...done");
        if (list2.contains((Object) null)) {
            return Futures.immediateFailedFuture(new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) list.get(list2.indexOf((Object) null))));
        }
        if (list2.isEmpty()) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("Unable to open capture session without surfaces"));
        }
        return Futures.immediateFuture(list2);
    }

    public boolean A() {
        boolean z11;
        synchronized (this.f5373a) {
            z11 = this.f5380h != null;
        }
        return z11;
    }

    public void G() {
        synchronized (this.f5373a) {
            List<DeferrableSurface> list = this.f5383k;
            if (list != null) {
                DeferrableSurfaces.decrementAll(list);
                this.f5383k = null;
            }
        }
    }

    public void a(SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f5378f);
        this.f5378f.a(synchronizedCaptureSession);
    }

    public void abortCaptures() throws CameraAccessException {
        h.h(this.f5379g, "Need to call openCaptureSession before using this API.");
        this.f5379g.c().abortCaptures();
    }

    public SynchronizedCaptureSession.StateCallback b() {
        return this;
    }

    public Executor c() {
        return this.f5376d;
    }

    public void close() {
        h.h(this.f5379g, "Need to call openCaptureSession before using this API.");
        this.f5374b.i(this);
        this.f5379g.c().close();
        c().execute(new s3(this));
    }

    public CameraDevice d() {
        h.g(this.f5379g);
        return this.f5379g.c().getDevice();
    }

    public int e(List<CaptureRequest> list, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        h.h(this.f5379g, "Need to call openCaptureSession before using this API.");
        return this.f5379g.a(list, c(), captureCallback);
    }

    public f f() {
        h.g(this.f5379g);
        return this.f5379g;
    }

    public ListenableFuture<Void> g() {
        return Futures.immediateFuture(null);
    }

    public void h() {
        G();
    }

    public int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        h.h(this.f5379g, "Need to call openCaptureSession before using this API.");
        return this.f5379g.b(captureRequest, c(), captureCallback);
    }

    public l j(int i11, List<p.f> list, SynchronizedCaptureSession.StateCallback stateCallback) {
        this.f5378f = stateCallback;
        return new l(i11, list, c(), new b());
    }

    public ListenableFuture<List<Surface>> k(List<DeferrableSurface> list, long j11) {
        synchronized (this.f5373a) {
            if (this.f5385m) {
                ListenableFuture<List<Surface>> immediateFailedFuture = Futures.immediateFailedFuture(new CancellationException("Opener is disabled"));
                return immediateFailedFuture;
            }
            FutureChain<T> transformAsync = FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(list, false, j11, c(), this.f5377e)).transformAsync(new q3(this, list), c());
            this.f5382j = transformAsync;
            ListenableFuture<List<Surface>> nonCancellationPropagating = Futures.nonCancellationPropagating(transformAsync);
            return nonCancellationPropagating;
        }
    }

    public ListenableFuture<Void> l(CameraDevice cameraDevice, l lVar, List<DeferrableSurface> list) {
        synchronized (this.f5373a) {
            if (this.f5385m) {
                ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new CancellationException("Opener is disabled"));
                return immediateFailedFuture;
            }
            this.f5374b.l(this);
            ListenableFuture<Void> a11 = CallbackToFutureAdapter.a(new r3(this, list, z.b(cameraDevice, this.f5375c), lVar));
            this.f5380h = a11;
            Futures.addCallback(a11, new a(), CameraXExecutors.directExecutor());
            ListenableFuture<Void> nonCancellationPropagating = Futures.nonCancellationPropagating(this.f5380h);
            return nonCancellationPropagating;
        }
    }

    public void m(SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f5378f);
        this.f5378f.m(synchronizedCaptureSession);
    }

    public void n(SynchronizedCaptureSession synchronizedCaptureSession) {
        ListenableFuture<Void> listenableFuture;
        synchronized (this.f5373a) {
            if (!this.f5384l) {
                this.f5384l = true;
                h.h(this.f5380h, "Need to call openCaptureSession before using this API.");
                listenableFuture = this.f5380h;
            } else {
                listenableFuture = null;
            }
        }
        h();
        if (listenableFuture != null) {
            listenableFuture.addListener(new u3(this, synchronizedCaptureSession), CameraXExecutors.directExecutor());
        }
    }

    public void o(SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f5378f);
        h();
        this.f5374b.j(this);
        this.f5378f.o(synchronizedCaptureSession);
    }

    public void p(SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f5378f);
        this.f5374b.k(this);
        this.f5378f.p(synchronizedCaptureSession);
    }

    public void q(SynchronizedCaptureSession synchronizedCaptureSession) {
        Objects.requireNonNull(this.f5378f);
        this.f5378f.q(synchronizedCaptureSession);
    }

    public void r(SynchronizedCaptureSession synchronizedCaptureSession) {
        ListenableFuture<Void> listenableFuture;
        synchronized (this.f5373a) {
            if (!this.f5386n) {
                this.f5386n = true;
                h.h(this.f5380h, "Need to call openCaptureSession before using this API.");
                listenableFuture = this.f5380h;
            } else {
                listenableFuture = null;
            }
        }
        if (listenableFuture != null) {
            listenableFuture.addListener(new t3(this, synchronizedCaptureSession), CameraXExecutors.directExecutor());
        }
    }

    public void s(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
        Objects.requireNonNull(this.f5378f);
        this.f5378f.s(synchronizedCaptureSession, surface);
    }

    public boolean stop() {
        boolean z11;
        ListenableFuture<List<Surface>> listenableFuture = null;
        try {
            synchronized (this.f5373a) {
                if (!this.f5385m) {
                    ListenableFuture<List<Surface>> listenableFuture2 = this.f5382j;
                    if (listenableFuture2 != null) {
                        listenableFuture = listenableFuture2;
                    }
                    this.f5385m = true;
                }
                z11 = !A();
            }
            if (listenableFuture != null) {
                listenableFuture.cancel(true);
            }
            return z11;
        } catch (Throwable th2) {
            if (listenableFuture != null) {
                listenableFuture.cancel(true);
            }
            throw th2;
        }
    }

    public void stopRepeating() throws CameraAccessException {
        h.h(this.f5379g, "Need to call openCaptureSession before using this API.");
        this.f5379g.c().stopRepeating();
    }

    public void y(CameraCaptureSession cameraCaptureSession) {
        if (this.f5379g == null) {
            this.f5379g = f.d(cameraCaptureSession, this.f5375c);
        }
    }

    public void z(List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        synchronized (this.f5373a) {
            G();
            DeferrableSurfaces.incrementAll(list);
            this.f5383k = list;
        }
    }
}
