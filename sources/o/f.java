package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import java.util.List;
import java.util.concurrent.Executor;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final a f16188a;

    public interface a {
        CameraCaptureSession a();

        int b(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int c(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    public static final class b extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final CameraCaptureSession.CaptureCallback f16189a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f16190b;

        public b(Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
            this.f16190b = executor;
            this.f16189a = captureCallback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j11) {
            c.a(this.f16189a, cameraCaptureSession, captureRequest, surface, j11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.f16189a.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            this.f16189a.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.f16189a.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(CameraCaptureSession cameraCaptureSession, int i11) {
            this.f16189a.onCaptureSequenceAborted(cameraCaptureSession, i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(CameraCaptureSession cameraCaptureSession, int i11, long j11) {
            this.f16189a.onCaptureSequenceCompleted(cameraCaptureSession, i11, j11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j11, long j12) {
            this.f16189a.onCaptureStarted(cameraCaptureSession, captureRequest, j11, j12);
        }

        public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j11) {
            this.f16190b.execute(new m(this, cameraCaptureSession, captureRequest, surface, j11));
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.f16190b.execute(new l(this, cameraCaptureSession, captureRequest, totalCaptureResult));
        }

        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            this.f16190b.execute(new j(this, cameraCaptureSession, captureRequest, captureFailure));
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.f16190b.execute(new k(this, cameraCaptureSession, captureRequest, captureResult));
        }

        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i11) {
            this.f16190b.execute(new g(this, cameraCaptureSession, i11));
        }

        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i11, long j11) {
            this.f16190b.execute(new h(this, cameraCaptureSession, i11, j11));
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j11, long j12) {
            this.f16190b.execute(new i(this, cameraCaptureSession, captureRequest, j11, j12));
        }
    }

    public static final class c extends CameraCaptureSession.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        public final CameraCaptureSession.StateCallback f16191a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f16192b;

        public c(Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this.f16192b = executor;
            this.f16191a = stateCallback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(CameraCaptureSession cameraCaptureSession) {
            this.f16191a.onActive(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(CameraCaptureSession cameraCaptureSession) {
            d.b(this.f16191a, cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(CameraCaptureSession cameraCaptureSession) {
            this.f16191a.onClosed(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(CameraCaptureSession cameraCaptureSession) {
            this.f16191a.onConfigureFailed(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(CameraCaptureSession cameraCaptureSession) {
            this.f16191a.onConfigured(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(CameraCaptureSession cameraCaptureSession) {
            this.f16191a.onReady(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(CameraCaptureSession cameraCaptureSession, Surface surface) {
            b.a(this.f16191a, cameraCaptureSession, surface);
        }

        public void onActive(CameraCaptureSession cameraCaptureSession) {
            this.f16192b.execute(new n(this, cameraCaptureSession));
        }

        public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
            this.f16192b.execute(new p(this, cameraCaptureSession));
        }

        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            this.f16192b.execute(new o(this, cameraCaptureSession));
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            this.f16192b.execute(new r(this, cameraCaptureSession));
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            this.f16192b.execute(new q(this, cameraCaptureSession));
        }

        public void onReady(CameraCaptureSession cameraCaptureSession) {
            this.f16192b.execute(new s(this, cameraCaptureSession));
        }

        public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
            this.f16192b.execute(new t(this, cameraCaptureSession, surface));
        }
    }

    public f(CameraCaptureSession cameraCaptureSession, Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f16188a = new u(cameraCaptureSession);
        } else {
            this.f16188a = v.d(cameraCaptureSession, handler);
        }
    }

    public static f d(CameraCaptureSession cameraCaptureSession, Handler handler) {
        return new f(cameraCaptureSession, handler);
    }

    public int a(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16188a.b(list, executor, captureCallback);
    }

    public int b(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16188a.c(captureRequest, executor, captureCallback);
    }

    public CameraCaptureSession c() {
        return this.f16188a.a();
    }
}
