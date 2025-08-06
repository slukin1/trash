package la;

import android.animation.ValueAnimator;
import com.hbg.lib.widgets.tablayout.TabItemView;

public final /* synthetic */ class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabItemView f58018b;

    public /* synthetic */ h(TabItemView tabItemView) {
        this.f58018b = tabItemView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f58018b.e(valueAnimator);
    }
}
