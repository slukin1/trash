package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.u;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import o.y;

public final class m4 {

    /* renamed from: a  reason: collision with root package name */
    public final u f5207a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f5208b;

    /* renamed from: c  reason: collision with root package name */
    public final n4 f5209c;

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<ZoomState> f5210d;

    /* renamed from: e  reason: collision with root package name */
    public final b f5211e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5212f = false;

    /* renamed from: g  reason: collision with root package name */
    public u.c f5213g = new a();

    public class a implements u.c {
        public a() {
        }

        public boolean a(TotalCaptureResult totalCaptureResult) {
            m4.this.f5211e.a(totalCaptureResult);
            return false;
        }
    }

    public interface b {
        void a(TotalCaptureResult totalCaptureResult);

        void b(Camera2ImplConfig.Builder builder);

        float c();

        void d(float f11, CallbackToFutureAdapter.a<Void> aVar);

        void e();

        Rect f();

        float getMaxZoom();
    }

    public m4(u uVar, y yVar, Executor executor) {
        this.f5207a = uVar;
        this.f5208b = executor;
        b f11 = f(yVar);
        this.f5211e = f11;
        n4 n4Var = new n4(f11.getMaxZoom(), f11.c());
        this.f5209c = n4Var;
        n4Var.d(1.0f);
        this.f5210d = new MutableLiveData<>(ImmutableZoomState.create(n4Var));
        uVar.k(this.f5213g);
    }

    public static b f(y yVar) {
        if (k(yVar)) {
            return new a(yVar);
        }
        return new f2(yVar);
    }

    public static ZoomState h(y yVar) {
        b f11 = f(yVar);
        n4 n4Var = new n4(f11.getMaxZoom(), f11.c());
        n4Var.d(1.0f);
        return ImmutableZoomState.create(n4Var);
    }

    public static Range<Float> i(y yVar) {
        try {
            return (Range) yVar.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        } catch (AssertionError e11) {
            Logger.w("ZoomControl", "AssertionError, fail to get camera characteristic.", e11);
            return null;
        }
    }

    public static boolean k(y yVar) {
        return Build.VERSION.SDK_INT >= 30 && i(yVar) != null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object m(ZoomState zoomState, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5208b.execute(new l4(this, aVar, zoomState));
        return "setLinearZoom";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object o(ZoomState zoomState, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5208b.execute(new k4(this, aVar, zoomState));
        return "setZoomRatio";
    }

    public void e(Camera2ImplConfig.Builder builder) {
        this.f5211e.b(builder);
    }

    public Rect g() {
        return this.f5211e.f();
    }

    public LiveData<ZoomState> j() {
        return this.f5210d;
    }

    public void p(boolean z11) {
        ZoomState create;
        if (this.f5212f != z11) {
            this.f5212f = z11;
            if (!z11) {
                synchronized (this.f5209c) {
                    this.f5209c.d(1.0f);
                    create = ImmutableZoomState.create(this.f5209c);
                }
                t(create);
                this.f5211e.e();
                this.f5207a.a0();
            }
        }
    }

    public ListenableFuture<Void> q(float f11) {
        ZoomState create;
        synchronized (this.f5209c) {
            try {
                this.f5209c.c(f11);
                create = ImmutableZoomState.create(this.f5209c);
            } catch (IllegalArgumentException e11) {
                return Futures.immediateFailedFuture(e11);
            }
        }
        t(create);
        return CallbackToFutureAdapter.a(new j4(this, create));
    }

    public ListenableFuture<Void> r(float f11) {
        ZoomState create;
        synchronized (this.f5209c) {
            try {
                this.f5209c.d(f11);
                create = ImmutableZoomState.create(this.f5209c);
            } catch (IllegalArgumentException e11) {
                return Futures.immediateFailedFuture(e11);
            }
        }
        t(create);
        return CallbackToFutureAdapter.a(new i4(this, create));
    }

    /* renamed from: s */
    public final void n(CallbackToFutureAdapter.a<Void> aVar, ZoomState zoomState) {
        ZoomState create;
        if (!this.f5212f) {
            synchronized (this.f5209c) {
                this.f5209c.d(1.0f);
                create = ImmutableZoomState.create(this.f5209c);
            }
            t(create);
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        t(zoomState);
        this.f5211e.d(zoomState.getZoomRatio(), aVar);
        this.f5207a.a0();
    }

    public final void t(ZoomState zoomState) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f5210d.setValue(zoomState);
        } else {
            this.f5210d.postValue(zoomState);
        }
    }
}
