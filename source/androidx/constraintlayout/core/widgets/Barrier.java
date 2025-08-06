package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

public class Barrier extends HelperWidget {
    public int V0 = 0;
    public boolean W0 = true;
    public int X0 = 0;
    public boolean Y0 = false;

    public void g(LinearSystem linearSystem, boolean z11) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z12;
        int i11;
        int i12;
        int i13;
        ConstraintAnchor[] constraintAnchorArr2 = this.X;
        constraintAnchorArr2[0] = this.P;
        constraintAnchorArr2[2] = this.Q;
        constraintAnchorArr2[1] = this.R;
        constraintAnchorArr2[3] = this.S;
        int i14 = 0;
        while (true) {
            constraintAnchorArr = this.X;
            if (i14 >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i14].f7086i = linearSystem.q(constraintAnchorArr[i14]);
            i14++;
        }
        int i15 = this.V0;
        if (i15 >= 0 && i15 < 4) {
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i15];
            if (!this.Y0) {
                o1();
            }
            if (this.Y0) {
                this.Y0 = false;
                int i16 = this.V0;
                if (i16 == 0 || i16 == 1) {
                    linearSystem.f(this.P.f7086i, this.f7101g0);
                    linearSystem.f(this.R.f7086i, this.f7101g0);
                } else if (i16 == 2 || i16 == 3) {
                    linearSystem.f(this.Q.f7086i, this.f7103h0);
                    linearSystem.f(this.S.f7086i, this.f7103h0);
                }
            } else {
                int i17 = 0;
                while (true) {
                    if (i17 >= this.U0) {
                        z12 = false;
                        break;
                    }
                    ConstraintWidget constraintWidget = this.T0[i17];
                    if ((this.W0 || constraintWidget.h()) && ((((i12 = this.V0) == 0 || i12 == 1) && constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.P.f7083f != null && constraintWidget.R.f7083f != null) || (((i13 = this.V0) == 2 || i13 == 3) && constraintWidget.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.Q.f7083f != null && constraintWidget.S.f7083f != null))) {
                        z12 = true;
                    } else {
                        i17++;
                    }
                }
                z12 = true;
                boolean z13 = this.P.l() || this.R.l();
                boolean z14 = this.Q.l() || this.S.l();
                boolean z15 = !z12 && (((i11 = this.V0) == 0 && z13) || ((i11 == 2 && z14) || ((i11 == 1 && z13) || (i11 == 3 && z14))));
                int i18 = 5;
                if (!z15) {
                    i18 = 4;
                }
                for (int i19 = 0; i19 < this.U0; i19++) {
                    ConstraintWidget constraintWidget2 = this.T0[i19];
                    if (this.W0 || constraintWidget2.h()) {
                        SolverVariable q11 = linearSystem.q(constraintWidget2.X[this.V0]);
                        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.X;
                        int i21 = this.V0;
                        constraintAnchorArr3[i21].f7086i = q11;
                        int i22 = (constraintAnchorArr3[i21].f7083f == null || constraintAnchorArr3[i21].f7083f.f7081d != this) ? 0 : constraintAnchorArr3[i21].f7084g + 0;
                        if (i21 == 0 || i21 == 2) {
                            linearSystem.i(constraintAnchor.f7086i, q11, this.X0 - i22, z12);
                        } else {
                            linearSystem.g(constraintAnchor.f7086i, q11, this.X0 + i22, z12);
                        }
                        linearSystem.e(constraintAnchor.f7086i, q11, this.X0 + i22, i18);
                    }
                }
                int i23 = this.V0;
                if (i23 == 0) {
                    linearSystem.e(this.R.f7086i, this.P.f7086i, 0, 8);
                    linearSystem.e(this.P.f7086i, this.f7091b0.R.f7086i, 0, 4);
                    linearSystem.e(this.P.f7086i, this.f7091b0.P.f7086i, 0, 0);
                } else if (i23 == 1) {
                    linearSystem.e(this.P.f7086i, this.R.f7086i, 0, 8);
                    linearSystem.e(this.P.f7086i, this.f7091b0.P.f7086i, 0, 4);
                    linearSystem.e(this.P.f7086i, this.f7091b0.R.f7086i, 0, 0);
                } else if (i23 == 2) {
                    linearSystem.e(this.S.f7086i, this.Q.f7086i, 0, 8);
                    linearSystem.e(this.Q.f7086i, this.f7091b0.S.f7086i, 0, 4);
                    linearSystem.e(this.Q.f7086i, this.f7091b0.Q.f7086i, 0, 0);
                } else if (i23 == 3) {
                    linearSystem.e(this.Q.f7086i, this.S.f7086i, 0, 8);
                    linearSystem.e(this.Q.f7086i, this.f7091b0.Q.f7086i, 0, 4);
                    linearSystem.e(this.Q.f7086i, this.f7091b0.S.f7086i, 0, 0);
                }
            }
        }
    }

    public boolean h() {
        return true;
    }

    public boolean l0() {
        return this.Y0;
    }

    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.m(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.V0 = barrier.V0;
        this.W0 = barrier.W0;
        this.X0 = barrier.X0;
    }

    public boolean m0() {
        return this.Y0;
    }

    public boolean o1() {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        boolean z11 = true;
        while (true) {
            i11 = this.U0;
            if (i14 >= i11) {
                break;
            }
            ConstraintWidget constraintWidget = this.T0[i14];
            if ((this.W0 || constraintWidget.h()) && ((((i12 = this.V0) == 0 || i12 == 1) && !constraintWidget.l0()) || (((i13 = this.V0) == 2 || i13 == 3) && !constraintWidget.m0()))) {
                z11 = false;
            }
            i14++;
        }
        if (!z11 || i11 <= 0) {
            return false;
        }
        int i15 = 0;
        boolean z12 = false;
        for (int i16 = 0; i16 < this.U0; i16++) {
            ConstraintWidget constraintWidget2 = this.T0[i16];
            if (this.W0 || constraintWidget2.h()) {
                if (!z12) {
                    int i17 = this.V0;
                    if (i17 == 0) {
                        i15 = constraintWidget2.p(ConstraintAnchor.Type.LEFT).e();
                    } else if (i17 == 1) {
                        i15 = constraintWidget2.p(ConstraintAnchor.Type.RIGHT).e();
                    } else if (i17 == 2) {
                        i15 = constraintWidget2.p(ConstraintAnchor.Type.TOP).e();
                    } else if (i17 == 3) {
                        i15 = constraintWidget2.p(ConstraintAnchor.Type.BOTTOM).e();
                    }
                    z12 = true;
                }
                int i18 = this.V0;
                if (i18 == 0) {
                    i15 = Math.min(i15, constraintWidget2.p(ConstraintAnchor.Type.LEFT).e());
                } else if (i18 == 1) {
                    i15 = Math.max(i15, constraintWidget2.p(ConstraintAnchor.Type.RIGHT).e());
                } else if (i18 == 2) {
                    i15 = Math.min(i15, constraintWidget2.p(ConstraintAnchor.Type.TOP).e());
                } else if (i18 == 3) {
                    i15 = Math.max(i15, constraintWidget2.p(ConstraintAnchor.Type.BOTTOM).e());
                }
            }
        }
        int i19 = i15 + this.X0;
        int i21 = this.V0;
        if (i21 == 0 || i21 == 1) {
            A0(i19, i19);
        } else {
            D0(i19, i19);
        }
        this.Y0 = true;
        return true;
    }

    public boolean p1() {
        return this.W0;
    }

    public int q1() {
        return this.V0;
    }

    public int r1() {
        return this.X0;
    }

    public int s1() {
        int i11 = this.V0;
        if (i11 == 0 || i11 == 1) {
            return 0;
        }
        return (i11 == 2 || i11 == 3) ? 1 : -1;
    }

    public void t1() {
        for (int i11 = 0; i11 < this.U0; i11++) {
            ConstraintWidget constraintWidget = this.T0[i11];
            if (this.W0 || constraintWidget.h()) {
                int i12 = this.V0;
                if (i12 == 0 || i12 == 1) {
                    constraintWidget.N0(0, true);
                } else if (i12 == 2 || i12 == 3) {
                    constraintWidget.N0(1, true);
                }
            }
        }
    }

    public String toString() {
        String str = "[Barrier] " + u() + " {";
        for (int i11 = 0; i11 < this.U0; i11++) {
            ConstraintWidget constraintWidget = this.T0[i11];
            if (i11 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.u();
        }
        return str + "}";
    }

    public void u1(boolean z11) {
        this.W0 = z11;
    }

    public void v1(int i11) {
        this.V0 = i11;
    }

    public void w1(int i11) {
        this.X0 = i11;
    }
}
