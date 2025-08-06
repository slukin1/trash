package j;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;

public class e {

    public static class a {
        public static boolean a(KeyguardManager keyguardManager) {
            return keyguardManager.isKeyguardSecure();
        }
    }

    public static class b {
        public static KeyguardManager a(Context context) {
            return (KeyguardManager) context.getSystemService(KeyguardManager.class);
        }

        public static boolean b(KeyguardManager keyguardManager) {
            return keyguardManager.isDeviceSecure();
        }
    }

    public static KeyguardManager a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(context);
        }
        Object systemService = context.getSystemService("keyguard");
        if (systemService instanceof KeyguardManager) {
            return (KeyguardManager) systemService;
        }
        return null;
    }

    public static boolean b(Context context) {
        KeyguardManager a11 = a(context);
        if (a11 == null) {
            return false;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            return b.b(a11);
        }
        if (i11 >= 16) {
            return a.a(a11);
        }
        return false;
    }
}
