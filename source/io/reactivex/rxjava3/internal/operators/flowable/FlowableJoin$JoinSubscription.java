package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j00.h;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import z20.b;
import z20.c;
import z20.d;

final class FlowableJoin$JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements d, g {
    public static final Integer LEFT_CLOSE = 3;
    public static final Integer LEFT_VALUE = 1;
    public static final Integer RIGHT_CLOSE = 4;
    public static final Integer RIGHT_VALUE = 2;
    private static final long serialVersionUID = -6071216598687999801L;
    public final AtomicInteger active;
    public volatile boolean cancelled;
    public final CompositeDisposable disposables = new CompositeDisposable();
    public final c<? super R> downstream;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final h<? super TLeft, ? extends b<TLeftEnd>> leftEnd;
    public int leftIndex;
    public final Map<Integer, TLeft> lefts = new LinkedHashMap();
    public final a<Object> queue = new a<>(Flowable.b());
    public final AtomicLong requested = new AtomicLong();
    public final j00.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
    public final h<? super TRight, ? extends b<TRightEnd>> rightEnd;
    public int rightIndex;
    public final Map<Integer, TRight> rights = new LinkedHashMap();

    public FlowableJoin$JoinSubscription(c<? super R> cVar, h<? super TLeft, ? extends b<TLeftEnd>> hVar, h<? super TRight, ? extends b<TRightEnd>> hVar2, j00.c<? super TLeft, ? super TRight, ? extends R> cVar2) {
        this.downstream = cVar;
        this.leftEnd = hVar;
        this.rightEnd = hVar2;
        this.resultSelector = cVar2;
        this.active = new AtomicInteger(2);
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            a<Object> aVar = this.queue;
            c<? super R> cVar = this.downstream;
            boolean z11 = true;
            int i11 = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    aVar.clear();
                    cancelAll();
                    errorAll(cVar);
                    return;
                }
                boolean z12 = this.active.get() == 0 ? z11 : false;
                Integer num = (Integer) aVar.poll();
                boolean z13 = num == null ? z11 : false;
                if (z12 && z13) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    cVar.onComplete();
                    return;
                } else if (z13) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    Object poll = aVar.poll();
                    if (num == LEFT_VALUE) {
                        int i12 = this.leftIndex;
                        this.leftIndex = i12 + 1;
                        this.lefts.put(Integer.valueOf(i12), poll);
                        try {
                            Object apply = this.leftEnd.apply(poll);
                            Objects.requireNonNull(apply, "The leftEnd returned a null Publisher");
                            b bVar = (b) apply;
                            FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber = new FlowableGroupJoin$LeftRightEndSubscriber(this, z11, i12);
                            this.disposables.a(flowableGroupJoin$LeftRightEndSubscriber);
                            bVar.subscribe(flowableGroupJoin$LeftRightEndSubscriber);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(cVar);
                                return;
                            }
                            long j11 = this.requested.get();
                            long j12 = 0;
                            for (TRight apply2 : this.rights.values()) {
                                try {
                                    Object apply3 = this.resultSelector.apply(poll, apply2);
                                    Objects.requireNonNull(apply3, "The resultSelector returned a null value");
                                    if (j12 != j11) {
                                        cVar.onNext(apply3);
                                        j12++;
                                    } else {
                                        ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        aVar.clear();
                                        cancelAll();
                                        errorAll(cVar);
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    fail(th2, cVar, aVar);
                                    return;
                                }
                            }
                            if (j12 != 0) {
                                io.reactivex.rxjava3.internal.util.b.e(this.requested, j12);
                            }
                        } catch (Throwable th3) {
                            fail(th3, cVar, aVar);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i13 = this.rightIndex;
                        this.rightIndex = i13 + 1;
                        this.rights.put(Integer.valueOf(i13), poll);
                        try {
                            Object apply4 = this.rightEnd.apply(poll);
                            Objects.requireNonNull(apply4, "The rightEnd returned a null Publisher");
                            b bVar2 = (b) apply4;
                            FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber2 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, i13);
                            this.disposables.a(flowableGroupJoin$LeftRightEndSubscriber2);
                            bVar2.subscribe(flowableGroupJoin$LeftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(cVar);
                                return;
                            }
                            long j13 = this.requested.get();
                            long j14 = 0;
                            for (TLeft apply5 : this.lefts.values()) {
                                try {
                                    Object apply6 = this.resultSelector.apply(apply5, poll);
                                    Objects.requireNonNull(apply6, "The resultSelector returned a null value");
                                    if (j14 != j13) {
                                        cVar.onNext(apply6);
                                        j14++;
                                    } else {
                                        ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        aVar.clear();
                                        cancelAll();
                                        errorAll(cVar);
                                        return;
                                    }
                                } catch (Throwable th4) {
                                    fail(th4, cVar, aVar);
                                    return;
                                }
                            }
                            if (j14 != 0) {
                                io.reactivex.rxjava3.internal.util.b.e(this.requested, j14);
                            }
                        } catch (Throwable th5) {
                            fail(th5, cVar, aVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber3 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                        this.lefts.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber3.index));
                        this.disposables.c(flowableGroupJoin$LeftRightEndSubscriber3);
                    } else {
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber4 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                        this.rights.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber4.index));
                        this.disposables.c(flowableGroupJoin$LeftRightEndSubscriber4);
                    }
                    z11 = true;
                }
            }
            aVar.clear();
        }
    }

    public void errorAll(c<?> cVar) {
        Throwable e11 = ExceptionHelper.e(this.error);
        this.lefts.clear();
        this.rights.clear();
        cVar.onError(e11);
    }

    public void fail(Throwable th2, c<?> cVar, f<?> fVar) {
        io.reactivex.rxjava3.exceptions.a.b(th2);
        ExceptionHelper.a(this.error, th2);
        fVar.clear();
        cancelAll();
        errorAll(cVar);
    }

    public void innerClose(boolean z11, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber) {
        synchronized (this) {
            this.queue.l(z11 ? LEFT_CLOSE : RIGHT_CLOSE, flowableGroupJoin$LeftRightEndSubscriber);
        }
        drain();
    }

    public void innerCloseError(Throwable th2) {
        if (ExceptionHelper.a(this.error, th2)) {
            drain();
        } else {
            o00.a.n(th2);
        }
    }

    public void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber) {
        this.disposables.b(flowableGroupJoin$LeftRightSubscriber);
        this.active.decrementAndGet();
        drain();
    }

    public void innerError(Throwable th2) {
        if (ExceptionHelper.a(this.error, th2)) {
            this.active.decrementAndGet();
            drain();
            return;
        }
        o00.a.n(th2);
    }

    public void innerValue(boolean z11, Object obj) {
        synchronized (this) {
            this.queue.l(z11 ? LEFT_VALUE : RIGHT_VALUE, obj);
        }
        drain();
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
        }
    }
}
