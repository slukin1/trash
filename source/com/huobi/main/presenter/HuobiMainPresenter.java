package com.huobi.main.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import bj.l0;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CommonFunc;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.core.webview.bean.AlertInfo;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.AssetDailyData;
import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import com.hbg.lib.network.hbg.core.bean.MarketRedData;
import com.hbg.lib.network.pro.core.bean.AssetModeBean;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.eventbus.HKPayOffEvent;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.ClosePathFloatView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.event.LogOutEvent;
import com.huobi.account.helper.UserLoginHelper;
import com.huobi.account.ui.AccountFragment;
import com.huobi.app.rms.HBRMSManager;
import com.huobi.app.rms.bean.HBRMSResourceDownloadMode;
import com.huobi.asset.event.ChangeVerticalSpotFromWhiteListEvent;
import com.huobi.asset.page.event.AccountConfigChangedEvent;
import com.huobi.asset2.index.AssetIndexFragmentNew;
import com.huobi.asset2.index.AssetIndexFragmentNew1;
import com.huobi.compliance.ComplianceUtil;
import com.huobi.contract.entity.ContractChangeEvent;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.coupon.handler.CouponExperienceRequestHelper;
import com.huobi.domain.DomainSwitcher;
import com.huobi.entity.UpdateResponse;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.feature.bean.FutureChangeEvent;
import com.huobi.feature.ui.FutureTradeFragment;
import com.huobi.feature.util.ContractCalmPeriodHelper;
import com.huobi.home.ui.HomeFragment;
import com.huobi.homemarket.ui.HomeMarketNewFragment;
import com.huobi.index.ui.IndexFragment;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.otc.widget.OtcOrderReminder;
import com.huobi.staring.helper.StaringRemindHelper;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.swap.bean.SwapChangeEvent;
import com.huobi.trade.ui.TradeFragment;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.UpgradeUtil;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.huobi.utils.x;
import cs.n;
import d7.a1;
import dt.i2;
import i6.m;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qh.p0;
import qk.k;
import rl.p;
import rx.subjects.BehaviorSubject;
import tg.r;
import v6.t;
import v6.u;
import vp.i0;

public class HuobiMainPresenter extends ActivityPresenter<j> {

    /* renamed from: j  reason: collision with root package name */
    public static String f77754j = "pro.huobi.pro";

    /* renamed from: a  reason: collision with root package name */
    public boolean f77755a = false;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f77756b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f77757c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f77758d = "";

    /* renamed from: e  reason: collision with root package name */
    public Double f77759e = null;

    /* renamed from: f  reason: collision with root package name */
    public TradeType f77760f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f77761g = new ao.c(this);

    /* renamed from: h  reason: collision with root package name */
    public boolean f77762h = false;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f77763i = ao.d.f12164b;

    public class a extends TimerTask {
        public a() {
        }

        public void run() {
            HBRMSManager.z().Q(HBRMSResourceDownloadMode.Idle);
            cancel();
        }
    }

    public class b implements e7.h {

        public class a implements u {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ WebView f77766b;

            public a(WebView webView) {
                this.f77766b = webView;
            }

            public void clearNeedLoginAction() {
            }

            public void dismissProgressDialog() {
            }

            public Activity getActivity() {
                return HuobiMainPresenter.this.getActivity();
            }

            public String getAvailableLocationY() {
                int[] iArr = new int[2];
                this.f77766b.getLocationOnScreen(iArr);
                i6.d.b("getAvailableLocationY-->" + iArr[1]);
                return String.valueOf(iArr[1]);
            }

            public String getDisplayHeight() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                return String.valueOf(displayMetrics.heightPixels);
            }

            public String getDisplayWidth() {
                return String.valueOf(ViewUtil.f(getActivity()));
            }

            public String getNavigatorHeight() {
                String str = getActivity().findViewById(R.id.main_tab).getHeight() + "";
                i6.d.b("getNavigatorHeight-->" + str);
                return str;
            }

            public String getTopHeight() {
                String str = (HuobiMainPresenter.this.getResources().getDimensionPixelOffset(R.dimen.top_bar_height) + ViewUtil.g()) + "";
                i6.d.b("getTopHeight-->" + str);
                return str;
            }

            public BehaviorSubject<Integer> getUIChangeSubject() {
                return ((HuobiMainActivity) getActivity()).getUIChangeSubject();
            }

            public WebView getWebView() {
                return this.f77766b;
            }

            public boolean isAlive() {
                return ((HuobiMainActivity) getActivity()).isAlive();
            }

            public boolean isCanBeSeen() {
                return ((HuobiMainActivity) getActivity()).isCanBeSeen();
            }

            public boolean isSupportBlankLabel() {
                return false;
            }

            public void setAlertDialogInfo(AlertInfo alertInfo) {
            }

            public void setHBWebViewLifecycleCallback(t tVar) {
            }

            public void setNeedLoginAction(boolean z11, boolean z12, JsMessage jsMessage) {
            }

            public void setProcess(int i11) {
            }

            public void setTitleText(CharSequence charSequence) {
            }

            public void setWebViewRefreshType(String str) {
            }

            public void showActionBarShare(boolean z11) {
            }

            public void showProgressDialog() {
            }

            public void showProgressDialog(boolean z11) {
            }

            public void showTopIcon(List<Map<String, String>> list) {
            }
        }

        public b() {
        }

        public boolean a() {
            return r.x().F0();
        }

        public void b(WebView webView) {
            webView.addJavascriptInterface(new x6.c(new a(webView)), "huobiNative");
        }

        public boolean c() {
            return AppUtil.e();
        }

        public int d() {
            View findViewById = getActivity().findViewById(R.id.main_tab);
            if (findViewById == null) {
                return PixelUtils.a(53.0f);
            }
            return findViewById.getHeight();
        }

        public void e(HashSet<String> hashSet) {
        }

        public FragmentActivity getActivity() {
            return HuobiMainPresenter.this.getActivity();
        }

        public String k(String str) {
            return a0.k(str);
        }
    }

    public class c implements ComplianceUtil.c {
        public c() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(HBDialogFragment hBDialogFragment) {
            HuobiMainPresenter.this.getActivity().finishAffinity();
        }

        public void a() {
        }

        public void onSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if ("76".equals(str) || "126".equals(str) || "168".equals(str) || "163".equals(str) || "42".equals(str)) {
                    DialogUtils.X(HuobiMainPresenter.this.getActivity(), HuobiMainPresenter.this.getString(R.string.warning), HuobiMainPresenter.this.getString(R.string.country_policy), (String) null, HuobiMainPresenter.this.getString(R.string.exit), new ao.e(this));
                }
                x.f(str);
            }
        }
    }

    public class d extends EasySubscriber<UpdateResponse> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f77769b;

        public d(boolean z11) {
            this.f77769b = z11;
        }

        /* renamed from: a */
        public void onNext(UpdateResponse updateResponse) {
            super.onNext(updateResponse);
            HuobiMainPresenter.this.J0(this.f77769b, updateResponse);
            ((j) HuobiMainPresenter.this.getUI()).Jc();
            boolean unused = HuobiMainPresenter.this.f77755a = false;
        }

        public void onError2(Throwable th2) {
            th2.printStackTrace();
            boolean unused = HuobiMainPresenter.this.f77755a = false;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            boolean unused = HuobiMainPresenter.this.f77755a = false;
        }
    }

    public class e extends BaseSubscriber<List<String>> {
        public e() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
        }
    }

    public class f extends BaseSubscriber<CommunityUserPermissions> {
        /* renamed from: a */
        public void onNext(CommunityUserPermissions communityUserPermissions) {
            super.onNext(communityUserPermissions);
            if (communityUserPermissions != null) {
                r.x().A0(communityUserPermissions.getIsSuper(), communityUserPermissions.getIsMute(), communityUserPermissions.getUidUnique());
                wf.a aVar = wf.a.f40622a;
                boolean z11 = false;
                aVar.i(communityUserPermissions.getIsPublish() == 1);
                aVar.k(communityUserPermissions.getPublishTips());
                if (communityUserPermissions.getIsLiveShare() == 1) {
                    z11 = true;
                }
                aVar.h(z11);
                aVar.j(communityUserPermissions.getPublishRedirectUrl());
            }
        }
    }

    public class g extends BaseSubscriber<String> {
    }

    public class h implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f77772b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HKPayOffEvent f77773c;

        public h(Activity activity, HKPayOffEvent hKPayOffEvent) {
            this.f77772b = activity;
            this.f77773c = hKPayOffEvent;
        }

        public static /* synthetic */ void b(HKPayOffEvent hKPayOffEvent, Activity activity, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            if (hKPayOffEvent.f70660a && !activity.getClass().equals(HuobiMainActivity.class)) {
                com.blankj.utilcode.util.a.g(k0.h(activity));
            }
        }

        public void run() {
            int i11;
            if (AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase().equals("zh-cn")) {
                i11 = R.drawable.hk_pay_off_zh_cn;
            } else {
                i11 = AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase().equals("zh-hk") ? R.drawable.hk_pay_off_zh_hk : R.drawable.hk_pay_off_en_us;
            }
            ImageView imageView = new ImageView(this.f77772b);
            imageView.setImageResource(i11);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(PixelUtils.a(300.0f), -2));
            FragmentActivity fragmentActivity = (FragmentActivity) this.f77772b;
            new DialogUtils.b.d(fragmentActivity).i1(4).I0(imageView).q0(false).P0(HuobiMainPresenter.this.getString(R.string.n_known)).Q0(new ao.f(this.f77773c, this.f77772b)).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }

    public static /* synthetic */ class i {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f77775a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent[] r0 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f77775a = r0
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_WIFI_CONNECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f77775a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_MOBILE_CONNECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f77775a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_NET_VPN_CONNECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.presenter.HuobiMainPresenter.i.<clinit>():void");
        }
    }

    public interface j extends u6.g {
        void Gb();

        void Hd(String str, String str2);

        void Jc();

        void Pe(boolean z11);

        void V5(int i11);

        void ag();

        void k4();

        void k5(UpdateResponse updateResponse);

        void k6(boolean z11);

        void ka(boolean z11);

        void l4();

        void q9(boolean z11);

        void s4();

        boolean t9();

        void vg(String str);

        void x8(int i11);

        void zf(String str, boolean z11, String str2, String str3);
    }

    public static void j0() {
        v7.b.a().getCommunityUserPermissions().b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new f());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0() {
        ComplianceUtil.d(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0() {
        ((j) getUI()).s4();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0() {
        if (getActivity() != null && ((j) getUI()).isAlive()) {
            getActivity().runOnUiThread(new ao.b(this));
        }
    }

    public static void w0() {
        v7.b.a().Q(m6.a.f()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new g());
    }

    public void A0(Intent intent) {
        if (((j) getUI()).t9()) {
            k0.G("pro.huobi.contract");
            TradeType tradeType = TradeType.CONTRACT;
            k0.E(tradeType);
            k0.D(tradeType);
            ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (contractCurrencyInfo != null) {
                ContractUserInfoProvider.i().x(contractCurrencyInfo);
            }
            ((j) getUI()).V5(R.id.main_contract_tab);
            B0(FutureTradeFragment.class, extras);
        }
    }

    public final void B0(Class cls, Bundle bundle) {
        NightHelper.e().d(getActivity());
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction q11 = supportFragmentManager.q();
        if (supportFragmentManager.B0() != null) {
            for (Fragment next : supportFragmentManager.B0()) {
                if (next != null && !(next instanceof DialogFragment)) {
                    q11.q(next);
                }
            }
        }
        String name = cls.getName();
        Fragment instanceFragment = getActivity().instanceFragment(cls.getName(), bundle, cls.getName());
        if (!instanceFragment.isAdded()) {
            q11.c(R.id.tab_content, instanceFragment, name);
        }
        t0(this.f77756b, cls);
        this.f77756b = instanceFragment;
        q11.A(instanceFragment).k();
    }

    public void C0(Bundle bundle) {
        k0.G("pro.huobi.home");
        f77754j = "pro.huobi.home";
        ((j) getUI()).V5(R.id.main_home_tab);
        if (HomeHelper.j()) {
            B0(HomeFragment.class, bundle);
            ((j) getUI()).k4();
        } else {
            B0(IndexFragment.class, bundle);
        }
        d0(true);
    }

    public void D0(Intent intent) {
        if (((j) getUI()).t9()) {
            k0.G("pro.huobi.linearswap");
            k0.E(TradeType.LINEAR_SWAP);
            FutureContractInfo futureContractInfo = (FutureContractInfo) intent.getSerializableExtra("linear_swap_currency_info");
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (futureContractInfo != null) {
                k.j(futureContractInfo);
            }
            ((j) getUI()).V5(R.id.main_contract_tab);
            B0(FutureTradeFragment.class, extras);
        }
    }

    public void E0(Intent intent) {
        k0.G("pro.huobi.margin");
        TradeType tradeType = TradeType.MARGIN;
        k0.H(tradeType);
        k0.F(tradeType);
        f77754j = "pro.huobi.margin";
        this.f77760f = tradeType;
        m0();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("key_trade_type", tradeType.name());
        com.huobi.trade.helper.j.b(intent.getBooleanExtra("change_trend_to_default", false));
        if (intent.hasExtra("trade_driection")) {
            com.huobi.trade.helper.d.d(tradeType, intent.getBooleanExtra("trade_driection", true));
        }
        ((j) getUI()).V5(R.id.main_cc_tab);
        B0(TradeFragment.class, extras);
        com.hbg.lib.core.util.b.c().g(0);
    }

    public void F0(Bundle bundle) {
        k0.G("pro.huobi.markets");
        ((j) getUI()).V5(R.id.main_market_tab);
        B0(HomeMarketNewFragment.class, bundle);
        we.c.w();
    }

    public void G0(Bundle bundle) {
        jp.k0.l(getActivity(), bundle);
    }

    public void H0(Intent intent) {
        k0.G("pro.huobi.supermargin");
        TradeType tradeType = TradeType.SUPERMARGIN;
        k0.H(tradeType);
        k0.F(tradeType);
        f77754j = "pro.huobi.supermargin";
        this.f77760f = tradeType;
        m0();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("key_trade_type", tradeType.name());
        com.huobi.trade.helper.j.b(intent.getBooleanExtra("change_trend_to_default", false));
        if (intent.hasExtra("trade_driection")) {
            com.huobi.trade.helper.d.d(tradeType, intent.getBooleanExtra("trade_driection", true));
        }
        ((j) getUI()).V5(R.id.main_cc_tab);
        B0(TradeFragment.class, extras);
        com.hbg.lib.core.util.b.c().g(1);
    }

    public void I0(Intent intent) {
        if (((j) getUI()).t9()) {
            k0.G("pro.huobi.swap");
            TradeType tradeType = TradeType.SWAP;
            k0.E(tradeType);
            k0.D(tradeType);
            SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) intent.getSerializableExtra("swap_currency_info");
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (swapCurrencyInfo != null) {
                ContractUserInfoProvider.i().y(swapCurrencyInfo);
            }
            ((j) getUI()).V5(R.id.main_contract_tab);
            B0(FutureTradeFragment.class, extras);
        }
    }

    public final void J0(boolean z11, UpdateResponse updateResponse) {
        this.f77757c = updateResponse.getMsgtype();
        this.f77758d = updateResponse.getActionurl();
        String downloadurl = updateResponse.getDownloadurl();
        String title = updateResponse.getTitle();
        String content = updateResponse.getContent();
        String notice_title = updateResponse.getNotice_title();
        String notice_content = updateResponse.getNotice_content();
        boolean z12 = false;
        if (updateResponse.getVersion_code() <= 105400) {
            UpgradeUtil.d((String) null);
            SP.u("user_config", "config_app_upgrade_count", 0);
        } else {
            UpgradeUtil.d(downloadurl);
            if (!(updateResponse.getMd5() == null || updateResponse.getDirect_downloadurl() == null)) {
                eh.h.q().k(updateResponse);
            }
        }
        if (updateResponse.getService_check() > 0) {
            ((j) getUI()).Hd(notice_title, notice_content);
        } else if (z11) {
            i6.d.c("UPGRADE", "silent true 不弹窗");
        } else {
            ((j) getUI()).Pe(UpgradeUtil.c());
            if (b0(z11, updateResponse)) {
                i6.d.c("UPGRADE", "校验完成，可以弹窗");
                if (!"upgrade".equals(this.f77757c)) {
                    j jVar = (j) getUI();
                    String str = this.f77757c;
                    if (updateResponse.getForce_upgrade() == 1) {
                        z12 = true;
                    }
                    jVar.zf(str, z12, title, content);
                    i6.d.c("UPGRADE", "showUpgradetipsDialog2");
                } else if (!UpgradeUtil.c()) {
                    i6.d.c("UPGRADE", "hasNewVersion false 不弹窗");
                } else if (updateResponse.getMd5() == null || updateResponse.getDirect_downloadurl() == null) {
                    j jVar2 = (j) getUI();
                    String str2 = this.f77757c;
                    if (updateResponse.getForce_upgrade() == 1) {
                        z12 = true;
                    }
                    jVar2.zf(str2, z12, title, content);
                    i6.d.c("UPGRADE", "showUpgradetipsDialog1");
                } else {
                    eh.h.q().k(updateResponse);
                    ((j) getUI()).k5(updateResponse);
                    i6.d.c("UPGRADE", "showUpgradeTipsDialogNewStyle");
                }
            }
        }
    }

    public void K0(String str, TradeType tradeType) {
        k0.H(tradeType);
        f77754j = k0.w();
        this.f77760f = tradeType;
        String d11 = i2.a().d(tradeType);
        i2.a().h(tradeType, str);
        m0();
        boolean p02 = a1.v().p0(str);
        if (p02 != a1.v().p0(d11)) {
            EventBus.d().k(new lk.a(p02));
            return;
        }
        SymbolChangeEvent symbolChangeEvent = new SymbolChangeEvent();
        symbolChangeEvent.g(str);
        symbolChangeEvent.i(d11);
        symbolChangeEvent.j(tradeType);
        EventBus.d().k(symbolChangeEvent);
    }

    public void L0(SwapCurrencyInfo swapCurrencyInfo, TradeType tradeType) {
        if (k0.g() == TradeType.CONTRACT) {
            BaseCoreActivity activity = getActivity();
            boolean z11 = activity != null && (activity instanceof HuobiMainActivity);
            Intent v11 = k0.v(activity, z11);
            if (!z11) {
                v11.addFlags(67108864);
                if (swapCurrencyInfo != null) {
                    ContractUserInfoProvider.i().y(swapCurrencyInfo);
                }
            } else {
                v11.putExtra("swap_currency_info", swapCurrencyInfo);
            }
            activity.startActivity(v11);
            activity.overridePendingTransition(0, 0);
            return;
        }
        Bundle bundle = null;
        if (getActivity().getIntent() != null) {
            bundle = getActivity().getIntent().getExtras();
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putSerializable("swap_currency_info", swapCurrencyInfo);
        SwapChangeEvent swapChangeEvent = new SwapChangeEvent();
        swapChangeEvent.setInfo(swapCurrencyInfo);
        EventBus.d().k(swapChangeEvent);
    }

    public void M0() {
        i6.i.b().f(this.f77763i);
    }

    public void a0() {
        HBRMSManager.z().C();
        HBRMSManager.z().Q(HBRMSResourceDownloadMode.Async);
        AppUtil.f();
        if (NetworkStatus.c(getActivity())) {
            c0();
            d0(false);
            if (o.h()) {
                ContractCurrencyUtils.f(true, "0").compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
            }
            StaringRemindHelper.n();
            n.v();
            i6.i.b().g(this.f77761g, 1000);
            os.c.q();
            qj.a.a();
            tg.f.a();
            com.huobi.lifecycle.a.j().q();
            HbgDialogManager.A().E(new b());
        } else if (!NightHelper.e().f() && !AppLanguageHelper.getInstance().isChangeLanguage()) {
            boolean z11 = ll.a.f76233a;
        }
    }

    public final boolean b0(boolean z11, UpdateResponse updateResponse) {
        if (!this.f77762h) {
            i6.d.c("UPGRADE", "不在首页，不弹窗");
            return false;
        } else if (updateResponse.getIs_popup() <= 0) {
            i6.d.c("UPGRADE", "getIs_popup不弹窗：" + updateResponse.getIs_popup());
            return false;
        } else {
            if (updateResponse.getForce_upgrade() == 1) {
                i6.d.c("UPGRADE", "强制更新弹窗");
                return true;
            }
            long w11 = DateTimeUtils.w();
            if (w11 - ((long) ConfigPreferences.g("user_config", "config_app_upgrade_time", 0)) < 86400) {
                i6.d.c("UPGRADE", "一天一次，不弹窗");
                return false;
            }
            ConfigPreferences.l("user_config", "config_app_upgrade_time", w11);
            int f11 = SP.f("user_config", "config_app_upgrade_count", 0);
            if (f11 >= updateResponse.getTip_count_sum()) {
                i6.d.c("UPGRADE", "getTip_count_sum，不弹窗:" + updateResponse.getTip_count_sum());
                return false;
            }
            SP.u("user_config", "config_app_upgrade_count", f11 + 1);
            return true;
        }
    }

    public final void c0() {
        ComplianceUtil.g(new c());
    }

    @k20.h
    @Keep
    public void changeAssetMode(AssetModeBean assetModeBean) {
        if (assetModeBean.isSuccess.booleanValue()) {
            if (assetModeBean.isUnion.booleanValue()) {
                l0.v().Z();
            }
            l0.w().X(assetModeBean.isUnion.booleanValue());
        }
    }

    public void d0(boolean z11) {
        if (!this.f77755a) {
            this.f77755a = true;
            v0(z11);
        }
    }

    public void f0(ContractCurrencyInfo contractCurrencyInfo, TradeType tradeType) {
        if (k0.g() == TradeType.SWAP) {
            BaseCoreActivity activity = getActivity();
            boolean z11 = activity != null && (activity instanceof HuobiMainActivity);
            Intent d11 = k0.d(activity, z11);
            if (!z11) {
                d11.addFlags(67108864);
            }
            d11.putExtra("contract_currency_info", contractCurrencyInfo);
            if (contractCurrencyInfo != null) {
                ContractUserInfoProvider.i().x(contractCurrencyInfo);
            }
            activity.startActivity(d11);
            activity.overridePendingTransition(0, 0);
            return;
        }
        Bundle bundle = null;
        if (getActivity().getIntent() != null) {
            bundle = getActivity().getIntent().getExtras();
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putSerializable("contract_currency_info", contractCurrencyInfo);
        ContractChangeEvent contractChangeEvent = new ContractChangeEvent();
        contractChangeEvent.setInfo(contractCurrencyInfo);
        EventBus.d().k(contractChangeEvent);
    }

    public void g0() {
        sn.t.s(false, getActivity()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
    }

    public Fragment h0() {
        return this.f77756b;
    }

    public TradeType i0() {
        return this.f77760f;
    }

    public void k0(String str) {
        if (!"upgrade".equals(str)) {
            String str2 = this.f77758d;
            if (str2 != null && !str2.equals("")) {
                CommonFunc.a(getActivity(), this.f77758d);
            }
        } else if (UpgradeUtil.c()) {
            CommonFunc.a(getActivity(), UpgradeUtil.a());
            System.exit(0);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c6, code lost:
        if (r1.equals("pro.huobi.otc") == false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l0(android.content.Intent r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0019
            android.os.Bundle r1 = r5.getExtras()
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = "flag_exit"
            boolean r1 = r5.getBooleanExtra(r1, r0)
            if (r1 == 0) goto L_0x0019
            com.hbg.lib.common.ui.BaseCoreActivity r5 = r4.getActivity()
            com.huobi.login.controller.KillProcessProxy.d(r5)
            return
        L_0x0019:
            if (r5 != 0) goto L_0x0025
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r4.C0(r5)
            goto L_0x016c
        L_0x0025:
            java.lang.String r1 = "navigator_action"
            java.lang.String r1 = r5.getStringExtra(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x003a
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r4.C0(r5)
            return
        L_0x003a:
            com.huobi.utils.HBHTtoHTXManager r2 = com.huobi.utils.HBHTtoHTXManager.f83692a
            r2.c()
            r1.hashCode()
            r2 = -1
            int r3 = r1.hashCode()
            switch(r3) {
                case -1922185608: goto L_0x00c0;
                case -1922184697: goto L_0x00b5;
                case -1913891426: goto L_0x00aa;
                case -1387036168: goto L_0x009f;
                case -95394681: goto L_0x0094;
                case 541575365: goto L_0x0089;
                case 541910393: goto L_0x007e;
                case 742738230: goto L_0x0073;
                case 893253652: goto L_0x0067;
                case 1469794883: goto L_0x005a;
                case 1921175057: goto L_0x004d;
                default: goto L_0x004a;
            }
        L_0x004a:
            r0 = r2
            goto L_0x00c9
        L_0x004d:
            java.lang.String r0 = "pro.huobi.markets"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0056
            goto L_0x004a
        L_0x0056:
            r0 = 10
            goto L_0x00c9
        L_0x005a:
            java.lang.String r0 = "pro.huobi.supermargin"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0063
            goto L_0x004a
        L_0x0063:
            r0 = 9
            goto L_0x00c9
        L_0x0067:
            java.lang.String r0 = "pro.huobi.margin"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0070
            goto L_0x004a
        L_0x0070:
            r0 = 8
            goto L_0x00c9
        L_0x0073:
            java.lang.String r0 = "pro.huobi.balance"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x007c
            goto L_0x004a
        L_0x007c:
            r0 = 7
            goto L_0x00c9
        L_0x007e:
            java.lang.String r0 = "pro.huobi.swap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0087
            goto L_0x004a
        L_0x0087:
            r0 = 6
            goto L_0x00c9
        L_0x0089:
            java.lang.String r0 = "pro.huobi.home"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0092
            goto L_0x004a
        L_0x0092:
            r0 = 5
            goto L_0x00c9
        L_0x0094:
            java.lang.String r0 = "pro.huobi.account"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x009d
            goto L_0x004a
        L_0x009d:
            r0 = 4
            goto L_0x00c9
        L_0x009f:
            java.lang.String r0 = "pro.huobi.contract"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00a8
            goto L_0x004a
        L_0x00a8:
            r0 = 3
            goto L_0x00c9
        L_0x00aa:
            java.lang.String r0 = "pro.huobi.linearswap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x004a
        L_0x00b3:
            r0 = 2
            goto L_0x00c9
        L_0x00b5:
            java.lang.String r0 = "pro.huobi.pro"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00be
            goto L_0x004a
        L_0x00be:
            r0 = 1
            goto L_0x00c9
        L_0x00c0:
            java.lang.String r3 = "pro.huobi.otc"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00c9
            goto L_0x004a
        L_0x00c9:
            java.lang.String r1 = "symbolId"
            switch(r0) {
                case 0: goto L_0x0165;
                case 1: goto L_0x014a;
                case 2: goto L_0x0146;
                case 3: goto L_0x0142;
                case 4: goto L_0x013a;
                case 5: goto L_0x0132;
                case 6: goto L_0x012e;
                case 7: goto L_0x0126;
                case 8: goto L_0x0100;
                case 9: goto L_0x00d9;
                case 10: goto L_0x00d0;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            goto L_0x016c
        L_0x00d0:
            android.os.Bundle r5 = r5.getExtras()
            r4.F0(r5)
            goto L_0x016c
        L_0x00d9:
            gj.d r0 = gj.d.n()
            boolean r0 = r0.G()
            if (r0 != 0) goto L_0x00e4
            return
        L_0x00e4:
            java.lang.String r0 = r5.getStringExtra(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00fb
            dt.i2 r0 = dt.i2.a()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN
            java.lang.String r1 = r5.getStringExtra(r1)
            r0.h(r2, r1)
        L_0x00fb:
            r4.H0(r5)
            goto L_0x016c
        L_0x0100:
            gj.d r0 = gj.d.n()
            boolean r0 = r0.G()
            if (r0 != 0) goto L_0x010b
            return
        L_0x010b:
            java.lang.String r0 = r5.getStringExtra(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0122
            dt.i2 r0 = dt.i2.a()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.MARGIN
            java.lang.String r1 = r5.getStringExtra(r1)
            r0.h(r2, r1)
        L_0x0122:
            r4.E0(r5)
            goto L_0x016c
        L_0x0126:
            android.os.Bundle r5 = r5.getExtras()
            r4.y0(r5)
            goto L_0x016c
        L_0x012e:
            r4.I0(r5)
            goto L_0x016c
        L_0x0132:
            android.os.Bundle r5 = r5.getExtras()
            r4.C0(r5)
            goto L_0x016c
        L_0x013a:
            android.os.Bundle r5 = r5.getExtras()
            r4.x0(r5)
            goto L_0x016c
        L_0x0142:
            r4.A0(r5)
            goto L_0x016c
        L_0x0146:
            r4.D0(r5)
            goto L_0x016c
        L_0x014a:
            java.lang.String r0 = r5.getStringExtra(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0161
            dt.i2 r0 = dt.i2.a()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r1 = r5.getStringExtra(r1)
            r0.h(r2, r1)
        L_0x0161:
            r4.z0(r5)
            goto L_0x016c
        L_0x0165:
            android.os.Bundle r5 = r5.getExtras()
            r4.G0(r5)
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.presenter.HuobiMainPresenter.l0(android.content.Intent):void");
    }

    public final void m0() {
        String d11 = i2.a().d(this.f77760f);
        if (TextUtils.isEmpty(d11)) {
            List<SymbolBean> Z = a1.v().Z(this.f77760f);
            d11 = (Z == null || Z.isEmpty()) ? "" : Z.get(0).getSymbol();
        }
        i2.a().h(this.f77760f, d11);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAccountConfigChanged(AccountConfigChangedEvent accountConfigChangedEvent) {
        Fragment fragment;
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        if (hh.f.h().l()) {
            fragment = supportFragmentManager.m0(AssetIndexFragmentNew1.class.getName());
        } else {
            fragment = supportFragmentManager.m0(AssetIndexFragmentNew.class.getName());
        }
        FragmentTransaction q11 = supportFragmentManager.q();
        q11.s(fragment);
        q11.m();
        y0((Bundle) null);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAssertDialyUpdate(AssetDailyData assetDailyData) {
        ((j) getUI()).ag();
        ((j) getUI()).k6(assetDailyData.displayGuideDot() && f77754j != "pro.huobi.balance");
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractRedUpdate(CouponExperienceRequestHelper couponExperienceRequestHelper) {
        ((j) getUI()).q9(couponExperienceRequestHelper.mContractTabRedVisible);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
        i6.i.b().h(this.f77761g);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onEvent(LogOutEvent logOutEvent) {
        ((j) getUI()).x8(0);
        EventBus.d().k(new ChangeVerticalSpotFromWhiteListEvent());
        p.e().i(getActivity());
        we.b.l("home_feed_refresh", Integer.class).g(1);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onHKPayOffAlert(HKPayOffEvent hKPayOffEvent) {
        Log.d("hk_pay_off", "香港清退");
        Activity l11 = rd.a.m().l();
        l11.runOnUiThread(new h(l11, hKPayOffEvent));
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onMarketRedUpdate(MarketRedData marketRedData) {
        ((j) getUI()).ka(marketRedData.displayTabRed());
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onNightModeChanged(NightHelper.NightEvent nightEvent) {
        getActivity().recreate();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        String str = proTokenUpdate.proToken;
        l0.v().K(str);
        l0.w().K(str);
        l0.y().K(str);
        l0.t().K(str);
        i6.d.d("onProTokenUpdate proToken:" + str + " getUI():" + getUI());
        if (!TextUtils.isEmpty(str)) {
            jo.a.e().f();
            HbgDialogManager.A().P();
            j0();
            w0();
            uh.i.d().l();
            uh.i.d().m();
            p.e().i(getActivity());
            p0.n().x();
            dn.d.f().o(true);
        } else {
            wf.a aVar = wf.a.f40622a;
            aVar.h(false);
            aVar.i(false);
            aVar.k((String) null);
            aVar.j((String) null);
        }
        CouponExperienceRequestHelper.getInstance().onProTokenUpdate(str);
        ContractCalmPeriodHelper.g(str);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            String string = bundle.getString("last_trade_type");
            if (!TextUtils.isEmpty(string)) {
                this.f77760f = TradeType.valueOf(string);
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (!UserLoginHelper.e().i() || !sn.f.d(getActivity(), (kn.a) null)) {
            ui.d.m(getActivity(), (u6.g) getUI());
            CouponExperienceRequestHelper.getInstance().checkContractTabGuide();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        TradeType tradeType;
        super.onSaveInstanceState(bundle);
        if (bundle != null && (tradeType = this.f77760f) != null) {
            bundle.putString("last_trade_type", tradeType.toString());
        }
    }

    public void onStart() {
        super.onStart();
        this.f77762h = true;
        if (!ConfigPreferences.b("user_config", "is_first_use")) {
            ConfigPreferences.n("user_config", "is_first_use", true);
        }
        GrowingIOStatics.i();
        HbgDialogManager.A().R();
    }

    public void onStop() {
        this.f77762h = false;
        super.onStop();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        ClosePathFloatView.g((String) null, getActivity(), false);
    }

    public void s0(FutureContractInfo futureContractInfo, TradeType tradeType) {
        Bundle extras = getActivity().getIntent() != null ? getActivity().getIntent().getExtras() : null;
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putSerializable("linear_swap_currency_info", futureContractInfo);
        FutureChangeEvent futureChangeEvent = new FutureChangeEvent();
        futureChangeEvent.setInfo(futureContractInfo);
        EventBus.d().k(futureChangeEvent);
    }

    public final void t0(Fragment fragment, Class cls) {
        Class<i0> cls2 = i0.class;
        if (!cls2.isAssignableFrom(cls)) {
            OtcOrderReminder.e().d(getActivity());
        } else if (fragment == null || !cls2.isAssignableFrom(fragment.getClass())) {
            OtcOrderReminder.e().c(getActivity());
        }
    }

    /* renamed from: u0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, j jVar) {
        super.onUIReady(baseCoreActivity, jVar);
        EventBus.d().p(this);
        a0();
        if (!HomeHelper.j() && (NightHelper.e().f() || AppLanguageHelper.getInstance().isChangeLanguage() || ll.a.f76233a)) {
            boolean z11 = false;
            NightHelper.e().j(false);
            AppLanguageHelper.getInstance().setChangeLanguage(false);
            ll.a.f76233a = false;
            x0((Bundle) null);
            j jVar2 = (j) getUI();
            if (p0.n().k().displayGuideDot() && f77754j != "pro.huobi.balance") {
                z11 = true;
            }
            jVar2.k6(z11);
        } else if (getActivity() instanceof HuobiMainActivity) {
            l0(getActivity().getIntent());
        }
        com.huobi.main.helper.f.c().n(new ao.a(this));
        new Timer().schedule(new a(), 5000);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    public void updateAssetProfitRate(Double d11) {
        if (d11 != null) {
            if (this.f77759e == null) {
                this.f77759e = d11;
            } else if (m.a(String.valueOf(Math.abs(d11.doubleValue() - this.f77759e.doubleValue()))).compareTo(m.a("0.05")) >= 0) {
                this.f77759e = d11;
                if (Math.abs(d11.doubleValue()) < 1.0d) {
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    decimalFormat.setRoundingMode(RoundingMode.FLOOR);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(d11.doubleValue() > 0.0d ? "+" : "");
                    sb2.append(decimalFormat.format(d11.doubleValue() * 100.0d));
                    sb2.append("%");
                    ((j) getUI()).vg(sb2.toString());
                    return;
                }
                ((j) getUI()).vg(d11.doubleValue() > 0.0d ? "≧100%" : "≦-100%");
            }
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateRemoteDomainFile(NetworkStatus.ConnectEvent connectEvent) {
        if (DomainSwitcher.A().V() == null || DomainSwitcher.A().V().switch_network == 1) {
            int i11 = i.f77775a[connectEvent.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                LogAndWoodRecorder.a("DOMAIN_TEST", "网络切换更新domain:" + connectEvent.name());
                M0();
            }
        }
    }

    public final void v0(boolean z11) {
        eh.h.B().compose(RxJavaHelper.t((u6.g) null)).subscribe(new d(z11));
    }

    public void x0(Bundle bundle) {
        k0.G("pro.huobi.account");
        f77754j = "pro.huobi.account";
        ((j) getUI()).V5(R.id.main_account_tab);
        B0(AccountFragment.class, bundle);
    }

    public void y0(Bundle bundle) {
        k0.G("pro.huobi.balance");
        f77754j = "pro.huobi.balance";
        ((j) getUI()).V5(R.id.main_balance_tab);
        ((j) getUI()).Gb();
        ((j) getUI()).l4();
        ((j) getUI()).k6(false);
        if (hh.f.h().l()) {
            B0(AssetIndexFragmentNew1.class, bundle);
        } else {
            B0(AssetIndexFragmentNew.class, bundle);
        }
        gi.a.d();
    }

    public void z0(Intent intent) {
        k0.G("pro.huobi.pro");
        TradeType tradeType = TradeType.PRO;
        k0.H(tradeType);
        f77754j = "pro.huobi.pro";
        this.f77760f = tradeType;
        m0();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("key_trade_type", this.f77760f.name());
        com.huobi.trade.helper.j.b(intent.getBooleanExtra("change_trend_to_default", false));
        if (intent.hasExtra("trade_driection")) {
            com.huobi.trade.helper.d.d(tradeType, intent.getBooleanExtra("trade_driection", true));
            qt.i.d(tradeType, intent.getBooleanExtra("trade_driection", true));
        }
        ((j) getUI()).V5(R.id.main_cc_tab);
        B0(TradeFragment.class, extras);
    }
}
