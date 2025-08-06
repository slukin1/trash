package com.huobi.copytrading.ui;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import d10.l;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import rx.Observable;

public final class CopyTradingTradeFragment$onActivityResume$1 extends Lambda implements l<Long, Observable<? extends List<FutureContractInfo>>> {
    public static final CopyTradingTradeFragment$onActivityResume$1 INSTANCE = new CopyTradingTradeFragment$onActivityResume$1();

    public CopyTradingTradeFragment$onActivityResume$1() {
        super(1);
    }

    public final Observable<? extends List<FutureContractInfo>> invoke(Long l11) {
        return FutureContractInfoController.n().i(TradeType.LINEAR_SWAP, false);
    }
}
