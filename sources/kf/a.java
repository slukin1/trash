package kf;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f56565b;

    public /* synthetic */ a(View view) {
        this.f56565b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        c.j(this.f56565b, valueAnimator);
    }
}
