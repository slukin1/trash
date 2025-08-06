package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$raw;

public class OtcAdsSkeletonView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f79944b;

    public OtcAdsSkeletonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i11, int i12) {
        float f11 = (((float) i11) * 328.0f) / 750.0f;
        float f12 = ((float) i12) / f11;
        float f13 = f11 - 15.0f;
        for (int i13 = 0; ((float) i13) < f12; i13++) {
            SafeLottieView safeLottieView = new SafeLottieView(getContext());
            if (NightHelper.e().g()) {
                safeLottieView.setAnimation(R$raw.skeleton_otc_a_night);
            } else {
                safeLottieView.setAnimation(R$raw.skeleton_otc_a);
            }
            safeLottieView.setRepeatCount(-1);
            addView(safeLottieView, i11, (int) f13);
            View view = new View(getContext());
            view.setBackgroundColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimarySeparator));
            addView(view, i11, getResources().getDimensionPixelOffset(R$dimen.dimen_0_5));
            safeLottieView.playAnimation();
        }
    }

    public void b() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof SafeLottieView) {
                SafeLottieView safeLottieView = (SafeLottieView) childAt;
                if (!safeLottieView.isAnimating()) {
                    safeLottieView.playAnimation();
                }
            }
        }
    }

    public void c() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof SafeLottieView) {
                SafeLottieView safeLottieView = (SafeLottieView) childAt;
                if (safeLottieView.isAnimating()) {
                    safeLottieView.cancelAnimation();
                }
            }
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (!this.f79944b) {
            this.f79944b = true;
            a(i11, i12);
        }
    }

    public OtcAdsSkeletonView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
