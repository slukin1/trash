package cs;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f53470b;

    public /* synthetic */ a(View view) {
        this.f53470b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        h.z(this.f53470b, valueAnimator);
    }
}
