package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.b;
import androidx.constraintlayout.core.widgets.analyzer.h;
import androidx.constraintlayout.core.widgets.analyzer.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget {
    public static float S0 = 0.5f;
    public float A = 1.0f;
    public boolean A0;
    public int B = 0;
    public boolean B0;
    public int C = 0;
    public boolean C0;
    public float D = 1.0f;
    public boolean D0;
    public boolean E;
    public boolean E0;
    public boolean F;
    public boolean F0;
    public int G = -1;
    public boolean G0;
    public float H = 1.0f;
    public int H0;
    public int[] I = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public int I0;
    public float J = 0.0f;
    public boolean J0;
    public boolean K = false;
    public boolean K0;
    public boolean L;
    public float[] L0;
    public boolean M = false;
    public ConstraintWidget[] M0;
    public int N = 0;
    public ConstraintWidget[] N0;
    public int O = 0;
    public ConstraintWidget O0;
    public ConstraintAnchor P = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintWidget P0;
    public ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public int Q0;
    public ConstraintAnchor R = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public int R0;
    public ConstraintAnchor S = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor T = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    public ConstraintAnchor U = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    public ConstraintAnchor V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    public ConstraintAnchor W;
    public ConstraintAnchor[] X;
    public ArrayList<ConstraintAnchor> Y;
    public boolean[] Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f7088a = false;

    /* renamed from: a0  reason: collision with root package name */
    public DimensionBehaviour[] f7089a0;

    /* renamed from: b  reason: collision with root package name */
    public WidgetRun[] f7090b = new WidgetRun[2];

    /* renamed from: b0  reason: collision with root package name */
    public ConstraintWidget f7091b0;

    /* renamed from: c  reason: collision with root package name */
    public b f7092c;

    /* renamed from: c0  reason: collision with root package name */
    public int f7093c0;

    /* renamed from: d  reason: collision with root package name */
    public b f7094d;

    /* renamed from: d0  reason: collision with root package name */
    public int f7095d0;

    /* renamed from: e  reason: collision with root package name */
    public h f7096e = null;

    /* renamed from: e0  reason: collision with root package name */
    public float f7097e0;

    /* renamed from: f  reason: collision with root package name */
    public j f7098f = null;

    /* renamed from: f0  reason: collision with root package name */
    public int f7099f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f7100g = {true, true};

    /* renamed from: g0  reason: collision with root package name */
    public int f7101g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7102h = false;

    /* renamed from: h0  reason: collision with root package name */
    public int f7103h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7104i = true;

    /* renamed from: i0  reason: collision with root package name */
    public int f7105i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7106j = false;

    /* renamed from: j0  reason: collision with root package name */
    public int f7107j0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7108k = true;

    /* renamed from: k0  reason: collision with root package name */
    public int f7109k0;

    /* renamed from: l  reason: collision with root package name */
    public int f7110l = -1;

    /* renamed from: l0  reason: collision with root package name */
    public int f7111l0;

    /* renamed from: m  reason: collision with root package name */
    public int f7112m = -1;

    /* renamed from: m0  reason: collision with root package name */
    public int f7113m0;

    /* renamed from: n  reason: collision with root package name */
    public WidgetFrame f7114n = new WidgetFrame(this);

    /* renamed from: n0  reason: collision with root package name */
    public int f7115n0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f7116o = false;

    /* renamed from: o0  reason: collision with root package name */
    public int f7117o0;

    /* renamed from: p  reason: collision with root package name */
    public boolean f7118p = false;

    /* renamed from: p0  reason: collision with root package name */
    public float f7119p0;

    /* renamed from: q  reason: collision with root package name */
    public boolean f7120q = false;

    /* renamed from: q0  reason: collision with root package name */
    public float f7121q0;

    /* renamed from: r  reason: collision with root package name */
    public boolean f7122r = false;

    /* renamed from: r0  reason: collision with root package name */
    public Object f7123r0;

    /* renamed from: s  reason: collision with root package name */
    public int f7124s = -1;

    /* renamed from: s0  reason: collision with root package name */
    public int f7125s0;

    /* renamed from: t  reason: collision with root package name */
    public int f7126t = -1;

    /* renamed from: t0  reason: collision with root package name */
    public int f7127t0;

    /* renamed from: u  reason: collision with root package name */
    public int f7128u = 0;

    /* renamed from: u0  reason: collision with root package name */
    public String f7129u0;

    /* renamed from: v  reason: collision with root package name */
    public int f7130v = 0;

    /* renamed from: v0  reason: collision with root package name */
    public String f7131v0;

    /* renamed from: w  reason: collision with root package name */
    public int f7132w = 0;

    /* renamed from: w0  reason: collision with root package name */
    public int f7133w0;

    /* renamed from: x  reason: collision with root package name */
    public int[] f7134x = new int[2];

    /* renamed from: x0  reason: collision with root package name */
    public int f7135x0;

    /* renamed from: y  reason: collision with root package name */
    public int f7136y = 0;

    /* renamed from: y0  reason: collision with root package name */
    public int f7137y0;

    /* renamed from: z  reason: collision with root package name */
    public int f7138z = 0;

    /* renamed from: z0  reason: collision with root package name */
    public int f7139z0;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7140a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f7141b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7141b = r0
                r1 = 1
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f7141b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f7141b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f7141b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f7140a = r4
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f7140a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f7140a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f7140a     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f7140a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f7140a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f7140a     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f7140a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f7140a     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.a.<clinit>():void");
        }
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.W = constraintAnchor;
        this.X = new ConstraintAnchor[]{this.P, this.R, this.Q, this.S, this.T, constraintAnchor};
        this.Y = new ArrayList<>();
        this.Z = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f7089a0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f7091b0 = null;
        this.f7093c0 = 0;
        this.f7095d0 = 0;
        this.f7097e0 = 0.0f;
        this.f7099f0 = -1;
        this.f7101g0 = 0;
        this.f7103h0 = 0;
        this.f7105i0 = 0;
        this.f7107j0 = 0;
        this.f7109k0 = 0;
        this.f7111l0 = 0;
        this.f7113m0 = 0;
        float f11 = S0;
        this.f7119p0 = f11;
        this.f7121q0 = f11;
        this.f7125s0 = 0;
        this.f7127t0 = 0;
        this.f7129u0 = null;
        this.f7131v0 = null;
        this.G0 = false;
        this.H0 = 0;
        this.I0 = 0;
        this.L0 = new float[]{-1.0f, -1.0f};
        this.M0 = new ConstraintWidget[]{null, null};
        this.N0 = new ConstraintWidget[]{null, null};
        this.O0 = null;
        this.P0 = null;
        this.Q0 = -1;
        this.R0 = -1;
        d();
    }

    public int A() {
        return this.H0;
    }

    public void A0(int i11, int i12) {
        if (!this.f7116o) {
            this.P.t(i11);
            this.R.t(i12);
            this.f7101g0 = i11;
            this.f7093c0 = i12 - i11;
            this.f7116o = true;
        }
    }

    public DimensionBehaviour B() {
        return this.f7089a0[0];
    }

    public void B0(int i11) {
        this.P.t(i11);
        this.f7101g0 = i11;
    }

    public int C() {
        ConstraintAnchor constraintAnchor = this.P;
        int i11 = 0;
        if (constraintAnchor != null) {
            i11 = 0 + constraintAnchor.f7084g;
        }
        ConstraintAnchor constraintAnchor2 = this.R;
        return constraintAnchor2 != null ? i11 + constraintAnchor2.f7084g : i11;
    }

    public void C0(int i11) {
        this.Q.t(i11);
        this.f7103h0 = i11;
    }

    public int D() {
        return this.N;
    }

    public void D0(int i11, int i12) {
        if (!this.f7118p) {
            this.Q.t(i11);
            this.S.t(i12);
            this.f7103h0 = i11;
            this.f7095d0 = i12 - i11;
            if (this.K) {
                this.T.t(i11 + this.f7113m0);
            }
            this.f7118p = true;
        }
    }

    public int E() {
        return this.O;
    }

    public void E0(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17 = i13 - i11;
        int i18 = i14 - i12;
        this.f7101g0 = i11;
        this.f7103h0 = i12;
        if (this.f7127t0 == 8) {
            this.f7093c0 = 0;
            this.f7095d0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.f7089a0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i17 < (i16 = this.f7093c0)) {
            i17 = i16;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i18 < (i15 = this.f7095d0)) {
            i18 = i15;
        }
        this.f7093c0 = i17;
        this.f7095d0 = i18;
        int i19 = this.f7117o0;
        if (i18 < i19) {
            this.f7095d0 = i19;
        }
        int i21 = this.f7115n0;
        if (i17 < i21) {
            this.f7093c0 = i21;
        }
        int i22 = this.f7138z;
        if (i22 > 0 && dimensionBehaviourArr[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f7093c0 = Math.min(this.f7093c0, i22);
        }
        int i23 = this.C;
        if (i23 > 0 && this.f7089a0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f7095d0 = Math.min(this.f7095d0, i23);
        }
        int i24 = this.f7093c0;
        if (i17 != i24) {
            this.f7110l = i24;
        }
        int i25 = this.f7095d0;
        if (i18 != i25) {
            this.f7112m = i25;
        }
    }

    public int F(int i11) {
        if (i11 == 0) {
            return U();
        }
        if (i11 == 1) {
            return y();
        }
        return 0;
    }

    public void F0(boolean z11) {
        this.K = z11;
    }

    public int G() {
        return this.I[1];
    }

    public void G0(int i11) {
        this.f7095d0 = i11;
        int i12 = this.f7117o0;
        if (i11 < i12) {
            this.f7095d0 = i12;
        }
    }

    public int H() {
        return this.I[0];
    }

    public void H0(float f11) {
        this.f7119p0 = f11;
    }

    public int I() {
        return this.f7117o0;
    }

    public void I0(int i11) {
        this.H0 = i11;
    }

    public int J() {
        return this.f7115n0;
    }

    public void J0(int i11, int i12) {
        this.f7101g0 = i11;
        int i13 = i12 - i11;
        this.f7093c0 = i13;
        int i14 = this.f7115n0;
        if (i13 < i14) {
            this.f7093c0 = i14;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.S;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget K(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f7083f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f7083f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7081d
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f7083f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f7083f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7081d
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.K(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void K0(DimensionBehaviour dimensionBehaviour) {
        this.f7089a0[0] = dimensionBehaviour;
    }

    public ConstraintWidget L() {
        return this.f7091b0;
    }

    public void L0(int i11, int i12, int i13, float f11) {
        this.f7130v = i11;
        this.f7136y = i12;
        if (i13 == Integer.MAX_VALUE) {
            i13 = 0;
        }
        this.f7138z = i13;
        this.A = f11;
        if (f11 > 0.0f && f11 < 1.0f && i11 == 0) {
            this.f7130v = 2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.Q;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget M(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f7083f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f7083f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7081d
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f7083f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f7083f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7081d
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.M(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void M0(float f11) {
        this.L0[0] = f11;
    }

    public int N() {
        return V() + this.f7093c0;
    }

    public void N0(int i11, boolean z11) {
        this.Z[i11] = z11;
    }

    public WidgetRun O(int i11) {
        if (i11 == 0) {
            return this.f7096e;
        }
        if (i11 == 1) {
            return this.f7098f;
        }
        return null;
    }

    public void O0(boolean z11) {
        this.L = z11;
    }

    public float P() {
        return this.f7121q0;
    }

    public void P0(boolean z11) {
        this.M = z11;
    }

    public int Q() {
        return this.I0;
    }

    public void Q0(int i11, int i12) {
        this.N = i11;
        this.O = i12;
        T0(false);
    }

    public DimensionBehaviour R() {
        return this.f7089a0[1];
    }

    public void R0(int i11) {
        this.I[1] = i11;
    }

    public int S() {
        int i11 = 0;
        if (this.P != null) {
            i11 = 0 + this.Q.f7084g;
        }
        return this.R != null ? i11 + this.S.f7084g : i11;
    }

    public void S0(int i11) {
        this.I[0] = i11;
    }

    public int T() {
        return this.f7127t0;
    }

    public void T0(boolean z11) {
        this.f7104i = z11;
    }

    public int U() {
        if (this.f7127t0 == 8) {
            return 0;
        }
        return this.f7093c0;
    }

    public void U0(int i11) {
        if (i11 < 0) {
            this.f7117o0 = 0;
        } else {
            this.f7117o0 = i11;
        }
    }

    public int V() {
        ConstraintWidget constraintWidget = this.f7091b0;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.f7101g0;
        }
        return ((ConstraintWidgetContainer) constraintWidget).f7143b1 + this.f7101g0;
    }

    public void V0(int i11) {
        if (i11 < 0) {
            this.f7115n0 = 0;
        } else {
            this.f7115n0 = i11;
        }
    }

    public int W() {
        ConstraintWidget constraintWidget = this.f7091b0;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.f7103h0;
        }
        return ((ConstraintWidgetContainer) constraintWidget).f7144c1 + this.f7103h0;
    }

    public void W0(int i11, int i12) {
        this.f7101g0 = i11;
        this.f7103h0 = i12;
    }

    public boolean X() {
        return this.K;
    }

    public void X0(ConstraintWidget constraintWidget) {
        this.f7091b0 = constraintWidget;
    }

    public boolean Y(int i11) {
        if (i11 == 0) {
            return (this.P.f7083f != null ? 1 : 0) + (this.R.f7083f != null ? 1 : 0) < 2;
        }
        if ((this.Q.f7083f != null ? 1 : 0) + (this.S.f7083f != null ? 1 : 0) + (this.T.f7083f != null ? 1 : 0) < 2) {
            return true;
        }
        return false;
    }

    public void Y0(float f11) {
        this.f7121q0 = f11;
    }

    public boolean Z() {
        int size = this.Y.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.Y.get(i11).m()) {
                return true;
            }
        }
        return false;
    }

    public void Z0(int i11) {
        this.I0 = i11;
    }

    public boolean a0() {
        return (this.f7110l == -1 && this.f7112m == -1) ? false : true;
    }

    public void a1(int i11, int i12) {
        this.f7103h0 = i11;
        int i13 = i12 - i11;
        this.f7095d0 = i13;
        int i14 = this.f7117o0;
        if (i13 < i14) {
            this.f7095d0 = i14;
        }
    }

    public boolean b0(int i11, int i12) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i11 == 0) {
            ConstraintAnchor constraintAnchor3 = this.P.f7083f;
            if (constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.R.f7083f) != null && constraintAnchor2.n()) {
                if ((this.R.f7083f.e() - this.R.f()) - (this.P.f7083f.e() + this.P.f()) >= i12) {
                    return true;
                }
                return false;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.Q.f7083f;
            if (constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.S.f7083f) != null && constraintAnchor.n()) {
                if ((this.S.f7083f.e() - this.S.f()) - (this.Q.f7083f.e() + this.Q.f()) >= i12) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void b1(DimensionBehaviour dimensionBehaviour) {
        this.f7089a0[1] = dimensionBehaviour;
    }

    public void c0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i11, int i12) {
        p(type).b(constraintWidget.p(type2), i11, i12, true);
    }

    public void c1(int i11, int i12, int i13, float f11) {
        this.f7132w = i11;
        this.B = i12;
        if (i13 == Integer.MAX_VALUE) {
            i13 = 0;
        }
        this.C = i13;
        this.D = f11;
        if (f11 > 0.0f && f11 < 1.0f && i11 == 0) {
            this.f7132w = 2;
        }
    }

    public final void d() {
        this.Y.add(this.P);
        this.Y.add(this.Q);
        this.Y.add(this.R);
        this.Y.add(this.S);
        this.Y.add(this.U);
        this.Y.add(this.V);
        this.Y.add(this.W);
        this.Y.add(this.T);
    }

    public final boolean d0(int i11) {
        int i12 = i11 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.X;
        if (!(constraintAnchorArr[i12].f7083f == null || constraintAnchorArr[i12].f7083f.f7083f == constraintAnchorArr[i12])) {
            int i13 = i12 + 1;
            return constraintAnchorArr[i13].f7083f != null && constraintAnchorArr[i13].f7083f.f7083f == constraintAnchorArr[i13];
        }
    }

    public void d1(float f11) {
        this.L0[1] = f11;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i11, boolean z11) {
        if (z11) {
            if (hashSet.contains(this)) {
                Optimizer.a(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                g(linearSystem, constraintWidgetContainer.P1(64));
            } else {
                return;
            }
        }
        if (i11 == 0) {
            HashSet<ConstraintAnchor> d11 = this.P.d();
            if (d11 != null) {
                Iterator<ConstraintAnchor> it2 = d11.iterator();
                while (it2.hasNext()) {
                    it2.next().f7081d.e(constraintWidgetContainer, linearSystem, hashSet, i11, true);
                }
            }
            HashSet<ConstraintAnchor> d12 = this.R.d();
            if (d12 != null) {
                Iterator<ConstraintAnchor> it3 = d12.iterator();
                while (it3.hasNext()) {
                    it3.next().f7081d.e(constraintWidgetContainer, linearSystem, hashSet, i11, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> d13 = this.Q.d();
        if (d13 != null) {
            Iterator<ConstraintAnchor> it4 = d13.iterator();
            while (it4.hasNext()) {
                it4.next().f7081d.e(constraintWidgetContainer, linearSystem, hashSet, i11, true);
            }
        }
        HashSet<ConstraintAnchor> d14 = this.S.d();
        if (d14 != null) {
            Iterator<ConstraintAnchor> it5 = d14.iterator();
            while (it5.hasNext()) {
                it5.next().f7081d.e(constraintWidgetContainer, linearSystem, hashSet, i11, true);
            }
        }
        HashSet<ConstraintAnchor> d15 = this.T.d();
        if (d15 != null) {
            Iterator<ConstraintAnchor> it6 = d15.iterator();
            while (it6.hasNext()) {
                it6.next().f7081d.e(constraintWidgetContainer, linearSystem, hashSet, i11, true);
            }
        }
    }

    public boolean e0() {
        return this.f7120q;
    }

    public void e1(int i11) {
        this.f7127t0 = i11;
    }

    public boolean f() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public boolean f0(int i11) {
        return this.Z[i11];
    }

    public void f1(int i11) {
        this.f7093c0 = i11;
        int i12 = this.f7115n0;
        if (i11 < i12) {
            this.f7093c0 = i12;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04c7  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x057b  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x057e  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x05be  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x05c4  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x05ef  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x05f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.constraintlayout.core.LinearSystem r54, boolean r55) {
        /*
            r53 = this;
            r15 = r53
            r14 = r54
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.P
            androidx.constraintlayout.core.SolverVariable r13 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.R
            androidx.constraintlayout.core.SolverVariable r12 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.Q
            androidx.constraintlayout.core.SolverVariable r11 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.S
            androidx.constraintlayout.core.SolverVariable r10 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.T
            androidx.constraintlayout.core.SolverVariable r9 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            r8 = 2
            r1 = 3
            r7 = 1
            r6 = 0
            if (r0 == 0) goto L_0x0055
            if (r0 == 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r0.f7089a0
            r2 = r2[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x0036
            r2 = r7
            goto L_0x0037
        L_0x0036:
            r2 = r6
        L_0x0037:
            if (r0 == 0) goto L_0x0043
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.f7089a0
            r0 = r0[r7]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x0043
            r0 = r7
            goto L_0x0044
        L_0x0043:
            r0 = r6
        L_0x0044:
            int r3 = r15.f7128u
            if (r3 == r7) goto L_0x0052
            if (r3 == r8) goto L_0x004f
            if (r3 == r1) goto L_0x0055
            r5 = r0
            r4 = r2
            goto L_0x0057
        L_0x004f:
            r5 = r0
            r4 = r6
            goto L_0x0057
        L_0x0052:
            r4 = r2
            r5 = r6
            goto L_0x0057
        L_0x0055:
            r4 = r6
            r5 = r4
        L_0x0057:
            int r0 = r15.f7127t0
            r3 = 8
            if (r0 != r3) goto L_0x006e
            boolean r0 = r53.Z()
            if (r0 != 0) goto L_0x006e
            boolean[] r0 = r15.Z
            boolean r2 = r0[r6]
            if (r2 != 0) goto L_0x006e
            boolean r0 = r0[r7]
            if (r0 != 0) goto L_0x006e
            return
        L_0x006e:
            boolean r0 = r15.f7116o
            r2 = 5
            if (r0 != 0) goto L_0x0077
            boolean r8 = r15.f7118p
            if (r8 == 0) goto L_0x00f4
        L_0x0077:
            if (r0 == 0) goto L_0x00a6
            int r0 = r15.f7101g0
            r14.f(r13, r0)
            int r0 = r15.f7101g0
            int r8 = r15.f7093c0
            int r0 = r0 + r8
            r14.f(r12, r0)
            if (r4 == 0) goto L_0x00a6
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x00a6
            boolean r8 = r15.f7108k
            if (r8 == 0) goto L_0x009d
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.P
            r0.u1(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.R
            r0.t1(r8)
            goto L_0x00a6
        L_0x009d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r12, r6, r2)
        L_0x00a6:
            boolean r0 = r15.f7118p
            if (r0 == 0) goto L_0x00e7
            int r0 = r15.f7103h0
            r14.f(r11, r0)
            int r0 = r15.f7103h0
            int r8 = r15.f7095d0
            int r0 = r0 + r8
            r14.f(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.T
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x00c7
            int r0 = r15.f7103h0
            int r8 = r15.f7113m0
            int r0 = r0 + r8
            r14.f(r9, r0)
        L_0x00c7:
            if (r5 == 0) goto L_0x00e7
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x00e7
            boolean r8 = r15.f7108k
            if (r8 == 0) goto L_0x00de
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.Q
            r0.z1(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.S
            r0.y1(r8)
            goto L_0x00e7
        L_0x00de:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r10, r6, r2)
        L_0x00e7:
            boolean r0 = r15.f7116o
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r15.f7118p
            if (r0 == 0) goto L_0x00f4
            r15.f7116o = r6
            r15.f7118p = r6
            return
        L_0x00f4:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.f6557x
            r17 = 1
            if (r0 == 0) goto L_0x0100
            long r1 = r0.f6603z
            long r1 = r1 + r17
            r0.f6603z = r1
        L_0x0100:
            if (r55 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.h r1 = r15.f7096e
            if (r1 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.j r2 = r15.f7098f
            if (r2 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r8 = r1.f7273h
            boolean r7 = r8.f7260j
            if (r7 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f7274i
            boolean r1 = r1.f7260j
            if (r1 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r2.f7273h
            boolean r1 = r1.f7260j
            if (r1 == 0) goto L_0x018f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r2.f7274i
            boolean r1 = r1.f7260j
            if (r1 == 0) goto L_0x018f
            if (r0 == 0) goto L_0x012a
            long r1 = r0.f6595r
            long r1 = r1 + r17
            r0.f6595r = r1
        L_0x012a:
            int r0 = r8.f7257g
            r14.f(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.h r0 = r15.f7096e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7274i
            int r0 = r0.f7257g
            r14.f(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f7098f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7273h
            int r0 = r0.f7257g
            r14.f(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f7098f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7274i
            int r0 = r0.f7257g
            r14.f(r10, r0)
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f7098f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7299k
            int r0 = r0.f7257g
            r14.f(r9, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x018a
            if (r4 == 0) goto L_0x0170
            boolean[] r0 = r15.f7100g
            boolean r0 = r0[r6]
            if (r0 == 0) goto L_0x0170
            boolean r0 = r53.g0()
            if (r0 != 0) goto L_0x0170
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r12, r6, r3)
        L_0x0170:
            if (r5 == 0) goto L_0x018a
            boolean[] r0 = r15.f7100g
            r1 = 1
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x018a
            boolean r0 = r53.i0()
            if (r0 != 0) goto L_0x018a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r10, r6, r3)
        L_0x018a:
            r15.f7116o = r6
            r15.f7118p = r6
            return
        L_0x018f:
            if (r0 == 0) goto L_0x0197
            long r1 = r0.f6596s
            long r1 = r1 + r17
            r0.f6596s = r1
        L_0x0197:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x020b
            boolean r0 = r15.d0(r6)
            if (r0 == 0) goto L_0x01aa
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            r0.q1(r15, r6)
            r0 = 1
            goto L_0x01ae
        L_0x01aa:
            boolean r0 = r53.g0()
        L_0x01ae:
            r1 = 1
            boolean r2 = r15.d0(r1)
            if (r2 == 0) goto L_0x01be
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r2
            r2.q1(r15, r1)
            r1 = 1
            goto L_0x01c2
        L_0x01be:
            boolean r1 = r53.i0()
        L_0x01c2:
            if (r0 != 0) goto L_0x01e2
            if (r4 == 0) goto L_0x01e2
            int r2 = r15.f7127t0
            if (r2 == r3) goto L_0x01e2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f7083f
            if (r2 != 0) goto L_0x01e2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f7083f
            if (r2 != 0) goto L_0x01e2
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.R
            androidx.constraintlayout.core.SolverVariable r2 = r14.q(r2)
            r7 = 1
            r14.h(r2, r12, r6, r7)
        L_0x01e2:
            if (r1 != 0) goto L_0x0206
            if (r5 == 0) goto L_0x0206
            int r2 = r15.f7127t0
            if (r2 == r3) goto L_0x0206
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f7083f
            if (r2 != 0) goto L_0x0206
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f7083f
            if (r2 != 0) goto L_0x0206
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.T
            if (r2 != 0) goto L_0x0206
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.S
            androidx.constraintlayout.core.SolverVariable r2 = r14.q(r2)
            r7 = 1
            r14.h(r2, r10, r6, r7)
        L_0x0206:
            r29 = r0
            r28 = r1
            goto L_0x020f
        L_0x020b:
            r28 = r6
            r29 = r28
        L_0x020f:
            int r0 = r15.f7093c0
            int r1 = r15.f7115n0
            if (r0 >= r1) goto L_0x0216
            goto L_0x0217
        L_0x0216:
            r1 = r0
        L_0x0217:
            int r2 = r15.f7095d0
            int r7 = r15.f7117o0
            if (r2 >= r7) goto L_0x021e
            goto L_0x021f
        L_0x021e:
            r7 = r2
        L_0x021f:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r15.f7089a0
            r3 = r8[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r22 = r1
            if (r3 == r6) goto L_0x022b
            r3 = 1
            goto L_0x022c
        L_0x022b:
            r3 = 0
        L_0x022c:
            r21 = 1
            r1 = r8[r21]
            r23 = r7
            if (r1 == r6) goto L_0x0236
            r1 = 1
            goto L_0x0237
        L_0x0236:
            r1 = 0
        L_0x0237:
            int r7 = r15.f7099f0
            r15.G = r7
            r27 = r9
            float r9 = r15.f7097e0
            r15.H = r9
            r30 = r10
            int r10 = r15.f7130v
            r31 = r11
            int r11 = r15.f7132w
            r24 = 0
            int r24 = (r9 > r24 ? 1 : (r9 == r24 ? 0 : -1))
            r25 = 4
            r32 = r12
            if (r24 <= 0) goto L_0x02dd
            int r12 = r15.f7127t0
            r33 = r13
            r13 = 8
            if (r12 == r13) goto L_0x02df
            r12 = 0
            r13 = r8[r12]
            if (r13 != r6) goto L_0x0263
            if (r10 != 0) goto L_0x0263
            r10 = 3
        L_0x0263:
            r12 = 1
            r13 = r8[r12]
            if (r13 != r6) goto L_0x026b
            if (r11 != 0) goto L_0x026b
            r11 = 3
        L_0x026b:
            r13 = 0
            r14 = r8[r13]
            if (r14 != r6) goto L_0x027d
            r13 = r8[r12]
            if (r13 != r6) goto L_0x027d
            r12 = 3
            if (r10 != r12) goto L_0x027e
            if (r11 != r12) goto L_0x027e
            r15.j1(r4, r5, r3, r1)
            goto L_0x02d2
        L_0x027d:
            r12 = 3
        L_0x027e:
            r1 = 0
            r3 = r8[r1]
            if (r3 != r6) goto L_0x02a2
            if (r10 != r12) goto L_0x02a2
            r3 = r8
            r15.G = r1
            float r0 = (float) r2
            float r9 = r9 * r0
            int r1 = (int) r9
            r2 = 1
            r0 = r3[r2]
            if (r0 == r6) goto L_0x0299
            r35 = r11
            r34 = r23
            r36 = r25
            r0 = 0
            r14 = 0
            goto L_0x02e9
        L_0x0299:
            r14 = r2
            r36 = r10
            r35 = r11
            r34 = r23
            r0 = 0
            goto L_0x02e9
        L_0x02a2:
            r3 = r8
            r2 = 1
            r1 = r3[r2]
            if (r1 != r6) goto L_0x02d2
            r1 = 3
            if (r11 != r1) goto L_0x02d2
            r15.G = r2
            r1 = -1
            if (r7 != r1) goto L_0x02b5
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 / r9
            r15.H = r1
        L_0x02b5:
            float r1 = r15.H
            float r0 = (float) r0
            float r1 = r1 * r0
            int r7 = (int) r1
            r0 = 0
            r1 = r3[r0]
            if (r1 == r6) goto L_0x02c9
            r14 = r0
            r34 = r7
            r36 = r10
            r1 = r22
            r35 = r25
            goto L_0x02e9
        L_0x02c9:
            r34 = r7
            r36 = r10
            r35 = r11
            r1 = r22
            goto L_0x02db
        L_0x02d2:
            r0 = 0
            r36 = r10
            r35 = r11
            r1 = r22
            r34 = r23
        L_0x02db:
            r14 = 1
            goto L_0x02e9
        L_0x02dd:
            r33 = r13
        L_0x02df:
            r0 = 0
            r14 = r0
            r36 = r10
            r35 = r11
            r1 = r22
            r34 = r23
        L_0x02e9:
            int[] r2 = r15.f7134x
            r2[r0] = r36
            r0 = 1
            r2[r0] = r35
            r15.f7102h = r14
            if (r14 == 0) goto L_0x02fe
            int r0 = r15.G
            r2 = -1
            if (r0 == 0) goto L_0x02fb
            if (r0 != r2) goto L_0x02ff
        L_0x02fb:
            r20 = 1
            goto L_0x0301
        L_0x02fe:
            r2 = -1
        L_0x02ff:
            r20 = 0
        L_0x0301:
            if (r14 == 0) goto L_0x030d
            int r0 = r15.G
            r3 = 1
            if (r0 == r3) goto L_0x030a
            if (r0 != r2) goto L_0x030d
        L_0x030a:
            r37 = 1
            goto L_0x030f
        L_0x030d:
            r37 = 0
        L_0x030f:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.f7089a0
            r2 = 0
            r0 = r0[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x031e
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x031e
            r9 = 1
            goto L_0x031f
        L_0x031e:
            r9 = 0
        L_0x031f:
            if (r9 == 0) goto L_0x0324
            r22 = 0
            goto L_0x0326
        L_0x0324:
            r22 = r1
        L_0x0326:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.W
            boolean r0 = r0.o()
            r1 = 1
            r38 = r0 ^ 1
            boolean[] r0 = r15.Z
            r2 = 0
            boolean r23 = r0[r2]
            boolean r39 = r0[r1]
            int r0 = r15.f7124s
            r40 = 0
            r8 = 2
            if (r0 == r8) goto L_0x044d
            boolean r0 = r15.f7116o
            if (r0 != 0) goto L_0x044d
            if (r55 == 0) goto L_0x03a4
            androidx.constraintlayout.core.widgets.analyzer.h r0 = r15.f7096e
            if (r0 == 0) goto L_0x03a4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f7273h
            boolean r2 = r1.f7260j
            if (r2 == 0) goto L_0x03a4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7274i
            boolean r0 = r0.f7260j
            if (r0 != 0) goto L_0x0354
            goto L_0x03a4
        L_0x0354:
            if (r55 == 0) goto L_0x03a0
            int r0 = r1.f7257g
            r12 = r54
            r11 = r33
            r12.f(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.h r0 = r15.f7096e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7274i
            int r0 = r0.f7257g
            r10 = r32
            r12.f(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x038a
            if (r4 == 0) goto L_0x038a
            boolean[] r0 = r15.f7100g
            r1 = 0
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x038a
            boolean r0 = r53.g0()
            if (r0 != 0) goto L_0x038a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r3 = 8
            r12.h(r0, r10, r1, r3)
        L_0x038a:
            r43 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r32 = r14
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r10
            r31 = r11
            goto L_0x0461
        L_0x03a0:
            r12 = r54
            goto L_0x044d
        L_0x03a4:
            r12 = r54
            r10 = r32
            r11 = r33
            r3 = 8
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x03b8
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r7 = r0
            goto L_0x03ba
        L_0x03b8:
            r7 = r40
        L_0x03ba:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x03c7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.P
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r16 = r0
            goto L_0x03c9
        L_0x03c7:
            r16 = r40
        L_0x03c9:
            boolean[] r0 = r15.f7100g
            r17 = 0
            boolean r18 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.f7089a0
            r32 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r15.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.R
            r41 = r2
            int r2 = r15.f7101g0
            r42 = r2
            int r2 = r15.f7115n0
            int[] r3 = r15.I
            r44 = r3[r17]
            float r3 = r15.f7119p0
            r21 = 1
            r0 = r0[r21]
            if (r0 != r6) goto L_0x03ee
            r45 = r21
            goto L_0x03f0
        L_0x03ee:
            r45 = r17
        L_0x03f0:
            int r0 = r15.f7136y
            r24 = r0
            int r0 = r15.f7138z
            r25 = r0
            float r0 = r15.A
            r26 = r0
            r0 = r53
            r46 = r1
            r1 = r54
            r19 = r41
            r33 = r42
            r41 = r2
            r2 = 1
            r42 = r3
            r3 = r4
            r43 = r4
            r4 = r5
            r47 = r5
            r5 = r18
            r48 = r6
            r6 = r16
            r8 = r32
            r49 = r27
            r16 = r10
            r50 = r30
            r10 = r46
            r17 = r11
            r51 = r31
            r11 = r19
            r30 = r16
            r12 = r33
            r52 = r13
            r31 = r17
            r13 = r22
            r32 = r14
            r14 = r41
            r15 = r44
            r16 = r42
            r17 = r20
            r18 = r45
            r19 = r29
            r20 = r28
            r21 = r23
            r22 = r36
            r23 = r35
            r27 = r38
            r0.i(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0461
        L_0x044d:
            r43 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r32
            r31 = r33
            r32 = r14
        L_0x0461:
            if (r55 == 0) goto L_0x04c7
            r15 = r53
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f7098f
            if (r0 == 0) goto L_0x04ba
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f7273h
            boolean r2 = r1.f7260j
            if (r2 == 0) goto L_0x04ba
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7274i
            boolean r0 = r0.f7260j
            if (r0 == 0) goto L_0x04ba
            int r0 = r1.f7257g
            r14 = r54
            r13 = r51
            r14.f(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f7098f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7274i
            int r0 = r0.f7257g
            r12 = r50
            r14.f(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f7098f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f7299k
            int r0 = r0.f7257g
            r1 = r49
            r14.f(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x04b4
            if (r28 != 0) goto L_0x04b4
            if (r47 == 0) goto L_0x04b4
            boolean[] r2 = r15.f7100g
            r11 = 1
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x04b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r2 = 8
            r10 = 0
            r14.h(r0, r12, r10, r2)
            goto L_0x04b8
        L_0x04b0:
            r2 = 8
            r10 = 0
            goto L_0x04b8
        L_0x04b4:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x04b8:
            r7 = r10
            goto L_0x04d6
        L_0x04ba:
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x04d5
        L_0x04c7:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r53
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
        L_0x04d5:
            r7 = r11
        L_0x04d6:
            int r0 = r15.f7126t
            r3 = 2
            if (r0 != r3) goto L_0x04dd
            r6 = r10
            goto L_0x04de
        L_0x04dd:
            r6 = r7
        L_0x04de:
            if (r6 == 0) goto L_0x05be
            boolean r0 = r15.f7118p
            if (r0 != 0) goto L_0x05be
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.f7089a0
            r0 = r0[r11]
            r3 = r52
            if (r0 != r3) goto L_0x04f2
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x04f2
            r9 = r11
            goto L_0x04f3
        L_0x04f2:
            r9 = r10
        L_0x04f3:
            if (r9 == 0) goto L_0x04f7
            r34 = r10
        L_0x04f7:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x0503
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r7 = r0
            goto L_0x0505
        L_0x0503:
            r7 = r40
        L_0x0505:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f7091b0
            if (r0 == 0) goto L_0x0511
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.Q
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r6 = r0
            goto L_0x0513
        L_0x0511:
            r6 = r40
        L_0x0513:
            int r0 = r15.f7113m0
            if (r0 > 0) goto L_0x051b
            int r0 = r15.f7127t0
            if (r0 != r2) goto L_0x055b
        L_0x051b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.f7083f
            if (r3 == 0) goto L_0x0548
            int r0 = r53.q()
            r14.e(r1, r13, r0, r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f7083f
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.T
            int r3 = r3.f()
            r14.e(r1, r0, r3, r2)
            if (r47 == 0) goto L_0x0545
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r1 = 5
            r14.h(r7, r0, r10, r1)
        L_0x0545:
            r27 = r10
            goto L_0x055d
        L_0x0548:
            int r3 = r15.f7127t0
            if (r3 != r2) goto L_0x0554
            int r0 = r0.f()
            r14.e(r1, r13, r0, r2)
            goto L_0x055b
        L_0x0554:
            int r0 = r53.q()
            r14.e(r1, r13, r0, r2)
        L_0x055b:
            r27 = r38
        L_0x055d:
            boolean[] r0 = r15.f7100g
            boolean r5 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.f7089a0
            r8 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r15.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.S
            int r1 = r15.f7103h0
            int r2 = r15.f7117o0
            int[] r10 = r15.I
            r16 = r10[r11]
            float r10 = r15.f7121q0
            r17 = 0
            r0 = r0[r17]
            r11 = r48
            if (r0 != r11) goto L_0x057e
            r18 = 1
            goto L_0x0580
        L_0x057e:
            r18 = r17
        L_0x0580:
            int r0 = r15.B
            r24 = r0
            int r0 = r15.C
            r25 = r0
            float r0 = r15.D
            r26 = r0
            r0 = r53
            r19 = r1
            r1 = r54
            r20 = r2
            r2 = 0
            r11 = r3
            r3 = r47
            r21 = r4
            r4 = r43
            r17 = r10
            r10 = r21
            r33 = r12
            r12 = r19
            r38 = r13
            r13 = r34
            r14 = r20
            r15 = r16
            r16 = r17
            r17 = r37
            r19 = r28
            r20 = r29
            r21 = r39
            r22 = r35
            r23 = r36
            r0.i(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x05c2
        L_0x05be:
            r33 = r12
            r38 = r13
        L_0x05c2:
            if (r32 == 0) goto L_0x05ef
            r6 = 8
            r7 = r53
            int r0 = r7.G
            r1 = 1
            if (r0 != r1) goto L_0x05dd
            float r5 = r7.H
            r0 = r54
            r1 = r33
            r2 = r38
            r3 = r30
            r4 = r31
            r0.k(r1, r2, r3, r4, r5, r6)
            goto L_0x05f1
        L_0x05dd:
            float r5 = r7.H
            r6 = 8
            r0 = r54
            r1 = r30
            r2 = r31
            r3 = r33
            r4 = r38
            r0.k(r1, r2, r3, r4, r5, r6)
            goto L_0x05f1
        L_0x05ef:
            r7 = r53
        L_0x05f1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.W
            boolean r0 = r0.o()
            if (r0 == 0) goto L_0x0619
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.W
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.j()
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.h()
            float r1 = r7.J
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r7.W
            int r2 = r2.f()
            r3 = r54
            r3.b(r7, r0, r1, r2)
        L_0x0619:
            r0 = 0
            r7.f7116o = r0
            r7.f7118p = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean g0() {
        ConstraintAnchor constraintAnchor = this.P;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f7083f;
        if (constraintAnchor2 != null && constraintAnchor2.f7083f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.R;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f7083f;
        return constraintAnchor4 != null && constraintAnchor4.f7083f == constraintAnchor3;
    }

    public void g1(int i11) {
        if (i11 >= 0 && i11 <= 3) {
            this.f7128u = i11;
        }
    }

    public boolean h() {
        return this.f7127t0 != 8;
    }

    public boolean h0() {
        return this.L;
    }

    public void h1(int i11) {
        this.f7101g0 = i11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03b3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x041a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x045d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x04a7  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x04df A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:371:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(androidx.constraintlayout.core.LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            r31 = this;
            r0 = r31
            r10 = r32
            r11 = r37
            r12 = r38
            r13 = r41
            r14 = r42
            r15 = r45
            r1 = r46
            r2 = r54
            r3 = r55
            r4 = r56
            androidx.constraintlayout.core.SolverVariable r9 = r10.q(r13)
            androidx.constraintlayout.core.SolverVariable r8 = r10.q(r14)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r41.j()
            androidx.constraintlayout.core.SolverVariable r7 = r10.q(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r42.j()
            androidx.constraintlayout.core.SolverVariable r6 = r10.q(r5)
            androidx.constraintlayout.core.Metrics r5 = androidx.constraintlayout.core.LinearSystem.x()
            if (r5 == 0) goto L_0x0040
            androidx.constraintlayout.core.Metrics r5 = androidx.constraintlayout.core.LinearSystem.x()
            long r11 = r5.f6600w
            r16 = 1
            long r11 = r11 + r16
            r5.f6600w = r11
        L_0x0040:
            boolean r11 = r41.o()
            boolean r12 = r42.o()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.W
            boolean r16 = r5.o()
            if (r12 == 0) goto L_0x0053
            int r5 = r11 + 1
            goto L_0x0054
        L_0x0053:
            r5 = r11
        L_0x0054:
            if (r16 == 0) goto L_0x0058
            int r5 = r5 + 1
        L_0x0058:
            if (r48 == 0) goto L_0x005d
            r18 = 3
            goto L_0x005f
        L_0x005d:
            r18 = r53
        L_0x005f:
            int[] r17 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.f7141b
            int r19 = r39.ordinal()
            r2 = r17[r19]
            r14 = 1
            if (r2 == r14) goto L_0x0073
            r14 = 2
            if (r2 == r14) goto L_0x0073
            r14 = 3
            if (r2 == r14) goto L_0x0073
            r14 = 4
            if (r2 == r14) goto L_0x0078
        L_0x0073:
            r2 = r18
        L_0x0075:
            r18 = 0
            goto L_0x007e
        L_0x0078:
            r2 = r18
            if (r2 == r14) goto L_0x0075
            r18 = 1
        L_0x007e:
            int r14 = r0.f7110l
            r13 = -1
            if (r14 == r13) goto L_0x008c
            if (r33 == 0) goto L_0x008c
            r0.f7110l = r13
            r21 = r6
            r18 = 0
            goto L_0x0090
        L_0x008c:
            r14 = r44
            r21 = r6
        L_0x0090:
            int r6 = r0.f7112m
            if (r6 == r13) goto L_0x009b
            if (r33 != 0) goto L_0x009b
            r0.f7112m = r13
            r14 = r6
            r18 = 0
        L_0x009b:
            int r6 = r0.f7127t0
            r13 = 8
            if (r6 != r13) goto L_0x00a4
            r14 = 0
            r18 = 0
        L_0x00a4:
            if (r58 == 0) goto L_0x00bd
            if (r11 != 0) goto L_0x00b2
            if (r12 != 0) goto L_0x00b2
            if (r16 != 0) goto L_0x00b2
            r6 = r43
            r10.f(r9, r6)
            goto L_0x00bd
        L_0x00b2:
            if (r11 == 0) goto L_0x00bd
            if (r12 != 0) goto L_0x00bd
            int r6 = r41.f()
            r10.e(r9, r7, r6, r13)
        L_0x00bd:
            if (r18 != 0) goto L_0x00ea
            if (r40 == 0) goto L_0x00d6
            r6 = 3
            r13 = 0
            r10.e(r8, r9, r13, r6)
            r6 = 8
            if (r15 <= 0) goto L_0x00cd
            r10.h(r8, r9, r15, r6)
        L_0x00cd:
            r14 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r14) goto L_0x00db
            r10.j(r8, r9, r1, r6)
            goto L_0x00db
        L_0x00d6:
            r6 = r13
            r13 = 0
            r10.e(r8, r9, r14, r6)
        L_0x00db:
            r1 = r4
            r40 = r5
            r13 = r7
            r15 = r8
            r23 = r18
            r14 = r21
            r18 = r36
            r21 = r3
            goto L_0x01ec
        L_0x00ea:
            r1 = 2
            r13 = 0
            if (r5 == r1) goto L_0x0113
            if (r48 != 0) goto L_0x0113
            r1 = 1
            if (r2 == r1) goto L_0x00f5
            if (r2 != 0) goto L_0x0113
        L_0x00f5:
            int r1 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x00ff
            int r1 = java.lang.Math.min(r4, r1)
        L_0x00ff:
            r6 = 8
            r10.e(r8, r9, r1, r6)
            r18 = r36
            r1 = r4
            r40 = r5
            r15 = r8
            r23 = r13
            r14 = r21
            r21 = r3
            r13 = r7
            goto L_0x01ec
        L_0x0113:
            r1 = -2
            if (r3 != r1) goto L_0x0118
            r6 = r14
            goto L_0x0119
        L_0x0118:
            r6 = r3
        L_0x0119:
            if (r4 != r1) goto L_0x011d
            r1 = r14
            goto L_0x011e
        L_0x011d:
            r1 = r4
        L_0x011e:
            if (r14 <= 0) goto L_0x0124
            r3 = 1
            if (r2 == r3) goto L_0x0124
            r14 = r13
        L_0x0124:
            if (r6 <= 0) goto L_0x012f
            r3 = 8
            r10.h(r8, r9, r6, r3)
            int r14 = java.lang.Math.max(r14, r6)
        L_0x012f:
            if (r1 <= 0) goto L_0x0148
            if (r34 == 0) goto L_0x0138
            r3 = 1
            if (r2 != r3) goto L_0x0138
            r3 = r13
            goto L_0x0139
        L_0x0138:
            r3 = 1
        L_0x0139:
            if (r3 == 0) goto L_0x0141
            r3 = 8
            r10.j(r8, r9, r1, r3)
            goto L_0x0143
        L_0x0141:
            r3 = 8
        L_0x0143:
            int r14 = java.lang.Math.min(r14, r1)
            goto L_0x014a
        L_0x0148:
            r3 = 8
        L_0x014a:
            r4 = 1
            if (r2 != r4) goto L_0x0173
            if (r34 == 0) goto L_0x0154
            r10.e(r8, r9, r14, r3)
            r4 = 5
            goto L_0x0165
        L_0x0154:
            if (r50 == 0) goto L_0x015e
            r4 = 5
            r10.e(r8, r9, r14, r4)
            r10.j(r8, r9, r14, r3)
            goto L_0x0165
        L_0x015e:
            r4 = 5
            r10.e(r8, r9, r14, r4)
            r10.j(r8, r9, r14, r3)
        L_0x0165:
            r40 = r5
            r13 = r7
            r15 = r8
            r23 = r18
            r14 = r21
            r18 = r36
            r21 = r6
            goto L_0x01ec
        L_0x0173:
            r4 = 5
            r14 = 2
            if (r2 != r14) goto L_0x01e0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r41.k()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r3 == r4) goto L_0x01a1
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r41.k()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r13) goto L_0x0188
            goto L_0x01a1
        L_0x0188:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.p(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.q(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.p(r13)
            androidx.constraintlayout.core.SolverVariable r4 = r10.q(r4)
            goto L_0x01b7
        L_0x01a1:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.p(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.q(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f7091b0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.p(r13)
            androidx.constraintlayout.core.SolverVariable r4 = r10.q(r4)
        L_0x01b7:
            r23 = r3
            r13 = r4
            androidx.constraintlayout.core.ArrayRow r3 = r32.r()
            r24 = 5
            r4 = r8
            r14 = r5
            r5 = r9
            r40 = r14
            r14 = r21
            r21 = r6
            r6 = r13
            r13 = r7
            r7 = r23
            r15 = r8
            r8 = r57
            androidx.constraintlayout.core.ArrayRow r3 = r3.k(r4, r5, r6, r7, r8)
            r10.d(r3)
            if (r34 == 0) goto L_0x01db
            r18 = 0
        L_0x01db:
            r23 = r18
            r18 = r36
            goto L_0x01ec
        L_0x01e0:
            r40 = r5
            r13 = r7
            r15 = r8
            r14 = r21
            r21 = r6
            r23 = r18
            r18 = 1
        L_0x01ec:
            if (r58 == 0) goto L_0x050f
            if (r50 == 0) goto L_0x01fc
            r1 = r37
            r4 = r38
            r5 = r40
            r2 = r15
            r3 = 0
            r6 = 2
            r15 = r9
            goto L_0x0519
        L_0x01fc:
            if (r11 != 0) goto L_0x0207
            if (r12 != 0) goto L_0x0207
            if (r16 != 0) goto L_0x0207
            r2 = r15
            r1 = 5
            r3 = 0
            goto L_0x04da
        L_0x0207:
            if (r11 == 0) goto L_0x0223
            if (r12 != 0) goto L_0x0223
            r7 = r41
            r8 = 0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r7.f7083f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f7081d
            if (r34 == 0) goto L_0x021b
            boolean r1 = r1 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x021b
            r13 = 8
            goto L_0x021c
        L_0x021b:
            r13 = 5
        L_0x021c:
            r22 = r34
            r3 = r8
            r6 = r13
            r2 = r15
            goto L_0x04dd
        L_0x0223:
            r7 = r41
            r8 = 0
            if (r11 != 0) goto L_0x025a
            if (r12 == 0) goto L_0x025a
            int r1 = r42.f()
            int r1 = -r1
            r2 = 8
            r10.e(r15, r14, r1, r2)
            if (r34 == 0) goto L_0x04d7
            boolean r1 = r0.f7106j
            if (r1 == 0) goto L_0x0250
            boolean r1 = r9.f6611h
            if (r1 == 0) goto L_0x0250
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f7091b0
            if (r1 == 0) goto L_0x0250
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r1
            if (r33 == 0) goto L_0x024b
            r1.u1(r7)
            goto L_0x04d7
        L_0x024b:
            r1.z1(r7)
            goto L_0x04d7
        L_0x0250:
            r6 = r37
            r1 = 5
            r10.h(r9, r6, r8, r1)
            r3 = r8
            r2 = r15
            goto L_0x04da
        L_0x025a:
            r6 = r37
            if (r11 == 0) goto L_0x04d7
            if (r12 == 0) goto L_0x04d7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r7.f7083f
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.f7081d
            r12 = r42
            r3 = 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r12.f7083f
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.f7081d
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r31.L()
            r16 = 6
            if (r23 == 0) goto L_0x0366
            if (r2 != 0) goto L_0x02c9
            if (r1 != 0) goto L_0x029e
            if (r21 != 0) goto L_0x029e
            boolean r1 = r13.f6611h
            if (r1 == 0) goto L_0x0293
            boolean r1 = r14.f6611h
            if (r1 == 0) goto L_0x0293
            int r1 = r41.f()
            r2 = 8
            r10.e(r9, r13, r1, r2)
            int r1 = r42.f()
            int r1 = -r1
            r10.e(r15, r14, r1, r2)
            return
        L_0x0293:
            r19 = r8
            r24 = r19
            r1 = 8
            r3 = 8
            r22 = 1
            goto L_0x02a6
        L_0x029e:
            r22 = r8
            r1 = 5
            r3 = 5
            r19 = 1
            r24 = 1
        L_0x02a6:
            boolean r8 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 != 0) goto L_0x02bc
            boolean r8 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 == 0) goto L_0x02af
            goto L_0x02bc
        L_0x02af:
            r8 = r38
            r25 = r22
            r22 = r19
            r19 = r3
        L_0x02b7:
            r3 = r1
            r1 = r16
            goto L_0x03b1
        L_0x02bc:
            r8 = r38
            r3 = r1
            r1 = r16
            r25 = r22
            r22 = r19
            r19 = 4
            goto L_0x03b1
        L_0x02c9:
            if (r2 != r3) goto L_0x02e1
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x02dd
            boolean r1 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x02d4
            goto L_0x02dd
        L_0x02d4:
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 5
            goto L_0x03ab
        L_0x02dd:
            r8 = r38
            goto L_0x03a6
        L_0x02e1:
            r8 = 1
            if (r2 != r8) goto L_0x02ec
            r8 = r38
            r1 = r16
            r3 = 8
            goto L_0x03a9
        L_0x02ec:
            r8 = 3
            if (r2 != r8) goto L_0x035a
            int r8 = r0.G
            r3 = -1
            if (r8 != r3) goto L_0x030e
            if (r51 == 0) goto L_0x02fe
            r8 = r38
            if (r34 == 0) goto L_0x02fc
            r1 = 5
            goto L_0x0302
        L_0x02fc:
            r1 = 4
            goto L_0x0302
        L_0x02fe:
            r8 = r38
            r1 = 8
        L_0x0302:
            r3 = 8
        L_0x0304:
            r19 = 5
        L_0x0306:
            r22 = 1
            r24 = 1
            r25 = 1
            goto L_0x03b1
        L_0x030e:
            if (r48 == 0) goto L_0x032f
            r3 = r54
            r8 = 2
            if (r3 == r8) goto L_0x031b
            r1 = 1
            if (r3 != r1) goto L_0x0319
            goto L_0x031b
        L_0x0319:
            r1 = 0
            goto L_0x031c
        L_0x031b:
            r1 = 1
        L_0x031c:
            if (r1 != 0) goto L_0x0322
            r1 = 8
            r3 = 5
            goto L_0x0324
        L_0x0322:
            r1 = 5
            r3 = 4
        L_0x0324:
            r8 = r38
            r19 = r3
            r22 = 1
            r24 = 1
            r25 = 1
            goto L_0x02b7
        L_0x032f:
            if (r1 <= 0) goto L_0x0337
            r8 = r38
            r1 = r16
            r3 = 5
            goto L_0x0304
        L_0x0337:
            if (r1 != 0) goto L_0x0352
            if (r21 != 0) goto L_0x0352
            if (r51 != 0) goto L_0x0345
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 8
            goto L_0x0306
        L_0x0345:
            if (r11 == r4) goto L_0x034b
            if (r5 == r4) goto L_0x034b
            r1 = 4
            goto L_0x034c
        L_0x034b:
            r1 = 5
        L_0x034c:
            r8 = r38
            r3 = r1
            r1 = r16
            goto L_0x0357
        L_0x0352:
            r8 = r38
            r1 = r16
            r3 = 5
        L_0x0357:
            r19 = 4
            goto L_0x0306
        L_0x035a:
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 4
            r22 = 0
            r24 = 0
            goto L_0x03af
        L_0x0366:
            boolean r1 = r13.f6611h
            if (r1 == 0) goto L_0x02dd
            boolean r1 = r14.f6611h
            if (r1 == 0) goto L_0x02dd
            int r1 = r41.f()
            int r2 = r42.f()
            r3 = 8
            r48 = r32
            r49 = r9
            r50 = r13
            r51 = r1
            r52 = r47
            r53 = r14
            r54 = r15
            r55 = r2
            r56 = r3
            r48.c(r49, r50, r51, r52, r53, r54, r55, r56)
            if (r34 == 0) goto L_0x03a5
            if (r18 == 0) goto L_0x03a5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r12.f7083f
            if (r1 == 0) goto L_0x039c
            int r13 = r42.f()
            r8 = r38
            goto L_0x039f
        L_0x039c:
            r8 = r38
            r13 = 0
        L_0x039f:
            if (r14 == r8) goto L_0x03a5
            r1 = 5
            r10.h(r8, r15, r13, r1)
        L_0x03a5:
            return
        L_0x03a6:
            r1 = r16
            r3 = 5
        L_0x03a9:
            r19 = 4
        L_0x03ab:
            r22 = 1
            r24 = 1
        L_0x03af:
            r25 = 0
        L_0x03b1:
            if (r24 == 0) goto L_0x03bc
            if (r13 != r14) goto L_0x03bc
            if (r11 == r4) goto L_0x03bc
            r24 = 0
            r26 = 0
            goto L_0x03be
        L_0x03bc:
            r26 = 1
        L_0x03be:
            if (r22 == 0) goto L_0x0404
            if (r23 != 0) goto L_0x03d3
            if (r49 != 0) goto L_0x03d3
            if (r51 != 0) goto L_0x03d3
            if (r13 != r6) goto L_0x03d3
            if (r14 != r8) goto L_0x03d3
            r22 = 0
            r26 = 8
            r27 = 8
            r28 = 0
            goto L_0x03db
        L_0x03d3:
            r22 = r34
            r27 = r1
            r28 = r26
            r26 = r3
        L_0x03db:
            int r29 = r41.f()
            int r30 = r42.f()
            r1 = r32
            r3 = r2
            r2 = r9
            r12 = r3
            r3 = r13
            r39 = r12
            r12 = r4
            r4 = r29
            r29 = r12
            r12 = r5
            r5 = r47
            r6 = r14
            r7 = r15
            r8 = r30
            r20 = r15
            r15 = r9
            r9 = r27
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r26
            r26 = r28
            goto L_0x040e
        L_0x0404:
            r39 = r2
            r29 = r4
            r12 = r5
            r20 = r15
            r15 = r9
            r22 = r34
        L_0x040e:
            int r1 = r0.f7127t0
            r2 = 8
            if (r1 != r2) goto L_0x041b
            boolean r1 = r42.m()
            if (r1 != 0) goto L_0x041b
            return
        L_0x041b:
            if (r24 == 0) goto L_0x043f
            if (r22 == 0) goto L_0x042d
            if (r13 == r14) goto L_0x042d
            if (r23 != 0) goto L_0x042d
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x042b
            boolean r1 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x042d
        L_0x042b:
            r3 = r16
        L_0x042d:
            int r1 = r41.f()
            r10.h(r15, r13, r1, r3)
            int r1 = r42.f()
            int r1 = -r1
            r2 = r20
            r10.j(r2, r14, r1, r3)
            goto L_0x0441
        L_0x043f:
            r2 = r20
        L_0x0441:
            if (r22 == 0) goto L_0x0457
            if (r52 == 0) goto L_0x0457
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x0457
            boolean r1 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x0457
            r1 = r29
            if (r12 == r1) goto L_0x0459
            r3 = r16
            r4 = r3
            r26 = 1
            goto L_0x045b
        L_0x0457:
            r1 = r29
        L_0x0459:
            r4 = r19
        L_0x045b:
            if (r26 == 0) goto L_0x04a5
            if (r25 == 0) goto L_0x0485
            if (r51 == 0) goto L_0x0463
            if (r35 == 0) goto L_0x0485
        L_0x0463:
            if (r11 == r1) goto L_0x046a
            if (r12 != r1) goto L_0x0468
            goto L_0x046a
        L_0x0468:
            r6 = r4
            goto L_0x046c
        L_0x046a:
            r6 = r16
        L_0x046c:
            boolean r5 = r11 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r5 != 0) goto L_0x0474
            boolean r5 = r12 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r5 == 0) goto L_0x0475
        L_0x0474:
            r6 = 5
        L_0x0475:
            boolean r5 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 != 0) goto L_0x047d
            boolean r5 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 == 0) goto L_0x047e
        L_0x047d:
            r6 = 5
        L_0x047e:
            if (r51 == 0) goto L_0x0481
            r6 = 5
        L_0x0481:
            int r4 = java.lang.Math.max(r6, r4)
        L_0x0485:
            if (r22 == 0) goto L_0x0496
            int r3 = java.lang.Math.min(r3, r4)
            if (r48 == 0) goto L_0x0495
            if (r51 != 0) goto L_0x0495
            if (r11 == r1) goto L_0x0493
            if (r12 != r1) goto L_0x0495
        L_0x0493:
            r4 = 4
            goto L_0x0496
        L_0x0495:
            r4 = r3
        L_0x0496:
            int r1 = r41.f()
            r10.e(r15, r13, r1, r4)
            int r1 = r42.f()
            int r1 = -r1
            r10.e(r2, r14, r1, r4)
        L_0x04a5:
            if (r22 == 0) goto L_0x04b7
            r1 = r37
            if (r1 != r13) goto L_0x04b0
            int r3 = r41.f()
            goto L_0x04b1
        L_0x04b0:
            r3 = 0
        L_0x04b1:
            if (r13 == r1) goto L_0x04b7
            r4 = 5
            r10.h(r15, r1, r3, r4)
        L_0x04b7:
            if (r22 == 0) goto L_0x04d4
            if (r23 == 0) goto L_0x04d4
            if (r45 != 0) goto L_0x04d4
            if (r21 != 0) goto L_0x04d4
            if (r23 == 0) goto L_0x04ce
            r1 = r39
            r3 = 3
            if (r1 != r3) goto L_0x04ce
            r1 = 8
            r3 = 0
            r10.h(r2, r15, r3, r1)
            r1 = 5
            goto L_0x04dc
        L_0x04ce:
            r3 = 0
            r1 = 5
            r10.h(r2, r15, r3, r1)
            goto L_0x04dc
        L_0x04d4:
            r1 = 5
            r3 = 0
            goto L_0x04dc
        L_0x04d7:
            r3 = r8
            r2 = r15
            r1 = 5
        L_0x04da:
            r22 = r34
        L_0x04dc:
            r6 = r1
        L_0x04dd:
            if (r22 == 0) goto L_0x050e
            if (r18 == 0) goto L_0x050e
            r1 = r42
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f7083f
            if (r4 == 0) goto L_0x04ee
            int r13 = r42.f()
            r4 = r38
            goto L_0x04f1
        L_0x04ee:
            r4 = r38
            r13 = r3
        L_0x04f1:
            if (r14 == r4) goto L_0x050e
            boolean r3 = r0.f7106j
            if (r3 == 0) goto L_0x050b
            boolean r3 = r2.f6611h
            if (r3 == 0) goto L_0x050b
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7091b0
            if (r3 == 0) goto L_0x050b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r3
            if (r33 == 0) goto L_0x0507
            r3.t1(r1)
            goto L_0x050a
        L_0x0507:
            r3.y1(r1)
        L_0x050a:
            return
        L_0x050b:
            r10.h(r4, r2, r13, r6)
        L_0x050e:
            return
        L_0x050f:
            r1 = r37
            r4 = r38
            r2 = r15
            r3 = 0
            r15 = r9
            r5 = r40
            r6 = 2
        L_0x0519:
            if (r5 >= r6) goto L_0x055a
            if (r34 == 0) goto L_0x055a
            if (r18 == 0) goto L_0x055a
            r5 = 8
            r10.h(r15, r1, r3, r5)
            if (r33 != 0) goto L_0x052f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f7083f
            if (r1 != 0) goto L_0x052d
            goto L_0x052f
        L_0x052d:
            r13 = r3
            goto L_0x0530
        L_0x052f:
            r13 = 1
        L_0x0530:
            if (r33 != 0) goto L_0x0552
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f7083f
            if (r1 == 0) goto L_0x0552
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f7081d
            float r5 = r1.f7097e0
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x0550
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.f7089a0
            r5 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0550
            r5 = 1
            r1 = r1[r5]
            if (r1 != r6) goto L_0x0550
            r14 = r5
            goto L_0x0553
        L_0x0550:
            r14 = r3
            goto L_0x0553
        L_0x0552:
            r14 = r13
        L_0x0553:
            if (r14 == 0) goto L_0x055a
            r1 = 8
            r10.h(r4, r2, r3, r1)
        L_0x055a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public boolean i0() {
        ConstraintAnchor constraintAnchor = this.Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f7083f;
        if (constraintAnchor2 != null && constraintAnchor2.f7083f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f7083f;
        return constraintAnchor4 != null && constraintAnchor4.f7083f == constraintAnchor3;
    }

    public void i1(int i11) {
        this.f7103h0 = i11;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i11) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z11;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type == type6 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor p11 = p(type4);
                ConstraintAnchor p12 = constraintWidget.p(type2);
                ConstraintAnchor p13 = p(ConstraintAnchor.Type.RIGHT);
                p11.a(p12, 0);
                p13.a(p12, 0);
                p(type6).a(p12, 0);
                return;
            }
            ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
            if (type == type7 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor p14 = constraintWidget.p(type2);
                p(type3).a(p14, 0);
                p(ConstraintAnchor.Type.BOTTOM).a(p14, 0);
                p(type7).a(p14, 0);
            } else if (type == type6 && type2 == type6) {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                p(type8).a(constraintWidget.p(type8), 0);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                p(type9).a(constraintWidget.p(type9), 0);
                p(type6).a(constraintWidget.p(type2), 0);
            } else if (type == type7 && type2 == type7) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                p(type10).a(constraintWidget.p(type10), 0);
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                p(type11).a(constraintWidget.p(type11), 0);
                p(type7).a(constraintWidget.p(type2), 0);
            } else {
                ConstraintAnchor p15 = p(type);
                ConstraintAnchor p16 = constraintWidget.p(type2);
                if (p15.p(p16)) {
                    ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                    if (type == type12) {
                        ConstraintAnchor p17 = p(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor p18 = p(ConstraintAnchor.Type.BOTTOM);
                        if (p17 != null) {
                            p17.q();
                        }
                        if (p18 != null) {
                            p18.q();
                        }
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor p19 = p(type12);
                        if (p19 != null) {
                            p19.q();
                        }
                        ConstraintAnchor p21 = p(type5);
                        if (p21.j() != p16) {
                            p21.q();
                        }
                        ConstraintAnchor g11 = p(type).g();
                        ConstraintAnchor p22 = p(type7);
                        if (p22.o()) {
                            g11.q();
                            p22.q();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor p23 = p(type5);
                        if (p23.j() != p16) {
                            p23.q();
                        }
                        ConstraintAnchor g12 = p(type).g();
                        ConstraintAnchor p24 = p(type6);
                        if (p24.o()) {
                            g12.q();
                            p24.q();
                        }
                    }
                    p15.a(p16, i11);
                }
            }
        } else if (type2 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor p25 = p(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor p26 = p(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor p27 = p(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor p28 = p(type16);
            boolean z12 = true;
            if ((p25 == null || !p25.o()) && (p26 == null || !p26.o())) {
                j(type13, constraintWidget, type13, 0);
                j(type14, constraintWidget, type14, 0);
                z11 = true;
            } else {
                z11 = false;
            }
            if ((p27 == null || !p27.o()) && (p28 == null || !p28.o())) {
                j(type15, constraintWidget, type15, 0);
                j(type16, constraintWidget, type16, 0);
            } else {
                z12 = false;
            }
            if (z11 && z12) {
                p(type5).a(constraintWidget.p(type5), 0);
            } else if (z11) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                p(type17).a(constraintWidget.p(type17), 0);
            } else if (z12) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                p(type18).a(constraintWidget.p(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type2 == type19 || type2 == ConstraintAnchor.Type.RIGHT) {
                j(type19, constraintWidget, type2, 0);
                j(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                p(type5).a(constraintWidget.p(type2), 0);
                return;
            }
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
            if (type2 == type20 || type2 == ConstraintAnchor.Type.BOTTOM) {
                j(type20, constraintWidget, type2, 0);
                j(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                p(type5).a(constraintWidget.p(type2), 0);
            }
        }
    }

    public boolean j0() {
        return this.M;
    }

    public void j1(boolean z11, boolean z12, boolean z13, boolean z14) {
        if (this.G == -1) {
            if (z13 && !z14) {
                this.G = 0;
            } else if (!z13 && z14) {
                this.G = 1;
                if (this.f7099f0 == -1) {
                    this.H = 1.0f / this.H;
                }
            }
        }
        if (this.G == 0 && (!this.Q.o() || !this.S.o())) {
            this.G = 1;
        } else if (this.G == 1 && (!this.P.o() || !this.R.o())) {
            this.G = 0;
        }
        if (this.G == -1 && (!this.Q.o() || !this.S.o() || !this.P.o() || !this.R.o())) {
            if (this.Q.o() && this.S.o()) {
                this.G = 0;
            } else if (this.P.o() && this.R.o()) {
                this.H = 1.0f / this.H;
                this.G = 1;
            }
        }
        if (this.G == -1) {
            int i11 = this.f7136y;
            if (i11 > 0 && this.B == 0) {
                this.G = 0;
            } else if (i11 == 0 && this.B > 0) {
                this.H = 1.0f / this.H;
                this.G = 1;
            }
        }
    }

    public void k(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11) {
        if (constraintAnchor.h() == this) {
            j(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i11);
        }
    }

    public boolean k0() {
        return this.f7104i && this.f7127t0 != 8;
    }

    public void k1(boolean z11, boolean z12) {
        int i11;
        int i12;
        boolean k11 = z11 & this.f7096e.k();
        boolean k12 = z12 & this.f7098f.k();
        h hVar = this.f7096e;
        int i13 = hVar.f7273h.f7257g;
        j jVar = this.f7098f;
        int i14 = jVar.f7273h.f7257g;
        int i15 = hVar.f7274i.f7257g;
        int i16 = jVar.f7274i.f7257g;
        int i17 = i16 - i14;
        if (i15 - i13 < 0 || i17 < 0 || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE || i16 == Integer.MIN_VALUE || i16 == Integer.MAX_VALUE) {
            i15 = 0;
            i13 = 0;
            i16 = 0;
            i14 = 0;
        }
        int i18 = i15 - i13;
        int i19 = i16 - i14;
        if (k11) {
            this.f7101g0 = i13;
        }
        if (k12) {
            this.f7103h0 = i14;
        }
        if (this.f7127t0 == 8) {
            this.f7093c0 = 0;
            this.f7095d0 = 0;
            return;
        }
        if (k11) {
            if (this.f7089a0[0] == DimensionBehaviour.FIXED && i18 < (i12 = this.f7093c0)) {
                i18 = i12;
            }
            this.f7093c0 = i18;
            int i21 = this.f7115n0;
            if (i18 < i21) {
                this.f7093c0 = i21;
            }
        }
        if (k12) {
            if (this.f7089a0[1] == DimensionBehaviour.FIXED && i19 < (i11 = this.f7095d0)) {
                i19 = i11;
            }
            this.f7095d0 = i19;
            int i22 = this.f7117o0;
            if (i19 < i22) {
                this.f7095d0 = i22;
            }
        }
    }

    public void l(ConstraintWidget constraintWidget, float f11, int i11) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        c0(type, constraintWidget, type, i11, 0);
        this.J = f11;
    }

    public boolean l0() {
        return this.f7116o || (this.P.n() && this.R.n());
    }

    public void l1(LinearSystem linearSystem, boolean z11) {
        j jVar;
        h hVar;
        int y11 = linearSystem.y(this.P);
        int y12 = linearSystem.y(this.Q);
        int y13 = linearSystem.y(this.R);
        int y14 = linearSystem.y(this.S);
        if (z11 && (hVar = this.f7096e) != null) {
            DependencyNode dependencyNode = hVar.f7273h;
            if (dependencyNode.f7260j) {
                DependencyNode dependencyNode2 = hVar.f7274i;
                if (dependencyNode2.f7260j) {
                    y11 = dependencyNode.f7257g;
                    y13 = dependencyNode2.f7257g;
                }
            }
        }
        if (z11 && (jVar = this.f7098f) != null) {
            DependencyNode dependencyNode3 = jVar.f7273h;
            if (dependencyNode3.f7260j) {
                DependencyNode dependencyNode4 = jVar.f7274i;
                if (dependencyNode4.f7260j) {
                    y12 = dependencyNode3.f7257g;
                    y14 = dependencyNode4.f7257g;
                }
            }
        }
        int i11 = y14 - y12;
        if (y13 - y11 < 0 || i11 < 0 || y11 == Integer.MIN_VALUE || y11 == Integer.MAX_VALUE || y12 == Integer.MIN_VALUE || y12 == Integer.MAX_VALUE || y13 == Integer.MIN_VALUE || y13 == Integer.MAX_VALUE || y14 == Integer.MIN_VALUE || y14 == Integer.MAX_VALUE) {
            y14 = 0;
            y11 = 0;
            y12 = 0;
            y13 = 0;
        }
        E0(y11, y12, y13, y14);
    }

    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.f7124s = constraintWidget.f7124s;
        this.f7126t = constraintWidget.f7126t;
        this.f7130v = constraintWidget.f7130v;
        this.f7132w = constraintWidget.f7132w;
        int[] iArr = this.f7134x;
        int[] iArr2 = constraintWidget.f7134x;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f7136y = constraintWidget.f7136y;
        this.f7138z = constraintWidget.f7138z;
        this.B = constraintWidget.B;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        int[] iArr3 = constraintWidget.I;
        this.I = Arrays.copyOf(iArr3, iArr3.length);
        this.J = constraintWidget.J;
        this.K = constraintWidget.K;
        this.L = constraintWidget.L;
        this.P.q();
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.f7089a0 = (DimensionBehaviour[]) Arrays.copyOf(this.f7089a0, 2);
        ConstraintWidget constraintWidget2 = null;
        this.f7091b0 = this.f7091b0 == null ? null : hashMap.get(constraintWidget.f7091b0);
        this.f7093c0 = constraintWidget.f7093c0;
        this.f7095d0 = constraintWidget.f7095d0;
        this.f7097e0 = constraintWidget.f7097e0;
        this.f7099f0 = constraintWidget.f7099f0;
        this.f7101g0 = constraintWidget.f7101g0;
        this.f7103h0 = constraintWidget.f7103h0;
        this.f7105i0 = constraintWidget.f7105i0;
        this.f7107j0 = constraintWidget.f7107j0;
        this.f7109k0 = constraintWidget.f7109k0;
        this.f7111l0 = constraintWidget.f7111l0;
        this.f7113m0 = constraintWidget.f7113m0;
        this.f7115n0 = constraintWidget.f7115n0;
        this.f7117o0 = constraintWidget.f7117o0;
        this.f7119p0 = constraintWidget.f7119p0;
        this.f7121q0 = constraintWidget.f7121q0;
        this.f7123r0 = constraintWidget.f7123r0;
        this.f7125s0 = constraintWidget.f7125s0;
        this.f7127t0 = constraintWidget.f7127t0;
        this.f7129u0 = constraintWidget.f7129u0;
        this.f7131v0 = constraintWidget.f7131v0;
        this.f7133w0 = constraintWidget.f7133w0;
        this.f7135x0 = constraintWidget.f7135x0;
        this.f7137y0 = constraintWidget.f7137y0;
        this.f7139z0 = constraintWidget.f7139z0;
        this.A0 = constraintWidget.A0;
        this.B0 = constraintWidget.B0;
        this.C0 = constraintWidget.C0;
        this.D0 = constraintWidget.D0;
        this.E0 = constraintWidget.E0;
        this.F0 = constraintWidget.F0;
        this.H0 = constraintWidget.H0;
        this.I0 = constraintWidget.I0;
        this.J0 = constraintWidget.J0;
        this.K0 = constraintWidget.K0;
        float[] fArr = this.L0;
        float[] fArr2 = constraintWidget.L0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.M0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.M0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.N0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.N0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.O0;
        this.O0 = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.P0;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.P0 = constraintWidget2;
    }

    public boolean m0() {
        return this.f7118p || (this.Q.n() && this.S.n());
    }

    public void n(LinearSystem linearSystem) {
        linearSystem.q(this.P);
        linearSystem.q(this.Q);
        linearSystem.q(this.R);
        linearSystem.q(this.S);
        if (this.f7113m0 > 0) {
            linearSystem.q(this.T);
        }
    }

    public boolean n0() {
        return this.f7122r;
    }

    public void o() {
        if (this.f7096e == null) {
            this.f7096e = new h(this);
        }
        if (this.f7098f == null) {
            this.f7098f = new j(this);
        }
    }

    public void o0() {
        this.f7120q = true;
    }

    public ConstraintAnchor p(ConstraintAnchor.Type type) {
        switch (a.f7140a[type.ordinal()]) {
            case 1:
                return this.P;
            case 2:
                return this.Q;
            case 3:
                return this.R;
            case 4:
                return this.S;
            case 5:
                return this.T;
            case 6:
                return this.W;
            case 7:
                return this.U;
            case 8:
                return this.V;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public void p0() {
        this.f7122r = true;
    }

    public int q() {
        return this.f7113m0;
    }

    public boolean q0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.f7089a0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public float r(int i11) {
        if (i11 == 0) {
            return this.f7119p0;
        }
        if (i11 == 1) {
            return this.f7121q0;
        }
        return -1.0f;
    }

    public void r0() {
        this.P.q();
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.f7091b0 = null;
        this.J = 0.0f;
        this.f7093c0 = 0;
        this.f7095d0 = 0;
        this.f7097e0 = 0.0f;
        this.f7099f0 = -1;
        this.f7101g0 = 0;
        this.f7103h0 = 0;
        this.f7109k0 = 0;
        this.f7111l0 = 0;
        this.f7113m0 = 0;
        this.f7115n0 = 0;
        this.f7117o0 = 0;
        float f11 = S0;
        this.f7119p0 = f11;
        this.f7121q0 = f11;
        DimensionBehaviour[] dimensionBehaviourArr = this.f7089a0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f7123r0 = null;
        this.f7125s0 = 0;
        this.f7127t0 = 0;
        this.f7131v0 = null;
        this.E0 = false;
        this.F0 = false;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = false;
        this.K0 = false;
        float[] fArr = this.L0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f7124s = -1;
        this.f7126t = -1;
        int[] iArr = this.I;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f7130v = 0;
        this.f7132w = 0;
        this.A = 1.0f;
        this.D = 1.0f;
        this.f7138z = Integer.MAX_VALUE;
        this.C = Integer.MAX_VALUE;
        this.f7136y = 0;
        this.B = 0;
        this.f7102h = false;
        this.G = -1;
        this.H = 1.0f;
        this.G0 = false;
        boolean[] zArr = this.f7100g;
        zArr[0] = true;
        zArr[1] = true;
        this.M = false;
        boolean[] zArr2 = this.Z;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f7104i = true;
        int[] iArr2 = this.f7134x;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f7110l = -1;
        this.f7112m = -1;
    }

    public int s() {
        return W() + this.f7095d0;
    }

    public void s0() {
        ConstraintWidget L2 = L();
        if (L2 == null || !(L2 instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) L()).H1()) {
            int size = this.Y.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.Y.get(i11).q();
            }
        }
    }

    public Object t() {
        return this.f7123r0;
    }

    public void t0() {
        this.f7116o = false;
        this.f7118p = false;
        this.f7120q = false;
        this.f7122r = false;
        int size = this.Y.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.Y.get(i11).r();
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f7131v0 != null) {
            str = "type: " + this.f7131v0 + " ";
        } else {
            str = str2;
        }
        sb2.append(str);
        if (this.f7129u0 != null) {
            str2 = "id: " + this.f7129u0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f7101g0);
        sb2.append(", ");
        sb2.append(this.f7103h0);
        sb2.append(") - (");
        sb2.append(this.f7093c0);
        sb2.append(" x ");
        sb2.append(this.f7095d0);
        sb2.append(")");
        return sb2.toString();
    }

    public String u() {
        return this.f7129u0;
    }

    public void u0(Cache cache) {
        this.P.s(cache);
        this.Q.s(cache);
        this.R.s(cache);
        this.S.s(cache);
        this.T.s(cache);
        this.W.s(cache);
        this.U.s(cache);
        this.V.s(cache);
    }

    public DimensionBehaviour v(int i11) {
        if (i11 == 0) {
            return B();
        }
        if (i11 == 1) {
            return R();
        }
        return null;
    }

    public void v0(int i11) {
        this.f7113m0 = i11;
        this.K = i11 > 0;
    }

    public float w() {
        return this.f7097e0;
    }

    public void w0(Object obj) {
        this.f7123r0 = obj;
    }

    public int x() {
        return this.f7099f0;
    }

    public void x0(String str) {
        this.f7129u0 = str;
    }

    public int y() {
        if (this.f7127t0 == 8) {
            return 0;
        }
        return this.f7095d0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y0(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = r4
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = r5
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = r0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.f7097e0 = r9
            r8.f7099f0 = r1
        L_0x008d:
            return
        L_0x008e:
            r8.f7097e0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.y0(java.lang.String):void");
    }

    public float z() {
        return this.f7119p0;
    }

    public void z0(int i11) {
        if (this.K) {
            int i12 = i11 - this.f7113m0;
            int i13 = this.f7095d0 + i12;
            this.f7103h0 = i12;
            this.Q.t(i12);
            this.S.t(i13);
            this.T.t(i11);
            this.f7118p = true;
        }
    }
}
