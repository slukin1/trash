package com.mob.commons.a;

import com.mob.commons.ab;
import com.mob.commons.k;
import com.mob.commons.l;
import com.mob.commons.s;
import com.mob.tools.MobLog;
import java.util.HashMap;
import java.util.Map;

public class g extends c {

    /* renamed from: c  reason: collision with root package name */
    private static k f26952c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f26953d = s.a("014MehXf ecdhHdci0diddWfYdhVg[dkej");

    public g() {
        super(s.a("002Yffdi"), 0, s.a("005<ffdiej1dj"), 30, 0);
    }

    private void b(long j11) {
        if (!l.a().b()) {
            g gVar = new g();
            gVar.a(true).b(false).a((Object) new Long[]{3L, Long.valueOf(j11)});
            d.a().a(gVar, l(), 0);
        }
    }

    private void m() {
        try {
            HashMap hashMap = (HashMap) ab.a().c(f26953d, (Object) null);
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    long longValue = ((Long) entry.getKey()).longValue();
                    long longValue2 = ((Long) entry.getValue()).longValue();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(s.a("005Qdg%eiYdiBg"), Long.valueOf(longValue2));
                    hashMap2.put(s.a("008<djdg eiEdidf=f0fi"), Long.valueOf(longValue2 - longValue));
                    a("BKIOMT", (HashMap<String, Object>) hashMap2);
                }
                ab.a().b(f26953d);
            }
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    private static synchronized boolean n() {
        synchronized (g.class) {
            if (f26952c != null) {
                return false;
            }
            f26952c = new k() {

                /* renamed from: a  reason: collision with root package name */
                private volatile long f26954a = 0;

                public void a(boolean z11, boolean z12, long j11) {
                    if (z12) {
                        this.f26954a = System.currentTimeMillis();
                        g gVar = new g();
                        gVar.a((Object) new Long[]{0L, Long.valueOf(this.f26954a), Long.valueOf(System.currentTimeMillis())}).b(false).a(true);
                        d.a().a(gVar, 0, 1);
                    }
                    if (z11) {
                        if (!z12) {
                            this.f26954a = System.currentTimeMillis();
                            g gVar2 = new g();
                            gVar2.a((Object) new Long[]{1L, Long.valueOf(this.f26954a), Long.valueOf(System.currentTimeMillis())}).b(false).a(true);
                            d.a().a(gVar2, 0, 0);
                        }
                    } else if (j11 > 0) {
                        g gVar3 = new g();
                        gVar3.a((Object) new Long[]{2L, Long.valueOf(this.f26954a), Long.valueOf(System.currentTimeMillis())}).b(false).a(true);
                        d.a().a(gVar3, 0, 1);
                    }
                }
            };
            l.a().a(f26952c);
            return true;
        }
    }

    public void a() {
        long j11;
        if (!g()) {
            Long[] lArr = (Long[]) this.f26917b;
            long longValue = lArr[0].longValue();
            long longValue2 = lArr[1].longValue();
            int i11 = (longValue > 3 ? 1 : (longValue == 3 ? 0 : -1));
            if (i11 != 0 || lArr.length >= 3) {
                j11 = lArr[2].longValue();
            } else {
                j11 = System.currentTimeMillis();
            }
            if (longValue == 0) {
                m();
                a(longValue2, j11);
                b(longValue2);
            } else if (longValue == 1 || i11 == 0) {
                a(longValue2, j11);
                b(longValue2);
            } else if (longValue == 2) {
                a(longValue2, j11);
                m();
            }
        }
    }

    public void c() {
        n();
    }

    private void a(long j11, long j12) {
        try {
            ab a11 = ab.a();
            String str = f26953d;
            HashMap hashMap = (HashMap) a11.c(str, (Object) null);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            hashMap.put(Long.valueOf(j11), Long.valueOf(j12));
            ab.a().b(str, (Object) hashMap);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }
}
