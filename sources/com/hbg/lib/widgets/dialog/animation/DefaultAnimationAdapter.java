package com.hbg.lib.widgets.dialog.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;

public class DefaultAnimationAdapter implements aa.a {

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseDialogFragment f71930b;

        public a(BaseDialogFragment baseDialogFragment) {
            this.f71930b = baseDialogFragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f71930b.doDismiss();
        }
    }

    public void a(BaseDialogFragment baseDialogFragment, View view) {
        view.setPivotY(0.0f);
        view.setPivotX((float) (view.getWidth() / 2));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{0.7f, 1.0f}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{0.7f, 1.0f}), ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f})});
        animatorSet.setDuration(170);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
    }

    public boolean b(BaseDialogFragment baseDialogFragment, View view) {
        if (view == null || baseDialogFragment == null) {
            return false;
        }
        view.setPivotY(0.0f);
        view.setPivotX((float) (view.getWidth() / 2));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{1.0f, 0.7f});
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{1.0f, 0.7f});
        ofFloat2.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration(170);
        animatorSet.addListener(new a(baseDialogFragment));
        animatorSet.start();
        return true;
    }
}
