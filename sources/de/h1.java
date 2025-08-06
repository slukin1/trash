package de;

import a7.e;
import android.text.TextUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapOpenInterestInfo;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huobi.contract.helper.ContractOrderHelper;
import de.q;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import u6.g;
import us.i;

public class h1 extends q {

    /* renamed from: u  reason: collision with root package name */
    public Subscription f25183u;

    /* renamed from: v  reason: collision with root package name */
    public Subscriber<List<SwapPosition>> f25184v;

    /* renamed from: w  reason: collision with root package name */
    public Subscriber<List<SwapCurrentOrderInfo>> f25185w;

    /* renamed from: x  reason: collision with root package name */
    public Subscriber<List<SwapTriggerOrderInfo>> f25186x;

    public class a extends EasySubscriber<List<SwapOpenInterestInfo>> {
        public a() {
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(List<SwapOpenInterestInfo> list) {
            q.e eVar;
            super.onNext(list);
            for (SwapOpenInterestInfo next : list) {
                if (TextUtils.equals(h1.this.f25203q, next.getContractCode()) && (eVar = h1.this.f25205s) != null) {
                    eVar.P(String.valueOf(next.getVolume()));
                }
            }
        }
    }

    public class b extends EasySubscriber<List<SwapPosition>> {
        public b() {
        }

        public void onNext(List<SwapPosition> list) {
            super.onNext(list);
            if (h1.this.f25205s != null) {
                if (list != null) {
                    boolean c11 = ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true);
                    boolean c12 = ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true);
                    for (int size = list.size() - 1; size >= 0; size--) {
                        SwapPosition swapPosition = list.get(size);
                        int m11 = i.m(swapPosition.getSymbol());
                        String liquidationPrice = swapPosition.getLiquidationPrice();
                        if (!c12 || TextUtils.isEmpty(liquidationPrice)) {
                            swapPosition.setLiquidationPrice("--");
                        } else {
                            swapPosition.setLiquidationPrice(m.q(m.a(liquidationPrice), m11));
                        }
                        String str = "";
                        if (!c11) {
                            swapPosition.setCostOpen(str);
                        } else {
                            swapPosition.setCostOpen(m.m(swapPosition.getCostOpen(), m11));
                            if (!e.E(TradeType.SWAP)) {
                                swapPosition.setVolume(m.m(swapPosition.getVolume(), i.l(swapPosition.getSymbol())));
                            } else if (m.a(swapPosition.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
                                swapPosition.setVolume(m.m("0", i.k(swapPosition.getSymbol())));
                            } else {
                                SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(swapPosition.getContractCode());
                                if (q11 != null) {
                                    str = q11.getContractFace();
                                }
                                swapPosition.setVolume(m.q(m.a(swapPosition.getVolume()).multiply(m.a(str)).divide(m.a(swapPosition.getLastPrice()), 32, 1), i.k(swapPosition.getSymbol())));
                            }
                        }
                    }
                }
                h1.this.f25205s.K(list, 2);
            }
        }
    }

    public class c extends EasySubscriber<List<SwapCurrentOrderInfo>> {
        public c() {
        }

        public void onNext(List<SwapCurrentOrderInfo> list) {
            super.onNext(list);
            q.e eVar = h1.this.f25205s;
            if (eVar != null) {
                eVar.K(list, 0);
            }
        }
    }

    public class d extends EasySubscriber<List<SwapTriggerOrderInfo>> {
        public d() {
        }

        public void onNext(List<SwapTriggerOrderInfo> list) {
            super.onNext(list);
            q.e eVar = h1.this.f25205s;
            if (eVar != null) {
                eVar.K(list, 1);
            }
        }
    }

    public h1(String str, String str2, String str3, q.e eVar, g gVar) {
        super(str, str2, str3, eVar, gVar);
    }

    private Subscriber<List<SwapTriggerOrderInfo>> A() {
        return new d();
    }

    private Subscriber<List<SwapPosition>> B() {
        return new b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable C(Long l11) {
        return l9.a.a().getSwapOpenInterest(this.f25203q).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable G(Long l11) {
        return l9.a.a().G(0, 50, this.f25203q, "").b().flatMap(d1.f53589b).map(b1.f53584b).toList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable J(Long l11) {
        return l9.a.a().M(0, 50, this.f25203q).b().flatMap(c1.f53586b).map(e1.f53592b).toList();
    }

    public static /* synthetic */ SwapCurrentOrderInfo i0(SwapCurrentOrderInfo swapCurrentOrderInfo) {
        int i11;
        SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(swapCurrentOrderInfo.getContractCode());
        if (q11 != null) {
            swapCurrentOrderInfo.setContractFace(q11.getContractFace());
        }
        TradeType tradeType = TradeType.SWAP;
        boolean E = e.E(tradeType);
        String f11 = ContractOrderHelper.f(swapCurrentOrderInfo.getVolume(), swapCurrentOrderInfo.getPrice(), swapCurrentOrderInfo.getContractFace(), tradeType);
        if (E) {
            i11 = i.p(swapCurrentOrderInfo.getSymbol());
        } else {
            i11 = i.z(swapCurrentOrderInfo.getSymbol());
        }
        swapCurrentOrderInfo.setVolume(m.m(f11, i11));
        swapCurrentOrderInfo.setPrice(m.n(swapCurrentOrderInfo.getPrice(), i.m(swapCurrentOrderInfo.getSymbol()), "--"));
        return swapCurrentOrderInfo;
    }

    public static /* synthetic */ SwapTriggerOrderInfo j0(SwapTriggerOrderInfo swapTriggerOrderInfo) {
        int i11;
        SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(swapTriggerOrderInfo.getContractCode());
        String contractFace = q11 != null ? q11.getContractFace() : "";
        TradeType tradeType = TradeType.SWAP;
        boolean E = e.E(tradeType);
        String str = null;
        if (!TextUtils.isEmpty(swapTriggerOrderInfo.getOrderPriceType()) && swapTriggerOrderInfo.getOrderPriceType().contains("_")) {
            String[] split = swapTriggerOrderInfo.getOrderPriceType().split("_");
            if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                str = swapTriggerOrderInfo.getTriggerPrice();
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = swapTriggerOrderInfo.getOrderPrice();
        }
        String f11 = ContractOrderHelper.f(swapTriggerOrderInfo.getVolume(), str, contractFace, tradeType);
        if (E) {
            i11 = i.p(swapTriggerOrderInfo.getSymbol());
        } else {
            i11 = i.z(swapTriggerOrderInfo.getSymbol());
        }
        swapTriggerOrderInfo.setVolume(m.m(f11, i11));
        swapTriggerOrderInfo.setTriggerPrice(m.m(swapTriggerOrderInfo.getTriggerPrice(), i.m(swapTriggerOrderInfo.getSymbol())));
        return swapTriggerOrderInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable l0(Long l11) {
        return l9.a.a().O(this.f25203q).b().flatMap(f1.f53595b).toList();
    }

    private Subscriber<List<SwapCurrentOrderInfo>> z() {
        return new c();
    }

    public void P(boolean z11) {
        T(this.f25185w);
        if (!BaseModuleConfig.a().a() || !z11) {
            q.e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 0);
                return;
            }
            return;
        }
        this.f25185w = z();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new z0(this)).retryWhen(g1.f53598b).compose(RxJavaHelper.t(this.f25206t)).subscribe(this.f25185w);
    }

    public void R(boolean z11) {
        T(this.f25186x);
        if (!BaseModuleConfig.a().a() || !z11) {
            q.e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 1);
                return;
            }
            return;
        }
        this.f25186x = A();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new a1(this)).retryWhen(x0.f53625b).compose(RxJavaHelper.t(this.f25206t)).subscribe(this.f25186x);
    }

    public void S(boolean z11, boolean z12) {
        T(this.f25184v);
        if (!BaseModuleConfig.a().a() || (!z11 && !z12)) {
            q.e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 2);
                return;
            }
            return;
        }
        this.f25184v = B();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new u0(this)).retryWhen(w0.f53623b).compose(RxJavaHelper.v(this.f25206t, Schedulers.io(), Schedulers.computation())).subscribe(this.f25184v);
    }

    public void f() {
        e(this.f25183u);
        T(this.f25184v);
        T(this.f25185w);
        T(this.f25186x);
        l9.a.a().c(this.f25217i);
    }

    public void g() {
        S(ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true), ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true));
        Q(ConfigPreferences.c("user_config", "KLINE_CONFIG_OPENORDERS_SWITCH", true));
        this.f25183u = Observable.interval(0, 15, TimeUnit.SECONDS).flatMap(new y0(this)).retryWhen(v0.f53621b).compose(RxJavaHelper.t(this.f25206t)).subscribe(new a());
        l9.a.a().d(this.f25217i);
    }

    public void j(boolean z11) {
        if (c(this.f25211c, this.f23716b)) {
            l9.a.a().g(z11, this.f25211c, Period.day, this.f25219k);
            l9.a.a().j(z11, this.f25211c, this.f25218j);
            if (!TextUtils.isEmpty(this.f25213e)) {
                l9.a.a().g(z11, this.f25213e, this.f23716b, this.f25216h);
            }
        }
    }
}
