package com.huobi.finance.presenter;

import android.content.Intent;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.page.SmartRefreshPageSplitter;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import tq.p;
import u6.g;

public class OtcOptionsDetailPresenter extends BaseAssetDetailPresenter {

    /* renamed from: d  reason: collision with root package name */
    public OtcOptionsDetailInfo f45635d;

    /* renamed from: e  reason: collision with root package name */
    public String f45636e;

    /* renamed from: f  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<FinanceRecordItem> f45637f = new a();

    public class a implements SmartRefreshPageSplitter.c<FinanceRecordItem> {
        public a() {
        }

        public Func1<? super FinanceRecordItem, ? extends Long> a() {
            return n6.f46014b;
        }

        public Observable<List<FinanceRecordItem>> c() {
            MapParamsBuilder c11 = MapParamsBuilder.c();
            c11.a("size", 10).a("types", OtcOptionsDetailPresenter.this.f45502b).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (OtcOptionsDetailPresenter.this.f45635d != null) {
                c11.a(FirebaseAnalytics.Param.CURRENCY, OtcOptionsDetailPresenter.this.f45635d.getCurrency());
            }
            return OtcOptionsDetailPresenter.this.d0(c11.b());
        }

        /* renamed from: f */
        public Observable<List<FinanceRecordItem>> b(FinanceRecordItem financeRecordItem) {
            MapParamsBuilder c11 = MapParamsBuilder.c();
            c11.a("size", 10).a("types", OtcOptionsDetailPresenter.this.f45502b).a("from", Long.valueOf(financeRecordItem.getId())).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (OtcOptionsDetailPresenter.this.f45635d != null) {
                c11.a(FirebaseAnalytics.Param.CURRENCY, OtcOptionsDetailPresenter.this.f45635d.getCurrency());
            }
            return OtcOptionsDetailPresenter.this.d0(c11.b());
        }
    }

    public class b implements Action1<OtcOptionsDetailInfo> {
        public b() {
        }

        /* renamed from: a */
        public void call(OtcOptionsDetailInfo otcOptionsDetailInfo) {
            OtcOptionsDetailInfo unused = OtcOptionsDetailPresenter.this.f45635d = otcOptionsDetailInfo;
            ((BaseAssetDetailPresenter.a) OtcOptionsDetailPresenter.this.getUI()).pb(OtcOptionsDetailPresenter.this.f45635d);
        }
    }

    public void R() {
        this.f45501a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r((SmartRefreshPageSplitter.d) getUI()).q(this.f45637f).k();
    }

    public void T(boolean z11) {
        if (this.f45635d != null) {
            al.b.b(this.f45636e).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new b()));
        }
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, BaseAssetDetailPresenter.a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        this.f45502b = FinanceRecordItem.TYPE_OTC_OPTIONS_BETWEEN_PRO;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45635d = (OtcOptionsDetailInfo) intent.getSerializableExtra("currency_detail_info");
        }
        OtcOptionsDetailInfo otcOptionsDetailInfo = this.f45635d;
        if (otcOptionsDetailInfo != null) {
            this.f45636e = otcOptionsDetailInfo.getCurrency();
            ((BaseAssetDetailPresenter.a) getUI()).pb(this.f45635d);
        }
    }

    /* renamed from: c0 */
    public OtcOptionsDetailInfo Q() {
        return this.f45635d;
    }

    public final Observable<List<FinanceRecordItem>> d0(Map<String, Object> map) {
        return ((FinanceService) p.W(FinanceService.class)).queryAllFinances(map).compose(p.a0()).flatMap(m6.f45999b).map(l6.f45984b).toList();
    }
}
