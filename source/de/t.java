package de;

import android.text.TextUtils;
import com.hbg.lib.network.pro.IProApi;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.lib.network.pro.socket.response.MarketDetailResponse;
import com.hbg.module.kline.source.BaseKlineDataProvider;
import g9.a;
import rx.Subscription;

public class t extends BaseKlineDataProvider {

    /* renamed from: c  reason: collision with root package name */
    public String f25211c;

    /* renamed from: d  reason: collision with root package name */
    public String f25212d;

    /* renamed from: e  reason: collision with root package name */
    public String f25213e;

    /* renamed from: f  reason: collision with root package name */
    public e f25214f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25215g;

    /* renamed from: h  reason: collision with root package name */
    public LastKlineListener f25216h = new a();

    /* renamed from: i  reason: collision with root package name */
    public a.d f25217i = new s(this);

    /* renamed from: j  reason: collision with root package name */
    public MarketDetailListener f25218j = new b();

    /* renamed from: k  reason: collision with root package name */
    public LastKlineListener f25219k = new c();

    /* renamed from: l  reason: collision with root package name */
    public LastKlineListener f25220l = new d();

    public class a extends LastKlineListener {
        public a() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            e eVar;
            t tVar = t.this;
            if (tVar.f23715a && (eVar = tVar.f25214f) != null) {
                eVar.G3(lastKlineResponse.getTick());
            }
        }
    }

    public class b extends MarketDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDetailResponse marketDetailResponse) {
            if (marketDetailResponse.isSuccess()) {
                t tVar = t.this;
                if (tVar.f23715a && tVar.f25211c.equals(marketDetailResponse.getSymbol())) {
                    t.this.k(marketDetailResponse.getTick());
                }
            }
        }
    }

    public class c extends LastKlineListener {
        public c() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            t tVar = t.this;
            if (tVar.f23715a) {
                e eVar = tVar.f25214f;
                if (eVar != null) {
                    eVar.s3(lastKlineResponse.getSymbol(), lastKlineResponse.getPeriod(), lastKlineResponse.getTick());
                }
                if (lastKlineResponse.getTick() != null && t.this.f25211c.equals(lastKlineResponse.getSymbol())) {
                    t.this.i(lastKlineResponse.getTick());
                }
            }
        }
    }

    public class d extends LastKlineListener {
        public d() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            t tVar = t.this;
            if (tVar.f23715a && lastKlineResponse != null && tVar.f25214f != null && lastKlineResponse.isSuccess() && t.this.f25212d.equals(lastKlineResponse.getSymbol())) {
                t.this.f25214f.G(lastKlineResponse.getSymbol(), lastKlineResponse.getPeriod(), lastKlineResponse.getTick());
            }
        }
    }

    public interface e {
        void G(String str, String str2, KlineInfo klineInfo);

        void G3(KlineInfo klineInfo);

        void M(KlineInfo klineInfo);

        void p3(String str);

        void s3(String str, String str2, KlineInfo klineInfo);
    }

    public t(String str, String str2, boolean z11, e eVar) {
        this.f25211c = str;
        this.f25215g = z11;
        this.f25213e = str2;
        this.f25214f = eVar;
        if (z11) {
            this.f25212d = str + "nav";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        b(true);
    }

    public void b(boolean z11) {
        j(z11);
    }

    public boolean c(String str, Period period) {
        return super.c(str, period);
    }

    public void e(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void f() {
        i6.d.i("MarketViewHandler doOnPause");
        x8.a.a().c(this.f25217i);
    }

    public void g() {
        i6.d.i("MarketViewHandler doOnResume");
        x8.a.a().d(this.f25217i);
    }

    public void i(KlineInfo klineInfo) {
    }

    public void j(boolean z11) {
        if (c(this.f25211c, this.f23716b)) {
            IProApi a11 = x8.a.a();
            String str = this.f25211c;
            Period period = Period.day;
            a11.g(z11, str, period, this.f25219k);
            x8.a.a().j(z11, this.f25211c, this.f25218j);
            if (!TextUtils.isEmpty(this.f25213e)) {
                x8.a.a().g(z11, this.f25213e, this.f23716b, this.f25216h);
            }
            if (this.f25215g) {
                x8.a.a().g(z11, this.f25212d, period, this.f25220l);
            }
        }
    }

    public void k(KlineInfo klineInfo) {
        e eVar = this.f25214f;
        if (eVar != null) {
            eVar.M(klineInfo);
        }
    }

    public void l(e eVar) {
        this.f25214f = eVar;
    }

    public void onPause() {
        super.onPause();
        f();
    }

    public void onResume() {
        super.onResume();
        g();
    }

    public t(String str, String str2, e eVar) {
        this.f25211c = str;
        this.f25213e = str2;
        this.f25214f = eVar;
    }
}
