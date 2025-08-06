package com.huobi.finance.ui;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.presenter.LoanSymbolDetailPresenter;
import com.huobi.finance.utils.UiFillUtil;
import com.huobi.finance.widget.DetailRiskPanel;
import com.huobi.main.helper.MarginUtil;
import com.huobi.margin.ui.MarginRiskRateUI;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.utils.k0;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.huobi.view.title.HbTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;
import pro.huobi.R;
import yl.x;

public class LoanSymbolDetailActivity extends BaseActivity<LoanSymbolDetailPresenter, LoanSymbolDetailPresenter.b> implements LoanSymbolDetailPresenter.b {
    public CoordinatorLayout A;
    public RelativeLayout B;
    public TextView C;
    public TextView D;
    public View E;
    public AppBarLayout F;
    public float G;
    public Animation H;
    public Animation I;
    public String J;
    public DetailRiskPanel K;
    public HbTitleBar L;

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f46620b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f46621c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f46622d;

    /* renamed from: e  reason: collision with root package name */
    public MarginRiskRateUI f46623e;

    /* renamed from: f  reason: collision with root package name */
    public View f46624f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46625g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46626h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46627i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46628j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f46629k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f46630l;

    /* renamed from: m  reason: collision with root package name */
    public View f46631m;

    /* renamed from: n  reason: collision with root package name */
    public View f46632n;

    /* renamed from: o  reason: collision with root package name */
    public View f46633o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f46634p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f46635q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f46636r;

    /* renamed from: s  reason: collision with root package name */
    public String f46637s;

    /* renamed from: t  reason: collision with root package name */
    public String f46638t;

    /* renamed from: u  reason: collision with root package name */
    public String f46639u;

    /* renamed from: v  reason: collision with root package name */
    public String f46640v;

    /* renamed from: w  reason: collision with root package name */
    public String f46641w;

    /* renamed from: x  reason: collision with root package name */
    public Toolbar f46642x;

    /* renamed from: y  reason: collision with root package name */
    public AppBarLayout f46643y;

    /* renamed from: z  reason: collision with root package name */
    public CollapsingToolbarLayout f46644z;

    public class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public float f46645b;

        /* renamed from: c  reason: collision with root package name */
        public float f46646c;

        /* renamed from: d  reason: collision with root package name */
        public int f46647d;

        /* renamed from: e  reason: collision with root package name */
        public float f46648e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f46649f = true;

        public a() {
            this.f46647d = ViewConfiguration.get(LoanSymbolDetailActivity.this).getScaledTouchSlop();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                boolean z11 = true;
                if (action == 1) {
                    float y11 = motionEvent.getY();
                    this.f46645b = y11;
                    float f11 = this.f46646c - y11;
                    this.f46648e = f11;
                    if (Float.compare(Math.abs(f11), (float) this.f46647d) >= 0) {
                        if (this.f46648e >= 0.0f) {
                            z11 = false;
                        }
                        if (z11 != this.f46649f) {
                            this.f46649f = z11;
                            LoanSymbolDetailActivity.this.E.clearAnimation();
                            if (this.f46649f) {
                                LoanSymbolDetailActivity.this.E.startAnimation(LoanSymbolDetailActivity.this.H);
                            } else {
                                LoanSymbolDetailActivity.this.E.startAnimation(LoanSymbolDetailActivity.this.I);
                            }
                        }
                    }
                    this.f46646c = 0.0f;
                } else if (action == 2 && this.f46646c == 0.0f) {
                    this.f46646c = motionEvent.getY();
                }
            } else {
                this.f46646c = motionEvent.getY();
            }
            return false;
        }
    }

    public class b implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: b  reason: collision with root package name */
        public int f46651b;

        public b() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            int abs = Math.abs(i11);
            this.f46651b = abs;
            if (Float.compare((float) abs, LoanSymbolDetailActivity.this.G) < 0) {
                LoanSymbolDetailActivity.this.C.setVisibility(8);
            } else if (Float.compare((float) Math.abs(i11), LoanSymbolDetailActivity.this.G) < 0 || Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
                LoanSymbolDetailActivity.this.C.setText(R.string.loan_order_detail_loanposition);
                LoanSymbolDetailActivity.this.C.setVisibility(0);
            } else {
                LoanSymbolDetailActivity.this.C.setText(LoanSymbolDetailActivity.this.J != null ? LoanSymbolDetailActivity.this.J.toUpperCase(Locale.US) : "");
                LoanSymbolDetailActivity.this.C.setVisibility(0);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            MarginUtil.c(LoanSymbolDetailActivity.this.f46637s + LoanSymbolDetailActivity.this.f46638t);
            is.a.w("226", LoanSymbolDetailActivity.this.f46637s + LoanSymbolDetailActivity.this.f46638t);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        UnifyTransferActivity.Uh(this, this.f46638t, "3", false, this.f46639u, false);
        is.a.w("227", this.f46639u);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        k0.M(this.f46639u, "0", true, this);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void vh(View view) {
        zn.a.d().v(Uri.parse(String.format("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=leverHistory&navConfig=&tabType=0&modeType=%s&symbol=%s", new Object[]{"2", this.f46640v + this.f46641w}))).c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public RecyclerView Y0() {
        return this.f46622d;
    }

    public void addEvent() {
        this.f46622d.setOnTouchListener(new a());
        this.F.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
        this.f46644z.setDrawCollapsingMiddleTitle(false);
        this.f46631m.setOnClickListener(new c());
        this.f46632n.setOnClickListener(new m6(this));
        this.f46624f.setClickable(true);
        this.f46624f.setOnClickListener(new n6(this));
        this.f46633o.setClickable(true);
        this.f46633o.setOnClickListener(new o6(this));
    }

    public void bc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f46639u = str;
            a1 v11 = a1.v();
            TradeType tradeType = TradeType.PRO;
            this.f46637s = v11.o(str, tradeType);
            this.f46640v = a1.v().p(str);
            this.f46638t = a1.v().E(str, tradeType);
            this.f46641w = a1.v().F(str);
        }
    }

    public void c8() {
        this.f46643y.setExpanded(true, true);
    }

    public LoadingLayout f6() {
        return this.f46620b;
    }

    public void fc(MarginBalanceDetailInfo marginBalanceDetailInfo) {
        if (marginBalanceDetailInfo == null) {
            String u02 = m.u0("0.00", 12, 8);
            String B2 = LegalCurrencyConfigUtil.B("0");
            this.f46628j.setText(u02);
            this.f46630l.setText(u02);
            this.f46625g.setText(u02);
            this.f46627i.setText(u02);
            this.f46626h.setText(u02);
            this.f46629k.setText(u02);
            this.f46636r.setText(getString(R.string.balance_margin_item_estimate, new Object[]{B2, LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            String str = this.f46640v + "/" + this.f46641w;
            this.J = str;
            this.f46644z.setTitle(str);
            this.f46634p.setText(this.f46641w);
            this.f46635q.setText(this.f46640v);
            this.f46623e.g((String) null, (String) null);
            wh(this.J);
            this.K.setData((MarginOverview) null);
            return;
        }
        if (!uh(marginBalanceDetailInfo)) {
            this.K.setData(sh(marginBalanceDetailInfo));
        } else {
            this.K.setData((MarginOverview) null);
        }
        String u03 = m.u0(marginBalanceDetailInfo.getBaseCurrencyAvaiable(), 12, 8);
        String u04 = m.u0(marginBalanceDetailInfo.getBaseCurrencyLoaned(), 12, 8);
        this.f46628j.setText(u03);
        this.f46630l.setText(u04);
        String u05 = m.u0(marginBalanceDetailInfo.getQuoteCurrencyAvaiable(), 12, 8);
        String u06 = m.u0(marginBalanceDetailInfo.getQuoteCurrencyLoaned(), 12, 8);
        this.f46625g.setText(u05);
        this.f46627i.setText(u06);
        String u07 = m.u0(marginBalanceDetailInfo.getBaseCurrencyOnorders(), 12, 8);
        this.f46626h.setText(m.u0(marginBalanceDetailInfo.getQuoteCurrencyOnorders(), 12, 8));
        this.f46629k.setText(u07);
        this.f46637s = marginBalanceDetailInfo.getBaseCurrency();
        this.f46640v = marginBalanceDetailInfo.getBaseCurrencyDisplayName();
        this.f46638t = marginBalanceDetailInfo.getQuoteCurrency();
        this.f46641w = marginBalanceDetailInfo.getQuoteCurrencyDisplayName();
        String str2 = this.f46640v + "/" + this.f46641w;
        this.J = str2;
        Locale locale = Locale.US;
        wh(str2.toUpperCase(locale));
        this.f46634p.setText(this.f46641w);
        this.f46635q.setText(this.f46640v);
        this.f46636r.setText(getString(R.string.balance_margin_item_estimate, new Object[]{marginBalanceDetailInfo.getEstimateAmount(), LegalCurrencyConfigUtil.y().toUpperCase(locale)}));
    }

    public int getContentView() {
        return R.layout.activity_loan_symbol_detail;
    }

    public void initView() {
        removeWinBg();
        this.L = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f46620b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.C = (TextView) this.viewFinder.b(R.id.currency_detail_toolbar_title);
        this.D = (TextView) this.viewFinder.b(R.id.currency_detail_collapsing_toolbar_title);
        this.F = (AppBarLayout) this.viewFinder.b(R.id.currency_detail_appbar_layout);
        this.E = this.viewFinder.b(R.id.currency_detail_bottom_layout);
        this.f46622d = (RecyclerView) this.viewFinder.b(R.id.loan_symbol_detail_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f46622d.setLayoutManager(linearLayoutManager);
        this.f46622d.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_divider_color), PixelUtils.a(0.5f), false, true));
        this.f46621c = (SmartRefreshLayout) this.viewFinder.b(R.id.loan_symbol_detail_refresh_layout);
        this.f46625g = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_quote_avaialbe_amount);
        this.f46626h = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_quote_onorders_amount);
        this.f46627i = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_quote_loaned_amount);
        this.f46628j = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_base_avaialbe_amount);
        this.f46629k = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_base_onorders_amount);
        this.f46630l = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_base_loaned_amount);
        this.f46631m = this.viewFinder.b(R.id.loan_symbol_detail_loan);
        ViewUtil.m(this.viewFinder.b(R.id.ll_loan_symbol_detail_loan), !x.n().p());
        this.f46632n = this.viewFinder.b(R.id.loan_symbol_detail_transfer);
        this.f46643y = (AppBarLayout) this.viewFinder.b(R.id.currency_detail_appbar_layout);
        this.f46624f = this.viewFinder.b(R.id.loan_symbol_detail_detail);
        this.f46642x = (Toolbar) this.viewFinder.b(R.id.loan_order_detail_toolbar);
        this.f46644z = (CollapsingToolbarLayout) this.viewFinder.b(R.id.currency_detail_collapsing_toolbar);
        setToolBar(this.f46642x, "", true);
        this.f46635q = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_base_currency);
        this.f46634p = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_quote_currency);
        this.f46623e = (MarginRiskRateUI) this.viewFinder.b(R.id.loan_symbol_detail_margin_risk_rate);
        this.B = (RelativeLayout) this.viewFinder.b(R.id.loan_symbol_pending_layout);
        this.f46633o = this.viewFinder.b(R.id.loan_symbol_detail_trade);
        this.f46636r = (TextView) this.viewFinder.b(R.id.loan_symbol_detail_estimate);
        this.A = (CoordinatorLayout) this.viewFinder.b(R.id.cl_root);
        this.G = getResources().getDimension(R.dimen.dimen_44);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_enter_from_bottom);
        this.H = loadAnimation;
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.anim_exit_from_bottom);
        this.I = loadAnimation2;
        loadAnimation2.setFillAfter(true);
        this.K = (DetailRiskPanel) this.viewFinder.b(R.id.risk_panel);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            ((LoanSymbolDetailPresenter) getPresenter()).Z();
        }
    }

    public void onResume() {
        super.onResume();
    }

    /* renamed from: rh */
    public LoanSymbolDetailPresenter createPresenter() {
        return new LoanSymbolDetailPresenter();
    }

    public final MarginOverview sh(MarginBalanceDetailInfo marginBalanceDetailInfo) {
        String state = marginBalanceDetailInfo.getState();
        String riskRate = marginBalanceDetailInfo.getRiskRate();
        MarginOverview marginOverview = new MarginOverview();
        marginOverview.setTradeMargin(true);
        marginOverview.setRiskRate(riskRate);
        marginOverview.setRiskState(com.huobi.trade.helper.a.a(riskRate, state));
        return marginOverview;
    }

    public SmartRefreshLayout t2() {
        return this.f46621c;
    }

    /* renamed from: th */
    public LoanSymbolDetailPresenter.b getUI() {
        return this;
    }

    public final boolean uh(MarginBalanceDetailInfo marginBalanceDetailInfo) {
        return m.a(marginBalanceDetailInfo.getBaseCurrencyAvaiable()).add(m.a(marginBalanceDetailInfo.getBaseCurrencyOnorders())).add(m.a(marginBalanceDetailInfo.getQuoteCurrencyAvaiable())).add(m.a(marginBalanceDetailInfo.getQuoteCurrencyOnorders())).compareTo(BigDecimal.ZERO) == 0;
    }

    public final void wh(String str) {
        UiFillUtil.a(this.D, str);
        UiFillUtil.a(this.C, str);
        this.L.setTitle(str);
    }
}
