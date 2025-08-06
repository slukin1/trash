package com.huobi.finance.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.SubaccountQueryData;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.margin.entity.MarginBalanceQueryData;
import d7.a1;
import dt.h2;
import java.util.HashMap;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import q6.d;
import rn.c;
import rx.Observable;
import tq.p;
import u6.g;

public class RepayPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public LoanOrderItem f45640a;

    /* renamed from: b  reason: collision with root package name */
    public String f45641b;

    public class a extends EasySubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45642b;

        public a(boolean z11) {
            this.f45642b = z11;
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            ((b) RepayPresenter.this.getUI()).V3(RepayPresenter.this.f45641b);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (this.f45642b) {
                ((b) RepayPresenter.this.getUI()).W0();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (this.f45642b) {
                ((b) RepayPresenter.this.getUI()).W0();
            }
        }
    }

    public interface b extends g {
        void R6(SymbolBean symbolBean);

        void V3(String str);

        void W0();

        void ch();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean T(List list) {
        if (list.size() == 0) {
            this.f45641b = "0";
            return Boolean.FALSE;
        }
        for (SubaccountQueryData next : ((MarginBalanceQueryData) list.get(0)).getList()) {
            if ("trade".equals(next.getType()) && this.f45640a.getCurrency().equals(next.getCurrency())) {
                this.f45641b = next.getBalance();
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(Object obj) {
        HuobiToastUtil.s(R.string.repay_successfully);
        ((b) getUI()).ch();
        V(false);
    }

    public void V(boolean z11) {
        W().subscribe(new a(z11));
    }

    public final Observable<Boolean> W() {
        return h2.t1().H3(TradeType.MARGIN, false, true, this.f45640a.getSymbol()).compose(RxJavaHelper.t((g) getUI())).map(new p6(this));
    }

    /* renamed from: X */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
        this.f45640a = (LoanOrderItem) getActivity().getIntent().getSerializableExtra("repay_bean");
        bVar.R6(a1.v().J(this.f45640a.getSymbol(), TradeType.PRO));
        V(true);
    }

    public void Y(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("amount", str2);
        ((FinanceService) p.W(FinanceService.class)).repayMargin(str, hashMap).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new o6(this)));
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
