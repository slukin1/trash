package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {

    /* renamed from: b  reason: collision with root package name */
    public boolean f79738b = true;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f79738b && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f79738b && super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z11) {
        this.f79738b = z11;
    }
}
