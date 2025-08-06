package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import z20.c;

public final class MaybeToFlowable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final g<T> f55547c;

    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements f<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        public b upstream;

        public MaybeToFlowableSubscriber(c<? super T> cVar) {
            super(cVar);
        }

        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        public void onComplete() {
            this.downstream.onComplete();
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

    public MaybeToFlowable(g<T> gVar) {
        this.f55547c = gVar;
    }

    public void j(c<? super T> cVar) {
        this.f55547c.a(new MaybeToFlowableSubscriber(cVar));
    }
}
