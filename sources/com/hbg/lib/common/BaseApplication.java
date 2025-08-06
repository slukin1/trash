package com.hbg.lib.common;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.dianping.logan.Logan;
import com.dianping.logan.LoganConfig;
import i6.k;

public abstract class BaseApplication {

    /* renamed from: a  reason: collision with root package name */
    public static Application f67406a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67407b = false;

    public static int a(int i11) {
        Context applicationContext;
        if (b() == null || (applicationContext = b().getApplicationContext()) == null) {
            return 0;
        }
        return ContextCompat.getColor(applicationContext, i11);
    }

    public static Application b() {
        return f67406a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = b().getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(int r1) {
        /*
            android.app.Application r0 = b()
            if (r0 == 0) goto L_0x0015
            android.app.Application r0 = b()
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x0015
            java.lang.String r1 = r0.getString(r1)
            return r1
        L_0x0015:
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.BaseApplication.c(int):java.lang.String");
    }

    public static int d() {
        try {
            return b().getPackageManager().getPackageInfo(b().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static String e() {
        try {
            return b().getPackageManager().getPackageInfo(b().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static void f(Application application) {
        f67406a = application;
        g();
    }

    public static void g() {
        if (b() != null && b().getFilesDir() != null && !TextUtils.isEmpty(k.l(b()))) {
            Logan.a(new LoganConfig.Builder().b(b().getFilesDir().getAbsolutePath()).g(k.l(b())).e("huobi12345678901".getBytes()).d("huobi12345678901".getBytes()).c(7).f(29).a());
            Logan.d(false);
        }
    }
}
