package com.tencent.liteav.videoproducer.capture.a;

import android.hardware.Camera;
import com.tencent.liteav.base.util.LiteavLog;

final /* synthetic */ class b implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final b f22560a = new b();

    private b() {
    }

    public static Camera.AutoFocusCallback a() {
        return f22560a;
    }

    public final void onAutoFocus(boolean z11, Camera camera) {
        LiteavLog.d("CameraController", "onAutoFocus success: %b", Boolean.valueOf(z11));
    }
}
