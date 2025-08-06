package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;

public class Direct {

    /* renamed from: a  reason: collision with root package name */
    public static BasicMeasure.Measure f7263a = new BasicMeasure.Measure();

    /* renamed from: b  reason: collision with root package name */
    public static int f7264b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f7265c = 0;

    public static boolean a(int i11, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour B = constraintWidget.B();
        ConstraintWidget.DimensionBehaviour R = constraintWidget.R();
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget.L() != null ? (ConstraintWidgetContainer) constraintWidget.L() : null;
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour B2 = constraintWidgetContainer.B();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour R2 = constraintWidgetContainer.R();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z11 = B == dimensionBehaviour5 || constraintWidget.l0() || B == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (B == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f7130v == 0 && constraintWidget.f7097e0 == 0.0f && constraintWidget.Y(0)) || (B == dimensionBehaviour2 && constraintWidget.f7130v == 1 && constraintWidget.b0(0, constraintWidget.U()));
        boolean z12 = R == dimensionBehaviour5 || constraintWidget.m0() || R == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (R == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f7132w == 0 && constraintWidget.f7097e0 == 0.0f && constraintWidget.Y(1)) || (B == dimensionBehaviour && constraintWidget.f7132w == 1 && constraintWidget.b0(1, constraintWidget.y()));
        if (constraintWidget.f7097e0 > 0.0f && (z11 || z12)) {
            return true;
        }
        if (!z11 || !z12) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
        r11 = r12.R.f7083f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cb, code lost:
        r8 = r12.P.f7083f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(int r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.a r18, boolean r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r17.e0()
            if (r3 == 0) goto L_0x000d
            return
        L_0x000d:
            int r3 = f7264b
            r4 = 1
            int r3 = r3 + r4
            f7264b = r3
            boolean r3 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r3 != 0) goto L_0x002f
            boolean r3 = r17.k0()
            if (r3 == 0) goto L_0x002f
            int r3 = r16 + 1
            boolean r5 = a(r3, r0)
            if (r5 == 0) goto L_0x002f
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r5 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r5.<init>()
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.O1(r3, r0, r1, r5, r6)
        L_0x002f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.p(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.p(r5)
            int r6 = r3.e()
            int r7 = r5.e()
            java.util.HashSet r8 = r3.d()
            r9 = 0
            r10 = 8
            if (r8 == 0) goto L_0x013e
            boolean r8 = r3.n()
            if (r8 == 0) goto L_0x013e
            java.util.HashSet r3 = r3.d()
            java.util.Iterator r3 = r3.iterator()
        L_0x005a:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x013e
            java.lang.Object r8 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r8.f7081d
            int r13 = r16 + 1
            boolean r14 = a(r13, r12)
            boolean r15 = r12.k0()
            if (r15 == 0) goto L_0x0080
            if (r14 == 0) goto L_0x0080
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r15 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r15.<init>()
            int r11 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.O1(r13, r12, r1, r15, r11)
        L_0x0080:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r12.B()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r15) goto L_0x00e7
            if (r14 == 0) goto L_0x008b
            goto L_0x00e7
        L_0x008b:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r12.B()
            if (r11 != r15) goto L_0x005a
            int r11 = r12.f7138z
            if (r11 < 0) goto L_0x005a
            int r11 = r12.f7136y
            if (r11 < 0) goto L_0x005a
            int r11 = r12.T()
            if (r11 == r10) goto L_0x00ab
            int r11 = r12.f7130v
            if (r11 != 0) goto L_0x005a
            float r11 = r12.w()
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x005a
        L_0x00ab:
            boolean r11 = r12.g0()
            if (r11 != 0) goto L_0x005a
            boolean r11 = r12.j0()
            if (r11 != 0) goto L_0x005a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.P
            if (r8 != r11) goto L_0x00c7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f7083f
            if (r11 == 0) goto L_0x00c7
            boolean r11 = r11.n()
            if (r11 != 0) goto L_0x00d7
        L_0x00c7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.R
            if (r8 != r11) goto L_0x00d9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r12.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r8.f7083f
            if (r8 == 0) goto L_0x00d9
            boolean r8 = r8.n()
            if (r8 == 0) goto L_0x00d9
        L_0x00d7:
            r8 = r4
            goto L_0x00da
        L_0x00d9:
            r8 = 0
        L_0x00da:
            if (r8 == 0) goto L_0x005a
            boolean r8 = r12.g0()
            if (r8 != 0) goto L_0x005a
            e(r13, r0, r1, r12, r2)
            goto L_0x005a
        L_0x00e7:
            boolean r11 = r12.k0()
            if (r11 == 0) goto L_0x00ef
            goto L_0x005a
        L_0x00ef:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.P
            if (r8 != r11) goto L_0x010b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f7083f
            if (r14 != 0) goto L_0x010b
            int r8 = r11.f()
            int r8 = r8 + r6
            int r11 = r12.U()
            int r11 = r11 + r8
            r12.A0(r8, r11)
            b(r13, r12, r1, r2)
            goto L_0x005a
        L_0x010b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.R
            if (r8 != r14) goto L_0x0127
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r11.f7083f
            if (r15 != 0) goto L_0x0127
            int r8 = r14.f()
            int r8 = r6 - r8
            int r11 = r12.U()
            int r11 = r8 - r11
            r12.A0(r11, r8)
            b(r13, r12, r1, r2)
            goto L_0x005a
        L_0x0127:
            if (r8 != r11) goto L_0x005a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r14.f7083f
            if (r8 == 0) goto L_0x005a
            boolean r8 = r8.n()
            if (r8 == 0) goto L_0x005a
            boolean r8 = r12.g0()
            if (r8 != 0) goto L_0x005a
            d(r13, r1, r12, r2)
            goto L_0x005a
        L_0x013e:
            boolean r3 = r0 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r3 == 0) goto L_0x0143
            return
        L_0x0143:
            java.util.HashSet r3 = r5.d()
            if (r3 == 0) goto L_0x0231
            boolean r3 = r5.n()
            if (r3 == 0) goto L_0x0231
            java.util.HashSet r3 = r5.d()
            java.util.Iterator r3 = r3.iterator()
        L_0x0157:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0231
            java.lang.Object r5 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f7081d
            int r8 = r16 + 1
            boolean r11 = a(r8, r6)
            boolean r12 = r6.k0()
            if (r12 == 0) goto L_0x017d
            if (r11 == 0) goto L_0x017d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r12 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r12.<init>()
            int r13 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.O1(r8, r6, r1, r12, r13)
        L_0x017d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.P
            if (r5 != r12) goto L_0x018d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f7083f
            if (r12 == 0) goto L_0x018d
            boolean r12 = r12.n()
            if (r12 != 0) goto L_0x019d
        L_0x018d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.R
            if (r5 != r12) goto L_0x019f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f7083f
            if (r12 == 0) goto L_0x019f
            boolean r12 = r12.n()
            if (r12 == 0) goto L_0x019f
        L_0x019d:
            r12 = r4
            goto L_0x01a0
        L_0x019f:
            r12 = 0
        L_0x01a0:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = r6.B()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r13 != r14) goto L_0x01e4
            if (r11 == 0) goto L_0x01ab
            goto L_0x01e4
        L_0x01ab:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = r6.B()
            if (r5 != r14) goto L_0x0157
            int r5 = r6.f7138z
            if (r5 < 0) goto L_0x0157
            int r5 = r6.f7136y
            if (r5 < 0) goto L_0x0157
            int r5 = r6.T()
            if (r5 == r10) goto L_0x01cb
            int r5 = r6.f7130v
            if (r5 != 0) goto L_0x0157
            float r5 = r6.w()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x0157
        L_0x01cb:
            boolean r5 = r6.g0()
            if (r5 != 0) goto L_0x0157
            boolean r5 = r6.j0()
            if (r5 != 0) goto L_0x0157
            if (r12 == 0) goto L_0x0157
            boolean r5 = r6.g0()
            if (r5 != 0) goto L_0x0157
            e(r8, r0, r1, r6, r2)
            goto L_0x0157
        L_0x01e4:
            boolean r11 = r6.k0()
            if (r11 == 0) goto L_0x01ec
            goto L_0x0157
        L_0x01ec:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.P
            if (r5 != r11) goto L_0x0208
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r6.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f7083f
            if (r13 != 0) goto L_0x0208
            int r5 = r11.f()
            int r5 = r5 + r7
            int r11 = r6.U()
            int r11 = r11 + r5
            r6.A0(r5, r11)
            b(r8, r6, r1, r2)
            goto L_0x0157
        L_0x0208:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r6.R
            if (r5 != r13) goto L_0x0224
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r11.f7083f
            if (r5 != 0) goto L_0x0224
            int r5 = r13.f()
            int r5 = r7 - r5
            int r11 = r6.U()
            int r11 = r5 - r11
            r6.A0(r11, r5)
            b(r8, r6, r1, r2)
            goto L_0x0157
        L_0x0224:
            if (r12 == 0) goto L_0x0157
            boolean r5 = r6.g0()
            if (r5 != 0) goto L_0x0157
            d(r8, r1, r6, r2)
            goto L_0x0157
        L_0x0231:
            r17.o0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.b(int, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$a, boolean):void");
    }

    public static void c(int i11, Barrier barrier, BasicMeasure.a aVar, int i12, boolean z11) {
        if (!barrier.o1()) {
            return;
        }
        if (i12 == 0) {
            b(i11 + 1, barrier, aVar, z11);
        } else {
            i(i11 + 1, barrier, aVar);
        }
    }

    public static void d(int i11, BasicMeasure.a aVar, ConstraintWidget constraintWidget, boolean z11) {
        float z12 = constraintWidget.z();
        int e11 = constraintWidget.P.f7083f.e();
        int e12 = constraintWidget.R.f7083f.e();
        int f11 = constraintWidget.P.f() + e11;
        int f12 = e12 - constraintWidget.R.f();
        if (e11 == e12) {
            z12 = 0.5f;
        } else {
            e11 = f11;
            e12 = f12;
        }
        int U = constraintWidget.U();
        int i12 = (e12 - e11) - U;
        if (e11 > e12) {
            i12 = (e11 - e12) - U;
        }
        int i13 = ((int) (i12 > 0 ? (z12 * ((float) i12)) + 0.5f : z12 * ((float) i12))) + e11;
        int i14 = i13 + U;
        if (e11 > e12) {
            i14 = i13 - U;
        }
        constraintWidget.A0(i13, i14);
        b(i11 + 1, constraintWidget, aVar, z11);
    }

    public static void e(int i11, ConstraintWidget constraintWidget, BasicMeasure.a aVar, ConstraintWidget constraintWidget2, boolean z11) {
        int i12;
        float z12 = constraintWidget2.z();
        int e11 = constraintWidget2.P.f7083f.e() + constraintWidget2.P.f();
        int e12 = constraintWidget2.R.f7083f.e() - constraintWidget2.R.f();
        if (e12 >= e11) {
            int U = constraintWidget2.U();
            if (constraintWidget2.T() != 8) {
                int i13 = constraintWidget2.f7130v;
                if (i13 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i12 = constraintWidget.U();
                    } else {
                        i12 = constraintWidget.L().U();
                    }
                    U = (int) (constraintWidget2.z() * 0.5f * ((float) i12));
                } else if (i13 == 0) {
                    U = e12 - e11;
                }
                U = Math.max(constraintWidget2.f7136y, U);
                int i14 = constraintWidget2.f7138z;
                if (i14 > 0) {
                    U = Math.min(i14, U);
                }
            }
            int i15 = e11 + ((int) ((z12 * ((float) ((e12 - e11) - U))) + 0.5f));
            constraintWidget2.A0(i15, U + i15);
            b(i11 + 1, constraintWidget2, aVar, z11);
        }
    }

    public static void f(int i11, BasicMeasure.a aVar, ConstraintWidget constraintWidget) {
        float P = constraintWidget.P();
        int e11 = constraintWidget.Q.f7083f.e();
        int e12 = constraintWidget.S.f7083f.e();
        int f11 = constraintWidget.Q.f() + e11;
        int f12 = e12 - constraintWidget.S.f();
        if (e11 == e12) {
            P = 0.5f;
        } else {
            e11 = f11;
            e12 = f12;
        }
        int y11 = constraintWidget.y();
        int i12 = (e12 - e11) - y11;
        if (e11 > e12) {
            i12 = (e11 - e12) - y11;
        }
        int i13 = (int) (i12 > 0 ? (P * ((float) i12)) + 0.5f : P * ((float) i12));
        int i14 = e11 + i13;
        int i15 = i14 + y11;
        if (e11 > e12) {
            i14 = e11 - i13;
            i15 = i14 - y11;
        }
        constraintWidget.D0(i14, i15);
        i(i11 + 1, constraintWidget, aVar);
    }

    public static void g(int i11, ConstraintWidget constraintWidget, BasicMeasure.a aVar, ConstraintWidget constraintWidget2) {
        int i12;
        float P = constraintWidget2.P();
        int e11 = constraintWidget2.Q.f7083f.e() + constraintWidget2.Q.f();
        int e12 = constraintWidget2.S.f7083f.e() - constraintWidget2.S.f();
        if (e12 >= e11) {
            int y11 = constraintWidget2.y();
            if (constraintWidget2.T() != 8) {
                int i13 = constraintWidget2.f7132w;
                if (i13 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i12 = constraintWidget.y();
                    } else {
                        i12 = constraintWidget.L().y();
                    }
                    y11 = (int) (P * 0.5f * ((float) i12));
                } else if (i13 == 0) {
                    y11 = e12 - e11;
                }
                y11 = Math.max(constraintWidget2.B, y11);
                int i14 = constraintWidget2.C;
                if (i14 > 0) {
                    y11 = Math.min(i14, y11);
                }
            }
            int i15 = e11 + ((int) ((P * ((float) ((e12 - e11) - y11))) + 0.5f));
            constraintWidget2.D0(i15, y11 + i15);
            i(i11 + 1, constraintWidget2, aVar);
        }
    }

    public static void h(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.a aVar) {
        ConstraintWidget.DimensionBehaviour B = constraintWidgetContainer.B();
        ConstraintWidget.DimensionBehaviour R = constraintWidgetContainer.R();
        f7264b = 0;
        f7265c = 0;
        constraintWidgetContainer.t0();
        ArrayList<ConstraintWidget> m12 = constraintWidgetContainer.m1();
        int size = m12.size();
        for (int i11 = 0; i11 < size; i11++) {
            m12.get(i11).t0();
        }
        boolean L1 = constraintWidgetContainer.L1();
        if (B == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.A0(0, constraintWidgetContainer.U());
        } else {
            constraintWidgetContainer.B0(0);
        }
        boolean z11 = false;
        boolean z12 = false;
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget = m12.get(i12);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.n1() == 1) {
                    if (guideline.o1() != -1) {
                        guideline.r1(guideline.o1());
                    } else if (guideline.p1() != -1 && constraintWidgetContainer.l0()) {
                        guideline.r1(constraintWidgetContainer.U() - guideline.p1());
                    } else if (constraintWidgetContainer.l0()) {
                        guideline.r1((int) ((guideline.q1() * ((float) constraintWidgetContainer.U())) + 0.5f));
                    }
                    z11 = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).s1() == 0) {
                z12 = true;
            }
        }
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget2 = m12.get(i13);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.n1() == 1) {
                        b(0, guideline2, aVar, L1);
                    }
                }
            }
        }
        b(0, constraintWidgetContainer, aVar, L1);
        if (z12) {
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget3 = m12.get(i14);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.s1() == 0) {
                        c(0, barrier, aVar, 0, L1);
                    }
                }
            }
        }
        if (R == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.D0(0, constraintWidgetContainer.y());
        } else {
            constraintWidgetContainer.C0(0);
        }
        boolean z13 = false;
        boolean z14 = false;
        for (int i15 = 0; i15 < size; i15++) {
            ConstraintWidget constraintWidget4 = m12.get(i15);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.n1() == 0) {
                    if (guideline3.o1() != -1) {
                        guideline3.r1(guideline3.o1());
                    } else if (guideline3.p1() != -1 && constraintWidgetContainer.m0()) {
                        guideline3.r1(constraintWidgetContainer.y() - guideline3.p1());
                    } else if (constraintWidgetContainer.m0()) {
                        guideline3.r1((int) ((guideline3.q1() * ((float) constraintWidgetContainer.y())) + 0.5f));
                    }
                    z13 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).s1() == 1) {
                z14 = true;
            }
        }
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget5 = m12.get(i16);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.n1() == 0) {
                        i(1, guideline4, aVar);
                    }
                }
            }
        }
        i(0, constraintWidgetContainer, aVar);
        if (z14) {
            for (int i17 = 0; i17 < size; i17++) {
                ConstraintWidget constraintWidget6 = m12.get(i17);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.s1() == 1) {
                        c(0, barrier2, aVar, 1, L1);
                    }
                }
            }
        }
        for (int i18 = 0; i18 < size; i18++) {
            ConstraintWidget constraintWidget7 = m12.get(i18);
            if (constraintWidget7.k0() && a(0, constraintWidget7)) {
                ConstraintWidgetContainer.O1(0, constraintWidget7, aVar, f7263a, BasicMeasure.Measure.f7238k);
                if (!(constraintWidget7 instanceof Guideline)) {
                    b(0, constraintWidget7, aVar, L1);
                    i(0, constraintWidget7, aVar);
                } else if (((Guideline) constraintWidget7).n1() == 0) {
                    i(0, constraintWidget7, aVar);
                } else {
                    b(0, constraintWidget7, aVar, L1);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        r13 = r11.S.f7083f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ca, code lost:
        r7 = r11.Q.f7083f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void i(int r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.a r18) {
        /*
            r0 = r17
            r1 = r18
            boolean r2 = r17.n0()
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            int r2 = f7265c
            r3 = 1
            int r2 = r2 + r3
            f7265c = r2
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r2 != 0) goto L_0x002d
            boolean r2 = r17.k0()
            if (r2 == 0) goto L_0x002d
            int r2 = r16 + 1
            boolean r4 = a(r2, r0)
            if (r4 == 0) goto L_0x002d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r4.<init>()
            int r5 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.O1(r2, r0, r1, r4, r5)
        L_0x002d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.p(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.p(r4)
            int r5 = r2.e()
            int r6 = r4.e()
            java.util.HashSet r7 = r2.d()
            r8 = 0
            r9 = 8
            r10 = 0
            if (r7 == 0) goto L_0x0137
            boolean r7 = r2.n()
            if (r7 == 0) goto L_0x0137
            java.util.HashSet r2 = r2.d()
            java.util.Iterator r2 = r2.iterator()
        L_0x0059:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0137
            java.lang.Object r7 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r7.f7081d
            int r12 = r16 + 1
            boolean r13 = a(r12, r11)
            boolean r14 = r11.k0()
            if (r14 == 0) goto L_0x007f
            if (r13 == 0) goto L_0x007f
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r14 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r14.<init>()
            int r15 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.O1(r12, r11, r1, r14, r15)
        L_0x007f:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = r11.R()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r14 != r15) goto L_0x00e6
            if (r13 == 0) goto L_0x008a
            goto L_0x00e6
        L_0x008a:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = r11.R()
            if (r13 != r15) goto L_0x0059
            int r13 = r11.C
            if (r13 < 0) goto L_0x0059
            int r13 = r11.B
            if (r13 < 0) goto L_0x0059
            int r13 = r11.T()
            if (r13 == r9) goto L_0x00aa
            int r13 = r11.f7132w
            if (r13 != 0) goto L_0x0059
            float r13 = r11.w()
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 != 0) goto L_0x0059
        L_0x00aa:
            boolean r13 = r11.i0()
            if (r13 != 0) goto L_0x0059
            boolean r13 = r11.j0()
            if (r13 != 0) goto L_0x0059
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.Q
            if (r7 != r13) goto L_0x00c6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f7083f
            if (r13 == 0) goto L_0x00c6
            boolean r13 = r13.n()
            if (r13 != 0) goto L_0x00d6
        L_0x00c6:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.S
            if (r7 != r13) goto L_0x00d8
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r11.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f7083f
            if (r7 == 0) goto L_0x00d8
            boolean r7 = r7.n()
            if (r7 == 0) goto L_0x00d8
        L_0x00d6:
            r7 = r3
            goto L_0x00d9
        L_0x00d8:
            r7 = r10
        L_0x00d9:
            if (r7 == 0) goto L_0x0059
            boolean r7 = r11.i0()
            if (r7 != 0) goto L_0x0059
            g(r12, r0, r1, r11)
            goto L_0x0059
        L_0x00e6:
            boolean r13 = r11.k0()
            if (r13 == 0) goto L_0x00ee
            goto L_0x0059
        L_0x00ee:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.Q
            if (r7 != r13) goto L_0x010a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f7083f
            if (r14 != 0) goto L_0x010a
            int r7 = r13.f()
            int r7 = r7 + r5
            int r13 = r11.y()
            int r13 = r13 + r7
            r11.D0(r7, r13)
            i(r12, r11, r1)
            goto L_0x0059
        L_0x010a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.S
            if (r7 != r14) goto L_0x0126
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r14.f7083f
            if (r15 != 0) goto L_0x0126
            int r7 = r14.f()
            int r7 = r5 - r7
            int r13 = r11.y()
            int r13 = r7 - r13
            r11.D0(r13, r7)
            i(r12, r11, r1)
            goto L_0x0059
        L_0x0126:
            if (r7 != r13) goto L_0x0059
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r14.f7083f
            if (r7 == 0) goto L_0x0059
            boolean r7 = r7.n()
            if (r7 == 0) goto L_0x0059
            f(r12, r1, r11)
            goto L_0x0059
        L_0x0137:
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r2 == 0) goto L_0x013c
            return
        L_0x013c:
            java.util.HashSet r2 = r4.d()
            if (r2 == 0) goto L_0x022a
            boolean r2 = r4.n()
            if (r2 == 0) goto L_0x022a
            java.util.HashSet r2 = r4.d()
            java.util.Iterator r2 = r2.iterator()
        L_0x0150:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x022a
            java.lang.Object r4 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.f7081d
            int r7 = r16 + 1
            boolean r11 = a(r7, r5)
            boolean r12 = r5.k0()
            if (r12 == 0) goto L_0x0176
            if (r11 == 0) goto L_0x0176
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r12 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r12.<init>()
            int r13 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.O1(r7, r5, r1, r12, r13)
        L_0x0176:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.Q
            if (r4 != r12) goto L_0x0186
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f7083f
            if (r12 == 0) goto L_0x0186
            boolean r12 = r12.n()
            if (r12 != 0) goto L_0x0196
        L_0x0186:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.S
            if (r4 != r12) goto L_0x0198
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f7083f
            if (r12 == 0) goto L_0x0198
            boolean r12 = r12.n()
            if (r12 == 0) goto L_0x0198
        L_0x0196:
            r12 = r3
            goto L_0x0199
        L_0x0198:
            r12 = r10
        L_0x0199:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = r5.R()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r13 != r14) goto L_0x01dd
            if (r11 == 0) goto L_0x01a4
            goto L_0x01dd
        L_0x01a4:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r5.R()
            if (r4 != r14) goto L_0x0150
            int r4 = r5.C
            if (r4 < 0) goto L_0x0150
            int r4 = r5.B
            if (r4 < 0) goto L_0x0150
            int r4 = r5.T()
            if (r4 == r9) goto L_0x01c4
            int r4 = r5.f7132w
            if (r4 != 0) goto L_0x0150
            float r4 = r5.w()
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0150
        L_0x01c4:
            boolean r4 = r5.i0()
            if (r4 != 0) goto L_0x0150
            boolean r4 = r5.j0()
            if (r4 != 0) goto L_0x0150
            if (r12 == 0) goto L_0x0150
            boolean r4 = r5.i0()
            if (r4 != 0) goto L_0x0150
            g(r7, r0, r1, r5)
            goto L_0x0150
        L_0x01dd:
            boolean r11 = r5.k0()
            if (r11 == 0) goto L_0x01e5
            goto L_0x0150
        L_0x01e5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.Q
            if (r4 != r11) goto L_0x0201
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r5.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f7083f
            if (r13 != 0) goto L_0x0201
            int r4 = r11.f()
            int r4 = r4 + r6
            int r11 = r5.y()
            int r11 = r11 + r4
            r5.D0(r4, r11)
            i(r7, r5, r1)
            goto L_0x0150
        L_0x0201:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r5.S
            if (r4 != r13) goto L_0x021d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r11.f7083f
            if (r4 != 0) goto L_0x021d
            int r4 = r13.f()
            int r4 = r6 - r4
            int r11 = r5.y()
            int r11 = r4 - r11
            r5.D0(r11, r4)
            i(r7, r5, r1)
            goto L_0x0150
        L_0x021d:
            if (r12 == 0) goto L_0x0150
            boolean r4 = r5.i0()
            if (r4 != 0) goto L_0x0150
            f(r7, r1, r5)
            goto L_0x0150
        L_0x022a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.p(r2)
            java.util.HashSet r4 = r2.d()
            if (r4 == 0) goto L_0x028f
            boolean r4 = r2.n()
            if (r4 == 0) goto L_0x028f
            int r4 = r2.e()
            java.util.HashSet r2 = r2.d()
            java.util.Iterator r2 = r2.iterator()
        L_0x0248:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x028f
            java.lang.Object r5 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f7081d
            int r7 = r16 + 1
            boolean r8 = a(r7, r6)
            boolean r9 = r6.k0()
            if (r9 == 0) goto L_0x026e
            if (r8 == 0) goto L_0x026e
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r9 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r9.<init>()
            int r10 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.O1(r7, r6, r1, r9, r10)
        L_0x026e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r6.R()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r10) goto L_0x0278
            if (r8 == 0) goto L_0x0248
        L_0x0278:
            boolean r8 = r6.k0()
            if (r8 == 0) goto L_0x027f
            goto L_0x0248
        L_0x027f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r6.T
            if (r5 != r8) goto L_0x0248
            int r5 = r5.f()
            int r5 = r5 + r4
            r6.z0(r5)
            i(r7, r6, r1)     // Catch:{ all -> 0x0293 }
            goto L_0x0248
        L_0x028f:
            r17.p0()
            return
        L_0x0293:
            r0 = move-exception
            r1 = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.i(int, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$a):void");
    }
}
