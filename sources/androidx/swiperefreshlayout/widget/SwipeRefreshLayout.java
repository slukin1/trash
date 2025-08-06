package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.core.view.h0;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.r;
import androidx.core.view.s;
import androidx.core.view.t;
import androidx.core.view.u;

public class SwipeRefreshLayout extends ViewGroup implements s, r, o, t, p {
    public static final String R = SwipeRefreshLayout.class.getSimpleName();
    public static final int[] S = {16842766};
    public int A;
    public int B;
    public int C;
    public a D;
    public Animation E;
    public Animation F;
    public Animation G;
    public Animation H;
    public Animation I;
    public boolean J;
    public int K;
    public boolean L;
    public i M;
    public boolean N;
    public Animation.AnimationListener O = new a();
    public final Animation P = new f();
    public final Animation Q = new g();

    /* renamed from: b  reason: collision with root package name */
    public View f10998b;

    /* renamed from: c  reason: collision with root package name */
    public j f10999c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11000d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f11001e;

    /* renamed from: f  reason: collision with root package name */
    public float f11002f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f11003g;

    /* renamed from: h  reason: collision with root package name */
    public final u f11004h;

    /* renamed from: i  reason: collision with root package name */
    public final q f11005i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f11006j = new int[2];

    /* renamed from: k  reason: collision with root package name */
    public final int[] f11007k = new int[2];

    /* renamed from: l  reason: collision with root package name */
    public final int[] f11008l = new int[2];

    /* renamed from: m  reason: collision with root package name */
    public boolean f11009m;

    /* renamed from: n  reason: collision with root package name */
    public int f11010n;

    /* renamed from: o  reason: collision with root package name */
    public int f11011o;

    /* renamed from: p  reason: collision with root package name */
    public float f11012p;

    /* renamed from: q  reason: collision with root package name */
    public float f11013q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f11014r;

    /* renamed from: s  reason: collision with root package name */
    public int f11015s = -1;

    /* renamed from: t  reason: collision with root package name */
    public boolean f11016t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f11017u;

    /* renamed from: v  reason: collision with root package name */
    public final DecelerateInterpolator f11018v;

    /* renamed from: w  reason: collision with root package name */
    public CircleImageView f11019w;

    /* renamed from: x  reason: collision with root package name */
    public int f11020x = -1;

    /* renamed from: y  reason: collision with root package name */
    public int f11021y;

    /* renamed from: z  reason: collision with root package name */
    public float f11022z;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f11000d) {
                swipeRefreshLayout.D.setAlpha(255);
                SwipeRefreshLayout.this.D.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.J && (jVar = swipeRefreshLayout2.f10999c) != null) {
                    jVar.onRefresh();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.f11011o = swipeRefreshLayout3.f11019w.getTop();
                return;
            }
            swipeRefreshLayout.m();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class b extends Animation {
        public b() {
        }

        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f11);
        }
    }

    public class c extends Animation {
        public c() {
        }

        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f11);
        }
    }

    public class d extends Animation {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f11026b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f11027c;

        public d(int i11, int i12) {
            this.f11026b = i11;
            this.f11027c = i12;
        }

        public void applyTransformation(float f11, Transformation transformation) {
            a aVar = SwipeRefreshLayout.this.D;
            int i11 = this.f11026b;
            aVar.setAlpha((int) (((float) i11) + (((float) (this.f11027c - i11)) * f11)));
        }
    }

    public class e implements Animation.AnimationListener {
        public e() {
        }

        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f11016t) {
                swipeRefreshLayout.s((Animation.AnimationListener) null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class f extends Animation {
        public f() {
        }

        public void applyTransformation(float f11, Transformation transformation) {
            int i11;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.L) {
                i11 = swipeRefreshLayout.B - Math.abs(swipeRefreshLayout.A);
            } else {
                i11 = swipeRefreshLayout.B;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i12 = swipeRefreshLayout2.f11021y;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i12 + ((int) (((float) (i11 - i12)) * f11))) - swipeRefreshLayout2.f11019w.getTop());
            SwipeRefreshLayout.this.D.e(1.0f - f11);
        }
    }

    public class g extends Animation {
        public g() {
        }

        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.k(f11);
        }
    }

    public class h extends Animation {
        public h() {
        }

        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f12 = swipeRefreshLayout.f11022z;
            swipeRefreshLayout.setAnimationProgress(f12 + ((-f12) * f11));
            SwipeRefreshLayout.this.k(f11);
        }
    }

    public interface i {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface j {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11001e = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f11010n = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f11018v = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i11 = (int) (displayMetrics.density * 64.0f);
        this.B = i11;
        this.f11002f = (float) i11;
        this.f11004h = new u(this);
        this.f11005i = new q(this);
        setNestedScrollingEnabled(true);
        int i12 = -this.K;
        this.f11011o = i12;
        this.A = i12;
        k(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void setColorViewAlpha(int i11) {
        this.f11019w.getBackground().setAlpha(i11);
        this.D.setAlpha(i11);
    }

    public final void a(int i11, Animation.AnimationListener animationListener) {
        this.f11021y = i11;
        this.P.reset();
        this.P.setDuration(200);
        this.P.setInterpolator(this.f11018v);
        if (animationListener != null) {
            this.f11019w.b(animationListener);
        }
        this.f11019w.clearAnimation();
        this.f11019w.startAnimation(this.P);
    }

    public final void b(int i11, Animation.AnimationListener animationListener) {
        if (this.f11016t) {
            t(i11, animationListener);
            return;
        }
        this.f11021y = i11;
        this.Q.reset();
        this.Q.setDuration(200);
        this.Q.setInterpolator(this.f11018v);
        if (animationListener != null) {
            this.f11019w.b(animationListener);
        }
        this.f11019w.clearAnimation();
        this.f11019w.startAnimation(this.Q);
    }

    public boolean c() {
        i iVar = this.M;
        if (iVar != null) {
            return iVar.a(this, this.f10998b);
        }
        View view = this.f10998b;
        if (view instanceof ListView) {
            return androidx.core.widget.j.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public final void d() {
        this.f11019w = new CircleImageView(getContext());
        a aVar = new a(getContext());
        this.D = aVar;
        aVar.l(1);
        this.f11019w.setImageDrawable(this.D);
        this.f11019w.setVisibility(8);
        addView(this.f11019w);
    }

    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return this.f11005i.a(f11, f12, z11);
    }

    public boolean dispatchNestedPreFling(float f11, float f12) {
        return this.f11005i.b(f11, f12);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return this.f11005i.c(i11, i12, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return this.f11005i.f(i11, i12, i13, i14, iArr);
    }

    public void e(int i11, int i12, int i13, int i14, int[] iArr, int i15, int[] iArr2) {
        if (i15 == 0) {
            this.f11005i.e(i11, i12, i13, i14, iArr, i15, iArr2);
        }
    }

    public final void f() {
        if (this.f10998b == null) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (!childAt.equals(this.f11019w)) {
                    this.f10998b = childAt;
                    return;
                }
            }
        }
    }

    public final void g(float f11) {
        if (f11 > this.f11002f) {
            n(true, true);
            return;
        }
        this.f11000d = false;
        this.D.j(0.0f, 0.0f);
        e eVar = null;
        if (!this.f11016t) {
            eVar = new e();
        }
        b(this.f11011o, eVar);
        this.D.d(false);
    }

    public int getChildDrawingOrder(int i11, int i12) {
        int i13 = this.f11020x;
        if (i13 < 0) {
            return i12;
        }
        if (i12 == i11 - 1) {
            return i13;
        }
        return i12 >= i13 ? i12 + 1 : i12;
    }

    public int getNestedScrollAxes() {
        return this.f11004h.a();
    }

    public int getProgressCircleDiameter() {
        return this.K;
    }

    public int getProgressViewEndOffset() {
        return this.B;
    }

    public int getProgressViewStartOffset() {
        return this.A;
    }

    public final boolean h(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    public boolean hasNestedScrollingParent() {
        return this.f11005i.k();
    }

    public boolean i() {
        return this.f11000d;
    }

    public boolean isNestedScrollingEnabled() {
        return this.f11005i.m();
    }

    public final void j(float f11) {
        this.D.d(true);
        float min = Math.min(1.0f, Math.abs(f11 / this.f11002f));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f11) - this.f11002f;
        int i11 = this.C;
        if (i11 <= 0) {
            if (this.L) {
                i11 = this.B - this.A;
            } else {
                i11 = this.B;
            }
        }
        float f12 = (float) i11;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f12 * 2.0f) / f12) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i12 = this.A + ((int) ((f12 * min) + (f12 * pow * 2.0f)));
        if (this.f11019w.getVisibility() != 0) {
            this.f11019w.setVisibility(0);
        }
        if (!this.f11016t) {
            this.f11019w.setScaleX(1.0f);
            this.f11019w.setScaleY(1.0f);
        }
        if (this.f11016t) {
            setAnimationProgress(Math.min(1.0f, f11 / this.f11002f));
        }
        if (f11 < this.f11002f) {
            if (this.D.getAlpha() > 76 && !h(this.G)) {
                r();
            }
        } else if (this.D.getAlpha() < 255 && !h(this.H)) {
            q();
        }
        this.D.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.D.e(Math.min(1.0f, max));
        this.D.g((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i12 - this.f11011o);
    }

    public void k(float f11) {
        int i11 = this.f11021y;
        setTargetOffsetTopAndBottom((i11 + ((int) (((float) (this.A - i11)) * f11))) - this.f11019w.getTop());
    }

    public final void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f11015s) {
            this.f11015s = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public void m() {
        this.f11019w.clearAnimation();
        this.D.stop();
        this.f11019w.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f11016t) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.A - this.f11011o);
        }
        this.f11011o = this.f11019w.getTop();
    }

    public final void n(boolean z11, boolean z12) {
        if (this.f11000d != z11) {
            this.J = z12;
            f();
            this.f11000d = z11;
            if (z11) {
                a(this.f11011o, this.O);
            } else {
                s(this.O);
            }
        }
    }

    public final Animation o(int i11, int i12) {
        d dVar = new d(i11, i12);
        dVar.setDuration(300);
        this.f11019w.b((Animation.AnimationListener) null);
        this.f11019w.clearAnimation();
        this.f11019w.startAnimation(dVar);
        return dVar;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f11017u && actionMasked == 0) {
            this.f11017u = false;
        }
        if (!isEnabled() || this.f11017u || c() || this.f11000d || this.f11009m) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i11 = this.f11015s;
                    if (i11 == -1) {
                        Log.e(R, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i11);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    p(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        l(motionEvent);
                    }
                }
            }
            this.f11014r = false;
            this.f11015s = -1;
        } else {
            setTargetOffsetTopAndBottom(this.A - this.f11019w.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f11015s = pointerId;
            this.f11014r = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f11013q = motionEvent.getY(findPointerIndex2);
        }
        return this.f11014r;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f10998b == null) {
                f();
            }
            View view = this.f10998b;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f11019w.getMeasuredWidth();
                int measuredHeight2 = this.f11019w.getMeasuredHeight();
                int i15 = measuredWidth / 2;
                int i16 = measuredWidth2 / 2;
                int i17 = this.f11011o;
                this.f11019w.layout(i15 - i16, i17, i15 + i16, measuredHeight2 + i17);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f10998b == null) {
            f();
        }
        View view = this.f10998b;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f11019w.measure(View.MeasureSpec.makeMeasureSpec(this.K, 1073741824), View.MeasureSpec.makeMeasureSpec(this.K, 1073741824));
            this.f11020x = -1;
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                if (getChildAt(i13) == this.f11019w) {
                    this.f11020x = i13;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        return dispatchNestedFling(f11, f12, z11);
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        return dispatchNestedPreFling(f11, f12);
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 0) {
            onNestedPreScroll(view, i11, i12, iArr);
        }
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        if (i15 == 0) {
            int i16 = iArr[1];
            e(i11, i12, i13, i14, this.f11007k, i15, iArr);
            int i17 = i14 - (iArr[1] - i16);
            int i18 = i17 == 0 ? i14 + this.f11007k[1] : i17;
            if (i18 < 0 && !c()) {
                float abs = this.f11003g + ((float) Math.abs(i18));
                this.f11003g = abs;
                j(abs);
                iArr[1] = iArr[1] + i17;
            }
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            onNestedScrollAccepted(view, view2, i11);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.mRefreshing);
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f11000d);
    }

    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            return onStartNestedScroll(view, view2, i11);
        }
        return false;
    }

    public void onStopNestedScroll(View view, int i11) {
        if (i11 == 0) {
            onStopNestedScroll(view);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f11017u && actionMasked == 0) {
            this.f11017u = false;
        }
        if (!isEnabled() || this.f11017u || c() || this.f11000d || this.f11009m) {
            return false;
        }
        if (actionMasked == 0) {
            this.f11015s = motionEvent.getPointerId(0);
            this.f11014r = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f11015s);
            if (findPointerIndex < 0) {
                Log.e(R, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.f11014r) {
                this.f11014r = false;
                g((motionEvent.getY(findPointerIndex) - this.f11012p) * 0.5f);
            }
            this.f11015s = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.f11015s);
            if (findPointerIndex2 < 0) {
                Log.e(R, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y11 = motionEvent.getY(findPointerIndex2);
            p(y11);
            if (this.f11014r) {
                float f11 = (y11 - this.f11012p) * 0.5f;
                if (f11 <= 0.0f) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                j(f11);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(R, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f11015s = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                l(motionEvent);
            }
        }
        return true;
    }

    public final void p(float f11) {
        float f12 = this.f11013q;
        int i11 = this.f11001e;
        if (f11 - f12 > ((float) i11) && !this.f11014r) {
            this.f11012p = f12 + ((float) i11);
            this.f11014r = true;
            this.D.setAlpha(76);
        }
    }

    public final void q() {
        this.H = o(this.D.getAlpha(), 255);
    }

    public final void r() {
        this.G = o(this.D.getAlpha(), 76);
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        ViewParent parent;
        View view;
        if ((Build.VERSION.SDK_INT >= 21 || !(this.f10998b instanceof AbsListView)) && ((view = this.f10998b) == null || h0.b0(view))) {
            super.requestDisallowInterceptTouchEvent(z11);
        } else if (!this.N && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    public void s(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.F = cVar;
        cVar.setDuration(150);
        this.f11019w.b(animationListener);
        this.f11019w.clearAnimation();
        this.f11019w.startAnimation(this.F);
    }

    public void setAnimationProgress(float f11) {
        this.f11019w.setScaleX(f11);
        this.f11019w.setScaleY(f11);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        f();
        this.D.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr2[i11] = ContextCompat.getColor(context, iArr[i11]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i11) {
        this.f11002f = (float) i11;
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        if (!z11) {
            m();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z11) {
        this.N = z11;
    }

    public void setNestedScrollingEnabled(boolean z11) {
        this.f11005i.n(z11);
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.M = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.f10999c = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i11) {
        setProgressBackgroundColorSchemeResource(i11);
    }

    public void setProgressBackgroundColorSchemeColor(int i11) {
        this.f11019w.setBackgroundColor(i11);
    }

    public void setProgressBackgroundColorSchemeResource(int i11) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i11));
    }

    public void setRefreshing(boolean z11) {
        int i11;
        if (!z11 || this.f11000d == z11) {
            n(z11, false);
            return;
        }
        this.f11000d = z11;
        if (!this.L) {
            i11 = this.B + this.A;
        } else {
            i11 = this.B;
        }
        setTargetOffsetTopAndBottom(i11 - this.f11011o);
        this.J = false;
        u(this.O);
    }

    public void setSize(int i11) {
        if (i11 == 0 || i11 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i11 == 0) {
                this.K = (int) (displayMetrics.density * 56.0f);
            } else {
                this.K = (int) (displayMetrics.density * 40.0f);
            }
            this.f11019w.setImageDrawable((Drawable) null);
            this.D.l(i11);
            this.f11019w.setImageDrawable(this.D);
        }
    }

    public void setSlingshotDistance(int i11) {
        this.C = i11;
    }

    public void setTargetOffsetTopAndBottom(int i11) {
        this.f11019w.bringToFront();
        h0.h0(this.f11019w, i11);
        this.f11011o = this.f11019w.getTop();
    }

    public boolean startNestedScroll(int i11) {
        return this.f11005i.p(i11);
    }

    public void stopNestedScroll(int i11) {
        if (i11 == 0) {
            stopNestedScroll();
        }
    }

    public final void t(int i11, Animation.AnimationListener animationListener) {
        this.f11021y = i11;
        this.f11022z = this.f11019w.getScaleX();
        h hVar = new h();
        this.I = hVar;
        hVar.setDuration(150);
        if (animationListener != null) {
            this.f11019w.b(animationListener);
        }
        this.f11019w.clearAnimation();
        this.f11019w.startAnimation(this.I);
    }

    public final void u(Animation.AnimationListener animationListener) {
        this.f11019w.setVisibility(0);
        this.D.setAlpha(255);
        b bVar = new b();
        this.E = bVar;
        bVar.setDuration((long) this.f11010n);
        if (animationListener != null) {
            this.f11019w.b(animationListener);
        }
        this.f11019w.clearAnimation();
        this.f11019w.startAnimation(this.E);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final boolean mRefreshing;

        public class a implements Parcelable.Creator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcelable parcelable, boolean z11) {
            super(parcelable);
            this.mRefreshing = z11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeByte(this.mRefreshing ? (byte) 1 : 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mRefreshing = parcel.readByte() != 0;
        }
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        if (i12 > 0) {
            float f11 = this.f11003g;
            if (f11 > 0.0f) {
                float f12 = (float) i12;
                if (f12 > f11) {
                    iArr[1] = (int) f11;
                    this.f11003g = 0.0f;
                } else {
                    this.f11003g = f11 - f12;
                    iArr[1] = i12;
                }
                j(this.f11003g);
            }
        }
        if (this.L && i12 > 0 && this.f11003g == 0.0f && Math.abs(i12 - iArr[1]) > 0) {
            this.f11019w.setVisibility(8);
        }
        int[] iArr2 = this.f11006j;
        if (dispatchNestedPreScroll(i11 - iArr[0], i12 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.f11004h.b(view, view2, i11);
        startNestedScroll(i11 & 2);
        this.f11003g = 0.0f;
        this.f11009m = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return isEnabled() && !this.f11017u && !this.f11000d && (i11 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f11004h.d(view);
        this.f11009m = false;
        float f11 = this.f11003g;
        if (f11 > 0.0f) {
            g(f11);
            this.f11003g = 0.0f;
        }
        stopNestedScroll();
    }

    public void stopNestedScroll() {
        this.f11005i.r();
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        onNestedScroll(view, i11, i12, i13, i14, i15, this.f11008l);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i11, i12, i13, i14, 0, this.f11008l);
    }
}
