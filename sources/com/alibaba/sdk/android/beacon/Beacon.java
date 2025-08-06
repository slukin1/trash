package com.alibaba.sdk.android.beacon;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Beacon {

    /* renamed from: a  reason: collision with root package name */
    public final String f14447a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14448b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f14449c;

    /* renamed from: d  reason: collision with root package name */
    public final HandlerThread f14450d;

    /* renamed from: e  reason: collision with root package name */
    public final a f14451e;

    /* renamed from: f  reason: collision with root package name */
    public final List<f> f14452f;

    /* renamed from: g  reason: collision with root package name */
    public final List<e> f14453g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f14454h;

    /* renamed from: i  reason: collision with root package name */
    public final long f14455i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f14456j;

    /* renamed from: k  reason: collision with root package name */
    public int f14457k;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f14458a;

        /* renamed from: b  reason: collision with root package name */
        public String f14459b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f14460c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        public long f14461d = 300000;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14462e = false;

        public Beacon a() {
            return new Beacon(this);
        }

        public Builder b() {
            this.f14458a = "24657847";
            this.f14459b = "f30fc0937f2b1e9e50a1b7134f1ddb10";
            return this;
        }

        public Builder c(Map<String, String> map) {
            this.f14460c.putAll(map);
            return this;
        }

        public Builder d(boolean z11) {
            this.f14462e = z11;
            return this;
        }
    }

    public final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 0:
                        Beacon.this.s((Context) message.obj);
                        return;
                    case 1:
                        Beacon.this.u((Context) message.obj);
                        return;
                    case 2:
                        Beacon.this.v((Context) message.obj);
                        return;
                    case 3:
                        Beacon.this.m();
                        return;
                    case 4:
                        Beacon.this.e((f) message.obj);
                        return;
                    case 5:
                        Beacon.this.p((f) message.obj);
                        return;
                    case 6:
                        Beacon.this.d((e) message.obj);
                        return;
                    case 7:
                        Beacon.this.o((d) message.obj);
                        return;
                    default:
                        return;
                }
            } catch (Exception e11) {
                Log.i("beacon", e11.getMessage(), e11);
            }
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f14464a;

        /* renamed from: b  reason: collision with root package name */
        public final String f14465b;

        public c(String str, String str2) {
            this.f14464a = str;
            this.f14465b = str2;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f14466a;

        /* renamed from: b  reason: collision with root package name */
        public final String f14467b;

        public d(String str, String str2) {
            this.f14466a = str;
            this.f14467b = str2;
        }
    }

    public interface e {
        void a(d dVar);
    }

    public interface f {
        void a(List<c> list);
    }

    public Beacon(Builder builder) {
        this.f14452f = new ArrayList();
        this.f14453g = new ArrayList();
        this.f14457k = 255;
        this.f14447a = builder.f14458a;
        this.f14448b = builder.f14459b;
        this.f14449c = builder.f14460c;
        this.f14455i = builder.f14461d;
        this.f14456j = builder.f14462e;
        this.f14451e = new a(this);
        HandlerThread handlerThread = new HandlerThread("Beacon Daemon");
        this.f14450d = handlerThread;
        handlerThread.start();
        a();
    }

    public final void a() {
        this.f14454h = new b(this.f14450d.getLooper());
    }

    public final void b(Context context) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = context;
        this.f14454h.sendMessage(obtain);
    }

    public void c(d dVar) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = dVar;
        this.f14454h.sendMessage(obtain);
    }

    public final void d(e eVar) {
        this.f14453g.add(eVar);
    }

    public final void e(f fVar) {
        this.f14452f.add(fVar);
    }

    public void k(e eVar) {
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = eVar;
        this.f14454h.sendMessage(obtain);
    }

    public void l(f fVar) {
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = fVar;
        this.f14454h.sendMessage(obtain);
    }

    public final void m() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f14454h.getLooper().quitSafely();
        } else {
            this.f14454h.getLooper().quit();
        }
        a();
    }

    public final void n(Context context) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = context;
        this.f14454h.sendMessage(obtain);
    }

    public final void o(d dVar) {
        for (e a11 : this.f14453g) {
            a11.a(dVar);
        }
    }

    public final void p(f fVar) {
        this.f14452f.remove(fVar);
    }

    public final void s(Context context) {
        if (this.f14456j) {
            n(context);
            this.f14457k = 1;
            return;
        }
        this.f14457k = 1;
        b(context);
        y();
        this.f14457k = 255;
    }

    public final void u(Context context) {
        this.f14451e.d(context, this.f14447a, this.f14448b, this.f14449c);
        List<c> c11 = this.f14451e.c();
        for (f a11 : this.f14452f) {
            a11.a(c11);
        }
    }

    public final void v(Context context) {
        if (this.f14454h.hasMessages(2)) {
            this.f14454h.removeMessages(2);
        }
        b(context);
        this.f14454h.sendEmptyMessageDelayed(2, this.f14455i);
    }

    public final boolean w() {
        return this.f14457k == 1;
    }

    public void x(Context context) {
        if (!w()) {
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = context;
            this.f14454h.sendMessage(obtain);
        }
    }

    public void y() {
        if (w()) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.f14454h.sendMessage(obtain);
        }
    }
}
