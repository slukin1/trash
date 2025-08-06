package androidx.camera.video;

import androidx.camera.core.impl.SessionConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class e1 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoCapture f5941a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig.Builder f5942b;

    public /* synthetic */ e1(VideoCapture videoCapture, SessionConfig.Builder builder) {
        this.f5941a = videoCapture;
        this.f5942b = builder;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5941a.M(this.f5942b, aVar);
    }
}
