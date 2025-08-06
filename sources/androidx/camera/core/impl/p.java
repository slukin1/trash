package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConstantObservable f5576b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable.Observer f5577c;

    public /* synthetic */ p(ConstantObservable constantObservable, Observable.Observer observer) {
        this.f5576b = constantObservable;
        this.f5577c = observer;
    }

    public final void run() {
        this.f5576b.lambda$addObserver$0(this.f5577c);
    }
}
