package com.cpiz.android.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.cpiz.android.bubbleview.BubbleStyle;
import com.hbg.lib.widgets.R$styleable;
import java.lang.ref.WeakReference;

public class BubbleImpl implements BubbleStyle {
    public int[] A = new int[2];
    public Rect B = new Rect();
    public Rect C = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public View f64722b;

    /* renamed from: c  reason: collision with root package name */
    public m4.a f64723c;

    /* renamed from: d  reason: collision with root package name */
    public a f64724d = new a();

    /* renamed from: e  reason: collision with root package name */
    public BubbleStyle.ArrowDirection f64725e = BubbleStyle.ArrowDirection.Auto;

    /* renamed from: f  reason: collision with root package name */
    public BubbleStyle.ArrowDirection f64726f = BubbleStyle.ArrowDirection.None;

    /* renamed from: g  reason: collision with root package name */
    public BubbleStyle.ArrowPosPolicy f64727g = BubbleStyle.ArrowPosPolicy.TargetCenter;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<View> f64728h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f64729i = 0;

    /* renamed from: j  reason: collision with root package name */
    public float f64730j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f64731k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f64732l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f64733m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public float f64734n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public float f64735o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    public float f64736p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    public int f64737q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f64738r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f64739s = 0;

    /* renamed from: t  reason: collision with root package name */
    public int f64740t = 0;

    /* renamed from: u  reason: collision with root package name */
    public int f64741u = -872415232;

    /* renamed from: v  reason: collision with root package name */
    public int f64742v = -1;

    /* renamed from: w  reason: collision with root package name */
    public float f64743w = 0.0f;

    /* renamed from: x  reason: collision with root package name */
    public float f64744x = 0.0f;

    /* renamed from: y  reason: collision with root package name */
    public int f64745y = 0;

    /* renamed from: z  reason: collision with root package name */
    public View.OnLayoutChangeListener f64746z = new a();

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            BubbleImpl.this.w();
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f64748b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f64749c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f64750d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f64751e;

        public b(int i11, int i12, int i13, int i14) {
            this.f64748b = i11;
            this.f64749c = i12;
            this.f64750d = i13;
            this.f64751e = i14;
        }

        public void run() {
            BubbleImpl.this.f64723c.a(this.f64748b, this.f64749c, this.f64750d, this.f64751e);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64753a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection[] r0 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f64753a = r0
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Left     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f64753a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Up     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f64753a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Right     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f64753a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Down     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f64753a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Auto     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f64753a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.None     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cpiz.android.bubbleview.BubbleImpl.c.<clinit>():void");
        }
    }

    public static BubbleStyle.ArrowDirection i(Rect rect, Rect rect2) {
        if (!rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom)) {
            Point point = new Point(rect.centerX() - rect2.centerX(), rect.centerY() - rect2.centerY());
            if (Math.abs(point.x) < (rect.width() / 2) + (rect2.width() / 2)) {
                int i11 = point.y;
                if (i11 < 0) {
                    return BubbleStyle.ArrowDirection.Down;
                }
                if (i11 > 0) {
                    return BubbleStyle.ArrowDirection.Up;
                }
            } else if (Math.abs(point.y) < (rect.height() / 2) + (rect2.height() / 2)) {
                int i12 = point.x;
                if (i12 < 0) {
                    return BubbleStyle.ArrowDirection.Right;
                }
                if (i12 > 0) {
                    return BubbleStyle.ArrowDirection.Left;
                }
            }
        }
        return BubbleStyle.ArrowDirection.None;
    }

    public final void A(View view) {
        View view2;
        WeakReference<View> weakReference = this.f64728h;
        if (!(weakReference == null || (view2 = (View) weakReference.get()) == null)) {
            view2.removeOnLayoutChangeListener(this.f64746z);
        }
        this.f64728h = view != null ? new WeakReference<>(view) : null;
        if (view != null) {
            view.addOnLayoutChangeListener(this.f64746z);
        }
    }

    public void B(float f11) {
        this.f64731k = f11;
    }

    public void C(int i11) {
        this.f64742v = i11;
    }

    public void D(float f11) {
        E(f11, f11, f11, f11);
    }

    public void E(float f11, float f12, float f13, float f14) {
        this.f64733m = f11;
        this.f64734n = f12;
        this.f64736p = f13;
        this.f64735o = f14;
    }

    public void F(int i11) {
        this.f64741u = i11;
    }

    public void G(float f11) {
        this.f64744x = f11;
    }

    public void H(int i11, int i12, int i13, int i14) {
        if (this.f64723c != null) {
            if (Build.VERSION.SDK_INT <= 16) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                int i15 = 0;
                while (i15 < 7) {
                    if (!stackTrace[i15].getClassName().equals(View.class.getName()) || !stackTrace[i15].getMethodName().equals("recomputePadding")) {
                        i15++;
                    } else {
                        Log.w("BubbleImpl", "Called setPadding by View on old Android platform");
                        this.f64723c.a(i11, i12, i13, i14);
                        return;
                    }
                }
            }
            this.f64740t = 0;
            this.f64739s = 0;
            this.f64738r = 0;
            this.f64737q = 0;
            int i16 = c.f64753a[this.f64726f.ordinal()];
            if (i16 == 1) {
                this.f64737q = (int) (((float) this.f64737q) + this.f64730j);
            } else if (i16 == 2) {
                this.f64738r = (int) (((float) this.f64738r) + this.f64730j);
            } else if (i16 == 3) {
                this.f64739s = (int) (((float) this.f64739s) + this.f64730j);
            } else if (i16 == 4) {
                this.f64740t = (int) (((float) this.f64740t) + this.f64730j);
            }
            int i17 = i11 + this.f64737q;
            int i18 = i12 + this.f64738r;
            int i19 = i13 + this.f64739s;
            int i21 = i14 + this.f64740t;
            if (i17 != this.f64723c.getSuperPaddingLeft() || i18 != this.f64723c.getSuperPaddingTop() || i19 != this.f64723c.getSuperPaddingRight() || i21 != this.f64723c.getSuperPaddingBottom()) {
                this.f64722b.post(new b(i17, i18, i19, i21));
            }
        }
    }

    public void I(int i11, int i12, boolean z11) {
        int i13;
        int i14;
        View g11 = g();
        if (g11 == null && (i14 = this.f64729i) != 0) {
            g11 = b(i14);
            A(g11);
        }
        this.f64726f = this.f64725e;
        int i15 = 0;
        if (g11 != null) {
            g11.getLocationOnScreen(this.A);
            Rect rect = this.B;
            int[] iArr = this.A;
            rect.set(iArr[0], iArr[1], iArr[0] + g11.getWidth(), this.A[1] + g11.getHeight());
            this.f64722b.getLocationOnScreen(this.A);
            Rect rect2 = this.C;
            int[] iArr2 = this.A;
            rect2.set(iArr2[0], iArr2[1], iArr2[0] + i11, iArr2[1] + i12);
            if (this.f64726f == BubbleStyle.ArrowDirection.Auto) {
                this.f64726f = i(this.C, this.B);
            }
            i15 = this.B.centerX() - this.C.centerX();
            i13 = this.B.centerY() - this.C.centerY();
        } else {
            i13 = 0;
        }
        H(this.f64722b.getPaddingLeft(), this.f64722b.getPaddingTop(), this.f64722b.getPaddingRight(), this.f64722b.getPaddingBottom());
        if (z11) {
            this.f64724d.m(i11, i12);
            this.f64724d.w(this.f64733m, this.f64734n, this.f64736p, this.f64735o);
            this.f64724d.x(this.f64741u);
            this.f64724d.v(this.f64743w);
            this.f64724d.y(this.f64744x);
            this.f64724d.u(this.f64742v);
            this.f64724d.o(this.f64726f);
            this.f64724d.r(this.f64727g);
            this.f64724d.s((float) i15, (float) i13);
            this.f64724d.q(this.f64732l);
            this.f64724d.p(this.f64730j);
            this.f64724d.t(this.f64731k);
            this.f64724d.n(this.f64745y);
            this.f64724d.E();
            if (Build.VERSION.SDK_INT >= 16) {
                this.f64722b.setBackground(this.f64724d);
            } else {
                this.f64722b.setBackgroundDrawable(this.f64724d);
            }
        }
    }

    public final View b(int i11) {
        if (i11 == 0) {
            return null;
        }
        View view = this.f64722b;
        while (view.getParent() instanceof View) {
            view = (View) view.getParent();
            View findViewById = view.findViewById(i11);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }

    public BubbleStyle.ArrowDirection c() {
        return this.f64725e;
    }

    public float d() {
        return this.f64730j;
    }

    public float e() {
        return this.f64732l;
    }

    public BubbleStyle.ArrowPosPolicy f() {
        return this.f64727g;
    }

    public View g() {
        WeakReference<View> weakReference = this.f64728h;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public float h() {
        return this.f64731k;
    }

    public int j() {
        return this.f64742v;
    }

    public float k() {
        return this.f64743w;
    }

    public float l() {
        return this.f64735o;
    }

    public float m() {
        return this.f64736p;
    }

    public float n() {
        return this.f64733m;
    }

    public float o() {
        return this.f64734n;
    }

    public int p() {
        return this.f64741u;
    }

    public float q() {
        return this.f64744x;
    }

    public int r() {
        return this.f64723c.getSuperPaddingBottom() - this.f64740t;
    }

    public int s() {
        return this.f64723c.getSuperPaddingLeft() - this.f64737q;
    }

    public void setArrowDirection(BubbleStyle.ArrowDirection arrowDirection) {
        this.f64725e = arrowDirection;
    }

    public void setArrowPosDelta(float f11) {
        this.f64732l = f11;
    }

    public void setArrowPosPolicy(BubbleStyle.ArrowPosPolicy arrowPosPolicy) {
        this.f64727g = arrowPosPolicy;
    }

    public void setArrowTo(View view) {
        this.f64729i = view != null ? view.getId() : 0;
        A(view);
    }

    public void setBorderWidth(float f11) {
        this.f64743w = f11;
    }

    public int t() {
        return this.f64723c.getSuperPaddingRight() - this.f64739s;
    }

    public int u() {
        return this.f64723c.getSuperPaddingTop() - this.f64738r;
    }

    public void v(View view, Context context, AttributeSet attributeSet) {
        this.f64722b = view;
        this.f64723c = (m4.a) view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BubbleStyle);
            this.f64725e = BubbleStyle.ArrowDirection.valueOf(obtainStyledAttributes.getInt(R$styleable.BubbleStyle_bb_arrowDirection, BubbleStyle.ArrowDirection.Auto.getValue()));
            this.f64730j = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_arrowHeight, (float) Utils.b(6));
            this.f64731k = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_arrowWidth, (float) Utils.b(10));
            this.f64727g = BubbleStyle.ArrowPosPolicy.valueOf(obtainStyledAttributes.getInt(R$styleable.BubbleStyle_bb_arrowPosPolicy, BubbleStyle.ArrowPosPolicy.TargetCenter.getValue()));
            this.f64732l = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_arrowPosDelta, 0.0f);
            this.f64729i = obtainStyledAttributes.getResourceId(R$styleable.BubbleStyle_bb_arrowTo, 0);
            float dimension = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_cornerRadius, 0.0f);
            this.f64736p = dimension;
            this.f64735o = dimension;
            this.f64734n = dimension;
            this.f64733m = dimension;
            float dimension2 = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_cornerTopLeftRadius, dimension);
            this.f64733m = dimension2;
            this.f64734n = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_cornerTopRightRadius, dimension2);
            this.f64735o = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_cornerBottomLeftRadius, this.f64733m);
            this.f64736p = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_cornerBottomRightRadius, this.f64733m);
            this.f64741u = obtainStyledAttributes.getColor(R$styleable.BubbleStyle_bb_fillColor, -872415232);
            this.f64744x = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_fillPadding, 0.0f);
            this.f64742v = obtainStyledAttributes.getColor(R$styleable.BubbleStyle_bb_borderColor, -1);
            this.f64743w = obtainStyledAttributes.getDimension(R$styleable.BubbleStyle_bb_borderWidth, 0.0f);
            obtainStyledAttributes.recycle();
        }
        I(this.f64722b.getWidth(), this.f64722b.getHeight(), false);
    }

    public void w() {
        I(this.f64722b.getWidth(), this.f64722b.getHeight(), true);
    }

    public void x(int i11) {
        this.f64745y = i11;
    }

    public void y(float f11) {
        this.f64730j = f11;
    }

    public void z(int i11) {
        this.f64729i = i11;
        A((View) null);
    }
}
