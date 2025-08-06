package androidx.camera.video;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class o1 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoEncoderSession f6333a;

    public /* synthetic */ o1(VideoEncoderSession videoEncoderSession) {
        this.f6333a = videoEncoderSession;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6333a.p(aVar);
    }
}
