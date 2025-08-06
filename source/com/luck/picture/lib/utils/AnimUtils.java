package com.luck.picture.lib.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class AnimUtils {
    public static final int DURATION = 250;

    public static void rotateArrow(ImageView imageView, boolean z11) {
        float f11 = 0.0f;
        float f12 = 180.0f;
        if (!z11) {
            f12 = 0.0f;
            f11 = 180.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", new float[]{f11, f12});
        ofFloat.setDuration(250);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    public static void selectZoom(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 1.05f, 1.0f}), ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 1.05f, 1.0f})});
        animatorSet.setDuration(250);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();
    }
}
