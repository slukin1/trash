package com.huobi.homemarket.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.MarketPlateDetail;
import com.huobi.homemarket.ui.HeaderAndFooterRecyclerViewAdapter;
import i6.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import tl.v;
import u6.g;

public class MarketDetailPlatePresenter extends BaseFragmentPresenter<c> {

    /* renamed from: c  reason: collision with root package name */
    public HeaderAndFooterRecyclerViewAdapter f72844c;

    /* renamed from: d  reason: collision with root package name */
    public List<MarketPlateDetail.CurrencyItem> f72845d;

    /* renamed from: e  reason: collision with root package name */
    public v9.a<MarketPlateDetail.CurrencyItem> f72846e;

    /* renamed from: f  reason: collision with root package name */
    public String f72847f;

    /* renamed from: g  reason: collision with root package name */
    public String f72848g = "sort_normal";

    /* renamed from: h  reason: collision with root package name */
    public String f72849h = "";

    /* renamed from: i  reason: collision with root package name */
    public MarketPlateDetail f72850i;

    /* renamed from: j  reason: collision with root package name */
    public Subscription f72851j;

    public class a extends EasySubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            d.i("Observable.interval:" + l11);
            MarketDetailPlatePresenter.this.n0();
        }
    }

    public class b extends EasySubscriber<MarketPlateDetail> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(MarketPlateDetail marketPlateDetail) {
            super.onNext(marketPlateDetail);
            if (MarketDetailPlatePresenter.this.getUI() != null && ((c) MarketDetailPlatePresenter.this.getUI()).isAlive()) {
                MarketPlateDetail unused = MarketDetailPlatePresenter.this.f72850i = marketPlateDetail;
                MarketDetailPlatePresenter.this.f72845d.clear();
                if (MarketDetailPlatePresenter.this.f72850i.getCurrencyList() != null) {
                    MarketDetailPlatePresenter.this.f72845d.addAll(MarketDetailPlatePresenter.this.f72850i.getCurrencyList());
                }
                MarketDetailPlatePresenter marketDetailPlatePresenter = MarketDetailPlatePresenter.this;
                marketDetailPlatePresenter.p0(marketDetailPlatePresenter.f72849h, MarketDetailPlatePresenter.this.f72848g);
            }
        }

        public void onAfter() {
            super.onAfter();
            if (MarketDetailPlatePresenter.this.getUI() != null && ((c) MarketDetailPlatePresenter.this.getUI()).isAlive()) {
                ((c) MarketDetailPlatePresenter.this.getUI()).C5(MarketDetailPlatePresenter.this.f72850i);
            }
        }
    }

    public interface c extends g {
        void C5(MarketPlateDetail marketPlateDetail);

        void ug(HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter);
    }

    public static int j0(boolean z11, MarketPlateDetail.CurrencyItem currencyItem, MarketPlateDetail.CurrencyItem currencyItem2) {
        String currency = currencyItem.getCurrency();
        String currency2 = currencyItem2.getCurrency();
        if (z11) {
            return currency.compareTo(currency2);
        }
        return currency2.compareTo(currency);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int k0(boolean z11, MarketPlateDetail.CurrencyItem currencyItem, MarketPlateDetail.CurrencyItem currencyItem2) {
        int i11;
        int i12;
        int i13;
        if ("type_amount".equals(this.f72849h)) {
            Double valueOf = Double.valueOf(Double.parseDouble(currencyItem.getTotalVol()));
            Double valueOf2 = Double.valueOf(Double.parseDouble(currencyItem2.getTotalVol()));
            if (z11) {
                i13 = valueOf.compareTo(valueOf2);
            } else {
                i13 = valueOf2.compareTo(valueOf);
            }
            return i13 == 0 ? j0(z11, currencyItem, currencyItem2) : i13;
        } else if ("type_name".equals(this.f72849h)) {
            return j0(z11, currencyItem, currencyItem2);
        } else {
            if ("type_price".equals(this.f72849h)) {
                Double valueOf3 = Double.valueOf(Double.parseDouble(currencyItem.getPrice()));
                Double valueOf4 = Double.valueOf(Double.parseDouble(currencyItem2.getPrice()));
                if (z11) {
                    i12 = valueOf3.compareTo(valueOf4);
                } else {
                    i12 = valueOf4.compareTo(valueOf3);
                }
                return i12 == 0 ? j0(z11, currencyItem, currencyItem2) : i12;
            } else if (!"type_heigh_low".equals(this.f72849h)) {
                return 0;
            } else {
                Double valueOf5 = Double.valueOf(Double.parseDouble(currencyItem.getUpDown()));
                Double valueOf6 = Double.valueOf(Double.parseDouble(currencyItem2.getUpDown()));
                if (z11) {
                    i11 = valueOf5.compareTo(valueOf6);
                } else {
                    i11 = valueOf6.compareTo(valueOf5);
                }
                return i11 == 0 ? j0(z11, currencyItem, currencyItem2) : i11;
            }
        }
    }

    /* renamed from: l0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        Bundle arguments = Q().getArguments();
        if (arguments != null) {
            this.f72847f = arguments.getString("plateId");
        }
        if (!TextUtils.isEmpty(this.f72847f)) {
            ArrayList arrayList = new ArrayList();
            this.f72845d = arrayList;
            v9.a<MarketPlateDetail.CurrencyItem> aVar = new v9.a<>(arrayList);
            this.f72846e = aVar;
            this.f72844c = new HeaderAndFooterRecyclerViewAdapter(aVar);
            ((c) getUI()).ug(this.f72844c);
        }
    }

    public void m0() {
        Subscription subscription = this.f72851j;
        if (subscription == null || subscription.isUnsubscribed()) {
            this.f72851j = Observable.interval(0, 10, TimeUnit.SECONDS).subscribe(new a());
        }
    }

    public final void n0() {
        v7.b.a().getMarketPlateDetail(this.f72847f).b().subscribeOn(Schedulers.io()).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
    }

    public void onPause() {
        super.onPause();
        q0();
    }

    public void onResume() {
        super.onResume();
        m0();
    }

    public void p0(String str, String str2) {
        this.f72848g = str2;
        this.f72849h = str;
        if ("sort_normal".equals(str2) || TextUtils.isEmpty(this.f72848g)) {
            this.f72845d.clear();
            if (this.f72850i.getCurrencyList() != null) {
                this.f72845d.addAll(this.f72850i.getCurrencyList());
            }
        } else {
            Collections.sort(this.f72845d, new v(this, "sort_asc".equals(this.f72848g)));
        }
        this.f72844c.notifyDataSetChanged();
    }

    public void q0() {
        Subscription subscription = this.f72851j;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
