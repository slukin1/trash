package com.huobi.quicktrade.order.presenter;

import al.p;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.trade.bean.TradeHoldBean;
import d7.a1;
import d7.k;
import dt.h2;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pq.e;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import tg.r;
import u6.g;

public class QuickTradeOrderVerticalSpotPresenter extends QuickTradeOrderBasePresenter<e> {

    /* renamed from: n  reason: collision with root package name */
    public Subscription f80528n;

    public class a implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f80529b;

        /* renamed from: com.huobi.quicktrade.order.presenter.QuickTradeOrderVerticalSpotPresenter$a$a  reason: collision with other inner class name */
        public class C0846a extends BaseSubscriber<BalanceDataTotal> {
            public C0846a() {
            }

            /* renamed from: a */
            public void onNext(BalanceDataTotal balanceDataTotal) {
                super.onNext(balanceDataTotal);
                QuickTradeOrderVerticalSpotPresenter quickTradeOrderVerticalSpotPresenter = QuickTradeOrderVerticalSpotPresenter.this;
                quickTradeOrderVerticalSpotPresenter.f80519f.y1(quickTradeOrderVerticalSpotPresenter.f80517d, quickTradeOrderVerticalSpotPresenter.f80526m, quickTradeOrderVerticalSpotPresenter.f80520g);
            }
        }

        public a(boolean z11) {
            this.f80529b = z11;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(BalanceDataTotal balanceDataTotal) {
            QuickTradeOrderVerticalSpotPresenter.this.x0(balanceDataTotal);
        }

        /* renamed from: b */
        public void call(Long l11) {
            h2.t1().K1(this.f80529b).doOnNext(new oq.a(this)).compose(RxJavaHelper.t((g) QuickTradeOrderVerticalSpotPresenter.this.getUI())).subscribe(new C0846a());
        }
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    public void b0() {
        super.b0();
        Subscription subscription = this.f80528n;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void c0() {
        super.c0();
        s0();
        u0();
        g0(false, this.f80517d, true);
    }

    public void g0(boolean z11, String str, boolean z12) {
        if (r.x().F0()) {
            Subscription subscription = this.f80528n;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.f80528n = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new a(z11)).subscribe(new BaseSubscriber());
        }
    }

    /* renamed from: j0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, e eVar) {
        super.onUIReady(baseCoreActivity, eVar);
        this.f80523j = 0;
        EventBus.d().p(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onErrorCodeEvent(mo.a aVar) {
        super.onErrorCodeEvent(aVar);
    }

    public void s0() {
        if (r.x().F0()) {
            ((e) getUI()).D1(0);
        } else {
            ((e) getUI()).D1(8);
        }
    }

    public void u0() {
        if (!r.x().F0()) {
            ((e) getUI()).D1(8);
        } else if (this.f80523j == 0) {
            ((e) getUI()).D1(8);
        } else {
            ((e) getUI()).D1(0);
        }
    }

    public final void x0(BalanceDataTotal balanceDataTotal) {
        TradeHoldBean tradeHoldBean;
        TradeHoldBean tradeHoldBean2;
        Map<String, BalanceDetailInfo> detailInfoMap = balanceDataTotal.getDetailInfoMap();
        SymbolBean J = a1.v().J(this.f80517d, this.f80520g);
        ArrayList arrayList = new ArrayList();
        if (detailInfoMap != null && J != null) {
            BalanceDetailInfo balanceDetailInfo = detailInfoMap.get(J.getBaseCurrency());
            if (balanceDetailInfo != null) {
                tradeHoldBean = new TradeHoldBean();
                tradeHoldBean.setAvailable(p.j(balanceDetailInfo.getAvaialAble(), J.getBaseCurrency()));
                tradeHoldBean.setNetAsset(p.j(balanceDetailInfo.getNetBalance(), J.getBaseCurrency()));
                tradeHoldBean.setEstimateTotal(balanceDetailInfo.getEstimateAmount());
                if (m.a(balanceDataTotal.getNetAsset()).compareTo(BigDecimal.ZERO) == 0) {
                    tradeHoldBean.setPercent("0.00%");
                } else {
                    tradeHoldBean.setPercent(m.Q(m.a(balanceDetailInfo.getEstimateAmount()).divide(m.a(balanceDataTotal.getNetAsset()), 32, 1).toPlainString(), 2, 1));
                }
            } else {
                tradeHoldBean = new TradeHoldBean();
                tradeHoldBean.setAvailable("0.00");
                tradeHoldBean.setNetAsset("0.00");
                tradeHoldBean.setEstimateTotal("0.00");
                tradeHoldBean.setPercent("0.00%");
            }
            tradeHoldBean.setDisplayName(J.getBaseCurrencyDisplayName());
            tradeHoldBean.setFullDisplayName(k.C().B(J.getBaseCurrency()));
            tradeHoldBean.setCurrencyInfo(balanceDetailInfo);
            arrayList.add(tradeHoldBean);
            BalanceDetailInfo balanceDetailInfo2 = detailInfoMap.get(J.getQuoteCurrency());
            if (balanceDetailInfo2 != null) {
                tradeHoldBean2 = new TradeHoldBean();
                tradeHoldBean2.setAvailable(p.j(balanceDetailInfo2.getAvaialAble(), J.getQuoteCurrency()));
                tradeHoldBean2.setNetAsset(p.j(balanceDetailInfo2.getNetBalance(), J.getQuoteCurrency()));
                tradeHoldBean2.setEstimateTotal(balanceDetailInfo2.getEstimateAmount());
                if (m.a(balanceDataTotal.getNetAsset()).compareTo(BigDecimal.ZERO) == 0) {
                    tradeHoldBean2.setPercent("0.00%");
                } else {
                    tradeHoldBean2.setPercent(m.Q(m.a(balanceDetailInfo2.getEstimateAmount()).divide(m.a(balanceDataTotal.getNetAsset()), 32, 1).toPlainString(), 2, 1));
                }
            } else {
                tradeHoldBean2 = new TradeHoldBean();
                tradeHoldBean2.setAvailable("0.00");
                tradeHoldBean2.setNetAsset("0.00");
                tradeHoldBean2.setEstimateTotal("0.00");
                tradeHoldBean2.setPercent("0.00%");
            }
            tradeHoldBean2.setDisplayName(J.getQuoteCurrencyDisplayName());
            tradeHoldBean2.setFullDisplayName(k.C().B(J.getQuoteCurrency()));
            tradeHoldBean2.setCurrencyInfo(balanceDetailInfo2);
            arrayList.add(tradeHoldBean2);
            synchronized (this.f80526m) {
                this.f80526m.clear();
                this.f80526m.addAll(arrayList);
            }
        }
    }
}
