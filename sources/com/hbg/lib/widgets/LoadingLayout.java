package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class LoadingLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f71504b;

    /* renamed from: c  reason: collision with root package name */
    public View f71505c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingView f71506d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f71507e;

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(View view) {
        View.OnClickListener onClickListener = this.f71504b;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View b(int i11) {
        if (i11 < getChildCount()) {
            return getChildAt(i11);
        }
        return null;
    }

    public final void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LoadingLayout);
            if (obtainStyledAttributes != null) {
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.LoadingLayout_loading_view, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.LoadingLayout_error_view, R$layout.common_error_view);
                int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.LoadingLayout_empty_view, R$layout.common_empty_view);
                int resourceId4 = obtainStyledAttributes.getResourceId(R$styleable.LoadingLayout_guide_view, R$layout.common_guide_view);
                LayoutInflater from = LayoutInflater.from(getContext());
                from.inflate(resourceId3, this, true);
                from.inflate(resourceId2, this, true);
                if (resourceId != 0) {
                    from.inflate(resourceId, this, true);
                } else {
                    d();
                }
                from.inflate(resourceId4, this, true);
                obtainStyledAttributes.recycle();
            }
            this.f71507e = (ViewGroup) findViewById(R$id.tv_empty_layout);
        }
    }

    public final void d() {
        this.f71505c = LayoutInflater.from(getContext()).inflate(R$layout.dialog_fragment_loading, this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_140);
        LoadingView loadingView = (LoadingView) this.f71505c.findViewById(R$id.loading_dialog_loading_view);
        this.f71506d = loadingView;
        loadingView.setLottieAnimationRes(R$raw.nd_middle_bg);
        addView(this.f71505c, 2, layoutParams);
    }

    public void f(int i11, View view) {
        if (i11 >= 4 || i11 < 0) {
            throw new IllegalArgumentException();
        }
        getViewType();
        removeViewAt(i11);
        addView(view, i11);
        o(i11, false);
    }

    public void g() {
        h(false);
    }

    public int getViewType() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11).getVisibility() == 0) {
                return i11;
            }
        }
        throw null;
    }

    public View.OnClickListener getmOnRetryClickListener() {
        return this.f71504b;
    }

    public void h(boolean z11) {
        o(4, z11);
    }

    public void i() {
        j(false);
    }

    public void j(boolean z11) {
        o(0, z11);
    }

    public void k() {
        l(false);
    }

    public void l(boolean z11) {
        o(1, z11);
    }

    public void m() {
        n(false);
    }

    public void n(boolean z11) {
        o(3, z11);
    }

    public final void o(int i11, boolean z11) {
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (i12 == i11) {
                if (childAt.getVisibility() == 8) {
                    if (z11) {
                        childAt.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                    } else {
                        childAt.clearAnimation();
                    }
                    childAt.setVisibility(0);
                }
                if (i11 == 2) {
                    if (childAt instanceof LoadingView) {
                        LoadingView loadingView = (LoadingView) childAt;
                        if (!loadingView.b()) {
                            loadingView.c();
                        }
                    } else {
                        LoadingView loadingView2 = this.f71506d;
                        if (loadingView2 != null && !loadingView2.b()) {
                            this.f71506d.c();
                        }
                    }
                }
            } else {
                if (childAt.getVisibility() == 0) {
                    if (z11) {
                        childAt.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    } else {
                        childAt.clearAnimation();
                    }
                    childAt.setVisibility(8);
                }
                if (i11 == 2) {
                    if (childAt instanceof LoadingView) {
                        ((LoadingView) childAt).d();
                    } else {
                        LoadingView loadingView3 = this.f71506d;
                        if (loadingView3 != null && !loadingView3.b()) {
                            this.f71506d.c();
                        }
                    }
                }
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i11 = 0; i11 < getChildCount() - 1; i11++) {
            getChildAt(i11).setVisibility(8);
        }
        View findViewById = findViewById(R$id.viewErrorRetry);
        if (findViewById != null) {
            findViewById.setOnClickListener(new e1(this));
        }
    }

    public void p() {
        q(false);
    }

    public void q(boolean z11) {
        o(2, z11);
    }

    public void setEmptyBackground(int i11) {
        this.f71507e.setBackground(getResources().getDrawable(i11));
    }

    public void setEmptyView(View view) {
        f(0, view);
    }

    public void setErrorView(View view) {
        f(1, view);
    }

    public void setGuideView(View view) {
        f(3, view);
    }

    public void setLoadingView(View view) {
        f(2, view);
    }

    public void setOnRetryClickListener(View.OnClickListener onClickListener) {
        this.f71504b = onClickListener;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(attributeSet);
    }
}
