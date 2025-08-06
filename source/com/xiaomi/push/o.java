package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static volatile o f52380a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Context f3256a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f3257a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Map<String, String>> f3258a = new HashMap();

    private o(Context context) {
        this.f3256a = context;
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f3258a == null) {
            this.f3258a = new HashMap();
        }
        Map map = this.f3258a.get(str);
        if (map == null) {
            map = new HashMap();
        }
        map.put(str2, str3);
        this.f3258a.put(str, map);
    }

    public static o a(Context context) {
        if (f52380a == null) {
            synchronized (o.class) {
                if (f52380a == null) {
                    f52380a = new o(context);
                }
            }
        }
        return f52380a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m2919a(final String str, final String str2, final String str3) {
        b(str, str2, str3);
        this.f3257a.post(new Runnable() {
            public void run() {
                SharedPreferences.Editor edit = o.this.f3256a.getSharedPreferences(str, 4).edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        });
    }

    private synchronized String a(String str, String str2) {
        if (this.f3258a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Map map = this.f3258a.get(str);
            if (map == null) {
                return "";
            }
            return (String) map.get(str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public synchronized String a(String str, String str2, String str3) {
        String a11 = a(str, str2);
        if (!TextUtils.isEmpty(a11)) {
            return a11;
        }
        return this.f3256a.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
