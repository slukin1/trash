package com.huobi.finance.model.subaccount;

import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.hbg.core.bean.GridAssetItem;
import com.hbg.lib.network.hbg.grid.bean.GridAccountConvertInfo;
import com.huobi.finance.bean.GridDataTotal;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import rx.Observable;
import v7.b;
import wk.p0;
import xk.c;
import xk.d;
import xk.v;

public class GridDataProvider implements v<GridDataTotal> {
    public static /* synthetic */ List e(Throwable th2) {
        return null;
    }

    public Observable<GridDataTotal> a(boolean z11) {
        return Observable.zip(p0.g("usdt", z11), b.a().getGridAccount().b(), b.a().getGridSymbolsAccountConvert().b().onErrorReturn(c.f61627b), new d(this));
    }

    public final GridDataTotal d(Map<String, BigDecimal> map, List<GridAssetItem> list, List<GridAccountConvertInfo> list2) {
        GridDataTotal gridDataTotal = new GridDataTotal();
        if (list != null && !list.isEmpty()) {
            BigDecimal bigDecimal = BigDecimal.ZERO;
            BigDecimal bigDecimal2 = bigDecimal;
            for (GridAssetItem next : list) {
                if (next != null) {
                    BigDecimal bigDecimal3 = map.get(StringUtils.g(next.getCurrency()));
                    bigDecimal = bigDecimal.add(m.a(next.getEstimateBalance()).multiply(bigDecimal3));
                    bigDecimal2 = bigDecimal2.add(m.a(next.getTotalProfit()).multiply(bigDecimal3));
                }
            }
            gridDataTotal.setEstimateBalance(bigDecimal.toPlainString());
            gridDataTotal.setTotalProfit(bigDecimal2.toPlainString());
        }
        if (!CollectionsUtils.b(list2)) {
            BigDecimal bigDecimal4 = BigDecimal.ZERO;
            for (GridAccountConvertInfo next2 : list2) {
                if (next2 != null) {
                    bigDecimal4 = bigDecimal4.add(m.a(next2.getTotalEstimateBtc()));
                }
            }
            gridDataTotal.setTotalEstimateBtc(bigDecimal4.toPlainString());
        }
        gridDataTotal.setConvertList(list2);
        return gridDataTotal;
    }
}
