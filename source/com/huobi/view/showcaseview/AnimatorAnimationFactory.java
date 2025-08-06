package com.huobi.view.showcaseview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.huobi.view.showcaseview.AnimationFactory;

@TargetApi(11)
class AnimatorAnimationFactory implements AnimationFactory {
    private static final String ALPHA = "alpha";
    private static final float INVISIBLE = 0.0f;
    private static final float VISIBLE = 1.0f;
    private final AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();

    public void animateTargetToPoint(ShowcaseView showcaseView, Point point) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofInt(showcaseView, "showcaseX", new int[]{point.x}), ObjectAnimator.ofInt(showcaseView, "showcaseY", new int[]{point.y})});
        animatorSet.setInterpolator(this.interpolator);
        animatorSet.start();
    }

    public void fadeInView(View view, long j11, final AnimationFactory.AnimationStartListener animationStartListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(j11).addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                animationStartListener.onAnimationStart();
            }
        });
        ofFloat.start();
    }

    public void fadeOutView(View view, long j11, final AnimationFactory.AnimationEndListener animationEndListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ALPHA, new float[]{0.0f});
        ofFloat.setDuration(j11).addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animationEndListener.onAnimationEnd();
            }
        });
        ofFloat.start();
    }
}
