package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ag {

    /* renamed from: a  reason: collision with root package name */
    private int f51360a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f2503a;

    /* renamed from: a  reason: collision with other field name */
    private a f2504a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile b f2505a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f2506a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f51361b;

    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public ag() {
        this(false);
    }

    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f2508a = new LinkedBlockingQueue<>();

        public a() {
            super("PackageProcessor");
        }

        public void a(b bVar) {
            try {
                this.f2508a.add(bVar);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void run() {
            long a11 = ag.a(ag.this) > 0 ? (long) ag.a(ag.this) : Long.MAX_VALUE;
            while (!ag.a(ag.this)) {
                try {
                    b poll = this.f2508a.poll(a11, TimeUnit.SECONDS);
                    b unused = ag.this.f2505a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (ag.a(ag.this) > 0) {
                        ag.a(ag.this);
                    }
                } catch (InterruptedException e11) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
                }
            }
        }

        private void a(int i11, b bVar) {
            try {
                ag.a(ag.this).sendMessage(ag.a(ag.this).obtainMessage(i11, bVar));
            } catch (Exception e11) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
            }
        }
    }

    public ag(boolean z11) {
        this(z11, 0);
    }

    public ag(boolean z11, int i11) {
        this.f2503a = null;
        this.f2506a = false;
        this.f51360a = 0;
        this.f2503a = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                int i11 = message.what;
                if (i11 == 0) {
                    bVar.a();
                } else if (i11 == 1) {
                    bVar.c();
                }
                super.handleMessage(message);
            }
        };
        this.f51361b = z11;
        this.f51360a = i11;
    }

    public synchronized void a(b bVar) {
        if (this.f2504a == null) {
            a aVar = new a();
            this.f2504a = aVar;
            aVar.setDaemon(this.f51361b);
            this.f2506a = false;
            this.f2504a.start();
        }
        this.f2504a.a(bVar);
    }

    private synchronized void a() {
        this.f2504a = null;
        this.f2506a = true;
    }

    public void a(final b bVar, long j11) {
        this.f2503a.postDelayed(new Runnable() {
            public void run() {
                ag.this.a(bVar);
            }
        }, j11);
    }
}
