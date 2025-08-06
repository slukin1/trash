package com.huobi.asset.feature.account.spot;

import al.p;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import dt.h2;
import hh.f;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oh.d;
import oh.e;
import oh.h;
import rx.Observable;
import u6.g;
import uh.i;
import v7.b;
import wk.p0;

public class SpotAccountConfig implements f.a<BalanceDataTotal> {
    public static /* synthetic */ YbbUserAssetInfoData j(YbbUserAssetInfoData ybbUserAssetInfoData) {
        HashMap hashMap = new HashMap();
        for (YbbUserAssetInfoData.DetailsDTO next : ybbUserAssetInfoData.getDetails()) {
            hashMap.put(StringUtils.g(next.getDigitalCurrency()), next);
        }
        ybbUserAssetInfoData.setCurrencyItemMap(hashMap);
        return ybbUserAssetInfoData;
    }

    public static /* synthetic */ List k(Throwable th2) {
        return new ArrayList();
    }

    public static /* synthetic */ Boolean l(Boolean bool) {
        i.d().n(!bool.booleanValue() && i.d().h());
        return bool;
    }

    public static /* synthetic */ BalanceDataTotal n(BalanceDataTotal balanceDataTotal, YbbUserAssetInfoData ybbUserAssetInfoData, List list, Boolean bool, Map map) {
        balanceDataTotal.setYbbAsset(ybbUserAssetInfoData);
        List<? extends BaseAssetInfo> detailInfos = balanceDataTotal.getDetailInfos();
        Map<String, YbbUserAssetInfoData.DetailsDTO> currencyItemMap = ybbUserAssetInfoData.getCurrencyItemMap();
        for (BaseAssetInfo baseAssetInfo : detailInfos) {
            BalanceDetailInfo balanceDetailInfo = (BalanceDetailInfo) baseAssetInfo;
            String g11 = StringUtils.g(balanceDetailInfo.getCurrency());
            YbbUserAssetInfoData.DetailsDTO detailsDTO = currencyItemMap.get(g11);
            if (detailsDTO == null && list.contains(g11)) {
                detailsDTO = new YbbUserAssetInfoData.DetailsDTO("0", "0", "0", "0", "0");
            }
            balanceDetailInfo.setYbbAsset(detailsDTO);
            if (detailsDTO != null) {
                String j11 = p.j(m.a(balanceDetailInfo.getAvaialAble()).add(m.a(balanceDetailInfo.getOnOrders())).add(m.a(balanceDetailInfo.getLock())).add(m.a(detailsDTO.getDigitalAssetTotalAmount())).toPlainString(), g11);
                balanceDetailInfo.setHoldingsNum(j11);
                BigDecimal bigDecimal = (BigDecimal) map.get(g11);
                if (bigDecimal == null) {
                    bigDecimal = BigDecimal.ZERO;
                }
                balanceDetailInfo.setEstimateAmountToBtc(m.a(j11).multiply(bigDecimal).toPlainString());
                balanceDetailInfo.setEstimateAmount(LegalCurrencyConfigUtil.E(g11, j11));
            }
        }
        Collections.sort(detailInfos, h2.t1().e1());
        return balanceDataTotal;
    }

    public Fragment a() {
        return new AssetSpotFragment();
    }

    public Observable<BalanceDataTotal> b() {
        return Observable.zip(AssetDataCacheManager.k0().q0(), b.a().W0("").b().map(d.f58857b), b.a().getYbbCurrencies().b().flatMap(ad.i.f3526b).map(oh.f.f58859b).toList().onErrorReturn(h.f58861b), b.a().getYbbSwitch().b().compose(RxJavaHelper.t((g) null)).map(e.f58858b).onErrorReturn(oh.g.f58860b), p0.g("btc", true), oh.i.f58862b);
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.n_spot);
    }

    public AssetAccountType d() {
        return AssetAccountType.SPOT;
    }

    public int getPriority() {
        return 100;
    }
}
