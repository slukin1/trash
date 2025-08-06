package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f6267b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f6268c;

    public /* synthetic */ u(EncoderImpl encoderImpl, CallbackToFutureAdapter.a aVar) {
        this.f6267b = encoderImpl;
        this.f6268c = aVar;
    }

    public final void run() {
        this.f6267b.J(this.f6268c);
    }
}
