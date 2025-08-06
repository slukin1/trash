package com.scwang.smartrefresh.layout.util;

import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

public class ScrollBoundaryUtil {
    public static boolean a(View view, MotionEvent motionEvent) {
        if (!c(view) && e(view) && view.getVisibility() == 0) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return a(childAt, obtain);
                }
            }
        }
        return false;
    }

    public static boolean b(View view, MotionEvent motionEvent) {
        if (e(view) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || motionEvent == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(pointF.x, pointF.y);
                return b(childAt, obtain);
            }
        }
        return true;
    }

    public static boolean c(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(1);
        }
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0 || (absListView.getLastVisiblePosition() >= absListView.getChildCount() - 1 && absListView.getChildAt(absListView.getChildCount() - 1).getBottom() <= absListView.getPaddingBottom())) {
                return false;
            }
            return true;
        } else if (view.getScrollY() < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean d(View view, MotionEvent motionEvent) {
        if (c(view) && view.getVisibility() == 0) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return d(childAt, obtain);
                }
            }
        }
        return false;
    }

    public static boolean e(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(-1);
        }
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(0).getTop() >= absListView.getPaddingTop())) {
                return false;
            }
            return true;
        } else if (view.getScrollY() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean f(ViewGroup viewGroup, View view, float f11, float f12, PointF pointF) {
        if (view.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f11, f12};
        h(viewGroup, view, fArr);
        boolean g11 = g(view, fArr[0], fArr[1], 0.0f);
        if (g11 && pointF != null) {
            pointF.set(fArr[0] - f11, fArr[1] - f12);
        }
        return g11;
    }

    public static boolean g(View view, float f11, float f12, float f13) {
        float f14 = -f13;
        return f11 >= f14 && f12 >= f14 && f11 < ((float) view.getWidth()) + f13 && f12 < ((float) view.getHeight()) + f13;
    }

    public static void h(ViewGroup viewGroup, View view, float[] fArr) {
        fArr[0] = fArr[0] + ((float) (viewGroup.getScrollX() - view.getLeft()));
        fArr[1] = fArr[1] + ((float) (viewGroup.getScrollY() - view.getTop()));
    }
}
