package bj;

import android.text.TextUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.ContractPositionApi;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCrossAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.option.core.util.OptionDirection;
import com.hbg.lib.network.pro.core.bean.AssetModeBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.ContractAuthenticationListener;
import com.hbg.lib.network.pro.socket.response.ContractAuthenticationResponse;
import com.hbg.lib.network.pro.socket.response.ContractPositionWsData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.module.contract.ContractModuleConfig;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.websocket.ContractPositionEventListener;
import com.huobi.contract.websocket.ContractPositionEventResponse;
import com.huobi.contract.websocket.UnionContractPositionEventListener;
import com.huobi.contract.websocket.UnionContractPositionEventResponse;
import g9.a;
import i6.m;
import i8.k;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import m9.r;
import o6.b;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

public class l0 {

    /* renamed from: w  reason: collision with root package name */
    public static final String[] f40841w = {"this_week", "next_week", "quarter", "next_quarter"};

    /* renamed from: x  reason: collision with root package name */
    public static Map<TradeType, l0> f40842x = new ConcurrentHashMap(4);

    /* renamed from: a  reason: collision with root package name */
    public TradeType f40843a;

    /* renamed from: b  reason: collision with root package name */
    public i f40844b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<s9.a> f40845c = new CopyOnWriteArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f40846d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f40847e;

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, ContractPositionWsData> f40848f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, LinearSwapAccountInfo> f40849g = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    public volatile String f40850h = "-9527";

    /* renamed from: i  reason: collision with root package name */
    public Map<String, LinearSwapAccountInfo> f40851i = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    public Map<String, SwapAccountInfo> f40852j = new ConcurrentHashMap();

    /* renamed from: k  reason: collision with root package name */
    public Map<String, ContractAccountInfo> f40853k = new ConcurrentHashMap();

    /* renamed from: l  reason: collision with root package name */
    public boolean f40854l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f40855m = false;

    /* renamed from: n  reason: collision with root package name */
    public Subscription f40856n;

    /* renamed from: o  reason: collision with root package name */
    public Subscription f40857o;

    /* renamed from: p  reason: collision with root package name */
    public a.d f40858p = new d0(this);

    /* renamed from: q  reason: collision with root package name */
    public ContractAuthenticationListener f40859q = new a();

    /* renamed from: r  reason: collision with root package name */
    public b.C0747b f40860r = new b();

    /* renamed from: s  reason: collision with root package name */
    public k.b f40861s = new c();

    /* renamed from: t  reason: collision with root package name */
    public r.b f40862t = new d();

    /* renamed from: u  reason: collision with root package name */
    public UnionContractPositionEventListener f40863u = new e();

    /* renamed from: v  reason: collision with root package name */
    public ContractPositionEventListener f40864v = new f();

    public class a extends ContractAuthenticationListener {
        public a() {
        }

        /* renamed from: j */
        public void f(ContractAuthenticationResponse contractAuthenticationResponse) {
            i6.d.d("ContractAuthenticationResponse onSuccess:" + contractAuthenticationResponse + " isUnionMode: " + l0.this.f40855m);
            if (contractAuthenticationResponse != null) {
                int errCode = contractAuthenticationResponse.getErrCode();
                if (errCode != 0 && errCode != 2005) {
                    return;
                }
                if (l0.this.f40855m) {
                    boolean unused = l0.this.f40854l = true;
                    l0.this.u().i(true, "positions", l0.this.f40863u);
                    return;
                }
                l0.this.u().h(true, "user_event_trigger.*", l0.this.f40864v);
            }
        }

        public void onFailed(Throwable th2) {
            super.onFailed(th2);
            i6.d.d("ContractAuthenticationResponse onFailed:" + th2);
        }
    }

    public class b implements b.C0747b {
        public b() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            l0.this.z();
        }
    }

    public class c implements k.b {
        public c() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            l0.this.z();
        }
    }

    public class d implements r.b {
        public d() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            l0.this.z();
        }
    }

    public class e extends UnionContractPositionEventListener {
        public e() {
        }

        /* renamed from: j */
        public void f(UnionContractPositionEventResponse unionContractPositionEventResponse) {
            if ("positions".equals(unionContractPositionEventResponse.topic) && l0.this.f40844b != null && unionContractPositionEventResponse.event != null) {
                l0.this.f40844b.e(unionContractPositionEventResponse.data, unionContractPositionEventResponse.event.equals("snapshot"));
            }
        }
    }

    public class f extends ContractPositionEventListener {
        public f() {
        }

        /* renamed from: j */
        public void f(ContractPositionEventResponse contractPositionEventResponse) {
            i6.d.d("ContractPositionEventResponse onSuccess:" + contractPositionEventResponse);
            if (contractPositionEventResponse != null && !TextUtils.isEmpty(contractPositionEventResponse.event)) {
                String str = contractPositionEventResponse.event;
                str.hashCode();
                char c11 = 65535;
                switch (str.hashCode()) {
                    case -807501318:
                        if (str.equals("leverage_change")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -556585366:
                        if (str.equals("asset_margin_mode_change")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 49:
                        if (str.equals("1")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 365320538:
                        if (str.equals("tpsl_change")) {
                            c11 = 3;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                    case 3:
                        if (l0.this.f40844b != null) {
                            l0.this.f40844b.a();
                            return;
                        }
                        return;
                    case 1:
                        EventBus.d().k(new AssetModeBean(Boolean.valueOf(contractPositionEventResponse.isUnionMode()), Boolean.TRUE));
                        return;
                    case 2:
                        if (l0.this.f40844b != null) {
                            l0.this.f40844b.d();
                            l0.this.f40844b.a();
                            l0.this.f40844b.b();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public class g extends EasySubscriber<List<s9.a>> {
        public g() {
        }

        public void onNext(List<s9.a> list) {
            super.onNext(list);
            if (l0.this.f40844b != null) {
                l0.this.f40844b.c(list);
            }
        }
    }

    public class h extends EasySubscriber<List<s9.a>> {
        public h() {
        }

        public void onNext(List<s9.a> list) {
            super.onNext(list);
            if (l0.this.f40844b != null) {
                l0.this.f40844b.c(list);
            }
        }
    }

    public interface i {
        void a();

        void b();

        void c(List<? extends s9.a> list);

        void d();

        void e(List<LinearSwapPosition> list, boolean z11);
    }

    public l0(TradeType tradeType) {
        this.f40843a = tradeType;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s9.a B(s9.a aVar) {
        SymbolPrice symbolPrice;
        SymbolPrice symbolPrice2;
        SymbolPrice symbolPrice3;
        if (aVar instanceof LinearSwapPositionOrderItem) {
            LinearSwapPositionOrderItem linearSwapPositionOrderItem = (LinearSwapPositionOrderItem) aVar;
            LinearSwapPosition linearSwapPosition = linearSwapPositionOrderItem.f26409b;
            if (!(TextUtils.equals(this.f40847e, linearSwapPosition.contractCode) || (symbolPrice3 = k.g().h().get(linearSwapPosition.contractCode)) == null || symbolPrice3.getClose() == null)) {
                BigDecimal a11 = m.a(linearSwapPosition.lastPrice);
                BigDecimal valueOf = BigDecimal.valueOf(symbolPrice3.getClose().doubleValue());
                if (a11.compareTo(valueOf) != 0) {
                    M(linearSwapPositionOrderItem, linearSwapPosition, valueOf);
                }
            }
        } else if (aVar instanceof SwapPositionItem) {
            SwapPositionItem swapPositionItem = (SwapPositionItem) aVar;
            SwapPosition d11 = swapPositionItem.d();
            if (!(TextUtils.equals(this.f40847e, d11.contractCode) || (symbolPrice2 = r.g().h().get(d11.contractCode)) == null || symbolPrice2.getClose() == null)) {
                BigDecimal a12 = m.a(d11.lastPrice);
                BigDecimal valueOf2 = BigDecimal.valueOf(symbolPrice2.getClose().doubleValue());
                if (a12.compareTo(valueOf2) != 0) {
                    N(swapPositionItem, d11, valueOf2);
                }
            }
        } else if (aVar instanceof ContractPosition) {
            ContractPosition contractPosition = (ContractPosition) aVar;
            if (!(contractPosition.getContractCurrencyInfo() == null || TextUtils.equals(this.f40847e, contractPosition.getContractCurrencyInfo().getContractShortType()) || (symbolPrice = o6.b.g().h().get(contractPosition.getContractCurrencyInfo().getContractShortType())) == null || symbolPrice.getClose() == null)) {
                BigDecimal a13 = m.a(contractPosition.lastPrice);
                BigDecimal valueOf3 = BigDecimal.valueOf(symbolPrice.getClose().doubleValue());
                if (a13.compareTo(valueOf3) != 0) {
                    L(contractPosition, valueOf3);
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List C(List list) {
        TradeType tradeType = this.f40843a;
        if (tradeType == TradeType.LINEAR_SWAP) {
            r();
            q();
        } else if (tradeType == TradeType.SWAP) {
            s();
        } else if (tradeType == TradeType.CONTRACT) {
            p();
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s9.a D(String str, double d11, s9.a aVar) {
        if (aVar instanceof LinearSwapPositionOrderItem) {
            LinearSwapPositionOrderItem linearSwapPositionOrderItem = (LinearSwapPositionOrderItem) aVar;
            LinearSwapPosition linearSwapPosition = linearSwapPositionOrderItem.f26409b;
            if (TextUtils.equals(linearSwapPosition.contractCode, str)) {
                BigDecimal a11 = m.a(linearSwapPosition.lastPrice);
                BigDecimal valueOf = BigDecimal.valueOf(d11);
                if (a11.compareTo(valueOf) != 0) {
                    M(linearSwapPositionOrderItem, linearSwapPosition, valueOf);
                }
            }
        } else if (aVar instanceof SwapPositionItem) {
            SwapPositionItem swapPositionItem = (SwapPositionItem) aVar;
            SwapPosition d12 = swapPositionItem.d();
            if (TextUtils.equals(d12.contractCode, str)) {
                BigDecimal a12 = m.a(d12.lastPrice);
                BigDecimal valueOf2 = BigDecimal.valueOf(d11);
                if (a12.compareTo(valueOf2) != 0) {
                    N(swapPositionItem, d12, valueOf2);
                }
            }
        } else if (aVar instanceof ContractPosition) {
            ContractPosition contractPosition = (ContractPosition) aVar;
            if (contractPosition.getContractCurrencyInfo() != null && TextUtils.equals(contractPosition.getContractCurrencyInfo().getContractShortType(), str)) {
                BigDecimal a13 = m.a(contractPosition.lastPrice);
                BigDecimal valueOf3 = BigDecimal.valueOf(d11);
                if (a13.compareTo(valueOf3) != 0) {
                    L(contractPosition, valueOf3);
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List E(List list) {
        TradeType tradeType = this.f40843a;
        if (tradeType == TradeType.LINEAR_SWAP) {
            r();
            q();
        } else if (tradeType == TradeType.SWAP) {
            s();
        } else if (tradeType == TradeType.CONTRACT) {
            p();
        }
        return list;
    }

    public static /* synthetic */ Boolean G(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s9.a I(String str, s9.a aVar) {
        if (aVar instanceof LinearSwapPositionOrderItem) {
            LinearSwapPosition linearSwapPosition = ((LinearSwapPositionOrderItem) aVar).f26409b;
            ConcurrentHashMap<String, ContractPositionWsData> concurrentHashMap = this.f40848f;
            concurrentHashMap.put(linearSwapPosition.getContractCode() + linearSwapPosition.getMarginMode() + linearSwapPosition.getDirection(), linearSwapPosition);
            this.f40846d = TextUtils.equals(linearSwapPosition.getContractCode(), str) | this.f40846d;
        } else if (aVar instanceof SwapPositionItem) {
            SwapPosition d11 = ((SwapPositionItem) aVar).d();
            ConcurrentHashMap<String, ContractPositionWsData> concurrentHashMap2 = this.f40848f;
            concurrentHashMap2.put(d11.getContractCode() + d11.getDirection(), d11);
            this.f40846d = TextUtils.equals(d11.getContractCode(), str) | this.f40846d;
        } else if (aVar instanceof ContractPosition) {
            ContractPosition contractPosition = (ContractPosition) aVar;
            ConcurrentHashMap<String, ContractPositionWsData> concurrentHashMap3 = this.f40848f;
            concurrentHashMap3.put(contractPosition.getSymbol() + contractPosition.getContractType() + contractPosition.getDirection(), contractPosition);
            if (contractPosition.getContractCurrencyInfo() != null) {
                this.f40846d = TextUtils.equals(contractPosition.getContractCurrencyInfo().getContractShortType(), str) | this.f40846d;
            }
        }
        return aVar;
    }

    public static l0 t() {
        return x(TradeType.CONTRACT);
    }

    public static l0 v() {
        return x(TradeType.LINEAR_SWAP);
    }

    public static l0 w() {
        return x(TradeType.LINEAR_SWAP_V5);
    }

    public static l0 x(TradeType tradeType) {
        l0 l0Var = f40842x.get(tradeType);
        if (l0Var == null) {
            synchronized (l0.class) {
                l0Var = f40842x.get(tradeType);
                if (l0Var == null) {
                    l0Var = new l0(tradeType);
                    f40842x.put(tradeType, l0Var);
                }
            }
        }
        return l0Var;
    }

    public static l0 y() {
        return x(TradeType.SWAP);
    }

    public final void A(String str, double d11) {
        Subscription subscription = this.f40857o;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f40857o = Observable.from(this.f40845c).map(new i0(this, str, d11)).toList().map(new f0(this)).compose(RxJavaHelper.t((u6.g) null)).subscribe(new g());
    }

    public void J(String str, double d11, boolean z11) {
        this.f40847e = str;
        if (z11 && this.f40846d) {
            A(str, d11);
        }
    }

    public void K(String str) {
        this.f40854l = false;
        u().d();
        this.f40845c.clear();
        this.f40848f.clear();
        this.f40846d = false;
        this.f40850h = "-9527";
        this.f40851i.clear();
        this.f40849g.clear();
        this.f40852j.clear();
        this.f40853k.clear();
    }

    public final void L(ContractPosition contractPosition, BigDecimal bigDecimal) {
        contractPosition.lastPrice = bigDecimal.toPlainString();
        BigDecimal a11 = m.a(contractPosition.getCostOpen());
        BigDecimal a12 = m.a(contractPosition.getCostHold());
        BigDecimal a13 = m.a(contractPosition.getContractCurrencyInfo().getContractFace());
        BigDecimal a14 = m.a(contractPosition.getVolume());
        BigDecimal a15 = m.a(contractPosition.getLeverRate());
        OptionDirection optionDirection = OptionDirection.BUY;
        if (optionDirection.direction.equalsIgnoreCase(contractPosition.getDirection())) {
            contractPosition.setProfit(BigDecimal.ONE.divide(a11, 18, 1).subtract(BigDecimal.ONE.divide(bigDecimal, 18, 1)).multiply(a14).multiply(a13).toPlainString());
            contractPosition.setProfitUnreal(BigDecimal.ONE.divide(a12, 18, 1).subtract(BigDecimal.ONE.divide(bigDecimal, 18, 1)).multiply(a14).multiply(a13).toPlainString());
        } else {
            contractPosition.setProfit(BigDecimal.ONE.divide(bigDecimal, 18, 1).subtract(BigDecimal.ONE.divide(a11, 18, 1)).multiply(a14).multiply(a13).toPlainString());
            contractPosition.setProfitUnreal(BigDecimal.ONE.divide(bigDecimal, 18, 1).subtract(BigDecimal.ONE.divide(a12, 18, 1)).multiply(a14).multiply(a13).toPlainString());
        }
        if (optionDirection.direction.equalsIgnoreCase(contractPosition.getDirection())) {
            contractPosition.setProfitRate(BigDecimal.ONE.subtract(a11.divide(bigDecimal, 18, 1)).multiply(a15).toPlainString());
        } else {
            contractPosition.setProfitRate(a11.divide(bigDecimal, 18, 1).subtract(BigDecimal.ONE).multiply(a15).toPlainString());
        }
        contractPosition.setPositionMargin(a14.multiply(a13).divide(bigDecimal.multiply(a15), 18, 1).toPlainString());
    }

    public final void M(LinearSwapPositionOrderItem linearSwapPositionOrderItem, LinearSwapPosition linearSwapPosition, BigDecimal bigDecimal) {
        linearSwapPosition.lastPrice = bigDecimal.toPlainString();
        BigDecimal a11 = m.a(linearSwapPosition.getCostOpen());
        BigDecimal a12 = m.a(linearSwapPositionOrderItem.f26410c.contractFace);
        BigDecimal a13 = m.a(linearSwapPosition.getVolume());
        BigDecimal a14 = m.a(linearSwapPosition.getLeverRate());
        OptionDirection optionDirection = OptionDirection.BUY;
        if (optionDirection.direction.equalsIgnoreCase(linearSwapPosition.getDirection())) {
            linearSwapPosition.setProfit(bigDecimal.subtract(a11).multiply(a13).multiply(a12).toPlainString());
        } else {
            linearSwapPosition.setProfit(a11.subtract(bigDecimal).multiply(a13).multiply(a12).toPlainString());
        }
        if (optionDirection.direction.equalsIgnoreCase(linearSwapPosition.getDirection())) {
            linearSwapPosition.setProfitRate(bigDecimal.subtract(a11).multiply(a14).divide(a11, 18, 1).toPlainString());
        } else {
            linearSwapPosition.setProfitRate(a11.subtract(bigDecimal).multiply(a14).divide(a11, 18, 1).toPlainString());
        }
        boolean equalsIgnoreCase = FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(linearSwapPosition.getMarginMode());
        if (!ContractModuleConfig.a().b() || equalsIgnoreCase) {
            linearSwapPosition.setPositionMargin(a13.multiply(a12).multiply(bigDecimal).divide(a14, 18, 1).toPlainString());
        }
    }

    public final void N(SwapPositionItem swapPositionItem, SwapPosition swapPosition, BigDecimal bigDecimal) {
        swapPosition.lastPrice = bigDecimal.toPlainString();
        BigDecimal a11 = m.a(swapPosition.getCostOpen());
        BigDecimal a12 = m.a(swapPosition.getCostHold());
        BigDecimal a13 = m.a(swapPositionItem.e().getContractFace());
        BigDecimal a14 = m.a(swapPosition.getVolume());
        BigDecimal a15 = m.a(swapPosition.getLeverRate());
        OptionDirection optionDirection = OptionDirection.BUY;
        if (optionDirection.direction.equalsIgnoreCase(swapPosition.getDirection())) {
            swapPosition.setProfit(BigDecimal.ONE.divide(a11, 18, 1).subtract(BigDecimal.ONE.divide(bigDecimal, 18, 1)).multiply(a14).multiply(a13).toPlainString());
            swapPosition.setProfitUnreal(BigDecimal.ONE.divide(a12, 18, 1).subtract(BigDecimal.ONE.divide(bigDecimal, 18, 1)).multiply(a14).multiply(a13).toPlainString());
        } else {
            swapPosition.setProfit(BigDecimal.ONE.divide(bigDecimal, 18, 1).subtract(BigDecimal.ONE.divide(a11, 18, 1)).multiply(a14).multiply(a13).toPlainString());
            swapPosition.setProfitUnreal(BigDecimal.ONE.divide(bigDecimal, 18, 1).subtract(BigDecimal.ONE.divide(a12, 18, 1)).multiply(a14).multiply(a13).toPlainString());
        }
        if (optionDirection.direction.equalsIgnoreCase(swapPosition.getDirection())) {
            swapPosition.setProfitRate(BigDecimal.ONE.subtract(a11.divide(bigDecimal, 18, 1)).multiply(a15).toPlainString());
        } else {
            swapPosition.setProfitRate(a11.divide(bigDecimal, 18, 1).subtract(BigDecimal.ONE).multiply(a15).toPlainString());
        }
        swapPosition.setPositionMargin(a14.multiply(a13).divide(bigDecimal.multiply(a15), 18, 1).toPlainString());
    }

    public void O(List<ContractAccountInfo> list) {
        if (list != null && list.size() > 0) {
            for (ContractAccountInfo next : list) {
                this.f40853k.put(next.getSymbol(), next);
            }
        }
    }

    public void P(String str, List<? extends s9.a> list) {
        this.f40845c.clear();
        this.f40848f.clear();
        this.f40846d = false;
        this.f40847e = str;
        this.f40845c.addAll(list);
        Observable.just(list).filter(k0.f12443b).flatMap(j0.f12439b).map(new h0(this, str)).subscribeOn(Schedulers.io()).subscribe(new BaseSubscriber());
        if (list.size() > 0) {
            W();
        } else {
            Z();
        }
    }

    public void Q(i iVar) {
        this.f40844b = iVar;
    }

    public void R(List<LinearSwapAccountInfo> list) {
        if (list != null && list.size() > 0) {
            for (LinearSwapAccountInfo next : list) {
                this.f40851i.put(next.getContractCode(), next);
            }
        }
    }

    public void S(List<LinearSwapCrossAccountInfo> list) {
        if (list == null || list.size() <= 0) {
            this.f40850h = "0";
            return;
        }
        LinearSwapCrossAccountInfo linearSwapCrossAccountInfo = list.get(0);
        this.f40850h = linearSwapCrossAccountInfo.getMarginStatic();
        if (linearSwapCrossAccountInfo.getContractDetail() != null && linearSwapCrossAccountInfo.getContractDetail().size() > 0) {
            for (LinearSwapAccountInfo next : linearSwapCrossAccountInfo.getContractDetail()) {
                this.f40849g.put(next.getContractCode(), next);
            }
        }
        if (linearSwapCrossAccountInfo.getFuturesContractDetail() != null && linearSwapCrossAccountInfo.getFuturesContractDetail().size() > 0) {
            for (LinearSwapAccountInfo next2 : linearSwapCrossAccountInfo.getFuturesContractDetail()) {
                this.f40849g.put(next2.getContractCode(), next2);
            }
        }
    }

    public void T(List<SwapAccountInfo> list) {
        if (list != null && list.size() > 0) {
            for (SwapAccountInfo next : list) {
                this.f40852j.put(next.getContractCode(), next);
            }
        }
    }

    public void U(boolean z11) {
        this.f40855m = z11;
    }

    /* renamed from: V */
    public void F() {
        if (BaseModuleConfig.a().a()) {
            s7.a u11 = u();
            u11.b(BaseModuleConfig.a().getUid(), BaseModuleConfig.a().f(), this.f40859q);
            u11.a(this.f40858p);
        }
    }

    public void W() {
        if (BaseModuleConfig.a().a()) {
            TradeType tradeType = this.f40843a;
            if (tradeType == TradeType.LINEAR_SWAP) {
                if (!this.f40855m) {
                    k.g().e("linearswap_overview_position", this.f40861s);
                    k.g().i();
                }
            } else if (tradeType == TradeType.SWAP) {
                r.g().e("swap_overview_position", this.f40862t);
                r.g().i();
            } else if (tradeType == TradeType.CONTRACT) {
                o6.b.g().e("contract_overview_position", this.f40860r);
                o6.b.g().i();
            }
        }
    }

    public void X(boolean z11) {
        this.f40855m = z11;
        if (!z11) {
            this.f40854l = false;
            u().d();
        } else if (!this.f40854l) {
            F();
        }
    }

    public void Y() {
        s7.a u11 = u();
        u11.g(this.f40858p);
        u11.h(false, "user_event_trigger.*", this.f40864v);
        this.f40854l = false;
        Z();
    }

    public void Z() {
        TradeType tradeType = this.f40843a;
        if (tradeType == TradeType.LINEAR_SWAP) {
            if (!this.f40855m) {
                k.g().j("linearswap_overview_position");
                k.g().n();
            }
        } else if (tradeType == TradeType.SWAP) {
            r.g().j("swap_overview_position");
            r.g().n();
        } else if (tradeType == TradeType.CONTRACT) {
            o6.b.g().j("contract_overview_position");
            o6.b.g().n();
        }
    }

    public final void p() {
        Iterator<s9.a> it2 = this.f40845c.iterator();
        HashMap hashMap = new HashMap();
        while (it2.hasNext()) {
            ContractPosition contractPosition = (ContractPosition) it2.next();
            if (hashMap.get(contractPosition.symbol) != null) {
                contractPosition.newRiskRate = (String) hashMap.get(contractPosition.symbol);
            } else {
                ContractAccountInfo contractAccountInfo = this.f40853k.get(contractPosition.symbol);
                if (contractAccountInfo != null) {
                    BigDecimal bigDecimal = BigDecimal.ZERO;
                    BigDecimal bigDecimal2 = bigDecimal;
                    for (String str : f40841w) {
                        BigDecimal bigDecimal3 = BigDecimal.ZERO;
                        BigDecimal bigDecimal4 = BigDecimal.ONE;
                        ContractPosition contractPosition2 = (ContractPosition) this.f40848f.get(contractPosition.getSymbol() + str + OptionDirection.BUY.direction);
                        if (contractPosition2 != null) {
                            bigDecimal2 = bigDecimal2.add(m.a(contractPosition2.profitUnreal));
                            bigDecimal3 = m.a(contractPosition2.volume);
                            bigDecimal4 = m.a(contractPosition2.lastPrice);
                        }
                        ContractPosition contractPosition3 = (ContractPosition) this.f40848f.get(contractPosition.getSymbol() + str + OptionDirection.SELL.direction);
                        if (contractPosition3 != null) {
                            bigDecimal2 = bigDecimal2.add(m.a(contractPosition3.profitUnreal));
                            bigDecimal3 = m.a(contractPosition3.volume).max(bigDecimal3);
                            bigDecimal4 = m.a(contractPosition3.lastPrice);
                        }
                        bigDecimal = bigDecimal.add(bigDecimal3.multiply(m.a(contractPosition.getContractCurrencyInfo().getContractFace())).multiply(m.a(contractAccountInfo.getAdjustFactor())).divide(m.a(contractPosition.getLeverRate()).multiply(bigDecimal4), 18, 1));
                    }
                    String plainString = bigDecimal.divide(bigDecimal2.add(m.a(contractAccountInfo.getMarginStatic())), 18, 1).toPlainString();
                    contractPosition.newRiskRate = plainString;
                    hashMap.put(contractPosition.symbol, plainString);
                }
            }
        }
        hashMap.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x036d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03d6  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0354  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q() {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = r0.f40850h
            java.lang.String r2 = "-9527"
            boolean r1 = r2.equals(r1)
            r2 = 1
            r1 = r1 ^ r2
            java.math.BigDecimal r3 = java.math.BigDecimal.ZERO
            java.lang.String r4 = "cross"
            if (r1 == 0) goto L_0x00b5
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.concurrent.CopyOnWriteArrayList<s9.a> r6 = r0.f40845c
            java.util.Iterator r6 = r6.iterator()
            r7 = r3
        L_0x001e:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00b6
            java.lang.Object r8 = r6.next()
            com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem r8 = (com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem) r8
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r8 = r8.f26409b
            java.lang.String r9 = r8.getMarginMode()
            boolean r9 = r4.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x001e
            java.lang.String r9 = r8.profit
            java.math.BigDecimal r9 = i6.m.a(r9)
            java.math.BigDecimal r3 = r3.add(r9)
            java.lang.String r9 = r8.contractCode
            boolean r9 = r5.containsKey(r9)
            if (r9 == 0) goto L_0x0049
            goto L_0x001e
        L_0x0049:
            java.util.Map<java.lang.String, com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo> r9 = r0.f40849g
            java.lang.String r10 = r8.contractCode
            java.lang.Object r9 = r9.get(r10)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo r9 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo) r9
            if (r9 != 0) goto L_0x0056
            goto L_0x001e
        L_0x0056:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.hbg.lib.network.pro.socket.response.ContractPositionWsData> r10 = r0.f40848f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r8.getContractCode()
            r11.append(r12)
            java.lang.String r12 = r8.getMarginMode()
            r11.append(r12)
            com.hbg.lib.network.option.core.util.OptionDirection r12 = com.hbg.lib.network.option.core.util.OptionDirection.BUY
            java.lang.String r13 = r12.direction
            java.lang.String r14 = r8.getDirection()
            boolean r13 = r13.equalsIgnoreCase(r14)
            if (r13 == 0) goto L_0x007b
            com.hbg.lib.network.option.core.util.OptionDirection r12 = com.hbg.lib.network.option.core.util.OptionDirection.SELL
        L_0x007b:
            java.lang.String r12 = r12.direction
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.Object r10 = r10.get(r11)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r10 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition) r10
            java.lang.String r11 = r8.positionMargin
            java.math.BigDecimal r11 = i6.m.a(r11)
            if (r10 == 0) goto L_0x009c
            java.lang.String r10 = r10.positionMargin
            java.math.BigDecimal r10 = i6.m.a(r10)
            java.math.BigDecimal r11 = r10.max(r11)
        L_0x009c:
            java.lang.String r9 = r9.getAdjustFactor()
            java.math.BigDecimal r9 = i6.m.a(r9)
            java.math.BigDecimal r9 = r11.multiply(r9)
            java.math.BigDecimal r7 = r7.add(r9)
            java.lang.String r8 = r8.contractCode
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            r5.put(r8, r9)
            goto L_0x001e
        L_0x00b5:
            r7 = r3
        L_0x00b6:
            java.util.concurrent.CopyOnWriteArrayList<s9.a> r5 = r0.f40845c
            java.util.Iterator r5 = r5.iterator()
        L_0x00bc:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x03e3
            java.lang.Object r6 = r5.next()
            com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem r6 = (com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem) r6
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r8 = r6.f26409b
            java.lang.String r9 = r8.getMarginMode()
            boolean r9 = r4.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x01fa
            if (r1 != 0) goto L_0x00d7
            goto L_0x00bc
        L_0x00d7:
            java.util.Map<java.lang.String, com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo> r9 = r0.f40849g
            java.lang.String r12 = r8.contractCode
            java.lang.Object r9 = r9.get(r12)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo r9 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo) r9
            if (r9 != 0) goto L_0x00e4
            goto L_0x00bc
        L_0x00e4:
            com.hbg.lib.network.option.core.util.OptionDirection r12 = com.hbg.lib.network.option.core.util.OptionDirection.BUY
            java.lang.String r13 = r12.direction
            java.lang.String r14 = r8.getDirection()
            boolean r13 = r13.equalsIgnoreCase(r14)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.hbg.lib.network.pro.socket.response.ContractPositionWsData> r14 = r0.f40848f
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r10 = r8.getContractCode()
            r15.append(r10)
            java.lang.String r10 = r8.getMarginMode()
            r15.append(r10)
            if (r13 == 0) goto L_0x010c
            com.hbg.lib.network.option.core.util.OptionDirection r10 = com.hbg.lib.network.option.core.util.OptionDirection.SELL
            java.lang.String r10 = r10.direction
            goto L_0x010e
        L_0x010c:
            java.lang.String r10 = r12.direction
        L_0x010e:
            r15.append(r10)
            java.lang.String r10 = r15.toString()
            java.lang.Object r10 = r14.get(r10)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r10 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition) r10
            if (r13 == 0) goto L_0x0124
            java.lang.String r12 = r8.volume
        L_0x011f:
            java.math.BigDecimal r12 = i6.m.a(r12)
            goto L_0x012b
        L_0x0124:
            if (r10 == 0) goto L_0x0129
            java.lang.String r12 = r10.volume
            goto L_0x011f
        L_0x0129:
            java.math.BigDecimal r12 = java.math.BigDecimal.ZERO
        L_0x012b:
            if (r13 == 0) goto L_0x0134
            java.lang.String r14 = r8.costHold
        L_0x012f:
            java.math.BigDecimal r14 = i6.m.a(r14)
            goto L_0x013b
        L_0x0134:
            if (r10 == 0) goto L_0x0139
            java.lang.String r14 = r10.costHold
            goto L_0x012f
        L_0x0139:
            java.math.BigDecimal r14 = java.math.BigDecimal.ONE
        L_0x013b:
            if (r13 == 0) goto L_0x0145
            if (r10 == 0) goto L_0x0142
            java.lang.String r15 = r10.volume
            goto L_0x0147
        L_0x0142:
            java.math.BigDecimal r15 = java.math.BigDecimal.ZERO
            goto L_0x014b
        L_0x0145:
            java.lang.String r15 = r8.volume
        L_0x0147:
            java.math.BigDecimal r15 = i6.m.a(r15)
        L_0x014b:
            if (r13 == 0) goto L_0x0155
            if (r10 == 0) goto L_0x0152
            java.lang.String r13 = r10.costHold
            goto L_0x0157
        L_0x0152:
            java.math.BigDecimal r13 = java.math.BigDecimal.ONE
            goto L_0x015b
        L_0x0155:
            java.lang.String r13 = r8.costHold
        L_0x0157:
            java.math.BigDecimal r13 = i6.m.a(r13)
        L_0x015b:
            java.lang.String r9 = r9.getAdjustFactor()
            java.math.BigDecimal r9 = i6.m.a(r9)
            java.lang.String r2 = r8.profit
            java.math.BigDecimal r2 = i6.m.a(r2)
            if (r10 == 0) goto L_0x0172
            java.lang.String r11 = r10.profit
            java.math.BigDecimal r11 = i6.m.a(r11)
            goto L_0x0174
        L_0x0172:
            java.math.BigDecimal r11 = java.math.BigDecimal.ZERO
        L_0x0174:
            java.math.BigDecimal r2 = r2.add(r11)
            java.lang.String r11 = r8.positionMargin
            java.math.BigDecimal r11 = i6.m.a(r11)
            if (r10 == 0) goto L_0x018a
            java.lang.String r10 = r10.positionMargin
            java.math.BigDecimal r10 = i6.m.a(r10)
            java.math.BigDecimal r11 = r10.max(r11)
        L_0x018a:
            java.math.BigDecimal r10 = r11.multiply(r9)
            com.hbg.lib.data.future.bean.FutureContractInfo r6 = r6.f26410c
            java.lang.String r6 = r6.contractFace
            java.math.BigDecimal r6 = i6.m.a(r6)
            java.math.BigDecimal r11 = r14.multiply(r12)
            java.math.BigDecimal r13 = r13.multiply(r15)
            java.math.BigDecimal r11 = r11.subtract(r13)
            java.math.BigDecimal r11 = r6.multiply(r11)
            java.lang.String r13 = r0.f40850h
            java.math.BigDecimal r13 = i6.m.a(r13)
            java.math.BigDecimal r11 = r11.subtract(r13)
            java.math.BigDecimal r2 = r3.subtract(r2)
            java.math.BigDecimal r2 = r11.subtract(r2)
            java.math.BigDecimal r10 = r7.subtract(r10)
            java.math.BigDecimal r2 = r2.add(r10)
            java.math.BigDecimal r10 = r12.subtract(r15)
            java.math.BigDecimal r11 = r12.max(r15)
            java.math.BigDecimal r9 = r9.multiply(r11)
            java.lang.String r11 = r8.leverRate
            java.math.BigDecimal r11 = i6.m.a(r11)
            r12 = 18
            r13 = 1
            java.math.BigDecimal r9 = r9.divide(r11, r12, r13)
            java.math.BigDecimal r9 = r10.subtract(r9)
            java.math.BigDecimal r6 = r6.multiply(r9)
            java.math.BigDecimal r2 = r2.divide(r6, r12, r13)
            java.math.BigDecimal r6 = java.math.BigDecimal.ZERO
            int r6 = r2.compareTo(r6)
            if (r6 <= 0) goto L_0x01f5
            java.lang.String r2 = r2.toPlainString()
            r8.liquidationPrice = r2
            goto L_0x02f5
        L_0x01f5:
            r2 = 0
            r8.liquidationPrice = r2
            goto L_0x02f5
        L_0x01fa:
            sc.a r2 = com.hbg.module.contract.ContractModuleConfig.a()
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x02f8
            java.util.Map<java.lang.String, com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo> r2 = r0.f40851i
            java.lang.String r9 = r8.contractCode
            java.lang.Object r2 = r2.get(r9)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo r2 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo) r2
            if (r2 != 0) goto L_0x0212
            goto L_0x0304
        L_0x0212:
            com.hbg.lib.network.option.core.util.OptionDirection r9 = com.hbg.lib.network.option.core.util.OptionDirection.BUY
            java.lang.String r9 = r9.direction
            java.lang.String r10 = r8.getDirection()
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x0282
            java.lang.String r9 = r8.costOpen
            java.math.BigDecimal r9 = i6.m.a(r9)
            java.lang.String r10 = r8.volume
            java.math.BigDecimal r10 = i6.m.a(r10)
            java.lang.String r11 = r8.lastPrice
            java.math.BigDecimal r11 = i6.m.a(r11)
            java.math.BigDecimal r10 = r10.multiply(r11)
            com.hbg.lib.data.future.bean.FutureContractInfo r11 = r6.f26410c
            java.lang.String r11 = r11.contractFace
            java.math.BigDecimal r11 = i6.m.a(r11)
            java.math.BigDecimal r10 = r10.multiply(r11)
            java.lang.String r2 = r2.getAdjustFactor()
            java.math.BigDecimal r2 = i6.m.a(r2)
            java.math.BigDecimal r2 = r10.multiply(r2)
            java.lang.String r10 = r8.getLeverRate()
            java.math.BigDecimal r10 = i6.m.a(r10)
            r11 = 18
            r12 = 1
            java.math.BigDecimal r2 = r2.divide(r10, r11, r12)
            java.lang.String r10 = r8.positionMargin
            java.math.BigDecimal r10 = i6.m.a(r10)
            java.math.BigDecimal r2 = r2.subtract(r10)
            java.lang.String r10 = r8.volume
            java.math.BigDecimal r10 = i6.m.a(r10)
            com.hbg.lib.data.future.bean.FutureContractInfo r6 = r6.f26410c
            java.lang.String r6 = r6.contractFace
            java.math.BigDecimal r6 = i6.m.a(r6)
            java.math.BigDecimal r6 = r10.multiply(r6)
            java.math.BigDecimal r2 = r2.divide(r6, r11, r12)
            java.math.BigDecimal r2 = r9.add(r2)
            goto L_0x02e3
        L_0x0282:
            java.lang.String r9 = r8.costOpen
            java.math.BigDecimal r9 = i6.m.a(r9)
            java.lang.String r10 = r8.volume
            java.math.BigDecimal r10 = i6.m.a(r10)
            java.lang.String r11 = r8.lastPrice
            java.math.BigDecimal r11 = i6.m.a(r11)
            java.math.BigDecimal r10 = r10.multiply(r11)
            com.hbg.lib.data.future.bean.FutureContractInfo r11 = r6.f26410c
            java.lang.String r11 = r11.contractFace
            java.math.BigDecimal r11 = i6.m.a(r11)
            java.math.BigDecimal r10 = r10.multiply(r11)
            java.lang.String r2 = r2.getAdjustFactor()
            java.math.BigDecimal r2 = i6.m.a(r2)
            java.math.BigDecimal r2 = r10.multiply(r2)
            java.lang.String r10 = r8.getLeverRate()
            java.math.BigDecimal r10 = i6.m.a(r10)
            r11 = 18
            r12 = 1
            java.math.BigDecimal r2 = r2.divide(r10, r11, r12)
            java.lang.String r10 = r8.positionMargin
            java.math.BigDecimal r10 = i6.m.a(r10)
            java.math.BigDecimal r2 = r2.subtract(r10)
            java.lang.String r10 = r8.volume
            java.math.BigDecimal r10 = i6.m.a(r10)
            com.hbg.lib.data.future.bean.FutureContractInfo r6 = r6.f26410c
            java.lang.String r6 = r6.contractFace
            java.math.BigDecimal r6 = i6.m.a(r6)
            java.math.BigDecimal r6 = r10.multiply(r6)
            java.math.BigDecimal r2 = r2.divide(r6, r11, r12)
            java.math.BigDecimal r2 = r9.subtract(r2)
        L_0x02e3:
            java.math.BigDecimal r6 = java.math.BigDecimal.ZERO
            int r6 = r2.compareTo(r6)
            if (r6 <= 0) goto L_0x02f2
            java.lang.String r2 = r2.toPlainString()
            r8.liquidationPrice = r2
            goto L_0x02f5
        L_0x02f2:
            r2 = 0
            r8.liquidationPrice = r2
        L_0x02f5:
            r13 = 1
            goto L_0x03e0
        L_0x02f8:
            java.util.Map<java.lang.String, com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo> r2 = r0.f40851i
            java.lang.String r9 = r8.contractCode
            java.lang.Object r2 = r2.get(r9)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo r2 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo) r2
            if (r2 != 0) goto L_0x0307
        L_0x0304:
            r2 = 1
            goto L_0x00bc
        L_0x0307:
            com.hbg.lib.network.option.core.util.OptionDirection r9 = com.hbg.lib.network.option.core.util.OptionDirection.BUY
            java.lang.String r10 = r9.direction
            java.lang.String r11 = r8.getDirection()
            boolean r10 = r10.equalsIgnoreCase(r11)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.hbg.lib.network.pro.socket.response.ContractPositionWsData> r11 = r0.f40848f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = r8.getContractCode()
            r12.append(r13)
            java.lang.String r13 = r8.getMarginMode()
            r12.append(r13)
            if (r10 == 0) goto L_0x032c
            com.hbg.lib.network.option.core.util.OptionDirection r9 = com.hbg.lib.network.option.core.util.OptionDirection.SELL
        L_0x032c:
            java.lang.String r9 = r9.direction
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            java.lang.Object r9 = r11.get(r9)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r9 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition) r9
            if (r10 == 0) goto L_0x0344
            java.lang.String r11 = r8.volume
        L_0x033f:
            java.math.BigDecimal r11 = i6.m.a(r11)
            goto L_0x034b
        L_0x0344:
            if (r9 == 0) goto L_0x0349
            java.lang.String r11 = r9.volume
            goto L_0x033f
        L_0x0349:
            java.math.BigDecimal r11 = java.math.BigDecimal.ZERO
        L_0x034b:
            if (r10 == 0) goto L_0x0354
            java.lang.String r12 = r8.costHold
        L_0x034f:
            java.math.BigDecimal r12 = i6.m.a(r12)
            goto L_0x035b
        L_0x0354:
            if (r9 == 0) goto L_0x0359
            java.lang.String r12 = r9.costHold
            goto L_0x034f
        L_0x0359:
            java.math.BigDecimal r12 = java.math.BigDecimal.ONE
        L_0x035b:
            if (r10 == 0) goto L_0x0365
            if (r9 == 0) goto L_0x0362
            java.lang.String r13 = r9.volume
            goto L_0x0367
        L_0x0362:
            java.math.BigDecimal r13 = java.math.BigDecimal.ZERO
            goto L_0x036b
        L_0x0365:
            java.lang.String r13 = r8.volume
        L_0x0367:
            java.math.BigDecimal r13 = i6.m.a(r13)
        L_0x036b:
            if (r10 == 0) goto L_0x0375
            if (r9 == 0) goto L_0x0372
            java.lang.String r9 = r9.costHold
            goto L_0x0377
        L_0x0372:
            java.math.BigDecimal r9 = java.math.BigDecimal.ONE
            goto L_0x037b
        L_0x0375:
            java.lang.String r9 = r8.costHold
        L_0x0377:
            java.math.BigDecimal r9 = i6.m.a(r9)
        L_0x037b:
            com.hbg.lib.data.future.bean.FutureContractInfo r6 = r6.f26410c
            java.lang.String r6 = r6.contractFace
            java.math.BigDecimal r6 = i6.m.a(r6)
            java.math.BigDecimal r10 = r12.multiply(r11)
            java.math.BigDecimal r9 = r9.multiply(r13)
            java.math.BigDecimal r9 = r10.subtract(r9)
            java.math.BigDecimal r9 = r6.multiply(r9)
            java.lang.String r10 = r2.getMarginStatic()
            java.math.BigDecimal r10 = i6.m.a(r10)
            java.math.BigDecimal r9 = r9.subtract(r10)
            java.math.BigDecimal r10 = r11.subtract(r13)
            java.lang.String r2 = r2.getAdjustFactor()
            java.math.BigDecimal r2 = i6.m.a(r2)
            java.math.BigDecimal r11 = r11.max(r13)
            java.math.BigDecimal r2 = r2.multiply(r11)
            java.lang.String r11 = r8.getLeverRate()
            java.math.BigDecimal r11 = i6.m.a(r11)
            r12 = 18
            r13 = 1
            java.math.BigDecimal r2 = r2.divide(r11, r12, r13)
            java.math.BigDecimal r2 = r10.subtract(r2)
            java.math.BigDecimal r2 = r6.multiply(r2)
            java.math.BigDecimal r2 = r9.divide(r2, r12, r13)
            java.math.BigDecimal r6 = java.math.BigDecimal.ZERO
            int r6 = r2.compareTo(r6)
            if (r6 <= 0) goto L_0x03dd
            java.lang.String r2 = r2.toPlainString()
            r8.liquidationPrice = r2
            goto L_0x03e0
        L_0x03dd:
            r2 = 0
            r8.liquidationPrice = r2
        L_0x03e0:
            r2 = r13
            goto L_0x00bc
        L_0x03e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bj.l0.q():void");
    }

    public final void r() {
        BigDecimal bigDecimal;
        LinearSwapAccountInfo linearSwapAccountInfo;
        BigDecimal bigDecimal2;
        LinearSwapAccountInfo linearSwapAccountInfo2;
        boolean z11 = !"-9527".equals(this.f40850h);
        if (ContractModuleConfig.a().b()) {
            BigDecimal bigDecimal3 = BigDecimal.ZERO;
            if (z11) {
                HashMap hashMap = new HashMap();
                Iterator<s9.a> it2 = this.f40845c.iterator();
                bigDecimal2 = bigDecimal3;
                while (it2.hasNext()) {
                    LinearSwapPositionOrderItem linearSwapPositionOrderItem = (LinearSwapPositionOrderItem) it2.next();
                    LinearSwapPosition linearSwapPosition = linearSwapPositionOrderItem.f26409b;
                    if (FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(linearSwapPosition.getMarginMode())) {
                        bigDecimal3 = bigDecimal3.add(m.a(linearSwapPosition.profit));
                        if (!hashMap.containsKey(linearSwapPosition.contractCode) && (linearSwapAccountInfo2 = this.f40849g.get(linearSwapPosition.contractCode)) != null) {
                            ConcurrentHashMap<String, ContractPositionWsData> concurrentHashMap = this.f40848f;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(linearSwapPosition.getContractCode());
                            sb2.append(linearSwapPosition.getMarginMode());
                            OptionDirection optionDirection = OptionDirection.BUY;
                            sb2.append(optionDirection.direction.equalsIgnoreCase(linearSwapPosition.getDirection()) ? OptionDirection.SELL.direction : optionDirection.direction);
                            LinearSwapPosition linearSwapPosition2 = (LinearSwapPosition) concurrentHashMap.get(sb2.toString());
                            BigDecimal a11 = m.a(linearSwapPosition.volume);
                            if (linearSwapPosition2 != null) {
                                a11 = m.a(linearSwapPosition2.volume).max(a11);
                            }
                            bigDecimal2 = bigDecimal2.add(a11.multiply(m.a(linearSwapPosition.lastPrice)).multiply(m.a(linearSwapPositionOrderItem.f26410c.contractFace)).multiply(m.a(linearSwapAccountInfo2.getAdjustFactor())).divide(m.a(linearSwapPosition.getLeverRate()), 18, 1));
                            hashMap.put(linearSwapPosition.contractCode, Boolean.TRUE);
                        }
                    }
                }
            } else {
                bigDecimal2 = bigDecimal3;
            }
            Iterator<s9.a> it3 = this.f40845c.iterator();
            while (it3.hasNext()) {
                LinearSwapPositionOrderItem linearSwapPositionOrderItem2 = (LinearSwapPositionOrderItem) it3.next();
                LinearSwapPosition linearSwapPosition3 = linearSwapPositionOrderItem2.f26409b;
                if (!FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(linearSwapPosition3.getMarginMode())) {
                    LinearSwapAccountInfo linearSwapAccountInfo3 = this.f40851i.get(linearSwapPosition3.contractCode);
                    if (linearSwapAccountInfo3 != null) {
                        linearSwapPosition3.newRiskRate = m.a(linearSwapPosition3.volume).multiply(m.a(linearSwapPosition3.lastPrice)).multiply(m.a(linearSwapPositionOrderItem2.f26410c.contractFace)).multiply(m.a(linearSwapAccountInfo3.getAdjustFactor())).divide(m.a(linearSwapPosition3.getLeverRate()).multiply(m.a(linearSwapPosition3.positionMargin).add(m.a(linearSwapPosition3.profit))), 18, 1).toPlainString();
                    }
                } else if (z11) {
                    linearSwapPosition3.newRiskRate = bigDecimal2.divide(bigDecimal3.add(m.a(this.f40850h)), 18, 1).toPlainString();
                }
            }
            return;
        }
        BigDecimal bigDecimal4 = BigDecimal.ZERO;
        if (z11) {
            HashSet hashSet = new HashSet();
            Iterator<s9.a> it4 = this.f40845c.iterator();
            bigDecimal = bigDecimal4;
            while (it4.hasNext()) {
                LinearSwapPosition linearSwapPosition4 = ((LinearSwapPositionOrderItem) it4.next()).f26409b;
                if (FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(linearSwapPosition4.getMarginMode())) {
                    bigDecimal4 = bigDecimal4.add(m.a(linearSwapPosition4.profit));
                    if (!hashSet.contains(linearSwapPosition4.contractCode) && (linearSwapAccountInfo = this.f40849g.get(linearSwapPosition4.contractCode)) != null) {
                        ConcurrentHashMap<String, ContractPositionWsData> concurrentHashMap2 = this.f40848f;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(linearSwapPosition4.getContractCode());
                        sb3.append(linearSwapPosition4.getMarginMode());
                        OptionDirection optionDirection2 = OptionDirection.BUY;
                        if (optionDirection2.direction.equalsIgnoreCase(linearSwapPosition4.getDirection())) {
                            optionDirection2 = OptionDirection.SELL;
                        }
                        sb3.append(optionDirection2.direction);
                        LinearSwapPosition linearSwapPosition5 = (LinearSwapPosition) concurrentHashMap2.get(sb3.toString());
                        BigDecimal a12 = m.a(linearSwapPosition4.positionMargin);
                        if (linearSwapPosition5 != null) {
                            a12 = m.a(linearSwapPosition5.positionMargin).max(a12);
                        }
                        bigDecimal = bigDecimal.add(a12.add(m.a(linearSwapAccountInfo.getMarginFrozen())).multiply(m.a(linearSwapAccountInfo.getAdjustFactor())));
                        hashSet.add(linearSwapPosition4.contractCode);
                    }
                }
            }
            for (Map.Entry next : this.f40849g.entrySet()) {
                LinearSwapAccountInfo linearSwapAccountInfo4 = (LinearSwapAccountInfo) next.getValue();
                if (!hashSet.contains(next.getKey()) && (!"0".equals(linearSwapAccountInfo4.getMarginPosition()) || !"0".equals(linearSwapAccountInfo4.getMarginFrozen()))) {
                    bigDecimal = bigDecimal.add(m.a(linearSwapAccountInfo4.getMarginPosition()).add(m.a(linearSwapAccountInfo4.getMarginFrozen())).multiply(m.a(linearSwapAccountInfo4.getAdjustFactor())));
                }
            }
            hashSet.clear();
        } else {
            bigDecimal = bigDecimal4;
        }
        Iterator<s9.a> it5 = this.f40845c.iterator();
        while (it5.hasNext()) {
            LinearSwapPosition linearSwapPosition6 = ((LinearSwapPositionOrderItem) it5.next()).f26409b;
            if (!FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(linearSwapPosition6.getMarginMode())) {
                LinearSwapAccountInfo linearSwapAccountInfo5 = this.f40851i.get(linearSwapPosition6.contractCode);
                if (linearSwapAccountInfo5 != null) {
                    BigDecimal a13 = m.a(linearSwapPosition6.profit);
                    ConcurrentHashMap<String, ContractPositionWsData> concurrentHashMap3 = this.f40848f;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(linearSwapPosition6.getContractCode());
                    sb4.append(linearSwapPosition6.getMarginMode());
                    OptionDirection optionDirection3 = OptionDirection.BUY;
                    if (optionDirection3.direction.equalsIgnoreCase(linearSwapPosition6.getDirection())) {
                        optionDirection3 = OptionDirection.SELL;
                    }
                    sb4.append(optionDirection3.direction);
                    LinearSwapPosition linearSwapPosition7 = (LinearSwapPosition) concurrentHashMap3.get(sb4.toString());
                    BigDecimal a14 = m.a(linearSwapPosition6.positionMargin);
                    if (linearSwapPosition7 != null) {
                        a14 = m.a(linearSwapPosition7.positionMargin).max(a14);
                        a13 = a13.add(m.a(linearSwapPosition7.profit));
                    }
                    linearSwapPosition6.riskRate = m.a(linearSwapAccountInfo5.getMarginStatic()).add(a13).divide(a14.add(m.a(linearSwapAccountInfo5.getMarginFrozen())), 18, 1).subtract(m.a(linearSwapAccountInfo5.getAdjustFactor())).toPlainString();
                }
            } else if (z11) {
                linearSwapPosition6.riskRate = bigDecimal4.add(m.a(this.f40850h)).divide(bigDecimal, 18, 1).subtract(BigDecimal.ONE).toPlainString();
            }
        }
    }

    public final void s() {
        Iterator<s9.a> it2 = this.f40845c.iterator();
        while (it2.hasNext()) {
            SwapPositionItem swapPositionItem = (SwapPositionItem) it2.next();
            SwapPosition d11 = swapPositionItem.d();
            SwapAccountInfo swapAccountInfo = this.f40852j.get(d11.contractCode);
            if (swapAccountInfo != null) {
                BigDecimal a11 = m.a(d11.profitUnreal);
                ConcurrentHashMap<String, ContractPositionWsData> concurrentHashMap = this.f40848f;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d11.getContractCode());
                OptionDirection optionDirection = OptionDirection.BUY;
                if (optionDirection.direction.equalsIgnoreCase(d11.getDirection())) {
                    optionDirection = OptionDirection.SELL;
                }
                sb2.append(optionDirection.direction);
                SwapPosition swapPosition = (SwapPosition) concurrentHashMap.get(sb2.toString());
                BigDecimal a12 = m.a(d11.volume);
                if (swapPosition != null) {
                    a12 = m.a(swapPosition.volume).max(a12);
                    a11 = a11.add(m.a(swapPosition.profitUnreal));
                }
                d11.newRiskRate = a12.multiply(m.a(swapPositionItem.e().getContractFace())).multiply(m.a(swapAccountInfo.getAdjustFactor())).divide(m.a(d11.getLeverRate()).multiply(m.a(d11.lastPrice)), 18, 1).divide(a11.add(m.a(swapAccountInfo.getMarginStatic())), 18, 1).toPlainString();
            }
        }
    }

    public final s7.a u() {
        TradeType tradeType = this.f40843a;
        if (tradeType == TradeType.LINEAR_SWAP) {
            return ContractPositionApi.c();
        }
        if (tradeType == TradeType.LINEAR_SWAP_V5) {
            return ContractPositionApi.d();
        }
        if (tradeType == TradeType.SWAP) {
            return ContractPositionApi.e();
        }
        if (tradeType == TradeType.CONTRACT) {
            return ContractPositionApi.b();
        }
        return ContractPositionApi.c();
    }

    public final void z() {
        Subscription subscription = this.f40856n;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f40856n = Observable.from(this.f40845c).map(new e0(this)).toList().map(new g0(this)).compose(RxJavaHelper.t((u6.g) null)).subscribe(new h());
    }
}
