package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f30133a;

    /* renamed from: b  reason: collision with root package name */
    public final d f30134b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f30135c;

    /* renamed from: d  reason: collision with root package name */
    public long f30136d;

    /* renamed from: e  reason: collision with root package name */
    public long f30137e;

    /* renamed from: f  reason: collision with root package name */
    public long f30138f;

    /* renamed from: g  reason: collision with root package name */
    public long f30139g;

    /* renamed from: h  reason: collision with root package name */
    public long f30140h;

    /* renamed from: i  reason: collision with root package name */
    public long f30141i;

    /* renamed from: j  reason: collision with root package name */
    public long f30142j;

    /* renamed from: k  reason: collision with root package name */
    public long f30143k;

    /* renamed from: l  reason: collision with root package name */
    public int f30144l;

    /* renamed from: m  reason: collision with root package name */
    public int f30145m;

    /* renamed from: n  reason: collision with root package name */
    public int f30146n;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final t f30147a;

        /* renamed from: com.squareup.picasso.t$a$a  reason: collision with other inner class name */
        public class C0267a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Message f30148b;

            public C0267a(Message message) {
                this.f30148b = message;
            }

            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f30148b.what);
            }
        }

        public a(Looper looper, t tVar) {
            super(looper);
            this.f30147a = tVar;
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                this.f30147a.j();
            } else if (i11 == 1) {
                this.f30147a.k();
            } else if (i11 == 2) {
                this.f30147a.h((long) message.arg1);
            } else if (i11 == 3) {
                this.f30147a.i((long) message.arg1);
            } else if (i11 != 4) {
                Picasso.f29949p.post(new C0267a(message));
            } else {
                this.f30147a.l((Long) message.obj);
            }
        }
    }

    public t(d dVar) {
        this.f30134b = dVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f30133a = handlerThread;
        handlerThread.start();
        y.h(handlerThread.getLooper());
        this.f30135c = new a(handlerThread.getLooper(), this);
    }

    public static long g(int i11, long j11) {
        return j11 / ((long) i11);
    }

    public u a() {
        return new u(this.f30134b.a(), this.f30134b.size(), this.f30136d, this.f30137e, this.f30138f, this.f30139g, this.f30140h, this.f30141i, this.f30142j, this.f30143k, this.f30144l, this.f30145m, this.f30146n, System.currentTimeMillis());
    }

    public void b(Bitmap bitmap) {
        m(bitmap, 2);
    }

    public void c(Bitmap bitmap) {
        m(bitmap, 3);
    }

    public void d() {
        this.f30135c.sendEmptyMessage(0);
    }

    public void e() {
        this.f30135c.sendEmptyMessage(1);
    }

    public void f(long j11) {
        Handler handler = this.f30135c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j11)));
    }

    public void h(long j11) {
        int i11 = this.f30145m + 1;
        this.f30145m = i11;
        long j12 = this.f30139g + j11;
        this.f30139g = j12;
        this.f30142j = g(i11, j12);
    }

    public void i(long j11) {
        this.f30146n++;
        long j12 = this.f30140h + j11;
        this.f30140h = j12;
        this.f30143k = g(this.f30145m, j12);
    }

    public void j() {
        this.f30136d++;
    }

    public void k() {
        this.f30137e++;
    }

    public void l(Long l11) {
        this.f30144l++;
        long longValue = this.f30138f + l11.longValue();
        this.f30138f = longValue;
        this.f30141i = g(this.f30144l, longValue);
    }

    public final void m(Bitmap bitmap, int i11) {
        int i12 = y.i(bitmap);
        Handler handler = this.f30135c;
        handler.sendMessage(handler.obtainMessage(i11, i12, 0));
    }
}
