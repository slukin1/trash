package e0;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.e;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f54256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Surface f54257c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f54258d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f54259e;

    public /* synthetic */ q(e eVar, Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        this.f54256b = eVar;
        this.f54257c = surface;
        this.f54258d = listenableFuture;
        this.f54259e = surfaceRequest;
    }

    public final void run() {
        this.f54256b.r(this.f54257c, this.f54258d, this.f54259e);
    }
}
