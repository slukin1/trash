package com.hbg.module.livesquare.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerView extends RecyclerView {

    /* renamed from: b  reason: collision with root package name */
    public int f26472b;

    /* renamed from: c  reason: collision with root package name */
    public int f26473c;

    /* renamed from: d  reason: collision with root package name */
    public int f26474d;

    public CustomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        this.f26472b = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f26473c = (int) motionEvent.getX();
            this.f26474d = (int) motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            int x11 = (int) motionEvent.getX();
            if (Math.abs(((int) motionEvent.getY()) - this.f26474d) <= this.f26472b || Math.abs(x11 - this.f26473c) >= this.f26472b * 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
