package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public final void internalSetVisibility(int i11, boolean z11) {
        super.setVisibility(i11);
        if (z11) {
            this.userSetVisibility = i11;
        }
    }

    public void setVisibility(int i11) {
        internalSetVisibility(i11, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.userSetVisibility = getVisibility();
    }
}
