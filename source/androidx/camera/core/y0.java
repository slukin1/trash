package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

public final /* synthetic */ class y0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f5743b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Surface f5744c;

    public /* synthetic */ y0(Consumer consumer, Surface surface) {
        this.f5743b = consumer;
        this.f5744c = surface;
    }

    public final void run() {
        this.f5743b.accept(SurfaceRequest.Result.of(3, this.f5744c));
    }
}
