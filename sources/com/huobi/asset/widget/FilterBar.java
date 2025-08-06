package com.huobi.asset.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import uh.b;
import uh.d;
import vh.h0;
import vh.i0;
import vh.j0;
import vh.k0;
import vh.l0;
import vh.m0;

public class FilterBar extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public EditText f42484b;

    /* renamed from: c  reason: collision with root package name */
    public TextWatcher f42485c;

    /* renamed from: d  reason: collision with root package name */
    public View f42486d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42487e;

    /* renamed from: f  reason: collision with root package name */
    public View f42488f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42489g;

    public class a implements TextWatcher {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            FilterBar.this.f42484b.requestFocus();
        }

        public void afterTextChanged(Editable editable) {
            ViewUtil.m(FilterBar.this.f42486d, !TextUtils.isEmpty(editable));
            d.d().g(editable == null ? "" : editable.toString());
            FilterBar.this.f42484b.post(new m0(this));
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public FilterBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(CommonSwitchButton commonSwitchButton, View view) {
        d.d().h(!commonSwitchButton.isChecked());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(View view) {
        if (this.f42489g) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        b.a(view, String.format(getResources().getString(R$string.n_balance_hide_balance_tip), new Object[]{"0.0001"}));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k(View view) {
        this.f42484b.setText("");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ boolean l(TextView textView, int i11, KeyEvent keyEvent) {
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(CommonSwitchButton commonSwitchButton) {
        commonSwitchButton.b(d.d().e(), true);
        String c11 = d.d().c();
        boolean z11 = false;
        boolean z12 = this.f42484b.getText() == null && !TextUtils.isEmpty(c11);
        if (this.f42484b.getText() != null && !this.f42484b.getText().toString().equals(c11)) {
            z11 = true;
        }
        if (z12 || z11) {
            this.f42484b.removeTextChangedListener(this.f42485c);
            this.f42484b.setText(c11);
            ViewUtil.m(this.f42486d, true ^ TextUtils.isEmpty(c11));
            if (!TextUtils.isEmpty(c11)) {
                this.f42484b.setSelection(c11.length());
            }
            this.f42484b.addTextChangedListener(this.f42485c);
        }
    }

    public final void h(Context context) {
        View.inflate(context, R$layout.layout_asset_list_toolbar, this);
        CommonSwitchButton commonSwitchButton = (CommonSwitchButton) findViewById(R$id.list_toolbar_switcher);
        commonSwitchButton.setChecked(d.d().e());
        commonSwitchButton.setOnClickListener(new h0(commonSwitchButton));
        this.f42488f = findViewById(R$id.line);
        int i11 = R$id.tv_hide_small_balance;
        TextView textView = (TextView) findViewById(i11);
        this.f42487e = textView;
        textView.setText(getResources().getString(R$string.balance_hide_zero_balance));
        findViewById(i11).setOnClickListener(new i0(this));
        findViewById(R$id.search_panel).setVisibility(0);
        View findViewById = findViewById(R$id.clear_btn);
        this.f42486d = findViewById;
        findViewById.setOnClickListener(new j0(this));
        EditText editText = (EditText) findViewById(R$id.search_symbol_input);
        this.f42484b = editText;
        editText.setOnEditorActionListener(k0.f61042b);
        this.f42484b.setText(d.d().c());
        EditText editText2 = this.f42484b;
        editText2.setSelection(editText2.getText().length());
        a aVar = new a();
        this.f42485c = aVar;
        this.f42484b.addTextChangedListener(aVar);
        d.d().a(new l0(this, commonSwitchButton));
    }

    public void n() {
        this.f42489g = true;
        this.f42488f.setVisibility(8);
    }

    public void setFilterTitle(String str) {
        this.f42487e.setText(str);
    }

    public FilterBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        h(context);
    }
}
