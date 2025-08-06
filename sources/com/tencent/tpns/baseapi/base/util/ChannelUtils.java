package com.tencent.tpns.baseapi.base.util;

import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.lang.reflect.Method;

public class ChannelUtils {
    public static Boolean isBrandXiaoMi;

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, new Object[]{str});
        } catch (Exception unused) {
            TBaseLogger.w("ChannelUtils", "unexpected for getSystemPropertiesKey:" + str);
            return "";
        }
    }

    public static String getMiuiVersionCode() {
        return a("ro.miui.ui.version.code");
    }

    public static String getMiuiVersionName() {
        return a("ro.miui.ui.version.name");
    }

    public static boolean isBrandBlackShark() {
        return MTPushConstants.Manufacturer.BLACKSHARK.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandHonor() {
        return MTPushConstants.Manufacturer.HONOR.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandHuaWei() {
        return MTPushConstants.Manufacturer.HUAWEI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandMeiZu() {
        String a11 = a("ro.meizu.product.model");
        String a12 = a("ro.vendor.meizu.product.model");
        if (TextUtils.isEmpty(a11) && TextUtils.isEmpty(a12)) {
            String str = Build.BRAND;
            return MTPushConstants.Manufacturer.MEIZU.equalsIgnoreCase(str) || MTPushConstants.Manufacturer.MEIZU.equalsIgnoreCase(Build.MANUFACTURER) || "魅蓝".equalsIgnoreCase(str) || "22c4185e".equalsIgnoreCase(str);
        }
    }

    public static boolean isBrandPTAC() {
        return "ptac".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static synchronized boolean isBrandXiaoMi() {
        boolean booleanValue;
        synchronized (ChannelUtils.class) {
            if (isBrandXiaoMi == null) {
                isBrandXiaoMi = Boolean.valueOf("xiaomi".equalsIgnoreCase(Build.MANUFACTURER));
            }
            booleanValue = isBrandXiaoMi.booleanValue();
        }
        return booleanValue;
    }

    public static boolean isEmuiOrOhosVersion() {
        return !TextUtils.isEmpty(a("ro.build.version.emui")) || !TextUtils.isEmpty(a("hw_sc.build.platform.version"));
    }

    public static boolean isHonorNewDevice() {
        return isBrandHonor() && !a();
    }

    public static boolean isHonorVersionSupport() {
        String a11 = a("ro.build.version.magic");
        TBaseLogger.i("ChannelUtils", "get magicUi version: " + a11);
        return "4.0".compareToIgnoreCase(a11) <= 0;
    }

    public static boolean isMiuiV12() {
        if (!TextUtils.isEmpty(getMiuiVersionName()) && "v12".compareTo(getMiuiVersionName().toLowerCase()) <= 0) {
            return true;
        }
        return false;
    }

    private static boolean a() {
        return isBrandHonor() && !TextUtils.isEmpty(a("ro.build.version.emui"));
    }
}
