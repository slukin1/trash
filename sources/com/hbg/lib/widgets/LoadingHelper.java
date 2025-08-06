package com.hbg.lib.widgets;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import i6.d;

public class LoadingHelper {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f71500d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f71501a;

    /* renamed from: b  reason: collision with root package name */
    public LoadingView f71502b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f71503c;

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        synchronized (f71500d) {
            if (this.f71501a != null) {
                LoadingView loadingView = this.f71502b;
                if (loadingView != null) {
                    loadingView.d();
                }
                try {
                    ViewGroup viewGroup = this.f71503c;
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f71501a);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        synchronized (f71500d) {
            if (this.f71501a == null) {
                this.f71501a = new FrameLayout(this.f71503c.getContext());
                LoadingView loadingView = new LoadingView(this.f71503c.getContext());
                this.f71502b = loadingView;
                loadingView.setLottieAnimationRes(R$raw.nd_middle_bg);
                Resources resources = this.f71503c.getResources();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelOffset(R$dimen.common_middle_loading_w), resources.getDimensionPixelOffset(R$dimen.common_middle_loading_h));
                layoutParams.gravity = 17;
                this.f71502b.setLayoutParams(layoutParams);
                this.f71501a.addView(this.f71502b);
                this.f71501a.setClickable(true);
            }
            this.f71501a.setLayoutParams(c());
            this.f71503c.addView(this.f71501a);
            LoadingView loadingView2 = this.f71502b;
            if (loadingView2 != null) {
                loadingView2.c();
            }
        }
    }

    public final ViewGroup.LayoutParams c() {
        if (this.f71503c instanceof CoordinatorLayout) {
            return new CoordinatorLayout.LayoutParams(-1, -1);
        }
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public void d() {
        d.b("LoadingHelper-->hideLoading-->" + this.f71503c);
        ViewGroup viewGroup = this.f71503c;
        if (viewGroup != null) {
            viewGroup.post(new c1(this));
        }
    }

    public void g(ViewGroup viewGroup) {
        this.f71503c = viewGroup;
        d.b("LoadingHelper-->showLoading-->" + this.f71503c);
        d();
        ViewGroup viewGroup2 = this.f71503c;
        if (viewGroup2 != null) {
            viewGroup2.post(new d1(this));
        }
    }
}
