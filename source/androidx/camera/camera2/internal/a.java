package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.m4;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import o.y;

public final class a implements m4.b {

    /* renamed from: a  reason: collision with root package name */
    public final y f4991a;

    /* renamed from: b  reason: collision with root package name */
    public final Range<Float> f4992b;

    /* renamed from: c  reason: collision with root package name */
    public float f4993c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f4994d;

    /* renamed from: e  reason: collision with root package name */
    public float f4995e = 1.0f;

    public a(y yVar) {
        this.f4991a = yVar;
        this.f4992b = (Range) yVar.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
    }

    public void a(TotalCaptureResult totalCaptureResult) {
        Float f11;
        if (this.f4994d != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            if (request == null) {
                f11 = null;
            } else {
                f11 = (Float) request.get(CaptureRequest.CONTROL_ZOOM_RATIO);
            }
            if (f11 != null) {
                if (this.f4995e == f11.floatValue()) {
                    this.f4994d.c(null);
                    this.f4994d = null;
                }
            }
        }
    }

    public void b(Camera2ImplConfig.Builder builder) {
        builder.c(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.f4993c));
    }

    public float c() {
        return this.f4992b.getLower().floatValue();
    }

    public void d(float f11, CallbackToFutureAdapter.a<Void> aVar) {
        this.f4993c = f11;
        CallbackToFutureAdapter.a<Void> aVar2 = this.f4994d;
        if (aVar2 != null) {
            aVar2.f(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
        }
        this.f4995e = this.f4993c;
        this.f4994d = aVar;
    }

    public void e() {
        this.f4993c = 1.0f;
        CallbackToFutureAdapter.a<Void> aVar = this.f4994d;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            this.f4994d = null;
        }
    }

    public Rect f() {
        return (Rect) h.g((Rect) this.f4991a.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    public float getMaxZoom() {
        return this.f4992b.getUpper().floatValue();
    }
}
