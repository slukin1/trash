package com.huobi.supermargin.presenter;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.pro.core.bean.MaxOrderAmountBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.entity.AccountType;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.store.AppConfigManager;
import com.huobi.supermargin.bean.MarginLoanAsset;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.supermargin.helper.MarginRiskRateUtil;
import com.huobi.supermargin.service.SuperMarginService;
import com.huobi.trade.event.ShowMarginGuideEvent;
import com.huobi.trade.helper.w;
import com.huobi.trade.helper.x;
import com.huobi.trade.presenter.TradeVerticalBasePresenter;
import com.huobi.trade.utils.TradeTimeMonitorUtils;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import dt.h2;
import i6.m;
import ij.j;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k20.h;
import ms.y;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func3;
import tg.r;
import tq.p;
import u6.g;

public class TradeVerticalSuperMarginPresenter extends TradeVerticalBasePresenter<y> {
    public Subscription K;
    public Subscription L;
    public Subscription M;
    public MarginOverview N;
    public boolean O;

    public class a extends BaseSubscriber<Boolean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool != null && bool.booleanValue()) {
                ((y) TradeVerticalSuperMarginPresenter.this.getUI()).Nb(false);
            }
        }
    }

    public class b extends BaseSubscriber<List<SymbolBean>> {
        public b() {
        }

        public void onAfter() {
            super.onAfter();
            ((y) TradeVerticalSuperMarginPresenter.this.getUI()).y0(true);
        }

        public void onStart() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (a1.v().H(TradeVerticalSuperMarginPresenter.this.f82105p).contains(TradeVerticalSuperMarginPresenter.this.f82094e)) {
                if (((y) TradeVerticalSuperMarginPresenter.this.getUI()).isCanBeSeen()) {
                    ((y) TradeVerticalSuperMarginPresenter.this.getUI()).t(a1.v().J(TradeVerticalSuperMarginPresenter.this.f82094e, TradeVerticalSuperMarginPresenter.this.f82105p));
                }
                TradeVerticalSuperMarginPresenter.this.r1();
                return;
            }
            String Y2 = TradeVerticalSuperMarginPresenter.this.f82094e;
            if (!a1.v().H(TradeVerticalSuperMarginPresenter.this.f82105p).isEmpty()) {
                Y2 = a1.v().H(TradeVerticalSuperMarginPresenter.this.f82105p).get(0);
            }
            TradeVerticalSuperMarginPresenter.this.C0(Y2);
        }
    }

    public class c extends BaseSubscriber<Map<String, String>> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(Map<String, String> map) {
            super.onNext(map);
            boolean unused = TradeVerticalSuperMarginPresenter.this.f82109t = true;
            TradeVerticalSuperMarginPresenter.this.V1();
            TradeVerticalSuperMarginPresenter.this.U1();
            TradeTimeMonitorUtils.d(5);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            TradeTimeMonitorUtils.b();
        }
    }

    public class d extends BaseSubscriber<Long> {

        public class a extends BaseSubscriber<Long> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Long f81341b;

            /* renamed from: com.huobi.supermargin.presenter.TradeVerticalSuperMarginPresenter$d$a$a  reason: collision with other inner class name */
            public class C0850a extends BaseSubscriber<MarginOverview> {
                public C0850a() {
                }

                /* renamed from: a */
                public void onNext(MarginOverview marginOverview) {
                    super.onNext(marginOverview);
                    MarginOverview unused = TradeVerticalSuperMarginPresenter.this.N = marginOverview;
                    boolean unused2 = TradeVerticalSuperMarginPresenter.this.O = true;
                    ((y) TradeVerticalSuperMarginPresenter.this.getUI()).Ac(marginOverview);
                    ((y) TradeVerticalSuperMarginPresenter.this.getUI()).z7(marginOverview);
                    if (TradeVerticalSuperMarginPresenter.this.N == null || !TradeVerticalSuperMarginPresenter.this.N.isLiquidation()) {
                        ((y) TradeVerticalSuperMarginPresenter.this.getUI()).k(8, TradeVerticalSuperMarginPresenter.this.f82094e);
                    } else {
                        ((y) TradeVerticalSuperMarginPresenter.this.getUI()).k(0, TradeVerticalSuperMarginPresenter.this.f82094e);
                    }
                }

                public void onError(Throwable th2) {
                    super.onError(th2);
                    MarginOverview unused = TradeVerticalSuperMarginPresenter.this.N = null;
                    boolean unused2 = TradeVerticalSuperMarginPresenter.this.O = false;
                    ((y) TradeVerticalSuperMarginPresenter.this.getUI()).z7(TradeVerticalSuperMarginPresenter.this.N);
                }
            }

            public a(Long l11) {
                this.f81341b = l11;
            }

            public void onStart() {
                super.onStart();
                MarginOverview unused = TradeVerticalSuperMarginPresenter.this.N = null;
                boolean unused2 = TradeVerticalSuperMarginPresenter.this.O = false;
            }

            public void onNext(Long l11) {
                super.onNext(l11);
                ((SuperMarginService) p.W(SuperMarginService.class)).getMarginOverview(this.f81341b.longValue()).compose(p.a0()).compose(RxJavaHelper.t((g) TradeVerticalSuperMarginPresenter.this.getUI())).subscribe(new C0850a());
            }
        }

        public d() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            MarginOverview unused = TradeVerticalSuperMarginPresenter.this.N = null;
            boolean unused2 = TradeVerticalSuperMarginPresenter.this.O = false;
            ((y) TradeVerticalSuperMarginPresenter.this.getUI()).z7(TradeVerticalSuperMarginPresenter.this.N);
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            if (l11 == null || l11.longValue() == 0) {
                boolean unused = TradeVerticalSuperMarginPresenter.this.O = true;
                MarginOverview unused2 = TradeVerticalSuperMarginPresenter.this.N = null;
                ((y) TradeVerticalSuperMarginPresenter.this.getUI()).Ac((MarginOverview) null);
                ((y) TradeVerticalSuperMarginPresenter.this.getUI()).k(8, TradeVerticalSuperMarginPresenter.this.f82094e);
                ((y) TradeVerticalSuperMarginPresenter.this.getUI()).z7(TradeVerticalSuperMarginPresenter.this.N);
                return;
            }
            if (TradeVerticalSuperMarginPresenter.this.L != null) {
                TradeVerticalSuperMarginPresenter.this.L.unsubscribe();
            }
            Subscription unused3 = TradeVerticalSuperMarginPresenter.this.L = Observable.interval(0, 3000, TimeUnit.MILLISECONDS).subscribe(new a(l11));
        }
    }

    public class e extends BaseSubscriber<Long> {
        public e() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            TradeVerticalSuperMarginPresenter.this.j3();
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            TradeVerticalSuperMarginPresenter.this.D3(l11);
        }
    }

    public class f extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Long f81345b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f81346c;

        public class a implements Func2<Map<String, String>, List<MarginLoanAsset>, ArrayList<Object>> {
            public a() {
            }

            /* renamed from: a */
            public ArrayList<Object> call(Map<String, String> map, List<MarginLoanAsset> list) {
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(map);
                arrayList.add(list);
                return arrayList;
            }
        }

        public class b implements Func3<Map<String, String>, List<MarginLoanAsset>, MaxOrderAmountBean, ArrayList<Object>> {
            public b() {
            }

            /* renamed from: a */
            public ArrayList<Object> call(Map<String, String> map, List<MarginLoanAsset> list, MaxOrderAmountBean maxOrderAmountBean) {
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(map);
                arrayList.add(list);
                arrayList.add(maxOrderAmountBean);
                return arrayList;
            }
        }

        public class c extends BaseSubscriber<ArrayList<Object>> {
            public c() {
            }

            /* renamed from: a */
            public void onNext(ArrayList<Object> arrayList) {
                super.onNext(arrayList);
                TradeVerticalSuperMarginPresenter.this.w3((Map) arrayList.get(0), (List) arrayList.get(1), arrayList.size() >= 3 ? (MaxOrderAmountBean) arrayList.get(2) : null);
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                if (!TradeVerticalSuperMarginPresenter.this.f82109t) {
                    TradeVerticalSuperMarginPresenter.this.j3();
                }
                TradeTimeMonitorUtils.b();
            }
        }

        public f(Long l11, String str) {
            this.f81345b = l11;
            this.f81346c = str;
        }

        public void onNext(Long l11) {
            Observable<R> observable;
            Class cls = SuperMarginService.class;
            super.onNext(l11);
            if (!MarginRiskRateUtil.a()) {
                observable = Observable.zip(h2.t1().y3(TradeVerticalSuperMarginPresenter.this.f82105p, false), ((SuperMarginService) p.W(cls)).getMarginLoanAsset(this.f81345b.longValue(), this.f81346c).compose(p.a0()), new a());
            } else {
                observable = Observable.zip(h2.t1().y3(TradeVerticalSuperMarginPresenter.this.f82105p, false), ((SuperMarginService) p.W(cls)).getMarginLoanAsset(this.f81345b.longValue(), this.f81346c).compose(p.a0()), TradeVerticalSuperMarginPresenter.this.l3(), new b());
            }
            observable.compose(RxJavaHelper.t((g) TradeVerticalSuperMarginPresenter.this.getUI())).subscribe(new c());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable q3(Long l11) {
        HashMap hashMap = new HashMap();
        if (l11.longValue() != 0) {
            hashMap.put("account-id", l11);
        }
        hashMap.put("account-type-code", 9);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, Integer.valueOf(a1() ? 1 : 0));
        int i11 = 2;
        if (((y) getUI()).S1() != 2) {
            if (((y) getUI()).S1() == 0) {
                i11 = 1;
            } else {
                i11 = ((y) getUI()).S1() == 3 ? 4 : 3;
            }
        }
        hashMap.put("margin-order-type", Integer.valueOf(i11));
        hashMap.put("symbol", this.f82094e);
        return x8.a.a().getSuperMarginRiskRate((Map<String, Object>) hashMap).b().compose(RxJavaHelper.t((g) getUI()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable r3(Long l11) {
        return h2.t1().y3(this.f82105p, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u3(Map map) {
        this.f82100k.q0(this.f82105p, map);
    }

    public void A3() {
        int f11 = ks.g.f();
        if (f11 == 1) {
            C3();
        } else if (f11 == 2) {
            z3();
        }
    }

    public final void B3() {
        if (ks.g.k()) {
            int f11 = ks.g.f();
            if (f11 == 0) {
                z3();
            } else if (f11 == 1) {
                C3();
            } else if (f11 == 2) {
                z3();
            }
        } else if (ks.g.f() == 1) {
            C3();
        } else {
            z3();
        }
    }

    public final void C3() {
        if (r.x().F0()) {
            Subscription subscription = this.K;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            h2.t1().b1(this.f82105p, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).compose(RxJavaHelper.t((g) null)).subscribe(new e());
        }
    }

    public final void D3(Long l11) {
        if (l11 == null || l11.longValue() == 0) {
            this.f82100k.r0(this.f82105p, new HashMap());
            this.f82100k.q0(this.f82105p, new HashMap());
            this.f82109t = true;
            V1();
            U1();
            return;
        }
        Subscription subscription = this.M;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        String n11 = a1.v().n(this.f82094e);
        String D = a1.v().D(this.f82094e);
        this.M = Observable.interval(0, 3000, TimeUnit.MILLISECONDS).subscribe(new f(l11, n11 + Constants.ACCEPT_TIME_SEPARATOR_SP + D));
    }

    public void E2(BigDecimal bigDecimal) {
        int i11;
        if (a1.v().p0(this.f82094e) || !r.x().F0() || !AppConfigManager.h(MgtConfigNumber.MARGIN_COUPON.number, "isOpen", false) || (i11 = this.f82103n) == 3) {
            ((y) getUI()).Yd(8, "", 0);
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
            ((y) getUI()).Yd(0, String.format(string, new Object[]{this.J.getAmount() + "usdt".toUpperCase()}), i12);
            return;
        }
        int h11 = j.g().h("9,12");
        if (h11 > 0) {
            ((y) getUI()).Yd(0, String.format(getString(R.string.n_exchange_coupon_available_number), new Object[]{Integer.valueOf(h11)}), R.color.baseColorPrimaryText);
        } else {
            ((y) getUI()).Yd(8, "", 0);
        }
    }

    public final void E3() {
        if (r.x().F0()) {
            h2.t1().b1(this.f82105p, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).compose(RxJavaHelper.t((g) getUI())).subscribe(new d());
        }
    }

    public void F3() {
        Subscription subscription = this.K;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.L;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        Subscription subscription3 = this.M;
        if (subscription3 != null) {
            subscription3.unsubscribe();
        }
    }

    public final void H3() {
        SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
        if (J != null) {
            ((y) getUI()).M0(!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()));
        }
    }

    public void S1() {
        super.S1();
        int i11 = 8;
        if (a1.v().S(this.f82094e)) {
            ((y) getUI()).W1(8);
        } else if (r.x().F0()) {
            y yVar = (y) getUI();
            if (g() == 1 || g() == 3) {
                i11 = 0;
            }
            yVar.W1(i11);
        } else {
            ((y) getUI()).W1(8);
        }
    }

    public void U1() {
        String str;
        String str2;
        if (a1()) {
            str = a1.v().n(this.f82094e);
        } else {
            str = a1.v().D(this.f82094e);
        }
        MarginLoanAsset A = this.f82100k.A(str);
        if (A != null) {
            str2 = m.u(A.getLoanAndInterest().toPlainString(), PrecisionUtil.r());
        } else {
            str2 = this.f82109t ? m.u("0", PrecisionUtil.r()) : "--";
        }
        ((y) getUI()).h1(str2);
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    public void V1() {
        Map<String, String> map;
        if (a1()) {
            map = this.f82100k.F(this.f82105p, ((y) getUI()).S1());
        } else {
            map = this.f82100k.F(this.f82105p, ((y) getUI()).c2());
        }
        ((y) getUI()).i2(i3(this.f82100k.F(this.f82105p, 0)), i3(map), a1());
        Z1();
    }

    public void Y0(boolean z11, String str, boolean z12) {
        if (r.x().F0()) {
            if (z12) {
                ((y) getUI()).b3();
            }
            A3();
            E3();
        }
    }

    public void Y1() {
    }

    @h
    @Keep
    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((y) getUI()).isCanBeSeen()) {
            if (V0() != symbolChangeEvent.e()) {
                EventBus.d().k(symbolChangeEvent.e());
            }
            super.afterSymbolIdChanged(symbolChangeEvent);
            ((y) getUI()).b3();
            y3();
            H3();
            ((y) getUI()).Ac((MarginOverview) null);
            ((y) getUI()).k(8, this.f82094e);
            S1();
            MarginRiskRateUtil.d(D0());
        }
    }

    public final BaseSubscriber<List<SymbolBean>> g3() {
        return new b();
    }

    public final Observable<Long> h3() {
        return h2.t1().b1(this.f82105p, AccountType.supermargin.toString());
    }

    public final String i3(Map<String, String> map) {
        String E = a1.v().E(this.f82094e, this.f82105p);
        int a11 = PrecisionUtil.a(this.f82105p, E);
        String o11 = a1.v().o(this.f82094e, this.f82105p);
        int a12 = PrecisionUtil.a(this.f82105p, o11);
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

    public final void j3() {
        this.f82109t = false;
        this.f82100k.r0(this.f82105p, (Map<String, String>) null);
        this.f82100k.q0(this.f82105p, (Map<String, String>) null);
        V1();
        U1();
    }

    public void k3(BaseSubscriber<Boolean> baseSubscriber) {
        if (w.f82084a) {
            baseSubscriber.onNext(Boolean.FALSE);
        } else {
            w.d(getActivity(), (g) getUI(), "SUPER_MARGIN", baseSubscriber);
        }
    }

    public final Observable<MaxOrderAmountBean> l3() {
        return h3().compose(RxJavaHelper.t((g) getUI())).flatMap(new ls.c(this));
    }

    public void m0() {
        super.m0();
        F3();
    }

    public void m1() {
        is.a.j("4248", (Map<String, Object>) null, "1000100");
    }

    public final void m3() {
        a1.v().Y(false, false).compose(RxJavaHelper.t((g) getUI())).subscribe(g3());
    }

    public void n0() {
        super.n0();
        ((y) getUI()).vf();
        if (!(ks.g.d() == ((y) getUI()).S1() && ks.g.h() == ((y) getUI()).c2())) {
            if (ks.g.j()) {
                ((y) getUI()).U1(1, false);
            } else {
                ((y) getUI()).U1(2, false);
            }
        }
        boolean F0 = r.x().F0();
        ((y) getUI()).Ac((MarginOverview) null);
        t1();
        if (!F0) {
            ((y) getUI()).k(8, this.f82094e);
            ((y) getUI()).Nb(false);
        } else {
            k3(new a());
        }
        m3();
        y3();
        H3();
        E3();
        B3();
        S1();
        MarginRiskRateUtil.d(D0());
        MarginRiskRateUtil.b();
    }

    public boolean n3() {
        BigDecimal G = this.f82100k.G(this.f82105p, this.f82094e, true, 0);
        BigDecimal G2 = this.f82100k.G(this.f82105p, this.f82094e, false, 0);
        if (G == null || G.compareTo(BigDecimal.ZERO) >= 0) {
            return G2 != null && G2.compareTo(BigDecimal.ZERO) < 0;
        }
        return true;
    }

    public void o2() {
        if (!r.x().F0() || !AppConfigManager.h(MgtConfigNumber.MARGIN_COUPON.number, "isOpen", false)) {
            this.J = null;
            ((y) getUI()).Yd(8, "", 0);
        } else if (a1.v().p0(this.f82094e)) {
            ((y) getUI()).Yd(8, "", 0);
        } else if (this.J == null) {
            ((y) getUI()).i1();
        }
    }

    public boolean o3() {
        return this.O;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onChangeMarginEvent(at.a aVar) {
        super.onChangeMarginEvent(aVar);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onErrorCodeEvent(mo.a aVar) {
        if (((y) getUI()).isCanBeSeen()) {
            ((y) getUI()).Ac((MarginOverview) null);
            ((y) getUI()).L0();
            super.onErrorCodeEvent(aVar);
        }
    }

    public void onPause() {
        super.onPause();
        F3();
    }

    public void p1() {
        super.p1();
        m3();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void showGuideEvent(ShowMarginGuideEvent showMarginGuideEvent) {
        if (((y) getUI()).isCanBeSeen()) {
            ((y) getUI()).Nb(true);
        }
    }

    public void v3() {
        String str;
        if (a1()) {
            str = a1.v().n(this.f82094e);
        } else {
            str = a1.v().D(this.f82094e);
        }
        MarginLoanAsset A = this.f82100k.A(str);
        if (A != null) {
            String str2 = null;
            if (a1()) {
                str2 = m.u(A.getLoanAndInterest().toPlainString(), PrecisionUtil.z(this.f82094e));
            } else {
                BigDecimal a11 = m.a(((y) getUI()).getInputPriceText());
                if (a11.compareTo(BigDecimal.ZERO) != 0) {
                    str2 = m.a(A.getLoanAndInterest().toPlainString()).divide(a11, PrecisionUtil.z(this.f82094e), 0).toPlainString();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                ((y) getUI()).setInputAmountText(str2);
            }
        } else if (this.f82109t) {
            ((y) getUI()).setInputAmountText(m.u("0", PrecisionUtil.z(this.f82094e)));
        }
    }

    public final void w3(Map<String, String> map, List<MarginLoanAsset> list, MaxOrderAmountBean maxOrderAmountBean) {
        HashMap hashMap = new HashMap(map);
        for (MarginLoanAsset next : list) {
            String g11 = StringUtils.g(next.getCurrency());
            map.put(g11, m.a(map.get(g11)).add(m.a(next.getRemainLoanQuota()).setScale(PrecisionUtil.k(), 1)).toPlainString());
            this.f82100k.Z(g11, next);
        }
        if (!MarginRiskRateUtil.a() || maxOrderAmountBean == null) {
            this.f82100k.r0(this.f82105p, map);
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(maxOrderAmountBean.getCurrency(), maxOrderAmountBean.getMaxOrderAmount());
            this.f82100k.r0(this.f82105p, hashMap2);
        }
        this.f82100k.q0(this.f82105p, hashMap);
        this.f82109t = true;
        V1();
        U1();
        TradeTimeMonitorUtils.d(5);
    }

    /* renamed from: x3 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, y yVar) {
        super.onUIReady(baseCoreActivity, yVar);
        EventBus.d().p(this);
    }

    public final void y3() {
        SymbolBean J;
        if (x.b() && (J = a1.v().J(this.f82094e, TradeType.PRO)) != null) {
            String superMarginLeverageRatio = J.getSuperMarginLeverageRatio();
            ((y) getUI()).p(0, superMarginLeverageRatio + "X");
        }
    }

    public final void z3() {
        Subscription subscription = this.K;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.M;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        if (r.x().F0()) {
            this.K = Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new ls.d(this)).retryWhen(ls.e.f58063b).doOnNext(new ls.b(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new c());
        }
    }
}
