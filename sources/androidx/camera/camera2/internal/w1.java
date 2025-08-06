package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.TagBundle;
import androidx.core.util.h;
import java.util.Objects;

public final class w1 extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    public final CameraCaptureCallback f5397a;

    public w1(CameraCaptureCallback cameraCaptureCallback) {
        Objects.requireNonNull(cameraCaptureCallback, "cameraCaptureCallback is null");
        this.f5397a = cameraCaptureCallback;
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        TagBundle tagBundle;
        super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        Object tag = captureRequest.getTag();
        if (tag != null) {
            h.b(tag instanceof TagBundle, "The tagBundle object from the CaptureResult is not a TagBundle object.");
            tagBundle = (TagBundle) tag;
        } else {
            tagBundle = TagBundle.emptyBundle();
        }
        this.f5397a.onCaptureCompleted(new f(tagBundle, totalCaptureResult));
    }

    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        this.f5397a.onCaptureFailed(new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR));
    }
}
