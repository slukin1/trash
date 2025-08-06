package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.u;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ExposureState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import o.y;

public class l2 {

    /* renamed from: a  reason: collision with root package name */
    public final u f5184a;

    /* renamed from: b  reason: collision with root package name */
    public final m2 f5185b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f5186c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5187d = false;

    /* renamed from: e  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Integer> f5188e;

    /* renamed from: f  reason: collision with root package name */
    public u.c f5189f;

    public l2(u uVar, y yVar, Executor executor) {
        this.f5184a = uVar;
        this.f5185b = new m2(yVar, 0);
        this.f5186c = executor;
    }

    public static ExposureState e(y yVar) {
        return new m2(yVar, 0);
    }

    public static /* synthetic */ boolean g(int i11, CallbackToFutureAdapter.a aVar, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
        if (num != null && num2 != null) {
            int intValue = num.intValue();
            if ((intValue != 2 && intValue != 3 && intValue != 4) || num2.intValue() != i11) {
                return false;
            }
            aVar.c(Integer.valueOf(i11));
            return true;
        } else if (num2 == null || num2.intValue() != i11) {
            return false;
        } else {
            aVar.c(Integer.valueOf(i11));
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(CallbackToFutureAdapter.a aVar, int i11) {
        boolean z11 = false;
        if (!this.f5187d) {
            this.f5185b.a(0);
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        d();
        h.j(this.f5188e == null, "mRunningCompleter should be null when starting set a new exposure compensation value");
        if (this.f5189f == null) {
            z11 = true;
        }
        h.j(z11, "mRunningCaptureResultListener should be null when starting set a new exposure compensation value");
        i2 i2Var = new i2(i11, aVar);
        this.f5189f = i2Var;
        this.f5188e = aVar;
        this.f5184a.k(i2Var);
        this.f5184a.a0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object i(int i11, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5186c.execute(new k2(this, aVar, i11));
        return "setExposureCompensationIndex[" + i11 + "]";
    }

    public final void d() {
        CallbackToFutureAdapter.a<Integer> aVar = this.f5188e;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            this.f5188e = null;
        }
        u.c cVar = this.f5189f;
        if (cVar != null) {
            this.f5184a.R(cVar);
            this.f5189f = null;
        }
    }

    public ExposureState f() {
        return this.f5185b;
    }

    public void j(boolean z11) {
        if (z11 != this.f5187d) {
            this.f5187d = z11;
            if (!z11) {
                this.f5185b.a(0);
                d();
            }
        }
    }

    public void k(Camera2ImplConfig.Builder builder) {
        builder.c(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.f5185b.getExposureCompensationIndex()));
    }

    public ListenableFuture<Integer> l(int i11) {
        if (!this.f5185b.isExposureCompensationSupported()) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("ExposureCompensation is not supported"));
        }
        Range<Integer> exposureCompensationRange = this.f5185b.getExposureCompensationRange();
        if (!exposureCompensationRange.contains(Integer.valueOf(i11))) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("Requested ExposureCompensation " + i11 + " is not within valid range [" + exposureCompensationRange.getUpper() + ".." + exposureCompensationRange.getLower() + "]"));
        }
        this.f5185b.a(i11);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.a(new j2(this, i11)));
    }
}
