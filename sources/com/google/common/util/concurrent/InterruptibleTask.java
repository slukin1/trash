package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = new DoNothingRunnable();
    private static final Runnable INTERRUPTING = new DoNothingRunnable();
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED = new DoNothingRunnable();

    public static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        public void run() {
        }
    }

    static {
        Class<LockSupport> cls = LockSupport.class;
    }

    public abstract void afterRanInterruptibly(T t11, Throwable th2);

    public final void interruptTask() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, INTERRUPTING)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (((Runnable) getAndSet(DONE)) == PARKED) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    public abstract boolean isDone();

    public final void run() {
        Object obj;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet((Object) null, currentThread)) {
            boolean z11 = !isDone();
            if (z11) {
                try {
                    obj = runInterruptibly();
                } catch (Throwable th2) {
                    if (!compareAndSet(currentThread, DONE)) {
                        Runnable runnable = (Runnable) get();
                        boolean z12 = false;
                        int i11 = 0;
                        while (true) {
                            Runnable runnable2 = INTERRUPTING;
                            if (runnable != runnable2 && runnable != PARKED) {
                                break;
                            }
                            i11++;
                            if (i11 > 1000) {
                                Runnable runnable3 = PARKED;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                    z12 = Thread.interrupted() || z12;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = (Runnable) get();
                        }
                        if (z12) {
                            currentThread.interrupt();
                        }
                    }
                    if (z11) {
                        afterRanInterruptibly((Object) null, th2);
                        return;
                    }
                    return;
                }
            } else {
                obj = null;
            }
            if (!compareAndSet(currentThread, DONE)) {
                Runnable runnable4 = (Runnable) get();
                boolean z13 = false;
                int i12 = 0;
                while (true) {
                    Runnable runnable5 = INTERRUPTING;
                    if (runnable4 != runnable5 && runnable4 != PARKED) {
                        break;
                    }
                    i12++;
                    if (i12 > 1000) {
                        Runnable runnable6 = PARKED;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            z13 = Thread.interrupted() || z13;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable4 = (Runnable) get();
                }
                if (z13) {
                    currentThread.interrupt();
                }
            }
            if (z11) {
                afterRanInterruptibly(obj, (Throwable) null);
            }
        }
    }

    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable == INTERRUPTING) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + toPendingString();
    }
}
