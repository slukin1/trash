package com.dianping.logan;

import android.os.Looper;
import android.text.TextUtils;
import com.dianping.logan.LoganModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a {

    /* renamed from: l  reason: collision with root package name */
    public static a f64846l;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<LoganModel> f64847a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public String f64848b;

    /* renamed from: c  reason: collision with root package name */
    public String f64849c;

    /* renamed from: d  reason: collision with root package name */
    public long f64850d;

    /* renamed from: e  reason: collision with root package name */
    public long f64851e;

    /* renamed from: f  reason: collision with root package name */
    public long f64852f;

    /* renamed from: g  reason: collision with root package name */
    public long f64853g;

    /* renamed from: h  reason: collision with root package name */
    public String f64854h;

    /* renamed from: i  reason: collision with root package name */
    public String f64855i;

    /* renamed from: j  reason: collision with root package name */
    public d f64856j;

    /* renamed from: k  reason: collision with root package name */
    public SimpleDateFormat f64857k = new SimpleDateFormat("yyyy-MM-dd");

    public a(LoganConfig loganConfig) {
        if (loganConfig.h()) {
            this.f64849c = loganConfig.f64826b;
            this.f64848b = loganConfig.f64825a;
            this.f64850d = loganConfig.f64828d;
            this.f64852f = loganConfig.f64830f;
            this.f64851e = loganConfig.f64827c;
            this.f64853g = loganConfig.f64829e;
            this.f64854h = new String(loganConfig.f64831g);
            this.f64855i = new String(loganConfig.f64832h);
            b();
            return;
        }
        throw new NullPointerException("config's param is invalid");
    }

    public static a c(LoganConfig loganConfig) {
        if (f64846l == null) {
            synchronized (a.class) {
                if (f64846l == null) {
                    f64846l = new a(loganConfig);
                }
            }
        }
        return f64846l;
    }

    public final long a(String str) {
        try {
            return this.f64857k.parse(str).getTime();
        } catch (ParseException e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public final void b() {
        if (this.f64856j == null) {
            d dVar = new d(this.f64847a, this.f64848b, this.f64849c, this.f64850d, this.f64851e, this.f64852f, this.f64854h, this.f64855i);
            this.f64856j = dVar;
            dVar.setName("logan-thread");
            this.f64856j.start();
        }
    }

    public void d(String[] strArr, SendLogRunnable sendLogRunnable) {
        if (!TextUtils.isEmpty(this.f64849c) && strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    long a11 = a(str);
                    if (a11 > 0) {
                        LoganModel loganModel = new LoganModel();
                        f fVar = new f();
                        loganModel.f64840a = LoganModel.Action.SEND;
                        fVar.f64886b = String.valueOf(a11);
                        fVar.f64888d = sendLogRunnable;
                        loganModel.f64842c = fVar;
                        this.f64847a.add(loganModel);
                        d dVar = this.f64856j;
                        if (dVar != null) {
                            dVar.n();
                        }
                    }
                }
            }
        }
    }

    public void e(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            LoganModel loganModel = new LoganModel();
            loganModel.f64840a = LoganModel.Action.WRITE;
            g gVar = new g();
            String name = Thread.currentThread().getName();
            long id2 = Thread.currentThread().getId();
            boolean z11 = false;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z11 = true;
            }
            gVar.f64889a = str;
            gVar.f64893e = System.currentTimeMillis();
            gVar.f64894f = i11;
            gVar.f64890b = z11;
            gVar.f64891c = id2;
            gVar.f64892d = name;
            loganModel.f64841b = gVar;
            if (((long) this.f64847a.size()) < this.f64853g) {
                this.f64847a.add(loganModel);
                d dVar = this.f64856j;
                if (dVar != null) {
                    dVar.n();
                }
            }
        }
    }
}
