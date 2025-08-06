package com.hbg.lib.data.future.util;

import android.text.TextUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.xiaomi.mipush.sdk.Constants;

public class FutureTypeUtil {
    public static TradeType a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return TradeType.OPTION;
        }
        if (TextUtils.isEmpty(str2)) {
            return TradeType.CONTRACT;
        }
        if (str2.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length <= 1) {
                return TradeType.LINEAR_SWAP;
            }
            String str4 = split[1];
            if (TextUtils.isEmpty(str4) || !str4.equalsIgnoreCase("USD")) {
                return TradeType.LINEAR_SWAP;
            }
            return TradeType.SWAP;
        } else if (str2.contains("_")) {
            return TradeType.CONTRACT;
        } else {
            return TradeType.CONTRACT;
        }
    }
}
