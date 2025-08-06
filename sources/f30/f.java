package f30;

import android.content.Context;
import androidx.core.content.ContextCompat;

public class f {
    public static boolean a(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length > 0) {
                for (String equals : strArr) {
                    if (equals.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static boolean c(Context context, String... strArr) {
        if (context == null || strArr == null) {
            return true;
        }
        for (String checkSelfPermission : strArr) {
            if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }
}
