package com.hbg.module.kline.view;

import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;

public class ViewHeightWrapper implements Serializable {
    private final View mTarget;

    public ViewHeightWrapper(View view) {
        this.mTarget = view;
    }

    public int getHeight() {
        return this.mTarget.getLayoutParams().height;
    }

    public int getWidth() {
        return this.mTarget.getLayoutParams().width;
    }

    public void setHeight(int i11) {
        ViewGroup.LayoutParams layoutParams = this.mTarget.getLayoutParams();
        layoutParams.height = i11;
        this.mTarget.setLayoutParams(layoutParams);
    }

    public void setWidth(int i11) {
        this.mTarget.getLayoutParams().width = i11;
        this.mTarget.requestLayout();
    }
}
