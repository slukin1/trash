package androidx.camera.core;

import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;

public final /* synthetic */ class m implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysis f5618a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5619b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysisConfig f5620c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamSpec f5621d;

    public /* synthetic */ m(ImageAnalysis imageAnalysis, String str, ImageAnalysisConfig imageAnalysisConfig, StreamSpec streamSpec) {
        this.f5618a = imageAnalysis;
        this.f5619b = str;
        this.f5620c = imageAnalysisConfig;
        this.f5621d = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f5618a.lambda$createPipeline$1(this.f5619b, this.f5620c, this.f5621d, sessionConfig, sessionError);
    }
}
