package com.mob.tools.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.mob.commons.CSCenter;
import com.mob.commons.a.l;
import com.mob.commons.d;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.f;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static e f27785b;

    /* renamed from: a  reason: collision with root package name */
    private Context f27786a;

    /* renamed from: c  reason: collision with root package name */
    private Object f27787c;

    /* renamed from: d  reason: collision with root package name */
    private PackageManager f27788d;

    /* renamed from: e  reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f27789e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f27790f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f27791g = new ConcurrentHashMap<>();

    private e(Context context) {
        this.f27786a = context;
    }

    public static e a(Context context) {
        if (f27785b == null) {
            synchronized (e.class) {
                if (f27785b == null) {
                    f27785b = new e(context);
                }
            }
        }
        return f27785b;
    }

    public ResolveInfo b(Intent intent, int i11) {
        if (!d.b()) {
            return null;
        }
        return (ResolveInfo) ReflectHelper.invokeInstanceMethod(this.f27786a.getPackageManager(), l.a("015>ek-gIgjelOhXee@gEge3dj>ejeeejZj<fd"), new Object[]{intent, Integer.valueOf(i11)}, new Class[]{Intent.class, Integer.TYPE}, null);
    }

    public int c() {
        if (Build.VERSION.SDK_INT < 24 || !DH.SyncMtd.checkPermission(l.a("035efWedekelejedem)kgXekegejgjgjejel+f7emhkhjgegmeihmglhifhhjeifmgdgegdhj"))) {
            return -1;
        }
        if (!CSCenter.getInstance().isPhoneStateDataEnable()) {
            return CSCenter.getInstance().getNetworkType();
        }
        if (this.f27787c == null) {
            this.f27787c = DH.SyncMtd.getSystemServiceSafe(l.a("005kiIelEfg"));
        }
        return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(this.f27787c, l.a("018^fkHgj1gmLejeHfh:gjZghelekfigdfd2kg"), -1, new Object[0])).intValue();
    }

    public ApplicationInfo d() {
        return this.f27786a.getApplicationInfo();
    }

    public Object b(String str) {
        Object systemServiceSafe;
        if (!d.f() || !f.a().a(str) || (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(l.a("008h>elCdej6ejelCf"))) == null) {
            return null;
        }
        return ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, l.a("020Cfk4gjDgf1eLgjUjTjdPfGelgh4f8gfelIdej5ejelBf"), null, str);
    }

    public String a(String str) {
        return a(str, "");
    }

    public String a(String str, String str2) {
        Object invokeStaticMethodNoThrow = ReflectHelper.invokeStaticMethodNoThrow(ReflectHelper.importClassNoThrow(l.a("027efMedekelejedemelgjemfmfdgjKjg>eghmekel*kgRek<j2ej-gKgj"), (String) null), l.a("003WfkHgj"), str2, str);
        return invokeStaticMethodNoThrow != null ? String.valueOf(invokeStaticMethodNoThrow) : str2;
    }

    public int b() {
        if (!c.a(this.f27786a).d().e(l.a("035efGedekelejedemGkg[ekegejgjgjejelJfEemhkhjgegmeihmglhifhhjeifmgdgegdhj"))) {
            return -1;
        }
        if (!CSCenter.getInstance().isPhoneStateDataEnable()) {
            return CSCenter.getInstance().getNetworkType();
        }
        if (this.f27787c == null) {
            this.f27787c = DH.SyncMtd.getSystemServiceSafe(l.a("005ki_el<fg"));
        }
        return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(this.f27787c, l.a("014+fk(gj(fhFgjEghelekfigdfd1kg"), -1, new Object[0])).intValue();
    }

    public Enumeration<NetworkInterface> a() {
        try {
            return NetworkInterface.getNetworkInterfaces();
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public List<ResolveInfo> a(Intent intent, int i11) {
        if (!d.b()) {
            return null;
        }
        return (List) ReflectHelper.invokeInstanceMethod(this.f27786a.getPackageManager(), l.a("019+efeh-gYekfdff)fjgfj6fm<g^ekeeejGdg-gj"), new Object[]{intent, Integer.valueOf(i11)}, new Class[]{Intent.class, Integer.TYPE}, null);
    }

    public Object a(String str, int i11, boolean z11) throws Throwable {
        Class<String> cls = String.class;
        if (this.f27788d == null) {
            this.f27788d = this.f27786a.getPackageManager();
        }
        if (z11) {
            return DH.SyncMtd.invokeInstanceMethod(this.f27788d, l.a("014Hfk)gj_hmNedYfi_eQfk-gGffQfYfgel"), new Object[]{str, Integer.valueOf(i11)}, new Class[]{cls, Integer.TYPE});
        }
        boolean equals = str.equals(DH.SyncMtd.getPackageName());
        if (!equals && !d.b()) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 25 && !equals) {
            return j.a(this.f27786a, str, i11);
        }
        return DH.SyncMtd.invokeInstanceMethod(this.f27788d, l.a("014Hfk[gj7hm^edZfi+eCfk@g5ff[fJfgel"), new Object[]{str, Integer.valueOf(i11)}, new Class[]{cls, Integer.TYPE});
    }

    public void a(String str, long j11, float f11, Object obj) {
        if (d.e()) {
            try {
                if (f.a().a(str)) {
                    Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(l.a("008hOel5dej)ejel7f"));
                    Class<?> cls = Class.forName(l.a("033efIedekelejedemGh[el)dej!ejel.fOemgfel*dej2ejelDf_gfejgjPjgfg-ek"));
                    if (systemServiceSafe != null) {
                        ReflectHelper.invokeInstanceMethod(systemServiceSafe, l.a("022Qek)gNefehZgOgjBjIgfel0dejGejel?fFfl)kXed[ejgCgj"), new Object[]{str, Long.valueOf(j11), Float.valueOf(f11), obj, l.a().c()}, new Class[]{String.class, Long.TYPE, Float.TYPE, cls, Looper.class});
                    }
                }
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
            }
        }
    }

    public Enumeration<InetAddress> a(NetworkInterface networkInterface) {
        return (Enumeration) ReflectHelper.invokeInstanceMethodNoThrow(networkInterface, l.a("0169fkZgj)ffUfgjYgeededek:gGgjgjYg@gj"), null, new Object[0]);
    }

    public ApplicationInfo a(String str, int i11) throws PackageManager.NameNotFoundException {
        if (this.f27788d == null) {
            this.f27788d = this.f27786a.getPackageManager();
        }
        if (TextUtils.equals(str, this.f27786a.getPackageName()) || d.b()) {
            return this.f27788d.getApplicationInfo(str, i11);
        }
        return null;
    }
}
