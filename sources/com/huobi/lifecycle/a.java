package com.huobi.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import bh.j;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.e;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.AdConfig;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.SecurityLinkStep2Activity;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.account.ui.UpdateOtcTradePwdActivity;
import com.huobi.activity.SplashAdActivity;
import com.huobi.activity.StartFlashActivity;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.finance.ui.UnifyWithdrawActivity;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.litere.main.ui.LiteReMainActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.ui.ChooseEnvironmentActivity;
import com.huobi.login.ui.NinePointSetActivity;
import com.huobi.login.ui.SecurityVerificationActivity;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.login.v2.ui.UserRegisterActivityV2;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.utils.d;
import com.huobi.utils.q0;
import com.iproov.sdk.bridge.OptionsBridge;
import d7.a1;
import i6.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import sn.l;
import tg.f;
import tg.r;

public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: n  reason: collision with root package name */
    public static final List<String> f74943n = Arrays.asList(new String[]{"com.huobi.index.ui.IndexFragment", "com.huobi.homemarket.ui.HomeMarketNewFragment", "com.huobi.trade.ui.TradeFragment", "com.huobi.feature.ui.FutureTradeFragment", "com.hbg.module.kline.ui.MarketInfoActivity"});

    /* renamed from: o  reason: collision with root package name */
    public static a f74944o = new a();

    /* renamed from: b  reason: collision with root package name */
    public long f74945b;

    /* renamed from: c  reason: collision with root package name */
    public long f74946c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74947d;

    /* renamed from: e  reason: collision with root package name */
    public long f74948e;

    /* renamed from: f  reason: collision with root package name */
    public int f74949f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74950g = false;

    /* renamed from: h  reason: collision with root package name */
    public AdConfig f74951h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74952i;

    /* renamed from: j  reason: collision with root package name */
    public long f74953j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f74954k = true;

    /* renamed from: l  reason: collision with root package name */
    public AdConfig.OpenScreenAdv f74955l = null;

    /* renamed from: m  reason: collision with root package name */
    public String f74956m = "";

    /* renamed from: com.huobi.lifecycle.a$a  reason: collision with other inner class name */
    public class C0802a implements d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f74957a;

        public C0802a(Activity activity) {
            this.f74957a = activity;
        }

        public void a() {
            l.p(this.f74957a);
        }

        public void b() {
            l.o(this.f74957a);
        }
    }

    public class b extends RequestCallback1<HbgIntCodeResponse<AdConfig>> {
        public b() {
        }

        /* renamed from: a */
        public void onRequestSuccess(HbgIntCodeResponse<AdConfig> hbgIntCodeResponse) {
            AdConfig unused = a.this.f74951h = hbgIntCodeResponse.getData();
            long unused2 = a.this.f74953j = hbgIntCodeResponse.getTs();
            a aVar = a.this;
            AdConfig.OpenScreenAdv unused3 = aVar.f74955l = aVar.h();
            a.this.p();
        }

        public void onRequestFailure(Throwable th2) {
            AdConfig.OpenScreenAdv unused = a.this.f74955l = null;
            super.onRequestFailure(th2);
        }
    }

    public class c implements e<Drawable> {
        public c() {
        }

        /* renamed from: a */
        public boolean onResourceReady(Drawable drawable, Object obj, g<Drawable> gVar, DataSource dataSource, boolean z11) {
            Log.d("SplashAdActivity", "ad-img-preload:onResourceReady---isFirstResource:" + z11);
            boolean unused = a.this.f74952i = true;
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, g<Drawable> gVar, boolean z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ad-img-preload:onLoadFailed---error:");
            sb2.append(glideException != null ? glideException.getMessage() : OptionsBridge.NULL_VALUE);
            sb2.append(" isFirstResource:");
            sb2.append(z11);
            Log.d("SplashAdActivity", sb2.toString());
            boolean unused = a.this.f74952i = false;
            return false;
        }
    }

    public static a j() {
        return f74944o;
    }

    public static /* synthetic */ int o(AdConfig.OpenScreenAdv openScreenAdv, AdConfig.OpenScreenAdv openScreenAdv2) {
        return openScreenAdv2.priority - openScreenAdv.priority;
    }

    public final AdConfig.OpenScreenAdv h() {
        if (this.f74951h == null) {
            return null;
        }
        r();
        Collections.sort(this.f74951h.openScreenAdvList, xm.a.f61656b);
        long j11 = this.f74953j;
        if (j11 == 0) {
            j11 = System.currentTimeMillis();
        }
        for (AdConfig.OpenScreenAdv next : this.f74951h.openScreenAdvList) {
            if (j11 < next.endTime && j11 > next.startTime) {
                int k11 = k(next.advId);
                int n11 = n();
                int i11 = this.f74951h.openScreenCommonConfig.count;
                if (k11 < i11 && n11 < i11) {
                    return next;
                }
            }
        }
        return null;
    }

    public AdConfig i() {
        return this.f74951h;
    }

    public int k(long j11) {
        return SP.e("show_count_" + j11, 0);
    }

    public int l() {
        return SP.e("key_show_date", -1);
    }

    public AdConfig.OpenScreenAdv m() {
        return this.f74955l;
    }

    public int n() {
        return SP.e("total_show_count", 0);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!r.x().F0()) {
            this.f74950g = true;
            d.b().c(new C0802a(activity), activity instanceof HuobiMainActivity);
        }
        ah.a.c().e(activity);
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f74946c = System.currentTimeMillis();
        f.h();
    }

    public void onActivityResumed(Activity activity) {
        JumpTarget jumpTarget;
        if (this.f74946c <= 0) {
            this.f74946c = System.currentTimeMillis();
        }
        long max = Math.max(System.currentTimeMillis() - this.f74946c, this.f74945b);
        this.f74945b = max;
        k.o("BackgroundStatusMonitor", AppUtil.b("onActivityResumed maxMills:", Long.valueOf(max), " lastMills:", Long.valueOf(this.f74946c)));
        if (r.x().F0() && this.f74945b > f.e()) {
            s();
            String name = activity.getClass().getName();
            k.o("BackgroundStatusMonitor", "activityClassName --" + name);
            if (activity instanceof HuobiMainActivity) {
                String name2 = ((HuobiMainActivity) activity).Lh().h0().getClass().getName();
                if (!f74943n.contains(name2)) {
                    rn.c.i().o(activity, (kn.a) null);
                    k.o("clear_token", "清理Token2");
                } else if (this.f74950g) {
                    this.f74950g = false;
                } else {
                    r.x().k();
                    k.o("clear_token", "清理Token0");
                }
                k.o("BackgroundStatusMonitor", "localClassName --" + name2);
            } else if (f74943n.contains(name)) {
                r.x().k();
                k.o("clear_token", "清理Token3");
            } else {
                if (LiteReHelper.a().b()) {
                    Intent intent = new Intent(activity, LiteReMainActivity.class);
                    jumpTarget = new JumpTarget(intent, intent);
                } else {
                    jumpTarget = null;
                }
                rn.c.i().o(activity, jumpTarget);
                k.o("clear_token", "清理Token4");
            }
            k.o("BackgroundStatusMonitor", "background timeout and go login");
        }
        if (this.f74946c != 0) {
            this.f74948e = System.currentTimeMillis() - this.f74946c;
        }
        if (this.f74948e > 10000) {
            LegalCurrencyConfigUtil.X(false).compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
            a1.v().Y(false, false).compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
            d7.k.C().U(false, (RequestCallback1<List<CurrencyBean>>) null);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.f74949f == 0) {
            if (!this.f74954k && !this.f74956m.equals("com.huobi.login.v2.ui.UserLoginActivityV2") && !this.f74956m.equals("com.huobi.lancher.guide.AppWelcomeActivityV4") && this.f74955l != null && this.f74952i) {
                SplashAdActivity.j(j.c().getApplicationContext());
            }
            if (!this.f74954k) {
                DomainSwitcher.A().V0();
            }
            this.f74954k = false;
            EventBus.d().k(new OnBackgroundStatusChangedEvent(OnBackgroundStatusChangedEvent.STATUS.FOREGROUND));
            is.a.a();
        }
        this.f74949f++;
        if (!gf.a.d()) {
            gf.a.e();
        }
        if (gf.a.j() && !(activity instanceof StartFlashActivity) && !(activity instanceof ChooseEnvironmentActivity)) {
            gf.a.o(false);
        }
        q0.d().g(activity);
    }

    public void onActivityStopped(Activity activity) {
        int i11 = this.f74949f - 1;
        this.f74949f = i11;
        if (i11 == 0) {
            k.o("BackgroundStatusMonitor", "switch to background.");
            ah.a.c().f();
            this.f74956m = activity.getClass().getName();
            if (!activity.getClass().getName().equals("com.huobi.login.v2.ui.UserLoginActivityV2") && !activity.getClass().getName().equals("com.huobi.lancher.guide.AppWelcomeActivityV4")) {
                q();
            }
            EventBus.d().k(new OnBackgroundStatusChangedEvent(OnBackgroundStatusChangedEvent.STATUS.BACKGROUND));
            if (!gf.a.j()) {
                qu.a.b();
            }
            if ((activity instanceof UserLoginActivityV2) || (activity instanceof UserRegisterActivityV2) || (activity instanceof NinePointSetActivity) || (activity instanceof SecurityVerificationActivity) || (activity instanceof UnifyDepositActivity) || (activity instanceof UnifyWithdrawActivity) || (activity instanceof UnifyTransferActivity) || (activity instanceof SecuritySetActivity) || (activity instanceof UpdateOtcTradePwdActivity) || (activity instanceof SecurityLinkStep2Activity)) {
                HuobiToastUtil.o(R.string.app_background_hint);
            }
        }
        is.a.x();
    }

    public final void p() {
        if (this.f74955l != null) {
            this.f74952i = false;
            ((com.bumptech.glide.c) com.bumptech.glide.a.v(j.c().getApplicationContext()).q(this.f74955l.imageUrl).h(DiskCacheStrategy.f63711c)).G0(new c()).P0();
        }
    }

    public void q() {
        v7.b.a().T(m0.a()).d(new b());
    }

    public final void r() {
        int l11 = l();
        long j11 = this.f74953j / Period.DAY_MILLS;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j11);
        sb2.append("");
        boolean z11 = (l11 == -1 || ((long) l11) == Long.parseLong(sb2.toString())) ? false : true;
        if (z11) {
            v(0);
        }
        for (AdConfig.OpenScreenAdv next : this.f74951h.openScreenAdvList) {
            if (z11) {
                t(next.advId, 0);
            }
        }
    }

    public void s() {
        this.f74945b = 0;
        this.f74947d = false;
    }

    public void t(long j11, int i11) {
        SP.q("show_count_" + j11, i11);
    }

    public void u() {
        long j11 = this.f74953j / Period.DAY_MILLS;
        SP.r("key_show_date", Long.parseLong(j11 + ""));
    }

    public void v(int i11) {
        SP.q("total_show_count", i11);
    }

    public void w() {
        this.f74947d = true;
        r.x().i();
    }
}
