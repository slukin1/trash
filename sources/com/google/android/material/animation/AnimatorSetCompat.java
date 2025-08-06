package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

public class AnimatorSetCompat {
    public static void playTogether(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j11 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            Animator animator = list.get(i11);
            j11 = Math.max(j11, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0});
        ofInt.setDuration(j11);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
