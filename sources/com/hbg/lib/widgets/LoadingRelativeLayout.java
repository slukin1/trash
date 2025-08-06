package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class LoadingRelativeLayout extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f71508b;

    /* renamed from: c  reason: collision with root package name */
    public LoadingView f71509c;

    public LoadingRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        View view = this.f71508b;
        if (view != null) {
            view.setVisibility(8);
            LoadingView loadingView = this.f71509c;
            if (loadingView != null) {
                loadingView.d();
            }
        }
    }

    public void b() {
        View view = this.f71508b;
        if (view != null) {
            view.setVisibility(0);
            LoadingView loadingView = this.f71509c;
            if (loadingView != null) {
                loadingView.c();
            }
        } else if (getContext() != null) {
            this.f71508b = LayoutInflater.from(getContext()).inflate(R$layout.dialog_fragment_loading, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            addView(this.f71508b, layoutParams);
            LoadingView loadingView2 = (LoadingView) this.f71508b.findViewById(R$id.loading_dialog_loading_view);
            this.f71509c = loadingView2;
            loadingView2.setLottieAnimationRes(R$raw.nd_middle_bg);
            this.f71509c.c();
        }
    }

    public LoadingRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
