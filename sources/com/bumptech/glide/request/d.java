package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import c4.f;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import f4.i;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class d<R> implements b<R>, e<R> {

    /* renamed from: l  reason: collision with root package name */
    public static final a f64241l = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f64242b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64243c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f64244d;

    /* renamed from: e  reason: collision with root package name */
    public final a f64245e;

    /* renamed from: f  reason: collision with root package name */
    public R f64246f;

    /* renamed from: g  reason: collision with root package name */
    public c f64247g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64248h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64249i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f64250j;

    /* renamed from: k  reason: collision with root package name */
    public GlideException f64251k;

    public static class a {
        public void a(Object obj) {
            obj.notifyAll();
        }

        public void b(Object obj, long j11) throws InterruptedException {
            obj.wait(j11);
        }
    }

    public d(int i11, int i12) {
        this(i11, i12, true, f64241l);
    }

    public final synchronized R a(Long l11) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f64244d && !isDone()) {
            i.a();
        }
        if (this.f64248h) {
            throw new CancellationException();
        } else if (this.f64250j) {
            throw new ExecutionException(this.f64251k);
        } else if (this.f64249i) {
            return this.f64246f;
        } else {
            if (l11 == null) {
                this.f64245e.b(this, 0);
            } else if (l11.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l11.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.f64245e.b(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.f64250j) {
                throw new ExecutionException(this.f64251k);
            } else if (this.f64248h) {
                throw new CancellationException();
            } else if (this.f64249i) {
                return this.f64246f;
            } else {
                throw new TimeoutException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r1 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x000a
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            return r3
        L_0x000a:
            r0 = 1
            r2.f64248h = r0     // Catch:{ all -> 0x0021 }
            com.bumptech.glide.request.d$a r1 = r2.f64245e     // Catch:{ all -> 0x0021 }
            r1.a(r2)     // Catch:{ all -> 0x0021 }
            r1 = 0
            if (r3 == 0) goto L_0x001a
            com.bumptech.glide.request.c r3 = r2.f64247g     // Catch:{ all -> 0x0021 }
            r2.f64247g = r1     // Catch:{ all -> 0x0021 }
            r1 = r3
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0020
            r1.clear()
        L_0x0020:
            return r0
        L_0x0021:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.d.cancel(boolean):boolean");
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e11) {
            throw new AssertionError(e11);
        }
    }

    public synchronized c getRequest() {
        return this.f64247g;
    }

    public void getSize(f fVar) {
        fVar.d(this.f64242b, this.f64243c);
    }

    public synchronized boolean isCancelled() {
        return this.f64248h;
    }

    public synchronized boolean isDone() {
        return this.f64248h || this.f64249i || this.f64250j;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public synchronized void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public synchronized void onResourceReady(R r11, com.bumptech.glide.request.transition.a<? super R> aVar) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void removeCallback(f fVar) {
    }

    public synchronized void setRequest(c cVar) {
        this.f64247g = cVar;
    }

    public d(int i11, int i12, boolean z11, a aVar) {
        this.f64242b = i11;
        this.f64243c = i12;
        this.f64244d = z11;
        this.f64245e = aVar;
    }

    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, g<R> gVar, boolean z11) {
        this.f64250j = true;
        this.f64251k = glideException;
        this.f64245e.a(this);
        return false;
    }

    public synchronized boolean onResourceReady(R r11, Object obj, g<R> gVar, DataSource dataSource, boolean z11) {
        this.f64249i = true;
        this.f64246f = r11;
        this.f64245e.a(this);
        return false;
    }

    public R get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j11)));
    }
}
