package com.huobi.supermargin.ui;

import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.input.PointLengthFilter;
import com.huobi.finance.ui.TransferOrderActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.supermargin.bean.LoanCurrency;
import com.huobi.supermargin.presenter.SuperLoanPresenter;
import com.huobi.utils.EditTextUtil;
import com.huobi.utils.SpannableUtils;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import pro.huobi.R;

public class SuperLoanActivity extends BaseActivity<SuperLoanPresenter, SuperLoanPresenter.d> implements SuperLoanPresenter.d {

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f81351b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f81352c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f81353d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f81354e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81355f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f81356g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f81357h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f81358i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f81359j;

    /* renamed from: k  reason: collision with root package name */
    public EditText f81360k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f81361l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f81362m;

    /* renamed from: n  reason: collision with root package name */
    public Button f81363n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f81364o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f81365p;

    /* renamed from: q  reason: collision with root package name */
    public String f81366q;

    /* renamed from: r  reason: collision with root package name */
    public LoanCurrency f81367r;

    /* renamed from: s  reason: collision with root package name */
    public String f81368s;

    /* renamed from: t  reason: collision with root package name */
    public View f81369t;

    /* renamed from: u  reason: collision with root package name */
    public HuobiKeyboardHelper f81370u;

    /* renamed from: v  reason: collision with root package name */
    public HbTitleBar f81371v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f81372w;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HBBaseWebActivity.showWebView(view.getContext(), d1.m(), "", "", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperLoanActivity superLoanActivity = SuperLoanActivity.this;
            DialogUtils.X(superLoanActivity, superLoanActivity.getString(R.string.available_amount), SuperLoanActivity.this.getString(R.string.n_margin_super_margin_available_loan_tip), (String) null, SuperLoanActivity.this.getString(R.string.dialog_minamount_hint_confrm_btn), ad.b.f3517a);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperLoanActivity.this.startActivityForResult(SuperLoanChooseCoinActivity.fg(view.getContext()), 0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperLoanActivity superLoanActivity = SuperLoanActivity.this;
            DialogUtils.X(superLoanActivity, superLoanActivity.getString(R.string.loan_rate_dialog_title), String.format(SuperLoanActivity.this.getString(R.string.allin_loan_rate_desc), new Object[]{SuperLoanActivity.this.f81366q}), (String) null, SuperLoanActivity.this.getString(R.string.dialog_minamount_hint_confrm_btn), ad.b.f3517a);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public void afterTextChanged(Editable editable) {
            EditTextUtil.a(SuperLoanActivity.this.f81360k);
            if (TextUtils.isEmpty(editable)) {
                SuperLoanActivity.this.f81363n.setEnabled(false);
            } else if (SuperLoanActivity.this.f81367r != null && m.a(SuperLoanActivity.this.f81367r.getRemainLoanQuota()).compareTo(BigDecimal.ZERO) > 0) {
                SuperLoanActivity.this.f81363n.setEnabled(true);
            }
            SuperLoanActivity.this.f81369t.setBackgroundColor(SuperLoanActivity.this.getResources().getColor(TextUtils.isEmpty(editable) ? R.color.global_divider_color : R.color.global_button_end_color));
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (SuperLoanActivity.this.f81367r == null) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SuperLoanActivity.this.f81360k.setText(m.m(SuperLoanActivity.this.f81367r.getRemainLoanQuota(), 3));
            SuperLoanActivity.this.f81360k.setSelection(SuperLoanActivity.this.f81360k.getText().length());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class g implements View.OnClickListener {

        public class a extends EasySubscriber<Object> {

            /* renamed from: com.huobi.supermargin.ui.SuperLoanActivity$g$a$a  reason: collision with other inner class name */
            public class C0851a extends EasySubscriber<List<LoanCurrency>> {
                public C0851a() {
                }

                public void onNext(List<LoanCurrency> list) {
                    super.onNext(list);
                    SuperLoanActivity.this.fb(list, false);
                }
            }

            public a() {
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void b(HBDialogFragment hBDialogFragment) {
                k0.Q(SuperLoanActivity.this);
                hBDialogFragment.dismiss();
            }

            public void onAfter() {
                super.onAfter();
                SuperLoanActivity.this.getUI().dismissProgressDialog();
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                SuperLoanActivity.this.f81360k.setText("");
                SuperLoanActivity superLoanActivity = SuperLoanActivity.this;
                DialogUtils.c0(superLoanActivity, superLoanActivity.getString(R.string.loan_finsh_hint), "", SuperLoanActivity.this.getString(R.string.global_string_cancel), SuperLoanActivity.this.getString(R.string.tab_channel_margin), ad.b.f3517a, new ms.g(this));
                ((SuperLoanPresenter) SuperLoanActivity.this.getPresenter()).R(false).subscribe(new C0851a());
            }

            public void onStart() {
                super.onStart();
                SuperLoanActivity.this.getUI().showOldProgressDialog(SuperLoanActivity.this.getString(R.string.loan_result_requesting));
            }
        }

        public g() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (SuperLoanActivity.this.f81367r == null) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            ((SuperLoanPresenter) SuperLoanActivity.this.getPresenter()).Q(SuperLoanActivity.this.f81367r.getCurrency().toLowerCase(), SuperLoanActivity.this.f81360k.getText().toString()).subscribe(new a());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class h extends q6.d<List<LoanCurrency>> {
        public h(u6.g gVar) {
            super(gVar);
        }

        public void onNext(List<LoanCurrency> list) {
            super.onNext(list);
            SuperLoanActivity.this.fb(list, false);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Intent intent = new Intent(this, TransferOrderActivity.class);
        intent.putExtra("margin_finance_page", "type_super_load_repay");
        intent.putExtra(FirebaseAnalytics.Param.CURRENCY, this.f81368s);
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        LoanCurrency loanCurrency = this.f81367r;
        if (loanCurrency != null) {
            sn.f.P(this, loanCurrency.getCurrency().toLowerCase());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ boolean xh(MenuItem menuItem) {
        Intent intent = new Intent(this, TransferOrderActivity.class);
        intent.putExtra("margin_finance_page", "type_super_load_repay");
        intent.putExtra(FirebaseAnalytics.Param.CURRENCY, this.f81368s);
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(int i11, EditText editText) {
        if (i11 == 1) {
            this.f81352c.setExpanded(false);
        } else if (i11 == 2) {
            this.f81352c.setExpanded(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        UnifyTransferActivity.Th(this, this.f81368s, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
        finish();
    }

    public final void Bh(String str) {
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            new DialogUtils.b.d(this).c1(getString(R.string.super_loan_no_available_content)).E0(false).i1(1).M0(Integer.valueOf(R.drawable.account_popup_window_image)).P0(getResources().getString(R.string.go_to_transfer)).Q0(new ms.d(this)).q0(true).s0(getString(R.string.global_string_cancel)).N0(ms.e.f58255a).j0().show(getSupportFragmentManager(), "");
        }
    }

    public final void Ch(String str) {
        DialogUtils.X(this, getString(R.string.n_option_delivery_tip), String.format(getString(R.string.n_balance_platform_loan_max), new Object[]{str.toUpperCase()}), "", getString(R.string.n_known), ad.b.f3517a);
    }

    public void addEvent() {
        this.viewFinder.b(R.id.tv_available_loan_amount).setOnClickListener(new b());
        this.f81351b.setOnMenuItemClickListener(new ms.c(this));
        this.f81371v.setOnClickActionListener(new ms.a(this));
        this.f81353d.setOnClickListener(new c());
        this.f81356g.setOnClickListener(new d());
        this.f81370u.getBoardView().setKeyBoardStateChangeListener(new ms.f(this));
        this.f81359j.setOnClickListener(new ms.b(this));
        PointLengthFilter pointLengthFilter = new PointLengthFilter();
        pointLengthFilter.a(3);
        this.f81360k.setFilters(new InputFilter[]{pointLengthFilter});
        this.f81360k.addTextChangedListener(new e());
        this.f81362m.setOnClickListener(new f());
        this.f81363n.setOnClickListener(new g());
    }

    public void fb(List<LoanCurrency> list, boolean z11) {
        if (list != null && !list.isEmpty()) {
            LoanCurrency loanCurrency = list.get(uh(list, this.f81368s));
            this.f81367r = loanCurrency;
            String z12 = k.C().z(loanCurrency.getCurrency());
            this.f81354e.setText(z12);
            this.f81361l.setText(z12);
            String m11 = m.m(loanCurrency.getLoanAmount(), PrecisionUtil.r());
            this.f81355f.setText(String.format("%s %s", new Object[]{m11, z12}));
            String N = m.N(loanCurrency.getInterestRate(), PrecisionUtil.l(), 1);
            this.f81366q = N;
            this.f81357h.setText(N);
            String m12 = m.m(loanCurrency.getRemainLoanQuota(), PrecisionUtil.k());
            if (z11) {
                if (loanCurrency.getPlfLoanFlag() == 0) {
                    Ch(z12);
                } else {
                    Bh(m12);
                }
            }
            this.f81358i.setText(String.format("%s %s", new Object[]{m12, z12}));
            String m13 = m.m(loanCurrency.getUserLoanMinAmount(), PrecisionUtil.k());
            this.f81360k.setHint(String.format(getString(R.string.transfer_amount_hint_s), new Object[]{m13}));
            this.f81364o.setText(String.format("%s %s", new Object[]{m12, z12}));
            this.f81360k.setText("");
        }
    }

    public int getContentView() {
        return R.layout.activity_super_loan;
    }

    public void initView() {
        HbTitleBar hbTitleBar = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f81371v = hbTitleBar;
        hbTitleBar.setTitle(getResources().getString(R.string.loan_coin) + "(" + getResources().getString(R.string.super_margin_account) + ")");
        this.f81368s = StringUtils.i(getIntent().getStringExtra("KEY_CURRENCY"));
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f81351b = toolbar;
        setToolBar(toolbar, getResources().getString(R.string.loan_coin), true);
        this.f81352c = (AppBarLayout) this.viewFinder.b(R.id.appbar_layout);
        this.f81353d = (RelativeLayout) this.viewFinder.b(R.id.rl_coin);
        this.f81354e = (TextView) this.viewFinder.b(R.id.tv_coin);
        this.f81355f = (TextView) this.viewFinder.b(R.id.loan_loaned_text);
        this.f81356g = (TextView) this.viewFinder.b(R.id.loan_rate_label_tv);
        this.f81357h = (TextView) this.viewFinder.b(R.id.loan_rate_text);
        this.f81358i = (TextView) this.viewFinder.b(R.id.load_remain_text);
        this.f81359j = (TextView) this.viewFinder.b(R.id.loan_limit_tv);
        this.f81360k = (EditText) this.viewFinder.b(R.id.loan_edit_amount);
        this.f81369t = this.viewFinder.b(R.id.input_amount_divider);
        this.f81361l = (TextView) this.viewFinder.b(R.id.tv_currency);
        this.f81362m = (TextView) this.viewFinder.b(R.id.tv_all);
        this.f81363n = (Button) this.viewFinder.b(R.id.btn_action);
        this.f81364o = (TextView) this.viewFinder.b(R.id.available_text);
        TextView textView = (TextView) this.viewFinder.b(R.id.tv_pledge_loan);
        this.f81372w = textView;
        textView.setText((CharSequence) null);
        this.f81372w.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView2 = (TextView) this.viewFinder.b(R.id.tv_loan_desc);
        this.f81365p = textView2;
        textView2.setText(vh());
        this.f81365p.setMovementMethod(LinkMovementMethod.getInstance());
        this.f81370u = new HuobiKeyboardHelper().attach(this).registerInput(this.f81360k);
        this.f81355f.setText("--");
        this.f81366q = "--";
        this.f81357h.setText("--");
        this.f81358i.setText("--");
        this.f81360k.setHint("");
        this.f81364o.setText("--");
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 0) {
            this.f81368s = StringUtils.i(intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY));
            ((SuperLoanPresenter) getPresenter()).R(false).subscribe(new h(getUI()));
        }
    }

    public void onBackPressed() {
        if (this.f81370u.getBoardView().keyboardVisible()) {
            this.f81370u.hideKeyboard();
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_currency_detail_record, menu);
        return true;
    }

    public void onStop() {
        super.onStop();
        this.f81370u.hideKeyboard();
    }

    /* renamed from: th */
    public SuperLoanPresenter createPresenter() {
        return new SuperLoanPresenter();
    }

    public int uh(List<LoanCurrency> list, String str) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (str.equalsIgnoreCase(list.get(i11).getCurrency())) {
                return i11;
            }
        }
        return 0;
    }

    public final SpannableStringBuilder vh() {
        return SpannableUtils.a(this, getString(R.string.n_margin_super_margin_loan_tip), getString(R.string.n_margin_super_margin_loan_rules), new a());
    }

    /* renamed from: wh */
    public SuperLoanPresenter.d getUI() {
        return this;
    }
}
