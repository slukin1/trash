package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

public class b extends ArrayRow {

    /* renamed from: g  reason: collision with root package name */
    public int f6634g = 128;

    /* renamed from: h  reason: collision with root package name */
    public SolverVariable[] f6635h = new SolverVariable[128];

    /* renamed from: i  reason: collision with root package name */
    public SolverVariable[] f6636i = new SolverVariable[128];

    /* renamed from: j  reason: collision with root package name */
    public int f6637j = 0;

    /* renamed from: k  reason: collision with root package name */
    public C0016b f6638k = new C0016b(this);

    /* renamed from: l  reason: collision with root package name */
    public Cache f6639l;

    public class a implements Comparator<SolverVariable> {
        public a() {
        }

        /* renamed from: a */
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f6607d - solverVariable2.f6607d;
        }
    }

    /* renamed from: androidx.constraintlayout.core.b$b  reason: collision with other inner class name */
    public class C0016b {

        /* renamed from: a  reason: collision with root package name */
        public SolverVariable f6641a;

        /* renamed from: b  reason: collision with root package name */
        public b f6642b;

        public C0016b(b bVar) {
            this.f6642b = bVar;
        }

        public boolean a(SolverVariable solverVariable, float f11) {
            boolean z11 = true;
            if (this.f6641a.f6605b) {
                for (int i11 = 0; i11 < 9; i11++) {
                    float[] fArr = this.f6641a.f6613j;
                    fArr[i11] = fArr[i11] + (solverVariable.f6613j[i11] * f11);
                    if (Math.abs(fArr[i11]) < 1.0E-4f) {
                        this.f6641a.f6613j[i11] = 0.0f;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    b.this.G(this.f6641a);
                }
                return false;
            }
            for (int i12 = 0; i12 < 9; i12++) {
                float f12 = solverVariable.f6613j[i12];
                if (f12 != 0.0f) {
                    float f13 = f12 * f11;
                    if (Math.abs(f13) < 1.0E-4f) {
                        f13 = 0.0f;
                    }
                    this.f6641a.f6613j[i12] = f13;
                } else {
                    this.f6641a.f6613j[i12] = 0.0f;
                }
            }
            return true;
        }

        public void b(SolverVariable solverVariable) {
            this.f6641a = solverVariable;
        }

        public final boolean c() {
            for (int i11 = 8; i11 >= 0; i11--) {
                float f11 = this.f6641a.f6613j[i11];
                if (f11 > 0.0f) {
                    return false;
                }
                if (f11 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i11 = 8;
            while (true) {
                if (i11 < 0) {
                    break;
                }
                float f11 = solverVariable.f6613j[i11];
                float f12 = this.f6641a.f6613j[i11];
                if (f12 == f11) {
                    i11--;
                } else if (f12 < f11) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f6641a.f6613j, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f6641a != null) {
                for (int i11 = 0; i11 < 9; i11++) {
                    str = str + this.f6641a.f6613j[i11] + " ";
                }
            }
            return str + "] " + this.f6641a;
        }
    }

    public b(Cache cache) {
        super(cache);
        this.f6639l = cache;
    }

    public void B(LinearSystem linearSystem, ArrayRow arrayRow, boolean z11) {
        SolverVariable solverVariable = arrayRow.f6541a;
        if (solverVariable != null) {
            ArrayRow.a aVar = arrayRow.f6545e;
            int h11 = aVar.h();
            for (int i11 = 0; i11 < h11; i11++) {
                SolverVariable b11 = aVar.b(i11);
                float j11 = aVar.j(i11);
                this.f6638k.b(b11);
                if (this.f6638k.a(solverVariable, j11)) {
                    F(b11);
                }
                this.f6542b += arrayRow.f6542b * j11;
            }
            G(solverVariable);
        }
    }

    public final void F(SolverVariable solverVariable) {
        int i11;
        int i12 = this.f6637j + 1;
        SolverVariable[] solverVariableArr = this.f6635h;
        if (i12 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f6635h = solverVariableArr2;
            this.f6636i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f6635h;
        int i13 = this.f6637j;
        solverVariableArr3[i13] = solverVariable;
        int i14 = i13 + 1;
        this.f6637j = i14;
        if (i14 > 1 && solverVariableArr3[i14 - 1].f6607d > solverVariable.f6607d) {
            int i15 = 0;
            while (true) {
                i11 = this.f6637j;
                if (i15 >= i11) {
                    break;
                }
                this.f6636i[i15] = this.f6635h[i15];
                i15++;
            }
            Arrays.sort(this.f6636i, 0, i11, new a());
            for (int i16 = 0; i16 < this.f6637j; i16++) {
                this.f6635h[i16] = this.f6636i[i16];
            }
        }
        solverVariable.f6605b = true;
        solverVariable.a(this);
    }

    public final void G(SolverVariable solverVariable) {
        int i11 = 0;
        while (i11 < this.f6637j) {
            if (this.f6635h[i11] == solverVariable) {
                while (true) {
                    int i12 = this.f6637j;
                    if (i11 < i12 - 1) {
                        SolverVariable[] solverVariableArr = this.f6635h;
                        int i13 = i11 + 1;
                        solverVariableArr[i11] = solverVariableArr[i13];
                        i11 = i13;
                    } else {
                        this.f6637j = i12 - 1;
                        solverVariable.f6605b = false;
                        return;
                    }
                }
            } else {
                i11++;
            }
        }
    }

    public SolverVariable a(LinearSystem linearSystem, boolean[] zArr) {
        int i11 = -1;
        for (int i12 = 0; i12 < this.f6637j; i12++) {
            SolverVariable solverVariable = this.f6635h[i12];
            if (!zArr[solverVariable.f6607d]) {
                this.f6638k.b(solverVariable);
                if (i11 == -1) {
                    if (!this.f6638k.c()) {
                    }
                } else if (!this.f6638k.d(this.f6635h[i11])) {
                }
                i11 = i12;
            }
        }
        if (i11 == -1) {
            return null;
        }
        return this.f6635h[i11];
    }

    public void c(SolverVariable solverVariable) {
        this.f6638k.b(solverVariable);
        this.f6638k.e();
        solverVariable.f6613j[solverVariable.f6609f] = 1.0f;
        F(solverVariable);
    }

    public void clear() {
        this.f6637j = 0;
        this.f6542b = 0.0f;
    }

    public boolean isEmpty() {
        return this.f6637j == 0;
    }

    public String toString() {
        String str = "" + " goal -> (" + this.f6542b + ") : ";
        for (int i11 = 0; i11 < this.f6637j; i11++) {
            this.f6638k.b(this.f6635h[i11]);
            str = str + this.f6638k + " ";
        }
        return str;
    }
}
