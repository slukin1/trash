package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.bc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static r f52585a;

    /* renamed from: a  reason: collision with other field name */
    private Context f3414a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f3415a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f52586b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f52587c = new ArrayList();

    private r(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f3414a = applicationContext;
        if (applicationContext == null) {
            this.f3414a = context;
        }
        SharedPreferences sharedPreferences = this.f3414a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f3415a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f52586b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f52587c.add(str3);
            }
        }
    }

    public static r a(Context context) {
        if (f52585a == null) {
            f52585a = new r(context);
        }
        return f52585a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m3043b(String str) {
        boolean contains;
        synchronized (this.f52586b) {
            contains = this.f52586b.contains(str);
        }
        return contains;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m3044c(String str) {
        boolean contains;
        synchronized (this.f52587c) {
            contains = this.f52587c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f3415a) {
            if (this.f3415a.contains(str)) {
                this.f3415a.remove(str);
                this.f3414a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", bc.a((Collection<?>) this.f3415a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f52586b) {
            if (this.f52586b.contains(str)) {
                this.f52586b.remove(str);
                this.f3414a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", bc.a((Collection<?>) this.f52586b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f52587c) {
            if (this.f52587c.contains(str)) {
                this.f52587c.remove(str);
                this.f3414a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", bc.a((Collection<?>) this.f52587c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m3042a(String str) {
        boolean contains;
        synchronized (this.f3415a) {
            contains = this.f3415a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.f52586b) {
            if (!this.f52586b.contains(str)) {
                this.f52586b.add(str);
                this.f3414a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", bc.a((Collection<?>) this.f52586b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void c(String str) {
        synchronized (this.f52587c) {
            if (!this.f52587c.contains(str)) {
                this.f52587c.add(str);
                this.f3414a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", bc.a((Collection<?>) this.f52587c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void a(String str) {
        synchronized (this.f3415a) {
            if (!this.f3415a.contains(str)) {
                this.f3415a.add(str);
                this.f3414a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", bc.a((Collection<?>) this.f3415a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
