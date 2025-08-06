package qh;

import android.animation.ValueAnimator;
import com.huobi.asset.feature.summary.AssetSummaryAccountItemView;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryAccountItemView f53335b;

    public /* synthetic */ b(AssetSummaryAccountItemView assetSummaryAccountItemView) {
        this.f53335b = assetSummaryAccountItemView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f53335b.t(valueAnimator);
    }
}
