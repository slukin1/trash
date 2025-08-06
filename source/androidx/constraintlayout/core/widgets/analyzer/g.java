package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

public class g extends WidgetRun {
    public g(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    public void a(c cVar) {
        Barrier barrier = (Barrier) this.f7267b;
        int q12 = barrier.q1();
        int i11 = 0;
        int i12 = -1;
        for (DependencyNode dependencyNode : this.f7273h.f7262l) {
            int i13 = dependencyNode.f7257g;
            if (i12 == -1 || i13 < i12) {
                i12 = i13;
            }
            if (i11 < i13) {
                i11 = i13;
            }
        }
        if (q12 == 0 || q12 == 2) {
            this.f7273h.d(i12 + barrier.r1());
        } else {
            this.f7273h.d(i11 + barrier.r1());
        }
    }

    public void d() {
        ConstraintWidget constraintWidget = this.f7267b;
        if (constraintWidget instanceof Barrier) {
            this.f7273h.f7252b = true;
            Barrier barrier = (Barrier) constraintWidget;
            int q12 = barrier.q1();
            boolean p12 = barrier.p1();
            int i11 = 0;
            if (q12 == 0) {
                this.f7273h.f7255e = DependencyNode.Type.LEFT;
                while (i11 < barrier.U0) {
                    ConstraintWidget constraintWidget2 = barrier.T0[i11];
                    if (p12 || constraintWidget2.T() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.f7096e.f7273h;
                        dependencyNode.f7261k.add(this.f7273h);
                        this.f7273h.f7262l.add(dependencyNode);
                    }
                    i11++;
                }
                q(this.f7267b.f7096e.f7273h);
                q(this.f7267b.f7096e.f7274i);
            } else if (q12 == 1) {
                this.f7273h.f7255e = DependencyNode.Type.RIGHT;
                while (i11 < barrier.U0) {
                    ConstraintWidget constraintWidget3 = barrier.T0[i11];
                    if (p12 || constraintWidget3.T() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.f7096e.f7274i;
                        dependencyNode2.f7261k.add(this.f7273h);
                        this.f7273h.f7262l.add(dependencyNode2);
                    }
                    i11++;
                }
                q(this.f7267b.f7096e.f7273h);
                q(this.f7267b.f7096e.f7274i);
            } else if (q12 == 2) {
                this.f7273h.f7255e = DependencyNode.Type.TOP;
                while (i11 < barrier.U0) {
                    ConstraintWidget constraintWidget4 = barrier.T0[i11];
                    if (p12 || constraintWidget4.T() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f7098f.f7273h;
                        dependencyNode3.f7261k.add(this.f7273h);
                        this.f7273h.f7262l.add(dependencyNode3);
                    }
                    i11++;
                }
                q(this.f7267b.f7098f.f7273h);
                q(this.f7267b.f7098f.f7274i);
            } else if (q12 == 3) {
                this.f7273h.f7255e = DependencyNode.Type.BOTTOM;
                while (i11 < barrier.U0) {
                    ConstraintWidget constraintWidget5 = barrier.T0[i11];
                    if (p12 || constraintWidget5.T() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget5.f7098f.f7274i;
                        dependencyNode4.f7261k.add(this.f7273h);
                        this.f7273h.f7262l.add(dependencyNode4);
                    }
                    i11++;
                }
                q(this.f7267b.f7098f.f7273h);
                q(this.f7267b.f7098f.f7274i);
            }
        }
    }

    public void e() {
        ConstraintWidget constraintWidget = this.f7267b;
        if (constraintWidget instanceof Barrier) {
            int q12 = ((Barrier) constraintWidget).q1();
            if (q12 == 0 || q12 == 1) {
                this.f7267b.h1(this.f7273h.f7257g);
            } else {
                this.f7267b.i1(this.f7273h.f7257g);
            }
        }
    }

    public void f() {
        this.f7268c = null;
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
