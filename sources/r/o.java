package r;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.t0;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import p.l;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f16432a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f16433b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final ListenableFuture<Void> f16434c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f16435d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16436e;

    /* renamed from: f  reason: collision with root package name */
    public final CameraCaptureSession.CaptureCallback f16437f = new a();

    public class a extends CameraCaptureSession.CaptureCallback {
        public a() {
        }

        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i11) {
            CallbackToFutureAdapter.a<Void> aVar = o.this.f16435d;
            if (aVar != null) {
                aVar.d();
                o.this.f16435d = null;
            }
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j11, long j12) {
            CallbackToFutureAdapter.a<Void> aVar = o.this.f16435d;
            if (aVar != null) {
                aVar.c(null);
                o.this.f16435d = null;
            }
        }
    }

    @FunctionalInterface
    public interface b {
        ListenableFuture<Void> a(CameraDevice cameraDevice, l lVar, List<DeferrableSurface> list);
    }

    @FunctionalInterface
    public interface c {
        int a(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    public o(Quirks quirks) {
        this.f16432a = quirks.contains(CaptureSessionStuckQuirk.class);
        if (i()) {
            this.f16434c = CallbackToFutureAdapter.a(new n(this));
        } else {
            this.f16434c = Futures.immediateFuture(null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f16435d = aVar;
        return "WaitForRepeatingRequestStart[" + this + "]";
    }

    public ListenableFuture<Void> c() {
        return Futures.nonCancellationPropagating(this.f16434c);
    }

    public void f() {
        synchronized (this.f16433b) {
            if (i() && !this.f16436e) {
                this.f16434c.cancel(true);
            }
        }
    }

    public ListenableFuture<Void> g(CameraDevice cameraDevice, l lVar, List<DeferrableSurface> list, List<SynchronizedCaptureSession> list2, b bVar) {
        ArrayList arrayList = new ArrayList();
        for (SynchronizedCaptureSession g11 : list2) {
            arrayList.add(g11.g());
        }
        return FutureChain.from(Futures.successfulAsList(arrayList)).transformAsync(new m(bVar, cameraDevice, lVar, list), CameraXExecutors.directExecutor());
    }

    public int h(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback, c cVar) throws CameraAccessException {
        int a11;
        synchronized (this.f16433b) {
            if (i()) {
                captureCallback = t0.b(this.f16437f, captureCallback);
                this.f16436e = true;
            }
            a11 = cVar.a(captureRequest, captureCallback);
        }
        return a11;
    }

    public boolean i() {
        return this.f16432a;
    }
}
