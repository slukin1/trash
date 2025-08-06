package com.huobi.trade.presenter;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.pro.core.bean.MaxOrderAmountBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.entity.AccountType;
import com.huobi.account.entity.SubaccountQueryData;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.MarginSettings;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.store.AppConfigManager;
import com.huobi.supermargin.helper.MarginRiskRateUtil;
import com.huobi.trade.event.ShowMarginGuideEvent;
import com.huobi.trade.helper.w;
import com.huobi.trade.helper.x;
import com.huobi.trade.ui.l4;
import com.huobi.trade.utils.TradeTimeMonitorUtils;
import d7.a1;
import dt.h2;
import et.n;
import et.o;
import et.q;
import et.s;
import i6.m;
import ij.j;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k20.h;
import ks.g;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;
import tg.r;
import tq.p;

public class TradeVerticalMarginPresenter extends TradeVerticalBasePresenter<l4> {
    public Subscriber<Pair<Map<String, Map<String, String>>, MaxOrderAmountBean>> K;
    public Subscriber<MarginSettings> L;

    public class a extends BaseSubscriber<Boolean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool != null && bool.booleanValue()) {
                ((l4) TradeVerticalMarginPresenter.this.getUI()).Nb(false);
            }
        }
    }

    public class b extends BaseSubscriber<List<SymbolBean>> {
        public b() {
        }

        public void onAfter() {
            super.onAfter();
            ((l4) TradeVerticalMarginPresenter.this.getUI()).y0(true);
        }

        public void onStart() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (a1.v().H(TradeVerticalMarginPresenter.this.f82105p).contains(TradeVerticalMarginPresenter.this.f82094e)) {
                if (((l4) TradeVerticalMarginPresenter.this.getUI()).isCanBeSeen()) {
                    a1 v11 = a1.v();
                    TradeVerticalMarginPresenter tradeVerticalMarginPresenter = TradeVerticalMarginPresenter.this;
                    ((l4) TradeVerticalMarginPresenter.this.getUI()).t(v11.J(tradeVerticalMarginPresenter.f82094e, tradeVerticalMarginPresenter.f82105p));
                }
                TradeVerticalMarginPresenter.this.r1();
                return;
            }
            String str = TradeVerticalMarginPresenter.this.f82094e;
            if (!a1.v().H(TradeVerticalMarginPresenter.this.f82105p).isEmpty()) {
                str = a1.v().H(TradeVerticalMarginPresenter.this.f82105p).get(0);
            }
            TradeVerticalMarginPresenter.this.C0(str);
        }
    }

    public class c implements Func2<Map<String, Map<String, String>>, MaxOrderAmountBean, Pair<Map<String, Map<String, String>>, MaxOrderAmountBean>> {
        public c() {
        }

        /* renamed from: a */
        public Pair<Map<String, Map<String, String>>, MaxOrderAmountBean> call(Map<String, Map<String, String>> map, MaxOrderAmountBean maxOrderAmountBean) {
            return new Pair<>(map, maxOrderAmountBean);
        }
    }

    public class d extends BaseSubscriber<Pair<Map<String, Map<String, String>>, MaxOrderAmountBean>> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(Pair<Map<String, Map<String, String>>, MaxOrderAmountBean> pair) {
            super.onNext(pair);
            Map map = (Map) pair.first;
            MaxOrderAmountBean maxOrderAmountBean = (MaxOrderAmountBean) pair.second;
            TradeVerticalMarginPresenter.this.f82109t = true;
            MarginBalanceQueryData y12 = h2.t1().y1(TradeVerticalMarginPresenter.this.f82094e);
            if (map != null) {
                int f11 = g.f();
                Map map2 = (Map) map.get(TradeVerticalMarginPresenter.this.f82094e);
                if (map2 == null) {
                    map2 = new HashMap();
                }
                HashMap hashMap = new HashMap(map2);
                if (f11 == 1) {
                    if (!(y12 == null || y12.getList() == null)) {
                        for (SubaccountQueryData next : y12.getList()) {
                            if ("loan-available".equals(next.getType())) {
                                map2.put(next.getCurrency(), m.a((String) map2.get(next.getCurrency())).add(m.a(next.getBalance()).setScale(PrecisionUtil.k(), 1)).toPlainString());
                            }
                        }
                    }
                    TradeVerticalMarginPresenter tradeVerticalMarginPresenter = TradeVerticalMarginPresenter.this;
                    tradeVerticalMarginPresenter.f82100k.k0(tradeVerticalMarginPresenter.f82094e, map2);
                    TradeVerticalMarginPresenter tradeVerticalMarginPresenter2 = TradeVerticalMarginPresenter.this;
                    tradeVerticalMarginPresenter2.f82100k.l0(tradeVerticalMarginPresenter2.f82094e, hashMap);
                } else {
                    TradeVerticalMarginPresenter tradeVerticalMarginPresenter3 = TradeVerticalMarginPresenter.this;
                    tradeVerticalMarginPresenter3.f82100k.l0(tradeVerticalMarginPresenter3.f82094e, hashMap);
                }
            }
            if (MarginRiskRateUtil.a() && maxOrderAmountBean != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(maxOrderAmountBean.getCurrency(), maxOrderAmountBean.getMaxOrderAmount());
                TradeVerticalMarginPresenter tradeVerticalMarginPresenter4 = TradeVerticalMarginPresenter.this;
                tradeVerticalMarginPresenter4.f82100k.k0(tradeVerticalMarginPresenter4.f82094e, hashMap2);
            }
            TradeVerticalMarginPresenter.this.V1();
            TradeVerticalMarginPresenter.this.U1();
            ((l4) TradeVerticalMarginPresenter.this.getUI()).B1(y12, TradeVerticalMarginPresenter.this.f82094e);
            if (y12 == null || !y12.isLiquidation()) {
                ((l4) TradeVerticalMarginPresenter.this.getUI()).k(8, TradeVerticalMarginPresenter.this.f82094e);
            } else {
                ((l4) TradeVerticalMarginPresenter.this.getUI()).k(0, TradeVerticalMarginPresenter.this.f82094e);
            }
            TradeTimeMonitorUtils.d(5);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            TradeTimeMonitorUtils.b();
        }
    }

    public class e extends BaseSubscriber<MarginSettings> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(MarginSettings marginSettings) {
            super.onNext(marginSettings);
            TradeVerticalMarginPresenter tradeVerticalMarginPresenter = TradeVerticalMarginPresenter.this;
            tradeVerticalMarginPresenter.f82100k.a0(tradeVerticalMarginPresenter.f82094e, marginSettings);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable U2(Long l11) {
        return ((FinanceService) p.W(FinanceService.class)).marginSettings(this.f82094e).compose(p.a0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable W2(Long l11) {
        HashMap hashMap = new HashMap();
        hashMap.put("account-id", l11);
        int i11 = 3;
        hashMap.put("account-type-code", 3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, Integer.valueOf(a1() ? 1 : 0));
        if (((l4) getUI()).S1() == 2) {
            i11 = 2;
        } else if (((l4) getUI()).S1() == 0) {
            i11 = 1;
        } else if (((l4) getUI()).S1() == 3) {
            i11 = 4;
        }
        hashMap.put("margin-order-type", Integer.valueOf(i11));
        hashMap.put("symbol", this.f82094e);
        return x8.a.a().getSuperMarginRiskRate((Map<String, Object>) hashMap).b().compose(RxJavaHelper.t((u6.g) getUI()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Y2(Long l11) {
        if (!MarginRiskRateUtil.a()) {
            return h2.t1().A3(this.f82105p, false, true, this.f82094e).flatMap(q.f54447b);
        }
        return Observable.zip(h2.t1().A3(this.f82105p, false, true, this.f82094e), S2(), new c());
    }

    public void E2(BigDecimal bigDecimal) {
        int i11;
        if (a1.v().p0(this.f82094e) || !r.x().F0() || !AppConfigManager.h(MgtConfigNumber.MARGIN_COUPON.number, "isOpen", false) || (i11 = this.f82103n) == 3) {
            ((l4) getUI()).Yd(8, "", 0);
            return;
        }
        this.E = false;
        CouponReturn couponReturn = this.J;
        int i12 = R.color.baseColorPrimaryText;
        if (couponReturn != null) {
            boolean z11 = i11 == 1 && !a1();
            if (m.a(this.J.getMeetCondition()).compareTo(BigDecimal.ZERO) == 0) {
                this.E = true;
            } else if (z11) {
                this.E = true;
            } else if (bigDecimal != null && m.a(LegalCurrencyConfigUtil.V(bigDecimal.toPlainString(), a1.v().D(this.f82094e), TradeType.PRO)).compareTo(m.a(this.J.getMeetCondition())) >= 0) {
                this.E = true;
            } else {
                i12 = R.color.baseColorSecondaryText;
            }
            String string = getString(R.string.n_exchange_coupon_max_return);
            ((l4) getUI()).Yd(0, String.format(string, new Object[]{this.J.getAmount() + "usdt".toUpperCase()}), i12);
            return;
        }
        ArrayList<CouponReturn> f11 = j.g().f("9", (CouponReturn) null);
        if (f11 == null || f11.size() <= 0) {
            ((l4) getUI()).Yd(8, "", 0);
        } else {
            ((l4) getUI()).Yd(0, String.format(getString(R.string.n_exchange_coupon_available_number), new Object[]{Integer.valueOf(f11.size())}), R.color.baseColorPrimaryText);
        }
    }

    public Subscriber<MarginSettings> L2() {
        return new e();
    }

    public Subscriber<Pair<Map<String, Map<String, String>>, MaxOrderAmountBean>> M2() {
        return new d();
    }

    public final BaseSubscriber<List<SymbolBean>> N2() {
        return new b();
    }

    public final Observable<Long> O2() {
        return h2.t1().D1(AccountType.margin.toString(), this.f82094e);
    }

    public final String P2(Map<String, String> map) {
        String E = a1.v().E(this.f82094e, V0());
        int a11 = PrecisionUtil.a(V0(), E);
        String o11 = a1.v().o(this.f82094e, V0());
        int a12 = PrecisionUtil.a(V0(), o11);
        if (map == null) {
            return "--";
        }
        if (a1()) {
            if (map.get(E) != null) {
                return m.m(map.get(E), a11);
            }
            return m.i(0.0d, a11);
        } else if (map.get(o11) != null) {
            return m.m(map.get(o11), a12);
        } else {
            return m.i(0.0d, a12);
        }
    }

    public void Q2(BaseSubscriber<Boolean> baseSubscriber) {
        if (w.f82084a) {
            baseSubscriber.onNext(Boolean.FALSE);
        } else {
            w.d(getActivity(), (u6.g) getUI(), "MARGIN", baseSubscriber);
        }
    }

    public final void R2() {
        Subscriber<MarginSettings> subscriber = this.L;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (r.x().F0()) {
            this.L = L2();
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new o(this)).retryWhen(s.f54449b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.L);
        }
    }

    public void S1() {
        super.S1();
        int i11 = 8;
        if (a1.v().S(this.f82094e)) {
            ((l4) getUI()).W1(8);
        } else if (r.x().F0()) {
            l4 l4Var = (l4) getUI();
            if (g() == 1) {
                i11 = 0;
            }
            l4Var.W1(i11);
        } else {
            ((l4) getUI()).W1(8);
        }
    }

    public final Observable<MaxOrderAmountBean> S2() {
        return O2().compose(RxJavaHelper.t((u6.g) getUI())).flatMap(new n(this));
    }

    public final void T2() {
        a1.v().Y(false, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(N2());
    }

    public void U1() {
        String str;
        String str2;
        if (a1()) {
            str = a1.v().n(this.f82094e);
        } else {
            str = a1.v().D(this.f82094e);
        }
        MarginBalanceQueryData y12 = h2.t1().y1(this.f82094e);
        if (y12 != null) {
            str2 = m.u(y12.getLoanAndInterest(str).toPlainString(), PrecisionUtil.r());
        } else {
            str2 = this.f82109t ? m.u("0", PrecisionUtil.r()) : "--";
        }
        ((l4) getUI()).h1(str2);
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    public void V1() {
        int i11;
        if (a1()) {
            i11 = ((l4) getUI()).S1();
        } else {
            i11 = ((l4) getUI()).c2();
        }
        Map<String, String> y11 = this.f82100k.y(this.f82094e, i11);
        ((l4) getUI()).i2(P2(this.f82100k.y(this.f82094e, 0)), P2(y11), a1());
        Z1();
    }

    public void Y0(boolean z11, String str, boolean z12) {
        if (z12) {
            ((l4) getUI()).b3();
        }
        e3();
    }

    public void Y1() {
    }

    public void a3() {
        String str;
        if (a1()) {
            str = a1.v().n(this.f82094e);
        } else {
            str = a1.v().D(this.f82094e);
        }
        MarginBalanceQueryData y12 = h2.t1().y1(this.f82094e);
        if (y12 != null) {
            BigDecimal loanAndInterest = y12.getLoanAndInterest(str);
            String str2 = null;
            if (a1()) {
                str2 = m.u(loanAndInterest.toPlainString(), PrecisionUtil.z(this.f82094e));
            } else {
                BigDecimal a11 = m.a(((l4) getUI()).getInputPriceText());
                if (a11.compareTo(BigDecimal.ZERO) != 0) {
                    str2 = m.a(loanAndInterest.toPlainString()).divide(a11, PrecisionUtil.z(this.f82094e), 0).toPlainString();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                ((l4) getUI()).setInputAmountText(str2);
            }
        } else if (this.f82109t) {
            ((l4) getUI()).setInputAmountText(m.u("0", PrecisionUtil.z(this.f82094e)));
        }
    }

    @h
    @Keep
    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((l4) getUI()).isCanBeSeen()) {
            if (V0() != symbolChangeEvent.e()) {
                EventBus.d().k(symbolChangeEvent.e());
            }
            super.afterSymbolIdChanged(symbolChangeEvent);
            ((l4) getUI()).b3();
            c3();
            g3();
            ((l4) getUI()).B1((MarginBalanceQueryData) null, this.f82094e);
            ((l4) getUI()).k(8, this.f82094e);
            S1();
            MarginRiskRateUtil.c(this.f82094e);
        }
    }

    /* renamed from: b3 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, l4 l4Var) {
        super.onUIReady(baseCoreActivity, l4Var);
        EventBus.d().p(this);
    }

    public final void c3() {
        SymbolBean J;
        if (x.b() && (J = a1.v().J(this.f82094e, TradeType.PRO)) != null) {
            String leverageRatio = J.getLeverageRatio();
            ((l4) getUI()).p(0, leverageRatio + "X");
        }
    }

    public final void d3() {
        e3();
    }

    public void e3() {
        Subscriber<Pair<Map<String, Map<String, String>>, MaxOrderAmountBean>> subscriber = this.K;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (r.x().F0()) {
            this.K = M2();
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new et.p(this)).retryWhen(et.r.f54448b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.K);
        }
    }

    public void f3() {
        Subscriber<Pair<Map<String, Map<String, String>>, MaxOrderAmountBean>> subscriber = this.K;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        Subscriber<MarginSettings> subscriber2 = this.L;
        if (subscriber2 != null) {
            subscriber2.unsubscribe();
        }
    }

    public final void g3() {
        SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
        if (J != null) {
            ((l4) getUI()).M0(!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()));
        }
    }

    public void m0() {
        super.m0();
        f3();
    }

    public void m1() {
        is.a.j("4249", (Map<String, Object>) null, "1000101");
    }

    public void n0() {
        super.n0();
        ((l4) getUI()).vf();
        if (!(g.d() == ((l4) getUI()).S1() && g.h() == ((l4) getUI()).c2())) {
            if (g.j()) {
                ((l4) getUI()).U1(1, false);
            } else {
                ((l4) getUI()).U1(2, false);
            }
        }
        boolean F0 = r.x().F0();
        ((l4) getUI()).B1((MarginBalanceQueryData) null, this.f82094e);
        t1();
        if (!F0) {
            ((l4) getUI()).k(8, this.f82094e);
            ((l4) getUI()).Nb(false);
        } else {
            Q2(new a());
        }
        T2();
        c3();
        g3();
        R2();
        d3();
        S1();
        MarginRiskRateUtil.c(this.f82094e);
        MarginRiskRateUtil.b();
    }

    public void o2() {
        if (!r.x().F0() || !AppConfigManager.h(MgtConfigNumber.MARGIN_COUPON.number, "isOpen", false)) {
            this.J = null;
            ((l4) getUI()).Yd(8, "", 0);
        } else if (a1.v().p0(this.f82094e)) {
            ((l4) getUI()).Yd(8, "", 0);
        } else if (this.J == null) {
            ((l4) getUI()).i1();
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onChangeMarginEvent(at.a aVar) {
        super.onChangeMarginEvent(aVar);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onErrorCodeEvent(mo.a aVar) {
        if (((l4) getUI()).isCanBeSeen()) {
            ((l4) getUI()).B1((MarginBalanceQueryData) null, this.f82094e);
            ((l4) getUI()).L0();
            super.onErrorCodeEvent(aVar);
        }
    }

    public void onPause() {
        super.onPause();
        f3();
    }

    public void p1() {
        super.p1();
        T2();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void showGuideEvent(ShowMarginGuideEvent showMarginGuideEvent) {
        if (((l4) getUI()).isCanBeSeen()) {
            ((l4) getUI()).Nb(true);
        }
    }
}
