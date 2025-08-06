package com.hbg.lib.data.future.controller;

import com.hbg.lib.data.future.bean.FuturePriceLimitInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPriceLimitInfo;
import com.hbg.lib.network.option.core.bean.PriceLimitInfo;
import h8.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import z6.f;
import z6.g;

public class FuturePriceLimitController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, FuturePriceLimitInfo> f68838a = new HashMap();

    public static /* synthetic */ List c(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (f68838a) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                LinearSwapPriceLimitInfo linearSwapPriceLimitInfo = (LinearSwapPriceLimitInfo) it2.next();
                FuturePriceLimitInfo futurePriceLimitInfo = new FuturePriceLimitInfo();
                FuturePriceLimitInfo linearSwapConvert = futurePriceLimitInfo.linearSwapConvert(futurePriceLimitInfo, linearSwapPriceLimitInfo);
                f68838a.put(linearSwapPriceLimitInfo.getContractCode(), linearSwapConvert);
                arrayList.add(linearSwapConvert);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List d(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (f68838a) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                PriceLimitInfo priceLimitInfo = (PriceLimitInfo) it2.next();
                FuturePriceLimitInfo futurePriceLimitInfo = new FuturePriceLimitInfo();
                FuturePriceLimitInfo optionConvert = futurePriceLimitInfo.optionConvert(futurePriceLimitInfo, priceLimitInfo);
                f68838a.put(priceLimitInfo.getContractCode(), optionConvert);
                arrayList.add(optionConvert);
            }
        }
        return arrayList;
    }

    public static Observable<List<FuturePriceLimitInfo>> e(boolean z11, String str, String str2, String str3) {
        Observable<List<FuturePriceLimitInfo>> just;
        if (z11) {
            Map<String, FuturePriceLimitInfo> map = f68838a;
            if (!map.isEmpty()) {
                synchronized (map) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(map.get(str));
                    just = Observable.just(arrayList);
                }
                return just;
            }
        }
        return a.a().getPriceLimitLevel(str, str2, str3).b().map(g.f62010b);
    }

    public static Observable<List<FuturePriceLimitInfo>> f(boolean z11, String str) {
        Observable<List<FuturePriceLimitInfo>> just;
        if (z11) {
            Map<String, FuturePriceLimitInfo> map = f68838a;
            if (!map.isEmpty()) {
                synchronized (map) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(map.get(str));
                    just = Observable.just(arrayList);
                }
                return just;
            }
        }
        return p8.a.a().getPriceLimitLevel(str).b().map(f.f62009b);
    }

    public static Observable<List<FuturePriceLimitInfo>> g(boolean z11, String str, String str2, String str3, TradeType tradeType) {
        if (tradeType == TradeType.OPTION) {
            return f(z11, str);
        }
        return e(z11, str, str2, str3);
    }
}
