package com.huobi.finance.presenter;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.finance.bean.FinanceRecordItem;
import rx.functions.Func1;

public final /* synthetic */ class l6 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ l6 f45984b = new l6();

    public final Object call(Object obj) {
        return ((FinanceRecordItem) obj).setTradeType(TradeType.OTC_OPTIONS);
    }
}
