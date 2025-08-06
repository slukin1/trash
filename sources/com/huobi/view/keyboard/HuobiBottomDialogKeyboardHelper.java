package com.huobi.view.keyboard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.view.keyboard.CustomBoardView;

public class HuobiBottomDialogKeyboardHelper extends HuobiKeyboardHelper implements CustomBoardView.KeyboardAnimProxy {
    /* access modifiers changed from: private */
    public int keyboardHeight;
    /* access modifiers changed from: private */
    public LinearLayout llParent;

    private void dialogAnimOut() {
        int height = this.llParent.getHeight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.llParent, View.TRANSLATION_Y, new float[]{(float) height, (float) this.keyboardHeight});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.llParent, View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200).playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$attach$0() {
        this.boardView.setVisibility(4);
        this.keyboardHeight = this.boardView.getHeight();
        dialogAnimOut();
    }

    public HuobiKeyboardHelper attach(Activity activity, LinearLayout linearLayout) {
        if (linearLayout == null || linearLayout.getOrientation() != 1) {
            throw new IllegalArgumentException("A LinearLayout parent with vertical orientation is essential for HuobiKeyboard in dialog.");
        }
        this.llParent = linearLayout;
        CustomBoardView findKeyboard = findKeyboard(linearLayout);
        this.boardView = findKeyboard;
        if (findKeyboard == null) {
            this.boardView = new CustomBoardView(activity);
            linearLayout.addView(this.boardView, new LinearLayout.LayoutParams(-1, -2));
        }
        this.boardView.setKeyboardAnimProxy(this);
        this.llParent.setTranslationY((float) PixelUtils.f());
        this.keyboardHeight = this.boardView.getHeight();
        this.boardView.postDelayed(new c(this), 100);
        return this;
    }

    public void hideKeyboardAnim() {
        if (this.boardView.getVisibility() == 0) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.boardView, View.ALPHA, new float[]{1.0f, 0.5f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.llParent, View.TRANSLATION_Y, new float[]{0.0f, (float) this.keyboardHeight});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.setDuration(220).playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    HuobiBottomDialogKeyboardHelper.this.boardView.setVisibility(4);
                }
            });
            animatorSet.start();
        }
    }

    public void showKeyboardAnim() {
        if (this.boardView.getVisibility() != 0) {
            this.boardView.post(new Runnable() {
                public void run() {
                    HuobiBottomDialogKeyboardHelper.this.boardView.setVisibility(4);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(HuobiBottomDialogKeyboardHelper.this.boardView, View.ALPHA, new float[]{0.5f, 1.0f});
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(HuobiBottomDialogKeyboardHelper.this.llParent, View.TRANSLATION_Y, new float[]{(float) HuobiBottomDialogKeyboardHelper.this.keyboardHeight, 0.0f});
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                    animatorSet.setDuration(220).playTogether(new Animator[]{ofFloat, ofFloat2});
                    animatorSet.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            HuobiBottomDialogKeyboardHelper.this.boardView.setVisibility(0);
                            HuobiBottomDialogKeyboardHelper.this.boardView.clearAnimation();
                            HuobiBottomDialogKeyboardHelper.this.llParent.clearAnimation();
                        }

                        public void onAnimationStart(Animator animator) {
                            super.onAnimationStart(animator);
                            HuobiBottomDialogKeyboardHelper.this.boardView.setVisibility(0);
                        }
                    });
                    animatorSet.start();
                }
            });
        }
    }
}
