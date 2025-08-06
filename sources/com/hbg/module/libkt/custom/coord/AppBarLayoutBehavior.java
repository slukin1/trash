package com.hbg.module.libkt.custom.coord;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

public final class AppBarLayoutBehavior extends AppBarLayout.Behavior {

    /* renamed from: a  reason: collision with root package name */
    public final int f24771a = 1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24772b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24773c;

    public AppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final Field b() throws NoSuchFieldException {
        Class<? super Object> cls;
        Class<? super AppBarLayoutBehavior> superclass = AppBarLayoutBehavior.class.getSuperclass();
        if (superclass != null) {
            try {
                cls = superclass.getSuperclass();
            } catch (NoSuchFieldException unused) {
                Class<? super Object> superclass2 = superclass.getSuperclass();
                Class<? super Object> superclass3 = superclass2 != null ? superclass2.getSuperclass() : null;
                if (superclass3 != null) {
                    return superclass3.getDeclaredField("flingRunnable");
                }
                return null;
            }
        } else {
            cls = null;
        }
        if (cls != null) {
            return cls.getDeclaredField("mFlingRunnable");
        }
        return null;
    }

    /* renamed from: c */
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int i13, int i14, int i15) {
        if (!this.f24773c) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i11, i12, i13, i14, i15);
        }
    }

    public final void d(AppBarLayout appBarLayout) {
        try {
            Field b11 = b();
            Field scrollerField = getScrollerField();
            if (b11 != null) {
                b11.setAccessible(true);
            }
            if (scrollerField != null) {
                scrollerField.setAccessible(true);
            }
            Runnable runnable = b11 != null ? (Runnable) b11.get(this) : null;
            OverScroller overScroller = (OverScroller) (scrollerField != null ? scrollerField.get(this) : null);
            if (runnable != null) {
                appBarLayout.removeCallbacks(runnable);
                b11.set(this, (Object) null);
            }
            if (overScroller != null && !overScroller.isFinished()) {
                overScroller.abortAnimation();
            }
        } catch (NoSuchFieldException unused) {
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r0 = r0.getSuperclass();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.reflect.Field getScrollerField() throws java.lang.NoSuchFieldException {
        /*
            r4 = this;
            java.lang.Class<com.hbg.module.libkt.custom.coord.AppBarLayoutBehavior> r0 = com.hbg.module.libkt.custom.coord.AppBarLayoutBehavior.class
            java.lang.Class r0 = r0.getSuperclass()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.Class r2 = r0.getSuperclass()     // Catch:{ NoSuchFieldException -> 0x0018 }
            goto L_0x000f
        L_0x000e:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x002e
            java.lang.String r3 = "mScroller"
            java.lang.reflect.Field r1 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0018 }
            goto L_0x002e
        L_0x0018:
            if (r0 == 0) goto L_0x0025
            java.lang.Class r0 = r0.getSuperclass()
            if (r0 == 0) goto L_0x0025
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            if (r0 == 0) goto L_0x002e
            java.lang.String r1 = "scroller"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.custom.coord.AppBarLayoutBehavior.getScrollerField():java.lang.reflect.Field");
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        this.f24773c = this.f24772b;
        if (motionEvent.getActionMasked() == 0) {
            d(appBarLayout);
        }
        return super.onInterceptTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == this.f24771a) {
            this.f24772b = true;
        }
        if (!this.f24773c) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i11, i12, iArr, i13);
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i11, int i12) {
        d(appBarLayout);
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i11, i12);
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11) {
        super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i11);
        this.f24772b = false;
        this.f24773c = false;
    }
}
