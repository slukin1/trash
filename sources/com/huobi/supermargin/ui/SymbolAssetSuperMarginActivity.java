package com.huobi.supermargin.ui;

import android.net.Uri;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.main.helper.MarginUtil;
import com.huobi.supermargin.presenter.SymbolAssetSuperMarginPresenter;
import com.huobi.utils.k0;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.huobi.view.title.HbTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.k;
import ms.l;
import pro.huobi.R;
import yl.x;

public class SymbolAssetSuperMarginActivity extends BaseActivity<SymbolAssetSuperMarginPresenter, SymbolAssetSuperMarginPresenter.f> implements SymbolAssetSuperMarginPresenter.f {
    public HbTitleBar A;

    /* renamed from: b  reason: collision with root package name */
    public TextView f81447b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f81448c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f81449d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f81450e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81451f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f81452g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f81453h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f81454i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f81455j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f81456k;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f81457l;

    /* renamed from: m  reason: collision with root package name */
    public Toolbar f81458m;

    /* renamed from: n  reason: collision with root package name */
    public CollapsingToolbarLayout f81459n;

    /* renamed from: o  reason: collision with root package name */
    public AppBarLayout f81460o;

    /* renamed from: p  reason: collision with root package name */
    public float f81461p;

    /* renamed from: q  reason: collision with root package name */
    public RecyclerView f81462q;

    /* renamed from: r  reason: collision with root package name */
    public SmartRefreshLayout f81463r;

    /* renamed from: s  reason: collision with root package name */
    public LoadingLayout f81464s;

    /* renamed from: t  reason: collision with root package name */
    public String f81465t;

    /* renamed from: u  reason: collision with root package name */
    public String f81466u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f81467v;

    /* renamed from: w  reason: collision with root package name */
    public View f81468w;

    /* renamed from: x  reason: collision with root package name */
    public Animation f81469x;

    /* renamed from: y  reason: collision with root package name */
    public Animation f81470y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f81471z;

    public class a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: b  reason: collision with root package name */
        public int f81472b;

        public a() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            int abs = Math.abs(i11);
            this.f81472b = abs;
            if (Float.compare((float) abs, SymbolAssetSuperMarginActivity.this.f81461p) < 0) {
                SymbolAssetSuperMarginActivity.this.f81471z.setVisibility(8);
            } else if (Float.compare((float) Math.abs(i11), SymbolAssetSuperMarginActivity.this.f81461p) < 0 || Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
                SymbolAssetSuperMarginActivity.this.f81471z.setText(R.string.loan_order_detail_loanposition);
                SymbolAssetSuperMarginActivity.this.f81471z.setVisibility(0);
            } else {
                SymbolAssetSuperMarginActivity.this.f81471z.setText(SymbolAssetSuperMarginActivity.this.f81466u);
                SymbolAssetSuperMarginActivity.this.f81471z.setVisibility(0);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SymbolAssetSuperMarginActivity symbolAssetSuperMarginActivity = SymbolAssetSuperMarginActivity.this;
            DialogUtils.X(symbolAssetSuperMarginActivity, symbolAssetSuperMarginActivity.getString(R.string.repay_text), SymbolAssetSuperMarginActivity.this.getString(R.string.repay_description), (String) null, SymbolAssetSuperMarginActivity.this.getString(R.string.showcase_know), ad.b.f3517a);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            MarginUtil.a(SymbolAssetSuperMarginActivity.this.f81465t);
            is.a.k("224", SymbolAssetSuperMarginActivity.this.f81465t);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SymbolAssetSuperMarginActivity symbolAssetSuperMarginActivity = SymbolAssetSuperMarginActivity.this;
            UnifyTransferActivity.Th(symbolAssetSuperMarginActivity, symbolAssetSuperMarginActivity.f81465t, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
            is.a.k("225", SymbolAssetSuperMarginActivity.this.f81465t);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            k0.R(a1.v().a0(TradeType.SUPERMARGIN, SymbolAssetSuperMarginActivity.this.f81465t), "0", true, SymbolAssetSuperMarginActivity.this);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        zn.a.d().v(Uri.parse(String.format("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=leverHistory&navConfig=&tabType=0&modeType=%s&symbol=%s", new Object[]{"1", this.f81465t}))).c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Og */
    public SymbolAssetSuperMarginPresenter createPresenter() {
        return new SymbolAssetSuperMarginPresenter();
    }

    /* renamed from: Pg */
    public SymbolAssetSuperMarginPresenter.f getUI() {
        return this;
    }

    public RecyclerView Y0() {
        return this.f81462q;
    }

    public void addEvent() {
        this.f81460o.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a());
        this.f81448c.setOnClickListener(new b());
        this.f81455j.setOnClickListener(new c());
        this.f81456k.setOnClickListener(new d());
        this.f81457l.setOnClickListener(new e());
        this.f81467v.setOnClickListener(new l(this));
    }

    public LoadingLayout f6() {
        return this.f81464s;
    }

    public void g8(String str, String str2, String str3, String str4, String str5) {
        this.f81450e.setText(str);
        this.f81451f.setText(str2);
        this.f81452g.setText(str3);
        this.f81454i.setText(str5);
    }

    public int getContentView() {
        return R.layout.activity_super_margin_symbol_asset_detail;
    }

    public void initView() {
        String stringExtra = getIntent().getStringExtra(FirebaseAnalytics.Param.CURRENCY);
        this.f81465t = stringExtra;
        this.f81465t = StringUtils.g(stringExtra);
        this.f81466u = k.C().z(this.f81465t);
        HbTitleBar hbTitleBar = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.A = hbTitleBar;
        hbTitleBar.setTitle(this.f81466u);
        this.f81464s = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f81460o = (AppBarLayout) this.viewFinder.b(R.id.currency_detail_appbar_layout);
        TextView textView = (TextView) findViewById(R.id.currency_detail_collapsing_toolbar_title);
        this.f81447b = textView;
        textView.setText(this.f81466u);
        this.f81449d = (LinearLayout) findViewById(R.id.rl_repay_area);
        this.f81471z = (TextView) findViewById(R.id.currency_detail_toolbar_title);
        this.f81448c = (TextView) findViewById(R.id.tv_repay_action);
        this.f81450e = (TextView) findViewById(R.id.tv_available_amount);
        this.f81451f = (TextView) findViewById(R.id.tv_freeze_amount);
        this.f81452g = (TextView) findViewById(R.id.tv_loaned_amount);
        TextView textView2 = (TextView) findViewById(R.id.tv_currency_title);
        this.f81453h = textView2;
        textView2.setText(this.f81466u);
        this.f81454i = (TextView) findViewById(R.id.loan_symbol_detail_estimate);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_loan_area);
        this.f81455j = linearLayout;
        ViewUtil.m(linearLayout, !x.n().p());
        this.f81456k = (LinearLayout) findViewById(R.id.ll_transfer_area);
        this.f81457l = (LinearLayout) findViewById(R.id.ll_trade_area);
        this.f81467v = (TextView) findViewById(R.id.loan_symbol_detail_detail);
        this.f81458m = (Toolbar) this.viewFinder.b(R.id.loan_order_detail_toolbar);
        this.f81459n = (CollapsingToolbarLayout) this.viewFinder.b(R.id.currency_detail_collapsing_toolbar);
        setToolBar(this.f81458m, "", true);
        this.f81461p = getResources().getDimension(R.dimen.dimen_44);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_enter_from_bottom);
        this.f81469x = loadAnimation;
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.anim_exit_from_bottom);
        this.f81470y = loadAnimation2;
        loadAnimation2.setFillAfter(true);
        this.f81462q = (RecyclerView) this.viewFinder.b(R.id.loan_symbol_detail_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f81462q.setLayoutManager(linearLayoutManager);
        this.f81462q.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_divider_color), PixelUtils.a(0.5f), false, true));
        this.f81463r = (SmartRefreshLayout) this.viewFinder.b(R.id.loan_symbol_detail_refresh_layout);
        this.f81468w = this.viewFinder.b(R.id.currency_detail_bottom_layout);
    }

    public void lc(boolean z11) {
        this.f81449d.setVisibility(z11 ? 0 : 8);
    }

    public SmartRefreshLayout t2() {
        return this.f81463r;
    }

    public void z4(boolean z11) {
        this.f81457l.setVisibility(z11 ? 0 : 8);
    }
}
