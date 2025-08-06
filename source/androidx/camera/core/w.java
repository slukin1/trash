package androidx.camera.core;

import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;

public final /* synthetic */ class w implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageCapture f5729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5730b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageCaptureConfig f5731c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamSpec f5732d;

    public /* synthetic */ w(ImageCapture imageCapture, String str, ImageCaptureConfig imageCaptureConfig, StreamSpec streamSpec) {
        this.f5729a = imageCapture;
        this.f5730b = str;
        this.f5731c = imageCaptureConfig;
        this.f5732d = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f5729a.lambda$createPipeline$3(this.f5730b, this.f5731c, this.f5732d, sessionConfig, sessionError);
    }
}
