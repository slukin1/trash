package j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

public class f {

    public static class a {
        public static boolean a(PackageManager packageManager) {
            return packageManager.hasSystemFeature("android.hardware.fingerprint");
        }
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 23 && context != null && context.getPackageManager() != null && a.a(context.getPackageManager());
    }
}
