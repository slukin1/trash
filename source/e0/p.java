package e0;

import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f54255b;

    public /* synthetic */ p(CallbackToFutureAdapter.a aVar) {
        this.f54255b = aVar;
    }

    public final void accept(Object obj) {
        this.f54255b.c((SurfaceRequest.Result) obj);
    }
}
