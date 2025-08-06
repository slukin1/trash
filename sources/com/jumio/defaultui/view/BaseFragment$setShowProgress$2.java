package com.jumio.defaultui.view;

import android.graphics.drawable.Drawable;
import com.google.android.material.button.MaterialButton;

public final class BaseFragment$setShowProgress$2 implements Drawable.Callback {
    public final /* synthetic */ MaterialButton $this_setShowProgress;

    public BaseFragment$setShowProgress$2(MaterialButton materialButton) {
        this.$this_setShowProgress = materialButton;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.$this_setShowProgress.invalidate();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }
}
