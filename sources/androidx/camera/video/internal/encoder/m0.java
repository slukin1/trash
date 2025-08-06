package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f6244b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f6245c;

    public /* synthetic */ m0(EncoderImpl.d dVar, ListenableFuture listenableFuture) {
        this.f6244b = dVar;
        this.f6245c = listenableFuture;
    }

    public final void run() {
        this.f6244b.o(this.f6245c);
    }
}
