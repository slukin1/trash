package t;

import androidx.camera.camera2.interop.a;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f29281b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f29282c;

    public /* synthetic */ e(a aVar, CallbackToFutureAdapter.a aVar2) {
        this.f29281b = aVar;
        this.f29282c = aVar2;
    }

    public final void run() {
        this.f29281b.m(this.f29282c);
    }
}
