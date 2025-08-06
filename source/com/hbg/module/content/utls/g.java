package com.hbg.module.content.utls;

import android.content.Context;
import android.os.Bundle;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.router.HbgRouter;
import d7.a1;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f18913a = new g();

    public final void a(Context context, String str, boolean z11, TradeType tradeType, String str2) {
        b(context, str, z11, false, tradeType, str2);
    }

    public final void b(Context context, String str, boolean z11, boolean z12, TradeType tradeType, String str2) {
        Bundle bundle = new Bundle();
        String X = a1.v().X(str, tradeType);
        bundle.putString("symbolId", str);
        bundle.putString("from", str2);
        bundle.getBoolean("market_is_hadax", a1.v().N(X));
        bundle.getBoolean("market_is_st", a1.v().T(X));
        bundle.putString("market_title", X);
        bundle.putString("market_trade_type", tradeType.toString());
        HbgRouter.i(context, "/kline/index", bundle);
    }
}
