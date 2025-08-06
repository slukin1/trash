package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;

public abstract class BaseOrderFilterDialogFragment extends BaseDialogFragment {
    public static final long DURATION = 270;
    public Animator.AnimatorListener animatorListener = new a();
    private boolean canReset;
    public ObjectAnimator closeAnimator;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            BaseOrderFilterDialogFragment baseOrderFilterDialogFragment = BaseOrderFilterDialogFragment.this;
            baseOrderFilterDialogFragment.closeAnimator = null;
            baseOrderFilterDialogFragment.doDismiss();
        }
    }

    private void doOnBackClick() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        doOnBackClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        View backBtn = getBackBtn();
        if (backBtn != null) {
            backBtn.setOnClickListener(new e(this));
        }
    }

    public void configCoverViewLayoutParams(View view, FrameLayout.LayoutParams layoutParams) {
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_44);
    }

    public void doContentViewHideAnimation(View view) {
        View filterLayout;
        ObjectAnimator objectAnimator = this.closeAnimator;
        if ((objectAnimator == null || !objectAnimator.isRunning()) && (filterLayout = getFilterLayout()) != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(filterLayout, View.TRANSLATION_Y, new float[]{0.0f, (float) (-getTranslateY())}).setDuration(270);
            this.closeAnimator = duration;
            duration.addListener(this.animatorListener);
            this.closeAnimator.setInterpolator(new DecelerateInterpolator());
            this.closeAnimator.start();
        }
    }

    public void doContentViewShowAnimation(View view) {
        View filterLayout = getFilterLayout();
        if (filterLayout != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(filterLayout, View.TRANSLATION_Y, new float[]{(float) (-getTranslateY()), 0.0f});
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(270).start();
        }
    }

    public abstract View getBackBtn();

    public abstract View getFilterLayout();

    public int getGravity() {
        return 48;
    }

    public int getTranslateY() {
        return getResources().getDimensionPixelOffset(R$dimen.dimen_143);
    }

    public boolean isCanReset() {
        return this.canReset;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (isCanReset()) {
            reset();
            setCanReset(false);
        }
    }

    public abstract void reset();

    public void setCanReset(boolean z11) {
        this.canReset = z11;
    }

    public boolean useWindowBg() {
        return false;
    }
}
