package io.reactivex.rxjava3.internal.operators.flowable;

import h00.c;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.g;
import java.util.concurrent.atomic.AtomicLong;
import z20.d;

final class FlowableGenerate$GeneratorSubscription<T, S> extends AtomicLong implements c<T>, d {
    private static final long serialVersionUID = 7565982551505011832L;
    public volatile boolean cancelled;
    public final g<? super S> disposeState;
    public final z20.c<? super T> downstream;
    public final j00.c<S, ? super c<T>, S> generator;
    public boolean hasNext;
    public S state;
    public boolean terminate;

    public FlowableGenerate$GeneratorSubscription(z20.c<? super T> cVar, j00.c<S, ? super c<T>, S> cVar2, g<? super S> gVar, S s11) {
        this.downstream = cVar;
        this.generator = cVar2;
        this.disposeState = gVar;
        this.state = s11;
    }

    private void dispose(S s11) {
        try {
            this.disposeState.accept(s11);
        } catch (Throwable th2) {
            a.b(th2);
            o00.a.n(th2);
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            if (b.a(this, 1) == 0) {
                S s11 = this.state;
                this.state = null;
                dispose(s11);
            }
        }
    }

    public void onComplete() {
        if (!this.terminate) {
            this.terminate = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.terminate) {
            o00.a.n(th2);
            return;
        }
        if (th2 == null) {
            th2 = ExceptionHelper.b("onError called with a null Throwable.");
        }
        this.terminate = true;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (this.terminate) {
            return;
        }
        if (this.hasNext) {
            onError(new IllegalStateException("onNext already called in this generate turn"));
        } else if (t11 == null) {
            onError(ExceptionHelper.b("onNext called with a null value."));
        } else {
            this.hasNext = true;
            this.downstream.onNext(t11);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11) && b.a(this, j11) == 0) {
            S s11 = this.state;
            j00.c<S, ? super c<T>, S> cVar = this.generator;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11) {
                        j11 = get();
                        if (j12 == j11) {
                            this.state = s11;
                            j11 = addAndGet(-j12);
                        }
                    } else if (this.cancelled) {
                        this.state = null;
                        dispose(s11);
                        return;
                    } else {
                        this.hasNext = false;
                        try {
                            s11 = cVar.apply(s11, this);
                            if (this.terminate) {
                                this.cancelled = true;
                                this.state = null;
                                dispose(s11);
                                return;
                            }
                            j12++;
                        } catch (Throwable th2) {
                            a.b(th2);
                            this.cancelled = true;
                            this.state = null;
                            onError(th2);
                            dispose(s11);
                            return;
                        }
                    }
                }
            } while (j11 != 0);
        }
    }
}
