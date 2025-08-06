package com.huobi.finance.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import bj.d;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.module.contract.service.ContractService;
import com.huobi.finance.bean.ContractRecordItem;
import com.huobi.finance.bean.ContractRecordWrapper;
import com.huobi.page.SmartRefreshPageSplitter;
import java.util.ArrayList;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import rx.Observable;
import rx.functions.Func1;
import vk.l;

public class ContractFinanceRecordPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter<l> f45511a;

    /* renamed from: b  reason: collision with root package name */
    public String f45512b;

    /* renamed from: c  reason: collision with root package name */
    public int f45513c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f45514d = 1;

    /* renamed from: e  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<l> f45515e = new a();

    public class a implements SmartRefreshPageSplitter.c<l> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List h(ContractRecordWrapper contractRecordWrapper) {
            ArrayList arrayList = new ArrayList();
            if (contractRecordWrapper != null) {
                int unused = ContractFinanceRecordPresenter.this.f45514d = contractRecordWrapper.getCurrentPage();
                List<ContractRecordItem> account_action = contractRecordWrapper.getAccount_action();
                if (account_action != null && !account_action.isEmpty()) {
                    for (ContractRecordItem lVar : account_action) {
                        arrayList.add(new l(lVar));
                    }
                    ContractFinanceRecordPresenter.this.f45511a.D(arrayList);
                    ContractFinanceRecordPresenter.this.f45511a.C((l) arrayList.get(arrayList.size() - 1));
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List i(ContractRecordWrapper contractRecordWrapper) {
            ArrayList arrayList = new ArrayList();
            if (contractRecordWrapper != null) {
                int unused = ContractFinanceRecordPresenter.this.f45514d = contractRecordWrapper.getCurrentPage();
                List<ContractRecordItem> account_action = contractRecordWrapper.getAccount_action();
                if (account_action != null && !account_action.isEmpty()) {
                    for (ContractRecordItem lVar : account_action) {
                        arrayList.add(new l(lVar));
                    }
                    ContractFinanceRecordPresenter.this.f45511a.D(arrayList);
                    ContractFinanceRecordPresenter.this.f45511a.C((l) arrayList.get(arrayList.size() - 1));
                }
            }
            return arrayList;
        }

        public Func1<? super l, ? extends Long> a() {
            return e2.f45860b;
        }

        public Observable<List<l>> c() {
            int unused = ContractFinanceRecordPresenter.this.f45514d = 1;
            MapParamsBuilder a11 = MapParamsBuilder.c().a("symbol", ContractFinanceRecordPresenter.this.f45512b).a("page_size", 10);
            if (ContractFinanceRecordPresenter.this.f45513c != Integer.MIN_VALUE) {
                a11.a("money_type", d.k(ContractFinanceRecordPresenter.this.f45513c));
            }
            return ((ContractService) ContractRetrofit.request(ContractService.class)).getFinanceRecord(a11.b()).compose(ContractRetrofit.h()).map(new d2(this));
        }

        /* renamed from: j */
        public Observable<List<l>> b(l lVar) {
            MapParamsBuilder a11 = MapParamsBuilder.c().a("symbol", ContractFinanceRecordPresenter.this.f45512b).a("page_size", 10).a("page_index", Integer.valueOf(ContractFinanceRecordPresenter.this.f45514d + 1));
            if (ContractFinanceRecordPresenter.this.f45513c != Integer.MIN_VALUE) {
                a11.a("money_type", d.k(ContractFinanceRecordPresenter.this.f45513c));
            }
            return ((ContractService) ContractRetrofit.request(ContractService.class)).getFinanceRecord(a11.b()).compose(ContractRetrofit.h()).map(new c2(this));
        }
    }

    public interface b extends SmartRefreshPageSplitter.d {
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45512b = intent.getStringExtra("coin_name");
        }
        this.f45513c = Integer.MIN_VALUE;
        SmartRefreshPageSplitter<l> k11 = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r(bVar).q(this.f45515e).k();
        this.f45511a = k11;
        k11.F();
    }

    public void W(int i11) {
        this.f45513c = i11;
        this.f45511a.F();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
