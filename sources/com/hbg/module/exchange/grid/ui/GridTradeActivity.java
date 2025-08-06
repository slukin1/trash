package com.hbg.module.exchange.grid.ui;

import ad.m;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import cd.l;
import cd.n;
import cd.o;
import cd.o0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.CommonRestartActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.grid.bean.GridAiQuote;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.exchange.R$anim;
import com.hbg.module.exchange.R$color;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.R$string;
import com.hbg.module.exchange.grid.presenter.GridTradePresenter;
import com.hbg.module.exchange.grid.ui.GridTradeHandView;
import com.hbg.module.exchange.grid.ui.GridTradeLayout;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import d7.a1;
import d7.k;
import d7.y;
import i6.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import u6.g;

@Route(path = "/trade/grid")
public class GridTradeActivity extends BaseActivity<GridTradePresenter, GridTradePresenter.i> implements GridTradePresenter.i, wc.a {

    /* renamed from: b  reason: collision with root package name */
    public GridTradeLayout f19498b;

    /* renamed from: c  reason: collision with root package name */
    public String f19499c;

    /* renamed from: d  reason: collision with root package name */
    public String f19500d;

    /* renamed from: e  reason: collision with root package name */
    public String f19501e;

    /* renamed from: f  reason: collision with root package name */
    public BaseDialogFragment f19502f;

    /* renamed from: g  reason: collision with root package name */
    public HuobiKeyboardHelper f19503g;

    /* renamed from: h  reason: collision with root package name */
    public HBDialogFragment f19504h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19505i = true;

    public class a extends q6.a<String> {
        public a(g gVar, boolean z11) {
            super(gVar, z11);
        }

        public void onError2(Throwable th2) {
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).R0("");
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).R0("");
        }

        public void onRequestSuccess(String str) {
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).R0(str);
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).p0();
        }
    }

    public class b implements GridTradeLayout.b {
        public b() {
        }

        public void a() {
            GridTradeActivity.this.Sh();
        }

        public void b(View view) {
            GridTradeActivity.this.Sh();
            o0.a(view, GridTradeActivity.this.getResources().getString(R$string.n_grid_rate_tips), false);
        }

        public void c() {
            GridTradeActivity.this.Sh();
            String Pg = GridTradeActivity.this.f19499c;
            TradeType tradeType = TradeType.PRO;
            Bundle bundle = new Bundle();
            String X = a1.v().X(Pg, tradeType);
            bundle.putString("symbolId", Pg);
            bundle.putString("market_title", X);
            bundle.putString("market_trade_type", tradeType.toString());
            bundle.putBoolean("market_grid", true);
            HbgRouter.i(GridTradeActivity.this, "/kline/index", bundle);
        }

        public void d() {
            GridTradeActivity.this.Sh();
            GridTradeActivity gridTradeActivity = GridTradeActivity.this;
            vc.a a11 = vc.b.a();
            boolean g11 = NightHelper.e().g();
            GridTradeActivity gridTradeActivity2 = GridTradeActivity.this;
            BaseDialogFragment unused = gridTradeActivity.f19502f = a11.o(g11, gridTradeActivity2, gridTradeActivity2.getUI(), GridTradeActivity.this.o0(), GridTradeActivity.this.f19502f, TradeType.GRID.toString(), GridTradeActivity.this);
        }

        public void e(View view) {
            GridTradeActivity.this.Sh();
            o0.a(view, GridTradeActivity.this.getResources().getString(R$string.n_grid_seven_day_rate_tips), true);
        }

        public void f(boolean z11) {
            GridTradeActivity.this.Th();
            GridTradeActivity.this.Sh();
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).q0();
            GridTradeActivity.this.f19503g.hideKeyboard();
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).L0();
        }

        public void g() {
            vc.b.a().j(GridTradeActivity.this);
        }

        public void h() {
            GridTradeActivity.this.Sh();
            vc.b.a().e(GridTradeActivity.this);
        }

        public void i(boolean z11, String str) {
            if (!z11) {
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).B0(str);
            }
        }

        public void j() {
            if (!ViewUtil.c(1000)) {
                if (!GridTradeActivity.this.f19505i) {
                    HuobiToastUtil.j(R$string.n_grid_trade_error_toast_9);
                    return;
                }
                GridTradeActivity.this.Sh();
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).N0();
                HashMap hashMap = new HashMap();
                hashMap.put("type", GridTradeActivity.this.y8() ? "一键创建" : "手动创建");
                hashMap.put("symbol", GridTradeActivity.this.o0());
                vc.b.a().d("5838", hashMap, "1005373");
            }
        }

        public void k() {
            GridTradeActivity.this.Sh();
            GridTradeActivity.this.finish();
        }

        public void l() {
            GridTradeActivity.this.Sh();
            m.d(GridTradeActivity.this.getSupportFragmentManager(), GridTradeActivity.this);
        }

        public void m(boolean z11) {
            GridTradeActivity.this.Sh();
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).T0(z11);
        }

        public void n(String str) {
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).p0();
        }

        public void onRefresh() {
            GridTradeActivity.this.Sh();
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).L0();
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).Q0();
        }
    }

    public class c implements GridTradeHandView.j {
        public c() {
        }

        public static /* synthetic */ void w(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            HBBaseWebActivity.showWebView(fragmentActivity, vc.b.a().m(), "", "", false);
            vc.b.a().d("5913", (Map<String, Object>) null, "1005373");
        }

        public static /* synthetic */ void x(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            vc.b.a().d("5912", (Map<String, Object>) null, "1005373");
        }

        public void a() {
            GridTradeActivity.this.Sh();
        }

        public void b(String str) {
        }

        public void c(boolean z11, String str) {
            if (!z11) {
                GridTradeActivity.this.Th();
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).D0(str);
            }
        }

        public void d(boolean z11, String str) {
            if (!z11) {
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).G0(str);
            }
        }

        public void e(boolean z11, String str) {
            if (!z11) {
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).I0(str);
            }
        }

        public void f(boolean z11, String str) {
            if (!z11) {
                GridTradeActivity.this.Th();
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).F0(str);
            }
        }

        public void g(boolean z11, String str) {
            if (!z11) {
                GridTradeActivity.this.Th();
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).E0(str);
            }
        }

        public void h(boolean z11) {
            if (z11) {
                GridTradeActivity.this.Th();
            }
            GridTradeActivity.this.Sh();
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).q0();
        }

        public void i(View view) {
            GridTradeActivity.this.Sh();
            String z11 = k.C().z(GridTradeActivity.this.getQuoteCurrency());
            String z12 = k.C().z(GridTradeActivity.this.getBaseCurrency());
            Resources resources = GridTradeActivity.this.getResources();
            int i11 = R$string.n_grid_throw_amount_tips;
            o0.a(view, resources.getString(i11, new Object[]{z11, z11, z11 + "+" + z12, z11, z12}), false);
        }

        public void j(boolean z11, String str) {
            if (!z11) {
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).H0(str);
            }
        }

        public void k(int i11) {
            GridTradeActivity.this.Th();
            GridTradeActivity.this.Sh();
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).q0();
        }

        public void l(String str) {
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).q0();
        }

        public void m(String str) {
        }

        public void n(String str) {
        }

        public void o(String str) {
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).q0();
        }

        public void p(String str) {
        }

        public void q(boolean z11, String str) {
            if (!z11) {
                ((GridTradePresenter) GridTradeActivity.this.getPresenter()).C0(str);
            }
        }

        public void r(View view) {
            GridTradeActivity.this.Sh();
            o0.a(view, GridTradeActivity.this.getResources().getString(R$string.n_grid_rate_tips), false);
        }

        public void s(String str) {
            ((GridTradePresenter) GridTradeActivity.this.getPresenter()).q0();
        }

        public void t() {
            GridTradeActivity.this.Sh();
            GridTradeActivity gridTradeActivity = GridTradeActivity.this;
            new DialogUtils.b.d(gridTradeActivity).c1(gridTradeActivity.getString(R$string.n_grid_strategye_advanced_settings_title)).C0(gridTradeActivity.getString(R$string.n_grid_strategy_advanced_settings_tip)).q0(false).Y0(gridTradeActivity.getString(R$string.n_otc_advert_list_select_blue_shield_more)).a1(new n(gridTradeActivity)).P0(gridTradeActivity.getString(R$string.n_known)).Q0(o.f13054a).k0().show(gridTradeActivity.getSupportFragmentManager(), "");
            vc.b.a().l("5911", "1005373", (Map<String, Object>) null);
        }
    }

    public static /* synthetic */ void Qh(HBDialogFragment hBDialogFragment) {
        ClearDialogConfigController.g(6);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Rh(String str, HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(this, vc.b.a().i(str), "", "", false);
        ClearDialogConfigController.g(6);
        hBDialogFragment.dismiss();
    }

    public void Aa(String str) {
        this.f19498b.getGridTradeAiView().setMinCapitalQuote(str);
    }

    public String Cc() {
        if (y8()) {
            return this.f19498b.getGridTradeAiView().getInvestQuoteAmount();
        }
        return this.f19498b.getGridTradeHandView().getInvestQuoteAmount();
    }

    public void D8(String str) {
        this.f19498b.getGridTradeHandView().setMinCapitalQuote(str);
    }

    public void Ef(SpannableStringBuilder spannableStringBuilder, String str) {
        this.f19498b.F(spannableStringBuilder, str);
    }

    public void Gf() {
        this.f19498b.getGridTradeAiView().l();
        this.f19498b.getGridTradeHandView().E();
    }

    public void H5() {
        this.f19498b.o();
    }

    public void L6(String str, String str2, String str3, int i11, int i12, int i13) {
        this.f19498b.G(str, str2, str3, i11, i12, i13);
    }

    public void Mf(String str) {
        this.f19498b.getGridTradeHandView().setPerGridRate(str);
    }

    /* renamed from: Mh */
    public GridTradePresenter createPresenter() {
        return new GridTradePresenter();
    }

    public HuobiKeyboardHelper Nh() {
        return this.f19503g;
    }

    /* renamed from: Oh */
    public GridTradePresenter.i getUI() {
        return this;
    }

    public final void Ph() {
        SymbolBean J;
        GridSymbolsBean gridSymbolsBean;
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("EXTRA_SYMBOL");
            this.f19499c = stringExtra;
            if (!TextUtils.isEmpty(stringExtra) && (J = a1.v().J(this.f19499c, TradeType.PRO)) != null && !J.isCanTrade()) {
                List<GridSymbolsBean> n11 = y.n();
                if (!n11.isEmpty() && (gridSymbolsBean = n11.get(0)) != null) {
                    this.f19499c = gridSymbolsBean.getSymbolCode();
                }
            }
            this.f19498b.setIsAI(intent.getBooleanExtra("EXTRA_AI", true));
            this.f19498b.getGridTradeHandView().setDengCha(intent.getBooleanExtra("EXTRA_DENG_CHA", true));
            this.f19498b.getGridTradeHandView().setIsSingle(intent.getBooleanExtra("EXTRA_SINGLE", true));
            this.f19498b.getGridTradeHandView().setHighLevelOpen(intent.getBooleanExtra("EXTRA_HIGH_LEVEL_OPEN", false));
        }
    }

    public void Qa(String str, String str2) {
        this.f19498b.getGridTradeAiView().setAvailable(str);
        this.f19498b.getGridTradeHandView().F(str, str2);
    }

    public boolean Qf() {
        return this.f19498b.getGridTradeHandView().v();
    }

    public void Sh() {
        this.f19498b.getGridTradeAiView().k();
        this.f19498b.getGridTradeHandView().D();
        HuobiKeyboardHelper huobiKeyboardHelper = this.f19503g;
        if (huobiKeyboardHelper != null) {
            huobiKeyboardHelper.hideKeyboard();
        }
    }

    public String Te() {
        if (y8()) {
            return null;
        }
        return this.f19498b.getGridTradeHandView().getStopProfitPrice();
    }

    public String Tg() {
        if (y8()) {
            return this.f19498b.getGridTradeAiView().getGridRate();
        }
        return this.f19498b.getGridTradeHandView().getGridRate();
    }

    public final void Th() {
        if (!y8() && Qf()) {
            ((GridTradePresenter) getPresenter()).R0("");
            v7.b.a().o0(o0(), this.f19498b.getGridTradeHandView().u(), this.f19498b.getGridTradeHandView().getGridNum(), this.f19498b.getGridTradeHandView().getMinPrice(), this.f19498b.getGridTradeHandView().getMaxPrice()).d(new a(getUI(), false));
        }
    }

    public void We() {
        Intent intent = getIntent();
        if (intent != null && !y8()) {
            String stringExtra = intent.getStringExtra("EXTRA_MIN_PRICE");
            String stringExtra2 = intent.getStringExtra("EXTRA_MAX_PRICE");
            String stringExtra3 = intent.getStringExtra("EXTRA_GRID_NUM");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f19498b.getGridTradeHandView().setInputMinPrice(stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.f19498b.getGridTradeHandView().setInputMaxPrice(stringExtra2);
            }
            if (!TextUtils.isEmpty(stringExtra3)) {
                this.f19498b.getGridTradeHandView().setInputGridNum(stringExtra3);
            }
        }
    }

    public void Yc(String str) {
        this.f19498b.getGridTradeHandView().setMinCapitalBase(str);
    }

    public void Z8(String str) {
        this.f19499c = str;
        if (str != null) {
            String W = a1.v().W(this.f19499c);
            this.f19500d = a1.v().n(this.f19499c);
            this.f19501e = a1.v().D(this.f19499c);
            this.f19498b.setSymbolTitle(W);
            this.f19498b.getGridTradeAiView().setQuoteCurrency(this.f19501e);
            GridTradeHandView gridTradeHandView = this.f19498b.getGridTradeHandView();
            gridTradeHandView.setQuoteCurrency(this.f19501e);
            gridTradeHandView.setBaseCurrency(this.f19500d);
            gridTradeHandView.H();
        }
    }

    public void addEvent() {
        this.f19498b.setCallback(new b());
        this.f19498b.getGridTradeHandView().setCallback(new c());
    }

    public void afterInit() {
        super.afterInit();
        Ph();
        Z8(this.f19499c);
    }

    public void b(v9.a aVar) {
        this.f19498b.setRvAdapter(aVar);
    }

    public String b5() {
        if (y8()) {
            return this.f19498b.getGridTradeAiView().getMinPrice();
        }
        return this.f19498b.getGridTradeHandView().getMinPrice();
    }

    public void fe(String str) {
        this.f19498b.getGridTradeAiView().n(str);
        this.f19498b.getGridTradeHandView().G(str);
    }

    public int gb() {
        if (y8()) {
            return this.f19498b.getGridTradeAiView().getRunType();
        }
        return this.f19498b.getGridTradeHandView().u();
    }

    public String getBaseCurrency() {
        return this.f19500d;
    }

    public int getContentView() {
        return R$layout.activity_grid_trade;
    }

    public String getQuoteCurrency() {
        return this.f19501e;
    }

    public void initView() {
        this.f19498b = (GridTradeLayout) this.viewFinder.b(R$id.id_grid_trade_layout);
        this.f19503g = new HuobiKeyboardHelper();
        this.f19498b.setActivity(this);
    }

    public void j(String str) {
        Intent intent = new Intent(this, GridTradeActivity.class);
        intent.putExtra("EXTRA_SYMBOL", str);
        intent.putExtra("EXTRA_AI", y8());
        intent.putExtra("EXTRA_DENG_CHA", this.f19498b.getGridTradeHandView().s());
        intent.putExtra("EXTRA_SINGLE", this.f19498b.getGridTradeHandView().v());
        intent.putExtra("EXTRA_HIGH_LEVEL_OPEN", this.f19498b.getGridTradeHandView().t());
        CommonRestartActivity.Xf(this, intent);
        overridePendingTransition(R$anim.fade_in, R$anim.fade_out);
    }

    public void k7() {
        ((GridTradePresenter) getPresenter()).M0();
    }

    public void n5(boolean z11) {
        this.f19505i = z11;
        this.f19498b.setCreateBtnEnable(z11);
    }

    public int na() {
        if (y8()) {
            return this.f19498b.getGridTradeAiView().getGridNum();
        }
        return this.f19498b.getGridTradeHandView().getGridNum();
    }

    public String o0() {
        return this.f19499c;
    }

    public void of(GridAiQuote gridAiQuote) {
        this.f19498b.getGridTradeAiView().m(gridAiQuote);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStatusBarColor(getResources().getColor(R$color.login_v2_bottom_background));
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d.b("========onNewIntent");
        boolean booleanExtra = intent.getBooleanExtra("EXTRA_FORCE_RESTART", false);
        boolean booleanExtra2 = intent.getBooleanExtra("EXTRA_ACT_ANIM", true);
        Intent intent2 = new Intent(this, GridTradeActivity.class);
        if (booleanExtra) {
            intent2.putExtras(intent);
            CommonRestartActivity.Xf(this, intent2);
            if (booleanExtra2) {
                overridePendingTransition(R$anim.fade_in, R$anim.fade_out);
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("EXTRA_SYMBOL");
        String str = this.f19499c;
        if (str == null || !str.equalsIgnoreCase(stringExtra)) {
            intent2.putExtra("EXTRA_SYMBOL", stringExtra);
            intent2.putExtra("EXTRA_AI", y8());
            intent2.putExtra("EXTRA_DENG_CHA", this.f19498b.getGridTradeHandView().s());
            intent2.putExtra("EXTRA_SINGLE", this.f19498b.getGridTradeHandView().v());
            intent2.putExtra("EXTRA_HIGH_LEVEL_OPEN", this.f19498b.getGridTradeHandView().t());
            CommonRestartActivity.Xf(this, intent2);
            overridePendingTransition(R$anim.fade_in, R$anim.fade_out);
            return;
        }
        GridTradeLayout gridTradeLayout = this.f19498b;
        if (gridTradeLayout != null) {
            gridTradeLayout.E();
        }
    }

    public void onResume() {
        super.onResume();
        Th();
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        HuobiKeyboardHelper huobiKeyboardHelper = this.f19503g;
        if (huobiKeyboardHelper != null) {
            huobiKeyboardHelper.hideKeyboard();
        }
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        BaseModuleConfig.a().g(this);
        finish();
    }

    public void p0(String str, String str2) {
        HBDialogFragment hBDialogFragment = this.f19504h;
        if (hBDialogFragment == null || !hBDialogFragment.th()) {
            DialogUtils.b.d Q0 = new DialogUtils.b.d(this).c1(getString(R$string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getString(R$string.n_known)).Q0(cd.m.f13049a);
            if (!TextUtils.isEmpty(str)) {
                Q0.s0(getString(R$string.n_exchange_filled_orders_tip_view_detail)).N0(new l(this, str));
            }
            HBDialogFragment k02 = Q0.k0();
            this.f19504h = k02;
            k02.show(getSupportFragmentManager(), "");
        }
    }

    public String q8() {
        if (y8()) {
            return null;
        }
        return this.f19498b.getGridTradeHandView().getStopLossPrice();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public String we() {
        if (y8()) {
            return this.f19498b.getGridTradeAiView().getMaxPrice();
        }
        return this.f19498b.getGridTradeHandView().getMaxPrice();
    }

    public String xd() {
        if (y8()) {
            return null;
        }
        return this.f19498b.getGridTradeHandView().getInvestBaseAmount();
    }

    public boolean y8() {
        return this.f19498b.q();
    }
}
