package com.hbg.module.kline.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.ability.CurrencyNoticeAbility;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.n;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.RedPointPagerTitleView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.R$style;
import com.hbg.module.kline.presenter.MarketInfoPresenter;
import com.huobi.utils.ReviewManger;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import td.i;

@Route(path = "/kline/index")
public class MarketInfoActivity extends BaseActivity<MarketInfoPresenter, MarketInfoPresenter.e> implements MarketInfoPresenter.e {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f23909b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f23910c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f23911d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23912e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f23913f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23914g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f23915h;

    /* renamed from: i  reason: collision with root package name */
    public BaseDialogFragment f23916i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f23917j;

    /* renamed from: k  reason: collision with root package name */
    public CommonTextListIndicator f23918k;

    /* renamed from: l  reason: collision with root package name */
    public View f23919l;

    /* renamed from: m  reason: collision with root package name */
    public DialogFragment f23920m;

    /* renamed from: n  reason: collision with root package name */
    public FrameLayout f23921n;

    /* renamed from: o  reason: collision with root package name */
    public rj.b f23922o;

    /* renamed from: p  reason: collision with root package name */
    public View f23923p;

    /* renamed from: q  reason: collision with root package name */
    public long f23924q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f23925r;

    public class a implements CommonTextListIndicator.b {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            MarketInfoActivity.this.f23913f.setCurrentItem(i11);
            String str = MarketInfoActivity.this.f23918k.getList().get(i11);
            if (MarketInfoActivity.this.getString(R$string.n_content_comment).equals(str)) {
                BaseModuleConfig.a().w("Kcommunity_click", (HashMap) null);
            } else if (MarketInfoActivity.this.getString(R$string.n_content_newsflash).equals(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("news_state", "app_kline_news");
                BaseModuleConfig.a().w("app_newsTab_click", hashMap);
            } else if (MarketInfoActivity.this.getString(R$string.n_content_deep_news).equals(str)) {
                BaseModuleConfig.a().w("app_kline_articlesTab_click", (HashMap) null);
            }
        }
    }

    public class b extends EasySubscriber<Boolean> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (MarketInfoActivity.this.getActivity() != null && !MarketInfoActivity.this.getActivity().isFinishing()) {
                MarketInfoActivity.this.Uh(bool.booleanValue());
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class c extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f23928b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ vd.b f23929c;

        public class a extends EasySubscriber<Object> {
            public a() {
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                HuobiToastUtil.v(MarketInfoActivity.this.getString(R$string.market_delete_collection_success));
                MarketInfoActivity.this.f23911d.setSelected(false);
                vd.b bVar = c.this.f23929c;
                if (bVar != null) {
                    bVar.a(false);
                }
            }
        }

        public c(String str, vd.b bVar) {
            this.f23928b = str;
            this.f23929c = bVar;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (aPIStatusErrorException == null || !"11302".equals(aPIStatusErrorException.getErrCode())) {
                super.onFailed(aPIStatusErrorException);
            } else {
                i.a().b().q(MarketInfoActivity.this, TradeType.PRO.toString(), this.f23928b).subscribe(new a());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.v(MarketInfoActivity.this.getString(R$string.market_delete_collection_success));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(View view) {
        i.a().b().x(Ch(getPresenter().i0(), getPresenter().c0()), Bh(getPresenter().i0()), this, getPresenter().h0());
        i.a().b().d("3111", (Map<String, Object>) null, Eh() ? "1005015" : "1005005");
        BaseModuleConfig.a().w("App_markets_kline_remind_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gh(Object obj) {
        HuobiToastUtil.v(getString(R$string.market_add_collection_success));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(boolean z11, Throwable th2) {
        if (z11) {
            xh(getPresenter().j0(), (vd.b) null);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ih(View view) {
        doShare();
        BaseModuleConfig.a().w("App_markets_kline_share_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        if (!TradeType.isIndex(getPresenter().i0()) && !TradeType.isContractIndex(getPresenter().i0()) && !TradeType.isLinearSwapIndex(getPresenter().i0())) {
            Rh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        if (!TradeType.isIndex(getPresenter().i0()) && !TradeType.isContractIndex(getPresenter().i0()) && !TradeType.isLinearSwapIndex(getPresenter().i0())) {
            Rh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        ee.a.a(this, !KLineHelper.f() ? 1 : 0, getString(R$string.n_option_delivery_tip), getString(R$string.n_trade_innovate_risk_tips), (String) null, (String) null, getString(R$string.n_copy_trading_i_got_it), (DialogUtils.b.f) null, r0.f24262a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oh(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            if (this.f23923p == null) {
                View E = this.f23922o.E("currency_notice.xml", getActivity(), false, (JSONObject) null);
                this.f23923p = E;
                this.f23921n.addView(E);
            }
            this.f23921n.setVisibility(0);
            return;
        }
        this.f23921n.setVisibility(8);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Sh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        boolean z11 = !this.f23911d.isSelected();
        this.f23911d.setSelected(z11);
        BaseModuleConfig.a().w("App_markets_kline_focus_click", (HashMap) null);
        if (!z11) {
            i.a().b().g(getPresenter().j0(), new i0(this));
        } else if (!TextUtils.isEmpty(getPresenter().j0())) {
            i.a().b().C(getUI(), getPresenter().i0(), getPresenter().j0()).subscribe(EasySubscriber.create(new s0(this)));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Ah */
    public MarketInfoPresenter getPresenter() {
        return (MarketInfoPresenter) super.getPresenter();
    }

    public final RemindBusinessType Bh(String str) {
        if (TradeType.CONTRACT.toString().equals(str)) {
            return RemindBusinessType.CONTRACT;
        }
        if (TradeType.SWAP.toString().equals(str)) {
            return RemindBusinessType.SWAP;
        }
        if (TradeType.LINEAR_SWAP.toString().equals(str)) {
            return RemindBusinessType.LINEAR_SWAP;
        }
        return null;
    }

    public final RemindContractType Ch(String str, String str2) {
        if (TradeType.CONTRACT.toString().equals(str)) {
            RemindContractType remindContractType = RemindContractType.TYPE_CURRENT_WEEK;
            if (TextUtils.isEmpty(str2)) {
                str2 = getPresenter().h0();
            }
            if (str2.contains("NQ")) {
                return RemindContractType.TYPE_NEXT_SEASON;
            }
            if (str2.contains("CQ")) {
                return RemindContractType.TYPE_CURRENT_SEASON;
            }
            if (str2.contains("NW")) {
                return RemindContractType.TYPE_NEXT_WEEK;
            }
            return remindContractType;
        } else if (TradeType.SWAP.toString().equals(str)) {
            return RemindContractType.TYPE_SWAP;
        } else {
            if (TradeType.LINEAR_SWAP.toString().equals(str)) {
                return RemindContractType.TYPE_LINEAR_SWAP;
            }
            return null;
        }
    }

    /* renamed from: Dh */
    public MarketInfoPresenter.e getUI() {
        return this;
    }

    public final boolean Eh() {
        return TradeType.isContract(getPresenter().i0()) || TradeType.isSwap(getPresenter().i0()) || TradeType.isOption(getPresenter().i0()) || TradeType.isLinearSwap(getPresenter().i0());
    }

    public void I6(int i11) {
        try {
            ((RedPointPagerTitleView) this.f23918k.getmCommonNavigator().d(i11)).a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void P7(List<String> list) {
        this.f23918k.setCapitalTitle(false);
        this.f23918k.setDataList(list);
        ViewPagerHelper.a(this.f23918k, this.f23913f);
    }

    public void Pc() {
        if (TradeType.isIndex(getPresenter().i0()) || TradeType.isContractIndex(getPresenter().i0()) || TradeType.isLinearSwapIndex(getPresenter().i0())) {
            ViewUtil.m(this.f23919l, false);
        }
    }

    public final void Ph() {
        if (TradeType.isOption(getPresenter().i0())) {
            ViewUtil.m(this.f23910c, false);
        } else if (i.a().b().a(getPresenter().i0())) {
            ViewUtil.m(this.f23910c, true);
            i.a().b().s(Ch(getPresenter().i0(), getPresenter().c0()), this, getPresenter().h0()).subscribe(new b());
        } else {
            ViewUtil.m(this.f23910c, false);
        }
    }

    public void Qh() {
        this.f23920m = null;
    }

    public final void Rh() {
        if (getPresenter().m0()) {
            this.f23920m = i.a().b().u(!KLineHelper.f(), this, getPresenter(), this.f23920m, TradeType.GRID.toString());
            return;
        }
        TradeType valueOf = TradeType.valueOf(getPresenter().i0());
        if (valueOf == TradeType.PRO || valueOf == TradeType.MARGIN || valueOf == TradeType.SUPERMARGIN || valueOf == TradeType.CONTRACT || valueOf == TradeType.SWAP || valueOf == TradeType.LINEAR_SWAP) {
            this.f23920m = i.a().b().w(!KLineHelper.f(), this, getPresenter(), this.f23920m, getPresenter().i0());
            return;
        }
        this.f23920m = i.a().b().u(!KLineHelper.f(), this, getPresenter(), this.f23920m, getPresenter().i0());
    }

    public void Sh() {
        showProgressDialog();
        i.a().b().o(this, getPresenter().h0(), this.f23916i, getPresenter().i0());
    }

    public final void Th() {
        if (KLineHelper.e() != null) {
            KLineHelper.e().a(this, this.f23917j, "kline_detail");
        }
    }

    public final void Uh(boolean z11) {
        if (z11) {
            ImageView imageView = this.f23910c;
            if (imageView != null) {
                imageView.setImageResource(R$drawable.kline_remind_bell_selected);
                return;
            }
            return;
        }
        ImageView imageView2 = this.f23910c;
        if (imageView2 != null) {
            imageView2.setImageResource(zh(R$attr.kline_remind_bell));
        }
    }

    public void W6(boolean z11, boolean z12, boolean z13) {
        CommonNavigator commonNavigator = this.f23918k.getmCommonNavigator();
        List<String> list = this.f23918k.getList();
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < list.size(); i14++) {
            if (list.get(i14).equalsIgnoreCase(getResources().getString(R$string.n_content_comment))) {
                i11 = i14;
            } else if (list.get(i14).equalsIgnoreCase(getResources().getString(R$string.n_content_newsflash))) {
                i13 = i14;
            } else if (list.get(i14).equalsIgnoreCase(getResources().getString(R$string.n_content_deep_news))) {
                i12 = i14;
            }
        }
        if (z11 && i11 >= 0) {
            ((RedPointPagerTitleView) commonNavigator.d(i11)).c();
        }
        if (z12 && i13 >= 0) {
            ((RedPointPagerTitleView) commonNavigator.d(i13)).c();
        }
        if (z13 && i12 >= 0) {
            ((RedPointPagerTitleView) commonNavigator.d(i12)).c();
        }
    }

    public void X9(SymbolBean symbolBean) {
        if (symbolBean != null && symbolBean.isStTag()) {
            ViewUtil.m(this.f23915h, true);
            this.f23915h.setImageResource(R$drawable.market_st);
        } else if (symbolBean == null || !symbolBean.isInnovateTag()) {
            ViewUtil.m(this.f23915h, false);
        } else {
            ViewUtil.m(this.f23915h, true);
            this.f23915h.setImageResource(R$drawable.market_innovate);
            this.f23915h.setOnClickListener(new p0(this));
        }
    }

    public void Zg(TradeType tradeType, boolean z11) {
        d.b("KlineConfig-->onDataObserver--> onMarketCompareDataResponse: " + z11);
        dismissProgressDialog();
        if (z11) {
            this.f23916i = i.a().b().F(!KLineHelper.f(), this, getPresenter().h0(), this.f23916i, getPresenter().i0());
            return;
        }
        HuobiToastUtil.m(getString(R$string.n_market_compare_empty_toast));
    }

    public void a7(Boolean bool) {
        this.f23911d.setSelected(bool.booleanValue());
        if (!bool.booleanValue() && !this.f23925r) {
            this.f23925r = true;
            n.o().C(this, this.f23911d, this.f23924q);
        }
    }

    public void addEvent() {
        this.f23909b.setOnClickListener(new q0(this));
        this.f23910c.setOnClickListener(new m0(this));
        this.f23911d.setOnClickListener(new o0(this));
        this.f23912e.setOnClickListener(new n0(this));
        this.f23918k.setCallback(new a());
        this.f23914g.setOnClickListener(new k0(this));
        this.f23919l.setOnClickListener(new h0(this));
        this.viewFinder.b(R$id.home_up).setOnClickListener(new l0(this));
    }

    public final void doShare() {
        Th();
    }

    public void finish() {
        KLineHelper.i();
        super.finish();
    }

    public ViewPager g3() {
        return this.f23913f;
    }

    public Activity getActivity() {
        return this;
    }

    public int getContentView() {
        return R$layout.activity_market_info;
    }

    public void initView() {
        setStatusBarColor(yh(R$attr.kline_activity_background_color));
        if (KLineHelper.f()) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 16);
        }
        getWindow().setNavigationBarColor(yh(R$attr.kline_content_background_color));
        this.f23914g = (TextView) this.viewFinder.b(R$id.market_info_symbol);
        this.f23915h = (ImageView) this.viewFinder.b(R$id.market_info_tag_icon);
        this.f23919l = this.viewFinder.b(R$id.image_view_kline_title_icon);
        this.f23909b = (ImageView) this.viewFinder.b(R$id.image_view_pk_title_icon);
        this.f23910c = (ImageView) this.viewFinder.b(R$id.image_view_remind_title_icon);
        this.f23911d = (ImageView) this.viewFinder.b(R$id.image_view_kline_collection);
        this.f23912e = (ImageView) this.viewFinder.b(R$id.image_view_kline_share);
        this.f23913f = (ViewPager) this.viewFinder.b(R$id.view_pager_kline_content);
        this.f23917j = (ViewGroup) this.viewFinder.b(R$id.rl_market_info_root);
        CommonTextListIndicator commonTextListIndicator = (CommonTextListIndicator) this.viewFinder.b(R$id.common_text_list_indicator);
        this.f23918k = commonTextListIndicator;
        commonTextListIndicator.setShowRedPoint(true);
        this.f23921n = (FrameLayout) this.viewFinder.b(R$id.currency_notice);
        this.f23918k.setTitleViewSelectColor(yh(R$attr.base_color_primary_text));
        this.f23918k.setTitleViewNormalColor(yh(R$attr.base_color_secondary_textNew));
    }

    public boolean isLightStatusBar() {
        return !KLineHelper.f();
    }

    public void onBackPressed() {
        KLineHelper.i();
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        if (KLineHelper.f()) {
            setTheme(R$style.ActivityKlineLight);
        } else {
            setTheme(R$style.ActivityKlineNight);
        }
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable((Drawable) null);
        if (getPresenter().i0().equals("PRO")) {
            this.f23909b.setVisibility(8);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        rj.b bVar = this.f23922o;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.addFlags(65536);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    public void onPause() {
        super.onPause();
        DialogFragment dialogFragment = this.f23920m;
        if (dialogFragment != null && dialogFragment.isVisible()) {
            this.f23920m.dismiss();
        }
    }

    public void onResume() {
        super.onResume();
        Ph();
    }

    public void onStop() {
        super.onStop();
        n.o().B(this.f23911d);
    }

    public void pe(String str, int i11) {
        if (!TextUtils.isEmpty(str) && !ReviewManger.a()) {
            rj.b bVar = new rj.b(this, FirebaseAnalytics.Param.CURRENCY);
            this.f23922o = bVar;
            bVar.t("openNoticeUrl", CurrencyNoticeAbility.class);
            this.f23922o.H();
            this.f23922o.I("currencyNoticeMessage('" + str + "','" + i11 + "')");
            if (KLineHelper.f()) {
                this.f23922o.I("setDarkMode(0)");
            } else {
                this.f23922o.I("setDarkMode(1)");
            }
            this.f23922o.v("visibility", new j0(this));
        }
    }

    public void qg(SymbolBean symbolBean) {
        if (symbolBean == null || symbolBean.getTradeOpenAt() <= 0 || !symbolBean.getState().equalsIgnoreCase(SymbolBean.PRE_ONLINE) || symbolBean.getTradeOpenAt() <= DateTimeUtils.v()) {
            this.f23924q = 30000;
        } else {
            this.f23924q = 0;
        }
    }

    public void te(boolean z11) {
        ViewUtil.m(this.f23909b, z11);
    }

    public void ub(String str) {
        if (this.f23915h.getVisibility() == 0 && str != null) {
            if (str.length() <= 12) {
                this.f23914g.setTextSize(1, 20.0f);
            } else if (str.length() <= 15) {
                this.f23914g.setTextSize(1, 16.0f);
            } else {
                this.f23914g.setTextSize(1, 12.0f);
            }
        }
        this.f23914g.setText(str);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    /* renamed from: wh */
    public MarketInfoPresenter createPresenter() {
        return new MarketInfoPresenter();
    }

    public void xh(String str, vd.b bVar) {
        i.a().b().q(this, getPresenter().i0(), str).subscribe(new c(str, bVar));
    }

    public int yh(int i11) {
        if (getActivity() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    public void zc() {
        if (this.f23912e.getParent() != null) {
            ((ViewGroup) this.f23912e.getParent()).removeView(this.f23912e);
        }
        if (this.f23909b.getParent() != null) {
            ((ViewGroup) this.f23909b.getParent()).removeView(this.f23909b);
        }
        for (int childCount = this.f23917j.getChildCount() - 1; childCount >= 0; childCount--) {
            if (this.f23917j.getChildAt(childCount).getId() != R$id.layout_head_top) {
                ViewGroup viewGroup = this.f23917j;
                viewGroup.removeView(viewGroup.getChildAt(childCount));
            }
        }
        this.f23917j.addView(BaseModuleConfig.a().V(this), new ViewGroup.LayoutParams(-1, -1));
    }

    public int zh(int i11) {
        if (getActivity() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }
}
