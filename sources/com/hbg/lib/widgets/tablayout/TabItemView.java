package com.hbg.lib.widgets.tablayout;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$font;
import la.a;
import la.h;

public class TabItemView extends AppCompatTextView implements a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f72338b;

    /* renamed from: c  reason: collision with root package name */
    public int f72339c;

    /* renamed from: d  reason: collision with root package name */
    public int f72340d;

    /* renamed from: e  reason: collision with root package name */
    public int f72341e;

    public TabItemView(Context context) {
        this(context, (AttributeSet) null);
        init(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f72341e = intValue;
        setTextColor(intValue);
    }

    public void c(boolean z11, boolean z12) {
        int i11;
        int i12;
        this.f72338b = z11;
        setSelected(z11);
        if (z12) {
            if (getVisibility() == 0 && !TextUtils.isEmpty(getText())) {
                if (z11) {
                    i12 = this.f72340d;
                    i11 = this.f72339c;
                } else {
                    i12 = this.f72339c;
                    i11 = this.f72340d;
                }
                if (this.f72341e == 0) {
                    this.f72341e = i12;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(this.f72341e), Integer.valueOf(i11)});
                ofObject.addUpdateListener(new h(this));
                ofObject.setDuration(270);
                ofObject.setInterpolator(new DecelerateInterpolator());
                ofObject.start();
            }
        } else if (z11) {
            setTextColor(this.f72339c);
        } else {
            setTextColor(this.f72340d);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final void init(Context context) {
        setGravity(17);
        setTextSize(1, 14.0f);
        setAutoSizeTextTypeUniformWithConfiguration(getResources().getDimensionPixelSize(R$dimen.global_text_size_10), getResources().getDimensionPixelSize(R$dimen.global_text_size_14), 1, 0);
        setMaxLines(2);
        setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        setChecked(this.f72338b);
    }

    public void setCheckColor(int i11) {
        this.f72339c = i11;
    }

    public void setChecked(boolean z11) {
        c(z11, false);
    }

    public void setUnCheckColor(int i11) {
        this.f72340d = i11;
    }

    public TabItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
