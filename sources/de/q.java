package de;

import android.text.TextUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.ContractHoldAmount;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.contract.entity.ContractCurrentOrderInfo;
import com.huobi.contract.entity.ContractCurrentTriggerOrderInfo;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractOrderHelper;
import de.t;
import ej.f;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import u6.g;

public class q extends t {

    /* renamed from: m  reason: collision with root package name */
    public Subscriber<List<ContractPosition>> f25199m;

    /* renamed from: n  reason: collision with root package name */
    public Subscriber<List<ContractCurrentOrderInfo>> f25200n;

    /* renamed from: o  reason: collision with root package name */
    public Subscriber<List<ContractCurrentTriggerOrderInfo>> f25201o;

    /* renamed from: p  reason: collision with root package name */
    public String f25202p;

    /* renamed from: q  reason: collision with root package name */
    public String f25203q;

    /* renamed from: r  reason: collision with root package name */
    public Subscription f25204r;

    /* renamed from: s  reason: collision with root package name */
    public e f25205s;

    /* renamed from: t  reason: collision with root package name */
    public g f25206t;

    public class a extends EasySubscriber<List<ContractHoldAmount>> {
        public a() {
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(List<ContractHoldAmount> list) {
            e eVar;
            super.onNext(list);
            for (ContractHoldAmount next : list) {
                if (TextUtils.equals(q.this.f25203q, next.getContractCode()) && (eVar = q.this.f25205s) != null) {
                    eVar.P(String.valueOf(next.getVolume()));
                }
            }
        }
    }

    public class b extends EasySubscriber<List<ContractPosition>> {
        public b() {
        }

        public void onNext(List<ContractPosition> list) {
            super.onNext(list);
            if (q.this.f25205s != null) {
                if (list != null) {
                    boolean c11 = ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true);
                    boolean c12 = ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true);
                    for (int size = list.size() - 1; size >= 0; size--) {
                        ContractPosition contractPosition = list.get(size);
                        String liquidationPrice = contractPosition.getLiquidationPrice();
                        String str = "";
                        if (!c12 || TextUtils.isEmpty(liquidationPrice)) {
                            contractPosition.setLiquidationPrice("--");
                        } else {
                            try {
                                if (contractPosition.getContractCurrencyInfo() != null) {
                                    contractPosition.setLiquidationPrice(m.q(m.a(liquidationPrice), f.p(contractPosition.getContractCurrencyInfo().getContractCode())));
                                } else {
                                    contractPosition.setLiquidationPrice(m.m(liquidationPrice, f.b(contractPosition.getSymbol() == null ? str : contractPosition.getSymbol(), 8)));
                                }
                            } catch (Throwable unused) {
                                contractPosition.setLiquidationPrice("--");
                            }
                        }
                        if (!c11) {
                            contractPosition.setCostOpen(str);
                        } else {
                            contractPosition.setCostOpen(m.m(contractPosition.getCostOpen(), f.p(contractPosition.getContractCode())));
                            if (!a7.e.E(TradeType.CONTRACT)) {
                                contractPosition.setVolume(m.m(contractPosition.getVolume(), f.g(contractPosition.getSymbol())));
                            } else if (m.a(contractPosition.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
                                contractPosition.setVolume(m.m("0", f.n(contractPosition.getContractCode())));
                            } else {
                                ContractCurrencyInfo h11 = ContractCurrencyUtils.h(contractPosition.getContractCode());
                                if (h11 != null) {
                                    str = h11.getContractFace();
                                }
                                contractPosition.setVolume(m.q(m.a(contractPosition.getVolume()).multiply(m.a(str)).divide(m.a(contractPosition.getLastPrice()), 32, 1), f.n(contractPosition.getContractCode())));
                            }
                        }
                    }
                }
                q.this.f25205s.K(list, 2);
            }
        }
    }

    public class c extends EasySubscriber<List<ContractCurrentOrderInfo>> {
        public c() {
        }

        public void onNext(List<ContractCurrentOrderInfo> list) {
            super.onNext(list);
            e eVar = q.this.f25205s;
            if (eVar != null) {
                eVar.K(list, 0);
            }
        }
    }

    public class d extends EasySubscriber<List<ContractCurrentTriggerOrderInfo>> {
        public d() {
        }

        public void onNext(List<ContractCurrentTriggerOrderInfo> list) {
            super.onNext(list);
            e eVar = q.this.f25205s;
            if (eVar != null) {
                eVar.K(list, 1);
            }
        }
    }

    public interface e extends t.e {
        void K(List<?> list, int i11);

        void P(String str);

        void u(KlineInfo klineInfo);
    }

    public q(String str, String str2, String str3, e eVar, g gVar) {
        super(str, str2, false, eVar);
        this.f25203q = str3;
        this.f25205s = eVar;
        this.f25206t = gVar;
        if (!TextUtils.isEmpty(str) && str.contains("_")) {
            this.f25202p = str.split("_")[0];
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable C(Long l11) {
        return q7.a.a().J(this.f25203q).b();
    }

    public static /* synthetic */ ContractCurrentOrderInfo F(ContractCurrentOrderInfo contractCurrentOrderInfo) {
        int i11;
        ContractCurrencyInfo h11 = ContractCurrencyUtils.h(contractCurrentOrderInfo.getContractCode());
        if (h11 != null) {
            contractCurrentOrderInfo.setContractFace(h11.getContractFace());
        }
        boolean E = a7.e.E(TradeType.CONTRACT);
        String e11 = ContractOrderHelper.e(contractCurrentOrderInfo.getVolume(), contractCurrentOrderInfo.getPrice(), contractCurrentOrderInfo.getContractFace());
        if (E) {
            i11 = f.n(contractCurrentOrderInfo.getContractCode());
        } else {
            i11 = f.t(contractCurrentOrderInfo.getSymbol());
        }
        contractCurrentOrderInfo.setVolume(m.m(e11, i11));
        contractCurrentOrderInfo.setPrice(m.n(contractCurrentOrderInfo.getPrice(), f.p(contractCurrentOrderInfo.getContractCode()), "--"));
        return contractCurrentOrderInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable G(Long l11) {
        return ContractOrderHelper.h(this.f25202p, 0, 50).flatMap(l.f53606b).map(k.f53604b).toList();
    }

    public static /* synthetic */ ContractCurrentTriggerOrderInfo I(ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo) {
        int i11;
        ContractCurrencyInfo h11 = ContractCurrencyUtils.h(contractCurrentTriggerOrderInfo.getContractCode());
        if (h11 != null) {
            contractCurrentTriggerOrderInfo.setContractFace(h11.getContractFace());
        }
        String str = null;
        if (!TextUtils.isEmpty(contractCurrentTriggerOrderInfo.getOrderPriceType()) && contractCurrentTriggerOrderInfo.getOrderPriceType().contains("_")) {
            String[] split = contractCurrentTriggerOrderInfo.getOrderPriceType().split("_");
            if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                str = contractCurrentTriggerOrderInfo.getTriggerPrice();
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = contractCurrentTriggerOrderInfo.getOrderPrice();
        }
        boolean E = a7.e.E(TradeType.CONTRACT);
        String e11 = ContractOrderHelper.e(contractCurrentTriggerOrderInfo.getVolume(), str, contractCurrentTriggerOrderInfo.getContractFace());
        if (E) {
            i11 = f.n(contractCurrentTriggerOrderInfo.getContractCode());
        } else {
            i11 = f.t(contractCurrentTriggerOrderInfo.getSymbol());
        }
        contractCurrentTriggerOrderInfo.setVolume(m.m(e11, i11));
        contractCurrentTriggerOrderInfo.setTriggerPrice(m.m(contractCurrentTriggerOrderInfo.getTriggerPrice(), f.p(contractCurrentTriggerOrderInfo.getContractCode())));
        return contractCurrentTriggerOrderInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable J(Long l11) {
        return ContractOrderHelper.i(this.f25202p, (String) null, 0, 50).flatMap(n.f53610b).map(m.f53608b).toList();
    }

    public final Subscriber<List<ContractCurrentTriggerOrderInfo>> A() {
        return new d();
    }

    public final Subscriber<List<ContractPosition>> B() {
        return new b();
    }

    public void P(boolean z11) {
        T(this.f25200n);
        if (!BaseModuleConfig.a().a() || !z11) {
            e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 0);
                return;
            }
            return;
        }
        this.f25200n = z();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new d(this)).retryWhen(p.f53614b).compose(RxJavaHelper.t(this.f25206t)).subscribe(this.f25200n);
    }

    public void Q(boolean z11) {
        P(z11);
        R(z11);
    }

    public void R(boolean z11) {
        T(this.f25201o);
        if (!BaseModuleConfig.a().a() || !z11) {
            e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 1);
                return;
            }
            return;
        }
        this.f25201o = A();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new i(this)).retryWhen(f.f53593b).compose(RxJavaHelper.t(this.f25206t)).subscribe(this.f25201o);
    }

    public void S(boolean z11, boolean z12) {
        T(this.f25199m);
        if (!BaseModuleConfig.a().a() || (!z11 && !z12)) {
            e eVar = this.f25205s;
            if (eVar != null) {
                eVar.K((List<?>) null, 2);
                return;
            }
            return;
        }
        this.f25199m = B();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new j(MapParamsBuilder.c().a("symbol", this.f25202p).a("contract_code", this.f25203q).b())).retryWhen(g.f53596b).compose(RxJavaHelper.v(this.f25206t, Schedulers.io(), Schedulers.computation())).subscribe(this.f25199m);
    }

    public void T(Subscriber subscriber) {
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void f() {
        e(this.f25204r);
        T(this.f25199m);
        T(this.f25200n);
        T(this.f25201o);
        q7.a.a().c(this.f25217i);
    }

    public void g() {
        S(ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true), ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true));
        Q(ConfigPreferences.c("user_config", "KLINE_CONFIG_OPENORDERS_SWITCH", true));
        this.f25204r = Observable.interval(0, 15, TimeUnit.SECONDS).flatMap(new h(this)).retryWhen(e.f53590b).compose(RxJavaHelper.t(this.f25206t)).subscribe(new a());
        q7.a.a().d(this.f25217i);
    }

    public void i(KlineInfo klineInfo) {
        e eVar = this.f25205s;
        if (eVar != null) {
            eVar.G3(klineInfo);
        }
    }

    public void j(boolean z11) {
        if (c(this.f25211c, this.f23716b)) {
            q7.a.a().g(z11, this.f25211c, Period.day, this.f25219k);
            q7.a.a().j(z11, this.f25211c, this.f25218j);
        }
    }

    public void k(KlineInfo klineInfo) {
        e eVar = this.f25205s;
        if (eVar != null) {
            eVar.u(klineInfo);
        }
    }

    public void l(t.e eVar) {
        this.f25205s = (e) eVar;
        this.f25214f = eVar;
    }

    public final Subscriber<List<ContractCurrentOrderInfo>> z() {
        return new c();
    }
}
