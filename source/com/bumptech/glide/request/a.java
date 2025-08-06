package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

public final class a implements RequestCoordinator, c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f64235a;

    /* renamed from: b  reason: collision with root package name */
    public final RequestCoordinator f64236b;

    /* renamed from: c  reason: collision with root package name */
    public volatile c f64237c;

    /* renamed from: d  reason: collision with root package name */
    public volatile c f64238d;

    /* renamed from: e  reason: collision with root package name */
    public RequestCoordinator.RequestState f64239e;

    /* renamed from: f  reason: collision with root package name */
    public RequestCoordinator.RequestState f64240f;

    public a(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f64239e = requestState;
        this.f64240f = requestState;
        this.f64235a = obj;
        this.f64236b = requestCoordinator;
    }

    public boolean a() {
        boolean z11;
        synchronized (this.f64235a) {
            if (!this.f64237c.a()) {
                if (!this.f64238d.a()) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public void b(c cVar) {
        synchronized (this.f64235a) {
            if (cVar.equals(this.f64237c)) {
                this.f64239e = RequestCoordinator.RequestState.SUCCESS;
            } else if (cVar.equals(this.f64238d)) {
                this.f64240f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f64236b;
            if (requestCoordinator != null) {
                requestCoordinator.b(this);
            }
        }
    }

    public boolean c(c cVar) {
        boolean z11;
        synchronized (this.f64235a) {
            z11 = l() && j(cVar);
        }
        return z11;
    }

    public void clear() {
        synchronized (this.f64235a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f64239e = requestState;
            this.f64237c.clear();
            if (this.f64240f != requestState) {
                this.f64240f = requestState;
                this.f64238d.clear();
            }
        }
    }

    public boolean d(c cVar) {
        boolean z11;
        synchronized (this.f64235a) {
            z11 = m() && j(cVar);
        }
        return z11;
    }

    public boolean e() {
        boolean z11;
        synchronized (this.f64235a) {
            RequestCoordinator.RequestState requestState = this.f64239e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            z11 = requestState == requestState2 && this.f64240f == requestState2;
        }
        return z11;
    }

    public boolean f(c cVar) {
        if (!(cVar instanceof a)) {
            return false;
        }
        a aVar = (a) cVar;
        if (!this.f64237c.f(aVar.f64237c) || !this.f64238d.f(aVar.f64238d)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(com.bumptech.glide.request.c r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f64235a
            monitor-enter(r0)
            com.bumptech.glide.request.c r1 = r2.f64238d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.f64239e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f64240f     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002b }
            if (r3 == r1) goto L_0x001c
            r2.f64240f = r1     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.c r3 = r2.f64238d     // Catch:{ all -> 0x002b }
            r3.h()     // Catch:{ all -> 0x002b }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.f64240f = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f64236b     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0029
            r3.g(r2)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.g(com.bumptech.glide.request.c):void");
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f64235a) {
            RequestCoordinator requestCoordinator = this.f64236b;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    public void h() {
        synchronized (this.f64235a) {
            RequestCoordinator.RequestState requestState = this.f64239e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f64239e = requestState2;
                this.f64237c.h();
            }
        }
    }

    public boolean i(c cVar) {
        boolean z11;
        synchronized (this.f64235a) {
            z11 = k() && j(cVar);
        }
        return z11;
    }

    public boolean isComplete() {
        boolean z11;
        synchronized (this.f64235a) {
            RequestCoordinator.RequestState requestState = this.f64239e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2) {
                if (this.f64240f != requestState2) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public boolean isRunning() {
        boolean z11;
        synchronized (this.f64235a) {
            RequestCoordinator.RequestState requestState = this.f64239e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                if (this.f64240f != requestState2) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public final boolean j(c cVar) {
        return cVar.equals(this.f64237c) || (this.f64239e == RequestCoordinator.RequestState.FAILED && cVar.equals(this.f64238d));
    }

    public final boolean k() {
        RequestCoordinator requestCoordinator = this.f64236b;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f64236b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public final boolean m() {
        RequestCoordinator requestCoordinator = this.f64236b;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    public void n(c cVar, c cVar2) {
        this.f64237c = cVar;
        this.f64238d = cVar2;
    }

    public void pause() {
        synchronized (this.f64235a) {
            RequestCoordinator.RequestState requestState = this.f64239e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f64239e = RequestCoordinator.RequestState.PAUSED;
                this.f64237c.pause();
            }
            if (this.f64240f == requestState2) {
                this.f64240f = RequestCoordinator.RequestState.PAUSED;
                this.f64238d.pause();
            }
        }
    }
}
