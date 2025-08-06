package com.hbg.lib.widgets.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class CommonAnimateUtil {
    public static void a(View view) {
        view.setPivotX(0.0f);
        view.setPivotY((float) (view.getHeight() >> 1));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{1.0f, 1.1f, 1.0f}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{1.0f, 1.1f, 1.0f})});
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }
}
