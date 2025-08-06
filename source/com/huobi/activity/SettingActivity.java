package com.huobi.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import bh.u;
import bj.o0;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.lang.EnLang;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.account.index.ui.AccountActivity;
import com.hbg.module.kline.KLineHelper;
import com.huobi.account.ui.NotificationManagerSettingActivity;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.account.ui.TradingSettingActivity;
import com.huobi.account.widget.SettingItemView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.setting.pricing.PricingMethodActivity;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.LanguageHelper;
import com.huobi.utils.UpgradeUtil;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.title.HbTitleBar;
import com.huobi.webcache.ui.LogActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import pro.huobi.R;
import q6.d;
import rn.c;
import sn.w;
import tg.r;
import u6.g;
import we.b;
import xg.a0;
import xg.b0;
import xg.c0;
import xg.d0;
import xg.e0;
import xg.f0;
import xg.g0;
import xg.h0;
import xg.i0;
import xg.j0;
import xg.k0;
import xg.l0;
import xg.m0;
import xg.n0;
import xg.p0;
import xg.q0;
import xg.x;
import xg.y;
import xg.z;

public class SettingActivity extends EmptyMVPActivity {

    /* renamed from: t  reason: collision with root package name */
    public static Handler f42080t = new Handler();

    /* renamed from: u  reason: collision with root package name */
    public static boolean f42081u;

    /* renamed from: v  reason: collision with root package name */
    public static boolean f42082v;

    /* renamed from: w  reason: collision with root package name */
    public static boolean f42083w = false;

    /* renamed from: x  reason: collision with root package name */
    public static boolean f42084x = false;

    /* renamed from: b  reason: collision with root package name */
    public TextView f42085b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42086c;

    /* renamed from: d  reason: collision with root package name */
    public View f42087d;

    /* renamed from: e  reason: collision with root package name */
    public SettingItemView f42088e;

    /* renamed from: f  reason: collision with root package name */
    public SettingItemView f42089f;

    /* renamed from: g  reason: collision with root package name */
    public SettingItemView f42090g;

    /* renamed from: h  reason: collision with root package name */
    public SettingItemView f42091h;

    /* renamed from: i  reason: collision with root package name */
    public SettingItemView f42092i;

    /* renamed from: j  reason: collision with root package name */
    public SettingItemView f42093j;

    /* renamed from: k  reason: collision with root package name */
    public SettingItemView f42094k;

    /* renamed from: l  reason: collision with root package name */
    public SettingItemView f42095l;

    /* renamed from: m  reason: collision with root package name */
    public BottomMenuFragment f42096m = new BottomMenuFragment();

    /* renamed from: n  reason: collision with root package name */
    public TextView f42097n;

    /* renamed from: o  reason: collision with root package name */
    public View f42098o;

    /* renamed from: p  reason: collision with root package name */
    public MenuItem f42099p;

    /* renamed from: q  reason: collision with root package name */
    public MenuItem f42100q;

    /* renamed from: r  reason: collision with root package name */
    public HBDialogFragment f42101r;

    /* renamed from: s  reason: collision with root package name */
    public MenuItemOnClickListener f42102s = new g0(this);

    public class a extends d<Object> {
        public a(g gVar) {
            super(gVar);
        }

        public void onAfter() {
            super.onAfter();
            SettingActivity.this.t4();
            w.j().m((CountryListData) null);
            r x11 = r.x();
            x11.m("old clearUserLoginInfo method t - [" + Thread.currentThread().getName() + "]", false);
            u.e();
            c.i().d(SettingActivity.this, new JumpTarget((Intent) null, (Intent) null));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hh(View view) {
        NetworkDetectionActivity.Og(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ih(View view) {
        ci();
        gs.g.i("Common_Cache_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        Intent intent = new Intent();
        intent.setClass(this, LogActivity.class);
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Kh(View view) {
        gs.g.i("Night_Me_click", (HashMap) null);
        boolean g11 = NightHelper.e().g();
        NightHelper.e().j(true);
        NightHelper.e().c(!g11);
        oa.a.g().i(SettingActivity.class);
        if (HomeHelper.j()) {
            oa.a.g().i(AccountActivity.class);
        }
        f42083w = true;
        if (KLineHelper.f() ^ g11) {
            f42081u = true;
            f42082v = g11;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        if (r.x().F0()) {
            NotificationManagerSettingActivity.Qg(this);
        } else {
            c.i().d(this, Dh(new Intent(this, NotificationManagerSettingActivity.class)));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(View view) {
        HbgRouter.h(this, "/app/language");
        gs.g.i("Common_Language_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        PricingMethodActivity.Hh(this);
        gs.g.i("Common_Currency_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        this.f42096m.show(getFragmentManager(), "SettingActivityQuoteChangecolorMenuFragment");
        gs.g.i("Common_Color_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ph(View view) {
        if (r.x().F0()) {
            ei(this);
        } else {
            c.i().d(this, Dh(new Intent(this, SecuritySetActivity.class)));
        }
        gs.g.i("Security_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qh(View view) {
        if (r.x().F0()) {
            TradingSettingActivity.Xh(this);
        } else {
            c.i().d(this, Dh(new Intent(this, TradingSettingActivity.class)));
        }
        gs.g.i("Trading_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Rh(View view) {
        AppConfigActivity.Xh(this);
        gs.g.i("Common_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Sh(View view) {
        AppConfigAboutUsActivity.Sh(this);
        gs.g.i("About_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Th(View view, MenuItem menuItem, int i11) {
        if (i11 == 0) {
            com.hbg.lib.core.util.w.m(true);
        } else if (i11 == 1) {
            com.hbg.lib.core.util.w.m(false);
        }
        b.l("riseFallChange", Object.class).g(0);
        hi();
        this.f42096m.dismiss();
        this.f42090g.setSubTitle(Eh());
        if (HomeHelper.j()) {
            oa.a.g().i(AccountActivity.class);
        }
        f42083w = true;
        ll.a.f76233a = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        c.i().t().compose(RxJavaHelper.t(getUI())).subscribe(new a(getUI()));
    }

    public static /* synthetic */ void Wh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        tu.c.d();
        com.huobi.webcache.g.h().p();
        HuobiToastUtil.s(R.string.n_set_clear_web_cache_success);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xh(View view) {
        ai();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yh(View view) {
        bi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void Zh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        KLineHelper.n(f42082v);
    }

    public static void di(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$1(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String Ch() {
        return getString(R.string.n_setting_sign_out);
    }

    public final JumpTarget Dh(Intent intent) {
        JumpTarget jumpTarget = new JumpTarget(intent, (Intent) null);
        jumpTarget.setExpandData("LOGIN_FROM_PERSONAL_CENTER");
        return jumpTarget;
    }

    public final String Eh() {
        if (com.hbg.lib.core.util.w.l()) {
            return getString(R.string.setting_quote_color_red_rise);
        }
        return getString(R.string.setting_quote_color_green_rise);
    }

    public final boolean Fh() {
        return r.x().F0();
    }

    public final boolean Gh() {
        return r.x().F0() && !LiteReHelper.a().b();
    }

    public void addEvent() {
        super.addEvent();
        this.f42093j.setClickListener(new n0(this));
        this.f42088e.setClickListener(new k0(this));
        this.f42089f.setClickListener(new x(this));
        this.f42090g.setClickListener(new l0(this));
        this.f42091h.setClickListener(new p0(this));
        this.f42092i.setClickListener(new z(this));
        this.f42094k.setClickListener(new xg.w(this));
        this.f42095l.setClickListener(b0.f61546b);
        fi();
    }

    public void ai() {
        DialogUtils.c0(this, getString(R.string.setting_sign_out_msg), "", getString(R.string.security_google_cancel), getString(R.string.setting_sign_out_confirm), e0.f61554a, new c0(this));
    }

    public void bi() {
        HbgRouter.h(this, "/account/multiple");
    }

    public final void ci() {
        DialogUtils.b0(this, getString(R.string.n_set_clear_web_cache), getString(R.string.n_set_clear_web_cache_sure), "", getString(R.string.global_string_cancel), getString(R.string.global_string_confirm), ad.b.f3517a, d0.f61552a);
    }

    public final void ei(Activity activity) {
        if (!NetworkStatus.c(activity)) {
            HuobiToastUtil.j(R.string.server_error);
        } else {
            activity.startActivity(new Intent(activity, SecuritySetActivity.class));
        }
    }

    public void fi() {
        if (this.f42085b != null) {
            boolean Fh = Fh();
            if (Fh) {
                this.f42085b.setText(Ch());
                this.f42085b.setOnClickListener(new y(this));
            }
            boolean Gh = Gh();
            if (Gh) {
                this.f42086c.setOnClickListener(new m0(this));
            }
            int i11 = 8;
            this.f42085b.setVisibility(Fh ? 0 : 8);
            this.f42086c.setVisibility(Gh ? 0 : 8);
            boolean z11 = Fh || Gh;
            View view = this.f42087d;
            if (z11) {
                i11 = 0;
            }
            view.setVisibility(i11);
        }
    }

    public int getContentView() {
        return R.layout.activity_setting_layout;
    }

    public final void gi() {
        if (f42081u) {
            this.f42101r = DialogUtils.c0(this, getString(f42082v ? R.string.n_kline_also_set_kline_day : R.string.n_kline_also_set_kline_night), "", getString(R.string.n_cancel), getString(R.string.n_kline_also_set), o0.f12469a, f0.f61556a);
            f42081u = false;
        }
    }

    public final void hi() {
        if (com.hbg.lib.core.util.w.l()) {
            this.f42099p.setStyle(MenuItem.MenuItemStyle.STRESS);
            this.f42100q.setStyle(MenuItem.MenuItemStyle.COMMON);
            return;
        }
        this.f42099p.setStyle(MenuItem.MenuItemStyle.COMMON);
        this.f42100q.setStyle(MenuItem.MenuItemStyle.STRESS);
    }

    public final void ii() {
        String str;
        this.f42088e.setSubTitle(AppLanguageHelper.getInstance().getCurAppLocaleName());
        this.f42089f.setSubTitle(LegalCurrencyConfigUtil.y().toUpperCase(Locale.US));
        this.f42090g.setSubTitle(Eh());
        boolean g11 = NightHelper.e().g();
        SettingItemView settingItemView = this.f42095l;
        if (g11) {
            str = getString(R.string.n_user_center_setting_theme_night);
        } else {
            str = getString(R.string.n_user_center_setting_theme_normal);
        }
        settingItemView.setSubTitle(str);
    }

    public void initView() {
        ((HbTitleBar) this.viewFinder.b(R.id.title_bar)).setOnClickBackListener(new q0(this));
        this.f42098o = findViewById(R.id.newVersionDot);
        this.f42097n = (TextView) findViewById(R.id.versionNameText);
        this.f42088e = (SettingItemView) findViewById(R.id.ll_language);
        this.f42089f = (SettingItemView) findViewById(R.id.ll_pricing_method);
        this.f42090g = (SettingItemView) findViewById(R.id.ll_quote_color);
        this.f42091h = (SettingItemView) findViewById(R.id.ll_network_test);
        this.f42092i = (SettingItemView) findViewById(R.id.ll_clear_cache);
        this.f42093j = (SettingItemView) findViewById(R.id.ll_notify_manager);
        this.f42095l = (SettingItemView) findViewById(R.id.ll_color_mode);
        SettingItemView settingItemView = (SettingItemView) findViewById(R.id.debug_logcollect_container);
        this.f42094k = settingItemView;
        settingItemView.setVisibility(8);
        String string = getString(R.string.setting_quote_color_red_rise);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        this.f42099p = new MenuItem("", string, menuItemStyle, this.f42102s);
        ArrayList arrayList = new ArrayList();
        this.f42100q = new MenuItem("", getString(R.string.setting_quote_color_green_rise), menuItemStyle, this.f42102s);
        hi();
        arrayList.add(this.f42099p);
        arrayList.add(this.f42100q);
        this.f42096m.setMenuItems(arrayList);
        ViewUtil.m(this.f42093j, !r.x().X());
        findViewById(R.id.ll_security_center).setOnClickListener(new a0(this));
        findViewById(R.id.ll_trading).setOnClickListener(new h0(this));
        findViewById(R.id.ll_setting).setOnClickListener(new xg.o0(this));
        findViewById(R.id.aboutUsLayout).setOnClickListener(new j0(this));
        this.f42087d = this.viewFinder.b(R.id.id_common_list_ll);
        this.f42085b = (TextView) this.viewFinder.b(R.id.id_common_list_bottom_btn);
        this.f42086c = (TextView) this.viewFinder.b(R.id.id_common_list_change_btn);
        ji();
    }

    public final void ji() {
        if (!UpgradeUtil.c()) {
            this.f42098o.setVisibility(8);
            this.f42097n.setText(getResources().getString(R.string.n_user_center_version, new Object[]{" 10.54.0"}));
            return;
        }
        this.f42098o.setVisibility(0);
        this.f42097n.setText(getResources().getString(R.string.n_user_center_discover_new_version));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f42080t.post(new i0(this));
    }

    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            if (f42084x) {
                oa.a.g().j((Class<?>) null);
            } else if (f42083w) {
                oa.a.g().i(HuobiMainActivity.class);
            }
            f42083w = false;
            f42084x = false;
        }
    }

    public void onRestart() {
        super.onRestart();
        gs.g.i("Setting_Me_view", (HashMap) null);
    }

    public void onResume() {
        super.onResume();
        ii();
        fi();
    }

    public final void t4() {
        if (m6.a.l()) {
            LanguageHelper.b(EnLang.getInstance());
            f42084x = true;
            oa.a.g().i(SettingActivity.class);
            if (HomeHelper.j()) {
                oa.a.g().i(AccountActivity.class);
            }
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
