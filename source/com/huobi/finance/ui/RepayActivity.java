package com.huobi.finance.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.input.PointLengthFilter;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.finance.presenter.RepayPresenter;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.keyboard.KeyboardTouchListener;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;
import pro.huobi.R;

public class RepayActivity extends BaseActivity<RepayPresenter, RepayPresenter.b> implements RepayPresenter.b {
    public TextView A;
    public View B;

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f46748b;

    /* renamed from: c  reason: collision with root package name */
    public HbTitleBar f46749c;

    /* renamed from: d  reason: collision with root package name */
    public CustomBoardView f46750d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f46751e;

    /* renamed from: f  reason: collision with root package name */
    public AppBarLayout f46752f;

    /* renamed from: g  reason: collision with root package name */
    public Button f46753g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f46754h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46755i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46756j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f46757k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f46758l;

    /* renamed from: m  reason: collision with root package name */
    public LoanOrderItem f46759m;

    /* renamed from: n  reason: collision with root package name */
    public String f46760n;

    /* renamed from: o  reason: collision with root package name */
    public CollapsingToolbarLayout f46761o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f46762p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f46763q;

    /* renamed from: r  reason: collision with root package name */
    public View f46764r;

    /* renamed from: s  reason: collision with root package name */
    public BigDecimal f46765s;

    /* renamed from: t  reason: collision with root package name */
    public String f46766t;

    /* renamed from: u  reason: collision with root package name */
    public String f46767u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f46768v;

    /* renamed from: w  reason: collision with root package name */
    public LoadingLayout f46769w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f46770x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f46771y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f46772z;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            int i11 = TextUtils.isEmpty(editable) ? R.color.global_divider_color : R.color.global_button_end_color;
            Typeface h11 = ResourcesCompat.h(RepayActivity.this.f46751e.getContext(), R.font.roboto_medium);
            Typeface h12 = ResourcesCompat.h(RepayActivity.this.f46751e.getContext(), R.font.roboto_regular);
            if (TextUtils.isEmpty(editable)) {
                RepayActivity.this.f46751e.setTypeface(h12);
            } else {
                RepayActivity.this.f46751e.setTypeface(h11);
            }
            RepayActivity.this.B.setBackgroundColor(RepayActivity.this.getResources().getColor(i11));
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements Toolbar.g {
        public b() {
        }

        @SensorsDataInstrumented
        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent intent = new Intent(RepayActivity.this, TransferOrderActivity.class);
            intent.putExtra("margin_finance_page", "type_load_repay");
            intent.putExtra("symbol", RepayActivity.this.f46759m.getSymbol());
            RepayActivity.this.startActivity(intent);
            SensorsDataAutoTrackHelper.trackMenuItem(menuItem);
            return false;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        ((RepayPresenter) getPresenter()).Y(this.f46759m.getId() + "", this.f46754h.getText().toString());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (!TextUtils.isEmpty(this.f46766t)) {
            if (this.f46765s.compareTo(new BigDecimal(this.f46766t)) < 0) {
                this.f46751e.setText(this.f46767u);
            } else {
                this.f46751e.setText(this.f46766t);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        A(true);
        ((RepayPresenter) getPresenter()).V(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rh(int i11, EditText editText) {
        if (i11 == 1) {
            this.f46752f.setExpanded(false);
        } else if (i11 == 2) {
            this.f46752f.setExpanded(true);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        Intent intent = new Intent(this, TransferOrderActivity.class);
        intent.putExtra("margin_finance_page", "type_load_repay");
        intent.putExtra("symbol", this.f46759m.getSymbol());
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void th(View view) {
        DialogUtils.X(this, getString(R.string.setting_quickly_withdraw_dialog_title), getString(R.string.trade_margin_repay_total_desc), (String) null, getString(R.string.dialog_minamount_hint_confrm_btn), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void A(boolean z11) {
        if (z11) {
            this.f46769w.setVisibility(0);
            this.f46769w.p();
            return;
        }
        this.f46769w.setVisibility(8);
    }

    public void R6(SymbolBean symbolBean) {
        this.f46770x.setText(String.format(Locale.US, getString(R.string.loan_trade_margin_subtitle), new Object[]{StringUtils.i(symbolBean.getBaseCurrencyDisplayName()), StringUtils.i(symbolBean.getQuoteCurrencyDisplayName())}));
    }

    public void V3(String str) {
        this.f46766t = m.m(str, PrecisionUtil.b(this.f46759m.getCurrency()));
        this.f46762p.setText(String.format(Locale.US, getResources().getString(R.string.repay_available_text), new Object[]{this.f46766t, this.f46760n}));
        A(false);
    }

    public void W0() {
        this.f46769w.k();
    }

    public void addEvent() {
        this.f46750d.setKeyBoardStateChangeListener(new n7(this));
        this.f46751e.setOnTouchListener(new KeyboardTouchListener(this.f46750d, 3, -1));
        this.f46751e.addTextChangedListener(new a());
        this.f46748b.setOnMenuItemClickListener(new b());
        this.f46749c.setOnClickActionListener(new i7(this));
        this.f46753g.setOnClickListener(new j7(this));
        this.f46764r.setOnClickListener(new k7(this));
        this.f46769w.setOnRetryClickListener(new l7(this));
        this.A.setOnClickListener(new m7(this));
    }

    public void ch() {
        finish();
    }

    public int getContentView() {
        return R.layout.activity_repay;
    }

    public void initView() {
        this.f46748b = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f46749c = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f46751e = (EditText) this.viewFinder.b(R.id.repay_edit_amount);
        this.f46752f = (AppBarLayout) this.viewFinder.b(R.id.appbar_layout);
        this.f46753g = (Button) this.viewFinder.b(R.id.repay_btn);
        this.f46754h = (EditText) this.viewFinder.b(R.id.repay_edit_amount);
        this.f46755i = (TextView) this.viewFinder.b(R.id.repay_unreturn_text);
        this.f46756j = (TextView) this.viewFinder.b(R.id.repay_fee_text);
        this.f46768v = (TextView) this.viewFinder.b(R.id.repay_fee_title);
        this.f46757k = (TextView) this.viewFinder.b(R.id.repay_date_text);
        this.f46758l = (TextView) this.viewFinder.b(R.id.repay_total_text);
        this.f46761o = (CollapsingToolbarLayout) this.viewFinder.b(R.id.collapsing_toolbar);
        this.f46762p = (TextView) this.viewFinder.b(R.id.available_text);
        this.f46763q = (TextView) this.viewFinder.b(R.id.currency_text);
        this.f46764r = this.viewFinder.b(R.id.tv_all);
        this.f46770x = (TextView) this.viewFinder.b(R.id.tv_sub_title);
        this.f46771y = (TextView) this.viewFinder.b(R.id.tv_un_return);
        TextView textView = (TextView) this.viewFinder.b(R.id.tv_repay_total_label);
        this.A = textView;
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.risk_rate_instruction, 0);
        this.A.setCompoundDrawablePadding(PixelUtils.a(4.0f));
        this.A.setClickable(true);
        this.f46772z = (TextView) this.viewFinder.b(R.id.tv_repay_total);
        this.B = this.viewFinder.b(R.id.input_amount_divider);
        this.f46750d = new CustomBoardView(this);
        this.f46750d.setGravity(80);
        this.f46750d.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        ((FrameLayout) findViewById(16908290)).addView(this.f46750d, layoutParams);
        this.f46759m = (LoanOrderItem) getIntent().getSerializableExtra("repay_bean");
        this.f46760n = k.C().z(this.f46759m.getCurrency());
        TextView textView2 = this.f46755i;
        Locale locale = Locale.US;
        textView2.setText(String.format(locale, "%s %s", new Object[]{m.m(this.f46759m.getLoanBalance(), PrecisionUtil.j()), this.f46760n}));
        BigDecimal add = m.a(this.f46759m.getLoanBalance()).add(m.a(this.f46759m.getInterestBalance()));
        this.f46772z.setText(String.format(locale, "%s %s", new Object[]{m.q(add, PrecisionUtil.j()), this.f46760n}));
        this.f46756j.setText(String.format(locale, "%s %s", new Object[]{m.m(this.f46759m.getInterestBalance(), PrecisionUtil.j()), this.f46760n}));
        BigDecimal add2 = new BigDecimal(this.f46759m.getLoanBalance()).add(new BigDecimal(this.f46759m.getInterestBalance()));
        this.f46765s = add2;
        String q11 = m.q(add2, PrecisionUtil.j());
        this.f46767u = q11;
        this.f46758l.setText(String.format(locale, "%s %s", new Object[]{q11, this.f46760n}));
        if (DateTimeUtils.E(this.f46759m.getCreatedTime())) {
            this.f46757k.setText(DateTimeUtils.h(this.f46759m.getCreatedTime(), "HH:mm MM/dd"));
        } else {
            this.f46757k.setText(DateTimeUtils.h(this.f46759m.getCreatedTime(), "HH:mm MM/dd/yyyy "));
        }
        String format = String.format(getResources().getString(R.string.repay_title_text), new Object[]{this.f46760n});
        setToolBar(this.f46748b, format, true);
        this.f46761o.setTitle(format);
        this.f46749c.setTitle(format);
        this.f46763q.setText(this.f46760n);
        this.f46762p.setText(String.format(locale, getResources().getString(R.string.repay_available_text), new Object[]{"", this.f46760n}));
        String string = getString(R.string.make_interest);
        String reductedRatePercent = this.f46759m.getReductedRatePercent();
        this.f46768v.setText(String.format(locale, "%s(%s)", new Object[]{string, reductedRatePercent}));
        PointLengthFilter pointLengthFilter = new PointLengthFilter();
        pointLengthFilter.a(8);
        this.f46751e.setFilters(new InputFilter[]{pointLengthFilter});
        this.f46769w = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        A(true);
    }

    public void onBackPressed() {
        CustomBoardView customBoardView = this.f46750d;
        if (customBoardView == null || !customBoardView.isShown()) {
            super.onBackPressed();
        } else {
            this.f46750d.hideKeyboardLayout();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_currency_detail_record, menu);
        return true;
    }

    public void onStop() {
        super.onStop();
        CustomBoardView customBoardView = this.f46750d;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
    }

    /* renamed from: ph */
    public RepayPresenter createPresenter() {
        return new RepayPresenter();
    }

    /* renamed from: qh */
    public RepayPresenter.b getUI() {
        return this;
    }
}
