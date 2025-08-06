package com.hbg.module.content.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.widget.NestedScrollView;

public class ConflictNestedScrollView extends NestedScrollView {

    /* renamed from: b  reason: collision with root package name */
    public boolean f17972b = true;

    /* renamed from: c  reason: collision with root package name */
    public float f17973c;

    /* renamed from: d  reason: collision with root package name */
    public float f17974d;

    /* renamed from: e  reason: collision with root package name */
    public float f17975e;

    /* renamed from: f  reason: collision with root package name */
    public float f17976f;

    /* renamed from: g  reason: collision with root package name */
    public int f17977g;

    public ConflictNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f17974d = 0.0f;
            this.f17973c = 0.0f;
            this.f17975e = motionEvent.getX();
            this.f17976f = motionEvent.getY();
        } else if (action == 2) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f17973c += Math.abs(x11 - this.f17975e);
            this.f17974d += Math.abs(y11 - this.f17976f);
            this.f17975e = x11;
            this.f17976f = y11;
            Log.e("SiberiaDante", "xDistance ：" + this.f17973c + "---yDistance:" + this.f17974d);
            float f11 = this.f17973c;
            float f12 = this.f17974d;
            return f11 < f12 && f12 >= ((float) this.f17977g) && this.f17972b;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Log.e("SiberiaDante", "MotionEvent ：" + motionEvent.toString());
        return this.f17972b && super.onTouchEvent(motionEvent);
    }

    public void setNeedScroll(boolean z11) {
        this.f17972b = z11;
    }

    public ConflictNestedScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f17977g = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
