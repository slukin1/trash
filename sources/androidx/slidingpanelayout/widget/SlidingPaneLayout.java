package androidx.slidingpanelayout.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.window.layout.j;
import androidx.window.layout.o;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SlidingPaneLayout extends ViewGroup {
    public static boolean C = (Build.VERSION.SDK_INT >= 29);
    public Field A;
    public boolean B;

    /* renamed from: b  reason: collision with root package name */
    public int f10956b;

    /* renamed from: c  reason: collision with root package name */
    public int f10957c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f10958d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f10959e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10960f;

    /* renamed from: g  reason: collision with root package name */
    public View f10961g;

    /* renamed from: h  reason: collision with root package name */
    public float f10962h;

    /* renamed from: i  reason: collision with root package name */
    public float f10963i;

    /* renamed from: j  reason: collision with root package name */
    public int f10964j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f10965k;

    /* renamed from: l  reason: collision with root package name */
    public int f10966l;

    /* renamed from: m  reason: collision with root package name */
    public float f10967m;

    /* renamed from: n  reason: collision with root package name */
    public float f10968n;

    /* renamed from: o  reason: collision with root package name */
    public final List<e> f10969o;

    /* renamed from: p  reason: collision with root package name */
    public e f10970p;

    /* renamed from: q  reason: collision with root package name */
    public final ViewDragHelper f10971q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f10972r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f10973s;

    /* renamed from: t  reason: collision with root package name */
    public final Rect f10974t;

    /* renamed from: u  reason: collision with root package name */
    public final ArrayList<c> f10975u;

    /* renamed from: v  reason: collision with root package name */
    public int f10976v;

    /* renamed from: w  reason: collision with root package name */
    public j f10977w;

    /* renamed from: x  reason: collision with root package name */
    public FoldingFeatureObserver.a f10978x;

    /* renamed from: y  reason: collision with root package name */
    public FoldingFeatureObserver f10979y;

    /* renamed from: z  reason: collision with root package name */
    public Method f10980z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean isOpen;
        public int mLockMode;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.isOpen ? 1 : 0);
            parcel.writeInt(this.mLockMode);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
            this.mLockMode = parcel.readInt();
        }
    }

    public static class SimplePanelSlideListener implements e {
        public void a(View view) {
        }

        public void b(View view) {
        }

        public void c(View view, float f11) {
        }
    }

    public static class TouchBlocker extends FrameLayout {
        public TouchBlocker(View view) {
            super(view.getContext());
            addView(view);
        }

        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public class a implements FoldingFeatureObserver.a {
        public a() {
        }

        public void a(j jVar) {
            SlidingPaneLayout.this.f10977w = jVar;
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(300);
            changeBounds.setInterpolator(c1.b.a(0.2f, 0.0f, 0.0f, 1.0f));
            TransitionManager.b(SlidingPaneLayout.this, changeBounds);
            SlidingPaneLayout.this.requestLayout();
        }
    }

    public class b extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f10987a = new Rect();

        public b() {
        }

        public final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f10987a;
            accessibilityNodeInfoCompat2.n(rect);
            accessibilityNodeInfoCompat.k0(rect);
            accessibilityNodeInfoCompat.S0(accessibilityNodeInfoCompat2.Z());
            accessibilityNodeInfoCompat.D0(accessibilityNodeInfoCompat2.z());
            accessibilityNodeInfoCompat.o0(accessibilityNodeInfoCompat2.q());
            accessibilityNodeInfoCompat.s0(accessibilityNodeInfoCompat2.t());
            accessibilityNodeInfoCompat.u0(accessibilityNodeInfoCompat2.O());
            accessibilityNodeInfoCompat.p0(accessibilityNodeInfoCompat2.M());
            accessibilityNodeInfoCompat.w0(accessibilityNodeInfoCompat2.P());
            accessibilityNodeInfoCompat.x0(accessibilityNodeInfoCompat2.Q());
            accessibilityNodeInfoCompat.h0(accessibilityNodeInfoCompat2.J());
            accessibilityNodeInfoCompat.L0(accessibilityNodeInfoCompat2.W());
            accessibilityNodeInfoCompat.A0(accessibilityNodeInfoCompat2.T());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.k());
            accessibilityNodeInfoCompat.C0(accessibilityNodeInfoCompat2.x());
        }

        public boolean b(View view) {
            return SlidingPaneLayout.this.k(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat c02 = AccessibilityNodeInfoCompat.c0(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, c02);
            a(accessibilityNodeInfoCompat, c02);
            c02.e0();
            accessibilityNodeInfoCompat.o0("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            accessibilityNodeInfoCompat.N0(view);
            ViewParent M = h0.M(view);
            if (M instanceof View) {
                accessibilityNodeInfoCompat.F0((View) M);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i11);
                if (!b(childAt) && childAt.getVisibility() == 0) {
                    h0.I0(childAt, 1);
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!b(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final View f10989b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f10990c;

        public void run() {
            if (this.f10989b.getParent() == this.f10990c) {
                this.f10989b.setLayerType(0, (Paint) null);
                this.f10990c.j(this.f10989b);
            }
            this.f10990c.f10975u.remove(this);
        }
    }

    public class d extends ViewDragHelper.Callback {
        public d() {
        }

        public final boolean a() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f10965k || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.m() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            if (SlidingPaneLayout.this.m() || SlidingPaneLayout.this.getLockMode() != 2) {
                return true;
            }
            return false;
        }

        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f10961g.getLayoutParams();
            if (SlidingPaneLayout.this.l()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.f10961g.getWidth());
                return Math.max(Math.min(i11, width), width - SlidingPaneLayout.this.f10964j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i11, paddingLeft), SlidingPaneLayout.this.f10964j + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f10964j;
        }

        public void onEdgeDragStarted(int i11, int i12) {
            if (a()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f10971q.c(slidingPaneLayout.f10961g, i12);
            }
        }

        public void onEdgeTouched(int i11, int i12) {
            if (a()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f10971q.c(slidingPaneLayout.f10961g, i12);
            }
        }

        public void onViewCaptured(View view, int i11) {
            SlidingPaneLayout.this.u();
        }

        public void onViewDragStateChanged(int i11) {
            if (SlidingPaneLayout.this.f10971q.C() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f10962h == 1.0f) {
                    slidingPaneLayout.x(slidingPaneLayout.f10961g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.f10961g);
                    SlidingPaneLayout.this.f10972r = false;
                    return;
                }
                slidingPaneLayout.e(slidingPaneLayout.f10961g);
                SlidingPaneLayout.this.f10972r = true;
            }
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            SlidingPaneLayout.this.p(i11);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f11, float f12) {
            int i11;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.l()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f11 < 0.0f || (f11 == 0.0f && SlidingPaneLayout.this.f10962h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f10964j;
                }
                i11 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f10961g.getWidth();
            } else {
                i11 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i12 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
                if (i12 > 0 || (i12 == 0 && SlidingPaneLayout.this.f10962h > 0.5f)) {
                    i11 += SlidingPaneLayout.this.f10964j;
                }
            }
            SlidingPaneLayout.this.f10971q.Q(i11, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i11) {
            if (!a()) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f10983b;
        }
    }

    public interface e {
        void a(View view);

        void b(View view);

        void c(View view, float f11);
    }

    public SlidingPaneLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Activity g(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private t0.d getSystemGestureInsets() {
        WindowInsetsCompat N;
        if (!C || (N = h0.N(this)) == null) {
            return null;
        }
        return N.i();
    }

    public static Rect h(j jVar, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getWidth());
        Rect rect2 = new Rect(jVar.a());
        boolean intersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !intersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    public static int i(View view) {
        if (view instanceof TouchBlocker) {
            return h0.H(((TouchBlocker) view).getChildAt(0));
        }
        return h0.H(view);
    }

    public static int o(View view, int i11, int i12) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.width == 0 && layoutParams.f10982a > 0.0f) {
            return ViewGroup.getChildMeasureSpec(i11, i12, layoutParams.height);
        }
        return View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824);
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.f10979y = foldingFeatureObserver;
        foldingFeatureObserver.f(this.f10978x);
    }

    public static boolean y(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 18 || (background = view.getBackground()) == null) {
            return false;
        }
        if (background.getOpacity() == -1) {
            return true;
        }
        return false;
    }

    public void a(e eVar) {
        this.f10969o.add(eVar);
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new TouchBlocker(view), i11, layoutParams);
        } else {
            super.addView(view, i11, layoutParams);
        }
    }

    public boolean b() {
        return c(0);
    }

    public final boolean c(int i11) {
        if (!this.f10960f) {
            this.f10972r = false;
        }
        if (!this.f10973s && !v(1.0f, i11)) {
            return false;
        }
        this.f10972r = false;
        return true;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.f10971q.n(true)) {
            return;
        }
        if (!this.f10960f) {
            this.f10971q.a();
        } else {
            h0.n0(this);
        }
    }

    public void d(View view) {
        for (e b11 : this.f10969o) {
            b11.b(view);
        }
        sendAccessibilityEvent(32);
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int i11;
        int i12;
        super.draw(canvas);
        if (l()) {
            drawable = this.f10959e;
        } else {
            drawable = this.f10958d;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (l()) {
                i12 = childAt.getRight();
                i11 = intrinsicWidth + i12;
            } else {
                int left = childAt.getLeft();
                int i13 = left - intrinsicWidth;
                i11 = left;
                i12 = i13;
            }
            drawable.setBounds(i12, top, i11, bottom);
            drawable.draw(canvas);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        if (l() ^ m()) {
            this.f10971q.O(1);
            t0.d systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                ViewDragHelper viewDragHelper = this.f10971q;
                viewDragHelper.N(Math.max(viewDragHelper.x(), systemGestureInsets.f16512a));
            }
        } else {
            this.f10971q.O(2);
            t0.d systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                ViewDragHelper viewDragHelper2 = this.f10971q;
                viewDragHelper2.N(Math.max(viewDragHelper2.x(), systemGestureInsets2.f16514c));
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f10960f && !layoutParams.f10983b && this.f10961g != null) {
            canvas.getClipBounds(this.f10974t);
            if (l()) {
                Rect rect = this.f10974t;
                rect.left = Math.max(rect.left, this.f10961g.getRight());
            } else {
                Rect rect2 = this.f10974t;
                rect2.right = Math.min(rect2.right, this.f10961g.getLeft());
            }
            canvas.clipRect(this.f10974t);
        }
        boolean drawChild = super.drawChild(canvas, view, j11);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public void e(View view) {
        for (e a11 : this.f10969o) {
            a11.a(view);
        }
        sendAccessibilityEvent(32);
    }

    public void f(View view) {
        for (e c11 : this.f10969o) {
            c11.c(view, this.f10962h);
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.f10957c;
    }

    public final int getLockMode() {
        return this.f10976v;
    }

    public int getParallaxDistance() {
        return this.f10966l;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.f10956b;
    }

    public void j(View view) {
        Field field;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 17) {
            h0.L0(view, ((LayoutParams) view.getLayoutParams()).f10985d);
            return;
        }
        if (i11 >= 16) {
            if (!this.B) {
                try {
                    this.f10980z = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e11) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e11);
                }
                try {
                    Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                    this.A = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e12) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e12);
                }
                this.B = true;
            }
            if (this.f10980z == null || (field = this.A) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.f10980z.invoke(view, (Object[]) null);
            } catch (Exception e13) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e13);
            }
        }
        h0.o0(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public boolean k(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.f10960f || !layoutParams.f10984c || this.f10962h <= 0.0f) {
            return false;
        }
        return true;
    }

    public boolean l() {
        return h0.F(this) == 1;
    }

    public boolean m() {
        return !this.f10960f || this.f10962h == 0.0f;
    }

    public boolean n() {
        return this.f10960f;
    }

    public void onAttachedToWindow() {
        Activity g11;
        super.onAttachedToWindow();
        this.f10973s = true;
        if (this.f10979y != null && (g11 = g(getContext())) != null) {
            this.f10979y.e(g11);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10973s = true;
        FoldingFeatureObserver foldingFeatureObserver = this.f10979y;
        if (foldingFeatureObserver != null) {
            foldingFeatureObserver.g();
        }
        int size = this.f10975u.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f10975u.get(i11).run();
        }
        this.f10975u.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f10960f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f10972r = this.f10971q.G(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f10960f || (this.f10965k && actionMasked != 0)) {
            this.f10971q.b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f10971q.b();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f10965k = false;
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                this.f10967m = x11;
                this.f10968n = y11;
                if (this.f10971q.G(this.f10961g, (int) x11, (int) y11) && k(this.f10961g)) {
                    z11 = true;
                    if (this.f10971q.R(motionEvent) && !z11) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x12 = motionEvent.getX();
                float y12 = motionEvent.getY();
                float abs = Math.abs(x12 - this.f10967m);
                float abs2 = Math.abs(y12 - this.f10968n);
                if (abs > ((float) this.f10971q.B()) && abs2 > abs) {
                    this.f10971q.b();
                    this.f10965k = true;
                    return false;
                }
            }
            z11 = false;
            return this.f10971q.R(motionEvent) ? true : true;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean l11 = l();
        int i21 = i13 - i11;
        int paddingRight = l11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = l11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f10973s) {
            this.f10962h = (!this.f10960f || !this.f10972r) ? 1.0f : 0.0f;
        }
        int i22 = paddingRight;
        int i23 = 0;
        while (i23 < childCount) {
            View childAt = getChildAt(i23);
            if (childAt.getVisibility() == 8) {
                i15 = i22;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f10983b) {
                    int i24 = i21 - paddingLeft;
                    int min = (Math.min(paddingRight, i24) - i22) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f10964j = min;
                    int i25 = l11 ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f10984c = ((i22 + i25) + min) + (measuredWidth / 2) > i24;
                    int i26 = (int) (((float) min) * this.f10962h);
                    this.f10962h = ((float) i26) / ((float) min);
                    i15 = i22 + i25 + i26;
                    i16 = 0;
                } else if (!this.f10960f || (i19 = this.f10966l) == 0) {
                    i15 = paddingRight;
                    i16 = 0;
                } else {
                    i16 = (int) ((1.0f - this.f10962h) * ((float) i19));
                    i15 = paddingRight;
                }
                if (l11) {
                    i17 = (i21 - i15) + i16;
                    i18 = i17 - measuredWidth;
                } else {
                    i18 = i15 - i16;
                    i17 = i18 + measuredWidth;
                }
                childAt.layout(i18, paddingTop, i17, childAt.getMeasuredHeight() + paddingTop);
                j jVar = this.f10977w;
                paddingRight += childAt.getWidth() + Math.abs((jVar == null || jVar.c() != j.b.f12124c || !this.f10977w.b()) ? 0 : this.f10977w.a().width());
            }
            i23++;
            i22 = i15;
        }
        if (this.f10973s) {
            if (this.f10960f && this.f10966l != 0) {
                s(this.f10962h);
            }
            x(this.f10961g);
        }
        this.f10973s = false;
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21 = i12;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        boolean z11 = false;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                i14 = 0;
            } else {
                i14 = (size2 - getPaddingTop()) - getPaddingBottom();
            }
            i13 = i14;
        } else {
            i13 = (size2 - getPaddingTop()) - getPaddingBottom();
            i14 = 0;
        }
        int max = Math.max((size - getPaddingLeft()) - getPaddingRight(), 0);
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f10961g = null;
        int i22 = 0;
        boolean z12 = false;
        int i23 = max;
        float f11 = 0.0f;
        while (true) {
            i15 = 8;
            if (i22 >= childCount) {
                break;
            }
            View childAt = getChildAt(i22);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i24 = size;
            if (childAt.getVisibility() == 8) {
                layoutParams.f10984c = z11;
            } else {
                float f12 = layoutParams.f10982a;
                if (f12 > 0.0f) {
                    f11 += f12;
                    if (layoutParams.width == 0) {
                    }
                }
                int max2 = Math.max(max - (layoutParams.leftMargin + layoutParams.rightMargin), z11 ? 1 : 0);
                int i25 = layoutParams.width;
                if (i25 == -2) {
                    i19 = View.MeasureSpec.makeMeasureSpec(max2, mode == 0 ? mode : Integer.MIN_VALUE);
                } else if (i25 == -1) {
                    i19 = View.MeasureSpec.makeMeasureSpec(max2, mode);
                } else {
                    i19 = View.MeasureSpec.makeMeasureSpec(i25, 1073741824);
                }
                childAt.measure(i19, ViewGroup.getChildMeasureSpec(i21, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i14) {
                    if (mode2 == Integer.MIN_VALUE) {
                        i14 = Math.min(measuredHeight, i13);
                    } else if (mode2 == 0) {
                        i14 = measuredHeight;
                    }
                }
                i23 -= measuredWidth;
                if (i22 != 0) {
                    boolean z13 = i23 < 0;
                    layoutParams.f10983b = z13;
                    z12 |= z13;
                    if (z13) {
                        this.f10961g = childAt;
                    }
                }
            }
            i22++;
            size = i24;
            z11 = false;
        }
        int i26 = size;
        int i27 = i23;
        if (z12 || f11 > 0.0f) {
            int i28 = 0;
            while (i28 < childCount) {
                View childAt2 = getChildAt(i28);
                if (childAt2.getVisibility() != i15) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (layoutParams2.width == 0 && layoutParams2.f10982a > 0.0f) {
                        i16 = 0;
                    } else {
                        i16 = childAt2.getMeasuredWidth();
                    }
                    if (z12) {
                        i17 = max - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                        i18 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                    } else if (layoutParams2.f10982a > 0.0f) {
                        i17 = i16 + ((int) ((layoutParams2.f10982a * ((float) Math.max(0, i27))) / f11));
                        i18 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                    } else {
                        i17 = i16;
                        i18 = 0;
                    }
                    int o11 = o(childAt2, i21, getPaddingTop() + getPaddingBottom());
                    if (i16 != i17) {
                        childAt2.measure(i18, o11);
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        if (measuredHeight2 > i14) {
                            if (mode2 == Integer.MIN_VALUE) {
                                measuredHeight2 = Math.min(measuredHeight2, i13);
                            } else if (mode2 != 0) {
                            }
                            i14 = measuredHeight2;
                        }
                    }
                }
                i28++;
                i15 = 8;
            }
        }
        ArrayList<Rect> w11 = w();
        if (w11 != null && !z12) {
            for (int i29 = 0; i29 < childCount; i29++) {
                View childAt3 = getChildAt(i29);
                if (childAt3.getVisibility() != 8) {
                    Rect rect = w11.get(i29);
                    LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                    int i30 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), 1073741824);
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE), makeMeasureSpec);
                    if ((childAt3.getMeasuredWidthAndState() & 16777216) == 1 || (i(childAt3) != 0 && rect.width() < i(childAt3))) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(max - i30, 1073741824), makeMeasureSpec);
                        if (i29 != 0) {
                            layoutParams3.f10983b = true;
                            this.f10961g = childAt3;
                            z12 = true;
                        }
                    } else {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), makeMeasureSpec);
                    }
                }
            }
        }
        setMeasuredDimension(i26, i14 + getPaddingTop() + getPaddingBottom());
        this.f10960f = z12;
        if (this.f10971q.C() != 0 && !z12) {
            this.f10971q.a();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            q();
        } else {
            b();
        }
        this.f10972r = savedState.isOpen;
        setLockMode(savedState.mLockMode);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = n() ? m() : this.f10972r;
        savedState.mLockMode = this.f10976v;
        return savedState;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13) {
            this.f10973s = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f10960f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f10971q.H(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f10967m = x11;
            this.f10968n = y11;
        } else if (actionMasked == 1 && k(this.f10961g)) {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            float f11 = x12 - this.f10967m;
            float f12 = y12 - this.f10968n;
            int B2 = this.f10971q.B();
            if ((f11 * f11) + (f12 * f12) < ((float) (B2 * B2)) && this.f10971q.G(this.f10961g, (int) x12, (int) y12)) {
                c(0);
            }
        }
        return true;
    }

    public void p(int i11) {
        if (this.f10961g == null) {
            this.f10962h = 0.0f;
            return;
        }
        boolean l11 = l();
        LayoutParams layoutParams = (LayoutParams) this.f10961g.getLayoutParams();
        int width = this.f10961g.getWidth();
        if (l11) {
            i11 = (getWidth() - i11) - width;
        }
        float paddingRight = ((float) (i11 - ((l11 ? getPaddingRight() : getPaddingLeft()) + (l11 ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.f10964j);
        this.f10962h = paddingRight;
        if (this.f10966l != 0) {
            s(paddingRight);
        }
        f(this.f10961g);
    }

    public boolean q() {
        return r(0);
    }

    public final boolean r(int i11) {
        if (!this.f10960f) {
            this.f10972r = true;
        }
        if (!this.f10973s && !v(0.0f, i11)) {
            return false;
        }
        this.f10972r = true;
        return true;
    }

    public void removeView(View view) {
        if (view.getParent() instanceof TouchBlocker) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f10960f) {
            this.f10972r = view == this.f10961g;
        }
    }

    public final void s(float f11) {
        boolean l11 = l();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != this.f10961g) {
                int i12 = this.f10966l;
                this.f10963i = f11;
                int i13 = ((int) ((1.0f - this.f10963i) * ((float) i12))) - ((int) ((1.0f - f11) * ((float) i12)));
                if (l11) {
                    i13 = -i13;
                }
                childAt.offsetLeftAndRight(i13);
            }
        }
    }

    @Deprecated
    public void setCoveredFadeColor(int i11) {
        this.f10957c = i11;
    }

    public final void setLockMode(int i11) {
        this.f10976v = i11;
    }

    @Deprecated
    public void setPanelSlideListener(e eVar) {
        e eVar2 = this.f10970p;
        if (eVar2 != null) {
            t(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.f10970p = eVar;
    }

    public void setParallaxDistance(int i11) {
        this.f10966l = i11;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f10958d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f10959e = drawable;
    }

    @Deprecated
    public void setShadowResource(int i11) {
        setShadowDrawableLeft(getResources().getDrawable(i11));
    }

    public void setShadowResourceLeft(int i11) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i11));
    }

    public void setShadowResourceRight(int i11) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i11));
    }

    @Deprecated
    public void setSliderFadeColor(int i11) {
        this.f10956b = i11;
    }

    public void t(e eVar) {
        this.f10969o.remove(eVar);
    }

    public void u() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public boolean v(float f11, int i11) {
        int i12;
        if (!this.f10960f) {
            return false;
        }
        boolean l11 = l();
        LayoutParams layoutParams = (LayoutParams) this.f10961g.getLayoutParams();
        if (l11) {
            i12 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f11 * ((float) this.f10964j))) + ((float) this.f10961g.getWidth())));
        } else {
            i12 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f11 * ((float) this.f10964j)));
        }
        ViewDragHelper viewDragHelper = this.f10971q;
        View view = this.f10961g;
        if (!viewDragHelper.S(view, i12, view.getTop())) {
            return false;
        }
        u();
        h0.n0(this);
        return true;
    }

    public final ArrayList<Rect> w() {
        Rect h11;
        j jVar = this.f10977w;
        if (jVar == null || !jVar.b() || this.f10977w.a().left == 0 || this.f10977w.a().top != 0 || (h11 = h(this.f10977w, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), h11.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList<>(Arrays.asList(new Rect[]{rect, new Rect(Math.min(width, h11.right), getPaddingTop(), width, getHeight() - getPaddingBottom())}));
    }

    public void x(View view) {
        int i11;
        int i12;
        int i13;
        int i14;
        View childAt;
        boolean z11;
        View view2 = view;
        boolean l11 = l();
        int width = l11 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = l11 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !y(view)) {
            i14 = 0;
            i13 = 0;
            i12 = 0;
            i11 = 0;
        } else {
            i14 = view.getLeft();
            i13 = view.getRight();
            i12 = view.getTop();
            i11 = view.getBottom();
        }
        int childCount = getChildCount();
        int i15 = 0;
        while (true) {
            if (i15 < childCount && (childAt = getChildAt(i15)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z11 = l11;
                } else {
                    z11 = l11;
                    childAt.setVisibility((Math.max(l11 ? paddingLeft : width, childAt.getLeft()) < i14 || Math.max(paddingTop, childAt.getTop()) < i12 || Math.min(l11 ? width : paddingLeft, childAt.getRight()) > i13 || Math.min(height, childAt.getBottom()) > i11) ? 0 : 4);
                }
                i15++;
                view2 = view;
                l11 = z11;
            } else {
                return;
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e  reason: collision with root package name */
        public static final int[] f10981e = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f10982a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10983b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10984c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f10985d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f10981e);
            this.f10982a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f10956b = 0;
        this.f10962h = 1.0f;
        this.f10969o = new CopyOnWriteArrayList();
        this.f10973s = true;
        this.f10974t = new Rect();
        this.f10975u = new ArrayList<>();
        this.f10978x = new a();
        float f11 = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        h0.x0(this, new b());
        h0.I0(this, 1);
        ViewDragHelper o11 = ViewDragHelper.o(this, 0.5f, new d());
        this.f10971q = o11;
        o11.P(f11 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(o.a(context), ContextCompat.getMainExecutor(context)));
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
