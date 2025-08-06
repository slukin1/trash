package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.internal.util.b;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

public class SubscriptionArbiter extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;
    public d actual;
    public final boolean cancelOnReplace;
    public volatile boolean cancelled;
    public final AtomicLong missedProduced = new AtomicLong();
    public final AtomicLong missedRequested = new AtomicLong();
    public final AtomicReference<d> missedSubscription = new AtomicReference<>();
    public long requested;
    public boolean unbounded;

    public SubscriptionArbiter(boolean z11) {
        this.cancelOnReplace = z11;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            drain();
        }
    }

    /* access modifiers changed from: package-private */
    public final void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* access modifiers changed from: package-private */
    public final void drainLoop() {
        int i11 = 1;
        d dVar = null;
        long j11 = 0;
        do {
            d dVar2 = this.missedSubscription.get();
            if (dVar2 != null) {
                dVar2 = this.missedSubscription.getAndSet((Object) null);
            }
            long j12 = this.missedRequested.get();
            if (j12 != 0) {
                j12 = this.missedRequested.getAndSet(0);
            }
            long j13 = this.missedProduced.get();
            if (j13 != 0) {
                j13 = this.missedProduced.getAndSet(0);
            }
            d dVar3 = this.actual;
            if (this.cancelled) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.actual = null;
                }
                if (dVar2 != null) {
                    dVar2.cancel();
                }
            } else {
                long j14 = this.requested;
                if (j14 != Long.MAX_VALUE) {
                    j14 = b.c(j14, j12);
                    if (j14 != Long.MAX_VALUE) {
                        j14 -= j13;
                        if (j14 < 0) {
                            SubscriptionHelper.reportMoreProduced(j14);
                            j14 = 0;
                        }
                    }
                    this.requested = j14;
                }
                if (dVar2 != null) {
                    if (dVar3 != null && this.cancelOnReplace) {
                        dVar3.cancel();
                    }
                    this.actual = dVar2;
                    if (j14 != 0) {
                        j11 = b.c(j11, j14);
                        dVar = dVar2;
                    }
                } else if (!(dVar3 == null || j12 == 0)) {
                    j11 = b.c(j11, j12);
                    dVar = dVar3;
                }
            }
            i11 = addAndGet(-i11);
        } while (i11 != 0);
        if (j11 != 0) {
            dVar.request(j11);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j11) {
        if (!this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                b.a(this.missedProduced, j11);
                drain();
                return;
            }
            long j12 = this.requested;
            if (j12 != Long.MAX_VALUE) {
                long j13 = j12 - j11;
                if (j13 < 0) {
                    SubscriptionHelper.reportMoreProduced(j13);
                    j13 = 0;
                }
                this.requested = j13;
            }
            if (decrementAndGet() != 0) {
                drainLoop();
            }
        }
    }

    public final void request(long j11) {
        if (SubscriptionHelper.validate(j11) && !this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                b.a(this.missedRequested, j11);
                drain();
                return;
            }
            long j12 = this.requested;
            if (j12 != Long.MAX_VALUE) {
                long c11 = b.c(j12, j11);
                this.requested = c11;
                if (c11 == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            d dVar = this.actual;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (dVar != null) {
                dVar.request(j11);
            }
        }
    }

    public final void setSubscription(d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        Objects.requireNonNull(dVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            d andSet = this.missedSubscription.getAndSet(dVar);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            drain();
            return;
        }
        d dVar2 = this.actual;
        if (dVar2 != null && this.cancelOnReplace) {
            dVar2.cancel();
        }
        this.actual = dVar;
        long j11 = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j11 != 0) {
            dVar.request(j11);
        }
    }
}
