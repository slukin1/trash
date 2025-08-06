package com.jumio.defaultui.view;

import android.animation.Animator;
import android.widget.ImageView;
import com.jumio.defaultui.R;

public final class IDScanFragment$flipCardAndHide$lambda$18$$inlined$doOnEnd$1 implements Animator.AnimatorListener {
    public final /* synthetic */ IDScanFragment this$0;

    public IDScanFragment$flipCardAndHide$lambda$18$$inlined$doOnEnd$1(IDScanFragment iDScanFragment) {
        this.this$0 = iDScanFragment;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        ImageView animationIcon = this.this$0.getAnimationIcon();
        if (animationIcon != null) {
            animationIcon.setImageResource(R.drawable.jumio_ic_card_back);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
