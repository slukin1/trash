package com.hbg.lib.common.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

public class FloatWindowUtil {
    public static boolean a(Context context) {
        if (!b(context)) {
            try {
                Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get((Object) null).toString());
                intent.setFlags(268435456);
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);
                return true;
            } catch (Exception unused) {
                Toast.makeText(context, "进入设置页面失败，请手动设置", 1).show();
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            return Settings.canDrawOverlays(context);
        }
        if (i11 >= 19) {
            return c(context);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r2 = r1.getClass();
        r5 = java.lang.Integer.TYPE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = "appops"
            java.lang.Object r1 = r8.getSystemService(r1)     // Catch:{ Exception -> 0x0053 }
            if (r1 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.Class r2 = r1.getClass()     // Catch:{ Exception -> 0x0053 }
            r3 = 3
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0053 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0053 }
            r4[r0] = r5     // Catch:{ Exception -> 0x0053 }
            r6 = 1
            r4[r6] = r5     // Catch:{ Exception -> 0x0053 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r7 = 2
            r4[r7] = r5     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = "checkOp"
            java.lang.reflect.Method r2 = r2.getMethod(r5, r4)     // Catch:{ Exception -> 0x0053 }
            if (r2 != 0) goto L_0x0026
            return r0
        L_0x0026:
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0053 }
            r4 = 24
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0053 }
            r3[r0] = r4     // Catch:{ Exception -> 0x0053 }
            int r4 = android.os.Binder.getCallingUid()     // Catch:{ Exception -> 0x0053 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0053 }
            r3[r6] = r4     // Catch:{ Exception -> 0x0053 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x0053 }
            r3[r7] = r8     // Catch:{ Exception -> 0x0053 }
            java.lang.Object r8 = r2.invoke(r1, r3)     // Catch:{ Exception -> 0x0053 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x0053 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0053 }
            if (r8 == 0) goto L_0x0052
            boolean r8 = com.hbg.lib.common.utils.RomUtils.d()     // Catch:{ Exception -> 0x0053 }
            if (r8 != 0) goto L_0x0053
        L_0x0052:
            r0 = r6
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.FloatWindowUtil.c(android.content.Context):boolean");
    }
}
