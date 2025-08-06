package uy;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.ta.a.e.h;

public class a {
    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (Exception e11) {
            h.d("", e11, new Object[0]);
            return 0;
        }
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e11) {
            h.d("", e11, new Object[0]);
            return null;
        }
    }

    public static String c(Context context) {
        PackageInfo b11 = b(context);
        return b11 != null ? b11.packageName : "";
    }

    public static String d(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean e(Context context) {
        String d11 = d(context);
        String c11 = c(context);
        if (TextUtils.isEmpty(d11) || TextUtils.isEmpty(c11) || d11.equals(c11)) {
            return true;
        }
        return false;
    }
}
