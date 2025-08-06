package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.m4;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import o.y;

public final class f2 implements m4.b {

    /* renamed from: a  reason: collision with root package name */
    public final y f5108a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f5109b = null;

    /* renamed from: c  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f5110c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f5111d = null;

    public f2(y yVar) {
        this.f5108a = yVar;
    }

    public static Rect g(Rect rect, float f11) {
        float width = ((float) rect.width()) / f11;
        float height = ((float) rect.height()) / f11;
        float width2 = (((float) rect.width()) - width) / 2.0f;
        float height2 = (((float) rect.height()) - height) / 2.0f;
        return new Rect((int) width2, (int) height2, (int) (width2 + width), (int) (height2 + height));
    }

    public void a(TotalCaptureResult totalCaptureResult) {
        Rect rect;
        if (this.f5110c != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            if (request == null) {
                rect = null;
            } else {
                rect = (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
            }
            Rect rect2 = this.f5111d;
            if (rect2 != null && rect2.equals(rect)) {
                this.f5110c.c(null);
                this.f5110c = null;
                this.f5111d = null;
            }
        }
    }

    public void b(Camera2ImplConfig.Builder builder) {
        Rect rect = this.f5109b;
        if (rect != null) {
            builder.c(CaptureRequest.SCALER_CROP_REGION, rect);
        }
    }

    public float c() {
        return 1.0f;
    }

    public void d(float f11, CallbackToFutureAdapter.a<Void> aVar) {
        this.f5109b = g(h(), f11);
        CallbackToFutureAdapter.a<Void> aVar2 = this.f5110c;
        if (aVar2 != null) {
            aVar2.f(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
        }
        this.f5111d = this.f5109b;
        this.f5110c = aVar;
    }

    public void e() {
        this.f5111d = null;
        this.f5109b = null;
        CallbackToFutureAdapter.a<Void> aVar = this.f5110c;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            this.f5110c = null;
        }
    }

    public Rect f() {
        Rect rect = this.f5109b;
        return rect != null ? rect : h();
    }

    public float getMaxZoom() {
        Float f11 = (Float) this.f5108a.a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f11 == null) {
            return 1.0f;
        }
        if (f11.floatValue() < c()) {
            return c();
        }
        return f11.floatValue();
    }

    public final Rect h() {
        return (Rect) h.g((Rect) this.f5108a.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }
}
