package com.mob.commons.a;

import com.huobi.framework.im.common.GenerateUserSig;
import com.mob.commons.ab;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import java.util.HashMap;
import java.util.Map;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile long f26904c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile HashMap<Long, Long> f26905d;

    public a() {
        super(l.a("002fk"), 0, l.a("005fkEgl:fl"), 900, 0);
        if (f26905d == null) {
            f26904c = System.currentTimeMillis();
            f26905d = ab.a().f();
        }
    }

    private void m() {
        try {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : f26905d.entrySet()) {
                if (next != null) {
                    hashMap.put(l.a("008if!fiGgej2hf1k"), next.getKey());
                    hashMap.put(l.a("008!fefiflZfk]fkfmLg"), next.getValue());
                }
            }
            a("ARSTAMT", (HashMap<String, Object>) hashMap);
            ab.a().a(ab.f26992f, System.currentTimeMillis());
            if (f26905d != null) {
                f26905d.clear();
            }
            ab.a().a((HashMap<Long, Long>) null);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    public void a() {
        if (f26905d == null) {
            f26905d = new HashMap<>();
        }
        for (Map.Entry next : f26905d.entrySet()) {
            if (!(next == null || ((Long) next.getKey()).longValue() == f26904c)) {
                m();
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - f26904c;
        f26905d.put(Long.valueOf(f26904c), Long.valueOf(currentTimeMillis));
        ab.a().a(f26905d);
        long b11 = ab.a().b(ab.f26992f, 0);
        long l11 = l() * 1000;
        if (currentTimeMillis >= l11 && System.currentTimeMillis() - b11 > l11) {
            m();
        }
    }

    public void b() {
        long longValue = ((Long) a(d(), 0L)).longValue();
        if (longValue > 0 && longValue < GenerateUserSig.EXPIRETIME) {
            a(longValue);
        }
    }
}
