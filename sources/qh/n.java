package qh;

import android.animation.ValueAnimator;
import com.huobi.asset.feature.summary.AssetSummaryHeaderView;

public final /* synthetic */ class n implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryHeaderView f53361b;

    public /* synthetic */ n(AssetSummaryHeaderView assetSummaryHeaderView) {
        this.f53361b = assetSummaryHeaderView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f53361b.Y(valueAnimator);
    }
}
