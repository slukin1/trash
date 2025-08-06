package com.mob.commons.a;

import com.mob.commons.c;
import com.mob.commons.k;
import com.mob.commons.l;
import com.mob.commons.m;
import java.util.HashMap;

public class j extends c {

    /* renamed from: c  reason: collision with root package name */
    private static k f26958c;

    public j() {
        super(TtmlNode.TAG_P, 0, (String) null, 0, 0);
        a(0);
    }

    private static synchronized boolean m() {
        synchronized (j.class) {
            if (f26958c != null) {
                return false;
            }
            f26958c = new k() {
                public void a(boolean z11, boolean z12, long j11) {
                    if (z11) {
                        j jVar = new j();
                        jVar.b(false).a((Object) Long.valueOf(System.currentTimeMillis())).a(true);
                        d.a().a(jVar, 0, 0);
                    }
                }
            };
            l.a().a(f26958c);
            return true;
        }
    }

    public void a() {
        if (!g()) {
            HashMap hashMap = new HashMap();
            hashMap.put(m.a("004gHca$hd"), "PVMT");
            hashMap.put(m.a("008Vba_bgdg,bgbd8d"), this.f26917b);
            if (!com.mob.commons.j.a().f27252a.get()) {
                hashMap.putAll(com.mob.commons.j.a().c());
                com.mob.commons.j.a().f27252a.compareAndSet(false, true);
            }
            c.a().a(System.currentTimeMillis(), (HashMap<String, Object>) hashMap);
        }
    }

    public void c() {
        m();
    }
}
