package com.huochat.community.util;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NBDeviceHelper {
    private static final String BRAND = Build.BRAND.toLowerCase();
    private static final String ESSENTIAL = "essential";
    private static final String FLYME = "flyme";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String[] MEIZUBOARD = {"m9", "M9", "mx", "MX"};
    private static final String TAG = "NBDeviceHelper";
    private static final String ZTEC2016 = "zte c2016";
    private static final String ZUKZ1 = "zuk z1";
    private static String sFlymeVersionName;
    private static boolean sIsTabletChecked = false;
    private static boolean sIsTabletValue = false;
    private static String sMiuiVersionName;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065 A[SYNTHETIC, Splitter:B:18:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d A[SYNTHETIC, Splitter:B:23:0x006d] */
    static {
        /*
            java.lang.String r0 = "m9"
            java.lang.String r1 = "M9"
            java.lang.String r2 = "mx"
            java.lang.String r3 = "MX"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2, r3}
            MEIZUBOARD = r0
            r0 = 0
            sIsTabletChecked = r0
            sIsTabletValue = r0
            java.lang.String r1 = android.os.Build.BRAND
            java.lang.String r1 = r1.toLowerCase()
            BRAND = r1
            java.util.Properties r1 = new java.util.Properties
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 >= r3) goto L_0x0076
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.io.File r5 = android.os.Environment.getRootDirectory()     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.lang.String r6 = "build.prop"
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r1.load(r3)     // Catch:{ Exception -> 0x0043 }
            r3.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0076
        L_0x003e:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x0076
        L_0x0043:
            r2 = move-exception
            goto L_0x004b
        L_0x0045:
            r0 = move-exception
            goto L_0x006b
        L_0x0047:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
        L_0x004b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = "NBDeviceHelper: "
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0069 }
            r4.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0069 }
            i6.d.d(r2)     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x0076
            r3.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0076
        L_0x0069:
            r0 = move-exception
            r2 = r3
        L_0x006b:
            if (r2 == 0) goto L_0x0075
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0075:
            throw r0
        L_0x0076:
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x009a }
            java.lang.String r3 = "get"
            r4 = 1
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x009a }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ Exception -> 0x009a }
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x009a }
            java.lang.String r2 = "ro.miui.ui.version.name"
            java.lang.String r2 = getLowerCaseName(r1, r0, r2)     // Catch:{ Exception -> 0x009a }
            sMiuiVersionName = r2     // Catch:{ Exception -> 0x009a }
            java.lang.String r2 = "ro.build.display.id"
            java.lang.String r0 = getLowerCaseName(r1, r0, r2)     // Catch:{ Exception -> 0x009a }
            sFlymeVersionName = r0     // Catch:{ Exception -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.NBDeviceHelper.<clinit>():void");
    }

    private static boolean _isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    @TargetApi(19)
    private static boolean checkOp(Context context, int i11) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class<?> cls = appOpsManager.getClass();
                Class cls2 = Integer.TYPE;
                if (((Integer) cls.getDeclaredMethod("checkOp", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(i11), Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    private static String getLowerCaseName(Properties properties, Method method, String str) {
        String property = properties.getProperty(str);
        if (property == null) {
            try {
                property = (String) method.invoke((Object) null, new Object[]{str});
            } catch (Exception unused) {
            }
        }
        return property != null ? property.toLowerCase() : property;
    }

    public static boolean isEssentialPhone() {
        return BRAND.contains(ESSENTIAL);
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return checkOp(context, 24);
        }
        try {
            if ((context.getApplicationInfo().flags & 134217728) == 134217728) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean isFlyme() {
        return !TextUtils.isEmpty(sFlymeVersionName) && sFlymeVersionName.contains(FLYME);
    }

    public static boolean isFlymeVersionHigher5_2_4() {
        boolean z11;
        String group;
        String str = sFlymeVersionName;
        if (str != null && !str.equals("")) {
            Matcher matcher = Pattern.compile("(\\d+\\.){2}\\d").matcher(sFlymeVersionName);
            if (matcher.find() && (group = matcher.group()) != null && !group.equals("")) {
                String[] split = group.split("\\.");
                if (split.length == 3) {
                    if (Integer.valueOf(split[0]).intValue() >= 5) {
                        if (Integer.valueOf(split[0]).intValue() <= 5) {
                            if (Integer.valueOf(split[1]).intValue() >= 2) {
                                if (Integer.valueOf(split[1]).intValue() <= 2) {
                                    if (Integer.valueOf(split[2]).intValue() >= 4) {
                                        int intValue = Integer.valueOf(split[2]).intValue();
                                    }
                                }
                            }
                        }
                    }
                    z11 = false;
                    if (!isMeizu() && z11) {
                        return true;
                    }
                }
            }
        }
        z11 = true;
        return !isMeizu() ? false : false;
    }

    public static boolean isHuawei() {
        String str = BRAND;
        return str.contains(MTPushConstants.Manufacturer.HUAWEI) || str.contains(MTPushConstants.Manufacturer.HONOR);
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(sMiuiVersionName);
    }

    public static boolean isMIUIV5() {
        return "v5".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV6() {
        return "v6".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV7() {
        return "v7".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV8() {
        return "v8".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV9() {
        return "v9".equals(sMiuiVersionName);
    }

    public static boolean isMeizu() {
        return isPhone(MEIZUBOARD) || isFlyme();
    }

    public static boolean isOppo() {
        return BRAND.contains(MTPushConstants.Manufacturer.OPPO);
    }

    private static boolean isPhone(String[] strArr) {
        String str = Build.BOARD;
        if (str == null) {
            return false;
        }
        for (String equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTablet(Context context) {
        if (sIsTabletChecked) {
            return sIsTabletValue;
        }
        boolean _isTablet = _isTablet(context);
        sIsTabletValue = _isTablet;
        sIsTabletChecked = true;
        return _isTablet;
    }

    public static boolean isVivo() {
        String str = BRAND;
        return str.contains("vivo") || str.contains("bbk");
    }

    public static boolean isXiaomi() {
        return Build.MANUFACTURER.toLowerCase().equals("xiaomi");
    }

    public static boolean isZTKC2016() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains(ZTEC2016);
    }

    public static boolean isZUKZ1() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains(ZUKZ1);
    }
}
