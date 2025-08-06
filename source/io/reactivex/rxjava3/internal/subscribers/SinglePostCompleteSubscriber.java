package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements e<T>, d {
    public static final long COMPLETE_MASK = Long.MIN_VALUE;
    public static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    public final c<? super R> downstream;
    public long produced;
    public d upstream;
    public R value;

    public SinglePostCompleteSubscriber(c<? super R> cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public final void complete(R r11) {
        long j11 = this.produced;
        if (j11 != 0) {
            b.e(this, j11);
        }
        while (true) {
            long j12 = get();
            if ((j12 & Long.MIN_VALUE) != 0) {
                onDrop(r11);
                return;
            } else if ((j12 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.downstream.onNext(r11);
                this.downstream.onComplete();
                return;
            } else {
                this.value = r11;
                if (!compareAndSet(0, Long.MIN_VALUE)) {
                    this.value = null;
                } else {
                    return;
                }
            }
        }
    }

    public abstract /* synthetic */ void onComplete();

    public void onDrop(R r11) {
    }

    public abstract /* synthetic */ void onError(Throwable th2);

    public abstract /* synthetic */ void onNext(T t11);

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    public final void request(long j11) {
        long j12;
        if (SubscriptionHelper.validate(j11)) {
            do {
                j12 = get();
                if ((j12 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.downstream.onNext(this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j12, b.c(j12, j11)));
            this.upstream.request(j11);
        }
    }
}
