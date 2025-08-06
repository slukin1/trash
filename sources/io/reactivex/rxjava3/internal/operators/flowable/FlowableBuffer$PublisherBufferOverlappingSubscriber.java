package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import io.reactivex.rxjava3.internal.util.g;
import j00.k;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.c;
import z20.d;

final class FlowableBuffer$PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements e<T>, d, j00.e {
    private static final long serialVersionUID = -7370244972039324525L;
    public final k<C> bufferSupplier;
    public final ArrayDeque<C> buffers = new ArrayDeque<>();
    public volatile boolean cancelled;
    public boolean done;
    public final c<? super C> downstream;
    public int index;
    public final AtomicBoolean once = new AtomicBoolean();
    public long produced;
    public final int size;
    public final int skip;
    public d upstream;

    public FlowableBuffer$PublisherBufferOverlappingSubscriber(c<? super C> cVar, int i11, int i12, k<C> kVar) {
        this.downstream = cVar;
        this.size = i11;
        this.skip = i12;
        this.bufferSupplier = kVar;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public boolean getAsBoolean() {
        return this.cancelled;
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            long j11 = this.produced;
            if (j11 != 0) {
                b.e(this, j11);
            }
            g.c(this.downstream, this.buffers, this, this);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.buffers.clear();
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            ArrayDeque<C> arrayDeque = this.buffers;
            int i11 = this.index;
            int i12 = i11 + 1;
            if (i11 == 0) {
                try {
                    C c11 = this.bufferSupplier.get();
                    Objects.requireNonNull(c11, "The bufferSupplier returned a null buffer");
                    arrayDeque.offer((Collection) c11);
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    cancel();
                    onError(th2);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t11);
                this.produced++;
                this.downstream.onNext(collection);
            }
            Iterator<C> it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                ((Collection) it2.next()).add(t11);
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
        if (SubscriptionHelper.validate(j11)) {
            if (!g.e(j11, this.downstream, this.buffers, this, this)) {
                if (this.once.get() || !this.once.compareAndSet(false, true)) {
                    this.upstream.request(b.d((long) this.skip, j11));
                    return;
                }
                this.upstream.request(b.c((long) this.size, b.d((long) this.skip, j11 - 1)));
            }
        }
    }
}
