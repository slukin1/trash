package com.huobi.utils;

import com.alibaba.android.arouter.utils.TextUtils;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfigManager;
import com.xiaomi.mipush.sdk.Constants;

public class ReviewManger {
    public static boolean a() {
        String[] split;
        MgtConfigNumber mgtConfigNumber = MgtConfigNumber.RISK_STATUS;
        int j11 = AppConfigManager.j(mgtConfigNumber.number, "isReviewStatus", -1);
        if (j11 == -1) {
            return true;
        }
        if (j11 == 1) {
            String l11 = AppConfigManager.l(mgtConfigNumber.number, "channelID", "");
            if (!(TextUtils.c(l11) || (split = l11.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length == 0)) {
                for (String equals : split) {
                    if (ChannelUtils.a().equals(equals)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
