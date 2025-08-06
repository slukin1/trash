package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import h00.o;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import z20.c;

public final class SingleToFlowable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final o<? extends T> f55605c;

    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements m<T> {
        private static final long serialVersionUID = 187782011903685568L;
        public b upstream;

        public SingleToFlowableObserver(c<? super T> cVar) {
            super(cVar);
        }

        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public SingleToFlowable(o<? extends T> oVar) {
        this.f55605c = oVar;
    }

    public void j(c<? super T> cVar) {
        this.f55605c.a(new SingleToFlowableObserver(cVar));
    }
}
