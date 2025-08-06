package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ballpulse.BallPulseView;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.f;
import ky.i;
import ky.j;
import t0.c;

public class BallPulseFooter extends ViewGroup implements f {

    /* renamed from: b  reason: collision with root package name */
    public BallPulseView f29814b;

    /* renamed from: c  reason: collision with root package name */
    public SpinnerStyle f29815c = SpinnerStyle.Translate;

    /* renamed from: d  reason: collision with root package name */
    public Integer f29816d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f29817e;

    public BallPulseFooter(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        BallPulseView ballPulseView = new BallPulseView(context);
        this.f29814b = ballPulseView;
        addView(ballPulseView, -2, -2);
        setMinimumHeight(DensityUtil.b(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BallPulseFooter);
        int i12 = R$styleable.BallPulseFooter_srlAnimatingColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            b(obtainStyledAttributes.getColor(i12, 0));
        }
        int i13 = R$styleable.BallPulseFooter_srlNormalColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            d(obtainStyledAttributes.getColor(i13, 0));
        }
        int i14 = R$styleable.BallPulseFooter_srlIndicatorColor;
        if (obtainStyledAttributes.hasValue(i14)) {
            c(obtainStyledAttributes.getColor(i14, 0));
        }
        this.f29815c = SpinnerStyle.values()[obtainStyledAttributes.getInt(R$styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f29815c.ordinal())];
        obtainStyledAttributes.recycle();
    }

    public BallPulseFooter b(int i11) {
        this.f29817e = Integer.valueOf(i11);
        this.f29814b.setAnimatingColor(i11);
        return this;
    }

    public BallPulseFooter c(int i11) {
        this.f29814b.setIndicatorColor(i11);
        return this;
    }

    public BallPulseFooter d(int i11) {
        this.f29816d = Integer.valueOf(i11);
        this.f29814b.setNormalColor(i11);
        return this;
    }

    public SpinnerStyle getSpinnerStyle() {
        return this.f29815c;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public int onFinish(j jVar, boolean z11) {
        this.f29814b.e();
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f29814b.getMeasuredWidth();
        int measuredHeight2 = this.f29814b.getMeasuredHeight();
        int i15 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i16 = (measuredHeight / 2) - (measuredHeight2 / 2);
        this.f29814b.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
    }

    public void onMeasure(int i11, int i12) {
        this.f29814b.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12), Integer.MIN_VALUE));
        setMeasuredDimension(ViewGroup.resolveSize(this.f29814b.getMeasuredWidth(), i11), ViewGroup.resolveSize(this.f29814b.getMeasuredHeight(), i12));
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        this.f29814b.d();
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    public boolean setNoMoreData(boolean z11) {
        return false;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.f29817e == null && iArr.length > 1) {
            this.f29814b.setAnimatingColor(iArr[0]);
        }
        if (this.f29816d != null) {
            return;
        }
        if (iArr.length > 1) {
            this.f29814b.setNormalColor(iArr[1]);
        } else if (iArr.length > 0) {
            this.f29814b.setNormalColor(c.f(-1711276033, iArr[0]));
        }
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet, i11);
    }
}
