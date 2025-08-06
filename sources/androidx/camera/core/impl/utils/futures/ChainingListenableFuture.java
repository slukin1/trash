package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ChainingListenableFuture<I, O> extends FutureChain<O> implements Runnable {
    private AsyncFunction<? super I, ? extends O> mFunction;
    private ListenableFuture<? extends I> mInputFuture;
    private final BlockingQueue<Boolean> mMayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
    private final CountDownLatch mOutputCreated = new CountDownLatch(1);
    public volatile ListenableFuture<? extends O> mOutputFuture;

    public ChainingListenableFuture(AsyncFunction<? super I, ? extends O> asyncFunction, ListenableFuture<? extends I> listenableFuture) {
        this.mFunction = (AsyncFunction) h.g(asyncFunction);
        this.mInputFuture = (ListenableFuture) h.g(listenableFuture);
    }

    private <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e11) {
        boolean z11 = false;
        while (true) {
            try {
                blockingQueue.put(e11);
                break;
            } catch (InterruptedException unused) {
                z11 = true;
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    private <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        E take;
        boolean z11 = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z11 = true;
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    public boolean cancel(boolean z11) {
        if (!super.cancel(z11)) {
            return false;
        }
        putUninterruptibly(this.mMayInterruptIfRunningChannel, Boolean.valueOf(z11));
        cancel(this.mInputFuture, z11);
        cancel(this.mOutputFuture, z11);
        return true;
    }

    public O get() throws InterruptedException, ExecutionException {
        if (!isDone()) {
            ListenableFuture<? extends I> listenableFuture = this.mInputFuture;
            if (listenableFuture != null) {
                listenableFuture.get();
            }
            this.mOutputCreated.await();
            ListenableFuture<? extends O> listenableFuture2 = this.mOutputFuture;
            if (listenableFuture2 != null) {
                listenableFuture2.get();
            }
        }
        return super.get();
    }

    public void run() {
        try {
            try {
                final ListenableFuture<? extends O> apply = this.mFunction.apply(Futures.getUninterruptibly(this.mInputFuture));
                this.mOutputFuture = apply;
                if (isCancelled()) {
                    apply.cancel(((Boolean) takeUninterruptibly(this.mMayInterruptIfRunningChannel)).booleanValue());
                    this.mOutputFuture = null;
                    this.mFunction = null;
                    this.mInputFuture = null;
                    this.mOutputCreated.countDown();
                    return;
                }
                apply.addListener(new Runnable() {
                    public void run() {
                        try {
                            ChainingListenableFuture.this.set(Futures.getUninterruptibly(apply));
                        } catch (CancellationException unused) {
                            ChainingListenableFuture.this.cancel(false);
                            ChainingListenableFuture.this.mOutputFuture = null;
                            return;
                        } catch (ExecutionException e11) {
                            ChainingListenableFuture.this.setException(e11.getCause());
                        } catch (Throwable th2) {
                            ChainingListenableFuture.this.mOutputFuture = null;
                            throw th2;
                        }
                        ChainingListenableFuture.this.mOutputFuture = null;
                    }
                }, CameraXExecutors.directExecutor());
                this.mFunction = null;
                this.mInputFuture = null;
                this.mOutputCreated.countDown();
            } catch (UndeclaredThrowableException e11) {
                setException(e11.getCause());
            } catch (Exception e12) {
                setException(e12);
            } catch (Error e13) {
                setException(e13);
            } catch (Throwable th2) {
                this.mFunction = null;
                this.mInputFuture = null;
                this.mOutputCreated.countDown();
                throw th2;
            }
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e14) {
            setException(e14.getCause());
        }
    }

    private void cancel(Future<?> future, boolean z11) {
        if (future != null) {
            future.cancel(z11);
        }
    }

    public O get(long j11, TimeUnit timeUnit) throws TimeoutException, ExecutionException, InterruptedException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j11 = timeUnit2.convert(j11, timeUnit);
                timeUnit = timeUnit2;
            }
            ListenableFuture<? extends I> listenableFuture = this.mInputFuture;
            if (listenableFuture != null) {
                long nanoTime = System.nanoTime();
                listenableFuture.get(j11, timeUnit);
                j11 -= Math.max(0, System.nanoTime() - nanoTime);
            }
            long nanoTime2 = System.nanoTime();
            if (this.mOutputCreated.await(j11, timeUnit)) {
                j11 -= Math.max(0, System.nanoTime() - nanoTime2);
                ListenableFuture<? extends O> listenableFuture2 = this.mOutputFuture;
                if (listenableFuture2 != null) {
                    listenableFuture2.get(j11, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return super.get(j11, timeUnit);
    }
}
