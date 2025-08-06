package dq;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huobi.permission.source.Source;
import com.tencent.android.tpush.common.Constants;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f83962b = Build.MANUFACTURER.toLowerCase();

    /* renamed from: a  reason: collision with root package name */
    public Source f83963a;

    public b(Source source) {
        this.f83963a = source;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        if (c(context, intent)) {
            return intent;
        }
        return a(context);
    }

    public static boolean c(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static Intent d(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (c(context, intent)) {
            return intent;
        }
        return b(context);
    }

    public void e(int i11) {
        Intent intent;
        if (f83962b.contains(MTPushConstants.Manufacturer.MEIZU)) {
            intent = d(this.f83963a.a());
        } else {
            intent = b(this.f83963a.a());
        }
        try {
            this.f83963a.b(intent, i11);
        } catch (Exception unused) {
            this.f83963a.b(a(this.f83963a.a()), i11);
        }
    }
}
