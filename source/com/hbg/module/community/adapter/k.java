package com.hbg.module.community.adapter;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.module.libkt.base.ext.b;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import d7.a1;
import java.util.Locale;

public final class k {
    public static final String a(String str, boolean z11) {
        String str2;
        if (b.x(str)) {
            return RankScreenBean.SCREEN_VALUE_SPOT;
        }
        TradeType tradeType = TradeType.CONTRACT;
        if (StringsKt__StringsJVMKt.w(tradeType.toString(), str, true)) {
            str2 = tradeType.toString().toLowerCase(Locale.getDefault());
        } else if (StringsKt__StringsJVMKt.w(TradeType.SWAP.toString(), str, true)) {
            str2 = tradeType.toString().toLowerCase(Locale.getDefault());
        } else if (StringsKt__StringsJVMKt.w(TradeType.LINEAR_SWAP.toString(), str, true)) {
            str2 = tradeType.toString().toLowerCase(Locale.getDefault());
        } else if (StringsKt__StringsJVMKt.w(TradeType.MARGIN.toString(), str, true) || StringsKt__StringsJVMKt.w(TradeType.SUPERMARGIN.toString(), str, true)) {
            return HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE;
        } else {
            if (z11) {
                str2 = TradeType.GRID.toString();
            } else if (!a1.v().p0(str)) {
                return RankScreenBean.SCREEN_VALUE_SPOT;
            } else {
                str2 = "etp";
            }
        }
        return str2;
    }
}
