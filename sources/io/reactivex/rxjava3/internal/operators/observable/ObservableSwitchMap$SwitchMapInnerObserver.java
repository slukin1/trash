package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;

final class ObservableSwitchMap$SwitchMapInnerObserver<T, R> extends AtomicReference<b> implements k<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    public final int bufferSize;
    public volatile boolean done;
    public final long index;
    public final ObservableSwitchMap$SwitchMapObserver<T, R> parent;
    public volatile f<R> queue;

    public ObservableSwitchMap$SwitchMapInnerObserver(ObservableSwitchMap$SwitchMapObserver<T, R> observableSwitchMap$SwitchMapObserver, long j11, int i11) {
        this.parent = observableSwitchMap$SwitchMapObserver;
        this.index = j11;
        this.bufferSize = i11;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        if (this.index == this.parent.unique) {
            this.done = true;
            this.parent.drain();
        }
    }

    public void onError(Throwable th2) {
        this.parent.innerError(this, th2);
    }

    public void onNext(R r11) {
        if (this.index == this.parent.unique) {
            if (r11 != null) {
                this.queue.offer(r11);
            }
            this.parent.drain();
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof k00.b) {
                k00.b bVar2 = (k00.b) bVar;
                int requestFusion = bVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.queue = bVar2;
                    return;
                }
            }
            this.queue = new a(this.bufferSize);
        }
    }
}
