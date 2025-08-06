package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> T0 = new ArrayList<>();

    public void a(ConstraintWidget constraintWidget) {
        this.T0.add(constraintWidget);
        if (constraintWidget.L() != null) {
            ((WidgetContainer) constraintWidget.L()).o1(constraintWidget);
        }
        constraintWidget.X0(this);
    }

    public ArrayList<ConstraintWidget> m1() {
        return this.T0;
    }

    public void n1() {
        ArrayList<ConstraintWidget> arrayList = this.T0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget = this.T0.get(i11);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).n1();
                }
            }
        }
    }

    public void o1(ConstraintWidget constraintWidget) {
        this.T0.remove(constraintWidget);
        constraintWidget.r0();
    }

    public void p1() {
        this.T0.clear();
    }

    public void r0() {
        this.T0.clear();
        super.r0();
    }

    public void u0(Cache cache) {
        super.u0(cache);
        int size = this.T0.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.T0.get(i11).u0(cache);
        }
    }
}
