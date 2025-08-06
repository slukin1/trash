package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.k;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import o00.a;
import z20.c;
import z20.d;

final class FlowableBuffer$PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -5616169793639412593L;
    public C buffer;
    public final k<C> bufferSupplier;
    public boolean done;
    public final c<? super C> downstream;
    public int index;
    public final int size;
    public final int skip;
    public d upstream;

    public FlowableBuffer$PublisherBufferSkipSubscriber(c<? super C> cVar, int i11, int i12, k<C> kVar) {
        this.downstream = cVar;
        this.size = i11;
        this.skip = i12;
        this.bufferSupplier = kVar;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            C c11 = this.buffer;
            this.buffer = null;
            if (c11 != null) {
                this.downstream.onNext(c11);
            }
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.buffer = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            C c11 = this.buffer;
            int i11 = this.index;
            int i12 = i11 + 1;
            if (i11 == 0) {
                try {
                    C c12 = this.bufferSupplier.get();
                    Objects.requireNonNull(c12, "The bufferSupplier returned a null buffer");
                    c11 = (Collection) c12;
                    this.buffer = c11;
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    cancel();
                    onError(th2);
                    return;
                }
            }
            if (c11 != null) {
                c11.add(t11);
                if (c11.size() == this.size) {
                    this.buffer = null;
                    this.downstream.onNext(c11);
                }
            }
            if (i12 == this.skip) {
                i12 = 0;
            }
            this.index = i12;
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j11) {
        if (!SubscriptionHelper.validate(j11)) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            this.upstream.request(b.d((long) this.skip, j11));
            return;
        }
        this.upstream.request(b.c(b.d(j11, (long) this.size), b.d((long) (this.skip - this.size), j11 - 1)));
    }
}
