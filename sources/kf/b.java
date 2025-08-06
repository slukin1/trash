package kf;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f56566b;

    public /* synthetic */ b(View view) {
        this.f56566b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        c.k(this.f56566b, valueAnimator);
    }
}
