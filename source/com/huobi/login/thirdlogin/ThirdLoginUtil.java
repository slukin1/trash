package com.huobi.login.thirdlogin;

import android.os.Build;
import com.hbg.lib.common.utils.RomUtils;
import i6.k;

public class ThirdLoginUtil {
    public static boolean a() {
        int i11 = Build.VERSION.SDK_INT;
        boolean z11 = (i11 == 23 || i11 == 24) && RomUtils.e();
        k.f("ThirdLogin", "build version " + i11);
        k.f("ThirdLogin", "isHuaweiRom " + RomUtils.e());
        k.f("ThirdLogin", "isExclude " + z11);
        return z11;
    }
}
