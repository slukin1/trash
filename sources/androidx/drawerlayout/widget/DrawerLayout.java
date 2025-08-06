package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.h0;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    public static final int[] M = {16843828};
    public static final int[] N = {16842931};
    public static final boolean O;
    public static final boolean P;
    public static boolean Q;
    public CharSequence A;
    public CharSequence B;
    public Object C;
    public boolean D;
    public Drawable E;
    public Drawable F;
    public Drawable G;
    public Drawable H;
    public final ArrayList<View> I;
    public Rect J;
    public Matrix K;
    public final AccessibilityViewCommand L;

    /* renamed from: b  reason: collision with root package name */
    public final d f9275b;

    /* renamed from: c  reason: collision with root package name */
    public float f9276c;

    /* renamed from: d  reason: collision with root package name */
    public int f9277d;

    /* renamed from: e  reason: collision with root package name */
    public int f9278e;

    /* renamed from: f  reason: collision with root package name */
    public float f9279f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f9280g;

    /* renamed from: h  reason: collision with root package name */
    public final ViewDragHelper f9281h;

    /* renamed from: i  reason: collision with root package name */
    public final ViewDragHelper f9282i;

    /* renamed from: j  reason: collision with root package name */
    public final f f9283j;

    /* renamed from: k  reason: collision with root package name */
    public final f f9284k;

    /* renamed from: l  reason: collision with root package name */
    public int f9285l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f9286m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f9287n;

    /* renamed from: o  reason: collision with root package name */
    public int f9288o;

    /* renamed from: p  reason: collision with root package name */
    public int f9289p;

    /* renamed from: q  reason: collision with root package name */
    public int f9290q;

    /* renamed from: r  reason: collision with root package name */
    public int f9291r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f9292s;

    /* renamed from: t  reason: collision with root package name */
    public e f9293t;

    /* renamed from: u  reason: collision with root package name */
    public List<e> f9294u;

    /* renamed from: v  reason: collision with root package name */
    public float f9295v;

    /* renamed from: w  reason: collision with root package name */
    public float f9296w;

    /* renamed from: x  reason: collision with root package name */
    public Drawable f9297x;

    /* renamed from: y  reason: collision with root package name */
    public Drawable f9298y;

    /* renamed from: z  reason: collision with root package name */
    public Drawable f9299z;

    public static abstract class SimpleDrawerListener implements e {
        public void a(View view) {
        }

        public void b(View view) {
        }

        public void c(int i11) {
        }

        public void d(View view, float f11) {
        }
    }

    public class a implements AccessibilityViewCommand {
        public a() {
        }

        public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            if (!DrawerLayout.this.A(view) || DrawerLayout.this.p(view) == 2) {
                return false;
            }
            DrawerLayout.this.d(view);
            return true;
        }
    }

    public class b implements View.OnApplyWindowInsetsListener {
        public b() {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).M(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public class c extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f9306a = new Rect();

        public c() {
        }

        public final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (DrawerLayout.y(childAt)) {
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        public final void b(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f9306a;
            accessibilityNodeInfoCompat2.n(rect);
            accessibilityNodeInfoCompat.k0(rect);
            accessibilityNodeInfoCompat.S0(accessibilityNodeInfoCompat2.Z());
            accessibilityNodeInfoCompat.D0(accessibilityNodeInfoCompat2.z());
            accessibilityNodeInfoCompat.o0(accessibilityNodeInfoCompat2.q());
            accessibilityNodeInfoCompat.s0(accessibilityNodeInfoCompat2.t());
            accessibilityNodeInfoCompat.u0(accessibilityNodeInfoCompat2.O());
            accessibilityNodeInfoCompat.x0(accessibilityNodeInfoCompat2.Q());
            accessibilityNodeInfoCompat.h0(accessibilityNodeInfoCompat2.J());
            accessibilityNodeInfoCompat.L0(accessibilityNodeInfoCompat2.W());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.k());
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence q11;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View n11 = DrawerLayout.this.n();
            if (n11 == null || (q11 = DrawerLayout.this.q(DrawerLayout.this.r(n11))) == null) {
                return true;
            }
            text.add(q11);
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.O) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat c02 = AccessibilityNodeInfoCompat.c0(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, c02);
                accessibilityNodeInfoCompat.N0(view);
                ViewParent M = h0.M(view);
                if (M instanceof View) {
                    accessibilityNodeInfoCompat.F0((View) M);
                }
                b(accessibilityNodeInfoCompat, c02);
                c02.e0();
                a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.o0("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfoCompat.w0(false);
            accessibilityNodeInfoCompat.x0(false);
            accessibilityNodeInfoCompat.f0(AccessibilityNodeInfoCompat.a.f8535e);
            accessibilityNodeInfoCompat.f0(AccessibilityNodeInfoCompat.a.f8536f);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.O || DrawerLayout.y(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public static final class d extends AccessibilityDelegateCompat {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.y(view)) {
                accessibilityNodeInfoCompat.F0((View) null);
            }
        }
    }

    public interface e {
        void a(View view);

        void b(View view);

        void c(int i11);

        void d(View view, float f11);
    }

    public class f extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final int f9308a;

        /* renamed from: b  reason: collision with root package name */
        public ViewDragHelper f9309b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f9310c = new a();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                f.this.b();
            }
        }

        public f(int i11) {
            this.f9308a = i11;
        }

        public final void a() {
            int i11 = 3;
            if (this.f9308a == 3) {
                i11 = 5;
            }
            View l11 = DrawerLayout.this.l(i11);
            if (l11 != null) {
                DrawerLayout.this.d(l11);
            }
        }

        public void b() {
            View view;
            int i11;
            int y11 = this.f9309b.y();
            int i12 = 0;
            boolean z11 = this.f9308a == 3;
            if (z11) {
                view = DrawerLayout.this.l(3);
                if (view != null) {
                    i12 = -view.getWidth();
                }
                i11 = i12 + y11;
            } else {
                view = DrawerLayout.this.l(5);
                i11 = DrawerLayout.this.getWidth() - y11;
            }
            if (view == null) {
                return;
            }
            if (((z11 && view.getLeft() < i11) || (!z11 && view.getLeft() > i11)) && DrawerLayout.this.p(view) == 0) {
                this.f9309b.S(view, i11, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f9302c = true;
                DrawerLayout.this.invalidate();
                a();
                DrawerLayout.this.b();
            }
        }

        public void c() {
            DrawerLayout.this.removeCallbacks(this.f9310c);
        }

        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i11, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i11, width));
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        public void d(ViewDragHelper viewDragHelper) {
            this.f9309b = viewDragHelper;
        }

        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void onEdgeDragStarted(int i11, int i12) {
            View view;
            if ((i11 & 1) == 1) {
                view = DrawerLayout.this.l(3);
            } else {
                view = DrawerLayout.this.l(5);
            }
            if (view != null && DrawerLayout.this.p(view) == 0) {
                this.f9309b.c(view, i12);
            }
        }

        public boolean onEdgeLock(int i11) {
            return false;
        }

        public void onEdgeTouched(int i11, int i12) {
            DrawerLayout.this.postDelayed(this.f9310c, 160);
        }

        public void onViewCaptured(View view, int i11) {
            ((LayoutParams) view.getLayoutParams()).f9302c = false;
            a();
        }

        public void onViewDragStateChanged(int i11) {
            DrawerLayout.this.R(i11, this.f9309b.w());
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            float f11;
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                f11 = (float) (i11 + width);
            } else {
                f11 = (float) (DrawerLayout.this.getWidth() - i11);
            }
            float f12 = f11 / ((float) width);
            DrawerLayout.this.O(view, f12);
            view.setVisibility(f12 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f11, float f12) {
            int i11;
            float s11 = DrawerLayout.this.s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                int i12 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
                i11 = (i12 > 0 || (i12 == 0 && s11 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f11 < 0.0f || (f11 == 0.0f && s11 > 0.5f)) {
                    width2 -= width;
                }
                i11 = width2;
            }
            this.f9309b.Q(i11, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i11) {
            return DrawerLayout.this.B(view) && DrawerLayout.this.c(view, this.f9308a) && DrawerLayout.this.p(view) == 0;
        }
    }

    static {
        boolean z11 = true;
        int i11 = Build.VERSION.SDK_INT;
        O = i11 >= 19;
        P = i11 >= 21;
        if (i11 < 29) {
            z11 = false;
        }
        Q = z11;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.drawerLayoutStyle);
    }

    public static String u(int i11) {
        if ((i11 & 3) == 3) {
            return "LEFT";
        }
        return (i11 & 5) == 5 ? "RIGHT" : Integer.toHexString(i11);
    }

    public static boolean v(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public static boolean y(View view) {
        return (h0.D(view) == 4 || h0.D(view) == 2) ? false : true;
    }

    public boolean A(View view) {
        if (B(view)) {
            return (((LayoutParams) view.getLayoutParams()).f9303d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean B(View view) {
        int b11 = androidx.core.view.f.b(((LayoutParams) view.getLayoutParams()).f9300a, h0.F(view));
        return ((b11 & 3) == 0 && (b11 & 5) == 0) ? false : true;
    }

    public boolean C(View view) {
        if (B(view)) {
            return ((LayoutParams) view.getLayoutParams()).f9301b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final boolean D(float f11, float f12, View view) {
        if (this.J == null) {
            this.J = new Rect();
        }
        view.getHitRect(this.J);
        return this.J.contains((int) f11, (int) f12);
    }

    public final void E(Drawable drawable, int i11) {
        if (drawable != null && u0.a.h(drawable)) {
            u0.a.m(drawable, i11);
        }
    }

    public void F(View view, float f11) {
        float s11 = s(view);
        float width = (float) view.getWidth();
        int i11 = ((int) (width * f11)) - ((int) (s11 * width));
        if (!c(view, 3)) {
            i11 = -i11;
        }
        view.offsetLeftAndRight(i11);
        O(view, f11);
    }

    public void G(View view) {
        H(view, true);
    }

    public void H(View view, boolean z11) {
        if (B(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f9287n) {
                layoutParams.f9301b = 1.0f;
                layoutParams.f9303d = 1;
                Q(view, true);
                P(view);
            } else if (z11) {
                layoutParams.f9303d |= 2;
                if (c(view, 3)) {
                    this.f9281h.S(view, 0, view.getTop());
                } else {
                    this.f9282i.S(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                F(view, 1.0f);
                R(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void I(e eVar) {
        List<e> list;
        if (eVar != null && (list = this.f9294u) != null) {
            list.remove(eVar);
        }
    }

    public final Drawable J() {
        int F2 = h0.F(this);
        if (F2 == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                E(drawable, F2);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                E(drawable2, F2);
                return this.F;
            }
        }
        return this.G;
    }

    public final Drawable K() {
        int F2 = h0.F(this);
        if (F2 == 0) {
            Drawable drawable = this.F;
            if (drawable != null) {
                E(drawable, F2);
                return this.F;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                E(drawable2, F2);
                return this.E;
            }
        }
        return this.H;
    }

    public final void L() {
        if (!P) {
            this.f9298y = J();
            this.f9299z = K();
        }
    }

    public void M(Object obj, boolean z11) {
        this.C = obj;
        this.D = z11;
        setWillNotDraw(!z11 && getBackground() == null);
        requestLayout();
    }

    public void N(int i11, int i12) {
        View l11;
        int b11 = androidx.core.view.f.b(i12, h0.F(this));
        if (i12 == 3) {
            this.f9288o = i11;
        } else if (i12 == 5) {
            this.f9289p = i11;
        } else if (i12 == 8388611) {
            this.f9290q = i11;
        } else if (i12 == 8388613) {
            this.f9291r = i11;
        }
        if (i11 != 0) {
            (b11 == 3 ? this.f9281h : this.f9282i).b();
        }
        if (i11 == 1) {
            View l12 = l(b11);
            if (l12 != null) {
                d(l12);
            }
        } else if (i11 == 2 && (l11 = l(b11)) != null) {
            G(l11);
        }
    }

    public void O(View view, float f11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f11 != layoutParams.f9301b) {
            layoutParams.f9301b = f11;
            j(view, f11);
        }
    }

    public final void P(View view) {
        AccessibilityNodeInfoCompat.a aVar = AccessibilityNodeInfoCompat.a.f8555y;
        h0.r0(view, aVar.b());
        if (A(view) && p(view) != 2) {
            h0.t0(view, aVar, (CharSequence) null, this.L);
        }
    }

    public final void Q(View view, boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((z11 || B(childAt)) && (!z11 || childAt != view)) {
                h0.I0(childAt, 4);
            } else {
                h0.I0(childAt, 1);
            }
        }
    }

    public void R(int i11, View view) {
        int C2 = this.f9281h.C();
        int C3 = this.f9282i.C();
        int i12 = 2;
        if (C2 == 1 || C3 == 1) {
            i12 = 1;
        } else if (!(C2 == 2 || C3 == 2)) {
            i12 = 0;
        }
        if (view != null && i11 == 0) {
            float f11 = ((LayoutParams) view.getLayoutParams()).f9301b;
            if (f11 == 0.0f) {
                h(view);
            } else if (f11 == 1.0f) {
                i(view);
            }
        }
        if (i12 != this.f9285l) {
            this.f9285l = i12;
            List<e> list = this.f9294u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f9294u.get(size).c(i12);
                }
            }
        }
    }

    public void a(e eVar) {
        if (eVar != null) {
            if (this.f9294u == null) {
                this.f9294u = new ArrayList();
            }
            this.f9294u.add(eVar);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z11 = false;
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (!B(childAt)) {
                    this.I.add(childAt);
                } else if (A(childAt)) {
                    childAt.addFocusables(arrayList, i11, i12);
                    z11 = true;
                }
            }
            if (!z11) {
                int size = this.I.size();
                for (int i14 = 0; i14 < size; i14++) {
                    View view = this.I.get(i14);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i11, i12);
                    }
                }
            }
            this.I.clear();
        }
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (m() != null || B(view)) {
            h0.I0(view, 4);
        } else {
            h0.I0(view, 1);
        }
        if (!O) {
            h0.x0(view, this.f9275b);
        }
    }

    public void b() {
        if (!this.f9292s) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                getChildAt(i11).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f9292s = true;
        }
    }

    public boolean c(View view, int i11) {
        return (r(view) & i11) == i11;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            f11 = Math.max(f11, ((LayoutParams) getChildAt(i11).getLayoutParams()).f9301b);
        }
        this.f9279f = f11;
        boolean n11 = this.f9281h.n(true);
        boolean n12 = this.f9282i.n(true);
        if (n11 || n12) {
            h0.n0(this);
        }
    }

    public void d(View view) {
        e(view, true);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f9279f <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            View childAt = getChildAt(i11);
            if (D(x11, y11, childAt) && !z(childAt) && k(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean z11 = z(view2);
        int width = getWidth();
        int save = canvas.save();
        int i11 = 0;
        if (z11) {
            int childCount = getChildCount();
            int i12 = 0;
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (childAt != view2 && childAt.getVisibility() == 0 && v(childAt) && B(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i12) {
                            i12 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i12, 0, width, getHeight());
            i11 = i12;
        }
        boolean drawChild = super.drawChild(canvas, view, j11);
        canvas.restoreToCount(save);
        float f11 = this.f9279f;
        if (f11 > 0.0f && z11) {
            int i14 = this.f9278e;
            this.f9280g.setColor((i14 & FlexItem.MAX_SIZE) | (((int) (((float) ((-16777216 & i14) >>> 24)) * f11)) << 24));
            canvas.drawRect((float) i11, 0.0f, (float) width, (float) getHeight(), this.f9280g);
        } else if (this.f9298y != null && c(view2, 3)) {
            int intrinsicWidth = this.f9298y.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f9281h.y()), 1.0f));
            this.f9298y.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f9298y.setAlpha((int) (max * 255.0f));
            this.f9298y.draw(canvas);
        } else if (this.f9299z != null && c(view2, 5)) {
            int intrinsicWidth2 = this.f9299z.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.f9282i.y()), 1.0f));
            this.f9299z.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f9299z.setAlpha((int) (max2 * 255.0f));
            this.f9299z.draw(canvas);
        }
        return drawChild;
    }

    public void e(View view, boolean z11) {
        if (B(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f9287n) {
                layoutParams.f9301b = 0.0f;
                layoutParams.f9303d = 0;
            } else if (z11) {
                layoutParams.f9303d |= 4;
                if (c(view, 3)) {
                    this.f9281h.S(view, -view.getWidth(), view.getTop());
                } else {
                    this.f9282i.S(view, getWidth(), view.getTop());
                }
            } else {
                F(view, 0.0f);
                R(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void f() {
        g(false);
    }

    public void g(boolean z11) {
        boolean z12;
        int childCount = getChildCount();
        boolean z13 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (B(childAt) && (!z11 || layoutParams.f9302c)) {
                int width = childAt.getWidth();
                if (c(childAt, 3)) {
                    z12 = this.f9281h.S(childAt, -width, childAt.getTop());
                } else {
                    z12 = this.f9282i.S(childAt, getWidth(), childAt.getTop());
                }
                z13 |= z12;
                layoutParams.f9302c = false;
            }
        }
        this.f9283j.c();
        this.f9284k.c();
        if (z13) {
            invalidate();
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (P) {
            return this.f9276c;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f9297x;
    }

    public void h(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f9303d & 1) == 1) {
            layoutParams.f9303d = 0;
            List<e> list = this.f9294u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f9294u.get(size).b(view);
                }
            }
            Q(view, false);
            P(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    public void i(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f9303d & 1) == 0) {
            layoutParams.f9303d = 1;
            List<e> list = this.f9294u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f9294u.get(size).a(view);
                }
            }
            Q(view, true);
            P(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public void j(View view, float f11) {
        List<e> list = this.f9294u;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f9294u.get(size).d(view, f11);
            }
        }
    }

    public final boolean k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent t11 = t(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(t11);
            t11.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    public View l(int i11) {
        int b11 = androidx.core.view.f.b(i11, h0.F(this)) & 7;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if ((r(childAt) & 7) == b11) {
                return childAt;
            }
        }
        return null;
    }

    public View m() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((((LayoutParams) childAt.getLayoutParams()).f9303d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public View n() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (B(childAt) && C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int o(int i11) {
        int F2 = h0.F(this);
        if (i11 == 3) {
            int i12 = this.f9288o;
            if (i12 != 3) {
                return i12;
            }
            int i13 = F2 == 0 ? this.f9290q : this.f9291r;
            if (i13 != 3) {
                return i13;
            }
            return 0;
        } else if (i11 == 5) {
            int i14 = this.f9289p;
            if (i14 != 3) {
                return i14;
            }
            int i15 = F2 == 0 ? this.f9291r : this.f9290q;
            if (i15 != 3) {
                return i15;
            }
            return 0;
        } else if (i11 == 8388611) {
            int i16 = this.f9290q;
            if (i16 != 3) {
                return i16;
            }
            int i17 = F2 == 0 ? this.f9288o : this.f9289p;
            if (i17 != 3) {
                return i17;
            }
            return 0;
        } else if (i11 != 8388613) {
            return 0;
        } else {
            int i18 = this.f9291r;
            if (i18 != 3) {
                return i18;
            }
            int i19 = F2 == 0 ? this.f9289p : this.f9288o;
            if (i19 != 3) {
                return i19;
            }
            return 0;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9287n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9287n = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r4.C;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            boolean r0 = r4.D
            if (r0 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r4.f9297x
            if (r0 == 0) goto L_0x002e
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x001d
            java.lang.Object r0 = r4.C
            if (r0 == 0) goto L_0x001d
            android.view.WindowInsets r0 = (android.view.WindowInsets) r0
            int r0 = r0.getSystemWindowInsetTop()
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r1 = r4.f9297x
            int r3 = r4.getWidth()
            r1.setBounds(r2, r2, r3, r0)
            android.graphics.drawable.Drawable r0 = r4.f9297x
            r0.draw(r5)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        r7 = r6.f9281h.u((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.f9281h
            boolean r1 = r1.R(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.f9282i
            boolean r2 = r2.R(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0036
        L_0x001e:
            androidx.customview.widget.ViewDragHelper r7 = r6.f9281h
            boolean r7 = r7.e(r4)
            if (r7 == 0) goto L_0x0036
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f9283j
            r7.c()
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f9284k
            r7.c()
            goto L_0x0036
        L_0x0031:
            r6.g(r2)
            r6.f9292s = r3
        L_0x0036:
            r7 = r3
            goto L_0x0060
        L_0x0038:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f9295v = r0
            r6.f9296w = r7
            float r4 = r6.f9279f
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            androidx.customview.widget.ViewDragHelper r4 = r6.f9281h
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.u(r0, r7)
            if (r7 == 0) goto L_0x005d
            boolean r7 = r6.z(r7)
            if (r7 == 0) goto L_0x005d
            r7 = r2
            goto L_0x005e
        L_0x005d:
            r7 = r3
        L_0x005e:
            r6.f9292s = r3
        L_0x0060:
            if (r1 != 0) goto L_0x0070
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.w()
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.f9292s
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || !x()) {
            return super.onKeyDown(i11, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyUp(i11, keyEvent);
        }
        View n11 = n();
        if (n11 != null && p(n11) == 0) {
            f();
        }
        return n11 != null;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        WindowInsets rootWindowInsets;
        float f11;
        int i15;
        boolean z12 = true;
        this.f9286m = true;
        int i16 = i13 - i11;
        int childCount = getChildCount();
        int i17 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z(childAt)) {
                    int i18 = layoutParams.leftMargin;
                    childAt.layout(i18, layoutParams.topMargin, childAt.getMeasuredWidth() + i18, layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f12 = (float) measuredWidth;
                        i15 = (-measuredWidth) + ((int) (layoutParams.f9301b * f12));
                        f11 = ((float) (measuredWidth + i15)) / f12;
                    } else {
                        float f13 = (float) measuredWidth;
                        int i19 = i16 - ((int) (layoutParams.f9301b * f13));
                        f11 = ((float) (i16 - i19)) / f13;
                        i15 = i19;
                    }
                    boolean z13 = f11 != layoutParams.f9301b ? z12 : false;
                    int i21 = layoutParams.f9300a & 112;
                    if (i21 == 16) {
                        int i22 = i14 - i12;
                        int i23 = (i22 - measuredHeight) / 2;
                        int i24 = layoutParams.topMargin;
                        if (i23 < i24) {
                            i23 = i24;
                        } else {
                            int i25 = i23 + measuredHeight;
                            int i26 = layoutParams.bottomMargin;
                            if (i25 > i22 - i26) {
                                i23 = (i22 - i26) - measuredHeight;
                            }
                        }
                        childAt.layout(i15, i23, measuredWidth + i15, measuredHeight + i23);
                    } else if (i21 != 80) {
                        int i27 = layoutParams.topMargin;
                        childAt.layout(i15, i27, measuredWidth + i15, measuredHeight + i27);
                    } else {
                        int i28 = i14 - i12;
                        childAt.layout(i15, (i28 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i15, i28 - layoutParams.bottomMargin);
                    }
                    if (z13) {
                        O(childAt, f11);
                    }
                    int i29 = layoutParams.f9301b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i29) {
                        childAt.setVisibility(i29);
                    }
                }
            }
            i17++;
            z12 = true;
        }
        if (Q && (rootWindowInsets = getRootWindowInsets()) != null) {
            t0.d i30 = WindowInsetsCompat.x(rootWindowInsets).i();
            ViewDragHelper viewDragHelper = this.f9281h;
            viewDragHelper.N(Math.max(viewDragHelper.x(), i30.f16512a));
            ViewDragHelper viewDragHelper2 = this.f9282i;
            viewDragHelper2.N(Math.max(viewDragHelper2.x(), i30.f16514c));
        }
        this.f9286m = false;
        this.f9287n = false;
    }

    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i13 = 0;
        boolean z11 = this.C != null && h0.C(this);
        int F2 = h0.F(this);
        int childCount = getChildCount();
        int i14 = 0;
        boolean z12 = false;
        boolean z13 = false;
        while (i14 < childCount) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z11) {
                    int b11 = androidx.core.view.f.b(layoutParams.f9300a, F2);
                    if (h0.C(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.C;
                            if (b11 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i13, windowInsets.getSystemWindowInsetBottom());
                            } else if (b11 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i13, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.C;
                        if (b11 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i13, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b11 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i13, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (B(childAt)) {
                    if (P) {
                        float z14 = h0.z(childAt);
                        float f11 = this.f9276c;
                        if (z14 != f11) {
                            h0.F0(childAt, f11);
                        }
                    }
                    int r11 = r(childAt) & 7;
                    int i15 = r11 == 3 ? 1 : i13;
                    if ((i15 == 0 || !z12) && (i15 != 0 || !z13)) {
                        if (i15 != 0) {
                            z12 = true;
                        } else {
                            z13 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i11, this.f9277d + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), ViewGroup.getChildMeasureSpec(i12, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                        i14++;
                        i13 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + u(r11) + " but this " + "DrawerLayout" + " already has a drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i14 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i16 = i11;
            int i17 = i12;
            i14++;
            i13 = 0;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        View l11;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i11 = savedState.openDrawerGravity;
        if (!(i11 == 0 || (l11 = l(i11)) == null)) {
            G(l11);
        }
        int i12 = savedState.lockModeLeft;
        if (i12 != 3) {
            N(i12, 3);
        }
        int i13 = savedState.lockModeRight;
        if (i13 != 3) {
            N(i13, 5);
        }
        int i14 = savedState.lockModeStart;
        if (i14 != 3) {
            N(i14, 8388611);
        }
        int i15 = savedState.lockModeEnd;
        if (i15 != 3) {
            N(i15, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i11) {
        L();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i11).getLayoutParams();
            int i12 = layoutParams.f9303d;
            boolean z11 = true;
            boolean z12 = i12 == 1;
            if (i12 != 2) {
                z11 = false;
            }
            if (z12 || z11) {
                savedState.openDrawerGravity = layoutParams.f9300a;
            } else {
                i11++;
            }
        }
        savedState.lockModeLeft = this.f9288o;
        savedState.lockModeRight = this.f9289p;
        savedState.lockModeStart = this.f9290q;
        savedState.lockModeEnd = this.f9291r;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (p(r7) != 2) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.f9281h
            r0.H(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.f9282i
            r0.H(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x005f
            if (r0 == r2) goto L_0x0020
            r7 = 3
            if (r0 == r7) goto L_0x001a
            goto L_0x006d
        L_0x001a:
            r6.g(r2)
            r6.f9292s = r1
            goto L_0x006d
        L_0x0020:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.f9281h
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.u(r4, r5)
            if (r3 == 0) goto L_0x005a
            boolean r3 = r6.z(r3)
            if (r3 == 0) goto L_0x005a
            float r3 = r6.f9295v
            float r0 = r0 - r3
            float r3 = r6.f9296w
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.f9281h
            int r3 = r3.B()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x005a
            android.view.View r7 = r6.m()
            if (r7 == 0) goto L_0x005a
            int r7 = r6.p(r7)
            r0 = 2
            if (r7 != r0) goto L_0x005b
        L_0x005a:
            r1 = r2
        L_0x005b:
            r6.g(r1)
            goto L_0x006d
        L_0x005f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f9295v = r0
            r6.f9296w = r7
            r6.f9292s = r1
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public int p(View view) {
        if (B(view)) {
            return o(((LayoutParams) view.getLayoutParams()).f9300a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence q(int i11) {
        int b11 = androidx.core.view.f.b(i11, h0.F(this));
        if (b11 == 3) {
            return this.A;
        }
        if (b11 == 5) {
            return this.B;
        }
        return null;
    }

    public int r(View view) {
        return androidx.core.view.f.b(((LayoutParams) view.getLayoutParams()).f9300a, h0.F(this));
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        super.requestDisallowInterceptTouchEvent(z11);
        if (z11) {
            g(true);
        }
    }

    public void requestLayout() {
        if (!this.f9286m) {
            super.requestLayout();
        }
    }

    public float s(View view) {
        return ((LayoutParams) view.getLayoutParams()).f9301b;
    }

    public void setDrawerElevation(float f11) {
        this.f9276c = f11;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (B(childAt)) {
                h0.F0(childAt, this.f9276c);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.f9293t;
        if (eVar2 != null) {
            I(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.f9293t = eVar;
    }

    public void setDrawerLockMode(int i11) {
        N(i11, 3);
        N(i11, 5);
    }

    public void setScrimColor(int i11) {
        this.f9278e = i11;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f9297x = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i11) {
        this.f9297x = new ColorDrawable(i11);
        invalidate();
    }

    public final MotionEvent t(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.K == null) {
                this.K = new Matrix();
            }
            matrix.invert(this.K);
            obtain.transform(this.K);
        }
        return obtain;
    }

    public final boolean w() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (((LayoutParams) getChildAt(i11).getLayoutParams()).f9302c) {
                return true;
            }
        }
        return false;
    }

    public final boolean x() {
        return n() != null;
    }

    public boolean z(View view) {
        return ((LayoutParams) view.getLayoutParams()).f9300a == 0;
    }

    /* JADX INFO: finally extract failed */
    public DrawerLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f9275b = new d();
        this.f9278e = -1728053248;
        this.f9280g = new Paint();
        this.f9287n = true;
        this.f9288o = 3;
        this.f9289p = 3;
        this.f9290q = 3;
        this.f9291r = 3;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.L = new a();
        setDescendantFocusability(262144);
        float f11 = getResources().getDisplayMetrics().density;
        this.f9277d = (int) ((64.0f * f11) + 0.5f);
        float f12 = f11 * 400.0f;
        f fVar = new f(3);
        this.f9283j = fVar;
        f fVar2 = new f(5);
        this.f9284k = fVar2;
        ViewDragHelper o11 = ViewDragHelper.o(this, 1.0f, fVar);
        this.f9281h = o11;
        o11.O(1);
        o11.P(f12);
        fVar.d(o11);
        ViewDragHelper o12 = ViewDragHelper.o(this, 1.0f, fVar2);
        this.f9282i = o12;
        o12.O(2);
        o12.P(f12);
        fVar2.d(o12);
        setFocusableInTouchMode(true);
        h0.I0(this, 1);
        h0.x0(this, new c());
        setMotionEventSplittingEnabled(false);
        if (h0.C(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new b());
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(M);
                try {
                    this.f9297x = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.f9297x = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.DrawerLayout, i11, 0);
        try {
            int i12 = R$styleable.DrawerLayout_elevation;
            if (obtainStyledAttributes2.hasValue(i12)) {
                this.f9276c = obtainStyledAttributes2.getDimension(i12, 0.0f);
            } else {
                this.f9276c = getResources().getDimension(R$dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.I = new ArrayList<>();
        } catch (Throwable th2) {
            obtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setStatusBarBackground(int i11) {
        this.f9297x = i11 != 0 ? ContextCompat.getDrawable(getContext(), i11) : null;
        invalidate();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f9300a = 0;

        /* renamed from: b  reason: collision with root package name */
        public float f9301b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9302c;

        /* renamed from: d  reason: collision with root package name */
        public int f9303d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.N);
            this.f9300a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f9300a = layoutParams.f9300a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int lockModeEnd;
        public int lockModeLeft;
        public int lockModeRight;
        public int lockModeStart;
        public int openDrawerGravity = 0;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
