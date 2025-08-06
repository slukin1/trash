package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

public class a implements ArrayRow.a {

    /* renamed from: l  reason: collision with root package name */
    public static float f6622l = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    public int f6623a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayRow f6624b;

    /* renamed from: c  reason: collision with root package name */
    public final Cache f6625c;

    /* renamed from: d  reason: collision with root package name */
    public int f6626d = 8;

    /* renamed from: e  reason: collision with root package name */
    public SolverVariable f6627e = null;

    /* renamed from: f  reason: collision with root package name */
    public int[] f6628f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public int[] f6629g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    public float[] f6630h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    public int f6631i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f6632j = -1;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6633k = false;

    public a(ArrayRow arrayRow, Cache cache) {
        this.f6624b = arrayRow;
        this.f6625c = cache;
    }

    public boolean a(SolverVariable solverVariable) {
        int i11 = this.f6631i;
        if (i11 == -1) {
            return false;
        }
        int i12 = 0;
        while (i11 != -1 && i12 < this.f6623a) {
            if (this.f6628f[i11] == solverVariable.f6607d) {
                return true;
            }
            i11 = this.f6629g[i11];
            i12++;
        }
        return false;
    }

    public SolverVariable b(int i11) {
        int i12 = this.f6631i;
        int i13 = 0;
        while (i12 != -1 && i13 < this.f6623a) {
            if (i13 == i11) {
                return this.f6625c.f6550d[this.f6628f[i12]];
            }
            i12 = this.f6629g[i12];
            i13++;
        }
        return null;
    }

    public final void c(SolverVariable solverVariable, float f11) {
        if (f11 == 0.0f) {
            g(solverVariable, true);
            return;
        }
        int i11 = this.f6631i;
        if (i11 == -1) {
            this.f6631i = 0;
            this.f6630h[0] = f11;
            this.f6628f[0] = solverVariable.f6607d;
            this.f6629g[0] = -1;
            solverVariable.f6617n++;
            solverVariable.a(this.f6624b);
            this.f6623a++;
            if (!this.f6633k) {
                int i12 = this.f6632j + 1;
                this.f6632j = i12;
                int[] iArr = this.f6628f;
                if (i12 >= iArr.length) {
                    this.f6633k = true;
                    this.f6632j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i13 = 0;
        int i14 = -1;
        while (i11 != -1 && i13 < this.f6623a) {
            int[] iArr2 = this.f6628f;
            int i15 = iArr2[i11];
            int i16 = solverVariable.f6607d;
            if (i15 == i16) {
                this.f6630h[i11] = f11;
                return;
            }
            if (iArr2[i11] < i16) {
                i14 = i11;
            }
            i11 = this.f6629g[i11];
            i13++;
        }
        int i17 = this.f6632j;
        int i18 = i17 + 1;
        if (this.f6633k) {
            int[] iArr3 = this.f6628f;
            if (iArr3[i17] != -1) {
                i17 = iArr3.length;
            }
        } else {
            i17 = i18;
        }
        int[] iArr4 = this.f6628f;
        if (i17 >= iArr4.length && this.f6623a < iArr4.length) {
            int i19 = 0;
            while (true) {
                int[] iArr5 = this.f6628f;
                if (i19 >= iArr5.length) {
                    break;
                } else if (iArr5[i19] == -1) {
                    i17 = i19;
                    break;
                } else {
                    i19++;
                }
            }
        }
        int[] iArr6 = this.f6628f;
        if (i17 >= iArr6.length) {
            i17 = iArr6.length;
            int i21 = this.f6626d * 2;
            this.f6626d = i21;
            this.f6633k = false;
            this.f6632j = i17 - 1;
            this.f6630h = Arrays.copyOf(this.f6630h, i21);
            this.f6628f = Arrays.copyOf(this.f6628f, this.f6626d);
            this.f6629g = Arrays.copyOf(this.f6629g, this.f6626d);
        }
        this.f6628f[i17] = solverVariable.f6607d;
        this.f6630h[i17] = f11;
        if (i14 != -1) {
            int[] iArr7 = this.f6629g;
            iArr7[i17] = iArr7[i14];
            iArr7[i14] = i17;
        } else {
            this.f6629g[i17] = this.f6631i;
            this.f6631i = i17;
        }
        solverVariable.f6617n++;
        solverVariable.a(this.f6624b);
        int i22 = this.f6623a + 1;
        this.f6623a = i22;
        if (!this.f6633k) {
            this.f6632j++;
        }
        int[] iArr8 = this.f6628f;
        if (i22 >= iArr8.length) {
            this.f6633k = true;
        }
        if (this.f6632j >= iArr8.length) {
            this.f6633k = true;
            this.f6632j = iArr8.length - 1;
        }
    }

    public final void clear() {
        int i11 = this.f6631i;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f6623a) {
            SolverVariable solverVariable = this.f6625c.f6550d[this.f6628f[i11]];
            if (solverVariable != null) {
                solverVariable.e(this.f6624b);
            }
            i11 = this.f6629g[i11];
            i12++;
        }
        this.f6631i = -1;
        this.f6632j = -1;
        this.f6633k = false;
        this.f6623a = 0;
    }

    public final float d(SolverVariable solverVariable) {
        int i11 = this.f6631i;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f6623a) {
            if (this.f6628f[i11] == solverVariable.f6607d) {
                return this.f6630h[i11];
            }
            i11 = this.f6629g[i11];
            i12++;
        }
        return 0.0f;
    }

    public void e(float f11) {
        int i11 = this.f6631i;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f6623a) {
            float[] fArr = this.f6630h;
            fArr[i11] = fArr[i11] / f11;
            i11 = this.f6629g[i11];
            i12++;
        }
    }

    public void f(SolverVariable solverVariable, float f11, boolean z11) {
        float f12 = f6622l;
        if (f11 <= (-f12) || f11 >= f12) {
            int i11 = this.f6631i;
            if (i11 == -1) {
                this.f6631i = 0;
                this.f6630h[0] = f11;
                this.f6628f[0] = solverVariable.f6607d;
                this.f6629g[0] = -1;
                solverVariable.f6617n++;
                solverVariable.a(this.f6624b);
                this.f6623a++;
                if (!this.f6633k) {
                    int i12 = this.f6632j + 1;
                    this.f6632j = i12;
                    int[] iArr = this.f6628f;
                    if (i12 >= iArr.length) {
                        this.f6633k = true;
                        this.f6632j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i13 = 0;
            int i14 = -1;
            while (i11 != -1 && i13 < this.f6623a) {
                int[] iArr2 = this.f6628f;
                int i15 = iArr2[i11];
                int i16 = solverVariable.f6607d;
                if (i15 == i16) {
                    float[] fArr = this.f6630h;
                    float f13 = fArr[i11] + f11;
                    float f14 = f6622l;
                    if (f13 > (-f14) && f13 < f14) {
                        f13 = 0.0f;
                    }
                    fArr[i11] = f13;
                    if (f13 == 0.0f) {
                        if (i11 == this.f6631i) {
                            this.f6631i = this.f6629g[i11];
                        } else {
                            int[] iArr3 = this.f6629g;
                            iArr3[i14] = iArr3[i11];
                        }
                        if (z11) {
                            solverVariable.e(this.f6624b);
                        }
                        if (this.f6633k) {
                            this.f6632j = i11;
                        }
                        solverVariable.f6617n--;
                        this.f6623a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i11] < i16) {
                    i14 = i11;
                }
                i11 = this.f6629g[i11];
                i13++;
            }
            int i17 = this.f6632j;
            int i18 = i17 + 1;
            if (this.f6633k) {
                int[] iArr4 = this.f6628f;
                if (iArr4[i17] != -1) {
                    i17 = iArr4.length;
                }
            } else {
                i17 = i18;
            }
            int[] iArr5 = this.f6628f;
            if (i17 >= iArr5.length && this.f6623a < iArr5.length) {
                int i19 = 0;
                while (true) {
                    int[] iArr6 = this.f6628f;
                    if (i19 >= iArr6.length) {
                        break;
                    } else if (iArr6[i19] == -1) {
                        i17 = i19;
                        break;
                    } else {
                        i19++;
                    }
                }
            }
            int[] iArr7 = this.f6628f;
            if (i17 >= iArr7.length) {
                i17 = iArr7.length;
                int i21 = this.f6626d * 2;
                this.f6626d = i21;
                this.f6633k = false;
                this.f6632j = i17 - 1;
                this.f6630h = Arrays.copyOf(this.f6630h, i21);
                this.f6628f = Arrays.copyOf(this.f6628f, this.f6626d);
                this.f6629g = Arrays.copyOf(this.f6629g, this.f6626d);
            }
            this.f6628f[i17] = solverVariable.f6607d;
            this.f6630h[i17] = f11;
            if (i14 != -1) {
                int[] iArr8 = this.f6629g;
                iArr8[i17] = iArr8[i14];
                iArr8[i14] = i17;
            } else {
                this.f6629g[i17] = this.f6631i;
                this.f6631i = i17;
            }
            solverVariable.f6617n++;
            solverVariable.a(this.f6624b);
            this.f6623a++;
            if (!this.f6633k) {
                this.f6632j++;
            }
            int i22 = this.f6632j;
            int[] iArr9 = this.f6628f;
            if (i22 >= iArr9.length) {
                this.f6633k = true;
                this.f6632j = iArr9.length - 1;
            }
        }
    }

    public final float g(SolverVariable solverVariable, boolean z11) {
        if (this.f6627e == solverVariable) {
            this.f6627e = null;
        }
        int i11 = this.f6631i;
        if (i11 == -1) {
            return 0.0f;
        }
        int i12 = 0;
        int i13 = -1;
        while (i11 != -1 && i12 < this.f6623a) {
            if (this.f6628f[i11] == solverVariable.f6607d) {
                if (i11 == this.f6631i) {
                    this.f6631i = this.f6629g[i11];
                } else {
                    int[] iArr = this.f6629g;
                    iArr[i13] = iArr[i11];
                }
                if (z11) {
                    solverVariable.e(this.f6624b);
                }
                solverVariable.f6617n--;
                this.f6623a--;
                this.f6628f[i11] = -1;
                if (this.f6633k) {
                    this.f6632j = i11;
                }
                return this.f6630h[i11];
            }
            i12++;
            i13 = i11;
            i11 = this.f6629g[i11];
        }
        return 0.0f;
    }

    public int h() {
        return this.f6623a;
    }

    public float i(ArrayRow arrayRow, boolean z11) {
        float d11 = d(arrayRow.f6541a);
        g(arrayRow.f6541a, z11);
        ArrayRow.a aVar = arrayRow.f6545e;
        int h11 = aVar.h();
        for (int i11 = 0; i11 < h11; i11++) {
            SolverVariable b11 = aVar.b(i11);
            f(b11, aVar.d(b11) * d11, z11);
        }
        return d11;
    }

    public void invert() {
        int i11 = this.f6631i;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f6623a) {
            float[] fArr = this.f6630h;
            fArr[i11] = fArr[i11] * -1.0f;
            i11 = this.f6629g[i11];
            i12++;
        }
    }

    public float j(int i11) {
        int i12 = this.f6631i;
        int i13 = 0;
        while (i12 != -1 && i13 < this.f6623a) {
            if (i13 == i11) {
                return this.f6630h[i12];
            }
            i12 = this.f6629g[i12];
            i13++;
        }
        return 0.0f;
    }

    public String toString() {
        int i11 = this.f6631i;
        String str = "";
        int i12 = 0;
        while (i11 != -1 && i12 < this.f6623a) {
            str = ((str + " -> ") + this.f6630h[i11] + " : ") + this.f6625c.f6550d[this.f6628f[i11]];
            i11 = this.f6629g[i11];
            i12++;
        }
        return str;
    }
}
