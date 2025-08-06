package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableReplay$ReplayObserver<T> extends AtomicReference<b> implements k<T>, b {
    public static final ObservableReplay$InnerDisposable[] EMPTY = new ObservableReplay$InnerDisposable[0];
    public static final ObservableReplay$InnerDisposable[] TERMINATED = new ObservableReplay$InnerDisposable[0];
    private static final long serialVersionUID = -533785617179540163L;
    public final f<T> buffer;
    public final AtomicReference<ObservableReplay$ReplayObserver<T>> current;
    public boolean done;
    public final AtomicReference<ObservableReplay$InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
    public final AtomicBoolean shouldConnect = new AtomicBoolean();

    public ObservableReplay$ReplayObserver(f<T> fVar, AtomicReference<ObservableReplay$ReplayObserver<T>> atomicReference) {
        this.buffer = fVar;
        this.current = atomicReference;
    }

    public boolean add(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr2;
        do {
            observableReplay$InnerDisposableArr = this.observers.get();
            if (observableReplay$InnerDisposableArr == TERMINATED) {
                return false;
            }
            int length = observableReplay$InnerDisposableArr.length;
            observableReplay$InnerDisposableArr2 = new ObservableReplay$InnerDisposable[(length + 1)];
            System.arraycopy(observableReplay$InnerDisposableArr, 0, observableReplay$InnerDisposableArr2, 0, length);
            observableReplay$InnerDisposableArr2[length] = observableReplay$InnerDisposable;
        } while (!this.observers.compareAndSet(observableReplay$InnerDisposableArr, observableReplay$InnerDisposableArr2));
        return true;
    }

    public void dispose() {
        this.observers.set(TERMINATED);
        this.current.compareAndSet(this, (Object) null);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.observers.get() == TERMINATED;
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }
    }

    public void onError(Throwable th2) {
        if (!this.done) {
            this.done = true;
            this.buffer.error(th2);
            replayFinal();
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            this.buffer.next(t11);
            replay();
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            replay();
        }
    }

    public void remove(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr2;
        do {
            observableReplay$InnerDisposableArr = this.observers.get();
            int length = observableReplay$InnerDisposableArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (observableReplay$InnerDisposableArr[i12].equals(observableReplay$InnerDisposable)) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        observableReplay$InnerDisposableArr2 = EMPTY;
                    } else {
                        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr3 = new ObservableReplay$InnerDisposable[(length - 1)];
                        System.arraycopy(observableReplay$InnerDisposableArr, 0, observableReplay$InnerDisposableArr3, 0, i11);
                        System.arraycopy(observableReplay$InnerDisposableArr, i11 + 1, observableReplay$InnerDisposableArr3, i11, (length - i11) - 1);
                        observableReplay$InnerDisposableArr2 = observableReplay$InnerDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(observableReplay$InnerDisposableArr, observableReplay$InnerDisposableArr2));
    }

    public void replay() {
        for (ObservableReplay$InnerDisposable replay : this.observers.get()) {
            this.buffer.replay(replay);
        }
    }

    public void replayFinal() {
        for (ObservableReplay$InnerDisposable replay : this.observers.getAndSet(TERMINATED)) {
            this.buffer.replay(replay);
        }
    }
}
