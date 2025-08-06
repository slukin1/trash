package pk;

import android.animation.ValueAnimator;
import com.huobi.feature.ui.LeverSelectDialogFragment;

public final /* synthetic */ class v2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LeverSelectDialogFragment f53153b;

    public /* synthetic */ v2(LeverSelectDialogFragment leverSelectDialogFragment) {
        this.f53153b = leverSelectDialogFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f53153b.ii(valueAnimator);
    }
}
