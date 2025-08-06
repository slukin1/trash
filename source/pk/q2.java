package pk;

import android.animation.ValueAnimator;
import com.huobi.feature.ui.LeverSelectDialogFragment;

public final /* synthetic */ class q2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LeverSelectDialogFragment f53130b;

    public /* synthetic */ q2(LeverSelectDialogFragment leverSelectDialogFragment) {
        this.f53130b = leverSelectDialogFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f53130b.hi(valueAnimator);
    }
}
