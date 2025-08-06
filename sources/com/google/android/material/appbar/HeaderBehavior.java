package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.h0;
import x0.a;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId = -1;
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    public OverScroller scroller;
    private int touchSlop = -1;
    private VelocityTracker velocityTracker;

    public class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;

        public FlingRunnable(CoordinatorLayout coordinatorLayout, V v11) {
            this.parent = coordinatorLayout;
            this.layout = v11;
        }

        public void run() {
            OverScroller overScroller;
            if (this.layout != null && (overScroller = HeaderBehavior.this.scroller) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
                    h0.p0(this.layout, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
            }
        }
    }

    public HeaderBehavior() {
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    public boolean canDragView(V v11) {
        return false;
    }

    public final boolean fling(CoordinatorLayout coordinatorLayout, V v11, int i11, int i12, float f11) {
        V v12 = v11;
        Runnable runnable = this.flingRunnable;
        if (runnable != null) {
            v11.removeCallbacks(runnable);
            this.flingRunnable = null;
        }
        if (this.scroller == null) {
            this.scroller = new OverScroller(v11.getContext());
        }
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f11), 0, 0, i11, i12);
        if (this.scroller.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            FlingRunnable flingRunnable2 = new FlingRunnable(coordinatorLayout, v11);
            this.flingRunnable = flingRunnable2;
            h0.p0(v11, flingRunnable2);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        onFlingFinished(coordinatorLayout, v11);
        return false;
    }

    public int getMaxDragOffset(V v11) {
        return -v11.getHeight();
    }

    public int getScrollRangeForDragFling(V v11) {
        return v11.getHeight();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(CoordinatorLayout coordinatorLayout, V v11) {
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v11, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int i11 = this.activePointerId;
            if (i11 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i11)) == -1) {
                return false;
            }
            int y11 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y11 - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = y11;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x11 = (int) motionEvent.getX();
            int y12 = (int) motionEvent.getY();
            boolean z11 = canDragView(v11) && coordinatorLayout.isPointInChildBounds(v11, x11, y12);
            this.isBeingDragged = z11;
            if (z11) {
                this.lastMotionY = y12;
                this.activePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                OverScroller overScroller = this.scroller;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L_0x004e
            r4 = 2
            if (r0 == r4) goto L_0x002d
            r12 = 3
            if (r0 == r12) goto L_0x0072
            r12 = 6
            if (r0 == r12) goto L_0x0013
            goto L_0x004c
        L_0x0013:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L_0x001b
            r12 = r2
            goto L_0x001c
        L_0x001b:
            r12 = r3
        L_0x001c:
            int r13 = r14.getPointerId(r12)
            r11.activePointerId = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.lastMotionY = r12
            goto L_0x004c
        L_0x002d:
            int r0 = r11.activePointerId
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L_0x0036
            return r3
        L_0x0036:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.lastMotionY
            int r7 = r1 - r0
            r11.lastMotionY = r0
            int r8 = r11.getMaxDragOffset(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.scroll(r5, r6, r7, r8, r9)
        L_0x004c:
            r12 = r3
            goto L_0x0081
        L_0x004e:
            android.view.VelocityTracker r0 = r11.velocityTracker
            if (r0 == 0) goto L_0x0072
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.velocityTracker
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.velocityTracker
            int r4 = r11.activePointerId
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.getScrollRangeForDragFling(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.fling(r6, r7, r8, r9, r10)
            r12 = r2
            goto L_0x0073
        L_0x0072:
            r12 = r3
        L_0x0073:
            r11.isBeingDragged = r3
            r11.activePointerId = r1
            android.view.VelocityTracker r13 = r11.velocityTracker
            if (r13 == 0) goto L_0x0081
            r13.recycle()
            r13 = 0
            r11.velocityTracker = r13
        L_0x0081:
            android.view.VelocityTracker r13 = r11.velocityTracker
            if (r13 == 0) goto L_0x0088
            r13.addMovement(r14)
        L_0x0088:
            boolean r13 = r11.isBeingDragged
            if (r13 != 0) goto L_0x0090
            if (r12 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r2 = r3
        L_0x0090:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public final int scroll(CoordinatorLayout coordinatorLayout, V v11, int i11, int i12, int i13) {
        return setHeaderTopBottomOffset(coordinatorLayout, v11, getTopBottomOffsetForScrollingSibling() - i11, i12, i13);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v11, int i11) {
        return setHeaderTopBottomOffset(coordinatorLayout, v11, i11, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v11, int i11, int i12, int i13) {
        int c11;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i12 == 0 || topAndBottomOffset < i12 || topAndBottomOffset > i13 || topAndBottomOffset == (c11 = a.c(i11, i12, i13))) {
            return 0;
        }
        setTopAndBottomOffset(c11);
        return topAndBottomOffset - c11;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
