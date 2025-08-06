package com.huobi.finance.model.subaccount;

import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.bean.FutureProductInfo;
import com.hbg.lib.data.future.bean.FutureUserInfo;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.contract.entity.OptionBalanceItem;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.OptionDataTotal;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p8.a;
import rx.Observable;
import rx.schedulers.Schedulers;
import xk.b;
import xk.q;
import xk.r;
import xk.s;
import xk.t;
import z6.l;

public class OptionDataProvider extends b<OptionDataTotal, OptionBalanceItem, FutureProductInfo, FutureUserInfo> {
    /* access modifiers changed from: private */
    public /* synthetic */ Observable p(Throwable th2) {
        if (o(th2)) {
            return Observable.just(null);
        }
        return Observable.error(th2);
    }

    public static /* synthetic */ OptionDataTotal q(List list) {
        OptionDataTotal optionDataTotal = new OptionDataTotal();
        optionDataTotal.setOptionAccountInfoList(list);
        return optionDataTotal;
    }

    public static /* synthetic */ int r(OptionBalanceItem optionBalanceItem, OptionBalanceItem optionBalanceItem2) {
        double d11;
        double d12 = 0.0d;
        try {
            d11 = m.h0(optionBalanceItem2.getEstimateAmount());
            try {
                d12 = m.h0(optionBalanceItem.getEstimateAmount());
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return Double.compare(d11, d12);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            d11 = 0.0d;
            e.printStackTrace();
            return Double.compare(d11, d12);
        }
        return Double.compare(d11, d12);
    }

    public static /* synthetic */ List s(Throwable th2) {
        return null;
    }

    public /* bridge */ /* synthetic */ Observable a(boolean z11) {
        return super.a(z11);
    }

    public Observable<OptionDataTotal> d() {
        return a.a().z((String) null, "usdt".toUpperCase(Locale.US)).b().subscribeOn(Schedulers.io()).onErrorResumeNext(new r(this)).map(t.f61647b);
    }

    public Comparator<OptionBalanceItem> e() {
        if (this.f48082a == null) {
            this.f48082a = q.f61644b;
        }
        return this.f48082a;
    }

    public Observable<List<FutureProductInfo>> f(boolean z11) {
        return FutureProductInfoController.d().h(z11).onErrorReturn(s.f61646b);
    }

    public Observable<FutureUserInfo> g(boolean z11) {
        return l.c().e(z11).subscribeOn(Schedulers.io());
    }

    /* renamed from: n */
    public void c(OptionDataTotal optionDataTotal, List<FutureProductInfo> list, Map<String, BigDecimal> map, Comparator<OptionBalanceItem> comparator, FutureUserInfo futureUserInfo) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        List<OptionAccountInfo> optionAccountInfoList = optionDataTotal.getOptionAccountInfoList();
        boolean z11 = false;
        boolean z12 = optionAccountInfoList == null || optionAccountInfoList.isEmpty();
        if (!(futureUserInfo == null || 1 == futureUserInfo.getActiveState())) {
            z11 = true;
        }
        ArrayList arrayList = new ArrayList();
        if (!z12 && !z11) {
            for (OptionAccountInfo next : optionAccountInfoList) {
                if (!(next == null || next.getSymbol() == null)) {
                    OptionBalanceItem optionBalanceItem = new OptionBalanceItem(next);
                    String g11 = StringUtils.g(next.getSymbol());
                    if (g11.equalsIgnoreCase(this.f48083b)) {
                        String marginBalance = next.getMarginBalance();
                        optionBalanceItem.setEstimateAmountToBtc(marginBalance);
                        bigDecimal = bigDecimal.add(m.a(marginBalance));
                    } else if (map.containsKey(g11)) {
                        BigDecimal bigDecimal2 = map.get(g11);
                        BigDecimal bigDecimal3 = new BigDecimal(next.getMarginBalance());
                        if (bigDecimal2 != null) {
                            String plainString = bigDecimal2.multiply(bigDecimal3).toPlainString();
                            optionBalanceItem.setEstimateAmountToBtc(plainString);
                            bigDecimal = bigDecimal.add(m.a(plainString));
                        }
                    }
                    optionBalanceItem.setEstimateAmount(m.a(LegalCurrencyConfigUtil.G(next.getMarginBalance(), optionBalanceItem.getCurrency(), TradeType.PRO)).toPlainString());
                    arrayList.add(optionBalanceItem);
                }
            }
            Collections.sort(arrayList, comparator);
        } else if (list != null && !list.isEmpty()) {
            if (optionAccountInfoList == null) {
                optionAccountInfoList = new ArrayList<>();
            }
            for (FutureProductInfo next2 : list) {
                if (next2 != null) {
                    OptionAccountInfo optionAccountInfo = new OptionAccountInfo();
                    optionAccountInfo.setSymbol(next2.getSymbol());
                    optionAccountInfoList.add(optionAccountInfo);
                    arrayList.add(new OptionBalanceItem(optionAccountInfo));
                }
            }
        }
        optionDataTotal.setNetAssetToBtc(bigDecimal.toPlainString());
        optionDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        if (optionAccountInfoList == null) {
            arrayList = new ArrayList();
        }
        optionDataTotal.setDetailInfos(arrayList);
    }

    public final boolean o(Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException) || 1220 != m.k0(((APIStatusErrorException) th2).getErrCode())) {
            return false;
        }
        return true;
    }
}
