package com.wtree.scrolltable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public class MyExpandRecycleView extends RecyclerView {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f51244b;

    public MyExpandRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final MotionEvent a(MotionEvent motionEvent) {
        motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getY());
        return motionEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView = this.f51244b;
        if (recyclerView != null) {
            recyclerView.dispatchTouchEvent(a(motionEvent));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        RecyclerView recyclerView = this.f51244b;
        if (recyclerView != null) {
            recyclerView.onInterceptTouchEvent(a(motionEvent));
        }
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView = this.f51244b;
        if (recyclerView != null) {
            recyclerView.onTouchEvent(a(motionEvent));
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setView(RecyclerView recyclerView) {
        this.f51244b = recyclerView;
    }
}
