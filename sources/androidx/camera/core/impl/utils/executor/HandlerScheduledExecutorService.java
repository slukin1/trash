package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

final class HandlerScheduledExecutorService extends AbstractExecutorService implements ScheduledExecutorService {
    private static ThreadLocal<ScheduledExecutorService> sThreadLocalInstance = new ThreadLocal<ScheduledExecutorService>() {
        public ScheduledExecutorService initialValue() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return CameraXExecutors.mainThreadExecutor();
            }
            if (Looper.myLooper() != null) {
                return new HandlerScheduledExecutorService(new Handler(Looper.myLooper()));
            }
            return null;
        }
    };
    private final Handler mHandler;

    public static class HandlerScheduledFuture<V> implements RunnableScheduledFuture<V> {
        public final AtomicReference<CallbackToFutureAdapter.a<V>> mCompleter = new AtomicReference<>((Object) null);
        private final ListenableFuture<V> mDelegate;
        private final long mRunAtMillis;
        private final Callable<V> mTask;

        public HandlerScheduledFuture(final Handler handler, long j11, final Callable<V> callable) {
            this.mRunAtMillis = j11;
            this.mTask = callable;
            this.mDelegate = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b<V>() {
                public Object attachCompleter(CallbackToFutureAdapter.a<V> aVar) throws RejectedExecutionException {
                    aVar.a(new Runnable() {
                        public void run() {
                            if (HandlerScheduledFuture.this.mCompleter.getAndSet((Object) null) != null) {
                                AnonymousClass1 r02 = AnonymousClass1.this;
                                handler.removeCallbacks(HandlerScheduledFuture.this);
                            }
                        }
                    }, CameraXExecutors.directExecutor());
                    HandlerScheduledFuture.this.mCompleter.set(aVar);
                    return "HandlerScheduledFuture-" + callable.toString();
                }
            });
        }

        public boolean cancel(boolean z11) {
            return this.mDelegate.cancel(z11);
        }

        public V get() throws ExecutionException, InterruptedException {
            return this.mDelegate.get();
        }

        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.mRunAtMillis - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public boolean isCancelled() {
            return this.mDelegate.isCancelled();
        }

        public boolean isDone() {
            return this.mDelegate.isDone();
        }

        public boolean isPeriodic() {
            return false;
        }

        public void run() {
            CallbackToFutureAdapter.a andSet = this.mCompleter.getAndSet((Object) null);
            if (andSet != null) {
                try {
                    andSet.c(this.mTask.call());
                } catch (Exception e11) {
                    andSet.f(e11);
                }
            }
        }

        public int compareTo(Delayed delayed) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
        }

        public V get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.mDelegate.get(j11, timeUnit);
        }
    }

    public HandlerScheduledExecutorService(Handler handler) {
        this.mHandler = handler;
    }

    private RejectedExecutionException createPostFailedException() {
        return new RejectedExecutionException(this.mHandler + " is shutting down");
    }

    public static ScheduledExecutorService currentThreadExecutor() {
        ScheduledExecutorService scheduledExecutorService = sThreadLocalInstance.get();
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            HandlerScheduledExecutorService handlerScheduledExecutorService = new HandlerScheduledExecutorService(new Handler(myLooper));
            sThreadLocalInstance.set(handlerScheduledExecutorService);
            return handlerScheduledExecutorService;
        }
        throw new IllegalStateException("Current thread has no looper!");
    }

    public boolean awaitTermination(long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    public void execute(Runnable runnable) {
        if (!this.mHandler.post(runnable)) {
            throw createPostFailedException();
        }
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public ScheduledFuture<?> schedule(final Runnable runnable, long j11, TimeUnit timeUnit) {
        return schedule(new Callable<Void>() {
            public Void call() {
                runnable.run();
                return null;
            }
        }, j11, timeUnit);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " does not yet support fixed-rate scheduling.");
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " does not yet support fixed-delay scheduling.");
    }

    public void shutdown() {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j11, TimeUnit timeUnit) {
        long uptimeMillis = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(j11, timeUnit);
        HandlerScheduledFuture handlerScheduledFuture = new HandlerScheduledFuture(this.mHandler, uptimeMillis, callable);
        if (this.mHandler.postAtTime(handlerScheduledFuture, uptimeMillis)) {
            return handlerScheduledFuture;
        }
        return Futures.immediateFailedScheduledFuture(createPostFailedException());
    }
}
