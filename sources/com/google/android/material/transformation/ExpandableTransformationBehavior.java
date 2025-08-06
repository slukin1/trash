package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */
    public AnimatorSet currentAnimation;

    public ExpandableTransformationBehavior() {
    }

    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z11, boolean z12);

    public boolean onExpandedStateChange(View view, View view2, boolean z11, boolean z12) {
        AnimatorSet animatorSet = this.currentAnimation;
        boolean z13 = animatorSet != null;
        if (z13) {
            animatorSet.cancel();
        }
        AnimatorSet onCreateExpandedStateChangeAnimation = onCreateExpandedStateChangeAnimation(view, view2, z11, z13);
        this.currentAnimation = onCreateExpandedStateChangeAnimation;
        onCreateExpandedStateChangeAnimation.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                AnimatorSet unused = ExpandableTransformationBehavior.this.currentAnimation = null;
            }
        });
        this.currentAnimation.start();
        if (!z12) {
            this.currentAnimation.end();
        }
        return true;
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
