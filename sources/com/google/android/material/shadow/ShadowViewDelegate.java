package com.google.android.material.shadow;

import android.graphics.drawable.Drawable;

public interface ShadowViewDelegate {
    float getRadius();

    boolean isCompatPaddingEnabled();

    void setBackgroundDrawable(Drawable drawable);

    void setShadowPadding(int i11, int i12, int i13, int i14);
}
