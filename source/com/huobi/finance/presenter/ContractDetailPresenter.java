package com.huobi.finance.presenter;

import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.module.contract.service.ContractService;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.ui.ContractTradeBaseFragment;
import com.huobi.finance.bean.ContractRecordItem;
import com.huobi.finance.bean.ContractRecordWrapper;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.page.SmartRefreshPageSplitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import u6.g;
import vk.l;

public class ContractDetailPresenter extends BaseAssetDetailPresenter {

    /* renamed from: d  reason: collision with root package name */
    public ContractAccountInfo f45504d;

    /* renamed from: e  reason: collision with root package name */
    public int f45505e = 1;

    /* renamed from: f  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<l> f45506f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Subscription f45507g;

    public class a implements SmartRefreshPageSplitter.c<l> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List h(ContractRecordWrapper contractRecordWrapper) {
            ArrayList arrayList = new ArrayList();
            if (contractRecordWrapper != null) {
                int unused = ContractDetailPresenter.this.f45505e = contractRecordWrapper.getCurrentPage();
                List<ContractRecordItem> account_action = contractRecordWrapper.getAccount_action();
                if (account_action != null && !account_action.isEmpty()) {
                    for (ContractRecordItem lVar : account_action) {
                        arrayList.add(new l(lVar));
                    }
                    ContractDetailPresenter.this.f45501a.D(arrayList);
                    ContractDetailPresenter.this.f45501a.C((s9.a) arrayList.get(arrayList.size() - 1));
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List i(ContractRecordWrapper contractRecordWrapper) {
            ArrayList arrayList = new ArrayList();
            if (contractRecordWrapper != null) {
                int unused = ContractDetailPresenter.this.f45505e = contractRecordWrapper.getCurrentPage();
                List<ContractRecordItem> account_action = contractRecordWrapper.getAccount_action();
                if (account_action != null && !account_action.isEmpty()) {
                    for (ContractRecordItem lVar : account_action) {
                        arrayList.add(new l(lVar));
                    }
                    ContractDetailPresenter.this.f45501a.D(arrayList);
                    ContractDetailPresenter.this.f45501a.C((s9.a) arrayList.get(arrayList.size() - 1));
                }
            }
            return arrayList;
        }

        public Func1<? super l, ? extends Long> a() {
            return b2.f45813b;
        }

        public Observable<List<l>> c() {
            int unused = ContractDetailPresenter.this.f45505e = 1;
            MapParamsBuilder a11 = MapParamsBuilder.c().a("page_size", 10);
            if (ContractDetailPresenter.this.f45504d != null) {
                a11.a("symbol", ContractDetailPresenter.this.f45504d.getSymbol());
            }
            String str = ContractDetailPresenter.this.f45502b;
            if (str != null) {
                a11.a("money_type", str);
            }
            a11.a("create_date", "90");
            return ((ContractService) ContractRetrofit.request(ContractService.class)).getFinanceRecord(a11.b()).compose(ContractRetrofit.h()).map(new a2(this));
        }

        /* renamed from: j */
        public Observable<List<l>> b(l lVar) {
            MapParamsBuilder a11 = MapParamsBuilder.c().a("page_size", 10).a("page_index", Integer.valueOf(ContractDetailPresenter.this.f45505e + 1));
            if (ContractDetailPresenter.this.f45504d != null) {
                a11.a("symbol", ContractDetailPresenter.this.f45504d.getSymbol());
            }
            String str = ContractDetailPresenter.this.f45502b;
            if (str != null) {
                a11.a("money_type", str);
            }
            a11.a("create_date", "90");
            return ((ContractService) ContractRetrofit.request(ContractService.class)).getFinanceRecord(a11.b()).compose(ContractRetrofit.h()).map(new z1(this));
        }
    }

    public class b extends EasySubscriber<ContractAccountInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(ContractAccountInfo contractAccountInfo) {
            super.onNext(contractAccountInfo);
            ContractAccountInfo unused = ContractDetailPresenter.this.f45504d = contractAccountInfo;
            ((BaseAssetDetailPresenter.a) ContractDetailPresenter.this.getUI()).pb(ContractDetailPresenter.this.f45504d);
        }
    }

    public class c extends EasySubscriber<ContractCurrencyInfo> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(ContractCurrencyInfo contractCurrencyInfo) {
            super.onNext(contractCurrencyInfo);
            if (contractCurrencyInfo != null) {
                ContractTradeBaseFragment.Ri(ContractDetailPresenter.this.getActivity(), contractCurrencyInfo);
            }
        }
    }

    public static /* synthetic */ ContractAccountInfo g0(List list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        return (ContractAccountInfo) list.get(0);
    }

    public void R() {
        this.f45501a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r((SmartRefreshPageSplitter.d) getUI()).q(this.f45506f).k();
    }

    public void T(boolean z11) {
        ContractAccountInfo contractAccountInfo = this.f45504d;
        if (contractAccountInfo != null && !TextUtils.isEmpty(contractAccountInfo.getSymbol())) {
            HashMap hashMap = new HashMap();
            hashMap.put("symbol", this.f45504d.getSymbol());
            ((com.huobi.contract.service.ContractService) ContractRetrofit.request(com.huobi.contract.service.ContractService.class)).getAccountInfo(hashMap).compose(ContractRetrofit.h()).map(y1.f46186b).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
        }
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, BaseAssetDetailPresenter.a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45504d = (ContractAccountInfo) intent.getSerializableExtra("currency_detail_info");
        }
        if (this.f45504d != null) {
            ((BaseAssetDetailPresenter.a) getUI()).pb(this.f45504d);
            if (this.f45504d.isNewAssetData()) {
                T(false);
            }
        }
    }

    public final void d0() {
        Subscription subscription = this.f45507g;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f45507g.unsubscribe();
        }
    }

    public void f0() {
        ContractAccountInfo contractAccountInfo = this.f45504d;
        if (contractAccountInfo != null && contractAccountInfo.getSymbol() != null) {
            d0();
            this.f45507g = ContractCurrencyUtils.j(false, this.f45504d.getSymbol()).compose(RxJavaHelper.t((g) getUI())).subscribe(new c());
        }
    }

    public void onStop() {
        super.onStop();
        d0();
    }
}
