package com.tencent.qcloud.tuikit.tuichat.util;

import android.util.DisplayMetrics;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.TUIBuild;

public class DeviceUtil {
    private static String[] huaweiAndHonorDevice = {"hwH60", "hwPE", "hwH30", "hwHol", "hwG750", "hw7D", "hwChe2"};

    public static int[] getScreenSize() {
        DisplayMetrics displayMetrics = TUIConfig.getAppContext().getResources().getDisplayMetrics();
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static boolean isHuaWeiOrHonor() {
        String device = TUIBuild.getDevice();
        for (String equals : huaweiAndHonorDevice) {
            if (equals.equals(device)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVivoX21() {
        return "vivo X21".equalsIgnoreCase(TUIBuild.getModel());
    }
}
