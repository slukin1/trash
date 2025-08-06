package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

public class c implements ArrayRow.a {

    /* renamed from: n  reason: collision with root package name */
    public static float f6644n = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    public final int f6645a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f6646b = 16;

    /* renamed from: c  reason: collision with root package name */
    public int f6647c = 16;

    /* renamed from: d  reason: collision with root package name */
    public int[] f6648d = new int[16];

    /* renamed from: e  reason: collision with root package name */
    public int[] f6649e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    public int[] f6650f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    public float[] f6651g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    public int[] f6652h = new int[16];

    /* renamed from: i  reason: collision with root package name */
    public int[] f6653i = new int[16];

    /* renamed from: j  reason: collision with root package name */
    public int f6654j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f6655k = -1;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayRow f6656l;

    /* renamed from: m  reason: collision with root package name */
    public final Cache f6657m;

    public c(ArrayRow arrayRow, Cache cache) {
        this.f6656l = arrayRow;
        this.f6657m = cache;
        clear();
    }

    public boolean a(SolverVariable solverVariable) {
        return o(solverVariable) != -1;
    }

    public SolverVariable b(int i11) {
        int i12 = this.f6654j;
        if (i12 == 0) {
            return null;
        }
        int i13 = this.f6655k;
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 == i11 && i13 != -1) {
                return this.f6657m.f6550d[this.f6650f[i13]];
            }
            i13 = this.f6653i[i13];
            if (i13 == -1) {
                break;
            }
        }
        return null;
    }

    public void c(SolverVariable solverVariable, float f11) {
        float f12 = f6644n;
        if (f11 <= (-f12) || f11 >= f12) {
            if (this.f6654j == 0) {
                l(0, solverVariable, f11);
                k(solverVariable, 0);
                this.f6655k = 0;
                return;
            }
            int o11 = o(solverVariable);
            if (o11 != -1) {
                this.f6651g[o11] = f11;
                return;
            }
            if (this.f6654j + 1 >= this.f6646b) {
                n();
            }
            int i11 = this.f6654j;
            int i12 = this.f6655k;
            int i13 = -1;
            for (int i14 = 0; i14 < i11; i14++) {
                int[] iArr = this.f6650f;
                int i15 = iArr[i12];
                int i16 = solverVariable.f6607d;
                if (i15 == i16) {
                    this.f6651g[i12] = f11;
                    return;
                }
                if (iArr[i12] < i16) {
                    i13 = i12;
                }
                i12 = this.f6653i[i12];
                if (i12 == -1) {
                    break;
                }
            }
            p(i13, solverVariable, f11);
            return;
        }
        g(solverVariable, true);
    }

    public void clear() {
        int i11 = this.f6654j;
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable b11 = b(i12);
            if (b11 != null) {
                b11.e(this.f6656l);
            }
        }
        for (int i13 = 0; i13 < this.f6646b; i13++) {
            this.f6650f[i13] = -1;
            this.f6649e[i13] = -1;
        }
        for (int i14 = 0; i14 < this.f6647c; i14++) {
            this.f6648d[i14] = -1;
        }
        this.f6654j = 0;
        this.f6655k = -1;
    }

    public float d(SolverVariable solverVariable) {
        int o11 = o(solverVariable);
        if (o11 != -1) {
            return this.f6651g[o11];
        }
        return 0.0f;
    }

    public void e(float f11) {
        int i11 = this.f6654j;
        int i12 = this.f6655k;
        int i13 = 0;
        while (i13 < i11) {
            float[] fArr = this.f6651g;
            fArr[i12] = fArr[i12] / f11;
            i12 = this.f6653i[i12];
            if (i12 != -1) {
                i13++;
            } else {
                return;
            }
        }
    }

    public void f(SolverVariable solverVariable, float f11, boolean z11) {
        float f12 = f6644n;
        if (f11 <= (-f12) || f11 >= f12) {
            int o11 = o(solverVariable);
            if (o11 == -1) {
                c(solverVariable, f11);
                return;
            }
            float[] fArr = this.f6651g;
            fArr[o11] = fArr[o11] + f11;
            float f13 = fArr[o11];
            float f14 = f6644n;
            if (f13 > (-f14) && fArr[o11] < f14) {
                fArr[o11] = 0.0f;
                g(solverVariable, z11);
            }
        }
    }

    public float g(SolverVariable solverVariable, boolean z11) {
        int o11 = o(solverVariable);
        if (o11 == -1) {
            return 0.0f;
        }
        q(solverVariable);
        float f11 = this.f6651g[o11];
        if (this.f6655k == o11) {
            this.f6655k = this.f6653i[o11];
        }
        this.f6650f[o11] = -1;
        int[] iArr = this.f6652h;
        if (iArr[o11] != -1) {
            int[] iArr2 = this.f6653i;
            iArr2[iArr[o11]] = iArr2[o11];
        }
        int[] iArr3 = this.f6653i;
        if (iArr3[o11] != -1) {
            iArr[iArr3[o11]] = iArr[o11];
        }
        this.f6654j--;
        solverVariable.f6617n--;
        if (z11) {
            solverVariable.e(this.f6656l);
        }
        return f11;
    }

    public int h() {
        return this.f6654j;
    }

    public float i(ArrayRow arrayRow, boolean z11) {
        float d11 = d(arrayRow.f6541a);
        g(arrayRow.f6541a, z11);
        c cVar = (c) arrayRow.f6545e;
        int h11 = cVar.h();
        int i11 = 0;
        int i12 = 0;
        while (i11 < h11) {
            int[] iArr = cVar.f6650f;
            if (iArr[i12] != -1) {
                f(this.f6657m.f6550d[iArr[i12]], cVar.f6651g[i12] * d11, z11);
                i11++;
            }
            i12++;
        }
        return d11;
    }

    public void invert() {
        int i11 = this.f6654j;
        int i12 = this.f6655k;
        int i13 = 0;
        while (i13 < i11) {
            float[] fArr = this.f6651g;
            fArr[i12] = fArr[i12] * -1.0f;
            i12 = this.f6653i[i12];
            if (i12 != -1) {
                i13++;
            } else {
                return;
            }
        }
    }

    public float j(int i11) {
        int i12 = this.f6654j;
        int i13 = this.f6655k;
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 == i11) {
                return this.f6651g[i13];
            }
            i13 = this.f6653i[i13];
            if (i13 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public final void k(SolverVariable solverVariable, int i11) {
        int[] iArr;
        int i12 = solverVariable.f6607d % this.f6647c;
        int[] iArr2 = this.f6648d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            iArr2[i12] = i11;
        } else {
            while (true) {
                iArr = this.f6649e;
                if (iArr[i13] == -1) {
                    break;
                }
                i13 = iArr[i13];
            }
            iArr[i13] = i11;
        }
        this.f6649e[i11] = -1;
    }

    public final void l(int i11, SolverVariable solverVariable, float f11) {
        this.f6650f[i11] = solverVariable.f6607d;
        this.f6651g[i11] = f11;
        this.f6652h[i11] = -1;
        this.f6653i[i11] = -1;
        solverVariable.a(this.f6656l);
        solverVariable.f6617n++;
        this.f6654j++;
    }

    public final int m() {
        for (int i11 = 0; i11 < this.f6646b; i11++) {
            if (this.f6650f[i11] == -1) {
                return i11;
            }
        }
        return -1;
    }

    public final void n() {
        int i11 = this.f6646b * 2;
        this.f6650f = Arrays.copyOf(this.f6650f, i11);
        this.f6651g = Arrays.copyOf(this.f6651g, i11);
        this.f6652h = Arrays.copyOf(this.f6652h, i11);
        this.f6653i = Arrays.copyOf(this.f6653i, i11);
        this.f6649e = Arrays.copyOf(this.f6649e, i11);
        for (int i12 = this.f6646b; i12 < i11; i12++) {
            this.f6650f[i12] = -1;
            this.f6649e[i12] = -1;
        }
        this.f6646b = i11;
    }

    public int o(SolverVariable solverVariable) {
        int[] iArr;
        if (!(this.f6654j == 0 || solverVariable == null)) {
            int i11 = solverVariable.f6607d;
            int i12 = this.f6648d[i11 % this.f6647c];
            if (i12 == -1) {
                return -1;
            }
            if (this.f6650f[i12] == i11) {
                return i12;
            }
            while (true) {
                iArr = this.f6649e;
                if (iArr[i12] != -1 && this.f6650f[iArr[i12]] != i11) {
                    i12 = iArr[i12];
                }
            }
            if (iArr[i12] != -1 && this.f6650f[iArr[i12]] == i11) {
                return iArr[i12];
            }
        }
        return -1;
    }

    public final void p(int i11, SolverVariable solverVariable, float f11) {
        int m11 = m();
        l(m11, solverVariable, f11);
        if (i11 != -1) {
            this.f6652h[m11] = i11;
            int[] iArr = this.f6653i;
            iArr[m11] = iArr[i11];
            iArr[i11] = m11;
        } else {
            this.f6652h[m11] = -1;
            if (this.f6654j > 0) {
                this.f6653i[m11] = this.f6655k;
                this.f6655k = m11;
            } else {
                this.f6653i[m11] = -1;
            }
        }
        int[] iArr2 = this.f6653i;
        if (iArr2[m11] != -1) {
            this.f6652h[iArr2[m11]] = m11;
        }
        k(solverVariable, m11);
    }

    public final void q(SolverVariable solverVariable) {
        int[] iArr;
        int i11 = solverVariable.f6607d;
        int i12 = i11 % this.f6647c;
        int[] iArr2 = this.f6648d;
        int i13 = iArr2[i12];
        if (i13 != -1) {
            if (this.f6650f[i13] == i11) {
                int[] iArr3 = this.f6649e;
                iArr2[i12] = iArr3[i13];
                iArr3[i13] = -1;
                return;
            }
            while (true) {
                iArr = this.f6649e;
                if (iArr[i13] == -1 || this.f6650f[iArr[i13]] == i11) {
                    int i14 = iArr[i13];
                } else {
                    i13 = iArr[i13];
                }
            }
            int i142 = iArr[i13];
            if (i142 != -1 && this.f6650f[i142] == i11) {
                iArr[i13] = iArr[i142];
                iArr[i142] = -1;
            }
        }
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i11 = this.f6654j;
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable b11 = b(i12);
            if (b11 != null) {
                String str4 = str3 + b11 + " = " + j(i12) + " ";
                int o11 = o(b11);
                String str5 = str4 + "[p: ";
                if (this.f6652h[o11] != -1) {
                    str = str5 + this.f6657m.f6550d[this.f6650f[this.f6652h[o11]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f6653i[o11] != -1) {
                    str2 = str6 + this.f6657m.f6550d[this.f6650f[this.f6653i[o11]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }
}
