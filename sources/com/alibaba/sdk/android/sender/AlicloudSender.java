package com.alibaba.sdk.android.sender;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.sdk.android.tbrest.SendService;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.android.tpush.common.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class AlicloudSender {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14664a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f14665b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, SdkInfo> f14666c;

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, c> f14667d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f14668e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicBoolean f14669f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public static SendService f14670g;

    /* renamed from: h  reason: collision with root package name */
    public static final y2.b f14671h = z2.a.a(AlicloudSender.class);

    /* renamed from: i  reason: collision with root package name */
    public static boolean f14672i = false;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: j  reason: collision with root package name */
    public static final SimpleDateFormat f14673j = new SimpleDateFormat("yyyyMMdd");

    public static class a implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            if (AlicloudSender.f14666c != null && !AlicloudSender.f14666c.isEmpty()) {
                for (SdkInfo d11 : AlicloudSender.f14666c.values()) {
                    AlicloudSender.j(activity.getApplicationContext(), d11);
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f14674b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SdkInfo f14675c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f14676d;

        public b(Context context, SdkInfo sdkInfo, String str) {
            this.f14674b = context;
            this.f14675c = sdkInfo;
            this.f14676d = str;
        }

        public void run() {
            AlicloudSender.k(this.f14674b, this.f14675c, this.f14676d);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f14677a;

        /* renamed from: b  reason: collision with root package name */
        public String f14678b;

        /* renamed from: c  reason: collision with root package name */
        public String f14679c;

        public c() {
            this.f14677a = -1;
            this.f14678b = "";
            this.f14679c = "";
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static void b(Application application) {
        if (f14669f.compareAndSet(false, true) && Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new a());
        }
    }

    public static void c(Context context) {
        if (f14668e.compareAndSet(false, true)) {
            f14666c = new ConcurrentHashMap();
            f14667d = l(context);
            SendService sendService = new SendService();
            f14670g = sendService;
            sendService.f14694i = Boolean.valueOf(f14672i);
            f14670g.b(context, "24527540@android", "24527540", i(context), (String) null, (String) null);
            f14670g.f14689d = "56fc10fbe8c6ae7d0d895f49c4fb6838";
        }
    }

    public static void f(Context context, Map<String, c> map) {
        SharedPreferences.Editor editor;
        if (map == null || map.isEmpty()) {
            editor = context.getSharedPreferences("sp_emas_info", 0).edit().remove("emas_sdk_info");
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String next : map.keySet()) {
                c cVar = map.get(next);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", next);
                    jSONObject.put("version", cVar.f14679c);
                    jSONObject.put(CrashHianalyticsData.TIME, cVar.f14678b);
                    jSONObject.put("statu", cVar.f14677a);
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
            }
            editor = context.getSharedPreferences("sp_emas_info", 0).edit().putString("emas_sdk_info", jSONArray.toString());
        }
        editor.apply();
    }

    public static void g(Application application, SdkInfo sdkInfo) {
        if (application == null) {
            f14671h.d("asyncSend failed. application is null. ");
        } else if (sdkInfo == null) {
            f14671h.d("asyncSend failed. sdk info is null. ");
        } else {
            String a11 = sdkInfo.a();
            if (TextUtils.isEmpty(a11)) {
                f14671h.d("asyncSend failed. sdk id is empty. ");
            } else if (TextUtils.isEmpty(sdkInfo.b())) {
                f14671h.d("asyncSend failed. sdk version is empty. ");
            } else {
                c(application.getApplicationContext());
                b(application);
                f14666c.put(a11, sdkInfo);
                j(application.getApplicationContext(), sdkInfo);
            }
        }
    }

    @Deprecated
    public static void h(Context context, SdkInfo sdkInfo) {
        if (context == null) {
            f14671h.d("asyncSend failed. context is null. ");
        } else if (sdkInfo == null) {
            f14671h.d("asyncSend failed. sdk info is null. ");
        } else {
            String a11 = sdkInfo.a();
            if (TextUtils.isEmpty(a11)) {
                f14671h.d("asyncSend failed. sdk id is empty. ");
            } else if (TextUtils.isEmpty(sdkInfo.b())) {
                f14671h.d("asyncSend failed. sdk version is empty. ");
            } else {
                c(context.getApplicationContext());
                f14666c.put(a11, sdkInfo);
                j(context.getApplicationContext(), sdkInfo);
            }
        }
    }

    public static String i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static void j(Context context, SdkInfo sdkInfo) {
        String format = f14673j.format(new Date(System.currentTimeMillis()));
        try {
            c cVar = f14667d.get(sdkInfo.a());
            if (cVar == null || !TextUtils.equals(format, cVar.f14678b) || !TextUtils.equals(sdkInfo.b(), cVar.f14679c) || cVar.f14677a != 0) {
                f14665b.execute(new b(context, sdkInfo, format));
                return;
            }
            y2.b bVar = f14671h;
            bVar.d(sdkInfo.a() + " " + sdkInfo.b() + " send abort send. ");
        } catch (Exception unused) {
        }
    }

    public static void k(Context context, SdkInfo sdkInfo, String str) {
        c cVar = f14667d.get(sdkInfo.a());
        if (cVar == null) {
            cVar = new c((a) null);
            f14667d.put(sdkInfo.a(), cVar);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sdkId", sdkInfo.a());
        hashMap.put(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        hashMap.put("sdkVersion", sdkInfo.b());
        hashMap.put("kVersion", "1.1.4");
        if (!TextUtils.isEmpty(sdkInfo.c())) {
            hashMap.put("appKey", sdkInfo.c());
        }
        Map<String, String> map = sdkInfo.f14684d;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("_aliyun_biz_id", "emas-active");
        y2.b bVar = f14671h;
        bVar.d(sdkInfo.a() + " " + sdkInfo.b() + " start send. ");
        SendService sendService = f14670g;
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = f14664a;
        boolean booleanValue = sendService.c("adash-emas.cn-hangzhou.aliyuncs.com", currentTimeMillis, str2, 19999, sdkInfo.a() + "_biz_active", (Object) null, (Object) null, hashMap).booleanValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sdkInfo.a());
        sb2.append(" ");
        sb2.append(sdkInfo.b());
        sb2.append(" send ");
        sb2.append(booleanValue ? "success. " : "failed. ");
        bVar.d(sb2.toString());
        String unused = cVar.f14678b = str;
        String unused2 = cVar.f14679c = sdkInfo.b();
        int unused3 = cVar.f14677a = booleanValue ? 0 : -1;
        f(context, f14667d);
    }

    public static Map<String, c> l(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        String string = context.getSharedPreferences("sp_emas_info", 0).getString("emas_sdk_info", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i11);
                        String string2 = jSONObject.getString("id");
                        c cVar = new c((a) null);
                        String unused = cVar.f14678b = jSONObject.getString(CrashHianalyticsData.TIME);
                        int unused2 = cVar.f14677a = jSONObject.getInt("statu");
                        String unused3 = cVar.f14679c = jSONObject.getString("version");
                        concurrentHashMap.put(string2, cVar);
                    }
                }
            } catch (Exception unused4) {
            }
        }
        return concurrentHashMap;
    }
}
