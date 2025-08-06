package com.hbg.module.kline.presenter;

import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.etf.retrofit.EtfRetrofit;
import com.hbg.lib.network.hbg.core.bean.CurrencyIntroInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.retrofit.ProRetrofit;
import com.hbg.lib.network.pro.retrofit.service.ProApiService;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.module.kline.bean.EtfInfo;
import com.hbg.module.kline.bean.EtfIngredient;
import com.hbg.module.kline.service.MarketInfoService;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sl.f0;
import u6.g;

public class MarketInfoCurrencyDetailPresenter extends BaseFragmentPresenter<f> {

    /* renamed from: c  reason: collision with root package name */
    public String f23619c;

    /* renamed from: d  reason: collision with root package name */
    public String f23620d;

    /* renamed from: e  reason: collision with root package name */
    public Subscription f23621e;

    public class a extends BaseSubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            MarketInfoCurrencyDetailPresenter.this.i0();
        }
    }

    public class b extends EasySubscriber<List<KlineInfo>> {
        public b() {
        }

        public void onError2(Throwable th2) {
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).Za("--");
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).Za("--");
        }

        public void onNext(List<KlineInfo> list) {
            super.onNext(list);
            if (!CollectionsUtils.b(list)) {
                ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).Za(String.valueOf(list.get(0).getClose()));
            } else {
                ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).Za("--");
            }
        }
    }

    public class c extends BaseSubscriber<List<EtfIngredient>> {
        public c() {
        }

        public void onNext(List<EtfIngredient> list) {
            super.onNext(list);
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).Yg(list);
        }
    }

    public class d extends EasySubscriber<EtfInfo> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(EtfInfo etfInfo) {
            super.onNext(etfInfo);
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).W5(etfInfo);
        }

        public void onError2(Throwable th2) {
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).G7();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).G7();
        }
    }

    public class e extends EasySubscriber<CurrencyIntroInfo> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(CurrencyIntroInfo currencyIntroInfo) {
            super.onNext(currencyIntroInfo);
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).G4(currencyIntroInfo);
        }

        public void onError2(Throwable th2) {
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).G4((CurrencyIntroInfo) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((f) MarketInfoCurrencyDetailPresenter.this.getUI()).G4((CurrencyIntroInfo) null);
        }
    }

    public interface f extends g {
        void G4(CurrencyIntroInfo currencyIntroInfo);

        void G7();

        void W5(EtfInfo etfInfo);

        void Yg(List<EtfIngredient> list);

        void Za(String str);

        void b8(boolean z11);
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            f0.g().i();
            m0();
            return;
        }
        f0.g().m();
        d0(this.f23621e);
    }

    public final void d0(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public final void f0() {
        v7.b.a().getDigitalAssetInfo(MapParamsBuilder.c().a(FirebaseAnalytics.Param.CURRENCY, this.f23620d).a("lang", AppLanguageHelper.getInstance().getCurAppLocale().toString().replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER)).b()).b().retry(3).onErrorReturn(ce.f.f13075b).subscribeOn(Schedulers.io()).compose(RxJavaHelper.t((g) getUI())).subscribe(new e());
    }

    public final void g0() {
        ((MarketInfoService) EtfRetrofit.request(MarketInfoService.class)).getEtfInfo(this.f23620d).compose(EtfRetrofit.d()).compose(RxJavaHelper.t((g) getUI())).subscribe(new d());
    }

    public final void h0() {
        ((MarketInfoService) EtfRetrofit.request(MarketInfoService.class)).getEtfIngredient(this.f23620d).compose(EtfRetrofit.d()).compose(RxJavaHelper.t((g) getUI())).subscribe(new c());
    }

    public final void i0() {
        ((ProApiService) ProRetrofit.request(ProApiService.class)).getIndexKline(this.f23620d, Period.day.value, 1).compose(ProRetrofit.h()).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
    }

    public final boolean j0() {
        return "HB10".equalsIgnoreCase(this.f23620d);
    }

    public final void l0() {
        d0(this.f23621e);
        this.f23621e = Observable.interval(0, 15, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public void m0() {
        f0();
        if (j0()) {
            h0();
            g0();
            l0();
        }
    }

    /* renamed from: n0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, f fVar) {
        super.onUIReady(baseCoreActivity, fVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f23619c = intent.getStringExtra("symbolId");
        }
        this.f23620d = a1.v().n(this.f23619c);
        ((f) getUI()).b8(j0());
    }
}
