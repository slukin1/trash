package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

public class Guideline extends ConstraintWidget {
    public float T0 = -1.0f;
    public int U0 = -1;
    public int V0 = -1;
    public ConstraintAnchor W0 = this.Q;
    public int X0;
    public int Y0;
    public boolean Z0;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7203a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7203a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7203a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7203a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7203a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7203a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7203a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7203a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7203a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7203a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Guideline.a.<clinit>():void");
        }
    }

    public Guideline() {
        this.X0 = 0;
        this.Y0 = 0;
        this.Y.clear();
        this.Y.add(this.W0);
        int length = this.X.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.X[i11] = this.W0;
        }
    }

    public void g(LinearSystem linearSystem, boolean z11) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) L();
        if (constraintWidgetContainer != null) {
            ConstraintAnchor p11 = constraintWidgetContainer.p(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor p12 = constraintWidgetContainer.p(ConstraintAnchor.Type.RIGHT);
            ConstraintWidget constraintWidget = this.f7091b0;
            boolean z12 = true;
            boolean z13 = constraintWidget != null && constraintWidget.f7089a0[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (this.X0 == 0) {
                p11 = constraintWidgetContainer.p(ConstraintAnchor.Type.TOP);
                p12 = constraintWidgetContainer.p(ConstraintAnchor.Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.f7091b0;
                if (constraintWidget2 == null || constraintWidget2.f7089a0[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z12 = false;
                }
                z13 = z12;
            }
            if (this.Z0 && this.W0.n()) {
                SolverVariable q11 = linearSystem.q(this.W0);
                linearSystem.f(q11, this.W0.e());
                if (this.U0 != -1) {
                    if (z13) {
                        linearSystem.h(linearSystem.q(p12), q11, 0, 5);
                    }
                } else if (this.V0 != -1 && z13) {
                    SolverVariable q12 = linearSystem.q(p12);
                    linearSystem.h(q11, linearSystem.q(p11), 0, 5);
                    linearSystem.h(q12, q11, 0, 5);
                }
                this.Z0 = false;
            } else if (this.U0 != -1) {
                SolverVariable q13 = linearSystem.q(this.W0);
                linearSystem.e(q13, linearSystem.q(p11), this.U0, 8);
                if (z13) {
                    linearSystem.h(linearSystem.q(p12), q13, 0, 5);
                }
            } else if (this.V0 != -1) {
                SolverVariable q14 = linearSystem.q(this.W0);
                SolverVariable q15 = linearSystem.q(p12);
                linearSystem.e(q14, q15, -this.V0, 8);
                if (z13) {
                    linearSystem.h(q14, linearSystem.q(p11), 0, 5);
                    linearSystem.h(q15, q14, 0, 5);
                }
            } else if (this.T0 != -1.0f) {
                linearSystem.d(LinearSystem.s(linearSystem, linearSystem.q(this.W0), linearSystem.q(p12), this.T0));
            }
        }
    }

    public boolean h() {
        return true;
    }

    public boolean l0() {
        return this.Z0;
    }

    public void l1(LinearSystem linearSystem, boolean z11) {
        if (L() != null) {
            int y11 = linearSystem.y(this.W0);
            if (this.X0 == 1) {
                h1(y11);
                i1(0);
                G0(L().y());
                f1(0);
                return;
            }
            h1(0);
            i1(y11);
            f1(L().U());
            G0(0);
        }
    }

    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.m(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.T0 = guideline.T0;
        this.U0 = guideline.U0;
        this.V0 = guideline.V0;
        v1(guideline.X0);
    }

    public boolean m0() {
        return this.Z0;
    }

    public ConstraintAnchor m1() {
        return this.W0;
    }

    public int n1() {
        return this.X0;
    }

    public int o1() {
        return this.U0;
    }

    public ConstraintAnchor p(ConstraintAnchor.Type type) {
        int i11 = a.f7203a[type.ordinal()];
        if (i11 == 1 || i11 == 2) {
            if (this.X0 == 1) {
                return this.W0;
            }
            return null;
        } else if ((i11 == 3 || i11 == 4) && this.X0 == 0) {
            return this.W0;
        } else {
            return null;
        }
    }

    public int p1() {
        return this.V0;
    }

    public float q1() {
        return this.T0;
    }

    public void r1(int i11) {
        this.W0.t(i11);
        this.Z0 = true;
    }

    public void s1(int i11) {
        if (i11 > -1) {
            this.T0 = -1.0f;
            this.U0 = i11;
            this.V0 = -1;
        }
    }

    public void t1(int i11) {
        if (i11 > -1) {
            this.T0 = -1.0f;
            this.U0 = -1;
            this.V0 = i11;
        }
    }

    public void u1(float f11) {
        if (f11 > -1.0f) {
            this.T0 = f11;
            this.U0 = -1;
            this.V0 = -1;
        }
    }

    public void v1(int i11) {
        if (this.X0 != i11) {
            this.X0 = i11;
            this.Y.clear();
            if (this.X0 == 1) {
                this.W0 = this.P;
            } else {
                this.W0 = this.Q;
            }
            this.Y.add(this.W0);
            int length = this.X.length;
            for (int i12 = 0; i12 < length; i12++) {
                this.X[i12] = this.W0;
            }
        }
    }
}
