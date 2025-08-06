package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

public class OtcConstraintLayout extends ConstraintLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f79964b;

    public interface a {
        void a(float f11, float f12);
    }

    public OtcConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() == 0 && (aVar = this.f79964b) != null) {
            aVar.a(motionEvent.getRawX(), motionEvent.getRawY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnTouchDownCallBack(a aVar) {
        this.f79964b = aVar;
    }
}
