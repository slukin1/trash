package vp;

import android.animation.ValueAnimator;
import com.huobi.otc.widget.CollapsingLayout;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollapsingLayout f61124b;

    public /* synthetic */ a(CollapsingLayout collapsingLayout) {
        this.f61124b = collapsingLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f61124b.d(valueAnimator);
    }
}
