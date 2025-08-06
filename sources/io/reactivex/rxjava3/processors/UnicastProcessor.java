package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f55735c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Runnable> f55736d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f55737e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f55738f;

    /* renamed from: g  reason: collision with root package name */
    public Throwable f55739g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<c<? super T>> f55740h = new AtomicReference<>();

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f55741i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicBoolean f55742j = new AtomicBoolean();

    /* renamed from: k  reason: collision with root package name */
    public final BasicIntQueueSubscription<T> f55743k = new UnicastQueueSubscription();

    /* renamed from: l  reason: collision with root package name */
    public final AtomicLong f55744l = new AtomicLong();

    /* renamed from: m  reason: collision with root package name */
    public boolean f55745m;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        public void cancel() {
            if (!UnicastProcessor.this.f55741i) {
                UnicastProcessor.this.f55741i = true;
                UnicastProcessor.this.q();
                UnicastProcessor.this.f55740h.lazySet((Object) null);
                if (UnicastProcessor.this.f55743k.getAndIncrement() == 0) {
                    UnicastProcessor.this.f55740h.lazySet((Object) null);
                    UnicastProcessor unicastProcessor = UnicastProcessor.this;
                    if (!unicastProcessor.f55745m) {
                        unicastProcessor.f55735c.clear();
                    }
                }
            }
        }

        public void clear() {
            UnicastProcessor.this.f55735c.clear();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.f55735c.isEmpty();
        }

        public T poll() {
            return UnicastProcessor.this.f55735c.poll();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                b.a(UnicastProcessor.this.f55744l, j11);
                UnicastProcessor.this.r();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f55745m = true;
            return 2;
        }
    }

    public UnicastProcessor(int i11, Runnable runnable, boolean z11) {
        this.f55735c = new a<>(i11);
        this.f55736d = new AtomicReference<>(runnable);
        this.f55737e = z11;
    }

    public static <T> UnicastProcessor<T> n() {
        return new UnicastProcessor<>(Flowable.b(), (Runnable) null, true);
    }

    public static <T> UnicastProcessor<T> o(int i11, Runnable runnable) {
        return p(i11, runnable, true);
    }

    public static <T> UnicastProcessor<T> p(int i11, Runnable runnable, boolean z11) {
        Objects.requireNonNull(runnable, "onTerminate");
        io.reactivex.rxjava3.internal.functions.a.a(i11, "capacityHint");
        return new UnicastProcessor<>(i11, runnable, z11);
    }

    public void j(c<? super T> cVar) {
        if (this.f55742j.get() || !this.f55742j.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.onSubscribe(this.f55743k);
        this.f55740h.set(cVar);
        if (this.f55741i) {
            this.f55740h.lazySet((Object) null);
        } else {
            r();
        }
    }

    public boolean m(boolean z11, boolean z12, boolean z13, c<? super T> cVar, a<T> aVar) {
        if (this.f55741i) {
            aVar.clear();
            this.f55740h.lazySet((Object) null);
            return true;
        } else if (!z12) {
            return false;
        } else {
            if (z11 && this.f55739g != null) {
                aVar.clear();
                this.f55740h.lazySet((Object) null);
                cVar.onError(this.f55739g);
                return true;
            } else if (!z13) {
                return false;
            } else {
                Throwable th2 = this.f55739g;
                this.f55740h.lazySet((Object) null);
                if (th2 != null) {
                    cVar.onError(th2);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
        }
    }

    public void onComplete() {
        if (!this.f55738f && !this.f55741i) {
            this.f55738f = true;
            q();
            r();
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f55738f || this.f55741i) {
            o00.a.n(th2);
            return;
        }
        this.f55739g = th2;
        this.f55738f = true;
        q();
        r();
    }

    public void onNext(T t11) {
        ExceptionHelper.c(t11, "onNext called with a null value.");
        if (!this.f55738f && !this.f55741i) {
            this.f55735c.offer(t11);
            r();
        }
    }

    public void onSubscribe(d dVar) {
        if (this.f55738f || this.f55741i) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void q() {
        Runnable andSet = this.f55736d.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    public void r() {
        if (this.f55743k.getAndIncrement() == 0) {
            int i11 = 1;
            c cVar = this.f55740h.get();
            while (cVar == null) {
                i11 = this.f55743k.addAndGet(-i11);
                if (i11 != 0) {
                    cVar = this.f55740h.get();
                } else {
                    return;
                }
            }
            if (this.f55745m) {
                s(cVar);
            } else {
                t(cVar);
            }
        }
    }

    public void s(c<? super T> cVar) {
        a<T> aVar = this.f55735c;
        int i11 = 1;
        boolean z11 = !this.f55737e;
        while (!this.f55741i) {
            boolean z12 = this.f55738f;
            if (!z11 || !z12 || this.f55739g == null) {
                cVar.onNext(null);
                if (z12) {
                    this.f55740h.lazySet((Object) null);
                    Throwable th2 = this.f55739g;
                    if (th2 != null) {
                        cVar.onError(th2);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                } else {
                    i11 = this.f55743k.addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            } else {
                aVar.clear();
                this.f55740h.lazySet((Object) null);
                cVar.onError(this.f55739g);
                return;
            }
        }
        this.f55740h.lazySet((Object) null);
    }

    public void t(c<? super T> cVar) {
        int i11;
        long j11;
        a<T> aVar = this.f55735c;
        boolean z11 = true;
        boolean z12 = !this.f55737e;
        int i12 = 1;
        while (true) {
            long j12 = this.f55744l.get();
            long j13 = 0;
            while (true) {
                i11 = (j12 > j13 ? 1 : (j12 == j13 ? 0 : -1));
                if (i11 == 0) {
                    j11 = j13;
                    break;
                }
                boolean z13 = this.f55738f;
                T poll = aVar.poll();
                boolean z14 = poll == null ? z11 : false;
                T t11 = poll;
                j11 = j13;
                if (!m(z12, z13, z14, cVar, aVar)) {
                    if (z14) {
                        break;
                    }
                    cVar.onNext(t11);
                    j13 = 1 + j11;
                    z11 = true;
                } else {
                    return;
                }
            }
            c<? super T> cVar2 = cVar;
            if (i11 == 0) {
                if (m(z12, this.f55738f, aVar.isEmpty(), cVar, aVar)) {
                    return;
                }
            }
            if (!(j11 == 0 || j12 == Long.MAX_VALUE)) {
                this.f55744l.addAndGet(-j11);
            }
            i12 = this.f55743k.addAndGet(-i12);
            if (i12 != 0) {
                z11 = true;
            } else {
                return;
            }
        }
    }
}
