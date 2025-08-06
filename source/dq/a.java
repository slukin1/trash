package dq;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huobi.permission.source.Source;
import com.tencent.android.tpush.common.Constants;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f83960b = Build.MANUFACTURER.toLowerCase();

    /* renamed from: a  reason: collision with root package name */
    public Source f83961a;

    public a(Source source) {
        this.f83961a = source;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    public static boolean b(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public final Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (b(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        if (b(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        if (b(context, intent)) {
            return intent;
        }
        return a(context);
    }

    public final Intent d(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        if (b(context, intent)) {
            return intent;
        }
        return a(context);
    }

    public final Intent e(Context context) {
        Intent intent = new Intent();
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (b(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (b(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (b(context, intent)) {
            return intent;
        }
        return a(context);
    }

    public void f(int i11) {
        Intent intent;
        String str = f83960b;
        if (str.contains(MTPushConstants.Manufacturer.HUAWEI)) {
            intent = c(this.f83961a.a());
        } else if (str.contains("xiaomi")) {
            intent = h(this.f83961a.a());
        } else if (str.contains(MTPushConstants.Manufacturer.OPPO)) {
            intent = e(this.f83961a.a());
        } else if (str.contains("vivo")) {
            intent = g(this.f83961a.a());
        } else if (str.contains(MTPushConstants.Manufacturer.MEIZU)) {
            intent = d(this.f83961a.a());
        } else {
            intent = a(this.f83961a.a());
        }
        try {
            this.f83961a.b(intent, i11);
        } catch (Exception unused) {
            this.f83961a.b(a(this.f83961a.a()), i11);
        }
    }

    public final Intent g(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra("packagename", context.getPackageName());
        if (b(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (b(context, intent)) {
            return intent;
        }
        return a(context);
    }

    public final Intent h(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (b(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (b(context, intent)) {
            return intent;
        }
        return a(context);
    }
}
