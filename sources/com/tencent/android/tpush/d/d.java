package com.tencent.android.tpush.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.a.a;
import com.tencent.android.tpush.d.a.b;
import com.tencent.android.tpush.d.a.c;
import com.tencent.android.tpush.d.a.e;
import com.tencent.android.tpush.d.a.f;
import com.tencent.android.tpush.d.a.g;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f68945a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f68946b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f68947c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f68948d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f68949e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f68950f = "";

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f68951g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    public static String f68952h = "";

    /* renamed from: i  reason: collision with root package name */
    private static volatile d f68953i = null;

    /* renamed from: j  reason: collision with root package name */
    private static volatile c f68954j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile c f68955k = null;

    /* renamed from: l  reason: collision with root package name */
    private static volatile c f68956l = null;

    /* renamed from: m  reason: collision with root package name */
    private Boolean f68957m;

    /* renamed from: n  reason: collision with root package name */
    private Boolean f68958n;

    /* renamed from: o  reason: collision with root package name */
    private Boolean f68959o;

    /* renamed from: p  reason: collision with root package name */
    private Context f68960p = null;

    /* renamed from: q  reason: collision with root package name */
    private int f68961q = -1;

    private d(Context context) {
        this.f68960p = context;
        this.f68960p = context;
        if (h.a(context).a() && XGPushConfig.isUsedFcmPush(context)) {
            f68956l = new a();
        }
        f68955k = b(this.f68960p);
        if (n()) {
            f68954j = f68955k;
        } else if (o()) {
            f68954j = f68956l;
        } else {
            f68954j = f68955k;
        }
    }

    private c b(Context context) {
        c eVar;
        try {
            String j11 = j();
            if (com.tencent.android.tpush.f.a.b(this.f68960p)) {
                TLogger.ii("OtherPushManager", "USE XgSys");
                eVar = new com.tencent.android.tpush.d.a.h(this.f68960p);
            } else {
                if (!ChannelUtils.isBrandXiaoMi()) {
                    if (!ChannelUtils.isBrandBlackShark()) {
                        if (!ChannelUtils.isBrandHuaWei() && !ChannelUtils.isBrandHonor()) {
                            if (!ChannelUtils.isEmuiOrOhosVersion()) {
                                if (ChannelUtils.isBrandMeiZu()) {
                                    TLogger.ii("OtherPushManager", "USE meizu");
                                    eVar = new com.tencent.android.tpush.d.a.d();
                                } else {
                                    if (!MTPushConstants.Manufacturer.OPPO.equals(j11) && !MTPushConstants.Manufacturer.ONEPLUS.equals(j11)) {
                                        if (!MTPushConstants.Manufacturer.REALME.equals(j11)) {
                                            if ("vivo".equals(j11)) {
                                                TLogger.ii("OtherPushManager", "USE vivo");
                                                eVar = new g();
                                            } else {
                                                TLogger.ii("OtherPushManager", "deviceType: " + j11);
                                                return null;
                                            }
                                        }
                                    }
                                    TLogger.ii("OtherPushManager", "USE oppo");
                                    eVar = new f();
                                }
                            }
                        }
                        if (ChannelUtils.isBrandHonor()) {
                            TLogger.ii("OtherPushManager", "USE honor");
                            b bVar = new b();
                            if (bVar.d(context) || ChannelUtils.isHonorNewDevice()) {
                                return bVar;
                            }
                            TLogger.ii("OtherPushManager", "USE honor isConfig return false, use huawei as substitute");
                            eVar = new c();
                        } else {
                            TLogger.ii("OtherPushManager", "USE huawei");
                            eVar = new c();
                        }
                    }
                }
                TLogger.ii("OtherPushManager", "USE xiaomi");
                eVar = new e();
            }
            return eVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String j() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    public boolean a() {
        if (f68954j == null || this.f68960p == null) {
            return false;
        }
        return f68954j.d(this.f68960p);
    }

    public void c() {
        if (f68955k != null && this.f68960p != null && f68955k.d(this.f68960p)) {
            f68955k.a(this.f68960p);
        }
    }

    public void d() {
        if (f68956l != null && this.f68960p != null && f68956l.d(this.f68960p)) {
            f68956l.a(this.f68960p);
        }
    }

    public void e() {
        if (f68954j != null && this.f68960p != null && f68954j.d(this.f68960p)) {
            f68954j.b(this.f68960p);
        }
    }

    public String f() {
        if (f68954j == null || this.f68960p == null || !f68954j.d(this.f68960p)) {
            return null;
        }
        return f68954j.c(this.f68960p);
    }

    public String g() {
        if (f68954j == null || this.f68960p == null || !f68954j.d(this.f68960p)) {
            return null;
        }
        return f68954j.f(this.f68960p);
    }

    public String h() {
        if (f68955k == null || this.f68960p == null || !f68955k.d(this.f68960p)) {
            return null;
        }
        return f68955k.c(this.f68960p);
    }

    public String i() {
        if (f68956l == null || this.f68960p == null || !f68956l.d(this.f68960p)) {
            return null;
        }
        return f68956l.c(this.f68960p);
    }

    public String k() {
        if (f68954j != null) {
            return f68954j.a();
        }
        return null;
    }

    public boolean l() {
        if (f68954j == null || this.f68960p == null) {
            return false;
        }
        if (this.f68957m == null) {
            this.f68957m = Boolean.valueOf(f68954j.d(this.f68960p));
        }
        return this.f68957m.booleanValue();
    }

    public boolean m() {
        return n() || o();
    }

    public boolean n() {
        try {
            if (f68955k == null || this.f68960p == null) {
                return false;
            }
            if (this.f68959o == null) {
                this.f68959o = Boolean.valueOf(f68955k.d(this.f68960p));
            }
            return this.f68959o.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean o() {
        try {
            if (f68956l == null || this.f68960p == null) {
                return false;
            }
            if (this.f68958n == null) {
                this.f68958n = Boolean.valueOf(f68956l.d(this.f68960p));
            }
            return this.f68958n.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void p() {
        this.f68959o = null;
        this.f68958n = null;
    }

    public void q() {
        try {
            String i11 = i();
            String h11 = h();
            boolean z11 = !j.b(i11);
            boolean z12 = !j.b(h11);
            if (!z11 || !z12) {
                if (z11) {
                    f68954j = f68956l;
                } else if (z12) {
                    f68954j = f68955k;
                } else {
                    TLogger.i("OtherPushManager", "don't have valid token");
                }
            } else if (XGPushConfig.isUseFcmFirst(this.f68960p)) {
                f68954j = f68956l;
            } else {
                f68954j = f68955k;
            }
        } catch (Throwable unused) {
        }
    }

    public static d a(Context context) {
        if (f68953i == null) {
            synchronized (d.class) {
                if (f68953i == null) {
                    f68953i = new d(context);
                }
            }
        }
        return f68953i;
    }

    public static void c(Context context, String str) {
        f68947c = str;
    }

    public static void d(Context context, String str) {
        f68948d = str;
    }

    public static void e(Context context, String str) {
        f68949e = str;
    }

    public static void f(Context context, String str) {
        f68950f = str;
    }

    public static void a(Context context, String str, String str2) {
        String str3 = "";
        try {
            str3 = SharePrefsUtil.getString(context, Constants.OTHER_PUSH_ERROR_CODE, str3);
        } catch (Throwable th2) {
            TLogger.w(str, "save returnMsg error: " + th2.getMessage());
            return;
        }
        if (!str2.equals(str3)) {
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, str2);
        }
    }

    public static void a(Context context, String str) {
        f68945a = str;
    }

    public static void a(Context context, boolean z11) {
        f68951g = Boolean.valueOf(z11);
    }

    public boolean b() {
        boolean z11 = false;
        if (!(f68954j == null || this.f68960p == null)) {
            if (f68954j.e(this.f68960p) == 8) {
                z11 = true;
            }
            if (z11) {
                TLogger.ii("OtherPushManager", "UseXgSysDevice!");
            }
        }
        return z11;
    }

    public static void b(Context context, String str) {
        f68946b = str;
    }
}
