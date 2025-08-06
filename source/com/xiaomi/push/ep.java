package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ay;
import com.xiaomi.push.dq;
import com.xiaomi.push.ih;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ep {

    /* renamed from: a  reason: collision with root package name */
    private int f51743a;

    /* renamed from: a  reason: collision with other field name */
    private long f2800a;

    /* renamed from: a  reason: collision with other field name */
    private ay f2801a = ay.a();

    /* renamed from: a  reason: collision with other field name */
    private eo f2802a;

    /* renamed from: a  reason: collision with other field name */
    private String f2803a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2804a = false;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final ep f51745a = new ep();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ep m2643a() {
        return a.f51745a;
    }

    public boolean b() {
        a();
        return this.f2804a && this.f2801a.a() > 0;
    }

    public static eo a() {
        eo eoVar;
        ep epVar = a.f51745a;
        synchronized (epVar) {
            eoVar = epVar.f2802a;
        }
        return eoVar;
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f2802a = new eo(xMPushService);
        this.f2803a = "";
        ax.a().a((ax.a) new ax.a() {
            public void a(dq.b bVar) {
                if (bVar.e()) {
                    ep.a().a(bVar.e());
                }
            }
        });
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2648a() {
        return this.f2804a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2647a(int i11) {
        if (i11 > 0) {
            int i12 = i11 * 1000;
            if (i12 > 604800000) {
                i12 = 604800000;
            }
            if (this.f51743a != i12 || !this.f2804a) {
                this.f2804a = true;
                this.f2800a = System.currentTimeMillis();
                this.f51743a = i12;
                b.c("enable dot duration = " + i12 + " start = " + this.f2800a);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m2644a() {
        if (this.f2804a && System.currentTimeMillis() - this.f2800a > ((long) this.f51743a)) {
            this.f2804a = false;
            this.f2800a = 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized el m2646a() {
        el elVar;
        elVar = null;
        if (b()) {
            int i11 = 750;
            if (!av.d(this.f2802a.f2797a)) {
                i11 = 375;
            }
            elVar = a(i11);
        }
        return elVar;
    }

    private el a(int i11) {
        ArrayList arrayList = new ArrayList();
        el elVar = new el(this.f2803a, arrayList);
        if (!av.d(this.f2802a.f2797a)) {
            elVar.a(i.f(this.f2802a.f2797a));
        }
        ij ijVar = new ij(i11);
        ib a11 = new ih.a().a(ijVar);
        try {
            elVar.b(a11);
        } catch (hv unused) {
        }
        LinkedList a12 = this.f2801a.a();
        while (true) {
            try {
                if (a12.size() <= 0) {
                    break;
                }
                ek a13 = a((ay.a) a12.getLast());
                if (a13 != null) {
                    a13.b(a11);
                }
                if (ijVar.a() > i11) {
                    break;
                }
                if (a13 != null) {
                    arrayList.add(a13);
                }
                a12.removeLast();
            } catch (hv | NoSuchElementException unused2) {
            }
        }
        return elVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ek m2645a() {
        ek ekVar;
        ekVar = new ek();
        ekVar.a(av.a((Context) this.f2802a.f2797a));
        ekVar.f2774a = 0;
        ekVar.f2778b = 1;
        ekVar.d((int) (System.currentTimeMillis() / 1000));
        return ekVar;
    }

    private ek a(ay.a aVar) {
        if (aVar.f2546a == 0) {
            Object obj = aVar.f2547a;
            if (obj instanceof ek) {
                return (ek) obj;
            }
            return null;
        }
        ek a11 = a();
        a11.a(ej.CHANNEL_STATS_COUNTER.a());
        a11.c(aVar.f2546a);
        a11.c(aVar.f2548a);
        return a11;
    }

    public synchronized void a(ek ekVar) {
        this.f2801a.a(ekVar);
    }
}
