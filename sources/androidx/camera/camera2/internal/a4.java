package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import p.l;
import r.f;
import r.g;
import r.o;

public class a4 extends v3 {

    /* renamed from: o  reason: collision with root package name */
    public final Object f5007o = new Object();

    /* renamed from: p  reason: collision with root package name */
    public List<DeferrableSurface> f5008p;

    /* renamed from: q  reason: collision with root package name */
    public ListenableFuture<Void> f5009q;

    /* renamed from: r  reason: collision with root package name */
    public final g f5010r;

    /* renamed from: s  reason: collision with root package name */
    public final o f5011s;

    /* renamed from: t  reason: collision with root package name */
    public final f f5012t;

    public a4(Quirks quirks, Quirks quirks2, e2 e2Var, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        super(e2Var, executor, scheduledExecutorService, handler);
        this.f5010r = new g(quirks, quirks2);
        this.f5011s = new o(quirks);
        this.f5012t = new f(quirks2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M() {
        L("Session call super.close()");
        super.close();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(SynchronizedCaptureSession synchronizedCaptureSession) {
        super.p(synchronizedCaptureSession);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ListenableFuture O(CameraDevice cameraDevice, l lVar, List list) {
        return super.l(cameraDevice, lVar, list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int P(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return super.i(captureRequest, captureCallback);
    }

    public void L(String str) {
        Logger.d("SyncCaptureSessionImpl", "[" + this + "] " + str);
    }

    public void close() {
        L("Session call close()");
        this.f5011s.f();
        this.f5011s.c().addListener(new w3(this), c());
    }

    public ListenableFuture<Void> g() {
        return this.f5011s.c();
    }

    public int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f5011s.h(captureRequest, captureCallback, new z3(this));
    }

    public ListenableFuture<List<Surface>> k(List<DeferrableSurface> list, long j11) {
        ListenableFuture<List<Surface>> k11;
        synchronized (this.f5007o) {
            this.f5008p = list;
            k11 = super.k(list, j11);
        }
        return k11;
    }

    public ListenableFuture<Void> l(CameraDevice cameraDevice, l lVar, List<DeferrableSurface> list) {
        ListenableFuture<Void> nonCancellationPropagating;
        synchronized (this.f5007o) {
            ListenableFuture<Void> g11 = this.f5011s.g(cameraDevice, lVar, list, this.f5374b.e(), new y3(this));
            this.f5009q = g11;
            nonCancellationPropagating = Futures.nonCancellationPropagating(g11);
        }
        return nonCancellationPropagating;
    }

    public void n(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.f5007o) {
            this.f5010r.a(this.f5008p);
        }
        L("onClosed()");
        super.n(synchronizedCaptureSession);
    }

    public void p(SynchronizedCaptureSession synchronizedCaptureSession) {
        L("Session onConfigured()");
        this.f5012t.c(synchronizedCaptureSession, this.f5374b.f(), this.f5374b.d(), new x3(this));
    }

    public boolean stop() {
        boolean stop;
        synchronized (this.f5007o) {
            if (A()) {
                this.f5010r.a(this.f5008p);
            } else {
                ListenableFuture<Void> listenableFuture = this.f5009q;
                if (listenableFuture != null) {
                    listenableFuture.cancel(true);
                }
            }
            stop = super.stop();
        }
        return stop;
    }
}
