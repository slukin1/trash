package ry;

import android.content.Context;
import android.os.Process;

public final class c {
    public static int a(Context context, String str) {
        return b(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int b(Context context, String str, int i11, int i12, String str2) {
        if (context.checkPermission(str, i11, i12) == -1) {
            return -1;
        }
        String b11 = a.b(str);
        if (b11 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i12);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if (a.a(context, b11, str2) != 0) {
            return -2;
        }
        return 0;
    }
}
