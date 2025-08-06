package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import java.util.Objects;
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

public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    public static final b ATOMIC_HELPER;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.sumsub.sns.internal.core.analytics.d.f31895b));
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = Logger.getLogger(AbstractResolvableFuture.class.getName());
    public volatile d listeners;
    public volatile Object value;
    public volatile h waiters;

    public static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        public static final Failure f6514b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f6515a;

        public Failure(Throwable th2) {
            this.f6515a = (Throwable) AbstractResolvableFuture.checkNotNull(th2);
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final c f6516c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f6517d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f6518a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f6519b;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                f6517d = null;
                f6516c = null;
                return;
            }
            f6517d = new c(false, (Throwable) null);
            f6516c = new c(true, (Throwable) null);
        }

        public c(boolean z11, Throwable th2) {
            this.f6518a = z11;
            this.f6519b = th2;
        }
    }

    public static final class d {

        /* renamed from: d  reason: collision with root package name */
        public static final d f6520d = new d((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f6521a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f6522b;

        /* renamed from: c  reason: collision with root package name */
        public d f6523c;

        public d(Runnable runnable, Executor executor) {
            this.f6521a = runnable;
            this.f6522b = executor;
        }
    }

    public static final class e extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f6524a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, h> f6525b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> f6526c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> f6527d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f6528e;

        public e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f6524a = atomicReferenceFieldUpdater;
            this.f6525b = atomicReferenceFieldUpdater2;
            this.f6526c = atomicReferenceFieldUpdater3;
            this.f6527d = atomicReferenceFieldUpdater4;
            this.f6528e = atomicReferenceFieldUpdater5;
        }

        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            return a.a(this.f6527d, abstractResolvableFuture, dVar, dVar2);
        }

        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return a.a(this.f6528e, abstractResolvableFuture, obj, obj2);
        }

        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            return a.a(this.f6526c, abstractResolvableFuture, hVar, hVar2);
        }

        public void d(h hVar, h hVar2) {
            this.f6525b.lazySet(hVar, hVar2);
        }

        public void e(h hVar, Thread thread) {
            this.f6524a.lazySet(hVar, thread);
        }
    }

    public static final class f<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final AbstractResolvableFuture<V> f6529b;

        /* renamed from: c  reason: collision with root package name */
        public final ListenableFuture<? extends V> f6530c;

        public f(AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f6529b = abstractResolvableFuture;
            this.f6530c = listenableFuture;
        }

        public void run() {
            if (this.f6529b.value == this) {
                if (AbstractResolvableFuture.ATOMIC_HELPER.b(this.f6529b, this, AbstractResolvableFuture.getFutureValue(this.f6530c))) {
                    AbstractResolvableFuture.complete(this.f6529b);
                }
            }
        }
    }

    public static final class g extends b {
        public g() {
            super();
        }

        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.listeners != dVar) {
                    return false;
                }
                abstractResolvableFuture.listeners = dVar2;
                return true;
            }
        }

        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.value != obj) {
                    return false;
                }
                abstractResolvableFuture.value = obj2;
                return true;
            }
        }

        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.waiters != hVar) {
                    return false;
                }
                abstractResolvableFuture.waiters = hVar2;
                return true;
            }
        }

        public void d(h hVar, h hVar2) {
            hVar.f6533b = hVar2;
        }

        public void e(h hVar, Thread thread) {
            hVar.f6532a = thread;
        }
    }

    public static final class h {

        /* renamed from: c  reason: collision with root package name */
        public static final h f6531c = new h(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f6532a;

        /* renamed from: b  reason: collision with root package name */
        public volatile h f6533b;

        public h(boolean z11) {
        }

        public void a(h hVar) {
            AbstractResolvableFuture.ATOMIC_HELPER.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f6532a;
            if (thread != null) {
                this.f6532a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            AbstractResolvableFuture.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$h> r0 = androidx.concurrent.futures.AbstractResolvableFuture.h.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            GENERATE_CANCELLATION_CAUSES = r1
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r1 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.String r1 = r1.getName()
            java.util.logging.Logger r1 = java.util.logging.Logger.getLogger(r1)
            log = r1
            androidx.concurrent.futures.AbstractResolvableFuture$e r1 = new androidx.concurrent.futures.AbstractResolvableFuture$e     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.Thread> r2 = java.lang.Thread.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r3)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r2)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r2 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.String r5 = "waiters"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r2, r0, r5)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r0 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$d> r2 = androidx.concurrent.futures.AbstractResolvableFuture.d.class
            java.lang.String r6 = "listeners"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r6)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r0 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            java.lang.String r7 = "value"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r7)     // Catch:{ all -> 0x004e }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004e }
            r0 = 0
            goto L_0x0054
        L_0x004e:
            r0 = move-exception
            androidx.concurrent.futures.AbstractResolvableFuture$g r1 = new androidx.concurrent.futures.AbstractResolvableFuture$g
            r1.<init>()
        L_0x0054:
            ATOMIC_HELPER = r1
            java.lang.Class<java.util.concurrent.locks.LockSupport> r1 = java.util.concurrent.locks.LockSupport.class
            if (r0 == 0) goto L_0x0063
            java.util.logging.Logger r1 = log
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0063:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            NULL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.<clinit>():void");
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

    public static <T> T checkNotNull(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    private d clearListeners(d dVar) {
        d dVar2;
        do {
            dVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, dVar2, d.f6520d));
        d dVar3 = dVar2;
        d dVar4 = dVar;
        d dVar5 = dVar3;
        while (dVar5 != null) {
            d dVar6 = dVar5.f6523c;
            dVar5.f6523c = dVar4;
            dVar4 = dVar5;
            dVar5 = dVar6;
        }
        return dVar4;
    }

    public static void complete(AbstractResolvableFuture<?> abstractResolvableFuture) {
        d dVar = null;
        AbstractResolvableFuture<V> abstractResolvableFuture2 = abstractResolvableFuture;
        while (true) {
            abstractResolvableFuture2.releaseWaiters();
            abstractResolvableFuture2.afterDone();
            d clearListeners = abstractResolvableFuture2.clearListeners(dVar);
            while (true) {
                if (clearListeners != null) {
                    dVar = clearListeners.f6523c;
                    Runnable runnable = clearListeners.f6521a;
                    if (runnable instanceof f) {
                        f fVar = (f) runnable;
                        AbstractResolvableFuture<V> abstractResolvableFuture3 = fVar.f6529b;
                        if (abstractResolvableFuture3.value == fVar) {
                            if (ATOMIC_HELPER.b(abstractResolvableFuture3, fVar, getFutureValue(fVar.f6530c))) {
                                abstractResolvableFuture2 = abstractResolvableFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.f6522b);
                    }
                    clearListeners = dVar;
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
        if (obj instanceof c) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((c) obj).f6519b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f6515a);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).value;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.f6518a) {
                return obj;
            }
            if (cVar.f6519b != null) {
                return new c(false, cVar.f6519b);
            }
            return c.f6517d;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return c.f6517d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            return uninterruptibly == null ? NULL : uninterruptibly;
        } catch (ExecutionException e11) {
            return new Failure(e11.getCause());
        } catch (CancellationException e12) {
            if (isCancelled) {
                return new c(false, e12);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e12));
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

    static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
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
        h hVar;
        do {
            hVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, hVar, h.f6531c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f6533b;
        }
    }

    private void removeWaiter(h hVar) {
        hVar.f6532a = null;
        while (true) {
            h hVar2 = this.waiters;
            if (hVar2 != h.f6531c) {
                h hVar3 = null;
                while (hVar2 != null) {
                    h hVar4 = hVar2.f6533b;
                    if (hVar2.f6532a != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f6533b = hVar4;
                        if (hVar3.f6532a == null) {
                        }
                    } else if (!ATOMIC_HELPER.c(this, hVar2, hVar4)) {
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        d dVar = this.listeners;
        if (dVar != d.f6520d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f6523c = dVar;
                if (!ATOMIC_HELPER.a(this, dVar, dVar2)) {
                    dVar = this.listeners;
                } else {
                    return;
                }
            } while (dVar != d.f6520d);
        }
        executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
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
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.f
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            androidx.concurrent.futures.AbstractResolvableFuture$c r3 = new androidx.concurrent.futures.AbstractResolvableFuture$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.concurrent.futures.AbstractResolvableFuture$c r3 = androidx.concurrent.futures.AbstractResolvableFuture.c.f6516c
            goto L_0x0026
        L_0x0024:
            androidx.concurrent.futures.AbstractResolvableFuture$c r3 = androidx.concurrent.futures.AbstractResolvableFuture.c.f6517d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.concurrent.futures.AbstractResolvableFuture$b r6 = ATOMIC_HELPER
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            complete(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.f
            if (r4 == 0) goto L_0x0062
            androidx.concurrent.futures.AbstractResolvableFuture$f r0 = (androidx.concurrent.futures.AbstractResolvableFuture.f) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.f6530c
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.concurrent.futures.AbstractResolvableFuture r4 = (androidx.concurrent.futures.AbstractResolvableFuture) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.f
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.f
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.cancel(boolean):boolean");
    }

    public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j12 = j11;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j12);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof f))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                h hVar = this.waiters;
                if (hVar != h.f6531c) {
                    h hVar2 = new h();
                    do {
                        hVar2.a(hVar);
                        if (ATOMIC_HELPER.c(this, hVar, hVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof f))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(hVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            removeWaiter(hVar2);
                        } else {
                            hVar = this.waiters;
                        }
                    } while (hVar != h.f6531c);
                }
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof f))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
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
            throw new TimeoutException(str + " for " + abstractResolvableFuture);
        }
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    public final boolean isCancelled() {
        return this.value instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof f)) & (obj != null);
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof f) {
            return "setFuture=[" + userObjectToString(((f) obj).f6530c) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    public boolean set(V v11) {
        if (v11 == null) {
            v11 = NULL;
        }
        if (!ATOMIC_HELPER.b(this, (Object) null, v11)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.b(this, (Object) null, new Failure((Throwable) checkNotNull(th2)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        f fVar;
        Failure failure;
        checkNotNull(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.b(this, (Object) null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this);
                return true;
            }
            fVar = new f(this, listenableFuture);
            if (ATOMIC_HELPER.b(this, (Object) null, fVar)) {
                try {
                    listenableFuture.addListener(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.f6514b;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).f6518a);
        }
        return false;
        ATOMIC_HELPER.b(this, fVar, failure);
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

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).f6518a;
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof f))) {
                return getDoneValue(obj2);
            }
            h hVar = this.waiters;
            if (hVar != h.f6531c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (ATOMIC_HELPER.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return getDoneValue(obj);
                    }
                    hVar = this.waiters;
                } while (hVar != h.f6531c);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
