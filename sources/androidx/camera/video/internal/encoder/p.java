package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class p implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f6250a;

    public /* synthetic */ p(AtomicReference atomicReference) {
        this.f6250a = atomicReference;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6250a.set(aVar);
    }
}
