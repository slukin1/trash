package com.huobi.finance.utils;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.BigDecimal;

public class AssetNumberUtil {
    public static String a(String str, int i11) {
        String m11 = m.m(str, i11);
        boolean z11 = false;
        if (!TextUtils.isEmpty(m11)) {
            try {
                if (new BigDecimal(str).compareTo(BigDecimal.ZERO) < 0 && !Constants.ACCEPT_TIME_SEPARATOR_SERVER.equals(m11.substring(0, 1))) {
                    z11 = true;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        if (!z11) {
            return m11;
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + m11;
    }
}
