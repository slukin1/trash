package com.mob.commons.a;

import android.text.TextUtils;
import com.mob.commons.ab;
import com.mob.commons.b;
import com.mob.commons.l;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.e;
import com.mob.tools.utils.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class o extends c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile long f26976c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile AtomicInteger f26977d = new AtomicInteger(0);

    public o() {
        super(l.a("002?hi(i"), 0, l.a("004.hiNiThkfl"), 300, c.a(l.a("002?hi(i"), (Long) 0L));
    }

    /* access modifiers changed from: private */
    public void m() {
        this.f26976c = System.currentTimeMillis();
        v.a((e<ArrayList<HashMap<String, Object>>>) new e<ArrayList<HashMap<String, Object>>>() {
            public void a(ArrayList<HashMap<String, Object>> arrayList) {
                if (arrayList != null) {
                    try {
                        if (!arrayList.isEmpty()) {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<HashMap<String, Object>> it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                Object obj = it2.next().get(l.a("005Xhlgngngghn"));
                                if (obj != null) {
                                    arrayList2.add(String.valueOf(obj));
                                }
                            }
                            Collections.sort(arrayList2);
                            String MD5 = Data.MD5(TextUtils.join("", arrayList2));
                            ab a11 = ab.a();
                            String str = ab.f26996j;
                            String b11 = a11.b(str, (String) null);
                            long currentTimeMillis = System.currentTimeMillis();
                            ab a12 = ab.a();
                            String str2 = ab.f26997k;
                            long b12 = a12.b(str2, 0);
                            long intValue = (long) (((Integer) o.this.a(l.a("005-hi=iTgl*fl"), 7200)).intValue() * 1000);
                            if (b11 == null || !b11.equals(MD5) || currentTimeMillis - intValue >= b12) {
                                o.this.a(0, "WLMT", (Object) arrayList, true);
                                ab.a().a(str, MD5);
                                ab.a().a(str2, currentTimeMillis);
                            }
                        }
                    } catch (Throwable th2) {
                        MobLog.getInstance().w(th2);
                    }
                }
            }
        });
    }

    public void a() {
        Object obj = this.f26917b;
        if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            this.f26977d.set(0);
        }
        m();
    }

    public void c() {
        k.a().a(getClass().getName(), (k.a) new k.a() {
            public void a() {
                if (o.this.e()) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis() - o.this.f26976c;
                        long intValue = (long) (((Integer) b.a("wsct", 300)).intValue() * 1000);
                        if (currentTimeMillis >= intValue) {
                            o.this.m();
                        } else if (o.this.f26977d.get() == 0) {
                            o.this.f26977d.getAndSet(1);
                            o oVar = new o();
                            oVar.a((Object) Boolean.TRUE).a(true);
                            d.a().a(oVar, (intValue - currentTimeMillis) / 1000, 0);
                        }
                    } catch (Throwable th2) {
                        MobLog.getInstance().d(th2);
                    }
                }
            }
        });
    }
}
