package com.huobi.view.bubbleseekbar;

import android.content.res.Resources;
import android.util.TypedValue;
import java.util.Properties;

class BubbleUtils {
    private static final String KEY_MIUI_MANE = "ro.miui.ui.version.name";
    private static Boolean miui;
    private static Properties sProperties = new Properties();

    public static int dp2px(int i11) {
        return (int) TypedValue.applyDimension(1, (float) i11, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[SYNTHETIC, Splitter:B:21:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050 A[SYNTHETIC, Splitter:B:27:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isMIUI() {
        /*
            java.lang.Boolean r0 = miui
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.booleanValue()
            return r0
        L_0x0009:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            java.lang.String r2 = "ro.miui.ui.version.name"
            r3 = 0
            if (r0 >= r1) goto L_0x0059
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0033 }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0033 }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ IOException -> 0x0033 }
            java.lang.String r5 = "build.prop"
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x0033 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0033 }
            java.util.Properties r1 = sProperties     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            r1.load(r0)     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            r0.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x002b:
            r1 = move-exception
            r3 = r0
            goto L_0x004e
        L_0x002e:
            r1 = move-exception
            r3 = r0
            goto L_0x0034
        L_0x0031:
            r1 = move-exception
            goto L_0x004e
        L_0x0033:
            r1 = move-exception
        L_0x0034:
            r1.printStackTrace()     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x0041
            r3.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0041:
            java.util.Properties r0 = sProperties
            boolean r0 = r0.containsKey(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            miui = r0
            goto L_0x008a
        L_0x004e:
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0058:
            throw r1
        L_0x0059:
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r1 = "get"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0086 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ Exception -> 0x0086 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r5)     // Catch:{ Exception -> 0x0086 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0086 }
            r1[r7] = r2     // Catch:{ Exception -> 0x0086 }
            java.lang.Object r0 = r0.invoke(r3, r1)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0086 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0086 }
            if (r0 != 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r4 = r7
        L_0x007f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0086 }
            miui = r0     // Catch:{ Exception -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            miui = r0
        L_0x008a:
            java.lang.Boolean r0 = miui
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.bubbleseekbar.BubbleUtils.isMIUI():boolean");
    }

    public static int sp2px(int i11) {
        return (int) TypedValue.applyDimension(2, (float) i11, Resources.getSystem().getDisplayMetrics());
    }
}
