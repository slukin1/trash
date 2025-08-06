package com.tencent.qcloud.tuikit.tuicallkit.view.common;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SlideRecyclerView extends RecyclerView {
    private static final int INVALID_CHILD_WIDTH = -1;
    private static final int INVALID_POSITION = -1;
    private static final int SNAP_VELOCITY = 600;
    private static final String TAG = "SlideRecyclerView";
    private boolean mDisableRecyclerViewSlide;
    private float mFirstX;
    private float mFirstY;
    private ViewGroup mFlingView;
    private boolean mIsSlide;
    private float mLastX;
    private int mMenuViewWidth;
    private int mPosition;
    private Scroller mScroller;
    private Rect mTouchFrame;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public SlideRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void obtainVelocity(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void releaseVelocity() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void closeMenu() {
        ViewGroup viewGroup = this.mFlingView;
        if (viewGroup != null && viewGroup.getScrollX() != 0) {
            this.mFlingView.scrollTo(0, 0);
        }
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mDisableRecyclerViewSlide) {
                this.mFlingView.scrollTo(0, 0);
            } else {
                this.mFlingView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            }
            invalidate();
        }
    }

    public void disableRecyclerViewSlide(boolean z11) {
        this.mDisableRecyclerViewSlide = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0078, code lost:
        if (java.lang.Math.abs(r0 - r8.mFirstX) > java.lang.Math.abs(((float) r1) - r8.mFirstY)) goto L_0x007a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            float r0 = r9.getX()
            int r0 = (int) r0
            float r1 = r9.getY()
            int r1 = (int) r1
            r8.obtainVelocity(r9)
            int r2 = r9.getAction()
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0081
            if (r2 == r5) goto L_0x007d
            if (r2 == r3) goto L_0x001c
            goto L_0x00d8
        L_0x001c:
            android.view.VelocityTracker r2 = r8.mVelocityTracker
            r3 = 1000(0x3e8, float:1.401E-42)
            r2.computeCurrentVelocity(r3)
            android.view.VelocityTracker r2 = r8.mVelocityTracker
            float r2 = r2.getXVelocity()
            android.view.VelocityTracker r3 = r8.mVelocityTracker
            float r3 = r3.getYVelocity()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = r8.getLayoutManager()
            androidx.recyclerview.widget.LinearLayoutManager r6 = (androidx.recyclerview.widget.LinearLayoutManager) r6
            android.view.View r6 = r6.findViewByPosition(r4)
            android.view.ViewGroup r7 = r8.mFlingView
            if (r6 != r7) goto L_0x0041
            r8.mIsSlide = r4
            goto L_0x00d8
        L_0x0041:
            float r4 = java.lang.Math.abs(r2)
            r6 = 1142292480(0x44160000, float:600.0)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0057
            float r2 = java.lang.Math.abs(r2)
            float r3 = java.lang.Math.abs(r3)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x007a
        L_0x0057:
            float r0 = (float) r0
            float r2 = r8.mFirstX
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r3 = r8.mTouchSlop
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x00d8
            float r2 = r8.mFirstX
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r1 = (float) r1
            float r2 = r8.mFirstY
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d8
        L_0x007a:
            r8.mIsSlide = r5
            return r5
        L_0x007d:
            r8.releaseVelocity()
            goto L_0x00d8
        L_0x0081:
            android.widget.Scroller r2 = r8.mScroller
            boolean r2 = r2.isFinished()
            if (r2 != 0) goto L_0x008e
            android.widget.Scroller r2 = r8.mScroller
            r2.abortAnimation()
        L_0x008e:
            float r2 = (float) r0
            r8.mLastX = r2
            r8.mFirstX = r2
            float r2 = (float) r1
            r8.mFirstY = r2
            int r0 = r8.pointToPosition(r0, r1)
            r8.mPosition = r0
            r1 = -1
            if (r0 == r1) goto L_0x00d8
            android.view.ViewGroup r2 = r8.mFlingView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = r8.getLayoutManager()
            androidx.recyclerview.widget.LinearLayoutManager r6 = (androidx.recyclerview.widget.LinearLayoutManager) r6
            int r6 = r6.findFirstVisibleItemPosition()
            int r0 = r0 - r6
            android.view.View r0 = r8.getChildAt(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r8.mFlingView = r0
            if (r2 == 0) goto L_0x00c1
            if (r0 == r2) goto L_0x00c1
            int r0 = r2.getScrollX()
            if (r0 == 0) goto L_0x00c1
            r2.scrollTo(r4, r4)
        L_0x00c1:
            android.view.ViewGroup r0 = r8.mFlingView
            int r0 = r0.getChildCount()
            if (r0 != r3) goto L_0x00d6
            android.view.ViewGroup r0 = r8.mFlingView
            android.view.View r0 = r0.getChildAt(r5)
            int r0 = r0.getWidth()
            r8.mMenuViewWidth = r0
            goto L_0x00d8
        L_0x00d6:
            r8.mMenuViewWidth = r1
        L_0x00d8:
            boolean r9 = super.onInterceptTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuicallkit.view.common.SlideRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsSlide || this.mPosition == -1) {
            closeMenu();
            releaseVelocity();
            return super.onTouchEvent(motionEvent);
        }
        float x11 = motionEvent.getX();
        obtainVelocity(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            releaseVelocity();
        } else if (action == 2 && this.mMenuViewWidth != -1) {
            float f11 = this.mLastX - x11;
            if (((float) this.mFlingView.getScrollX()) + f11 <= ((float) this.mMenuViewWidth) && ((float) this.mFlingView.getScrollX()) + f11 > 0.0f) {
                if (this.mMenuViewWidth != -1) {
                    int scrollX = this.mFlingView.getScrollX();
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    if (this.mVelocityTracker.getXVelocity() < -600.0f) {
                        Scroller scroller = this.mScroller;
                        int i11 = this.mMenuViewWidth;
                        scroller.startScroll(scrollX, 0, i11 - scrollX, 0, Math.abs(i11 - scrollX));
                    } else if (this.mVelocityTracker.getXVelocity() >= 600.0f) {
                        this.mScroller.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                    } else {
                        int i12 = this.mMenuViewWidth;
                        if (scrollX >= i12 / 2) {
                            this.mScroller.startScroll(scrollX, 0, i12 - scrollX, 0, Math.abs(i12 - scrollX));
                        } else {
                            this.mScroller.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                        }
                    }
                    invalidate();
                }
                this.mMenuViewWidth = -1;
                this.mIsSlide = false;
                this.mPosition = -1;
            }
            this.mLastX = x11;
        }
        return true;
    }

    public int pointToPosition(int i11, int i12) {
        int findFirstVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i11, i12)) {
                    return findFirstVisibleItemPosition + childCount;
                }
            }
        }
        return -1;
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mScroller = new Scroller(context);
    }
}
