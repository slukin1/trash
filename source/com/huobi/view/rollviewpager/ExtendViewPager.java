package com.huobi.view.rollviewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

public class ExtendViewPager extends ViewPager {
    private boolean isCanScroll = true;
    private boolean mIsBeingDragged = true;
    private float xDistance;
    private float xLast;
    private float yDistance;
    private float yLast;

    public ExtendViewPager(Context context) {
        super(context);
        fixTouchSlop();
    }

    private void fixTouchSlop() {
        Field field;
        try {
            field = ViewPager.class.getDeclaredField("mMinimumVelocity");
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            field.setInt(this, 10);
        } catch (IllegalAccessException e12) {
            e12.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 != 3) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            android.view.ViewParent r0 = r9.getParent()
            r1 = 1
            r0.requestDisallowInterceptTouchEvent(r1)
            int r0 = r10.getAction()
            if (r0 == 0) goto L_0x0064
            r2 = 0
            if (r0 == r1) goto L_0x0061
            r3 = 2
            if (r0 == r3) goto L_0x0018
            r1 = 3
            if (r0 == r1) goto L_0x0061
            goto L_0x0075
        L_0x0018:
            float r0 = r10.getX()
            float r3 = r10.getY()
            float r4 = r9.xDistance
            float r5 = r9.xLast
            float r5 = r0 - r5
            float r5 = java.lang.Math.abs(r5)
            float r4 = r4 + r5
            r9.xDistance = r4
            float r4 = r9.yDistance
            float r5 = r9.yLast
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            float r4 = r4 + r5
            r9.yDistance = r4
            r9.xLast = r0
            r9.yLast = r3
            boolean r0 = r9.mIsBeingDragged
            if (r0 != 0) goto L_0x0075
            double r3 = (double) r4
            float r0 = r9.xDistance
            double r5 = (double) r0
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r5 = r5 * r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0057
            r9.mIsBeingDragged = r1
            android.view.ViewParent r0 = r9.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L_0x0075
        L_0x0057:
            r9.mIsBeingDragged = r2
            android.view.ViewParent r0 = r9.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L_0x0075
        L_0x0061:
            r9.mIsBeingDragged = r2
            goto L_0x0075
        L_0x0064:
            r0 = 0
            r9.yDistance = r0
            r9.xDistance = r0
            float r0 = r10.getX()
            r9.xLast = r0
            float r0 = r10.getY()
            r9.yLast = r0
        L_0x0075:
            boolean r10 = super.dispatchTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.rollviewpager.ExtendViewPager.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void scrollTo(int i11, int i12) {
        if (this.isCanScroll) {
            super.scrollTo(i11, i12);
        }
    }

    public void setScanScroll(boolean z11) {
        this.isCanScroll = z11;
    }

    public ExtendViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        fixTouchSlop();
    }
}
