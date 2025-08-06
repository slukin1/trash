package io.reactivex.rxjava3.internal.observers;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.g;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import l00.a;

public final class InnerQueuedObserver<T> extends AtomicReference<b> implements k<T>, b {
    private static final long serialVersionUID = -5417183359794346637L;
    public volatile boolean done;
    public int fusionMode;
    public final a<T> parent;
    public final int prefetch;
    public f<T> queue;

    public InnerQueuedObserver(a<T> aVar, int i11) {
        this.parent = aVar;
        this.prefetch = i11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public boolean isDone() {
        return this.done;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(this, th2);
    }

    public void onNext(T t11) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t11);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof k00.b) {
                k00.b bVar2 = (k00.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    return;
                }
            }
            this.queue = g.a(-this.prefetch);
        }
    }

    public f<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
