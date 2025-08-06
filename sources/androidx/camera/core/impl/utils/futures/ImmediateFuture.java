package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.Logger;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

abstract class ImmediateFuture<V> implements ListenableFuture<V> {
    private static final String TAG = "ImmediateFuture";

    public static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        private final Throwable mCause;

        public ImmediateFailedFuture(Throwable th2) {
            this.mCause = th2;
        }

        public V get() throws ExecutionException {
            throw new ExecutionException(this.mCause);
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.mCause + "]]";
        }
    }

    public static final class ImmediateFailedScheduledFuture<V> extends ImmediateFailedFuture<V> implements ScheduledFuture<V> {
        public ImmediateFailedScheduledFuture(Throwable th2) {
            super(th2);
        }

        public int compareTo(Delayed delayed) {
            return -1;
        }

        public long getDelay(TimeUnit timeUnit) {
            return 0;
        }
    }

    public static final class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        public static final ImmediateFuture<Object> NULL_FUTURE = new ImmediateSuccessfulFuture((Object) null);
        private final V mValue;

        public ImmediateSuccessfulFuture(V v11) {
            this.mValue = v11;
        }

        public V get() {
            return this.mValue;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.mValue + "]]";
        }
    }

    public static <V> ListenableFuture<V> nullFuture() {
        return ImmediateSuccessfulFuture.NULL_FUTURE;
    }

    public void addListener(Runnable runnable, Executor executor) {
        h.g(runnable);
        h.g(executor);
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            Logger.e(TAG, "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e11);
        }
    }

    public boolean cancel(boolean z11) {
        return false;
    }

    public abstract V get() throws ExecutionException;

    public V get(long j11, TimeUnit timeUnit) throws ExecutionException {
        h.g(timeUnit);
        return get();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
