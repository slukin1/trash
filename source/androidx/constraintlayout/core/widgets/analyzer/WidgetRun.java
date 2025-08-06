package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public abstract class WidgetRun implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f7266a;

    /* renamed from: b  reason: collision with root package name */
    public ConstraintWidget f7267b;

    /* renamed from: c  reason: collision with root package name */
    public i f7268c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f7269d;

    /* renamed from: e  reason: collision with root package name */
    public e f7270e = new e(this);

    /* renamed from: f  reason: collision with root package name */
    public int f7271f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7272g = false;

    /* renamed from: h  reason: collision with root package name */
    public DependencyNode f7273h = new DependencyNode(this);

    /* renamed from: i  reason: collision with root package name */
    public DependencyNode f7274i = new DependencyNode(this);

    /* renamed from: j  reason: collision with root package name */
    public RunType f7275j = RunType.NONE;

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7276a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7276a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7276a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7276a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7276a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7276a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.a.<clinit>():void");
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f7267b = constraintWidget;
    }

    public void a(c cVar) {
    }

    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i11) {
        dependencyNode.f7262l.add(dependencyNode2);
        dependencyNode.f7256f = i11;
        dependencyNode2.f7261k.add(dependencyNode);
    }

    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i11, e eVar) {
        dependencyNode.f7262l.add(dependencyNode2);
        dependencyNode.f7262l.add(this.f7270e);
        dependencyNode.f7258h = i11;
        dependencyNode.f7259i = eVar;
        dependencyNode2.f7261k.add(dependencyNode);
        eVar.f7261k.add(dependencyNode);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i11, int i12) {
        int i13;
        if (i12 == 0) {
            ConstraintWidget constraintWidget = this.f7267b;
            int i14 = constraintWidget.f7138z;
            i13 = Math.max(constraintWidget.f7136y, i11);
            if (i14 > 0) {
                i13 = Math.min(i14, i11);
            }
            if (i13 == i11) {
                return i11;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f7267b;
            int i15 = constraintWidget2.C;
            int max = Math.max(constraintWidget2.B, i11);
            if (i15 > 0) {
                max = Math.min(i15, i11);
            }
            if (i13 == i11) {
                return i11;
            }
        }
        return i13;
    }

    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f7083f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f7081d;
        int i11 = a.f7276a[constraintAnchor2.f7082e.ordinal()];
        if (i11 == 1) {
            return constraintWidget.f7096e.f7273h;
        }
        if (i11 == 2) {
            return constraintWidget.f7096e.f7274i;
        }
        if (i11 == 3) {
            return constraintWidget.f7098f.f7273h;
        }
        if (i11 == 4) {
            return constraintWidget.f7098f.f7299k;
        }
        if (i11 != 5) {
            return null;
        }
        return constraintWidget.f7098f.f7274i;
    }

    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i11) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f7083f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f7081d;
        WidgetRun widgetRun = i11 == 0 ? constraintWidget.f7096e : constraintWidget.f7098f;
        int i12 = a.f7276a[constraintAnchor2.f7082e.ordinal()];
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    if (i12 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f7274i;
        }
        return widgetRun.f7273h;
    }

    public long j() {
        e eVar = this.f7270e;
        if (eVar.f7260j) {
            return (long) eVar.f7257g;
        }
        return 0;
    }

    public boolean k() {
        return this.f7272g;
    }

    public final void l(int i11, int i12) {
        int i13;
        int i14 = this.f7266a;
        if (i14 == 0) {
            this.f7270e.d(g(i12, i11));
        } else if (i14 == 1) {
            this.f7270e.d(Math.min(g(this.f7270e.f7288m, i11), i12));
        } else if (i14 == 2) {
            ConstraintWidget L = this.f7267b.L();
            if (L != null) {
                e eVar = (i11 == 0 ? L.f7096e : L.f7098f).f7270e;
                if (eVar.f7260j) {
                    ConstraintWidget constraintWidget = this.f7267b;
                    this.f7270e.d(g((int) ((((float) eVar.f7257g) * (i11 == 0 ? constraintWidget.A : constraintWidget.D)) + 0.5f), i11));
                }
            }
        } else if (i14 == 3) {
            ConstraintWidget constraintWidget2 = this.f7267b;
            WidgetRun widgetRun = constraintWidget2.f7096e;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.f7269d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.f7266a == 3) {
                j jVar = constraintWidget2.f7098f;
                if (jVar.f7269d == dimensionBehaviour2 && jVar.f7266a == 3) {
                    return;
                }
            }
            if (i11 == 0) {
                widgetRun = constraintWidget2.f7098f;
            }
            if (widgetRun.f7270e.f7260j) {
                float w11 = constraintWidget2.w();
                if (i11 == 1) {
                    i13 = (int) ((((float) widgetRun.f7270e.f7257g) / w11) + 0.5f);
                } else {
                    i13 = (int) ((w11 * ((float) widgetRun.f7270e.f7257g)) + 0.5f);
                }
                this.f7270e.d(i13);
            }
        }
    }

    public abstract boolean m();

    public void n(c cVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11) {
        float f11;
        DependencyNode h11 = h(constraintAnchor);
        DependencyNode h12 = h(constraintAnchor2);
        if (h11.f7260j && h12.f7260j) {
            int f12 = h11.f7257g + constraintAnchor.f();
            int f13 = h12.f7257g - constraintAnchor2.f();
            int i12 = f13 - f12;
            if (!this.f7270e.f7260j && this.f7269d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i11, i12);
            }
            e eVar = this.f7270e;
            if (eVar.f7260j) {
                if (eVar.f7257g == i12) {
                    this.f7273h.d(f12);
                    this.f7274i.d(f13);
                    return;
                }
                ConstraintWidget constraintWidget = this.f7267b;
                if (i11 == 0) {
                    f11 = constraintWidget.z();
                } else {
                    f11 = constraintWidget.P();
                }
                if (h11 == h12) {
                    f12 = h11.f7257g;
                    f13 = h12.f7257g;
                    f11 = 0.5f;
                }
                this.f7273h.d((int) (((float) f12) + 0.5f + (((float) ((f13 - f12) - this.f7270e.f7257g)) * f11)));
                this.f7274i.d(this.f7273h.f7257g + this.f7270e.f7257g);
            }
        }
    }

    public void o(c cVar) {
    }

    public void p(c cVar) {
    }
}
