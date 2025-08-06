package com.huobi.contract.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.contract.R$drawable;
import com.hbg.lib.contract.R$font;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import dj.m0;
import i6.m;

public class ContractTpslEditText extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public EditText f43348b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f43349c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43350d;

    /* renamed from: e  reason: collision with root package name */
    public k4 f43351e;

    /* renamed from: f  reason: collision with root package name */
    public c f43352f;

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (ContractTpslEditText.this.f43351e != null) {
                ContractTpslEditText.this.f43351e.onFocusChange(view, z11);
            }
            if (!z11) {
                ContractTpslEditText.this.f43348b.setSelection(0);
            }
            ContractTpslEditText.this.setInputBackgroundRes(z11);
            ContractTpslEditText.this.f();
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                ContractTpslEditText.this.f43348b.setTypeface(ResourcesCompat.h(ContractTpslEditText.this.getContext(), R$font.roboto_regular));
            } else {
                ContractTpslEditText.this.f43348b.setTypeface(ResourcesCompat.h(ContractTpslEditText.this.getContext(), R$font.roboto_medium));
            }
            if (ContractTpslEditText.this.f43352f != null) {
                String b11 = m.b(editable, 10, ContractTpslEditText.this.f43352f.getTradePricePrecision());
                if (b11 != null) {
                    ContractTpslEditText.this.f43348b.setText(b11);
                    ContractTpslEditText.this.f43348b.setSelection(b11.length());
                    ContractTpslEditText.this.f43352f.afterTextChanged(ContractTpslEditText.this.f43348b, b11);
                } else {
                    ContractTpslEditText.this.f43352f.afterTextChanged(ContractTpslEditText.this.f43348b, editable.toString().trim());
                }
            }
            ContractTpslEditText.this.f();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public interface c {
        void afterTextChanged(EditText editText, String str);

        int getTradePricePrecision();
    }

    public ContractTpslEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        this.f43348b.setText("");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void setInputBackgroundRes(boolean z11) {
        if (z11) {
            setBackgroundResource(R$drawable.custom_edittext_blue_focused_bg);
        } else {
            setBackgroundResource(R$drawable.custom_edittext_normal_bg);
        }
    }

    public void f() {
        if (!this.f43350d || !this.f43348b.hasFocus() || this.f43348b.length() <= 0) {
            this.f43349c.setVisibility(8);
        } else {
            this.f43349c.setVisibility(0);
        }
    }

    public final void g(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_contract_tpsl_editext, this, true);
        this.f43348b = (EditText) findViewById(R$id.input_price_et);
        this.f43349c = (ImageView) findViewById(R$id.inputClearBtn);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ContractTpslEditText);
        if (obtainStyledAttributes != null) {
            this.f43348b.setHint(obtainStyledAttributes.getString(R$styleable.ContractTpslEditText_contract_tpsl_edittext_hint));
            obtainStyledAttributes.recycle();
        }
        setInputBackgroundRes(false);
        h();
    }

    public ImageView getClearImageView() {
        return this.f43349c;
    }

    public EditText getEditText() {
        return this.f43348b;
    }

    public final void h() {
        this.f43348b.setKeyListener(DigitsKeyListener.getInstance(false, true));
        this.f43348b.setOnFocusChangeListener(new a());
        this.f43348b.addTextChangedListener(new b());
        this.f43349c.setOnClickListener(new m0(this));
    }

    public void setCallback(c cVar) {
        this.f43352f = cVar;
    }

    public void setClearEnable(boolean z11) {
        this.f43350d = z11;
    }

    public void setHintText(String str) {
        this.f43348b.setHint(str);
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.f43351e = k4Var;
    }

    public ContractTpslEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43350d = true;
        g(attributeSet);
    }

    public void setHintText(int i11) {
        this.f43348b.setHint(i11);
    }
}
