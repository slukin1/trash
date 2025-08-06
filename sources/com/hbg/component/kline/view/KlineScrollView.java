package com.hbg.component.kline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class KlineScrollView extends ScrollView {

    /* renamed from: b  reason: collision with root package name */
    public boolean f67403b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67404c = false;

    public KlineScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f67403b) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setScrollDisable(boolean z11) {
        this.f67403b = z11;
    }

    public KlineScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
