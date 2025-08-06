package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class t0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5722b;

    public /* synthetic */ t0(AtomicReference atomicReference, String str) {
        this.f5721a = atomicReference;
        this.f5722b = str;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5721a.set(aVar);
    }
}
