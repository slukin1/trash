package ut;

import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.CurrencyAsset;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.prime.PrimeResult;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.order.service.OrderService;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.prime.bean.AliToken;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import com.huobi.trade.prime.bean.PrimeCollection;
import com.huobi.trade.prime.bean.PrimeOrderBean;
import com.huobi.trade.prime.bean.TradeOrderNum;
import com.huobi.tradenew.prime.dialog.PrimeSignDialog;
import com.huobi.tradenew.prime.service.PrimeService;
import d7.a1;
import i6.b;
import i6.i;
import it.k;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;
import u6.g;

public final class o implements it.a {

    /* renamed from: x  reason: collision with root package name */
    public static volatile o f84962x;

    /* renamed from: b  reason: collision with root package name */
    public String f84963b;

    /* renamed from: c  reason: collision with root package name */
    public PrimeInfo f84964c;

    /* renamed from: d  reason: collision with root package name */
    public TradeOrderNum f84965d;

    /* renamed from: e  reason: collision with root package name */
    public OrderPlaceBean f84966e;

    /* renamed from: f  reason: collision with root package name */
    public String f84967f;

    /* renamed from: g  reason: collision with root package name */
    public String f84968g;

    /* renamed from: h  reason: collision with root package name */
    public Subscription f84969h;

    /* renamed from: i  reason: collision with root package name */
    public Subscription f84970i;

    /* renamed from: j  reason: collision with root package name */
    public Subscription f84971j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f84972k;

    /* renamed from: l  reason: collision with root package name */
    public SoftReference<g> f84973l;

    /* renamed from: m  reason: collision with root package name */
    public SoftReference<k> f84974m;

    /* renamed from: n  reason: collision with root package name */
    public final Set<String> f84975n = new HashSet();

    /* renamed from: o  reason: collision with root package name */
    public String f84976o;

    /* renamed from: p  reason: collision with root package name */
    public PrimeAveragePosition f84977p;

    /* renamed from: q  reason: collision with root package name */
    public PrimeSignDialog f84978q;

    /* renamed from: r  reason: collision with root package name */
    public d f84979r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f84980s;

    /* renamed from: t  reason: collision with root package name */
    public SparseArray<PrimeResult> f84981t = new SparseArray<>();

    /* renamed from: u  reason: collision with root package name */
    public CurrencyAsset f84982u;

    /* renamed from: v  reason: collision with root package name */
    public i6.b f84983v = new i6.b(this.f84984w);

    /* renamed from: w  reason: collision with root package name */
    public b.a f84984w = new e(this);

    public class a extends BaseSubscriber<PrimeInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f84985b;

        public a(k kVar) {
            this.f84985b = kVar;
        }

        /* renamed from: a */
        public void onNext(PrimeInfo primeInfo) {
            super.onNext(primeInfo);
            o.this.q0(this.f84985b);
        }
    }

    public class b extends EasySubscriber<PrimeCollection> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f84987b;

        public b(k kVar) {
            this.f84987b = kVar;
        }

        /* renamed from: a */
        public void onNext(PrimeCollection primeCollection) {
            super.onNext(primeCollection);
            o.this.q0(this.f84987b);
            if (this.f84987b != null) {
                if (a1.v().S(o.this.f84967f)) {
                    this.f84987b.E8(primeCollection.getLimit(), primeCollection.getPrimeAveragePosition());
                }
                if (o.this.f84980s != a1.v().S(o.this.f84967f)) {
                    this.f84987b.ff(o.this.f84967f);
                }
            }
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onStart() {
            super.onStart();
        }
    }

    public class c extends EasySubscriber<String> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            i6.d.b("PrimeTradeHelper-->reloadPrimeLimit-->onNext-->limit = " + str);
            k kVar = o.this.f84974m != null ? (k) o.this.f84974m.get() : null;
            if (kVar != null) {
                kVar.Wb(str);
            }
        }
    }

    public class d extends EasySubscriber<PrimeResult> {

        /* renamed from: b  reason: collision with root package name */
        public int f84990b;

        public d(int i11) {
            this.f84990b = i11;
        }

        public int a() {
            return this.f84990b;
        }

        /* renamed from: b */
        public void onNext(PrimeResult primeResult) {
            k kVar;
            super.onNext(primeResult);
            o.this.f84981t.put(this.f84990b, primeResult);
            i6.d.b("PrimeTradeHelper-->checkLoopPrimeResult-->onNext-->" + primeResult);
            if (!(o.this.f84974m == null || (kVar = (k) o.this.f84974m.get()) == null)) {
                kVar.m5(primeResult);
            }
            if (primeResult != null && primeResult.isFinished()) {
                o.this.C0();
                o.this.s0();
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public o() {
        d.i().s(this);
    }

    public static o C() {
        if (f84962x == null) {
            synchronized (o.class) {
                if (f84962x == null) {
                    f84962x = new o();
                }
            }
        }
        return f84962x;
    }

    public static /* synthetic */ Observable h0(Long l11) {
        Class cls = PrimeService.class;
        if (C().X()) {
            return ((PrimeService) p.C(cls)).getPrimeBidResult();
        }
        return ((PrimeService) p.C(cls)).getPrimeResult();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(PrimeAveragePosition primeAveragePosition) {
        this.f84977p = primeAveragePosition;
    }

    public static /* synthetic */ PrimeCollection k0(String str, PrimeAveragePosition primeAveragePosition, PrimeInfo primeInfo) {
        return new PrimeCollection(primeInfo, str, primeAveragePosition);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(String str) {
        this.f84963b = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(TradeOrderNum tradeOrderNum) {
        this.f84965d = tradeOrderNum;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0() {
        if (this.f84974m.get() != null) {
            this.f84974m.get().X8();
        }
        i6.d.b("PrimeTradeHelper-->-->MSG_REFRESH_TRADE:" + System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(Message message) {
        if (message.what == 1) {
            i.b().f(new g(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PrimeInfo p0(PrimeInfo primeInfo) {
        this.f84964c = primeInfo;
        if (primeInfo != null) {
            primeInfo.parseData();
        }
        return primeInfo;
    }

    public int A() {
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo != null) {
            return primeInfo.getCurrentRoundNumber();
        }
        return 0;
    }

    public void A0(FragmentActivity fragmentActivity, String str) {
        PrimeSignDialog primeSignDialog = new PrimeSignDialog();
        this.f84978q = primeSignDialog;
        primeSignDialog.setCanceledOnTouchOutside(false);
        this.f84978q.setCanDismissOnBackPress(false);
        this.f84978q.setCancelable(false);
        this.f84978q.th(str);
        this.f84978q.show(fragmentActivity.getSupportFragmentManager(), "primeSignDialog");
    }

    public String B() {
        return this.f84976o;
    }

    public void B0() {
        i6.b bVar = this.f84983v;
        if (bVar != null) {
            bVar.removeMessages(1);
        }
    }

    public void C0() {
        d dVar = this.f84979r;
        if (dVar != null && !dVar.isUnsubscribed()) {
            this.f84979r.unsubscribe();
        }
        Subscription subscription = this.f84971j;
        if (subscription != null && !subscription.isUnsubscribed()) {
            i6.d.b("PrimeTradeHelper-->unLoopPrimeResult-->");
            this.f84971j.unsubscribe();
        }
    }

    public String D() {
        List<PrimeRounds> rounds;
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo != null && primeInfo.getTotalRounds() > 1 && (rounds = this.f84964c.getRounds()) != null) {
            Iterator<PrimeRounds> it2 = rounds.iterator();
            PrimeRounds primeRounds = null;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PrimeRounds next = it2.next();
                if (next == null || next.getRoundNum() != this.f84964c.getCurrentRoundNumber()) {
                    primeRounds = next;
                } else if (primeRounds != null) {
                    return primeRounds.getRoundTradeType();
                }
            }
        }
        return null;
    }

    public PrimeAveragePosition E() {
        return this.f84977p;
    }

    public void F(String str, g gVar, k kVar) {
        if (r.x().F0()) {
            w();
            this.f84974m = new SoftReference<>(kVar);
            this.f84967f = str;
            this.f84980s = a1.v().S(str);
            this.f84970i = Observable.zip(H().subscribeOn(Schedulers.io()), ((PrimeService) p.C(PrimeService.class)).getAveragePosition().compose(p.D()).onErrorResumeNext(Observable.just(null)).doOnNext(new h(this)).subscribeOn(Schedulers.io()), t0().subscribeOn(Schedulers.io()), n.f60946b).compose(RxJavaHelper.t(gVar)).subscribe(new b(kVar));
        }
    }

    public PrimeInfo G() {
        return this.f84964c;
    }

    public Observable<String> H() {
        return ((PrimeService) p.C(PrimeService.class)).getPrimeLimit().compose(p.D()).onErrorResumeNext(Observable.just(null)).doOnNext(new j(this));
    }

    public Observable<List<PrimeOrderBean>> I() {
        return J("submitting,submitted,canceling");
    }

    public Observable<List<PrimeOrderBean>> J(String str) {
        Class cls = PrimeService.class;
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("states", str);
        }
        String N = N();
        if (g0()) {
            String D = D();
            if (Z(D)) {
                N = D;
            }
        }
        if (Z(N)) {
            return ((PrimeService) p.C(cls)).getPrimeBidOrders(hashMap).compose(p.D());
        }
        return ((PrimeService) p.C(cls)).getPrimeOrders(hashMap).compose(p.D());
    }

    public PrimeResult K() {
        d dVar = this.f84979r;
        if (dVar == null || dVar.a() == M()) {
            return this.f84981t.get(M());
        }
        y();
        return null;
    }

    public String L() {
        return this.f84963b;
    }

    public int M() {
        return X() ? 1 : 2;
    }

    public String N() {
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo != null) {
            return primeInfo.getRoundTradeType();
        }
        return null;
    }

    public synchronized Pair<String, String> O(String str) {
        CurrencyAsset currencyAsset;
        if (!TextUtils.isEmpty(str) && (currencyAsset = this.f84982u) != null) {
            if (TextUtils.equals(str, currencyAsset.getBaseCurrency())) {
                return Pair.create(this.f84982u.getBaseBalance(), this.f84982u.getBaseMaxBalance());
            } else if (TextUtils.equals(str, this.f84982u.getQuoteCurrency())) {
                return Pair.create(this.f84982u.getQuoteBalance(), this.f84982u.getQuoteMaxBalance());
            }
        }
        return Pair.create((Object) null, (Object) null);
    }

    public Observable<TradeOrderNum> P(g gVar) {
        return Q(gVar, RankScreenBean.SCREEN_VALUE_SPOT);
    }

    public Observable<TradeOrderNum> Q(g gVar, String str) {
        return ((OrderService) p.X(TradeType.PRO, OrderService.class)).getTradeOrderNum(str).compose(p.E()).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null)).doOnNext(new i(this));
    }

    public void R() {
        PrimeSignDialog primeSignDialog = this.f84978q;
        if (primeSignDialog != null && primeSignDialog.isVisible()) {
            this.f84978q.dismiss();
        }
    }

    public boolean S() {
        return this.f84972k;
    }

    public boolean T() {
        return U() || Y();
    }

    public boolean U() {
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo != null) {
            return "limit".equals(primeInfo.getRoundTradeType());
        }
        return false;
    }

    public boolean V() {
        PrimeInfo primeInfo = this.f84964c;
        return primeInfo != null && primeInfo.isListingTransfer();
    }

    public boolean W() {
        return f0() || V() || Y();
    }

    public boolean X() {
        return Y() || (g0() && a0());
    }

    public boolean Y() {
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo != null) {
            return Z(primeInfo.getRoundTradeType());
        }
        return false;
    }

    public boolean Z(String str) {
        return PrimeRounds.ROUND_TRADE_LUCKY_TYPE.equals(str);
    }

    public boolean a0() {
        return Z(D());
    }

    public void b(int i11, long j11, long[] jArr) {
        x(j11);
    }

    public boolean b0() {
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo != null) {
            return PrimeRounds.ROUND_TRADE_MARKET_TYPE.equals(primeInfo.getRoundTradeType());
        }
        return false;
    }

    public void c(int i11) {
        this.f84976o = "";
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo != null) {
            primeInfo.setCurrentTime(primeInfo.getCurrentTime() + this.f84964c.getCountDownTime());
            this.f84964c.parseData();
            int status = this.f84964c.getStatus();
            if (status == 1) {
                d.i().t(0, this.f84964c.getCountDownTime());
            } else if (status == 2) {
                d.i().t(1, this.f84964c.getCountDownTime());
            } else if (status == 3) {
                d.i().r();
            }
        }
    }

    public boolean c0() {
        PrimeInfo primeInfo = this.f84964c;
        return primeInfo != null && primeInfo.isPrime();
    }

    public boolean d0() {
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo == null || primeInfo.getStatus() != 2) {
            return false;
        }
        return true;
    }

    public boolean e0() {
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo == null || primeInfo.getStatus() != 3) {
            return false;
        }
        return true;
    }

    public boolean f0() {
        PrimeInfo primeInfo = this.f84964c;
        return primeInfo != null && primeInfo.isPrimeLite();
    }

    public boolean g0() {
        PrimeInfo primeInfo = this.f84964c;
        if (primeInfo == null || primeInfo.getStatus() != 1) {
            return false;
        }
        return true;
    }

    public final void q0(k kVar) {
        i6.b bVar;
        B0();
        PrimeInfo primeInfo = this.f84964c;
        int i11 = 1;
        if (primeInfo != null) {
            primeInfo.parseData();
            int status = this.f84964c.getStatus();
            int status2 = this.f84964c.getStatus();
            if (status2 == 1) {
                d.i().t(1, this.f84964c.getCountDownTime());
            } else if (status2 == 2) {
                d.i().t(2, this.f84964c.getCountDownTime());
            } else if (status2 == 3) {
                d.i().r();
                if (this.f84964c.getCurrentTime() < this.f84964c.getTradeBeginTime() && (bVar = this.f84983v) != null) {
                    bVar.sendEmptyMessageDelayed(1, this.f84964c.getTradeBeginTime() - this.f84964c.getCurrentTime());
                }
            }
            i11 = status;
        }
        if (kVar != null) {
            if (a1.v().S(this.f84967f)) {
                kVar.Bb(this.f84964c, i11, false);
                kVar.S7(this.f84964c);
                kVar.W8();
            }
            if (this.f84980s != a1.v().S(this.f84967f)) {
                kVar.ff(this.f84967f);
            }
        }
    }

    public synchronized void r(CurrencyAsset currencyAsset) {
        if (currencyAsset != null) {
            this.f84982u = currencyAsset;
        }
    }

    public final void r0() {
        SoftReference<g> softReference = this.f84973l;
        k kVar = null;
        g gVar = softReference != null ? softReference.get() : null;
        SoftReference<k> softReference2 = this.f84974m;
        if (softReference2 != null) {
            kVar = softReference2.get();
        }
        u0(this.f84967f, gVar, kVar);
    }

    public boolean s() {
        if (!c0() && !f0() && !V()) {
            return false;
        }
        if (!c0()) {
            return true;
        }
        if (Y() && g0()) {
            return false;
        }
        if (X()) {
            return true;
        }
        return e0();
    }

    public void s0() {
        i6.d.b("PrimeTradeHelper-->reloadPrimeLimit-->");
        SoftReference<g> softReference = this.f84973l;
        H().compose(RxJavaHelper.t(softReference != null ? softReference.get() : null)).subscribe(new c());
    }

    public final void t() {
        Subscription subscription = this.f84969h;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f84969h = null;
        }
    }

    public Observable<PrimeInfo> t0() {
        return ((PrimeService) p.C(PrimeService.class)).getPrimeInfo().compose(p.D()).onErrorResumeNext(Observable.just(null)).map(new k(this));
    }

    public Observable<String> u(long j11) {
        Class cls = PrimeService.class;
        if (Y()) {
            return ((PrimeService) p.C(cls)).bidCancelLuckyOrder(j11).compose(p.D());
        }
        return ((PrimeService) p.C(cls)).cancelLuckyOrder(j11).compose(p.D());
    }

    public void u0(String str, g gVar, k kVar) {
        this.f84967f = str;
        this.f84973l = new SoftReference<>(gVar);
        this.f84974m = new SoftReference<>(kVar);
        t();
        this.f84980s = a1.v().S(str);
        this.f84969h = t0().compose(RxJavaHelper.t(gVar)).subscribe(new a(kVar));
    }

    public void v() {
        t();
        w();
    }

    public void v0(String str) {
        this.f84976o = str;
    }

    public final void w() {
        Subscription subscription = this.f84970i;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f84970i = null;
        }
    }

    public void w0(boolean z11) {
        this.f84972k = z11;
    }

    public final void x(long j11) {
        int A;
        if (g0() && j11 >= 10000 && j11 <= 15000 && (A = A()) > 0) {
            String str = this.f84967f + "_" + A;
            if (!this.f84975n.contains(str)) {
                this.f84975n.add(str);
                int i11 = (int) (j11 - 10000);
                if (!TextUtils.isEmpty(this.f84967f) && this.f84967f.equals(this.f84968g)) {
                    i.b().g(new f(this), new Random().nextInt(Math.max(i11, 1)));
                }
            }
        }
    }

    public void x0(OrderPlaceBean orderPlaceBean) {
        this.f84966e = orderPlaceBean;
    }

    public void y() {
        C0();
        if (C().s() && r.x().F0()) {
            i6.d.b("PrimeTradeHelper-->checkLoopPrimeResult-->");
            this.f84979r = new d(M());
            this.f84971j = Observable.interval(0, 10, TimeUnit.SECONDS).flatMap(l.f60944b).compose(p.D()).retryWhen(m.f60945b).compose(RxJavaHelper.t((g) null)).subscribe(this.f84979r);
        }
    }

    public void y0(String str) {
        this.f84963b = str;
    }

    public Observable<AliToken> z() {
        return ((PrimeService) p.C(PrimeService.class)).getAliToken().compose(p.D());
    }

    public void z0(String str) {
        this.f84968g = str;
    }
}
