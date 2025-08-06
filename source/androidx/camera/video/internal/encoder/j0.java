package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.encoder.EncoderImpl;
import java.util.concurrent.Executor;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.d f6231b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable.Observer f6232c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Executor f6233d;

    public /* synthetic */ j0(EncoderImpl.d dVar, Observable.Observer observer, Executor executor) {
        this.f6231b = dVar;
        this.f6232c = observer;
        this.f6233d = executor;
    }

    public final void run() {
        this.f6231b.s(this.f6232c, this.f6233d);
    }
}
