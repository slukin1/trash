package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f5562b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable.Result f5563c;

    public /* synthetic */ e0(LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.Result result) {
        this.f5562b = liveDataObserverAdapter;
        this.f5563c = result;
    }

    public final void run() {
        this.f5562b.lambda$onChanged$0(this.f5563c);
    }
}
