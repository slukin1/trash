package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class j extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    public DependencyNode f7299k;

    /* renamed from: l  reason: collision with root package name */
    public e f7300l = null;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7301a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7301a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7301a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7301a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.j.a.<clinit>():void");
        }
    }

    public j(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f7299k = dependencyNode;
        this.f7273h.f7255e = DependencyNode.Type.TOP;
        this.f7274i.f7255e = DependencyNode.Type.BOTTOM;
        dependencyNode.f7255e = DependencyNode.Type.BASELINE;
        this.f7271f = 1;
    }

    public void a(c cVar) {
        int i11;
        float f11;
        float f12;
        float f13;
        int i12 = a.f7301a[this.f7275j.ordinal()];
        if (i12 == 1) {
            p(cVar);
        } else if (i12 == 2) {
            o(cVar);
        } else if (i12 == 3) {
            ConstraintWidget constraintWidget = this.f7267b;
            n(cVar, constraintWidget.Q, constraintWidget.S, 1);
            return;
        }
        e eVar = this.f7270e;
        if (eVar.f7253c && !eVar.f7260j && this.f7269d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f7267b;
            int i13 = constraintWidget2.f7132w;
            if (i13 == 2) {
                ConstraintWidget L = constraintWidget2.L();
                if (L != null) {
                    e eVar2 = L.f7098f.f7270e;
                    if (eVar2.f7260j) {
                        this.f7270e.d((int) ((((float) eVar2.f7257g) * this.f7267b.D) + 0.5f));
                    }
                }
            } else if (i13 == 3 && constraintWidget2.f7096e.f7270e.f7260j) {
                int x11 = constraintWidget2.x();
                if (x11 == -1) {
                    ConstraintWidget constraintWidget3 = this.f7267b;
                    f13 = (float) constraintWidget3.f7096e.f7270e.f7257g;
                    f12 = constraintWidget3.w();
                } else if (x11 == 0) {
                    ConstraintWidget constraintWidget4 = this.f7267b;
                    f11 = ((float) constraintWidget4.f7096e.f7270e.f7257g) * constraintWidget4.w();
                    i11 = (int) (f11 + 0.5f);
                    this.f7270e.d(i11);
                } else if (x11 != 1) {
                    i11 = 0;
                    this.f7270e.d(i11);
                } else {
                    ConstraintWidget constraintWidget5 = this.f7267b;
                    f13 = (float) constraintWidget5.f7096e.f7270e.f7257g;
                    f12 = constraintWidget5.w();
                }
                f11 = f13 / f12;
                i11 = (int) (f11 + 0.5f);
                this.f7270e.d(i11);
            }
        }
        DependencyNode dependencyNode = this.f7273h;
        if (dependencyNode.f7253c) {
            DependencyNode dependencyNode2 = this.f7274i;
            if (dependencyNode2.f7253c) {
                if (!dependencyNode.f7260j || !dependencyNode2.f7260j || !this.f7270e.f7260j) {
                    if (!this.f7270e.f7260j && this.f7269d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.f7267b;
                        if (constraintWidget6.f7130v == 0 && !constraintWidget6.i0()) {
                            int i14 = this.f7273h.f7262l.get(0).f7257g;
                            DependencyNode dependencyNode3 = this.f7273h;
                            int i15 = i14 + dependencyNode3.f7256f;
                            int i16 = this.f7274i.f7262l.get(0).f7257g + this.f7274i.f7256f;
                            dependencyNode3.d(i15);
                            this.f7274i.d(i16);
                            this.f7270e.d(i16 - i15);
                            return;
                        }
                    }
                    if (!this.f7270e.f7260j && this.f7269d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f7266a == 1 && this.f7273h.f7262l.size() > 0 && this.f7274i.f7262l.size() > 0) {
                        int i17 = (this.f7274i.f7262l.get(0).f7257g + this.f7274i.f7256f) - (this.f7273h.f7262l.get(0).f7257g + this.f7273h.f7256f);
                        e eVar3 = this.f7270e;
                        int i18 = eVar3.f7288m;
                        if (i17 < i18) {
                            eVar3.d(i17);
                        } else {
                            eVar3.d(i18);
                        }
                    }
                    if (this.f7270e.f7260j && this.f7273h.f7262l.size() > 0 && this.f7274i.f7262l.size() > 0) {
                        DependencyNode dependencyNode4 = this.f7273h.f7262l.get(0);
                        DependencyNode dependencyNode5 = this.f7274i.f7262l.get(0);
                        int i19 = dependencyNode4.f7257g + this.f7273h.f7256f;
                        int i21 = dependencyNode5.f7257g + this.f7274i.f7256f;
                        float P = this.f7267b.P();
                        if (dependencyNode4 == dependencyNode5) {
                            i19 = dependencyNode4.f7257g;
                            i21 = dependencyNode5.f7257g;
                            P = 0.5f;
                        }
                        this.f7273h.d((int) (((float) i19) + 0.5f + (((float) ((i21 - i19) - this.f7270e.f7257g)) * P)));
                        this.f7274i.d(this.f7273h.f7257g + this.f7270e.f7257g);
                    }
                }
            }
        }
    }

    public void d() {
        ConstraintWidget L;
        ConstraintWidget L2;
        ConstraintWidget constraintWidget = this.f7267b;
        if (constraintWidget.f7088a) {
            this.f7270e.d(constraintWidget.y());
        }
        if (!this.f7270e.f7260j) {
            this.f7269d = this.f7267b.R();
            if (this.f7267b.X()) {
                this.f7300l = new a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f7269d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (L2 = this.f7267b.L()) != null && L2.R() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int y11 = (L2.y() - this.f7267b.Q.f()) - this.f7267b.S.f();
                    b(this.f7273h, L2.f7098f.f7273h, this.f7267b.Q.f());
                    b(this.f7274i, L2.f7098f.f7274i, -this.f7267b.S.f());
                    this.f7270e.d(y11);
                    return;
                } else if (this.f7269d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f7270e.d(this.f7267b.y());
                }
            }
        } else if (this.f7269d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (L = this.f7267b.L()) != null && L.R() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f7273h, L.f7098f.f7273h, this.f7267b.Q.f());
            b(this.f7274i, L.f7098f.f7274i, -this.f7267b.S.f());
            return;
        }
        e eVar = this.f7270e;
        boolean z11 = eVar.f7260j;
        if (z11) {
            ConstraintWidget constraintWidget2 = this.f7267b;
            if (constraintWidget2.f7088a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.X;
                if (constraintAnchorArr[2].f7083f != null && constraintAnchorArr[3].f7083f != null) {
                    if (constraintWidget2.i0()) {
                        this.f7273h.f7256f = this.f7267b.X[2].f();
                        this.f7274i.f7256f = -this.f7267b.X[3].f();
                    } else {
                        DependencyNode h11 = h(this.f7267b.X[2]);
                        if (h11 != null) {
                            b(this.f7273h, h11, this.f7267b.X[2].f());
                        }
                        DependencyNode h12 = h(this.f7267b.X[3]);
                        if (h12 != null) {
                            b(this.f7274i, h12, -this.f7267b.X[3].f());
                        }
                        this.f7273h.f7252b = true;
                        this.f7274i.f7252b = true;
                    }
                    if (this.f7267b.X()) {
                        b(this.f7299k, this.f7273h, this.f7267b.q());
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[2].f7083f != null) {
                    DependencyNode h13 = h(constraintAnchorArr[2]);
                    if (h13 != null) {
                        b(this.f7273h, h13, this.f7267b.X[2].f());
                        b(this.f7274i, this.f7273h, this.f7270e.f7257g);
                        if (this.f7267b.X()) {
                            b(this.f7299k, this.f7273h, this.f7267b.q());
                            return;
                        }
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[3].f7083f != null) {
                    DependencyNode h14 = h(constraintAnchorArr[3]);
                    if (h14 != null) {
                        b(this.f7274i, h14, -this.f7267b.X[3].f());
                        b(this.f7273h, this.f7274i, -this.f7270e.f7257g);
                    }
                    if (this.f7267b.X()) {
                        b(this.f7299k, this.f7273h, this.f7267b.q());
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[4].f7083f != null) {
                    DependencyNode h15 = h(constraintAnchorArr[4]);
                    if (h15 != null) {
                        b(this.f7299k, h15, 0);
                        b(this.f7273h, this.f7299k, -this.f7267b.q());
                        b(this.f7274i, this.f7273h, this.f7270e.f7257g);
                        return;
                    }
                    return;
                } else if (!(constraintWidget2 instanceof l0.a) && constraintWidget2.L() != null && this.f7267b.p(ConstraintAnchor.Type.CENTER).f7083f == null) {
                    b(this.f7273h, this.f7267b.L().f7098f.f7273h, this.f7267b.W());
                    b(this.f7274i, this.f7273h, this.f7270e.f7257g);
                    if (this.f7267b.X()) {
                        b(this.f7299k, this.f7273h, this.f7267b.q());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        if (z11 || this.f7269d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            eVar.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f7267b;
            int i11 = constraintWidget3.f7132w;
            if (i11 == 2) {
                ConstraintWidget L3 = constraintWidget3.L();
                if (L3 != null) {
                    e eVar2 = L3.f7098f.f7270e;
                    this.f7270e.f7262l.add(eVar2);
                    eVar2.f7261k.add(this.f7270e);
                    e eVar3 = this.f7270e;
                    eVar3.f7252b = true;
                    eVar3.f7261k.add(this.f7273h);
                    this.f7270e.f7261k.add(this.f7274i);
                }
            } else if (i11 == 3 && !constraintWidget3.i0()) {
                ConstraintWidget constraintWidget4 = this.f7267b;
                if (constraintWidget4.f7130v != 3) {
                    e eVar4 = constraintWidget4.f7096e.f7270e;
                    this.f7270e.f7262l.add(eVar4);
                    eVar4.f7261k.add(this.f7270e);
                    e eVar5 = this.f7270e;
                    eVar5.f7252b = true;
                    eVar5.f7261k.add(this.f7273h);
                    this.f7270e.f7261k.add(this.f7274i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f7267b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.X;
        if (constraintAnchorArr2[2].f7083f != null && constraintAnchorArr2[3].f7083f != null) {
            if (constraintWidget5.i0()) {
                this.f7273h.f7256f = this.f7267b.X[2].f();
                this.f7274i.f7256f = -this.f7267b.X[3].f();
            } else {
                DependencyNode h16 = h(this.f7267b.X[2]);
                DependencyNode h17 = h(this.f7267b.X[3]);
                if (h16 != null) {
                    h16.b(this);
                }
                if (h17 != null) {
                    h17.b(this);
                }
                this.f7275j = WidgetRun.RunType.CENTER;
            }
            if (this.f7267b.X()) {
                c(this.f7299k, this.f7273h, 1, this.f7300l);
            }
        } else if (constraintAnchorArr2[2].f7083f != null) {
            DependencyNode h18 = h(constraintAnchorArr2[2]);
            if (h18 != null) {
                b(this.f7273h, h18, this.f7267b.X[2].f());
                c(this.f7274i, this.f7273h, 1, this.f7270e);
                if (this.f7267b.X()) {
                    c(this.f7299k, this.f7273h, 1, this.f7300l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f7269d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f7267b.w() > 0.0f) {
                    h hVar = this.f7267b.f7096e;
                    if (hVar.f7269d == dimensionBehaviour3) {
                        hVar.f7270e.f7261k.add(this.f7270e);
                        this.f7270e.f7262l.add(this.f7267b.f7096e.f7270e);
                        this.f7270e.f7251a = this;
                    }
                }
            }
        } else if (constraintAnchorArr2[3].f7083f != null) {
            DependencyNode h19 = h(constraintAnchorArr2[3]);
            if (h19 != null) {
                b(this.f7274i, h19, -this.f7267b.X[3].f());
                c(this.f7273h, this.f7274i, -1, this.f7270e);
                if (this.f7267b.X()) {
                    c(this.f7299k, this.f7273h, 1, this.f7300l);
                }
            }
        } else if (constraintAnchorArr2[4].f7083f != null) {
            DependencyNode h21 = h(constraintAnchorArr2[4]);
            if (h21 != null) {
                b(this.f7299k, h21, 0);
                c(this.f7273h, this.f7299k, -1, this.f7300l);
                c(this.f7274i, this.f7273h, 1, this.f7270e);
            }
        } else if (!(constraintWidget5 instanceof l0.a) && constraintWidget5.L() != null) {
            b(this.f7273h, this.f7267b.L().f7098f.f7273h, this.f7267b.W());
            c(this.f7274i, this.f7273h, 1, this.f7270e);
            if (this.f7267b.X()) {
                c(this.f7299k, this.f7273h, 1, this.f7300l);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f7269d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour4 == dimensionBehaviour5 && this.f7267b.w() > 0.0f) {
                h hVar2 = this.f7267b.f7096e;
                if (hVar2.f7269d == dimensionBehaviour5) {
                    hVar2.f7270e.f7261k.add(this.f7270e);
                    this.f7270e.f7262l.add(this.f7267b.f7096e.f7270e);
                    this.f7270e.f7251a = this;
                }
            }
        }
        if (this.f7270e.f7262l.size() == 0) {
            this.f7270e.f7253c = true;
        }
    }

    public void e() {
        DependencyNode dependencyNode = this.f7273h;
        if (dependencyNode.f7260j) {
            this.f7267b.i1(dependencyNode.f7257g);
        }
    }

    public void f() {
        this.f7268c = null;
        this.f7273h.c();
        this.f7274i.c();
        this.f7299k.c();
        this.f7270e.c();
        this.f7272g = false;
    }

    public boolean m() {
        if (this.f7269d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f7267b.f7132w == 0) {
            return true;
        }
        return false;
    }

    public void q() {
        this.f7272g = false;
        this.f7273h.c();
        this.f7273h.f7260j = false;
        this.f7274i.c();
        this.f7274i.f7260j = false;
        this.f7299k.c();
        this.f7299k.f7260j = false;
        this.f7270e.f7260j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f7267b.u();
    }
}
