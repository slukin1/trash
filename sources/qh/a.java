package qh;

import android.animation.ValueAnimator;
import com.huobi.asset.feature.summary.AssetSummaryAccountItemView;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryAccountItemView f53333b;

    public /* synthetic */ a(AssetSummaryAccountItemView assetSummaryAccountItemView) {
        this.f53333b = assetSummaryAccountItemView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f53333b.s(valueAnimator);
    }
}
