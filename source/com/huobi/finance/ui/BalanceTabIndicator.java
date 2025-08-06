package com.huobi.finance.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.R$id;
import p10.a;

public class BalanceTabIndicator extends MagicIndicator {

    /* renamed from: c  reason: collision with root package name */
    public HorizontalScrollView f46389c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46390d = true;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f46391e;

    /* renamed from: f  reason: collision with root package name */
    public DecelerateInterpolator f46392f = new DecelerateInterpolator();

    public BalanceTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l(View view) {
        this.f46389c.smoothScrollTo(Integer.MAX_VALUE, 0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(View view, int i11, int i12, int i13, int i14) {
        if (this.f46391e.getVisibility() == 0) {
            if (k(view)) {
                j();
            } else {
                i();
            }
        }
    }

    public final boolean f() {
        View childAt;
        HorizontalScrollView horizontalScrollView = this.f46389c;
        if (horizontalScrollView == null || (childAt = horizontalScrollView.getChildAt(0)) == null || childAt.getWidth() <= (this.f46389c.getWidth() - this.f46389c.getPaddingLeft()) - this.f46389c.getPaddingRight()) {
            return false;
        }
        return true;
    }

    public void g(float f11) {
        ImageView imageView = this.f46391e;
        if (imageView != null) {
            imageView.setAlpha(f11);
        }
    }

    public void h(int i11) {
        ImageView imageView = this.f46391e;
        if (imageView != null) {
            imageView.setImageResource(i11);
        }
    }

    public final void i() {
        if (!this.f46390d) {
            this.f46390d = true;
            this.f46391e.animate().setInterpolator(this.f46392f).setDuration(300).translationX(0.0f).alpha(1.0f);
        }
    }

    public final void j() {
        if (this.f46390d) {
            this.f46390d = false;
            this.f46391e.animate().setInterpolator(this.f46392f).setDuration(300).translationX((float) this.f46391e.getWidth()).alpha(0.0f);
        }
    }

    public final boolean k(View view) {
        return ((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f46389c.getChildAt(0).getWidth();
    }

    public void n() {
        if (this.f46391e != null) {
            if (f()) {
                this.f46391e.setVisibility(0);
                return;
            }
            ImageView imageView = this.f46391e;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public void setCoverView(ImageView imageView) {
        this.f46391e = imageView;
        imageView.setOnClickListener(new y2(this));
        if (Build.VERSION.SDK_INT >= 23) {
            this.f46389c.setOnScrollChangeListener(new z2(this));
        }
    }

    public void setNavigator(a aVar) {
        super.setNavigator(aVar);
        this.f46389c = (HorizontalScrollView) findViewById(R$id.scroll_view);
        post(new a3(this));
    }
}
