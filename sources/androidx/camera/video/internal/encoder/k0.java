package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f6238b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f6239c;

    public /* synthetic */ k0(EncoderImpl.d dVar, CallbackToFutureAdapter.a aVar) {
        this.f6238b = dVar;
        this.f6239c = aVar;
    }

    public final void run() {
        this.f6238b.p(this.f6239c);
    }
}
