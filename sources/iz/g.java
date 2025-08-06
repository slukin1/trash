package iz;

import android.content.Context;
import androidx.core.content.ContextCompat;

public class g {
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
}
