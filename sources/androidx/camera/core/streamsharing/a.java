package androidx.camera.core.streamsharing;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;

public final /* synthetic */ class a implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamSharing f5715a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5716b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UseCaseConfig f5717c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamSpec f5718d;

    public /* synthetic */ a(StreamSharing streamSharing, String str, UseCaseConfig useCaseConfig, StreamSpec streamSpec) {
        this.f5715a = streamSharing;
        this.f5716b = str;
        this.f5717c = useCaseConfig;
        this.f5718d = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f5715a.lambda$addCameraErrorListener$1(this.f5716b, this.f5717c, this.f5718d, sessionConfig, sessionError);
    }
}
