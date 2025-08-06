package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

public class ao implements aj {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ao f51386a;

    /* renamed from: a  reason: collision with other field name */
    private int f2529a = an.f51385a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2530a;

    /* renamed from: a  reason: collision with other field name */
    private aj f2531a;

    private ao(Context context) {
        this.f2530a = context.getApplicationContext();
        this.f2531a = an.a(context);
        b.a("create id manager is: " + this.f2529a);
    }

    public static ao a(Context context) {
        if (f51386a == null) {
            synchronized (ao.class) {
                if (f51386a == null) {
                    f51386a = new ao(context.getApplicationContext());
                }
            }
        }
        return f51386a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2393a() {
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2394a() {
        return this.f2531a.a();
    }

    public String a() {
        return j.a(this.f2530a) ? a(this.f2531a.a()) : "";
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            String b11 = b();
            if (!TextUtils.isEmpty(b11)) {
                map.put("udid", b11);
            }
            String a11 = a();
            if (!TextUtils.isEmpty(a11)) {
                map.put("oaid", a11);
            }
            String c11 = c();
            if (!TextUtils.isEmpty(c11)) {
                map.put("vaid", c11);
            }
            String d11 = d();
            if (!TextUtils.isEmpty(d11)) {
                map.put("aaid", d11);
            }
            map.put("oaid_type", String.valueOf(this.f2529a));
        }
    }
}
