package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidgetContainer extends WidgetContainer {
    public BasicMeasure U0 = new BasicMeasure(this);
    public d V0 = new d(this);
    public int W0;
    public BasicMeasure.a X0 = null;
    public boolean Y0 = false;
    public Metrics Z0;

    /* renamed from: a1  reason: collision with root package name */
    public LinearSystem f7142a1 = new LinearSystem();

    /* renamed from: b1  reason: collision with root package name */
    public int f7143b1;

    /* renamed from: c1  reason: collision with root package name */
    public int f7144c1;

    /* renamed from: d1  reason: collision with root package name */
    public int f7145d1;

    /* renamed from: e1  reason: collision with root package name */
    public int f7146e1;

    /* renamed from: f1  reason: collision with root package name */
    public int f7147f1 = 0;

    /* renamed from: g1  reason: collision with root package name */
    public int f7148g1 = 0;

    /* renamed from: h1  reason: collision with root package name */
    public a[] f7149h1 = new a[4];

    /* renamed from: i1  reason: collision with root package name */
    public a[] f7150i1 = new a[4];

    /* renamed from: j1  reason: collision with root package name */
    public boolean f7151j1 = false;

    /* renamed from: k1  reason: collision with root package name */
    public boolean f7152k1 = false;

    /* renamed from: l1  reason: collision with root package name */
    public boolean f7153l1 = false;

    /* renamed from: m1  reason: collision with root package name */
    public int f7154m1 = 0;

    /* renamed from: n1  reason: collision with root package name */
    public int f7155n1 = 0;

    /* renamed from: o1  reason: collision with root package name */
    public int f7156o1 = 257;

    /* renamed from: p1  reason: collision with root package name */
    public boolean f7157p1 = false;

    /* renamed from: q1  reason: collision with root package name */
    public boolean f7158q1 = false;

    /* renamed from: r1  reason: collision with root package name */
    public boolean f7159r1 = false;

    /* renamed from: s1  reason: collision with root package name */
    public int f7160s1 = 0;

    /* renamed from: t1  reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f7161t1 = null;

    /* renamed from: u1  reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f7162u1 = null;

    /* renamed from: v1  reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f7163v1 = null;

    /* renamed from: w1  reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f7164w1 = null;

    /* renamed from: x1  reason: collision with root package name */
    public HashSet<ConstraintWidget> f7165x1 = new HashSet<>();

    /* renamed from: y1  reason: collision with root package name */
    public BasicMeasure.Measure f7166y1 = new BasicMeasure.Measure();

    public static boolean O1(int i11, ConstraintWidget constraintWidget, BasicMeasure.a aVar, BasicMeasure.Measure measure, int i12) {
        int i13;
        int i14;
        if (aVar == null) {
            return false;
        }
        if (constraintWidget.T() == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.f7245e = 0;
            measure.f7246f = 0;
            return false;
        }
        measure.f7241a = constraintWidget.B();
        measure.f7242b = constraintWidget.R();
        measure.f7243c = constraintWidget.U();
        measure.f7244d = constraintWidget.y();
        measure.f7249i = false;
        measure.f7250j = i12;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f7241a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z11 = dimensionBehaviour == dimensionBehaviour2;
        boolean z12 = measure.f7242b == dimensionBehaviour2;
        boolean z13 = z11 && constraintWidget.f7097e0 > 0.0f;
        boolean z14 = z12 && constraintWidget.f7097e0 > 0.0f;
        if (z11 && constraintWidget.Y(0) && constraintWidget.f7130v == 0 && !z13) {
            measure.f7241a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z12 && constraintWidget.f7132w == 0) {
                measure.f7241a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (z12 && constraintWidget.Y(1) && constraintWidget.f7132w == 0 && !z14) {
            measure.f7242b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.f7130v == 0) {
                measure.f7242b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z12 = false;
        }
        if (constraintWidget.l0()) {
            measure.f7241a = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (constraintWidget.m0()) {
            measure.f7242b = ConstraintWidget.DimensionBehaviour.FIXED;
            z12 = false;
        }
        if (z13) {
            if (constraintWidget.f7134x[0] == 4) {
                measure.f7241a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z12) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.f7242b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i14 = measure.f7244d;
                } else {
                    measure.f7241a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    aVar.b(constraintWidget, measure);
                    i14 = measure.f7246f;
                }
                measure.f7241a = dimensionBehaviour4;
                measure.f7243c = (int) (constraintWidget.w() * ((float) i14));
            }
        }
        if (z14) {
            if (constraintWidget.f7134x[1] == 4) {
                measure.f7242b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.f7241a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i13 = measure.f7243c;
                } else {
                    measure.f7242b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    aVar.b(constraintWidget, measure);
                    i13 = measure.f7245e;
                }
                measure.f7242b = dimensionBehaviour6;
                if (constraintWidget.x() == -1) {
                    measure.f7244d = (int) (((float) i13) / constraintWidget.w());
                } else {
                    measure.f7244d = (int) (constraintWidget.w() * ((float) i13));
                }
            }
        }
        aVar.b(constraintWidget, measure);
        constraintWidget.f1(measure.f7245e);
        constraintWidget.G0(measure.f7246f);
        constraintWidget.F0(measure.f7248h);
        constraintWidget.v0(measure.f7247g);
        measure.f7250j = BasicMeasure.Measure.f7238k;
        return measure.f7249i;
    }

    public boolean A1(boolean z11) {
        return this.V0.f(z11);
    }

    public boolean B1(boolean z11) {
        return this.V0.g(z11);
    }

    public boolean C1(boolean z11, int i11) {
        return this.V0.h(z11, i11);
    }

    public void D1(Metrics metrics) {
        this.Z0 = metrics;
        this.f7142a1.v(metrics);
    }

    public BasicMeasure.a E1() {
        return this.X0;
    }

    public int F1() {
        return this.f7156o1;
    }

    public LinearSystem G1() {
        return this.f7142a1;
    }

    public boolean H1() {
        return false;
    }

    public void I1() {
        this.V0.j();
    }

    public void J1() {
        this.V0.k();
    }

    public boolean K1() {
        return this.f7159r1;
    }

    public boolean L1() {
        return this.Y0;
    }

    public boolean M1() {
        return this.f7158q1;
    }

    public long N1(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        int i21 = i18;
        this.f7143b1 = i21;
        int i22 = i19;
        this.f7144c1 = i22;
        return this.U0.d(this, i11, i21, i22, i12, i13, i14, i15, i16, i17);
    }

    public boolean P1(int i11) {
        return (this.f7156o1 & i11) == i11;
    }

    public final void Q1() {
        this.f7147f1 = 0;
        this.f7148g1 = 0;
    }

    public void R1(BasicMeasure.a aVar) {
        this.X0 = aVar;
        this.V0.n(aVar);
    }

    public void S1(int i11) {
        this.f7156o1 = i11;
        LinearSystem.f6551r = P1(512);
    }

    public void T1(int i11) {
        this.W0 = i11;
    }

    public void U1(boolean z11) {
        this.Y0 = z11;
    }

    public boolean V1(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean P1 = P1(64);
        l1(linearSystem, P1);
        int size = this.T0.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.T0.get(i11);
            constraintWidget.l1(linearSystem, P1);
            if (constraintWidget.a0()) {
                z11 = true;
            }
        }
        return z11;
    }

    public void W1() {
        this.U0.e(this);
    }

    public void k1(boolean z11, boolean z12) {
        super.k1(z11, z12);
        int size = this.T0.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.T0.get(i11).k1(z11, z12);
        }
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x031d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n1() {
        /*
            r18 = this;
            r1 = r18
            r2 = 0
            r1.f7101g0 = r2
            r1.f7103h0 = r2
            r1.f7158q1 = r2
            r1.f7159r1 = r2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r1.T0
            int r3 = r0.size()
            int r0 = r18.U()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r18.y()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.f7089a0
            r6 = 1
            r7 = r5[r6]
            r5 = r5[r2]
            androidx.constraintlayout.core.Metrics r8 = r1.Z0
            if (r8 == 0) goto L_0x0033
            long r9 = r8.E
            r11 = 1
            long r9 = r9 + r11
            r8.E = r9
        L_0x0033:
            int r8 = r1.W0
            if (r8 != 0) goto L_0x0093
            int r8 = r1.f7156o1
            boolean r8 = androidx.constraintlayout.core.widgets.Optimizer.b(r8, r6)
            if (r8 == 0) goto L_0x0093
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$a r8 = r18.E1()
            androidx.constraintlayout.core.widgets.analyzer.Direct.h(r1, r8)
            r8 = r2
        L_0x0047:
            if (r8 >= r3) goto L_0x0093
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r9 = r1.T0
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9.k0()
            if (r10 == 0) goto L_0x0090
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r10 != 0) goto L_0x0090
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r10 != 0) goto L_0x0090
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r10 != 0) goto L_0x0090
            boolean r10 = r9.j0()
            if (r10 != 0) goto L_0x0090
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r9.v(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.v(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r12) goto L_0x0081
            int r10 = r9.f7130v
            if (r10 == r6) goto L_0x0081
            if (r11 != r12) goto L_0x0081
            int r10 = r9.f7132w
            if (r10 == r6) goto L_0x0081
            r10 = r6
            goto L_0x0082
        L_0x0081:
            r10 = r2
        L_0x0082:
            if (r10 != 0) goto L_0x0090
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$a r11 = r1.X0
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            O1(r2, r9, r11, r10, r12)
        L_0x0090:
            int r8 = r8 + 1
            goto L_0x0047
        L_0x0093:
            r8 = 2
            if (r3 <= r8) goto L_0x00dc
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x009c
            if (r7 != r9) goto L_0x00dc
        L_0x009c:
            int r10 = r1.f7156o1
            r11 = 1024(0x400, float:1.435E-42)
            boolean r10 = androidx.constraintlayout.core.widgets.Optimizer.b(r10, r11)
            if (r10 == 0) goto L_0x00dc
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$a r10 = r18.E1()
            boolean r10 = androidx.constraintlayout.core.widgets.analyzer.Grouping.c(r1, r10)
            if (r10 == 0) goto L_0x00dc
            if (r5 != r9) goto L_0x00c4
            int r10 = r18.U()
            if (r0 >= r10) goto L_0x00c0
            if (r0 <= 0) goto L_0x00c0
            r1.f1(r0)
            r1.f7158q1 = r6
            goto L_0x00c4
        L_0x00c0:
            int r0 = r18.U()
        L_0x00c4:
            if (r7 != r9) goto L_0x00d8
            int r9 = r18.y()
            if (r4 >= r9) goto L_0x00d4
            if (r4 <= 0) goto L_0x00d4
            r1.G0(r4)
            r1.f7159r1 = r6
            goto L_0x00d8
        L_0x00d4:
            int r4 = r18.y()
        L_0x00d8:
            r9 = r4
            r4 = r0
            r0 = r6
            goto L_0x00df
        L_0x00dc:
            r9 = r4
            r4 = r0
            r0 = r2
        L_0x00df:
            r10 = 64
            boolean r11 = r1.P1(r10)
            if (r11 != 0) goto L_0x00f2
            r11 = 128(0x80, float:1.794E-43)
            boolean r11 = r1.P1(r11)
            if (r11 == 0) goto L_0x00f0
            goto L_0x00f2
        L_0x00f0:
            r11 = r2
            goto L_0x00f3
        L_0x00f2:
            r11 = r6
        L_0x00f3:
            androidx.constraintlayout.core.LinearSystem r12 = r1.f7142a1
            r12.f6567h = r2
            r12.f6568i = r2
            int r13 = r1.f7156o1
            if (r13 == 0) goto L_0x0101
            if (r11 == 0) goto L_0x0101
            r12.f6568i = r6
        L_0x0101:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r11 = r1.T0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.B()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r13) goto L_0x0114
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.R()
            if (r12 != r13) goto L_0x0112
            goto L_0x0114
        L_0x0112:
            r12 = r2
            goto L_0x0115
        L_0x0114:
            r12 = r6
        L_0x0115:
            r18.Q1()
            r13 = r2
        L_0x0119:
            if (r13 >= r3) goto L_0x012f
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r14 = r1.T0
            java.lang.Object r14 = r14.get(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            boolean r15 = r14 instanceof androidx.constraintlayout.core.widgets.WidgetContainer
            if (r15 == 0) goto L_0x012c
            androidx.constraintlayout.core.widgets.WidgetContainer r14 = (androidx.constraintlayout.core.widgets.WidgetContainer) r14
            r14.n1()
        L_0x012c:
            int r13 = r13 + 1
            goto L_0x0119
        L_0x012f:
            boolean r10 = r1.P1(r10)
            r13 = r0
            r0 = r2
            r14 = r6
        L_0x0136:
            if (r14 == 0) goto L_0x0324
            int r15 = r0 + 1
            androidx.constraintlayout.core.LinearSystem r0 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            r0.E()     // Catch:{ Exception -> 0x01e7 }
            r18.Q1()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r0 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            r1.n(r0)     // Catch:{ Exception -> 0x01e7 }
            r0 = r2
        L_0x0148:
            if (r0 >= r3) goto L_0x015c
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r6 = r1.T0     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r2 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            r6.n(r2)     // Catch:{ Exception -> 0x01e7 }
            int r0 = r0 + 1
            r2 = 0
            r6 = 1
            goto L_0x0148
        L_0x015c:
            androidx.constraintlayout.core.LinearSystem r0 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            boolean r14 = r1.r1(r0)     // Catch:{ Exception -> 0x01e7 }
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f7161t1     // Catch:{ Exception -> 0x01e7 }
            r2 = 0
            if (r0 == 0) goto L_0x0182
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x0182
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f7161t1     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.Q     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x01e7 }
            r1.w1(r0, r6)     // Catch:{ Exception -> 0x01e7 }
            r1.f7161t1 = r2     // Catch:{ Exception -> 0x01e7 }
        L_0x0182:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f7163v1     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01a1
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01a1
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f7163v1     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.S     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x01e7 }
            r1.v1(r0, r6)     // Catch:{ Exception -> 0x01e7 }
            r1.f7163v1 = r2     // Catch:{ Exception -> 0x01e7 }
        L_0x01a1:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f7162u1     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01c0
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01c0
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f7162u1     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.P     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x01e7 }
            r1.w1(r0, r6)     // Catch:{ Exception -> 0x01e7 }
            r1.f7162u1 = r2     // Catch:{ Exception -> 0x01e7 }
        L_0x01c0:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f7164w1     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01df
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            if (r0 == 0) goto L_0x01df
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f7164w1     // Catch:{ Exception -> 0x01e7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.R     // Catch:{ Exception -> 0x01e7 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x01e7 }
            r1.v1(r0, r6)     // Catch:{ Exception -> 0x01e7 }
            r1.f7164w1 = r2     // Catch:{ Exception -> 0x01e7 }
        L_0x01df:
            if (r14 == 0) goto L_0x0201
            androidx.constraintlayout.core.LinearSystem r0 = r1.f7142a1     // Catch:{ Exception -> 0x01e7 }
            r0.A()     // Catch:{ Exception -> 0x01e7 }
            goto L_0x0201
        L_0x01e7:
            r0 = move-exception
            r0.printStackTrace()
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "EXCEPTION : "
            r6.append(r8)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.println(r0)
        L_0x0201:
            if (r14 == 0) goto L_0x020c
            androidx.constraintlayout.core.LinearSystem r0 = r1.f7142a1
            boolean[] r2 = androidx.constraintlayout.core.widgets.Optimizer.f7204a
            boolean r0 = r1.V1(r0, r2)
            goto L_0x0225
        L_0x020c:
            androidx.constraintlayout.core.LinearSystem r0 = r1.f7142a1
            r1.l1(r0, r10)
            r0 = 0
        L_0x0212:
            if (r0 >= r3) goto L_0x0224
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.T0
            java.lang.Object r2 = r2.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.LinearSystem r6 = r1.f7142a1
            r2.l1(r6, r10)
            int r0 = r0 + 1
            goto L_0x0212
        L_0x0224:
            r0 = 0
        L_0x0225:
            r2 = 8
            if (r12 == 0) goto L_0x0296
            if (r15 >= r2) goto L_0x0296
            boolean[] r6 = androidx.constraintlayout.core.widgets.Optimizer.f7204a
            r8 = 2
            boolean r6 = r6[r8]
            if (r6 == 0) goto L_0x0296
            r6 = 0
            r8 = 0
            r14 = 0
        L_0x0235:
            if (r6 >= r3) goto L_0x025f
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.T0
            java.lang.Object r2 = r2.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            r16 = r0
            int r0 = r2.f7101g0
            int r17 = r2.U()
            int r0 = r0 + r17
            int r14 = java.lang.Math.max(r14, r0)
            int r0 = r2.f7103h0
            int r2 = r2.y()
            int r0 = r0 + r2
            int r8 = java.lang.Math.max(r8, r0)
            int r6 = r6 + 1
            r0 = r16
            r2 = 8
            goto L_0x0235
        L_0x025f:
            r16 = r0
            int r0 = r1.f7115n0
            int r0 = java.lang.Math.max(r0, r14)
            int r2 = r1.f7117o0
            int r2 = java.lang.Math.max(r2, r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x0282
            int r8 = r18.U()
            if (r8 >= r0) goto L_0x0282
            r1.f1(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            r8 = 0
            r0[r8] = r6
            r13 = 1
            r16 = 1
        L_0x0282:
            if (r7 != r6) goto L_0x0298
            int r0 = r18.y()
            if (r0 >= r2) goto L_0x0298
            r1.G0(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            r2 = 1
            r0[r2] = r6
            r13 = 1
            r16 = 1
            goto L_0x0298
        L_0x0296:
            r16 = r0
        L_0x0298:
            int r0 = r1.f7115n0
            int r2 = r18.U()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.U()
            if (r0 <= r2) goto L_0x02b5
            r1.f1(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 0
            r0[r6] = r2
            r13 = 1
            r16 = 1
        L_0x02b5:
            int r0 = r1.f7117o0
            int r2 = r18.y()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.y()
            if (r0 <= r2) goto L_0x02d3
            r1.G0(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 1
            r0[r6] = r2
            r2 = r6
            r16 = r2
            goto L_0x02d5
        L_0x02d3:
            r6 = 1
            r2 = r13
        L_0x02d5:
            if (r2 != 0) goto L_0x0314
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            r8 = 0
            r0 = r0[r8]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x02f6
            if (r4 <= 0) goto L_0x02f6
            int r0 = r18.U()
            if (r0 <= r4) goto L_0x02f6
            r1.f7158q1 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r8] = r2
            r1.f1(r4)
            r2 = r6
            r16 = r2
        L_0x02f6:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            r0 = r0[r6]
            if (r0 != r13) goto L_0x0314
            if (r9 <= 0) goto L_0x0314
            int r0 = r18.y()
            if (r0 <= r9) goto L_0x0314
            r1.f7159r1 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r6] = r2
            r1.G0(r9)
            r0 = 8
            r2 = 1
            r13 = 1
            goto L_0x0319
        L_0x0314:
            r13 = r2
            r2 = r16
            r0 = 8
        L_0x0319:
            if (r15 <= r0) goto L_0x031d
            r14 = 0
            goto L_0x031e
        L_0x031d:
            r14 = r2
        L_0x031e:
            r0 = r15
            r2 = 0
            r6 = 1
            r8 = 2
            goto L_0x0136
        L_0x0324:
            r1.T0 = r11
            if (r13 == 0) goto L_0x0330
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.f7089a0
            r2 = 0
            r0[r2] = r5
            r2 = 1
            r0[r2] = r7
        L_0x0330:
            androidx.constraintlayout.core.LinearSystem r0 = r1.f7142a1
            androidx.constraintlayout.core.Cache r0 = r0.w()
            r1.u0(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.n1():void");
    }

    public void q1(ConstraintWidget constraintWidget, int i11) {
        if (i11 == 0) {
            s1(constraintWidget);
        } else if (i11 == 1) {
            x1(constraintWidget);
        }
    }

    public void r0() {
        this.f7142a1.E();
        this.f7143b1 = 0;
        this.f7145d1 = 0;
        this.f7144c1 = 0;
        this.f7146e1 = 0;
        this.f7157p1 = false;
        super.r0();
    }

    public boolean r1(LinearSystem linearSystem) {
        boolean P1 = P1(64);
        g(linearSystem, P1);
        int size = this.T0.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.T0.get(i11);
            constraintWidget.N0(0, false);
            constraintWidget.N0(1, false);
            if (constraintWidget instanceof Barrier) {
                z11 = true;
            }
        }
        if (z11) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = this.T0.get(i12);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).t1();
                }
            }
        }
        this.f7165x1.clear();
        for (int i13 = 0; i13 < size; i13++) {
            ConstraintWidget constraintWidget3 = this.T0.get(i13);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.f7165x1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(linearSystem, P1);
                }
            }
        }
        while (this.f7165x1.size() > 0) {
            int size2 = this.f7165x1.size();
            Iterator<ConstraintWidget> it2 = this.f7165x1.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it2.next();
                if (virtualLayout.q1(this.f7165x1)) {
                    virtualLayout.g(linearSystem, P1);
                    this.f7165x1.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.f7165x1.size()) {
                Iterator<ConstraintWidget> it3 = this.f7165x1.iterator();
                while (it3.hasNext()) {
                    it3.next().g(linearSystem, P1);
                }
                this.f7165x1.clear();
            }
        }
        if (LinearSystem.f6551r) {
            HashSet hashSet = new HashSet();
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget4 = this.T0.get(i14);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            e(this, linearSystem, hashSet, B() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator it4 = hashSet.iterator();
            while (it4.hasNext()) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) it4.next();
                Optimizer.a(this, linearSystem, constraintWidget5);
                constraintWidget5.g(linearSystem, P1);
            }
        } else {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget6 = this.T0.get(i15);
                if (constraintWidget6 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.f7089a0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.K0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.b1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(linearSystem, P1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.K0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.b1(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.a(this, linearSystem, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(linearSystem, P1);
                    }
                }
            }
        }
        if (this.f7147f1 > 0) {
            Chain.b(this, linearSystem, (ArrayList<ConstraintWidget>) null, 0);
        }
        if (this.f7148g1 > 0) {
            Chain.b(this, linearSystem, (ArrayList<ConstraintWidget>) null, 1);
        }
        return true;
    }

    public final void s1(ConstraintWidget constraintWidget) {
        int i11 = this.f7147f1 + 1;
        a[] aVarArr = this.f7150i1;
        if (i11 >= aVarArr.length) {
            this.f7150i1 = (a[]) Arrays.copyOf(aVarArr, aVarArr.length * 2);
        }
        this.f7150i1[this.f7147f1] = new a(constraintWidget, 0, L1());
        this.f7147f1++;
    }

    public void t1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f7164w1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f7164w1.get()).e()) {
            this.f7164w1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void u1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f7162u1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f7162u1.get()).e()) {
            this.f7162u1 = new WeakReference<>(constraintAnchor);
        }
    }

    public final void v1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f7142a1.h(solverVariable, this.f7142a1.q(constraintAnchor), 0, 5);
    }

    public final void w1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f7142a1.h(this.f7142a1.q(constraintAnchor), solverVariable, 0, 5);
    }

    public final void x1(ConstraintWidget constraintWidget) {
        int i11 = this.f7148g1 + 1;
        a[] aVarArr = this.f7149h1;
        if (i11 >= aVarArr.length) {
            this.f7149h1 = (a[]) Arrays.copyOf(aVarArr, aVarArr.length * 2);
        }
        this.f7149h1[this.f7148g1] = new a(constraintWidget, 1, L1());
        this.f7148g1++;
    }

    public void y1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f7163v1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f7163v1.get()).e()) {
            this.f7163v1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void z1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f7161t1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f7161t1.get()).e()) {
            this.f7161t1 = new WeakReference<>(constraintAnchor);
        }
    }
}
