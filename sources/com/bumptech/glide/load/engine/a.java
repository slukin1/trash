package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.engine.m;
import f4.h;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f63716a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f63717b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<n3.b, d> f63718c;

    /* renamed from: d  reason: collision with root package name */
    public final ReferenceQueue<m<?>> f63719d;

    /* renamed from: e  reason: collision with root package name */
    public m.a f63720e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f63721f;

    /* renamed from: g  reason: collision with root package name */
    public volatile c f63722g;

    /* renamed from: com.bumptech.glide.load.engine.a$a  reason: collision with other inner class name */
    public class C0700a implements ThreadFactory {

        /* renamed from: com.bumptech.glide.load.engine.a$a$a  reason: collision with other inner class name */
        public class C0701a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Runnable f63723b;

            public C0701a(Runnable runnable) {
                this.f63723b = runnable;
            }

            public void run() {
                Process.setThreadPriority(10);
                this.f63723b.run();
            }
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(new C0701a(runnable), "glide-active-resources");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a.this.b();
        }
    }

    public interface c {
        void a();
    }

    public static final class d extends WeakReference<m<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final n3.b f63726a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f63727b;

        /* renamed from: c  reason: collision with root package name */
        public r<?> f63728c;

        public d(n3.b bVar, m<?> mVar, ReferenceQueue<? super m<?>> referenceQueue, boolean z11) {
            super(mVar, referenceQueue);
            this.f63726a = (n3.b) h.d(bVar);
            this.f63728c = (!mVar.d() || !z11) ? null : (r) h.d(mVar.c());
            this.f63727b = mVar.d();
        }

        public void a() {
            this.f63728c = null;
            clear();
        }
    }

    public a(boolean z11) {
        this(z11, Executors.newSingleThreadExecutor(new C0700a()));
    }

    public synchronized void a(n3.b bVar, m<?> mVar) {
        d put = this.f63718c.put(bVar, new d(bVar, mVar, this.f63719d, this.f63716a));
        if (put != null) {
            put.a();
        }
    }

    public void b() {
        while (!this.f63721f) {
            try {
                c((d) this.f63719d.remove());
                c cVar = this.f63722g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(d dVar) {
        synchronized (this) {
            this.f63718c.remove(dVar.f63726a);
            if (dVar.f63727b) {
                r<?> rVar = dVar.f63728c;
                if (rVar != null) {
                    this.f63720e.a(dVar.f63726a, new m(rVar, true, false, dVar.f63726a, this.f63720e));
                }
            }
        }
    }

    public synchronized void d(n3.b bVar) {
        d remove = this.f63718c.remove(bVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.load.engine.m<?> e(n3.b r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<n3.b, com.bumptech.glide.load.engine.a$d> r0 = r1.f63718c     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.a$d r2 = (com.bumptech.glide.load.engine.a.d) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.m r0 = (com.bumptech.glide.load.engine.m) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.c(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.a.e(n3.b):com.bumptech.glide.load.engine.m");
    }

    public void f(m.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f63720e = aVar;
            }
        }
    }

    public a(boolean z11, Executor executor) {
        this.f63718c = new HashMap();
        this.f63719d = new ReferenceQueue<>();
        this.f63716a = z11;
        this.f63717b = executor;
        executor.execute(new b());
    }
}
