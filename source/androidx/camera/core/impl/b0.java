package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable f5554b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f5555c;

    public /* synthetic */ b0(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter) {
        this.f5554b = liveDataObservable;
        this.f5555c = liveDataObserverAdapter;
    }

    public final void run() {
        this.f5554b.lambda$removeObserver$3(this.f5555c);
    }
}
