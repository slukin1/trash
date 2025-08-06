package com.huobi.finance.model.subaccount;

import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.MiningMarketInfo;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.MiningDataTotal;
import com.huobi.utils.SymbolUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import rx.Observable;
import v7.b;
import wk.p0;
import xk.j;
import xk.k;
import xk.l;
import xk.m;
import xk.v;

public class MiningDataProvider implements v<MiningDataTotal> {
    public static /* synthetic */ List g(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List h(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List i(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ MiningDataTotal j(List list, List list2, List list3, Map map) {
        MiningDataTotal miningDataTotal = new MiningDataTotal();
        k(list, map, miningDataTotal);
        miningDataTotal.setActiveList(list2);
        miningDataTotal.setFixedList(list3);
        return miningDataTotal;
    }

    public Observable<MiningDataTotal> a(boolean z11) {
        return Observable.zip(b.a().getMiningAssetMarket().b().onErrorReturn(l.f61636b), b.a().getMiningItemList(0).b().onErrorReturn(k.f61635b), b.a().getMiningItemList(1).b().onErrorReturn(j.f61634b), p0.g(SymbolUtil.d(), z11), new m(this));
    }

    public final String f(BigDecimal bigDecimal) {
        if ("btc".equals(LegalCurrencyConfigUtil.d())) {
            return i6.m.u0(bigDecimal.toPlainString(), 12, 8);
        }
        return LegalCurrencyConfigUtil.D(i6.m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO);
    }

    public final void k(List<MiningMarketInfo> list, Map<String, BigDecimal> map, MiningDataTotal miningDataTotal) {
        BigDecimal bigDecimal;
        if (list != null && !list.isEmpty()) {
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            BigDecimal bigDecimal3 = bigDecimal2;
            for (MiningMarketInfo next : list) {
                String g11 = StringUtils.g(next.getDigitalCurrency());
                if (map.containsKey(g11) && (bigDecimal = map.get(g11)) != null) {
                    bigDecimal2 = bigDecimal2.add(bigDecimal.multiply(i6.m.a(next.getDigitalAssetTotalAmount())));
                    bigDecimal3 = bigDecimal3.add(bigDecimal.multiply(i6.m.a(next.getDigitalIncomeTotalAmount())));
                }
            }
            miningDataTotal.setNetAssetToBtc(bigDecimal2.toPlainString());
            miningDataTotal.setNetAsset(f(bigDecimal2));
            miningDataTotal.setProfitAmount(bigDecimal3.toPlainString());
            miningDataTotal.setProfitAmountLegal(f(bigDecimal3));
        }
    }
}
