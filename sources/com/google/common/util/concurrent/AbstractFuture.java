package com.google.common.util.concurrent;

import androidx.concurrent.futures.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import com.sumsub.sns.internal.core.analytics.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    /* access modifiers changed from: private */
    public static final AtomicHelper ATOMIC_HELPER;
    /* access modifiers changed from: private */
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", d.f31895b));
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
    /* access modifiers changed from: private */
    public volatile Listener listeners;
    /* access modifiers changed from: private */
    public volatile Object value;
    /* access modifiers changed from: private */
    public volatile Waiter waiters;

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        public abstract boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        public abstract void putNext(Waiter waiter, Waiter waiter2);

        public abstract void putThread(Waiter waiter, Thread thread);
    }

    public static final class Cancellation {
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public final Throwable cause;
        public final boolean wasInterrupted;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
                return;
            }
            CAUSELESS_CANCELLED = new Cancellation(false, (Throwable) null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, (Throwable) null);
        }

        public Cancellation(boolean z11, Throwable th2) {
            this.wasInterrupted = z11;
            this.cause = th2;
        }
    }

    public static final class Failure {
        public static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        public final Throwable exception;

        public Failure(Throwable th2) {
            this.exception = (Throwable) Preconditions.checkNotNull(th2);
        }
    }

    public static final class Listener {
        public static final Listener TOMBSTONE = new Listener((Runnable) null, (Executor) null);
        public final Executor executor;
        public Listener next;
        public final Runnable task;

        public Listener(Runnable runnable, Executor executor2) {
            this.task = runnable;
            this.executor = executor2;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        public final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        public boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return a.a(this.listenersUpdater, abstractFuture, listener, listener2);
        }

        public boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.a(this.valueUpdater, abstractFuture, obj, obj2);
        }

        public boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.waitersUpdater, abstractFuture, waiter, waiter2);
        }

        public void putNext(Waiter waiter, Waiter waiter2) {
            this.waiterNextUpdater.lazySet(waiter, waiter2);
        }

        public void putThread(Waiter waiter, Thread thread) {
            this.waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements Runnable {
        public final ListenableFuture<? extends V> future;
        public final AbstractFuture<V> owner;

        public SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.owner = abstractFuture;
            this.future = listenableFuture;
        }

        public void run() {
            if (this.owner.value == this) {
                if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                    AbstractFuture.complete(this.owner);
                }
            }
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        public boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.listeners != listener) {
                    return false;
                }
                Listener unused = abstractFuture.listeners = listener2;
                return true;
            }
        }

        public boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.value != obj) {
                    return false;
                }
                Object unused = abstractFuture.value = obj2;
                return true;
            }
        }

        public boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.waiters != waiter) {
                    return false;
                }
                Waiter unused = abstractFuture.waiters = waiter2;
                return true;
            }
        }

        public void putNext(Waiter waiter, Waiter waiter2) {
            waiter.next = waiter2;
        }

        public void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }
    }

    public interface Trusted<V> extends ListenableFuture<V> {
    }

    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        public final void addListener(Runnable runnable, Executor executor) {
            AbstractFuture.super.addListener(runnable, executor);
        }

        @CanIgnoreReturnValue
        public final boolean cancel(boolean z11) {
            return AbstractFuture.super.cancel(z11);
        }

        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return AbstractFuture.super.get();
        }

        public final boolean isCancelled() {
            return AbstractFuture.super.isCancelled();
        }

        public final boolean isDone() {
            return AbstractFuture.super.isDone();
        }

        @CanIgnoreReturnValue
        public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return AbstractFuture.super.get(j11, timeUnit);
        }
    }

    public static final class UnsafeAtomicHelper extends AtomicHelper {
        public static final long LISTENERS_OFFSET;
        public static final Unsafe UNSAFE;
        public static final long VALUE_OFFSET;
        public static final long WAITERS_OFFSET;
        public static final long WAITER_NEXT_OFFSET;
        public static final long WAITER_THREAD_OFFSET;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.common.util.concurrent.AbstractFuture$Waiter> r0 = com.google.common.util.concurrent.AbstractFuture.Waiter.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1 r1 = new com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1     // Catch:{ PrivilegedActionException -> 0x005d }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
            L_0x0012:
                java.lang.Class<com.google.common.util.concurrent.AbstractFuture> r2 = com.google.common.util.concurrent.AbstractFuture.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                WAITERS_OFFSET = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                LISTENERS_OFFSET = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                VALUE_OFFSET = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                WAITER_THREAD_OFFSET = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
                WAITER_NEXT_OFFSET = r2     // Catch:{ Exception -> 0x0053 }
                UNSAFE = r1     // Catch:{ Exception -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                com.google.common.base.Throwables.throwIfUnchecked(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005d:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.<clinit>():void");
        }

        private UnsafeAtomicHelper() {
            super();
        }

        public boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return androidx.test.espresso.core.internal.deps.guava.util.concurrent.a.a(UNSAFE, abstractFuture, LISTENERS_OFFSET, listener, listener2);
        }

        public boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return androidx.test.espresso.core.internal.deps.guava.util.concurrent.a.a(UNSAFE, abstractFuture, VALUE_OFFSET, obj, obj2);
        }

        public boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return androidx.test.espresso.core.internal.deps.guava.util.concurrent.a.a(UNSAFE, abstractFuture, WAITERS_OFFSET, waiter, waiter2);
        }

        public void putNext(Waiter waiter, Waiter waiter2) {
            UNSAFE.putObject(waiter, WAITER_NEXT_OFFSET, waiter2);
        }

        public void putThread(Waiter waiter, Thread thread) {
            UNSAFE.putObject(waiter, WAITER_THREAD_OFFSET, thread);
        }
    }

    public static final class Waiter {
        public static final Waiter TOMBSTONE = new Waiter(false);
        public volatile Waiter next;
        public volatile Thread thread;

        public Waiter(boolean z11) {
        }

        public void setNext(Waiter waiter) {
            AbstractFuture.ATOMIC_HELPER.putNext(this, waiter);
        }

        public void unpark() {
            Thread thread2 = this.thread;
            if (thread2 != null) {
                this.thread = null;
                LockSupport.unpark(thread2);
            }
        }

        public Waiter() {
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper atomicHelper;
        Class<Waiter> cls = Waiter.class;
        Throwable th2 = null;
        try {
            atomicHelper = new UnsafeAtomicHelper();
            th = null;
        } catch (Throwable th3) {
            atomicHelper = new SynchronizedHelper();
            th2 = th3;
        }
        ATOMIC_HELPER = atomicHelper;
        Class<LockSupport> cls2 = LockSupport.class;
        if (th2 != null) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
    }

    private void addDoneString(StringBuilder sb2) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(userObjectToString(uninterruptibly));
            sb2.append("]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e12) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e12.getClass());
            sb2.append(" thrown from get()]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    private Listener clearListeners(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.listeners;
        } while (!ATOMIC_HELPER.casListeners(this, listener2, Listener.TOMBSTONE));
        Listener listener3 = listener2;
        Listener listener4 = listener;
        Listener listener5 = listener3;
        while (listener5 != null) {
            Listener listener6 = listener5.next;
            listener5.next = listener4;
            listener4 = listener5;
            listener5 = listener6;
        }
        return listener4;
    }

    /* access modifiers changed from: private */
    public static void complete(AbstractFuture<?> abstractFuture) {
        Listener listener = null;
        AbstractFuture<V> abstractFuture2 = abstractFuture;
        while (true) {
            abstractFuture2.releaseWaiters();
            abstractFuture2.afterDone();
            Listener clearListeners = abstractFuture2.clearListeners(listener);
            while (true) {
                if (clearListeners != null) {
                    listener = clearListeners.next;
                    Runnable runnable = clearListeners.task;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        AbstractFuture<V> abstractFuture3 = setFuture.owner;
                        if (abstractFuture3.value == setFuture) {
                            if (ATOMIC_HELPER.casValue(abstractFuture3, setFuture, getFutureValue(setFuture.future))) {
                                abstractFuture2 = abstractFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.executor);
                    }
                    clearListeners = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e11);
        }
    }

    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).cause);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        Throwable tryInternalFastPathGetFailure;
        if (listenableFuture instanceof Trusted) {
            Object obj = ((AbstractFuture) listenableFuture).value;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            if (cancellation.wasInterrupted) {
                return cancellation.cause != null ? new Cancellation(false, cancellation.cause) : Cancellation.CAUSELESS_CANCELLED;
            }
            return obj;
        } else if ((listenableFuture instanceof InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(tryInternalFastPathGetFailure);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
                return Cancellation.CAUSELESS_CANCELLED;
            }
            try {
                Object uninterruptibly = getUninterruptibly(listenableFuture);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
            } catch (ExecutionException e11) {
                if (!isCancelled) {
                    return new Failure(e11.getCause());
                }
                return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e11));
            } catch (CancellationException e12) {
                if (isCancelled) {
                    return new Cancellation(false, e12);
                }
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e12));
            } catch (Throwable th2) {
                return new Failure(th2);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
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

    private void releaseWaiters() {
        Waiter waiter;
        do {
            waiter = this.waiters;
        } while (!ATOMIC_HELPER.casWaiters(this, waiter, Waiter.TOMBSTONE));
        while (waiter != null) {
            waiter.unpark();
            waiter = waiter.next;
        }
    }

    private void removeWaiter(Waiter waiter) {
        waiter.thread = null;
        while (true) {
            Waiter waiter2 = this.waiters;
            if (waiter2 != Waiter.TOMBSTONE) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.next;
                    if (waiter2.thread != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.next = waiter4;
                        if (waiter3.thread == null) {
                        }
                    } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        if (isDone() || (listener = this.listeners) == Listener.TOMBSTONE) {
            executeListener(runnable, executor);
        }
        Listener listener2 = new Listener(runnable, executor);
        do {
            listener2.next = listener;
            if (!ATOMIC_HELPER.casListeners(this, listener, listener2)) {
                listener = this.listeners;
            } else {
                return;
            }
        } while (listener != Listener.TOMBSTONE);
        executeListener(runnable, executor);
    }

    @ForOverride
    @Beta
    public void afterDone() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = new com.google.common.util.concurrent.AbstractFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = com.google.common.util.concurrent.AbstractFuture.Cancellation.CAUSELESS_INTERRUPTED
            goto L_0x0026
        L_0x0024:
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = com.google.common.util.concurrent.AbstractFuture.Cancellation.CAUSELESS_CANCELLED
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            com.google.common.util.concurrent.AbstractFuture$AtomicHelper r6 = ATOMIC_HELPER
            boolean r6 = r6.casValue(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            complete(r4)
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r4 == 0) goto L_0x0062
            com.google.common.util.concurrent.AbstractFuture$SetFuture r0 = (com.google.common.util.concurrent.AbstractFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.future
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.Trusted
            if (r4 == 0) goto L_0x0055
            r4 = r0
            com.google.common.util.concurrent.AbstractFuture r4 = (com.google.common.util.concurrent.AbstractFuture) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.cancel(boolean):boolean");
    }

    @CanIgnoreReturnValue
    public V get(long j11, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j12 = j11;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j12);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.waiters;
                if (waiter != Waiter.TOMBSTONE) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.setNext(waiter);
                        if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            removeWaiter(waiter2);
                        } else {
                            waiter = this.waiters;
                        }
                    } while (waiter != Waiter.TOMBSTONE);
                }
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String timeUnit3 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit3.toLowerCase(locale);
            String str = "Waited " + j12 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j13 = -nanos;
                long convert = timeUnit2.convert(j13, TimeUnit.NANOSECONDS);
                long nanos2 = j13 - timeUnit2.toNanos(convert);
                int i11 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z11 = i11 == 0 || nanos2 > 1000;
                if (i11 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z11) {
                        str3 = str3 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                    }
                    str2 = str3 + " ";
                }
                if (z11) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    public boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + userObjectToString(((SetFuture) obj).future) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    @CanIgnoreReturnValue
    public boolean set(V v11) {
        if (v11 == null) {
            v11 = NULL;
        }
        if (!ATOMIC_HELPER.casValue(this, (Object) null, v11)) {
            return false;
        }
        complete(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.casValue(this, (Object) null, new Failure((Throwable) Preconditions.checkNotNull(th2)))) {
            return false;
        }
        complete(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        SetFuture setFuture;
        Failure failure;
        Preconditions.checkNotNull(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.casValue(this, (Object) null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this);
                return true;
            }
            setFuture = new SetFuture(this, listenableFuture);
            if (ATOMIC_HELPER.casValue(this, (Object) null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.FALLBACK_INSTANCE;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).wasInterrupted);
        }
        return false;
        ATOMIC_HELPER.casValue(this, setFuture, failure);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb2);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e11) {
                str = "Exception thrown from implementation: " + e11.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                addDoneString(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof Cancellation) && ((Cancellation) obj).wasInterrupted;
    }

    @CanIgnoreReturnValue
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            Waiter waiter = this.waiters;
            if (waiter != Waiter.TOMBSTONE) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.setNext(waiter);
                    if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue(obj);
                    }
                    waiter = this.waiters;
                } while (waiter != Waiter.TOMBSTONE);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
