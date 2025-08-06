package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class w implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f6276a;

    public /* synthetic */ w(AtomicReference atomicReference) {
        this.f6276a = atomicReference;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6276a.set(aVar);
    }
}
