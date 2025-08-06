package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class Optimizer {

    /* renamed from: a  reason: collision with root package name */
    public static boolean[] f7204a = new boolean[3];

    public static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.f7124s = -1;
        constraintWidget.f7126t = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.f7089a0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.f7089a0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i11 = constraintWidget.P.f7084g;
            int U = constraintWidgetContainer.U() - constraintWidget.R.f7084g;
            ConstraintAnchor constraintAnchor = constraintWidget.P;
            constraintAnchor.f7086i = linearSystem.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.R;
            constraintAnchor2.f7086i = linearSystem.q(constraintAnchor2);
            linearSystem.f(constraintWidget.P.f7086i, i11);
            linearSystem.f(constraintWidget.R.f7086i, U);
            constraintWidget.f7124s = 2;
            constraintWidget.J0(i11, U);
        }
        if (constraintWidgetContainer.f7089a0[1] != dimensionBehaviour2 && constraintWidget.f7089a0[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i12 = constraintWidget.Q.f7084g;
            int y11 = constraintWidgetContainer.y() - constraintWidget.S.f7084g;
            ConstraintAnchor constraintAnchor3 = constraintWidget.Q;
            constraintAnchor3.f7086i = linearSystem.q(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.S;
            constraintAnchor4.f7086i = linearSystem.q(constraintAnchor4);
            linearSystem.f(constraintWidget.Q.f7086i, i12);
            linearSystem.f(constraintWidget.S.f7086i, y11);
            if (constraintWidget.f7113m0 > 0 || constraintWidget.T() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.T;
                constraintAnchor5.f7086i = linearSystem.q(constraintAnchor5);
                linearSystem.f(constraintWidget.T.f7086i, constraintWidget.f7113m0 + i12);
            }
            constraintWidget.f7126t = 2;
            constraintWidget.a1(i12, y11);
        }
    }

    public static final boolean b(int i11, int i12) {
        return (i11 & i12) == i12;
    }
}
