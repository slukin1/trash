package com.huobi.quicktrade.trade.presenter;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.AssertsTradeData;
import com.hbg.lib.network.hbg.core.bean.CurrencyAsset;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.account.entity.AccountType;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.trade.bean.TradeRefreshEvent;
import com.huobi.trade.ui.ZoneReminderActivity;
import com.huobi.utils.SymbolUtil;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import d7.k;
import dt.h2;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import sq.u;
import tg.r;
import u6.g;
import uh.i;
import ut.o;

public class QuickTradeVerticalSpotPresenter extends QuickTradeVerticalBasePresenter<u> {

    /* renamed from: w  reason: collision with root package name */
    public Subscription f80598w;

    /* renamed from: x  reason: collision with root package name */
    public Subscription f80599x;

    public class a extends BaseSubscriber<List<SymbolBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f80600b;

        public a(boolean z11) {
            this.f80600b = z11;
        }

        public void onAfter() {
            super.onAfter();
            ((u) QuickTradeVerticalSpotPresenter.this.getUI()).y0(true);
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (a1.v().H(QuickTradeVerticalSpotPresenter.this.f80580k).contains(QuickTradeVerticalSpotPresenter.this.f80573d)) {
                if (((u) QuickTradeVerticalSpotPresenter.this.getUI()).isCanBeSeen()) {
                    a1 v11 = a1.v();
                    QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter = QuickTradeVerticalSpotPresenter.this;
                    ((u) QuickTradeVerticalSpotPresenter.this.getUI()).t(v11.J(quickTradeVerticalSpotPresenter.f80573d, quickTradeVerticalSpotPresenter.f80580k));
                }
                QuickTradeVerticalSpotPresenter.this.H0();
            } else {
                if (!a1.v().H(QuickTradeVerticalSpotPresenter.this.f80580k).isEmpty()) {
                    QuickTradeVerticalSpotPresenter.this.f80573d = a1.v().H(QuickTradeVerticalSpotPresenter.this.f80580k).get(0);
                }
                QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter2 = QuickTradeVerticalSpotPresenter.this;
                quickTradeVerticalSpotPresenter2.k0(quickTradeVerticalSpotPresenter2.f80573d);
            }
            if (this.f80600b) {
                QuickTradeVerticalSpotPresenter.this.y1();
            }
        }
    }

    public class b extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SymbolBean f80602b;

        public b(SymbolBean symbolBean) {
            this.f80602b = symbolBean;
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            i6.d.b((this.f80602b.getTradeOpenAt() - System.currentTimeMillis()) + "=====");
            if (this.f80602b.getTradeOpenAt() - System.currentTimeMillis() <= 0) {
                QuickTradeVerticalSpotPresenter.this.q1(false);
                QuickTradeVerticalSpotPresenter.this.z1();
            }
        }
    }

    public class c extends BaseSubscriber<List<SymbolBean>> {
        public c() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter = QuickTradeVerticalSpotPresenter.this;
            quickTradeVerticalSpotPresenter.k0(quickTradeVerticalSpotPresenter.f80573d);
        }
    }

    public class d implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80605b;

        public d(String str) {
            this.f80605b = str;
        }

        /* renamed from: a */
        public void call(Long l11) {
            if (i.d().g()) {
                QuickTradeVerticalSpotPresenter.this.x1(this.f80605b);
            } else {
                QuickTradeVerticalSpotPresenter.this.w1(this.f80605b);
            }
        }
    }

    public class e extends BaseSubscriber<List<AssertsTradeData>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80607b;

        public e(String str) {
            this.f80607b = str;
        }

        public void onNext(List<AssertsTradeData> list) {
            super.onNext(list);
            if (list != null && list.size() > 0) {
                QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter = QuickTradeVerticalSpotPresenter.this;
                quickTradeVerticalSpotPresenter.f80577h.f0(quickTradeVerticalSpotPresenter.f80580k, h2.t1().U0(list));
                String str = this.f80607b;
                QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter2 = QuickTradeVerticalSpotPresenter.this;
                ((u) QuickTradeVerticalSpotPresenter.this.getUI()).R2(str, quickTradeVerticalSpotPresenter2.f80577h.E(quickTradeVerticalSpotPresenter2.f80580k, str, quickTradeVerticalSpotPresenter2.z0()));
                QuickTradeVerticalSpotPresenter.this.f80582m = true;
            }
        }
    }

    public class f extends BaseSubscriber<CurrencyAsset> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80609b;

        public f(String str) {
            this.f80609b = str;
        }

        /* renamed from: a */
        public void onNext(CurrencyAsset currencyAsset) {
            Pair<String, String> O;
            Pair<String, String> O2;
            o.C().r(currencyAsset);
            String a11 = SymbolUtil.a(this.f80609b);
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(a11) && (O2 = o.C().O(a11)) != null && !TextUtils.isEmpty((CharSequence) O2.first)) {
                hashMap.put(a11, (String) O2.first);
            }
            String b11 = SymbolUtil.b(this.f80609b);
            if (!TextUtils.isEmpty(b11) && (O = o.C().O(b11)) != null && !TextUtils.isEmpty((CharSequence) O.first)) {
                hashMap.put(b11, (String) O.first);
            }
            if (QuickTradeVerticalSpotPresenter.this.f80577h != null && !hashMap.isEmpty()) {
                QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter = QuickTradeVerticalSpotPresenter.this;
                quickTradeVerticalSpotPresenter.f80577h.f0(quickTradeVerticalSpotPresenter.f80580k, hashMap);
            }
            String str = this.f80609b;
            QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter2 = QuickTradeVerticalSpotPresenter.this;
            ((u) QuickTradeVerticalSpotPresenter.this.getUI()).R2(str, quickTradeVerticalSpotPresenter2.f80577h.E(quickTradeVerticalSpotPresenter2.f80580k, str, quickTradeVerticalSpotPresenter2.z0()));
            QuickTradeVerticalSpotPresenter.this.f80582m = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean r1(List list) {
        String A = a1.v().A(this.f80573d);
        return Boolean.valueOf("innovation".equals(A) || "bifurcation".equals(A) || SymbolBean.POTENTIALS.equals(A) || "profession".equals(A));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable s1(List list) {
        String A = a1.v().A(this.f80573d);
        this.f80583n = "NEW_ZONE";
        A.hashCode();
        char c11 = 65535;
        switch (A.hashCode()) {
            case -1210261252:
                if (A.equals("profession")) {
                    c11 = 0;
                    break;
                }
                break;
            case -587971563:
                if (A.equals(SymbolBean.POTENTIALS)) {
                    c11 = 1;
                    break;
                }
                break;
            case -69405874:
                if (A.equals("bifurcation")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1225074021:
                if (A.equals("innovation")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f80583n = "PRO_ZONE";
                break;
            case 1:
                this.f80583n = "POTENTIALS";
                break;
            case 2:
                this.f80583n = "FORK_ZONE";
                break;
            case 3:
                this.f80583n = "NEW_ZONE";
                break;
        }
        return UserCenterRemoteDataSource.A().requestLicenseState(this.f80583n, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t1(TradeRiskReminder tradeRiskReminder) {
        if (B0()) {
            com.huobi.trade.helper.b.a().c(tradeRiskReminder.getState());
        } else if ("0".equals(tradeRiskReminder.getState())) {
            getActivity().startActivity(new Intent(getActivity(), ZoneReminderActivity.class).putExtra("zone_reminder_type", this.f80583n));
        }
    }

    public static /* synthetic */ Observable u1(String str, String str2, Long l11) {
        IHbgApi a11 = v7.b.a();
        long longValue = l11.longValue();
        return a11.getAssetsTrade(longValue, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2).b();
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    @h
    @Keep
    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((u) getUI()).isCanBeSeen()) {
            if (symbolChangeEvent.f() || !symbolChangeEvent.b().equals(this.f80573d)) {
                super.afterSymbolIdChanged(symbolChangeEvent);
                if (r.x().F0()) {
                    p1();
                }
                y1();
            }
        }
    }

    public void g0() {
        super.g0();
        Subscription subscription = this.f80598w;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        z1();
    }

    public void h0() {
        super.h0();
        boolean F0 = r.x().F0();
        q1(true);
        if (F0) {
            p1();
        }
        k.C().U(true, (RequestCallback1<List<CurrencyBean>>) null);
        x0(false, this.f80573d, true);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onErrorCodeEvent(mo.a aVar) {
        super.onErrorCodeEvent(aVar);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTradeRefresh(TradeRefreshEvent tradeRefreshEvent) {
        a1.v().Y(false, true).compose(RxJavaHelper.t((g) getUI())).subscribe(new c());
    }

    public final void p1() {
        if (!r.x().X()) {
            a1.v().Y(true, false).filter(new rq.e(this)).flatMap(new rq.f(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new rq.d(this)));
        }
    }

    public final void q1(boolean z11) {
        a1.v().Y(false, true).compose(RxJavaHelper.t((g) getUI())).subscribe(new a(z11));
    }

    /* renamed from: v1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, u uVar) {
        super.onUIReady(baseCoreActivity, uVar);
        this.f80586q = 0;
        EventBus.d().p(this);
    }

    public final void w1(String str) {
        if (z0()) {
            SymbolUtil.a(str);
        } else {
            SymbolUtil.b(str);
        }
        h2.t1().b1(this.f80580k, AccountType.spot.toString()).flatMap(new rq.g(SymbolUtil.a(str), SymbolUtil.b(str))).compose(RxJavaHelper.t((g) getUI())).subscribe(new e(str));
    }

    public void x0(boolean z11, String str, boolean z12) {
        if (r.x().F0()) {
            if (z12) {
                ((u) getUI()).b3();
            }
            if (this.f80577h.q(this.f80580k, str, z0())) {
                ((u) getUI()).R2(str, this.f80577h.E(this.f80580k, str, z0()));
                this.f80582m = true;
            }
            Subscription subscription = this.f80598w;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.f80598w = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new d(str)).subscribe(new BaseSubscriber());
        }
    }

    public final void x1(String str) {
        v7.b.a().A0(str).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new f(str));
    }

    public final void y1() {
        z1();
        SymbolBean J = a1.v().J(this.f80573d, this.f80580k);
        if (J != null && SymbolBean.PRE_ONLINE.equals(J.getState())) {
            if (J.getTradeOpenAt() - System.currentTimeMillis() > 0) {
                this.f80599x = Observable.interval(0, 1, TimeUnit.SECONDS).subscribe(new b(J));
            } else {
                q1(false);
            }
        }
    }

    public final void z1() {
        Subscription subscription = this.f80599x;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
