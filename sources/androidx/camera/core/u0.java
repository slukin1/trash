package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class u0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5724a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5725b;

    public /* synthetic */ u0(AtomicReference atomicReference, String str) {
        this.f5724a = atomicReference;
        this.f5725b = str;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5724a.set(aVar);
    }
}
