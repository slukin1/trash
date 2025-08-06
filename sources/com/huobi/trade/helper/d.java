package com.huobi.trade.helper;

import com.hbg.lib.data.symbol.TradeType;
import java.util.HashMap;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static Map<TradeType, Boolean> f82024a = new HashMap();

    public static boolean a(TradeType tradeType) {
        Boolean bool = f82024a.get(tradeType);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static boolean b(TradeType tradeType) {
        return f82024a.containsKey(tradeType);
    }

    public static void c(TradeType tradeType) {
        f82024a.remove(tradeType);
    }

    public static void d(TradeType tradeType, boolean z11) {
        f82024a.put(tradeType, Boolean.valueOf(z11));
    }
}
