package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import i6.d;

public class MyNestedScrollView extends NestedScrollView {

    /* renamed from: b  reason: collision with root package name */
    public int f71536b = 0;

    /* renamed from: c  reason: collision with root package name */
    public float f71537c;

    /* renamed from: d  reason: collision with root package name */
    public float f71538d;

    /* renamed from: e  reason: collision with root package name */
    public float f71539e;

    /* renamed from: f  reason: collision with root package name */
    public float f71540f;

    /* renamed from: g  reason: collision with root package name */
    public b f71541g;

    /* renamed from: h  reason: collision with root package name */
    public a f71542h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71543i = true;

    public interface a {
        void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14);
    }

    public interface b {
        void onStartNestedScroll();

        void onStateChanged(int i11);

        void onStopNestedScroll();
    }

    public MyNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final void dispatchScrollState(int i11) {
        b bVar = this.f71541g;
        if (bVar != null && this.f71536b != i11) {
            bVar.onStateChanged(i11);
            d.b("----Unsmooth----");
            this.f71536b = i11;
        }
    }

    public final void init(Context context) {
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f71543i) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f71538d = 0.0f;
            this.f71537c = 0.0f;
            this.f71539e = motionEvent.getX();
            this.f71540f = motionEvent.getY();
            computeScroll();
        } else if (action == 2) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f71537c += Math.abs(x11 - this.f71539e);
            float abs = this.f71538d + Math.abs(y11 - this.f71540f);
            this.f71538d = abs;
            this.f71539e = x11;
            this.f71540f = y11;
            if (this.f71537c > abs) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        a aVar = this.f71542h;
        if (aVar != null) {
            aVar.onScrollChange(this, i11, i12, i13, i14);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        dispatchScrollState(1);
        return super.onStartNestedScroll(view, view2, i11);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f71543i && super.onTouchEvent(motionEvent);
    }

    public void setOnScrollChangedListener(a aVar) {
        this.f71542h = aVar;
    }

    public void setScrollStateListener(b bVar) {
        this.f71541g = bVar;
    }

    public void setScrollingEnabled(boolean z11) {
        this.f71543i = z11;
    }

    public boolean startNestedScroll(int i11, int i12) {
        b bVar = this.f71541g;
        if (bVar != null) {
            bVar.onStartNestedScroll();
        }
        return super.startNestedScroll(i11, i12);
    }

    public void stopNestedScroll() {
        super.stopNestedScroll();
        dispatchScrollState(0);
        b bVar = this.f71541g;
        if (bVar != null) {
            bVar.onStopNestedScroll();
        }
    }

    public boolean startNestedScroll(int i11) {
        boolean startNestedScroll = super.startNestedScroll(i11);
        dispatchScrollState(1);
        return startNestedScroll;
    }

    public MyNestedScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
