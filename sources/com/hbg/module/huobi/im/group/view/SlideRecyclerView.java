package com.hbg.module.huobi.im.group.view;

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

    /* renamed from: b  reason: collision with root package name */
    public VelocityTracker f20502b;

    /* renamed from: c  reason: collision with root package name */
    public int f20503c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f20504d;

    /* renamed from: e  reason: collision with root package name */
    public Scroller f20505e;

    /* renamed from: f  reason: collision with root package name */
    public float f20506f;

    /* renamed from: g  reason: collision with root package name */
    public float f20507g;

    /* renamed from: h  reason: collision with root package name */
    public float f20508h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20509i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f20510j;

    /* renamed from: k  reason: collision with root package name */
    public int f20511k;

    /* renamed from: l  reason: collision with root package name */
    public int f20512l;

    public SlideRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void closeMenu() {
        ViewGroup viewGroup = this.f20510j;
        if (viewGroup != null && viewGroup.getScrollX() != 0) {
            this.f20510j.scrollTo(0, 0);
        }
    }

    public void computeScroll() {
        if (this.f20505e.computeScrollOffset()) {
            this.f20510j.scrollTo(this.f20505e.getCurrX(), this.f20505e.getCurrY());
            invalidate();
        }
    }

    public final void obtainVelocity(MotionEvent motionEvent) {
        if (this.f20502b == null) {
            this.f20502b = VelocityTracker.obtain();
        }
        this.f20502b.addMovement(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (java.lang.Math.abs(r0 - r7.f20507g) > java.lang.Math.abs(((float) r1) - r7.f20508h)) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            r7.obtainVelocity(r8)
            int r2 = r8.getAction()
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x006e
            if (r2 == r4) goto L_0x006a
            if (r2 == r3) goto L_0x001b
            goto L_0x00c6
        L_0x001b:
            android.view.VelocityTracker r2 = r7.f20502b
            r3 = 1000(0x3e8, float:1.401E-42)
            r2.computeCurrentVelocity(r3)
            android.view.VelocityTracker r2 = r7.f20502b
            float r2 = r2.getXVelocity()
            android.view.VelocityTracker r3 = r7.f20502b
            float r3 = r3.getYVelocity()
            float r5 = java.lang.Math.abs(r2)
            r6 = 1142292480(0x44160000, float:600.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0044
            float r2 = java.lang.Math.abs(r2)
            float r3 = java.lang.Math.abs(r3)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0067
        L_0x0044:
            float r0 = (float) r0
            float r2 = r7.f20507g
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r3 = r7.f20503c
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x00c6
            float r2 = r7.f20507g
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r1 = (float) r1
            float r2 = r7.f20508h
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c6
        L_0x0067:
            r7.f20509i = r4
            return r4
        L_0x006a:
            r7.releaseVelocity()
            goto L_0x00c6
        L_0x006e:
            android.widget.Scroller r2 = r7.f20505e
            boolean r2 = r2.isFinished()
            if (r2 != 0) goto L_0x007b
            android.widget.Scroller r2 = r7.f20505e
            r2.abortAnimation()
        L_0x007b:
            float r2 = (float) r0
            r7.f20506f = r2
            r7.f20507g = r2
            float r2 = (float) r1
            r7.f20508h = r2
            int r0 = r7.pointToPosition(r0, r1)
            r7.f20511k = r0
            r1 = -1
            if (r0 == r1) goto L_0x00c6
            android.view.ViewGroup r2 = r7.f20510j
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = r7.getLayoutManager()
            androidx.recyclerview.widget.LinearLayoutManager r5 = (androidx.recyclerview.widget.LinearLayoutManager) r5
            int r5 = r5.findFirstVisibleItemPosition()
            int r0 = r0 - r5
            android.view.View r0 = r7.getChildAt(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r7.f20510j = r0
            if (r2 == 0) goto L_0x00af
            if (r0 == r2) goto L_0x00af
            int r0 = r2.getScrollX()
            if (r0 == 0) goto L_0x00af
            r0 = 0
            r2.scrollTo(r0, r0)
        L_0x00af:
            android.view.ViewGroup r0 = r7.f20510j
            int r0 = r0.getChildCount()
            if (r0 != r3) goto L_0x00c4
            android.view.ViewGroup r0 = r7.f20510j
            android.view.View r0 = r0.getChildAt(r4)
            int r0 = r0.getWidth()
            r7.f20512l = r0
            goto L_0x00c6
        L_0x00c4:
            r7.f20512l = r1
        L_0x00c6:
            boolean r8 = super.onInterceptTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.view.SlideRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f20509i || this.f20511k == -1) {
            closeMenu();
            releaseVelocity();
            return super.onTouchEvent(motionEvent);
        }
        float x11 = motionEvent.getX();
        obtainVelocity(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            if (this.f20512l != -1) {
                int scrollX = this.f20510j.getScrollX();
                this.f20502b.computeCurrentVelocity(1000);
                if (this.f20502b.getXVelocity() < -600.0f) {
                    Scroller scroller = this.f20505e;
                    int i11 = this.f20512l;
                    scroller.startScroll(scrollX, 0, i11 - scrollX, 0, Math.abs(i11 - scrollX));
                } else if (this.f20502b.getXVelocity() >= 600.0f) {
                    this.f20505e.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                } else {
                    int i12 = this.f20512l;
                    if (scrollX >= i12 / 2) {
                        this.f20505e.startScroll(scrollX, 0, i12 - scrollX, 0, Math.abs(i12 - scrollX));
                    } else {
                        this.f20505e.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                    }
                }
                invalidate();
            }
            this.f20512l = -1;
            this.f20509i = false;
            this.f20511k = -1;
            releaseVelocity();
        } else if (action == 2 && this.f20512l != -1) {
            float f11 = this.f20506f - x11;
            if (((float) this.f20510j.getScrollX()) + f11 <= ((float) this.f20512l) && ((float) this.f20510j.getScrollX()) + f11 > 0.0f) {
                this.f20510j.scrollBy((int) f11, 0);
            }
            this.f20506f = x11;
        }
        return true;
    }

    public int pointToPosition(int i11, int i12) {
        if (getLayoutManager() == null) {
            return -1;
        }
        int findFirstVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        Rect rect = this.f20504d;
        if (rect == null) {
            rect = new Rect();
            this.f20504d = rect;
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

    public final void releaseVelocity() {
        VelocityTracker velocityTracker = this.f20502b;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f20502b.recycle();
            this.f20502b = null;
        }
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f20503c = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f20505e = new Scroller(context);
    }
}
