package com.hbg.module.libkt.custom.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import com.huobi.view.roundview.RoundViewDelegate;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.jvm.internal.r;

public final class RoundTXCloudVideoView extends TXCloudVideoView {

    /* renamed from: b  reason: collision with root package name */
    public final RoundViewDelegate f24860b;

    public RoundTXCloudVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (SurfaceView) null, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoundTXCloudVideoView(Context context, AttributeSet attributeSet, SurfaceView surfaceView, int i11, r rVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? null : surfaceView);
    }

    public final RoundViewDelegate getDelegate() {
        return this.f24860b;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f24860b.isRadiusHalfHeight()) {
            this.f24860b.setCornerRadius(getHeight() / 2);
        } else {
            this.f24860b.setBgSelector();
        }
    }

    public void onMeasure(int i11, int i12) {
        if (!this.f24860b.isWidthHeightEqual() || getWidth() <= 0 || getHeight() <= 0) {
            super.onMeasure(i11, i12);
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public RoundTXCloudVideoView(Context context, AttributeSet attributeSet, SurfaceView surfaceView) {
        super(context, attributeSet, surfaceView);
        this.f24860b = new RoundViewDelegate(this, context, attributeSet);
    }
}
