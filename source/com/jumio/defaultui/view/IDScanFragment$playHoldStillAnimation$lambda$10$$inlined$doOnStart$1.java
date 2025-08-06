package com.jumio.defaultui.view;

import android.animation.Animator;

public final class IDScanFragment$playHoldStillAnimation$lambda$10$$inlined$doOnStart$1 implements Animator.AnimatorListener {
    public final /* synthetic */ IDScanFragment this$0;

    public IDScanFragment$playHoldStillAnimation$lambda$10$$inlined$doOnStart$1(IDScanFragment iDScanFragment) {
        this.this$0 = iDScanFragment;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        IDScanFragment iDScanFragment = this.this$0;
        BaseFragment.fadeAndScaleTo$default(iDScanFragment, iDScanFragment.getAnimationIcon(), 4, 0, 0, 6, (Object) null);
    }
}
