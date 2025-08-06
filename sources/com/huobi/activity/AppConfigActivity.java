package com.huobi.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.widget.ui.MarketWidgetSettingActivity;
import com.huobi.account.helper.UserLoginHelper;
import com.huobi.app.AbstractCommonListActivity;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.savings.mining.ui.MiningDetailActivity;
import com.huobi.setting.pricing.PricingMethodActivity;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import gs.g;
import hr.a;
import hr.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;
import tg.r;
import xg.k;
import xg.l;
import xg.m;
import xg.n;
import xg.o;

@Route(path = "/app/settings")
public class AppConfigActivity extends AbstractCommonListActivity {

    /* renamed from: g  reason: collision with root package name */
    public BottomMenuFragment f42039g = new BottomMenuFragment();

    /* renamed from: h  reason: collision with root package name */
    public List<MenuItem> f42040h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public MenuItem f42041i;

    /* renamed from: j  reason: collision with root package name */
    public MenuItem f42042j;

    /* renamed from: k  reason: collision with root package name */
    public MenuItemOnClickListener f42043k = new l(this);

    /* renamed from: l  reason: collision with root package name */
    public String f42044l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f42045m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f42046n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f42047o = true;

    /* renamed from: p  reason: collision with root package name */
    public d.a f42048p = new b();

    /* renamed from: q  reason: collision with root package name */
    public a.C0866a f42049q = new c();

    public class a extends EasySubscriber<KvStore> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(KvStore kvStore) {
            super.onNext(kvStore);
            AppConfigActivity.this.Dh();
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

    public class b implements d.a {
        public b() {
        }

        public String D(int i11) {
            if (i11 == 1) {
                return AppLanguageHelper.getInstance().getCurAppLocaleName();
            }
            if (i11 == 5) {
                return LegalCurrencyConfigUtil.y();
            }
            if (i11 != 6) {
                return null;
            }
            return AppConfigActivity.this.Sh();
        }

        public boolean E8(int i11, View view) {
            if (r.x().X()) {
                if (i11 == 17) {
                    view.setBackgroundColor(AppConfigActivity.this.getResources().getColor(R.color.baseColorDeepestBackground));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = 0;
                    layoutParams.height = AppConfigActivity.this.getResources().getDimensionPixelOffset(R.dimen.dimen_10);
                    view.setLayoutParams(layoutParams);
                    return true;
                }
            } else if (i11 == 21) {
                view.setBackgroundColor(AppConfigActivity.this.getResources().getColor(R.color.baseColorDeepestBackground));
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.leftMargin = 0;
                layoutParams2.height = AppConfigActivity.this.getResources().getDimensionPixelOffset(R.dimen.dimen_10);
                view.setLayoutParams(layoutParams2);
                return true;
            }
            return false;
        }

        public String a(int i11) {
            if (i11 == 1) {
                return AppConfigActivity.this.getString(R.string.setting_language);
            }
            if (i11 == 9) {
                return AppConfigActivity.this.getString(R.string.setting_network_test);
            }
            if (i11 == 14) {
                return AppConfigActivity.this.getString(R.string.hbg_pool);
            }
            if (i11 == 5) {
                return AppConfigActivity.this.getString(R.string.setting_pricing_method);
            }
            if (i11 == 6) {
                return AppConfigActivity.this.getString(R.string.setting_quote_color);
            }
            if (i11 == 16) {
                return AppConfigActivity.this.getString(R.string.hbg_pos_pool);
            }
            if (i11 == 17) {
                return AppConfigActivity.this.getString(R.string.n_widget_market_float_window_title_setting);
            }
            if (i11 == 20) {
                return AppConfigActivity.this.getString(R.string.n_set_clear_web_cache);
            }
            if (i11 != 21) {
                return null;
            }
            return AppConfigActivity.this.getString(R.string.n_setting_config_api_manager);
        }

        public void onItemClick(int i11) {
            Class<ApiManagerActivity> cls = ApiManagerActivity.class;
            if (i11 == 1) {
                String unused = AppConfigActivity.this.f42044l = AppLanguageHelper.getInstance().getCurAppLocaleName();
                HbgRouter.h(AppConfigActivity.this, "/app/language");
                g.i("Common_Language_Me_click", (HashMap) null);
            } else if (i11 == 9) {
                HBBaseWebActivity.showWebView(AppConfigActivity.this, "https://file.hbfile.net/diag/", "", "", false);
            } else if (i11 == 5) {
                PricingMethodActivity.Hh(AppConfigActivity.this);
                g.i("Common_Currency_Me_click", (HashMap) null);
            } else if (i11 != 6) {
                switch (i11) {
                    case 17:
                        MarketWidgetSettingActivity.vh(AppConfigActivity.this);
                        return;
                    case 18:
                        AppConfigActivity.this.startActivity(new Intent(AppConfigActivity.this, UserLoginActivityV2.class));
                        return;
                    case 19:
                        AppConfigActivity.this.startActivity(new Intent(AppConfigActivity.this, MiningDetailActivity.class));
                        return;
                    case 20:
                        AppConfigActivity.this.Wh();
                        g.i("Common_Cache_Me_click", (HashMap) null);
                        return;
                    case 21:
                        if (r.x().F0()) {
                            AppConfigActivity.this.startActivity(new Intent(AppConfigActivity.this, cls));
                        } else {
                            rn.c.i().d(AppConfigActivity.this, new JumpTarget(new Intent(AppConfigActivity.this, cls), (Intent) null));
                        }
                        g.i("Common_API_Me_click", (HashMap) null);
                        return;
                    default:
                        return;
                }
            } else {
                AppConfigActivity.this.f42039g.show(AppConfigActivity.this.getFragmentManager(), "QuoteChangecolorMenuFragment");
                g.i("Common_Color_Me_click", (HashMap) null);
            }
        }

        public boolean v8(int i11) {
            return false;
        }
    }

    public class c implements a.C0866a {
        public c() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(KvStore kvStore) {
            AppConfigActivity.this.Eh();
        }

        public String a(int i11) {
            if (i11 != 7) {
                return null;
            }
            return AppConfigActivity.this.getString(R.string.setting_quickly_withdraw);
        }

        public void b(int i11) {
            if (i11 == 7) {
                AppConfigActivity appConfigActivity = AppConfigActivity.this;
                DialogUtils.X(appConfigActivity, appConfigActivity.getString(R.string.setting_quickly_withdraw_dialog_title), AppConfigActivity.this.getString(R.string.setting_quickly_withdraw_dialog_message), (String) null, AppConfigActivity.this.getString(R.string.setting_quickly_withdraw_dialog_know), m.f61569a);
            }
        }

        public int c(int i11) {
            if (i11 == 7) {
                return R.drawable.setting_quickly_withdraw_help;
            }
            return 0;
        }

        public void d(int i11, boolean z11) {
            if (i11 == 7) {
                UserCenterRemoteDataSource.A().putKvStore(MapParamsBuilder.c().a(PlaceFields.WEBSITE, "2").a("store_key", KvStore.QUICK_WITHDRAW).a("store_value", z11 ? KvStore.Y : KvStore.N).b()).flatMap(o.f61573b).compose(RxJavaHelper.t(AppConfigActivity.this.getUI())).subscribe(q6.d.c(AppConfigActivity.this.getUI(), new n(this)));
                VibrateManager.a(AppConfigActivity.this.f42120c);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(View view, MenuItem menuItem, int i11) {
        if (i11 == 0) {
            w.m(true);
        } else if (i11 == 1) {
            w.m(false);
        }
        we.b.l("riseFallChange", Object.class).g(0);
        Yh();
        this.f42039g.dismiss();
        Eh();
    }

    public static /* synthetic */ void Vh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        tu.c.d();
        HuobiToastUtil.s(R.string.n_set_clear_web_cache_success);
    }

    public static void Xh(Context context) {
        HbgRouter.h(context, "/app/settings");
    }

    public void Bh() {
    }

    public void Ch() {
    }

    public String Qg() {
        return null;
    }

    public final String Sh() {
        if (w.l()) {
            return getString(R.string.setting_quote_color_red_rise);
        }
        return getString(R.string.setting_quote_color_green_rise);
    }

    public final void Th() {
        if (this.f42045m) {
            UserLoginHelper.e().f().compose(RxJavaHelper.t(getUI())).subscribe(new a());
        }
    }

    public final void Wh() {
        DialogUtils.b0(this, getString(R.string.n_set_clear_web_cache), getString(R.string.n_set_clear_web_cache_sure), "", getString(R.string.global_string_cancel), getString(R.string.global_string_confirm), ad.b.f3517a, k.f61565a);
    }

    public final void Yh() {
        if (w.l()) {
            this.f42041i.setStyle(MenuItem.MenuItemStyle.STRESS);
            this.f42042j.setStyle(MenuItem.MenuItemStyle.COMMON);
            return;
        }
        this.f42041i.setStyle(MenuItem.MenuItemStyle.COMMON);
        this.f42042j.setStyle(MenuItem.MenuItemStyle.STRESS);
    }

    public void initContentView() {
        if (getIntent().getBooleanExtra("APP_CONFIG_NO_ANIM", false)) {
            setTheme(R.style.NoAnimTheme);
        } else {
            setTheme(R.style.ActivityTranslation);
        }
        super.initContentView();
    }

    public void initView() {
        this.f42045m = r.x().F0();
        this.f42046n = r.x().X();
        super.initView();
        String string = getString(R.string.setting_quote_color_red_rise);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        MenuItem menuItem = new MenuItem("", string, menuItemStyle, this.f42043k);
        this.f42041i = menuItem;
        this.f42040h.add(menuItem);
        MenuItem menuItem2 = new MenuItem("", getString(R.string.setting_quote_color_green_rise), menuItemStyle, this.f42043k);
        this.f42042j = menuItem2;
        this.f42040h.add(menuItem2);
        this.f42039g.setMenuItems(this.f42040h);
        Yh();
        Th();
    }

    public String oh() {
        return getString(R.string.n_user_center_setting);
    }

    public void onStart() {
        super.onStart();
        if (!TextUtils.isEmpty(this.f42044l) && !AppLanguageHelper.getInstance().getCurLanguageHeader().equals(this.f42044l)) {
            recreate();
        }
        if (!this.f42047o) {
            boolean F0 = r.x().F0();
            if (this.f42045m == F0 && this.f42046n == r.x().X()) {
                Eh();
            } else {
                this.f42045m = F0;
                this.f42046n = r.x().X();
                Dh();
            }
        }
        this.f42047o = false;
        ph();
    }

    public List<s9.a> qh(List<s9.a> list) {
        if (!LiteReHelper.a().b() && !r.x().X()) {
            list.add(new d(21, this.f42048p));
        }
        list.add(new d(1, this.f42048p));
        list.add(new d(5, this.f42048p));
        list.add(new d(6, this.f42048p));
        if (this.f42045m && !r.x().X()) {
            list.add(new hr.a(7, this.f42049q));
        }
        if (i6.d.k()) {
            list.add(new d(14, this.f42048p));
            list.add(new d(16, this.f42048p));
            list.add(new d(18, this.f42048p));
            list.add(new d(19, this.f42048p));
        }
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            list.add(new d(9, this.f42048p));
        }
        list.add(new d(20, this.f42048p));
        return list;
    }

    public boolean th() {
        return false;
    }

    public boolean uh() {
        return false;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
