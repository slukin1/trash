package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable f5557b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f5558c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f5559d;

    public /* synthetic */ c0(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter2) {
        this.f5557b = liveDataObservable;
        this.f5558c = liveDataObserverAdapter;
        this.f5559d = liveDataObserverAdapter2;
    }

    public final void run() {
        this.f5557b.lambda$addObserver$2(this.f5558c, this.f5559d);
    }
}
