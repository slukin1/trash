package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.hbg.lib.network.pro.core.util.Period;
import com.zx.sdk.api.PermissionCallback;
import com.zx.sdk.api.ZXID;
import com.zx.sdk.api.ZXIDListener;
import com.zx.sdk.api.ZXManager;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/geetest/captcha/utils/ZxIdUtils;", "", "()V", "TAG", "", "get", "", "context", "Landroid/content/Context;", "getZxID", "isZxIDAvailable", "", "start", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class ai {

    /* renamed from: a  reason: collision with root package name */
    public static final ai f65191a = new ai();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/geetest/captcha/utils/ZxIdUtils$get$1", "Lcom/zx/sdk/api/ZXIDListener;", "onFailed", "", "code", "", "msg", "", "onSuccess", "zxid", "Lcom/zx/sdk/api/ZXID;", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a implements ZXIDListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f65192a;

        public a(Context context) {
            this.f65192a = context;
        }

        public final void onFailed(int i11, String str) {
            ag agVar = ag.f65177a;
            ag.a("ZxIdUtils", "ZxID onFailed code: " + i11 + ", msg: " + str);
        }

        public final void onSuccess(ZXID zxid) {
            ag agVar = ag.f65177a;
            ag.a("ZxIdUtils", "ZxID success: " + zxid.getValue());
            try {
                SharedPreferences.Editor edit = this.f65192a.getSharedPreferences("gt_zid_sp", 0).edit();
                edit.putLong("gt_zid_et", zxid.getExpiredTime());
                edit.putString("gt_zid", zxid.getValue());
                edit.apply();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/geetest/captcha/utils/ZxIdUtils$start$1", "Lcom/zx/sdk/api/PermissionCallback;", "onAuthorized", "", "onUnauthorized", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class b implements PermissionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f65193a;

        public b(Context context) {
            this.f65193a = context;
        }

        public final void onAuthorized() {
            ag agVar = ag.f65177a;
            ag.a("ZxIdUtils", "ZxID checkPermission: onAuthorized");
            ai aiVar = ai.f65191a;
            ZXManager.getZXID(new a(this.f65193a));
        }

        public final void onUnauthorized() {
            ag agVar = ag.f65177a;
            ag.a("ZxIdUtils", "ZxID checkPermission: onUnauthorized");
        }
    }

    private ai() {
    }

    private static boolean a() {
        try {
            Class.forName("com.zx.sdk.api.ZXManager");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void c(Context context) {
        ZXManager.init(context);
        ZXManager.setDebug(false);
        ZXManager.setEnable(true);
        ZXManager.allowPermissionDialog(false);
        if (context != null) {
            ZXManager.checkPermission((Activity) context, new b(context));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }

    public static String a(Context context) {
        try {
            if (a()) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("gt_zid_sp", 0);
                String string = sharedPreferences.getString("gt_zid", (String) null);
                long j11 = sharedPreferences.getLong("gt_zid_et", 0);
                if (string == null || !(!StringsKt__StringsJVMKt.z(string)) || j11 <= 0) {
                    c(context);
                } else {
                    if (j11 - System.currentTimeMillis() < Period.DAY_MILLS) {
                        c(context);
                    }
                    return string;
                }
            }
            return "unknown";
        } catch (Exception e11) {
            e11.printStackTrace();
            return "unknown";
        }
    }
}
