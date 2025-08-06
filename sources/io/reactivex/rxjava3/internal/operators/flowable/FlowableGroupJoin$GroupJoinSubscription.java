package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
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

final class FlowableGroupJoin$GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements d, g {
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
    public final Map<Integer, UnicastProcessor<TRight>> lefts = new LinkedHashMap();
    public final a<Object> queue = new a<>(Flowable.b());
    public final AtomicLong requested = new AtomicLong();
    public final j00.c<? super TLeft, ? super Flowable<TRight>, ? extends R> resultSelector;
    public final h<? super TRight, ? extends b<TRightEnd>> rightEnd;
    public int rightIndex;
    public final Map<Integer, TRight> rights = new LinkedHashMap();

    public FlowableGroupJoin$GroupJoinSubscription(c<? super R> cVar, h<? super TLeft, ? extends b<TLeftEnd>> hVar, h<? super TRight, ? extends b<TRightEnd>> hVar2, j00.c<? super TLeft, ? super Flowable<TRight>, ? extends R> cVar2) {
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
            int i11 = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    aVar.clear();
                    cancelAll();
                    errorAll(cVar);
                    return;
                }
                boolean z11 = this.active.get() == 0;
                Integer num = (Integer) aVar.poll();
                boolean z12 = num == null;
                if (z11 && z12) {
                    for (UnicastProcessor<TRight> onComplete : this.lefts.values()) {
                        onComplete.onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    cVar.onComplete();
                    return;
                } else if (z12) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    Object poll = aVar.poll();
                    if (num == LEFT_VALUE) {
                        UnicastProcessor n11 = UnicastProcessor.n();
                        int i12 = this.leftIndex;
                        this.leftIndex = i12 + 1;
                        this.lefts.put(Integer.valueOf(i12), n11);
                        try {
                            Object apply = this.leftEnd.apply(poll);
                            Objects.requireNonNull(apply, "The leftEnd returned a null Publisher");
                            b bVar = (b) apply;
                            FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber = new FlowableGroupJoin$LeftRightEndSubscriber(this, true, i12);
                            this.disposables.a(flowableGroupJoin$LeftRightEndSubscriber);
                            bVar.subscribe(flowableGroupJoin$LeftRightEndSubscriber);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(cVar);
                                return;
                            }
                            try {
                                Object apply2 = this.resultSelector.apply(poll, n11);
                                Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                if (this.requested.get() != 0) {
                                    cVar.onNext(apply2);
                                    io.reactivex.rxjava3.internal.util.b.e(this.requested, 1);
                                    for (TRight onNext : this.rights.values()) {
                                        n11.onNext(onNext);
                                    }
                                } else {
                                    fail(new MissingBackpressureException("Could not emit value due to lack of requests"), cVar, aVar);
                                    return;
                                }
                            } catch (Throwable th2) {
                                fail(th2, cVar, aVar);
                                return;
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
                            Object apply3 = this.rightEnd.apply(poll);
                            Objects.requireNonNull(apply3, "The rightEnd returned a null Publisher");
                            b bVar2 = (b) apply3;
                            FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber2 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, i13);
                            this.disposables.a(flowableGroupJoin$LeftRightEndSubscriber2);
                            bVar2.subscribe(flowableGroupJoin$LeftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(cVar);
                                return;
                            }
                            for (UnicastProcessor<TRight> onNext2 : this.lefts.values()) {
                                onNext2.onNext(poll);
                            }
                        } catch (Throwable th4) {
                            fail(th4, cVar, aVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber3 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                        UnicastProcessor remove = this.lefts.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber3.index));
                        this.disposables.c(flowableGroupJoin$LeftRightEndSubscriber3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else {
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber4 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                        this.rights.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber4.index));
                        this.disposables.c(flowableGroupJoin$LeftRightEndSubscriber4);
                    }
                }
            }
            aVar.clear();
        }
    }

    public void errorAll(c<?> cVar) {
        Throwable e11 = ExceptionHelper.e(this.error);
        for (UnicastProcessor<TRight> onError : this.lefts.values()) {
            onError.onError(e11);
        }
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
