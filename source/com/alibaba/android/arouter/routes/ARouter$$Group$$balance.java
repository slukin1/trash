package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.finance.ui.CopyTradingCurrencyHistoryActivity;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.finance.ui.UnifyWithdrawActivity;
import java.util.Map;

public class ARouter$$Group$$balance implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/balance/copyTradingTransferRecord", RouteMeta.build(routeType, CopyTradingCurrencyHistoryActivity.class, "/balance/copytradingtransferrecord", "balance", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/balance/deposit", RouteMeta.build(routeType, UnifyDepositActivity.class, "/balance/deposit", "balance", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/balance/depositSearch", RouteMeta.build(routeType, CurrencySearchActivity.class, "/balance/depositsearch", "balance", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/balance/transfer", RouteMeta.build(routeType, UnifyTransferActivity.class, "/balance/transfer", "balance", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/balance/withdraw", RouteMeta.build(routeType, UnifyWithdrawActivity.class, "/balance/withdraw", "balance", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
