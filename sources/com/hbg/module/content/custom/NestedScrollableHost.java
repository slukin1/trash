package com.hbg.module.content.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;

public final class NestedScrollableHost extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f18077b = ViewConfiguration.get(getContext()).getScaledTouchSlop();

    /* renamed from: c  reason: collision with root package name */
    public float f18078c;

    /* renamed from: d  reason: collision with root package name */
    public float f18079d;

    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[EDGE_INSN: B:13:0x001e->B:10:0x001e ?: BREAK  
    EDGE_INSN: B:15:0x001e->B:10:0x001e ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.viewpager2.widget.ViewPager2 getParentViewPager() {
        /*
            r3 = this;
            android.view.ViewParent r0 = r3.getParent()
            boolean r1 = r0 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto L_0x000c
            android.view.View r0 = (android.view.View) r0
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 == 0) goto L_0x001e
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 != 0) goto L_0x001e
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x000c
            android.view.View r0 = (android.view.View) r0
            goto L_0x000d
        L_0x001e:
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L_0x0025
            r2 = r0
            androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
        L_0x0025:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.custom.NestedScrollableHost.getParentViewPager():androidx.viewpager2.widget.ViewPager2");
    }

    public final boolean a(int i11, float f11) {
        int i12 = -((int) Math.signum(f11));
        if (i11 == 0) {
            View child = getChild();
            if (child != null) {
                return child.canScrollHorizontally(i12);
            }
            return false;
        } else if (i11 == 1) {
            View child2 = getChild();
            if (child2 != null) {
                return child2.canScrollVertically(i12);
            }
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void b(MotionEvent motionEvent) {
        ViewPager2 parentViewPager = getParentViewPager();
        if (parentViewPager != null) {
            int orientation = parentViewPager.getOrientation();
            float f11 = 1.0f;
            if (!a(orientation, -1.0f) && !a(orientation, 1.0f)) {
                return;
            }
            if (motionEvent.getAction() == 0) {
                this.f18078c = motionEvent.getX();
                this.f18079d = motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (motionEvent.getAction() == 2) {
                float x11 = motionEvent.getX() - this.f18078c;
                float y11 = motionEvent.getY() - this.f18079d;
                boolean z11 = orientation == 0;
                float abs = Math.abs(x11) * (z11 ? 0.5f : 1.0f);
                float abs2 = Math.abs(y11);
                if (!z11) {
                    f11 = 0.5f;
                }
                float f12 = abs2 * f11;
                int i11 = this.f18077b;
                if (abs > ((float) i11) || f12 > ((float) i11)) {
                    if (z11 == (f12 > abs)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return;
                    }
                    if (!z11) {
                        x11 = y11;
                    }
                    if (a(orientation, x11)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
