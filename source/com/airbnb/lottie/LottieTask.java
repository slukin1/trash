package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    private volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;

    public class LottieFutureTask extends FutureTask<LottieResult<T>> {
        public LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        public void done() {
            if (!isCancelled()) {
                try {
                    LottieTask.this.setResult((LottieResult) get());
                } catch (InterruptedException | ExecutionException e11) {
                    LottieTask.this.setResult(new LottieResult(e11));
                }
            }
        }
    }

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyListeners$0() {
        LottieResult<T> lottieResult = this.result;
        if (lottieResult != null) {
            if (lottieResult.getValue() != null) {
                notifySuccessListeners(lottieResult.getValue());
            } else {
                notifyFailureListeners(lottieResult.getException());
            }
        }
    }

    private synchronized void notifyFailureListeners(Throwable th2) {
        ArrayList<LottieListener> arrayList = new ArrayList<>(this.failureListeners);
        if (arrayList.isEmpty()) {
            Logger.warning("Lottie encountered an error but no failure listener was added:", th2);
            return;
        }
        for (LottieListener onResult : arrayList) {
            onResult.onResult(th2);
        }
    }

    private void notifyListeners() {
        this.handler.post(new g0(this));
    }

    private synchronized void notifySuccessListeners(T t11) {
        for (LottieListener onResult : new ArrayList(this.successListeners)) {
            onResult.onResult(t11);
        }
    }

    /* access modifiers changed from: private */
    public void setResult(LottieResult<T> lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            notifyListeners();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        LottieResult<T> lottieResult = this.result;
        if (!(lottieResult == null || lottieResult.getException() == null)) {
            lottieListener.onResult(lottieResult.getException());
        }
        this.failureListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        LottieResult<T> lottieResult = this.result;
        if (!(lottieResult == null || lottieResult.getValue() == null)) {
            lottieListener.onResult(lottieResult.getValue());
        }
        this.successListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListeners.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.successListeners.remove(lottieListener);
        return this;
    }

    public LottieTask(Callable<LottieResult<T>> callable, boolean z11) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z11) {
            try {
                setResult(callable.call());
            } catch (Throwable th2) {
                setResult(new LottieResult(th2));
            }
        } else {
            EXECUTOR.execute(new LottieFutureTask(callable));
        }
    }
}
