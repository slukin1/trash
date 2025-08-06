package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.core.util.g;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.h0;
import androidx.core.view.r;
import androidx.core.view.s;
import androidx.core.view.u;
import androidx.core.view.v;
import androidx.customview.view.AbsSavedState;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.material.badge.BadgeDrawable;
import com.huobi.view.roundimg.RoundedDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements r, s {
    public static final Class<?>[] CONSTRUCTOR_PARAMS = {Context.class, AttributeSet.class};
    public static final int EVENT_NESTED_SCROLL = 1;
    public static final int EVENT_PRE_DRAW = 0;
    public static final int EVENT_VIEW_REMOVED = 2;
    public static final String TAG = "CoordinatorLayout";
    public static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = new ThreadLocal<>();
    private static final androidx.core.util.e<Rect> sRectPool = new g(12);
    private v mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final u mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private e mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public static Object getTag(View view) {
            return ((LayoutParams) view.getLayoutParams()).f8129r;
        }

        public static void setTag(View view, Object obj) {
            ((LayoutParams) view.getLayoutParams()).f8129r = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v11) {
            return getScrimOpacity(coordinatorLayout, v11) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v11, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v11) {
            return RoundedDrawable.DEFAULT_BORDER_COLOR;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v11) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v11, View view) {
            return false;
        }

        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v11, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onAttachedToLayoutParams(LayoutParams layoutParams) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v11, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v11, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v11, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v11, int i11) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v11, int i11, int i12, int i13, int i14) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v11, View view, float f11, float f12, boolean z11) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v11, View view, float f11, float f12) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11, int i12, int[] iArr) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11, int i12, int[] iArr, int i13) {
            if (i13 == 0) {
                onNestedPreScroll(coordinatorLayout, v11, view, i11, i12, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11, int i12, int i13, int i14) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11, int i12, int i13, int i14, int i15) {
            if (i15 == 0) {
                onNestedScroll(coordinatorLayout, v11, view, i11, i12, i13, i14);
            }
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v11, View view, View view2, int i11) {
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v11, View view, View view2, int i11, int i12) {
            if (i12 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v11, view, view2, i11);
            }
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v11, Rect rect, boolean z11) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v11, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v11) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, View view2, int i11) {
            return false;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, View view2, int i11, int i12) {
            if (i12 == 0) {
                return onStartNestedScroll(coordinatorLayout, v11, view, view2, i11);
            }
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view) {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11) {
            if (i11 == 0) {
                onStopNestedScroll(coordinatorLayout, v11, view);
            }
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v11, MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
            iArr[0] = iArr[0] + i13;
            iArr[1] = iArr[1] + i14;
            onNestedScroll(coordinatorLayout, v11, view, i11, i12, i13, i14, i15);
        }
    }

    public class a implements v {
        public a() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return CoordinatorLayout.this.setWindowInsets(windowInsetsCompat);
        }
    }

    public interface b {
        Behavior getBehavior();
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class<? extends Behavior> value();
    }

    public class d implements ViewGroup.OnHierarchyChangeListener {
        public d() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class e implements ViewTreeObserver.OnPreDrawListener {
        public e() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    public static class f implements Comparator<View> {
        /* renamed from: a */
        public int compare(View view, View view2) {
            float U = h0.U(view);
            float U2 = h0.U(view2);
            if (U > U2) {
                return -1;
            }
            return U < U2 ? 1 : 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getName()
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            WIDGET_PACKAGE_NAME = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x001f
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$f
            r0.<init>()
            TOP_SORTED_CHILDREN_COMPARATOR = r0
            goto L_0x0021
        L_0x001f:
            TOP_SORTED_CHILDREN_COMPARATOR = r1
        L_0x0021:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            CONSTRUCTOR_PARAMS = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            sConstructors = r0
            androidx.core.util.g r0 = new androidx.core.util.g
            r1 = 12
            r0.<init>(r1)
            sRectPool = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static Rect acquireTempRect() {
        Rect acquire = sRectPool.acquire();
        return acquire == null ? new Rect() : acquire;
    }

    private static int clamp(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : i11 > i13 ? i13 : i11;
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i11, int i12) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i11) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i12) - layoutParams.bottomMargin));
        rect.set(max, max2, i11 + max, i12 + max2);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        Behavior f11;
        if (windowInsetsCompat.q()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (h0.C(childAt) && (f11 = ((LayoutParams) childAt.getLayoutParams()).f()) != null) {
                windowInsetsCompat = f11.onApplyWindowInsets(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.q()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i11, Rect rect, Rect rect2, LayoutParams layoutParams, int i12, int i13) {
        int i14;
        int i15;
        int b11 = androidx.core.view.f.b(resolveAnchoredChildGravity(layoutParams.f8114c), i11);
        int b12 = androidx.core.view.f.b(resolveGravity(layoutParams.f8115d), i11);
        int i16 = b11 & 7;
        int i17 = b11 & 112;
        int i18 = b12 & 7;
        int i19 = b12 & 112;
        if (i18 == 1) {
            i14 = rect.left + (rect.width() / 2);
        } else if (i18 != 5) {
            i14 = rect.left;
        } else {
            i14 = rect.right;
        }
        if (i19 == 16) {
            i15 = rect.top + (rect.height() / 2);
        } else if (i19 != 80) {
            i15 = rect.top;
        } else {
            i15 = rect.bottom;
        }
        if (i16 == 1) {
            i14 -= i12 / 2;
        } else if (i16 != 5) {
            i14 -= i12;
        }
        if (i17 == 16) {
            i15 -= i13 / 2;
        } else if (i17 != 80) {
            i15 -= i13;
        }
        rect2.set(i14, i15, i12 + i14, i13 + i15);
    }

    private int getKeyline(int i11) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i11);
            return 0;
        } else if (i11 >= 0 && i11 < iArr.length) {
            return iArr[i11];
        } else {
            Log.e(TAG, "Keyline index " + i11 + " out of range for " + this);
            return 0;
        }
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i11) : i11));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.j(view);
    }

    private void layoutChild(View view, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (this.mLastInsets != null && h0.C(this) && !h0.C(view)) {
            acquireTempRect.left += this.mLastInsets.k();
            acquireTempRect.top += this.mLastInsets.m();
            acquireTempRect.right -= this.mLastInsets.l();
            acquireTempRect.bottom -= this.mLastInsets.j();
        }
        Rect acquireTempRect2 = acquireTempRect();
        androidx.core.view.f.a(resolveGravity(layoutParams.f8114c), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i11);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int i11) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i11, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i11, int i12) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int b11 = androidx.core.view.f.b(resolveKeylineGravity(layoutParams.f8114c), i12);
        int i13 = b11 & 7;
        int i14 = b11 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i12 == 1) {
            i11 = width - i11;
        }
        int keyline = getKeyline(i11) - measuredWidth;
        int i15 = 0;
        if (i13 == 1) {
            keyline += measuredWidth / 2;
        } else if (i13 == 5) {
            keyline += measuredWidth;
        }
        if (i14 == 16) {
            i15 = 0 + (measuredHeight / 2);
        } else if (i14 == 80) {
            i15 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(i15, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void offsetChildByInset(View view, Rect rect, int i11) {
        boolean z11;
        boolean z12;
        int width;
        int i12;
        int i13;
        int i14;
        int height;
        int i15;
        int i16;
        int i17;
        if (h0.a0(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior f11 = layoutParams.f();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f11 == null || !f11.getInsetDodgeRect(this, view, acquireTempRect)) {
                acquireTempRect.set(acquireTempRect2);
            } else if (!acquireTempRect2.contains(acquireTempRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int b11 = androidx.core.view.f.b(layoutParams.f8119h, i11);
            boolean z13 = true;
            if ((b11 & 48) != 48 || (i16 = (acquireTempRect.top - layoutParams.topMargin) - layoutParams.f8121j) >= (i17 = rect.top)) {
                z11 = false;
            } else {
                setInsetOffsetY(view, i17 - i16);
                z11 = true;
            }
            if ((b11 & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - layoutParams.bottomMargin) + layoutParams.f8121j) < (i15 = rect.bottom)) {
                setInsetOffsetY(view, height - i15);
                z11 = true;
            }
            if (!z11) {
                setInsetOffsetY(view, 0);
            }
            if ((b11 & 3) != 3 || (i13 = (acquireTempRect.left - layoutParams.leftMargin) - layoutParams.f8120i) >= (i14 = rect.left)) {
                z12 = false;
            } else {
                setInsetOffsetX(view, i14 - i13);
                z12 = true;
            }
            if ((b11 & 5) != 5 || (width = ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin) + layoutParams.f8120i) >= (i12 = rect.right)) {
                z13 = z12;
            } else {
                setInsetOffsetX(view, width - i12);
            }
            if (!z13) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    public static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(InstructionFileId.DOT)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = WIDGET_PACKAGE_NAME;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = sConstructors;
            Map map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e11) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e11);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i11) {
        MotionEvent motionEvent2 = motionEvent;
        int i12 = i11;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z11 = false;
        boolean z12 = false;
        for (int i13 = 0; i13 < size; i13++) {
            View view = list.get(i13);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior f11 = layoutParams.f();
            if ((!z11 && !z12) || actionMasked == 0) {
                if (!z11 && f11 != null) {
                    if (i12 == 0) {
                        z11 = f11.onInterceptTouchEvent(this, view, motionEvent2);
                    } else if (i12 == 1) {
                        z11 = f11.onTouchEvent(this, view, motionEvent2);
                    }
                    if (z11) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean c11 = layoutParams.c();
                boolean i14 = layoutParams.i(this, view);
                z12 = i14 && !c11;
                if (i14 && !z12) {
                    break;
                }
            } else if (f11 != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i12 == 0) {
                    f11.onInterceptTouchEvent(this, view, motionEvent3);
                } else if (i12 == 1) {
                    f11.onTouchEvent(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z11;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.c();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.d(this, childAt);
            this.mChildDag.b(childAt);
            for (int i12 = 0; i12 < childCount; i12++) {
                if (i12 != i11) {
                    View childAt2 = getChildAt(i12);
                    if (resolvedLayoutParams.b(this, childAt, childAt2)) {
                        if (!this.mChildDag.d(childAt2)) {
                            this.mChildDag.b(childAt2);
                        }
                        this.mChildDag.a(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.i());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    private void resetTouchBehaviors(boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            Behavior f11 = ((LayoutParams) childAt.getLayoutParams()).f();
            if (f11 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z11) {
                    f11.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    f11.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            ((LayoutParams) getChildAt(i12).getLayoutParams()).m();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int i11) {
        if (i11 == 0) {
            return 17;
        }
        return i11;
    }

    private static int resolveGravity(int i11) {
        if ((i11 & 7) == 0) {
            i11 |= 8388611;
        }
        return (i11 & 112) == 0 ? i11 | 48 : i11;
    }

    private static int resolveKeylineGravity(int i11) {
        return i11 == 0 ? BadgeDrawable.TOP_END : i11;
    }

    private void setInsetOffsetX(View view, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = layoutParams.f8120i;
        if (i12 != i11) {
            h0.g0(view, i11 - i12);
            layoutParams.f8120i = i11;
        }
    }

    private void setInsetOffsetY(View view, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = layoutParams.f8121j;
        if (i12 != i11) {
            h0.h0(view, i11 - i12);
            layoutParams.f8121j = i11;
        }
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (h0.C(this)) {
                if (this.mApplyWindowInsetsListener == null) {
                    this.mApplyWindowInsetsListener = new a();
                }
                h0.O0(this, this.mApplyWindowInsetsListener);
                setSystemUiVisibility(1280);
                return;
            }
            h0.O0(this, (v) null);
        }
    }

    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void dispatchDependentViewsChanged(View view) {
        List g11 = this.mChildDag.g(view);
        if (g11 != null && !g11.isEmpty()) {
            for (int i11 = 0; i11 < g11.size(); i11++) {
                View view2 = (View) g11.get(i11);
                Behavior f11 = ((LayoutParams) view2.getLayoutParams()).f();
                if (f11 != null) {
                    f11.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z11 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        getChildRect(view2, view2.getParent() != this, acquireTempRect2);
        try {
            if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left && acquireTempRect.bottom >= acquireTempRect2.top) {
                z11 = true;
            }
            return z11;
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Behavior behavior = layoutParams.f8112a;
        if (behavior != null) {
            float scrimOpacity = behavior.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.f8112a.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j11);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z11 = false;
        if (drawable != null && drawable.isStateful()) {
            z11 = false | drawable.setState(drawableState);
        }
        if (z11) {
            invalidate();
        }
    }

    public void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i11))) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (z11 == this.mNeedsPreDrawListener) {
            return;
        }
        if (z11) {
            addPreDrawListener();
        } else {
            removePreDrawListener();
        }
    }

    public void getChildRect(View view, boolean z11, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z11) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> getDependencies(View view) {
        List<View> h11 = this.mChildDag.h(view);
        this.mTempDependenciesList.clear();
        if (h11 != null) {
            this.mTempDependenciesList.addAll(h11);
        }
        return this.mTempDependenciesList;
    }

    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List<View> getDependents(View view) {
        List g11 = this.mChildDag.g(view);
        this.mTempDependenciesList.clear();
        if (g11 != null) {
            this.mTempDependenciesList.addAll(g11);
        }
        return this.mTempDependenciesList;
    }

    public void getDescendantRect(View view, Rect rect) {
        o0.a.a(this, view, rect);
    }

    public void getDesiredAnchoredChildRect(View view, int i11, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i11, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    public void getLastChildRect(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).h());
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    public LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f8113b) {
            if (view instanceof b) {
                Behavior behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                layoutParams.o(behavior);
                layoutParams.f8113b = true;
            } else {
                c cVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        layoutParams.o((Behavior) cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e11) {
                        Log.e(TAG, "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e11);
                    }
                }
                layoutParams.f8113b = true;
            }
        }
        return layoutParams;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public boolean isPointInChildBounds(View view, int i11, int i12) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i11, i12);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    public void offsetChildToAnchor(View view, int i11) {
        Behavior f11;
        View view2 = view;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f8122k != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(layoutParams.f8122k, acquireTempRect);
            boolean z11 = false;
            getChildRect(view2, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i12 = measuredHeight;
            getDesiredAnchoredChildRectWithoutConstraints(view, i11, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
            if (!(acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top)) {
                z11 = true;
            }
            constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, i12);
            int i13 = acquireTempRect3.left - acquireTempRect2.left;
            int i14 = acquireTempRect3.top - acquireTempRect2.top;
            if (i13 != 0) {
                h0.g0(view2, i13);
            }
            if (i14 != 0) {
                h0.h0(view2, i14);
            }
            if (z11 && (f11 = layoutParams.f()) != null) {
                f11.onDependentViewChanged(this, view2, layoutParams.f8122k);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && h0.C(this)) {
            h0.u0(this);
        }
        this.mIsAttachedToWindow = true;
    }

    public final void onChildViewsChanged(int i11) {
        boolean z11;
        int i12 = i11;
        int F = h0.F(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i13 = 0; i13 < size; i13++) {
            View view = this.mDependencySortedChildren.get(i13);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i12 != 0 || view.getVisibility() != 8) {
                for (int i14 = 0; i14 < i13; i14++) {
                    if (layoutParams.f8123l == this.mDependencySortedChildren.get(i14)) {
                        offsetChildToAnchor(view, F);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (layoutParams.f8118g != 0 && !acquireTempRect2.isEmpty()) {
                    int b11 = androidx.core.view.f.b(layoutParams.f8118g, F);
                    int i15 = b11 & 112;
                    if (i15 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i15 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    int i16 = b11 & 7;
                    if (i16 == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (i16 == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (layoutParams.f8119h != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, F);
                }
                if (i12 != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i17 = i13 + 1; i17 < size; i17++) {
                    View view2 = this.mDependencySortedChildren.get(i17);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior f11 = layoutParams2.f();
                    if (f11 != null && f11.layoutDependsOn(this, view2, view)) {
                        if (i12 != 0 || !layoutParams2.g()) {
                            if (i12 != 2) {
                                z11 = f11.onDependentViewChanged(this, view2, view);
                            } else {
                                f11.onDependentViewRemoved(this, view2, view);
                                z11 = true;
                            }
                            if (i12 == 1) {
                                layoutParams2.p(z11);
                            }
                        } else {
                            layoutParams2.k();
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            int m11 = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
            if (m11 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), m11);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        Behavior f11;
        int F = h0.F(this);
        int size = this.mDependencySortedChildren.size();
        for (int i15 = 0; i15 < size; i15++) {
            View view = this.mDependencySortedChildren.get(i15);
            if (view.getVisibility() != 8 && ((f11 = ((LayoutParams) view.getLayoutParams()).f()) == null || !f11.onLayoutChild(this, view, F))) {
                onLayoutChild(view, F);
            }
        }
    }

    public void onLayoutChild(View view, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.a()) {
            View view2 = layoutParams.f8122k;
            if (view2 != null) {
                layoutChildWithAnchor(view, view2, i11);
                return;
            }
            int i12 = layoutParams.f8116e;
            if (i12 >= 0) {
                layoutChildWithKeyline(view, i12, i11);
            } else {
                layoutChild(view, i11);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L_0x012a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.prepareChildren()
            r30.ensurePreDrawListener()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.view.h0.F(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = r2
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.view.WindowInsetsCompat r3 = r7.mLastInsets
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.view.h0.C(r30)
            if (r3 == 0) goto L_0x004b
            r19 = r2
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.mDependencySortedChildren
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x0057:
            if (r3 >= r6) goto L_0x016f
            java.util.List<android.view.View> r0 = r7.mDependencySortedChildren
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0073
            r22 = r3
            r29 = r6
            r28 = r8
            goto L_0x0167
        L_0x0073:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            int r0 = r1.f8116e
            if (r0 < 0) goto L_0x00ba
            if (r13 == 0) goto L_0x00ba
            int r0 = r7.getKeyline(r0)
            int r11 = r1.f8114c
            int r11 = resolveKeylineGravity(r11)
            int r11 = androidx.core.view.f.b(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r11 = r0
            r21 = r2
            goto L_0x00bf
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00bc
            if (r12 == 0) goto L_0x00bc
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00bf
        L_0x00ba:
            r22 = r2
        L_0x00bc:
            r11 = 0
            r21 = r11
        L_0x00bf:
            if (r19 == 0) goto L_0x00f1
            boolean r0 = androidx.core.view.h0.C(r20)
            if (r0 != 0) goto L_0x00f1
            androidx.core.view.WindowInsetsCompat r0 = r7.mLastInsets
            int r0 = r0.k()
            androidx.core.view.WindowInsetsCompat r2 = r7.mLastInsets
            int r2 = r2.l()
            int r0 = r0 + r2
            androidx.core.view.WindowInsetsCompat r2 = r7.mLastInsets
            int r2 = r2.m()
            androidx.core.view.WindowInsetsCompat r11 = r7.mLastInsets
            int r11 = r11.j()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f5
        L_0x00f1:
            r11 = r31
            r23 = r32
        L_0x00f5:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f()
            if (r0 == 0) goto L_0x011d
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r11
            r27 = r4
            r4 = r21
            r28 = r8
            r8 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.onMeasureChild(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0137
            goto L_0x012a
        L_0x011d:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r8
            r25 = r22
            r22 = r3
            r8 = r5
        L_0x012a:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.onMeasureChild(r1, r2, r3, r4, r5)
        L_0x0137:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r8, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r25
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r5 = r0
            r4 = r1
        L_0x0167:
            int r3 = r22 + 1
            r8 = r28
            r6 = r29
            goto L_0x0057
        L_0x016f:
            r11 = r2
            r1 = r4
            r8 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r8, r2, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public void onMeasureChild(View view, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        Behavior f13;
        int childCount = getChildCount();
        boolean z12 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(0) && (f13 = layoutParams.f()) != null) {
                    z12 |= f13.onNestedFling(this, childAt, view, f11, f12, z11);
                }
            }
        }
        if (z12) {
            onChildViewsChanged(1);
        }
        return z12;
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        Behavior f13;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(0) && (f13 = layoutParams.f()) != null) {
                    z11 |= f13.onNestedPreFling(this, childAt, view, f11, f12);
                }
            }
        }
        return z11;
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        onNestedPreScroll(view, i11, i12, iArr, 0);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i11, i12, i13, i14, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i11) {
        onNestedScrollAccepted(view, view2, i11, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            Behavior f11 = getResolvedLayoutParams(childAt).f();
            if (!(id2 == -1 || f11 == null || (parcelable2 = sparseArray.get(id2)) == null)) {
                f11.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            Behavior f11 = ((LayoutParams) childAt.getLayoutParams()).f();
            if (!(id2 == -1 || f11 == null || (onSaveInstanceState = f11.onSaveInstanceState(this, childAt)) == null)) {
                sparseArray.append(id2, onSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return onStartNestedScroll(view, view2, i11, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = r5
        L_0x0016:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L_0x002c
        L_0x002b:
            r6 = r5
        L_0x002c:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.resetTouchBehaviors(r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void recordLastChildRect(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).q(rect);
    }

    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z11) {
        Behavior f11 = ((LayoutParams) view.getLayoutParams()).f();
        if (f11 == null || !f11.onRequestChildRectangleOnScreen(this, view, rect, z11)) {
            return super.requestChildRectangleOnScreen(view, rect, z11);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        super.requestDisallowInterceptTouchEvent(z11);
        if (z11 && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    public void setFitsSystemWindows(boolean z11) {
        super.setFitsSystemWindows(z11);
        setupForInsets();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                u0.a.m(this.mStatusBarBackground, h0.F(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            h0.n0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i11) {
        setStatusBarBackground(new ColorDrawable(i11));
    }

    public void setStatusBarBackgroundResource(int i11) {
        setStatusBarBackground(i11 != 0 ? ContextCompat.getDrawable(getContext(), i11) : null);
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z11 = i11 == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z11) {
            this.mStatusBarBackground.setVisible(z11, false);
        }
    }

    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        if (androidx.core.util.b.a(this.mLastInsets, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.mLastInsets = windowInsetsCompat;
        boolean z11 = true;
        boolean z12 = windowInsetsCompat != null && windowInsetsCompat.m() > 0;
        this.mDrawStatusBarBackground = z12;
        if (z12 || getBackground() != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
        WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
        requestLayout();
        return dispatchApplyWindowInsetsToBehaviors;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        Behavior f11;
        int i14;
        int i15;
        int childCount = getChildCount();
        boolean z11 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() == 8) {
                int i19 = i13;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(i13) && (f11 = layoutParams.f()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f11.onNestedPreScroll(this, childAt, view, i11, i12, iArr2, i13);
                    int[] iArr3 = this.mBehaviorConsumed;
                    if (i11 > 0) {
                        i14 = Math.max(i16, iArr3[0]);
                    } else {
                        i14 = Math.min(i16, iArr3[0]);
                    }
                    i16 = i14;
                    int[] iArr4 = this.mBehaviorConsumed;
                    if (i12 > 0) {
                        i15 = Math.max(i17, iArr4[1]);
                    } else {
                        i15 = Math.min(i17, iArr4[1]);
                    }
                    i17 = i15;
                    z11 = true;
                }
            }
        }
        iArr[0] = i16;
        iArr[1] = i17;
        if (z11) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        onNestedScroll(view, i11, i12, i13, i14, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        Behavior f11;
        this.mNestedScrollingParentHelper.c(view, view2, i11, i12);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.j(i12) && (f11 = layoutParams.f()) != null) {
                f11.onNestedScrollAccepted(this, childAt, view, view2, i11, i12);
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        int i13 = i12;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior f11 = layoutParams.f();
                if (f11 != null) {
                    boolean onStartNestedScroll = f11.onStartNestedScroll(this, childAt, view, view2, i11, i12);
                    z11 |= onStartNestedScroll;
                    layoutParams.r(i13, onStartNestedScroll);
                } else {
                    layoutParams.r(i13, false);
                }
            }
        }
        return z11;
    }

    public void onStopNestedScroll(View view, int i11) {
        this.mNestedScrollingParentHelper.e(view, i11);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.j(i11)) {
                Behavior f11 = layoutParams.f();
                if (f11 != null) {
                    f11.onStopNestedScroll(this, childAt, view, i11);
                }
                layoutParams.l(i11);
                layoutParams.k();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray typedArray;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new u(this);
        if (i11 == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i11, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i11 == 0) {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, typedArray, 0, R$style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, typedArray, i11, 0);
            }
        }
        int resourceId = typedArray.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f11 = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i12 = 0; i12 < length; i12++) {
                int[] iArr = this.mKeylines;
                iArr[i12] = (int) (((float) iArr[i12]) * f11);
            }
        }
        this.mStatusBarBackground = typedArray.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new d());
        if (h0.D(this) == 0) {
            h0.I0(this, 1);
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        Behavior f11;
        int i16;
        boolean z11;
        int i17;
        int childCount = getChildCount();
        boolean z12 = false;
        int i18 = 0;
        int i19 = 0;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(i15) && (f11 = layoutParams.f()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f11.onNestedScroll(this, childAt, view, i11, i12, i13, i14, i15, iArr2);
                    int[] iArr3 = this.mBehaviorConsumed;
                    if (i13 > 0) {
                        i16 = Math.max(i18, iArr3[0]);
                    } else {
                        i16 = Math.min(i18, iArr3[0]);
                    }
                    i18 = i16;
                    if (i14 > 0) {
                        z11 = true;
                        i17 = Math.max(i19, this.mBehaviorConsumed[1]);
                    } else {
                        z11 = true;
                        i17 = Math.min(i19, this.mBehaviorConsumed[1]);
                    }
                    i19 = i17;
                    z12 = z11;
                }
            }
        }
        iArr[0] = iArr[0] + i18;
        iArr[1] = iArr[1] + i19;
        if (z12) {
            onChildViewsChanged(1);
        }
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public SparseArray<Parcelable> behaviorStates;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i11 = 0; i11 < readInt; i11++) {
                this.behaviorStates.append(iArr[i11], readParcelableArray[i11]);
            }
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i12 = 0; i12 < size; i12++) {
                iArr[i12] = this.behaviorStates.keyAt(i12);
                parcelableArr[i12] = this.behaviorStates.valueAt(i12);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i11);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public Behavior f8112a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8113b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f8114c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f8115d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f8116e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f8117f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f8118g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f8119h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f8120i;

        /* renamed from: j  reason: collision with root package name */
        public int f8121j;

        /* renamed from: k  reason: collision with root package name */
        public View f8122k;

        /* renamed from: l  reason: collision with root package name */
        public View f8123l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f8124m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f8125n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f8126o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f8127p;

        /* renamed from: q  reason: collision with root package name */
        public final Rect f8128q = new Rect();

        /* renamed from: r  reason: collision with root package name */
        public Object f8129r;

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public boolean a() {
            return this.f8122k == null && this.f8117f != -1;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r0 = r1.f8112a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4) {
            /*
                r1 = this;
                android.view.View r0 = r1.f8123l
                if (r4 == r0) goto L_0x001b
                int r0 = androidx.core.view.h0.F(r2)
                boolean r0 = r1.s(r4, r0)
                if (r0 != 0) goto L_0x001b
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f8112a
                if (r0 == 0) goto L_0x0019
                boolean r2 = r0.layoutDependsOn(r2, r3, r4)
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r2 = 0
                goto L_0x001c
            L_0x001b:
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams.b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):boolean");
        }

        public boolean c() {
            if (this.f8112a == null) {
                this.f8124m = false;
            }
            return this.f8124m;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f8117f == -1) {
                this.f8123l = null;
                this.f8122k = null;
                return null;
            }
            if (this.f8122k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f8122k;
        }

        public int e() {
            return this.f8117f;
        }

        public Behavior f() {
            return this.f8112a;
        }

        public boolean g() {
            return this.f8127p;
        }

        public Rect h() {
            return this.f8128q;
        }

        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z11 = this.f8124m;
            if (z11) {
                return true;
            }
            Behavior behavior = this.f8112a;
            boolean blocksInteractionBelow = (behavior != null ? behavior.blocksInteractionBelow(coordinatorLayout, view) : false) | z11;
            this.f8124m = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        public boolean j(int i11) {
            if (i11 == 0) {
                return this.f8125n;
            }
            if (i11 != 1) {
                return false;
            }
            return this.f8126o;
        }

        public void k() {
            this.f8127p = false;
        }

        public void l(int i11) {
            r(i11, false);
        }

        public void m() {
            this.f8124m = false;
        }

        public final void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f8117f);
            this.f8122k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f8123l = null;
                            this.f8122k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f8123l = findViewById;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f8123l = null;
                    this.f8122k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f8123l = null;
                this.f8122k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f8117f) + " to anchor view " + view);
            }
        }

        public void o(Behavior behavior) {
            Behavior behavior2 = this.f8112a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.f8112a = behavior;
                this.f8129r = null;
                this.f8113b = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        public void p(boolean z11) {
            this.f8127p = z11;
        }

        public void q(Rect rect) {
            this.f8128q.set(rect);
        }

        public void r(int i11, boolean z11) {
            if (i11 == 0) {
                this.f8125n = z11;
            } else if (i11 == 1) {
                this.f8126o = z11;
            }
        }

        public final boolean s(View view, int i11) {
            int b11 = androidx.core.view.f.b(((LayoutParams) view.getLayoutParams()).f8118g, i11);
            return b11 != 0 && (androidx.core.view.f.b(this.f8119h, i11) & b11) == b11;
        }

        public final boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f8122k.getId() != this.f8117f) {
                return false;
            }
            View view2 = this.f8122k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f8123l = null;
                    this.f8122k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f8123l = view2;
            return true;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.f8114c = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f8117f = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f8115d = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f8116e = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f8118g = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f8119h = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i11 = R$styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean hasValue = obtainStyledAttributes.hasValue(i11);
            this.f8113b = hasValue;
            if (hasValue) {
                this.f8112a = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(i11));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f8112a;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
