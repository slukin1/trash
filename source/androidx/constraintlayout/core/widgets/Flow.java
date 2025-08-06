package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public int A1 = 0;
    public ArrayList<a> B1 = new ArrayList<>();
    public ConstraintWidget[] C1 = null;
    public ConstraintWidget[] D1 = null;
    public int[] E1 = null;
    public ConstraintWidget[] F1;
    public int G1 = 0;

    /* renamed from: i1  reason: collision with root package name */
    public int f7167i1 = -1;

    /* renamed from: j1  reason: collision with root package name */
    public int f7168j1 = -1;

    /* renamed from: k1  reason: collision with root package name */
    public int f7169k1 = -1;

    /* renamed from: l1  reason: collision with root package name */
    public int f7170l1 = -1;

    /* renamed from: m1  reason: collision with root package name */
    public int f7171m1 = -1;

    /* renamed from: n1  reason: collision with root package name */
    public int f7172n1 = -1;

    /* renamed from: o1  reason: collision with root package name */
    public float f7173o1 = 0.5f;

    /* renamed from: p1  reason: collision with root package name */
    public float f7174p1 = 0.5f;

    /* renamed from: q1  reason: collision with root package name */
    public float f7175q1 = 0.5f;

    /* renamed from: r1  reason: collision with root package name */
    public float f7176r1 = 0.5f;

    /* renamed from: s1  reason: collision with root package name */
    public float f7177s1 = 0.5f;

    /* renamed from: t1  reason: collision with root package name */
    public float f7178t1 = 0.5f;

    /* renamed from: u1  reason: collision with root package name */
    public int f7179u1 = 0;

    /* renamed from: v1  reason: collision with root package name */
    public int f7180v1 = 0;

    /* renamed from: w1  reason: collision with root package name */
    public int f7181w1 = 2;

    /* renamed from: x1  reason: collision with root package name */
    public int f7182x1 = 2;

    /* renamed from: y1  reason: collision with root package name */
    public int f7183y1 = 0;

    /* renamed from: z1  reason: collision with root package name */
    public int f7184z1 = -1;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f7185a = 0;

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget f7186b = null;

        /* renamed from: c  reason: collision with root package name */
        public int f7187c = 0;

        /* renamed from: d  reason: collision with root package name */
        public ConstraintAnchor f7188d;

        /* renamed from: e  reason: collision with root package name */
        public ConstraintAnchor f7189e;

        /* renamed from: f  reason: collision with root package name */
        public ConstraintAnchor f7190f;

        /* renamed from: g  reason: collision with root package name */
        public ConstraintAnchor f7191g;

        /* renamed from: h  reason: collision with root package name */
        public int f7192h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f7193i = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f7194j = 0;

        /* renamed from: k  reason: collision with root package name */
        public int f7195k = 0;

        /* renamed from: l  reason: collision with root package name */
        public int f7196l = 0;

        /* renamed from: m  reason: collision with root package name */
        public int f7197m = 0;

        /* renamed from: n  reason: collision with root package name */
        public int f7198n = 0;

        /* renamed from: o  reason: collision with root package name */
        public int f7199o = 0;

        /* renamed from: p  reason: collision with root package name */
        public int f7200p = 0;

        /* renamed from: q  reason: collision with root package name */
        public int f7201q = 0;

        public a(int i11, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i12) {
            this.f7185a = i11;
            this.f7188d = constraintAnchor;
            this.f7189e = constraintAnchor2;
            this.f7190f = constraintAnchor3;
            this.f7191g = constraintAnchor4;
            this.f7192h = Flow.this.u1();
            this.f7193i = Flow.this.w1();
            this.f7194j = Flow.this.v1();
            this.f7195k = Flow.this.t1();
            this.f7201q = i12;
        }

        public void b(ConstraintWidget constraintWidget) {
            int i11 = 0;
            if (this.f7185a == 0) {
                int W1 = Flow.this.g2(constraintWidget, this.f7201q);
                if (constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f7200p++;
                    W1 = 0;
                }
                int K1 = Flow.this.f7179u1;
                if (constraintWidget.T() != 8) {
                    i11 = K1;
                }
                this.f7196l += W1 + i11;
                int X1 = Flow.this.f2(constraintWidget, this.f7201q);
                if (this.f7186b == null || this.f7187c < X1) {
                    this.f7186b = constraintWidget;
                    this.f7187c = X1;
                    this.f7197m = X1;
                }
            } else {
                int W12 = Flow.this.g2(constraintWidget, this.f7201q);
                int X12 = Flow.this.f2(constraintWidget, this.f7201q);
                if (constraintWidget.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f7200p++;
                    X12 = 0;
                }
                int L1 = Flow.this.f7180v1;
                if (constraintWidget.T() != 8) {
                    i11 = L1;
                }
                this.f7197m += X12 + i11;
                if (this.f7186b == null || this.f7187c < W12) {
                    this.f7186b = constraintWidget;
                    this.f7187c = W12;
                    this.f7196l = W12;
                }
            }
            this.f7199o++;
        }

        public void c() {
            this.f7187c = 0;
            this.f7186b = null;
            this.f7196l = 0;
            this.f7197m = 0;
            this.f7198n = 0;
            this.f7199o = 0;
            this.f7200p = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x00df  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.f7199o
                r2 = 0
                r3 = r2
            L_0x0006:
                if (r3 >= r1) goto L_0x0027
                int r4 = r0.f7198n
                int r4 = r4 + r3
                androidx.constraintlayout.core.widgets.Flow r5 = androidx.constraintlayout.core.widgets.Flow.this
                int r5 = r5.G1
                if (r4 < r5) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                androidx.constraintlayout.core.widgets.Flow r4 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.F1
                int r5 = r0.f7198n
                int r5 = r5 + r3
                r4 = r4[r5]
                if (r4 == 0) goto L_0x0024
                r4.s0()
            L_0x0024:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0027:
                if (r1 == 0) goto L_0x0377
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7186b
                if (r3 != 0) goto L_0x002f
                goto L_0x0377
            L_0x002f:
                if (r19 == 0) goto L_0x0035
                if (r18 != 0) goto L_0x0035
                r4 = 1
                goto L_0x0036
            L_0x0035:
                r4 = r2
            L_0x0036:
                r5 = -1
                r6 = r2
                r7 = r5
                r8 = r7
            L_0x003a:
                if (r6 >= r1) goto L_0x0067
                if (r17 == 0) goto L_0x0042
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0043
            L_0x0042:
                r9 = r6
            L_0x0043:
                int r10 = r0.f7198n
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.G1
                if (r10 < r11) goto L_0x004f
                goto L_0x0067
            L_0x004f:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.F1
                int r11 = r0.f7198n
                int r11 = r11 + r9
                r9 = r10[r11]
                int r9 = r9.T()
                if (r9 != 0) goto L_0x0064
                if (r7 != r5) goto L_0x0063
                r7 = r6
            L_0x0063:
                r8 = r6
            L_0x0064:
                int r6 = r6 + 1
                goto L_0x003a
            L_0x0067:
                r6 = 0
                int r9 = r0.f7185a
                if (r9 != 0) goto L_0x0206
                androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r0.f7186b
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.f7168j1
                r9.Z0(r10)
                int r10 = r0.f7193i
                if (r18 <= 0) goto L_0x0082
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.f7180v1
                int r10 = r10 + r11
            L_0x0082:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f7189e
                r11.a(r12, r10)
                if (r19 == 0) goto L_0x0094
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r9.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7191g
                int r12 = r0.f7195k
                r10.a(r11, r12)
            L_0x0094:
                if (r18 <= 0) goto L_0x00a1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f7189e
                androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.f7081d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.Q
                r10.a(r11, r2)
            L_0x00a1:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.f7182x1
                r11 = 3
                if (r10 != r11) goto L_0x00db
                boolean r10 = r9.X()
                if (r10 != 0) goto L_0x00db
                r10 = r2
            L_0x00b1:
                if (r10 >= r1) goto L_0x00db
                if (r17 == 0) goto L_0x00b9
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x00ba
            L_0x00b9:
                r12 = r10
            L_0x00ba:
                int r13 = r0.f7198n
                int r13 = r13 + r12
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                int r14 = r14.G1
                if (r13 < r14) goto L_0x00c6
                goto L_0x00db
            L_0x00c6:
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r13.F1
                int r14 = r0.f7198n
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.X()
                if (r13 == 0) goto L_0x00d8
                goto L_0x00dc
            L_0x00d8:
                int r10 = r10 + 1
                goto L_0x00b1
            L_0x00db:
                r12 = r9
            L_0x00dc:
                r10 = r2
            L_0x00dd:
                if (r10 >= r1) goto L_0x0377
                if (r17 == 0) goto L_0x00e5
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00e6
            L_0x00e5:
                r13 = r10
            L_0x00e6:
                int r14 = r0.f7198n
                int r14 = r14 + r13
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.G1
                if (r14 < r15) goto L_0x00f3
                goto L_0x0377
            L_0x00f3:
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r14.F1
                int r15 = r0.f7198n
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r10 != 0) goto L_0x0109
                androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r14.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7188d
                int r3 = r0.f7192h
                r14.k(r15, r11, r3)
            L_0x0109:
                if (r13 != 0) goto L_0x0167
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.f7167i1
                r11 = 1065353216(0x3f800000, float:1.0)
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.f7173o1
                if (r17 == 0) goto L_0x011d
                float r13 = r11 - r13
            L_0x011d:
                int r15 = r0.f7198n
                if (r15 != 0) goto L_0x0141
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.f7169k1
                if (r15 == r5) goto L_0x0141
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.f7169k1
                if (r17 == 0) goto L_0x0139
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.f7175q1
            L_0x0137:
                float r11 = r11 - r13
                goto L_0x013f
            L_0x0139:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.f7175q1
            L_0x013f:
                r13 = r11
                goto L_0x0161
            L_0x0141:
                if (r19 == 0) goto L_0x0161
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.f7171m1
                if (r15 == r5) goto L_0x0161
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.f7171m1
                if (r17 == 0) goto L_0x015a
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.f7177s1
                goto L_0x0137
            L_0x015a:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.f7177s1
                goto L_0x013f
            L_0x0161:
                r14.I0(r3)
                r14.H0(r13)
            L_0x0167:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x0174
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7190f
                int r13 = r0.f7194j
                r14.k(r3, r11, r13)
            L_0x0174:
                if (r6 == 0) goto L_0x019f
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.f7179u1
                r3.a(r11, r13)
                if (r10 != r7) goto L_0x018c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.P
                int r11 = r0.f7192h
                r3.u(r11)
            L_0x018c:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r6.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r14.P
                r3.a(r11, r2)
                r3 = 1
                int r11 = r8 + 1
                if (r10 != r11) goto L_0x019f
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r6.R
                int r6 = r0.f7194j
                r3.u(r6)
            L_0x019f:
                if (r14 == r9) goto L_0x01ff
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.f7182x1
                r6 = 3
                if (r3 != r6) goto L_0x01c0
                boolean r3 = r12.X()
                if (r3 == 0) goto L_0x01c0
                if (r14 == r12) goto L_0x01c0
                boolean r3 = r14.X()
                if (r3 == 0) goto L_0x01c0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.T
                r3.a(r11, r2)
                goto L_0x0200
            L_0x01c0:
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.f7182x1
                if (r3 == 0) goto L_0x01f7
                r11 = 1
                if (r3 == r11) goto L_0x01ef
                if (r4 == 0) goto L_0x01e0
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7189e
                int r13 = r0.f7193i
                r3.a(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7191g
                int r13 = r0.f7195k
                r3.a(r11, r13)
                goto L_0x0200
            L_0x01e0:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.Q
                r3.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.S
                r3.a(r11, r2)
                goto L_0x0200
            L_0x01ef:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.S
                r3.a(r11, r2)
                goto L_0x0200
            L_0x01f7:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.Q
                r3.a(r11, r2)
                goto L_0x0200
            L_0x01ff:
                r6 = 3
            L_0x0200:
                int r10 = r10 + 1
                r11 = r6
                r6 = r14
                goto L_0x00dd
            L_0x0206:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f7186b
                androidx.constraintlayout.core.widgets.Flow r9 = androidx.constraintlayout.core.widgets.Flow.this
                int r9 = r9.f7167i1
                r3.I0(r9)
                int r9 = r0.f7192h
                if (r18 <= 0) goto L_0x021c
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.f7179u1
                int r9 = r9 + r10
            L_0x021c:
                if (r17 == 0) goto L_0x023e
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7190f
                r10.a(r11, r9)
                if (r19 == 0) goto L_0x0230
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r3.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f7188d
                int r11 = r0.f7194j
                r9.a(r10, r11)
            L_0x0230:
                if (r18 <= 0) goto L_0x025d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.f7190f
                androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r9.f7081d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.R
                r9.a(r10, r2)
                goto L_0x025d
            L_0x023e:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7188d
                r10.a(r11, r9)
                if (r19 == 0) goto L_0x0250
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r3.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f7190f
                int r11 = r0.f7194j
                r9.a(r10, r11)
            L_0x0250:
                if (r18 <= 0) goto L_0x025d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.f7188d
                androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r9.f7081d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.P
                r9.a(r10, r2)
            L_0x025d:
                r9 = r2
            L_0x025e:
                if (r9 >= r1) goto L_0x0377
                int r10 = r0.f7198n
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.G1
                if (r10 < r11) goto L_0x026d
                goto L_0x0377
            L_0x026d:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.F1
                int r11 = r0.f7198n
                int r11 = r11 + r9
                r10 = r10[r11]
                if (r9 != 0) goto L_0x02c4
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f7189e
                int r13 = r0.f7193i
                r10.k(r11, r12, r13)
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.f7168j1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.f7174p1
                int r13 = r0.f7198n
                if (r13 != 0) goto L_0x02a8
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.f7170l1
                if (r13 == r5) goto L_0x02a8
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.f7170l1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.f7176r1
                goto L_0x02be
            L_0x02a8:
                if (r19 == 0) goto L_0x02be
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.f7172n1
                if (r13 == r5) goto L_0x02be
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.f7172n1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.f7178t1
            L_0x02be:
                r10.Z0(r11)
                r10.Y0(r12)
            L_0x02c4:
                int r11 = r1 + -1
                if (r9 != r11) goto L_0x02d1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f7191g
                int r13 = r0.f7195k
                r10.k(r11, r12, r13)
            L_0x02d1:
                if (r6 == 0) goto L_0x02fc
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.S
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.f7180v1
                r11.a(r12, r13)
                if (r9 != r7) goto L_0x02e9
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.Q
                int r12 = r0.f7193i
                r11.u(r12)
            L_0x02e9:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r10.Q
                r11.a(r12, r2)
                r11 = 1
                int r12 = r8 + 1
                if (r9 != r12) goto L_0x02fc
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.S
                int r11 = r0.f7195k
                r6.u(r11)
            L_0x02fc:
                if (r10 == r3) goto L_0x0371
                r6 = 2
                if (r17 == 0) goto L_0x032e
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.f7181w1
                if (r11 == 0) goto L_0x0326
                r12 = 1
                if (r11 == r12) goto L_0x031e
                if (r11 == r6) goto L_0x030f
                goto L_0x0371
            L_0x030f:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.P
                r6.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.R
                r6.a(r11, r2)
                goto L_0x0371
            L_0x031e:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.P
                r6.a(r11, r2)
                goto L_0x0371
            L_0x0326:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.R
                r6.a(r11, r2)
                goto L_0x0371
            L_0x032e:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.f7181w1
                if (r11 == 0) goto L_0x0368
                r12 = 1
                if (r11 == r12) goto L_0x0360
                if (r11 == r6) goto L_0x033c
                goto L_0x0372
            L_0x033c:
                if (r4 == 0) goto L_0x0351
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7188d
                int r13 = r0.f7192h
                r6.a(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f7190f
                int r13 = r0.f7194j
                r6.a(r11, r13)
                goto L_0x0372
            L_0x0351:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.P
                r6.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.R
                r6.a(r11, r2)
                goto L_0x0372
            L_0x0360:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.R
                r6.a(r11, r2)
                goto L_0x0372
            L_0x0368:
                r12 = 1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.P
                r6.a(r11, r2)
                goto L_0x0372
            L_0x0371:
                r12 = 1
            L_0x0372:
                int r9 = r9 + 1
                r6 = r10
                goto L_0x025e
            L_0x0377:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.a.d(boolean, int, boolean):void");
        }

        public int e() {
            if (this.f7185a == 1) {
                return this.f7197m - Flow.this.f7180v1;
            }
            return this.f7197m;
        }

        public int f() {
            if (this.f7185a == 0) {
                return this.f7196l - Flow.this.f7179u1;
            }
            return this.f7196l;
        }

        public void g(int i11) {
            int i12 = this.f7200p;
            if (i12 != 0) {
                int i13 = this.f7199o;
                int i14 = i11 / i12;
                int i15 = 0;
                while (i15 < i13 && this.f7198n + i15 < Flow.this.G1) {
                    ConstraintWidget constraintWidget = Flow.this.F1[this.f7198n + i15];
                    if (this.f7185a == 0) {
                        if (constraintWidget != null && constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f7130v == 0) {
                            Flow.this.y1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i14, constraintWidget.R(), constraintWidget.y());
                        }
                    } else if (constraintWidget != null && constraintWidget.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f7132w == 0) {
                        Flow.this.y1(constraintWidget, constraintWidget.B(), constraintWidget.U(), ConstraintWidget.DimensionBehaviour.FIXED, i14);
                    }
                    i15++;
                }
                h();
            }
        }

        public final void h() {
            this.f7196l = 0;
            this.f7197m = 0;
            this.f7186b = null;
            this.f7187c = 0;
            int i11 = this.f7199o;
            int i12 = 0;
            while (i12 < i11 && this.f7198n + i12 < Flow.this.G1) {
                ConstraintWidget constraintWidget = Flow.this.F1[this.f7198n + i12];
                if (this.f7185a == 0) {
                    int U = constraintWidget.U();
                    int K1 = Flow.this.f7179u1;
                    if (constraintWidget.T() == 8) {
                        K1 = 0;
                    }
                    this.f7196l += U + K1;
                    int X1 = Flow.this.f2(constraintWidget, this.f7201q);
                    if (this.f7186b == null || this.f7187c < X1) {
                        this.f7186b = constraintWidget;
                        this.f7187c = X1;
                        this.f7197m = X1;
                    }
                } else {
                    int W1 = Flow.this.g2(constraintWidget, this.f7201q);
                    int X12 = Flow.this.f2(constraintWidget, this.f7201q);
                    int L1 = Flow.this.f7180v1;
                    if (constraintWidget.T() == 8) {
                        L1 = 0;
                    }
                    this.f7197m += X12 + L1;
                    if (this.f7186b == null || this.f7187c < W1) {
                        this.f7186b = constraintWidget;
                        this.f7187c = W1;
                        this.f7196l = W1;
                    }
                }
                i12++;
            }
        }

        public void i(int i11) {
            this.f7198n = i11;
        }

        public void j(int i11, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i12, int i13, int i14, int i15, int i16) {
            this.f7185a = i11;
            this.f7188d = constraintAnchor;
            this.f7189e = constraintAnchor2;
            this.f7190f = constraintAnchor3;
            this.f7191g = constraintAnchor4;
            this.f7192h = i12;
            this.f7193i = i13;
            this.f7194j = i14;
            this.f7195k = i15;
            this.f7201q = i16;
        }
    }

    public void A2(int i11) {
        this.f7180v1 = i11;
    }

    public void B2(int i11) {
        this.f7168j1 = i11;
    }

    public void C2(int i11) {
        this.f7183y1 = i11;
    }

    public final void e2(boolean z11) {
        ConstraintWidget constraintWidget;
        float f11;
        int i11;
        if (this.E1 != null && this.D1 != null && this.C1 != null) {
            for (int i12 = 0; i12 < this.G1; i12++) {
                this.F1[i12].s0();
            }
            int[] iArr = this.E1;
            int i13 = iArr[0];
            int i14 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            float f12 = this.f7173o1;
            int i15 = 0;
            while (i15 < i13) {
                if (z11) {
                    i11 = (i13 - i15) - 1;
                    f11 = 1.0f - this.f7173o1;
                } else {
                    f11 = f12;
                    i11 = i15;
                }
                ConstraintWidget constraintWidget3 = this.D1[i11];
                if (!(constraintWidget3 == null || constraintWidget3.T() == 8)) {
                    if (i15 == 0) {
                        constraintWidget3.k(constraintWidget3.P, this.P, u1());
                        constraintWidget3.I0(this.f7167i1);
                        constraintWidget3.H0(f11);
                    }
                    if (i15 == i13 - 1) {
                        constraintWidget3.k(constraintWidget3.R, this.R, v1());
                    }
                    if (i15 > 0 && constraintWidget2 != null) {
                        constraintWidget3.k(constraintWidget3.P, constraintWidget2.R, this.f7179u1);
                        constraintWidget2.k(constraintWidget2.R, constraintWidget3.P, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
                i15++;
                f12 = f11;
            }
            for (int i16 = 0; i16 < i14; i16++) {
                ConstraintWidget constraintWidget4 = this.C1[i16];
                if (!(constraintWidget4 == null || constraintWidget4.T() == 8)) {
                    if (i16 == 0) {
                        constraintWidget4.k(constraintWidget4.Q, this.Q, w1());
                        constraintWidget4.Z0(this.f7168j1);
                        constraintWidget4.Y0(this.f7174p1);
                    }
                    if (i16 == i14 - 1) {
                        constraintWidget4.k(constraintWidget4.S, this.S, t1());
                    }
                    if (i16 > 0 && constraintWidget2 != null) {
                        constraintWidget4.k(constraintWidget4.Q, constraintWidget2.S, this.f7180v1);
                        constraintWidget2.k(constraintWidget2.S, constraintWidget4.Q, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i17 = 0; i17 < i13; i17++) {
                for (int i18 = 0; i18 < i14; i18++) {
                    int i19 = (i18 * i13) + i17;
                    if (this.A1 == 1) {
                        i19 = (i17 * i14) + i18;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.F1;
                    if (!(i19 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i19]) == null || constraintWidget.T() == 8)) {
                        ConstraintWidget constraintWidget5 = this.D1[i17];
                        ConstraintWidget constraintWidget6 = this.C1[i18];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.k(constraintWidget.P, constraintWidget5.P, 0);
                            constraintWidget.k(constraintWidget.R, constraintWidget5.R, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.k(constraintWidget.Q, constraintWidget6.Q, 0);
                            constraintWidget.k(constraintWidget.S, constraintWidget6.S, 0);
                        }
                    }
                }
            }
        }
    }

    public final int f2(ConstraintWidget constraintWidget, int i11) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i12 = constraintWidget.f7132w;
            if (i12 == 0) {
                return 0;
            }
            if (i12 == 2) {
                int i13 = (int) (constraintWidget.D * ((float) i11));
                if (i13 != constraintWidget.y()) {
                    constraintWidget.T0(true);
                    y1(constraintWidget, constraintWidget.B(), constraintWidget.U(), ConstraintWidget.DimensionBehaviour.FIXED, i13);
                }
                return i13;
            } else if (i12 == 1) {
                return constraintWidget.y();
            } else {
                if (i12 == 3) {
                    return (int) ((((float) constraintWidget.U()) * constraintWidget.f7097e0) + 0.5f);
                }
            }
        }
        return constraintWidget.y();
    }

    public void g(LinearSystem linearSystem, boolean z11) {
        super.g(linearSystem, z11);
        boolean z12 = L() != null && ((ConstraintWidgetContainer) L()).L1();
        int i11 = this.f7183y1;
        if (i11 != 0) {
            if (i11 == 1) {
                int size = this.B1.size();
                int i12 = 0;
                while (i12 < size) {
                    this.B1.get(i12).d(z12, i12, i12 == size + -1);
                    i12++;
                }
            } else if (i11 == 2) {
                e2(z12);
            }
        } else if (this.B1.size() > 0) {
            this.B1.get(0).d(z12, 0, true);
        }
        B1(false);
    }

    public final int g2(ConstraintWidget constraintWidget, int i11) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i12 = constraintWidget.f7130v;
            if (i12 == 0) {
                return 0;
            }
            if (i12 == 2) {
                int i13 = (int) (constraintWidget.A * ((float) i11));
                if (i13 != constraintWidget.U()) {
                    constraintWidget.T0(true);
                    y1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i13, constraintWidget.R(), constraintWidget.y());
                }
                return i13;
            } else if (i12 == 1) {
                return constraintWidget.U();
            } else {
                if (i12 == 3) {
                    return (int) ((((float) constraintWidget.y()) * constraintWidget.f7097e0) + 0.5f);
                }
            }
        }
        return constraintWidget.U();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x012b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    public final void h2(androidx.constraintlayout.core.widgets.ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = 0
            if (r3 != 0) goto L_0x0030
            int r6 = r0.f7184z1
            if (r6 > 0) goto L_0x002d
            r6 = r5
            r7 = r6
            r8 = r7
        L_0x0014:
            if (r7 >= r2) goto L_0x002d
            if (r7 <= 0) goto L_0x001b
            int r9 = r0.f7179u1
            int r8 = r8 + r9
        L_0x001b:
            r9 = r1[r7]
            if (r9 != 0) goto L_0x0020
            goto L_0x002a
        L_0x0020:
            int r9 = r0.g2(r9, r4)
            int r8 = r8 + r9
            if (r8 <= r4) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            int r6 = r6 + 1
        L_0x002a:
            int r7 = r7 + 1
            goto L_0x0014
        L_0x002d:
            r7 = r6
            r6 = r5
            goto L_0x0051
        L_0x0030:
            int r6 = r0.f7184z1
            if (r6 > 0) goto L_0x0050
            r6 = r5
            r7 = r6
            r8 = r7
        L_0x0037:
            if (r7 >= r2) goto L_0x0050
            if (r7 <= 0) goto L_0x003e
            int r9 = r0.f7180v1
            int r8 = r8 + r9
        L_0x003e:
            r9 = r1[r7]
            if (r9 != 0) goto L_0x0043
            goto L_0x004d
        L_0x0043:
            int r9 = r0.f2(r9, r4)
            int r8 = r8 + r9
            if (r8 <= r4) goto L_0x004b
            goto L_0x0050
        L_0x004b:
            int r6 = r6 + 1
        L_0x004d:
            int r7 = r7 + 1
            goto L_0x0037
        L_0x0050:
            r7 = r5
        L_0x0051:
            int[] r8 = r0.E1
            if (r8 != 0) goto L_0x005a
            r8 = 2
            int[] r8 = new int[r8]
            r0.E1 = r8
        L_0x005a:
            r8 = 1
            if (r6 != 0) goto L_0x005f
            if (r3 == r8) goto L_0x0063
        L_0x005f:
            if (r7 != 0) goto L_0x0065
            if (r3 != 0) goto L_0x0065
        L_0x0063:
            r9 = r8
            goto L_0x0066
        L_0x0065:
            r9 = r5
        L_0x0066:
            if (r9 != 0) goto L_0x012b
            if (r3 != 0) goto L_0x0074
            float r6 = (float) r2
            float r10 = (float) r7
            float r6 = r6 / r10
            double r10 = (double) r6
            double r10 = java.lang.Math.ceil(r10)
            int r6 = (int) r10
            goto L_0x007d
        L_0x0074:
            float r7 = (float) r2
            float r10 = (float) r6
            float r7 = r7 / r10
            double r10 = (double) r7
            double r10 = java.lang.Math.ceil(r10)
            int r7 = (int) r10
        L_0x007d:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r0.D1
            r11 = 0
            if (r10 == 0) goto L_0x008a
            int r12 = r10.length
            if (r12 >= r7) goto L_0x0086
            goto L_0x008a
        L_0x0086:
            java.util.Arrays.fill(r10, r11)
            goto L_0x008e
        L_0x008a:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r7]
            r0.D1 = r10
        L_0x008e:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r0.C1
            if (r10 == 0) goto L_0x009a
            int r12 = r10.length
            if (r12 >= r6) goto L_0x0096
            goto L_0x009a
        L_0x0096:
            java.util.Arrays.fill(r10, r11)
            goto L_0x009e
        L_0x009a:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r6]
            r0.C1 = r10
        L_0x009e:
            r10 = r5
        L_0x009f:
            if (r10 >= r7) goto L_0x00e7
            r11 = r5
        L_0x00a2:
            if (r11 >= r6) goto L_0x00e4
            int r12 = r11 * r7
            int r12 = r12 + r10
            if (r3 != r8) goto L_0x00ac
            int r12 = r10 * r6
            int r12 = r12 + r11
        L_0x00ac:
            int r13 = r1.length
            if (r12 < r13) goto L_0x00b0
            goto L_0x00e1
        L_0x00b0:
            r12 = r1[r12]
            if (r12 != 0) goto L_0x00b5
            goto L_0x00e1
        L_0x00b5:
            int r13 = r0.g2(r12, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r0.D1
            r15 = r14[r10]
            if (r15 == 0) goto L_0x00c7
            r14 = r14[r10]
            int r14 = r14.U()
            if (r14 >= r13) goto L_0x00cb
        L_0x00c7:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r0.D1
            r13[r10] = r12
        L_0x00cb:
            int r13 = r0.f2(r12, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r0.C1
            r15 = r14[r11]
            if (r15 == 0) goto L_0x00dd
            r14 = r14[r11]
            int r14 = r14.y()
            if (r14 >= r13) goto L_0x00e1
        L_0x00dd:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r0.C1
            r13[r11] = r12
        L_0x00e1:
            int r11 = r11 + 1
            goto L_0x00a2
        L_0x00e4:
            int r10 = r10 + 1
            goto L_0x009f
        L_0x00e7:
            r10 = r5
            r11 = r10
        L_0x00e9:
            if (r10 >= r7) goto L_0x00fe
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r12 = r0.D1
            r12 = r12[r10]
            if (r12 == 0) goto L_0x00fb
            if (r10 <= 0) goto L_0x00f6
            int r13 = r0.f7179u1
            int r11 = r11 + r13
        L_0x00f6:
            int r12 = r0.g2(r12, r4)
            int r11 = r11 + r12
        L_0x00fb:
            int r10 = r10 + 1
            goto L_0x00e9
        L_0x00fe:
            r10 = r5
            r12 = r10
        L_0x0100:
            if (r10 >= r6) goto L_0x0115
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r0.C1
            r13 = r13[r10]
            if (r13 == 0) goto L_0x0112
            if (r10 <= 0) goto L_0x010d
            int r14 = r0.f7180v1
            int r12 = r12 + r14
        L_0x010d:
            int r13 = r0.f2(r13, r4)
            int r12 = r12 + r13
        L_0x0112:
            int r10 = r10 + 1
            goto L_0x0100
        L_0x0115:
            r21[r5] = r11
            r21[r8] = r12
            if (r3 != 0) goto L_0x0123
            if (r11 <= r4) goto L_0x0063
            if (r7 <= r8) goto L_0x0063
            int r7 = r7 + -1
            goto L_0x0066
        L_0x0123:
            if (r12 <= r4) goto L_0x0063
            if (r6 <= r8) goto L_0x0063
            int r6 = r6 + -1
            goto L_0x0066
        L_0x012b:
            int[] r1 = r0.E1
            r1[r5] = r7
            r1[r8] = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.h2(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    public final void i2(ConstraintWidget[] constraintWidgetArr, int i11, int i12, int i13, int[] iArr) {
        int i14;
        ConstraintAnchor constraintAnchor;
        int i15;
        int i16;
        int i17;
        ConstraintAnchor constraintAnchor2;
        int i18;
        int i19;
        int i21 = i11;
        int i22 = i13;
        if (i21 != 0) {
            this.B1.clear();
            a aVar = new a(i12, this.P, this.Q, this.R, this.S, i13);
            this.B1.add(aVar);
            if (i12 == 0) {
                i14 = 0;
                int i23 = 0;
                int i24 = 0;
                while (i24 < i21) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i24];
                    int g22 = g2(constraintWidget, i22);
                    if (constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i14++;
                    }
                    int i25 = i14;
                    boolean z11 = (i23 == i22 || (this.f7179u1 + i23) + g22 > i22) && aVar.f7186b != null;
                    if (!z11 && i24 > 0 && (i19 = this.f7184z1) > 0 && i24 % i19 == 0) {
                        z11 = true;
                    }
                    if (z11) {
                        aVar = new a(i12, this.P, this.Q, this.R, this.S, i13);
                        aVar.i(i24);
                        this.B1.add(aVar);
                    } else if (i24 > 0) {
                        i23 += this.f7179u1 + g22;
                        aVar.b(constraintWidget);
                        i24++;
                        i14 = i25;
                    }
                    i23 = g22;
                    aVar.b(constraintWidget);
                    i24++;
                    i14 = i25;
                }
            } else {
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                while (i28 < i21) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i28];
                    int f22 = f2(constraintWidget2, i22);
                    if (constraintWidget2.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i14++;
                    }
                    int i29 = i14;
                    boolean z12 = (i27 == i22 || (this.f7180v1 + i27) + f22 > i22) && aVar.f7186b != null;
                    if (!z12 && i28 > 0 && (i18 = this.f7184z1) > 0 && i28 % i18 == 0) {
                        z12 = true;
                    }
                    if (z12) {
                        aVar = new a(i12, this.P, this.Q, this.R, this.S, i13);
                        aVar.i(i28);
                        this.B1.add(aVar);
                    } else if (i28 > 0) {
                        i27 += this.f7180v1 + f22;
                        aVar.b(constraintWidget2);
                        i28++;
                        i26 = i29;
                    }
                    i27 = f22;
                    aVar.b(constraintWidget2);
                    i28++;
                    i26 = i29;
                }
            }
            int size = this.B1.size();
            ConstraintAnchor constraintAnchor3 = this.P;
            ConstraintAnchor constraintAnchor4 = this.Q;
            ConstraintAnchor constraintAnchor5 = this.R;
            ConstraintAnchor constraintAnchor6 = this.S;
            int u12 = u1();
            int w12 = w1();
            int v12 = v1();
            int t12 = t1();
            ConstraintWidget.DimensionBehaviour B = B();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z13 = B == dimensionBehaviour || R() == dimensionBehaviour;
            if (i14 > 0 && z13) {
                for (int i30 = 0; i30 < size; i30++) {
                    a aVar2 = this.B1.get(i30);
                    if (i12 == 0) {
                        aVar2.g(i22 - aVar2.f());
                    } else {
                        aVar2.g(i22 - aVar2.e());
                    }
                }
            }
            int i31 = w12;
            int i32 = v12;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = u12;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i37 = t12;
            while (i35 < size) {
                a aVar3 = this.B1.get(i35);
                if (i12 == 0) {
                    if (i35 < size - 1) {
                        constraintAnchor2 = this.B1.get(i35 + 1).f7186b.Q;
                        i17 = 0;
                    } else {
                        constraintAnchor2 = this.S;
                        i17 = t1();
                    }
                    ConstraintAnchor constraintAnchor9 = aVar3.f7186b.S;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i38 = i33;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i39 = i34;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i15 = i35;
                    aVar3.j(i12, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i36, i31, i32, i17, i13);
                    int max = Math.max(i39, aVar3.f());
                    i33 = i38 + aVar3.e();
                    if (i15 > 0) {
                        i33 += this.f7180v1;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i34 = max;
                    i31 = 0;
                    constraintAnchor7 = constraintAnchor9;
                    constraintAnchor = constraintAnchor14;
                    int i40 = i17;
                    constraintAnchor6 = constraintAnchor2;
                    i37 = i40;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i41 = i33;
                    int i42 = i34;
                    i15 = i35;
                    if (i15 < size - 1) {
                        constraintAnchor = this.B1.get(i15 + 1).f7186b.P;
                        i16 = 0;
                    } else {
                        constraintAnchor = this.R;
                        i16 = v1();
                    }
                    ConstraintAnchor constraintAnchor16 = aVar3.f7186b.R;
                    aVar3.j(i12, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i36, i31, i16, i37, i13);
                    i34 = i42 + aVar3.f();
                    int max2 = Math.max(i41, aVar3.e());
                    if (i15 > 0) {
                        i34 += this.f7179u1;
                    }
                    i33 = max2;
                    i36 = 0;
                    i32 = i16;
                    constraintAnchor8 = constraintAnchor16;
                }
                i35 = i15 + 1;
                int i43 = i13;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i34;
            iArr[1] = i33;
        }
    }

    public final void j2(ConstraintWidget[] constraintWidgetArr, int i11, int i12, int i13, int[] iArr) {
        a aVar;
        int i14 = i11;
        if (i14 != 0) {
            if (this.B1.size() == 0) {
                aVar = new a(i12, this.P, this.Q, this.R, this.S, i13);
                this.B1.add(aVar);
            } else {
                a aVar2 = this.B1.get(0);
                aVar2.c();
                aVar = aVar2;
                aVar.j(i12, this.P, this.Q, this.R, this.S, u1(), w1(), v1(), t1(), i13);
            }
            for (int i15 = 0; i15 < i14; i15++) {
                aVar.b(constraintWidgetArr[i15]);
            }
            iArr[0] = aVar.f();
            iArr[1] = aVar.e();
        }
    }

    public void k2(float f11) {
        this.f7175q1 = f11;
    }

    public void l2(int i11) {
        this.f7169k1 = i11;
    }

    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.m(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.f7167i1 = flow.f7167i1;
        this.f7168j1 = flow.f7168j1;
        this.f7169k1 = flow.f7169k1;
        this.f7170l1 = flow.f7170l1;
        this.f7171m1 = flow.f7171m1;
        this.f7172n1 = flow.f7172n1;
        this.f7173o1 = flow.f7173o1;
        this.f7174p1 = flow.f7174p1;
        this.f7175q1 = flow.f7175q1;
        this.f7176r1 = flow.f7176r1;
        this.f7177s1 = flow.f7177s1;
        this.f7178t1 = flow.f7178t1;
        this.f7179u1 = flow.f7179u1;
        this.f7180v1 = flow.f7180v1;
        this.f7181w1 = flow.f7181w1;
        this.f7182x1 = flow.f7182x1;
        this.f7183y1 = flow.f7183y1;
        this.f7184z1 = flow.f7184z1;
        this.A1 = flow.A1;
    }

    public void m2(float f11) {
        this.f7176r1 = f11;
    }

    public void n2(int i11) {
        this.f7170l1 = i11;
    }

    public void o2(int i11) {
        this.f7181w1 = i11;
    }

    public void p2(float f11) {
        this.f7173o1 = f11;
    }

    public void q2(int i11) {
        this.f7179u1 = i11;
    }

    public void r2(int i11) {
        this.f7167i1 = i11;
    }

    public void s2(float f11) {
        this.f7177s1 = f11;
    }

    public void t2(int i11) {
        this.f7171m1 = i11;
    }

    public void u2(float f11) {
        this.f7178t1 = f11;
    }

    public void v2(int i11) {
        this.f7172n1 = i11;
    }

    public void w2(int i11) {
        this.f7184z1 = i11;
    }

    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x1(int r19, int r20, int r21, int r22) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            int r0 = r6.U0
            r11 = 0
            if (r0 <= 0) goto L_0x001c
            boolean r0 = r18.z1()
            if (r0 != 0) goto L_0x001c
            r6.C1(r11, r11)
            r6.B1(r11)
            return
        L_0x001c:
            int r12 = r18.u1()
            int r13 = r18.v1()
            int r14 = r18.w1()
            int r15 = r18.t1()
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r8 - r12
            int r1 = r1 - r13
            int r2 = r6.A1
            r4 = 1
            if (r2 != r4) goto L_0x003a
            int r1 = r10 - r14
            int r1 = r1 - r15
        L_0x003a:
            r16 = r1
            r1 = -1
            if (r2 != 0) goto L_0x004c
            int r2 = r6.f7167i1
            if (r2 != r1) goto L_0x0045
            r6.f7167i1 = r11
        L_0x0045:
            int r2 = r6.f7168j1
            if (r2 != r1) goto L_0x0058
            r6.f7168j1 = r11
            goto L_0x0058
        L_0x004c:
            int r2 = r6.f7167i1
            if (r2 != r1) goto L_0x0052
            r6.f7167i1 = r11
        L_0x0052:
            int r2 = r6.f7168j1
            if (r2 != r1) goto L_0x0058
            r6.f7168j1 = r11
        L_0x0058:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r6.T0
            r2 = r11
            r3 = r2
        L_0x005c:
            int r11 = r6.U0
            r0 = 8
            if (r2 >= r11) goto L_0x0072
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.T0
            r11 = r11[r2]
            int r11 = r11.T()
            if (r11 != r0) goto L_0x006e
            int r3 = r3 + 1
        L_0x006e:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x005c
        L_0x0072:
            if (r3 <= 0) goto L_0x0091
            int r11 = r11 - r3
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r11]
            r2 = 0
            r3 = 0
        L_0x0079:
            int r11 = r6.U0
            if (r2 >= r11) goto L_0x008f
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.T0
            r11 = r11[r2]
            int r4 = r11.T()
            if (r4 == r0) goto L_0x008b
            r1[r3] = r11
            int r3 = r3 + 1
        L_0x008b:
            int r2 = r2 + 1
            r4 = 1
            goto L_0x0079
        L_0x008f:
            r2 = r3
            goto L_0x0092
        L_0x0091:
            r2 = r11
        L_0x0092:
            r6.F1 = r1
            r6.G1 = r2
            int r0 = r6.f7183y1
            if (r0 == 0) goto L_0x00bf
            r4 = 1
            if (r0 == r4) goto L_0x00b2
            r3 = 2
            if (r0 == r3) goto L_0x00a5
            r11 = r4
            r17 = r5
        L_0x00a3:
            r0 = 0
            goto L_0x00cc
        L_0x00a5:
            int r3 = r6.A1
            r0 = r18
            r11 = r4
            r4 = r16
            r17 = r5
            r0.h2(r1, r2, r3, r4, r5)
            goto L_0x00a3
        L_0x00b2:
            r11 = r4
            r17 = r5
            int r3 = r6.A1
            r0 = r18
            r4 = r16
            r0.i2(r1, r2, r3, r4, r5)
            goto L_0x00a3
        L_0x00bf:
            r17 = r5
            r11 = 1
            int r3 = r6.A1
            r0 = r18
            r4 = r16
            r0.j2(r1, r2, r3, r4, r5)
            goto L_0x00a3
        L_0x00cc:
            r1 = r17[r0]
            int r1 = r1 + r12
            int r1 = r1 + r13
            r2 = r17[r11]
            int r2 = r2 + r14
            int r2 = r2 + r15
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r7 != r4) goto L_0x00dc
            r1 = r8
            goto L_0x00e7
        L_0x00dc:
            if (r7 != r3) goto L_0x00e3
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x00e7
        L_0x00e3:
            if (r7 != 0) goto L_0x00e6
            goto L_0x00e7
        L_0x00e6:
            r1 = r0
        L_0x00e7:
            if (r9 != r4) goto L_0x00eb
            r2 = r10
            goto L_0x00f6
        L_0x00eb:
            if (r9 != r3) goto L_0x00f2
            int r2 = java.lang.Math.min(r2, r10)
            goto L_0x00f6
        L_0x00f2:
            if (r9 != 0) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r2 = r0
        L_0x00f6:
            r6.C1(r1, r2)
            r6.f1(r1)
            r6.G0(r2)
            int r1 = r6.U0
            if (r1 <= 0) goto L_0x0104
            goto L_0x0105
        L_0x0104:
            r11 = r0
        L_0x0105:
            r6.B1(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.x1(int, int, int, int):void");
    }

    public void x2(int i11) {
        this.A1 = i11;
    }

    public void y2(int i11) {
        this.f7182x1 = i11;
    }

    public void z2(float f11) {
        this.f7174p1 = f11;
    }
}
