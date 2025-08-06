package androidx.camera.core;

import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;

public final /* synthetic */ class k0 implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Preview f5611a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5612b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PreviewConfig f5613c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamSpec f5614d;

    public /* synthetic */ k0(Preview preview, String str, PreviewConfig previewConfig, StreamSpec streamSpec) {
        this.f5611a = preview;
        this.f5612b = str;
        this.f5613c = previewConfig;
        this.f5614d = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f5611a.lambda$addCameraSurfaceAndErrorListener$1(this.f5612b, this.f5613c, this.f5614d, sessionConfig, sessionError);
    }
}
