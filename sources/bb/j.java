package bb;

import android.animation.ValueAnimator;
import com.hbg.lite.index.ui.LiteIndexOtcReminderView;

public final /* synthetic */ class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteIndexOtcReminderView f12335b;

    public /* synthetic */ j(LiteIndexOtcReminderView liteIndexOtcReminderView) {
        this.f12335b = liteIndexOtcReminderView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f12335b.j(valueAnimator);
    }
}
