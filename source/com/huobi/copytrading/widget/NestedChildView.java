package com.huobi.copytrading.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.p;
import androidx.core.view.q;

public class NestedChildView extends LinearLayout implements p {

    /* renamed from: b  reason: collision with root package name */
    public q f43724b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f43725c = new int[2];

    /* renamed from: d  reason: collision with root package name */
    public final int[] f43726d = new int[2];

    /* renamed from: e  reason: collision with root package name */
    public int f43727e;

    /* renamed from: f  reason: collision with root package name */
    public int f43728f;

    public NestedChildView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private q getScrollingChildHelper() {
        if (this.f43724b == null) {
            q qVar = new q(this);
            this.f43724b = qVar;
            qVar.n(true);
        }
        return this.f43724b;
    }

    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return getScrollingChildHelper().a(f11, f12, z11);
    }

    public boolean dispatchNestedPreFling(float f11, float f12) {
        return getScrollingChildHelper().b(f11, f12);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i11, i12, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return getScrollingChildHelper().f(i11, i12, i13, i14, iArr);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f43728f = getMeasuredHeight();
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f43727e = (int) motionEvent.getRawY();
        } else if (action == 2) {
            int rawY = (int) motionEvent.getRawY();
            int i11 = rawY - this.f43727e;
            this.f43727e = rawY;
            if (!startNestedScroll(2) || !dispatchNestedPreScroll(0, i11, this.f43726d, this.f43725c)) {
                scrollBy(0, -i11);
            } else {
                int i12 = i11 - this.f43726d[1];
                if (i12 != 0) {
                    scrollBy(0, -i12);
                }
            }
        }
        return true;
    }

    public void scrollTo(int i11, int i12) {
        int measuredHeight = getMeasuredHeight() - this.f43728f;
        if (i12 > measuredHeight) {
            i12 = measuredHeight;
        }
        if (i12 < 0) {
            i12 = 0;
        }
        super.scrollTo(i11, i12);
    }

    public void setNestedScrollingEnabled(boolean z11) {
        getScrollingChildHelper().n(z11);
    }

    public boolean startNestedScroll(int i11) {
        return getScrollingChildHelper().p(i11);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }
}
