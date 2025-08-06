package com.hbg.lib.imsdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;

public class UpSlideView extends ConstraintLayout {

    /* renamed from: b  reason: collision with root package name */
    public GestureDetector f69191b;

    /* renamed from: c  reason: collision with root package name */
    public b f69192c;

    /* renamed from: d  reason: collision with root package name */
    public int f69193d;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            if (f12 > ((float) UpSlideView.this.f69193d) && Math.abs(f12) > Math.abs(f11) && UpSlideView.this.f69192c != null) {
                UpSlideView.this.f69192c.a();
            }
            return super.onScroll(motionEvent, motionEvent2, f11, f12);
        }
    }

    public interface b {
        void a();
    }

    public UpSlideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f69191b.onTouchEvent(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }

    public void setGestureCallback(b bVar) {
        this.f69192c = bVar;
    }

    public UpSlideView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f69193d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f69191b = new GestureDetector(context, new a());
    }
}
