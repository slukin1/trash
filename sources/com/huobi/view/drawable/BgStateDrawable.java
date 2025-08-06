package com.huobi.view.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class BgStateDrawable extends StateListDrawable {
    public BgStateDrawable() {
    }

    public void addDisableDrawable(Drawable drawable) {
        addState(new int[]{-16842910}, drawable);
    }

    public void addFocuceDrawable(Drawable drawable) {
        addState(new int[]{16842908}, drawable);
    }

    public void addNormalDrawable(Drawable drawable) {
        addState(new int[0], drawable);
    }

    public void addPressDrawable(Drawable drawable) {
        addState(new int[]{16842919}, drawable);
    }

    public BgStateDrawable(Drawable drawable, Drawable drawable2) {
        addNormalDrawable(drawable);
        addPressDrawable(drawable2);
    }
}
