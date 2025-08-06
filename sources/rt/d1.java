package rt;

import ad.i;
import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.order.bean.ExchangeOpenOrderItem;
import com.huobi.order.bean.OrderBean;
import com.huobi.trade.bean.OrderEmptyItem;
import com.huobi.trade.bean.TradeHoldBean;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.trade.prime.bean.PrimeOrderBean;
import com.huobi.utils.k0;
import d7.a1;
import i6.k;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import qt.x;
import qt.y;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import tg.r;
import ut.o;
import vo.a;
import yo.s0;

public class d1 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f84758a;

    /* renamed from: b  reason: collision with root package name */
    public Set<Long> f84759b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public f f84760c;

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f84761d;

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f84762e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f84763f;

    /* renamed from: g  reason: collision with root package name */
    public List<s9.a> f84764g;

    /* renamed from: h  reason: collision with root package name */
    public List<s9.a> f84765h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Long, s9.a> f84766i;

    /* renamed from: j  reason: collision with root package name */
    public v9.a<s9.a> f84767j;

    /* renamed from: k  reason: collision with root package name */
    public final Set<g> f84768k = new HashSet();

    /* renamed from: l  reason: collision with root package name */
    public Subscription f84769l;

    /* renamed from: m  reason: collision with root package name */
    public Subscription f84770m;

    /* renamed from: n  reason: collision with root package name */
    public int f84771n = 0;

    /* renamed from: o  reason: collision with root package name */
    public Subscription f84772o;

    /* renamed from: p  reason: collision with root package name */
    public Map<String, List<s9.a>> f84773p = new HashMap(1);

    /* renamed from: q  reason: collision with root package name */
    public Map<String, List<s9.a>> f84774q = new HashMap(1);

    /* renamed from: r  reason: collision with root package name */
    public Map<String, List<s9.a>> f84775r = new HashMap(1);

    /* renamed from: s  reason: collision with root package name */
    public Map<String, List<s9.a>> f84776s = new HashMap(1);

    /* renamed from: t  reason: collision with root package name */
    public Map<String, List<s9.a>> f84777t = new HashMap(1);

    /* renamed from: u  reason: collision with root package name */
    public boolean f84778u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f84779v;

    /* renamed from: w  reason: collision with root package name */
    public OrderBean.a f84780w = new a();

    /* renamed from: x  reason: collision with root package name */
    public ExchangeOpenOrderItem.a f84781x = new b();

    /* renamed from: y  reason: collision with root package name */
    public a.C0887a f84782y = new c();

    public class a implements OrderBean.a {
        public a() {
        }

        public void a(OrderBean orderBean, Context context) {
            if (orderBean.isTrade() && orderBean.getTradeType() == TradeType.PRO) {
                HashMap hashMap = new HashMap();
                hashMap.put("symbol", orderBean.getSymbol());
                is.a.j("5984", hashMap, "1000048");
            }
            k0.S(context, orderBean.getSymbol(), orderBean.isBuy(), orderBean.getTradeType());
        }
    }

    public class b implements ExchangeOpenOrderItem.a {
        public b() {
        }

        public void a(ExchangeOpenOrderItem exchangeOpenOrderItem, Context context) {
            if (exchangeOpenOrderItem.i() && exchangeOpenOrderItem.e() == TradeType.PRO) {
                HashMap hashMap = new HashMap();
                hashMap.put("symbol", exchangeOpenOrderItem.d().getSymbol());
                is.a.j("5984", hashMap, "1000048");
            }
            k0.S(context, exchangeOpenOrderItem.d().getSymbol(), exchangeOpenOrderItem.f(), exchangeOpenOrderItem.e());
        }
    }

    public class c implements a.C0887a {
        public c() {
        }

        public void a(vo.a aVar, Context context) {
            if (aVar.h() && aVar.g() == TradeType.PRO) {
                HashMap hashMap = new HashMap();
                hashMap.put("symbol", aVar.f());
                is.a.j("5985", hashMap, "1000048");
            }
            k0.S(context, aVar.f(), "buy".equals(aVar.e().getOrderSide()), aVar.g());
        }
    }

    public class d extends EasySubscriber<List<? extends s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TradeType f84787c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f84788d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f84789e;

        public d(String str, TradeType tradeType, int i11, int i12) {
            this.f84786b = str;
            this.f84787c = tradeType;
            this.f84788d = i11;
            this.f84789e = i12;
        }

        public void onError2(Throwable th2) {
            d1.this.t0(this.f84786b, this.f84788d, this.f84789e);
            printLog(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"510".equalsIgnoreCase(aPIStatusErrorException.getErrCode())) {
                d1.this.t0(this.f84786b, this.f84788d, this.f84789e);
                k.c(aPIStatusErrorException.getErrCode() + "===" + aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(List<? extends s9.a> list) {
            d1.this.w0(this.f84786b, list, this.f84787c);
        }
    }

    public class e extends EasySubscriber<List<? extends s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84791b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TradeType f84792c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f84793d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f84794e;

        public e(String str, TradeType tradeType, int i11, int i12) {
            this.f84791b = str;
            this.f84792c = tradeType;
            this.f84793d = i11;
            this.f84794e = i12;
        }

        public void onError2(Throwable th2) {
            d1.this.t0(this.f84791b, this.f84793d, this.f84794e);
            printLog(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            d1.this.t0(this.f84791b, this.f84793d, this.f84794e);
            k.c(aPIStatusErrorException.getErrCode() + "===" + aPIStatusErrorException.getErrMsg());
        }

        public void onNext(List<? extends s9.a> list) {
            d1.this.u0(this.f84791b, list, this.f84792c);
        }
    }

    public interface f {
        u6.g d();

        int e();

        int g();

        String o0();

        boolean r();
    }

    public interface g {
        void a();
    }

    public d1(f fVar, boolean z11, boolean z12) {
        this.f84758a = z11;
        this.f84760c = fVar;
        this.f84779v = z12;
        this.f84759b.add(1L);
        this.f84759b.add(3L);
        this.f84759b.add(6L);
        this.f84759b.add(11L);
        this.f84759b.add(19L);
        this.f84765h = new ArrayList();
        this.f84761d = new ArrayList();
        this.f84762e = new ArrayList();
        this.f84763f = new ArrayList();
        this.f84764g = new ArrayList();
        this.f84766i = new HashMap();
        this.f84767j = new v9.a<>(this.f84761d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s9.a Q(TradeType tradeType, s9.a aVar) {
        if (aVar instanceof OrderBean) {
            OrderBean orderBean = (OrderBean) aVar;
            orderBean.setTradeType(tradeType);
            orderBean.setTrade(true);
            orderBean.setCallAuctionTwo(a1.v().o0(orderBean.getSymbol(), tradeType));
            orderBean.setCallback(this.f84780w);
            this.f84766i.put(Long.valueOf(orderBean.getId()), orderBean);
        } else if (aVar instanceof ExchangeOpenOrderItem) {
            ExchangeOpenOrderItem exchangeOpenOrderItem = (ExchangeOpenOrderItem) aVar;
            exchangeOpenOrderItem.k(this.f84781x);
            exchangeOpenOrderItem.n(tradeType);
            exchangeOpenOrderItem.m(true);
            exchangeOpenOrderItem.j(a1.v().o0(exchangeOpenOrderItem.d().getSymbol(), tradeType));
            this.f84766i.put(Long.valueOf(exchangeOpenOrderItem.d().getId()), exchangeOpenOrderItem);
        }
        return aVar;
    }

    public static /* synthetic */ List R(List list) {
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s9.a S(TradeType tradeType, s9.a aVar) {
        if (aVar instanceof vo.a) {
            vo.a aVar2 = (vo.a) aVar;
            aVar2.j(true);
            aVar2.k(tradeType);
            aVar2.i(this.f84782y);
        }
        return aVar;
    }

    public static /* synthetic */ TradeOrderHistory U(s9.a aVar) {
        return (TradeOrderHistory) aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable V(Observable observable, Throwable th2) {
        int i11 = this.f84771n + 1;
        this.f84771n = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(15, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable W(Observable observable) {
        return observable.flatMap(new q0(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(TradeType tradeType, String str, s0.e eVar, String str2, int i11, int i12, Long l11) {
        s0.d0().g0(true, tradeType, 2, str, eVar).flatMap(t0.f25877b).map(s0.f25875b).toList().retryWhen(new k0(this)).compose(RxJavaHelper.t(N())).subscribe(O(str2, tradeType, i11, i12));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PrimeOrderBean Y(PrimeOrderBean primeOrderBean) {
        this.f84766i.put(Long.valueOf(primeOrderBean.getId()), primeOrderBean);
        return primeOrderBean;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(String str, int i11, int i12, TradeType tradeType, Long l11) {
        o.C().I().concatMap(i.f3526b).map(new c1(this)).toList().compose(RxJavaHelper.t(N())).subscribe(K(str, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(TradeType tradeType, boolean z11, String str, String str2, int i11, int i12, Long l11) {
        I(tradeType, z11, str, "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok").retryWhen(new l0(this)).compose(RxJavaHelper.t(N())).subscribe(K(str2, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable b0(Throwable th2) {
        int i11 = this.f84771n + 1;
        this.f84771n = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return Observable.error(th2);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable c0(Observable observable) {
        return observable.flatMap(new d0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(String str, TradeType tradeType, String str2, int i11, int i12, Long l11) {
        J(str, tradeType).retryWhen(new i0(this)).compose(RxJavaHelper.t(N())).subscribe(K(str2, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable e0(Observable observable, Throwable th2) {
        int i11 = this.f84771n + 1;
        this.f84771n = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(15, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable f0(Observable observable) {
        return observable.flatMap(new p0(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(TradeType tradeType, boolean z11, String str, String str2, int i11, int i12, Long l11) {
        I(tradeType, z11, str, "buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok").retryWhen(new j0(this)).compose(RxJavaHelper.t(N())).subscribe(K(str2, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable h0(Observable observable, Throwable th2) {
        int i11 = this.f84771n + 1;
        this.f84771n = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(15, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable i0(Observable observable) {
        return observable.flatMap(new r0(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List j0(List list) {
        H(list);
        F(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(String str, int i11, int i12, TradeType tradeType, Long l11) {
        if (this.f84759b.contains(l11)) {
            o.C().I().concatMap(i.f3526b).toList().map(new g0(this)).compose(RxJavaHelper.t(N())).subscribe(K(str, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            D0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List l0(List list) {
        G(list);
        E(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(String str, TradeType tradeType, String str2, int i11, int i12, Long l11) {
        if (this.f84759b.contains(l11)) {
            J(str, tradeType).map(new h0(this)).compose(RxJavaHelper.t(N())).subscribe(K(str2, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            D0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List n0(List list) {
        G(list);
        E(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(TradeType tradeType, boolean z11, String str, String str2, int i11, int i12, Long l11) {
        if (this.f84759b.contains(l11)) {
            I(tradeType, z11, str, "buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok").map(new f0(this)).compose(RxJavaHelper.t(N())).subscribe(K(str2, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            D0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List p0(List list) {
        G(list);
        E(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(TradeType tradeType, boolean z11, String str, String str2, int i11, int i12, Long l11) {
        if (this.f84759b.contains(l11)) {
            I(tradeType, z11, str, "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok").map(new e0(this)).compose(RxJavaHelper.t(N())).subscribe(K(str2, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            D0();
        }
    }

    public void A0(boolean z11, TradeType tradeType, String str, int i11, int i12) {
        String str2;
        D0();
        if (!r.x().F0()) {
            x0(str, i11, i12);
            return;
        }
        if ((tradeType == TradeType.PRO || tradeType == TradeType.MARGIN || tradeType == TradeType.SUPERMARGIN) && (!this.f84758a ? !this.f84779v ? !y.a() : !y.b() : !x.a())) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (!a1.v().S(str) || !o.C().T()) {
            i6.d.e("PLAN_TRADE", "startPlaceOrderListInterval - orderListTradeType - " + i12);
            if (i12 == 2) {
                this.f84772o = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new a1(this, str2, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
            } else if (i12 == 1) {
                this.f84772o = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new x0(this, tradeType, z11, str2, str, i11, i12)).subscribe(new BaseSubscriber());
            } else {
                this.f84772o = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new v0(this, tradeType, z11, str2, str, i11, i12)).subscribe(new BaseSubscriber());
            }
        } else {
            i6.d.b("updateOrderList-->request prime orders");
            if (i12 == 2) {
                x0(str, i11, i12);
            } else {
                this.f84772o = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new z0(this, str, i11, i12, tradeType)).subscribe(new BaseSubscriber());
            }
        }
    }

    public void B0() {
        Subscription subscription = this.f84770m;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void C0() {
        this.f84766i.clear();
        Subscription subscription = this.f84769l;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void D0() {
        Subscription subscription = this.f84772o;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void E(List<? extends s9.a> list) {
        this.f84766i.clear();
        for (s9.a aVar : list) {
            if (aVar instanceof OrderBean) {
                this.f84766i.put(Long.valueOf(((OrderBean) aVar).getId()), aVar);
            } else if (aVar instanceof vo.a) {
                vo.a aVar2 = (vo.a) aVar;
                this.f84766i.put(aVar2.d(), aVar2);
            } else if (aVar instanceof ExchangeOpenOrderItem) {
                this.f84766i.put(Long.valueOf(((ExchangeOpenOrderItem) aVar).d().getId()), aVar);
            }
        }
    }

    public final void F(List<PrimeOrderBean> list) {
        this.f84766i.clear();
        for (PrimeOrderBean next : list) {
            this.f84766i.put(Long.valueOf(next.getId()), next);
        }
    }

    public final void G(List<? extends s9.a> list) {
        boolean z11 = true;
        if (list.size() == this.f84766i.size()) {
            Iterator<? extends s9.a> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z11 = false;
                    break;
                }
                s9.a aVar = (s9.a) it2.next();
                if (!(aVar instanceof OrderBean)) {
                    if (!(aVar instanceof vo.a)) {
                        if ((aVar instanceof ExchangeOpenOrderItem) && !this.f84766i.containsKey(Long.valueOf(((ExchangeOpenOrderItem) aVar).d().getId()))) {
                            break;
                        }
                    } else if (!this.f84766i.containsKey(((vo.a) aVar).d())) {
                        break;
                    }
                } else if (!this.f84766i.containsKey(Long.valueOf(((OrderBean) aVar).getId()))) {
                    break;
                }
            }
        }
        if (z11) {
            D0();
        }
    }

    public final void H(List<PrimeOrderBean> list) {
        boolean z11 = true;
        if (list.size() == this.f84766i.size()) {
            boolean z12 = false;
            for (PrimeOrderBean id2 : list) {
                if (!this.f84766i.containsKey(Long.valueOf(id2.getId()))) {
                    z12 = true;
                }
            }
            z11 = z12;
        }
        if (z11) {
            D0();
        }
    }

    public final Observable<List<? extends s9.a>> I(TradeType tradeType, boolean z11, String str, String str2) {
        return s0.d0().g0(z11, tradeType, tradeType == TradeType.PRO ? 5 : 0, str, new s0.d(50, 1, -1, "", str2)).concatMap(i.f3526b).map(new m0(this, tradeType)).toList().map(u0.f25879b);
    }

    public final Observable<List<s9.a>> J(String str, TradeType tradeType) {
        return s0.d0().W(str, tradeType).concatMap(i.f3526b).map(new o0(this, tradeType)).toList();
    }

    public final Observer<List<? extends s9.a>> K(String str, int i11, int i12, TradeType tradeType) {
        return new d(str, tradeType, i11, i12);
    }

    public List<s9.a> L() {
        return this.f84761d;
    }

    public v9.a<s9.a> M() {
        return this.f84767j;
    }

    public final u6.g N() {
        return this.f84760c.d();
    }

    public final Observer<List<? extends s9.a>> O(String str, TradeType tradeType, int i11, int i12) {
        return new e(str, tradeType, i11, i12);
    }

    public boolean P() {
        return this.f84778u;
    }

    public void r0() {
        v9.a<s9.a> aVar = this.f84767j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void s0(g gVar) {
        synchronized (this.f84768k) {
            this.f84768k.add(gVar);
        }
    }

    public final void t0(String str, int i11, int i12) {
        x0(str, i11, i12);
    }

    public final void u0(String str, List<? extends s9.a> list, TradeType tradeType) {
        List<s9.a> list2;
        int g11 = this.f84760c.g();
        this.f84760c.e();
        if (g11 == 2) {
            this.f84764g.clear();
            if (list.isEmpty()) {
                this.f84764g.add(new OrderEmptyItem(str));
                this.f84778u = true;
            } else {
                this.f84764g.addAll(list);
                this.f84778u = false;
                if (list.size() >= 50) {
                    this.f84764g.add(new ws.f(str, 0, g11, tradeType));
                }
            }
            this.f84767j.i(this.f84764g);
            String J = r.x().J();
            if (!TextUtils.isEmpty(J) && (list2 = this.f84764g) != null && !list2.isEmpty()) {
                this.f84777t.clear();
                ArrayList arrayList = new ArrayList(this.f84764g.size());
                arrayList.addAll(this.f84764g);
                this.f84777t.put(J, arrayList);
            }
            this.f84767j.notifyDataSetChanged();
        }
    }

    public void v0(String str, List<? extends s9.a> list, TradeType tradeType) {
        List<s9.a> list2;
        int g11 = this.f84760c.g();
        boolean r11 = this.f84760c.r();
        String o02 = this.f84760c.o0();
        if (g11 == 0) {
            this.f84764g.clear();
            if (list.isEmpty()) {
                if (r.x().F0()) {
                    this.f84764g.add(new j(str, r11));
                } else {
                    this.f84764g.add(new OrderEmptyItem(str));
                }
                this.f84778u = true;
            } else {
                if (this.f84779v) {
                    if (y.b()) {
                        for (s9.a aVar : list) {
                            if (aVar instanceof TradeHoldBean) {
                                TradeHoldBean tradeHoldBean = (TradeHoldBean) aVar;
                                if (!TextUtils.isEmpty(tradeHoldBean.getCurrency())) {
                                    if (str.equals(o02)) {
                                        this.f84764g.add(aVar);
                                    }
                                } else if (tradeHoldBean.getCurrencyInfo() != null && str.equals(o02)) {
                                    this.f84764g.add(aVar);
                                }
                            }
                        }
                    } else {
                        this.f84764g.addAll(list);
                    }
                } else if (y.a()) {
                    for (s9.a aVar2 : list) {
                        if (aVar2 instanceof TradeHoldBean) {
                            TradeHoldBean tradeHoldBean2 = (TradeHoldBean) aVar2;
                            if (!TextUtils.isEmpty(tradeHoldBean2.getCurrency())) {
                                if (str.equals(o02)) {
                                    this.f84764g.add(aVar2);
                                }
                            } else if (tradeHoldBean2.getCurrencyInfo() != null && str.equals(o02)) {
                                this.f84764g.add(aVar2);
                            }
                        }
                    }
                } else {
                    this.f84764g.addAll(list);
                }
                this.f84778u = false;
            }
            this.f84767j.i(this.f84764g);
            String J = r.x().J();
            if (!TextUtils.isEmpty(J) && (list2 = this.f84764g) != null && !list2.isEmpty()) {
                this.f84773p.clear();
                ArrayList arrayList = new ArrayList(this.f84764g.size());
                arrayList.addAll(this.f84764g);
                this.f84773p.put(J, arrayList);
            }
            this.f84767j.notifyDataSetChanged();
        }
    }

    public final void w0(String str, List<? extends s9.a> list, TradeType tradeType) {
        List<s9.a> list2;
        List<s9.a> list3;
        List<s9.a> list4;
        int g11 = this.f84760c.g();
        int e11 = this.f84760c.e();
        if (e11 == 2) {
            this.f84763f.clear();
            if (list.isEmpty()) {
                this.f84763f.add(new OrderEmptyItem(str));
                this.f84778u = true;
            } else {
                this.f84763f.addAll(list);
                this.f84778u = false;
                if (list.size() >= 50) {
                    this.f84763f.add(new ws.f(str, e11, g11, tradeType));
                }
            }
        } else if (e11 == 1) {
            this.f84762e.clear();
            if (list.isEmpty()) {
                this.f84762e.add(new OrderEmptyItem(str));
                this.f84778u = true;
            } else {
                this.f84762e.addAll(list);
                this.f84778u = false;
                if (list.size() >= 50) {
                    this.f84762e.add(new ws.f(str, e11, g11, tradeType));
                }
            }
        } else if (e11 == 0) {
            this.f84761d.clear();
            if (list.isEmpty()) {
                this.f84761d.add(new OrderEmptyItem(str));
                this.f84778u = true;
            } else {
                this.f84761d.addAll(list);
                this.f84778u = false;
                if (list.size() >= 50) {
                    this.f84761d.add(new ws.f(str, e11, g11, tradeType));
                }
            }
        }
        if (g11 == 1) {
            String J = r.x().J();
            if (e11 == 2) {
                this.f84767j.i(this.f84763f);
                if (!TextUtils.isEmpty(J) && (list4 = this.f84763f) != null && !list4.isEmpty()) {
                    this.f84776s.clear();
                    ArrayList arrayList = new ArrayList(this.f84763f.size());
                    arrayList.addAll(this.f84763f);
                    this.f84776s.put(J, arrayList);
                }
            } else if (e11 == 0) {
                this.f84767j.i(this.f84761d);
                if (!TextUtils.isEmpty(J) && (list3 = this.f84761d) != null && !list3.isEmpty()) {
                    this.f84774q.clear();
                    ArrayList arrayList2 = new ArrayList(this.f84761d.size());
                    arrayList2.addAll(this.f84761d);
                    this.f84774q.put(J, arrayList2);
                }
            } else if (e11 == 1) {
                this.f84767j.i(this.f84762e);
                if (!TextUtils.isEmpty(J) && (list2 = this.f84762e) != null && !list2.isEmpty()) {
                    this.f84775r.clear();
                    ArrayList arrayList3 = new ArrayList(this.f84762e.size());
                    arrayList3.addAll(this.f84762e);
                    this.f84775r.put(J, arrayList3);
                }
            }
            this.f84767j.notifyDataSetChanged();
        }
        synchronized (this.f84768k) {
            for (g a11 : this.f84768k) {
                a11.a();
            }
        }
    }

    public void x0(String str, int i11, int i12) {
        if (i11 == 0) {
            if (this.f84760c.g() == 0) {
                this.f84765h.clear();
                if (r.x().F0()) {
                    List list = this.f84773p.get(r.x().J());
                    if (list == null || list.isEmpty()) {
                        this.f84765h.add(new j(str, this.f84760c.r()));
                    } else {
                        this.f84765h.addAll(list);
                    }
                } else {
                    this.f84765h.add(new OrderEmptyItem(str));
                }
                this.f84767j.i(this.f84765h);
            } else {
                return;
            }
        } else if (i11 == 1) {
            if (this.f84760c.g() == 1) {
                if (i12 == 0) {
                    if (this.f84760c.e() == 0) {
                        this.f84761d.clear();
                        if (r.x().F0()) {
                            List list2 = this.f84774q.get(r.x().J());
                            if (list2 == null || list2.isEmpty()) {
                                this.f84761d.add(new OrderEmptyItem(str));
                            } else {
                                this.f84761d.addAll(list2);
                            }
                        } else {
                            this.f84761d.add(new OrderEmptyItem(str));
                        }
                        this.f84767j.i(this.f84761d);
                        this.f84766i.clear();
                    } else {
                        return;
                    }
                } else if (i12 == 1) {
                    if (this.f84760c.e() == 1) {
                        this.f84762e.clear();
                        if (r.x().F0()) {
                            List list3 = this.f84775r.get(r.x().J());
                            if (list3 == null || list3.isEmpty()) {
                                this.f84762e.add(new OrderEmptyItem(str));
                            } else {
                                this.f84762e.addAll(list3);
                            }
                        } else {
                            this.f84762e.add(new OrderEmptyItem(str));
                        }
                        this.f84767j.i(this.f84762e);
                    } else {
                        return;
                    }
                } else if (i12 == 2) {
                    if (this.f84760c.e() == 2) {
                        this.f84763f.clear();
                        if (r.x().F0()) {
                            List list4 = this.f84776s.get(r.x().J());
                            if (list4 == null || list4.isEmpty()) {
                                this.f84763f.add(new OrderEmptyItem(str));
                            } else {
                                this.f84763f.addAll(list4);
                            }
                        } else {
                            this.f84763f.add(new OrderEmptyItem(str));
                        }
                        this.f84767j.i(this.f84763f);
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        } else if (i11 == 2) {
            if (this.f84760c.g() == 2) {
                this.f84764g.clear();
                if (r.x().F0()) {
                    List list5 = this.f84777t.get(r.x().J());
                    if (list5 == null || list5.isEmpty()) {
                        this.f84764g.add(new OrderEmptyItem(str));
                    } else {
                        this.f84764g.addAll(list5);
                    }
                } else {
                    this.f84764g.add(new OrderEmptyItem(str));
                }
                this.f84767j.i(this.f84764g);
            } else {
                return;
            }
        }
        this.f84778u = true;
        this.f84767j.notifyDataSetChanged();
    }

    public void y0(TradeType tradeType, String str, int i11, int i12) {
        String str2;
        if (!r.x().F0()) {
            x0(str, i11, i12);
            return;
        }
        String str3 = str;
        int i13 = i11;
        int i14 = i12;
        this.f84771n = 0;
        B0();
        if (tradeType != TradeType.PRO || (!this.f84758a ? !(!this.f84779v ? !y.a() : !y.b()) : x.a())) {
            str2 = str3;
        } else {
            str2 = "";
        }
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(5, -119);
        long timeInMillis2 = instance.getTimeInMillis();
        String m11 = DateTimeUtils.m(timeInMillis / 1000);
        String m12 = DateTimeUtils.m(timeInMillis2 / 1000);
        s0.e eVar = new s0.e(50, 0, -1, "partial-canceled,filled", "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok,buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok");
        eVar.b(m12);
        eVar.a(m11);
        this.f84770m = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new c0(this, tradeType, str2, eVar, str, i11, i12)).subscribe(new BaseSubscriber());
    }

    public void z0(boolean z11, TradeType tradeType, String str, int i11, int i12) {
        String str2;
        C0();
        if (!r.x().F0()) {
            x0(str, i11, i12);
            return;
        }
        this.f84771n = 0;
        if ((tradeType == TradeType.PRO || tradeType == TradeType.MARGIN || tradeType == TradeType.SUPERMARGIN) && (!this.f84758a ? !this.f84779v ? !y.a() : !y.b() : !x.a())) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (!a1.v().S(str) || !o.C().T()) {
            i6.d.e("PLAN_TRADE", "startOrderListInterval - orderListTradeType - " + i12);
            if (i12 == 2) {
                this.f84769l = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new b1(this, str2, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
            } else if (i12 == 1) {
                this.f84769l = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new w0(this, tradeType, z11, str2, str, i11, i12)).subscribe(new BaseSubscriber());
            } else {
                this.f84769l = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new n0(this, tradeType, z11, str2, str, i11, i12)).subscribe(new BaseSubscriber());
            }
        } else {
            i6.d.b("updateOrderList-->request prime orders");
            if (i12 == 2) {
                x0(str, i11, i12);
            } else {
                this.f84769l = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new y0(this, str, i11, i12, tradeType)).subscribe(new BaseSubscriber());
            }
        }
    }
}
