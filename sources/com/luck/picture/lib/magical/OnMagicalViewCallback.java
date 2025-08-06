package com.luck.picture.lib.magical;

public interface OnMagicalViewCallback {
    void onBackgroundAlpha(float f11);

    void onBeginBackMinAnim();

    void onBeginBackMinMagicalFinish(boolean z11);

    void onBeginMagicalAnimComplete(MagicalView magicalView, boolean z11);

    void onMagicalViewFinish();
}
