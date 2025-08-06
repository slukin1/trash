package com.yalantis.ucrop;

import com.yalantis.ucrop.UCropFragment;

public interface UCropFragmentCallback {
    void loadingProgress(boolean z11);

    void onCropFinish(UCropFragment.UCropResult uCropResult);
}
