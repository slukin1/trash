package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import c4.f;
import c4.g;
import com.bumptech.glide.Priority;
import com.bumptech.glide.b;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.r;
import d4.a;
import f4.e;
import f4.i;
import g4.c;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements c, f, f {
    public static final boolean D = Log.isLoggable("Request", 2);
    public int A;
    public boolean B;
    public RuntimeException C;

    /* renamed from: a  reason: collision with root package name */
    public final String f64209a;

    /* renamed from: b  reason: collision with root package name */
    public final c f64210b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f64211c;

    /* renamed from: d  reason: collision with root package name */
    public final e<R> f64212d;

    /* renamed from: e  reason: collision with root package name */
    public final RequestCoordinator f64213e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f64214f;

    /* renamed from: g  reason: collision with root package name */
    public final b f64215g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f64216h;

    /* renamed from: i  reason: collision with root package name */
    public final Class<R> f64217i;

    /* renamed from: j  reason: collision with root package name */
    public final BaseRequestOptions<?> f64218j;

    /* renamed from: k  reason: collision with root package name */
    public final int f64219k;

    /* renamed from: l  reason: collision with root package name */
    public final int f64220l;

    /* renamed from: m  reason: collision with root package name */
    public final Priority f64221m;

    /* renamed from: n  reason: collision with root package name */
    public final g<R> f64222n;

    /* renamed from: o  reason: collision with root package name */
    public final List<e<R>> f64223o;

    /* renamed from: p  reason: collision with root package name */
    public final a<? super R> f64224p;

    /* renamed from: q  reason: collision with root package name */
    public final Executor f64225q;

    /* renamed from: r  reason: collision with root package name */
    public r<R> f64226r;

    /* renamed from: s  reason: collision with root package name */
    public h.d f64227s;

    /* renamed from: t  reason: collision with root package name */
    public long f64228t;

    /* renamed from: u  reason: collision with root package name */
    public volatile h f64229u;

    /* renamed from: v  reason: collision with root package name */
    public Status f64230v;

    /* renamed from: w  reason: collision with root package name */
    public Drawable f64231w;

    /* renamed from: x  reason: collision with root package name */
    public Drawable f64232x;

    /* renamed from: y  reason: collision with root package name */
    public Drawable f64233y;

    /* renamed from: z  reason: collision with root package name */
    public int f64234z;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(Context context, b bVar, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i11, int i12, Priority priority, g<R> gVar, e<R> eVar, List<e<R>> list, RequestCoordinator requestCoordinator, h hVar, a<? super R> aVar, Executor executor) {
        this.f64209a = D ? String.valueOf(super.hashCode()) : null;
        this.f64210b = c.a();
        this.f64211c = obj;
        this.f64214f = context;
        this.f64215g = bVar;
        this.f64216h = obj2;
        this.f64217i = cls;
        this.f64218j = baseRequestOptions;
        this.f64219k = i11;
        this.f64220l = i12;
        this.f64221m = priority;
        this.f64222n = gVar;
        this.f64212d = eVar;
        this.f64223o = list;
        this.f64213e = requestCoordinator;
        this.f64229u = hVar;
        this.f64224p = aVar;
        this.f64225q = executor;
        this.f64230v = Status.PENDING;
        if (this.C == null && bVar.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    public static int t(int i11, float f11) {
        return i11 == Integer.MIN_VALUE ? i11 : Math.round(f11 * ((float) i11));
    }

    public static <R> SingleRequest<R> w(Context context, b bVar, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i11, int i12, Priority priority, g<R> gVar, e<R> eVar, List<e<R>> list, RequestCoordinator requestCoordinator, h hVar, a<? super R> aVar, Executor executor) {
        return new SingleRequest(context, bVar, obj, obj2, cls, baseRequestOptions, i11, i12, priority, gVar, eVar, list, requestCoordinator, hVar, aVar, executor);
    }

    public boolean a() {
        boolean z11;
        synchronized (this.f64211c) {
            z11 = this.f64230v == Status.COMPLETE;
        }
        return z11;
    }

    public void b(GlideException glideException) {
        x(glideException, 5);
    }

    public void c(r<?> rVar, DataSource dataSource) {
        this.f64210b.c();
        r<?> rVar2 = null;
        try {
            synchronized (this.f64211c) {
                try {
                    this.f64227s = null;
                    if (rVar == null) {
                        b(new GlideException("Expected to receive a Resource<R> with an object of " + this.f64217i + " inside, but instead got null."));
                        return;
                    }
                    Object obj = rVar.get();
                    if (obj != null) {
                        if (this.f64217i.isAssignableFrom(obj.getClass())) {
                            if (!l()) {
                                try {
                                    this.f64226r = null;
                                    this.f64230v = Status.COMPLETE;
                                    this.f64229u.l(rVar);
                                    return;
                                } catch (Throwable th2) {
                                    rVar2 = rVar;
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                y(rVar, obj, dataSource);
                                return;
                            }
                        }
                    }
                    this.f64226r = null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected to receive an object of ");
                    sb2.append(this.f64217i);
                    sb2.append(" but instead got ");
                    sb2.append(obj != null ? obj.getClass() : "");
                    sb2.append("{");
                    sb2.append(obj);
                    sb2.append("} inside Resource{");
                    sb2.append(rVar);
                    sb2.append("}.");
                    sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                    b(new GlideException(sb2.toString()));
                    this.f64229u.l(rVar);
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            if (rVar2 != null) {
                this.f64229u.l(rVar2);
            }
            throw th4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r5.f64229u.l(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f64211c
            monitor-enter(r0)
            r5.i()     // Catch:{ all -> 0x0039 }
            g4.c r1 = r5.f64210b     // Catch:{ all -> 0x0039 }
            r1.c()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.f64230v     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0039 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return
        L_0x0013:
            r5.m()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.load.engine.r<R> r1 = r5.f64226r     // Catch:{ all -> 0x0039 }
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.f64226r = r3     // Catch:{ all -> 0x0039 }
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            boolean r3 = r5.j()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x002e
            c4.g<R> r3 = r5.f64222n     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r4 = r5.p()     // Catch:{ all -> 0x0039 }
            r3.onLoadCleared(r4)     // Catch:{ all -> 0x0039 }
        L_0x002e:
            r5.f64230v = r2     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0038
            com.bumptech.glide.load.engine.h r0 = r5.f64229u
            r0.l(r1)
        L_0x0038:
            return
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public void d(int i11, int i12) {
        Object obj;
        this.f64210b.c();
        Object obj2 = this.f64211c;
        synchronized (obj2) {
            try {
                boolean z11 = D;
                if (z11) {
                    s("Got onSizeReady in " + e.a(this.f64228t));
                }
                if (this.f64230v == Status.WAITING_FOR_SIZE) {
                    Status status = Status.RUNNING;
                    this.f64230v = status;
                    float E = this.f64218j.E();
                    this.f64234z = t(i11, E);
                    this.A = t(i12, E);
                    if (z11) {
                        s("finished setup for calling load in " + e.a(this.f64228t));
                    }
                    Status status2 = status;
                    boolean z12 = z11;
                    Status status3 = status2;
                    obj = obj2;
                    try {
                        this.f64227s = this.f64229u.g(this.f64215g, this.f64216h, this.f64218j.D(), this.f64234z, this.A, this.f64218j.C(), this.f64217i, this.f64221m, this.f64218j.q(), this.f64218j.G(), this.f64218j.P(), this.f64218j.L(), this.f64218j.w(), this.f64218j.J(), this.f64218j.I(), this.f64218j.H(), this.f64218j.v(), this, this.f64225q);
                        if (this.f64230v != status3) {
                            this.f64227s = null;
                        }
                        if (z12) {
                            s("finished onSizeReady in " + e.a(this.f64228t));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
                throw th;
            }
        }
    }

    public boolean e() {
        boolean z11;
        synchronized (this.f64211c) {
            z11 = this.f64230v == Status.CLEARED;
        }
        return z11;
    }

    public boolean f(c cVar) {
        int i11;
        int i12;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i13;
        int i14;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        c cVar2 = cVar;
        if (!(cVar2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f64211c) {
            i11 = this.f64219k;
            i12 = this.f64220l;
            obj = this.f64216h;
            cls = this.f64217i;
            baseRequestOptions = this.f64218j;
            priority = this.f64221m;
            List<e<R>> list = this.f64223o;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) cVar2;
        synchronized (singleRequest.f64211c) {
            i13 = singleRequest.f64219k;
            i14 = singleRequest.f64220l;
            obj2 = singleRequest.f64216h;
            cls2 = singleRequest.f64217i;
            baseRequestOptions2 = singleRequest.f64218j;
            priority2 = singleRequest.f64221m;
            List<e<R>> list2 = singleRequest.f64223o;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i11 == i13 && i12 == i14 && i.c(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
    }

    public Object g() {
        this.f64210b.c();
        return this.f64211c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f64211c
            monitor-enter(r0)
            r5.i()     // Catch:{ all -> 0x00a7 }
            g4.c r1 = r5.f64210b     // Catch:{ all -> 0x00a7 }
            r1.c()     // Catch:{ all -> 0x00a7 }
            long r1 = f4.e.b()     // Catch:{ all -> 0x00a7 }
            r5.f64228t = r1     // Catch:{ all -> 0x00a7 }
            java.lang.Object r1 = r5.f64216h     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x003c
            int r1 = r5.f64219k     // Catch:{ all -> 0x00a7 }
            int r2 = r5.f64220l     // Catch:{ all -> 0x00a7 }
            boolean r1 = f4.i.t(r1, r2)     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0027
            int r1 = r5.f64219k     // Catch:{ all -> 0x00a7 }
            r5.f64234z = r1     // Catch:{ all -> 0x00a7 }
            int r1 = r5.f64220l     // Catch:{ all -> 0x00a7 }
            r5.A = r1     // Catch:{ all -> 0x00a7 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r5.o()     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00a7 }
            r5.x(r2, r1)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.f64230v     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00a7 }
            if (r1 == r2) goto L_0x009f
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00a7 }
            if (r1 != r3) goto L_0x004f
            com.bumptech.glide.load.engine.r<R> r1 = r5.f64226r     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00a7 }
            r5.c(r1, r2)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x004f:
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00a7 }
            r5.f64230v = r1     // Catch:{ all -> 0x00a7 }
            int r3 = r5.f64219k     // Catch:{ all -> 0x00a7 }
            int r4 = r5.f64220l     // Catch:{ all -> 0x00a7 }
            boolean r3 = f4.i.t(r3, r4)     // Catch:{ all -> 0x00a7 }
            if (r3 == 0) goto L_0x0065
            int r3 = r5.f64219k     // Catch:{ all -> 0x00a7 }
            int r4 = r5.f64220l     // Catch:{ all -> 0x00a7 }
            r5.d(r3, r4)     // Catch:{ all -> 0x00a7 }
            goto L_0x006a
        L_0x0065:
            c4.g<R> r3 = r5.f64222n     // Catch:{ all -> 0x00a7 }
            r3.getSize(r5)     // Catch:{ all -> 0x00a7 }
        L_0x006a:
            com.bumptech.glide.request.SingleRequest$Status r3 = r5.f64230v     // Catch:{ all -> 0x00a7 }
            if (r3 == r2) goto L_0x0070
            if (r3 != r1) goto L_0x007f
        L_0x0070:
            boolean r1 = r5.k()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x007f
            c4.g<R> r1 = r5.f64222n     // Catch:{ all -> 0x00a7 }
            android.graphics.drawable.Drawable r2 = r5.p()     // Catch:{ all -> 0x00a7 }
            r1.onLoadStarted(r2)     // Catch:{ all -> 0x00a7 }
        L_0x007f:
            boolean r1 = D     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x009d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r1.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            long r2 = r5.f64228t     // Catch:{ all -> 0x00a7 }
            double r2 = f4.e.a(r2)     // Catch:{ all -> 0x00a7 }
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a7 }
            r5.s(r1)     // Catch:{ all -> 0x00a7 }
        L_0x009d:
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x009f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00a7 }
            throw r1     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.h():void");
    }

    public final void i() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public boolean isComplete() {
        boolean z11;
        synchronized (this.f64211c) {
            z11 = this.f64230v == Status.COMPLETE;
        }
        return z11;
    }

    public boolean isRunning() {
        boolean z11;
        synchronized (this.f64211c) {
            Status status = this.f64230v;
            if (status != Status.RUNNING) {
                if (status != Status.WAITING_FOR_SIZE) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public final boolean j() {
        RequestCoordinator requestCoordinator = this.f64213e;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    public final boolean k() {
        RequestCoordinator requestCoordinator = this.f64213e;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f64213e;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    public final void m() {
        i();
        this.f64210b.c();
        this.f64222n.removeCallback(this);
        h.d dVar = this.f64227s;
        if (dVar != null) {
            dVar.a();
            this.f64227s = null;
        }
    }

    public final Drawable n() {
        if (this.f64231w == null) {
            Drawable s11 = this.f64218j.s();
            this.f64231w = s11;
            if (s11 == null && this.f64218j.r() > 0) {
                this.f64231w = r(this.f64218j.r());
            }
        }
        return this.f64231w;
    }

    public final Drawable o() {
        if (this.f64233y == null) {
            Drawable t11 = this.f64218j.t();
            this.f64233y = t11;
            if (t11 == null && this.f64218j.u() > 0) {
                this.f64233y = r(this.f64218j.u());
            }
        }
        return this.f64233y;
    }

    public final Drawable p() {
        if (this.f64232x == null) {
            Drawable z11 = this.f64218j.z();
            this.f64232x = z11;
            if (z11 == null && this.f64218j.A() > 0) {
                this.f64232x = r(this.f64218j.A());
            }
        }
        return this.f64232x;
    }

    public void pause() {
        synchronized (this.f64211c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public final boolean q() {
        RequestCoordinator requestCoordinator = this.f64213e;
        return requestCoordinator == null || !requestCoordinator.getRoot().a();
    }

    public final Drawable r(int i11) {
        return w3.a.a(this.f64215g, i11, this.f64218j.F() != null ? this.f64218j.F() : this.f64214f.getTheme());
    }

    public final void s(String str) {
        Log.v("Request", str + " this: " + this.f64209a);
    }

    public final void u() {
        RequestCoordinator requestCoordinator = this.f64213e;
        if (requestCoordinator != null) {
            requestCoordinator.g(this);
        }
    }

    public final void v() {
        RequestCoordinator requestCoordinator = this.f64213e;
        if (requestCoordinator != null) {
            requestCoordinator.b(this);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void x(GlideException glideException, int i11) {
        boolean z11;
        this.f64210b.c();
        synchronized (this.f64211c) {
            glideException.setOrigin(this.C);
            int g11 = this.f64215g.g();
            if (g11 <= i11) {
                Log.w("Glide", "Load failed for " + this.f64216h + " with size [" + this.f64234z + "x" + this.A + "]", glideException);
                if (g11 <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.f64227s = null;
            this.f64230v = Status.FAILED;
            boolean z12 = true;
            this.B = true;
            try {
                List<e<R>> list = this.f64223o;
                if (list != null) {
                    z11 = false;
                    for (e<R> onLoadFailed : list) {
                        z11 |= onLoadFailed.onLoadFailed(glideException, this.f64216h, this.f64222n, q());
                    }
                } else {
                    z11 = false;
                }
                e<R> eVar = this.f64212d;
                if (eVar == null || !eVar.onLoadFailed(glideException, this.f64216h, this.f64222n, q())) {
                    z12 = false;
                }
                if (!z11 && !z12) {
                    z();
                }
                this.B = false;
                u();
            } catch (Throwable th2) {
                this.B = false;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A[Catch:{ all -> 0x00b9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y(com.bumptech.glide.load.engine.r<R> r11, R r12, com.bumptech.glide.load.DataSource r13) {
        /*
            r10 = this;
            boolean r6 = r10.q()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r10.f64230v = r0
            r10.f64226r = r11
            com.bumptech.glide.b r11 = r10.f64215g
            int r11 = r11.g()
            r0 = 3
            if (r11 > r0) goto L_0x006b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Finished loading "
            r11.append(r0)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.f64216h
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.f64234z
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.A
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.f64228t
            double r0 = f4.e.a(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r11)
        L_0x006b:
            r11 = 1
            r10.B = r11
            r7 = 0
            java.util.List<com.bumptech.glide.request.e<R>> r0 = r10.f64223o     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x0091
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00b9 }
            r9 = r7
        L_0x0078:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x0092
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00b9 }
            com.bumptech.glide.request.e r0 = (com.bumptech.glide.request.e) r0     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r10.f64216h     // Catch:{ all -> 0x00b9 }
            c4.g<R> r3 = r10.f64222n     // Catch:{ all -> 0x00b9 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b9 }
            r9 = r9 | r0
            goto L_0x0078
        L_0x0091:
            r9 = r7
        L_0x0092:
            com.bumptech.glide.request.e<R> r0 = r10.f64212d     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r2 = r10.f64216h     // Catch:{ all -> 0x00b9 }
            c4.g<R> r3 = r10.f64222n     // Catch:{ all -> 0x00b9 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            r11 = r7
        L_0x00a5:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00b3
            d4.a<? super R> r11 = r10.f64224p     // Catch:{ all -> 0x00b9 }
            com.bumptech.glide.request.transition.a r11 = r11.a(r13, r6)     // Catch:{ all -> 0x00b9 }
            c4.g<R> r13 = r10.f64222n     // Catch:{ all -> 0x00b9 }
            r13.onResourceReady(r12, r11)     // Catch:{ all -> 0x00b9 }
        L_0x00b3:
            r10.B = r7
            r10.v()
            return
        L_0x00b9:
            r11 = move-exception
            r10.B = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.y(com.bumptech.glide.load.engine.r, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    public final void z() {
        if (k()) {
            Drawable drawable = null;
            if (this.f64216h == null) {
                drawable = o();
            }
            if (drawable == null) {
                drawable = n();
            }
            if (drawable == null) {
                drawable = p();
            }
            this.f64222n.onLoadFailed(drawable);
        }
    }
}
