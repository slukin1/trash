package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import com.ta.a.a.b;
import com.ta.a.e.h;
import com.ta.utdid2.device.c;
import ty.d;
import ty.g;
import uy.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f40364a = new a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static long f40365c = 3000;

    /* renamed from: e  reason: collision with root package name */
    private String f40366e = "";

    private a() {
    }

    public static a a() {
        return f40364a;
    }

    private void h() {
        h.i();
        if (!TextUtils.isEmpty(this.f40366e)) {
            try {
                final Context f11 = py.a.c().f();
                if (uy.a.e(f11)) {
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(a.f40365c);
                            } catch (Exception unused) {
                            }
                            if (!d.h(f11)) {
                                h.e("", "unable upload!");
                                return;
                            }
                            new g(f11).run();
                        }
                    }).start();
                }
            } catch (Throwable th2) {
                h.e("", th2);
            }
        }
    }

    private String q() {
        final Context f11 = py.a.c().f();
        if (f11 == null) {
            return "";
        }
        final String j11 = d.j();
        if (c.c(j11)) {
            h.e("AppUtdid", "read utdid from V5AppFile");
            c.setType(7);
            c.a((c.a) new c.a() {
                public void i() {
                    b a11 = qy.a.a(j11);
                    String e11 = d.e(f11);
                    if (!TextUtils.isEmpty(e11)) {
                        b a12 = qy.a.a(e11);
                        if (!a12.c() || a12.b() < a11.b()) {
                            d.b(f11, j11);
                        }
                    } else {
                        d.b(f11, j11);
                    }
                    String l11 = d.l();
                    if (!TextUtils.isEmpty(l11)) {
                        b a13 = qy.a.a(l11);
                        if (!a13.c() || a13.b() < a11.b()) {
                            d.f(j11);
                            return;
                        }
                        return;
                    }
                    d.f(j11);
                }
            });
            return j11;
        }
        final String e11 = d.e(f11);
        if (c.c(e11)) {
            h.e("AppUtdid", "read utdid from V5Settings");
            c.setType(8);
            c.a((c.a) new c.a() {
                public void i() {
                    d.c(e11);
                    String l11 = d.l();
                    if (!TextUtils.isEmpty(l11)) {
                        b a11 = qy.a.a(e11);
                        b a12 = qy.a.a(l11);
                        if (!a12.c() || a12.b() < a11.b()) {
                            d.f(e11);
                            return;
                        }
                        return;
                    }
                    d.f(e11);
                }
            });
            return e11;
        }
        final String l11 = d.l();
        if (!c.c(l11)) {
            return null;
        }
        h.e("AppUtdid", "read utdid from V5Sdcard");
        c.setType(9);
        c.a((c.a) new c.a() {
            public void i() {
                d.c(l11);
                d.b(f11, l11);
            }
        });
        return l11;
    }

    public synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.f40366e)) {
            return this.f40366e;
        }
        try {
            e.b();
            String q11 = q();
            if (TextUtils.isEmpty(q11)) {
                q11 = c.a(context).getValue();
            }
            if (!TextUtils.isEmpty(q11)) {
                this.f40366e = q11;
                h();
                String str = this.f40366e;
                e.c();
                return str;
            }
            e.c();
            return "ffffffffffffffffffffffff";
        } catch (Throwable th2) {
            e.c();
            throw th2;
        }
    }

    public synchronized String r() {
        return this.f40366e;
    }
}
