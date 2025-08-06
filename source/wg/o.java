package wg;

import android.animation.ValueAnimator;
import com.huobi.account.widget.AnimationChangeGroupView;

public final /* synthetic */ class o implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnimationChangeGroupView f61258b;

    public /* synthetic */ o(AnimationChangeGroupView animationChangeGroupView) {
        this.f61258b = animationChangeGroupView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f61258b.h(valueAnimator);
    }
}
