package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class d {
    public HashMap<String, ViewTimeCycle> A;
    public HashMap<String, ViewSpline> B;
    public HashMap<String, ViewOscillator> C;
    public KeyTrigger[] D;
    public int E;
    public int F;
    public View G;
    public int H;
    public float I;
    public Interpolator J;
    public boolean K;

    /* renamed from: a  reason: collision with root package name */
    public Rect f7660a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public View f7661b;

    /* renamed from: c  reason: collision with root package name */
    public int f7662c;

    /* renamed from: d  reason: collision with root package name */
    public String f7663d;

    /* renamed from: e  reason: collision with root package name */
    public int f7664e = -1;

    /* renamed from: f  reason: collision with root package name */
    public MotionPaths f7665f = new MotionPaths();

    /* renamed from: g  reason: collision with root package name */
    public MotionPaths f7666g = new MotionPaths();

    /* renamed from: h  reason: collision with root package name */
    public MotionConstrainedPoint f7667h = new MotionConstrainedPoint();

    /* renamed from: i  reason: collision with root package name */
    public MotionConstrainedPoint f7668i = new MotionConstrainedPoint();

    /* renamed from: j  reason: collision with root package name */
    public CurveFit[] f7669j;

    /* renamed from: k  reason: collision with root package name */
    public CurveFit f7670k;

    /* renamed from: l  reason: collision with root package name */
    public float f7671l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f7672m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public float f7673n = 1.0f;

    /* renamed from: o  reason: collision with root package name */
    public float f7674o;

    /* renamed from: p  reason: collision with root package name */
    public float f7675p;

    /* renamed from: q  reason: collision with root package name */
    public int[] f7676q;

    /* renamed from: r  reason: collision with root package name */
    public double[] f7677r;

    /* renamed from: s  reason: collision with root package name */
    public double[] f7678s;

    /* renamed from: t  reason: collision with root package name */
    public String[] f7679t;

    /* renamed from: u  reason: collision with root package name */
    public int[] f7680u;

    /* renamed from: v  reason: collision with root package name */
    public int f7681v = 4;

    /* renamed from: w  reason: collision with root package name */
    public float[] f7682w = new float[4];

    /* renamed from: x  reason: collision with root package name */
    public ArrayList<MotionPaths> f7683x = new ArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    public float[] f7684y = new float[1];

    /* renamed from: z  reason: collision with root package name */
    public ArrayList<Key> f7685z = new ArrayList<>();

    public class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Easing f7686a;

        public a(Easing easing) {
            this.f7686a = easing;
        }

        public float getInterpolation(float f11) {
            return (float) this.f7686a.a((double) f11);
        }
    }

    public d(View view) {
        int i11 = Key.f7390f;
        this.E = i11;
        this.F = i11;
        this.G = null;
        this.H = i11;
        this.I = Float.NaN;
        this.J = null;
        this.K = false;
        G(view);
    }

    public static Interpolator p(Context context, int i11, String str, int i12) {
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(context, i12);
        }
        if (i11 == -1) {
            return new a(Easing.c(str));
        }
        if (i11 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i11 == 1) {
            return new AccelerateInterpolator();
        }
        if (i11 == 2) {
            return new DecelerateInterpolator();
        }
        if (i11 == 4) {
            return new BounceInterpolator();
        }
        if (i11 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    public void A(View view) {
        MotionPaths motionPaths = this.f7665f;
        motionPaths.f7616d = 0.0f;
        motionPaths.f7617e = 0.0f;
        this.K = true;
        motionPaths.q(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f7666g.q(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f7667h.k(view);
        this.f7668i.k(view);
    }

    public void B(Rect rect, ConstraintSet constraintSet, int i11, int i12) {
        int i13 = constraintSet.f7992d;
        if (i13 != 0) {
            z(rect, this.f7660a, i13, i11, i12);
            rect = this.f7660a;
        }
        MotionPaths motionPaths = this.f7666g;
        motionPaths.f7616d = 1.0f;
        motionPaths.f7617e = 1.0f;
        y(motionPaths);
        this.f7666g.q((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.f7666g.a(constraintSet.z(this.f7662c));
        this.f7668i.j(rect, constraintSet, i13, this.f7662c);
    }

    public void C(int i11) {
        this.E = i11;
    }

    public void D(View view) {
        MotionPaths motionPaths = this.f7665f;
        motionPaths.f7616d = 0.0f;
        motionPaths.f7617e = 0.0f;
        motionPaths.q(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f7667h.k(view);
    }

    public void E(Rect rect, ConstraintSet constraintSet, int i11, int i12) {
        int i13 = constraintSet.f7992d;
        if (i13 != 0) {
            z(rect, this.f7660a, i13, i11, i12);
        }
        MotionPaths motionPaths = this.f7665f;
        motionPaths.f7616d = 0.0f;
        motionPaths.f7617e = 0.0f;
        y(motionPaths);
        this.f7665f.q((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        ConstraintSet.Constraint z11 = constraintSet.z(this.f7662c);
        this.f7665f.a(z11);
        this.f7671l = z11.f7999d.f8066g;
        this.f7667h.j(rect, constraintSet, i13, this.f7662c);
        this.F = z11.f8001f.f8088i;
        ConstraintSet.Motion motion = z11.f7999d;
        this.H = motion.f8070k;
        this.I = motion.f8069j;
        Context context = this.f7661b.getContext();
        ConstraintSet.Motion motion2 = z11.f7999d;
        this.J = p(context, motion2.f8072m, motion2.f8071l, motion2.f8073n);
    }

    public void F(ViewState viewState, View view, int i11, int i12, int i13) {
        MotionPaths motionPaths = this.f7665f;
        motionPaths.f7616d = 0.0f;
        motionPaths.f7617e = 0.0f;
        Rect rect = new Rect();
        if (i11 == 1) {
            int i14 = viewState.f7380b + viewState.f7382d;
            rect.left = ((viewState.f7381c + viewState.f7383e) - viewState.b()) / 2;
            rect.top = i12 - ((i14 + viewState.a()) / 2);
            rect.right = rect.left + viewState.b();
            rect.bottom = rect.top + viewState.a();
        } else if (i11 == 2) {
            int i15 = viewState.f7380b + viewState.f7382d;
            rect.left = i13 - (((viewState.f7381c + viewState.f7383e) + viewState.b()) / 2);
            rect.top = (i15 - viewState.a()) / 2;
            rect.right = rect.left + viewState.b();
            rect.bottom = rect.top + viewState.a();
        }
        this.f7665f.q((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.f7667h.i(rect, view, i11, viewState.f7379a);
    }

    public void G(View view) {
        this.f7661b = view;
        this.f7662c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f7663d = ((ConstraintLayout.LayoutParams) layoutParams).a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0157, code lost:
        r11 = (java.lang.Integer) r5.get(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H(int r18, int r19, float r20, long r21) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Class<double> r1 = double.class
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            int r6 = r0.E
            int r7 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r6 == r7) goto L_0x0027
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.f7665f
            r7.f7624l = r6
        L_0x0027:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.f7667h
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r7 = r0.f7668i
            r6.g(r7, r3)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r6 = r0.f7685z
            if (r6 == 0) goto L_0x008e
            java.util.Iterator r6 = r6.iterator()
            r8 = 0
        L_0x0037:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x008f
            java.lang.Object r9 = r6.next()
            androidx.constraintlayout.motion.widget.Key r9 = (androidx.constraintlayout.motion.widget.Key) r9
            boolean r10 = r9 instanceof androidx.constraintlayout.motion.widget.KeyPosition
            if (r10 == 0) goto L_0x0066
            androidx.constraintlayout.motion.widget.KeyPosition r9 = (androidx.constraintlayout.motion.widget.KeyPosition) r9
            androidx.constraintlayout.motion.widget.MotionPaths r10 = new androidx.constraintlayout.motion.widget.MotionPaths
            androidx.constraintlayout.motion.widget.MotionPaths r15 = r0.f7665f
            androidx.constraintlayout.motion.widget.MotionPaths r14 = r0.f7666g
            r11 = r10
            r12 = r18
            r13 = r19
            r16 = r14
            r14 = r9
            r11.<init>(r12, r13, r14, r15, r16)
            r0.w(r10)
            int r9 = r9.f7659g
            int r10 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r9 == r10) goto L_0x0037
            r0.f7664e = r9
            goto L_0x0037
        L_0x0066:
            boolean r10 = r9 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r10 == 0) goto L_0x006e
            r9.d(r4)
            goto L_0x0037
        L_0x006e:
            boolean r10 = r9 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r10 == 0) goto L_0x0076
            r9.d(r2)
            goto L_0x0037
        L_0x0076:
            boolean r10 = r9 instanceof androidx.constraintlayout.motion.widget.KeyTrigger
            if (r10 == 0) goto L_0x0087
            if (r8 != 0) goto L_0x0081
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0081:
            androidx.constraintlayout.motion.widget.KeyTrigger r9 = (androidx.constraintlayout.motion.widget.KeyTrigger) r9
            r8.add(r9)
            goto L_0x0037
        L_0x0087:
            r9.h(r5)
            r9.d(r3)
            goto L_0x0037
        L_0x008e:
            r8 = 0
        L_0x008f:
            r6 = 0
            if (r8 == 0) goto L_0x009c
            androidx.constraintlayout.motion.widget.KeyTrigger[] r9 = new androidx.constraintlayout.motion.widget.KeyTrigger[r6]
            java.lang.Object[] r8 = r8.toArray(r9)
            androidx.constraintlayout.motion.widget.KeyTrigger[] r8 = (androidx.constraintlayout.motion.widget.KeyTrigger[]) r8
            r0.D = r8
        L_0x009c:
            boolean r8 = r3.isEmpty()
            java.lang.String r9 = ","
            java.lang.String r10 = "CUSTOM,"
            r11 = 1
            if (r8 != 0) goto L_0x0173
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r0.B = r8
            java.util.Iterator r8 = r3.iterator()
        L_0x00b2:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x010d
            java.lang.Object r12 = r8.next()
            java.lang.String r12 = (java.lang.String) r12
            boolean r13 = r12.startsWith(r10)
            if (r13 == 0) goto L_0x00fc
            android.util.SparseArray r13 = new android.util.SparseArray
            r13.<init>()
            java.lang.String[] r14 = r12.split(r9)
            r14 = r14[r11]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r15 = r0.f7685z
            java.util.Iterator r15 = r15.iterator()
        L_0x00d5:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x00f7
            java.lang.Object r16 = r15.next()
            r7 = r16
            androidx.constraintlayout.motion.widget.Key r7 = (androidx.constraintlayout.motion.widget.Key) r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r11 = r7.f7395e
            if (r11 != 0) goto L_0x00e9
        L_0x00e7:
            r11 = 1
            goto L_0x00d5
        L_0x00e9:
            java.lang.Object r11 = r11.get(r14)
            androidx.constraintlayout.widget.ConstraintAttribute r11 = (androidx.constraintlayout.widget.ConstraintAttribute) r11
            if (r11 == 0) goto L_0x00e7
            int r7 = r7.f7391a
            r13.append(r7, r11)
            goto L_0x00e7
        L_0x00f7:
            androidx.constraintlayout.motion.utils.ViewSpline r7 = androidx.constraintlayout.motion.utils.ViewSpline.f(r12, r13)
            goto L_0x0100
        L_0x00fc:
            androidx.constraintlayout.motion.utils.ViewSpline r7 = androidx.constraintlayout.motion.utils.ViewSpline.g(r12)
        L_0x0100:
            if (r7 != 0) goto L_0x0103
            goto L_0x010b
        L_0x0103:
            r7.d(r12)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r11 = r0.B
            r11.put(r12, r7)
        L_0x010b:
            r11 = 1
            goto L_0x00b2
        L_0x010d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r7 = r0.f7685z
            if (r7 == 0) goto L_0x012b
            java.util.Iterator r7 = r7.iterator()
        L_0x0115:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x012b
            java.lang.Object r8 = r7.next()
            androidx.constraintlayout.motion.widget.Key r8 = (androidx.constraintlayout.motion.widget.Key) r8
            boolean r11 = r8 instanceof androidx.constraintlayout.motion.widget.KeyAttributes
            if (r11 == 0) goto L_0x0115
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r11 = r0.B
            r8.a(r11)
            goto L_0x0115
        L_0x012b:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r7 = r0.f7667h
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r8 = r0.B
            r7.a(r8, r6)
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r7 = r0.f7668i
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r8 = r0.B
            r11 = 100
            r7.a(r8, r11)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r7 = r0.B
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0145:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0173
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            boolean r11 = r5.containsKey(r8)
            if (r11 == 0) goto L_0x0164
            java.lang.Object r11 = r5.get(r8)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 == 0) goto L_0x0164
            int r11 = r11.intValue()
            goto L_0x0165
        L_0x0164:
            r11 = r6
        L_0x0165:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r12 = r0.B
            java.lang.Object r8 = r12.get(r8)
            androidx.constraintlayout.core.motion.utils.SplineSet r8 = (androidx.constraintlayout.core.motion.utils.SplineSet) r8
            if (r8 == 0) goto L_0x0145
            r8.e(r11)
            goto L_0x0145
        L_0x0173:
            boolean r7 = r2.isEmpty()
            if (r7 != 0) goto L_0x0241
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r7 = r0.A
            if (r7 != 0) goto L_0x0184
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.A = r7
        L_0x0184:
            java.util.Iterator r2 = r2.iterator()
        L_0x0188:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x01ed
            java.lang.Object r7 = r2.next()
            java.lang.String r7 = (java.lang.String) r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r8 = r0.A
            boolean r8 = r8.containsKey(r7)
            if (r8 == 0) goto L_0x019d
            goto L_0x0188
        L_0x019d:
            boolean r8 = r7.startsWith(r10)
            if (r8 == 0) goto L_0x01db
            android.util.SparseArray r8 = new android.util.SparseArray
            r8.<init>()
            java.lang.String[] r11 = r7.split(r9)
            r12 = 1
            r11 = r11[r12]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r12 = r0.f7685z
            java.util.Iterator r12 = r12.iterator()
        L_0x01b5:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01d4
            java.lang.Object r13 = r12.next()
            androidx.constraintlayout.motion.widget.Key r13 = (androidx.constraintlayout.motion.widget.Key) r13
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r14 = r13.f7395e
            if (r14 != 0) goto L_0x01c6
            goto L_0x01b5
        L_0x01c6:
            java.lang.Object r14 = r14.get(r11)
            androidx.constraintlayout.widget.ConstraintAttribute r14 = (androidx.constraintlayout.widget.ConstraintAttribute) r14
            if (r14 == 0) goto L_0x01b5
            int r13 = r13.f7391a
            r8.append(r13, r14)
            goto L_0x01b5
        L_0x01d4:
            androidx.constraintlayout.motion.utils.ViewTimeCycle r8 = androidx.constraintlayout.motion.utils.ViewTimeCycle.g(r7, r8)
            r11 = r21
            goto L_0x01e1
        L_0x01db:
            r11 = r21
            androidx.constraintlayout.motion.utils.ViewTimeCycle r8 = androidx.constraintlayout.motion.utils.ViewTimeCycle.h(r7, r11)
        L_0x01e1:
            if (r8 != 0) goto L_0x01e4
            goto L_0x0188
        L_0x01e4:
            r8.d(r7)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r13 = r0.A
            r13.put(r7, r8)
            goto L_0x0188
        L_0x01ed:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r2 = r0.f7685z
            if (r2 == 0) goto L_0x020d
            java.util.Iterator r2 = r2.iterator()
        L_0x01f5:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x020d
            java.lang.Object r7 = r2.next()
            androidx.constraintlayout.motion.widget.Key r7 = (androidx.constraintlayout.motion.widget.Key) r7
            boolean r8 = r7 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r8 == 0) goto L_0x01f5
            androidx.constraintlayout.motion.widget.KeyTimeCycle r7 = (androidx.constraintlayout.motion.widget.KeyTimeCycle) r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r8 = r0.A
            r7.U(r8)
            goto L_0x01f5
        L_0x020d:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r2 = r0.A
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0217:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0241
            java.lang.Object r7 = r2.next()
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = r5.containsKey(r7)
            if (r8 == 0) goto L_0x0234
            java.lang.Object r8 = r5.get(r7)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            goto L_0x0235
        L_0x0234:
            r8 = r6
        L_0x0235:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r9 = r0.A
            java.lang.Object r7 = r9.get(r7)
            androidx.constraintlayout.motion.utils.ViewTimeCycle r7 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r7
            r7.e(r8)
            goto L_0x0217
        L_0x0241:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r2 = r0.f7683x
            int r2 = r2.size()
            r5 = 2
            int r2 = r2 + r5
            androidx.constraintlayout.motion.widget.MotionPaths[] r7 = new androidx.constraintlayout.motion.widget.MotionPaths[r2]
            androidx.constraintlayout.motion.widget.MotionPaths r8 = r0.f7665f
            r7[r6] = r8
            int r8 = r2 + -1
            androidx.constraintlayout.motion.widget.MotionPaths r9 = r0.f7666g
            r7[r8] = r9
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r8 = r0.f7683x
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x0264
            int r8 = r0.f7664e
            r9 = -1
            if (r8 != r9) goto L_0x0264
            r0.f7664e = r6
        L_0x0264:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r8 = r0.f7683x
            java.util.Iterator r8 = r8.iterator()
            r9 = 1
        L_0x026b:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x027d
            java.lang.Object r11 = r8.next()
            androidx.constraintlayout.motion.widget.MotionPaths r11 = (androidx.constraintlayout.motion.widget.MotionPaths) r11
            int r12 = r9 + 1
            r7[r9] = r11
            r9 = r12
            goto L_0x026b
        L_0x027d:
            r8 = 18
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            androidx.constraintlayout.motion.widget.MotionPaths r11 = r0.f7666g
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r11 = r11.f7628p
            java.util.Set r11 = r11.keySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x0290:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x02bf
            java.lang.Object r12 = r11.next()
            java.lang.String r12 = (java.lang.String) r12
            androidx.constraintlayout.motion.widget.MotionPaths r13 = r0.f7665f
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r13 = r13.f7628p
            boolean r13 = r13.containsKey(r12)
            if (r13 == 0) goto L_0x0290
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r10)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            boolean r13 = r3.contains(r13)
            if (r13 != 0) goto L_0x0290
            r9.add(r12)
            goto L_0x0290
        L_0x02bf:
            java.lang.String[] r3 = new java.lang.String[r6]
            java.lang.Object[] r3 = r9.toArray(r3)
            java.lang.String[] r3 = (java.lang.String[]) r3
            r0.f7679t = r3
            int r3 = r3.length
            int[] r3 = new int[r3]
            r0.f7680u = r3
            r3 = r6
        L_0x02cf:
            java.lang.String[] r9 = r0.f7679t
            int r10 = r9.length
            if (r3 >= r10) goto L_0x0305
            r9 = r9[r3]
            int[] r10 = r0.f7680u
            r10[r3] = r6
            r10 = r6
        L_0x02db:
            if (r10 >= r2) goto L_0x0302
            r11 = r7[r10]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r11 = r11.f7628p
            boolean r11 = r11.containsKey(r9)
            if (r11 == 0) goto L_0x02ff
            r11 = r7[r10]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r11 = r11.f7628p
            java.lang.Object r11 = r11.get(r9)
            androidx.constraintlayout.widget.ConstraintAttribute r11 = (androidx.constraintlayout.widget.ConstraintAttribute) r11
            if (r11 == 0) goto L_0x02ff
            int[] r9 = r0.f7680u
            r10 = r9[r3]
            int r11 = r11.h()
            int r10 = r10 + r11
            r9[r3] = r10
            goto L_0x0302
        L_0x02ff:
            int r10 = r10 + 1
            goto L_0x02db
        L_0x0302:
            int r3 = r3 + 1
            goto L_0x02cf
        L_0x0305:
            r3 = r7[r6]
            int r3 = r3.f7624l
            int r10 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r3 == r10) goto L_0x030f
            r3 = 1
            goto L_0x0310
        L_0x030f:
            r3 = r6
        L_0x0310:
            int r9 = r9.length
            int r8 = r8 + r9
            boolean[] r9 = new boolean[r8]
            r10 = 1
        L_0x0315:
            if (r10 >= r2) goto L_0x0325
            r11 = r7[r10]
            int r12 = r10 + -1
            r12 = r7[r12]
            java.lang.String[] r13 = r0.f7679t
            r11.e(r12, r9, r13, r3)
            int r10 = r10 + 1
            goto L_0x0315
        L_0x0325:
            r10 = r6
            r3 = 1
        L_0x0327:
            if (r3 >= r8) goto L_0x0332
            boolean r11 = r9[r3]
            if (r11 == 0) goto L_0x032f
            int r10 = r10 + 1
        L_0x032f:
            int r3 = r3 + 1
            goto L_0x0327
        L_0x0332:
            int[] r3 = new int[r10]
            r0.f7676q = r3
            int r3 = java.lang.Math.max(r5, r10)
            double[] r10 = new double[r3]
            r0.f7677r = r10
            double[] r3 = new double[r3]
            r0.f7678s = r3
            r10 = r6
            r3 = 1
        L_0x0344:
            if (r3 >= r8) goto L_0x0354
            boolean r11 = r9[r3]
            if (r11 == 0) goto L_0x0351
            int[] r11 = r0.f7676q
            int r12 = r10 + 1
            r11[r10] = r3
            r10 = r12
        L_0x0351:
            int r3 = r3 + 1
            goto L_0x0344
        L_0x0354:
            int[] r3 = r0.f7676q
            int r3 = r3.length
            int[] r8 = new int[r5]
            r9 = 1
            r8[r9] = r3
            r8[r6] = r2
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r1, r8)
            double[][] r3 = (double[][]) r3
            double[] r8 = new double[r2]
            r9 = r6
        L_0x0367:
            if (r9 >= r2) goto L_0x037c
            r10 = r7[r9]
            r11 = r3[r9]
            int[] r12 = r0.f7676q
            r10.f(r11, r12)
            r10 = r7[r9]
            float r10 = r10.f7616d
            double r10 = (double) r10
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x0367
        L_0x037c:
            r9 = r6
        L_0x037d:
            int[] r10 = r0.f7676q
            int r11 = r10.length
            if (r9 >= r11) goto L_0x03be
            r10 = r10[r9]
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.MotionPaths.f7613u
            int r11 = r11.length
            if (r10 >= r11) goto L_0x03bb
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.MotionPaths.f7613u
            int[] r12 = r0.f7676q
            r12 = r12[r9]
            r11 = r11[r12]
            r10.append(r11)
            java.lang.String r11 = " ["
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r11 = r6
        L_0x03a3:
            if (r11 >= r2) goto L_0x03bb
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r10)
            r10 = r3[r11]
            r13 = r10[r9]
            r12.append(r13)
            java.lang.String r10 = r12.toString()
            int r11 = r11 + 1
            goto L_0x03a3
        L_0x03bb:
            int r9 = r9 + 1
            goto L_0x037d
        L_0x03be:
            java.lang.String[] r9 = r0.f7679t
            int r9 = r9.length
            r10 = 1
            int r9 = r9 + r10
            androidx.constraintlayout.core.motion.utils.CurveFit[] r9 = new androidx.constraintlayout.core.motion.utils.CurveFit[r9]
            r0.f7669j = r9
            r9 = r6
        L_0x03c8:
            java.lang.String[] r10 = r0.f7679t
            int r11 = r10.length
            if (r9 >= r11) goto L_0x0424
            r10 = r10[r9]
            r11 = r6
            r13 = r11
            r12 = 0
            r14 = 0
        L_0x03d3:
            if (r11 >= r2) goto L_0x040b
            r15 = r7[r11]
            boolean r15 = r15.l(r10)
            if (r15 == 0) goto L_0x0406
            if (r14 != 0) goto L_0x03f5
            double[] r12 = new double[r2]
            r14 = r7[r11]
            int r14 = r14.j(r10)
            int[] r15 = new int[r5]
            r16 = 1
            r15[r16] = r14
            r15[r6] = r2
            java.lang.Object r14 = java.lang.reflect.Array.newInstance(r1, r15)
            double[][] r14 = (double[][]) r14
        L_0x03f5:
            r15 = r7[r11]
            float r15 = r15.f7616d
            double r5 = (double) r15
            r12[r13] = r5
            r5 = r7[r11]
            r6 = r14[r13]
            r15 = 0
            r5.i(r10, r6, r15)
            int r13 = r13 + 1
        L_0x0406:
            int r11 = r11 + 1
            r5 = 2
            r6 = 0
            goto L_0x03d3
        L_0x040b:
            double[] r5 = java.util.Arrays.copyOf(r12, r13)
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r14, r13)
            double[][] r6 = (double[][]) r6
            androidx.constraintlayout.core.motion.utils.CurveFit[] r10 = r0.f7669j
            int r9 = r9 + 1
            int r11 = r0.f7664e
            androidx.constraintlayout.core.motion.utils.CurveFit r5 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r11, r5, r6)
            r10[r9] = r5
            r5 = 2
            r6 = 0
            goto L_0x03c8
        L_0x0424:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r5 = r0.f7669j
            int r6 = r0.f7664e
            androidx.constraintlayout.core.motion.utils.CurveFit r3 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r6, r8, r3)
            r6 = 0
            r5[r6] = r3
            r3 = r7[r6]
            int r3 = r3.f7624l
            int r5 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r3 == r5) goto L_0x0476
            int[] r3 = new int[r2]
            double[] r5 = new double[r2]
            r8 = 2
            int[] r9 = new int[r8]
            r10 = 1
            r9[r10] = r8
            r9[r6] = r2
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r9)
            double[][] r1 = (double[][]) r1
            r15 = 0
        L_0x044a:
            if (r15 >= r2) goto L_0x0470
            r6 = r7[r15]
            int r6 = r6.f7624l
            r3[r15] = r6
            r6 = r7[r15]
            float r6 = r6.f7616d
            double r8 = (double) r6
            r5[r15] = r8
            r6 = r1[r15]
            r8 = r7[r15]
            float r8 = r8.f7618f
            double r8 = (double) r8
            r10 = 0
            r6[r10] = r8
            r6 = r1[r15]
            r8 = r7[r15]
            float r8 = r8.f7619g
            double r8 = (double) r8
            r11 = 1
            r6[r11] = r8
            int r15 = r15 + 1
            goto L_0x044a
        L_0x0470:
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.b(r3, r5, r1)
            r0.f7670k = r1
        L_0x0476:
            r1 = 2143289344(0x7fc00000, float:NaN)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.C = r2
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r2 = r0.f7685z
            if (r2 == 0) goto L_0x04eb
            java.util.Iterator r2 = r4.iterator()
        L_0x0487:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04b3
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.motion.utils.ViewOscillator r4 = androidx.constraintlayout.motion.utils.ViewOscillator.i(r3)
            if (r4 != 0) goto L_0x049a
            goto L_0x0487
        L_0x049a:
            boolean r5 = r4.h()
            if (r5 == 0) goto L_0x04aa
            boolean r5 = java.lang.Float.isNaN(r1)
            if (r5 == 0) goto L_0x04aa
            float r1 = r17.s()
        L_0x04aa:
            r4.f(r3)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r5 = r0.C
            r5.put(r3, r4)
            goto L_0x0487
        L_0x04b3:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r2 = r0.f7685z
            java.util.Iterator r2 = r2.iterator()
        L_0x04b9:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04d1
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.Key r3 = (androidx.constraintlayout.motion.widget.Key) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r4 == 0) goto L_0x04b9
            androidx.constraintlayout.motion.widget.KeyCycle r3 = (androidx.constraintlayout.motion.widget.KeyCycle) r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r4 = r0.C
            r3.Y(r4)
            goto L_0x04b9
        L_0x04d1:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r2 = r0.C
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x04db:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04eb
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r3 = (androidx.constraintlayout.motion.utils.ViewOscillator) r3
            r3.g(r1)
            goto L_0x04db
        L_0x04eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.d.H(int, int, float, long):void");
    }

    public void I(d dVar) {
        this.f7665f.t(dVar, dVar.f7665f);
        this.f7666g.t(dVar, dVar.f7666g);
    }

    public void a(Key key) {
        this.f7685z.add(key);
    }

    public void b(ArrayList<Key> arrayList) {
        this.f7685z.addAll(arrayList);
    }

    public int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h11 = this.f7669j[0].h();
        if (iArr != null) {
            Iterator<MotionPaths> it2 = this.f7683x.iterator();
            int i11 = 0;
            while (it2.hasNext()) {
                iArr[i11] = it2.next().f7629q;
                i11++;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < h11.length; i13++) {
            this.f7669j[0].d(h11[i13], this.f7677r);
            this.f7665f.g(h11[i13], this.f7676q, this.f7677r, fArr, i12);
            i12 += 2;
        }
        return i12 / 2;
    }

    public void d(float[] fArr, int i11) {
        double d11;
        int i12 = i11;
        float f11 = 1.0f;
        float f12 = 1.0f / ((float) (i12 - 1));
        HashMap<String, ViewSpline> hashMap = this.B;
        ViewOscillator viewOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.B;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewOscillator> hashMap3 = this.C;
        ViewOscillator viewOscillator2 = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, ViewOscillator> hashMap4 = this.C;
        if (hashMap4 != null) {
            viewOscillator = hashMap4.get("translationY");
        }
        ViewOscillator viewOscillator3 = viewOscillator;
        int i13 = 0;
        while (i13 < i12) {
            float f13 = ((float) i13) * f12;
            float f14 = this.f7673n;
            if (f14 != f11) {
                float f15 = this.f7672m;
                if (f13 < f15) {
                    f13 = 0.0f;
                }
                if (f13 > f15 && ((double) f13) < 1.0d) {
                    f13 = Math.min((f13 - f15) * f14, f11);
                }
            }
            float f16 = f13;
            double d12 = (double) f16;
            Easing easing = this.f7665f.f7614b;
            float f17 = Float.NaN;
            Iterator<MotionPaths> it2 = this.f7683x.iterator();
            float f18 = 0.0f;
            while (it2.hasNext()) {
                MotionPaths next = it2.next();
                Easing easing2 = next.f7614b;
                double d13 = d12;
                if (easing2 != null) {
                    float f19 = next.f7616d;
                    if (f19 < f16) {
                        f18 = f19;
                        easing = easing2;
                    } else if (Float.isNaN(f17)) {
                        f17 = next.f7616d;
                    }
                }
                d12 = d13;
            }
            double d14 = d12;
            if (easing != null) {
                if (Float.isNaN(f17)) {
                    f17 = 1.0f;
                }
                float f21 = f17 - f18;
                d11 = (double) ((((float) easing.a((double) ((f16 - f18) / f21))) * f21) + f18);
            } else {
                d11 = d14;
            }
            this.f7669j[0].d(d11, this.f7677r);
            CurveFit curveFit = this.f7670k;
            if (curveFit != null) {
                double[] dArr = this.f7677r;
                if (dArr.length > 0) {
                    curveFit.d(d11, dArr);
                }
            }
            int i14 = i13 * 2;
            float f22 = f16;
            int i15 = i13;
            this.f7665f.g(d11, this.f7676q, this.f7677r, fArr, i14);
            if (viewOscillator2 != null) {
                fArr[i14] = fArr[i14] + viewOscillator2.a(f22);
            } else if (splineSet != null) {
                fArr[i14] = fArr[i14] + splineSet.a(f22);
            }
            if (viewOscillator3 != null) {
                int i16 = i14 + 1;
                fArr[i16] = fArr[i16] + viewOscillator3.a(f22);
            } else if (splineSet2 != null) {
                int i17 = i14 + 1;
                fArr[i17] = fArr[i17] + splineSet2.a(f22);
            }
            i13 = i15 + 1;
            f11 = 1.0f;
        }
    }

    public void e(float f11, float[] fArr, int i11) {
        this.f7669j[0].d((double) g(f11, (float[]) null), this.f7677r);
        this.f7665f.k(this.f7676q, this.f7677r, fArr, i11);
    }

    public void f(boolean z11) {
        if ("button".equals(Debug.d(this.f7661b)) && this.D != null) {
            int i11 = 0;
            while (true) {
                KeyTrigger[] keyTriggerArr = this.D;
                if (i11 < keyTriggerArr.length) {
                    keyTriggerArr[i11].y(z11 ? -100.0f : 100.0f, this.f7661b);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public final float g(float f11, float[] fArr) {
        float f12 = 0.0f;
        float f13 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f14 = this.f7673n;
            if (((double) f14) != 1.0d) {
                float f15 = this.f7672m;
                if (f11 < f15) {
                    f11 = 0.0f;
                }
                if (f11 > f15 && ((double) f11) < 1.0d) {
                    f11 = Math.min((f11 - f15) * f14, 1.0f);
                }
            }
        }
        Easing easing = this.f7665f.f7614b;
        float f16 = Float.NaN;
        Iterator<MotionPaths> it2 = this.f7683x.iterator();
        while (it2.hasNext()) {
            MotionPaths next = it2.next();
            Easing easing2 = next.f7614b;
            if (easing2 != null) {
                float f17 = next.f7616d;
                if (f17 < f11) {
                    easing = easing2;
                    f12 = f17;
                } else if (Float.isNaN(f16)) {
                    f16 = next.f7616d;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f16)) {
                f13 = f16;
            }
            float f18 = f13 - f12;
            double d11 = (double) ((f11 - f12) / f18);
            f11 = (((float) easing.a(d11)) * f18) + f12;
            if (fArr != null) {
                fArr[0] = (float) easing.b(d11);
            }
        }
        return f11;
    }

    public int h() {
        return this.f7665f.f7625m;
    }

    public void i(double d11, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f7669j[0].d(d11, dArr);
        this.f7669j[0].g(d11, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f7665f.h(d11, this.f7676q, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.f7674o;
    }

    public float k() {
        return this.f7675p;
    }

    public void l(float f11, float f12, float f13, float[] fArr) {
        double[] dArr;
        float g11 = g(f11, this.f7684y);
        CurveFit[] curveFitArr = this.f7669j;
        int i11 = 0;
        if (curveFitArr != null) {
            double d11 = (double) g11;
            curveFitArr[0].g(d11, this.f7678s);
            this.f7669j[0].d(d11, this.f7677r);
            float f14 = this.f7684y[0];
            while (true) {
                dArr = this.f7678s;
                if (i11 >= dArr.length) {
                    break;
                }
                dArr[i11] = dArr[i11] * ((double) f14);
                i11++;
            }
            CurveFit curveFit = this.f7670k;
            if (curveFit != null) {
                double[] dArr2 = this.f7677r;
                if (dArr2.length > 0) {
                    curveFit.d(d11, dArr2);
                    this.f7670k.g(d11, this.f7678s);
                    this.f7665f.r(f12, f13, fArr, this.f7676q, this.f7678s, this.f7677r);
                    return;
                }
                return;
            }
            this.f7665f.r(f12, f13, fArr, this.f7676q, dArr, this.f7677r);
            return;
        }
        MotionPaths motionPaths = this.f7666g;
        float f15 = motionPaths.f7618f;
        MotionPaths motionPaths2 = this.f7665f;
        float f16 = f15 - motionPaths2.f7618f;
        float f17 = motionPaths.f7619g - motionPaths2.f7619g;
        float f18 = (motionPaths.f7620h - motionPaths2.f7620h) + f16;
        float f19 = (motionPaths.f7621i - motionPaths2.f7621i) + f17;
        fArr[0] = (f16 * (1.0f - f12)) + (f18 * f12);
        fArr[1] = (f17 * (1.0f - f13)) + (f19 * f13);
    }

    public int m() {
        int i11 = this.f7665f.f7615c;
        Iterator<MotionPaths> it2 = this.f7683x.iterator();
        while (it2.hasNext()) {
            i11 = Math.max(i11, it2.next().f7615c);
        }
        return Math.max(i11, this.f7666g.f7615c);
    }

    public float n() {
        return this.f7666g.f7618f;
    }

    public float o() {
        return this.f7666g.f7619g;
    }

    public MotionPaths q(int i11) {
        return this.f7683x.get(i11);
    }

    public void r(float f11, int i11, int i12, float f12, float f13, float[] fArr) {
        float g11 = g(f11, this.f7684y);
        HashMap<String, ViewSpline> hashMap = this.B;
        ViewOscillator viewOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.B;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewSpline> hashMap3 = this.B;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get("rotation");
        HashMap<String, ViewSpline> hashMap4 = this.B;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, ViewSpline> hashMap5 = this.B;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, ViewOscillator> hashMap6 = this.C;
        ViewOscillator viewOscillator2 = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, ViewOscillator> hashMap7 = this.C;
        ViewOscillator viewOscillator3 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, ViewOscillator> hashMap8 = this.C;
        ViewOscillator viewOscillator4 = hashMap8 == null ? null : hashMap8.get("rotation");
        HashMap<String, ViewOscillator> hashMap9 = this.C;
        ViewOscillator viewOscillator5 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, ViewOscillator> hashMap10 = this.C;
        if (hashMap10 != null) {
            viewOscillator = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.b();
        velocityMatrix.d(splineSet3, g11);
        velocityMatrix.h(splineSet, splineSet2, g11);
        velocityMatrix.f(splineSet4, splineSet5, g11);
        velocityMatrix.c(viewOscillator4, g11);
        velocityMatrix.g(viewOscillator2, viewOscillator3, g11);
        velocityMatrix.e(viewOscillator5, viewOscillator, g11);
        CurveFit curveFit = this.f7670k;
        if (curveFit != null) {
            double[] dArr = this.f7677r;
            if (dArr.length > 0) {
                double d11 = (double) g11;
                curveFit.d(d11, dArr);
                this.f7670k.g(d11, this.f7678s);
                this.f7665f.r(f12, f13, fArr, this.f7676q, this.f7678s, this.f7677r);
            }
            velocityMatrix.a(f12, f13, i11, i12, fArr);
            return;
        }
        int i13 = 0;
        if (this.f7669j != null) {
            double g12 = (double) g(g11, this.f7684y);
            this.f7669j[0].g(g12, this.f7678s);
            this.f7669j[0].d(g12, this.f7677r);
            float f14 = this.f7684y[0];
            while (true) {
                double[] dArr2 = this.f7678s;
                if (i13 < dArr2.length) {
                    dArr2[i13] = dArr2[i13] * ((double) f14);
                    i13++;
                } else {
                    float f15 = f12;
                    float f16 = f13;
                    this.f7665f.r(f15, f16, fArr, this.f7676q, dArr2, this.f7677r);
                    velocityMatrix.a(f15, f16, i11, i12, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.f7666g;
            float f17 = motionPaths.f7618f;
            MotionPaths motionPaths2 = this.f7665f;
            float f18 = f17 - motionPaths2.f7618f;
            float f19 = motionPaths.f7619g - motionPaths2.f7619g;
            ViewOscillator viewOscillator6 = viewOscillator5;
            float f21 = (motionPaths.f7621i - motionPaths2.f7621i) + f19;
            fArr[0] = (f18 * (1.0f - f12)) + (((motionPaths.f7620h - motionPaths2.f7620h) + f18) * f12);
            fArr[1] = (f19 * (1.0f - f13)) + (f21 * f13);
            velocityMatrix.b();
            velocityMatrix.d(splineSet3, g11);
            velocityMatrix.h(splineSet, splineSet2, g11);
            velocityMatrix.f(splineSet4, splineSet5, g11);
            velocityMatrix.c(viewOscillator4, g11);
            velocityMatrix.g(viewOscillator2, viewOscillator3, g11);
            velocityMatrix.e(viewOscillator6, viewOscillator, g11);
            velocityMatrix.a(f12, f13, i11, i12, fArr);
        }
    }

    public final float s() {
        char c11;
        float f11;
        float[] fArr = new float[2];
        float f12 = 1.0f / ((float) 99);
        double d11 = 0.0d;
        double d12 = 0.0d;
        float f13 = 0.0f;
        int i11 = 0;
        while (i11 < 100) {
            float f14 = ((float) i11) * f12;
            double d13 = (double) f14;
            Easing easing = this.f7665f.f7614b;
            Iterator<MotionPaths> it2 = this.f7683x.iterator();
            float f15 = Float.NaN;
            float f16 = 0.0f;
            while (it2.hasNext()) {
                MotionPaths next = it2.next();
                Easing easing2 = next.f7614b;
                if (easing2 != null) {
                    float f17 = next.f7616d;
                    if (f17 < f14) {
                        easing = easing2;
                        f16 = f17;
                    } else if (Float.isNaN(f15)) {
                        f15 = next.f7616d;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                float f18 = f15 - f16;
                d13 = (double) ((((float) easing.a((double) ((f14 - f16) / f18))) * f18) + f16);
            }
            this.f7669j[0].d(d13, this.f7677r);
            float f19 = f13;
            int i12 = i11;
            this.f7665f.g(d13, this.f7676q, this.f7677r, fArr, 0);
            if (i12 > 0) {
                c11 = 0;
                f11 = (float) (((double) f19) + Math.hypot(d12 - ((double) fArr[1]), d11 - ((double) fArr[0])));
            } else {
                c11 = 0;
                f11 = f19;
            }
            d11 = (double) fArr[c11];
            i11 = i12 + 1;
            f13 = f11;
            d12 = (double) fArr[1];
        }
        return f13;
    }

    public float t() {
        return this.f7665f.f7618f;
    }

    public String toString() {
        return " start: x: " + this.f7665f.f7618f + " y: " + this.f7665f.f7619g + " end: x: " + this.f7666g.f7618f + " y: " + this.f7666g.f7619g;
    }

    public float u() {
        return this.f7665f.f7619g;
    }

    public View v() {
        return this.f7661b;
    }

    public final void w(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.f7683x, motionPaths);
        if (binarySearch == 0) {
            Log.e("MotionController", " KeyPath position \"" + motionPaths.f7617e + "\" outside of range");
        }
        this.f7683x.add((-binarySearch) - 1, motionPaths);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean x(android.view.View r23, float r24, long r25, androidx.constraintlayout.core.motion.utils.KeyCache r27) {
        /*
            r22 = this;
            r0 = r22
            r11 = r23
            r1 = 0
            r2 = r24
            float r2 = r0.g(r2, r1)
            int r3 = r0.H
            int r4 = androidx.constraintlayout.motion.widget.Key.f7390f
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r3 == r4) goto L_0x0042
            float r3 = (float) r3
            float r3 = r13 / r3
            float r4 = r2 / r3
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            float r4 = (float) r4
            float r4 = r4 * r3
            float r2 = r2 % r3
            float r2 = r2 / r3
            float r5 = r0.I
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L_0x002d
            float r5 = r0.I
            float r2 = r2 + r5
            float r2 = r2 % r13
        L_0x002d:
            android.view.animation.Interpolator r5 = r0.J
            if (r5 == 0) goto L_0x0036
            float r2 = r5.getInterpolation(r2)
            goto L_0x0040
        L_0x0036:
            double r5 = (double) r2
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x003f
            r2 = r13
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            float r2 = r2 * r3
            float r2 = r2 + r4
        L_0x0042:
            r14 = r2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r2 = r0.B
            if (r2 == 0) goto L_0x005f
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x004f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005f
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.utils.ViewSpline r3 = (androidx.constraintlayout.motion.utils.ViewSpline) r3
            r3.h(r11, r14)
            goto L_0x004f
        L_0x005f:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r2 = r0.A
            r15 = 0
            if (r2 == 0) goto L_0x0092
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = r15
        L_0x006e:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x008f
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.utils.ViewTimeCycle r1 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate
            if (r2 == 0) goto L_0x0082
            r8 = r1
            androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate r8 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate) r8
            goto L_0x006e
        L_0x0082:
            r2 = r23
            r3 = r14
            r4 = r25
            r6 = r27
            boolean r1 = r1.i(r2, r3, r4, r6)
            r9 = r9 | r1
            goto L_0x006e
        L_0x008f:
            r16 = r9
            goto L_0x0095
        L_0x0092:
            r8 = r1
            r16 = r15
        L_0x0095:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.f7669j
            r9 = 1
            if (r1 == 0) goto L_0x01eb
            r1 = r1[r15]
            double r6 = (double) r14
            double[] r2 = r0.f7677r
            r1.d(r6, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.f7669j
            r1 = r1[r15]
            double[] r2 = r0.f7678s
            r1.g(r6, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.f7670k
            if (r1 == 0) goto L_0x00be
            double[] r2 = r0.f7677r
            int r3 = r2.length
            if (r3 <= 0) goto L_0x00be
            r1.d(r6, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.f7670k
            double[] r2 = r0.f7678s
            r1.g(r6, r2)
        L_0x00be:
            boolean r1 = r0.K
            if (r1 != 0) goto L_0x00d7
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.f7665f
            int[] r4 = r0.f7676q
            double[] r5 = r0.f7677r
            double[] r10 = r0.f7678s
            r17 = 0
            r2 = r14
            r3 = r23
            r12 = r6
            r6 = r10
            r7 = r17
            r1.s(r2, r3, r4, r5, r6, r7)
            goto L_0x00d8
        L_0x00d7:
            r12 = r6
        L_0x00d8:
            int r1 = r0.F
            int r2 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r1 == r2) goto L_0x013a
            android.view.View r1 = r0.G
            if (r1 != 0) goto L_0x00f0
            android.view.ViewParent r1 = r23.getParent()
            android.view.View r1 = (android.view.View) r1
            int r2 = r0.F
            android.view.View r1 = r1.findViewById(r2)
            r0.G = r1
        L_0x00f0:
            android.view.View r1 = r0.G
            if (r1 == 0) goto L_0x013a
            int r1 = r1.getTop()
            android.view.View r2 = r0.G
            int r2 = r2.getBottom()
            int r1 = r1 + r2
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            android.view.View r3 = r0.G
            int r3 = r3.getLeft()
            android.view.View r4 = r0.G
            int r4 = r4.getRight()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r3 = r3 / r2
            int r2 = r23.getRight()
            int r4 = r23.getLeft()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x013a
            int r2 = r23.getBottom()
            int r4 = r23.getTop()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x013a
            int r2 = r23.getLeft()
            float r2 = (float) r2
            float r3 = r3 - r2
            int r2 = r23.getTop()
            float r2 = (float) r2
            float r1 = r1 - r2
            r11.setPivotX(r3)
            r11.setPivotY(r1)
        L_0x013a:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r1 = r0.B
            if (r1 == 0) goto L_0x0168
            java.util.Collection r1 = r1.values()
            java.util.Iterator r10 = r1.iterator()
        L_0x0146:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x0168
            java.lang.Object r1 = r10.next()
            androidx.constraintlayout.core.motion.utils.SplineSet r1 = (androidx.constraintlayout.core.motion.utils.SplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewSpline.PathRotate
            if (r2 == 0) goto L_0x0146
            double[] r2 = r0.f7678s
            int r3 = r2.length
            if (r3 <= r9) goto L_0x0146
            androidx.constraintlayout.motion.utils.ViewSpline$PathRotate r1 = (androidx.constraintlayout.motion.utils.ViewSpline.PathRotate) r1
            r4 = r2[r15]
            r6 = r2[r9]
            r2 = r23
            r3 = r14
            r1.i(r2, r3, r4, r6)
            goto L_0x0146
        L_0x0168:
            if (r8 == 0) goto L_0x0187
            double[] r1 = r0.f7678s
            r18 = r1[r15]
            r20 = r1[r9]
            r1 = r8
            r2 = r23
            r3 = r27
            r4 = r14
            r5 = r25
            r7 = r18
            r17 = r9
            r9 = r20
            boolean r1 = r1.j(r2, r3, r4, r5, r7, r9)
            r1 = r16 | r1
            r16 = r1
            goto L_0x0189
        L_0x0187:
            r17 = r9
        L_0x0189:
            r9 = r17
        L_0x018b:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.f7669j
            int r2 = r1.length
            if (r9 >= r2) goto L_0x01af
            r1 = r1[r9]
            float[] r2 = r0.f7682w
            r1.e(r12, r2)
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.f7665f
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r1 = r1.f7628p
            java.lang.String[] r2 = r0.f7679t
            int r3 = r9 + -1
            r2 = r2[r3]
            java.lang.Object r1 = r1.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            float[] r2 = r0.f7682w
            r1.k(r11, r2)
            int r9 = r9 + 1
            goto L_0x018b
        L_0x01af:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.f7667h
            int r2 = r1.f7491c
            if (r2 != 0) goto L_0x01d9
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x01c0
            int r1 = r1.f7492d
            r11.setVisibility(r1)
            goto L_0x01d9
        L_0x01c0:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x01ce
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.f7668i
            int r1 = r1.f7492d
            r11.setVisibility(r1)
            goto L_0x01d9
        L_0x01ce:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r2 = r0.f7668i
            int r2 = r2.f7492d
            int r1 = r1.f7492d
            if (r2 == r1) goto L_0x01d9
            r11.setVisibility(r15)
        L_0x01d9:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.D
            if (r1 == 0) goto L_0x0235
            r1 = r15
        L_0x01de:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r2 = r0.D
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0235
            r2 = r2[r1]
            r2.y(r14, r11)
            int r1 = r1 + 1
            goto L_0x01de
        L_0x01eb:
            r17 = r9
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.f7665f
            float r2 = r1.f7618f
            androidx.constraintlayout.motion.widget.MotionPaths r3 = r0.f7666g
            float r4 = r3.f7618f
            float r4 = r4 - r2
            float r4 = r4 * r14
            float r2 = r2 + r4
            float r4 = r1.f7619g
            float r5 = r3.f7619g
            float r5 = r5 - r4
            float r5 = r5 * r14
            float r4 = r4 + r5
            float r5 = r1.f7620h
            float r6 = r3.f7620h
            float r7 = r6 - r5
            float r7 = r7 * r14
            float r7 = r7 + r5
            float r1 = r1.f7621i
            float r3 = r3.f7621i
            float r8 = r3 - r1
            float r8 = r8 * r14
            float r8 = r8 + r1
            r9 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r9
            int r10 = (int) r2
            float r4 = r4 + r9
            int r9 = (int) r4
            float r2 = r2 + r7
            int r2 = (int) r2
            float r4 = r4 + r8
            int r4 = (int) r4
            int r7 = r2 - r10
            int r8 = r4 - r9
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0225
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0232
        L_0x0225:
            r1 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
            r11.measure(r3, r1)
        L_0x0232:
            r11.layout(r10, r9, r2, r4)
        L_0x0235:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r1 = r0.C
            if (r1 == 0) goto L_0x0264
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x0241:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0264
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r1 = (androidx.constraintlayout.motion.utils.ViewOscillator) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet
            if (r2 == 0) goto L_0x0260
            androidx.constraintlayout.motion.utils.ViewOscillator$PathRotateSet r1 = (androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet) r1
            double[] r2 = r0.f7678s
            r4 = r2[r15]
            r6 = r2[r17]
            r2 = r23
            r3 = r14
            r1.k(r2, r3, r4, r6)
            goto L_0x0241
        L_0x0260:
            r1.j(r11, r14)
            goto L_0x0241
        L_0x0264:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.d.x(android.view.View, float, long, androidx.constraintlayout.core.motion.utils.KeyCache):boolean");
    }

    public final void y(MotionPaths motionPaths) {
        motionPaths.q((float) ((int) this.f7661b.getX()), (float) ((int) this.f7661b.getY()), (float) this.f7661b.getWidth(), (float) this.f7661b.getHeight());
    }

    public void z(Rect rect, Rect rect2, int i11, int i12, int i13) {
        if (i11 == 1) {
            int i14 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i13 - ((i14 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i11 == 2) {
            int i15 = rect.left + rect.right;
            rect2.left = i12 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i15 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i11 == 3) {
            int i16 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i16 / 2);
            rect2.top = i13 - ((i16 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i11 == 4) {
            int i17 = rect.left + rect.right;
            rect2.left = i12 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = (i17 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }
}
