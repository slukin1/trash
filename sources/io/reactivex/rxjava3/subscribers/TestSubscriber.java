package io.reactivex.rxjava3.subscribers;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements e<T>, d {

    /* renamed from: h  reason: collision with root package name */
    public final c<? super T> f55789h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f55790i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicReference<d> f55791j;

    /* renamed from: k  reason: collision with root package name */
    public final AtomicLong f55792k;

    public enum EmptySubscriber implements e<Object> {
        INSTANCE;

        public void onComplete() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }

        public void onSubscribe(d dVar) {
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public void a() {
    }

    public final void cancel() {
        if (!this.f55790i) {
            this.f55790i = true;
            SubscriptionHelper.cancel(this.f55791j);
        }
    }

    public void onComplete() {
        if (!this.f55719g) {
            this.f55719g = true;
            if (this.f55791j.get() == null) {
                this.f55716d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f55718f = Thread.currentThread();
            this.f55717e++;
            this.f55789h.onComplete();
        } finally {
            this.f55714b.countDown();
        }
    }

    public void onError(Throwable th2) {
        if (!this.f55719g) {
            this.f55719g = true;
            if (this.f55791j.get() == null) {
                this.f55716d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f55718f = Thread.currentThread();
            if (th2 == null) {
                this.f55716d.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f55716d.add(th2);
            }
            this.f55789h.onError(th2);
        } finally {
            this.f55714b.countDown();
        }
    }

    public void onNext(T t11) {
        if (!this.f55719g) {
            this.f55719g = true;
            if (this.f55791j.get() == null) {
                this.f55716d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f55718f = Thread.currentThread();
        this.f55715c.add(t11);
        if (t11 == null) {
            this.f55716d.add(new NullPointerException("onNext received a null value"));
        }
        this.f55789h.onNext(t11);
    }

    public void onSubscribe(d dVar) {
        this.f55718f = Thread.currentThread();
        if (dVar == null) {
            this.f55716d.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f55791j.compareAndSet((Object) null, dVar)) {
            dVar.cancel();
            if (this.f55791j.get() != SubscriptionHelper.CANCELLED) {
                List<Throwable> list = this.f55716d;
                list.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + dVar));
            }
        } else {
            this.f55789h.onSubscribe(dVar);
            long andSet = this.f55792k.getAndSet(0);
            if (andSet != 0) {
                dVar.request(andSet);
            }
            a();
        }
    }

    public final void request(long j11) {
        SubscriptionHelper.deferredRequest(this.f55791j, this.f55792k, j11);
    }

    public TestSubscriber(c<? super T> cVar, long j11) {
        if (j11 >= 0) {
            this.f55789h = cVar;
            this.f55791j = new AtomicReference<>();
            this.f55792k = new AtomicLong(j11);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
