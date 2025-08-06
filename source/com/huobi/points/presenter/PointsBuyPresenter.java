package com.huobi.points.presenter;

import android.content.Intent;
import android.util.Pair;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.network.exception.NullResponseException;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.response.AliTokenStringStatusResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsPack;
import com.huobi.points.utils.PointsDataSource;
import com.huobi.utils.k0;
import dt.h2;
import g9.a;
import i6.i;
import iq.h;
import iq.j;
import iq.k;
import iq.l;
import iq.m;
import iq.n;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import sl.d0;
import tg.r;
import u6.g;

public class PointsBuyPresenter extends ActivityPresenter<e> {

    /* renamed from: a  reason: collision with root package name */
    public PointsPack f80475a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, BigDecimal> f80476b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f80477c;

    /* renamed from: d  reason: collision with root package name */
    public Points f80478d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f80479e;

    /* renamed from: f  reason: collision with root package name */
    public Subscriber f80480f;

    /* renamed from: g  reason: collision with root package name */
    public String f80481g = "usdt";

    /* renamed from: h  reason: collision with root package name */
    public String f80482h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f80483i = new h(this);

    /* renamed from: j  reason: collision with root package name */
    public MarketOverviewListener f80484j = new d();

    public class a extends EasySubscriber<List<SymbolPrice>> {
        public a() {
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

        public void onNext(List<SymbolPrice> list) {
            super.onNext(list);
            if (((e) PointsBuyPresenter.this.getUI()).isAlive() && !isUnsubscribed() && PointsBuyPresenter.this.f80477c != null) {
                Map unused = PointsBuyPresenter.this.f80476b = h2.t1().s1("usdt", LegalCurrencyConfigUtil.T());
                ((e) PointsBuyPresenter.this.getUI()).gd(PointsBuyPresenter.this.f80477c, PointsBuyPresenter.this.f80481g);
            }
        }
    }

    public class b implements Observable.Transformer<AliTokenStringStatusResponse<Points>, Points> {
        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(AliTokenStringStatusResponse aliTokenStringStatusResponse, Subscriber subscriber) {
            subscriber.onStart();
            if (aliTokenStringStatusResponse == null) {
                subscriber.onError(new NullResponseException());
            } else if (aliTokenStringStatusResponse.isSuccess()) {
                subscriber.onNext(aliTokenStringStatusResponse.getData());
                String unused = PointsBuyPresenter.this.f80482h = aliTokenStringStatusResponse.getToken();
                subscriber.onCompleted();
            } else {
                subscriber.onError(new APIStatusErrorException(aliTokenStringStatusResponse.getErrCode(), aliTokenStringStatusResponse.getErrMsg()));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Observable e(AliTokenStringStatusResponse aliTokenStringStatusResponse) {
            return Observable.create(new m(this, aliTokenStringStatusResponse));
        }

        /* renamed from: c */
        public Observable<Points> call(Observable<AliTokenStringStatusResponse<Points>> observable) {
            return observable.flatMap(new n(this));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            PointsBuyPresenter.this.getActivity().finish();
        }
    }

    public class d extends MarketOverviewListener {
        public d() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            if (PointsBuyPresenter.this.getUI() != null && ((e) PointsBuyPresenter.this.getUI()).isAlive()) {
                d0.a().d(marketOverviewResponse);
            }
        }
    }

    public interface e extends g {
        void Ad(PointsPack pointsPack);

        void B8(Points points);

        void gd(Map<String, String> map, String str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0() {
        q0(true);
    }

    public static /* synthetic */ Pair h0(Map map, Map map2) {
        return new Pair(map, map2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(Pair pair) {
        this.f80477c = (Map) pair.first;
        this.f80476b = h2.t1().s1("usdt", (Map) pair.second);
        ((e) getUI()).gd(this.f80477c, "usdt");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(Points points) {
        this.f80478d = points;
        ((e) getUI()).B8(points);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(Long l11) {
        HuobiToastUtil.s(R.string.points_buy_confirm_buy_success);
        i.b().g(new c(), 10);
    }

    public final Subscriber<List<SymbolPrice>> a0() {
        return new a();
    }

    public Map<String, String> b0() {
        return this.f80477c;
    }

    public String c0() {
        return this.f80481g;
    }

    public PointsPack d0() {
        return this.f80475a;
    }

    public Map<String, BigDecimal> f0() {
        return this.f80476b;
    }

    /* renamed from: l0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, e eVar) {
        super.onUIReady(baseCoreActivity, eVar);
        EventBus.d().p(this);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f80475a = (PointsPack) intent.getSerializableExtra("buy_points_pack");
            ((e) getUI()).Ad(this.f80475a);
        }
        h2 t12 = h2.t1();
        TradeType tradeType = TradeType.PRO;
        Observable.zip(t12.y3(tradeType, false).compose(RxJavaHelper.t((g) getUI())), LegalCurrencyConfigUtil.S(tradeType, false).compose(RxJavaHelper.t((g) getUI())), l.f55815b).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new iq.i(this)));
    }

    public void m0(Map<String, Object> map) {
        PointsDataSource.e(map).compose(new b()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new j(this)));
    }

    public void n0(Map<String, String> map) {
        Map<String, Object> b11 = MapParamsBuilder.c().b();
        if (map != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("platform", 1);
            hashMap.put(SettingsJsonConstants.SESSION_KEY, map.get("sessionID"));
            hashMap.put("token", this.f80482h);
            b11.put("afs", hashMap);
        }
        PointsDataSource.g(b11, this.f80478d.getId()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new k(this)));
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onPause() {
        super.onPause();
        x8.a.a().c(this.f80483i);
        this.f80479e = false;
        q0(false);
        Subscriber subscriber = this.f80480f;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void onResume() {
        super.onResume();
        if (r.x().F0()) {
            this.f80479e = true;
            x8.a.a().d(this.f80483i);
            q0(true);
            Subscriber subscriber = this.f80480f;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f80480f = a0();
            d0.a().c().compose(RxJavaHelper.t((g) getUI())).subscribe(this.f80480f);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        getActivity().startActivity(k0.h(getActivity()));
        getActivity().finish();
    }

    public void p0(String str) {
        this.f80481g = str;
    }

    public final void q0(boolean z11) {
        x8.a.a().e(z11, this.f80484j);
    }
}
