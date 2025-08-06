package ry;

import android.content.Context;
import android.os.Build;
import com.luck.picture.lib.permissions.PermissionConfig;
import uy.a;

public class d {
    public static boolean a(Context context) {
        try {
            return b(context, PermissionConfig.WRITE_EXTERNAL_STORAGE);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        if (context == null) {
            return false;
        }
        int a11 = a.a(context);
        if (Build.VERSION.SDK_INT >= 23) {
            if (a11 >= 23) {
                if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            } else if (c.a(context, str) != 0) {
                return false;
            }
        } else if (c.a(context, str) != 0) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        try {
            return b(context, "android.permission.READ_PHONE_STATE");
        } catch (Throwable unused) {
            return false;
        }
    }
}
