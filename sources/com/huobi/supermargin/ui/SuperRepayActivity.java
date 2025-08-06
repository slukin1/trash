package com.huobi.supermargin.ui;

import android.content.Intent;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.input.PointLengthFilter;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.ui.TransferOrderActivity;
import com.huobi.supermargin.bean.RepayCurrency;
import com.huobi.supermargin.presenter.SuperRepayPresenter;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.keyboard.KeyboardTouchListener;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.i;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import ms.j;
import pro.huobi.R;
import u6.g;

public class SuperRepayActivity extends BaseActivity<SuperRepayPresenter, SuperRepayPresenter.d> implements SuperRepayPresenter.d {

    /* renamed from: b  reason: collision with root package name */
    public CollapsingToolbarLayout f81404b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f81405c;

    /* renamed from: d  reason: collision with root package name */
    public Toolbar f81406d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f81407e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81408f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f81409g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f81410h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f81411i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f81412j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f81413k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f81414l;

    /* renamed from: m  reason: collision with root package name */
    public Button f81415m;

    /* renamed from: n  reason: collision with root package name */
    public String f81416n;

    /* renamed from: o  reason: collision with root package name */
    public CustomBoardView f81417o;

    /* renamed from: p  reason: collision with root package name */
    public BigDecimal f81418p;

    /* renamed from: q  reason: collision with root package name */
    public String f81419q;

    /* renamed from: r  reason: collision with root package name */
    public String f81420r;

    /* renamed from: s  reason: collision with root package name */
    public RepayCurrency f81421s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f81422t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f81423u;

    /* renamed from: v  reason: collision with root package name */
    public View f81424v;

    /* renamed from: w  reason: collision with root package name */
    public HbTitleBar f81425w;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                SuperRepayActivity.this.f81415m.setEnabled(false);
            } else if (SuperRepayActivity.this.f81421s != null && m.a(SuperRepayActivity.this.f81421s.getPayableAmount()).compareTo(BigDecimal.ZERO) > 0) {
                SuperRepayActivity.this.f81415m.setEnabled(true);
            }
            SuperRepayActivity.this.f81424v.setBackgroundColor(SuperRepayActivity.this.getResources().getColor(TextUtils.isEmpty(editable) ? R.color.global_divider_color : R.color.global_button_end_color));
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperRepayActivity.this.startActivityForResult(SuperLoanChooseCoinActivity.fg(view.getContext()), 0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperRepayActivity superRepayActivity = SuperRepayActivity.this;
            DialogUtils.X(superRepayActivity, superRepayActivity.getString(R.string.setting_quickly_withdraw_dialog_title), SuperRepayActivity.this.getString(R.string.super_repay_dialog_desc), (String) null, SuperRepayActivity.this.getString(R.string.dialog_minamount_hint_confrm_btn), ad.b.f3517a);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (TextUtils.isEmpty(SuperRepayActivity.this.f81420r)) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (SuperRepayActivity.this.f81418p.compareTo(new BigDecimal(SuperRepayActivity.this.f81420r)) < 0) {
                SuperRepayActivity.this.f81411i.setText(SuperRepayActivity.this.f81419q);
            } else {
                SuperRepayActivity.this.f81411i.setText(SuperRepayActivity.this.f81420r);
            }
            SuperRepayActivity.this.f81411i.setSelection(SuperRepayActivity.this.f81411i.getText().toString().length());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements View.OnClickListener {

        public class a extends q6.d<Object> {

            /* renamed from: com.huobi.supermargin.ui.SuperRepayActivity$e$a$a  reason: collision with other inner class name */
            public class C0852a implements Runnable {
                public C0852a() {
                }

                public void run() {
                    SuperRepayActivity.this.finish();
                }
            }

            public a(g gVar) {
                super(gVar);
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                HuobiToastUtil.s(R.string.repay_successfully);
                i.b().g(new C0852a(), 10);
            }
        }

        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((SuperRepayPresenter) SuperRepayActivity.this.getPresenter()).S(SuperRepayActivity.this.f81416n.toLowerCase(), SuperRepayActivity.this.f81411i.getText().toString()).subscribe(new a(SuperRepayActivity.this.getUI()));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ boolean vh(MenuItem menuItem) {
        Intent intent = new Intent(this, TransferOrderActivity.class);
        intent.putExtra("margin_finance_page", "type_super_load_repay");
        intent.putExtra(FirebaseAnalytics.Param.CURRENCY, this.f81416n);
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void wh(View view) {
        Intent intent = new Intent(this, TransferOrderActivity.class);
        intent.putExtra("margin_finance_page", "type_super_load_repay");
        intent.putExtra(FirebaseAnalytics.Param.CURRENCY, this.f81416n);
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(int i11, EditText editText) {
        if (i11 == 1) {
            this.f81405c.setExpanded(false);
        } else if (i11 == 2) {
            this.f81405c.setExpanded(true);
        }
    }

    public void Ce(List<RepayCurrency> list, Map<String, String> map) {
        int th2;
        if (list != null && map != null && (th2 = th(this.f81416n, list)) != -1) {
            this.f81421s = list.get(th2);
            String z11 = k.C().z(this.f81421s.getCurrency());
            this.f81404b.setTitle(getResources().getString(R.string.repay_title_text, new Object[]{z11}));
            this.f81408f.setText(z11);
            this.f81412j.setText(z11);
            String m11 = m.m(this.f81421s.getLoanamount(), PrecisionUtil.r());
            this.f81410h.setText(String.format("%s %s", new Object[]{m11, z11}));
            String m12 = m.m(this.f81421s.getInterestAmount(), PrecisionUtil.r());
            this.f81409g.setText(String.format("%s %s", new Object[]{m12, z11}));
            String m13 = m.m(this.f81421s.getPayableAmount(), PrecisionUtil.r());
            this.f81423u.setText(String.format("%s %s", new Object[]{m13, z11}));
            this.f81411i.setHint(R.string.points_buy_confirm_error_number_hint);
            this.f81418p = new BigDecimal(this.f81421s.getPayableAmount());
            this.f81419q = m.m(this.f81421s.getPayableAmount(), PrecisionUtil.r());
            String str = map.get(this.f81416n.toLowerCase());
            if (m.a(str).compareTo(BigDecimal.ZERO) < 0) {
                str = "0";
            }
            String m14 = m.m(str, PrecisionUtil.r());
            this.f81414l.setText(String.format("%s %s", new Object[]{m14, z11}));
            this.f81420r = m14;
            this.f81411i.setText("");
        }
    }

    public void addEvent() {
        this.f81406d.setOnMenuItemClickListener(new j(this));
        this.f81425w.setOnClickActionListener(new ms.i(this));
        this.f81417o.setKeyBoardStateChangeListener(new ms.k(this));
        PointLengthFilter pointLengthFilter = new PointLengthFilter();
        pointLengthFilter.a(8);
        this.f81411i.setFilters(new InputFilter[]{pointLengthFilter});
        this.f81411i.addTextChangedListener(new a());
        this.f81411i.setOnTouchListener(new KeyboardTouchListener(this.f81417o, 3, -1));
        this.f81407e.setOnClickListener(new b());
        this.f81422t.setOnClickListener(new c());
        this.f81413k.setOnClickListener(new d());
        this.f81415m.setOnClickListener(new e());
    }

    public int getContentView() {
        return R.layout.activity_super_repay;
    }

    public void initView() {
        this.f81416n = StringUtils.i(getIntent().getStringExtra("KEY_CURRENCY"));
        this.f81404b = (CollapsingToolbarLayout) this.viewFinder.b(R.id.collapsing_toolbar);
        this.f81405c = (AppBarLayout) this.viewFinder.b(R.id.appbar_layout);
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f81406d = toolbar;
        setToolBar(toolbar, "", true);
        this.f81425w = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f81407e = (RelativeLayout) this.viewFinder.b(R.id.rl_coin);
        this.f81408f = (TextView) this.viewFinder.b(R.id.tv_coin);
        this.f81410h = (TextView) this.viewFinder.b(R.id.repay_unreturn_text);
        this.f81409g = (TextView) this.viewFinder.b(R.id.repay_fee_text);
        this.f81422t = (TextView) this.viewFinder.b(R.id.repay_sum);
        this.f81423u = (TextView) this.viewFinder.b(R.id.repay_sum_text);
        this.f81411i = (EditText) this.viewFinder.b(R.id.repay_edit_amount);
        this.f81424v = this.viewFinder.b(R.id.input_amount_divider);
        this.f81412j = (TextView) this.viewFinder.b(R.id.currency_text);
        this.f81413k = (TextView) this.viewFinder.b(R.id.tv_all);
        this.f81414l = (TextView) this.viewFinder.b(R.id.available_text);
        this.f81415m = (Button) this.viewFinder.b(R.id.repay_btn);
        this.f81417o = new CustomBoardView(this);
        this.f81417o.setGravity(80);
        this.f81417o.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        ((FrameLayout) findViewById(16908290)).addView(this.f81417o, layoutParams);
        this.f81410h.setText("--");
        this.f81409g.setText("--");
        this.f81423u.setText("--");
        this.f81411i.setText("");
        this.f81414l.setText("--");
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 0) {
            this.f81416n = StringUtils.i(intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY));
            ((SuperRepayPresenter) getPresenter()).Q();
        }
    }

    public void onBackPressed() {
        CustomBoardView customBoardView = this.f81417o;
        if (customBoardView == null || !customBoardView.isShown()) {
            super.onBackPressed();
        } else {
            this.f81417o.hideKeyboardLayout();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_currency_detail_record, menu);
        return true;
    }

    public void onStop() {
        super.onStop();
        CustomBoardView customBoardView = this.f81417o;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
    }

    /* renamed from: sh */
    public SuperRepayPresenter createPresenter() {
        return new SuperRepayPresenter();
    }

    public int th(String str, List<RepayCurrency> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (str.equalsIgnoreCase(list.get(i11).getCurrency())) {
                return i11;
            }
        }
        return -1;
    }

    /* renamed from: uh */
    public SuperRepayPresenter.d getUI() {
        return this;
    }
}
