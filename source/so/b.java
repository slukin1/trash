package so;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.huobi.app.JumpActivity;
import com.huobi.index.bean.IndexFeatureItem;
import p0.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f84866a = 10001;

    public static void a(Activity activity) {
        if (activity != null) {
            try {
                Intent intent = new Intent();
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 26) {
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
                } else if (i11 >= 21) {
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("app_package", activity.getPackageName());
                    intent.putExtra("app_uid", activity.getApplicationInfo().uid);
                } else if (i11 >= 9) {
                    intent.addFlags(268435456);
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
                } else {
                    intent.addFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                    intent.putExtra("com.android.settings.ApplicationPkgName", activity.getPackageName());
                }
                activity.startActivity(intent);
            } catch (Exception unused) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
                activity.startActivity(intent2);
            }
        }
    }

    public static boolean b(Context context) {
        try {
            return m.d(context).a();
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static void c(Context context, String str, String str2, IndexFeatureItem indexFeatureItem) {
        if (context != null) {
            Intent nf2 = JumpActivity.nf(context, indexFeatureItem);
            a aVar = new a(context);
            int i11 = f84866a + 1;
            f84866a = i11;
            aVar.e(i11, str, str2, nf2);
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(activity, "android.permission.POST_NOTIFICATIONS") != -1) {
                return;
            }
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.POST_NOTIFICATIONS")) {
                a(activity);
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 100);
            }
        } else if (!m.d(activity).a()) {
            a(activity);
        }
    }
}
