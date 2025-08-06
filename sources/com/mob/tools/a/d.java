package com.mob.tools.a;

import android.content.Context;
import android.os.Build;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.commons.CSCenter;
import com.mob.commons.b;
import com.mob.tools.MobLog;
import com.mob.tools.b.c;
import com.mob.tools.log.NLog;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f27754a;

    /* renamed from: b  reason: collision with root package name */
    private a f27755b;

    private d(Context context) {
        try {
            boolean a11 = a();
            boolean b11 = b();
            boolean c11 = c();
            boolean isDREnable = CSCenter.getInstance().isDREnable();
            int i11 = c.a(context).d().ak().targetSdkVersion;
            int i12 = Build.VERSION.SDK_INT;
            b("3xu: " + b11 + ", 3xd: " + a11 + ", dre: " + isDREnable + ", obf: " + c11 + ", tar: " + i11 + ", api: " + i12);
            if (i11 < 30 || i12 < 30) {
                b("2x");
                this.f27755b = new e();
                return;
            }
            if (b11 && !c11) {
                c cVar = new c();
                if (cVar.a(context)) {
                    b("3xu");
                    this.f27755b = cVar;
                }
            }
            if (this.f27755b == null && isDREnable && a11) {
                b bVar = new b();
                if (bVar.a(context)) {
                    b("3xd");
                    this.f27755b = bVar;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f27754a == null && context != null) {
                f27754a = new d(context);
            }
            dVar = f27754a;
        }
        return dVar;
    }

    private boolean c() {
        return d();
    }

    private boolean d() {
        boolean z11 = true;
        try {
            if (C0891r.b("014bIcjceckcecjeeckgbcjeedkekhb").equals(MobSDK.class.getName()) && C0891r.b("024bBcjceckcecjeeck*bJcjcececj.d4ehckdcdkdcLedheDci").equals(CSCenter.class.getName())) {
                z11 = false;
            }
        } catch (Throwable th2) {
            a(th2);
        }
        b("ck-cn: " + z11);
        return z11;
    }

    public boolean b(Context context) {
        return b.b(context);
    }

    public static void b(String str) {
        NLog instance = MobLog.getInstance();
        instance.d("[HH] " + str, new Object[0]);
    }

    private boolean b() {
        return ((Integer) b.a(C0891r.b("0024cfeh"), 1)).intValue() == 1;
    }

    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, T t11) throws Throwable {
        a aVar = this.f27755b;
        return aVar != null ? aVar.a(cls, obj, str, clsArr, objArr) : t11;
    }

    public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr, T t11) throws Throwable {
        a aVar = this.f27755b;
        return aVar != null ? aVar.a(str, obj, str2, clsArr, objArr) : t11;
    }

    public <T> T a(String str) throws Throwable {
        a aVar = this.f27755b;
        if (aVar != null) {
            return aVar.a(str);
        }
        return null;
    }

    public <T> T a(String str, String str2, Object obj, T t11) throws Throwable {
        a aVar = this.f27755b;
        return aVar != null ? aVar.a(str, str2, obj) : t11;
    }

    public <T> T a(String str, Class[] clsArr, Object[] objArr) throws Throwable {
        a aVar = this.f27755b;
        if (aVar != null) {
            return aVar.a(str, clsArr, objArr);
        }
        return null;
    }

    public static void a(Throwable th2) {
        MobLog.getInstance().d(th2, "[HH] ", new Object[0]);
    }

    private boolean a() {
        return ((Integer) b.a(C0891r.b("0024cbde"), 0)).intValue() == 1;
    }
}
