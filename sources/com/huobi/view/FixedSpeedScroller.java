package com.huobi.view;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class FixedSpeedScroller extends Scroller {
    private static final int DUR_SCORLL = 1500;
    private int mDuration = 1500;

    public FixedSpeedScroller(Context context) {
        super(context);
    }

    public int getScrollDuration() {
        return this.mDuration;
    }

    public void setScrollDuration(int i11) {
        this.mDuration = i11;
    }

    public void startScroll(int i11, int i12, int i13, int i14, int i15) {
        super.startScroll(i11, i12, i13, i14, this.mDuration);
    }

    public void startScroll(int i11, int i12, int i13, int i14) {
        super.startScroll(i11, i12, i13, i14, this.mDuration);
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }
}
