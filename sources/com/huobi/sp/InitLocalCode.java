package com.huobi.sp;

import android.content.Context;
import com.hbg.lib.core.util.ConfigPreferences;
import zr.a;

public class InitLocalCode implements a {
    public int a() {
        return 2;
    }

    public void b(Context context) {
        String[] strArr = {"config_local_code_string"};
        for (int i11 = 0; i11 < 1; i11++) {
            c("user_config", strArr[i11]);
        }
    }

    public final void c(String str, String str2) {
        ConfigPreferences.m(str, str2, "");
    }
}
