package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

public class RotateAnimTextView extends AppCompatTextView {

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f71607b;

        public a(String str) {
            this.f71607b = str;
        }

        public void onAnimationEnd(Animator animator) {
            RotateAnimTextView.this.setText(this.f71607b);
        }
    }

    public RotateAnimTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void d(String str) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this, TextView.ALPHA, new float[]{1.0f, 0.05f}), ObjectAnimator.ofFloat(this, TextView.SCALE_X, new float[]{1.0f, 0.8f}), ObjectAnimator.ofFloat(this, TextView.SCALE_Y, new float[]{1.0f, 0.8f}), ObjectAnimator.ofFloat(this, TextView.ROTATION_Y, new float[]{0.0f, -80.0f})});
        animatorSet.setDuration(160);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new a(str));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{ObjectAnimator.ofFloat(this, TextView.ALPHA, new float[]{0.05f, 1.0f}), ObjectAnimator.ofFloat(this, TextView.SCALE_X, new float[]{0.8f, 1.0f}), ObjectAnimator.ofFloat(this, TextView.SCALE_Y, new float[]{0.8f, 1.0f}), ObjectAnimator.ofFloat(this, TextView.ROTATION_Y, new float[]{80.0f, 0.0f})});
        animatorSet2.setInterpolator(new AccelerateInterpolator());
        animatorSet2.setDuration(160);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(new Animator[]{animatorSet, animatorSet2});
        animatorSet3.start();
    }

    public RotateAnimTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
