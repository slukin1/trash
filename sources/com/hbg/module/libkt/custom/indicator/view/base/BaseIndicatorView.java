package com.hbg.module.libkt.custom.indicator.view.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;

public class BaseIndicatorView extends View implements ViewPager.OnPageChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public IndicatorOptions f24840b = new IndicatorOptions();

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f24841c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager2 f24842d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24843e;

    /* renamed from: f  reason: collision with root package name */
    public final a f24844f = new a(this);

    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseIndicatorView f24845a;

        public a(BaseIndicatorView baseIndicatorView) {
            this.f24845a = baseIndicatorView;
        }

        public void onPageScrollStateChanged(int i11) {
            this.f24845a.e(i11);
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            this.f24845a.f(i11, f11, i12);
        }

        public void onPageSelected(int i11) {
            this.f24845a.g(i11);
        }
    }

    public BaseIndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    private final void setCurrentPosition(int i11) {
        this.f24840b.o(i11);
    }

    private final void setPageSize(int i11) {
        this.f24840b.t(i11);
    }

    private final void setSlideProgress(float f11) {
        this.f24840b.v(f11);
    }

    public void d() {
        o();
        requestLayout();
        invalidate();
    }

    public final void e(int i11) {
    }

    public final void f(int i11, float f11, int i12) {
        if (getSlideMode() != 0 && getPageSize() > 1) {
            h(i11, f11);
            invalidate();
        }
    }

    public final void g(int i11) {
        if (getSlideMode() == 0) {
            setCurrentPosition(i11);
            setSlideProgress(0.0f);
            invalidate();
        }
    }

    public final int getCheckedColor() {
        return this.f24840b.a();
    }

    public final float getCheckedSliderWidth() {
        return this.f24840b.b();
    }

    public final int getCurrentPosition() {
        return this.f24840b.c();
    }

    public final float getIndicatorGap() {
        return this.f24840b.l();
    }

    public final IndicatorOptions getIndicatorOptions() {
        return this.f24840b;
    }

    public final IndicatorOptions getMIndicatorOptions() {
        return this.f24840b;
    }

    public final int getNormalColor() {
        return this.f24840b.e();
    }

    public final float getNormalSlideWidth() {
        return this.f24840b.f();
    }

    public final float getNormalSliderWidth() {
        return this.f24840b.f();
    }

    public final int getPageSize() {
        return this.f24840b.h();
    }

    public final int getSlideMode() {
        return this.f24840b.j();
    }

    public final float getSlideProgress() {
        return this.f24840b.k();
    }

    public final void h(int i11, float f11) {
        if (this.f24840b.j() == 4 || this.f24840b.j() == 5) {
            setCurrentPosition(i11 % getPageSize());
            setSlideProgress(f11);
        } else if (i11 % getPageSize() != getPageSize() - 1) {
            setCurrentPosition(i11 % getPageSize());
            setSlideProgress(f11);
        } else if (((double) f11) < 0.5d) {
            setCurrentPosition(i11 % getPageSize());
            setSlideProgress(0.0f);
        } else {
            setCurrentPosition(0);
            setSlideProgress(0.0f);
        }
    }

    public final BaseIndicatorView i(int i11) {
        this.f24840b.p(i11);
        return this;
    }

    public final BaseIndicatorView j(int i11) {
        this.f24840b.u(i11);
        return this;
    }

    public final BaseIndicatorView k(int i11, int i12) {
        this.f24840b.w(i11, i12);
        return this;
    }

    public final BaseIndicatorView l(float f11) {
        this.f24840b.x(f11);
        return this;
    }

    public final BaseIndicatorView m(float f11) {
        this.f24840b.y(f11);
        return this;
    }

    public final BaseIndicatorView n(float f11, float f12) {
        this.f24840b.z(f11, f12);
        return this;
    }

    public final void o() {
        ViewPager viewPager = this.f24841c;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this);
            this.f24841c.addOnPageChangeListener(this);
            if (this.f24841c.getAdapter() != null) {
                setPageSize(this.f24841c.getAdapter().getCount());
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = this.f24842d;
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(this.f24844f);
            this.f24842d.registerOnPageChangeCallback(this.f24844f);
            if (this.f24842d.getAdapter() != null && !this.f24843e) {
                setPageSize(this.f24842d.getAdapter().getItemCount());
            }
        }
    }

    public void onPageScrollStateChanged(int i11) {
        e(i11);
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        f(i11, f11, i12);
    }

    public void onPageSelected(int i11) {
        g(i11);
    }

    public void setIndicatorOptions(IndicatorOptions indicatorOptions) {
        this.f24840b = indicatorOptions;
    }

    public final void setMIndicatorOptions(IndicatorOptions indicatorOptions) {
        this.f24840b = indicatorOptions;
    }

    public final void setNormalSlideWidth(float f11) {
        this.f24840b.r(f11);
    }

    public final void setupCycle(boolean z11) {
        this.f24843e = z11;
    }

    public final void setupCyclePage(int i11) {
        setPageSize(i11);
    }

    public final void setupWithViewPager(ViewPager viewPager) {
        this.f24841c = viewPager;
        d();
    }

    public final void setupWithViewPager(ViewPager2 viewPager2) {
        this.f24842d = viewPager2;
        d();
    }
}
