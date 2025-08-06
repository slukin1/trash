package com.luck.picture.lib.immersive;

import android.os.Build;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.luck.picture.lib.utils.ValueOf;
import java.util.regex.Pattern;

public class RomUtils {
    private static final String[] ROM_SAMSUNG = {Constants.REFERRER_API_SAMSUNG};
    private static final String UNKNOWN = "unknown";
    private static Integer romType;

    public static class AvailableRomType {
        public static final int ANDROID_NATIVE = 3;
        public static final int FLYME = 2;
        public static final int MIUI = 1;
        public static final int NA = 4;
    }

    private static String getBrand() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static int getFlymeVersion() {
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme")) {
            return 0;
        }
        return stringToInt(str.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(" ", "").substring(0, 1));
    }

    public static int getLightStatusBarAvailableRomType() {
        Integer num = romType;
        if (num != null) {
            return num.intValue();
        }
        if (isMIUIV6OrAbove()) {
            Integer num2 = 1;
            romType = num2;
            return num2.intValue();
        } else if (isFlymeV4OrAbove()) {
            Integer num3 = 2;
            romType = num3;
            return num3.intValue();
        } else if (isAndroid5OrAbove()) {
            Integer num4 = 3;
            romType = num4;
            return num4.intValue();
        } else {
            Integer num5 = 4;
            romType = num5;
            return num5.intValue();
        }
    }

    public static int getMIUIVersionCode() {
        String systemProperty = getSystemProperty();
        if (TextUtils.isEmpty(systemProperty)) {
            return 0;
        }
        try {
            return ValueOf.toInt(systemProperty);
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    private static String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[SYNTHETIC, Splitter:B:14:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getSystemProperty() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x003b, all -> 0x002d }
            java.lang.String r2 = "getprop ro.miui.ui.version.code"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x003b, all -> 0x002d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003b, all -> 0x002d }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003b, all -> 0x002d }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x003b, all -> 0x002d }
            r3.<init>(r1)     // Catch:{ IOException -> 0x003b, all -> 0x002d }
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch:{ IOException -> 0x003b, all -> 0x002d }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x003c, all -> 0x002b }
            r2.close()     // Catch:{ IOException -> 0x003c, all -> 0x002b }
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002a:
            return r1
        L_0x002b:
            r0 = move-exception
            goto L_0x0030
        L_0x002d:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0030:
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003a:
            throw r0
        L_0x003b:
            r2 = r0
        L_0x003c:
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.immersive.RomUtils.getSystemProperty():java.lang.String");
    }

    private static boolean isAndroid5OrAbove() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private static boolean isFlymeV4OrAbove() {
        return getFlymeVersion() >= 4;
    }

    private static boolean isMIUIV6OrAbove() {
        String systemProperty = getSystemProperty();
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        try {
            if (ValueOf.toInt(systemProperty) >= 4) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private static boolean isRightRom(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSamsung() {
        return isRightRom(getBrand(), getManufacturer(), ROM_SAMSUNG);
    }

    public static int stringToInt(String str) {
        if (Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return ValueOf.toInt(str);
        }
        return 0;
    }
}
