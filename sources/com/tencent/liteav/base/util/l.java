package com.tencent.liteav.base.util;

import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l implements v {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f21550a;

    /* renamed from: b  reason: collision with root package name */
    public final CustomHandler f21551b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f21552c;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f21553a;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f21554b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f21555c = q.a(this);

        /* renamed from: d  reason: collision with root package name */
        public final long f21556d;

        public a(Runnable runnable, long j11) {
            this.f21553a = runnable;
            this.f21554b = p.a(this, runnable);
            this.f21556d = j11;
        }
    }

    public l() {
        this(60);
    }

    public final void a(Runnable runnable) {
        this.f21550a.execute(runnable);
    }

    public final void b(Runnable runnable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f21550a.execute(n.a(runnable, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void c(Runnable runnable) {
        if (runnable != null) {
            this.f21550a.remove(runnable);
            synchronized (this) {
                Iterator<a> it2 = this.f21552c.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next != null && runnable == next.f21553a) {
                        l.this.f21551b.removeCallbacks(next.f21555c);
                        l.this.f21550a.remove(next.f21554b);
                        it2.remove();
                    }
                }
            }
        }
    }

    public l(int i11) {
        this(i11, "SequenceTaskRunner_");
    }

    public final void a(Runnable runnable, long j11) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f21550a.execute(o.a(runnable, countDownLatch));
        try {
            countDownLatch.await(j11, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public l(int i11, String str) {
        this.f21550a = new ThreadPoolExecutor(0, 1, (long) i11, TimeUnit.SECONDS, new LinkedBlockingQueue(), m.a(str));
        this.f21551b = new CustomHandler(Looper.getMainLooper());
        this.f21552c = new ArrayList();
    }

    public final void b(Runnable runnable, long j11) {
        a aVar = new a(runnable, j11);
        synchronized (this) {
            this.f21552c.add(aVar);
        }
        l.this.f21551b.postDelayed(aVar.f21555c, aVar.f21556d);
    }
}
