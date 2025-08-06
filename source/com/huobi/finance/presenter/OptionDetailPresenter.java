package com.huobi.finance.presenter;

import ad.i;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.hbg.lib.network.option.core.bean.OptionFinancialRecordResponse;
import com.huobi.contract.entity.OptionBalanceItem;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.page.SmartRefreshPageSplitter;
import d7.k;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import u6.g;
import vk.u;

public class OptionDetailPresenter extends BaseAssetDetailPresenter {

    /* renamed from: d  reason: collision with root package name */
    public OptionBalanceItem f45611d;

    /* renamed from: e  reason: collision with root package name */
    public int f45612e = 1;

    /* renamed from: f  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<u> f45613f = new a();

    public class a implements SmartRefreshPageSplitter.c<u> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List j(OptionFinancialRecordResponse optionFinancialRecordResponse) {
            int unused = OptionDetailPresenter.this.f45612e = optionFinancialRecordResponse.getCurrentPage();
            return optionFinancialRecordResponse.getFinancialRecord();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List k(List list) {
            if (list != null && !list.isEmpty()) {
                OptionDetailPresenter.this.f45501a.D(list);
                OptionDetailPresenter.this.f45501a.C((s9.a) list.get(list.size() - 1));
            }
            return list;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List l(OptionFinancialRecordResponse optionFinancialRecordResponse) {
            int unused = OptionDetailPresenter.this.f45612e = optionFinancialRecordResponse.getCurrentPage();
            return optionFinancialRecordResponse.getFinancialRecord();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List m(List list) {
            if (list != null && !list.isEmpty()) {
                OptionDetailPresenter.this.f45501a.D(list);
                OptionDetailPresenter.this.f45501a.C((s9.a) list.get(list.size() - 1));
            }
            return list;
        }

        public Func1<? super u, ? extends Long> a() {
            return l5.f45983b;
        }

        public Observable<List<u>> c() {
            if (OptionDetailPresenter.this.f45611d == null || OptionDetailPresenter.this.f45611d.getMAccountInfo() == null) {
                return Observable.empty();
            }
            OptionDetailPresenter.this.T(false);
            int unused = OptionDetailPresenter.this.f45612e = 1;
            p8.b a11 = p8.a.a();
            String symbol = OptionDetailPresenter.this.f45611d.getMAccountInfo().getSymbol();
            OptionDetailPresenter optionDetailPresenter = OptionDetailPresenter.this;
            return a11.n(symbol, "USDT", optionDetailPresenter.f45502b, optionDetailPresenter.f45612e, 10).b().map(new i5(this)).flatMap(i.f3526b).map(m5.f45998b).toList().map(new j5(this));
        }

        /* renamed from: n */
        public Observable<List<u>> b(u uVar) {
            if (OptionDetailPresenter.this.f45611d == null || OptionDetailPresenter.this.f45611d.getMAccountInfo() == null) {
                return Observable.empty();
            }
            p8.b a11 = p8.a.a();
            String symbol = OptionDetailPresenter.this.f45611d.getMAccountInfo().getSymbol();
            OptionDetailPresenter optionDetailPresenter = OptionDetailPresenter.this;
            return a11.n(symbol, "USDT", optionDetailPresenter.f45502b, optionDetailPresenter.f45612e + 1, 10).b().map(new h5(this)).flatMap(i.f3526b).map(m5.f45998b).toList().map(new k5(this));
        }
    }

    public class b extends EasySubscriber<OptionAccountInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(OptionAccountInfo optionAccountInfo) {
            super.onNext(optionAccountInfo);
            OptionBalanceItem unused = OptionDetailPresenter.this.f45611d = new OptionBalanceItem(optionAccountInfo);
            ((BaseAssetDetailPresenter.a) OptionDetailPresenter.this.getUI()).pb(OptionDetailPresenter.this.f45611d);
        }
    }

    public static /* synthetic */ OptionAccountInfo d0(List list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        return (OptionAccountInfo) list.get(0);
    }

    public void R() {
        this.f45501a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r((SmartRefreshPageSplitter.d) getUI()).q(this.f45613f).k();
    }

    public void T(boolean z11) {
        OptionBalanceItem optionBalanceItem = this.f45611d;
        if (optionBalanceItem != null && optionBalanceItem.getMAccountInfo() != null && !TextUtils.isEmpty(this.f45611d.getMAccountInfo().getSymbol())) {
            p8.a.a().z(this.f45611d.getMAccountInfo().getSymbol(), "USDT").b().map(g5.f45892b).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
        }
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, BaseAssetDetailPresenter.a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45611d = (OptionBalanceItem) intent.getSerializableExtra("currency_detail_info");
        }
        OptionBalanceItem optionBalanceItem = this.f45611d;
        if (!(optionBalanceItem == null || optionBalanceItem.getMAccountInfo() == null)) {
            ((BaseAssetDetailPresenter.a) getUI()).pb(this.f45611d);
        }
        if (this.f45611d != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("currency_name", k.C().z(this.f45611d.getCurrency()));
            gs.g.i("app_assets_derivatives_details_view", hashMap);
        }
    }

    public void c0() {
        OptionBalanceItem optionBalanceItem = this.f45611d;
        if (optionBalanceItem != null && optionBalanceItem.getMAccountInfo() != null) {
            qk.k.g(getActivity(), this.f45611d.getMAccountInfo().getSymbol());
        }
    }
}
