package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.util.Locale;

public class CameraCaptureParams extends CaptureSourceInterface.CaptureParams {

    /* renamed from: a  reason: collision with root package name */
    public Boolean f22518a = null;

    public boolean equals(Object obj) {
        if (!(obj instanceof CameraCaptureParams)) {
            return false;
        }
        CameraCaptureParams cameraCaptureParams = (CameraCaptureParams) obj;
        if (!super.equals(cameraCaptureParams) || !h.a(this.f22518a, cameraCaptureParams.f22518a)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%s, frontCamera: %b", new Object[]{super.toString(), this.f22518a});
    }
}
