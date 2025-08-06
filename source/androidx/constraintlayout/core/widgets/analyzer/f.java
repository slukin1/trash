package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

public class f extends WidgetRun {
    public f(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f7096e.f();
        constraintWidget.f7098f.f();
        this.f7271f = ((Guideline) constraintWidget).n1();
    }

    public void a(c cVar) {
        DependencyNode dependencyNode = this.f7273h;
        if (dependencyNode.f7253c && !dependencyNode.f7260j) {
            this.f7273h.d((int) ((((float) dependencyNode.f7262l.get(0).f7257g) * ((Guideline) this.f7267b).q1()) + 0.5f));
        }
    }

    public void d() {
        Guideline guideline = (Guideline) this.f7267b;
        int o12 = guideline.o1();
        int p12 = guideline.p1();
        guideline.q1();
        if (guideline.n1() == 1) {
            if (o12 != -1) {
                this.f7273h.f7262l.add(this.f7267b.f7091b0.f7096e.f7273h);
                this.f7267b.f7091b0.f7096e.f7273h.f7261k.add(this.f7273h);
                this.f7273h.f7256f = o12;
            } else if (p12 != -1) {
                this.f7273h.f7262l.add(this.f7267b.f7091b0.f7096e.f7274i);
                this.f7267b.f7091b0.f7096e.f7274i.f7261k.add(this.f7273h);
                this.f7273h.f7256f = -p12;
            } else {
                DependencyNode dependencyNode = this.f7273h;
                dependencyNode.f7252b = true;
                dependencyNode.f7262l.add(this.f7267b.f7091b0.f7096e.f7274i);
                this.f7267b.f7091b0.f7096e.f7274i.f7261k.add(this.f7273h);
            }
            q(this.f7267b.f7096e.f7273h);
            q(this.f7267b.f7096e.f7274i);
            return;
        }
        if (o12 != -1) {
            this.f7273h.f7262l.add(this.f7267b.f7091b0.f7098f.f7273h);
            this.f7267b.f7091b0.f7098f.f7273h.f7261k.add(this.f7273h);
            this.f7273h.f7256f = o12;
        } else if (p12 != -1) {
            this.f7273h.f7262l.add(this.f7267b.f7091b0.f7098f.f7274i);
            this.f7267b.f7091b0.f7098f.f7274i.f7261k.add(this.f7273h);
            this.f7273h.f7256f = -p12;
        } else {
            DependencyNode dependencyNode2 = this.f7273h;
            dependencyNode2.f7252b = true;
            dependencyNode2.f7262l.add(this.f7267b.f7091b0.f7098f.f7274i);
            this.f7267b.f7091b0.f7098f.f7274i.f7261k.add(this.f7273h);
        }
        q(this.f7267b.f7098f.f7273h);
        q(this.f7267b.f7098f.f7274i);
    }

    public void e() {
        if (((Guideline) this.f7267b).n1() == 1) {
            this.f7267b.h1(this.f7273h.f7257g);
        } else {
            this.f7267b.i1(this.f7273h.f7257g);
        }
    }

    public void f() {
        this.f7273h.c();
    }

    public boolean m() {
        return false;
    }

    public final void q(DependencyNode dependencyNode) {
        this.f7273h.f7261k.add(dependencyNode);
        dependencyNode.f7262l.add(this.f7273h);
    }
}
