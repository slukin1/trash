package com.huobi.finance.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.page.SmartRefreshPageSplitter;
import dt.h2;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import rx.Observable;
import rx.functions.Func1;
import tg.r;
import tq.p;
import u6.g;

public class LoanSymbolDetailPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter<LoanOrderItem> f45588a;

    /* renamed from: b  reason: collision with root package name */
    public String f45589b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<LoanOrderItem> f45590c = new a();

    public class a implements SmartRefreshPageSplitter.c<LoanOrderItem> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List g(List list) {
            if (list.size() == 0) {
                ((b) LoanSymbolDetailPresenter.this.getUI()).c8();
            }
            return list;
        }

        public Func1<? super LoanOrderItem, ? extends Long> a() {
            return o4.f46036b;
        }

        public Observable<List<LoanOrderItem>> c() {
            return ((FinanceService) p.W(FinanceService.class)).getLoanOrders(MapParamsBuilder.c().a("symbol", LoanSymbolDetailPresenter.this.f45589b).a("states", LoanOrderItem.ACCRUAL).a("size", 10).a(DevicePublicKeyStringDef.DIRECT, "next").b()).compose(p.a0()).compose(RxJavaHelper.t((g) LoanSymbolDetailPresenter.this.getUI())).map(new n4(this));
        }

        /* renamed from: h */
        public Observable<List<LoanOrderItem>> b(LoanOrderItem loanOrderItem) {
            return ((FinanceService) p.W(FinanceService.class)).getLoanOrders(MapParamsBuilder.c().a("symbol", LoanSymbolDetailPresenter.this.f45589b).a("states", LoanOrderItem.ACCRUAL).a("size", 10).a(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "next").a("from", Long.valueOf(loanOrderItem.getId())).b()).compose(p.a0());
        }
    }

    public interface b extends SmartRefreshPageSplitter.d {
        void bc(String str);

        void c8();

        void fc(MarginBalanceDetailInfo marginBalanceDetailInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(List list) {
        if (list.size() > 0) {
            ((b) getUI()).fc((MarginBalanceDetailInfo) list.get(0));
        } else {
            ((b) getUI()).fc((MarginBalanceDetailInfo) null);
        }
        ((b) getUI()).dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(APIStatusErrorException aPIStatusErrorException) {
        ((b) getUI()).f6().k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(Throwable th2) {
        ((b) getUI()).f6().k();
    }

    public final void U() {
        h2.t1().z1(false, this.f45589b).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new m4(this), new k4(this), new l4(this)));
    }

    /* renamed from: Y */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45589b = intent.getStringExtra("symbol");
        }
        ((b) getUI()).bc(this.f45589b);
        this.f45588a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r(bVar).q(this.f45590c).k();
        EventBus.d().p(this);
    }

    public void Z() {
        this.f45588a.F();
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (r.x().F0()) {
            Z();
            U();
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
