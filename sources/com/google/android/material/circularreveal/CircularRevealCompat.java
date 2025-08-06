package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.circularreveal.CircularRevealWidget;

public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f11, float f12, float f13) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f11, f12, f13)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f11, (int) f12, revealInfo.radius, f13);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Animator.AnimatorListener createCircularRevealListener(final CircularRevealWidget circularRevealWidget) {
        return new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                circularRevealWidget.destroyCircularRevealCache();
            }

            public void onAnimationStart(Animator animator) {
                circularRevealWidget.buildCircularRevealCache();
            }
        };
    }

    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f11, float f12, float f13, float f14) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f11, f12, f13), new CircularRevealWidget.RevealInfo(f11, f12, f14)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f11, (int) f12, f13, f14);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
        return animatorSet;
    }
}
