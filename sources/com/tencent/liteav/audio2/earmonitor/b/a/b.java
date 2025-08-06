package com.tencent.liteav.audio2.earmonitor.b.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.tencent.liteav.base.util.LiteavLog;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f21345b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f21346c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f21347d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f21348e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static b f21349f;

    /* renamed from: a  reason: collision with root package name */
    public e f21350a = null;

    public static b a() {
        b bVar;
        synchronized (f21346c) {
            if (f21349f == null) {
                f21349f = new b();
            }
            bVar = f21349f;
        }
        return bVar;
    }

    public static <T extends a> T a(int i11, Context context) {
        if (context == null || i11 != 1) {
            return null;
        }
        T cVar = new c(context);
        cVar.a(context);
        return cVar;
    }

    public static void a(Context context, ServiceConnection serviceConnection, String str) {
        synchronized (f21347d) {
            if (context != null) {
                Intent intent = new Intent();
                intent.setClassName("com.huawei.multimedia.audioengine", str);
                try {
                    context.bindService(intent, serviceConnection, 1);
                } catch (SecurityException e11) {
                    LiteavLog.e("HwAudioKit.FeatureKitManager", "bindService, SecurityException, %s", e11.getMessage());
                }
            }
        }
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        synchronized (f21348e) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return true;
        }
        try {
            if (packageManager.getPackageInfo("com.huawei.multimedia.audioengine", 0) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            LiteavLog.e("HwAudioKit.FeatureKitManager", "isAudioKitSupport ,NameNotFoundException");
            return false;
        }
    }

    public final void a(int i11) {
        synchronized (f21345b) {
            e eVar = this.f21350a;
            if (eVar != null) {
                eVar.a(i11);
            }
        }
    }
}
