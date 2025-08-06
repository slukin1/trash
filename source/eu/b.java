package eu;

import android.animation.ValueAnimator;
import com.huobi.view.button.StatusButton;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StatusButton f54459b;

    public /* synthetic */ b(StatusButton statusButton) {
        this.f54459b = statusButton;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f54459b.lambda$startAnim$0(valueAnimator);
    }
}
