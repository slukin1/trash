package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.view.Surface;
import com.iproov.sdk.p021new.Celse;
import com.iproov.sdk.p021new.Cgoto;
import java.util.List;
import java.util.Objects;

/* renamed from: com.iproov.sdk.cameray.new  reason: invalid class name */
class Cnew {

    /* renamed from: if  reason: not valid java name */
    private static final String f132if = ("🎥2 " + Cnew.class.getSimpleName());

    /* renamed from: do  reason: not valid java name */
    private final CaptureRequest.Builder f133do;

    public Cnew(CameraDevice cameraDevice, Cfor forR, List<Surface> list, Cgoto gotoR, RectF rectF) throws CameraAccessException {
        this.f133do = cameraDevice.createCaptureRequest(1);
        for (Surface addTarget : list) {
            this.f133do.addTarget(addTarget);
        }
        this.f133do.set(CaptureRequest.CONTROL_AF_MODE, 4);
        this.f133do.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, forR.m133else());
        double d11 = gotoR.m1198do(Cconst.CAMERA2, forR.m134for());
        if (d11 > 1.0d) {
            this.f133do.set(CaptureRequest.SCALER_CROP_REGION, Celse.m1189do(forR.m132do(), Double.valueOf(d11)));
        }
        m194do(false);
        m192do(m190do(rectF, forR.m132do(), 1000));
    }

    /* renamed from: do  reason: not valid java name */
    public void m194do(boolean z11) {
        this.f133do.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(z11));
        this.f133do.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(z11));
    }

    /* renamed from: do  reason: not valid java name */
    public void m192do(MeteringRectangle meteringRectangle) {
        this.f133do.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        Objects.toString(meteringRectangle);
    }

    /* renamed from: do  reason: not valid java name */
    public void m193do(Surface surface) {
        if (surface != null) {
            this.f133do.removeTarget(surface);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public CaptureRequest m191do() {
        return this.f133do.build();
    }

    /* renamed from: do  reason: not valid java name */
    public static MeteringRectangle m190do(RectF rectF, Rect rect, int i11) {
        return new MeteringRectangle(Math.max(0, (int) (rectF.left * ((float) rect.width()))), Math.max(0, (int) (rectF.top * ((float) rect.height()))), Math.min(rect.width(), (int) (rectF.width() * ((float) rect.width()))), Math.min(rect.height(), (int) (rectF.height() * ((float) rect.height()))), i11);
    }
}
