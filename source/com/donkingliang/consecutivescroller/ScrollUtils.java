package com.donkingliang.consecutivescroller;

import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.a0;
import androidx.core.view.h0;
import androidx.recyclerview.widget.RecyclerView;
import com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import n4.a;

public class ScrollUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Method f64936a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f64937b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f64938c;

    /* renamed from: d  reason: collision with root package name */
    public static final Rect f64939d = new Rect();

    public static void a(List<View> list, View view, int i11, int i12) {
        if (q(view) && t(view, i11, i12)) {
            list.add(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i13 = 0; i13 < childCount; i13++) {
                    a(list, viewGroup.getChildAt(i13), i11, i12);
                }
            }
        }
    }

    public static boolean b(View view) {
        return q(view) && (c(view, 1) || c(view, -1));
    }

    public static boolean c(View view, int i11) {
        View m11 = m(view);
        if (m11.getVisibility() == 8) {
            return false;
        }
        if (m11 instanceof AbsListView) {
            AbsListView absListView = (AbsListView) m11;
            if (Build.VERSION.SDK_INT >= 19) {
                return absListView.canScrollList(i11);
            }
            return false;
        } else if (!(m11 instanceof RecyclerView)) {
            return m11.canScrollVertically(i11);
        } else {
            RecyclerView recyclerView = (RecyclerView) m11;
            if ((recyclerView.canScrollHorizontally(1) || recyclerView.canScrollHorizontally(-1)) && !recyclerView.canScrollVertically(i11)) {
                return false;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (!(layoutManager == null || adapter == null || adapter.getItemCount() <= 0)) {
                if (layoutManager.findViewByPosition(i11 > 0 ? adapter.getItemCount() - 1 : 0) == null) {
                    return true;
                }
                int childCount = recyclerView.getChildCount();
                if (i11 > 0) {
                    for (int i12 = childCount - 1; i12 >= 0; i12--) {
                        View childAt = recyclerView.getChildAt(i12);
                        Rect rect = f64939d;
                        recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
                        if (rect.bottom > recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                            return true;
                        }
                    }
                    return false;
                }
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt2 = recyclerView.getChildAt(i13);
                    Rect rect2 = f64939d;
                    recyclerView.getDecoratedBoundsWithMargins(childAt2, rect2);
                    if (rect2.top < recyclerView.getPaddingTop()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static int d(View view) {
        View m11 = m(view);
        if (m11 instanceof a0) {
            return ((a0) m11).computeVerticalScrollExtent();
        }
        try {
            if (f64938c == null) {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
                f64938c = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = f64938c.invoke(m11, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return m11.getHeight();
    }

    public static int e(View view) {
        View m11 = m(view);
        if (m11 instanceof a0) {
            return ((a0) m11).computeVerticalScrollOffset();
        }
        try {
            if (f64936a == null) {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
                f64936a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = f64936a.invoke(m11, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return m11.getScrollY();
    }

    public static int f(View view) {
        View m11 = m(view);
        if (m11 instanceof a0) {
            return ((a0) m11).computeVerticalScrollRange();
        }
        try {
            if (f64937b == null) {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
                f64937b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = f64937b.invoke(m11, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return m11.getHeight();
    }

    public static List<ConsecutiveScrollerLayout> g(View view, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        for (View next : o(view, i11, i12)) {
            if (next instanceof ConsecutiveScrollerLayout) {
                arrayList.add((ConsecutiveScrollerLayout) next);
            }
        }
        return arrayList;
    }

    public static int h(View view, MotionEvent motionEvent, int i11) {
        float x11;
        if (Build.VERSION.SDK_INT >= 29) {
            x11 = motionEvent.getRawX(i11);
        } else {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            x11 = ((float) iArr[0]) + motionEvent.getX(i11);
        }
        return (int) x11;
    }

    public static int i(View view, MotionEvent motionEvent, int i11) {
        float y11;
        if (Build.VERSION.SDK_INT >= 29) {
            y11 = motionEvent.getRawY(i11);
        } else {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            y11 = ((float) iArr[1]) + motionEvent.getY(i11);
        }
        return (int) y11;
    }

    public static int j(View view) {
        if (!q(view) || !c(view, 1)) {
            return 0;
        }
        return Math.max((f(view) - e(view)) - d(view), 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r0 = r2.findViewById((r0 = ((com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.LayoutParams) r0).f64925f));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.View k(android.view.View r2) {
        /*
            if (r2 == 0) goto L_0x0018
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            boolean r1 = r0 instanceof com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.LayoutParams
            if (r1 == 0) goto L_0x0018
            com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout$LayoutParams r0 = (com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.LayoutParams) r0
            int r0 = r0.f64925f
            r1 = -1
            if (r0 == r1) goto L_0x0018
            android.view.View r0 = r2.findViewById(r0)
            if (r0 == 0) goto L_0x0018
            return r0
        L_0x0018:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.donkingliang.consecutivescroller.ScrollUtils.k(android.view.View):android.view.View");
    }

    public static int l(View view) {
        if (!q(view) || !c(view, -1)) {
            return 0;
        }
        return Math.min(-e(view), -1);
    }

    public static View m(View view) {
        View k11 = k(view);
        while (k11 instanceof a) {
            View currentScrollerView = ((a) k11).getCurrentScrollerView();
            if (k11 == currentScrollerView) {
                return currentScrollerView;
            }
            k11 = currentScrollerView;
        }
        return k11;
    }

    public static View n(ConsecutiveScrollerLayout consecutiveScrollerLayout, int i11, int i12) {
        int childCount = consecutiveScrollerLayout.getChildCount();
        View view = null;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = consecutiveScrollerLayout.getChildAt(i13);
            if (childAt.getVisibility() == 0 && t(childAt, i11, i12) && (view == null || h0.U(childAt) > h0.U(view) || (h0.U(childAt) == h0.U(view) && consecutiveScrollerLayout.v(childAt) > consecutiveScrollerLayout.v(view)))) {
                view = childAt;
            }
        }
        return view;
    }

    public static List<View> o(View view, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        a(arrayList, view, i11, i12);
        return arrayList;
    }

    public static boolean p(View view) {
        while ((view.getParent() instanceof ViewGroup) && !(view.getParent() instanceof ConsecutiveScrollerLayout)) {
            view = (View) view.getParent();
        }
        if (view.getParent() instanceof ConsecutiveScrollerLayout) {
            return q(view);
        }
        return false;
    }

    public static boolean q(View view) {
        if (view == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConsecutiveScrollerLayout.LayoutParams) {
            return ((ConsecutiveScrollerLayout.LayoutParams) layoutParams).f64920a;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean r(android.view.View r1, int r2, int r3) {
        /*
            java.util.List r1 = o(r1, r2, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0008:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r1.next()
            android.view.View r2 = (android.view.View) r2
            r3 = 1
            boolean r0 = r2.canScrollHorizontally(r3)
            if (r0 != 0) goto L_0x0022
            r0 = -1
            boolean r2 = r2.canScrollHorizontally(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0022:
            return r3
        L_0x0023:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.donkingliang.consecutivescroller.ScrollUtils.r(android.view.View, int, int):boolean");
    }

    public static boolean s(View view, int i11, int i12) {
        List<ConsecutiveScrollerLayout> g11 = g(view, i11, i12);
        for (int size = g11.size() - 1; size >= 0; size--) {
            ConsecutiveScrollerLayout consecutiveScrollerLayout = g11.get(size);
            View n11 = n(consecutiveScrollerLayout, i11, i12);
            if (n11 != null && consecutiveScrollerLayout.I(n11) && consecutiveScrollerLayout.e0(n11) && !((ConsecutiveScrollerLayout.LayoutParams) n11.getLayoutParams()).f64923d) {
                return true;
            }
        }
        return false;
    }

    public static boolean t(View view, int i11, int i12) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i13 = iArr[0];
        int i14 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i13;
        int measuredHeight = view.getMeasuredHeight() + i14;
        if (i11 < i13 || i11 > measuredWidth || i12 < i14 || i12 > measuredHeight) {
            return false;
        }
        return true;
    }

    public static boolean u(RecyclerView recyclerView) {
        if ("InterceptRequestLayout".equals(recyclerView.getTag())) {
            try {
                Method declaredMethod = RecyclerView.class.getDeclaredMethod("startInterceptRequestLayout", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(recyclerView, new Object[0]);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void v(RecyclerView recyclerView) {
        if ("InterceptRequestLayout".equals(recyclerView.getTag())) {
            Class<RecyclerView> cls = RecyclerView.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("stopInterceptRequestLayout", new Class[]{Boolean.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(recyclerView, new Object[]{Boolean.FALSE});
            } catch (Exception unused) {
            }
        }
    }
}
