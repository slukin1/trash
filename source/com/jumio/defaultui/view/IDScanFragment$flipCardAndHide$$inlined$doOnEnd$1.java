package com.jumio.defaultui.view;

import android.animation.Animator;
import com.jumio.commons.log.Log;
import com.jumio.core.views.CameraScanView;

public final class IDScanFragment$flipCardAndHide$$inlined$doOnEnd$1 implements Animator.AnimatorListener {
    public final /* synthetic */ IDScanFragment this$0;

    public IDScanFragment$flipCardAndHide$$inlined$doOnEnd$1(IDScanFragment iDScanFragment) {
        this.this$0 = iDScanFragment;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.updateScanTitleTextAndBackground();
        IDScanFragment iDScanFragment = this.this$0;
        iDScanFragment.setProgressText(iDScanFragment.getScanModePromptStringResource());
        ScanFragment.showScanUiElementsIfRequired$default(this.this$0, 0, 1, (Object) null);
        Log.v("IDScanFragment", "Flip card doOnEnd");
        CameraScanView scanView = this.this$0.getScanView();
        if (scanView != null) {
            scanView.setExtraction(true);
        }
        this.this$0.getJumioViewModel$jumio_defaultui_release().f56365m.setValue(Boolean.TRUE);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
