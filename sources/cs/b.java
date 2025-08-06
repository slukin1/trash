package cs;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f53471b;

    public /* synthetic */ b(View view) {
        this.f53471b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        h.A(this.f53471b, valueAnimator);
    }
}
