package com.sumsub.sns.camera.photo.presentation.document;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f30689b;

    public /* synthetic */ c(View view) {
        this.f30689b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        a.a(this.f30689b, valueAnimator);
    }
}
