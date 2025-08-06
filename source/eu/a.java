package eu;

import android.animation.ValueAnimator;
import com.huobi.view.button.CircleStatusButton;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CircleStatusButton f54458b;

    public /* synthetic */ a(CircleStatusButton circleStatusButton) {
        this.f54458b = circleStatusButton;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f54458b.lambda$startAnimator$0(valueAnimator);
    }
}
