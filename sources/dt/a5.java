package dt;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.pro.core.bean.AlgoOrderCancelResult;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.order.bean.CurrentTimeTradeInfo;
import com.huobi.order.bean.ExchangeOpenOrderItem;
import com.huobi.order.bean.OrderBean;
import com.huobi.order.ui.TimeTradeDetailOrderActivity;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.trade.bean.OrderEmptyItem;
import com.huobi.trade.bean.TradeOrderAssets;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.trade.bean.TradeOrderOutstanding;
import com.huobi.trade.bean.TradeOrderPositions;
import com.huobi.trade.prime.bean.PrimeOrderBean;
import com.huobi.trade.ui.s;
import com.huobi.utils.k0;
import d7.a1;
import ht.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import qt.y;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import tg.r;
import vo.a;
import yo.s0;

public class a5 {
    public ExchangeOpenOrderItem.a A;
    public a.C0887a B;
    public CurrentTimeTradeInfo.a C;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f83964a;

    /* renamed from: b  reason: collision with root package name */
    public Set<Long> f83965b;

    /* renamed from: c  reason: collision with root package name */
    public l f83966c;

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f83967d;

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f83968e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f83969f;

    /* renamed from: g  reason: collision with root package name */
    public List<s9.a> f83970g;

    /* renamed from: h  reason: collision with root package name */
    public List<s9.a> f83971h;

    /* renamed from: i  reason: collision with root package name */
    public List<s9.a> f83972i;

    /* renamed from: j  reason: collision with root package name */
    public List<TradeOrderAssets> f83973j;

    /* renamed from: k  reason: collision with root package name */
    public List<s9.a> f83974k;

    /* renamed from: l  reason: collision with root package name */
    public List<s9.a> f83975l;

    /* renamed from: m  reason: collision with root package name */
    public List<s9.a> f83976m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Long, s9.a> f83977n;

    /* renamed from: o  reason: collision with root package name */
    public v9.a<s9.a> f83978o;

    /* renamed from: p  reason: collision with root package name */
    public final Set<m> f83979p;

    /* renamed from: q  reason: collision with root package name */
    public Subscription f83980q;

    /* renamed from: r  reason: collision with root package name */
    public Subscription f83981r;

    /* renamed from: s  reason: collision with root package name */
    public Subscription f83982s;

    /* renamed from: t  reason: collision with root package name */
    public Subscription f83983t;

    /* renamed from: u  reason: collision with root package name */
    public Subscription f83984u;

    /* renamed from: v  reason: collision with root package name */
    public int f83985v;

    /* renamed from: w  reason: collision with root package name */
    public Subscription f83986w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f83987x;

    /* renamed from: y  reason: collision with root package name */
    public Comparator<TradeOrderAssets> f83988y;

    /* renamed from: z  reason: collision with root package name */
    public OrderBean.a f83989z;

    public class a extends BaseSubscriber<List<? extends s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f83990b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TradeType f83991c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f83992d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f83993e;

        public a(String str, TradeType tradeType, int i11, int i12) {
            this.f83990b = str;
            this.f83991c = tradeType;
            this.f83992d = i11;
            this.f83993e = i12;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            a5.this.w1(this.f83990b, this.f83992d, this.f83993e);
            printLog(th2);
            i6.k.c(th2.getMessage());
        }

        public void onNext(List<? extends s9.a> list) {
            a5.this.B1(this.f83990b, list, this.f83991c);
        }
    }

    public class b implements xs.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f83995a;

        public b(s sVar) {
            this.f83995a = sVar;
        }

        public void V2() {
            this.f83995a.V2();
        }

        public void e3() {
            this.f83995a.e3();
        }
    }

    public class c implements OrderBean.a {
        public c() {
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

    public class d implements ExchangeOpenOrderItem.a {
        public d() {
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

    public class e implements a.C0887a {
        public e() {
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

    public class f implements CurrentTimeTradeInfo.a {
        public f() {
        }

        public void a(CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
            Intent intent = new Intent();
            intent.setClass(context, TimeTradeDetailOrderActivity.class);
            intent.putExtra("clientOrderId", currentTimeTradeInfo.getOrderInfo().getClientOrderId());
            context.startActivity(intent);
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
            gs.g.i("app_trade_twap_order_details_click", hashMap);
        }

        public void b(CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
            if (currentTimeTradeInfo.isTrade() && currentTimeTradeInfo.getTradeType() == TradeType.PRO) {
                HashMap hashMap = new HashMap();
                hashMap.put("symbol", currentTimeTradeInfo.getSymbol());
                is.a.j("5985", hashMap, "1000048");
            }
            k0.S(context, currentTimeTradeInfo.getSymbol(), "buy".equals(currentTimeTradeInfo.getOrderInfo().getOrderSide()), currentTimeTradeInfo.getTradeType());
        }

        public void c(CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
            a5.this.h0(context, currentTimeTradeInfo.getOrderInfo());
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
            gs.g.i("app_trade_twap_order_stop_click", hashMap);
        }
    }

    public class g extends q6.d<AlgoOrderCancelResult> {
        public g(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(AlgoOrderCancelResult algoOrderCancelResult) {
            super.onNext(algoOrderCancelResult);
            HuobiToastUtil.t(bh.j.c(), R.string.n_exchange_timing_stop_order_success);
        }

        public void onAfter() {
            super.onAfter();
            EventBus.d().k(new AssetAndOrderUpdateEvent());
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            HuobiToastUtil.k(bh.j.c(), R.string.n_order_cancel_failed_toast);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            String errCode = aPIStatusErrorException.getErrCode();
            if (!errCode.equals("5007") && !errCode.equals("5008") && !errCode.equals("5009")) {
                super.onFailed(aPIStatusErrorException);
            } else if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
            }
        }
    }

    public class h extends EasySubscriber<List<? extends s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84002b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TradeType f84003c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f84004d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f84005e;

        public h(String str, TradeType tradeType, int i11, int i12) {
            this.f84002b = str;
            this.f84003c = tradeType;
            this.f84004d = i11;
            this.f84005e = i12;
        }

        public void onError2(Throwable th2) {
            a5.this.w1(this.f84002b, this.f84004d, this.f84005e);
            printLog(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"510".equalsIgnoreCase(aPIStatusErrorException.getErrCode())) {
                a5.this.w1(this.f84002b, this.f84004d, this.f84005e);
                i6.k.c(aPIStatusErrorException.getErrCode() + "===" + aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(List<? extends s9.a> list) {
            a5.this.z1(this.f84002b, list, this.f84003c);
        }
    }

    public class i extends EasySubscriber<List<? extends s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84007b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TradeType f84008c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f84009d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f84010e;

        public i(String str, TradeType tradeType, int i11, int i12) {
            this.f84007b = str;
            this.f84008c = tradeType;
            this.f84009d = i11;
            this.f84010e = i12;
        }

        public void onError2(Throwable th2) {
            a5.this.w1(this.f84007b, this.f84009d, this.f84010e);
            printLog(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            a5.this.w1(this.f84007b, this.f84009d, this.f84010e);
            i6.k.c(aPIStatusErrorException.getErrCode() + "===" + aPIStatusErrorException.getErrMsg());
        }

        public void onNext(List<? extends s9.a> list) {
            a5.this.x1(this.f84007b, list, this.f84008c);
        }
    }

    public class j extends BaseSubscriber<List<? extends s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84012b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f84013c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f84014d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TradeType f84015e;

        public j(String str, int i11, int i12, TradeType tradeType) {
            this.f84012b = str;
            this.f84013c = i11;
            this.f84014d = i12;
            this.f84015e = tradeType;
        }

        public void onCompleted() {
            super.onCompleted();
            a5 a5Var = a5.this;
            a5Var.u1(this.f84012b, a5Var.f83972i, this.f84015e);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            a5.this.w1(this.f84012b, this.f84013c, this.f84014d);
            printLog(th2);
            i6.k.c(th2.getMessage());
        }

        public void onNext(List<? extends s9.a> list) {
            a5.this.f83972i.clear();
            if (!CollectionsUtils.b(list)) {
                a5.this.f83972i.addAll(list);
            }
        }
    }

    public class k extends BaseSubscriber<List<? extends s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84017b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TradeType f84018c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f84019d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f84020e;

        public k(String str, TradeType tradeType, int i11, int i12) {
            this.f84017b = str;
            this.f84018c = tradeType;
            this.f84019d = i11;
            this.f84020e = i12;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            a5.this.w1(this.f84017b, this.f84019d, this.f84020e);
            printLog(th2);
            i6.k.c(th2.getMessage());
        }

        public void onNext(List<? extends s9.a> list) {
            a5.this.A1(this.f84017b, list, this.f84018c);
        }
    }

    public interface l {
        u6.g d();

        int e();

        int g();
    }

    public interface m {
        void a();
    }

    public a5(l lVar) {
        this(lVar, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable A0(Observable observable) {
        return observable.flatMap(new i4(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0(TradeType tradeType, String str, int i11, int i12, Long l11) {
        s0.d0().U(tradeType).map(new f4(this, str)).retryWhen(new a4(this)).compose(RxJavaHelper.t(q0())).subscribe(g0(str, tradeType, i11, i12));
    }

    public static /* synthetic */ TradeOrderHistory D0(s9.a aVar) {
        return (TradeOrderHistory) aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable E0(Observable observable, Throwable th2) {
        int i11 = this.f83985v + 1;
        this.f83985v = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(15, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable F0(Observable observable) {
        return observable.flatMap(new h4(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(TradeType tradeType, String str, s0.e eVar, String str2, int i11, int i12, Long l11) {
        s0.d0().g0(true, tradeType, 2, str, eVar).flatMap(s4.f54150b).map(p4.f54129b).toList().retryWhen(new c4(this)).compose(RxJavaHelper.t(q0())).subscribe(s0(str2, tradeType, i11, i12));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PrimeOrderBean H0(PrimeOrderBean primeOrderBean) {
        this.f83977n.put(Long.valueOf(primeOrderBean.getId()), primeOrderBean);
        return primeOrderBean;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I0(String str, int i11, int i12, TradeType tradeType, Long l11) {
        o.B().H().concatMap(ad.i.f3526b).map(new l3(this)).toList().compose(RxJavaHelper.t(q0())).subscribe(m0(str, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J0(String str, TradeType tradeType, String str2, int i11, int i12, Long l11) {
        l0(2, str, tradeType).retryWhen(new x3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str2, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable K0(Observable observable, Throwable th2) {
        int i11 = this.f83985v + 1;
        this.f83985v = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(15, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable L0(Observable observable) {
        return observable.flatMap(new j4(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M0(TradeType tradeType, boolean z11, String str, String str2, int i11, int i12, Long l11) {
        k0(tradeType, z11, str, "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok").retryWhen(new u3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str2, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable N0(Throwable th2) {
        int i11 = this.f83985v + 1;
        this.f83985v = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return Observable.error(th2);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable O0(Observable observable) {
        return observable.flatMap(new n3(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P0(String str, TradeType tradeType, String str2, int i11, int i12, Long l11) {
        l0(1, str, tradeType).retryWhen(new v3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str2, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Q0(Observable observable, Throwable th2) {
        int i11 = this.f83985v + 1;
        this.f83985v = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(15, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable R0(Observable observable) {
        return observable.flatMap(new l4(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S0(TradeType tradeType, boolean z11, String str, String str2, int i11, int i12, Long l11) {
        k0(tradeType, z11, str, "buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok").retryWhen(new z3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str2, i11, i12, tradeType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable T0(Throwable th2) {
        int i11 = this.f83985v + 1;
        this.f83985v = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return Observable.error(th2);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable U0(Observable observable) {
        return observable.flatMap(new m3(this));
    }

    public static /* synthetic */ TradeOrderOutstanding W0(s9.a aVar) {
        return (TradeOrderOutstanding) aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable X0(Observable observable, Throwable th2) {
        int i11 = this.f83985v + 1;
        this.f83985v = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(5, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Y0(Observable observable) {
        return observable.flatMap(new k4(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(TradeType tradeType, String str, int i11, int i12, Long l11) {
        s0.d0().i0(tradeType).flatMap(q4.f54139b).map(n4.f54114b).toList().retryWhen(new y3(this)).compose(RxJavaHelper.t(q0())).subscribe(r1(str, tradeType, i11, i12));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List a1(List list) {
        j0(list);
        e0(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b1(String str, int i11, int i12, TradeType tradeType, Long l11) {
        if (this.f83965b.contains(l11)) {
            o.B().H().concatMap(ad.i.f3526b).toList().map(new o3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            N1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List c1(List list) {
        i0(list);
        d0(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d1(String str, TradeType tradeType, String str2, int i11, int i12, Long l11) {
        if (this.f83965b.contains(l11)) {
            l0(1, str, tradeType).map(new p3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str2, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            N1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List e1(List list) {
        i0(list);
        d0(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f1(String str, TradeType tradeType, String str2, int i11, int i12, Long l11) {
        if (this.f83965b.contains(l11)) {
            l0(2, str, tradeType).map(new t3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str2, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            N1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List g1(List list) {
        i0(list);
        d0(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h1(TradeType tradeType, boolean z11, String str, String str2, int i11, int i12, Long l11) {
        if (this.f83965b.contains(l11)) {
            k0(tradeType, z11, str, "buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok").map(new s3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str2, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            N1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List i1(List list) {
        i0(list);
        d0(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j1(TradeType tradeType, boolean z11, String str, String str2, int i11, int i12, Long l11) {
        if (this.f83965b.contains(l11)) {
            k0(tradeType, z11, str, "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok").map(new r3(this)).compose(RxJavaHelper.t(q0())).subscribe(m0(str2, i11, i12, tradeType));
        } else if (l11.longValue() > 19) {
            N1();
        }
    }

    public static /* synthetic */ TradeOrderPositions l1(s9.a aVar) {
        return (TradeOrderPositions) aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable m1(Observable observable, Throwable th2) {
        int i11 = this.f83985v + 1;
        this.f83985v = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(5, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable n1(Observable observable) {
        return observable.flatMap(new g4(this, observable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o1(TradeType tradeType, String str, int i11, int i12, Long l11) {
        s0.d0().j0(tradeType).flatMap(t4.f54157b).map(o4.f54123b).toList().retryWhen(new w3(this)).compose(RxJavaHelper.t(q0())).subscribe(s1(str, tradeType, i11, i12));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s9.a u0(TradeType tradeType, s9.a aVar) {
        if (aVar instanceof OrderBean) {
            OrderBean orderBean = (OrderBean) aVar;
            orderBean.setTradeType(tradeType);
            orderBean.setTrade(true);
            orderBean.setCallAuctionTwo(a1.v().o0(orderBean.getSymbol(), tradeType));
            orderBean.setCallback(this.f83989z);
            this.f83977n.put(Long.valueOf(orderBean.getId()), orderBean);
        } else if (aVar instanceof ExchangeOpenOrderItem) {
            ExchangeOpenOrderItem exchangeOpenOrderItem = (ExchangeOpenOrderItem) aVar;
            exchangeOpenOrderItem.k(this.A);
            exchangeOpenOrderItem.n(tradeType);
            exchangeOpenOrderItem.m(true);
            exchangeOpenOrderItem.j(a1.v().o0(exchangeOpenOrderItem.d().getSymbol(), tradeType));
            this.f83977n.put(Long.valueOf(exchangeOpenOrderItem.d().getId()), exchangeOpenOrderItem);
        }
        return aVar;
    }

    public static /* synthetic */ List v0(List list) {
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s9.a w0(TradeType tradeType, s9.a aVar) {
        if (aVar instanceof vo.a) {
            vo.a aVar2 = (vo.a) aVar;
            aVar2.j(true);
            aVar2.k(tradeType);
            aVar2.i(this.B);
        } else if (aVar instanceof CurrentTimeTradeInfo) {
            CurrentTimeTradeInfo currentTimeTradeInfo = (CurrentTimeTradeInfo) aVar;
            currentTimeTradeInfo.setTrade(true);
            currentTimeTradeInfo.setTradeType(tradeType);
            currentTimeTradeInfo.setCallback(this.C);
        }
        return aVar;
    }

    public static /* synthetic */ int x0(TradeOrderAssets tradeOrderAssets, TradeOrderAssets tradeOrderAssets2) {
        int compareTo = i6.m.a(tradeOrderAssets2.getUsdtPoistionValue()).compareTo(i6.m.a(tradeOrderAssets.getUsdtPoistionValue()));
        if (compareTo != 0) {
            return compareTo;
        }
        Integer num = 0;
        int i11 = 0;
        try {
            d7.k C2 = d7.k.C();
            String currency = tradeOrderAssets2.getCurrency();
            TradeType tradeType = TradeType.PRO;
            num = Integer.valueOf(C2.I(currency, tradeType));
            i11 = Integer.valueOf(d7.k.C().I(tradeOrderAssets.getCurrency(), tradeType));
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
        }
        return num.compareTo(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List y0(String str, List list) {
        this.f83973j.clear();
        if (!CollectionsUtils.b(list)) {
            this.f83973j.addAll(list);
        }
        return r0(str, list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable z0(Observable observable, Throwable th2) {
        int i11 = this.f83985v + 1;
        this.f83985v = i11;
        if (i11 >= 4 || !(th2 instanceof SSLException)) {
            return observable.delay(5, TimeUnit.SECONDS);
        }
        return Observable.just(Observable.empty());
    }

    public final void A1(String str, List<? extends s9.a> list, TradeType tradeType) {
        if (this.f83966c.g() == 4) {
            this.f83974k.clear();
            if (list.isEmpty()) {
                this.f83974k.add(new OrderEmptyItem(str));
                this.f83987x = true;
            } else {
                this.f83974k.addAll(list);
                this.f83987x = false;
            }
            this.f83978o.i(this.f83974k);
            this.f83978o.notifyDataSetChanged();
        }
    }

    public final void B1(String str, List<? extends s9.a> list, TradeType tradeType) {
        if (this.f83966c.g() == 9) {
            this.f83975l.clear();
            if (list.isEmpty()) {
                this.f83975l.add(new OrderEmptyItem(str));
                this.f83987x = true;
            } else {
                this.f83975l.addAll(list);
                this.f83987x = false;
            }
            this.f83978o.i(this.f83975l);
            this.f83978o.notifyDataSetChanged();
        }
    }

    public void C1(String str, int i11, int i12) {
        if (i11 == 0) {
            if (this.f83966c.g() == 0) {
                this.f83976m.clear();
                this.f83976m.add(new OrderEmptyItem(str));
                this.f83978o.i(this.f83976m);
            } else {
                return;
            }
        } else if (i11 == 1) {
            if (this.f83966c.g() == 1) {
                if (i12 == 0) {
                    if (this.f83966c.e() == 0) {
                        this.f83967d.clear();
                        this.f83967d.add(new OrderEmptyItem(str));
                        this.f83978o.i(this.f83967d);
                        this.f83977n.clear();
                    } else {
                        return;
                    }
                } else if (i12 == 1) {
                    if (this.f83966c.e() == 1) {
                        this.f83968e.clear();
                        this.f83968e.add(new OrderEmptyItem(str));
                        this.f83978o.i(this.f83968e);
                    } else {
                        return;
                    }
                } else if (i12 == 2) {
                    if (this.f83966c.e() == 2) {
                        this.f83969f.clear();
                        this.f83969f.add(new OrderEmptyItem(str));
                        this.f83978o.i(this.f83969f);
                    } else {
                        return;
                    }
                } else if (i12 == 3) {
                    if (this.f83966c.e() == 3) {
                        this.f83970g.clear();
                        this.f83970g.add(new OrderEmptyItem(str));
                        this.f83978o.i(this.f83970g);
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        } else if (i11 == 2) {
            if (this.f83966c.g() == 2) {
                this.f83971h.clear();
                this.f83971h.add(new OrderEmptyItem(str));
                this.f83978o.i(this.f83971h);
            } else {
                return;
            }
        } else if (i11 == 3) {
            if (this.f83966c.g() == 3) {
                this.f83972i.clear();
                this.f83972i.add(new OrderEmptyItem(str));
                this.f83978o.i(this.f83972i);
            } else {
                return;
            }
        } else if (i11 == 4) {
            if (this.f83966c.g() == 4) {
                this.f83974k.clear();
                this.f83974k.add(new OrderEmptyItem(str));
                this.f83978o.i(this.f83974k);
            } else {
                return;
            }
        } else if (i11 == 9) {
            if (this.f83966c.g() == 9) {
                this.f83975l.clear();
                this.f83975l.add(new OrderEmptyItem(str));
                this.f83978o.i(this.f83975l);
            } else {
                return;
            }
        }
        this.f83987x = true;
        this.f83978o.notifyDataSetChanged();
    }

    public void D1(TradeType tradeType, String str, int i11, int i12) {
        this.f83985v = 0;
        J1();
        if (!r.x().F0()) {
            this.f83973j.clear();
            C1(str, i11, i12);
            return;
        }
        this.f83982s = Observable.interval(0, 5, TimeUnit.SECONDS).doOnNext(new m4(this, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
    }

    public void E1(TradeType tradeType, String str, int i11, int i12) {
        String str2;
        this.f83985v = 0;
        K1();
        if (!r.x().F0()) {
            C1(str, i11, i12);
            return;
        }
        String str3 = str;
        int i13 = i11;
        int i14 = i12;
        if (tradeType != TradeType.PRO || (!this.f83964a ? y.a() : com.huobi.trade.helper.y.a())) {
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
        this.f83981r = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new u4(this, tradeType, str2, eVar, str, i11, i12)).subscribe(new BaseSubscriber());
    }

    public void F1(boolean z11, TradeType tradeType, String str, int i11, int i12) {
        String str2;
        L1();
        if (!r.x().F0()) {
            C1(str, i11, i12);
            return;
        }
        this.f83985v = 0;
        if ((tradeType == TradeType.PRO || tradeType == TradeType.MARGIN || tradeType == TradeType.SUPERMARGIN) && (!this.f83964a ? !y.a() : !com.huobi.trade.helper.y.a())) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (!a1.v().S(str) || !o.B().P()) {
            i6.d.e("PLAN_TRADE", "startOrderListInterval - orderListTradeType - " + i12);
            if (i12 == 2) {
                this.f83980q = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new i3(this, str2, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
            } else if (i12 == 1) {
                this.f83980q = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new w4(this, tradeType, z11, str2, str, i11, i12)).subscribe(new BaseSubscriber());
            } else if (i12 == 3) {
                this.f83980q = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new j3(this, str2, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
            } else {
                this.f83980q = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new v4(this, tradeType, z11, str2, str, i11, i12)).subscribe(new BaseSubscriber());
            }
        } else {
            i6.d.b("updateOrderList-->request prime orders");
            if (i12 == 2) {
                C1(str, i11, i12);
            } else {
                this.f83980q = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new g3(this, str, i11, i12, tradeType)).subscribe(new BaseSubscriber());
            }
        }
    }

    public void G1(TradeType tradeType, String str, int i11, int i12) {
        if (!r.x().F0()) {
            C1(str, i11, i12);
            return;
        }
        this.f83985v = 0;
        M1();
        this.f83983t = Observable.interval(0, 5, TimeUnit.SECONDS).doOnNext(new b4(this, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
    }

    public void H1(boolean z11, TradeType tradeType, String str, int i11, int i12) {
        String str2;
        N1();
        if (!r.x().F0()) {
            C1(str, i11, i12);
            return;
        }
        if ((tradeType == TradeType.PRO || tradeType == TradeType.MARGIN || tradeType == TradeType.SUPERMARGIN) && (!this.f83964a ? !y.a() : !com.huobi.trade.helper.y.a())) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (!a1.v().S(str) || !o.B().P()) {
            i6.d.e("PLAN_TRADE", "startPlaceOrderListInterval - orderListTradeType - " + i12);
            if (i12 == 2) {
                this.f83986w = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new k3(this, str2, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
            } else if (i12 == 3) {
                this.f83986w = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new h3(this, str2, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
            } else if (i12 == 1) {
                this.f83986w = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new y4(this, tradeType, z11, str2, str, i11, i12)).subscribe(new BaseSubscriber());
            } else {
                this.f83986w = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new x4(this, tradeType, z11, str2, str, i11, i12)).subscribe(new BaseSubscriber());
            }
        } else {
            i6.d.b("updateOrderList-->request prime orders");
            if (i12 == 2) {
                C1(str, i11, i12);
            } else {
                this.f83986w = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new z4(this, str, i11, i12, tradeType)).subscribe(new BaseSubscriber());
            }
        }
    }

    public void I1(TradeType tradeType, String str, int i11, int i12) {
        if (!r.x().F0()) {
            C1(str, i11, i12);
            return;
        }
        this.f83985v = 0;
        O1();
        this.f83984u = Observable.interval(0, 5, TimeUnit.SECONDS).doOnNext(new q3(this, tradeType, str, i11, i12)).subscribe(new BaseSubscriber());
    }

    public void J1() {
        Subscription subscription = this.f83982s;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void K1() {
        Subscription subscription = this.f83981r;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void L1() {
        this.f83977n.clear();
        Subscription subscription = this.f83980q;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void M1() {
        Subscription subscription = this.f83983t;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void N1() {
        Subscription subscription = this.f83986w;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void O1() {
        Subscription subscription = this.f83984u;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void d0(List<? extends s9.a> list) {
        this.f83977n.clear();
        for (s9.a aVar : list) {
            if (aVar instanceof OrderBean) {
                this.f83977n.put(Long.valueOf(((OrderBean) aVar).getId()), aVar);
            } else if (aVar instanceof vo.a) {
                vo.a aVar2 = (vo.a) aVar;
                this.f83977n.put(aVar2.d(), aVar2);
            } else if (aVar instanceof ExchangeOpenOrderItem) {
                this.f83977n.put(Long.valueOf(((ExchangeOpenOrderItem) aVar).d().getId()), aVar);
            }
        }
    }

    public final void e0(List<PrimeOrderBean> list) {
        this.f83977n.clear();
        for (PrimeOrderBean next : list) {
            this.f83977n.put(Long.valueOf(next.getId()), next);
        }
    }

    public void f0(TradeType tradeType, String str) {
        if (!CollectionsUtils.b(this.f83973j)) {
            u1(str, r0(str, new ArrayList(this.f83973j)), tradeType);
        }
    }

    public final Observer<List<? extends s9.a>> g0(String str, TradeType tradeType, int i11, int i12) {
        return new j(str, i11, i12, tradeType);
    }

    public final void h0(Context context, AlgoOrderInfo algoOrderInfo) {
        u6.g gVar = context instanceof u6.g ? (u6.g) context : null;
        if (!NetworkStatus.c(bh.j.c())) {
            HuobiToastUtil.k(bh.j.c(), R.string.string_network_disconnect);
        } else {
            s0.d0().R(2, algoOrderInfo.getClientOrderId()).delay(1, TimeUnit.SECONDS).compose(RxJavaHelper.t(gVar)).subscribe(new g(gVar));
        }
    }

    public final void i0(List<? extends s9.a> list) {
        boolean z11 = true;
        if (list.size() == this.f83977n.size()) {
            Iterator<? extends s9.a> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z11 = false;
                    break;
                }
                s9.a aVar = (s9.a) it2.next();
                if (!(aVar instanceof OrderBean)) {
                    if (!(aVar instanceof vo.a)) {
                        if ((aVar instanceof ExchangeOpenOrderItem) && !this.f83977n.containsKey(Long.valueOf(((ExchangeOpenOrderItem) aVar).d().getId()))) {
                            break;
                        }
                    } else if (!this.f83977n.containsKey(((vo.a) aVar).d())) {
                        break;
                    }
                } else if (!this.f83977n.containsKey(Long.valueOf(((OrderBean) aVar).getId()))) {
                    break;
                }
            }
        }
        if (z11) {
            N1();
        }
    }

    public final void j0(List<PrimeOrderBean> list) {
        boolean z11 = true;
        if (list.size() == this.f83977n.size()) {
            boolean z12 = false;
            for (PrimeOrderBean id2 : list) {
                if (!this.f83977n.containsKey(Long.valueOf(id2.getId()))) {
                    z12 = true;
                }
            }
            z11 = z12;
        }
        if (z11) {
            N1();
        }
    }

    public final Observable<List<? extends s9.a>> k0(TradeType tradeType, boolean z11, String str, String str2) {
        return s0.d0().g0(z11, tradeType, tradeType == TradeType.PRO ? 5 : 0, str, new s0.d(50, 1, -1, "", str2)).concatMap(ad.i.f3526b).map(new d4(this, tradeType)).toList().map(r4.f54144b);
    }

    public final Observable<List<s9.a>> l0(int i11, String str, TradeType tradeType) {
        return s0.d0().V(i11, str, tradeType).concatMap(ad.i.f3526b).map(new e4(this, tradeType)).toList();
    }

    public final Observer<List<? extends s9.a>> m0(String str, int i11, int i12, TradeType tradeType) {
        return new h(str, tradeType, i11, i12);
    }

    public List<s9.a> n0() {
        return this.f83967d;
    }

    public v9.a<s9.a> o0() {
        return this.f83978o;
    }

    public Comparator<TradeOrderAssets> p0() {
        if (this.f83988y == null) {
            this.f83988y = f3.f54022b;
        }
        return this.f83988y;
    }

    public void p1() {
        v9.a<s9.a> aVar = this.f83978o;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final u6.g q0() {
        return this.f83966c.d();
    }

    public void q1(ProTokenUpdate proTokenUpdate) {
        this.f83973j.clear();
        this.f83972i.clear();
    }

    public final List<? extends s9.a> r0(String str, List<TradeOrderAssets> list) {
        SymbolBean J = a1.v().J(str, TradeType.PRO);
        if (J != null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            TradeOrderAssets tradeOrderAssets = null;
            TradeOrderAssets tradeOrderAssets2 = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                TradeOrderAssets tradeOrderAssets3 = list.get(size);
                if (tradeOrderAssets3.getCurrency().equalsIgnoreCase(J.getBaseCurrency())) {
                    tradeOrderAssets3.setHead(bh.j.d(R.string.n_spot_current_symbol_asset));
                    list.remove(size);
                    tradeOrderAssets = tradeOrderAssets3;
                } else if (tradeOrderAssets3.getCurrency().equalsIgnoreCase(J.getQuoteCurrency())) {
                    list.remove(size);
                    tradeOrderAssets2 = tradeOrderAssets3;
                } else if (i6.m.a(LegalCurrencyConfigUtil.Q("btc", tradeOrderAssets3.getUsdtPoistionValue())).compareTo(wi.a.f48036a) < 0) {
                    list.remove(size);
                }
            }
            if (tradeOrderAssets == null) {
                tradeOrderAssets = new TradeOrderAssets();
                tradeOrderAssets.setCurrency(J.getBaseCurrency().toUpperCase(Locale.US));
                tradeOrderAssets.setHead(bh.j.d(R.string.n_spot_current_symbol_asset));
                tradeOrderAssets.setUsdtPoistionValue("0.00");
                tradeOrderAssets.setBalance("0.00");
            }
            if (tradeOrderAssets2 == null) {
                tradeOrderAssets2 = new TradeOrderAssets();
                tradeOrderAssets2.setCurrency(J.getQuoteCurrency().toUpperCase(Locale.US));
                tradeOrderAssets2.setUsdtPoistionValue("0.00");
                tradeOrderAssets2.setBalance("0.00");
            }
            if (y.a()) {
                list.clear();
                list.add(tradeOrderAssets);
                list.add(tradeOrderAssets2);
            } else {
                if (list.size() > 0) {
                    Collections.sort(list, p0());
                    list.get(0).setHead(bh.j.d(R.string.n_spot_other_symbol_more_than_zero_asset));
                }
                list.add(0, tradeOrderAssets2);
                list.add(0, tradeOrderAssets);
            }
        }
        return list;
    }

    public final Observer<List<? extends s9.a>> r1(String str, TradeType tradeType, int i11, int i12) {
        return new k(str, tradeType, i11, i12);
    }

    public final Observer<List<? extends s9.a>> s0(String str, TradeType tradeType, int i11, int i12) {
        return new i(str, tradeType, i11, i12);
    }

    public final Observer<List<? extends s9.a>> s1(String str, TradeType tradeType, int i11, int i12) {
        return new a(str, tradeType, i11, i12);
    }

    public boolean t0() {
        return this.f83987x;
    }

    public void t1(m mVar) {
        synchronized (this.f83979p) {
            this.f83979p.add(mVar);
        }
    }

    public final void u1(String str, List<? extends s9.a> list, TradeType tradeType) {
        if (this.f83966c.g() == 3) {
            if (list.isEmpty()) {
                this.f83972i.clear();
                this.f83972i.add(new OrderEmptyItem(str));
                this.f83978o.i(this.f83972i);
                this.f83987x = true;
            } else {
                this.f83978o.i(list);
                this.f83987x = false;
            }
            this.f83978o.notifyDataSetChanged();
        }
    }

    public void v1(String str, List<? extends s9.a> list, TradeType tradeType, s sVar) {
        if (this.f83966c.g() == 0) {
            this.f83976m.clear();
            if (list.isEmpty()) {
                this.f83976m.add(new ws.a(str, new WeakReference(new b(sVar))));
                this.f83987x = true;
            } else {
                this.f83976m.addAll(list);
                this.f83987x = false;
            }
            this.f83978o.i(this.f83976m);
            this.f83978o.notifyDataSetChanged();
        }
    }

    public final void w1(String str, int i11, int i12) {
        C1(str, i11, i12);
    }

    public final void x1(String str, List<? extends s9.a> list, TradeType tradeType) {
        int g11 = this.f83966c.g();
        this.f83966c.e();
        if (g11 == 2) {
            this.f83971h.clear();
            if (list.isEmpty()) {
                this.f83971h.add(new OrderEmptyItem(str));
                this.f83987x = true;
            } else {
                this.f83971h.addAll(list);
                this.f83987x = false;
                if (list.size() >= 50) {
                    this.f83971h.add(new ws.f(str, 0, g11, tradeType));
                }
            }
            this.f83978o.i(this.f83971h);
            this.f83978o.notifyDataSetChanged();
        }
    }

    public void y1(String str, List<? extends s9.a> list, TradeType tradeType) {
        if (this.f83966c.g() == 0) {
            this.f83976m.clear();
            if (list.isEmpty()) {
                this.f83976m.add(new OrderEmptyItem(str));
                this.f83987x = true;
            } else {
                this.f83976m.addAll(list);
                this.f83987x = false;
            }
            this.f83978o.i(this.f83976m);
            this.f83978o.notifyDataSetChanged();
        }
    }

    public final void z1(String str, List<? extends s9.a> list, TradeType tradeType) {
        int g11 = this.f83966c.g();
        int e11 = this.f83966c.e();
        if (e11 == 2) {
            this.f83969f.clear();
            if (list.isEmpty()) {
                this.f83969f.add(new OrderEmptyItem(str));
                this.f83987x = true;
            } else {
                this.f83969f.addAll(list);
                this.f83987x = false;
                if (list.size() >= 50) {
                    this.f83969f.add(new ws.f(str, e11, g11, tradeType));
                }
            }
        } else if (e11 == 1) {
            this.f83968e.clear();
            if (list.isEmpty()) {
                this.f83968e.add(new OrderEmptyItem(str));
                this.f83987x = true;
            } else {
                this.f83968e.addAll(list);
                this.f83987x = false;
                if (list.size() >= 50) {
                    this.f83968e.add(new ws.f(str, e11, g11, tradeType));
                }
            }
        } else if (e11 == 0) {
            this.f83967d.clear();
            if (list.isEmpty()) {
                this.f83967d.add(new OrderEmptyItem(str));
                this.f83987x = true;
            } else {
                this.f83967d.addAll(list);
                this.f83987x = false;
                if (list.size() >= 50) {
                    this.f83967d.add(new ws.f(str, e11, g11, tradeType));
                }
            }
        } else if (e11 == 3) {
            this.f83970g.clear();
            if (list.isEmpty()) {
                this.f83970g.add(new OrderEmptyItem(str));
                this.f83987x = true;
            } else {
                this.f83970g.addAll(list);
                this.f83987x = false;
                if (list.size() >= 50) {
                    this.f83970g.add(new ws.f(str, e11, g11, tradeType));
                }
            }
        }
        if (g11 == 1) {
            if (e11 == 2) {
                this.f83978o.i(this.f83969f);
            } else if (e11 == 0) {
                this.f83978o.i(this.f83967d);
            } else if (e11 == 1) {
                this.f83978o.i(this.f83968e);
            } else if (e11 == 3) {
                this.f83978o.i(this.f83970g);
            }
            this.f83978o.notifyDataSetChanged();
        }
        synchronized (this.f83979p) {
            for (m a11 : this.f83979p) {
                a11.a();
            }
        }
    }

    public a5(l lVar, boolean z11) {
        this.f83965b = new HashSet();
        this.f83979p = new HashSet();
        this.f83985v = 0;
        this.f83989z = new c();
        this.A = new d();
        this.B = new e();
        this.C = new f();
        this.f83964a = z11;
        this.f83966c = lVar;
        this.f83965b.add(1L);
        this.f83965b.add(3L);
        this.f83965b.add(6L);
        this.f83965b.add(11L);
        this.f83965b.add(19L);
        this.f83976m = new ArrayList();
        this.f83967d = new ArrayList();
        this.f83968e = new ArrayList();
        this.f83969f = new ArrayList();
        this.f83970g = new ArrayList();
        this.f83971h = new ArrayList();
        this.f83972i = new ArrayList();
        this.f83973j = new ArrayList();
        this.f83974k = new ArrayList();
        this.f83975l = new ArrayList();
        this.f83977n = new HashMap();
        this.f83978o = new v9.a<>(this.f83967d);
    }
}
