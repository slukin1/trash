package com.huobi.finance.presenter;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.finance.bean.FinanceRecordItem;
import rx.functions.Func1;

public final /* synthetic */ class r2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ r2 f46085b = new r2();

    public final Object call(Object obj) {
        return ((FinanceRecordItem) obj).setTradeType(TradeType.PRO);
    }
}
