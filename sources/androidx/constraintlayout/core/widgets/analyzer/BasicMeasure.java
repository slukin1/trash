package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f7235a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Measure f7236b = new Measure();

    /* renamed from: c  reason: collision with root package name */
    public ConstraintWidgetContainer f7237c;

    public static class Measure {

        /* renamed from: k  reason: collision with root package name */
        public static int f7238k = 0;

        /* renamed from: l  reason: collision with root package name */
        public static int f7239l = 1;

        /* renamed from: m  reason: collision with root package name */
        public static int f7240m = 2;

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f7241a;

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f7242b;

        /* renamed from: c  reason: collision with root package name */
        public int f7243c;

        /* renamed from: d  reason: collision with root package name */
        public int f7244d;

        /* renamed from: e  reason: collision with root package name */
        public int f7245e;

        /* renamed from: f  reason: collision with root package name */
        public int f7246f;

        /* renamed from: g  reason: collision with root package name */
        public int f7247g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f7248h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f7249i;

        /* renamed from: j  reason: collision with root package name */
        public int f7250j;
    }

    public interface a {
        void a();

        void b(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f7237c = constraintWidgetContainer;
    }

    public final boolean a(a aVar, ConstraintWidget constraintWidget, int i11) {
        this.f7236b.f7241a = constraintWidget.B();
        this.f7236b.f7242b = constraintWidget.R();
        this.f7236b.f7243c = constraintWidget.U();
        this.f7236b.f7244d = constraintWidget.y();
        Measure measure = this.f7236b;
        measure.f7249i = false;
        measure.f7250j = i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f7241a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z11 = dimensionBehaviour == dimensionBehaviour2;
        boolean z12 = measure.f7242b == dimensionBehaviour2;
        boolean z13 = z11 && constraintWidget.f7097e0 > 0.0f;
        boolean z14 = z12 && constraintWidget.f7097e0 > 0.0f;
        if (z13 && constraintWidget.f7134x[0] == 4) {
            measure.f7241a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z14 && constraintWidget.f7134x[1] == 4) {
            measure.f7242b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        aVar.b(constraintWidget, measure);
        constraintWidget.f1(this.f7236b.f7245e);
        constraintWidget.G0(this.f7236b.f7246f);
        constraintWidget.F0(this.f7236b.f7248h);
        constraintWidget.v0(this.f7236b.f7247g);
        Measure measure2 = this.f7236b;
        measure2.f7250j = Measure.f7238k;
        return measure2.f7249i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        if (r5.f7097e0 <= 0.0f) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13) {
        /*
            r12 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r13.T0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.P1(r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$a r2 = r13.E1()
            r3 = 0
            r4 = r3
        L_0x0012:
            if (r4 >= r0) goto L_0x00b0
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r13.T0
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r6 == 0) goto L_0x0022
            goto L_0x00ac
        L_0x0022:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r6 == 0) goto L_0x0028
            goto L_0x00ac
        L_0x0028:
            boolean r6 = r5.j0()
            if (r6 == 0) goto L_0x0030
            goto L_0x00ac
        L_0x0030:
            if (r1 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.h r6 = r5.f7096e
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.j r7 = r5.f7098f
            if (r7 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r6.f7270e
            boolean r6 = r6.f7260j
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r7.f7270e
            boolean r6 = r6.f7260j
            if (r6 == 0) goto L_0x0048
            goto L_0x00ac
        L_0x0048:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.v(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.v(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L_0x0061
            int r10 = r5.f7130v
            if (r10 == r7) goto L_0x0061
            if (r8 != r9) goto L_0x0061
            int r10 = r5.f7132w
            if (r10 == r7) goto L_0x0061
            r10 = r7
            goto L_0x0062
        L_0x0061:
            r10 = r3
        L_0x0062:
            if (r10 != 0) goto L_0x0098
            boolean r11 = r13.P1(r7)
            if (r11 == 0) goto L_0x0098
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r11 != 0) goto L_0x0098
            if (r6 != r9) goto L_0x007d
            int r11 = r5.f7130v
            if (r11 != 0) goto L_0x007d
            if (r8 == r9) goto L_0x007d
            boolean r11 = r5.g0()
            if (r11 != 0) goto L_0x007d
            r10 = r7
        L_0x007d:
            if (r8 != r9) goto L_0x008c
            int r11 = r5.f7132w
            if (r11 != 0) goto L_0x008c
            if (r6 == r9) goto L_0x008c
            boolean r11 = r5.g0()
            if (r11 != 0) goto L_0x008c
            r10 = r7
        L_0x008c:
            if (r6 == r9) goto L_0x0090
            if (r8 != r9) goto L_0x0098
        L_0x0090:
            float r6 = r5.f7097e0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r7 = r10
        L_0x0099:
            if (r7 == 0) goto L_0x009c
            goto L_0x00ac
        L_0x009c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            r12.a(r2, r5, r6)
            androidx.constraintlayout.core.Metrics r5 = r13.Z0
            if (r5 == 0) goto L_0x00ac
            long r6 = r5.f6578a
            r8 = 1
            long r6 = r6 + r8
            r5.f6578a = r6
        L_0x00ac:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x00b0:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    public final void c(ConstraintWidgetContainer constraintWidgetContainer, String str, int i11, int i12, int i13) {
        int J = constraintWidgetContainer.J();
        int I = constraintWidgetContainer.I();
        constraintWidgetContainer.V0(0);
        constraintWidgetContainer.U0(0);
        constraintWidgetContainer.f1(i12);
        constraintWidgetContainer.G0(i13);
        constraintWidgetContainer.V0(J);
        constraintWidgetContainer.U0(I);
        this.f7237c.T1(i11);
        this.f7237c.n1();
    }

    public long d(ConstraintWidgetContainer constraintWidgetContainer, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        int i21;
        boolean z11;
        int i22;
        int i23;
        boolean z12;
        a aVar;
        int i24;
        int i25;
        int i26;
        boolean z13;
        Metrics metrics;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int i27 = i11;
        int i28 = i14;
        int i29 = i16;
        a E1 = constraintWidgetContainer.E1();
        int size = constraintWidgetContainer2.T0.size();
        int U = constraintWidgetContainer.U();
        int y11 = constraintWidgetContainer.y();
        boolean b11 = Optimizer.b(i27, 128);
        boolean z14 = b11 || Optimizer.b(i27, 64);
        if (z14) {
            int i30 = 0;
            while (true) {
                if (i30 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetContainer2.T0.get(i30);
                ConstraintWidget.DimensionBehaviour B = constraintWidget.B();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z15 = (B == dimensionBehaviour) && (constraintWidget.R() == dimensionBehaviour) && constraintWidget.w() > 0.0f;
                if ((!constraintWidget.g0() || !z15) && ((!constraintWidget.i0() || !z15) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.g0() && !constraintWidget.i0())) {
                    i30++;
                }
            }
            z14 = false;
        }
        if (z14 && (metrics = LinearSystem.f6557x) != null) {
            metrics.f6580c++;
        }
        boolean z16 = z14 & ((i28 == 1073741824 && i29 == 1073741824) || b11);
        int i31 = 2;
        if (z16) {
            int min = Math.min(constraintWidgetContainer.H(), i15);
            int min2 = Math.min(constraintWidgetContainer.G(), i17);
            if (i28 == 1073741824 && constraintWidgetContainer.U() != min) {
                constraintWidgetContainer2.f1(min);
                constraintWidgetContainer.I1();
            }
            if (i29 == 1073741824 && constraintWidgetContainer.y() != min2) {
                constraintWidgetContainer2.G0(min2);
                constraintWidgetContainer.I1();
            }
            if (i28 == 1073741824 && i29 == 1073741824) {
                z11 = constraintWidgetContainer2.A1(b11);
                i21 = 2;
            } else {
                boolean B1 = constraintWidgetContainer2.B1(b11);
                if (i28 == 1073741824) {
                    B1 &= constraintWidgetContainer2.C1(b11, 0);
                    i21 = 1;
                } else {
                    i21 = 0;
                }
                if (i29 == 1073741824) {
                    z11 = constraintWidgetContainer2.C1(b11, 1) & B1;
                    i21++;
                } else {
                    z11 = B1;
                }
            }
            if (z11) {
                constraintWidgetContainer2.k1(i28 == 1073741824, i29 == 1073741824);
            }
        } else {
            z11 = false;
            i21 = 0;
        }
        if (z11 && i21 == 2) {
            return 0;
        }
        int F1 = constraintWidgetContainer.F1();
        if (size > 0) {
            b(constraintWidgetContainer);
        }
        e(constraintWidgetContainer);
        int size2 = this.f7235a.size();
        if (size > 0) {
            c(constraintWidgetContainer, "First pass", 0, U, y11);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour B2 = constraintWidgetContainer.B();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z17 = B2 == dimensionBehaviour2;
            boolean z18 = constraintWidgetContainer.R() == dimensionBehaviour2;
            int max = Math.max(constraintWidgetContainer.U(), this.f7237c.J());
            int max2 = Math.max(constraintWidgetContainer.y(), this.f7237c.I());
            int i32 = 0;
            boolean z19 = false;
            while (i32 < size2) {
                ConstraintWidget constraintWidget2 = this.f7235a.get(i32);
                if (!(constraintWidget2 instanceof VirtualLayout)) {
                    i24 = F1;
                    i25 = U;
                    i26 = y11;
                } else {
                    int U2 = constraintWidget2.U();
                    i24 = F1;
                    int y12 = constraintWidget2.y();
                    i26 = y11;
                    boolean a11 = a(E1, constraintWidget2, Measure.f7239l) | z19;
                    Metrics metrics2 = constraintWidgetContainer2.Z0;
                    i25 = U;
                    boolean z21 = a11;
                    if (metrics2 != null) {
                        metrics2.f6579b++;
                    }
                    int U3 = constraintWidget2.U();
                    int y13 = constraintWidget2.y();
                    if (U3 != U2) {
                        constraintWidget2.f1(U3);
                        if (z17 && constraintWidget2.N() > max) {
                            max = Math.max(max, constraintWidget2.N() + constraintWidget2.p(ConstraintAnchor.Type.RIGHT).f());
                        }
                        z13 = true;
                    } else {
                        z13 = z21;
                    }
                    if (y13 != y12) {
                        constraintWidget2.G0(y13);
                        if (z18 && constraintWidget2.s() > max2) {
                            max2 = Math.max(max2, constraintWidget2.s() + constraintWidget2.p(ConstraintAnchor.Type.BOTTOM).f());
                        }
                        z13 = true;
                    }
                    z19 = z13 | ((VirtualLayout) constraintWidget2).A1();
                }
                i32++;
                F1 = i24;
                y11 = i26;
                U = i25;
                i31 = 2;
            }
            int i33 = F1;
            int i34 = U;
            int i35 = y11;
            int i36 = i31;
            int i37 = 0;
            while (i37 < i36) {
                int i38 = 0;
                while (i38 < size2) {
                    ConstraintWidget constraintWidget3 = this.f7235a.get(i38);
                    if ((!(constraintWidget3 instanceof l0.a) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.T() != 8 && ((!z16 || !constraintWidget3.f7096e.f7270e.f7260j || !constraintWidget3.f7098f.f7270e.f7260j) && !(constraintWidget3 instanceof VirtualLayout))) {
                        int U4 = constraintWidget3.U();
                        int y14 = constraintWidget3.y();
                        int q11 = constraintWidget3.q();
                        int i39 = Measure.f7239l;
                        z12 = z16;
                        if (i37 == 1) {
                            i39 = Measure.f7240m;
                        }
                        boolean a12 = a(E1, constraintWidget3, i39) | z19;
                        Metrics metrics3 = constraintWidgetContainer2.Z0;
                        i23 = size2;
                        aVar = E1;
                        if (metrics3 != null) {
                            metrics3.f6579b++;
                        }
                        int U5 = constraintWidget3.U();
                        int y15 = constraintWidget3.y();
                        if (U5 != U4) {
                            constraintWidget3.f1(U5);
                            if (z17 && constraintWidget3.N() > max) {
                                max = Math.max(max, constraintWidget3.N() + constraintWidget3.p(ConstraintAnchor.Type.RIGHT).f());
                            }
                            a12 = true;
                        }
                        if (y15 != y14) {
                            constraintWidget3.G0(y15);
                            if (z18 && constraintWidget3.s() > max2) {
                                max2 = Math.max(max2, constraintWidget3.s() + constraintWidget3.p(ConstraintAnchor.Type.BOTTOM).f());
                            }
                            a12 = true;
                        }
                        z19 = (!constraintWidget3.X() || q11 == constraintWidget3.q()) ? a12 : true;
                    } else {
                        z12 = z16;
                        i23 = size2;
                        aVar = E1;
                    }
                    i38++;
                    E1 = aVar;
                    z16 = z12;
                    size2 = i23;
                }
                boolean z22 = z16;
                int i40 = size2;
                a aVar2 = E1;
                if (!z19) {
                    break;
                }
                i37++;
                c(constraintWidgetContainer, "intermediate pass", i37, i34, i35);
                E1 = aVar2;
                z16 = z22;
                size2 = i40;
                i36 = 2;
                z19 = false;
            }
            i22 = i33;
        } else {
            i22 = F1;
        }
        constraintWidgetContainer2.S1(i22);
        return 0;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f7235a.clear();
        int size = constraintWidgetContainer.T0.size();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.T0.get(i11);
            ConstraintWidget.DimensionBehaviour B = constraintWidget.B();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (B == dimensionBehaviour || constraintWidget.R() == dimensionBehaviour) {
                this.f7235a.add(constraintWidget);
            }
        }
        constraintWidgetContainer.I1();
    }
}
