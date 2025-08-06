package androidx.camera.video;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class p1 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoEncoderSession f6336a;

    public /* synthetic */ p1(VideoEncoderSession videoEncoderSession) {
        this.f6336a = videoEncoderSession;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6336a.o(aVar);
    }
}
