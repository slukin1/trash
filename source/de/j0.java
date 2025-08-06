package de;

import a7.e;
import android.text.TextUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOpenInterestInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
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

public class j0 extends q {

    /* renamed from: u  reason: collision with root package name */
    public Subscription f25191u;

    /* renamed from: v  reason: collision with root package name */
    public Subscriber<List<LinearSwapPosition>> f25192v;

    /* renamed from: w  reason: collision with root package name */
    public Subscriber<List<LinearSwapCurrentOrderInfo>> f25193w;

    /* renamed from: x  reason: collision with root package name */
    public Subscriber<List<LinearSwapTriggerOrderInfo>> f25194x;

    public class a extends EasySubscriber<List<LinearSwapOpenInterestInfo>> {
        public a() {
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(List<LinearSwapOpenInterestInfo> list) {
            q.e eVar;
            super.onNext(list);
            for (LinearSwapOpenInterestInfo next : list) {
                if (TextUtils.equals(j0.this.f25203q, next.getContractCode()) && (eVar = j0.this.f25205s) != null) {
                    eVar.P(String.valueOf(next.getVolume()));
                }
            }
        }
    }

    public class b extends EasySubscriber<List<LinearSwapPosition>> {
        public b() {
        }

        public void onNext(List<LinearSwapPosition> list) {
            super.onNext(list);
            if (j0.this.f25205s != null) {
                if (list != null) {
                    boolean c11 = ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true);
                    boolean c12 = ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true);
                    for (int size = list.size() - 1; size >= 0; size--) {
                        LinearSwapPosition linearSwapPosition = list.get(size);
                        FutureContractInfo o11 = FutureContractInfoController.n().o(linearSwapPosition.getContractCode());
                        if (o11 == null) {
                            list.remove(size);
                        } else {
                            String liquidationPrice = linearSwapPosition.getLiquidationPrice();
                            if (!c12 || TextUtils.isEmpty(liquidationPrice)) {
                                linearSwapPosition.setLiquidationPrice("--");
                            } else {
                                linearSwapPosition.setLiquidationPrice(m.q(m.a(linearSwapPosition.getLiquidationPrice()), FuturePrecisionUtil.y(o11.getContractCode(), o11.getContractShortType(), (String) null)));
                            }
                            String str = "";
                            if (!c11) {
                                linearSwapPosition.setCostOpen(str);
                            } else {
                                String contractShortType = o11.getContractShortType();
                                int y11 = FuturePrecisionUtil.y(linearSwapPosition.getContractCode(), contractShortType, (String) null);
                                if (linearSwapPosition.getCostOpen() != null) {
                                    str = m.m(linearSwapPosition.getCostOpen(), y11);
                                }
                                linearSwapPosition.setCostOpen(str);
                                int s11 = FuturePrecisionUtil.s(linearSwapPosition.getContractCode(), contractShortType, (String) null);
                                String contractFace = o11.getContractFace();
                                TradeType tradeType = TradeType.LINEAR_SWAP;
                                if (e.E(tradeType)) {
                                    if (m.a(linearSwapPosition.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
                                        linearSwapPosition.setVolume(m.m("0", s11));
                                    } else {
                                        linearSwapPosition.setVolume(m.m(FutureUnitUtil.a(linearSwapPosition.getVolume(), linearSwapPosition.getLastPrice(), contractFace, tradeType), s11));
                                    }
                                } else if (!e.G(tradeType)) {
                                    linearSwapPosition.setVolume(m.m(linearSwapPosition.getVolume(), FuturePrecisionUtil.B()));
                                } else if (m.a(linearSwapPosition.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
                                    linearSwapPosition.setVolume(m.m("0", s11));
                                } else {
                                    linearSwapPosition.setVolume(FutureUnitUtil.b(linearSwapPosition.getVolume(), linearSwapPosition.getLastPrice(), contractFace, tradeType, FuturePrecisionUtil.g(linearSwapPosition.getSymbol())));
                                }
                            }
                        }
                    }
                }
                j0.this.f25205s.K(list, 2);
            }
        }
    }

    public class c extends EasySubscriber<List<LinearSwapCurrentOrderInfo>> {
        public c() {
        }

        public void onNext(List<LinearSwapCurrentOrderInfo> list) {
            super.onNext(list);
            q.e eVar = j0.this.f25205s;
            if (eVar != null) {
                eVar.K(list, 0);
            }
        }
    }

    public class d extends EasySubscriber<List<LinearSwapTriggerOrderInfo>> {
        public d() {
        }

        public void onNext(List<LinearSwapTriggerOrderInfo> list) {
            super.onNext(list);
            q.e eVar = j0.this.f25205s;
            if (eVar != null) {
                eVar.K(list, 1);
            }
        }
    }

    public j0(String str, String str2, String str3, q.e eVar, g gVar) {
        super(str, str2, str3, eVar, gVar);
    }

    private Subscriber<List<LinearSwapTriggerOrderInfo>> A() {
        return new d();
    }

    private Subscriber<List<LinearSwapPosition>> B() {
        return new b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable C(Long l11) {
        return h8.a.a().getSwapOpenInterest(this.f25203q, TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable G(Long l11) {
        return h8.a.a().K(0, 100, this.f25203q, TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL, "").b().flatMap(f0.f53594b).map(d0.f53588b).toList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable J(Long l11) {
        return h8.a.a().m0(0, 100, this.f25203q, TtmlNode.COMBINE_ALL, 0).b().flatMap(e0.f53591b).map(g0.f53597b).toList();
    }

    public static /* synthetic */ LinearSwapCurrentOrderInfo i0(LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo) {
        String str;
        LinearSwapContractInfo m11 = LinearSwapCurrencyInfoController.l().m(linearSwapCurrentOrderInfo.getContractCode());
        linearSwapCurrentOrderInfo.setSymbol(m11.getSymbol());
        linearSwapCurrentOrderInfo.setContractFace(m11.getContractFace());
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (e.G(tradeType)) {
            str = FutureUnitUtil.b(linearSwapCurrentOrderInfo.getVolume(), linearSwapCurrentOrderInfo.getPrice(), linearSwapCurrentOrderInfo.getContractFace(), tradeType, FuturePrecisionUtil.g(linearSwapCurrentOrderInfo.getSymbol()));
        } else {
            str = m.m(FutureUnitUtil.a(linearSwapCurrentOrderInfo.getVolume(), linearSwapCurrentOrderInfo.getPrice(), linearSwapCurrentOrderInfo.getContractFace(), tradeType), FuturePrecisionUtil.s(linearSwapCurrentOrderInfo.getContractCode(), linearSwapCurrentOrderInfo.getContractCode(), (String) null));
        }
        linearSwapCurrentOrderInfo.setVolume(str);
        linearSwapCurrentOrderInfo.setPrice(m.n(linearSwapCurrentOrderInfo.getPrice(), FuturePrecisionUtil.y(linearSwapCurrentOrderInfo.getContractCode(), linearSwapCurrentOrderInfo.getContractCode(), (String) null), "--"));
        return linearSwapCurrentOrderInfo;
    }

    public static /* synthetic */ LinearSwapTriggerOrderInfo j0(LinearSwapTriggerOrderInfo linearSwapTriggerOrderInfo) {
        String str;
        int i11;
        String str2;
        linearSwapTriggerOrderInfo.setContractFace(LinearSwapCurrencyInfoController.l().m(linearSwapTriggerOrderInfo.getContractCode()).getContractFace());
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (e.G(tradeType)) {
            if (m.a(linearSwapTriggerOrderInfo.getOrderPrice()).compareTo(BigDecimal.ZERO) == 0) {
                str2 = linearSwapTriggerOrderInfo.getTriggerPrice();
            } else {
                str2 = linearSwapTriggerOrderInfo.getOrderPrice();
            }
            str = FutureUnitUtil.b(linearSwapTriggerOrderInfo.getVolume(), str2, linearSwapTriggerOrderInfo.getContractFace(), tradeType, FuturePrecisionUtil.g(linearSwapTriggerOrderInfo.getSymbol()));
        } else {
            boolean E = e.E(tradeType);
            String a11 = FutureUnitUtil.a(linearSwapTriggerOrderInfo.getVolume(), linearSwapTriggerOrderInfo.getOrderPrice(), linearSwapTriggerOrderInfo.getContractFace(), tradeType);
            if (E) {
                i11 = FuturePrecisionUtil.s(linearSwapTriggerOrderInfo.getContractCode(), linearSwapTriggerOrderInfo.getContractCode(), (String) null);
            } else {
                i11 = FuturePrecisionUtil.B();
            }
            str = m.m(a11, i11);
        }
        linearSwapTriggerOrderInfo.setVolume(str);
        linearSwapTriggerOrderInfo.setTriggerPrice(m.n(linearSwapTriggerOrderInfo.getTriggerPrice(), FuturePrecisionUtil.y(linearSwapTriggerOrderInfo.getContractCode(), linearSwapTriggerOrderInfo.getContractCode(), (String) null), "--"));
        return linearSwapTriggerOrderInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable l0(Long l11) {
        return h8.a.a().n0(this.f25203q, TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL).b().flatMap(h0.f53600b).toList();
    }

    private Subscriber<List<LinearSwapCurrentOrderInfo>> z() {
        return new c();
    }

    public void P(boolean z11) {
        T(this.f25193w);
        if (!BaseModuleConfig.a().a() || !z11) {
            q.e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 0);
                return;
            }
            return;
        }
        this.f25193w = z();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new a0(this)).retryWhen(x.f53624b).compose(RxJavaHelper.t(this.f25206t)).subscribe(this.f25193w);
    }

    public void R(boolean z11) {
        T(this.f25194x);
        if (!BaseModuleConfig.a().a() || !z11) {
            q.e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 1);
                return;
            }
            return;
        }
        this.f25194x = A();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new w(this)).retryWhen(y.f53626b).compose(RxJavaHelper.t(this.f25206t)).subscribe(this.f25194x);
    }

    public void S(boolean z11, boolean z12) {
        T(this.f25192v);
        if (!BaseModuleConfig.a().a() || (!z11 && !z12)) {
            q.e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 2);
                return;
            }
            return;
        }
        this.f25192v = B();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new b0(this)).retryWhen(z.f53628b).compose(RxJavaHelper.v(this.f25206t, Schedulers.io(), Schedulers.computation())).subscribe(this.f25192v);
    }

    public void f() {
        e(this.f25191u);
        T(this.f25192v);
        T(this.f25193w);
        T(this.f25194x);
        h8.a.a().c(this.f25217i);
    }

    public void g() {
        S(ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true), ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true));
        Q(ConfigPreferences.c("user_config", "KLINE_CONFIG_OPENORDERS_SWITCH", true));
        this.f25191u = Observable.interval(0, 15, TimeUnit.SECONDS).flatMap(new c0(this)).retryWhen(i0.f53602b).compose(RxJavaHelper.t(this.f25206t)).subscribe(new a());
        h8.a.a().d(this.f25217i);
    }

    public void j(boolean z11) {
        if (c(this.f25211c, this.f23716b)) {
            h8.a.a().g(z11, this.f25211c, Period.day, this.f25219k);
            h8.a.a().j(z11, this.f25211c, this.f25218j);
        }
    }
}
