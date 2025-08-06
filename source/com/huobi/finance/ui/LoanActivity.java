package com.huobi.finance.ui;

import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.input.PointLengthFilter;
import com.hbg.lib.widgets.tablayout.TabItemLayoutData;
import com.hbg.lib.widgets.tablayout.TabItemLayoutIndicator;
import com.huobi.finance.bean.LoanInfo;
import com.huobi.finance.presenter.LoanPresenter;
import com.huobi.utils.k0;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import java.util.ArrayList;
import java.util.Map;
import pro.huobi.R;
import sn.f;

public class LoanActivity extends BaseActivity<LoanPresenter, LoanPresenter.d> implements LoanPresenter.d {

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f46594b;

    /* renamed from: c  reason: collision with root package name */
    public HbTitleBar f46595c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46596d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f46597e;

    /* renamed from: f  reason: collision with root package name */
    public AppBarLayout f46598f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46599g = true;

    /* renamed from: h  reason: collision with root package name */
    public TabItemLayoutIndicator f46600h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46601i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46602j;

    /* renamed from: k  reason: collision with root package name */
    public LoanInfo f46603k;

    /* renamed from: l  reason: collision with root package name */
    public LoanInfo f46604l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f46605m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f46606n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f46607o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f46608p;

    /* renamed from: q  reason: collision with root package name */
    public View f46609q;

    /* renamed from: r  reason: collision with root package name */
    public View f46610r;

    /* renamed from: s  reason: collision with root package name */
    public String f46611s;

    /* renamed from: t  reason: collision with root package name */
    public CoordinatorLayout f46612t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f46613u;

    /* renamed from: v  reason: collision with root package name */
    public View f46614v;

    /* renamed from: w  reason: collision with root package name */
    public HuobiKeyboardHelper f46615w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f46616x;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                LoanActivity.this.f46597e.setTypeface(ResourcesCompat.h(LoanActivity.this.getBaseContext(), R.font.roboto_regular));
                LoanActivity.this.f46610r.setEnabled(false);
            } else {
                LoanActivity.this.f46597e.setTypeface(ResourcesCompat.h(LoanActivity.this.getBaseContext(), R.font.roboto_medium));
                LoanActivity.this.f46610r.setEnabled(true);
            }
            LoanActivity.this.f46614v.setBackgroundColor(LoanActivity.this.getResources().getColor(TextUtils.isEmpty(editable) ? R.color.global_divider_color : R.color.global_button_end_color));
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements la.b {
        public b() {
        }

        public void onItemClick(int i11) {
            if (i11 == 0) {
                if (!LoanActivity.this.f46599g) {
                    boolean unused = LoanActivity.this.f46599g = true;
                    LoanActivity.this.yh();
                    LoanActivity.this.f46597e.setText("");
                }
            } else if (LoanActivity.this.f46599g) {
                boolean unused2 = LoanActivity.this.f46599g = false;
                LoanActivity.this.yh();
                LoanActivity.this.f46597e.setText("");
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            LoanInfo loanInfo;
            if (LoanActivity.this.f46599g) {
                loanInfo = LoanActivity.this.f46603k;
            } else {
                loanInfo = LoanActivity.this.f46604l;
            }
            if (!(loanInfo == null || LoanActivity.this.f46597e.getText() == null)) {
                ((LoanPresenter) LoanActivity.this.getPresenter()).p0(((LoanPresenter) LoanActivity.this.getPresenter()).f0(), loanInfo.d(), LoanActivity.this.f46597e.getText().toString());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ch(View view) {
        f.Y(this, ((LoanPresenter) getPresenter()).f0());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Dh(int i11, EditText editText) {
        if (i11 == 1) {
            this.f46598f.setExpanded(false);
        } else if (i11 == 2) {
            this.f46598f.setExpanded(true);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ boolean Eh(MenuItem menuItem) {
        Intent intent = new Intent(this, TransferOrderActivity.class);
        intent.putExtra("margin_finance_page", "type_load_repay");
        intent.putExtra("symbol", ((LoanPresenter) getPresenter()).f0());
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(View view) {
        LoanInfo loanInfo;
        if (this.f46599g) {
            loanInfo = this.f46603k;
        } else {
            loanInfo = this.f46604l;
        }
        if (loanInfo != null) {
            this.f46597e.setText(loanInfo.b());
            EditText editText = this.f46597e;
            editText.setSelection(editText.getText().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        String str;
        if (this.f46599g) {
            str = this.f46603k.a();
        } else {
            str = this.f46604l.a();
        }
        DialogUtils.X(this, getString(R.string.loan_rate_dialog_title), String.format(getString(R.string.allin_loan_rate_desc), new Object[]{str}), (String) null, getString(R.string.dialog_minamount_hint_confrm_btn), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(HBDialogFragment hBDialogFragment) {
        k0.M(((LoanPresenter) getPresenter()).f0(), "0", true, this);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        Intent intent = new Intent(this, TransferOrderActivity.class);
        intent.putExtra("margin_finance_page", "type_load_repay");
        intent.putExtra("symbol", ((LoanPresenter) getPresenter()).f0());
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Ah */
    public LoanPresenter.d getUI() {
        return this;
    }

    public final void Bh() {
        ArrayList arrayList = new ArrayList();
        TabItemLayoutData tabItemLayoutData = new TabItemLayoutData();
        tabItemLayoutData.setRightTabText(getString(R.string.loan_short));
        tabItemLayoutData.setCheck(true);
        arrayList.add(tabItemLayoutData);
        TabItemLayoutData tabItemLayoutData2 = new TabItemLayoutData();
        tabItemLayoutData2.setRightTabText(getString(R.string.loan_long));
        arrayList.add(tabItemLayoutData2);
        this.f46600h.setTabItemLayoutData(arrayList);
    }

    public void Ng(String str, String str2) {
        if (str != null && str2 != null) {
            String z11 = k.C().z(str);
            String z12 = k.C().z(str2);
            this.f46600h.y(z11, 0);
            this.f46600h.y(z12, 1);
            this.f46613u.setText(String.format(getString(R.string.loan_trade_margin_subtitle), new Object[]{z11, z12}));
        }
    }

    public void Rb() {
        DialogUtils.c0(this, getString(R.string.loan_finsh_hint), "", getString(R.string.global_string_cancel), getString(R.string.tab_channel_margin), k6.f47204a, new j6(this));
    }

    public void Tf(Map<String, LoanInfo> map) {
        this.f46603k = map.get(((LoanPresenter) getPresenter()).d0());
        this.f46604l = map.get(((LoanPresenter) getPresenter()).g0());
        yh();
        this.f46597e.setText("");
    }

    public void addEvent() {
        this.f46596d.setOnClickListener(new h6(this));
        this.f46597e.addTextChangedListener(new a());
        this.f46615w.getBoardView().setKeyBoardStateChangeListener(new l6(this));
        this.f46594b.setOnMenuItemClickListener(new i6(this));
        this.f46595c.setOnClickActionListener(new f6(this));
        this.f46600h.setItemClickCallBack(new b());
        this.f46609q.setOnClickListener(new e6(this));
        this.f46610r.setOnClickListener(new c());
        this.f46608p.setOnClickListener(new g6(this));
        this.f46608p.setClickable(false);
    }

    public int getContentView() {
        return R.layout.activity_loan_new;
    }

    public void initView() {
        this.f46594b = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f46595c = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f46596d = (TextView) this.viewFinder.b(R.id.loan_limit_tv);
        this.f46597e = (EditText) this.viewFinder.b(R.id.loan_edit_amount);
        this.f46598f = (AppBarLayout) this.viewFinder.b(R.id.appbar_layout);
        this.f46615w = new HuobiKeyboardHelper().attach(this).registerInput(this.f46597e);
        setToolBar(this.f46594b, getResources().getString(R.string.loan_coin), true);
        this.f46600h = (TabItemLayoutIndicator) this.viewFinder.b(R.id.tab_layout);
        this.f46601i = (TextView) this.viewFinder.b(R.id.available_text);
        this.f46602j = (TextView) this.viewFinder.b(R.id.tv_currency);
        this.f46605m = (TextView) this.viewFinder.b(R.id.loan_loaned_text);
        this.f46606n = (TextView) this.viewFinder.b(R.id.load_max_text);
        this.f46607o = (TextView) this.viewFinder.b(R.id.loan_rate_text);
        this.f46608p = (TextView) this.viewFinder.b(R.id.loan_rate_label_tv);
        this.f46609q = this.viewFinder.b(R.id.tv_all);
        this.f46610r = this.viewFinder.b(R.id.btn_action);
        PointLengthFilter pointLengthFilter = new PointLengthFilter();
        pointLengthFilter.a(3);
        this.f46597e.setFilters(new InputFilter[]{pointLengthFilter});
        this.f46612t = (CoordinatorLayout) this.viewFinder.b(R.id.cl_root);
        RelativeLayout relativeLayout = (RelativeLayout) this.viewFinder.b(R.id.loan_middle_layout);
        this.f46613u = (TextView) this.viewFinder.b(R.id.tv_subtitle);
        this.f46614v = this.viewFinder.b(R.id.input_amount_divider);
        Bh();
        TextView textView = (TextView) this.viewFinder.b(R.id.tv_pledge_loan);
        this.f46616x = textView;
        textView.setText((CharSequence) null);
        this.f46616x.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void onBackPressed() {
        if (this.f46615w.getBoardView().keyboardVisible()) {
            this.f46615w.hideKeyboard();
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_currency_detail_record, menu);
        return true;
    }

    public void onDialogFragmentBackPressed() {
        super.onDialogFragmentBackPressed();
        dismissProgressDialog();
        if (((LoanPresenter) getPresenter()).h0() != null && !((LoanPresenter) getPresenter()).h0().isUnsubscribed()) {
            ((LoanPresenter) getPresenter()).h0().unsubscribe();
        }
    }

    public void onStop() {
        super.onStop();
        this.f46615w.hideKeyboard();
    }

    public final void yh() {
        String str = "";
        if (this.f46599g) {
            LoanInfo loanInfo = this.f46603k;
            if (loanInfo != null) {
                if (loanInfo.d() != null) {
                    str = k.C().z(this.f46603k.d());
                }
                this.f46602j.setText(str);
                String c11 = this.f46603k.c();
                this.f46611s = c11;
                this.f46601i.setText(String.format("%s%s", new Object[]{c11, str}));
                this.f46605m.setText(String.format("%s%s", new Object[]{this.f46603k.e(), str}));
                this.f46606n.setText(String.format("%s%s", new Object[]{this.f46603k.f(), str}));
                this.f46607o.setText(this.f46603k.a());
                this.f46608p.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.risk_rate_instruction, 0);
                this.f46608p.setClickable(true);
                this.f46597e.setHint(String.format(getString(R.string.transfer_amount_hint_s), new Object[]{this.f46603k.g()}));
                return;
            }
            return;
        }
        LoanInfo loanInfo2 = this.f46604l;
        if (loanInfo2 != null) {
            if (loanInfo2.d() != null) {
                str = k.C().z(this.f46604l.d());
            }
            this.f46602j.setText(str);
            String c12 = this.f46604l.c();
            this.f46611s = c12;
            this.f46601i.setText(String.format("%s%s", new Object[]{c12, str}));
            this.f46605m.setText(String.format("%s%s", new Object[]{this.f46604l.e(), str}));
            this.f46606n.setText(String.format("%s%s", new Object[]{this.f46604l.f(), str}));
            this.f46607o.setText(this.f46604l.a());
            this.f46608p.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.risk_rate_instruction, 0);
            this.f46608p.setClickable(true);
            this.f46597e.setHint(String.format(getString(R.string.transfer_amount_hint_s), new Object[]{this.f46604l.g()}));
        }
    }

    /* renamed from: zh */
    public LoanPresenter createPresenter() {
        return new LoanPresenter();
    }
}
