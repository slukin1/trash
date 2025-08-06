package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.concurrent.futures.a;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.internal.InternalFutureFailureAccess;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.internal.InternalFutures;
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

public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f11325e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", d.f31895b));

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f11326f = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicHelper f11327g;

    /* renamed from: h  reason: collision with root package name */
    public static final Object f11328h = new Object();

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f11329b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Listener f11330c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Waiter f11331d;

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        public abstract void d(Waiter waiter, Waiter waiter2);

        public abstract void e(Waiter waiter, Thread thread);
    }

    public static final class Cancellation {

        /* renamed from: c  reason: collision with root package name */
        public static final Cancellation f11332c;

        /* renamed from: d  reason: collision with root package name */
        public static final Cancellation f11333d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f11334a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f11335b;

        static {
            if (AbstractFuture.f11325e) {
                f11333d = null;
                f11332c = null;
                return;
            }
            f11333d = new Cancellation(false, (Throwable) null);
            f11332c = new Cancellation(true, (Throwable) null);
        }

        public Cancellation(boolean z11, Throwable th2) {
            this.f11334a = z11;
            this.f11335b = th2;
        }
    }

    public static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        public static final Failure f11336b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f11337a;

        public Failure(Throwable th2) {
            this.f11337a = (Throwable) Preconditions.i(th2);
        }
    }

    public static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        public static final Listener f11338d = new Listener((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f11339a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f11340b;

        /* renamed from: c  reason: collision with root package name */
        public Listener f11341c;

        public Listener(Runnable runnable, Executor executor) {
            this.f11339a = runnable;
            this.f11340b = executor;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<Waiter, Thread> f11342a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> f11343b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f11344c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f11345d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f11346e;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f11342a = atomicReferenceFieldUpdater;
            this.f11343b = atomicReferenceFieldUpdater2;
            this.f11344c = atomicReferenceFieldUpdater3;
            this.f11345d = atomicReferenceFieldUpdater4;
            this.f11346e = atomicReferenceFieldUpdater5;
        }

        public boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return a.a(this.f11345d, abstractFuture, listener, listener2);
        }

        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.a(this.f11346e, abstractFuture, obj, obj2);
        }

        public boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f11344c, abstractFuture, waiter, waiter2);
        }

        public void d(Waiter waiter, Waiter waiter2) {
            this.f11343b.lazySet(waiter, waiter2);
        }

        public void e(Waiter waiter, Thread thread) {
            this.f11342a.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final AbstractFuture<V> f11347b;

        /* renamed from: c  reason: collision with root package name */
        public final ListenableFuture<? extends V> f11348c;

        public void run() {
            if (this.f11347b.f11329b == this) {
                if (AbstractFuture.f11327g.b(this.f11347b, this, AbstractFuture.s(this.f11348c))) {
                    AbstractFuture.p(this.f11347b);
                }
            }
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        public boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f11330c != listener) {
                    return false;
                }
                Listener unused = abstractFuture.f11330c = listener2;
                return true;
            }
        }

        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f11329b != obj) {
                    return false;
                }
                Object unused = abstractFuture.f11329b = obj2;
                return true;
            }
        }

        public boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f11331d != waiter) {
                    return false;
                }
                Waiter unused = abstractFuture.f11331d = waiter2;
                return true;
            }
        }

        public void d(Waiter waiter, Waiter waiter2) {
            waiter.f11357b = waiter2;
        }

        public void e(Waiter waiter, Thread thread) {
            waiter.f11356a = thread;
        }
    }

    public interface Trusted<V> extends ListenableFuture<V> {
    }

    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        public final void addListener(Runnable runnable, Executor executor) {
            AbstractFuture.super.addListener(runnable, executor);
        }

        public final boolean cancel(boolean z11) {
            return AbstractFuture.super.cancel(z11);
        }

        public final V get() throws InterruptedException, ExecutionException {
            return AbstractFuture.super.get();
        }

        public final boolean isCancelled() {
            return AbstractFuture.super.isCancelled();
        }

        public final boolean isDone() {
            return AbstractFuture.super.isDone();
        }

        public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return AbstractFuture.super.get(j11, timeUnit);
        }
    }

    public static final class UnsafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final Unsafe f11349a;

        /* renamed from: b  reason: collision with root package name */
        public static final long f11350b;

        /* renamed from: c  reason: collision with root package name */
        public static final long f11351c;

        /* renamed from: d  reason: collision with root package name */
        public static final long f11352d;

        /* renamed from: e  reason: collision with root package name */
        public static final long f11353e;

        /* renamed from: f  reason: collision with root package name */
        public static final long f11354f;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.UnsafeAtomicHelper.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$Waiter> r0 = androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.Waiter.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1 r1 = new androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1     // Catch:{ PrivilegedActionException -> 0x005d }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
            L_0x0012:
                java.lang.Class<androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture> r2 = androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.class
                java.lang.String r3 = "d"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                f11351c = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "c"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                f11350b = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "b"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                f11352d = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "a"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                f11353e = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "b"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
                f11354f = r2     // Catch:{ Exception -> 0x0053 }
                f11349a = r1     // Catch:{ Exception -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                androidx.test.espresso.core.internal.deps.guava.base.Throwables.e(r0)
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.UnsafeAtomicHelper.<clinit>():void");
        }

        private UnsafeAtomicHelper() {
            super();
        }

        public boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return a.a(f11349a, abstractFuture, f11350b, listener, listener2);
        }

        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.a(f11349a, abstractFuture, f11352d, obj, obj2);
        }

        public boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(f11349a, abstractFuture, f11351c, waiter, waiter2);
        }

        public void d(Waiter waiter, Waiter waiter2) {
            f11349a.putObject(waiter, f11354f, waiter2);
        }

        public void e(Waiter waiter, Thread thread) {
            f11349a.putObject(waiter, f11353e, thread);
        }
    }

    public static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        public static final Waiter f11355c = new Waiter(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f11356a;

        /* renamed from: b  reason: collision with root package name */
        public volatile Waiter f11357b;

        public Waiter(boolean z11) {
        }

        public void a(Waiter waiter) {
            AbstractFuture.f11327g.d(this, waiter);
        }

        public void b() {
            Thread thread = this.f11356a;
            if (thread != null) {
                this.f11356a = null;
                LockSupport.unpark(thread);
            }
        }

        public Waiter() {
            AbstractFuture.f11327g.e(this, Thread.currentThread());
        }
    }

    static {
        Throwable th2;
        Throwable th3;
        AtomicHelper atomicHelper;
        Class<Waiter> cls = Waiter.class;
        try {
            atomicHelper = new UnsafeAtomicHelper();
            th3 = null;
            th2 = null;
        } catch (Throwable th4) {
            th2 = th4;
            th3 = th;
            atomicHelper = new SynchronizedHelper();
        }
        f11327g = atomicHelper;
        Class<LockSupport> cls2 = LockSupport.class;
        if (th2 != null) {
            Logger logger = f11326f;
            Level level = Level.SEVERE;
            logger.logp(level, "androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th3);
            logger.logp(level, "androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
    }

    public static CancellationException n(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    public static void p(AbstractFuture<?> abstractFuture) {
        Listener listener = null;
        AbstractFuture<V> abstractFuture2 = abstractFuture;
        while (true) {
            abstractFuture2.w();
            abstractFuture2.m();
            Listener o11 = abstractFuture2.o(listener);
            while (true) {
                if (o11 != null) {
                    listener = o11.f11341c;
                    Runnable runnable = o11.f11339a;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        AbstractFuture<V> abstractFuture3 = setFuture.f11347b;
                        if (abstractFuture3.f11329b == setFuture) {
                            if (f11327g.b(abstractFuture3, setFuture, s(setFuture.f11348c))) {
                                abstractFuture2 = abstractFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        q(runnable, o11.f11340b);
                    }
                    o11 = listener;
                } else {
                    return;
                }
            }
        }
    }

    public static void q(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            Logger logger = f11326f;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.logp(level, "androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture", "executeListener", sb2.toString(), e11);
        }
    }

    public static Object s(ListenableFuture<?> listenableFuture) {
        Throwable a11;
        if (listenableFuture instanceof Trusted) {
            Object obj = ((AbstractFuture) listenableFuture).f11329b;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            if (!cancellation.f11334a) {
                return obj;
            }
            if (cancellation.f11335b != null) {
                return new Cancellation(false, cancellation.f11335b);
            }
            return Cancellation.f11333d;
        } else if ((listenableFuture instanceof InternalFutureFailureAccess) && (a11 = InternalFutures.a((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(a11);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!f11325e) && isCancelled) {
                return Cancellation.f11333d;
            }
            try {
                Object t11 = t(listenableFuture);
                if (!isCancelled) {
                    return t11 == null ? f11328h : t11;
                }
                String valueOf = String.valueOf(listenableFuture);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 84);
                sb2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb2.append(valueOf);
                return new Cancellation(false, new IllegalArgumentException(sb2.toString()));
            } catch (ExecutionException e11) {
                if (!isCancelled) {
                    return new Failure(e11.getCause());
                }
                String valueOf2 = String.valueOf(listenableFuture);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 84);
                sb3.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb3.append(valueOf2);
                return new Cancellation(false, new IllegalArgumentException(sb3.toString(), e11));
            } catch (CancellationException e12) {
                if (isCancelled) {
                    return new Cancellation(false, e12);
                }
                String valueOf3 = String.valueOf(listenableFuture);
                StringBuilder sb4 = new StringBuilder(valueOf3.length() + 77);
                sb4.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb4.append(valueOf3);
                return new Failure(new IllegalArgumentException(sb4.toString(), e12));
            } catch (Throwable th2) {
                return new Failure(th2);
            }
        }
    }

    public static <V> V t(Future<V> future) throws ExecutionException {
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

    public final String A(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean B() {
        Object obj = this.f11329b;
        return (obj instanceof Cancellation) && ((Cancellation) obj).f11334a;
    }

    public final Throwable a() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.f11329b;
        if (obj instanceof Failure) {
            return ((Failure) obj).f11337a;
        }
        return null;
    }

    public void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        Preconditions.j(runnable, "Runnable was null.");
        Preconditions.j(executor, "Executor was null.");
        if (isDone() || (listener = this.f11330c) == Listener.f11338d) {
            q(runnable, executor);
        }
        Listener listener2 = new Listener(runnable, executor);
        do {
            listener2.f11341c = listener;
            if (!f11327g.a(this, listener, listener2)) {
                listener = this.f11330c;
            } else {
                return;
            }
        } while (listener != Listener.f11338d);
        q(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f11329b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f11325e
            if (r3 == 0) goto L_0x001f
            androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$Cancellation r3 = new androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$Cancellation r3 = androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.Cancellation.f11332c
            goto L_0x0026
        L_0x0024:
            androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$Cancellation r3 = androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.Cancellation.f11333d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$AtomicHelper r6 = f11327g
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.u()
        L_0x0035:
            p(r4)
            boolean r4 = r0 instanceof androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.SetFuture
            if (r4 == 0) goto L_0x0062
            androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$SetFuture r0 = (androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.SetFuture) r0
            androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture<? extends V> r0 = r0.f11348c
            boolean r4 = r0 instanceof androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.Trusted
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture r4 = (androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture) r4
            java.lang.Object r0 = r4.f11329b
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f11329b
            boolean r6 = r0 instanceof androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.SetFuture
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture.cancel(boolean):boolean");
    }

    public V get(long j11, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j12 = j11;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j12);
        if (!Thread.interrupted()) {
            Object obj = this.f11329b;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return r(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.f11331d;
                if (waiter != Waiter.f11355c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (f11327g.c(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f11329b;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return r(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    x(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            x(waiter2);
                        } else {
                            waiter = this.f11331d;
                        }
                    } while (waiter != Waiter.f11355c);
                }
                return r(this.f11329b);
            }
            while (nanos > 0) {
                Object obj3 = this.f11329b;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return r(obj3);
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
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb2.append("Waited ");
            sb2.append(j12);
            sb2.append(" ");
            sb2.append(lowerCase2);
            String sb3 = sb2.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb3).concat(" (plus ");
                long j13 = -nanos;
                long convert = timeUnit2.convert(j13, TimeUnit.NANOSECONDS);
                long nanos2 = j13 - timeUnit2.toNanos(convert);
                int i11 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z11 = i11 == 0 || nanos2 > 1000;
                if (i11 > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb4 = new StringBuilder(valueOf.length() + 21 + String.valueOf(lowerCase).length());
                    sb4.append(valueOf);
                    sb4.append(convert);
                    sb4.append(" ");
                    sb4.append(lowerCase);
                    String sb5 = sb4.toString();
                    if (z11) {
                        sb5 = String.valueOf(sb5).concat(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    concat = String.valueOf(sb5).concat(" ");
                }
                if (z11) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb6 = new StringBuilder(valueOf2.length() + 33);
                    sb6.append(valueOf2);
                    sb6.append(nanos2);
                    sb6.append(" nanoseconds ");
                    concat = sb6.toString();
                }
                sb3 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb3).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb7 = new StringBuilder(String.valueOf(sb3).length() + 5 + String.valueOf(abstractFuture).length());
            sb7.append(sb3);
            sb7.append(" for ");
            sb7.append(abstractFuture);
            throw new TimeoutException(sb7.toString());
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.f11329b instanceof Cancellation;
    }

    public boolean isDone() {
        Object obj = this.f11329b;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    public final void l(StringBuilder sb2) {
        try {
            Object t11 = t(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(A(t11));
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

    public void m() {
    }

    public final Listener o(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.f11330c;
        } while (!f11327g.a(this, listener2, Listener.f11338d));
        Listener listener3 = listener2;
        Listener listener4 = listener;
        Listener listener5 = listener3;
        while (listener5 != null) {
            Listener listener6 = listener5.f11341c;
            listener5.f11341c = listener4;
            listener4 = listener5;
            listener5 = listener6;
        }
        return listener4;
    }

    public final V r(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw n("Task was cancelled.", ((Cancellation) obj).f11335b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f11337a);
        } else if (obj == f11328h) {
            return null;
        } else {
            return obj;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            l(sb2);
        } else {
            try {
                str = v();
            } catch (RuntimeException e11) {
                String valueOf = String.valueOf(e11.getClass());
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 38);
                sb3.append("Exception thrown from implementation: ");
                sb3.append(valueOf);
                str = sb3.toString();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                l(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void u() {
    }

    public String v() {
        Object obj = this.f11329b;
        if (obj instanceof SetFuture) {
            String A = A(((SetFuture) obj).f11348c);
            StringBuilder sb2 = new StringBuilder(String.valueOf(A).length() + 12);
            sb2.append("setFuture=[");
            sb2.append(A);
            sb2.append("]");
            return sb2.toString();
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
            StringBuilder sb3 = new StringBuilder(41);
            sb3.append("remaining delay=[");
            sb3.append(delay);
            sb3.append(" ms]");
            return sb3.toString();
        }
    }

    public final void w() {
        Waiter waiter;
        do {
            waiter = this.f11331d;
        } while (!f11327g.c(this, waiter, Waiter.f11355c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f11357b;
        }
    }

    public final void x(Waiter waiter) {
        waiter.f11356a = null;
        while (true) {
            Waiter waiter2 = this.f11331d;
            if (waiter2 != Waiter.f11355c) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.f11357b;
                    if (waiter2.f11356a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.f11357b = waiter4;
                        if (waiter3.f11356a == null) {
                        }
                    } else if (!f11327g.c(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    public boolean y(V v11) {
        if (v11 == null) {
            v11 = f11328h;
        }
        if (!f11327g.b(this, (Object) null, v11)) {
            return false;
        }
        p(this);
        return true;
    }

    public boolean z(Throwable th2) {
        if (!f11327g.b(this, (Object) null, new Failure((Throwable) Preconditions.i(th2)))) {
            return false;
        }
        p(this);
        return true;
    }

    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f11329b;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return r(obj2);
            }
            Waiter waiter = this.f11331d;
            if (waiter != Waiter.f11355c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f11327g.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f11329b;
                            } else {
                                x(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return r(obj);
                    }
                    waiter = this.f11331d;
                } while (waiter != Waiter.f11355c);
            }
            return r(this.f11329b);
        }
        throw new InterruptedException();
    }
}
