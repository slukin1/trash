package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

public class g implements RequestCoordinator, c {

    /* renamed from: a  reason: collision with root package name */
    public final RequestCoordinator f64252a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f64253b;

    /* renamed from: c  reason: collision with root package name */
    public volatile c f64254c;

    /* renamed from: d  reason: collision with root package name */
    public volatile c f64255d;

    /* renamed from: e  reason: collision with root package name */
    public RequestCoordinator.RequestState f64256e;

    /* renamed from: f  reason: collision with root package name */
    public RequestCoordinator.RequestState f64257f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64258g;

    public g(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f64256e = requestState;
        this.f64257f = requestState;
        this.f64253b = obj;
        this.f64252a = requestCoordinator;
    }

    public boolean a() {
        boolean z11;
        synchronized (this.f64253b) {
            if (!this.f64255d.a()) {
                if (!this.f64254c.a()) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.bumptech.glide.request.c r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f64253b
            monitor-enter(r0)
            com.bumptech.glide.request.c r1 = r2.f64255d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f64257f = r3     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f64256e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f64252a     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x001c
            r3.b(r2)     // Catch:{ all -> 0x002b }
        L_0x001c:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f64257f     // Catch:{ all -> 0x002b }
            boolean r3 = r3.isComplete()     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0029
            com.bumptech.glide.request.c r3 = r2.f64255d     // Catch:{ all -> 0x002b }
            r3.clear()     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.g.b(com.bumptech.glide.request.c):void");
    }

    public boolean c(c cVar) {
        boolean z11;
        synchronized (this.f64253b) {
            z11 = k() && cVar.equals(this.f64254c) && !a();
        }
        return z11;
    }

    public void clear() {
        synchronized (this.f64253b) {
            this.f64258g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f64256e = requestState;
            this.f64257f = requestState;
            this.f64255d.clear();
            this.f64254c.clear();
        }
    }

    public boolean d(c cVar) {
        boolean z11;
        synchronized (this.f64253b) {
            z11 = l() && (cVar.equals(this.f64254c) || this.f64256e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z11;
    }

    public boolean e() {
        boolean z11;
        synchronized (this.f64253b) {
            z11 = this.f64256e == RequestCoordinator.RequestState.CLEARED;
        }
        return z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(com.bumptech.glide.request.c r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.g
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.request.g r4 = (com.bumptech.glide.request.g) r4
            com.bumptech.glide.request.c r0 = r3.f64254c
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.c r0 = r4.f64254c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.request.c r0 = r3.f64254c
            com.bumptech.glide.request.c r2 = r4.f64254c
            boolean r0 = r0.f(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.request.c r0 = r3.f64255d
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.request.c r4 = r4.f64255d
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.request.c r0 = r3.f64255d
            com.bumptech.glide.request.c r4 = r4.f64255d
            boolean r4 = r0.f(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.g.f(com.bumptech.glide.request.c):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(com.bumptech.glide.request.c r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f64253b
            monitor-enter(r0)
            com.bumptech.glide.request.c r1 = r2.f64254c     // Catch:{ all -> 0x001e }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f64257f = r3     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f64256e = r3     // Catch:{ all -> 0x001e }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f64252a     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            r3.g(r2)     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.g.g(com.bumptech.glide.request.c):void");
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f64253b) {
            RequestCoordinator requestCoordinator = this.f64252a;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    public void h() {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2;
        synchronized (this.f64253b) {
            this.f64258g = true;
            try {
                if (!(this.f64256e == RequestCoordinator.RequestState.SUCCESS || this.f64257f == (requestState2 = RequestCoordinator.RequestState.RUNNING))) {
                    this.f64257f = requestState2;
                    this.f64255d.h();
                }
                if (this.f64258g && this.f64256e != (requestState = RequestCoordinator.RequestState.RUNNING)) {
                    this.f64256e = requestState;
                    this.f64254c.h();
                }
            } finally {
                this.f64258g = false;
            }
        }
    }

    public boolean i(c cVar) {
        boolean z11;
        synchronized (this.f64253b) {
            z11 = j() && cVar.equals(this.f64254c) && this.f64256e != RequestCoordinator.RequestState.PAUSED;
        }
        return z11;
    }

    public boolean isComplete() {
        boolean z11;
        synchronized (this.f64253b) {
            z11 = this.f64256e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z11;
    }

    public boolean isRunning() {
        boolean z11;
        synchronized (this.f64253b) {
            z11 = this.f64256e == RequestCoordinator.RequestState.RUNNING;
        }
        return z11;
    }

    public final boolean j() {
        RequestCoordinator requestCoordinator = this.f64252a;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    public final boolean k() {
        RequestCoordinator requestCoordinator = this.f64252a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f64252a;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    public void m(c cVar, c cVar2) {
        this.f64254c = cVar;
        this.f64255d = cVar2;
    }

    public void pause() {
        synchronized (this.f64253b) {
            if (!this.f64257f.isComplete()) {
                this.f64257f = RequestCoordinator.RequestState.PAUSED;
                this.f64255d.pause();
            }
            if (!this.f64256e.isComplete()) {
                this.f64256e = RequestCoordinator.RequestState.PAUSED;
                this.f64254c.pause();
            }
        }
    }
}
