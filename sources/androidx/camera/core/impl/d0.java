package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable f5560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5561c;

    public /* synthetic */ d0(LiveDataObservable liveDataObservable, CallbackToFutureAdapter.a aVar) {
        this.f5560b = liveDataObservable;
        this.f5561c = aVar;
    }

    public final void run() {
        this.f5560b.lambda$fetchData$0(this.f5561c);
    }
}
