package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.h;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import o00.a;
import z20.c;
import z20.d;

final class FlowableFlattenIterable$FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements e<T> {
    private static final long serialVersionUID = -3096000382929934955L;
    public volatile boolean cancelled;
    public int consumed;
    public Iterator<? extends R> current;
    public volatile boolean done;
    public final c<? super R> downstream;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public int fusionMode;
    public final int limit;
    public final h<? super T, ? extends Iterable<? extends R>> mapper;
    public final int prefetch;
    public f<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public d upstream;

    public FlowableFlattenIterable$FlattenIterableSubscriber(c<? super R> cVar, h<? super T, ? extends Iterable<? extends R>> hVar, int i11) {
        this.downstream = cVar;
        this.mapper = hVar;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, c<?> cVar, f<?> fVar) {
        if (this.cancelled) {
            this.current = null;
            fVar.clear();
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (this.error.get() != null) {
                Throwable e11 = ExceptionHelper.e(this.error);
                this.current = null;
                fVar.clear();
                cVar.onError(e11);
                return true;
            } else if (!z12) {
                return false;
            } else {
                cVar.onComplete();
                return true;
            }
        }
    }

    public void clear() {
        this.current = null;
        this.queue.clear();
    }

    public void consumedOne(boolean z11) {
        if (z11) {
            int i11 = this.consumed + 1;
            if (i11 == this.limit) {
                this.consumed = 0;
                this.upstream.request((long) i11);
                return;
            }
            this.consumed = i11;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0120, code lost:
        if (r6 == null) goto L_0x012b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r18 = this;
            r1 = r18
            int r0 = r18.getAndIncrement()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            z20.c<? super R> r2 = r1.downstream
            k00.f<T> r3 = r1.queue
            int r0 = r1.fusionMode
            r4 = 0
            r5 = 1
            if (r0 == r5) goto L_0x0015
            r0 = r5
            goto L_0x0016
        L_0x0015:
            r0 = r4
        L_0x0016:
            java.util.Iterator<? extends R> r6 = r1.current
            r7 = 0
            r8 = r5
        L_0x001a:
            if (r6 != 0) goto L_0x0080
            boolean r9 = r1.done
            java.lang.Object r10 = r3.poll()     // Catch:{ all -> 0x0062 }
            if (r10 != 0) goto L_0x0026
            r11 = r5
            goto L_0x0027
        L_0x0026:
            r11 = r4
        L_0x0027:
            boolean r9 = r1.checkTerminated(r9, r11, r2, r3)
            if (r9 == 0) goto L_0x002e
            return
        L_0x002e:
            if (r10 == 0) goto L_0x0080
            j00.h<? super T, ? extends java.lang.Iterable<? extends R>> r6 = r1.mapper     // Catch:{ all -> 0x004a }
            java.lang.Object r6 = r6.apply(r10)     // Catch:{ all -> 0x004a }
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x004a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x004a }
            boolean r9 = r6.hasNext()     // Catch:{ all -> 0x004a }
            if (r9 != 0) goto L_0x0047
            r1.consumedOne(r0)
            r6 = r7
            goto L_0x001a
        L_0x0047:
            r1.current = r6
            goto L_0x0080
        L_0x004a:
            r0 = move-exception
            io.reactivex.rxjava3.exceptions.a.b(r0)
            z20.d r3 = r1.upstream
            r3.cancel()
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.error
            io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r3, r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.e(r0)
            r2.onError(r0)
            return
        L_0x0062:
            r0 = move-exception
            r4 = r0
            io.reactivex.rxjava3.exceptions.a.b(r4)
            z20.d r0 = r1.upstream
            r0.cancel()
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r0, r4)
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.e(r0)
            r1.current = r7
            r3.clear()
            r2.onError(r0)
            return
        L_0x0080:
            if (r6 == 0) goto L_0x0123
            java.util.concurrent.atomic.AtomicLong r9 = r1.requested
            long r9 = r9.get()
            r11 = 0
            r13 = r11
        L_0x008b:
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 == 0) goto L_0x00f5
            boolean r15 = r1.done
            boolean r15 = r1.checkTerminated(r15, r4, r2, r3)
            if (r15 == 0) goto L_0x0098
            return
        L_0x0098:
            java.lang.Object r15 = r6.next()     // Catch:{ all -> 0x00db }
            java.lang.String r5 = "The iterator returned a null value"
            java.util.Objects.requireNonNull(r15, r5)     // Catch:{ all -> 0x00db }
            r2.onNext(r15)
            boolean r5 = r1.done
            boolean r5 = r1.checkTerminated(r5, r4, r2, r3)
            if (r5 == 0) goto L_0x00ad
            return
        L_0x00ad:
            r16 = 1
            long r13 = r13 + r16
            boolean r5 = r6.hasNext()     // Catch:{ all -> 0x00c0 }
            if (r5 != 0) goto L_0x00be
            r1.consumedOne(r0)
            r1.current = r7
            r6 = r7
            goto L_0x00f5
        L_0x00be:
            r5 = 1
            goto L_0x008b
        L_0x00c0:
            r0 = move-exception
            r3 = r0
            io.reactivex.rxjava3.exceptions.a.b(r3)
            r1.current = r7
            z20.d r0 = r1.upstream
            r0.cancel()
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r0, r3)
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.e(r0)
            r2.onError(r0)
            return
        L_0x00db:
            r0 = move-exception
            io.reactivex.rxjava3.exceptions.a.b(r0)
            r1.current = r7
            z20.d r3 = r1.upstream
            r3.cancel()
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.error
            io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r3, r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.e(r0)
            r2.onError(r0)
            return
        L_0x00f5:
            int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x010d
            boolean r5 = r1.done
            boolean r15 = r3.isEmpty()
            if (r15 == 0) goto L_0x0105
            if (r6 != 0) goto L_0x0105
            r15 = 1
            goto L_0x0106
        L_0x0105:
            r15 = r4
        L_0x0106:
            boolean r5 = r1.checkTerminated(r5, r15, r2, r3)
            if (r5 == 0) goto L_0x010d
            return
        L_0x010d:
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0120
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0120
            java.util.concurrent.atomic.AtomicLong r5 = r1.requested
            long r9 = -r13
            r5.addAndGet(r9)
        L_0x0120:
            if (r6 != 0) goto L_0x0123
            goto L_0x012b
        L_0x0123:
            int r5 = -r8
            int r8 = r1.addAndGet(r5)
            if (r8 != 0) goto L_0x012b
            return
        L_0x012b:
            r5 = 1
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable$FlattenIterableSubscriber.drain():void");
    }

    public boolean isEmpty() {
        return this.current == null && this.queue.isEmpty();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done || !ExceptionHelper.a(this.error, th2)) {
            a.n(th2);
            return;
        }
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        if (!this.done) {
            if (this.fusionMode != 0 || this.queue.offer(t11)) {
                drain();
            } else {
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    this.downstream.onSubscribe(this);
                    dVar.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            dVar.request((long) this.prefetch);
        }
    }

    public R poll() throws Throwable {
        Iterator<? extends R> it2 = this.current;
        while (true) {
            if (it2 == null) {
                T poll = this.queue.poll();
                if (poll != null) {
                    it2 = ((Iterable) this.mapper.apply(poll)).iterator();
                    if (it2.hasNext()) {
                        this.current = it2;
                        break;
                    }
                    it2 = null;
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        R next = it2.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        if (!it2.hasNext()) {
            this.current = null;
        }
        return next;
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }

    public int requestFusion(int i11) {
        return ((i11 & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
    }
}
