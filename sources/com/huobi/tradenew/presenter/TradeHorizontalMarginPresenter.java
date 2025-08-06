package com.huobi.tradenew.presenter;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.account.entity.SubaccountQueryData;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.MarginSettings;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.tradenew.ui.x1;
import d7.a1;
import dt.h2;
import i6.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k20.h;
import ks.g;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import qt.r;
import rx.Observable;
import rx.Subscriber;
import st.n;
import st.o;
import tq.p;

public class TradeHorizontalMarginPresenter extends TradeHorizontalBasePresenter<x1> {
    public Subscriber<Map<String, Map<String, String>>> J;

    public class a extends BaseSubscriber<List<SymbolBean>> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
            ((x1) TradeHorizontalMarginPresenter.this.getUI()).y0(true);
        }

        public void onStart() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (a1.v().H(TradeHorizontalMarginPresenter.this.f82880n).contains(TradeHorizontalMarginPresenter.this.f82871e)) {
                if (((x1) TradeHorizontalMarginPresenter.this.getUI()).isCanBeSeen()) {
                    a1 v11 = a1.v();
                    TradeHorizontalMarginPresenter tradeHorizontalMarginPresenter = TradeHorizontalMarginPresenter.this;
                    ((x1) TradeHorizontalMarginPresenter.this.getUI()).t(v11.J(tradeHorizontalMarginPresenter.f82871e, tradeHorizontalMarginPresenter.f82880n));
                }
                TradeHorizontalMarginPresenter.this.y1();
                return;
            }
            String str = TradeHorizontalMarginPresenter.this.f82871e;
            if (!a1.v().H(TradeHorizontalMarginPresenter.this.f82880n).isEmpty()) {
                str = a1.v().H(TradeHorizontalMarginPresenter.this.f82880n).get(0);
            }
            TradeHorizontalMarginPresenter.this.G0(str);
        }
    }

    public class b extends BaseSubscriber<Map<String, Map<String, String>>> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(Map<String, Map<String, String>> map) {
            super.onNext(map);
            TradeHorizontalMarginPresenter.this.f82884r = true;
            MarginBalanceQueryData y12 = h2.t1().y1(TradeHorizontalMarginPresenter.this.f82871e);
            int f11 = g.f();
            Map map2 = map.get(TradeHorizontalMarginPresenter.this.f82871e);
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
                TradeHorizontalMarginPresenter tradeHorizontalMarginPresenter = TradeHorizontalMarginPresenter.this;
                tradeHorizontalMarginPresenter.f82877k.l0(tradeHorizontalMarginPresenter.f82871e, map2);
                TradeHorizontalMarginPresenter tradeHorizontalMarginPresenter2 = TradeHorizontalMarginPresenter.this;
                tradeHorizontalMarginPresenter2.f82877k.m0(tradeHorizontalMarginPresenter2.f82871e, hashMap);
            } else {
                TradeHorizontalMarginPresenter tradeHorizontalMarginPresenter3 = TradeHorizontalMarginPresenter.this;
                tradeHorizontalMarginPresenter3.f82877k.m0(tradeHorizontalMarginPresenter3.f82871e, hashMap);
            }
            TradeHorizontalMarginPresenter.this.W1();
            TradeHorizontalMarginPresenter.this.V1();
            ((x1) TradeHorizontalMarginPresenter.this.getUI()).B1(y12, TradeHorizontalMarginPresenter.this.f82871e);
            if (y12 == null || !y12.isLiquidation()) {
                ((x1) TradeHorizontalMarginPresenter.this.getUI()).k(8, TradeHorizontalMarginPresenter.this.f82871e);
            } else {
                ((x1) TradeHorizontalMarginPresenter.this.getUI()).k(0, TradeHorizontalMarginPresenter.this.f82871e);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            TradeHorizontalMarginPresenter tradeHorizontalMarginPresenter = TradeHorizontalMarginPresenter.this;
            if (!tradeHorizontalMarginPresenter.f82884r) {
                tradeHorizontalMarginPresenter.l2();
            }
        }
    }

    public class c extends BaseSubscriber<MarginSettings> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(MarginSettings marginSettings) {
            super.onNext(marginSettings);
            TradeHorizontalMarginPresenter tradeHorizontalMarginPresenter = TradeHorizontalMarginPresenter.this;
            tradeHorizontalMarginPresenter.f82877k.d0(tradeHorizontalMarginPresenter.f82871e, marginSettings);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable o2(Long l11) {
        return h2.t1().A3(this.f82880n, false, true, this.f82871e);
    }

    public static /* synthetic */ Boolean p2(Map map) {
        return Boolean.valueOf(map != null);
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    public void V1() {
        String str;
        String n11 = a1.v().n(this.f82871e);
        String D = a1.v().D(this.f82871e);
        MarginBalanceQueryData y12 = h2.t1().y1(this.f82871e);
        String str2 = "--";
        if (y12 != null) {
            str2 = m.u(y12.getLoanAndInterest(n11).toPlainString(), PrecisionUtil.r());
            str = m.u(y12.getLoanAndInterest(D).toPlainString(), PrecisionUtil.r());
        } else if (this.f82884r) {
            str2 = m.u("0", PrecisionUtil.r());
            str = m.u("0", PrecisionUtil.r());
        } else {
            str = str2;
        }
        ((x1) getUI()).zd(str2, str);
    }

    public void W1() {
        String str = this.f82871e;
        ((x1) getUI()).le(str, this.f82877k.y(str, ((x1) getUI()).S1()), this.f82877k.y(this.f82871e, ((x1) getUI()).c2()));
    }

    public void Z1() {
    }

    @h
    @Keep
    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((x1) getUI()).isCanBeSeen()) {
            if (Z0() != symbolChangeEvent.e()) {
                EventBus.d().k(symbolChangeEvent.e());
            }
            super.afterSymbolIdChanged(symbolChangeEvent);
            String b11 = symbolChangeEvent.b();
            s2();
            w2();
            ((x1) getUI()).k(8, b11);
            ((x1) getUI()).B1((MarginBalanceQueryData) null, this.f82871e);
        }
    }

    public void c1(boolean z11, String str, boolean z12) {
        if (z12) {
            ((x1) getUI()).b3();
        }
        u2();
    }

    public final Subscriber<Map<String, Map<String, String>>> j2() {
        return new b();
    }

    public final BaseSubscriber<List<SymbolBean>> k2() {
        return new a();
    }

    public final void l2() {
        this.f82884r = false;
        this.f82877k.l0(this.f82871e, (Map<String, String>) null);
        this.f82877k.m0(this.f82871e, (Map<String, String>) null);
        W1();
        V1();
    }

    public final void m2() {
        ((FinanceService) p.W(FinanceService.class)).marginSettings(this.f82871e).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
    }

    public final void n2() {
        a1.v().Y(false, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(k2());
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onChangeMarginEvent(nt.a aVar) {
        super.onChangeMarginEvent(aVar);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onErrorCodeEvent(mo.a aVar) {
        if (((x1) getUI()).isCanBeSeen()) {
            ((x1) getUI()).B1((MarginBalanceQueryData) null, this.f82871e);
            ((x1) getUI()).L0();
            super.onErrorCodeEvent(aVar);
        }
    }

    public void onPause() {
        super.onPause();
        v2();
    }

    /* renamed from: r2 */
    public void u1(BaseCoreActivity baseCoreActivity, x1 x1Var) {
        super.onUIReady(baseCoreActivity, x1Var);
        this.f82888v = 1;
        EventBus.d().p(this);
    }

    public final void s2() {
        SymbolBean J2;
        if (r.b() && (J2 = a1.v().J(this.f82871e, TradeType.PRO)) != null) {
            String leverageRatio = J2.getLeverageRatio();
            ((x1) getUI()).p(0, leverageRatio + "X");
        }
    }

    public void t0() {
        super.t0();
        v2();
    }

    public void t1() {
        is.a.j("4249", (Map<String, Object>) null, "1000101");
    }

    public final void t2() {
        if (g.k()) {
            u2();
            return;
        }
        P0();
        u2();
    }

    public void u2() {
        v2();
        if (tg.r.x().F0()) {
            this.J = j2();
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new st.m(this)).filter(n.f29228b).retryWhen(o.f29230b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.J);
        }
    }

    public void v0() {
        super.v0();
        if (!(g.d() == ((x1) getUI()).S1() && g.h() == ((x1) getUI()).c2())) {
            if (g.j()) {
                ((x1) getUI()).U1(1, false);
            } else {
                ((x1) getUI()).U1(2, false);
            }
        }
        boolean F0 = tg.r.x().F0();
        ((x1) getUI()).B1((MarginBalanceQueryData) null, this.f82871e);
        if (F0) {
            ((x1) getUI()).k(8, this.f82871e);
        }
        n2();
        s2();
        w2();
        m2();
        t2();
    }

    public void v2() {
        Subscriber<Map<String, Map<String, String>>> subscriber = this.J;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void w1() {
        n2();
    }

    public final void w2() {
        SymbolBean J2 = a1.v().J(this.f82871e, this.f82880n);
        if (J2 != null) {
            ((x1) getUI()).M0(!TextUtils.isEmpty(J2.getSuperMarginLeverageRatio()));
        }
    }
}
