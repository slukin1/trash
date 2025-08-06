package e0;

import android.view.Surface;
import androidx.camera.view.e;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class o implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f54253a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Surface f54254b;

    public /* synthetic */ o(e eVar, Surface surface) {
        this.f54253a = eVar;
        this.f54254b = surface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f54253a.q(this.f54254b, aVar);
    }
}
