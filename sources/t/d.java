package t;

import androidx.camera.camera2.interop.a;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f29279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f29280c;

    public /* synthetic */ d(a aVar, CallbackToFutureAdapter.a aVar2) {
        this.f29279b = aVar;
        this.f29280c = aVar2;
    }

    public final void run() {
        this.f29279b.o(this.f29280c);
    }
}
