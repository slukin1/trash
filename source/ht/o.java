package ht;

import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.network.hbg.prime.PrimeResult;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.trade.prime.bean.AliToken;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import com.huobi.trade.prime.bean.PrimeCollection;
import com.huobi.trade.prime.bean.PrimeOrderBean;
import com.huobi.trade.prime.dialog.PrimeSignDialog;
import com.huobi.trade.prime.service.PrimeService;
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

    /* renamed from: u  reason: collision with root package name */
    public static volatile o f84247u;

    /* renamed from: b  reason: collision with root package name */
    public String f84248b;

    /* renamed from: c  reason: collision with root package name */
    public PrimeInfo f84249c;

    /* renamed from: d  reason: collision with root package name */
    public String f84250d;

    /* renamed from: e  reason: collision with root package name */
    public String f84251e;

    /* renamed from: f  reason: collision with root package name */
    public Subscription f84252f;

    /* renamed from: g  reason: collision with root package name */
    public Subscription f84253g;

    /* renamed from: h  reason: collision with root package name */
    public Subscription f84254h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f84255i;

    /* renamed from: j  reason: collision with root package name */
    public SoftReference<g> f84256j;

    /* renamed from: k  reason: collision with root package name */
    public SoftReference<k> f84257k;

    /* renamed from: l  reason: collision with root package name */
    public final Set<String> f84258l = new HashSet();

    /* renamed from: m  reason: collision with root package name */
    public String f84259m;

    /* renamed from: n  reason: collision with root package name */
    public PrimeAveragePosition f84260n;

    /* renamed from: o  reason: collision with root package name */
    public PrimeSignDialog f84261o;

    /* renamed from: p  reason: collision with root package name */
    public d f84262p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f84263q;

    /* renamed from: r  reason: collision with root package name */
    public SparseArray<PrimeResult> f84264r = new SparseArray<>();

    /* renamed from: s  reason: collision with root package name */
    public i6.b f84265s = new i6.b(this.f84266t);

    /* renamed from: t  reason: collision with root package name */
    public b.a f84266t = new f(this);

    public class a extends BaseSubscriber<PrimeInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f84267b;

        public a(k kVar) {
            this.f84267b = kVar;
        }

        /* renamed from: a */
        public void onNext(PrimeInfo primeInfo) {
            super.onNext(primeInfo);
            o.this.l0(this.f84267b);
        }
    }

    public class b extends EasySubscriber<PrimeCollection> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f84269b;

        public b(k kVar) {
            this.f84269b = kVar;
        }

        /* renamed from: a */
        public void onNext(PrimeCollection primeCollection) {
            super.onNext(primeCollection);
            o.this.l0(this.f84269b);
            if (this.f84269b != null) {
                if (a1.v().S(o.this.f84250d)) {
                    this.f84269b.E8(primeCollection.getLimit(), primeCollection.getPrimeAveragePosition());
                }
                if (o.this.f84263q != a1.v().S(o.this.f84250d)) {
                    this.f84269b.ff(o.this.f84250d);
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
            k kVar = o.this.f84257k != null ? (k) o.this.f84257k.get() : null;
            if (kVar != null) {
                kVar.Wb(str);
            }
        }
    }

    public class d extends EasySubscriber<PrimeResult> {

        /* renamed from: b  reason: collision with root package name */
        public int f84272b;

        public d(int i11) {
            this.f84272b = i11;
        }

        public int a() {
            return this.f84272b;
        }

        /* renamed from: b */
        public void onNext(PrimeResult primeResult) {
            k kVar;
            super.onNext(primeResult);
            o.this.f84264r.put(this.f84272b, primeResult);
            i6.d.b("PrimeTradeHelper-->checkLoopPrimeResult-->onNext-->" + primeResult);
            if (!(o.this.f84257k == null || (kVar = (k) o.this.f84257k.get()) == null)) {
                kVar.m5(primeResult);
            }
            if (primeResult != null && primeResult.isFinished()) {
                o.this.w0();
                o.this.n0();
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public o() {
        e.k().v(this);
    }

    public static o B() {
        if (f84247u == null) {
            synchronized (o.class) {
                if (f84247u == null) {
                    f84247u = new o();
                }
            }
        }
        return f84247u;
    }

    public static /* synthetic */ Observable d0(Long l11) {
        Class cls = PrimeService.class;
        if (B().T()) {
            return ((PrimeService) p.C(cls)).getPrimeBidResult();
        }
        return ((PrimeService) p.C(cls)).getPrimeResult();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(PrimeAveragePosition primeAveragePosition) {
        this.f84260n = primeAveragePosition;
    }

    public static /* synthetic */ PrimeCollection g0(String str, PrimeAveragePosition primeAveragePosition, PrimeInfo primeInfo) {
        return new PrimeCollection(primeInfo, str, primeAveragePosition);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(String str) {
        this.f84248b = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0() {
        if (this.f84257k.get() != null) {
            this.f84257k.get().X8();
        }
        i6.d.b("PrimeTradeHelper-->-->MSG_REFRESH_TRADE:" + System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(Message message) {
        if (message.what == 1) {
            i.b().f(new h(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PrimeInfo k0(PrimeInfo primeInfo) {
        this.f84249c = primeInfo;
        if (primeInfo != null) {
            primeInfo.parseData();
        }
        return primeInfo;
    }

    public String A() {
        return this.f84259m;
    }

    public String C() {
        List<PrimeRounds> rounds;
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo != null && primeInfo.getTotalRounds() > 1 && (rounds = this.f84249c.getRounds()) != null) {
            Iterator<PrimeRounds> it2 = rounds.iterator();
            PrimeRounds primeRounds = null;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PrimeRounds next = it2.next();
                if (next == null || next.getRoundNum() != this.f84249c.getCurrentRoundNumber()) {
                    primeRounds = next;
                } else if (primeRounds != null) {
                    return primeRounds.getRoundTradeType();
                }
            }
        }
        return null;
    }

    public PrimeAveragePosition D() {
        return this.f84260n;
    }

    public void E(String str, g gVar, k kVar) {
        if (r.x().F0()) {
            u();
            this.f84257k = new SoftReference<>(kVar);
            this.f84250d = str;
            this.f84263q = a1.v().S(str);
            this.f84253g = Observable.zip(G().subscribeOn(Schedulers.io()), ((PrimeService) p.C(PrimeService.class)).getAveragePosition().compose(p.D()).onErrorResumeNext(Observable.just(null)).doOnNext(new i(this)).subscribeOn(Schedulers.io()), o0().subscribeOn(Schedulers.io()), n.f54991b).compose(RxJavaHelper.t(gVar)).subscribe(new b(kVar));
        }
    }

    public PrimeInfo F() {
        return this.f84249c;
    }

    public Observable<String> G() {
        return ((PrimeService) p.C(PrimeService.class)).getPrimeLimit().compose(p.D()).onErrorResumeNext(Observable.just(null)).doOnNext(new j(this));
    }

    public Observable<List<PrimeOrderBean>> H() {
        return I("submitting,submitted,canceling");
    }

    public Observable<List<PrimeOrderBean>> I(String str) {
        Class cls = PrimeService.class;
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("states", str);
        }
        String M = M();
        if (c0()) {
            String C = C();
            if (V(C)) {
                M = C;
            }
        }
        if (V(M)) {
            return ((PrimeService) p.C(cls)).getPrimeBidOrders(hashMap).compose(p.D());
        }
        return ((PrimeService) p.C(cls)).getPrimeOrders(hashMap).compose(p.D());
    }

    public PrimeResult J() {
        d dVar = this.f84262p;
        if (dVar == null || dVar.a() == L()) {
            return this.f84264r.get(L());
        }
        w();
        return null;
    }

    public String K() {
        return this.f84248b;
    }

    public int L() {
        return T() ? 1 : 2;
    }

    public String M() {
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo != null) {
            return primeInfo.getRoundTradeType();
        }
        return null;
    }

    public void N() {
        PrimeSignDialog primeSignDialog = this.f84261o;
        if (primeSignDialog != null && primeSignDialog.isVisible()) {
            this.f84261o.dismiss();
        }
    }

    public boolean O() {
        return this.f84255i;
    }

    public boolean P() {
        return Q() || U();
    }

    public boolean Q() {
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo != null) {
            return "limit".equals(primeInfo.getRoundTradeType());
        }
        return false;
    }

    public boolean R() {
        PrimeInfo primeInfo = this.f84249c;
        return primeInfo != null && primeInfo.isListingTransfer();
    }

    public boolean S() {
        return b0() || R() || U();
    }

    public boolean T() {
        return U() || (c0() && W());
    }

    public boolean U() {
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo != null) {
            return V(primeInfo.getRoundTradeType());
        }
        return false;
    }

    public boolean V(String str) {
        return PrimeRounds.ROUND_TRADE_LUCKY_TYPE.equals(str);
    }

    public boolean W() {
        return V(C());
    }

    public boolean X() {
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo != null) {
            return PrimeRounds.ROUND_TRADE_MARKET_TYPE.equals(primeInfo.getRoundTradeType());
        }
        return false;
    }

    public boolean Y() {
        PrimeInfo primeInfo = this.f84249c;
        return primeInfo != null && primeInfo.isPrime();
    }

    public boolean Z() {
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo == null || primeInfo.getStatus() != 2) {
            return false;
        }
        return true;
    }

    public boolean a0() {
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo == null || primeInfo.getStatus() != 3) {
            return false;
        }
        return true;
    }

    public void b(int i11, long j11, long[] jArr) {
        v(j11);
    }

    public boolean b0() {
        PrimeInfo primeInfo = this.f84249c;
        return primeInfo != null && primeInfo.isPrimeLite();
    }

    public void c(int i11) {
        this.f84259m = "";
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo != null) {
            primeInfo.setCurrentTime(primeInfo.getCurrentTime() + this.f84249c.getCountDownTime());
            this.f84249c.parseData();
            int status = this.f84249c.getStatus();
            if (status == 1) {
                e.k().w(0, this.f84249c.getCountDownTime());
            } else if (status == 2) {
                e.k().w(1, this.f84249c.getCountDownTime());
            } else if (status == 3) {
                e.k().u();
            }
        }
    }

    public boolean c0() {
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo == null || primeInfo.getStatus() != 1) {
            return false;
        }
        return true;
    }

    public final void l0(k kVar) {
        i6.b bVar;
        v0();
        PrimeInfo primeInfo = this.f84249c;
        int i11 = 1;
        if (primeInfo != null) {
            primeInfo.parseData();
            int status = this.f84249c.getStatus();
            int status2 = this.f84249c.getStatus();
            if (status2 == 1) {
                e.k().w(1, this.f84249c.getCountDownTime());
            } else if (status2 == 2) {
                e.k().w(2, this.f84249c.getCountDownTime());
            } else if (status2 == 3) {
                e.k().u();
                if (this.f84249c.getCurrentTime() < this.f84249c.getTradeBeginTime() && (bVar = this.f84265s) != null) {
                    bVar.sendEmptyMessageDelayed(1, this.f84249c.getTradeBeginTime() - this.f84249c.getCurrentTime());
                }
            }
            i11 = status;
        }
        if (kVar != null) {
            if (a1.v().S(this.f84250d)) {
                kVar.Bb(this.f84249c, i11, false);
                kVar.S7(this.f84249c);
                kVar.W8();
            }
            if (this.f84263q != a1.v().S(this.f84250d)) {
                kVar.ff(this.f84250d);
            }
        }
    }

    public final void m0() {
        SoftReference<g> softReference = this.f84256j;
        k kVar = null;
        g gVar = softReference != null ? softReference.get() : null;
        SoftReference<k> softReference2 = this.f84257k;
        if (softReference2 != null) {
            kVar = softReference2.get();
        }
        p0(this.f84250d, gVar, kVar);
    }

    public void n0() {
        i6.d.b("PrimeTradeHelper-->reloadPrimeLimit-->");
        SoftReference<g> softReference = this.f84256j;
        G().compose(RxJavaHelper.t(softReference != null ? softReference.get() : null)).subscribe(new c());
    }

    public Observable<PrimeInfo> o0() {
        return ((PrimeService) p.C(PrimeService.class)).getPrimeInfo().compose(p.D()).onErrorResumeNext(Observable.just(null)).map(new k(this));
    }

    public void p0(String str, g gVar, k kVar) {
        this.f84250d = str;
        this.f84256j = new SoftReference<>(gVar);
        this.f84257k = new SoftReference<>(kVar);
        r();
        this.f84263q = a1.v().S(str);
        this.f84252f = o0().compose(RxJavaHelper.t(gVar)).subscribe(new a(kVar));
    }

    public boolean q() {
        if (!Y() && !b0() && !R()) {
            return false;
        }
        if (!Y()) {
            return true;
        }
        if (U() && c0()) {
            return false;
        }
        if (T()) {
            return true;
        }
        return a0();
    }

    public void q0(String str) {
        this.f84259m = str;
    }

    public final void r() {
        Subscription subscription = this.f84252f;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f84252f = null;
        }
    }

    public void r0(boolean z11) {
        this.f84255i = z11;
    }

    public Observable<String> s(long j11) {
        Class cls = PrimeService.class;
        if (U()) {
            return ((PrimeService) p.C(cls)).bidCancelLuckyOrder(j11).compose(p.D());
        }
        return ((PrimeService) p.C(cls)).cancelLuckyOrder(j11).compose(p.D());
    }

    public void s0(String str) {
        this.f84248b = str;
    }

    public void t() {
        r();
        u();
    }

    public void t0(String str) {
        this.f84251e = str;
    }

    public final void u() {
        Subscription subscription = this.f84253g;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f84253g = null;
        }
    }

    public void u0(FragmentActivity fragmentActivity, String str) {
        PrimeSignDialog primeSignDialog = new PrimeSignDialog();
        this.f84261o = primeSignDialog;
        primeSignDialog.setCanceledOnTouchOutside(false);
        this.f84261o.setCanDismissOnBackPress(false);
        this.f84261o.setCancelable(false);
        this.f84261o.th(str);
        this.f84261o.show(fragmentActivity.getSupportFragmentManager(), "primeSignDialog");
    }

    public final void v(long j11) {
        int z11;
        if (c0() && j11 >= 10000 && j11 <= 15000 && (z11 = z()) > 0) {
            String str = this.f84250d + "_" + z11;
            if (!this.f84258l.contains(str)) {
                this.f84258l.add(str);
                int i11 = (int) (j11 - 10000);
                if (!TextUtils.isEmpty(this.f84250d) && this.f84250d.equals(this.f84251e)) {
                    i.b().g(new g(this), new Random().nextInt(Math.max(i11, 1)));
                }
            }
        }
    }

    public void v0() {
        i6.b bVar = this.f84265s;
        if (bVar != null) {
            bVar.removeMessages(1);
        }
    }

    public void w() {
        w0();
        if (B().q() && r.x().F0()) {
            i6.d.b("PrimeTradeHelper-->checkLoopPrimeResult-->");
            this.f84262p = new d(L());
            this.f84254h = Observable.interval(0, 10, TimeUnit.SECONDS).flatMap(l.f54989b).compose(p.D()).retryWhen(m.f54990b).compose(RxJavaHelper.t((g) null)).subscribe(this.f84262p);
        }
    }

    public void w0() {
        d dVar = this.f84262p;
        if (dVar != null && !dVar.isUnsubscribed()) {
            this.f84262p.unsubscribe();
        }
        Subscription subscription = this.f84254h;
        if (subscription != null && !subscription.isUnsubscribed()) {
            i6.d.b("PrimeTradeHelper-->unLoopPrimeResult-->");
            this.f84254h.unsubscribe();
        }
    }

    public void x() {
        this.f84249c = null;
    }

    public Observable<AliToken> y() {
        return ((PrimeService) p.C(PrimeService.class)).getAliToken().compose(p.D());
    }

    public int z() {
        PrimeInfo primeInfo = this.f84249c;
        if (primeInfo != null) {
            return primeInfo.getCurrentRoundNumber();
        }
        return 0;
    }
}
