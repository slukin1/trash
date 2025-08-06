package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class s0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5714b;

    public /* synthetic */ s0(AtomicReference atomicReference, String str) {
        this.f5713a = atomicReference;
        this.f5714b = str;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5713a.set(aVar);
    }
}
