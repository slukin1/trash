package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate {
    public Context context;
    public CheckableImageButton endIconView;
    public TextInputLayout textInputLayout;

    public EndIconDelegate(TextInputLayout textInputLayout2) {
        this.textInputLayout = textInputLayout2;
        this.context = textInputLayout2.getContext();
        this.endIconView = textInputLayout2.getEndIconView();
    }

    public abstract void initialize();

    public boolean isBoxBackgroundModeSupported(int i11) {
        return true;
    }

    public void onSuffixVisibilityChanged(boolean z11) {
    }

    public boolean shouldTintIconOnError() {
        return false;
    }
}
