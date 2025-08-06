package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

public class VirtualLayout extends HelperWidget {
    public int V0 = 0;
    public int W0 = 0;
    public int X0 = 0;
    public int Y0 = 0;
    public int Z0 = 0;

    /* renamed from: a1  reason: collision with root package name */
    public int f7205a1 = 0;

    /* renamed from: b1  reason: collision with root package name */
    public int f7206b1 = 0;

    /* renamed from: c1  reason: collision with root package name */
    public int f7207c1 = 0;

    /* renamed from: d1  reason: collision with root package name */
    public boolean f7208d1 = false;

    /* renamed from: e1  reason: collision with root package name */
    public int f7209e1 = 0;

    /* renamed from: f1  reason: collision with root package name */
    public int f7210f1 = 0;

    /* renamed from: g1  reason: collision with root package name */
    public BasicMeasure.Measure f7211g1 = new BasicMeasure.Measure();

    /* renamed from: h1  reason: collision with root package name */
    public BasicMeasure.a f7212h1 = null;

    public boolean A1() {
        return this.f7208d1;
    }

    public void B1(boolean z11) {
        this.f7208d1 = z11;
    }

    public void C1(int i11, int i12) {
        this.f7209e1 = i11;
        this.f7210f1 = i12;
    }

    public void D1(int i11) {
        this.X0 = i11;
        this.V0 = i11;
        this.Y0 = i11;
        this.W0 = i11;
        this.Z0 = i11;
        this.f7205a1 = i11;
    }

    public void E1(int i11) {
        this.W0 = i11;
    }

    public void F1(int i11) {
        this.f7205a1 = i11;
    }

    public void G1(int i11) {
        this.X0 = i11;
        this.f7206b1 = i11;
    }

    public void H1(int i11) {
        this.Y0 = i11;
        this.f7207c1 = i11;
    }

    public void I1(int i11) {
        this.Z0 = i11;
        this.f7206b1 = i11;
        this.f7207c1 = i11;
    }

    public void J1(int i11) {
        this.V0 = i11;
    }

    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
        p1();
    }

    public void o1(boolean z11) {
        int i11 = this.Z0;
        if (i11 <= 0 && this.f7205a1 <= 0) {
            return;
        }
        if (z11) {
            this.f7206b1 = this.f7205a1;
            this.f7207c1 = i11;
            return;
        }
        this.f7206b1 = i11;
        this.f7207c1 = this.f7205a1;
    }

    public void p1() {
        for (int i11 = 0; i11 < this.U0; i11++) {
            ConstraintWidget constraintWidget = this.T0[i11];
            if (constraintWidget != null) {
                constraintWidget.P0(true);
            }
        }
    }

    public boolean q1(HashSet<ConstraintWidget> hashSet) {
        for (int i11 = 0; i11 < this.U0; i11++) {
            if (hashSet.contains(this.T0[i11])) {
                return true;
            }
        }
        return false;
    }

    public int r1() {
        return this.f7210f1;
    }

    public int s1() {
        return this.f7209e1;
    }

    public int t1() {
        return this.W0;
    }

    public int u1() {
        return this.f7206b1;
    }

    public int v1() {
        return this.f7207c1;
    }

    public int w1() {
        return this.V0;
    }

    public void x1(int i11, int i12, int i13, int i14) {
    }

    public void y1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i11, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i12) {
        while (this.f7212h1 == null && L() != null) {
            this.f7212h1 = ((ConstraintWidgetContainer) L()).E1();
        }
        BasicMeasure.Measure measure = this.f7211g1;
        measure.f7241a = dimensionBehaviour;
        measure.f7242b = dimensionBehaviour2;
        measure.f7243c = i11;
        measure.f7244d = i12;
        this.f7212h1.b(constraintWidget, measure);
        constraintWidget.f1(this.f7211g1.f7245e);
        constraintWidget.G0(this.f7211g1.f7246f);
        constraintWidget.F0(this.f7211g1.f7248h);
        constraintWidget.v0(this.f7211g1.f7247g);
    }

    public boolean z1() {
        ConstraintWidget constraintWidget = this.f7091b0;
        BasicMeasure.a E1 = constraintWidget != null ? ((ConstraintWidgetContainer) constraintWidget).E1() : null;
        if (E1 == null) {
            return false;
        }
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= this.U0) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.T0[i11];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour v11 = constraintWidget2.v(0);
                ConstraintWidget.DimensionBehaviour v12 = constraintWidget2.v(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (v11 != dimensionBehaviour || constraintWidget2.f7130v == 1 || v12 != dimensionBehaviour || constraintWidget2.f7132w == 1) {
                    z11 = false;
                }
                if (!z11) {
                    if (v11 == dimensionBehaviour) {
                        v11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (v12 == dimensionBehaviour) {
                        v12 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.f7211g1;
                    measure.f7241a = v11;
                    measure.f7242b = v12;
                    measure.f7243c = constraintWidget2.U();
                    this.f7211g1.f7244d = constraintWidget2.y();
                    E1.b(constraintWidget2, this.f7211g1);
                    constraintWidget2.f1(this.f7211g1.f7245e);
                    constraintWidget2.G0(this.f7211g1.f7246f);
                    constraintWidget2.v0(this.f7211g1.f7247g);
                }
            }
            i11++;
        }
    }
}
