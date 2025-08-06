package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class f0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f6205a;

    public /* synthetic */ f0(EncoderImpl.d dVar) {
        this.f6205a = dVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6205a.q(aVar);
    }
}
