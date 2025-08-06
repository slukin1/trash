package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintWidget f7213a;

    /* renamed from: b  reason: collision with root package name */
    public ConstraintWidget f7214b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintWidget f7215c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintWidget f7216d;

    /* renamed from: e  reason: collision with root package name */
    public ConstraintWidget f7217e;

    /* renamed from: f  reason: collision with root package name */
    public ConstraintWidget f7218f;

    /* renamed from: g  reason: collision with root package name */
    public ConstraintWidget f7219g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ConstraintWidget> f7220h;

    /* renamed from: i  reason: collision with root package name */
    public int f7221i;

    /* renamed from: j  reason: collision with root package name */
    public int f7222j;

    /* renamed from: k  reason: collision with root package name */
    public float f7223k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public int f7224l;

    /* renamed from: m  reason: collision with root package name */
    public int f7225m;

    /* renamed from: n  reason: collision with root package name */
    public int f7226n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f7227o;

    /* renamed from: p  reason: collision with root package name */
    public int f7228p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f7229q = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f7230r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f7231s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f7232t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f7233u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f7234v;

    public a(ConstraintWidget constraintWidget, int i11, boolean z11) {
        this.f7213a = constraintWidget;
        this.f7228p = i11;
        this.f7229q = z11;
    }

    public static boolean c(ConstraintWidget constraintWidget, int i11) {
        if (constraintWidget.T() != 8 && constraintWidget.f7089a0[i11] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.f7134x;
            if (iArr[i11] == 0 || iArr[i11] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.f7234v) {
            b();
        }
        this.f7234v = true;
    }

    public final void b() {
        int i11 = this.f7228p * 2;
        ConstraintWidget constraintWidget = this.f7213a;
        boolean z11 = true;
        this.f7227o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z12 = false;
        while (!z12) {
            this.f7221i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.N0;
            int i12 = this.f7228p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i12] = null;
            constraintWidget.M0[i12] = null;
            if (constraintWidget.T() != 8) {
                this.f7224l++;
                ConstraintWidget.DimensionBehaviour v11 = constraintWidget.v(this.f7228p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (v11 != dimensionBehaviour) {
                    this.f7225m += constraintWidget.F(this.f7228p);
                }
                int f11 = this.f7225m + constraintWidget.X[i11].f();
                this.f7225m = f11;
                int i13 = i11 + 1;
                this.f7225m = f11 + constraintWidget.X[i13].f();
                int f12 = this.f7226n + constraintWidget.X[i11].f();
                this.f7226n = f12;
                this.f7226n = f12 + constraintWidget.X[i13].f();
                if (this.f7214b == null) {
                    this.f7214b = constraintWidget;
                }
                this.f7216d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f7089a0;
                int i14 = this.f7228p;
                if (dimensionBehaviourArr[i14] == dimensionBehaviour) {
                    int[] iArr = constraintWidget.f7134x;
                    if (iArr[i14] == 0 || iArr[i14] == 3 || iArr[i14] == 2) {
                        this.f7222j++;
                        float[] fArr = constraintWidget.L0;
                        float f13 = fArr[i14];
                        if (f13 > 0.0f) {
                            this.f7223k += fArr[i14];
                        }
                        if (c(constraintWidget, i14)) {
                            if (f13 < 0.0f) {
                                this.f7230r = true;
                            } else {
                                this.f7231s = true;
                            }
                            if (this.f7220h == null) {
                                this.f7220h = new ArrayList<>();
                            }
                            this.f7220h.add(constraintWidget);
                        }
                        if (this.f7218f == null) {
                            this.f7218f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f7219g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.M0[this.f7228p] = constraintWidget;
                        }
                        this.f7219g = constraintWidget;
                    }
                    if (this.f7228p == 0) {
                        if (constraintWidget.f7130v != 0) {
                            this.f7227o = false;
                        } else if (!(constraintWidget.f7136y == 0 && constraintWidget.f7138z == 0)) {
                            this.f7227o = false;
                        }
                    } else if (constraintWidget.f7132w != 0) {
                        this.f7227o = false;
                    } else if (!(constraintWidget.B == 0 && constraintWidget.C == 0)) {
                        this.f7227o = false;
                    }
                    if (constraintWidget.f7097e0 != 0.0f) {
                        this.f7227o = false;
                        this.f7233u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.N0[this.f7228p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.X[i11 + 1].f7083f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f7081d;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.X;
                if (constraintAnchorArr[i11].f7083f != null && constraintAnchorArr[i11].f7083f.f7081d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z12 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f7214b;
        if (constraintWidget6 != null) {
            this.f7225m -= constraintWidget6.X[i11].f();
        }
        ConstraintWidget constraintWidget7 = this.f7216d;
        if (constraintWidget7 != null) {
            this.f7225m -= constraintWidget7.X[i11 + 1].f();
        }
        this.f7215c = constraintWidget;
        if (this.f7228p != 0 || !this.f7229q) {
            this.f7217e = this.f7213a;
        } else {
            this.f7217e = constraintWidget;
        }
        if (!this.f7231s || !this.f7230r) {
            z11 = false;
        }
        this.f7232t = z11;
    }
}
