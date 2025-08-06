package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;

abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = new DoNothingRunnable();
    private static final Runnable INTERRUPTING = new DoNothingRunnable();

    public static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        public void run() {
        }
    }

    public abstract void afterRanInterruptibly(T t11, Throwable th2);

    public final void interruptTask() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, INTERRUPTING)) {
            ((Thread) runnable).interrupt();
            set(DONE);
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
                        while (get() == INTERRUPTING) {
                            Thread.yield();
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
                while (get() == INTERRUPTING) {
                    Thread.yield();
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
            String name = ((Thread) runnable).getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 21);
            sb2.append("running=[RUNNING ON ");
            sb2.append(name);
            sb2.append("]");
            str = sb2.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String pendingString = toPendingString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(pendingString).length());
        sb3.append(str);
        sb3.append(", ");
        sb3.append(pendingString);
        return sb3.toString();
    }
}
