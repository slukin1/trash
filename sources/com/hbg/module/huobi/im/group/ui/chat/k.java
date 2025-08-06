package com.hbg.module.huobi.im.group.ui.chat;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class k implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f20447b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f20448c;

    public /* synthetic */ k(View view, ValueAnimator valueAnimator) {
        this.f20447b = view;
        this.f20448c = valueAnimator;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f20447b.setBackgroundColor(((Integer) this.f20448c.getAnimatedValue()).intValue());
    }
}
