package w;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class f implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f61219a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraX f61220b;

    public /* synthetic */ f(g gVar, CameraX cameraX) {
        this.f61219a = gVar;
        this.f61220b = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f61219a.k(this.f61220b, aVar);
    }
}
