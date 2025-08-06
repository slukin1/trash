package com.huobi.currencyconfig.helper;

import com.huobi.currencyconfig.bean.StableCoinCreate;
import com.huobi.currencyconfig.bean.StableCoinHints;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import java.util.List;
import java.util.Map;
import jj.f;
import jj.g;
import jj.h;
import jj.i;
import jj.j;
import rx.Observable;
import x8.a;

public class StableCurrencyRateConfigImpl implements f {

    /* renamed from: a  reason: collision with root package name */
    public List<StableCurrencyRateBean.StableCurrencyBean> f43754a = null;

    /* renamed from: b  reason: collision with root package name */
    public StableCurrencyRateBean.TradeCurrencyBean f43755b = null;

    /* renamed from: c  reason: collision with root package name */
    public List<StableCoinHints> f43756c = null;

    /* access modifiers changed from: private */
    public /* synthetic */ List k(List list) {
        this.f43756c = list;
        return list;
    }

    public static /* synthetic */ Boolean l(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List m(StableCurrencyRateBean stableCurrencyRateBean) {
        if (stableCurrencyRateBean == null) {
            return null;
        }
        this.f43754a = stableCurrencyRateBean.getStableCurrency();
        this.f43755b = stableCurrencyRateBean.getTradeCurrency();
        return stableCurrencyRateBean.getStableCurrency();
    }

    public static /* synthetic */ Boolean n(List list) {
        return Boolean.valueOf(list != null);
    }

    public Observable<StableCoinCreate> a(Map<String, Object> map) {
        return a.a().createStableCoinOrder(map).b();
    }

    public Observable<List<StableCoinHints>> b(boolean z11) {
        Observable<R> map = l8.a.a().getStableCoinHints().b().map(new h(this));
        return z11 ? Observable.concat(Observable.just(this.f43756c), map).takeFirst(i.f55957b) : map;
    }

    public Observable<List<StableCurrencyRateBean.StableCurrencyBean>> c(boolean z11) {
        Observable<R> map = a.a().getStableCurrencyRate().b().map(new g(this));
        return z11 ? Observable.concat(Observable.just(this.f43754a), map).takeFirst(j.f55958b) : map;
    }

    public List<StableCurrencyRateBean.StableCurrencyBean> d() {
        return this.f43754a;
    }

    public Observable<String> e(String str) {
        return a.a().placeStableCoinOrder(str).b();
    }

    public StableCurrencyRateBean.TradeCurrencyBean f() {
        return this.f43755b;
    }
}
