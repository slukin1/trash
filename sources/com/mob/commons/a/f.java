package com.mob.commons.a;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.ab;
import com.mob.commons.b;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.b.h;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class f extends c {

    public static class a {

        /* renamed from: d  reason: collision with root package name */
        private static volatile a f26947d;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public long f26948a;

        /* renamed from: b  reason: collision with root package name */
        private long f26949b;

        /* renamed from: c  reason: collision with root package name */
        private AtomicInteger f26950c = new AtomicInteger(0);

        private a() {
            com.mob.tools.utils.f.a().a((f.a) new f.a() {
                public void a() {
                    if (b.c()) {
                        if (System.currentTimeMillis() - a.this.f26948a >= ((long) (((Integer) b.a("gpdi", 120)).intValue() * 1000))) {
                            MobLog.getInstance().d("[cl] tme > ", new Object[0]);
                            a.this.b();
                            long unused = a.this.f26948a = System.currentTimeMillis();
                        }
                        a.this.c();
                    }
                }
            });
        }

        private void d() {
            Object c11 = com.mob.tools.utils.f.a().c();
            this.f26950c.getAndIncrement();
            this.f26949b = System.currentTimeMillis();
            Object b11 = com.mob.tools.utils.f.a().b();
            float f11 = 0.0f;
            if (!(c11 == null || b11 == null)) {
                try {
                    f11 = new h.a(c11).a(b11);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                    return;
                }
            }
            if (c11 == null) {
                return;
            }
            if (b11 == null || f11 > ((Float) b.a("gped", Float.valueOf(10.0f))).floatValue()) {
                MobLog.getInstance().d("[cl] cur != las", new Object[0]);
                com.mob.tools.utils.f.a().a(c11);
                f fVar = new f();
                fVar.a(true).a(c11).b(false);
                d.a().a(fVar, 0, 0);
            }
        }

        /* access modifiers changed from: private */
        public void b() {
            this.f26950c.getAndSet(0);
        }

        /* access modifiers changed from: private */
        public void c() {
            if (this.f26950c.get() < 3 && System.currentTimeMillis() - this.f26949b >= ((long) (((Integer) b.a("gpdi", 120)).intValue() * 1000))) {
                d();
            }
        }

        public static a a() {
            if (f26947d == null) {
                synchronized (a.class) {
                    if (f26947d == null) {
                        f26947d = new a();
                    }
                }
            }
            return f26947d;
        }
    }

    public f() {
        super(l.a("002Ofm%i"), 0, l.a("006;fm;i-gl+flj"), 60, c.a(l.a("002Ofm%i"), (Long) 0L));
    }

    private void m() {
        DH.requester(MobSDK.getContext()).getPosCommForce(0, 0, true, false).getMbcdi().getMcdi().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                List<HashMap<String, Object>> a11;
                JSONObject jSONObject;
                DH.DHResponse dHResponse2 = dHResponse;
                if (dHResponse2.getPosCommForce(new int[0]) != null && !dHResponse2.getPosCommForce(new int[0]).isEmpty() && (a11 = f.this.a(dHResponse2.getPosCommForce(new int[0]))) != null && !a11.isEmpty()) {
                    int i11 = 1;
                    HashMap hashMap = a11.get(a11.size() - 1);
                    if (hashMap != null && !hashMap.isEmpty()) {
                        f.this.a((HashMap<String, Object>) hashMap, (HashMap<String, Object>) hashMap);
                        HashMap hashMap2 = hashMap.get("nl") != null ? (HashMap) hashMap.get("nl") : null;
                        String mcdi = dHResponse.getMcdi();
                        String mbcdi = dHResponse.getMbcdi();
                        if (!TextUtils.isEmpty(mbcdi)) {
                            hashMap.put("cbsmt", mbcdi);
                        }
                        if (!TextUtils.isEmpty(mcdi)) {
                            hashMap.put("cssmt", mcdi);
                        }
                        if (hashMap2 == null || hashMap2.isEmpty()) {
                            jSONObject = new JSONObject(f.this.b(dHResponse2.getPosCommForce(new int[0]).get(a11.size() - 1)));
                        } else {
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("ltdmt", hashMap2.get("ltdmt"));
                            treeMap.put("lndmt", hashMap2.get("lndmt"));
                            jSONObject = new JSONObject(treeMap);
                        }
                        String MD5 = Data.MD5(jSONObject.toString());
                        ab a12 = ab.a();
                        String str = ab.f26993g;
                        String b11 = a12.b(str, (String) null);
                        ab a13 = ab.a();
                        String str2 = ab.f26994h;
                        long b12 = a13.b(str2, 0);
                        long longValue = ((Long) f.this.a(l.a("0066fmYiDgl6fli"), 3600L)).longValue() * 1000;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (TextUtils.isEmpty(b11) || !b11.equals(MD5) || currentTimeMillis - b12 >= longValue) {
                            if (!f.this.g()) {
                                i11 = currentTimeMillis - b12 >= longValue ? 2 : 3;
                            }
                            hashMap.put("pt", Integer.valueOf(i11));
                            if (hashMap2 != null && !hashMap2.isEmpty()) {
                                hashMap2.put("pt", Integer.valueOf(i11));
                            }
                            f.this.a("O_LCMT", (HashMap<String, Object>) hashMap);
                            ab.a().a(str, MD5);
                            ab.a().a(str2, currentTimeMillis);
                        }
                    }
                }
            }
        });
    }

    public void a() {
        HashMap hashMap;
        if (this.f26917b != null) {
            MobLog.getInstance().d("[cl] paramObj not null", new Object[0]);
            Object obj = this.f26917b;
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj);
            List<HashMap<String, Object>> a11 = a((List) arrayList);
            if (a11 != null && !a11.isEmpty() && (hashMap = a11.get(a11.size() - 1)) != null && !hashMap.isEmpty()) {
                hashMap.put("pt", 4);
                a("O_LCMT", (HashMap<String, Object>) hashMap);
                return;
            }
            return;
        }
        m();
    }

    public void c() {
        a.a();
    }
}
