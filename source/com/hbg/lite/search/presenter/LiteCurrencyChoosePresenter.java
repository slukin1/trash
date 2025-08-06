package com.hbg.lite.search.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.SymbolsDataProvider;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lite.search.bean.LiteChooseCurrencyItem;
import d7.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ra.c;
import rx.Observable;
import rx.schedulers.Schedulers;
import u6.g;

public class LiteCurrencyChoosePresenter extends ActivityPresenter<b> {

    public class a extends EasySubscriber<List<LiteChooseCurrencyItem>> {
        public a() {
        }

        public void onError2(Throwable th2) {
            ((b) LiteCurrencyChoosePresenter.this.getUI()).m0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((b) LiteCurrencyChoosePresenter.this.getUI()).m0();
        }

        public void onStart() {
            super.onStart();
            ((b) LiteCurrencyChoosePresenter.this.getUI()).showLoading();
        }

        public void onNext(List<LiteChooseCurrencyItem> list) {
            super.onNext(list);
            ((b) LiteCurrencyChoosePresenter.this.getUI()).ia(list);
            ((b) LiteCurrencyChoosePresenter.this.getUI()).F0();
        }
    }

    public interface b extends g {
        void F0();

        void ia(List<LiteChooseCurrencyItem> list);

        void m0();

        void showLoading();
    }

    public static /* synthetic */ List R(List list, List list2) {
        List<String> k11 = SymbolsDataProvider.k();
        ArrayList arrayList = new ArrayList();
        for (String next : k11) {
            LiteChooseCurrencyItem liteChooseCurrencyItem = new LiteChooseCurrencyItem();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                OtcMarketCoinInfo.CoinInfo coinInfo = (OtcMarketCoinInfo.CoinInfo) it2.next();
                if (coinInfo.getShortName().equalsIgnoreCase(next)) {
                    liteChooseCurrencyItem.setCoinInfo(coinInfo);
                }
            }
            liteChooseCurrencyItem.setSymbol((next + "usdt").toLowerCase());
            liteChooseCurrencyItem.setName(k.C().z(next));
            arrayList.add(liteChooseCurrencyItem);
        }
        return arrayList;
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        T();
    }

    public void T() {
        Observable.zip(SymbolsDataProvider.h(false, SymbolsDataProvider.i(c.c().getUid())).subscribeOn(Schedulers.io()), Observable.just(va.b.o().p()), lb.a.f58019b).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }
}
