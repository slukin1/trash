package com.huochat.community.util;

import android.app.Activity;
import android.content.Context;

public class ContextTool {
    public static boolean checkActivity(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return checkActivity((Activity) context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r4.getPackageManager().getApplicationInfo(r4.getPackageName(), 128) == null) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkContext(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch:{ Exception -> 0x0015 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x0015 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r2.getApplicationInfo(r4, r3)     // Catch:{ Exception -> 0x0015 }
            if (r4 != 0) goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            r4 = r0 ^ 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.ContextTool.checkContext(android.content.Context):boolean");
    }

    public static boolean checkActivity(Activity activity) {
        return activity != null && !activity.isFinishing() && !activity.isDestroyed();
    }
}
