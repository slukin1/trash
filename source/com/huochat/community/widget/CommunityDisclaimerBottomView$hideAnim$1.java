package com.huochat.community.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class CommunityDisclaimerBottomView$hideAnim$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ Animator.AnimatorListener $listener;
    public final /* synthetic */ CommunityDisclaimerBottomView this$0;

    public CommunityDisclaimerBottomView$hideAnim$1(CommunityDisclaimerBottomView communityDisclaimerBottomView, Animator.AnimatorListener animatorListener) {
        this.this$0 = communityDisclaimerBottomView;
        this.$listener = animatorListener;
    }

    public void onAnimationCancel(Animator animator) {
        onAnimationEnd(animator);
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.mIsAnimStarting = false;
        this.this$0.setVisibility(8);
        Animator.AnimatorListener animatorListener = this.$listener;
        if (animatorListener != null) {
            animatorListener.onAnimationEnd(animator);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.mIsAnimStarting = true;
        Animator.AnimatorListener animatorListener = this.$listener;
        if (animatorListener != null) {
            animatorListener.onAnimationStart(animator);
        }
    }
}
