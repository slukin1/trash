package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.NotificationUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class a0 {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f63535a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedHashMap<String, String> f63536b = new LinkedHashMap<>();

        /* renamed from: c  reason: collision with root package name */
        public LinkedHashMap<String, String> f63537c = new LinkedHashMap<>();

        public a(String str) {
            this.f63535a = str;
        }

        public void a(String str, String str2) {
            b(this.f63536b, str, str2);
        }

        public final void b(Map<String, String> map, String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int length = 19 - str.length();
                if (length > 0) {
                    str = str + "                   ".substring(0, length);
                }
                map.put(str, str2);
            }
        }

        public String c() {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : this.f63537c.entrySet()) {
                sb2.append((String) next.getKey());
                sb2.append(l.f34627b);
                sb2.append((String) next.getValue());
                sb2.append("\n");
            }
            return sb2.toString();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = "************* " + this.f63535a + " Head ****************\n";
            sb2.append(str);
            for (Map.Entry next : this.f63536b.entrySet()) {
                sb2.append((String) next.getKey());
                sb2.append(l.f34627b);
                sb2.append((String) next.getValue());
                sb2.append("\n");
            }
            sb2.append("Rom Info           : ");
            sb2.append(RomUtils.c());
            sb2.append("\n");
            sb2.append("Device Manufacturer: ");
            sb2.append(Build.MANUFACTURER);
            sb2.append("\n");
            sb2.append("Device Model       : ");
            sb2.append(Build.MODEL);
            sb2.append("\n");
            sb2.append("Android Version    : ");
            sb2.append(Build.VERSION.RELEASE);
            sb2.append("\n");
            sb2.append("Android SDK        : ");
            sb2.append(Build.VERSION.SDK_INT);
            sb2.append("\n");
            sb2.append("App VersionName    : ");
            sb2.append(d.c());
            sb2.append("\n");
            sb2.append("App VersionCode    : ");
            sb2.append(d.a());
            sb2.append("\n");
            sb2.append(c());
            sb2.append(str);
            sb2.append("\n");
            return sb2.toString();
        }
    }

    public static boolean A() {
        return ViewUtils.a();
    }

    public static boolean B() {
        return s.a();
    }

    public static boolean C(String str) {
        return x.e(str);
    }

    public static boolean D(View view, long j11) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return i.b(view, j11);
    }

    public static View E(int i11) {
        return ViewUtils.b(i11);
    }

    public static void F() {
        G(b.f());
    }

    public static void G(Runnable... runnableArr) {
        for (Runnable execute : runnableArr) {
            ThreadUtils.d().execute(execute);
        }
    }

    public static void H(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        z.f63546h.t(activityLifecycleCallbacks);
    }

    public static void I(Runnable runnable) {
        ThreadUtils.h(runnable);
    }

    public static void J(Runnable runnable, long j11) {
        ThreadUtils.i(runnable, j11);
    }

    public static void K(Application application) {
        z.f63546h.x(application);
    }

    public static Bitmap L(View view) {
        return ImageUtils.b(view);
    }

    public static boolean M(String str, String str2, boolean z11) {
        return k.h(str, str2, z11);
    }

    public static void a(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        z.f63546h.d(activityLifecycleCallbacks);
    }

    public static boolean b(File file) {
        return l.a(file);
    }

    public static boolean c(File file) {
        return l.b(file);
    }

    public static int d(float f11) {
        return v.a(f11);
    }

    public static void e(Activity activity) {
        KeyboardUtils.e(activity);
    }

    public static String f(String str) {
        return o.a(str);
    }

    public static List<Activity> g() {
        return z.f63546h.i();
    }

    public static int h() {
        return u.b();
    }

    public static Application i() {
        return z.f63546h.m();
    }

    public static String j() {
        return r.a();
    }

    public static File k(String str) {
        return l.f(str);
    }

    public static String l(Throwable th2) {
        return y.a(th2);
    }

    public static Gson m() {
        return m.e();
    }

    public static Intent n(String str, boolean z11) {
        return n.b(str, z11);
    }

    public static int o() {
        return e.a();
    }

    public static Notification p(NotificationUtils.a aVar, Utils.a<NotificationCompat.e> aVar2) {
        return NotificationUtils.a(aVar, aVar2);
    }

    public static t q() {
        return t.a("Utils");
    }

    public static int r() {
        return e.b();
    }

    public static String s(int i11) {
        return x.b(i11);
    }

    public static Activity t() {
        return z.f63546h.n();
    }

    public static void u(Application application) {
        z.f63546h.o(application);
    }

    public static boolean v(Activity activity) {
        return a.e(activity);
    }

    public static boolean w() {
        return z.f63546h.p();
    }

    public static boolean x(File file) {
        return l.h(file);
    }

    public static boolean y() {
        return PermissionUtils.v();
    }

    public static boolean z(Intent intent) {
        return n.c(intent);
    }
}
