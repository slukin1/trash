package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f5749b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Surface f5750c;

    public /* synthetic */ z0(Consumer consumer, Surface surface) {
        this.f5749b = consumer;
        this.f5750c = surface;
    }

    public final void run() {
        this.f5749b.accept(SurfaceRequest.Result.of(4, this.f5750c));
    }
}
