package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class CommonAllEditText extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public Context f71057b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f71058c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71059d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f71060e;

    /* renamed from: f  reason: collision with root package name */
    public String f71061f;

    public CommonAllEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d(View view) {
        this.f71058c.setText(this.f71061f);
        EditText editText = this.f71058c;
        editText.setSelection(editText.getText().toString().length());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void b() {
        this.f71060e.setOnClickListener(new i(this));
    }

    public final void c(Context context, AttributeSet attributeSet) {
        this.f71057b = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.common_all_edittext, this);
        this.f71058c = (EditText) inflate.findViewById(R$id.all_edittext_et);
        this.f71059d = (TextView) inflate.findViewById(R$id.currency_unit_tv);
        this.f71060e = (TextView) inflate.findViewById(R$id.all_edittext_tv);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CommonAllEditText);
        if (obtainStyledAttributes != null) {
            this.f71058c.setHint(obtainStyledAttributes.getString(R$styleable.CommonAllEditText_edittext_hint));
            obtainStyledAttributes.recycle();
        }
        b();
    }

    public EditText getEditText() {
        return this.f71058c;
    }

    public void setAllText(String str) {
        this.f71061f = str;
    }

    public void setCurrencyUnitText(String str) {
        this.f71059d.setText(str);
    }

    public void setEditTextText(String str) {
        this.f71058c.setText(str);
    }

    public CommonAllEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context, attributeSet);
    }
}
