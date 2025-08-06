package com.hbg.module.community.coordinatorTabLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.huobi.utils.StatusBarUtils;

public final class WrapCollapsingToolbarLayout extends CollapsingToolbarLayout {

    /* renamed from: b  reason: collision with root package name */
    public TypedValue f17231b = new TypedValue();

    public WrapCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final TypedValue getTv() {
        return this.f17231b;
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + StatusBarUtils.a(getContext()) + (getContext().getTheme().resolveAttribute(16843499, this.f17231b, true) ? TypedValue.complexToDimensionPixelSize(this.f17231b.data, getResources().getDisplayMetrics()) : 0), Integer.MIN_VALUE));
    }

    public final void setTv(TypedValue typedValue) {
        this.f17231b = typedValue;
    }
}
