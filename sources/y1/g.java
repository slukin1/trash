package y1;

import bolts.ExecutorException;
import bolts.TaskCompletionSource;
import bolts.UnobservedTaskException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class g<TResult> {

    /* renamed from: i  reason: collision with root package name */
    public static final ExecutorService f16829i = c.a();

    /* renamed from: j  reason: collision with root package name */
    public static final Executor f16830j = c.b();

    /* renamed from: k  reason: collision with root package name */
    public static final Executor f16831k = a.c();

    /* renamed from: l  reason: collision with root package name */
    public static volatile C0113g f16832l;

    /* renamed from: m  reason: collision with root package name */
    public static g<?> f16833m = new g<>((Object) null);

    /* renamed from: n  reason: collision with root package name */
    public static g<Boolean> f16834n = new g<>(Boolean.TRUE);

    /* renamed from: o  reason: collision with root package name */
    public static g<Boolean> f16835o = new g<>(Boolean.FALSE);

    /* renamed from: p  reason: collision with root package name */
    public static g<?> f16836p = new g<>(true);

    /* renamed from: a  reason: collision with root package name */
    public final Object f16837a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f16838b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16839c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f16840d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f16841e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16842f;

    /* renamed from: g  reason: collision with root package name */
    public h f16843g;

    /* renamed from: h  reason: collision with root package name */
    public List<f<TResult, Void>> f16844h = new ArrayList();

    public class a implements f<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f16845a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f16846b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f16847c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f16848d;

        public a(TaskCompletionSource taskCompletionSource, f fVar, Executor executor, d dVar) {
            this.f16845a = taskCompletionSource;
            this.f16846b = fVar;
            this.f16847c = executor;
        }

        /* renamed from: a */
        public Void then(g<TResult> gVar) {
            g.e(this.f16845a, this.f16846b, gVar, this.f16847c, this.f16848d);
            return null;
        }
    }

    public class b implements f<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f16850a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f16851b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f16852c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f16853d;

        public b(TaskCompletionSource taskCompletionSource, f fVar, Executor executor, d dVar) {
            this.f16850a = taskCompletionSource;
            this.f16851b = fVar;
            this.f16852c = executor;
        }

        /* renamed from: a */
        public Void then(g<TResult> gVar) {
            g.d(this.f16850a, this.f16851b, gVar, this.f16852c, this.f16853d);
            return null;
        }
    }

    public class c implements f<TResult, g<TContinuationResult>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f16855a;

        public c(d dVar, f fVar) {
            this.f16855a = fVar;
        }

        /* renamed from: a */
        public g<TContinuationResult> then(g<TResult> gVar) {
            if (gVar.r()) {
                return g.k(gVar.m());
            }
            if (gVar.p()) {
                return g.c();
            }
            return gVar.f(this.f16855a);
        }
    }

    public static class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f16857b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f16858c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f16859d;

        public d(d dVar, TaskCompletionSource taskCompletionSource, f fVar, g gVar) {
            this.f16857b = taskCompletionSource;
            this.f16858c = fVar;
            this.f16859d = gVar;
        }

        public void run() {
            try {
                this.f16857b.d(this.f16858c.then(this.f16859d));
            } catch (CancellationException unused) {
                this.f16857b.b();
            } catch (Exception e11) {
                this.f16857b.c(e11);
            }
        }
    }

    public static class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f16860b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f16861c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f16862d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f16863e;

        public class a implements f<TContinuationResult, Void> {
            public a() {
            }

            /* renamed from: a */
            public Void then(g<TContinuationResult> gVar) {
                d dVar = e.this.f16860b;
                if (gVar.p()) {
                    e.this.f16861c.b();
                    return null;
                } else if (gVar.r()) {
                    e.this.f16861c.c(gVar.m());
                    return null;
                } else {
                    e.this.f16861c.d(gVar.n());
                    return null;
                }
            }
        }

        public e(d dVar, TaskCompletionSource taskCompletionSource, f fVar, g gVar) {
            this.f16861c = taskCompletionSource;
            this.f16862d = fVar;
            this.f16863e = gVar;
        }

        public void run() {
            try {
                g gVar = (g) this.f16862d.then(this.f16863e);
                if (gVar == null) {
                    this.f16861c.d(null);
                } else {
                    gVar.f(new a());
                }
            } catch (CancellationException unused) {
                this.f16861c.b();
            } catch (Exception e11) {
                this.f16861c.c(e11);
            }
        }
    }

    public class f extends TaskCompletionSource<TResult> {
        public f() {
        }
    }

    /* renamed from: y1.g$g  reason: collision with other inner class name */
    public interface C0113g {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public g() {
    }

    public static <TResult> g<TResult> c() {
        return f16836p;
    }

    public static <TContinuationResult, TResult> void d(TaskCompletionSource<TContinuationResult> taskCompletionSource, f<TResult, g<TContinuationResult>> fVar, g<TResult> gVar, Executor executor, d dVar) {
        try {
            executor.execute(new e(dVar, taskCompletionSource, fVar, gVar));
        } catch (Exception e11) {
            taskCompletionSource.c(new ExecutorException(e11));
        }
    }

    public static <TContinuationResult, TResult> void e(TaskCompletionSource<TContinuationResult> taskCompletionSource, f<TResult, TContinuationResult> fVar, g<TResult> gVar, Executor executor, d dVar) {
        try {
            executor.execute(new d(dVar, taskCompletionSource, fVar, gVar));
        } catch (Exception e11) {
            taskCompletionSource.c(new ExecutorException(e11));
        }
    }

    public static <TResult> g<TResult>.f j() {
        return new f();
    }

    public static <TResult> g<TResult> k(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.c(exc);
        return taskCompletionSource.a();
    }

    public static <TResult> g<TResult> l(TResult tresult) {
        if (tresult == null) {
            return f16833m;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? f16834n : f16835o;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.d(tresult);
        return taskCompletionSource.a();
    }

    public static C0113g o() {
        return f16832l;
    }

    public <TContinuationResult> g<TContinuationResult> f(f<TResult, TContinuationResult> fVar) {
        return g(fVar, f16830j, (d) null);
    }

    public <TContinuationResult> g<TContinuationResult> g(f<TResult, TContinuationResult> fVar, Executor executor, d dVar) {
        boolean q11;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f16837a) {
            q11 = q();
            if (!q11) {
                this.f16844h.add(new a(taskCompletionSource, fVar, executor, dVar));
            }
        }
        if (q11) {
            e(taskCompletionSource, fVar, this, executor, dVar);
        }
        return taskCompletionSource.a();
    }

    public <TContinuationResult> g<TContinuationResult> h(f<TResult, g<TContinuationResult>> fVar, Executor executor) {
        return i(fVar, executor, (d) null);
    }

    public <TContinuationResult> g<TContinuationResult> i(f<TResult, g<TContinuationResult>> fVar, Executor executor, d dVar) {
        boolean q11;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f16837a) {
            q11 = q();
            if (!q11) {
                this.f16844h.add(new b(taskCompletionSource, fVar, executor, dVar));
            }
        }
        if (q11) {
            d(taskCompletionSource, fVar, this, executor, dVar);
        }
        return taskCompletionSource.a();
    }

    public Exception m() {
        Exception exc;
        synchronized (this.f16837a) {
            if (this.f16841e != null) {
                this.f16842f = true;
                h hVar = this.f16843g;
                if (hVar != null) {
                    hVar.a();
                    this.f16843g = null;
                }
            }
            exc = this.f16841e;
        }
        return exc;
    }

    public TResult n() {
        TResult tresult;
        synchronized (this.f16837a) {
            tresult = this.f16840d;
        }
        return tresult;
    }

    public boolean p() {
        boolean z11;
        synchronized (this.f16837a) {
            z11 = this.f16839c;
        }
        return z11;
    }

    public boolean q() {
        boolean z11;
        synchronized (this.f16837a) {
            z11 = this.f16838b;
        }
        return z11;
    }

    public boolean r() {
        boolean z11;
        synchronized (this.f16837a) {
            z11 = m() != null;
        }
        return z11;
    }

    public <TContinuationResult> g<TContinuationResult> s(f<TResult, TContinuationResult> fVar) {
        return t(fVar, f16830j, (d) null);
    }

    public <TContinuationResult> g<TContinuationResult> t(f<TResult, TContinuationResult> fVar, Executor executor, d dVar) {
        return h(new c(dVar, fVar), executor);
    }

    public final void u() {
        synchronized (this.f16837a) {
            for (f then : this.f16844h) {
                try {
                    then.then(this);
                } catch (RuntimeException e11) {
                    throw e11;
                } catch (Exception e12) {
                    throw new RuntimeException(e12);
                }
            }
            this.f16844h = null;
        }
    }

    public boolean v() {
        synchronized (this.f16837a) {
            if (this.f16838b) {
                return false;
            }
            this.f16838b = true;
            this.f16839c = true;
            this.f16837a.notifyAll();
            u();
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean w(java.lang.Exception r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f16837a
            monitor-enter(r0)
            boolean r1 = r3.f16838b     // Catch:{ all -> 0x002c }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r2
        L_0x000a:
            r1 = 1
            r3.f16838b = r1     // Catch:{ all -> 0x002c }
            r3.f16841e = r4     // Catch:{ all -> 0x002c }
            r3.f16842f = r2     // Catch:{ all -> 0x002c }
            java.lang.Object r4 = r3.f16837a     // Catch:{ all -> 0x002c }
            r4.notifyAll()     // Catch:{ all -> 0x002c }
            r3.u()     // Catch:{ all -> 0x002c }
            boolean r4 = r3.f16842f     // Catch:{ all -> 0x002c }
            if (r4 != 0) goto L_0x002a
            y1.g$g r4 = o()     // Catch:{ all -> 0x002c }
            if (r4 == 0) goto L_0x002a
            y1.h r4 = new y1.h     // Catch:{ all -> 0x002c }
            r4.<init>(r3)     // Catch:{ all -> 0x002c }
            r3.f16843g = r4     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r1
        L_0x002c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.g.w(java.lang.Exception):boolean");
    }

    public boolean x(TResult tresult) {
        synchronized (this.f16837a) {
            if (this.f16838b) {
                return false;
            }
            this.f16838b = true;
            this.f16840d = tresult;
            this.f16837a.notifyAll();
            u();
            return true;
        }
    }

    public g(TResult tresult) {
        x(tresult);
    }

    public g(boolean z11) {
        if (z11) {
            v();
        } else {
            x((Object) null);
        }
    }
}
