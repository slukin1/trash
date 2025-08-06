package com.jumio.defaultui.view;

import android.animation.Animator;
import android.widget.ImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.jumio.commons.log.Log;
import com.jumio.core.views.CameraScanView;
import com.jumio.defaultui.R;

public final class IDScanFragment$flipCardAndHide$$inlined$doOnStart$1 implements Animator.AnimatorListener {
    public final /* synthetic */ IDScanFragment this$0;

    public IDScanFragment$flipCardAndHide$$inlined$doOnStart$1(IDScanFragment iDScanFragment) {
        this.this$0 = iDScanFragment;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.getJumioViewModel$jumio_defaultui_release().f56365m.setValue(Boolean.FALSE);
        CameraScanView scanView = this.this$0.getScanView();
        if (scanView != null) {
            scanView.setExtraction(false);
        }
        ImageView animationIcon = this.this$0.getAnimationIcon();
        if (animationIcon != null) {
            animationIcon.setVisibility(0);
            animationIcon.setAlpha(0.0f);
            animationIcon.setScaleX(1.0f);
            animationIcon.setScaleY(1.0f);
            animationIcon.setImageResource(R.drawable.jumio_ic_card_front);
        }
        IDScanFragment iDScanFragment = this.this$0;
        BaseFragment.fadeAndScaleTo$default(iDScanFragment, iDScanFragment.getAnimationScrim(), 4, 0, 0, 6, (Object) null);
        this.this$0.setProgressTextWithId(R.string.jumio_id_scan_prompt_flip_to_back);
        ImageView animationIcon2 = this.this$0.getAnimationIcon();
        if (animationIcon2 != null) {
            animationIcon2.setRotation(0.0f);
            animationIcon2.setRotationY(0.0f);
        }
        CircularProgressIndicator processingIndicator = this.this$0.getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setAlpha(0.0f);
        }
        Log.v("IDScanFragment", "Flip card doOnStart");
    }
}
