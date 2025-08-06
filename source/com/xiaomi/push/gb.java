package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ah;
import java.io.File;

public class gb implements XMPushService.n {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f51891a = false;

    /* renamed from: a  reason: collision with other field name */
    private int f2899a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2900a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f51892b;

    public gb(Context context) {
        this.f2900a = context;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2721a() {
        a(this.f2900a);
        if (this.f51892b && a()) {
            b.a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            gf a11 = ge.a(this.f2900a).a();
            if (!a(a11)) {
                b.a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            f51891a = true;
            gc.a(this.f2900a, a11);
        }
    }

    private void a(Context context) {
        this.f51892b = ah.a(context).a(gl.TinyDataUploadSwitch.a(), true);
        int a11 = ah.a(context).a(gl.TinyDataUploadFrequency.a(), 7200);
        this.f2899a = a11;
        this.f2899a = Math.max(60, a11);
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f2900a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1)) > ((long) this.f2899a);
    }

    private boolean a(gf gfVar) {
        if (!av.a(this.f2900a) || gfVar == null || TextUtils.isEmpty(a(this.f2900a.getPackageName())) || !new File(this.f2900a.getFilesDir(), "tiny_data.data").exists() || f51891a) {
            return false;
        }
        if (!ah.a(this.f2900a).a(gl.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.a(this.f2900a) || i.b(this.f2900a)) {
            return true;
        }
        return false;
    }

    private String a(String str) {
        if ("com.xiaomi.xmsf".equals(str)) {
            return "1000271";
        }
        return this.f2900a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, (String) null);
    }

    public static void a(boolean z11) {
        f51891a = z11;
    }
}
