package com.huobi.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import bh.j;
import com.huobi.index.trace.IndexLifeCycleStep;
import com.huobi.index.trace.IndexLifeCycleTracer;
import com.huobi.webcache.ReflectionUtil;
import e6.k;
import i6.d;
import i6.u;
import java.io.File;
import java.io.IOException;
import js.b;

public class HuobiMainApplication extends Application {

    /* renamed from: b  reason: collision with root package name */
    public static k f42142b;

    public void attachBaseContext(Context context) {
        u.f68196a.b(System.currentTimeMillis());
        File file = null;
        try {
            int i11 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getCacheDir().getPath());
            String str = File.separator;
            sb2.append(str);
            sb2.append(i11);
            sb2.append(str);
            sb2.append("application_hook_stop.huobi");
            File file2 = new File(sb2.toString());
            try {
                if (!file2.exists()) {
                    Resources resources = (Resources) ReflectionUtil.f(context, "mResources");
                    k kVar = new k(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration(), resources);
                    f42142b = kVar;
                    ReflectionUtil.j(context, "mResources", kVar);
                }
            } catch (Throwable th2) {
                th = th2;
                file = file2;
                Log.e("HuobiMainApplication", "attachBaseContext:hook mResource hookSwitch=[" + file + "]Throwable ", th);
                try {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                super.attachBaseContext(context);
                j.a(context, this);
            }
        } catch (Throwable th3) {
            th = th3;
            Log.e("HuobiMainApplication", "attachBaseContext:hook mResource hookSwitch=[" + file + "]Throwable ", th);
            file.getParentFile().mkdirs();
            file.createNewFile();
            super.attachBaseContext(context);
            j.a(context, this);
        }
        super.attachBaseContext(context);
        j.a(context, this);
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        try {
            if (resources instanceof k) {
                return resources;
            }
            k kVar = f42142b;
            if (kVar != null) {
                return kVar;
            }
            if (kVar == null) {
                f42142b = new k(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration(), resources);
            }
            return f42142b;
        } catch (Exception e11) {
            Log.e("HuobiMainApplication", "getResources() called : " + resources + "  ,resources=" + resources.getClass().getCanonicalName(), e11);
            return resources;
        }
    }

    public SharedPreferences getSharedPreferences(String str, int i11) {
        SharedPreferences c11;
        if (!b.i()) {
            b.f(this, d.k());
        }
        if (b.i() && b.f84413j && (c11 = b.c(this, str)) != null) {
            return c11;
        }
        if (d.k()) {
            Log.e("MmkvSharedPrefs", "getSharedPreferences() called with: name = [" + str + "] 还用系统SharedPreferences");
        }
        return super.getSharedPreferences(str, i11);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j.e(configuration);
    }

    public void onCreate() {
        super.onCreate();
        System.currentTimeMillis();
        IndexLifeCycleTracer.c().f(IndexLifeCycleStep.AppStart);
        j.f();
    }
}
