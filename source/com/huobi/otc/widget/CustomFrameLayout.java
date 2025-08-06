package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class CustomFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f79737b;

    public interface a {
        void a();
    }

    public CustomFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() == 0 && (aVar = this.f79737b) != null) {
            aVar.a();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnTouchDownListener(a aVar) {
        this.f79737b = aVar;
    }
}
