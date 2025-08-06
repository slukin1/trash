package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;

public class ArrayRow implements LinearSystem.a {

    /* renamed from: a  reason: collision with root package name */
    public SolverVariable f6541a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f6542b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6543c = false;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<SolverVariable> f6544d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public a f6545e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6546f = false;

    public interface a {
        boolean a(SolverVariable solverVariable);

        SolverVariable b(int i11);

        void c(SolverVariable solverVariable, float f11);

        void clear();

        float d(SolverVariable solverVariable);

        void e(float f11);

        void f(SolverVariable solverVariable, float f11, boolean z11);

        float g(SolverVariable solverVariable, boolean z11);

        int h();

        float i(ArrayRow arrayRow, boolean z11);

        void invert();

        float j(int i11);
    }

    public ArrayRow() {
    }

    public void A(LinearSystem linearSystem, SolverVariable solverVariable, boolean z11) {
        if (solverVariable != null && solverVariable.f6611h) {
            this.f6542b += solverVariable.f6610g * this.f6545e.d(solverVariable);
            this.f6545e.g(solverVariable, z11);
            if (z11) {
                solverVariable.e(this);
            }
            if (LinearSystem.f6553t && this.f6545e.h() == 0) {
                this.f6546f = true;
                linearSystem.f6560a = true;
            }
        }
    }

    public void B(LinearSystem linearSystem, ArrayRow arrayRow, boolean z11) {
        this.f6542b += arrayRow.f6542b * this.f6545e.i(arrayRow, z11);
        if (z11) {
            arrayRow.f6541a.e(this);
        }
        if (LinearSystem.f6553t && this.f6541a != null && this.f6545e.h() == 0) {
            this.f6546f = true;
            linearSystem.f6560a = true;
        }
    }

    public void C(LinearSystem linearSystem, SolverVariable solverVariable, boolean z11) {
        if (solverVariable != null && solverVariable.f6618o) {
            float d11 = this.f6545e.d(solverVariable);
            this.f6542b += solverVariable.f6620q * d11;
            this.f6545e.g(solverVariable, z11);
            if (z11) {
                solverVariable.e(this);
            }
            this.f6545e.f(linearSystem.f6573n.f6550d[solverVariable.f6619p], d11, z11);
            if (LinearSystem.f6553t && this.f6545e.h() == 0) {
                this.f6546f = true;
                linearSystem.f6560a = true;
            }
        }
    }

    public void D(LinearSystem linearSystem) {
        if (linearSystem.f6566g.length != 0) {
            boolean z11 = false;
            while (!z11) {
                int h11 = this.f6545e.h();
                for (int i11 = 0; i11 < h11; i11++) {
                    SolverVariable b11 = this.f6545e.b(i11);
                    if (b11.f6608e != -1 || b11.f6611h || b11.f6618o) {
                        this.f6544d.add(b11);
                    }
                }
                int size = this.f6544d.size();
                if (size > 0) {
                    for (int i12 = 0; i12 < size; i12++) {
                        SolverVariable solverVariable = this.f6544d.get(i12);
                        if (solverVariable.f6611h) {
                            A(linearSystem, solverVariable, true);
                        } else if (solverVariable.f6618o) {
                            C(linearSystem, solverVariable, true);
                        } else {
                            B(linearSystem, linearSystem.f6566g[solverVariable.f6608e], true);
                        }
                    }
                    this.f6544d.clear();
                } else {
                    z11 = true;
                }
            }
            if (LinearSystem.f6553t && this.f6541a != null && this.f6545e.h() == 0) {
                this.f6546f = true;
                linearSystem.f6560a = true;
            }
        }
    }

    public SolverVariable a(LinearSystem linearSystem, boolean[] zArr) {
        return w(zArr, (SolverVariable) null);
    }

    public void b(LinearSystem.a aVar) {
        if (aVar instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) aVar;
            this.f6541a = null;
            this.f6545e.clear();
            for (int i11 = 0; i11 < arrayRow.f6545e.h(); i11++) {
                this.f6545e.f(arrayRow.f6545e.b(i11), arrayRow.f6545e.j(i11), true);
            }
        }
    }

    public void c(SolverVariable solverVariable) {
        int i11 = solverVariable.f6609f;
        float f11 = 1.0f;
        if (i11 != 1) {
            if (i11 == 2) {
                f11 = 1000.0f;
            } else if (i11 == 3) {
                f11 = 1000000.0f;
            } else if (i11 == 4) {
                f11 = 1.0E9f;
            } else if (i11 == 5) {
                f11 = 1.0E12f;
            }
        }
        this.f6545e.c(solverVariable, f11);
    }

    public void clear() {
        this.f6545e.clear();
        this.f6541a = null;
        this.f6542b = 0.0f;
    }

    public ArrayRow d(LinearSystem linearSystem, int i11) {
        this.f6545e.c(linearSystem.o(i11, "ep"), 1.0f);
        this.f6545e.c(linearSystem.o(i11, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    public ArrayRow e(SolverVariable solverVariable, int i11) {
        this.f6545e.c(solverVariable, (float) i11);
        return this;
    }

    public boolean f(LinearSystem linearSystem) {
        boolean z11;
        SolverVariable g11 = g(linearSystem);
        if (g11 == null) {
            z11 = true;
        } else {
            x(g11);
            z11 = false;
        }
        if (this.f6545e.h() == 0) {
            this.f6546f = true;
        }
        return z11;
    }

    public SolverVariable g(LinearSystem linearSystem) {
        boolean u11;
        boolean u12;
        int h11 = this.f6545e.h();
        SolverVariable solverVariable = null;
        boolean z11 = false;
        boolean z12 = false;
        float f11 = 0.0f;
        float f12 = 0.0f;
        SolverVariable solverVariable2 = null;
        for (int i11 = 0; i11 < h11; i11++) {
            float j11 = this.f6545e.j(i11);
            SolverVariable b11 = this.f6545e.b(i11);
            if (b11.f6614k == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    u12 = u(b11, linearSystem);
                } else if (f11 > j11) {
                    u12 = u(b11, linearSystem);
                } else if (!z11 && u(b11, linearSystem)) {
                    f11 = j11;
                    solverVariable = b11;
                    z11 = true;
                }
                z11 = u12;
                f11 = j11;
                solverVariable = b11;
            } else if (solverVariable == null && j11 < 0.0f) {
                if (solverVariable2 == null) {
                    u11 = u(b11, linearSystem);
                } else if (f12 > j11) {
                    u11 = u(b11, linearSystem);
                } else if (!z12 && u(b11, linearSystem)) {
                    f12 = j11;
                    solverVariable2 = b11;
                    z12 = true;
                }
                z12 = u11;
                f12 = j11;
                solverVariable2 = b11;
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    public SolverVariable getKey() {
        return this.f6541a;
    }

    public ArrayRow h(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, float f11, SolverVariable solverVariable3, SolverVariable solverVariable4, int i12) {
        if (solverVariable2 == solverVariable3) {
            this.f6545e.c(solverVariable, 1.0f);
            this.f6545e.c(solverVariable4, 1.0f);
            this.f6545e.c(solverVariable2, -2.0f);
            return this;
        }
        if (f11 == 0.5f) {
            this.f6545e.c(solverVariable, 1.0f);
            this.f6545e.c(solverVariable2, -1.0f);
            this.f6545e.c(solverVariable3, -1.0f);
            this.f6545e.c(solverVariable4, 1.0f);
            if (i11 > 0 || i12 > 0) {
                this.f6542b = (float) ((-i11) + i12);
            }
        } else if (f11 <= 0.0f) {
            this.f6545e.c(solverVariable, -1.0f);
            this.f6545e.c(solverVariable2, 1.0f);
            this.f6542b = (float) i11;
        } else if (f11 >= 1.0f) {
            this.f6545e.c(solverVariable4, -1.0f);
            this.f6545e.c(solverVariable3, 1.0f);
            this.f6542b = (float) (-i12);
        } else {
            float f12 = 1.0f - f11;
            this.f6545e.c(solverVariable, f12 * 1.0f);
            this.f6545e.c(solverVariable2, f12 * -1.0f);
            this.f6545e.c(solverVariable3, -1.0f * f11);
            this.f6545e.c(solverVariable4, 1.0f * f11);
            if (i11 > 0 || i12 > 0) {
                this.f6542b = (((float) (-i11)) * f12) + (((float) i12) * f11);
            }
        }
        return this;
    }

    public ArrayRow i(SolverVariable solverVariable, int i11) {
        this.f6541a = solverVariable;
        float f11 = (float) i11;
        solverVariable.f6610g = f11;
        this.f6542b = f11;
        this.f6546f = true;
        return this;
    }

    public boolean isEmpty() {
        return this.f6541a == null && this.f6542b == 0.0f && this.f6545e.h() == 0;
    }

    public ArrayRow j(SolverVariable solverVariable, SolverVariable solverVariable2, float f11) {
        this.f6545e.c(solverVariable, -1.0f);
        this.f6545e.c(solverVariable2, f11);
        return this;
    }

    public ArrayRow k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11) {
        this.f6545e.c(solverVariable, -1.0f);
        this.f6545e.c(solverVariable2, 1.0f);
        this.f6545e.c(solverVariable3, f11);
        this.f6545e.c(solverVariable4, -f11);
        return this;
    }

    public ArrayRow l(float f11, float f12, float f13, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f6542b = 0.0f;
        if (f12 == 0.0f || f11 == f13) {
            this.f6545e.c(solverVariable, 1.0f);
            this.f6545e.c(solverVariable2, -1.0f);
            this.f6545e.c(solverVariable4, 1.0f);
            this.f6545e.c(solverVariable3, -1.0f);
        } else if (f11 == 0.0f) {
            this.f6545e.c(solverVariable, 1.0f);
            this.f6545e.c(solverVariable2, -1.0f);
        } else if (f13 == 0.0f) {
            this.f6545e.c(solverVariable3, 1.0f);
            this.f6545e.c(solverVariable4, -1.0f);
        } else {
            float f14 = (f11 / f12) / (f13 / f12);
            this.f6545e.c(solverVariable, 1.0f);
            this.f6545e.c(solverVariable2, -1.0f);
            this.f6545e.c(solverVariable4, f14);
            this.f6545e.c(solverVariable3, -f14);
        }
        return this;
    }

    public ArrayRow m(SolverVariable solverVariable, int i11) {
        if (i11 < 0) {
            this.f6542b = (float) (i11 * -1);
            this.f6545e.c(solverVariable, 1.0f);
        } else {
            this.f6542b = (float) i11;
            this.f6545e.c(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow n(SolverVariable solverVariable, SolverVariable solverVariable2, int i11) {
        boolean z11 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            }
            this.f6542b = (float) i11;
        }
        if (!z11) {
            this.f6545e.c(solverVariable, -1.0f);
            this.f6545e.c(solverVariable2, 1.0f);
        } else {
            this.f6545e.c(solverVariable, 1.0f);
            this.f6545e.c(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i11) {
        boolean z11 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            }
            this.f6542b = (float) i11;
        }
        if (!z11) {
            this.f6545e.c(solverVariable, -1.0f);
            this.f6545e.c(solverVariable2, 1.0f);
            this.f6545e.c(solverVariable3, 1.0f);
        } else {
            this.f6545e.c(solverVariable, 1.0f);
            this.f6545e.c(solverVariable2, -1.0f);
            this.f6545e.c(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i11) {
        boolean z11 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            }
            this.f6542b = (float) i11;
        }
        if (!z11) {
            this.f6545e.c(solverVariable, -1.0f);
            this.f6545e.c(solverVariable2, 1.0f);
            this.f6545e.c(solverVariable3, -1.0f);
        } else {
            this.f6545e.c(solverVariable, 1.0f);
            this.f6545e.c(solverVariable2, -1.0f);
            this.f6545e.c(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11) {
        this.f6545e.c(solverVariable3, 0.5f);
        this.f6545e.c(solverVariable4, 0.5f);
        this.f6545e.c(solverVariable, -0.5f);
        this.f6545e.c(solverVariable2, -0.5f);
        this.f6542b = -f11;
        return this;
    }

    public void r() {
        float f11 = this.f6542b;
        if (f11 < 0.0f) {
            this.f6542b = f11 * -1.0f;
            this.f6545e.invert();
        }
    }

    public boolean s() {
        SolverVariable solverVariable = this.f6541a;
        return solverVariable != null && (solverVariable.f6614k == SolverVariable.Type.UNRESTRICTED || this.f6542b >= 0.0f);
    }

    public boolean t(SolverVariable solverVariable) {
        return this.f6545e.a(solverVariable);
    }

    public String toString() {
        return z();
    }

    public final boolean u(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.f6617n <= 1;
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w((boolean[]) null, solverVariable);
    }

    public final SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int h11 = this.f6545e.h();
        SolverVariable solverVariable2 = null;
        float f11 = 0.0f;
        for (int i11 = 0; i11 < h11; i11++) {
            float j11 = this.f6545e.j(i11);
            if (j11 < 0.0f) {
                SolverVariable b11 = this.f6545e.b(i11);
                if ((zArr == null || !zArr[b11.f6607d]) && b11 != solverVariable && (((type = b11.f6614k) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && j11 < f11)) {
                    f11 = j11;
                    solverVariable2 = b11;
                }
            }
        }
        return solverVariable2;
    }

    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f6541a;
        if (solverVariable2 != null) {
            this.f6545e.c(solverVariable2, -1.0f);
            this.f6541a.f6608e = -1;
            this.f6541a = null;
        }
        float g11 = this.f6545e.g(solverVariable, true) * -1.0f;
        this.f6541a = solverVariable;
        if (g11 != 1.0f) {
            this.f6542b /= g11;
            this.f6545e.e(g11);
        }
    }

    public void y() {
        this.f6541a = null;
        this.f6545e.clear();
        this.f6542b = 0.0f;
        this.f6546f = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String z() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.f6541a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.f6541a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f6542b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f6542b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L_0x0057
        L_0x0056:
            r1 = r3
        L_0x0057:
            androidx.constraintlayout.core.ArrayRow$a r5 = r10.f6545e
            int r5 = r5.h()
        L_0x005d:
            if (r3 >= r5) goto L_0x00eb
            androidx.constraintlayout.core.ArrayRow$a r6 = r10.f6545e
            androidx.constraintlayout.core.SolverVariable r6 = r6.b(r3)
            if (r6 != 0) goto L_0x0069
            goto L_0x00e7
        L_0x0069:
            androidx.constraintlayout.core.ArrayRow$a r7 = r10.f6545e
            float r7 = r7.j(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0075
            goto L_0x00e7
        L_0x0075:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0093
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b8
        L_0x0093:
            if (r8 <= 0) goto L_0x00a7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b9
        L_0x00a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b8:
            float r7 = r7 * r9
        L_0x00b9:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00cf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e6
        L_0x00cf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e6:
            r1 = r4
        L_0x00e7:
            int r3 = r3 + 1
            goto L_0x005d
        L_0x00eb:
            if (r1 != 0) goto L_0x00fe
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00fe:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.z():java.lang.String");
    }

    public ArrayRow(Cache cache) {
        this.f6545e = new a(this, cache);
    }
}
