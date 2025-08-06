package yo;

import android.text.TextUtils;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.pro.core.bean.AlgoOrderCancelResult;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.bean.AlgoOrderMatchResult;
import com.hbg.lib.network.pro.core.bean.AlgoSpecificOrderInfo;
import com.hbg.lib.network.pro.core.bean.ExchangeOpenOrder;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.retrofit.ProRetrofit;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.entity.AccountType;
import com.huobi.order.bean.CurrentTimeTradeInfo;
import com.huobi.order.bean.ExchangeOpenOrderItem;
import com.huobi.order.bean.OrderBean;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.order.provider.OrderParams;
import com.huobi.order.service.OrderService;
import com.huobi.trade.bean.TradeOrderAssets;
import com.huobi.trade.bean.TradeOrderOutstanding;
import com.huobi.trade.bean.TradeOrderPositions;
import dt.h2;
import i6.k;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;
import tq.p;

public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f85068a;

    public class a implements Func1<AlgoOrderInfo, s9.a> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f85069b;

        public a(int i11) {
            this.f85069b = i11;
        }

        /* renamed from: a */
        public s9.a call(AlgoOrderInfo algoOrderInfo) {
            if (this.f85069b == 2) {
                return new CurrentTimeTradeInfo(algoOrderInfo, true);
            }
            return new vo.a(algoOrderInfo, true);
        }
    }

    public class b implements Func1<List<AlgoOrderInfo>, Observable<AlgoOrderInfo>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<AlgoOrderInfo> call(List<AlgoOrderInfo> list) {
            return Observable.from(list);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static s0 f85072a = new s0((a) null);
    }

    public static class d extends e {

        /* renamed from: h  reason: collision with root package name */
        public String f85073h;

        public d(int i11, int i12, long j11, String str, String str2) {
            super(i11, i12, j11, str);
            this.f85073h = str2;
        }
    }

    public /* synthetic */ s0(a aVar) {
        this();
    }

    public static /* synthetic */ Long A0(Long l11) {
        return l11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable B0(String str, d dVar, Long l11) {
        return f0(l11.longValue(), str, dVar);
    }

    public static /* synthetic */ ExchangeOpenOrderItem D0(ExchangeOpenOrder exchangeOpenOrder) {
        ExchangeOpenOrderItem exchangeOpenOrderItem = new ExchangeOpenOrderItem();
        exchangeOpenOrderItem.l(exchangeOpenOrder);
        return exchangeOpenOrderItem;
    }

    public static /* synthetic */ List E0(List list) {
        return list;
    }

    public static /* synthetic */ Serializable G0(int i11, OrderBean orderBean) {
        return i11 == 2 ? orderBean.transToTradeOrderHistory() : orderBean;
    }

    public static /* synthetic */ List H0(List list) {
        return list;
    }

    public static /* synthetic */ Boolean I0(TradeType tradeType, Long l11) {
        return Boolean.valueOf(h2.t1().G1(tradeType, AccountType.spot.toString()) != 0);
    }

    public static /* synthetic */ Observable K0(Observable observable, Long l11) {
        return observable;
    }

    public static /* synthetic */ Boolean L0(String str, Long l11) {
        return Boolean.valueOf(h2.t1().C1(AccountType.margin.toString(), str) != 0);
    }

    public static /* synthetic */ Observable N0(Observable observable, Long l11) {
        return observable;
    }

    public static /* synthetic */ Boolean O0(String str, Long l11) {
        return Boolean.valueOf(h2.t1().C1(AccountType.borrow.toString(), str) != 0);
    }

    public static /* synthetic */ Observable Q0(Observable observable, Long l11) {
        return observable;
    }

    public static /* synthetic */ Boolean R0(TradeType tradeType, Long l11) {
        return Boolean.valueOf(h2.t1().G1(tradeType, AccountType.supermargin.toString()) != 0);
    }

    public static /* synthetic */ Observable T0(Observable observable, Long l11) {
        return observable;
    }

    public static /* synthetic */ TradeOrderOutstanding V0(TradeOrderOutstanding tradeOrderOutstanding) {
        return tradeOrderOutstanding;
    }

    public static /* synthetic */ List W0(List list) {
        return list;
    }

    public static /* synthetic */ Boolean X0(TradeType tradeType, Long l11) {
        return Boolean.valueOf(h2.t1().G1(tradeType, AccountType.supermargin.toString()) != 0);
    }

    public static /* synthetic */ Observable Z0(Observable observable, Long l11) {
        return observable;
    }

    public static /* synthetic */ TradeOrderPositions a1(TradeOrderPositions tradeOrderPositions) {
        return tradeOrderPositions;
    }

    public static /* synthetic */ List b1(List list) {
        return list;
    }

    public static s0 d0() {
        return c.f85072a;
    }

    public static /* synthetic */ Boolean m0(TradeType tradeType, Long l11) {
        return Boolean.valueOf(h2.t1().G1(tradeType, AccountType.supermargin.toString()) != 0);
    }

    public static /* synthetic */ Observable o0(Observable observable, Long l11) {
        return observable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable p0(int i11, String str, Long l11) {
        return X(i11, l11.longValue(), str, "", 0, 50);
    }

    public static /* synthetic */ Boolean q0(TradeType tradeType, Long l11) {
        return Boolean.valueOf(h2.t1().G1(tradeType, AccountType.spot.toString()) != 0);
    }

    public static /* synthetic */ Long r0(Long l11) {
        return l11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable s0(String str, d dVar, Long l11) {
        return f0(l11.longValue(), str, dVar);
    }

    public static /* synthetic */ Boolean t0(String str, Long l11) {
        return Boolean.valueOf(h2.t1().C1(AccountType.margin.toString(), str) != 0);
    }

    public static /* synthetic */ Long u0(Long l11) {
        return l11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable v0(String str, d dVar, Long l11) {
        return f0(l11.longValue(), str, dVar);
    }

    public static /* synthetic */ Boolean w0(String str, Long l11) {
        return Boolean.valueOf(h2.t1().C1(AccountType.borrow.toString(), str) != 0);
    }

    public static /* synthetic */ Long x0(Long l11) {
        return l11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable y0(String str, d dVar, Long l11) {
        return f0(l11.longValue(), str, dVar);
    }

    public static /* synthetic */ Boolean z0(TradeType tradeType, Long l11) {
        return Boolean.valueOf(h2.t1().G1(tradeType, AccountType.supermargin.toString()) != 0);
    }

    public Observable<AlgoOrderCancelResult> R(int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientOrderIds", new String[]{str});
        if (i11 == 1) {
            k.o("plan_order", "cancelPlanOrTimeOrder - " + hashMap);
        } else {
            k.o("timeweight_order", "cancelPlanOrTimeOrder - " + hashMap);
        }
        return x8.a.a().cancelAlgoOrder(hashMap).b();
    }

    public void S() {
        this.f85068a.clear();
    }

    public Observable<AlgoSpecificOrderInfo> T(Map<String, Object> map) {
        k.o("plan_order", "getAlgoOrderSpecific - " + map);
        return x8.a.a().algoOrderSpecific(map).b();
    }

    public Observable<List<TradeOrderAssets>> U(TradeType tradeType) {
        String str;
        MapParamsBuilder c11 = MapParamsBuilder.c();
        if (TradeType.PRO == tradeType) {
            str = AccountType.spot.toString();
        } else if (TradeType.MARGIN == tradeType) {
            str = AccountType.margin.toString();
        } else if (TradeType.C2C == tradeType) {
            str = AccountType.borrow.toString();
        } else {
            str = AccountType.supermargin.toString();
        }
        return h2.t1().b1(tradeType, str).filter(new m0(tradeType)).map(new r0(c11, tradeType)).flatMap(new l(((OrderService) p.W(OrderService.class)).getAssets(c11.b()).compose(p.a0())));
    }

    public Observable<List<s9.a>> V(int i11, String str, TradeType tradeType) {
        String str2;
        Observable<Long> observable;
        if (TradeType.PRO == tradeType) {
            str2 = AccountType.spot.toString();
        } else if (TradeType.MARGIN == tradeType) {
            str2 = AccountType.margin.toString();
        } else if (TradeType.C2C == tradeType) {
            str2 = AccountType.borrow.toString();
        } else {
            str2 = AccountType.supermargin.toString();
        }
        if (TradeType.C2C == tradeType || TradeType.MARGIN == tradeType) {
            observable = h2.t1().D1(str2, str);
        } else {
            observable = h2.t1().b1(tradeType, str2);
        }
        return observable.flatMap(new q(this, i11, str)).flatMap(new b()).map(new a(i11)).toList();
    }

    public Observable<List<s9.a>> W(String str, TradeType tradeType) {
        return V(1, str, tradeType);
    }

    public Observable<List<AlgoOrderInfo>> X(int i11, long j11, String str, String str2, long j12, int i12) {
        HashMap hashMap = new HashMap();
        if (i11 == 1) {
            hashMap.put("algoTypes", "1");
        } else {
            hashMap.put("algoTypes", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC);
        }
        hashMap.put("delegateType", Integer.valueOf(i11));
        if (j11 != 0) {
            hashMap.put("accountId", Long.valueOf(j11));
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("orderSide", str2);
        }
        if (i12 == 0) {
            i12 = 20;
        }
        hashMap.put("size", Integer.valueOf(i12));
        if (j12 != 0) {
            hashMap.put("from", Long.valueOf(j12));
        }
        if (i11 == 1) {
            k.o("plan_order", "getCurrentPlanOrderList - " + hashMap);
        } else {
            k.o("timeweight_order", "getCurrentPlanOrderList - " + hashMap);
        }
        return x8.a.a().algoOrderOpeningQuery(hashMap).b();
    }

    public Observable<List<AlgoOrderInfo>> Y(long j11, String str, String str2, long j12) {
        return X(1, j11, str, str2, j12, 20);
    }

    public Observable<List<OrderBeanDetails>> Z(OrderParams orderParams) {
        Long b11 = DateTimeUtils.b(orderParams.b());
        if (b11 != null) {
            b11 = Long.valueOf(b11.longValue() + Period.DAY_MILLS);
        }
        return ((OrderService) p.W(OrderService.class)).matchResultsList(orderParams.g(), orderParams.e(), orderParams.h(), orderParams.c(), DateTimeUtils.b(orderParams.f()), b11).compose(p.a0());
    }

    public Observable<List<AlgoOrderInfo>> a0(Map<String, Object> map) {
        k.o("plan_order", "getHistoryPlanOrderList - " + map);
        return x8.a.a().algoOrderHistoryQuery(map).b();
    }

    public Observable<List<AlgoOrderInfo>> b0(Map<String, Object> map) {
        k.o("timeweight_order", "getHistoryTimeOrderList - " + map);
        return x8.a.a().algoOrderHistoryQuery(map).b();
    }

    public final Observable<List<? extends s9.a>> c0(boolean z11, String str, d dVar, int i11, TradeType tradeType) {
        return h0(z11, str, dVar, i11, tradeType);
    }

    public final Observable<List<? extends s9.a>> e0(boolean z11, String str, d dVar, TradeType tradeType) {
        String str2;
        TradeType tradeType2 = TradeType.PRO;
        if (tradeType2 == tradeType) {
            str2 = AccountType.spot.toString();
        } else if (TradeType.MARGIN == tradeType) {
            str2 = AccountType.margin.toString();
        } else if (TradeType.C2C == tradeType) {
            str2 = AccountType.borrow.toString();
        } else {
            str2 = AccountType.supermargin.toString();
        }
        if (!z11) {
            return f0(0, str, dVar);
        }
        if (tradeType2 == tradeType) {
            return h2.t1().b1(tradeType, str2).filter(new m(tradeType)).map(a0.f61907b).flatMap(new r(this, str, dVar));
        }
        if (TradeType.MARGIN == tradeType) {
            return h2.t1().D1(str2, str).filter(new i(str)).map(c0.f61912b).flatMap(new u(this, str, dVar));
        }
        if (TradeType.C2C == tradeType) {
            return h2.t1().D1(str2, str).filter(new f(str)).map(b0.f61909b).flatMap(new t(this, str, dVar));
        }
        return h2.t1().b1(tradeType, str2).filter(new n0(tradeType)).map(z.f61965b).flatMap(new s(this, str, dVar));
    }

    public final Observable<List<? extends s9.a>> f0(long j11, String str, d dVar) {
        return x8.a.a().x(j11, str, dVar.f85073h, (String) null, dVar.f85076c, "next", dVar.f85074a, dVar.f85077d).b().flatMap(g0.f61922b).map(v.f61961b).toList().map(l0.f61932b);
    }

    public Observable<List<? extends s9.a>> g0(boolean z11, TradeType tradeType, int i11, String str, e eVar) {
        if (i11 == 2) {
            if (TextUtils.isEmpty(eVar.f85077d)) {
                eVar.f85077d = "partial-canceled,filled,canceled";
            }
            if (eVar instanceof d) {
                if (TextUtils.isEmpty(eVar.f85078e)) {
                    eVar.f85078e = "2017-6-1";
                }
                return c0(z11, str, (d) eVar, i11, tradeType);
            }
            d dVar = new d(eVar.f85074a, eVar.f85075b, eVar.f85076c, eVar.f85077d, !TextUtils.isEmpty(eVar.f85080g) ? eVar.f85080g : "");
            if (TextUtils.isEmpty(eVar.f85078e)) {
                dVar.f85078e = "2017-6-1";
            } else {
                dVar.f85078e = eVar.f85078e;
            }
            dVar.f85079f = eVar.f85079f;
            return c0(z11, str, dVar, i11, tradeType);
        } else if (eVar instanceof d) {
            return e0(z11, str, (d) eVar, tradeType);
        } else {
            return e0(z11, str, new d(eVar.f85074a, eVar.f85075b, eVar.f85076c, eVar.f85077d, ""), tradeType);
        }
    }

    public final Observable<List<? extends s9.a>> h0(boolean z11, String str, d dVar, int i11, TradeType tradeType) {
        String str2;
        MapParamsBuilder a11 = MapParamsBuilder.c().a(DevicePublicKeyStringDef.DIRECT, "next").a("size", Integer.valueOf(dVar.f85074a));
        if (!TextUtils.isEmpty(str)) {
            a11.a("symbols", str);
        }
        String str3 = dVar.f85077d;
        if (str3 != null) {
            a11.a("states", str3);
        }
        if (!TextUtils.isEmpty(dVar.f85073h)) {
            a11.a("types", dVar.f85073h);
        }
        Long b11 = DateTimeUtils.b(dVar.f85078e);
        if (b11 != null) {
            a11.a("start-time", b11);
        }
        Long b12 = DateTimeUtils.b(dVar.f85079f);
        if (b12 != null) {
            a11.a("end-time", Long.valueOf(b12.longValue() + Period.DAY_MILLS));
        }
        long j11 = dVar.f85076c;
        if (j11 >= 0) {
            a11.a("from", Long.valueOf(j11));
        }
        TradeType tradeType2 = TradeType.PRO;
        if (tradeType2 == tradeType) {
            str2 = AccountType.spot.toString();
        } else if (TradeType.MARGIN == tradeType) {
            str2 = AccountType.margin.toString();
        } else if (TradeType.C2C == tradeType) {
            str2 = AccountType.borrow.toString();
        } else {
            str2 = AccountType.supermargin.toString();
        }
        Observable<R> map = ((OrderService) p.X(tradeType2, OrderService.class)).getOrders(a11.b()).compose(p.a0()).flatMap(f0.f61920b).map(new b(i11)).toList().map(j0.f61928b);
        if (!z11) {
            return map;
        }
        if (tradeType2 == tradeType) {
            return h2.t1().b1(tradeType, str2).filter(new i0(tradeType)).map(new q0(a11, tradeType)).flatMap(new p(map));
        }
        if (TradeType.MARGIN == tradeType) {
            return h2.t1().D1(str2, str).filter(new h(str)).map(new d(a11, str)).flatMap(new n(map));
        }
        if (TradeType.C2C == tradeType) {
            return h2.t1().D1(str2, str).filter(new g(str)).map(new e(a11, str)).flatMap(new k(map));
        }
        return h2.t1().b1(tradeType, str2).filter(new x(tradeType)).map(new p0(a11, tradeType)).flatMap(new o(map));
    }

    public Observable<List<? extends s9.a>> i0(TradeType tradeType) {
        String str;
        MapParamsBuilder c11 = MapParamsBuilder.c();
        if (TradeType.PRO == tradeType) {
            str = AccountType.spot.toString();
        } else if (TradeType.MARGIN == tradeType) {
            str = AccountType.margin.toString();
        } else if (TradeType.C2C == tradeType) {
            str = AccountType.borrow.toString();
        } else {
            str = AccountType.supermargin.toString();
        }
        return h2.t1().b1(tradeType, str).filter(new o0(tradeType)).map(new c(c11, tradeType)).flatMap(new j(((OrderService) p.W(OrderService.class)).getOutstanding(c11.b()).compose(p.a0()).flatMap(e0.f61918b).map(w.f61962b).toList().map(h0.f61924b)));
    }

    public Observable<List<? extends s9.a>> j0(TradeType tradeType) {
        return ((OrderService) p.W(OrderService.class)).getPositions(MapParamsBuilder.c().b()).compose(p.a0()).flatMap(k0.f61930b).map(y.f61964b).toList().map(d0.f61915b);
    }

    public Observable<AlgoSpecificOrderInfo> k0(Map<String, Object> map) {
        k.o("timeweight_order", "getTimeAlgoOrderSpecific - " + map);
        return x8.a.a().algoOrderSpecific(map).b();
    }

    public Observable<List<AlgoOrderMatchResult>> l0(OrderParams orderParams) {
        MapParamsBuilder c11 = MapParamsBuilder.c();
        c11.a("symbol", orderParams.g());
        c11.a("size", Integer.valueOf(orderParams.e()));
        if (!TextUtils.isEmpty(orderParams.h())) {
            c11.a("orderSide", orderParams.h());
        }
        c11.a("from", orderParams.c());
        c11.a("start-date", orderParams.f());
        c11.a("end-date", orderParams.b());
        return ((OrderService) p.W(OrderService.class)).matchTimeResultsList(c11.b()).compose(ProRetrofit.h());
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f85074a;

        /* renamed from: b  reason: collision with root package name */
        public int f85075b;

        /* renamed from: c  reason: collision with root package name */
        public long f85076c;

        /* renamed from: d  reason: collision with root package name */
        public String f85077d;

        /* renamed from: e  reason: collision with root package name */
        public String f85078e;

        /* renamed from: f  reason: collision with root package name */
        public String f85079f;

        /* renamed from: g  reason: collision with root package name */
        public String f85080g;

        public e(int i11, int i12, long j11, String str, String str2) {
            this(i11, i12, j11, str);
            this.f85080g = str2;
        }

        public void a(String str) {
            this.f85079f = str;
        }

        public void b(String str) {
            this.f85078e = str;
        }

        public String toString() {
            return this.f85074a + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f85075b + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f85076c + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f85077d;
        }

        public e(int i11, int i12, long j11, String str) {
            this(i11, i12, j11);
            this.f85077d = str;
        }

        public e(int i11, int i12, long j11) {
            this.f85074a = i11;
            this.f85075b = i12;
            this.f85076c = j11;
        }
    }

    public s0() {
        this.f85068a = new HashMap();
    }
}
