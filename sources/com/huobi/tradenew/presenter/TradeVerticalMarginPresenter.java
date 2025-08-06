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
import com.huobi.tradenew.ui.o3;
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
import qt.q;
import qt.r;
import rx.Observable;
import rx.Subscriber;
import st.h0;
import st.i0;
import st.j0;
import tq.p;

public class TradeVerticalMarginPresenter extends TradeVerticalBasePresenter<o3> {
    public Subscriber<Map<String, Map<String, String>>> M;

    public class a extends BaseSubscriber<List<SymbolBean>> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
            ((o3) TradeVerticalMarginPresenter.this.getUI()).y0(true);
        }

        public void onStart() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (a1.v().H(TradeVerticalMarginPresenter.this.f82880n).contains(TradeVerticalMarginPresenter.this.f82871e)) {
                if (((o3) TradeVerticalMarginPresenter.this.getUI()).isCanBeSeen()) {
                    a1 v11 = a1.v();
                    TradeVerticalMarginPresenter tradeVerticalMarginPresenter = TradeVerticalMarginPresenter.this;
                    ((o3) TradeVerticalMarginPresenter.this.getUI()).t(v11.J(tradeVerticalMarginPresenter.f82871e, tradeVerticalMarginPresenter.f82880n));
                }
                TradeVerticalMarginPresenter.this.y1();
                return;
            }
            String str = TradeVerticalMarginPresenter.this.f82871e;
            if (!a1.v().H(TradeVerticalMarginPresenter.this.f82880n).isEmpty()) {
                str = a1.v().H(TradeVerticalMarginPresenter.this.f82880n).get(0);
            }
            TradeVerticalMarginPresenter.this.G0(str);
        }
    }

    public class b extends BaseSubscriber<Map<String, Map<String, String>>> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(Map<String, Map<String, String>> map) {
            super.onNext(map);
            TradeVerticalMarginPresenter.this.f82884r = true;
            MarginBalanceQueryData y12 = h2.t1().y1(TradeVerticalMarginPresenter.this.f82871e);
            int f11 = g.f();
            Map map2 = map.get(TradeVerticalMarginPresenter.this.f82871e);
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
                tradeVerticalMarginPresenter.f82877k.l0(tradeVerticalMarginPresenter.f82871e, map2);
                TradeVerticalMarginPresenter tradeVerticalMarginPresenter2 = TradeVerticalMarginPresenter.this;
                tradeVerticalMarginPresenter2.f82877k.m0(tradeVerticalMarginPresenter2.f82871e, hashMap);
            } else {
                TradeVerticalMarginPresenter tradeVerticalMarginPresenter3 = TradeVerticalMarginPresenter.this;
                tradeVerticalMarginPresenter3.f82877k.m0(tradeVerticalMarginPresenter3.f82871e, hashMap);
            }
            TradeVerticalMarginPresenter.this.W1();
            TradeVerticalMarginPresenter.this.V1();
            ((o3) TradeVerticalMarginPresenter.this.getUI()).B1(y12, TradeVerticalMarginPresenter.this.f82871e);
            if (y12 == null || !y12.isLiquidation()) {
                ((o3) TradeVerticalMarginPresenter.this.getUI()).k(8, TradeVerticalMarginPresenter.this.f82871e);
            } else {
                ((o3) TradeVerticalMarginPresenter.this.getUI()).k(0, TradeVerticalMarginPresenter.this.f82871e);
            }
        }
    }

    public class c extends BaseSubscriber<MarginSettings> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(MarginSettings marginSettings) {
            super.onNext(marginSettings);
            TradeVerticalMarginPresenter tradeVerticalMarginPresenter = TradeVerticalMarginPresenter.this;
            tradeVerticalMarginPresenter.f82877k.d0(tradeVerticalMarginPresenter.f82871e, marginSettings);
        }
    }

    public class d extends BaseSubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f82961b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f82962c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f82963d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f82964e;

        public d(String str, String str2, boolean z11, String str3) {
            this.f82961b = str;
            this.f82962c = str2;
            this.f82963d = z11;
            this.f82964e = str3;
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool != null && bool.booleanValue()) {
                TradeVerticalMarginPresenter.super.Q1(this.f82961b, this.f82962c, this.f82963d, this.f82964e);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable C2(Long l11) {
        return h2.t1().A3(this.f82880n, false, true, this.f82871e);
    }

    public static /* synthetic */ Boolean D2(Map map) {
        return Boolean.valueOf(map != null);
    }

    public final void A2() {
        ((FinanceService) p.W(FinanceService.class)).marginSettings(this.f82871e).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
    }

    public final void B2() {
        a1.v().Y(false, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(y2());
    }

    /* renamed from: F2 */
    public void u1(BaseCoreActivity baseCoreActivity, o3 o3Var) {
        super.onUIReady(baseCoreActivity, o3Var);
        this.f82888v = 1;
        EventBus.d().p(this);
    }

    public final void G2() {
        SymbolBean J;
        if (r.b() && (J = a1.v().J(this.f82871e, TradeType.PRO)) != null) {
            String leverageRatio = J.getLeverageRatio();
            ((o3) getUI()).p(0, leverageRatio + "X");
        }
    }

    public final void H2() {
        if (g.k()) {
            I2();
            return;
        }
        P0();
        I2();
    }

    public void I2() {
        Subscriber<Map<String, Map<String, String>>> subscriber = this.M;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (tg.r.x().F0()) {
            this.M = x2();
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new h0(this)).filter(i0.f29218b).retryWhen(j0.f29220b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.M);
        }
    }

    public void J2() {
        Subscriber<Map<String, Map<String, String>>> subscriber = this.M;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void K2() {
        SymbolBean J = a1.v().J(this.f82871e, this.f82880n);
        if (J != null) {
            ((o3) getUI()).M0(!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()));
        }
    }

    public void Q1(String str, String str2, boolean z11, String str3) {
        z2(new d(str, str2, z11, str3));
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    public void V1() {
        String str;
        String str2;
        if (e1()) {
            str = a1.v().n(this.f82871e);
        } else {
            str = a1.v().D(this.f82871e);
        }
        MarginBalanceQueryData y12 = h2.t1().y1(this.f82871e);
        if (y12 != null) {
            str2 = m.u(y12.getLoanAndInterest(str).toPlainString(), PrecisionUtil.r());
        } else {
            str2 = this.f82884r ? m.u("0", PrecisionUtil.r()) : "--";
        }
        ((o3) getUI()).h1(str2);
    }

    public void W1() {
        int i11;
        if (e1()) {
            i11 = ((o3) getUI()).S1();
        } else {
            i11 = ((o3) getUI()).c2();
        }
        String str = this.f82871e;
        ((o3) getUI()).cd(str, this.f82877k.y(str, i11), e1());
        a2();
    }

    public void Z1() {
    }

    @h
    @Keep
    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((o3) getUI()).isCanBeSeen()) {
            if (Z0() != symbolChangeEvent.e()) {
                EventBus.d().k(symbolChangeEvent.e());
            }
            super.afterSymbolIdChanged(symbolChangeEvent);
            ((o3) getUI()).b3();
            G2();
            K2();
            ((o3) getUI()).B1((MarginBalanceQueryData) null, this.f82871e);
            ((o3) getUI()).k(8, this.f82871e);
        }
    }

    public void c1(boolean z11, String str, boolean z12) {
        if (z12) {
            ((o3) getUI()).b3();
        }
        I2();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onChangeMarginEvent(nt.a aVar) {
        super.onChangeMarginEvent(aVar);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onErrorCodeEvent(mo.a aVar) {
        if (((o3) getUI()).isCanBeSeen()) {
            ((o3) getUI()).B1((MarginBalanceQueryData) null, this.f82871e);
            ((o3) getUI()).L0();
            super.onErrorCodeEvent(aVar);
        }
    }

    public void onPause() {
        super.onPause();
        J2();
    }

    public void t0() {
        super.t0();
        J2();
    }

    public void t1() {
        is.a.j("4249", (Map<String, Object>) null, "1000101");
    }

    public void v0() {
        super.v0();
        if (!(g.d() == ((o3) getUI()).S1() && g.h() == ((o3) getUI()).c2())) {
            if (g.j()) {
                ((o3) getUI()).U1(1, false);
            } else {
                ((o3) getUI()).U1(2, false);
            }
        }
        boolean F0 = tg.r.x().F0();
        ((o3) getUI()).B1((MarginBalanceQueryData) null, this.f82871e);
        if (!F0) {
            ((o3) getUI()).k(8, this.f82871e);
        }
        B2();
        G2();
        K2();
        A2();
        H2();
    }

    public void w1() {
        B2();
    }

    public Subscriber<Map<String, Map<String, String>>> x2() {
        return new b();
    }

    public final BaseSubscriber<List<SymbolBean>> y2() {
        return new a();
    }

    public void z2(BaseSubscriber<Boolean> baseSubscriber) {
        q.d(getActivity(), (u6.g) getUI(), "MARGIN", baseSubscriber);
    }
}
