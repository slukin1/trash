package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f6222b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable.Observer f6223c;

    public /* synthetic */ i0(EncoderImpl.d dVar, Observable.Observer observer) {
        this.f6222b = dVar;
        this.f6223c = observer;
    }

    public final void run() {
        this.f6222b.v(this.f6223c);
    }
}
