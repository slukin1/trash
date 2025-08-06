package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class TextCheckBox extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public String f71616b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBox f71617c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71618d;

    public TextCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c(View view) {
        this.f71617c.toggle();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean b() {
        return this.f71617c.isChecked();
    }

    public void d() {
        this.f71617c.toggle();
    }

    public TextView getTextView() {
        return this.f71618d;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f71617c.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setText(CharSequence charSequence) {
        this.f71618d.setText(charSequence);
    }

    public TextCheckBox(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TextCheckBox, i11, 0);
        this.f71616b = obtainStyledAttributes.getString(R$styleable.TextCheckBox_cb_text);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.layout_text_check_box, this);
        this.f71617c = (CheckBox) findViewById(R$id.check_box);
        TextView textView = (TextView) findViewById(R$id.tv_content);
        this.f71618d = textView;
        textView.setText(this.f71616b);
        setOnClickListener(new m1(this));
    }
}
