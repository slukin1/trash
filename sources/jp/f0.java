package jp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.ui.OtcAliCertificateActivity;
import nb.c;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static f0 f84330a = new f0();

    public static f0 a() {
        return f84330a;
    }

    public void b(Activity activity, boolean z11) {
        if (activity != null) {
            if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l(activity, (Intent) null, (Intent) null);
            } else if (OtcModuleConfig.a().D()) {
                c.h(activity, OtcModuleConfig.a().x(), z11);
            } else {
                e(activity);
            }
        }
    }

    public void c(Context context, boolean z11) {
        if (context != null) {
            if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l((Activity) context, (Intent) null, (Intent) null);
            } else if (OtcModuleConfig.a().D()) {
                Intent intent = new Intent();
                intent.putExtra("OTC_KYC_PRO", z11);
                OtcModuleConfig.b().v(context, intent);
            } else {
                e(context);
            }
        }
    }

    public void d(Context context, boolean z11, boolean z12) {
        if (context != null) {
            if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l((Activity) context, (Intent) null, (Intent) null);
            } else if (OtcModuleConfig.a().D()) {
                OtcAliCertificateActivity.gg(context, z11, z12);
            } else {
                e(context);
            }
        }
    }

    public void e(Context context) {
        if (context != null) {
            if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l((Activity) context, (Intent) null, (Intent) null);
                return;
            }
            OtcModuleConfig.a().B(context, new Intent());
        }
    }
}
