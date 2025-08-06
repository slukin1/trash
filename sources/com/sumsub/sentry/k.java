package com.sumsub.sentry;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class k {

    /* renamed from: g  reason: collision with root package name */
    public static final b f30403g = new b((r) null);

    /* renamed from: h  reason: collision with root package name */
    public static final long f30404h = TimeUnit.HOURS.toMillis(5);

    /* renamed from: i  reason: collision with root package name */
    public static final long f30405i = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: j  reason: collision with root package name */
    public static final i<k> f30406j = LazyKt__LazyJVMKt.a(a.f30413a);

    /* renamed from: a  reason: collision with root package name */
    public final long f30407a;

    /* renamed from: b  reason: collision with root package name */
    public final Callable<InetAddress> f30408b;

    /* renamed from: c  reason: collision with root package name */
    public volatile String f30409c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f30410d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f30411e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f30412f;

    public static final class a extends Lambda implements d10.a<k> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30413a = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final k invoke() {
            return new k((r) null);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final k a() {
            return (k) k.f30406j.getValue();
        }

        public b() {
        }
    }

    public static final class c implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public int f30414a;

        public Thread newThread(Runnable runnable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SentryHostnameCache-");
            int i11 = this.f30414a;
            this.f30414a = i11 + 1;
            sb2.append(i11);
            Thread thread = new Thread(runnable, sb2.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public k(long j11) {
        this(j11, (Callable) null, 2, (r) null);
    }

    public static final InetAddress a() {
        return InetAddress.getLocalHost();
    }

    public final void c() {
        this.f30412f.shutdown();
    }

    public final String d() {
        if (this.f30410d < System.currentTimeMillis() && this.f30411e.compareAndSet(false, true)) {
            g();
        }
        return this.f30409c;
    }

    public final void e() {
        this.f30410d = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1);
    }

    public final boolean f() {
        return this.f30412f.isShutdown();
    }

    public final void g() {
        try {
            this.f30412f.submit(new s0(this)).get(f30405i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            e();
        } catch (ExecutionException unused2) {
            e();
        } catch (TimeoutException unused3) {
            e();
        } catch (RuntimeException unused4) {
            e();
        }
    }

    public /* synthetic */ k(r rVar) {
        this();
    }

    /* JADX INFO: finally extract failed */
    public static final Void a(k kVar) {
        try {
            kVar.f30409c = kVar.f30408b.call().getCanonicalHostName();
            kVar.f30410d = System.currentTimeMillis() + kVar.f30407a;
            kVar.f30411e.set(false);
            return null;
        } catch (Throwable th2) {
            kVar.f30411e.set(false);
            throw th2;
        }
    }

    public k(long j11, Callable<InetAddress> callable) {
        this.f30407a = j11;
        this.f30408b = callable;
        this.f30411e = new AtomicBoolean(false);
        this.f30412f = Executors.newSingleThreadExecutor(new c());
        g();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(long j11, Callable callable, int i11, r rVar) {
        this(j11, (i11 & 2) != 0 ? t0.f30501b : callable);
    }

    public k() {
        this(f30404h, (Callable) null, 2, (r) null);
    }
}
