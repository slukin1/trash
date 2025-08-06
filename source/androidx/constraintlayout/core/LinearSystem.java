package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {

    /* renamed from: r  reason: collision with root package name */
    public static boolean f6551r = false;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f6552s = true;

    /* renamed from: t  reason: collision with root package name */
    public static boolean f6553t = true;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f6554u = true;

    /* renamed from: v  reason: collision with root package name */
    public static boolean f6555v = false;

    /* renamed from: w  reason: collision with root package name */
    public static int f6556w = 1000;

    /* renamed from: x  reason: collision with root package name */
    public static Metrics f6557x;

    /* renamed from: y  reason: collision with root package name */
    public static long f6558y;

    /* renamed from: z  reason: collision with root package name */
    public static long f6559z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6560a;

    /* renamed from: b  reason: collision with root package name */
    public int f6561b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, SolverVariable> f6562c;

    /* renamed from: d  reason: collision with root package name */
    public a f6563d;

    /* renamed from: e  reason: collision with root package name */
    public int f6564e;

    /* renamed from: f  reason: collision with root package name */
    public int f6565f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayRow[] f6566g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6567h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6568i;

    /* renamed from: j  reason: collision with root package name */
    public boolean[] f6569j;

    /* renamed from: k  reason: collision with root package name */
    public int f6570k;

    /* renamed from: l  reason: collision with root package name */
    public int f6571l;

    /* renamed from: m  reason: collision with root package name */
    public int f6572m;

    /* renamed from: n  reason: collision with root package name */
    public final Cache f6573n;

    /* renamed from: o  reason: collision with root package name */
    public SolverVariable[] f6574o;

    /* renamed from: p  reason: collision with root package name */
    public int f6575p;

    /* renamed from: q  reason: collision with root package name */
    public a f6576q;

    public interface a {
        SolverVariable a(LinearSystem linearSystem, boolean[] zArr);

        void b(a aVar);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    public class b extends ArrayRow {
        public b(Cache cache) {
            this.f6545e = new c(this, cache);
        }
    }

    public LinearSystem() {
        this.f6560a = false;
        this.f6561b = 0;
        this.f6562c = null;
        this.f6564e = 32;
        this.f6565f = 32;
        this.f6566g = null;
        this.f6567h = false;
        this.f6568i = false;
        this.f6569j = new boolean[32];
        this.f6570k = 1;
        this.f6571l = 0;
        this.f6572m = 32;
        this.f6574o = new SolverVariable[f6556w];
        this.f6575p = 0;
        this.f6566g = new ArrayRow[32];
        D();
        Cache cache = new Cache();
        this.f6573n = cache;
        this.f6563d = new b(cache);
        if (f6555v) {
            this.f6576q = new b(cache);
        } else {
            this.f6576q = new ArrayRow(cache);
        }
    }

    public static ArrayRow s(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f11) {
        return linearSystem.r().j(solverVariable, solverVariable2, f11);
    }

    public static Metrics x() {
        return f6557x;
    }

    public void A() throws Exception {
        Metrics metrics = f6557x;
        if (metrics != null) {
            metrics.f6582e++;
        }
        if (this.f6563d.isEmpty()) {
            n();
        } else if (this.f6567h || this.f6568i) {
            Metrics metrics2 = f6557x;
            if (metrics2 != null) {
                metrics2.f6594q++;
            }
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= this.f6571l) {
                    z11 = true;
                    break;
                } else if (!this.f6566g[i11].f6546f) {
                    break;
                } else {
                    i11++;
                }
            }
            if (!z11) {
                B(this.f6563d);
                return;
            }
            Metrics metrics3 = f6557x;
            if (metrics3 != null) {
                metrics3.f6593p++;
            }
            n();
        } else {
            B(this.f6563d);
        }
    }

    public void B(a aVar) throws Exception {
        Metrics metrics = f6557x;
        if (metrics != null) {
            metrics.f6597t++;
            metrics.f6598u = Math.max(metrics.f6598u, (long) this.f6570k);
            Metrics metrics2 = f6557x;
            metrics2.f6599v = Math.max(metrics2.f6599v, (long) this.f6571l);
        }
        u(aVar);
        C(aVar, false);
        n();
    }

    public final int C(a aVar, boolean z11) {
        Metrics metrics = f6557x;
        if (metrics != null) {
            metrics.f6585h++;
        }
        for (int i11 = 0; i11 < this.f6570k; i11++) {
            this.f6569j[i11] = false;
        }
        boolean z12 = false;
        int i12 = 0;
        while (!z12) {
            Metrics metrics2 = f6557x;
            if (metrics2 != null) {
                metrics2.f6586i++;
            }
            i12++;
            if (i12 >= this.f6570k * 2) {
                return i12;
            }
            if (aVar.getKey() != null) {
                this.f6569j[aVar.getKey().f6607d] = true;
            }
            SolverVariable a11 = aVar.a(this, this.f6569j);
            if (a11 != null) {
                boolean[] zArr = this.f6569j;
                int i13 = a11.f6607d;
                if (zArr[i13]) {
                    return i12;
                }
                zArr[i13] = true;
            }
            if (a11 != null) {
                float f11 = Float.MAX_VALUE;
                int i14 = -1;
                for (int i15 = 0; i15 < this.f6571l; i15++) {
                    ArrayRow arrayRow = this.f6566g[i15];
                    if (arrayRow.f6541a.f6614k != SolverVariable.Type.UNRESTRICTED && !arrayRow.f6546f && arrayRow.t(a11)) {
                        float d11 = arrayRow.f6545e.d(a11);
                        if (d11 < 0.0f) {
                            float f12 = (-arrayRow.f6542b) / d11;
                            if (f12 < f11) {
                                i14 = i15;
                                f11 = f12;
                            }
                        }
                    }
                }
                if (i14 > -1) {
                    ArrayRow arrayRow2 = this.f6566g[i14];
                    arrayRow2.f6541a.f6608e = -1;
                    Metrics metrics3 = f6557x;
                    if (metrics3 != null) {
                        metrics3.f6587j++;
                    }
                    arrayRow2.x(a11);
                    SolverVariable solverVariable = arrayRow2.f6541a;
                    solverVariable.f6608e = i14;
                    solverVariable.i(this, arrayRow2);
                }
            } else {
                z12 = true;
            }
        }
        return i12;
    }

    public final void D() {
        int i11 = 0;
        if (f6555v) {
            while (i11 < this.f6571l) {
                ArrayRow arrayRow = this.f6566g[i11];
                if (arrayRow != null) {
                    this.f6573n.f6547a.release(arrayRow);
                }
                this.f6566g[i11] = null;
                i11++;
            }
            return;
        }
        while (i11 < this.f6571l) {
            ArrayRow arrayRow2 = this.f6566g[i11];
            if (arrayRow2 != null) {
                this.f6573n.f6548b.release(arrayRow2);
            }
            this.f6566g[i11] = null;
            i11++;
        }
    }

    public void E() {
        Cache cache;
        int i11 = 0;
        while (true) {
            cache = this.f6573n;
            SolverVariable[] solverVariableArr = cache.f6550d;
            if (i11 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i11];
            if (solverVariable != null) {
                solverVariable.f();
            }
            i11++;
        }
        cache.f6549c.a(this.f6574o, this.f6575p);
        this.f6575p = 0;
        Arrays.fill(this.f6573n.f6550d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f6562c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f6561b = 0;
        this.f6563d.clear();
        this.f6570k = 1;
        for (int i12 = 0; i12 < this.f6571l; i12++) {
            ArrayRow[] arrayRowArr = this.f6566g;
            if (arrayRowArr[i12] != null) {
                arrayRowArr[i12].f6543c = false;
            }
        }
        D();
        this.f6571l = 0;
        if (f6555v) {
            this.f6576q = new b(this.f6573n);
        } else {
            this.f6576q = new ArrayRow(this.f6573n);
        }
    }

    public final SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.f6573n.f6549c.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.h(type, str);
        } else {
            acquire.f();
            acquire.h(type, str);
        }
        int i11 = this.f6575p;
        int i12 = f6556w;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            f6556w = i13;
            this.f6574o = (SolverVariable[]) Arrays.copyOf(this.f6574o, i13);
        }
        SolverVariable[] solverVariableArr = this.f6574o;
        int i14 = this.f6575p;
        this.f6575p = i14 + 1;
        solverVariableArr[i14] = acquire;
        return acquire;
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f11, int i11) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable q11 = q(constraintWidget3.p(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable q12 = q(constraintWidget3.p(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable q13 = q(constraintWidget3.p(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable q14 = q(constraintWidget3.p(type4));
        SolverVariable q15 = q(constraintWidget4.p(type));
        SolverVariable q16 = q(constraintWidget4.p(type2));
        SolverVariable q17 = q(constraintWidget4.p(type3));
        SolverVariable q18 = q(constraintWidget4.p(type4));
        ArrayRow r11 = r();
        double d11 = (double) f11;
        SolverVariable solverVariable = q17;
        double d12 = (double) i11;
        r11.q(q12, q14, q16, q18, (float) (Math.sin(d11) * d12));
        d(r11);
        ArrayRow r12 = r();
        r12.q(q11, q13, q15, solverVariable, (float) (Math.cos(d11) * d12));
        d(r12);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, float f11, SolverVariable solverVariable3, SolverVariable solverVariable4, int i12, int i13) {
        int i14 = i13;
        ArrayRow r11 = r();
        r11.h(solverVariable, solverVariable2, i11, f11, solverVariable3, solverVariable4, i12);
        if (i14 != 8) {
            r11.d(this, i14);
        }
        d(r11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.constraintlayout.core.Metrics r0 = f6557x
            r1 = 1
            if (r0 == 0) goto L_0x0017
            long r3 = r0.f6583f
            long r3 = r3 + r1
            r0.f6583f = r3
            boolean r3 = r8.f6546f
            if (r3 == 0) goto L_0x0017
            long r3 = r0.f6584g
            long r3 = r3 + r1
            r0.f6584g = r3
        L_0x0017:
            int r0 = r7.f6571l
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.f6572m
            if (r0 >= r4) goto L_0x0026
            int r0 = r7.f6570k
            int r0 = r0 + r3
            int r4 = r7.f6565f
            if (r0 < r4) goto L_0x0029
        L_0x0026:
            r7.z()
        L_0x0029:
            r0 = 0
            boolean r4 = r8.f6546f
            if (r4 != 0) goto L_0x00a1
            r8.D(r7)
            boolean r4 = r8.isEmpty()
            if (r4 == 0) goto L_0x0038
            return
        L_0x0038:
            r8.r()
            boolean r4 = r8.f(r7)
            if (r4 == 0) goto L_0x0098
            androidx.constraintlayout.core.SolverVariable r4 = r7.p()
            r8.f6541a = r4
            int r5 = r7.f6571l
            r7.l(r8)
            int r6 = r7.f6571l
            int r5 = r5 + r3
            if (r6 != r5) goto L_0x0098
            androidx.constraintlayout.core.LinearSystem$a r0 = r7.f6576q
            r0.b(r8)
            androidx.constraintlayout.core.LinearSystem$a r0 = r7.f6576q
            r7.C(r0, r3)
            int r0 = r4.f6608e
            r5 = -1
            if (r0 != r5) goto L_0x0099
            androidx.constraintlayout.core.SolverVariable r0 = r8.f6541a
            if (r0 != r4) goto L_0x0076
            androidx.constraintlayout.core.SolverVariable r0 = r8.v(r4)
            if (r0 == 0) goto L_0x0076
            androidx.constraintlayout.core.Metrics r4 = f6557x
            if (r4 == 0) goto L_0x0073
            long r5 = r4.f6587j
            long r5 = r5 + r1
            r4.f6587j = r5
        L_0x0073:
            r8.x(r0)
        L_0x0076:
            boolean r0 = r8.f6546f
            if (r0 != 0) goto L_0x007f
            androidx.constraintlayout.core.SolverVariable r0 = r8.f6541a
            r0.i(r7, r8)
        L_0x007f:
            boolean r0 = f6555v
            if (r0 == 0) goto L_0x008b
            androidx.constraintlayout.core.Cache r0 = r7.f6573n
            j0.a<androidx.constraintlayout.core.ArrayRow> r0 = r0.f6547a
            r0.release(r8)
            goto L_0x0092
        L_0x008b:
            androidx.constraintlayout.core.Cache r0 = r7.f6573n
            j0.a<androidx.constraintlayout.core.ArrayRow> r0 = r0.f6548b
            r0.release(r8)
        L_0x0092:
            int r0 = r7.f6571l
            int r0 = r0 - r3
            r7.f6571l = r0
            goto L_0x0099
        L_0x0098:
            r3 = r0
        L_0x0099:
            boolean r0 = r8.s()
            if (r0 != 0) goto L_0x00a0
            return
        L_0x00a0:
            r0 = r3
        L_0x00a1:
            if (r0 != 0) goto L_0x00a6
            r7.l(r8)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.d(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow e(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        if (!f6552s || i12 != 8 || !solverVariable2.f6611h || solverVariable.f6608e != -1) {
            ArrayRow r11 = r();
            r11.n(solverVariable, solverVariable2, i11);
            if (i12 != 8) {
                r11.d(this, i12);
            }
            d(r11);
            return r11;
        }
        solverVariable.g(this, solverVariable2.f6610g + ((float) i11));
        return null;
    }

    public void f(SolverVariable solverVariable, int i11) {
        if (!f6552s || solverVariable.f6608e != -1) {
            int i12 = solverVariable.f6608e;
            if (i12 != -1) {
                ArrayRow arrayRow = this.f6566g[i12];
                if (arrayRow.f6546f) {
                    arrayRow.f6542b = (float) i11;
                } else if (arrayRow.f6545e.h() == 0) {
                    arrayRow.f6546f = true;
                    arrayRow.f6542b = (float) i11;
                } else {
                    ArrayRow r11 = r();
                    r11.m(solverVariable, i11);
                    d(r11);
                }
            } else {
                ArrayRow r12 = r();
                r12.i(solverVariable, i11);
                d(r12);
            }
        } else {
            float f11 = (float) i11;
            solverVariable.g(this, f11);
            for (int i13 = 0; i13 < this.f6561b + 1; i13++) {
                SolverVariable solverVariable2 = this.f6573n.f6550d[i13];
                if (solverVariable2 != null && solverVariable2.f6618o && solverVariable2.f6619p == solverVariable.f6607d) {
                    solverVariable2.g(this, solverVariable2.f6620q + f11);
                }
            }
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, boolean z11) {
        ArrayRow r11 = r();
        SolverVariable t11 = t();
        t11.f6609f = 0;
        r11.o(solverVariable, solverVariable2, t11, i11);
        d(r11);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        ArrayRow r11 = r();
        SolverVariable t11 = t();
        t11.f6609f = 0;
        r11.o(solverVariable, solverVariable2, t11, i11);
        if (i12 != 8) {
            m(r11, (int) (r11.f6545e.d(t11) * -1.0f), i12);
        }
        d(r11);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, boolean z11) {
        ArrayRow r11 = r();
        SolverVariable t11 = t();
        t11.f6609f = 0;
        r11.p(solverVariable, solverVariable2, t11, i11);
        d(r11);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        ArrayRow r11 = r();
        SolverVariable t11 = t();
        t11.f6609f = 0;
        r11.p(solverVariable, solverVariable2, t11, i11);
        if (i12 != 8) {
            m(r11, (int) (r11.f6545e.d(t11) * -1.0f), i12);
        }
        d(r11);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11, int i11) {
        ArrayRow r11 = r();
        r11.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f11);
        if (i11 != 8) {
            r11.d(this, i11);
        }
        d(r11);
    }

    public final void l(ArrayRow arrayRow) {
        int i11;
        if (!f6553t || !arrayRow.f6546f) {
            ArrayRow[] arrayRowArr = this.f6566g;
            int i12 = this.f6571l;
            arrayRowArr[i12] = arrayRow;
            SolverVariable solverVariable = arrayRow.f6541a;
            solverVariable.f6608e = i12;
            this.f6571l = i12 + 1;
            solverVariable.i(this, arrayRow);
        } else {
            arrayRow.f6541a.g(this, arrayRow.f6542b);
        }
        if (f6553t && this.f6560a) {
            int i13 = 0;
            while (i13 < this.f6571l) {
                if (this.f6566g[i13] == null) {
                    System.out.println("WTF");
                }
                ArrayRow[] arrayRowArr2 = this.f6566g;
                if (arrayRowArr2[i13] != null && arrayRowArr2[i13].f6546f) {
                    ArrayRow arrayRow2 = arrayRowArr2[i13];
                    arrayRow2.f6541a.g(this, arrayRow2.f6542b);
                    if (f6555v) {
                        this.f6573n.f6547a.release(arrayRow2);
                    } else {
                        this.f6573n.f6548b.release(arrayRow2);
                    }
                    this.f6566g[i13] = null;
                    int i14 = i13 + 1;
                    int i15 = i14;
                    while (true) {
                        i11 = this.f6571l;
                        if (i14 >= i11) {
                            break;
                        }
                        ArrayRow[] arrayRowArr3 = this.f6566g;
                        int i16 = i14 - 1;
                        arrayRowArr3[i16] = arrayRowArr3[i14];
                        if (arrayRowArr3[i16].f6541a.f6608e == i14) {
                            arrayRowArr3[i16].f6541a.f6608e = i16;
                        }
                        i15 = i14;
                        i14++;
                    }
                    if (i15 < i11) {
                        this.f6566g[i15] = null;
                    }
                    this.f6571l = i11 - 1;
                    i13--;
                }
                i13++;
            }
            this.f6560a = false;
        }
    }

    public void m(ArrayRow arrayRow, int i11, int i12) {
        arrayRow.e(o(i12, (String) null), i11);
    }

    public final void n() {
        for (int i11 = 0; i11 < this.f6571l; i11++) {
            ArrayRow arrayRow = this.f6566g[i11];
            arrayRow.f6541a.f6610g = arrayRow.f6542b;
        }
    }

    public SolverVariable o(int i11, String str) {
        Metrics metrics = f6557x;
        if (metrics != null) {
            metrics.f6589l++;
        }
        if (this.f6570k + 1 >= this.f6565f) {
            z();
        }
        SolverVariable a11 = a(SolverVariable.Type.ERROR, str);
        int i12 = this.f6561b + 1;
        this.f6561b = i12;
        this.f6570k++;
        a11.f6607d = i12;
        a11.f6609f = i11;
        this.f6573n.f6550d[i12] = a11;
        this.f6563d.c(a11);
        return a11;
    }

    public SolverVariable p() {
        Metrics metrics = f6557x;
        if (metrics != null) {
            metrics.f6591n++;
        }
        if (this.f6570k + 1 >= this.f6565f) {
            z();
        }
        SolverVariable a11 = a(SolverVariable.Type.SLACK, (String) null);
        int i11 = this.f6561b + 1;
        this.f6561b = i11;
        this.f6570k++;
        a11.f6607d = i11;
        this.f6573n.f6550d[i11] = a11;
        return a11;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f6570k + 1 >= this.f6565f) {
            z();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.i();
            if (solverVariable == null) {
                constraintAnchor.s(this.f6573n);
                solverVariable = constraintAnchor.i();
            }
            int i11 = solverVariable.f6607d;
            if (i11 == -1 || i11 > this.f6561b || this.f6573n.f6550d[i11] == null) {
                if (i11 != -1) {
                    solverVariable.f();
                }
                int i12 = this.f6561b + 1;
                this.f6561b = i12;
                this.f6570k++;
                solverVariable.f6607d = i12;
                solverVariable.f6614k = SolverVariable.Type.UNRESTRICTED;
                this.f6573n.f6550d[i12] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow r() {
        ArrayRow arrayRow;
        if (f6555v) {
            arrayRow = this.f6573n.f6547a.acquire();
            if (arrayRow == null) {
                arrayRow = new b(this.f6573n);
                f6559z++;
            } else {
                arrayRow.y();
            }
        } else {
            arrayRow = this.f6573n.f6548b.acquire();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.f6573n);
                f6558y++;
            } else {
                arrayRow.y();
            }
        }
        SolverVariable.c();
        return arrayRow;
    }

    public SolverVariable t() {
        Metrics metrics = f6557x;
        if (metrics != null) {
            metrics.f6590m++;
        }
        if (this.f6570k + 1 >= this.f6565f) {
            z();
        }
        SolverVariable a11 = a(SolverVariable.Type.SLACK, (String) null);
        int i11 = this.f6561b + 1;
        this.f6561b = i11;
        this.f6570k++;
        a11.f6607d = i11;
        this.f6573n.f6550d[i11] = a11;
        return a11;
    }

    public final int u(a aVar) throws Exception {
        boolean z11;
        int i11 = 0;
        while (true) {
            if (i11 >= this.f6571l) {
                z11 = false;
                break;
            }
            ArrayRow[] arrayRowArr = this.f6566g;
            if (arrayRowArr[i11].f6541a.f6614k != SolverVariable.Type.UNRESTRICTED && arrayRowArr[i11].f6542b < 0.0f) {
                z11 = true;
                break;
            }
            i11++;
        }
        if (!z11) {
            return 0;
        }
        boolean z12 = false;
        int i12 = 0;
        while (!z12) {
            Metrics metrics = f6557x;
            if (metrics != null) {
                metrics.f6588k++;
            }
            i12++;
            float f11 = Float.MAX_VALUE;
            int i13 = -1;
            int i14 = -1;
            int i15 = 0;
            for (int i16 = 0; i16 < this.f6571l; i16++) {
                ArrayRow arrayRow = this.f6566g[i16];
                if (arrayRow.f6541a.f6614k != SolverVariable.Type.UNRESTRICTED && !arrayRow.f6546f && arrayRow.f6542b < 0.0f) {
                    int i17 = 9;
                    if (f6554u) {
                        int h11 = arrayRow.f6545e.h();
                        int i18 = 0;
                        while (i18 < h11) {
                            SolverVariable b11 = arrayRow.f6545e.b(i18);
                            float d11 = arrayRow.f6545e.d(b11);
                            if (d11 > 0.0f) {
                                int i19 = 0;
                                while (i19 < i17) {
                                    float f12 = b11.f6612i[i19] / d11;
                                    if ((f12 < f11 && i19 == i15) || i19 > i15) {
                                        i14 = b11.f6607d;
                                        i15 = i19;
                                        i13 = i16;
                                        f11 = f12;
                                    }
                                    i19++;
                                    i17 = 9;
                                }
                            }
                            i18++;
                            i17 = 9;
                        }
                    } else {
                        for (int i21 = 1; i21 < this.f6570k; i21++) {
                            SolverVariable solverVariable = this.f6573n.f6550d[i21];
                            float d12 = arrayRow.f6545e.d(solverVariable);
                            if (d12 > 0.0f) {
                                for (int i22 = 0; i22 < 9; i22++) {
                                    float f13 = solverVariable.f6612i[i22] / d12;
                                    if ((f13 < f11 && i22 == i15) || i22 > i15) {
                                        i14 = i21;
                                        i15 = i22;
                                        i13 = i16;
                                        f11 = f13;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i13 != -1) {
                ArrayRow arrayRow2 = this.f6566g[i13];
                arrayRow2.f6541a.f6608e = -1;
                Metrics metrics2 = f6557x;
                if (metrics2 != null) {
                    metrics2.f6587j++;
                }
                arrayRow2.x(this.f6573n.f6550d[i14]);
                SolverVariable solverVariable2 = arrayRow2.f6541a;
                solverVariable2.f6608e = i13;
                solverVariable2.i(this, arrayRow2);
            } else {
                z12 = true;
            }
            if (i12 > this.f6570k / 2) {
                z12 = true;
            }
        }
        return i12;
    }

    public void v(Metrics metrics) {
        f6557x = metrics;
    }

    public Cache w() {
        return this.f6573n;
    }

    public int y(Object obj) {
        SolverVariable i11 = ((ConstraintAnchor) obj).i();
        if (i11 != null) {
            return (int) (i11.f6610g + 0.5f);
        }
        return 0;
    }

    public final void z() {
        int i11 = this.f6564e * 2;
        this.f6564e = i11;
        this.f6566g = (ArrayRow[]) Arrays.copyOf(this.f6566g, i11);
        Cache cache = this.f6573n;
        cache.f6550d = (SolverVariable[]) Arrays.copyOf(cache.f6550d, this.f6564e);
        int i12 = this.f6564e;
        this.f6569j = new boolean[i12];
        this.f6565f = i12;
        this.f6572m = i12;
        Metrics metrics = f6557x;
        if (metrics != null) {
            metrics.f6581d++;
            metrics.f6592o = Math.max(metrics.f6592o, (long) i12);
            Metrics metrics2 = f6557x;
            metrics2.f6602y = metrics2.f6592o;
        }
    }
}
