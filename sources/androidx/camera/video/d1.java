package androidx.camera.video;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import x.a;

public final /* synthetic */ class d1 implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoCapture f5933a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5934b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f5935c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StreamSpec f5936d;

    public /* synthetic */ d1(VideoCapture videoCapture, String str, a aVar, StreamSpec streamSpec) {
        this.f5933a = videoCapture;
        this.f5934b = str;
        this.f5935c = aVar;
        this.f5936d = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f5933a.K(this.f5934b, this.f5935c, this.f5936d, sessionConfig, sessionError);
    }
}
