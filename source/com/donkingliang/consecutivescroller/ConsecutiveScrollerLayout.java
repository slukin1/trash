package com.donkingliang.consecutivescroller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.a0;
import androidx.core.view.h0;
import androidx.core.view.o;
import androidx.core.view.q;
import androidx.core.view.r;
import androidx.core.view.u;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConsecutiveScrollerLayout extends ViewGroup implements a0, r, o {
    public static final Interpolator W = new a();
    public int A;
    public int B;
    public int C;
    public EdgeEffect D;
    public EdgeEffect E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public int K;
    public View L;
    public final List<View> M;
    public final List<View> N;
    public int O;
    public final List<View> P;
    public int Q;
    public f R;
    public d S;
    public int T;
    public boolean U;
    public boolean V;

    /* renamed from: b  reason: collision with root package name */
    public int f64895b;

    /* renamed from: c  reason: collision with root package name */
    public int f64896c;

    /* renamed from: d  reason: collision with root package name */
    public OverScroller f64897d;

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f64898e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f64899f;

    /* renamed from: g  reason: collision with root package name */
    public int f64900g;

    /* renamed from: h  reason: collision with root package name */
    public int f64901h;

    /* renamed from: i  reason: collision with root package name */
    public int f64902i;

    /* renamed from: j  reason: collision with root package name */
    public int f64903j;

    /* renamed from: k  reason: collision with root package name */
    public int f64904k;

    /* renamed from: l  reason: collision with root package name */
    public int f64905l;

    /* renamed from: m  reason: collision with root package name */
    public int f64906m;

    /* renamed from: n  reason: collision with root package name */
    public HashMap<Integer, Float> f64907n;

    /* renamed from: o  reason: collision with root package name */
    public final int[] f64908o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f64909p;

    /* renamed from: q  reason: collision with root package name */
    public int f64910q;

    /* renamed from: r  reason: collision with root package name */
    public e f64911r;

    /* renamed from: s  reason: collision with root package name */
    public int f64912s;

    /* renamed from: t  reason: collision with root package name */
    public u f64913t;

    /* renamed from: u  reason: collision with root package name */
    public q f64914u;

    /* renamed from: v  reason: collision with root package name */
    public final int[] f64915v;

    /* renamed from: w  reason: collision with root package name */
    public final int[] f64916w;

    /* renamed from: x  reason: collision with root package name */
    public View f64917x;

    /* renamed from: y  reason: collision with root package name */
    public int f64918y;

    /* renamed from: z  reason: collision with root package name */
    public int f64919z;

    public static class a implements Interpolator {
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView f64927b;

        public b(RecyclerView recyclerView) {
            this.f64927b = recyclerView;
        }

        public void run() {
            ScrollUtils.v(this.f64927b);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64929a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout$LayoutParams$Align[] r0 = com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.LayoutParams.Align.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f64929a = r0
                com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout$LayoutParams$Align r1 = com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.LayoutParams.Align.RIGHT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f64929a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout$LayoutParams$Align r1 = com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.LayoutParams.Align.CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f64929a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout$LayoutParams$Align r1 = com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.LayoutParams.Align.LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.c.<clinit>():void");
        }
    }

    public interface d {
        void a(List<View> list);
    }

    public interface e {
        void a(View view, int i11, int i12, int i13);
    }

    public interface f {
        void a(View view, View view2);
    }

    public ConsecutiveScrollerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getAdjustHeight() {
        List<View> stickyChildren = getStickyChildren();
        int i11 = this.J;
        int size = stickyChildren.size();
        if (this.G) {
            for (int i12 = 0; i12 < size; i12++) {
                View view = stickyChildren.get(i12);
                if (!H(view)) {
                    i11 += view.getMeasuredHeight();
                }
            }
            return i11;
        }
        for (int i13 = size - 1; i13 >= 0; i13--) {
            View view2 = stickyChildren.get(i13);
            if (!H(view2)) {
                return i11 + view2.getMeasuredHeight();
            }
        }
        return i11;
    }

    private View getBottomView() {
        List<View> effectiveChildren = getEffectiveChildren();
        if (!effectiveChildren.isEmpty()) {
            return effectiveChildren.get(effectiveChildren.size() - 1);
        }
        return null;
    }

    private List<View> getEffectiveChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private List<View> getNonGoneChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, computeVerticalScrollRange() - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    private List<View> getStickyChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && I(childAt)) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private int getStickyY() {
        return getScrollY() + getPaddingTop() + this.K;
    }

    public final void A() {
        VelocityTracker velocityTracker = this.f64899f;
        if (velocityTracker == null) {
            this.f64899f = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final void B() {
        VelocityTracker velocityTracker = this.f64898e;
        if (velocityTracker == null) {
            this.f64898e = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final boolean C(int i11, int i12) {
        View x11 = x(i11, i12);
        if (x11 != null) {
            return ScrollUtils.q(x11);
        }
        return false;
    }

    public final boolean D(MotionEvent motionEvent) {
        int findPointerIndex = motionEvent.findPointerIndex(this.f64912s);
        if (findPointerIndex < 0 || findPointerIndex >= motionEvent.getPointerCount()) {
            return true;
        }
        return C(ScrollUtils.h(this, motionEvent, findPointerIndex), ScrollUtils.i(this, motionEvent, findPointerIndex));
    }

    public final boolean E() {
        if (this.N.size() != this.M.size()) {
            return false;
        }
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.N.get(i11) != this.M.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean F() {
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        if (size <= 0) {
            return true;
        }
        boolean z11 = getScrollY() >= this.f64896c && !ScrollUtils.c(effectiveChildren.get(effectiveChildren.size() - 1), 1);
        if (z11) {
            for (int i11 = size - 1; i11 >= 0; i11--) {
                View view = effectiveChildren.get(i11);
                if (ScrollUtils.q(view) && ScrollUtils.c(view, 1)) {
                    return false;
                }
            }
        }
        return z11;
    }

    public boolean G() {
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        if (size <= 0) {
            return true;
        }
        boolean z11 = getScrollY() <= 0 && !ScrollUtils.c(effectiveChildren.get(0), -1);
        if (z11) {
            for (int i11 = size - 1; i11 >= 0; i11--) {
                View view = effectiveChildren.get(i11);
                if (ScrollUtils.q(view) && ScrollUtils.c(view, -1)) {
                    return false;
                }
            }
        }
        return z11;
    }

    public boolean H(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            return ((LayoutParams) layoutParams).f64924e;
        }
        return false;
    }

    public boolean I(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            return ((LayoutParams) layoutParams).f64922c;
        }
        return false;
    }

    public final int J(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == 1073741824) {
            i12 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(i12, size);
        }
        return ViewGroup.resolveSizeAndState(Math.max(i12, getSuggestedMinimumWidth()), i11, 0);
    }

    public final void K(int i11, int i12) {
        int i13 = this.f64895b;
        j(i11);
        int i14 = this.f64895b - i13;
        this.f64914u.g(0, i14, 0, i11 - i14, (int[]) null, i12);
    }

    public final void L(List<View> list) {
        d dVar = this.S;
        if (dVar != null) {
            dVar.a(list);
        }
    }

    public final void M(List<View> list) {
        this.N.clear();
        for (int i11 = 0; i11 < list.size(); i11++) {
            View view = list.get(i11);
            int w11 = w(list, i11);
            if (view.getTop() <= getStickyY() + w11) {
                view.setY((float) (getStickyY() + w11));
                view.setClickable(true);
                this.N.add(view);
            }
        }
        if (!E()) {
            this.M.clear();
            this.M.addAll(this.N);
            this.N.clear();
            L(this.M);
        }
    }

    public final void N() {
        VelocityTracker velocityTracker = this.f64899f;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f64899f = null;
        }
    }

    public final void O() {
        VelocityTracker velocityTracker = this.f64898e;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f64898e = null;
        }
    }

    public final void P() {
        for (View translationY : getNonGoneChildren()) {
            translationY.setTranslationY(0.0f);
        }
    }

    public final void Q() {
        View m11 = m();
        this.f64917x = m11;
        if (m11 != null) {
            this.f64918y = getScrollY() - this.f64917x.getTop();
        }
    }

    public final void R() {
        View view;
        View view2;
        List<View> stickyChildren = getStickyChildren();
        if (!stickyChildren.isEmpty()) {
            int size = stickyChildren.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                stickyChildren.get(i12).setTranslationY(0.0f);
            }
            if (this.G) {
                d();
                M(stickyChildren);
                return;
            }
            e();
            int i13 = size - 1;
            int i14 = i13;
            while (true) {
                view = null;
                if (i14 < 0) {
                    view2 = null;
                    break;
                }
                View view3 = stickyChildren.get(i14);
                if (view3.getTop() <= getStickyY()) {
                    if (i14 != i13) {
                        view = stickyChildren.get(i14 + 1);
                    }
                    view2 = view;
                    view = view3;
                } else {
                    i14--;
                }
            }
            View view4 = this.L;
            if (view != null) {
                if (view2 != null && !H(view)) {
                    i11 = Math.max(0, view.getHeight() - (view2.getTop() - getStickyY()));
                }
                c0(view, i11);
            }
            if (view4 != view) {
                this.L = view;
                b0(view4, view);
                return;
            }
            return;
        }
        d();
        e();
    }

    public final void S(int i11, int i12) {
        e eVar = this.f64911r;
        if (eVar != null) {
            eVar.a(this, i11, i12, this.T);
        }
    }

    public final void T(View view, int i11) {
        View m11 = ScrollUtils.m(view);
        if (m11 instanceof AbsListView) {
            AbsListView absListView = (AbsListView) m11;
            if (Build.VERSION.SDK_INT >= 19) {
                absListView.scrollListBy(i11);
                return;
            }
            return;
        }
        boolean u11 = m11 instanceof RecyclerView ? ScrollUtils.u((RecyclerView) m11) : false;
        m11.scrollBy(0, i11);
        if (u11) {
            RecyclerView recyclerView = (RecyclerView) m11;
            recyclerView.postDelayed(new b(recyclerView), 0);
        }
    }

    public void U(View view) {
        int i11;
        do {
            i11 = 0;
            int j11 = ScrollUtils.j(view);
            if (j11 > 0) {
                int e11 = ScrollUtils.e(view);
                T(view, j11);
                i11 = e11 - ScrollUtils.e(view);
                continue;
            }
        } while (i11 != 0);
    }

    public void V(View view) {
        int i11;
        do {
            i11 = 0;
            int l11 = ScrollUtils.l(view);
            if (l11 < 0) {
                int e11 = ScrollUtils.e(view);
                T(view, l11);
                i11 = e11 - ScrollUtils.e(view);
                continue;
            }
        } while (i11 != 0);
    }

    public final void W(int i11) {
        int i12;
        int i13;
        View view;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        while (true) {
            int i14 = this.f64919z;
            int i15 = 0;
            if (i14 != -1) {
                View childAt = getChildAt(i14);
                i12 = (childAt.getTop() - this.B) - s(childAt);
                i13 = y(this.f64919z);
                if (this.C >= 1000 || getScrollY() + getPaddingTop() + i13 <= i12 || G()) {
                    this.f64919z = -1;
                    this.A = 0;
                    this.B = 0;
                    this.C = 0;
                    setScrollState(0);
                }
            } else {
                i13 = 0;
                i12 = 0;
            }
            if (!G()) {
                if (getScrollY() < this.f64896c) {
                    view = n();
                } else {
                    view = getBottomView();
                }
                if (view != null) {
                    awakenScrollBars();
                    int l11 = ScrollUtils.l(view);
                    if (l11 < 0) {
                        i15 = Math.max(i11, l11);
                        if (this.f64919z != -1) {
                            i15 = Math.max(i15, i12 - ((getScrollY() + getPaddingTop()) + i13));
                        }
                        T(view, i15);
                    } else {
                        int scrollY = getScrollY();
                        int max = Math.max(Math.max(i11, ((view.getTop() + getPaddingBottom()) - scrollY) - getHeight()), -scrollY);
                        if (this.f64919z != -1) {
                            max = Math.max(max, i12 - ((getScrollY() + getPaddingTop()) + i13));
                        }
                        X(scrollY + max);
                        i15 = max;
                    }
                    this.f64895b += i15;
                    i11 -= i15;
                }
            }
            if (i15 < 0) {
                if (i11 >= 0) {
                    break;
                }
            } else {
                break;
            }
        }
        int computeVerticalScrollOffset2 = computeVerticalScrollOffset();
        if (computeVerticalScrollOffset != computeVerticalScrollOffset2) {
            S(computeVerticalScrollOffset2, computeVerticalScrollOffset);
        }
    }

    public final void X(int i11) {
        if (i11 < 0) {
            i11 = 0;
        } else {
            int i12 = this.f64896c;
            if (i11 > i12) {
                i11 = i12;
            }
        }
        super.scrollTo(0, i11);
    }

    public final void Y(int i11) {
        int i12;
        int i13;
        View view;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        while (true) {
            int i14 = this.f64919z;
            int i15 = 0;
            if (i14 != -1) {
                View childAt = getChildAt(i14);
                i12 = (childAt.getTop() - this.B) - s(childAt);
                i13 = this.B < 0 ? y(this.f64919z) : 0;
                if (this.C >= 1000 || getScrollY() + getPaddingTop() + i13 >= i12 || F()) {
                    this.f64919z = -1;
                    this.A = 0;
                    this.B = 0;
                    this.C = 0;
                    setScrollState(0);
                }
            } else {
                i13 = 0;
                i12 = 0;
            }
            if (!F()) {
                if (getScrollY() < this.f64896c) {
                    view = m();
                } else {
                    view = getBottomView();
                }
                if (view != null) {
                    awakenScrollBars();
                    int j11 = ScrollUtils.j(view);
                    if (j11 > 0) {
                        i15 = Math.min(i11, j11);
                        if (this.f64919z != -1) {
                            i15 = Math.min(i15, i12 - ((getScrollY() + getPaddingTop()) + i13));
                        }
                        T(view, i15);
                    } else {
                        int min = Math.min(i11, (view.getBottom() - getPaddingTop()) - getScrollY());
                        if (this.f64919z != -1) {
                            min = Math.min(min, i12 - ((getScrollY() + getPaddingTop()) + i13));
                        }
                        X(getScrollY() + i15);
                    }
                    this.f64895b += i15;
                    i11 -= i15;
                }
            }
            if (i15 > 0) {
                if (i11 <= 0) {
                    break;
                }
            } else {
                break;
            }
        }
        int computeVerticalScrollOffset2 = computeVerticalScrollOffset();
        if (computeVerticalScrollOffset != computeVerticalScrollOffset2) {
            S(computeVerticalScrollOffset2, computeVerticalScrollOffset);
        }
    }

    public final void Z() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (!I(childAt) || H(childAt)) {
                arrayList.add(childAt);
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (I(childAt2) && !H(childAt2)) {
                arrayList.add(childAt2);
            }
        }
        this.P.clear();
        this.P.addAll(arrayList);
    }

    public final boolean a() {
        return !G() || !F();
    }

    public boolean a0(int i11, int i12) {
        return this.f64914u.q(i11, i12);
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        List<View> scrolledViews;
        if (layoutParams instanceof LayoutParams) {
            LayoutParamsUtils.a((LayoutParams) layoutParams);
        }
        super.addView(view, i11, layoutParams);
        if (ScrollUtils.q(view)) {
            View k11 = ScrollUtils.k(view);
            g(k11);
            if ((k11 instanceof n4.a) && (scrolledViews = ((n4.a) k11).getScrolledViews()) != null && !scrolledViews.isEmpty()) {
                int size = scrolledViews.size();
                for (int i12 = 0; i12 < size; i12++) {
                    g(scrolledViews.get(i12));
                }
            }
        }
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).setClipToPadding(false);
        }
    }

    public final void b(boolean z11, boolean z12) {
        int i11 = this.f64895b;
        View view = this.f64917x;
        if (view == null || !z11) {
            X(getScrollY());
        } else if (indexOfChild(view) != -1) {
            X(this.f64917x.getTop() + this.f64918y);
        }
        c(true, z12);
        if (!(i11 == this.f64895b || this.f64917x == m())) {
            scrollTo(0, i11);
        }
        this.f64917x = null;
        this.f64918y = 0;
        P();
        R();
    }

    public final void b0(View view, View view2) {
        f fVar = this.R;
        if (fVar != null) {
            fVar.a(view, view2);
        }
    }

    public final void c(boolean z11, boolean z12) {
        int computeVerticalScrollOffset;
        if (z12 || (!this.f64909p && this.f64897d.isFinished() && this.f64919z == -1)) {
            int computeVerticalScrollOffset2 = computeVerticalScrollOffset();
            View m11 = m();
            if (m11 != null) {
                int indexOfChild = indexOfChild(m11);
                if (z11) {
                    while (true) {
                        int j11 = ScrollUtils.j(m11);
                        int top = m11.getTop() - getScrollY();
                        if (j11 <= 0 || top >= 0) {
                            break;
                        }
                        int min = Math.min(j11, -top);
                        X(getScrollY() - min);
                        T(m11, min);
                    }
                }
                for (int i11 = 0; i11 < indexOfChild; i11++) {
                    View childAt = getChildAt(i11);
                    if (childAt.getVisibility() != 8 && ScrollUtils.q(childAt)) {
                        View k11 = ScrollUtils.k(childAt);
                        if (k11 instanceof n4.a) {
                            List<View> scrolledViews = ((n4.a) k11).getScrolledViews();
                            if (scrolledViews != null && !scrolledViews.isEmpty()) {
                                int size = scrolledViews.size();
                                for (int i12 = 0; i12 < size; i12++) {
                                    U(scrolledViews.get(i12));
                                }
                            }
                        } else {
                            U(k11);
                        }
                    }
                }
                while (true) {
                    indexOfChild++;
                    if (indexOfChild >= getChildCount()) {
                        break;
                    }
                    View childAt2 = getChildAt(indexOfChild);
                    if (childAt2.getVisibility() != 8 && ScrollUtils.q(childAt2)) {
                        if (indexOfChild != getChildCount() - 1 || childAt2.getHeight() >= getHeight() || getScrollY() < this.f64896c) {
                            View k12 = ScrollUtils.k(childAt2);
                            if (k12 instanceof n4.a) {
                                List<View> scrolledViews2 = ((n4.a) k12).getScrolledViews();
                                if (scrolledViews2 != null && !scrolledViews2.isEmpty()) {
                                    int size2 = scrolledViews2.size();
                                    for (int i13 = 0; i13 < size2; i13++) {
                                        V(scrolledViews2.get(i13));
                                    }
                                }
                            } else {
                                V(k12);
                            }
                        }
                    }
                }
                f();
                if (z11 && computeVerticalScrollOffset2 != (computeVerticalScrollOffset = computeVerticalScrollOffset())) {
                    S(computeVerticalScrollOffset, computeVerticalScrollOffset2);
                }
                R();
            }
        }
    }

    public final void c0(View view, int i11) {
        view.setY((float) (getStickyY() - i11));
        view.setClickable(true);
    }

    public boolean canScrollVertically(int i11) {
        if (i11 > 0) {
            return !F();
        }
        return !G();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        int i11;
        if (this.f64919z == -1 || (i11 = this.A) == 0) {
            if (this.f64897d.computeScrollOffset()) {
                int currY = this.f64897d.getCurrY();
                int i12 = currY - this.F;
                this.F = currY;
                int[] iArr = this.f64916w;
                iArr[1] = 0;
                h(0, i12, iArr, (int[]) null, 1);
                int i13 = i12 - this.f64916w[1];
                int i14 = this.f64895b;
                j(i13);
                int i15 = this.f64895b - i14;
                int i16 = i13 - i15;
                if ((i16 < 0 && G()) || (i16 > 0 && F())) {
                    i(0, i15, 0, i16, this.f64915v, 1);
                    i16 += this.f64915v[1];
                }
                if ((i16 < 0 && G()) || (i16 > 0 && F())) {
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) {
                        l();
                        if (i16 < 0) {
                            if (this.D.isFinished()) {
                                this.D.onAbsorb((int) this.f64897d.getCurrVelocity());
                            }
                        } else if (this.E.isFinished()) {
                            this.E.onAbsorb((int) this.f64897d.getCurrVelocity());
                        }
                    }
                    d0();
                }
                invalidate();
            }
            if (this.T == 2 && this.f64897d.isFinished()) {
                stopNestedScroll(1);
                c(false, false);
                setScrollState(0);
                return;
            }
            return;
        }
        if (i11 > 0 && i11 < 200) {
            this.A = i11 + 5;
        }
        int i17 = this.A;
        if (i17 < 0 && i17 > -200) {
            this.A = i17 - 5;
        }
        j(this.A);
        this.C++;
        invalidate();
    }

    public int computeVerticalScrollExtent() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public int computeVerticalScrollOffset() {
        int scrollY = getScrollY();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = nonGoneChildren.get(i11);
            if (ScrollUtils.q(view)) {
                scrollY += ScrollUtils.e(view);
            }
        }
        return scrollY;
    }

    public int computeVerticalScrollRange() {
        int height;
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            View view = nonGoneChildren.get(i12);
            if (!ScrollUtils.q(view)) {
                height = view.getHeight();
            } else if (ScrollUtils.b(view)) {
                View m11 = ScrollUtils.m(view);
                i11 += ScrollUtils.f(m11) + m11.getPaddingTop() + m11.getPaddingBottom();
            } else {
                height = view.getHeight();
            }
            i11 += height;
        }
        return i11;
    }

    public final void d() {
        View view = this.L;
        if (view != null) {
            this.L = null;
            b0(view, (View) null);
        }
    }

    public void d0() {
        if (!this.f64897d.isFinished()) {
            this.f64897d.abortAnimation();
            stopNestedScroll(1);
            if (this.f64919z == -1) {
                setScrollState(0);
            }
        }
    }

    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return this.f64914u.a(f11, f12, z11);
    }

    public boolean dispatchNestedPreFling(float f11, float f12) {
        return this.f64914u.b(f11, f12);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return h(i11, i12, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return this.f64914u.f(i11, i12, i13, i14, iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x015e, code lost:
        if (C(r10[0], r10[1]) != false) goto L_0x0160;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getActionIndex()
            int r1 = r12.f64910q
            r2 = 0
            r3 = -1
            r4 = 2
            r5 = 0
            if (r1 != r4) goto L_0x0047
            int r1 = r12.f64912s
            if (r1 == r3) goto L_0x0047
            java.util.HashMap<java.lang.Integer, java.lang.Float> r6 = r12.f64907n
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r6.get(r1)
            if (r1 == 0) goto L_0x0047
            int r1 = r12.f64912s
            int r1 = r13.findPointerIndex(r1)
            if (r1 < 0) goto L_0x0046
            int r6 = r13.getPointerCount()
            if (r1 < r6) goto L_0x002b
            goto L_0x0046
        L_0x002b:
            java.util.HashMap<java.lang.Integer, java.lang.Float> r6 = r12.f64907n
            int r7 = r12.f64912s
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object r6 = r6.get(r7)
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            float r1 = r13.getY(r1)
            float r6 = r6 - r1
            r13.offsetLocation(r2, r6)
            goto L_0x0047
        L_0x0046:
            return r5
        L_0x0047:
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13)
            int r6 = r1.getActionMasked()
            if (r6 != 0) goto L_0x0053
            r12.Q = r5
        L_0x0053:
            int r6 = r12.Q
            float r6 = (float) r6
            r1.offsetLocation(r2, r6)
            int r6 = r13.getActionMasked()
            r7 = 3
            r8 = 1
            if (r6 == 0) goto L_0x025e
            if (r6 == r8) goto L_0x01dc
            if (r6 == r4) goto L_0x0122
            if (r6 == r7) goto L_0x01dc
            r2 = 5
            if (r6 == r2) goto L_0x00d4
            r2 = 6
            if (r6 == r2) goto L_0x006f
            goto L_0x02bd
        L_0x006f:
            java.util.HashMap<java.lang.Integer, java.lang.Float> r2 = r12.f64907n
            int r4 = r13.getPointerId(r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.remove(r4)
            int r2 = r12.f64912s
            int r4 = r13.getPointerId(r0)
            if (r2 != r4) goto L_0x00ca
            if (r0 != 0) goto L_0x0088
            r0 = r8
            goto L_0x0089
        L_0x0088:
            r0 = r5
        L_0x0089:
            int r2 = r13.getPointerId(r0)
            r12.f64912s = r2
            java.util.HashMap<java.lang.Integer, java.lang.Float> r4 = r12.f64907n
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            float r6 = r13.getY(r0)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r4.put(r2, r6)
            float r2 = r13.getY(r0)
            int r2 = (int) r2
            r12.f64906m = r2
            float r2 = r13.getX(r0)
            int r2 = (int) r2
            r12.f64905l = r2
            int[] r2 = r12.f64908o
            int r4 = com.donkingliang.consecutivescroller.ScrollUtils.h(r12, r13, r0)
            r2[r5] = r4
            int[] r2 = r12.f64908o
            int r0 = com.donkingliang.consecutivescroller.ScrollUtils.i(r12, r13, r0)
            r2[r8] = r0
            int[] r0 = r12.f64908o
            r2 = r0[r5]
            r0 = r0[r8]
            boolean r0 = com.donkingliang.consecutivescroller.ScrollUtils.s(r12, r2, r0)
            r12.U = r0
        L_0x00ca:
            r12.z()
            android.view.VelocityTracker r0 = r12.f64899f
            r0.addMovement(r1)
            goto L_0x02bd
        L_0x00d4:
            int r2 = r13.getPointerId(r0)
            r12.f64912s = r2
            java.util.HashMap<java.lang.Integer, java.lang.Float> r4 = r12.f64907n
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            float r6 = r13.getY(r0)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r4.put(r2, r6)
            float r2 = r13.getY(r0)
            int r2 = (int) r2
            r12.f64906m = r2
            float r2 = r13.getX(r0)
            int r2 = (int) r2
            r12.f64905l = r2
            r12.requestDisallowInterceptTouchEvent(r5)
            int[] r2 = r12.f64908o
            int r4 = com.donkingliang.consecutivescroller.ScrollUtils.h(r12, r13, r0)
            r2[r5] = r4
            int[] r2 = r12.f64908o
            int r0 = com.donkingliang.consecutivescroller.ScrollUtils.i(r12, r13, r0)
            r2[r8] = r0
            int[] r0 = r12.f64908o
            r2 = r0[r5]
            r0 = r0[r8]
            boolean r0 = com.donkingliang.consecutivescroller.ScrollUtils.s(r12, r2, r0)
            r12.U = r0
            r12.z()
            android.view.VelocityTracker r0 = r12.f64899f
            r0.addMovement(r1)
            goto L_0x02bd
        L_0x0122:
            int r0 = r12.f64912s
            int r0 = r13.findPointerIndex(r0)
            if (r0 < 0) goto L_0x01db
            int r6 = r13.getPointerCount()
            if (r0 < r6) goto L_0x0132
            goto L_0x01db
        L_0x0132:
            r12.z()
            android.view.VelocityTracker r6 = r12.f64899f
            r6.addMovement(r1)
            float r6 = r13.getY(r0)
            int r6 = (int) r6
            int r9 = r12.f64906m
            int r6 = r6 - r9
            float r9 = r13.getX(r0)
            int r9 = (int) r9
            int r10 = r12.f64905l
            int r9 = r9 - r10
            int r10 = r12.f64910q
            if (r10 != 0) goto L_0x01cb
            boolean r10 = r12.D(r13)
            if (r10 != 0) goto L_0x0160
            int[] r10 = r12.f64908o
            r11 = r10[r5]
            r10 = r10[r8]
            boolean r10 = r12.C(r11, r10)
            if (r10 == 0) goto L_0x01cb
        L_0x0160:
            boolean r10 = r12.H
            if (r10 == 0) goto L_0x016f
            int r2 = java.lang.Math.abs(r6)
            int r4 = r12.f64903j
            if (r2 < r4) goto L_0x01c6
            r12.f64910q = r8
            goto L_0x01c6
        L_0x016f:
            int r10 = java.lang.Math.abs(r9)
            int r11 = java.lang.Math.abs(r6)
            if (r10 <= r11) goto L_0x01bc
            int r6 = java.lang.Math.abs(r9)
            int r9 = r12.f64903j
            if (r6 < r9) goto L_0x01c6
            r12.f64910q = r4
            int r4 = r12.f64912s
            if (r4 == r3) goto L_0x01c6
            java.util.HashMap<java.lang.Integer, java.lang.Float> r6 = r12.f64907n
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r6.get(r4)
            if (r4 == 0) goto L_0x01c6
            int r4 = r12.f64912s
            int r4 = r13.findPointerIndex(r4)
            if (r4 < 0) goto L_0x01c6
            int r6 = r13.getPointerCount()
            if (r0 >= r6) goto L_0x01c6
            java.util.HashMap<java.lang.Integer, java.lang.Float> r6 = r12.f64907n
            int r9 = r12.f64912s
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Object r6 = r6.get(r9)
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            float r4 = r13.getY(r4)
            float r6 = r6 - r4
            r13.offsetLocation(r2, r6)
            goto L_0x01c6
        L_0x01bc:
            int r2 = java.lang.Math.abs(r6)
            int r4 = r12.f64903j
            if (r2 < r4) goto L_0x01c6
            r12.f64910q = r8
        L_0x01c6:
            int r2 = r12.f64910q
            if (r2 != 0) goto L_0x01cb
            return r8
        L_0x01cb:
            float r2 = r13.getY(r0)
            int r2 = (int) r2
            r12.f64906m = r2
            float r0 = r13.getX(r0)
            int r0 = (int) r0
            r12.f64905l = r0
            goto L_0x02bd
        L_0x01db:
            return r5
        L_0x01dc:
            android.view.VelocityTracker r2 = r12.f64899f
            if (r2 == 0) goto L_0x024f
            r2.addMovement(r1)
            android.view.VelocityTracker r2 = r12.f64899f
            r4 = 1000(0x3e8, float:1.401E-42)
            int r6 = r12.f64901h
            float r6 = (float) r6
            r2.computeCurrentVelocity(r4, r6)
            android.view.VelocityTracker r2 = r12.f64899f
            float r2 = r2.getYVelocity()
            int r2 = (int) r2
            int r4 = r12.f64901h
            int r6 = -r4
            int r4 = java.lang.Math.min(r2, r4)
            int r4 = java.lang.Math.max(r6, r4)
            r12.f64900g = r4
            r12.N()
            int r4 = com.donkingliang.consecutivescroller.ScrollUtils.h(r12, r13, r0)
            int r0 = com.donkingliang.consecutivescroller.ScrollUtils.i(r12, r13, r0)
            android.view.View r6 = r12.x(r4, r0)
            boolean r6 = com.donkingliang.consecutivescroller.ScrollUtils.b(r6)
            boolean r0 = com.donkingliang.consecutivescroller.ScrollUtils.r(r12, r4, r0)
            int r4 = r12.f64910q
            if (r4 == r8) goto L_0x022b
            if (r6 == 0) goto L_0x022b
            int r4 = java.lang.Math.abs(r2)
            int r6 = r12.f64902i
            if (r4 < r6) goto L_0x022b
            if (r0 != 0) goto L_0x022b
            r13.setAction(r7)
        L_0x022b:
            int r4 = r12.f64910q
            if (r4 == r8) goto L_0x024f
            boolean r4 = com.donkingliang.consecutivescroller.ScrollUtils.p(r12)
            if (r4 != 0) goto L_0x024f
            boolean r4 = r12.D(r13)
            if (r4 == 0) goto L_0x024f
            int r2 = java.lang.Math.abs(r2)
            int r4 = r12.f64902i
            if (r2 < r4) goto L_0x024f
            int r2 = r12.f64910q
            if (r2 == 0) goto L_0x0249
            if (r0 != 0) goto L_0x024f
        L_0x0249:
            int r0 = r12.f64900g
            int r0 = -r0
            r12.o(r0)
        L_0x024f:
            r12.f64906m = r5
            r12.f64905l = r5
            r12.f64909p = r5
            int[] r0 = r12.f64908o
            r0[r5] = r5
            r0[r8] = r5
            r12.U = r5
            goto L_0x02bd
        L_0x025e:
            int r2 = r12.T
            if (r2 != r4) goto L_0x0264
            r2 = r8
            goto L_0x0265
        L_0x0264:
            r2 = r5
        L_0x0265:
            r12.V = r2
            r12.d0()
            r12.c(r5, r5)
            r12.f64909p = r8
            r12.f64910q = r5
            int r2 = r13.getPointerId(r0)
            r12.f64912s = r2
            java.util.HashMap<java.lang.Integer, java.lang.Float> r6 = r12.f64907n
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            float r9 = r13.getY(r0)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r6.put(r2, r9)
            float r2 = r13.getY(r0)
            int r2 = (int) r2
            r12.f64906m = r2
            float r2 = r13.getX(r0)
            int r2 = (int) r2
            r12.f64905l = r2
            r12.A()
            android.view.VelocityTracker r2 = r12.f64899f
            r2.addMovement(r1)
            r12.a0(r4, r5)
            int[] r2 = r12.f64908o
            int r4 = com.donkingliang.consecutivescroller.ScrollUtils.h(r12, r13, r0)
            r2[r5] = r4
            int[] r2 = r12.f64908o
            int r0 = com.donkingliang.consecutivescroller.ScrollUtils.i(r12, r13, r0)
            r2[r8] = r0
            int[] r0 = r12.f64908o
            r2 = r0[r5]
            r0 = r0[r8]
            boolean r0 = com.donkingliang.consecutivescroller.ScrollUtils.s(r12, r2, r0)
            r12.U = r0
        L_0x02bd:
            r1.recycle()
            boolean r0 = super.dispatchTouchEvent(r13)
            int r13 = r13.getActionMasked()
            if (r13 == r8) goto L_0x02cd
            if (r13 == r7) goto L_0x02cd
            goto L_0x02e3
        L_0x02cd:
            r12.f64910q = r5
            r12.f64900g = r5
            java.util.HashMap<java.lang.Integer, java.lang.Float> r13 = r12.f64907n
            r13.clear()
            r12.f64912s = r3
            android.widget.OverScroller r13 = r12.f64897d
            boolean r13 = r13.isFinished()
            if (r13 == 0) goto L_0x02e3
            r12.setScrollState(r5)
        L_0x02e3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void draw(Canvas canvas) {
        int i11;
        int i12;
        super.draw(canvas);
        if (this.O != getScrollY()) {
            this.O = getScrollY();
            R();
        }
        if (this.D != null) {
            int scrollY = getScrollY();
            int i13 = 0;
            if (!this.D.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int i14 = Build.VERSION.SDK_INT;
                if (i14 < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i11 = getPaddingLeft() + 0;
                } else {
                    i11 = 0;
                }
                if (i14 < 21 || !getClipToPadding()) {
                    i12 = scrollY;
                } else {
                    height -= getPaddingTop() + getPaddingBottom();
                    i12 = getPaddingTop() + scrollY;
                }
                canvas.translate((float) i11, (float) i12);
                this.D.setSize(width, height);
                if (this.D.draw(canvas)) {
                    h0.n0(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.E.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int i15 = scrollY + height2;
                int i16 = Build.VERSION.SDK_INT;
                if (i16 < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i13 = 0 + getPaddingLeft();
                }
                if (i16 >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    i15 -= getPaddingBottom();
                }
                canvas.translate((float) (i13 - width2), (float) i15);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.E.setSize(width2, height2);
                if (this.E.draw(canvas)) {
                    h0.n0(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public final void e() {
        if (!this.M.isEmpty()) {
            this.M.clear();
            L(this.M);
        }
    }

    public boolean e0(View view) {
        boolean z11 = this.G;
        return (!z11 && this.L == view) || (z11 && this.M.contains(view));
    }

    public final void f() {
        this.f64895b = computeVerticalScrollOffset();
    }

    public final void g(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        view.setOverScrollMode(2);
        h0.N0(view, false);
    }

    public int getAdjustHeightOffset() {
        return this.J;
    }

    public int getChildDrawingOrder(int i11, int i12) {
        int indexOfChild;
        if (this.P.size() <= i12 || (indexOfChild = indexOfChild(this.P.get(i12))) == -1) {
            return super.getChildDrawingOrder(i11, i12);
        }
        return indexOfChild;
    }

    public View getCurrentStickyView() {
        return this.L;
    }

    public List<View> getCurrentStickyViews() {
        return this.M;
    }

    public int getNestedScrollAxes() {
        return this.f64913t.a();
    }

    public d getOnPermanentStickyChangeListener() {
        return this.S;
    }

    public f getOnStickyChangeListener() {
        return this.R;
    }

    public e getOnVerticalScrollChangeListener() {
        return this.f64911r;
    }

    public int getOwnScrollY() {
        return computeVerticalScrollOffset();
    }

    public int getScrollState() {
        return this.T;
    }

    public int getStickyOffset() {
        return this.K;
    }

    public boolean h(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        return this.f64914u.d(i11, i12, iArr, iArr2, i13);
    }

    public boolean i(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return this.f64914u.g(i11, i12, i13, i14, iArr, i15);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f64914u.m();
    }

    public final void j(int i11) {
        if (i11 > 0) {
            Y(i11);
        } else if (i11 < 0) {
            W(i11);
        }
    }

    public final void k() {
        EdgeEffect edgeEffect = this.D;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.E.onRelease();
        }
    }

    public final void l() {
        if (getOverScrollMode() == 2) {
            this.D = null;
            this.E = null;
        } else if (this.D == null) {
            Context context = getContext();
            this.D = new EdgeEffect(context);
            this.E = new EdgeEffect(context);
        }
    }

    public View m() {
        int scrollY = getScrollY() + getPaddingTop();
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = effectiveChildren.get(i11);
            if (view.getTop() <= scrollY && view.getBottom() > scrollY) {
                return view;
            }
        }
        return null;
    }

    public void measureChildWithMargins(View view, int i11, int i12, int i13, int i14) {
        LayoutParamsUtils.a((LayoutParams) view.getLayoutParams());
        super.measureChildWithMargins(view, i11, i12, i13, i14);
    }

    public View n() {
        int height = (getHeight() - getPaddingBottom()) + getScrollY();
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = effectiveChildren.get(i11);
            if (view.getTop() < height && view.getBottom() >= height) {
                return view;
            }
        }
        return null;
    }

    public final void o(int i11) {
        if (Math.abs(i11) > this.f64902i) {
            float f11 = (float) i11;
            if (!dispatchNestedPreFling(0.0f, f11)) {
                dispatchNestedFling(0.0f, f11, (i11 < 0 && !G()) || (i11 > 0 && !F()));
                this.f64897d.fling(0, this.f64895b, 1, i11, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                a0(2, 1);
                setScrollState(2);
                this.F = this.f64895b;
                invalidate();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (C(r0[0], r0[1]) != false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r0 != 3) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getActionMasked()
            if (r0 == 0) goto L_0x0034
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0028
            r3 = 2
            if (r0 == r3) goto L_0x0011
            r3 = 3
            if (r0 == r3) goto L_0x0028
            goto L_0x003c
        L_0x0011:
            int r0 = r4.f64910q
            if (r0 == r3) goto L_0x003c
            boolean r0 = r4.D(r5)
            if (r0 != 0) goto L_0x0027
            int[] r0 = r4.f64908o
            r1 = r0[r1]
            r0 = r0[r2]
            boolean r0 = r4.C(r1, r0)
            if (r0 == 0) goto L_0x003c
        L_0x0027:
            return r2
        L_0x0028:
            r4.stopNestedScroll(r1)
            boolean r0 = r4.V
            if (r0 == 0) goto L_0x003c
            int r0 = r4.f64910q
            if (r0 != 0) goto L_0x003c
            return r2
        L_0x0034:
            r4.B()
            android.view.VelocityTracker r0 = r4.f64898e
            r0.addMovement(r5)
        L_0x003c:
            boolean r5 = super.onInterceptTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.f64896c = 0;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int measuredWidth = getMeasuredWidth();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i15 = 0;
        while (i15 < size) {
            View view = nonGoneChildren.get(i15);
            int measuredHeight = view.getMeasuredHeight() + paddingTop;
            int t11 = t(view, measuredWidth, paddingLeft, paddingRight);
            view.layout(t11, paddingTop, view.getMeasuredWidth() + t11, measuredHeight);
            this.f64896c += view.getHeight();
            i15++;
            paddingTop = measuredHeight;
        }
        int measuredHeight2 = this.f64896c - ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        this.f64896c = measuredHeight2;
        if (measuredHeight2 < 0) {
            this.f64896c = 0;
        }
        b(z11, false);
        Z();
    }

    public void onMeasure(int i11, int i12) {
        Q();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < size; i15++) {
            View view = nonGoneChildren.get(i15);
            measureChildWithMargins(view, i11, 0, i12, s(view));
            i13 = Math.max(i13, u(view));
            i14 += view.getMeasuredHeight();
        }
        setMeasuredDimension(J(i11, i13 + getPaddingLeft() + getPaddingRight()), J(i12, i14 + getPaddingTop() + getPaddingBottom()));
    }

    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        if (z11) {
            return false;
        }
        dispatchNestedFling(0.0f, f12, true);
        o((int) f12);
        return true;
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        return dispatchNestedPreFling(f11, f12);
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        onNestedPreScroll(view, i11, i12, iArr, 0);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        K(i14, i15);
    }

    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        this.f64913t.c(view, view2, i11, i12);
        c(false, false);
        a0(2, i12);
    }

    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams ? ((LayoutParams) layoutParams).f64921b : false) || (i11 & 2) == 0) {
            return false;
        }
        return true;
    }

    public void onStopNestedScroll(View view, int i11) {
        this.f64913t.e(view, i11);
        stopNestedScroll(i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r0 != 6) goto L_0x01be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            boolean r0 = com.donkingliang.consecutivescroller.ScrollUtils.p(r16)
            if (r0 != 0) goto L_0x01ca
            boolean r0 = r7.U
            if (r0 == 0) goto L_0x0010
            goto L_0x01ca
        L_0x0010:
            android.view.MotionEvent r9 = android.view.MotionEvent.obtain(r17)
            int r0 = r17.getActionMasked()
            r10 = 0
            if (r0 != 0) goto L_0x001d
            r7.Q = r10
        L_0x001d:
            int r0 = r7.Q
            float r0 = (float) r0
            r11 = 0
            r9.offsetLocation(r11, r0)
            int r0 = r7.f64912s
            int r12 = r8.findPointerIndex(r0)
            if (r12 < 0) goto L_0x01c9
            int r0 = r17.getPointerCount()
            if (r12 < r0) goto L_0x0034
            goto L_0x01c9
        L_0x0034:
            int r0 = r17.getActionMasked()
            r1 = 2
            r13 = 1
            if (r0 == 0) goto L_0x01b4
            if (r0 == r13) goto L_0x017d
            if (r0 == r1) goto L_0x0058
            r1 = 3
            if (r0 == r1) goto L_0x004b
            r1 = 5
            if (r0 == r1) goto L_0x01b7
            r1 = 6
            if (r0 == r1) goto L_0x01b7
            goto L_0x01be
        L_0x004b:
            r16.k()
            r7.f64904k = r10
            r16.O()
            r7.setScrollState(r10)
            goto L_0x01be
        L_0x0058:
            int r0 = r7.f64904k
            if (r0 != 0) goto L_0x0064
            float r0 = r8.getY(r12)
            int r0 = (int) r0
            r7.f64904k = r0
            return r13
        L_0x0064:
            int[] r0 = r7.f64916w
            r0[r13] = r10
            float r0 = r8.getY(r12)
            int r0 = (int) r0
            int r1 = r7.f64904k
            int r6 = r1 - r0
            r7.f64904k = r0
            r1 = 0
            int[] r3 = r7.f64916w
            int[] r4 = r7.f64915v
            r5 = 0
            r0 = r16
            r2 = r6
            boolean r0 = r0.h(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00a6
            int[] r0 = r7.f64916w
            r0 = r0[r13]
            int r6 = r6 - r0
            int[] r0 = r7.f64915v
            r0 = r0[r13]
            float r0 = (float) r0
            r8.offsetLocation(r11, r0)
            int r0 = r7.Q
            int[] r1 = r7.f64915v
            r2 = r1[r13]
            int r0 = r0 + r2
            r7.Q = r0
            int r0 = r7.f64904k
            r1 = r1[r13]
            int r0 = r0 - r1
            r7.f64904k = r0
            android.view.ViewParent r0 = r16.getParent()
            r0.requestDisallowInterceptTouchEvent(r13)
        L_0x00a6:
            int r14 = r7.f64895b
            int r0 = r7.T
            if (r0 == r13) goto L_0x00c0
            boolean r0 = r16.a()
            if (r0 == 0) goto L_0x00ba
            int r0 = java.lang.Math.abs(r6)
            if (r0 <= 0) goto L_0x00ba
            r0 = r13
            goto L_0x00bb
        L_0x00ba:
            r0 = r10
        L_0x00bb:
            if (r0 == 0) goto L_0x00c0
            r7.setScrollState(r13)
        L_0x00c0:
            int r0 = r7.T
            if (r0 != r13) goto L_0x00c7
            r7.j(r6)
        L_0x00c7:
            int r0 = r7.f64895b
            int r2 = r0 - r14
            if (r2 == 0) goto L_0x00d4
            android.view.ViewParent r0 = r16.getParent()
            r0.requestDisallowInterceptTouchEvent(r13)
        L_0x00d4:
            int r15 = r6 - r2
            r1 = 0
            r3 = 0
            int[] r5 = r7.f64915v
            r6 = 0
            r0 = r16
            r4 = r15
            boolean r0 = r0.i(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x0104
            int[] r0 = r7.f64915v
            r1 = r0[r13]
            int r15 = r15 + r1
            int r1 = r7.f64904k
            r2 = r0[r13]
            int r1 = r1 - r2
            r7.f64904k = r1
            int r1 = r7.Q
            r2 = r0[r13]
            int r1 = r1 + r2
            r7.Q = r1
            r0 = r0[r13]
            float r0 = (float) r0
            r8.offsetLocation(r11, r0)
            android.view.ViewParent r0 = r16.getParent()
            r0.requestDisallowInterceptTouchEvent(r13)
        L_0x0104:
            int r0 = r16.getScrollRange()
            int r1 = r16.getOverScrollMode()
            if (r1 == 0) goto L_0x0112
            if (r1 != r13) goto L_0x0113
            if (r0 <= 0) goto L_0x0113
        L_0x0112:
            r10 = r13
        L_0x0113:
            if (r10 == 0) goto L_0x01be
            r16.l()
            int r14 = r14 + r15
            if (r14 >= 0) goto L_0x013f
            android.widget.EdgeEffect r0 = r7.D
            float r1 = (float) r15
            int r2 = r16.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            float r2 = r8.getX(r12)
            int r3 = r16.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            androidx.core.widget.g.f(r0, r1, r2)
            android.widget.EdgeEffect r0 = r7.E
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x0167
            android.widget.EdgeEffect r0 = r7.E
            r0.onRelease()
            goto L_0x0167
        L_0x013f:
            if (r14 <= r0) goto L_0x0167
            android.widget.EdgeEffect r0 = r7.E
            float r1 = (float) r15
            int r2 = r16.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = r8.getX(r12)
            int r4 = r16.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            float r2 = r2 - r3
            androidx.core.widget.g.f(r0, r1, r2)
            android.widget.EdgeEffect r0 = r7.D
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x0167
            android.widget.EdgeEffect r0 = r7.D
            r0.onRelease()
        L_0x0167:
            android.widget.EdgeEffect r0 = r7.D
            if (r0 == 0) goto L_0x01be
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x0179
            android.widget.EdgeEffect r0 = r7.E
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01be
        L_0x0179:
            androidx.core.view.h0.n0(r16)
            goto L_0x01be
        L_0x017d:
            r16.k()
            r7.f64904k = r10
            android.view.VelocityTracker r0 = r7.f64898e
            if (r0 == 0) goto L_0x01be
            r0.addMovement(r9)
            android.view.VelocityTracker r0 = r7.f64898e
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r7.f64901h
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            android.view.VelocityTracker r0 = r7.f64898e
            float r0 = r0.getYVelocity()
            int r0 = (int) r0
            int r1 = r7.f64901h
            int r2 = -r1
            int r0 = java.lang.Math.min(r0, r1)
            int r0 = java.lang.Math.max(r2, r0)
            if (r0 != 0) goto L_0x01ac
            int r1 = r7.f64900g
            if (r1 == 0) goto L_0x01ac
            r0 = r1
        L_0x01ac:
            int r0 = -r0
            r7.o(r0)
            r16.O()
            goto L_0x01be
        L_0x01b4:
            r7.a0(r1, r10)
        L_0x01b7:
            float r0 = r8.getY(r12)
            int r0 = (int) r0
            r7.f64904k = r0
        L_0x01be:
            android.view.VelocityTracker r0 = r7.f64898e
            if (r0 == 0) goto L_0x01c5
            r0.addMovement(r9)
        L_0x01c5:
            r9.recycle()
            return r13
        L_0x01c9:
            return r10
        L_0x01ca:
            boolean r0 = super.onTouchEvent(r17)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: q */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: r */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void requestLayout() {
        super.requestLayout();
    }

    public final int s(View view) {
        if (!this.I || view != getChildAt(getChildCount() - 1)) {
            return 0;
        }
        return getAdjustHeight();
    }

    public void scrollBy(int i11, int i12) {
        scrollTo(0, this.f64895b + i12);
    }

    public void scrollTo(int i11, int i12) {
        j(i12 - this.f64895b);
    }

    public void setAdjustHeightOffset(int i11) {
        if (this.J != i11) {
            this.J = i11;
            requestLayout();
        }
    }

    public void setAutoAdjustHeightAtBottomView(boolean z11) {
        if (this.I != z11) {
            this.I = z11;
            requestLayout();
        }
    }

    public void setDisableChildHorizontalScroll(boolean z11) {
        this.H = z11;
    }

    public void setNestedScrollingEnabled(boolean z11) {
        this.f64914u.n(z11);
    }

    public void setOnPermanentStickyChangeListener(d dVar) {
        this.S = dVar;
    }

    @Deprecated
    public void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener) {
    }

    public void setOnStickyChangeListener(f fVar) {
        this.R = fVar;
    }

    public void setOnVerticalScrollChangeListener(e eVar) {
        this.f64911r = eVar;
    }

    public void setPermanent(boolean z11) {
        if (this.G != z11) {
            this.G = z11;
            if (this.I) {
                requestLayout();
            } else {
                R();
            }
        }
    }

    public void setScrollState(int i11) {
        if (i11 != this.T) {
            this.T = i11;
            int computeVerticalScrollOffset = computeVerticalScrollOffset();
            S(computeVerticalScrollOffset, computeVerticalScrollOffset);
        }
    }

    public void setStickyOffset(int i11) {
        if (this.K != i11) {
            this.K = i11;
            R();
        }
    }

    public void stopNestedScroll(int i11) {
        this.f64914u.s(i11);
    }

    public final int t(View view, int i11, int i12, int i13) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i14 = c.f64929a[layoutParams.f64926g.ordinal()];
        if (i14 == 1) {
            return ((i11 - view.getMeasuredWidth()) - i13) - layoutParams.rightMargin;
        }
        if (i14 != 2) {
            return i12 + layoutParams.leftMargin;
        }
        return layoutParams.leftMargin + i12 + ((((((i11 - view.getMeasuredWidth()) - i12) - layoutParams.leftMargin) - i13) - layoutParams.rightMargin) / 2);
    }

    public final int u(View view) {
        int measuredWidth = view.getMeasuredWidth();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public int v(View view) {
        return this.P.indexOf(view);
    }

    public final int w(List<View> list, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            View view = list.get(i13);
            if (!H(view)) {
                i12 += view.getMeasuredHeight();
            }
        }
        return i12;
    }

    public final View x(int i11, int i12) {
        for (View next : getNonGoneChildren()) {
            if (ScrollUtils.t(next, i11, i12)) {
                return next;
            }
        }
        return null;
    }

    public final int y(int i11) {
        int childCount = getChildCount();
        int i12 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && ScrollUtils.q(childAt)) {
                i12 += ScrollUtils.e(childAt);
            }
            i11++;
        }
        return i12;
    }

    public final void z() {
        if (this.f64899f == null) {
            this.f64899f = VelocityTracker.obtain();
        }
    }

    public ConsecutiveScrollerLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f64907n = new HashMap<>();
        this.f64908o = new int[2];
        this.f64909p = false;
        this.f64910q = 0;
        this.f64912s = -1;
        this.f64915v = new int[2];
        this.f64916w = new int[2];
        this.f64919z = -1;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.J = 0;
        this.K = 0;
        this.M = new ArrayList();
        this.N = new ArrayList();
        this.O = 0;
        this.P = new ArrayList();
        this.Q = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.ConsecutiveScrollerLayout);
            this.G = typedArray.getBoolean(R$styleable.ConsecutiveScrollerLayout_isPermanent, false);
            this.H = typedArray.getBoolean(R$styleable.ConsecutiveScrollerLayout_disableChildHorizontalScroll, false);
            this.K = typedArray.getDimensionPixelOffset(R$styleable.ConsecutiveScrollerLayout_stickyOffset, 0);
            this.I = typedArray.getBoolean(R$styleable.ConsecutiveScrollerLayout_autoAdjustHeightAtBottomView, false);
            this.J = typedArray.getDimensionPixelOffset(R$styleable.ConsecutiveScrollerLayout_adjustHeightOffset, 0);
            typedArray.recycle();
            this.f64897d = new OverScroller(getContext(), W);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f64901h = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f64902i = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f64903j = ViewConfiguration.getTouchSlop();
            setWillNotDraw(false);
            setVerticalScrollBarEnabled(true);
            this.f64913t = new u(this);
            this.f64914u = new q(this);
            setNestedScrollingEnabled(true);
            setChildrenDrawingOrderEnabled(true);
            setMotionEventSplittingEnabled(false);
        } catch (Throwable th2) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th2;
        }
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        h(i11, i12, iArr, (int[]) null, i13);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        K(i14, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i11) {
        onNestedScrollAccepted(view, view2, i11, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return onStartNestedScroll(view, view2, i11, 0);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f64920a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64921b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64922c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64923d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64924e = false;

        /* renamed from: f  reason: collision with root package name */
        public int f64925f;

        /* renamed from: g  reason: collision with root package name */
        public Align f64926g = Align.LEFT;

        public enum Align {
            LEFT(1),
            RIGHT(2),
            CENTER(3);
            
            public int value;

            private Align(int i11) {
                this.value = i11;
            }

            public static Align get(int i11) {
                if (i11 == 1) {
                    return LEFT;
                }
                if (i11 == 2) {
                    return RIGHT;
                }
                if (i11 != 3) {
                    return LEFT;
                }
                return CENTER;
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArray = null;
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.ConsecutiveScrollerLayout_Layout);
                this.f64920a = typedArray.getBoolean(R$styleable.ConsecutiveScrollerLayout_Layout_layout_isConsecutive, true);
                this.f64921b = typedArray.getBoolean(R$styleable.ConsecutiveScrollerLayout_Layout_layout_isNestedScroll, true);
                this.f64922c = typedArray.getBoolean(R$styleable.ConsecutiveScrollerLayout_Layout_layout_isSticky, false);
                this.f64923d = typedArray.getBoolean(R$styleable.ConsecutiveScrollerLayout_Layout_layout_isTriggerScroll, false);
                this.f64924e = typedArray.getBoolean(R$styleable.ConsecutiveScrollerLayout_Layout_layout_isSink, false);
                this.f64926g = Align.get(typedArray.getInt(R$styleable.ConsecutiveScrollerLayout_Layout_layout_align, 1));
                this.f64925f = typedArray.getResourceId(R$styleable.ConsecutiveScrollerLayout_Layout_layout_scrollChild, -1);
            } catch (Exception e11) {
                e11.printStackTrace();
                if (typedArray == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th2;
            }
            typedArray.recycle();
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
