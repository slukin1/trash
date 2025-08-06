package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.request.f;
import f4.h;
import g4.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class i<R> implements DecodeJob.b<R>, a.f {

    /* renamed from: z  reason: collision with root package name */
    public static final c f63855z = new c();

    /* renamed from: b  reason: collision with root package name */
    public final e f63856b;

    /* renamed from: c  reason: collision with root package name */
    public final g4.c f63857c;

    /* renamed from: d  reason: collision with root package name */
    public final m.a f63858d;

    /* renamed from: e  reason: collision with root package name */
    public final androidx.core.util.e<i<?>> f63859e;

    /* renamed from: f  reason: collision with root package name */
    public final c f63860f;

    /* renamed from: g  reason: collision with root package name */
    public final j f63861g;

    /* renamed from: h  reason: collision with root package name */
    public final r3.a f63862h;

    /* renamed from: i  reason: collision with root package name */
    public final r3.a f63863i;

    /* renamed from: j  reason: collision with root package name */
    public final r3.a f63864j;

    /* renamed from: k  reason: collision with root package name */
    public final r3.a f63865k;

    /* renamed from: l  reason: collision with root package name */
    public final AtomicInteger f63866l;

    /* renamed from: m  reason: collision with root package name */
    public n3.b f63867m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f63868n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f63869o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f63870p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f63871q;

    /* renamed from: r  reason: collision with root package name */
    public r<?> f63872r;

    /* renamed from: s  reason: collision with root package name */
    public DataSource f63873s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f63874t;

    /* renamed from: u  reason: collision with root package name */
    public GlideException f63875u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f63876v;

    /* renamed from: w  reason: collision with root package name */
    public m<?> f63877w;

    /* renamed from: x  reason: collision with root package name */
    public DecodeJob<R> f63878x;

    /* renamed from: y  reason: collision with root package name */
    public volatile boolean f63879y;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final f f63880b;

        public a(f fVar) {
            this.f63880b = fVar;
        }

        public void run() {
            synchronized (this.f63880b.g()) {
                synchronized (i.this) {
                    if (i.this.f63856b.b(this.f63880b)) {
                        i.this.f(this.f63880b);
                    }
                    i.this.i();
                }
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final f f63882b;

        public b(f fVar) {
            this.f63882b = fVar;
        }

        public void run() {
            synchronized (this.f63882b.g()) {
                synchronized (i.this) {
                    if (i.this.f63856b.b(this.f63882b)) {
                        i.this.f63877w.b();
                        i.this.g(this.f63882b);
                        i.this.r(this.f63882b);
                    }
                    i.this.i();
                }
            }
        }
    }

    public static class c {
        public <R> m<R> a(r<R> rVar, boolean z11, n3.b bVar, m.a aVar) {
            return new m(rVar, z11, true, bVar, aVar);
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final f f63884a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f63885b;

        public d(f fVar, Executor executor) {
            this.f63884a = fVar;
            this.f63885b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f63884a.equals(((d) obj).f63884a);
            }
            return false;
        }

        public int hashCode() {
            return this.f63884a.hashCode();
        }
    }

    public static final class e implements Iterable<d> {

        /* renamed from: b  reason: collision with root package name */
        public final List<d> f63886b;

        public e() {
            this(new ArrayList(2));
        }

        public static d d(f fVar) {
            return new d(fVar, f4.d.a());
        }

        public void a(f fVar, Executor executor) {
            this.f63886b.add(new d(fVar, executor));
        }

        public boolean b(f fVar) {
            return this.f63886b.contains(d(fVar));
        }

        public e c() {
            return new e(new ArrayList(this.f63886b));
        }

        public void clear() {
            this.f63886b.clear();
        }

        public void e(f fVar) {
            this.f63886b.remove(d(fVar));
        }

        public boolean isEmpty() {
            return this.f63886b.isEmpty();
        }

        public Iterator<d> iterator() {
            return this.f63886b.iterator();
        }

        public int size() {
            return this.f63886b.size();
        }

        public e(List<d> list) {
            this.f63886b = list;
        }
    }

    public i(r3.a aVar, r3.a aVar2, r3.a aVar3, r3.a aVar4, j jVar, m.a aVar5, androidx.core.util.e<i<?>> eVar) {
        this(aVar, aVar2, aVar3, aVar4, jVar, aVar5, eVar, f63855z);
    }

    public synchronized void a(f fVar, Executor executor) {
        this.f63857c.c();
        this.f63856b.a(fVar, executor);
        boolean z11 = true;
        if (this.f63874t) {
            k(1);
            executor.execute(new b(fVar));
        } else if (this.f63876v) {
            k(1);
            executor.execute(new a(fVar));
        } else {
            if (this.f63879y) {
                z11 = false;
            }
            h.a(z11, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    public void b(GlideException glideException) {
        synchronized (this) {
            this.f63875u = glideException;
        }
        n();
    }

    public void c(r<R> rVar, DataSource dataSource) {
        synchronized (this) {
            this.f63872r = rVar;
            this.f63873s = dataSource;
        }
        o();
    }

    public void d(DecodeJob<?> decodeJob) {
        j().execute(decodeJob);
    }

    public g4.c e() {
        return this.f63857c;
    }

    public void f(f fVar) {
        try {
            fVar.b(this.f63875u);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    public void g(f fVar) {
        try {
            fVar.c(this.f63877w, this.f63873s);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    public void h() {
        if (!m()) {
            this.f63879y = true;
            this.f63878x.a();
            this.f63861g.b(this, this.f63867m);
        }
    }

    public void i() {
        m<?> mVar;
        synchronized (this) {
            this.f63857c.c();
            h.a(m(), "Not yet complete!");
            int decrementAndGet = this.f63866l.decrementAndGet();
            h.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                mVar = this.f63877w;
                q();
            } else {
                mVar = null;
            }
        }
        if (mVar != null) {
            mVar.e();
        }
    }

    public final r3.a j() {
        if (this.f63869o) {
            return this.f63864j;
        }
        return this.f63870p ? this.f63865k : this.f63863i;
    }

    public synchronized void k(int i11) {
        m<?> mVar;
        h.a(m(), "Not yet complete!");
        if (this.f63866l.getAndAdd(i11) == 0 && (mVar = this.f63877w) != null) {
            mVar.b();
        }
    }

    public synchronized i<R> l(n3.b bVar, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f63867m = bVar;
        this.f63868n = z11;
        this.f63869o = z12;
        this.f63870p = z13;
        this.f63871q = z14;
        return this;
    }

    public final boolean m() {
        return this.f63876v || this.f63874t || this.f63879y;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.f63861g.d(r4, r1, (com.bumptech.glide.load.engine.m<?>) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = r0.next();
        r1.f63885b.execute(new com.bumptech.glide.load.engine.i.a(r4, r1.f63884a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
            r4 = this;
            monitor-enter(r4)
            g4.c r0 = r4.f63857c     // Catch:{ all -> 0x0066 }
            r0.c()     // Catch:{ all -> 0x0066 }
            boolean r0 = r4.f63879y     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x000f
            r4.q()     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return
        L_0x000f:
            com.bumptech.glide.load.engine.i$e r0 = r4.f63856b     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x005e
            boolean r0 = r4.f63876v     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0056
            r0 = 1
            r4.f63876v = r0     // Catch:{ all -> 0x0066 }
            n3.b r1 = r4.f63867m     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.i$e r2 = r4.f63856b     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.i$e r2 = r2.c()     // Catch:{ all -> 0x0066 }
            int r3 = r2.size()     // Catch:{ all -> 0x0066 }
            int r3 = r3 + r0
            r4.k(r3)     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.j r0 = r4.f63861g
            r3 = 0
            r0.d(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x0039:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.i$d r1 = (com.bumptech.glide.load.engine.i.d) r1
            java.util.concurrent.Executor r2 = r1.f63885b
            com.bumptech.glide.load.engine.i$a r3 = new com.bumptech.glide.load.engine.i$a
            com.bumptech.glide.request.f r1 = r1.f63884a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0039
        L_0x0052:
            r4.i()
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.i.n():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r5.f63861g.d(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r1 = r0.next();
        r1.f63885b.execute(new com.bumptech.glide.load.engine.i.b(r5, r1.f63884a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
            r5 = this;
            monitor-enter(r5)
            g4.c r0 = r5.f63857c     // Catch:{ all -> 0x007c }
            r0.c()     // Catch:{ all -> 0x007c }
            boolean r0 = r5.f63879y     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0014
            com.bumptech.glide.load.engine.r<?> r0 = r5.f63872r     // Catch:{ all -> 0x007c }
            r0.recycle()     // Catch:{ all -> 0x007c }
            r5.q()     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            return
        L_0x0014:
            com.bumptech.glide.load.engine.i$e r0 = r5.f63856b     // Catch:{ all -> 0x007c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x0074
            boolean r0 = r5.f63874t     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x006c
            com.bumptech.glide.load.engine.i$c r0 = r5.f63860f     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.r<?> r1 = r5.f63872r     // Catch:{ all -> 0x007c }
            boolean r2 = r5.f63868n     // Catch:{ all -> 0x007c }
            n3.b r3 = r5.f63867m     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.m$a r4 = r5.f63858d     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.m r0 = r0.a(r1, r2, r3, r4)     // Catch:{ all -> 0x007c }
            r5.f63877w = r0     // Catch:{ all -> 0x007c }
            r0 = 1
            r5.f63874t = r0     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.i$e r1 = r5.f63856b     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.i$e r1 = r1.c()     // Catch:{ all -> 0x007c }
            int r2 = r1.size()     // Catch:{ all -> 0x007c }
            int r2 = r2 + r0
            r5.k(r2)     // Catch:{ all -> 0x007c }
            n3.b r0 = r5.f63867m     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.m<?> r2 = r5.f63877w     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.j r3 = r5.f63861g
            r3.d(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x004f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.i$d r1 = (com.bumptech.glide.load.engine.i.d) r1
            java.util.concurrent.Executor r2 = r1.f63885b
            com.bumptech.glide.load.engine.i$b r3 = new com.bumptech.glide.load.engine.i$b
            com.bumptech.glide.request.f r1 = r1.f63884a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x004f
        L_0x0068:
            r5.i()
            return
        L_0x006c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x0074:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x007c:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.i.o():void");
    }

    public boolean p() {
        return this.f63871q;
    }

    public final synchronized void q() {
        if (this.f63867m != null) {
            this.f63856b.clear();
            this.f63867m = null;
            this.f63877w = null;
            this.f63872r = null;
            this.f63876v = false;
            this.f63879y = false;
            this.f63874t = false;
            this.f63878x.x(false);
            this.f63878x = null;
            this.f63875u = null;
            this.f63873s = null;
            this.f63859e.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void r(f fVar) {
        boolean z11;
        this.f63857c.c();
        this.f63856b.e(fVar);
        if (this.f63856b.isEmpty()) {
            h();
            if (!this.f63874t) {
                if (!this.f63876v) {
                    z11 = false;
                    if (z11 && this.f63866l.get() == 0) {
                        q();
                    }
                }
            }
            z11 = true;
            q();
        }
    }

    public synchronized void s(DecodeJob<R> decodeJob) {
        this.f63878x = decodeJob;
        (decodeJob.D() ? this.f63862h : j()).execute(decodeJob);
    }

    public i(r3.a aVar, r3.a aVar2, r3.a aVar3, r3.a aVar4, j jVar, m.a aVar5, androidx.core.util.e<i<?>> eVar, c cVar) {
        this.f63856b = new e();
        this.f63857c = g4.c.a();
        this.f63866l = new AtomicInteger();
        this.f63862h = aVar;
        this.f63863i = aVar2;
        this.f63864j = aVar3;
        this.f63865k = aVar4;
        this.f63861g = jVar;
        this.f63858d = aVar5;
        this.f63859e = eVar;
        this.f63860f = cVar;
    }
}
