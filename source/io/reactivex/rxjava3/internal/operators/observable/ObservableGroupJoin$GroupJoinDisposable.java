package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import j00.c;
import j00.h;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableGroupJoin$GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements b, e {
    public static final Integer LEFT_CLOSE = 3;
    public static final Integer LEFT_VALUE = 1;
    public static final Integer RIGHT_CLOSE = 4;
    public static final Integer RIGHT_VALUE = 2;
    private static final long serialVersionUID = -6071216598687999801L;
    public final AtomicInteger active;
    public volatile boolean cancelled;
    public final CompositeDisposable disposables = new CompositeDisposable();
    public final k<? super R> downstream;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final h<? super TLeft, ? extends j<TLeftEnd>> leftEnd;
    public int leftIndex;
    public final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
    public final a<Object> queue = new a<>(Observable.a());
    public final c<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector;
    public final h<? super TRight, ? extends j<TRightEnd>> rightEnd;
    public int rightIndex;
    public final Map<Integer, TRight> rights = new LinkedHashMap();

    public ObservableGroupJoin$GroupJoinDisposable(k<? super R> kVar, h<? super TLeft, ? extends j<TLeftEnd>> hVar, h<? super TRight, ? extends j<TRightEnd>> hVar2, c<? super TLeft, ? super Observable<TRight>, ? extends R> cVar) {
        this.downstream = kVar;
        this.leftEnd = hVar;
        this.rightEnd = hVar2;
        this.resultSelector = cVar;
        this.active = new AtomicInteger(2);
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            a<Object> aVar = this.queue;
            k<? super R> kVar = this.downstream;
            int i11 = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    aVar.clear();
                    cancelAll();
                    errorAll(kVar);
                    return;
                }
                boolean z11 = this.active.get() == 0;
                Integer num = (Integer) aVar.poll();
                boolean z12 = num == null;
                if (z11 && z12) {
                    for (UnicastSubject<TRight> onComplete : this.lefts.values()) {
                        onComplete.onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    kVar.onComplete();
                    return;
                } else if (z12) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    Object poll = aVar.poll();
                    if (num == LEFT_VALUE) {
                        UnicastSubject c11 = UnicastSubject.c();
                        int i12 = this.leftIndex;
                        this.leftIndex = i12 + 1;
                        this.lefts.put(Integer.valueOf(i12), c11);
                        try {
                            Object apply = this.leftEnd.apply(poll);
                            Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                            j jVar = (j) apply;
                            ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver = new ObservableGroupJoin$LeftRightEndObserver(this, true, i12);
                            this.disposables.a(observableGroupJoin$LeftRightEndObserver);
                            jVar.subscribe(observableGroupJoin$LeftRightEndObserver);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(kVar);
                                return;
                            }
                            try {
                                Object apply2 = this.resultSelector.apply(poll, c11);
                                Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                kVar.onNext(apply2);
                                for (TRight onNext : this.rights.values()) {
                                    c11.onNext(onNext);
                                }
                            } catch (Throwable th2) {
                                fail(th2, kVar, aVar);
                                return;
                            }
                        } catch (Throwable th3) {
                            fail(th3, kVar, aVar);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i13 = this.rightIndex;
                        this.rightIndex = i13 + 1;
                        this.rights.put(Integer.valueOf(i13), poll);
                        try {
                            Object apply3 = this.rightEnd.apply(poll);
                            Objects.requireNonNull(apply3, "The rightEnd returned a null ObservableSource");
                            j jVar2 = (j) apply3;
                            ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver2 = new ObservableGroupJoin$LeftRightEndObserver(this, false, i13);
                            this.disposables.a(observableGroupJoin$LeftRightEndObserver2);
                            jVar2.subscribe(observableGroupJoin$LeftRightEndObserver2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(kVar);
                                return;
                            }
                            for (UnicastSubject<TRight> onNext2 : this.lefts.values()) {
                                onNext2.onNext(poll);
                            }
                        } catch (Throwable th4) {
                            fail(th4, kVar, aVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver3 = (ObservableGroupJoin$LeftRightEndObserver) poll;
                        UnicastSubject remove = this.lefts.remove(Integer.valueOf(observableGroupJoin$LeftRightEndObserver3.index));
                        this.disposables.c(observableGroupJoin$LeftRightEndObserver3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else {
                        ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver4 = (ObservableGroupJoin$LeftRightEndObserver) poll;
                        this.rights.remove(Integer.valueOf(observableGroupJoin$LeftRightEndObserver4.index));
                        this.disposables.c(observableGroupJoin$LeftRightEndObserver4);
                    }
                }
            }
            aVar.clear();
        }
    }

    public void errorAll(k<?> kVar) {
        Throwable e11 = ExceptionHelper.e(this.error);
        for (UnicastSubject<TRight> onError : this.lefts.values()) {
            onError.onError(e11);
        }
        this.lefts.clear();
        this.rights.clear();
        kVar.onError(e11);
    }

    public void fail(Throwable th2, k<?> kVar, a<?> aVar) {
        io.reactivex.rxjava3.exceptions.a.b(th2);
        ExceptionHelper.a(this.error, th2);
        aVar.clear();
        cancelAll();
        errorAll(kVar);
    }

    public void innerClose(boolean z11, ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver) {
        synchronized (this) {
            this.queue.l(z11 ? LEFT_CLOSE : RIGHT_CLOSE, observableGroupJoin$LeftRightEndObserver);
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

    public void innerComplete(ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver) {
        this.disposables.b(observableGroupJoin$LeftRightObserver);
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

    public boolean isDisposed() {
        return this.cancelled;
    }
}
