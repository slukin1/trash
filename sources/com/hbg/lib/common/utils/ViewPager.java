package com.hbg.lib.common.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.l;
import androidx.core.os.m;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.f0;
import androidx.core.view.h0;
import androidx.core.view.j0;
import androidx.core.view.n;
import androidx.viewpager.widget.PagerAdapter;
import com.youth.banner.config.BannerConfig;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {

    /* renamed from: h0  reason: collision with root package name */
    public static final int[] f67499h0 = {16842931};

    /* renamed from: i0  reason: collision with root package name */
    public static final Comparator<d> f67500i0 = new a();

    /* renamed from: j0  reason: collision with root package name */
    public static final Interpolator f67501j0 = new b();

    /* renamed from: k0  reason: collision with root package name */
    public static final j f67502k0 = new j();
    public int A;
    public int B;
    public int C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H = -1;
    public VelocityTracker I;
    public int J;
    public int K;
    public int L;
    public int M;
    public boolean N;
    public androidx.core.widget.g O;
    public androidx.core.widget.g P;
    public boolean Q = true;
    public boolean R = false;
    public boolean S;
    public int T;
    public List<g> U;
    public g V;
    public g W;

    /* renamed from: a0  reason: collision with root package name */
    public f f67503a0;

    /* renamed from: b  reason: collision with root package name */
    public int f67504b;

    /* renamed from: b0  reason: collision with root package name */
    public h f67505b0;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<d> f67506c = new ArrayList<>();

    /* renamed from: c0  reason: collision with root package name */
    public Method f67507c0;

    /* renamed from: d  reason: collision with root package name */
    public final d f67508d = new d();

    /* renamed from: d0  reason: collision with root package name */
    public int f67509d0;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f67510e = new Rect();

    /* renamed from: e0  reason: collision with root package name */
    public ArrayList<View> f67511e0;

    /* renamed from: f  reason: collision with root package name */
    public PagerAdapter f67512f;

    /* renamed from: f0  reason: collision with root package name */
    public final Runnable f67513f0 = new c();

    /* renamed from: g  reason: collision with root package name */
    public int f67514g;

    /* renamed from: g0  reason: collision with root package name */
    public int f67515g0 = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f67516h = -1;

    /* renamed from: i  reason: collision with root package name */
    public Parcelable f67517i = null;

    /* renamed from: j  reason: collision with root package name */
    public ClassLoader f67518j = null;

    /* renamed from: k  reason: collision with root package name */
    public Scroller f67519k;

    /* renamed from: l  reason: collision with root package name */
    public i f67520l;

    /* renamed from: m  reason: collision with root package name */
    public int f67521m;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f67522n;

    /* renamed from: o  reason: collision with root package name */
    public int f67523o;

    /* renamed from: p  reason: collision with root package name */
    public int f67524p;

    /* renamed from: q  reason: collision with root package name */
    public float f67525q = -3.4028235E38f;

    /* renamed from: r  reason: collision with root package name */
    public float f67526r = Float.MAX_VALUE;

    /* renamed from: s  reason: collision with root package name */
    public int f67527s;

    /* renamed from: t  reason: collision with root package name */
    public int f67528t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f67529u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f67530v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f67531w;

    /* renamed from: x  reason: collision with root package name */
    public int f67532x = 1;

    /* renamed from: y  reason: collision with root package name */
    public boolean f67533y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f67534z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = l.a(new a());
        public Parcelable adapterState;
        public ClassLoader loader;
        public int position;

        public class a implements m<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i11);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements g {
        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
        }
    }

    public class a implements Comparator<d> {
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f67543b - dVar2.f67543b;
        }
    }

    public class b implements Interpolator {
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.F();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Object f67542a;

        /* renamed from: b  reason: collision with root package name */
        public int f67543b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67544c;

        /* renamed from: d  reason: collision with root package name */
        public float f67545d;

        /* renamed from: e  reason: collision with root package name */
        public float f67546e;
    }

    public class e extends AccessibilityDelegateCompat {
        public e() {
        }

        public final boolean canScroll() {
            return ViewPager.this.f67512f != null && ViewPager.this.f67512f.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            b1.c a11 = b1.c.a();
            a11.f(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.f67512f != null) {
                a11.c(ViewPager.this.f67512f.getCount());
                a11.b(ViewPager.this.f67514g);
                a11.h(ViewPager.this.f67514g);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.o0(ViewPager.class.getName());
            accessibilityNodeInfoCompat.K0(canScroll());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (super.performAccessibilityAction(view, i11, bundle)) {
                return true;
            }
            if (i11 != 4096) {
                if (i11 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f67514g - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f67514g + 1);
                return true;
            }
        }
    }

    public interface f {
        void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface g {
        void onPageScrollStateChanged(int i11);

        void onPageScrolled(int i11, float f11, int i12);

        void onPageSelected(int i11);
    }

    public interface h {
        void transformPage(View view, float f11);
    }

    public class i extends DataSetObserver {
        public i() {
        }

        public void onChanged() {
            ViewPager.this.j();
        }

        public void onInvalidated() {
            ViewPager.this.j();
        }

        public /* synthetic */ i(ViewPager viewPager, a aVar) {
            this();
        }
    }

    public static class j implements Comparator<View> {
        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z11 = layoutParams.f67535a;
            if (z11 != layoutParams2.f67535a) {
                return z11 ? 1 : -1;
            }
            return layoutParams.f67539e - layoutParams2.f67539e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i11) {
        if (this.f67515g0 != i11) {
            this.f67515g0 = i11;
            if (this.f67505b0 != null) {
                p(i11 != 0);
            }
            n(i11);
        }
    }

    private void setScrollingCacheEnabled(boolean z11) {
        if (this.f67530v != z11) {
            this.f67530v = z11;
        }
    }

    public final void A(MotionEvent motionEvent) {
        int b11 = n.b(motionEvent);
        if (n.d(motionEvent, b11) == this.H) {
            int i11 = b11 == 0 ? 1 : 0;
            this.D = n.e(motionEvent, i11);
            this.H = n.d(motionEvent, i11);
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean B() {
        int i11 = this.f67514g;
        if (i11 <= 0) {
            return false;
        }
        L(i11 - 1, true);
        return true;
    }

    public boolean C() {
        PagerAdapter pagerAdapter = this.f67512f;
        if (pagerAdapter == null || this.f67514g >= pagerAdapter.getCount() - 1) {
            return false;
        }
        L(this.f67514g + 1, true);
        return true;
    }

    public final boolean D(int i11) {
        if (this.f67506c.size() == 0) {
            this.S = false;
            z(0, 0.0f, 0);
            if (this.S) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        d v11 = v();
        int clientWidth = getClientWidth();
        int i12 = this.f67521m;
        int i13 = clientWidth + i12;
        float f11 = (float) clientWidth;
        int i14 = v11.f67543b;
        float f12 = ((((float) i11) / f11) - v11.f67546e) / (v11.f67545d + (((float) i12) / f11));
        this.S = false;
        z(i14, f12, (int) (((float) i13) * f12));
        if (this.S) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean E(float f11) {
        boolean z11;
        float f12 = this.D - f11;
        this.D = f11;
        float scrollX = ((float) getScrollX()) + f12;
        float clientWidth = (float) getClientWidth();
        float f13 = this.f67525q * clientWidth;
        float f14 = this.f67526r * clientWidth;
        boolean z12 = false;
        d dVar = this.f67506c.get(0);
        ArrayList<d> arrayList = this.f67506c;
        boolean z13 = true;
        d dVar2 = arrayList.get(arrayList.size() - 1);
        if (dVar.f67543b != 0) {
            f13 = dVar.f67546e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (dVar2.f67543b != this.f67512f.getCount() - 1) {
            f14 = dVar2.f67546e * clientWidth;
            z13 = false;
        }
        if (scrollX < f13) {
            if (z11) {
                z12 = this.O.g(Math.abs(f13 - scrollX) / clientWidth);
            }
            scrollX = f13;
        } else if (scrollX > f14) {
            if (z13) {
                z12 = this.P.g(Math.abs(scrollX - f14) / clientWidth);
            }
            scrollX = f14;
        }
        int i11 = (int) scrollX;
        this.D += scrollX - ((float) i11);
        scrollTo(i11, getScrollY());
        D(i11);
        return z12;
    }

    public void F() {
        G(this.f67514g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r10 == r11) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void G(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.f67514g
            if (r2 == r1) goto L_0x0016
            if (r2 >= r1) goto L_0x000d
            r4 = 66
            goto L_0x000f
        L_0x000d:
            r4 = 17
        L_0x000f:
            com.hbg.lib.common.utils.ViewPager$d r2 = r0.w(r2)
            r0.f67514g = r1
            goto L_0x0018
        L_0x0016:
            r4 = 2
            r2 = 0
        L_0x0018:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f67512f
            if (r1 != 0) goto L_0x0020
            r17.Q()
            return
        L_0x0020:
            boolean r1 = r0.f67531w
            if (r1 == 0) goto L_0x0028
            r17.Q()
            return
        L_0x0028:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x002f
            return
        L_0x002f:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f67512f
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.f67532x
            int r5 = r0.f67514g
            int r5 = r5 - r1
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            androidx.viewpager.widget.PagerAdapter r7 = r0.f67512f
            int r7 = r7.getCount()
            int r8 = r7 + -1
            int r9 = r0.f67514g
            int r9 = r9 + r1
            int r1 = java.lang.Math.min(r8, r9)
            int r8 = r0.f67504b
            if (r7 != r8) goto L_0x021a
            r8 = r6
        L_0x0052:
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r9 = r0.f67506c
            int r9 = r9.size()
            if (r8 >= r9) goto L_0x006e
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r9 = r0.f67506c
            java.lang.Object r9 = r9.get(r8)
            com.hbg.lib.common.utils.ViewPager$d r9 = (com.hbg.lib.common.utils.ViewPager.d) r9
            int r10 = r9.f67543b
            int r11 = r0.f67514g
            if (r10 < r11) goto L_0x006b
            if (r10 != r11) goto L_0x006e
            goto L_0x006f
        L_0x006b:
            int r8 = r8 + 1
            goto L_0x0052
        L_0x006e:
            r9 = 0
        L_0x006f:
            if (r9 != 0) goto L_0x0079
            if (r7 <= 0) goto L_0x0079
            int r9 = r0.f67514g
            com.hbg.lib.common.utils.ViewPager$d r9 = r0.e(r9, r8)
        L_0x0079:
            if (r9 == 0) goto L_0x0198
            int r11 = r8 + -1
            if (r11 < 0) goto L_0x0088
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r12 = r0.f67506c
            java.lang.Object r12 = r12.get(r11)
            com.hbg.lib.common.utils.ViewPager$d r12 = (com.hbg.lib.common.utils.ViewPager.d) r12
            goto L_0x0089
        L_0x0088:
            r12 = 0
        L_0x0089:
            int r13 = r17.getClientWidth()
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 > 0) goto L_0x0093
            r15 = 0
            goto L_0x009f
        L_0x0093:
            float r15 = r9.f67545d
            float r15 = r14 - r15
            int r3 = r17.getPaddingLeft()
            float r3 = (float) r3
            float r6 = (float) r13
            float r3 = r3 / r6
            float r15 = r15 + r3
        L_0x009f:
            int r3 = r0.f67514g
            int r3 = r3 + -1
            r6 = 0
        L_0x00a4:
            if (r3 < 0) goto L_0x0103
            int r16 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r16 < 0) goto L_0x00d2
            if (r3 >= r5) goto L_0x00d2
            if (r12 != 0) goto L_0x00af
            goto L_0x0103
        L_0x00af:
            int r10 = r12.f67543b
            if (r3 != r10) goto L_0x0100
            boolean r10 = r12.f67544c
            if (r10 != 0) goto L_0x0100
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r10 = r0.f67506c
            r10.remove(r11)
            androidx.viewpager.widget.PagerAdapter r10 = r0.f67512f
            java.lang.Object r12 = r12.f67542a
            r10.destroyItem((android.view.ViewGroup) r0, (int) r3, (java.lang.Object) r12)
            int r11 = r11 + -1
            int r8 = r8 + -1
            if (r11 < 0) goto L_0x00fe
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r10 = r0.f67506c
            java.lang.Object r10 = r10.get(r11)
            com.hbg.lib.common.utils.ViewPager$d r10 = (com.hbg.lib.common.utils.ViewPager.d) r10
            goto L_0x00ff
        L_0x00d2:
            if (r12 == 0) goto L_0x00e8
            int r10 = r12.f67543b
            if (r3 != r10) goto L_0x00e8
            float r10 = r12.f67545d
            float r6 = r6 + r10
            int r11 = r11 + -1
            if (r11 < 0) goto L_0x00fe
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r10 = r0.f67506c
            java.lang.Object r10 = r10.get(r11)
            com.hbg.lib.common.utils.ViewPager$d r10 = (com.hbg.lib.common.utils.ViewPager.d) r10
            goto L_0x00ff
        L_0x00e8:
            int r10 = r11 + 1
            com.hbg.lib.common.utils.ViewPager$d r10 = r0.e(r3, r10)
            float r10 = r10.f67545d
            float r6 = r6 + r10
            int r8 = r8 + 1
            if (r11 < 0) goto L_0x00fe
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r10 = r0.f67506c
            java.lang.Object r10 = r10.get(r11)
            com.hbg.lib.common.utils.ViewPager$d r10 = (com.hbg.lib.common.utils.ViewPager.d) r10
            goto L_0x00ff
        L_0x00fe:
            r10 = 0
        L_0x00ff:
            r12 = r10
        L_0x0100:
            int r3 = r3 + -1
            goto L_0x00a4
        L_0x0103:
            float r3 = r9.f67545d
            int r5 = r8 + 1
            int r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x0195
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r6 = r0.f67506c
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x011c
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r6 = r0.f67506c
            java.lang.Object r6 = r6.get(r5)
            com.hbg.lib.common.utils.ViewPager$d r6 = (com.hbg.lib.common.utils.ViewPager.d) r6
            goto L_0x011d
        L_0x011c:
            r6 = 0
        L_0x011d:
            if (r13 > 0) goto L_0x0121
            r10 = 0
            goto L_0x0129
        L_0x0121:
            int r10 = r17.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r13
            float r10 = r10 / r11
            float r10 = r10 + r14
        L_0x0129:
            int r11 = r0.f67514g
        L_0x012b:
            int r11 = r11 + 1
            if (r11 >= r7) goto L_0x0195
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x015f
            if (r11 <= r1) goto L_0x015f
            if (r6 != 0) goto L_0x0138
            goto L_0x0195
        L_0x0138:
            int r12 = r6.f67543b
            if (r11 != r12) goto L_0x0194
            boolean r12 = r6.f67544c
            if (r12 != 0) goto L_0x0194
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r12 = r0.f67506c
            r12.remove(r5)
            androidx.viewpager.widget.PagerAdapter r12 = r0.f67512f
            java.lang.Object r6 = r6.f67542a
            r12.destroyItem((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r6)
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r6 = r0.f67506c
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x015d
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r6 = r0.f67506c
            java.lang.Object r6 = r6.get(r5)
            com.hbg.lib.common.utils.ViewPager$d r6 = (com.hbg.lib.common.utils.ViewPager.d) r6
            goto L_0x0194
        L_0x015d:
            r6 = 0
            goto L_0x0194
        L_0x015f:
            if (r6 == 0) goto L_0x017b
            int r12 = r6.f67543b
            if (r11 != r12) goto L_0x017b
            float r6 = r6.f67545d
            float r3 = r3 + r6
            int r5 = r5 + 1
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r6 = r0.f67506c
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x015d
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r6 = r0.f67506c
            java.lang.Object r6 = r6.get(r5)
            com.hbg.lib.common.utils.ViewPager$d r6 = (com.hbg.lib.common.utils.ViewPager.d) r6
            goto L_0x0194
        L_0x017b:
            com.hbg.lib.common.utils.ViewPager$d r6 = r0.e(r11, r5)
            int r5 = r5 + 1
            float r6 = r6.f67545d
            float r3 = r3 + r6
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r6 = r0.f67506c
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x015d
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r6 = r0.f67506c
            java.lang.Object r6 = r6.get(r5)
            com.hbg.lib.common.utils.ViewPager$d r6 = (com.hbg.lib.common.utils.ViewPager.d) r6
        L_0x0194:
            goto L_0x012b
        L_0x0195:
            r0.g(r9, r8, r2)
        L_0x0198:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f67512f
            int r2 = r0.f67514g
            if (r9 == 0) goto L_0x01a1
            java.lang.Object r3 = r9.f67542a
            goto L_0x01a2
        L_0x01a1:
            r3 = 0
        L_0x01a2:
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
            androidx.viewpager.widget.PagerAdapter r1 = r0.f67512f
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01af:
            if (r2 >= r1) goto L_0x01db
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            com.hbg.lib.common.utils.ViewPager$LayoutParams r5 = (com.hbg.lib.common.utils.ViewPager.LayoutParams) r5
            r5.f67540f = r2
            boolean r6 = r5.f67535a
            if (r6 != 0) goto L_0x01d7
            float r6 = r5.f67537c
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x01d8
            com.hbg.lib.common.utils.ViewPager$d r3 = r0.u(r3)
            if (r3 == 0) goto L_0x01d8
            float r6 = r3.f67545d
            r5.f67537c = r6
            int r3 = r3.f67543b
            r5.f67539e = r3
            goto L_0x01d8
        L_0x01d7:
            r7 = 0
        L_0x01d8:
            int r2 = r2 + 1
            goto L_0x01af
        L_0x01db:
            r17.Q()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x0219
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01ef
            com.hbg.lib.common.utils.ViewPager$d r3 = r0.t(r1)
            goto L_0x01f0
        L_0x01ef:
            r3 = 0
        L_0x01f0:
            if (r3 == 0) goto L_0x01f8
            int r1 = r3.f67543b
            int r2 = r0.f67514g
            if (r1 == r2) goto L_0x0219
        L_0x01f8:
            r6 = 0
        L_0x01f9:
            int r1 = r17.getChildCount()
            if (r6 >= r1) goto L_0x0219
            android.view.View r1 = r0.getChildAt(r6)
            com.hbg.lib.common.utils.ViewPager$d r2 = r0.u(r1)
            if (r2 == 0) goto L_0x0216
            int r2 = r2.f67543b
            int r3 = r0.f67514g
            if (r2 != r3) goto L_0x0216
            boolean r1 = r1.requestFocus(r4)
            if (r1 == 0) goto L_0x0216
            goto L_0x0219
        L_0x0216:
            int r6 = r6 + 1
            goto L_0x01f9
        L_0x0219:
            return
        L_0x021a:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0227 }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0227 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0227 }
            goto L_0x022f
        L_0x0227:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x022f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.f67504b
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.PagerAdapter r1 = r0.f67512f
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.ViewPager.G(int):void");
    }

    public final void H(int i11, int i12, int i13, int i14) {
        if (i12 <= 0 || this.f67506c.isEmpty()) {
            d w11 = w(this.f67514g);
            int min = (int) ((w11 != null ? Math.min(w11.f67546e, this.f67526r) : 0.0f) * ((float) ((i11 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                i(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int scrollX = (int) ((((float) getScrollX()) / ((float) (((i12 - getPaddingLeft()) - getPaddingRight()) + i14))) * ((float) (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)));
        scrollTo(scrollX, getScrollY());
        if (!this.f67519k.isFinished()) {
            this.f67519k.startScroll(scrollX, 0, (int) (w(this.f67514g).f67546e * ((float) i11)), 0, this.f67519k.getDuration() - this.f67519k.timePassed());
        }
    }

    public final void I() {
        int i11 = 0;
        while (i11 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i11).getLayoutParams()).f67535a) {
                removeViewAt(i11);
                i11--;
            }
            i11++;
        }
    }

    public final void J(boolean z11) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    public final void K(int i11, boolean z11, int i12, boolean z12) {
        d w11 = w(i11);
        int clientWidth = w11 != null ? (int) (((float) getClientWidth()) * Math.max(this.f67525q, Math.min(w11.f67546e, this.f67526r))) : 0;
        if (z11) {
            P(clientWidth, 0, i12);
            if (z12) {
                m(i11);
                return;
            }
            return;
        }
        if (z12) {
            m(i11);
        }
        i(false);
        scrollTo(clientWidth, 0);
        D(clientWidth);
    }

    public void L(int i11, boolean z11) {
        this.f67531w = false;
        M(i11, z11, false);
    }

    public void M(int i11, boolean z11, boolean z12) {
        N(i11, z11, z12, 0);
    }

    public void N(int i11, boolean z11, boolean z12, int i12) {
        PagerAdapter pagerAdapter = this.f67512f;
        boolean z13 = false;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z12 || this.f67514g != i11 || this.f67506c.size() == 0) {
            if (i11 < 0) {
                i11 = 0;
            } else if (i11 >= this.f67512f.getCount()) {
                i11 = this.f67512f.getCount() - 1;
            }
            int i13 = this.f67532x;
            int i14 = this.f67514g;
            if (i11 > i14 + i13 || i11 < i14 - i13) {
                for (int i15 = 0; i15 < this.f67506c.size(); i15++) {
                    this.f67506c.get(i15).f67544c = true;
                }
            }
            if (this.f67514g != i11) {
                z13 = true;
            }
            if (this.Q) {
                this.f67514g = i11;
                if (z13) {
                    m(i11);
                }
                requestLayout();
                return;
            }
            G(i11);
            K(i11, z11, i12, z13);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void O(boolean z11, h hVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            int i11 = 1;
            boolean z12 = hVar != null;
            boolean z13 = z12 != (this.f67505b0 != null);
            this.f67505b0 = hVar;
            setChildrenDrawingOrderEnabledCompat(z12);
            if (z12) {
                if (z11) {
                    i11 = 2;
                }
                this.f67509d0 = i11;
            } else {
                this.f67509d0 = 0;
            }
            if (z13) {
                F();
            }
        }
    }

    public void P(int i11, int i12, int i13) {
        int i14;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i15 = i11 - scrollX;
        int i16 = i12 - scrollY;
        if (i15 == 0 && i16 == 0) {
            i(false);
            F();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i17 = clientWidth / 2;
        float f11 = (float) clientWidth;
        float f12 = (float) i17;
        float o11 = f12 + (o(Math.min(1.0f, (((float) Math.abs(i15)) * 1.0f) / f11)) * f12);
        int abs = Math.abs(i13);
        if (abs > 0) {
            i14 = Math.round(Math.abs(o11 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i14 = (int) (((((float) Math.abs(i15)) / ((f11 * this.f67512f.getPageWidth(this.f67514g)) + ((float) this.f67521m))) + 1.0f) * 100.0f);
        }
        this.f67519k.startScroll(scrollX, scrollY, i15, i16, Math.min(i14, BannerConfig.SCROLL_TIME));
        h0.n0(this);
    }

    public final void Q() {
        if (this.f67509d0 != 0) {
            ArrayList<View> arrayList = this.f67511e0;
            if (arrayList == null) {
                this.f67511e0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                this.f67511e0.add(getChildAt(i11));
            }
            Collections.sort(this.f67511e0, f67502k0);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        d u11;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 0 && (u11 = u(childAt)) != null && u11.f67543b == this.f67514g) {
                    childAt.addFocusables(arrayList, i11, i12);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i12 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        d u11;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (u11 = u(childAt)) != null && u11.f67543b == this.f67514g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z11 = layoutParams2.f67535a | false;
        layoutParams2.f67535a = z11;
        if (!this.f67529u) {
            super.addView(view, i11, layoutParams);
        } else if (!z11) {
            layoutParams2.f67538d = true;
            addViewInLayout(view, i11, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public boolean canScrollHorizontally(int i11) {
        if (this.f67512f == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i11 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.f67525q))) {
                return true;
            }
            return false;
        } else if (i11 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.f67526r))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.f67519k.isFinished() || !this.f67519k.computeScrollOffset()) {
            i(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f67519k.getCurrX();
        int currY = this.f67519k.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!D(currX)) {
                this.f67519k.abortAnimation();
                scrollTo(0, currY);
            }
        }
        h0.n0(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || r(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        d u11;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (u11 = u(childAt)) != null && u11.f67543b == this.f67514g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int J2 = h0.J(this);
        boolean z11 = false;
        if (J2 == 0 || (J2 == 1 && (pagerAdapter = this.f67512f) != null && pagerAdapter.getCount() > 1)) {
            if (!this.O.e()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f67525q * ((float) width));
                this.O.j(height, width);
                z11 = false | this.O.b(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.P.e()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f67526r + 1.0f)) * ((float) width2));
                this.P.j(height2, width2);
                z11 |= this.P.b(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.O.c();
            this.P.c();
        }
        if (z11) {
            h0.n0(this);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f67522n;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public d e(int i11, int i12) {
        d dVar = new d();
        dVar.f67543b = i11;
        dVar.f67542a = this.f67512f.instantiateItem((ViewGroup) this, i11);
        dVar.f67545d = this.f67512f.getPageWidth(i11);
        if (i12 < 0 || i12 >= this.f67506c.size()) {
            this.f67506c.add(dVar);
        } else {
            this.f67506c.add(i12, dVar);
        }
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto L_0x000b
        L_0x0009:
            r0 = r3
            goto L_0x0069
        L_0x000b:
            if (r0 == 0) goto L_0x0069
            android.view.ViewParent r4 = r0.getParent()
        L_0x0011:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x001e
            if (r4 != r6) goto L_0x0019
            r4 = r1
            goto L_0x001f
        L_0x0019:
            android.view.ViewParent r4 = r4.getParent()
            goto L_0x0011
        L_0x001e:
            r4 = r2
        L_0x001f:
            if (r4 != 0) goto L_0x0069
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L_0x0035:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x004e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0035
        L_0x004e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
            goto L_0x0009
        L_0x0069:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto L_0x00ba
            if (r3 == r0) goto L_0x00ba
            if (r7 != r5) goto L_0x009a
            android.graphics.Rect r1 = r6.f67510e
            android.graphics.Rect r1 = r6.s(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f67510e
            android.graphics.Rect r2 = r6.s(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x0094
            if (r1 < r2) goto L_0x0094
            boolean r0 = r6.B()
            goto L_0x0098
        L_0x0094:
            boolean r0 = r3.requestFocus()
        L_0x0098:
            r2 = r0
            goto L_0x00cd
        L_0x009a:
            if (r7 != r4) goto L_0x00cd
            android.graphics.Rect r1 = r6.f67510e
            android.graphics.Rect r1 = r6.s(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f67510e
            android.graphics.Rect r2 = r6.s(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x00b5
            if (r1 > r2) goto L_0x00b5
            boolean r0 = r6.C()
            goto L_0x0098
        L_0x00b5:
            boolean r0 = r3.requestFocus()
            goto L_0x0098
        L_0x00ba:
            if (r7 == r5) goto L_0x00c9
            if (r7 != r1) goto L_0x00bf
            goto L_0x00c9
        L_0x00bf:
            if (r7 == r4) goto L_0x00c4
            r0 = 2
            if (r7 != r0) goto L_0x00cd
        L_0x00c4:
            boolean r2 = r6.C()
            goto L_0x00cd
        L_0x00c9:
            boolean r2 = r6.B()
        L_0x00cd:
            if (r2 == 0) goto L_0x00d6
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        L_0x00d6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.ViewPager.f(int):boolean");
    }

    public final void g(d dVar, int i11, d dVar2) {
        int i12;
        int i13;
        d dVar3;
        d dVar4;
        int count = this.f67512f.getCount();
        int clientWidth = getClientWidth();
        float f11 = clientWidth > 0 ? ((float) this.f67521m) / ((float) clientWidth) : 0.0f;
        if (dVar2 != null) {
            int i14 = dVar2.f67543b;
            int i15 = dVar.f67543b;
            if (i14 < i15) {
                float f12 = dVar2.f67546e + dVar2.f67545d + f11;
                int i16 = i14 + 1;
                int i17 = 0;
                while (i16 <= dVar.f67543b && i17 < this.f67506c.size()) {
                    Object obj = this.f67506c.get(i17);
                    while (true) {
                        dVar4 = (d) obj;
                        if (i16 > dVar4.f67543b && i17 < this.f67506c.size() - 1) {
                            i17++;
                            obj = this.f67506c.get(i17);
                        }
                    }
                    while (i16 < dVar4.f67543b) {
                        f12 += this.f67512f.getPageWidth(i16) + f11;
                        i16++;
                    }
                    dVar4.f67546e = f12;
                    f12 += dVar4.f67545d + f11;
                    i16++;
                }
            } else if (i14 > i15) {
                int size = this.f67506c.size() - 1;
                float f13 = dVar2.f67546e;
                while (true) {
                    i14--;
                    if (i14 < dVar.f67543b || size < 0) {
                        break;
                    }
                    Object obj2 = this.f67506c.get(size);
                    while (true) {
                        dVar3 = (d) obj2;
                        if (i14 < dVar3.f67543b && size > 0) {
                            size--;
                            obj2 = this.f67506c.get(size);
                        }
                    }
                    while (i14 > dVar3.f67543b) {
                        f13 -= this.f67512f.getPageWidth(i14) + f11;
                        i14--;
                    }
                    f13 -= dVar3.f67545d + f11;
                    dVar3.f67546e = f13;
                }
            }
        }
        int size2 = this.f67506c.size();
        float f14 = dVar.f67546e;
        int i18 = dVar.f67543b;
        int i19 = i18 - 1;
        this.f67525q = i18 == 0 ? f14 : -3.4028235E38f;
        int i21 = count - 1;
        this.f67526r = i18 == i21 ? (dVar.f67545d + f14) - 1.0f : Float.MAX_VALUE;
        int i22 = i11 - 1;
        while (i22 >= 0) {
            d dVar5 = this.f67506c.get(i22);
            while (true) {
                i13 = dVar5.f67543b;
                if (i19 <= i13) {
                    break;
                }
                f14 -= this.f67512f.getPageWidth(i19) + f11;
                i19--;
            }
            f14 -= dVar5.f67545d + f11;
            dVar5.f67546e = f14;
            if (i13 == 0) {
                this.f67525q = f14;
            }
            i22--;
            i19--;
        }
        float f15 = dVar.f67546e + dVar.f67545d + f11;
        int i23 = dVar.f67543b + 1;
        int i24 = i11 + 1;
        while (i24 < size2) {
            d dVar6 = this.f67506c.get(i24);
            while (true) {
                i12 = dVar6.f67543b;
                if (i23 >= i12) {
                    break;
                }
                f15 += this.f67512f.getPageWidth(i23) + f11;
                i23++;
            }
            if (i12 == i21) {
                this.f67526r = (dVar6.f67545d + f15) - 1.0f;
            }
            dVar6.f67546e = f15;
            f15 += dVar6.f67545d + f11;
            i24++;
            i23++;
        }
        this.R = false;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.f67512f;
    }

    public int getChildDrawingOrder(int i11, int i12) {
        if (this.f67509d0 == 2) {
            i12 = (i11 - 1) - i12;
        }
        return ((LayoutParams) this.f67511e0.get(i12).getLayoutParams()).f67540f;
    }

    public int getCurrentItem() {
        return this.f67514g;
    }

    public int getOffscreenPageLimit() {
        return this.f67532x;
    }

    public int getPageMargin() {
        return this.f67521m;
    }

    public boolean h(View view, boolean z11, int i11, int i12, int i13) {
        int i14;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i15 = i12 + scrollX;
                if (i15 >= childAt.getLeft() && i15 < childAt.getRight() && (i14 = i13 + scrollY) >= childAt.getTop() && i14 < childAt.getBottom()) {
                    if (h(childAt, true, i11, i15 - childAt.getLeft(), i14 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z11 || !h0.f(view, -i11)) {
            return false;
        }
        return true;
    }

    public final void i(boolean z11) {
        boolean z12 = this.f67515g0 == 2;
        if (z12) {
            setScrollingCacheEnabled(false);
            this.f67519k.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f67519k.getCurrX();
            int currY = this.f67519k.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    D(currX);
                }
            }
        }
        this.f67531w = false;
        for (int i11 = 0; i11 < this.f67506c.size(); i11++) {
            d dVar = this.f67506c.get(i11);
            if (dVar.f67544c) {
                dVar.f67544c = false;
                z12 = true;
            }
        }
        if (!z12) {
            return;
        }
        if (z11) {
            h0.p0(this, this.f67513f0);
        } else {
            this.f67513f0.run();
        }
    }

    public void j() {
        int count = this.f67512f.getCount();
        this.f67504b = count;
        boolean z11 = this.f67506c.size() < (this.f67532x * 2) + 1 && this.f67506c.size() < count;
        int i11 = this.f67514g;
        int i12 = 0;
        boolean z12 = false;
        while (i12 < this.f67506c.size()) {
            d dVar = this.f67506c.get(i12);
            int itemPosition = this.f67512f.getItemPosition(dVar.f67542a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f67506c.remove(i12);
                    i12--;
                    if (!z12) {
                        this.f67512f.startUpdate((ViewGroup) this);
                        z12 = true;
                    }
                    this.f67512f.destroyItem((ViewGroup) this, dVar.f67543b, dVar.f67542a);
                    int i13 = this.f67514g;
                    if (i13 == dVar.f67543b) {
                        i11 = Math.max(0, Math.min(i13, count - 1));
                    }
                } else {
                    int i14 = dVar.f67543b;
                    if (i14 != itemPosition) {
                        if (i14 == this.f67514g) {
                            i11 = itemPosition;
                        }
                        dVar.f67543b = itemPosition;
                    }
                }
                z11 = true;
            }
            i12++;
        }
        if (z12) {
            this.f67512f.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f67506c, f67500i0);
        if (z11) {
            int childCount = getChildCount();
            for (int i15 = 0; i15 < childCount; i15++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i15).getLayoutParams();
                if (!layoutParams.f67535a) {
                    layoutParams.f67537c = 0.0f;
                }
            }
            M(i11, false, true);
            requestLayout();
        }
    }

    public final int k(int i11, float f11, int i12, int i13) {
        if (Math.abs(i13) <= this.L || Math.abs(i12) <= this.J) {
            i11 = (int) (((float) i11) + f11 + (i11 >= this.f67514g ? 0.4f : 0.6f));
        } else if (i12 <= 0) {
            i11++;
        }
        if (this.f67506c.size() <= 0) {
            return i11;
        }
        ArrayList<d> arrayList = this.f67506c;
        return Math.max(this.f67506c.get(0).f67543b, Math.min(i11, arrayList.get(arrayList.size() - 1).f67543b));
    }

    public final void l(int i11, float f11, int i12) {
        g gVar = this.V;
        if (gVar != null) {
            gVar.onPageScrolled(i11, f11, i12);
        }
        List<g> list = this.U;
        if (list != null) {
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                g gVar2 = this.U.get(i13);
                if (gVar2 != null) {
                    gVar2.onPageScrolled(i11, f11, i12);
                }
            }
        }
        g gVar3 = this.W;
        if (gVar3 != null) {
            gVar3.onPageScrolled(i11, f11, i12);
        }
    }

    public final void m(int i11) {
        g gVar = this.V;
        if (gVar != null) {
            gVar.onPageSelected(i11);
        }
        List<g> list = this.U;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                g gVar2 = this.U.get(i12);
                if (gVar2 != null) {
                    gVar2.onPageSelected(i11);
                }
            }
        }
        g gVar3 = this.W;
        if (gVar3 != null) {
            gVar3.onPageSelected(i11);
        }
    }

    public final void n(int i11) {
        g gVar = this.V;
        if (gVar != null) {
            gVar.onPageScrollStateChanged(i11);
        }
        List<g> list = this.U;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                g gVar2 = this.U.get(i12);
                if (gVar2 != null) {
                    gVar2.onPageScrollStateChanged(i11);
                }
            }
        }
        g gVar3 = this.W;
        if (gVar3 != null) {
            gVar3.onPageScrollStateChanged(i11);
        }
    }

    public float o(float f11) {
        return (float) Math.sin((double) ((float) (((double) (f11 - 0.5f)) * 0.4712389167638204d)));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Q = true;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.f67513f0);
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r0 = r17
            super.onDraw(r18)
            int r1 = r0.f67521m
            if (r1 <= 0) goto L_0x00a4
            android.graphics.drawable.Drawable r1 = r0.f67522n
            if (r1 == 0) goto L_0x00a4
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r1 = r0.f67506c
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00a4
            androidx.viewpager.widget.PagerAdapter r1 = r0.f67512f
            if (r1 == 0) goto L_0x00a4
            int r1 = r17.getScrollX()
            int r2 = r17.getWidth()
            int r3 = r0.f67521m
            float r3 = (float) r3
            float r4 = (float) r2
            float r3 = r3 / r4
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r5 = r0.f67506c
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            com.hbg.lib.common.utils.ViewPager$d r5 = (com.hbg.lib.common.utils.ViewPager.d) r5
            float r7 = r5.f67546e
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r8 = r0.f67506c
            int r8 = r8.size()
            int r9 = r5.f67543b
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r10 = r0.f67506c
            int r11 = r8 + -1
            java.lang.Object r10 = r10.get(r11)
            com.hbg.lib.common.utils.ViewPager$d r10 = (com.hbg.lib.common.utils.ViewPager.d) r10
            int r10 = r10.f67543b
        L_0x0045:
            if (r9 >= r10) goto L_0x00a4
        L_0x0047:
            int r11 = r5.f67543b
            if (r9 <= r11) goto L_0x0058
            if (r6 >= r8) goto L_0x0058
            java.util.ArrayList<com.hbg.lib.common.utils.ViewPager$d> r5 = r0.f67506c
            int r6 = r6 + 1
            java.lang.Object r5 = r5.get(r6)
            com.hbg.lib.common.utils.ViewPager$d r5 = (com.hbg.lib.common.utils.ViewPager.d) r5
            goto L_0x0047
        L_0x0058:
            if (r9 != r11) goto L_0x0064
            float r7 = r5.f67546e
            float r11 = r5.f67545d
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r7 = r7 + r11
            float r7 = r7 + r3
            goto L_0x006f
        L_0x0064:
            androidx.viewpager.widget.PagerAdapter r11 = r0.f67512f
            float r11 = r11.getPageWidth(r9)
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r11 = r11 + r3
            float r7 = r7 + r11
        L_0x006f:
            int r11 = r0.f67521m
            float r13 = (float) r11
            float r13 = r13 + r12
            float r14 = (float) r1
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 <= 0) goto L_0x0093
            android.graphics.drawable.Drawable r13 = r0.f67522n
            int r14 = (int) r12
            int r15 = r0.f67523o
            float r11 = (float) r11
            float r11 = r11 + r12
            r16 = 1056964608(0x3f000000, float:0.5)
            float r11 = r11 + r16
            int r11 = (int) r11
            r16 = r3
            int r3 = r0.f67524p
            r13.setBounds(r14, r15, r11, r3)
            android.graphics.drawable.Drawable r3 = r0.f67522n
            r11 = r18
            r3.draw(r11)
            goto L_0x0097
        L_0x0093:
            r11 = r18
            r16 = r3
        L_0x0097:
            int r3 = r1 + r2
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x009f
            goto L_0x00a4
        L_0x009f:
            int r9 = r9 + 1
            r3 = r16
            goto L_0x0045
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f11;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f67533y = false;
            this.f67534z = false;
            this.H = -1;
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.I = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.f67533y) {
                return true;
            }
            if (this.f67534z) {
                return false;
            }
        }
        if (action == 0) {
            float x11 = motionEvent.getX();
            this.F = x11;
            this.D = x11;
            float y11 = motionEvent.getY();
            this.G = y11;
            this.E = y11;
            this.H = n.d(motionEvent2, 0);
            this.f67534z = false;
            this.f67519k.computeScrollOffset();
            if (this.f67515g0 != 2 || Math.abs(this.f67519k.getFinalX() - this.f67519k.getCurrX()) <= this.M) {
                i(false);
                this.f67533y = false;
            } else {
                this.f67519k.abortAnimation();
                this.f67531w = false;
                F();
                this.f67533y = true;
                J(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i11 = this.H;
            if (i11 != -1) {
                int a11 = n.a(motionEvent2, i11);
                float e11 = n.e(motionEvent2, a11);
                float f12 = e11 - this.D;
                float abs = Math.abs(f12);
                float f13 = n.f(motionEvent2, a11);
                float abs2 = Math.abs(f13 - this.G);
                int i12 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
                if (i12 != 0 && !y(this.D, f12)) {
                    if (h(this, false, (int) f12, (int) e11, (int) f13)) {
                        this.D = e11;
                        this.E = f13;
                        this.f67534z = true;
                        return false;
                    }
                }
                int i13 = this.C;
                if (abs > ((float) i13) && abs * 0.5f > abs2) {
                    this.f67533y = true;
                    J(true);
                    setScrollState(1);
                    if (i12 > 0) {
                        f11 = this.F + ((float) this.C);
                    } else {
                        f11 = this.F - ((float) this.C);
                    }
                    this.D = f11;
                    this.E = f13;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i13)) {
                    this.f67534z = true;
                }
                if (this.f67533y && E(e11)) {
                    h0.n0(this);
                }
            }
        } else if (action == 6) {
            A(motionEvent);
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent2);
        return this.f67533y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b6
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b2
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            com.hbg.lib.common.utils.ViewPager$LayoutParams r12 = (com.hbg.lib.common.utils.ViewPager.LayoutParams) r12
            boolean r14 = r12.f67535a
            if (r14 == 0) goto L_0x00b2
            int r12 = r12.f67536b
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x005c
            r15 = 3
            if (r14 == r15) goto L_0x0056
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006d
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
            goto L_0x0068
        L_0x0056:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006d
        L_0x005c:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
        L_0x0068:
            r17 = r14
            r14 = r4
            r4 = r17
        L_0x006d:
            r15 = 16
            if (r12 == r15) goto L_0x008e
            r15 = 48
            if (r12 == r15) goto L_0x0088
            r15 = 80
            if (r12 == r15) goto L_0x007b
            r12 = r5
            goto L_0x009f
        L_0x007b:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
            goto L_0x009a
        L_0x0088:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x009f
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
        L_0x009a:
            r17 = r12
            r12 = r5
            r5 = r17
        L_0x009f:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r5 + r16
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b6:
            int r2 = r2 - r4
            int r2 = r2 - r6
            r6 = 0
        L_0x00b9:
            if (r6 >= r1) goto L_0x0106
            android.view.View r8 = r0.getChildAt(r6)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0103
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.hbg.lib.common.utils.ViewPager$LayoutParams r9 = (com.hbg.lib.common.utils.ViewPager.LayoutParams) r9
            boolean r10 = r9.f67535a
            if (r10 != 0) goto L_0x0103
            com.hbg.lib.common.utils.ViewPager$d r10 = r0.u(r8)
            if (r10 == 0) goto L_0x0103
            float r13 = (float) r2
            float r10 = r10.f67546e
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r4
            boolean r14 = r9.f67538d
            if (r14 == 0) goto L_0x00f6
            r14 = 0
            r9.f67538d = r14
            float r9 = r9.f67537c
            float r13 = r13 * r9
            int r9 = (int) r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r14 = r3 - r5
            int r14 = r14 - r7
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r8.measure(r9, r13)
        L_0x00f6:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r10
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r5
            r8.layout(r10, r5, r9, r13)
        L_0x0103:
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x0106:
            r0.f67523o = r5
            int r3 = r3 - r7
            r0.f67524p = r3
            r0.T = r11
            boolean r1 = r0.Q
            if (r1 == 0) goto L_0x0118
            int r1 = r0.f67514g
            r2 = 0
            r0.K(r1, r2, r2, r2)
            goto L_0x0119
        L_0x0118:
            r2 = 0
        L_0x0119:
            r0.Q = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i11, int i12) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i13;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i11), ViewGroup.getDefaultSize(0, i12));
        int measuredWidth = getMeasuredWidth();
        this.B = Math.min(measuredWidth / 10, this.A);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i14 = 0;
        while (true) {
            boolean z11 = true;
            int i15 = 1073741824;
            if (i14 >= childCount) {
                break;
            }
            View childAt = getChildAt(i14);
            if (!(childAt.getVisibility() == 8 || (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams2.f67535a)) {
                int i16 = layoutParams2.f67536b;
                int i17 = i16 & 7;
                int i18 = i16 & 112;
                boolean z12 = i18 == 48 || i18 == 80;
                if (!(i17 == 3 || i17 == 5)) {
                    z11 = false;
                }
                int i19 = Integer.MIN_VALUE;
                if (z12) {
                    i13 = Integer.MIN_VALUE;
                    i19 = 1073741824;
                } else {
                    i13 = z11 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i21 = layoutParams2.width;
                if (i21 != -2) {
                    if (i21 == -1) {
                        i21 = paddingLeft;
                    }
                    i19 = 1073741824;
                } else {
                    i21 = paddingLeft;
                }
                int i22 = layoutParams2.height;
                if (i22 == -2) {
                    i22 = measuredHeight;
                    i15 = i13;
                } else if (i22 == -1) {
                    i22 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i21, i19), View.MeasureSpec.makeMeasureSpec(i22, i15));
                if (z12) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z11) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i14++;
        }
        this.f67527s = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f67528t = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f67529u = true;
        F();
        this.f67529u = false;
        int childCount2 = getChildCount();
        for (int i23 = 0; i23 < childCount2; i23++) {
            View childAt2 = getChildAt(i23);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f67535a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * layoutParams.f67537c), 1073741824), this.f67528t);
            }
        }
    }

    public boolean onRequestFocusInDescendants(int i11, Rect rect) {
        int i12;
        int i13;
        d u11;
        int childCount = getChildCount();
        int i14 = -1;
        if ((i11 & 2) != 0) {
            i14 = childCount;
            i13 = 0;
            i12 = 1;
        } else {
            i13 = childCount - 1;
            i12 = -1;
        }
        while (i13 != i14) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 0 && (u11 = u(childAt)) != null && u11.f67543b == this.f67514g && childAt.requestFocus(i11, rect)) {
                return true;
            }
            i13 += i12;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.f67512f;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
            M(savedState.position, false, true);
            return;
        }
        this.f67516h = savedState.position;
        this.f67517i = savedState.adapterState;
        this.f67518j = savedState.loader;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.f67514g;
        PagerAdapter pagerAdapter = this.f67512f;
        if (pagerAdapter != null) {
            savedState.adapterState = pagerAdapter.saveState();
        }
        return savedState;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13) {
            int i15 = this.f67521m;
            H(i11, i13, i15, i15);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        boolean z11;
        boolean z12;
        float f11;
        if (this.N) {
            return true;
        }
        boolean z13 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f67512f) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.f67533y) {
                        int a11 = n.a(motionEvent, this.H);
                        float e11 = n.e(motionEvent, a11);
                        float abs = Math.abs(e11 - this.D);
                        float f12 = n.f(motionEvent, a11);
                        float abs2 = Math.abs(f12 - this.E);
                        if (abs > ((float) this.C) && abs > abs2) {
                            this.f67533y = true;
                            J(true);
                            float f13 = this.F;
                            if (e11 - f13 > 0.0f) {
                                f11 = f13 + ((float) this.C);
                            } else {
                                f11 = f13 - ((float) this.C);
                            }
                            this.D = f11;
                            this.E = f12;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.f67533y) {
                        z13 = false | E(n.e(motionEvent, n.a(motionEvent, this.H)));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int b11 = n.b(motionEvent);
                        this.D = n.e(motionEvent, b11);
                        this.H = n.d(motionEvent, b11);
                    } else if (action == 6) {
                        A(motionEvent);
                        this.D = n.e(motionEvent, n.a(motionEvent, this.H));
                    }
                } else if (this.f67533y) {
                    K(this.f67514g, true, 0, false);
                    this.H = -1;
                    q();
                    z11 = this.O.i();
                    z12 = this.P.i();
                }
            } else if (this.f67533y) {
                VelocityTracker velocityTracker = this.I;
                velocityTracker.computeCurrentVelocity(1000, (float) this.K);
                int a12 = (int) f0.a(velocityTracker, this.H);
                this.f67531w = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                d v11 = v();
                N(k(v11.f67543b, ((((float) scrollX) / ((float) clientWidth)) - v11.f67546e) / v11.f67545d, a12, (int) (n.e(motionEvent, n.a(motionEvent, this.H)) - this.F)), true, true, a12);
                this.H = -1;
                q();
                z11 = this.O.i();
                z12 = this.P.i();
            }
            z13 = z11 | z12;
        } else {
            this.f67519k.abortAnimation();
            this.f67531w = false;
            F();
            float x11 = motionEvent.getX();
            this.F = x11;
            this.D = x11;
            float y11 = motionEvent.getY();
            this.G = y11;
            this.E = y11;
            this.H = n.d(motionEvent, 0);
        }
        if (z13) {
            h0.n0(this);
        }
        return true;
    }

    public final void p(boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            h0.M0(getChildAt(i11), z11 ? 2 : 0, (Paint) null);
        }
    }

    public final void q() {
        this.f67533y = false;
        this.f67534z = false;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
    }

    public boolean r(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return f(17);
            }
            if (keyCode == 22) {
                return f(66);
            }
            if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                if (keyEvent.hasNoModifiers()) {
                    return f(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return f(1);
                }
            }
        }
        return false;
    }

    public void removeView(View view) {
        if (this.f67529u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final Rect s(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.f67512f;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.f67520l);
            this.f67512f.startUpdate((ViewGroup) this);
            for (int i11 = 0; i11 < this.f67506c.size(); i11++) {
                d dVar = this.f67506c.get(i11);
                this.f67512f.destroyItem((ViewGroup) this, dVar.f67543b, dVar.f67542a);
            }
            this.f67512f.finishUpdate((ViewGroup) this);
            this.f67506c.clear();
            I();
            this.f67514g = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.f67512f;
        this.f67512f = pagerAdapter;
        this.f67504b = 0;
        if (pagerAdapter != null) {
            if (this.f67520l == null) {
                this.f67520l = new i(this, (a) null);
            }
            this.f67512f.registerDataSetObserver(this.f67520l);
            this.f67531w = false;
            boolean z11 = this.Q;
            this.Q = true;
            this.f67504b = this.f67512f.getCount();
            if (this.f67516h >= 0) {
                this.f67512f.restoreState(this.f67517i, this.f67518j);
                M(this.f67516h, false, true);
                this.f67516h = -1;
                this.f67517i = null;
                this.f67518j = null;
            } else if (!z11) {
                F();
            } else {
                requestLayout();
            }
        }
        f fVar = this.f67503a0;
        if (fVar != null && pagerAdapter3 != pagerAdapter) {
            fVar.a(pagerAdapter3, pagerAdapter);
        }
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z11) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.f67507c0 == null) {
                Class<ViewGroup> cls = ViewGroup.class;
                try {
                    this.f67507c0 = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e11) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e11);
                }
            }
            try {
                this.f67507c0.invoke(this, new Object[]{Boolean.valueOf(z11)});
            } catch (Exception e12) {
                Log.e("ViewPager", "Error changing children drawing order", e12);
            }
        }
    }

    public void setCurrentItem(int i11) {
        this.f67531w = false;
        M(i11, !this.Q, false);
    }

    public void setOffscreenPageLimit(int i11) {
        if (i11 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i11 + " too small; defaulting to " + 1);
            i11 = 1;
        }
        if (i11 != this.f67532x) {
            this.f67532x = i11;
            F();
        }
    }

    public void setOnAdapterChangeListener(f fVar) {
        this.f67503a0 = fVar;
    }

    @Deprecated
    public void setOnPageChangeListener(g gVar) {
        this.V = gVar;
    }

    public void setPageMargin(int i11) {
        int i12 = this.f67521m;
        this.f67521m = i11;
        int width = getWidth();
        H(width, width, i11, i12);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f67522n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public d t(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return u(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public d u(View view) {
        for (int i11 = 0; i11 < this.f67506c.size(); i11++) {
            d dVar = this.f67506c.get(i11);
            if (this.f67512f.isViewFromObject(view, dVar.f67542a)) {
                return dVar;
            }
        }
        return null;
    }

    public final d v() {
        int i11;
        int clientWidth = getClientWidth();
        float f11 = 0.0f;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f12 = clientWidth > 0 ? ((float) this.f67521m) / ((float) clientWidth) : 0.0f;
        d dVar = null;
        int i12 = 0;
        int i13 = -1;
        boolean z11 = true;
        float f13 = 0.0f;
        while (i12 < this.f67506c.size()) {
            d dVar2 = this.f67506c.get(i12);
            if (!z11 && dVar2.f67543b != (i11 = i13 + 1)) {
                dVar2 = this.f67508d;
                dVar2.f67546e = f11 + f13 + f12;
                dVar2.f67543b = i11;
                dVar2.f67545d = this.f67512f.getPageWidth(i11);
                i12--;
            }
            f11 = dVar2.f67546e;
            float f14 = dVar2.f67545d + f11 + f12;
            if (!z11 && scrollX < f11) {
                return dVar;
            }
            if (scrollX < f14 || i12 == this.f67506c.size() - 1) {
                return dVar2;
            }
            i13 = dVar2.f67543b;
            f13 = dVar2.f67545d;
            i12++;
            z11 = false;
            dVar = dVar2;
        }
        return dVar;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f67522n;
    }

    public d w(int i11) {
        for (int i12 = 0; i12 < this.f67506c.size(); i12++) {
            d dVar = this.f67506c.get(i12);
            if (dVar.f67543b == i11) {
                return dVar;
            }
        }
        return null;
    }

    public void x() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f67519k = new Scroller(context, f67501j0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.C = j0.e(viewConfiguration);
        this.J = (int) (400.0f * f11);
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O = new androidx.core.widget.g(context);
        this.P = new androidx.core.widget.g(context);
        this.L = (int) (25.0f * f11);
        this.M = (int) (2.0f * f11);
        this.A = (int) (f11 * 16.0f);
        h0.x0(this, new e());
        if (h0.D(this) == 0) {
            h0.I0(this, 1);
        }
    }

    public final boolean y(float f11, float f12) {
        return (f11 < ((float) this.B) && f12 > 0.0f) || (f11 > ((float) (getWidth() - this.B)) && f12 < 0.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.T
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L_0x001b:
            if (r7 >= r6) goto L_0x006b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.hbg.lib.common.utils.ViewPager$LayoutParams r9 = (com.hbg.lib.common.utils.ViewPager.LayoutParams) r9
            boolean r10 = r9.f67535a
            if (r10 != 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            int r9 = r9.f67536b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004d
            r10 = 3
            if (r9 == r10) goto L_0x0047
            r10 = 5
            if (r9 == r10) goto L_0x003a
            r9 = r3
            goto L_0x005c
        L_0x003a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L_0x0059
        L_0x0047:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L_0x005c
        L_0x004d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L_0x0059:
            r11 = r9
            r9 = r3
            r3 = r11
        L_0x005c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L_0x0067
            r8.offsetLeftAndRight(r3)
        L_0x0067:
            r3 = r9
        L_0x0068:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x006b:
            r12.l(r13, r14, r15)
            com.hbg.lib.common.utils.ViewPager$h r13 = r12.f67505b0
            if (r13 == 0) goto L_0x009f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007a:
            if (r1 >= r14) goto L_0x009f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.hbg.lib.common.utils.ViewPager$LayoutParams r0 = (com.hbg.lib.common.utils.ViewPager.LayoutParams) r0
            boolean r0 = r0.f67535a
            if (r0 == 0) goto L_0x008b
            goto L_0x009c
        L_0x008b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.hbg.lib.common.utils.ViewPager$h r3 = r12.f67505b0
            r3.transformPage(r15, r0)
        L_0x009c:
            int r1 = r1 + 1
            goto L_0x007a
        L_0x009f:
            r12.S = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.ViewPager.z(int, float, int):void");
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f67535a;

        /* renamed from: b  reason: collision with root package name */
        public int f67536b;

        /* renamed from: c  reason: collision with root package name */
        public float f67537c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67538d;

        /* renamed from: e  reason: collision with root package name */
        public int f67539e;

        /* renamed from: f  reason: collision with root package name */
        public int f67540f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f67499h0);
            this.f67536b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i11) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i11));
    }
}
