package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;

@GwtCompatible(emulated = true)
public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    @GwtIncompatible
    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        boolean z11 = false;
        while (true) {
            try {
                countDownLatch.await();
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

    @CanIgnoreReturnValue
    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v11;
        boolean z11 = false;
        while (true) {
            try {
                v11 = future.get();
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
        return v11;
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread thread) {
        boolean z11 = false;
        while (true) {
            try {
                thread.join();
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

    @GwtIncompatible
    public static <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e11) {
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

    @GwtIncompatible
    public static void sleepUninterruptibly(long j11, TimeUnit timeUnit) {
        long nanos;
        long nanoTime;
        boolean z11 = false;
        try {
            nanos = timeUnit.toNanos(j11);
            nanoTime = System.nanoTime() + nanos;
            while (true) {
                TimeUnit.NANOSECONDS.sleep(nanos);
                break;
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused) {
            z11 = true;
            nanos = nanoTime - System.nanoTime();
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }

    @GwtIncompatible
    public static <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
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

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long j11, TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, j11, timeUnit);
    }

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, int i11, long j11, TimeUnit timeUnit) {
        long nanos;
        boolean tryAcquire;
        boolean z11 = false;
        try {
            nanos = timeUnit.toNanos(j11);
            while (true) {
                tryAcquire = semaphore.tryAcquire(i11, nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            return tryAcquire;
        } catch (InterruptedException unused) {
            z11 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j11, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z11 = false;
        try {
            nanos = timeUnit.toNanos(j11);
            while (true) {
                await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z11 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public static <V> V getUninterruptibly(Future<V> future, long j11, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        long nanos;
        V v11;
        boolean z11 = false;
        try {
            nanos = timeUnit.toNanos(j11);
            while (true) {
                v11 = future.get(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            return v11;
        } catch (InterruptedException unused) {
            z11 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread thread, long j11, TimeUnit timeUnit) {
        long nanos;
        long nanoTime;
        Preconditions.checkNotNull(thread);
        boolean z11 = false;
        try {
            nanos = timeUnit.toNanos(j11);
            nanoTime = System.nanoTime() + nanos;
            while (true) {
                TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                break;
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused) {
            z11 = true;
            nanos = nanoTime - System.nanoTime();
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }

    @GwtIncompatible
    public static boolean awaitUninterruptibly(Condition condition, long j11, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z11 = false;
        try {
            nanos = timeUnit.toNanos(j11);
            while (true) {
                await = condition.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z11 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }
}
