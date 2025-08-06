package com.huobi.finance.presenter;

import android.content.Intent;
import com.hbg.lib.common.network.exception.NullResponseException;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.LegalDataTotal;
import com.huobi.finance.bean.LegalDetailInfo;
import com.huobi.finance.bean.OtcFinanceRecordItem;
import com.huobi.finance.bean.OtcFinanceResponse;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.otc.service.OTCService;
import com.huobi.page.SmartRefreshPageSplitter;
import dt.h2;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import tq.p;
import u6.g;

public class OtcCurrencyDetailPresenter extends BaseAssetDetailPresenter {

    /* renamed from: d  reason: collision with root package name */
    public OtcFinanceResponse f45616d;

    /* renamed from: e  reason: collision with root package name */
    public LegalDetailInfo f45617e;

    /* renamed from: f  reason: collision with root package name */
    public int f45618f = 10;

    /* renamed from: g  reason: collision with root package name */
    public int f45619g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f45620h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f45621i = Integer.MIN_VALUE;

    /* renamed from: j  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<OtcFinanceRecordItem> f45622j = new a();

    public class a implements SmartRefreshPageSplitter.c<OtcFinanceRecordItem> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(OtcFinanceResponse otcFinanceResponse) {
            OtcCurrencyDetailPresenter.this.f45616d = otcFinanceResponse;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(List list) {
            if (list == null || list.isEmpty()) {
                OtcCurrencyDetailPresenter.this.f45501a.D((List) null);
                return;
            }
            OtcCurrencyDetailPresenter.this.f45501a.D(list);
            OtcCurrencyDetailPresenter.this.f45501a.C((s9.a) list.get(list.size() - 1));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(OtcFinanceResponse otcFinanceResponse) {
            OtcCurrencyDetailPresenter.this.f45616d = otcFinanceResponse;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(List list) {
            if (list != null && !list.isEmpty()) {
                OtcCurrencyDetailPresenter.this.f45501a.D(list);
                OtcCurrencyDetailPresenter.this.f45501a.C((s9.a) list.get(list.size() - 1));
            }
        }

        public Func1<? super OtcFinanceRecordItem, ? extends Long> a() {
            return w5.f46161b;
        }

        public Observable<List<OtcFinanceRecordItem>> c() {
            int unused = OtcCurrencyDetailPresenter.this.f45619g = 1;
            MapParamsBuilder c11 = MapParamsBuilder.c();
            if (OtcCurrencyDetailPresenter.this.f45621i != Integer.MIN_VALUE) {
                c11.a("coinId", Integer.valueOf(OtcCurrencyDetailPresenter.this.f45621i));
            }
            c11.a("currPage", Integer.valueOf(OtcCurrencyDetailPresenter.this.f45619g));
            if (OtcCurrencyDetailPresenter.this.f45502b != null) {
                if (String.valueOf(45).equals(OtcCurrencyDetailPresenter.this.f45502b)) {
                    c11.a("type", String.format("%d,%d", new Object[]{45, 46}));
                } else {
                    c11.a("type", OtcCurrencyDetailPresenter.this.f45502b);
                }
            }
            return OtcCurrencyDetailPresenter.this.m0(c11.b()).doOnNext(new s5(this)).compose(OtcCurrencyDetailPresenter.this.t0()).doOnNext(new u5(this));
        }

        /* renamed from: n */
        public Observable<List<OtcFinanceRecordItem>> b(OtcFinanceRecordItem otcFinanceRecordItem) {
            OtcCurrencyDetailPresenter.f0(OtcCurrencyDetailPresenter.this);
            MapParamsBuilder c11 = MapParamsBuilder.c();
            if (OtcCurrencyDetailPresenter.this.f45621i != Integer.MIN_VALUE) {
                c11.a("coinId", Integer.valueOf(OtcCurrencyDetailPresenter.this.f45621i));
            }
            c11.a("currPage", Integer.valueOf(OtcCurrencyDetailPresenter.this.f45619g));
            if (OtcCurrencyDetailPresenter.this.f45502b != null) {
                if (String.valueOf(45).equals(OtcCurrencyDetailPresenter.this.f45502b)) {
                    c11.a("type", String.format("%d,%d", new Object[]{45, 46}));
                } else {
                    c11.a("type", OtcCurrencyDetailPresenter.this.f45502b);
                }
            }
            return OtcCurrencyDetailPresenter.this.m0(c11.b()).doOnNext(new t5(this)).compose(OtcCurrencyDetailPresenter.this.t0()).doOnNext(new v5(this));
        }
    }

    public class b extends EasySubscriber<LegalDetailInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(LegalDetailInfo legalDetailInfo) {
            super.onNext(legalDetailInfo);
            LegalDetailInfo unused = OtcCurrencyDetailPresenter.this.f45617e = legalDetailInfo;
            ((BaseAssetDetailPresenter.a) OtcCurrencyDetailPresenter.this.getUI()).pb(OtcCurrencyDetailPresenter.this.f45617e);
        }
    }

    public static /* synthetic */ int f0(OtcCurrencyDetailPresenter otcCurrencyDetailPresenter) {
        int i11 = otcCurrencyDetailPresenter.f45619g;
        otcCurrencyDetailPresenter.f45619g = i11 + 1;
        return i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ LegalDetailInfo n0(LegalQueryData legalQueryData, LegalDataTotal legalDataTotal) {
        return l0(this.f45621i, legalQueryData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable p0(LegalQueryData legalQueryData) {
        if (h2.t1().E1("btc").isEmpty()) {
            return AssetDataCacheManager.k0().l0().map(new q5(this, legalQueryData));
        }
        return Observable.just(l0(this.f45621i, legalQueryData));
    }

    public static /* synthetic */ void q0(OtcFinanceResponse otcFinanceResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (otcFinanceResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (otcFinanceResponse.isSuccess()) {
            subscriber.onNext(otcFinanceResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(otcFinanceResponse.getErrCode(), otcFinanceResponse.getErrMsg()));
        }
    }

    public void R() {
        this.f45501a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(this.f45618f).r((SmartRefreshPageSplitter.d) getUI()).q(this.f45622j).k();
    }

    public void T(boolean z11) {
        ((OTCService) p.U(OTCService.class)).getWalletByCoinId(this.f45621i).compose(OtcRetrofit.o()).flatMap(new p5(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, BaseAssetDetailPresenter.a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45617e = (LegalDetailInfo) intent.getSerializableExtra("currency_detail_info");
        }
        LegalDetailInfo legalDetailInfo = this.f45617e;
        if (legalDetailInfo != null) {
            this.f45621i = legalDetailInfo.getCoinId();
            ((BaseAssetDetailPresenter.a) getUI()).pb(this.f45617e);
        } else if (intent != null) {
            this.f45621i = intent.getIntExtra("currency_detail_coin_id", Integer.MIN_VALUE);
            this.f45503c = false;
        }
    }

    public final LegalDetailInfo l0(int i11, LegalQueryData legalQueryData) {
        HashMap hashMap = new HashMap();
        if (legalQueryData != null) {
            hashMap.put(0, legalQueryData.getAvaialAble());
            hashMap.put(1, legalQueryData.getFrozen());
            hashMap.put(2, legalQueryData.getBorrow());
        }
        HashMap hashMap2 = new HashMap();
        Map<Integer, BigDecimal> E1 = h2.t1().E1("btc");
        for (Map.Entry next : h2.t1().E1("usdt").entrySet()) {
            if (!(next == null || next.getValue() == null)) {
                hashMap2.put((Integer) next.getKey(), LegalCurrencyConfigUtil.B(((BigDecimal) next.getValue()).toPlainString()));
            }
        }
        return h2.t1().Z0(i11, hashMap, hashMap2, E1);
    }

    public final Observable<OtcFinanceResponse<List<OtcFinanceRecordItem>>> m0(Map<String, Object> map) {
        return ((FinanceService) OtcRetrofit.request(FinanceService.class)).queryFinances(map);
    }

    public final <T> Observable.Transformer<OtcFinanceResponse<T>, T> t0() {
        return o5.f46037b;
    }
}
