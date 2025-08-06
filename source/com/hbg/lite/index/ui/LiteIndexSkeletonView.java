package com.hbg.lite.index.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lite.R$color;
import com.hbg.lite.R$dimen;
import com.hbg.lite.R$raw;

public class LiteIndexSkeletonView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f77170b;

    public LiteIndexSkeletonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i11, int i12) {
        float f11 = ((float) (i11 * 114)) / 750.0f;
        SafeLottieView safeLottieView = new SafeLottieView(getContext());
        if (NightHelper.e().g()) {
            safeLottieView.setAnimation(R$raw.skeleton_lite_home_b_night);
        } else {
            safeLottieView.setAnimation(R$raw.skeleton_lite_home_b);
        }
        safeLottieView.setRepeatCount(-1);
        addView(safeLottieView, i11, (int) f11);
        View view = new View(getContext());
        view.setBackgroundColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimarySeparator));
        addView(view, i11, getResources().getDimensionPixelOffset(R$dimen.dimen_0_5));
        safeLottieView.playAnimation();
        float f12 = (((float) i11) * 148.0f) / 750.0f;
        float f13 = ((float) ((int) (((float) i12) - f11))) / f12;
        for (int i13 = 0; ((float) i13) < f13; i13++) {
            SafeLottieView safeLottieView2 = new SafeLottieView(getContext());
            if (NightHelper.e().g()) {
                safeLottieView2.setAnimation(R$raw.skeleton_lite_home_c_night);
            } else {
                safeLottieView2.setAnimation(R$raw.skeleton_lite_home_c);
            }
            safeLottieView2.setRepeatCount(-1);
            addView(safeLottieView2, i11, (int) f12);
            View view2 = new View(getContext());
            view2.setBackgroundColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimarySeparator));
            addView(view2, i11, getResources().getDimensionPixelOffset(R$dimen.dimen_0_5));
            safeLottieView2.playAnimation();
        }
    }

    public void b() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) instanceof SafeLottieView) {
                ((SafeLottieView) getChildAt(i11)).playAnimation();
            }
        }
    }

    public void c() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) instanceof SafeLottieView) {
                ((SafeLottieView) getChildAt(i11)).cancelAnimation();
            }
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (!this.f77170b) {
            this.f77170b = true;
            a(i11, i12);
        }
    }

    public LiteIndexSkeletonView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
