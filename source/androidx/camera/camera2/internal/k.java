package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class k implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f5170a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f5171b;

    public /* synthetic */ k(u uVar, long j11) {
        this.f5170a = uVar;
        this.f5171b = j11;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5170a.Q(this.f5171b, aVar);
    }
}
