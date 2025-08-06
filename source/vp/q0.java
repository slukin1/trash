package vp;

import android.animation.ValueAnimator;
import com.huobi.otc.widget.SecurityScrollLayout;

public final /* synthetic */ class q0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityScrollLayout f61173b;

    public /* synthetic */ q0(SecurityScrollLayout securityScrollLayout) {
        this.f61173b = securityScrollLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f61173b.h(valueAnimator);
    }
}
