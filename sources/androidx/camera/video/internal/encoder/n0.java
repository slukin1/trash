package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f6246b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f6247c;

    public /* synthetic */ n0(EncoderImpl.d dVar, ListenableFuture listenableFuture) {
        this.f6246b = dVar;
        this.f6247c = listenableFuture;
    }

    public final void run() {
        this.f6246b.n(this.f6247c);
    }
}
