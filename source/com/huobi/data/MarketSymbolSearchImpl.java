package com.huobi.data;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.market.widget.bean.MarketSearchResultItem;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import d7.k;
import fr.c;
import gj.d;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jf.b;
import kj.e;
import rx.Observable;
import sn.t;
import tg.r;
import u6.g;

public class MarketSymbolSearchImpl implements b {

    public class a extends EasySubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ jf.a f43766b;

        public a(jf.a aVar) {
            this.f43766b = aVar;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            this.f43766b.a(t.r());
        }
    }

    public static /* synthetic */ List n(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List o(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Pair p(List list, List list2) {
        return null;
    }

    public static /* synthetic */ Object q(List list, List list2) {
        return null;
    }

    public boolean a() {
        return r.x().F0();
    }

    public void b(List<String> list) {
        c.b(list);
    }

    public MarketSearchResultItem c(Activity activity, String str) {
        String str2;
        MarketSearchResultItem marketSearchResultItem = new MarketSearchResultItem();
        SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(str);
        FutureContractInfo o11 = FutureContractInfoController.n().o(str);
        ContractCurrencyInfo b11 = ContractCurrencyUtils.b(str);
        Map<String, IndexCurrencyInfo> h11 = IndexCurrencyInfoController.k().h();
        IndexCurrencyInfo indexCurrencyInfo = h11 != null ? h11.get(str) : null;
        if (c11 != null && str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) && d.n().E()) {
            marketSearchResultItem.setSwapCurrencyInfo(c11);
            marketSearchResultItem.setItemCurrencyType(2);
            str2 = c11.getContractShortType();
        } else if (indexCurrencyInfo != null && str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) && d.n().E()) {
            marketSearchResultItem.setIndexCurrencyInfo(indexCurrencyInfo);
            if ("usdt".equalsIgnoreCase(indexCurrencyInfo.getQuoteCurrency())) {
                marketSearchResultItem.setItemCurrencyType(6);
            } else {
                marketSearchResultItem.setItemCurrencyType(5);
            }
            str2 = indexCurrencyInfo.getContractShortType();
        } else if (o11 != null && str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) && d.n().E()) {
            marketSearchResultItem.setLinearSwapContractInfo(o11);
            marketSearchResultItem.setItemCurrencyType(4);
            str2 = o11.getContractShortType();
        } else if (b11 == null || !str.contains("_") || !d.n().E()) {
            SymbolBean J = a1.v().J(str, TradeType.PRO);
            if (J != null) {
                str2 = J.getSymbol();
                marketSearchResultItem.setItemCurrencyType(0);
            } else {
                str2 = "";
            }
        } else {
            marketSearchResultItem.setContractCurrencyInfo(b11);
            marketSearchResultItem.setItemCurrencyType(1);
            str2 = b11.getContractShortType();
        }
        if (TextUtils.isEmpty(str2) && marketSearchResultItem.getContractCurrencyInfo() == null && marketSearchResultItem.getSwapCurrencyInfo() == null && marketSearchResultItem.getOptionContractInfo() == null) {
            return null;
        }
        marketSearchResultItem.setSearchKeyWord(str2);
        if (r.x().F0()) {
            marketSearchResultItem.setCollected(t.w(str2));
        } else {
            marketSearchResultItem.setCollected(m(activity, str2));
        }
        marketSearchResultItem.setSymbol(str2);
        return marketSearchResultItem;
    }

    public void d() {
        k.C().U(true, (RequestCallback1<List<CurrencyBean>>) null);
        Observable<List<SymbolBean>> Y = a1.v().Y(true, true);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Observable<R> onErrorReturn = Y.timeout(3000, timeUnit).compose(RxJavaHelper.t((g) null)).onErrorReturn(kj.c.f56581b);
        Observable<R> onErrorReturn2 = k.C().E(true).timeout(3000, timeUnit).compose(RxJavaHelper.t((g) null)).onErrorReturn(kj.b.f56580b);
        t.s(false, BaseApplication.b()).compose(RxJavaHelper.t((g) null));
        Observable.zip(onErrorReturn, onErrorReturn2, e.f56583b).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
        Observable.zip(ContractCurrencyUtils.g(false), SwapCurrencyInfoController.k().f(false), kj.d.f56582b).compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
        FutureContractInfoController.n().q(false).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
        FutureProductInfoController.d().i(TradeType.LINEAR_SWAP, false).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
    }

    public List<Pair<String, Object>> e(Context context, String str, boolean z11) {
        return c.a(context, str, z11);
    }

    public List<String> f() {
        return fr.a.e();
    }

    public void g(Context context, jf.a aVar) {
        if (aVar != null) {
            t.s(false, context).compose(RxJavaHelper.t((g) null)).subscribe(new a(aVar));
        }
    }

    public String getUid() {
        return r.x().J();
    }

    public void i() {
        fr.a.f();
    }

    public boolean m(Activity activity, String str) {
        List<String> i11 = br.c.g(activity).i();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return i11.contains(str);
    }
}
