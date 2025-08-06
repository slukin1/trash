package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.BufferProvider;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observable.Observer f6219b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BufferProvider.State f6220c;

    public /* synthetic */ h0(Observable.Observer observer, BufferProvider.State state) {
        this.f6219b = observer;
        this.f6220c = state;
    }

    public final void run() {
        this.f6219b.onNewData(this.f6220c);
    }
}
