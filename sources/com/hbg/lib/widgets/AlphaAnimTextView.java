package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huobi.view.roundimg.RoundedDrawable;

public class AlphaAnimTextView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f70977b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f70978c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f70979d;

    /* renamed from: e  reason: collision with root package name */
    public int f70980e;

    /* renamed from: f  reason: collision with root package name */
    public int f70981f;

    /* renamed from: g  reason: collision with root package name */
    public int f70982g;

    public AlphaAnimTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final TextView a(Context context) {
        TextView textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.f70982g;
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(this.f70980e);
        textView.setTextSize((float) this.f70981f);
        textView.setGravity(this.f70982g);
        addView(textView);
        return textView;
    }

    public final void b(Context context) {
        this.f70977b = a(context);
        TextView a11 = a(context);
        this.f70978c = a11;
        this.f70979d = a11;
    }

    public void c(String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f70979d, FrameLayout.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(120);
        TextView textView = this.f70979d;
        TextView textView2 = this.f70977b;
        if (textView == textView2) {
            textView2 = this.f70978c;
        }
        this.f70979d = textView2;
        textView2.setText(str);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView2, FrameLayout.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(120);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public void setGravity(int i11) {
        this.f70977b.setGravity(i11);
        this.f70977b.setGravity(i11);
    }

    public void setText(CharSequence charSequence) {
        this.f70977b.setText(charSequence);
        this.f70978c.setText(charSequence);
    }

    public void setTextColor(int i11) {
        this.f70977b.setTextColor(i11);
        this.f70978c.setTextColor(i11);
    }

    public void setTextSize(int i11) {
        float f11 = (float) i11;
        this.f70977b.setTextSize(f11);
        this.f70978c.setTextSize(f11);
    }

    public AlphaAnimTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AlphaAnimTextView, i11, 0);
        CharSequence text = obtainStyledAttributes.getText(R$styleable.AlphaAnimTextView_anim_tv_text);
        this.f70980e = obtainStyledAttributes.getColor(R$styleable.AlphaAnimTextView_anim_tv_text_color, RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f70981f = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.AlphaAnimTextView_anim_tv_text_size, 0);
        this.f70982g = obtainStyledAttributes.getInteger(R$styleable.AlphaAnimTextView_anim_tv_gravity, 8388611);
        obtainStyledAttributes.recycle();
        b(context);
        this.f70978c.setText(text);
    }
}
