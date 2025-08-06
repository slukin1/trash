package com.hbg.lite.market;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;
import com.hbg.lib.network.otc.core.bean.LiteMarketPrice;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.widgets.CommonShimmerLayout;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.ticker.TickerUtils;
import com.hbg.lib.widgets.ticker.TickerView;
import com.hbg.lite.R$array;
import com.hbg.lite.R$color;
import com.hbg.lite.R$dimen;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.base.LiteBaseActivity;
import com.hbg.lite.market.LiteMarketInfoPresenter;
import com.hbg.lite.market.bean.MarketDetailBean;
import com.hbg.lite.market.widget.ListenableScrollView;
import com.hbg.lite.market.widget.LiteBuyDialogFragment;
import com.hbg.lite.market.widget.LiteSellDialogFragment;
import com.hbg.lite.market.widget.LiteTradingView;
import com.hbg.lite.market.widget.RectTabLayout;
import com.hbg.lite.record.ui.AllCurrencyRecordActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import gb.e;
import gb.f;
import gb.g;
import gb.h;
import gb.i;
import gb.j;
import gb.k;
import gb.l;
import i6.d;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class LiteMarketInfoActivity extends LiteBaseActivity<LiteMarketInfoPresenter, LiteMarketInfoPresenter.h> implements LiteMarketInfoPresenter.h, RectTabLayout.a {
    public ImageView A;
    public TextView B;
    public TextView C;
    public View D;
    public LiteTradingView E;

    /* renamed from: b  reason: collision with root package name */
    public TextView f77184b;

    /* renamed from: c  reason: collision with root package name */
    public TickerView f77185c;

    /* renamed from: d  reason: collision with root package name */
    public View f77186d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77187e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f77188f;

    /* renamed from: g  reason: collision with root package name */
    public int f77189g;

    /* renamed from: h  reason: collision with root package name */
    public int f77190h;

    /* renamed from: i  reason: collision with root package name */
    public RectTabLayout f77191i;

    /* renamed from: j  reason: collision with root package name */
    public List<MarketDetailBean> f77192j;

    /* renamed from: k  reason: collision with root package name */
    public Button f77193k;

    /* renamed from: l  reason: collision with root package name */
    public Button f77194l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f77195m;

    /* renamed from: n  reason: collision with root package name */
    public LiteBuyDialogFragment f77196n = new LiteBuyDialogFragment();

    /* renamed from: o  reason: collision with root package name */
    public LiteSellDialogFragment f77197o = new LiteSellDialogFragment();

    /* renamed from: p  reason: collision with root package name */
    public FrameLayout f77198p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f77199q;

    /* renamed from: r  reason: collision with root package name */
    public ListenableScrollView f77200r;

    /* renamed from: s  reason: collision with root package name */
    public View f77201s;

    /* renamed from: t  reason: collision with root package name */
    public CommonShimmerLayout f77202t;

    /* renamed from: u  reason: collision with root package name */
    public LoadingView f77203u;

    /* renamed from: v  reason: collision with root package name */
    public ConstraintLayout f77204v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f77205w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f77206x;

    /* renamed from: y  reason: collision with root package name */
    public AnimatorSet f77207y;

    /* renamed from: z  reason: collision with root package name */
    public ObjectAnimator f77208z;

    public class a implements CommonShimmerLayout.a {
        public a() {
        }

        public void a(int i11, View view) {
            view.setBackgroundResource(R$drawable.lite_shape_rect_solid_bg);
            view.setAlpha(0.5f);
        }

        public Animator b(int i11, View view) {
            return null;
        }
    }

    public class b implements LiteTradingView.b {

        /* renamed from: a  reason: collision with root package name */
        public MarketDetailBean f77210a;

        public b() {
        }

        public void a(MarketDetailBean marketDetailBean) {
            boolean z11 = true;
            if (marketDetailBean == null) {
                LiteMarketPrice r02 = ((LiteMarketInfoPresenter) LiteMarketInfoActivity.this.getPresenter()).r0();
                if (r02 != null) {
                    LiteMarketInfoActivity liteMarketInfoActivity = LiteMarketInfoActivity.this;
                    String price = r02.getPrice();
                    String change = r02.getChange();
                    if (this.f77210a == null) {
                        z11 = false;
                    }
                    liteMarketInfoActivity.Sh(price, change, z11);
                }
            } else {
                LiteMarketInfoActivity liteMarketInfoActivity2 = LiteMarketInfoActivity.this;
                String price2 = marketDetailBean.getPrice();
                String c11 = c(marketDetailBean.getDoublePrice());
                if (this.f77210a != null) {
                    z11 = false;
                }
                liteMarketInfoActivity2.Sh(price2, c11, z11);
            }
            this.f77210a = marketDetailBean;
        }

        public String b() {
            int mCurrentIndex = LiteMarketInfoActivity.this.f77191i.getMCurrentIndex();
            if (mCurrentIndex == 0 || mCurrentIndex == 1) {
                return "HH:mm";
            }
            return mCurrentIndex != 4 ? "HH:mm MM/dd" : "yyyy/MM/dd";
        }

        public final String c(double d11) {
            if (CollectionsUtils.b(LiteMarketInfoActivity.this.f77192j)) {
                return "";
            }
            BigDecimal a11 = m.a(String.valueOf(((MarketDetailBean) LiteMarketInfoActivity.this.f77192j.get(0)).getDoublePrice()));
            return m.S(m.a(String.valueOf(d11)).subtract(a11).divide(a11, 6, RoundingMode.HALF_DOWN).doubleValue(), 2).replace("%", "");
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            LiteMarketInfoActivity liteMarketInfoActivity = LiteMarketInfoActivity.this;
            ObjectAnimator unused = liteMarketInfoActivity.f77208z = ObjectAnimator.ofFloat(liteMarketInfoActivity.f77204v, View.TRANSLATION_Y, new float[]{(float) (-PixelUtils.a(6.0f)), 0.0f});
            LiteMarketInfoActivity.this.f77208z.setInterpolator(new AccelerateDecelerateInterpolator());
            LiteMarketInfoActivity.this.f77208z.setDuration(800);
            LiteMarketInfoActivity.this.f77208z.setRepeatMode(2);
            LiteMarketInfoActivity.this.f77208z.setRepeatCount(-1);
            LiteMarketInfoActivity.this.f77208z.start();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh() {
        this.f77185c.setMaxWidth((((float) this.D.getWidth()) - (getResources().getDimension(R$dimen.dimen_15) * 2.0f)) - ((float) this.f77186d.getWidth()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(int i11) {
        boolean z11 = true;
        ViewUtil.n(this.f77201s, i11 > 0);
        TextView textView = this.C;
        if (i11 <= 0) {
            z11 = false;
        }
        ViewUtil.m(textView, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        xa.a.c(this, new Intent(this, AllCurrencyRecordActivity.class));
        ra.c.c().l("231", (Map<String, Object>) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kh(String str) {
        if (((float) this.f77205w.getWidth()) > ((float) this.f77193k.getWidth()) + getResources().getDimension(R$dimen.dimen_10)) {
            this.f77205w.setVisibility(8);
            this.f77206x.setVisibility(0);
            this.f77206x.setText(str);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        ra.c.c().n("189", ((LiteMarketInfoPresenter) getPresenter()).s0());
        this.f77196n.dismiss();
        mc(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(View view) {
        ra.c.c().n("190", ((LiteMarketInfoPresenter) getPresenter()).s0());
        this.f77196n.dismiss();
        Gh(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        ra.c.c().n("192", ((LiteMarketInfoPresenter) getPresenter()).s0());
        this.f77197o.dismiss();
        Gh(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        ra.c.c().n("191", ((LiteMarketInfoPresenter) getPresenter()).s0());
        this.f77197o.dismiss();
        mc(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ph(TeachConfigItem teachConfigItem, View view) {
        ra.c.b().c(this, teachConfigItem.getVideoUrl(), teachConfigItem.getVideoTitle());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        DialogUtils.X(this, getString(R$string.lite_market_info_price_notice_title), getString(R$string.lite_market_info_price_notice_content), (String) null, getString(R$string.allow_access_dialog_positive_btn), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        ((LiteMarketInfoPresenter) getPresenter()).p0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        ((LiteMarketInfoPresenter) getPresenter()).E0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Ah() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.height = (int) (((double) PixelUtils.f()) * 0.4d);
        this.E.setLayoutParams(layoutParams);
    }

    /* renamed from: Bh */
    public LiteMarketInfoPresenter createPresenter() {
        return new LiteMarketInfoPresenter();
    }

    public final void Ch() {
        if (this.f77204v.getVisibility() == 0) {
            this.f77204v.setVisibility(8);
            if (ra.c.c().p()) {
                ConfigPreferences.l("user_config", Dh(), System.currentTimeMillis());
            }
        }
    }

    public void D9(String str, String str2, boolean z11) {
        if (!this.E.C()) {
            Sh(str, str2, z11);
        }
    }

    public final String Dh() {
        return "LITE_BUBBLE_BUY_TIPS";
    }

    public final int Eh(double d11) {
        if (d11 > 0.0d) {
            return this.f77189g;
        }
        if (d11 < 0.0d) {
            return this.f77190h;
        }
        return getResources().getColor(R$color.baseColorDefaultPlaceholder);
    }

    public void Fe(OtcMarketCoinInfo.CoinInfo coinInfo) {
        this.f77196n.th(new e(this));
        this.f77196n.uh(new f(this));
        this.f77196n.show(getSupportFragmentManager(), "lite_buy_tag");
    }

    /* renamed from: Fh */
    public LiteMarketInfoPresenter.h getUI() {
        return this;
    }

    public void Gh(boolean z11) {
        if (((LiteMarketInfoPresenter) getPresenter()).q0() != null) {
            String f11 = va.b.o().f("usdt");
            nb.c.g(this, f11, ((LiteMarketInfoPresenter) getPresenter()).q0().getCoinId() + "", z11);
            if (z11) {
                Ch();
            }
            finish();
        }
    }

    public void Nc() {
        long h11 = ConfigPreferences.h("user_config", Dh());
        boolean equals = DateTimeUtils.h(System.currentTimeMillis(), "yyyy.MM.dd").equals(DateTimeUtils.h(h11, "yyyy.MM.dd"));
        if (h11 == 0 || !equals) {
            ((LiteMarketInfoPresenter) getPresenter()).w0();
        }
    }

    public void Qh(boolean z11) {
        d.b("LiteMarketInfoActivity-->setProgressVisible-->" + z11);
        ViewUtil.m(this.viewFinder.b(R$id.id_lite_market_info_loading_layout), z11);
        if (z11) {
            this.f77203u.c();
        } else {
            this.f77203u.d();
        }
    }

    public final void Rh() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f77204v, View.TRANSLATION_Y, new float[]{(float) PixelUtils.a(50.0f), (float) (-PixelUtils.a(6.0f))});
        ofFloat.setDuration(500);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f77204v, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(300);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f77207y = animatorSet;
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.f77207y.setInterpolator(new DecelerateInterpolator());
        this.f77207y.addListener(new c());
        this.f77207y.start();
    }

    public final void Sh(String str, String str2, boolean z11) {
        String str3;
        try {
            this.f77185c.k(va.b.n(sa.a.c()) + " " + str, z11);
            if (Double.parseDouble(str2) == 0.0d) {
                str3 = str2.replace("+", "").replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            } else if (str2.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) || str2.startsWith("+")) {
                str3 = str2;
            } else {
                str3 = "+" + str2;
            }
            this.f77187e.setText(String.format("%s%%", new Object[]{str3}));
            this.f77187e.setTextColor(Eh(Double.parseDouble(str2)));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void Wb(View view, int i11) {
        if (getPresenter() != null) {
            ((LiteMarketInfoPresenter) getPresenter()).D0(i11);
        }
        this.E.i();
        LiteTradingView liteTradingView = this.E;
        boolean z11 = true;
        if (i11 > 1) {
            z11 = false;
        }
        liteTradingView.setEnableInstantPrice(z11);
    }

    public void Y7(TeachConfigItem teachConfigItem) {
        if (teachConfigItem != null && !TextUtils.isEmpty(teachConfigItem.getVideoPic()) && !TextUtils.isEmpty(teachConfigItem.getVideoUrl())) {
            this.f77198p.setVisibility(0);
            g6.b.c().h(this.f77195m, teachConfigItem.getVideoPic());
            this.f77198p.setOnClickListener(new gb.m(this, teachConfigItem));
        }
    }

    public void addEvent() {
        this.D.post(new gb.c(this));
        this.f77191i.setOnItemSelectedListener(this);
        this.f77186d.setOnClickListener(new k(this));
        this.E.setOnHighlightListener(new b());
        this.f77193k.setOnClickListener(new h(this));
        this.f77194l.setOnClickListener(new i(this));
        this.f77200r.setOnScrollListener(new gb.b(this));
        findViewById(R$id.iv_history).setOnClickListener(new j(this));
    }

    public void bd(MarketDetailBean marketDetailBean) {
        this.E.setInstantPrice(marketDetailBean);
    }

    public void d7(OtcMarketCoinInfo.CoinInfo coinInfo) {
        this.f77197o.sh(new gb.a(this));
        this.f77197o.th(new g(this));
        this.f77197o.show(getSupportFragmentManager(), "lite_sell_tag");
    }

    public void dismissProgressDialog() {
        Qh(false);
    }

    public int getContentView() {
        return R$layout.lite_activity_market_info;
    }

    public void initView() {
        ((Toolbar) this.viewFinder.b(R$id.toolbar)).setNavigationOnClickListener(new l(this));
        String[] stringArray = getResources().getStringArray(R$array.trade_info_tab_array);
        RectTabLayout rectTabLayout = (RectTabLayout) this.viewFinder.b(R$id.tab_layout);
        this.f77191i = rectTabLayout;
        rectTabLayout.setTabNames(stringArray);
        this.f77189g = getResources().getColor(R$color.base_up_color);
        this.f77190h = getResources().getColor(R$color.base_down_color);
        this.E = (LiteTradingView) this.viewFinder.b(R$id.lite_trading_view);
        ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
        layoutParams.height = (int) (((float) PixelUtils.f()) * 0.5f);
        this.E.setLayoutParams(layoutParams);
        this.E.setCurrencySymbol(va.b.n(sa.a.c()));
        Ah();
        this.f77184b = (TextView) this.viewFinder.b(R$id.tv_title);
        this.C = (TextView) this.viewFinder.b(R$id.tv_header_title);
        this.B = (TextView) this.viewFinder.b(R$id.tv_full_title);
        this.A = (ImageView) this.viewFinder.b(R$id.iv_coin);
        TickerView tickerView = (TickerView) this.viewFinder.b(R$id.tv_price);
        this.f77185c = tickerView;
        tickerView.setCharacterLists(TickerUtils.b());
        this.f77185c.setAnimationInterpolator(new DecelerateInterpolator());
        this.f77185c.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/din_medium.otf"));
        this.f77186d = this.viewFinder.b(R$id.iv_price_more);
        this.f77187e = (TextView) this.viewFinder.b(R$id.tv_change_percent);
        this.f77199q = (TextView) this.viewFinder.b(R$id.tv_desc_title);
        this.f77188f = (TextView) this.viewFinder.b(R$id.tv_desc_content);
        this.f77195m = (ImageView) this.viewFinder.b(R$id.iv_video);
        this.f77198p = (FrameLayout) this.viewFinder.b(R$id.fl_video_container);
        this.f77203u = (LoadingView) this.viewFinder.b(R$id.id_lite_market_info_loading_view);
        this.f77193k = (Button) this.viewFinder.b(R$id.btn_buy);
        this.f77194l = (Button) this.viewFinder.b(R$id.btn_sell);
        this.f77200r = (ListenableScrollView) this.viewFinder.b(R$id.sv_content);
        this.f77201s = this.viewFinder.b(R$id.title_divider);
        CommonShimmerLayout commonShimmerLayout = (CommonShimmerLayout) this.viewFinder.b(R$id.id_lite_market_info_shimmer_layout);
        this.f77202t = commonShimmerLayout;
        commonShimmerLayout.setCallback(new a());
        this.f77204v = (ConstraintLayout) this.viewFinder.b(R$id.cl_bubble);
        this.f77205w = (TextView) this.viewFinder.b(R$id.tv_buy_tips);
        this.f77206x = (TextView) this.viewFinder.b(R$id.tv_buy_tips_2);
        this.D = findViewById(R$id.tv_price_layout);
    }

    public void jd(String str) {
        this.f77204v.setVisibility(0);
        this.f77205w.setText(str);
        this.f77205w.post(new gb.d(this, str));
        Rh();
    }

    public void mc(boolean z11) {
        if (((LiteMarketInfoPresenter) getPresenter()).q0() != null) {
            String c11 = sa.a.c();
            nb.c.f(this, c11, ((LiteMarketInfoPresenter) getPresenter()).q0().getCoinId() + "", z11);
            if (z11) {
                Ch();
            }
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f77191i.setCurrentItem(1);
    }

    public void onDestroy() {
        super.onDestroy();
        AnimatorSet animatorSet = this.f77207y;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f77207y.cancel();
        }
        ObjectAnimator objectAnimator = this.f77208z;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f77208z.cancel();
        }
    }

    public void showProgressDialog() {
        Qh(true);
    }

    public void wf(String str) {
        this.f77199q.setText(String.format(getString(R$string.lite_market_coin_desc_title), new Object[]{StringUtils.i(((LiteMarketInfoPresenter) getPresenter()).s0())}));
        this.f77188f.setText(str);
        this.f77202t.h();
    }

    public void x7() {
        CommonShimmerLayout commonShimmerLayout = this.f77202t;
        int i11 = R$id.tv_desc_title;
        Resources resources = getResources();
        int i12 = R$dimen.dimen_98;
        commonShimmerLayout.c(new CommonShimmerLayout.b(i11, resources.getDimensionPixelOffset(i12), getResources().getDimensionPixelOffset(R$dimen.dimen_28), 0, false, false));
        CommonShimmerLayout commonShimmerLayout2 = this.f77202t;
        Resources resources2 = getResources();
        int i13 = R$dimen.dimen_16;
        commonShimmerLayout2.c(new CommonShimmerLayout.b(2, -1, resources2.getDimensionPixelOffset(i13), getResources().getDimensionPixelOffset(R$dimen.dimen_50), false, true));
        this.f77202t.c(new CommonShimmerLayout.b(3, -1, getResources().getDimensionPixelOffset(i13), getResources().getDimensionPixelOffset(R$dimen.dimen_74), false, true));
        this.f77202t.c(new CommonShimmerLayout.b(4, getResources().getDimensionPixelOffset(R$dimen.dimen_110), getResources().getDimensionPixelOffset(i13), getResources().getDimensionPixelOffset(i12), false, true));
        this.f77202t.c(new CommonShimmerLayout.b(5, -1, getResources().getDimensionPixelOffset(i13), getResources().getDimensionPixelOffset(R$dimen.dimen_122), false, true));
        this.f77202t.c(new CommonShimmerLayout.b(6, -1, getResources().getDimensionPixelOffset(i13), getResources().getDimensionPixelOffset(R$dimen.dimen_146), false, true));
        CommonShimmerLayout commonShimmerLayout3 = this.f77202t;
        Resources resources3 = getResources();
        int i14 = R$dimen.dimen_220;
        commonShimmerLayout3.c(new CommonShimmerLayout.b(7, resources3.getDimensionPixelOffset(i14), getResources().getDimensionPixelOffset(i13), getResources().getDimensionPixelOffset(R$dimen.dimen_170), false, true));
        this.f77202t.c(new CommonShimmerLayout.b(8, getResources().getDimensionPixelOffset(i14), getResources().getDimensionPixelOffset(i13), getResources().getDimensionPixelOffset(R$dimen.dimen_194), false, true));
        this.f77202t.c(new CommonShimmerLayout.b(9, -1, getResources().getDimensionPixelOffset(i13), getResources().getDimensionPixelOffset(R$dimen.dimen_218), false, true));
        this.f77202t.i();
    }

    public void z9(List<MarketDetailBean> list) {
        this.f77192j = list;
        this.E.setData(list);
    }
}
