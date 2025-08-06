package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f6240b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f6241c;

    public /* synthetic */ l0(EncoderImpl.d dVar, CallbackToFutureAdapter.a aVar) {
        this.f6240b = dVar;
        this.f6241c = aVar;
    }

    public final void run() {
        this.f6240b.t(this.f6241c);
    }
}
