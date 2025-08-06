package com.huobi.sp;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import zr.a;

public class RemoveBTCE implements a {
    public int a() {
        return 1;
    }

    public void b(Context context) {
        String[] strArr = {"config_local_code_string", "config_local_code_string_btc", "config_local_code_string_ltc", "config_negative_code_string"};
        for (int i11 = 0; i11 < 4; i11++) {
            c("user_config", strArr[i11]);
        }
    }

    public final void c(String str, String str2) {
        String d11 = ConfigPreferences.d(str, str2);
        if (!TextUtils.isEmpty(d11)) {
            ConfigPreferences.m(str, str2, d11.replace("btc-ebtc,", "").replace("btc-ebtc", "").replace("btc-eltc,", "").replace("btc-eltc", ""));
        }
    }
}
