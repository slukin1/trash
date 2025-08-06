package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class a0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable f5553a;

    public /* synthetic */ a0(LiveDataObservable liveDataObservable) {
        this.f5553a = liveDataObservable;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5553a.lambda$fetchData$1(aVar);
    }
}
