package nb;

import android.animation.ValueAnimator;
import com.hbg.lite.trade.DonutProgressBar;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DonutProgressBar f58313b;

    public /* synthetic */ a(DonutProgressBar donutProgressBar) {
        this.f58313b = donutProgressBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f58313b.i(valueAnimator);
    }
}
