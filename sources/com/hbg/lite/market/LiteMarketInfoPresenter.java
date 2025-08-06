package com.hbg.lite.market;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;
import com.hbg.lib.network.otc.core.bean.LiteMarketBuyHint;
import com.hbg.lib.network.otc.core.bean.LiteMarketDetail;
import com.hbg.lib.network.otc.core.bean.LiteMarketPrice;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.network.php.core.bean.CurrencyIntro;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lite.market.bean.MarketDetailBean;
import com.hbg.lite.network.LiteRequestCallback1;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class LiteMarketInfoPresenter extends ActivityPresenter<h> {

    /* renamed from: t  reason: collision with root package name */
    public static final String[] f77213t = {"1h", "1day", "1week", "1mon", "1year"};

    /* renamed from: a  reason: collision with root package name */
    public s8.b f77214a;

    /* renamed from: b  reason: collision with root package name */
    public String f77215b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f77216c = new Handler();

    /* renamed from: d  reason: collision with root package name */
    public String f77217d;

    /* renamed from: e  reason: collision with root package name */
    public int f77218e = -1;

    /* renamed from: f  reason: collision with root package name */
    public OtcMarketCoinInfo.CoinInfo f77219f;

    /* renamed from: g  reason: collision with root package name */
    public int f77220g = -1;

    /* renamed from: h  reason: collision with root package name */
    public LiteMarketPrice f77221h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f77222i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f77223j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f77224k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f77225l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f77226m;

    /* renamed from: n  reason: collision with root package name */
    public d9.a<LiteMarketDetail> f77227n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f77228o = true;

    /* renamed from: p  reason: collision with root package name */
    public CurrencyIntro f77229p;

    /* renamed from: q  reason: collision with root package name */
    public d9.a<OtcMarketCoinInfo> f77230q;

    /* renamed from: r  reason: collision with root package name */
    public d9.a<CurrencyIntro> f77231r;

    /* renamed from: s  reason: collision with root package name */
    public String f77232s;

    public class a extends LiteRequestCallback1<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiteRequestCallback1 f77233a;

        public a(LiteRequestCallback1 liteRequestCallback1) {
            this.f77233a = liteRequestCallback1;
        }

        /* renamed from: b */
        public void onRequestSuccess(Integer num) {
            int unused = LiteMarketInfoPresenter.this.f77220g = num.intValue();
            if (this.f77233a != null) {
                ((h) LiteMarketInfoPresenter.this.getUI()).dismissProgressDialog();
                this.f77233a.onRequestSuccess(num);
            }
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            if (this.f77233a != null) {
                ((h) LiteMarketInfoPresenter.this.getUI()).dismissProgressDialog();
                this.f77233a.onRequestFailure(th2);
            }
        }
    }

    public class b extends LiteRequestCallback1<CurrencyIntro> {
        public b() {
        }

        /* renamed from: b */
        public void onRequestSuccess(CurrencyIntro currencyIntro) {
            CurrencyIntro unused = LiteMarketInfoPresenter.this.f77229p = currencyIntro;
            ((h) LiteMarketInfoPresenter.this.getUI()).wf(LiteMarketInfoPresenter.this.f77229p.getSummary());
            x9.d.m(1).t();
        }

        public void onRequestFailure(Throwable th2) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            LiteMarketInfoPresenter liteMarketInfoPresenter = LiteMarketInfoPresenter.this;
            liteMarketInfoPresenter.B0((h) liteMarketInfoPresenter.getUI(), true);
            if (!LiteMarketInfoPresenter.this.f77222i) {
                if (LiteMarketInfoPresenter.this.f77227n != null) {
                    LiteMarketInfoPresenter.this.f77227n.a();
                }
                LiteMarketInfoPresenter liteMarketInfoPresenter2 = LiteMarketInfoPresenter.this;
                liteMarketInfoPresenter2.A0((h) liteMarketInfoPresenter2.getUI());
            }
            if (LiteMarketInfoPresenter.this.f77219f == null) {
                if (LiteMarketInfoPresenter.this.f77230q != null) {
                    LiteMarketInfoPresenter.this.f77230q.a();
                }
                LiteMarketInfoPresenter.this.x0();
            }
            if (LiteMarketInfoPresenter.this.f77229p == null) {
                if (LiteMarketInfoPresenter.this.f77231r != null) {
                    LiteMarketInfoPresenter.this.f77231r.a();
                }
                LiteMarketInfoPresenter.this.y0();
            }
            LiteMarketInfoPresenter.this.f77216c.postDelayed(this, 5000);
        }
    }

    public class d extends LiteRequestCallback1<LiteMarketPrice> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f77237a;

        public d(h hVar) {
            this.f77237a = hVar;
        }

        /* renamed from: b */
        public void onRequestSuccess(LiteMarketPrice liteMarketPrice) {
            boolean unused = LiteMarketInfoPresenter.this.f77225l = false;
            LiteMarketInfoPresenter.this.u0();
            if (liteMarketPrice != null) {
                LiteMarketPrice unused2 = LiteMarketInfoPresenter.this.f77221h = liteMarketPrice;
                this.f77237a.D9(liteMarketPrice.getPrice(), liteMarketPrice.getChange(), !LiteMarketInfoPresenter.this.f77228o);
                boolean unused3 = LiteMarketInfoPresenter.this.f77228o = false;
                this.f77237a.bd(new MarketDetailBean(liteMarketPrice.getTime(), liteMarketPrice.getPrice()));
            }
        }

        public void onRequestFailure(Throwable th2) {
        }
    }

    public class e extends LiteRequestCallback1<LiteMarketDetail> {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<MarketDetailBean> f77239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f77240b;

        public e(h hVar) {
            this.f77240b = hVar;
        }

        /* renamed from: b */
        public void onRequestSuccess(LiteMarketDetail liteMarketDetail) {
            boolean unused = LiteMarketInfoPresenter.this.f77223j = false;
            LiteMarketInfoPresenter.this.u0();
            boolean unused2 = LiteMarketInfoPresenter.this.f77222i = true;
            this.f77240b.z9(this.f77239a);
        }

        /* renamed from: c */
        public LiteMarketDetail onRequestSuccessAsync(LiteMarketDetail liteMarketDetail) {
            this.f77239a = new ArrayList<>();
            for (LiteMarketDetail.Detail next : liteMarketDetail.getDetail()) {
                this.f77239a.add(new MarketDetailBean(next.getTime(), next.getPrice()));
            }
            return (LiteMarketDetail) super.onRequestSuccessAsync(liteMarketDetail);
        }

        public void onRequestFailure(Throwable th2) {
        }
    }

    public class f extends RequestCallback1<LiteMarketBuyHint> {
        public f() {
        }

        /* renamed from: a */
        public void onRequestSuccess(LiteMarketBuyHint liteMarketBuyHint) {
            if (liteMarketBuyHint != null) {
                String unused = LiteMarketInfoPresenter.this.f77232s = liteMarketBuyHint.getContent();
                ((h) LiteMarketInfoPresenter.this.getUI()).jd(LiteMarketInfoPresenter.this.f77232s);
            }
        }

        public void onRequestFailure(Throwable th2) {
        }
    }

    public class g extends LiteRequestCallback1<Integer> {
        public g() {
        }

        /* renamed from: b */
        public void onRequestSuccess(Integer num) {
            LiteMarketInfoPresenter.this.t0(num);
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
        }
    }

    public interface h extends u6.g {
        void D9(String str, String str2, boolean z11);

        void Fe(OtcMarketCoinInfo.CoinInfo coinInfo);

        void Nc();

        void Y7(TeachConfigItem teachConfigItem);

        void bd(MarketDetailBean marketDetailBean);

        void d7(OtcMarketCoinInfo.CoinInfo coinInfo);

        void jd(String str);

        void mc(boolean z11);

        void wf(String str);

        void x7();

        void z9(List<MarketDetailBean> list);
    }

    public final void A0(h hVar) {
        this.f77223j = true;
        u0();
        d9.a<LiteMarketDetail> marketDetail = this.f77214a.getMarketDetail(va.b.l(sa.a.c()), this.f77217d, this.f77215b);
        this.f77227n = marketDetail;
        marketDetail.d(new e(hVar));
    }

    public final void B0(h hVar, boolean z11) {
        i6.d.i("requestMarket#Price ...");
        if (!z11) {
            this.f77225l = true;
            u0();
        }
        this.f77214a.getMarketPrice(va.b.l(sa.a.c()), this.f77217d, this.f77215b).d(new d(hVar));
    }

    public final void C0() {
        if ("btc".equalsIgnoreCase(this.f77215b)) {
            ((h) getUI()).Y7(ra.c.c().m(3));
        }
    }

    public void D0(int i11) {
        this.f77218e = i11;
        this.f77217d = f77213t[i11];
        ((h) getUI()).showProgressDialog();
        A0((h) getUI());
        F0();
    }

    public void E0() {
        OtcMarketCoinInfo.CoinInfo coinInfo;
        ra.c.c().n("188", this.f77215b);
        if (!ra.c.c().C(getActivity(), (Intent) null, (Intent) null) || (coinInfo = this.f77219f) == null) {
            return;
        }
        if (coinInfo.getCoinId() == 2) {
            ((h) getUI()).mc(false);
        } else {
            ((h) getUI()).d7(this.f77219f);
        }
    }

    public final void F0() {
        B0((h) getUI(), false);
        this.f77216c.removeCallbacksAndMessages((Object) null);
        this.f77216c.postDelayed(new c(), 5000);
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        int i11 = this.f77218e;
        if (i11 >= 0 && this.f77226m) {
            this.f77226m = false;
            D0(i11);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        this.f77226m = true;
        this.f77216c.removeCallbacksAndMessages((Object) null);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(p6.a aVar) {
        if (getUI() != null && ((h) getUI()).isAlive()) {
            ra.c.b().e(getActivity(), (Intent) null, (Intent) null);
        }
    }

    public void p0() {
        ra.c.c().n("187", this.f77215b);
        if (ra.c.c().C(getActivity(), (Intent) null, (Intent) null)) {
            z0(new g());
        }
    }

    public OtcMarketCoinInfo.CoinInfo q0() {
        return this.f77219f;
    }

    public LiteMarketPrice r0() {
        return this.f77221h;
    }

    public String s0() {
        return this.f77215b;
    }

    public final void t0(Integer num) {
        if (this.f77219f != null) {
            if (num.intValue() != 1) {
                ((h) getUI()).mc(true);
            } else if (this.f77219f.getCoinId() == 2) {
                ((h) getUI()).mc(true);
            } else {
                ((h) getUI()).Fe(this.f77219f);
            }
        }
    }

    public final void u0() {
        if (this.f77225l || this.f77224k || this.f77223j) {
            ((h) getUI()).showProgressDialog();
        } else {
            ((h) getUI()).dismissProgressDialog();
        }
    }

    /* renamed from: v0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, h hVar) {
        super.onUIReady(baseCoreActivity, hVar);
        this.f77214a = s8.a.a();
        String stringExtra = getActivity().getIntent().getStringExtra("shortName");
        this.f77215b = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            getActivity().finish();
            return;
        }
        x9.d.m(1).r(9);
        x0();
        y0();
        C0();
        ((h) getUI()).Nc();
    }

    public void w0() {
        this.f77214a.getMarketBuyTips(sa.a.c()).d(new f());
    }

    public final void x0() {
    }

    public final void y0() {
        ((h) getUI()).x7();
        x9.d.m(1).s();
        d9.a<CurrencyIntro> c11 = v8.a.a().c(this.f77215b, AppLanguageHelper.getInstance().getCurAppLocale().toString().replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        this.f77231r = c11;
        c11.d(new b());
    }

    public final void z0(LiteRequestCallback1<Integer> liteRequestCallback1) {
        int i11 = this.f77220g;
        if (i11 >= 0) {
            if (liteRequestCallback1 != null) {
                liteRequestCallback1.onRequestSuccess(Integer.valueOf(i11));
            }
        } else if (ra.c.c().p()) {
            if (liteRequestCallback1 != null) {
                ((h) getUI()).showProgressDialog();
            }
            this.f77214a.p().d(new a(liteRequestCallback1));
        }
    }
}
