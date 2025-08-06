package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservablePublish$PublishConnection<T> extends AtomicReference<ObservablePublish$InnerDisposable<T>[]> implements k<T>, b {
    public static final ObservablePublish$InnerDisposable[] EMPTY = new ObservablePublish$InnerDisposable[0];
    public static final ObservablePublish$InnerDisposable[] TERMINATED = new ObservablePublish$InnerDisposable[0];
    private static final long serialVersionUID = -3251430252873581268L;
    public final AtomicBoolean connect = new AtomicBoolean();
    public final AtomicReference<ObservablePublish$PublishConnection<T>> current;
    public Throwable error;
    public final AtomicReference<b> upstream;

    public ObservablePublish$PublishConnection(AtomicReference<ObservablePublish$PublishConnection<T>> atomicReference) {
        this.current = atomicReference;
        this.upstream = new AtomicReference<>();
        lazySet(EMPTY);
    }

    public boolean add(ObservablePublish$InnerDisposable<T> observablePublish$InnerDisposable) {
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr2;
        do {
            observablePublish$InnerDisposableArr = (ObservablePublish$InnerDisposable[]) get();
            if (observablePublish$InnerDisposableArr == TERMINATED) {
                return false;
            }
            int length = observablePublish$InnerDisposableArr.length;
            observablePublish$InnerDisposableArr2 = new ObservablePublish$InnerDisposable[(length + 1)];
            System.arraycopy(observablePublish$InnerDisposableArr, 0, observablePublish$InnerDisposableArr2, 0, length);
            observablePublish$InnerDisposableArr2[length] = observablePublish$InnerDisposable;
        } while (!compareAndSet(observablePublish$InnerDisposableArr, observablePublish$InnerDisposableArr2));
        return true;
    }

    public void dispose() {
        getAndSet(TERMINATED);
        this.current.compareAndSet(this, (Object) null);
        DisposableHelper.dispose(this.upstream);
    }

    public boolean isDisposed() {
        return get() == TERMINATED;
    }

    public void onComplete() {
        this.upstream.lazySet(DisposableHelper.DISPOSED);
        for (ObservablePublish$InnerDisposable observablePublish$InnerDisposable : (ObservablePublish$InnerDisposable[]) getAndSet(TERMINATED)) {
            observablePublish$InnerDisposable.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        b bVar = this.upstream.get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            this.error = th2;
            this.upstream.lazySet(disposableHelper);
            for (ObservablePublish$InnerDisposable observablePublish$InnerDisposable : (ObservablePublish$InnerDisposable[]) getAndSet(TERMINATED)) {
                observablePublish$InnerDisposable.downstream.onError(th2);
            }
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        for (ObservablePublish$InnerDisposable observablePublish$InnerDisposable : (ObservablePublish$InnerDisposable[]) get()) {
            observablePublish$InnerDisposable.downstream.onNext(t11);
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void remove(ObservablePublish$InnerDisposable<T> observablePublish$InnerDisposable) {
        ObservablePublish$InnerDisposable<T>[] observablePublish$InnerDisposableArr;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr2;
        do {
            observablePublish$InnerDisposableArr = (ObservablePublish$InnerDisposable[]) get();
            int length = observablePublish$InnerDisposableArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (observablePublish$InnerDisposableArr[i12] == observablePublish$InnerDisposable) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    observablePublish$InnerDisposableArr2 = EMPTY;
                    if (length != 1) {
                        observablePublish$InnerDisposableArr2 = new ObservablePublish$InnerDisposable[(length - 1)];
                        System.arraycopy(observablePublish$InnerDisposableArr, 0, observablePublish$InnerDisposableArr2, 0, i11);
                        System.arraycopy(observablePublish$InnerDisposableArr, i11 + 1, observablePublish$InnerDisposableArr2, i11, (length - i11) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(observablePublish$InnerDisposableArr, observablePublish$InnerDisposableArr2));
    }
}
