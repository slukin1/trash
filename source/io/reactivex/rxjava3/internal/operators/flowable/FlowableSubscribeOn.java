package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.b;
import z20.c;
import z20.d;

public final class FlowableSubscribeOn<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f55496d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f55497e;

    public static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements e<T>, d, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        public final c<? super T> downstream;
        public final boolean nonScheduledRequests;
        public final AtomicLong requested = new AtomicLong();
        public b<T> source;
        public final AtomicReference<d> upstream = new AtomicReference<>();
        public final Scheduler.Worker worker;

        public static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final d f55498b;

            /* renamed from: c  reason: collision with root package name */
            public final long f55499c;

            public a(d dVar, long j11) {
                this.f55498b = dVar;
                this.f55499c = j11;
            }

            public void run() {
                this.f55498b.request(this.f55499c);
            }
        }

        public SubscribeOnSubscriber(c<? super T> cVar, Scheduler.Worker worker2, b<T> bVar, boolean z11) {
            this.downstream = cVar;
            this.worker = worker2;
            this.source = bVar;
            this.nonScheduledRequests = !z11;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        public void onNext(T t11) {
            this.downstream.onNext(t11);
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                d dVar = this.upstream.get();
                if (dVar != null) {
                    requestUpstream(j11, dVar);
                    return;
                }
                io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
                d dVar2 = this.upstream.get();
                if (dVar2 != null) {
                    long andSet = this.requested.getAndSet(0);
                    if (andSet != 0) {
                        requestUpstream(andSet, dVar2);
                    }
                }
            }
        }

        public void requestUpstream(long j11, d dVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                dVar.request(j11);
            } else {
                this.worker.b(new a(dVar, j11));
            }
        }

        public void run() {
            lazySet(Thread.currentThread());
            b<T> bVar = this.source;
            this.source = null;
            bVar.subscribe(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f55496d = scheduler;
        this.f55497e = z11;
    }

    public void j(c<? super T> cVar) {
        Scheduler.Worker a11 = this.f55496d.a();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(cVar, a11, this.f55511c, this.f55497e);
        cVar.onSubscribe(subscribeOnSubscriber);
        a11.b(subscribeOnSubscriber);
    }
}
