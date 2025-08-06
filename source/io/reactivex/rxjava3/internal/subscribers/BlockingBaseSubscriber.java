package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.c;
import java.util.concurrent.CountDownLatch;
import z20.d;

public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f55694b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f55695c;

    /* renamed from: d  reason: collision with root package name */
    public d f55696d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f55697e;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                c.a();
                await();
            } catch (InterruptedException e11) {
                d dVar = this.f55696d;
                this.f55696d = SubscriptionHelper.CANCELLED;
                if (dVar != null) {
                    dVar.cancel();
                }
                throw ExceptionHelper.g(e11);
            }
        }
        Throwable th2 = this.f55695c;
        if (th2 == null) {
            return this.f55694b;
        }
        throw ExceptionHelper.g(th2);
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.f55696d, dVar)) {
            this.f55696d = dVar;
            if (!this.f55697e) {
                dVar.request(Long.MAX_VALUE);
                if (this.f55697e) {
                    this.f55696d = SubscriptionHelper.CANCELLED;
                    dVar.cancel();
                }
            }
        }
    }
}
