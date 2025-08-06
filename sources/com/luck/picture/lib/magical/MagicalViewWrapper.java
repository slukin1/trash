package com.luck.picture.lib.magical;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MagicalViewWrapper {
    private final ViewGroup.MarginLayoutParams params;
    private final View viewWrapper;

    public MagicalViewWrapper(View view) {
        this.viewWrapper = view;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.params = marginLayoutParams;
        if (marginLayoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) marginLayoutParams).gravity = 8388611;
        }
    }

    public int getHeight() {
        return this.params.height;
    }

    public int getMarginBottom() {
        return this.params.bottomMargin;
    }

    public int getMarginLeft() {
        return this.params.leftMargin;
    }

    public int getMarginRight() {
        return this.params.rightMargin;
    }

    public int getMarginTop() {
        return this.params.topMargin;
    }

    public int getWidth() {
        return this.params.width;
    }

    public void setHeight(float f11) {
        this.params.height = Math.round(f11);
        this.viewWrapper.setLayoutParams(this.params);
    }

    public void setMarginBottom(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = this.params;
        marginLayoutParams.bottomMargin = i11;
        this.viewWrapper.setLayoutParams(marginLayoutParams);
    }

    public void setMarginLeft(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = this.params;
        marginLayoutParams.leftMargin = i11;
        this.viewWrapper.setLayoutParams(marginLayoutParams);
    }

    public void setMarginRight(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = this.params;
        marginLayoutParams.rightMargin = i11;
        this.viewWrapper.setLayoutParams(marginLayoutParams);
    }

    public void setMarginTop(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = this.params;
        marginLayoutParams.topMargin = i11;
        this.viewWrapper.setLayoutParams(marginLayoutParams);
    }

    public void setWidth(float f11) {
        this.params.width = Math.round(f11);
        this.viewWrapper.setLayoutParams(this.params);
    }
}
