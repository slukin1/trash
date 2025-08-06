package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class g0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f6218a;

    public /* synthetic */ g0(EncoderImpl.d dVar) {
        this.f6218a = dVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6218a.u(aVar);
    }
}
