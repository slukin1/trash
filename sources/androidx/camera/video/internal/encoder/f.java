package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class f implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f6204a;

    public /* synthetic */ f(AtomicReference atomicReference) {
        this.f6204a = atomicReference;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6204a.set(aVar);
    }
}
