package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;

public class ProgressConfirmButton extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public SafeLottieView f71599b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f71600c;

    public ProgressConfirmButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_progress_button, this);
        this.f71599b = (SafeLottieView) inflate.findViewById(R$id.progress_lv);
        this.f71600c = (TextView) inflate.findViewById(R$id.confirm_tv);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ProgressConfirmButton);
        if (obtainStyledAttributes != null) {
            this.f71600c.setText(obtainStyledAttributes.getString(R$styleable.ProgressConfirmButton_confirm_text));
            this.f71600c.setTextSize((float) PixelUtils.h(obtainStyledAttributes.getDimension(R$styleable.ProgressConfirmButton_confirm_text_size, 12.0f)));
            this.f71600c.setTextColor(obtainStyledAttributes.getColor(R$styleable.ProgressConfirmButton_confirm_text_color, 0));
            setEnabled(obtainStyledAttributes.getBoolean(R$styleable.ProgressConfirmButton_confirm_btn_enable, true));
            obtainStyledAttributes.recycle();
        }
    }

    public void b() {
        this.f71599b.playAnimation();
        this.f71600c.setVisibility(8);
        this.f71599b.setVisibility(0);
        setEnabled(false);
    }

    public void c() {
        this.f71599b.cancelAnimation();
        this.f71600c.setVisibility(0);
        this.f71599b.setVisibility(8);
        setEnabled(true);
    }

    public TextView getmConfirmTv() {
        return this.f71600c;
    }

    public ProgressConfirmButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(attributeSet);
    }
}
