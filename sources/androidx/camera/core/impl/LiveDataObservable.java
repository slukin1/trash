package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class LiveDataObservable<T> implements Observable<T> {
    public final MutableLiveData<Result<T>> mLiveData = new MutableLiveData<>();
    private final Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> mObservers = new HashMap();

    public static final class LiveDataObserverAdapter<T> implements z<Result<T>> {
        public final AtomicBoolean mActive = new AtomicBoolean(true);
        public final Executor mExecutor;
        public final Observable.Observer<? super T> mObserver;

        public LiveDataObserverAdapter(Executor executor, Observable.Observer<? super T> observer) {
            this.mExecutor = executor;
            this.mObserver = observer;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onChanged$0(Result result) {
            if (this.mActive.get()) {
                if (result.completedSuccessfully()) {
                    this.mObserver.onNewData(result.getValue());
                    return;
                }
                h.g(result.getError());
                this.mObserver.onError(result.getError());
            }
        }

        public void disable() {
            this.mActive.set(false);
        }

        public void onChanged(Result<T> result) {
            this.mExecutor.execute(new e0(this, result));
        }
    }

    public static final class Result<T> {
        private final Throwable mError;
        private final T mValue;

        private Result(T t11, Throwable th2) {
            this.mValue = t11;
            this.mError = th2;
        }

        public static <T> Result<T> fromError(Throwable th2) {
            return new Result<>((Object) null, (Throwable) h.g(th2));
        }

        public static <T> Result<T> fromValue(T t11) {
            return new Result<>(t11, (Throwable) null);
        }

        public boolean completedSuccessfully() {
            return this.mError == null;
        }

        public Throwable getError() {
            return this.mError;
        }

        public T getValue() {
            if (completedSuccessfully()) {
                return this.mValue;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[Result: <");
            if (completedSuccessfully()) {
                str = "Value: " + this.mValue;
            } else {
                str = "Error: " + this.mError;
            }
            sb2.append(str);
            sb2.append(">]");
            return sb2.toString();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addObserver$2(LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObserverAdapter liveDataObserverAdapter2) {
        if (liveDataObserverAdapter != null) {
            this.mLiveData.removeObserver(liveDataObserverAdapter);
        }
        this.mLiveData.observeForever(liveDataObserverAdapter2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchData$0(CallbackToFutureAdapter.a aVar) {
        Result value = this.mLiveData.getValue();
        if (value == null) {
            aVar.f(new IllegalStateException("Observable has not yet been initialized with a value."));
        } else if (value.completedSuccessfully()) {
            aVar.c(value.getValue());
        } else {
            h.g(value.getError());
            aVar.f(value.getError());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$fetchData$1(CallbackToFutureAdapter.a aVar) throws Exception {
        CameraXExecutors.mainThreadExecutor().execute(new d0(this, aVar));
        return this + " [fetch@" + SystemClock.uptimeMillis() + "]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$removeObserver$3(LiveDataObserverAdapter liveDataObserverAdapter) {
        this.mLiveData.removeObserver(liveDataObserverAdapter);
    }

    public void addObserver(Executor executor, Observable.Observer<? super T> observer) {
        synchronized (this.mObservers) {
            LiveDataObserverAdapter liveDataObserverAdapter = this.mObservers.get(observer);
            if (liveDataObserverAdapter != null) {
                liveDataObserverAdapter.disable();
            }
            LiveDataObserverAdapter liveDataObserverAdapter2 = new LiveDataObserverAdapter(executor, observer);
            this.mObservers.put(observer, liveDataObserverAdapter2);
            CameraXExecutors.mainThreadExecutor().execute(new c0(this, liveDataObserverAdapter, liveDataObserverAdapter2));
        }
    }

    public ListenableFuture<T> fetchData() {
        return CallbackToFutureAdapter.a(new a0(this));
    }

    public LiveData<Result<T>> getLiveData() {
        return this.mLiveData;
    }

    public void postError(Throwable th2) {
        this.mLiveData.postValue(Result.fromError(th2));
    }

    public void postValue(T t11) {
        this.mLiveData.postValue(Result.fromValue(t11));
    }

    public void removeObserver(Observable.Observer<? super T> observer) {
        synchronized (this.mObservers) {
            LiveDataObserverAdapter remove = this.mObservers.remove(observer);
            if (remove != null) {
                remove.disable();
                CameraXExecutors.mainThreadExecutor().execute(new b0(this, remove));
            }
        }
    }
}
