package com.huobi.view.wheelview.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.huobi.view.wheelview.WheelView;

public final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    private final WheelView wheelView;

    public LoopViewGestureListener(WheelView wheelView2) {
        this.wheelView = wheelView2;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        this.wheelView.scrollBy(f12);
        return true;
    }
}
