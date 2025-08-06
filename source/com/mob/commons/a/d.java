package com.mob.commons.a;

import com.mob.commons.b;
import com.mob.commons.s;
import com.mob.commons.y;
import com.mob.commons.z;
import com.mob.tools.utils.ResHelper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f26939a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f26940b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f26941c = new CopyOnWriteArrayList<>();

    private d() {
    }

    public static d a() {
        if (f26939a == null) {
            synchronized (y.class) {
                if (f26939a == null) {
                    f26939a = new d();
                }
            }
        }
        return f26939a;
    }

    private long c() {
        return (long) (((Integer) ResHelper.forceCast(b.a(s.a("0034djWji"), 300), 300)).intValue() * 1000);
    }

    public void b() {
        if (this.f26940b.compareAndSet(false, true)) {
            a(new a(), 0);
            a(new b(), 0);
            a(new e(), 0);
            a(new f(), 0);
            a(new k(), 0);
            g gVar = new g();
            gVar.a(true);
            a(gVar, 0);
            a(new h(), 0);
            a(new j(), 0);
            a(new i(), 0);
            a(new m(), 0);
            a(new n(), 0);
            a(new o(), 0);
            z.f27384c.execute(this);
        }
    }

    public void run() {
        if (this.f26941c.size() <= 0) {
            l.a().d(c(), this);
        } else if (!b.d() || !com.mob.commons.d.j()) {
            l.a().d(60000, this);
        } else {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<c> it2 = this.f26941c.iterator();
                while (it2.hasNext()) {
                    c next = it2.next();
                    if (currentTimeMillis >= next.j()) {
                        next.h();
                    }
                }
            } catch (Throwable unused) {
            }
            l.a().d(c(), this);
        }
    }

    public <T extends c> void a(T t11, int i11) {
        if (i11 == 1) {
            Iterator<c> it2 = this.f26941c.iterator();
            while (it2.hasNext()) {
                c next = it2.next();
                if (t11.k() == next.k()) {
                    this.f26941c.set(this.f26941c.indexOf(next), t11);
                } else {
                    this.f26941c.add(t11);
                }
            }
        } else if (i11 != 3) {
            this.f26941c.add(t11);
        } else {
            this.f26941c.add(0, t11);
        }
    }

    public void a(c cVar, long j11, int i11) {
        if (j11 == 0 && (i11 == 0 || i11 == 3)) {
            cVar.h();
        } else {
            l.a().a(j11, cVar, i11);
        }
    }
}
