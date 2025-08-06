package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

public class bn {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bn f51447a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2561a;

    private bn(Context context) {
        this.f2561a = context;
    }

    public static bn a(Context context) {
        if (f51447a == null) {
            synchronized (bn.class) {
                if (f51447a == null) {
                    f51447a = new bn(context);
                }
            }
        }
        return f51447a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m2445a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f2561a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m2444a(String str, String str2, long j11) {
        SharedPreferences.Editor edit = this.f2561a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j11);
        edit.commit();
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f2561a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized long a(String str, String str2, long j11) {
        try {
        } catch (Throwable unused) {
            return j11;
        }
        return this.f2561a.getSharedPreferences(str, 4).getLong(str2, j11);
    }
}
