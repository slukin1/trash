package pw;

import android.animation.ValueAnimator;
import com.jumio.defaultui.view.IDScanFragment;

public final /* synthetic */ class l implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IDScanFragment f53287b;

    public /* synthetic */ l(IDScanFragment iDScanFragment) {
        this.f53287b = iDScanFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        IDScanFragment.playHoldStillAnimation$lambda$10$lambda$9(this.f53287b, valueAnimator);
    }
}
