package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import i00.a;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.h;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends AtomicLong implements e<T>, d {
    public static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    public final int bufferSize;
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final boolean delayError;
    public boolean done;
    public final c<? super a<K, V>> downstream;
    public long emittedGroups;
    public final Queue<f<K, V>> evictedGroups;
    public final AtomicLong groupConsumed = new AtomicLong();
    public final AtomicInteger groupCount = new AtomicInteger(1);
    public final Map<Object, f<K, V>> groups;
    public final h<? super T, ? extends K> keySelector;
    public final int limit;
    public d upstream;
    public final h<? super T, ? extends V> valueSelector;

    public FlowableGroupBy$GroupBySubscriber(c<? super a<K, V>> cVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i11, boolean z11, Map<Object, f<K, V>> map, Queue<f<K, V>> queue) {
        this.downstream = cVar;
        this.keySelector = hVar;
        this.valueSelector = hVar2;
        this.bufferSize = i11;
        this.limit = i11 - (i11 >> 2);
        this.delayError = z11;
        this.groups = map;
        this.evictedGroups = queue;
    }

    private void completeEvictions() {
        if (this.evictedGroups != null) {
            int i11 = 0;
            while (true) {
                f poll = this.evictedGroups.poll();
                if (poll == null) {
                    break;
                }
                poll.onComplete();
                i11++;
            }
            if (i11 != 0) {
                this.groupCount.addAndGet(-i11);
            }
        }
    }

    public static String groupHangWarning(long j11) {
        return "Unable to emit a new group (#" + j11 + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.";
    }

    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            completeEvictions();
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public void onComplete() {
        if (!this.done) {
            for (f<K, V> onComplete : this.groups.values()) {
                onComplete.onComplete();
            }
            this.groups.clear();
            Queue<f<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.done = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            o00.a.n(th2);
            return;
        }
        this.done = true;
        for (f<K, V> onError : this.groups.values()) {
            onError.onError(th2);
        }
        this.groups.clear();
        Queue<f<K, V>> queue = this.evictedGroups;
        if (queue != null) {
            queue.clear();
        }
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        Object obj;
        if (!this.done) {
            try {
                Object apply = this.keySelector.apply(t11);
                boolean z11 = false;
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                f fVar = this.groups.get(obj);
                if (fVar == null) {
                    if (!this.cancelled.get()) {
                        fVar = f.m(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, fVar);
                        this.groupCount.getAndIncrement();
                        z11 = true;
                    } else {
                        return;
                    }
                }
                try {
                    fVar.onNext(ExceptionHelper.c(this.valueSelector.apply(t11), "The valueSelector returned a null value."));
                    completeEvictions();
                    if (!z11) {
                        return;
                    }
                    if (this.emittedGroups != get()) {
                        this.emittedGroups++;
                        this.downstream.onNext(fVar);
                        if (fVar.f55516d.tryAbandon()) {
                            cancel(apply);
                            fVar.onComplete();
                            requestGroup(1);
                            return;
                        }
                        return;
                    }
                    this.upstream.cancel();
                    onError(new MissingBackpressureException(groupHangWarning(this.emittedGroups)));
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    this.upstream.cancel();
                    if (z11) {
                        if (this.emittedGroups != get()) {
                            this.downstream.onNext(fVar);
                        } else {
                            MissingBackpressureException missingBackpressureException = new MissingBackpressureException(groupHangWarning(this.emittedGroups));
                            missingBackpressureException.initCause(th2);
                            onError(missingBackpressureException);
                            return;
                        }
                    }
                    onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.rxjava3.exceptions.a.b(th3);
                this.upstream.cancel();
                onError(th3);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request((long) this.bufferSize);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this, j11);
        }
    }

    public void requestGroup(long j11) {
        long j12;
        long c11;
        AtomicLong atomicLong = this.groupConsumed;
        int i11 = this.limit;
        do {
            j12 = atomicLong.get();
            c11 = b.c(j12, j11);
        } while (!atomicLong.compareAndSet(j12, c11));
        while (true) {
            long j13 = (long) i11;
            if (c11 >= j13) {
                if (atomicLong.compareAndSet(c11, c11 - j13)) {
                    this.upstream.request(j13);
                }
                c11 = atomicLong.get();
            } else {
                return;
            }
        }
    }

    public void cancel(K k11) {
        if (k11 == null) {
            k11 = NULL_KEY;
        }
        this.groups.remove(k11);
        if (this.groupCount.decrementAndGet() == 0) {
            this.upstream.cancel();
        }
    }
}
