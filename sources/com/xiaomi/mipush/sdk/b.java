package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huobi.finance.bean.FinanceRecordItem;
import com.xiaomi.push.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f51298a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2453a;

    /* renamed from: a  reason: collision with other field name */
    private a f2454a;

    /* renamed from: a  reason: collision with other field name */
    public String f2455a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f2456a;

    private b(Context context) {
        this.f2453a = context;
        c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m2335a(Context context) {
        if (f51298a == null) {
            synchronized (b.class) {
                if (f51298a == null) {
                    f51298a = new b(context);
                }
            }
        }
        return f51298a;
    }

    private void c() {
        this.f2454a = new a(this.f2453a);
        this.f2456a = new HashMap();
        SharedPreferences a11 = a(this.f2453a);
        this.f2454a.f2458a = a11.getString("appId", (String) null);
        this.f2454a.f51300b = a11.getString("appToken", (String) null);
        this.f2454a.f51301c = a11.getString("regId", (String) null);
        this.f2454a.f51302d = a11.getString("regSec", (String) null);
        this.f2454a.f51303e = a11.getString("vName", (String) null);
        this.f2454a.f2459a = a11.getBoolean(FinanceRecordItem.STATE_VALID, true);
        this.f2454a.f2460b = a11.getBoolean("paused", false);
        this.f2454a.f51299a = a11.getInt("envType", 1);
        this.f2454a.f51304f = a11.getString("regResource", (String) null);
        this.f2454a.f51305g = a11.getString("appRegion", (String) null);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2342b() {
        if (this.f2454a.a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.a("Don't send message before initialization succeeded!");
        return false;
    }

    public String d() {
        return this.f2454a.f51302d;
    }

    public String e() {
        return this.f2454a.f51304f;
    }

    public String f() {
        return this.f2454a.f51305g;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m2345d() {
        return !TextUtils.isEmpty(this.f2454a.f2458a) && !TextUtils.isEmpty(this.f2454a.f51300b) && !TextUtils.isEmpty(this.f2454a.f51301c) && !TextUtils.isEmpty(this.f2454a.f51302d);
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m2346e() {
        return this.f2454a.f2460b;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m2347f() {
        return !this.f2454a.f2459a;
    }

    public String b() {
        return this.f2454a.f51300b;
    }

    public void b(String str, String str2, String str3) {
        this.f2454a.b(str, str2, str3);
    }

    public void b(String str) {
        this.f2456a.remove(str);
        a(this.f2453a).edit().remove("hybrid_app_info_" + str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2339a() {
        Context context = this.f2453a;
        return !TextUtils.equals(g.a(context, context.getPackageName()), this.f2454a.f51303e);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2341b() {
        this.f2454a.b();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f51299a = 1;

        /* renamed from: a  reason: collision with other field name */
        private Context f2457a;

        /* renamed from: a  reason: collision with other field name */
        public String f2458a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2459a = true;

        /* renamed from: b  reason: collision with root package name */
        public String f51300b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f2460b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f51301c;

        /* renamed from: d  reason: collision with root package name */
        public String f51302d;

        /* renamed from: e  reason: collision with root package name */
        public String f51303e;

        /* renamed from: f  reason: collision with root package name */
        public String f51304f;

        /* renamed from: g  reason: collision with root package name */
        public String f51305g;

        public a(Context context) {
            this.f2457a = context;
        }

        public void a(String str, String str2, String str3) {
            this.f2458a = str;
            this.f51300b = str2;
            this.f51304f = str3;
            SharedPreferences.Editor edit = b.a(this.f2457a).edit();
            edit.putString("appId", this.f2458a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void b(String str, String str2, String str3) {
            this.f51301c = str;
            this.f51302d = str2;
            this.f51303e = a();
            this.f2459a = true;
            this.f51305g = str3;
            SharedPreferences.Editor edit = b.a(this.f2457a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("vName", a());
            edit.putBoolean(FinanceRecordItem.STATE_VALID, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f2458a = str;
            this.f51300b = str2;
            this.f51304f = str3;
        }

        public void a(String str, String str2) {
            this.f51301c = str;
            this.f51302d = str2;
            this.f51303e = a();
            this.f2459a = true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m2350a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f2458a, str);
            boolean equals2 = TextUtils.equals(this.f51300b, str2);
            boolean z11 = !TextUtils.isEmpty(this.f51301c);
            boolean z12 = !TextUtils.isEmpty(this.f51302d);
            boolean z13 = equals && equals2 && z11 && z12;
            if (!z13) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s", new Object[]{Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z11), Boolean.valueOf(z12)}));
            }
            return z13;
        }

        public void b() {
            this.f2459a = false;
            b.a(this.f2457a).edit().putBoolean(FinanceRecordItem.STATE_VALID, this.f2459a).commit();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m2349a() {
            return a(this.f2458a, this.f51300b);
        }

        private String a() {
            Context context = this.f2457a;
            return g.a(context, context.getPackageName());
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2348a() {
            b.a(this.f2457a).edit().clear().commit();
            this.f2458a = null;
            this.f51300b = null;
            this.f51301c = null;
            this.f51302d = null;
            this.f51303e = null;
            this.f2459a = false;
            this.f2460b = false;
            this.f51305g = null;
            this.f51299a = 1;
        }

        public void a(boolean z11) {
            this.f2460b = z11;
        }

        public void a(int i11) {
            this.f51299a = i11;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f2458a = jSONObject.getString("appId");
                aVar.f51300b = jSONObject.getString("appToken");
                aVar.f51301c = jSONObject.getString("regId");
                aVar.f51302d = jSONObject.getString("regSec");
                aVar.f51303e = jSONObject.getString("vName");
                aVar.f2459a = jSONObject.getBoolean(FinanceRecordItem.STATE_VALID);
                aVar.f2460b = jSONObject.getBoolean("paused");
                aVar.f51299a = jSONObject.getInt("envType");
                aVar.f51304f = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.a(th2);
                return null;
            }
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f2458a);
                jSONObject.put("appToken", aVar.f51300b);
                jSONObject.put("regId", aVar.f51301c);
                jSONObject.put("regSec", aVar.f51302d);
                jSONObject.put("vName", aVar.f51303e);
                jSONObject.put(FinanceRecordItem.STATE_VALID, aVar.f2459a);
                jSONObject.put("paused", aVar.f2460b);
                jSONObject.put("envType", aVar.f51299a);
                jSONObject.put("regResource", aVar.f51304f);
                return jSONObject.toString();
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.a(th2);
                return null;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2338a(String str) {
        SharedPreferences.Editor edit = a(this.f2453a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f2454a.f51303e = str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2336a() {
        return this.f2454a.f2458a;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m2343c() {
        return this.f2454a.f51301c;
    }

    public boolean a(String str, String str2) {
        return this.f2454a.a(str, str2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2344c() {
        return this.f2454a.a();
    }

    public void a(String str, String str2, String str3) {
        this.f2454a.a(str, str2, str3);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2337a() {
        this.f2454a.a();
    }

    public a a(String str) {
        if (this.f2456a.containsKey(str)) {
            return this.f2456a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a11 = a(this.f2453a);
        if (!a11.contains(str2)) {
            return null;
        }
        a a12 = a.a(this.f2453a, a11.getString(str2, ""));
        this.f2456a.put(str2, a12);
        return a12;
    }

    public void a(String str, a aVar) {
        this.f2456a.put(str, aVar);
        String a11 = a.a(aVar);
        a(this.f2453a).edit().putString("hybrid_app_info_" + str, a11).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2340a(String str, String str2, String str3) {
        a a11 = a(str3);
        return a11 != null && TextUtils.equals(str, a11.f2458a) && TextUtils.equals(str2, a11.f51300b);
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public int a() {
        return this.f2454a.f51299a;
    }

    public void a(boolean z11) {
        this.f2454a.a(z11);
        a(this.f2453a).edit().putBoolean("paused", z11).commit();
    }

    public void a(int i11) {
        this.f2454a.a(i11);
        a(this.f2453a).edit().putInt("envType", i11).commit();
    }
}
