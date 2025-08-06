package fo;

import android.animation.ValueAnimator;
import android.view.View;
import com.huobi.main.ui.HuobiMainActivity;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f54711b;

    public /* synthetic */ a(View view) {
        this.f54711b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HuobiMainActivity.Yh(this.f54711b, valueAnimator);
    }
}
