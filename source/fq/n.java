package fq;

import android.view.View;
import com.huobi.points.activity.PointsTransferActivity;

public final /* synthetic */ class n implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsTransferActivity f54748b;

    public /* synthetic */ n(PointsTransferActivity pointsTransferActivity) {
        this.f54748b = pointsTransferActivity;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f54748b.zh(view, z11);
    }
}
