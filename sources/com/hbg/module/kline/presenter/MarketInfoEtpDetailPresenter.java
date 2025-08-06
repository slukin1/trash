package com.hbg.module.kline.presenter;

import android.content.Intent;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.EtpInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRiskInfo;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.hbg.retrofit.service.HbgService;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import d7.a1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import u6.g;

public class MarketInfoEtpDetailPresenter extends BaseFragmentPresenter<e> {

    /* renamed from: c  reason: collision with root package name */
    public String f23645c;

    /* renamed from: d  reason: collision with root package name */
    public String f23646d;

    /* renamed from: e  reason: collision with root package name */
    public Subscription f23647e;

    public class a extends EasySubscriber<EtpInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(EtpInfo etpInfo) {
            super.onNext(etpInfo);
            ((e) MarketInfoEtpDetailPresenter.this.getUI()).a8(etpInfo);
        }

        public void onError2(Throwable th2) {
            ((e) MarketInfoEtpDetailPresenter.this.getUI()).a8((EtpInfo) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((e) MarketInfoEtpDetailPresenter.this.getUI()).a8((EtpInfo) null);
        }
    }

    public class b extends BaseSubscriber<Long> {
        public b() {
        }

        public void onNext(Long l11) {
            MarketInfoEtpDetailPresenter.this.g0();
        }
    }

    public class c extends q6.a<List<EtpRiskInfo>> {
        public c(g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(List<EtpRiskInfo> list) {
            ArrayList arrayList = new ArrayList();
            for (EtpRiskInfo aVar : list) {
                arrayList.add(new ud.a(aVar));
            }
            ((e) MarketInfoEtpDetailPresenter.this.getUI()).d0(arrayList);
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            ((e) MarketInfoEtpDetailPresenter.this.getUI()).m0();
        }
    }

    public class d extends BaseSubscriber<EtpRebalInfo> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(EtpRebalInfo etpRebalInfo) {
            super.onNext(etpRebalInfo);
            ((e) MarketInfoEtpDetailPresenter.this.getUI()).b0(etpRebalInfo);
        }
    }

    public interface e extends g {
        void Td();

        void a8(EtpInfo etpInfo);

        void b0(EtpRebalInfo etpRebalInfo);

        void d0(List<ud.a> list);

        void m0();

        void showLoading();
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            d0();
        } else {
            b0(this.f23647e);
        }
    }

    public void b0(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public String c0() {
        return this.f23645c;
    }

    public void d0() {
        ((HbgService) HbgRetrofit.request(HbgService.class)).getEtpInfo(this.f23646d).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
        h0();
        b0(this.f23647e);
        this.f23647e = Observable.interval(0, 3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b());
    }

    /* renamed from: f0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, e eVar) {
        super.onUIReady(baseCoreActivity, eVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f23645c = intent.getStringExtra("symbolId");
        }
        this.f23646d = a1.v().n(this.f23645c);
        ((e) getUI()).Td();
    }

    public void g0() {
        x7.d.c(this.f23646d, false).compose(RxJavaHelper.t((g) getUI())).subscribe(new d());
    }

    public void h0() {
        ((e) getUI()).showLoading();
        v7.b.a().S("etp", 2).d(new c((g) getUI(), false));
    }
}
