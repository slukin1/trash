package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.c;
import z20.d;

public final class FlowableRefCount<T> extends Flowable<T> {

    public static final class RefConnection extends AtomicReference<b> implements Runnable, g<b> {
        private static final long serialVersionUID = -4552101107598366241L;
        public boolean connected;
        public boolean disconnectedEarly;
        public final FlowableRefCount<?> parent;
        public long subscriberCount;
        public b timer;

        public RefConnection(FlowableRefCount<?> flowableRefCount) {
        }

        public void run() {
            throw null;
        }

        public void accept(b bVar) {
            DisposableHelper.replace(this, bVar);
            throw null;
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements e<T>, d {
        private static final long serialVersionUID = -7419642935409022375L;
        public final RefConnection connection;
        public final c<? super T> downstream;
        public final FlowableRefCount<T> parent;
        public d upstream;

        public RefCountSubscriber(c<? super T> cVar, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.downstream = cVar;
            this.connection = refConnection;
        }

        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public void onError(Throwable th2) {
            if (!compareAndSet(false, true)) {
                a.n(th2);
                return;
            }
            throw null;
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
}
