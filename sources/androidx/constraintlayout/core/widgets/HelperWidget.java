package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import l0.a;

public class HelperWidget extends ConstraintWidget implements a {
    public ConstraintWidget[] T0 = new ConstraintWidget[4];
    public int U0 = 0;

    public void a(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i11 = this.U0 + 1;
            ConstraintWidget[] constraintWidgetArr = this.T0;
            if (i11 > constraintWidgetArr.length) {
                this.T0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.T0;
            int i12 = this.U0;
            constraintWidgetArr2[i12] = constraintWidget;
            this.U0 = i12 + 1;
        }
    }

    public void b() {
        this.U0 = 0;
        Arrays.fill(this.T0, (Object) null);
    }

    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
    }

    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.m(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.U0 = 0;
        int i11 = helperWidget.U0;
        for (int i12 = 0; i12 < i11; i12++) {
            a(hashMap.get(helperWidget.T0[i12]));
        }
    }

    public void m1(ArrayList<k> arrayList, int i11, k kVar) {
        for (int i12 = 0; i12 < this.U0; i12++) {
            kVar.a(this.T0[i12]);
        }
        for (int i13 = 0; i13 < this.U0; i13++) {
            Grouping.a(this.T0[i13], i11, arrayList, kVar);
        }
    }

    public int n1(int i11) {
        int i12;
        int i13;
        for (int i14 = 0; i14 < this.U0; i14++) {
            ConstraintWidget constraintWidget = this.T0[i14];
            if (i11 == 0 && (i13 = constraintWidget.Q0) != -1) {
                return i13;
            }
            if (i11 == 1 && (i12 = constraintWidget.R0) != -1) {
                return i12;
            }
        }
        return -1;
    }
}
