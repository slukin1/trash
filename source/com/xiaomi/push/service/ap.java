package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.xiaomi.push.y;

public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static ap f52511a;

    /* renamed from: a  reason: collision with other field name */
    private int f3353a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f3354a;

    private ap(Context context) {
        this.f3354a = context.getApplicationContext();
    }

    public static ap a(Context context) {
        if (f52511a == null) {
            f52511a = new ap(context);
        }
        return f52511a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2999a() {
        String str = y.f3453a;
        return str.contains("xmsf") || str.contains("xiaomi") || str.contains("miui");
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i11 = this.f3353a;
        if (i11 != 0) {
            return i11;
        }
        try {
            this.f3353a = Settings.Global.getInt(this.f3354a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f3353a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m2998a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
