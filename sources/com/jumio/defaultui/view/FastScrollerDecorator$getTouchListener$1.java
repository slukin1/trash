package com.jumio.defaultui.view;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public final class FastScrollerDecorator$getTouchListener$1 implements RecyclerView.k {
    public final /* synthetic */ FastScrollerDecorator this$0;

    public FastScrollerDecorator$getTouchListener$1(FastScrollerDecorator fastScrollerDecorator) {
        this.this$0 = fastScrollerDecorator;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        return this.this$0.handleTap(motionEvent);
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z11) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
