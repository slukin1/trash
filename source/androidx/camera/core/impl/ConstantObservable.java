package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class ConstantObservable<T> implements Observable<T> {
    private static final ConstantObservable<Object> NULL_OBSERVABLE = new ConstantObservable<>((Object) null);
    private static final String TAG = "ConstantObservable";
    private final ListenableFuture<T> mValueFuture;

    private ConstantObservable(T t11) {
        this.mValueFuture = Futures.immediateFuture(t11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addObserver$0(Observable.Observer observer) {
        try {
            observer.onNewData(this.mValueFuture.get());
        } catch (InterruptedException | ExecutionException e11) {
            observer.onError(e11);
        }
    }

    public static <U> Observable<U> withValue(U u11) {
        if (u11 == null) {
            return NULL_OBSERVABLE;
        }
        return new ConstantObservable(u11);
    }

    public void addObserver(Executor executor, Observable.Observer<? super T> observer) {
        this.mValueFuture.addListener(new p(this, observer), executor);
    }

    public ListenableFuture<T> fetchData() {
        return this.mValueFuture;
    }

    public void removeObserver(Observable.Observer<? super T> observer) {
    }
}
