package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.g;
import java.util.concurrent.atomic.AtomicBoolean;
import z20.c;
import z20.d;

final class FlowableUsing$UsingSubscriber<T, D> extends AtomicBoolean implements e<T>, d {
    private static final long serialVersionUID = 5904473792286235046L;
    public final g<? super D> disposer;
    public final c<? super T> downstream;
    public final boolean eager;
    public final D resource;
    public d upstream;

    public FlowableUsing$UsingSubscriber(c<? super T> cVar, D d11, g<? super D> gVar, boolean z11) {
        this.downstream = cVar;
        this.resource = d11;
        this.disposer = gVar;
        this.eager = z11;
    }

    public void cancel() {
        if (this.eager) {
            disposeResource();
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            return;
        }
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
        disposeResource();
    }

    public void disposeResource() {
        if (compareAndSet(false, true)) {
            try {
                this.disposer.accept(this.resource);
            } catch (Throwable th2) {
                a.b(th2);
                o00.a.n(th2);
            }
        }
    }

    public void onComplete() {
        if (this.eager) {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    a.b(th2);
                    this.downstream.onError(th2);
                    return;
                }
            }
            this.upstream.cancel();
            this.downstream.onComplete();
            return;
        }
        this.downstream.onComplete();
        this.upstream.cancel();
        disposeResource();
    }

    public void onError(Throwable th2) {
        if (this.eager) {
            Throwable th3 = null;
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th4) {
                    th3 = th4;
                    a.b(th3);
                }
            }
            this.upstream.cancel();
            if (th3 != null) {
                this.downstream.onError(new CompositeException(th2, th3));
                return;
            }
            this.downstream.onError(th2);
            return;
        }
        this.downstream.onError(th2);
        this.upstream.cancel();
        disposeResource();
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j11) {
        this.upstream.request(j11);
    }
}
