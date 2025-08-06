package qh;

import android.animation.ValueAnimator;
import com.huobi.asset.feature.summary.AssetSummaryHeaderView;

public final /* synthetic */ class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryHeaderView f53375b;

    public /* synthetic */ w(AssetSummaryHeaderView assetSummaryHeaderView) {
        this.f53375b = assetSummaryHeaderView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f53375b.Z(valueAnimator);
    }
}
