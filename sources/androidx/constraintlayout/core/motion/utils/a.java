package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class a extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    public final double[] f6962a;

    /* renamed from: b  reason: collision with root package name */
    public C0017a[] f6963b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6964c = true;

    /* renamed from: androidx.constraintlayout.core.motion.utils.a$a  reason: collision with other inner class name */
    public static class C0017a {

        /* renamed from: s  reason: collision with root package name */
        public static double[] f6965s = new double[91];

        /* renamed from: a  reason: collision with root package name */
        public double[] f6966a;

        /* renamed from: b  reason: collision with root package name */
        public double f6967b;

        /* renamed from: c  reason: collision with root package name */
        public double f6968c;

        /* renamed from: d  reason: collision with root package name */
        public double f6969d;

        /* renamed from: e  reason: collision with root package name */
        public double f6970e;

        /* renamed from: f  reason: collision with root package name */
        public double f6971f;

        /* renamed from: g  reason: collision with root package name */
        public double f6972g;

        /* renamed from: h  reason: collision with root package name */
        public double f6973h;

        /* renamed from: i  reason: collision with root package name */
        public double f6974i;

        /* renamed from: j  reason: collision with root package name */
        public double f6975j;

        /* renamed from: k  reason: collision with root package name */
        public double f6976k;

        /* renamed from: l  reason: collision with root package name */
        public double f6977l;

        /* renamed from: m  reason: collision with root package name */
        public double f6978m;

        /* renamed from: n  reason: collision with root package name */
        public double f6979n;

        /* renamed from: o  reason: collision with root package name */
        public double f6980o;

        /* renamed from: p  reason: collision with root package name */
        public double f6981p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f6982q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f6983r = false;

        public C0017a(int i11, double d11, double d12, double d13, double d14, double d15, double d16) {
            int i12 = i11;
            double d17 = d11;
            double d18 = d12;
            double d19 = d13;
            double d21 = d14;
            double d22 = d15;
            double d23 = d16;
            boolean z11 = false;
            int i13 = 1;
            this.f6982q = i12 == 1 ? true : z11;
            this.f6968c = d17;
            this.f6969d = d18;
            this.f6974i = 1.0d / (d18 - d17);
            if (3 == i12) {
                this.f6983r = true;
            }
            double d24 = d22 - d19;
            double d25 = d23 - d21;
            if (this.f6983r || Math.abs(d24) < 0.001d || Math.abs(d25) < 0.001d) {
                this.f6983r = true;
                this.f6970e = d19;
                this.f6971f = d22;
                this.f6972g = d21;
                this.f6973h = d16;
                double hypot = Math.hypot(d25, d24);
                this.f6967b = hypot;
                this.f6979n = hypot * this.f6974i;
                double d26 = this.f6969d;
                double d27 = this.f6968c;
                this.f6977l = d24 / (d26 - d27);
                this.f6978m = d25 / (d26 - d27);
                return;
            }
            this.f6966a = new double[101];
            boolean z12 = this.f6982q;
            this.f6975j = d24 * ((double) (z12 ? -1 : 1));
            this.f6976k = d25 * ((double) (!z12 ? -1 : i13));
            this.f6977l = z12 ? d22 : d19;
            this.f6978m = z12 ? d21 : d16;
            a(d13, d14, d15, d16);
            this.f6979n = this.f6967b * this.f6974i;
        }

        public final void a(double d11, double d12, double d13, double d14) {
            double d15;
            double d16 = d13 - d11;
            double d17 = d12 - d14;
            int i11 = 0;
            double d18 = 0.0d;
            double d19 = 0.0d;
            double d21 = 0.0d;
            while (true) {
                double[] dArr = f6965s;
                if (i11 >= dArr.length) {
                    break;
                }
                double d22 = d18;
                double radians = Math.toRadians((((double) i11) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d16;
                double cos = Math.cos(radians) * d17;
                if (i11 > 0) {
                    d15 = Math.hypot(sin - d19, cos - d21) + d22;
                    f6965s[i11] = d15;
                } else {
                    d15 = d22;
                }
                i11++;
                d21 = cos;
                double d23 = sin;
                d18 = d15;
                d19 = d23;
            }
            double d24 = d18;
            this.f6967b = d24;
            int i12 = 0;
            while (true) {
                double[] dArr2 = f6965s;
                if (i12 >= dArr2.length) {
                    break;
                }
                dArr2[i12] = dArr2[i12] / d24;
                i12++;
            }
            int i13 = 0;
            while (true) {
                double[] dArr3 = this.f6966a;
                if (i13 < dArr3.length) {
                    double length = ((double) i13) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(f6965s, length);
                    if (binarySearch >= 0) {
                        this.f6966a[i13] = ((double) binarySearch) / ((double) (f6965s.length - 1));
                    } else if (binarySearch == -1) {
                        this.f6966a[i13] = 0.0d;
                    } else {
                        int i14 = -binarySearch;
                        int i15 = i14 - 2;
                        double[] dArr4 = f6965s;
                        this.f6966a[i13] = (((double) i15) + ((length - dArr4[i15]) / (dArr4[i14 - 1] - dArr4[i15]))) / ((double) (dArr4.length - 1));
                    }
                    i13++;
                } else {
                    return;
                }
            }
        }

        public double b() {
            double d11 = this.f6975j * this.f6981p;
            double hypot = this.f6979n / Math.hypot(d11, (-this.f6976k) * this.f6980o);
            if (this.f6982q) {
                d11 = -d11;
            }
            return d11 * hypot;
        }

        public double c() {
            double d11 = this.f6975j * this.f6981p;
            double d12 = (-this.f6976k) * this.f6980o;
            double hypot = this.f6979n / Math.hypot(d11, d12);
            return this.f6982q ? (-d12) * hypot : d12 * hypot;
        }

        public double d(double d11) {
            return this.f6977l;
        }

        public double e(double d11) {
            return this.f6978m;
        }

        public double f(double d11) {
            double d12 = (d11 - this.f6968c) * this.f6974i;
            double d13 = this.f6970e;
            return d13 + (d12 * (this.f6971f - d13));
        }

        public double g(double d11) {
            double d12 = (d11 - this.f6968c) * this.f6974i;
            double d13 = this.f6972g;
            return d13 + (d12 * (this.f6973h - d13));
        }

        public double h() {
            return this.f6977l + (this.f6975j * this.f6980o);
        }

        public double i() {
            return this.f6978m + (this.f6976k * this.f6981p);
        }

        public double j(double d11) {
            if (d11 <= 0.0d) {
                return 0.0d;
            }
            if (d11 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f6966a;
            double length = d11 * ((double) (dArr.length - 1));
            int i11 = (int) length;
            return dArr[i11] + ((length - ((double) i11)) * (dArr[i11 + 1] - dArr[i11]));
        }

        public void k(double d11) {
            double j11 = j((this.f6982q ? this.f6969d - d11 : d11 - this.f6968c) * this.f6974i) * 1.5707963267948966d;
            this.f6980o = Math.sin(j11);
            this.f6981p = Math.cos(j11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (r5 == 1) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r2 = 1
            r0.f6964c = r2
            r0.f6962a = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.a$a[] r3 = new androidx.constraintlayout.core.motion.utils.a.C0017a[r3]
            r0.f6963b = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L_0x0016:
            androidx.constraintlayout.core.motion.utils.a$a[] r7 = r0.f6963b
            int r8 = r7.length
            if (r4 >= r8) goto L_0x0053
            r8 = r25[r4]
            r9 = 3
            r10 = 2
            if (r8 == 0) goto L_0x002f
            if (r8 == r2) goto L_0x002c
            if (r8 == r10) goto L_0x002a
            if (r8 == r9) goto L_0x0028
            goto L_0x0030
        L_0x0028:
            if (r5 != r2) goto L_0x002c
        L_0x002a:
            r5 = r10
            goto L_0x002d
        L_0x002c:
            r5 = r2
        L_0x002d:
            r6 = r5
            goto L_0x0030
        L_0x002f:
            r6 = r9
        L_0x0030:
            androidx.constraintlayout.core.motion.utils.a$a r22 = new androidx.constraintlayout.core.motion.utils.a$a
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r3]
            r8 = r27[r4]
            r16 = r8[r2]
            r8 = r27[r23]
            r18 = r8[r3]
            r8 = r27[r23]
            r20 = r8[r2]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L_0x0016
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.a.<init>(int[], double[], double[][]):void");
    }

    public double c(double d11, int i11) {
        double d12;
        double g11;
        double e11;
        double i12;
        double c11;
        int i13 = 0;
        if (this.f6964c) {
            C0017a[] aVarArr = this.f6963b;
            if (d11 < aVarArr[0].f6968c) {
                double d13 = aVarArr[0].f6968c;
                d12 = d11 - aVarArr[0].f6968c;
                if (!aVarArr[0].f6983r) {
                    aVarArr[0].k(d13);
                    if (i11 == 0) {
                        i12 = this.f6963b[0].h();
                        c11 = this.f6963b[0].b();
                    } else {
                        i12 = this.f6963b[0].i();
                        c11 = this.f6963b[0].c();
                    }
                    return i12 + (d12 * c11);
                } else if (i11 == 0) {
                    g11 = aVarArr[0].f(d13);
                    e11 = this.f6963b[0].d(d13);
                } else {
                    g11 = aVarArr[0].g(d13);
                    e11 = this.f6963b[0].e(d13);
                }
            } else if (d11 > aVarArr[aVarArr.length - 1].f6969d) {
                double d14 = aVarArr[aVarArr.length - 1].f6969d;
                d12 = d11 - d14;
                int length = aVarArr.length - 1;
                if (i11 == 0) {
                    g11 = aVarArr[length].f(d14);
                    e11 = this.f6963b[length].d(d14);
                } else {
                    g11 = aVarArr[length].g(d14);
                    e11 = this.f6963b[length].e(d14);
                }
            }
            return g11 + (d12 * e11);
        }
        C0017a[] aVarArr2 = this.f6963b;
        if (d11 < aVarArr2[0].f6968c) {
            d11 = aVarArr2[0].f6968c;
        } else if (d11 > aVarArr2[aVarArr2.length - 1].f6969d) {
            d11 = aVarArr2[aVarArr2.length - 1].f6969d;
        }
        while (true) {
            C0017a[] aVarArr3 = this.f6963b;
            if (i13 >= aVarArr3.length) {
                return Double.NaN;
            }
            if (d11 > aVarArr3[i13].f6969d) {
                i13++;
            } else if (!aVarArr3[i13].f6983r) {
                aVarArr3[i13].k(d11);
                if (i11 == 0) {
                    return this.f6963b[i13].h();
                }
                return this.f6963b[i13].i();
            } else if (i11 == 0) {
                return aVarArr3[i13].f(d11);
            } else {
                return aVarArr3[i13].g(d11);
            }
        }
    }

    public void d(double d11, double[] dArr) {
        if (this.f6964c) {
            C0017a[] aVarArr = this.f6963b;
            if (d11 < aVarArr[0].f6968c) {
                double d12 = aVarArr[0].f6968c;
                double d13 = d11 - aVarArr[0].f6968c;
                if (aVarArr[0].f6983r) {
                    dArr[0] = aVarArr[0].f(d12) + (this.f6963b[0].d(d12) * d13);
                    dArr[1] = this.f6963b[0].g(d12) + (d13 * this.f6963b[0].e(d12));
                    return;
                }
                aVarArr[0].k(d12);
                dArr[0] = this.f6963b[0].h() + (this.f6963b[0].b() * d13);
                dArr[1] = this.f6963b[0].i() + (d13 * this.f6963b[0].c());
                return;
            } else if (d11 > aVarArr[aVarArr.length - 1].f6969d) {
                double d14 = aVarArr[aVarArr.length - 1].f6969d;
                double d15 = d11 - d14;
                int length = aVarArr.length - 1;
                if (aVarArr[length].f6983r) {
                    dArr[0] = aVarArr[length].f(d14) + (this.f6963b[length].d(d14) * d15);
                    dArr[1] = this.f6963b[length].g(d14) + (d15 * this.f6963b[length].e(d14));
                    return;
                }
                aVarArr[length].k(d11);
                dArr[0] = this.f6963b[length].h() + (this.f6963b[length].b() * d15);
                dArr[1] = this.f6963b[length].i() + (d15 * this.f6963b[length].c());
                return;
            }
        } else {
            C0017a[] aVarArr2 = this.f6963b;
            if (d11 < aVarArr2[0].f6968c) {
                d11 = aVarArr2[0].f6968c;
            }
            if (d11 > aVarArr2[aVarArr2.length - 1].f6969d) {
                d11 = aVarArr2[aVarArr2.length - 1].f6969d;
            }
        }
        int i11 = 0;
        while (true) {
            C0017a[] aVarArr3 = this.f6963b;
            if (i11 >= aVarArr3.length) {
                return;
            }
            if (d11 > aVarArr3[i11].f6969d) {
                i11++;
            } else if (aVarArr3[i11].f6983r) {
                dArr[0] = aVarArr3[i11].f(d11);
                dArr[1] = this.f6963b[i11].g(d11);
                return;
            } else {
                aVarArr3[i11].k(d11);
                dArr[0] = this.f6963b[i11].h();
                dArr[1] = this.f6963b[i11].i();
                return;
            }
        }
    }

    public void e(double d11, float[] fArr) {
        if (this.f6964c) {
            C0017a[] aVarArr = this.f6963b;
            if (d11 < aVarArr[0].f6968c) {
                double d12 = aVarArr[0].f6968c;
                double d13 = d11 - aVarArr[0].f6968c;
                if (aVarArr[0].f6983r) {
                    fArr[0] = (float) (aVarArr[0].f(d12) + (this.f6963b[0].d(d12) * d13));
                    fArr[1] = (float) (this.f6963b[0].g(d12) + (d13 * this.f6963b[0].e(d12)));
                    return;
                }
                aVarArr[0].k(d12);
                fArr[0] = (float) (this.f6963b[0].h() + (this.f6963b[0].b() * d13));
                fArr[1] = (float) (this.f6963b[0].i() + (d13 * this.f6963b[0].c()));
                return;
            } else if (d11 > aVarArr[aVarArr.length - 1].f6969d) {
                double d14 = aVarArr[aVarArr.length - 1].f6969d;
                double d15 = d11 - d14;
                int length = aVarArr.length - 1;
                if (aVarArr[length].f6983r) {
                    fArr[0] = (float) (aVarArr[length].f(d14) + (this.f6963b[length].d(d14) * d15));
                    fArr[1] = (float) (this.f6963b[length].g(d14) + (d15 * this.f6963b[length].e(d14)));
                    return;
                }
                aVarArr[length].k(d11);
                fArr[0] = (float) this.f6963b[length].h();
                fArr[1] = (float) this.f6963b[length].i();
                return;
            }
        } else {
            C0017a[] aVarArr2 = this.f6963b;
            if (d11 < aVarArr2[0].f6968c) {
                d11 = aVarArr2[0].f6968c;
            } else if (d11 > aVarArr2[aVarArr2.length - 1].f6969d) {
                d11 = aVarArr2[aVarArr2.length - 1].f6969d;
            }
        }
        int i11 = 0;
        while (true) {
            C0017a[] aVarArr3 = this.f6963b;
            if (i11 >= aVarArr3.length) {
                return;
            }
            if (d11 > aVarArr3[i11].f6969d) {
                i11++;
            } else if (aVarArr3[i11].f6983r) {
                fArr[0] = (float) aVarArr3[i11].f(d11);
                fArr[1] = (float) this.f6963b[i11].g(d11);
                return;
            } else {
                aVarArr3[i11].k(d11);
                fArr[0] = (float) this.f6963b[i11].h();
                fArr[1] = (float) this.f6963b[i11].i();
                return;
            }
        }
    }

    public double f(double d11, int i11) {
        C0017a[] aVarArr = this.f6963b;
        int i12 = 0;
        if (d11 < aVarArr[0].f6968c) {
            d11 = aVarArr[0].f6968c;
        }
        if (d11 > aVarArr[aVarArr.length - 1].f6969d) {
            d11 = aVarArr[aVarArr.length - 1].f6969d;
        }
        while (true) {
            C0017a[] aVarArr2 = this.f6963b;
            if (i12 >= aVarArr2.length) {
                return Double.NaN;
            }
            if (d11 > aVarArr2[i12].f6969d) {
                i12++;
            } else if (!aVarArr2[i12].f6983r) {
                aVarArr2[i12].k(d11);
                if (i11 == 0) {
                    return this.f6963b[i12].b();
                }
                return this.f6963b[i12].c();
            } else if (i11 == 0) {
                return aVarArr2[i12].d(d11);
            } else {
                return aVarArr2[i12].e(d11);
            }
        }
    }

    public void g(double d11, double[] dArr) {
        C0017a[] aVarArr = this.f6963b;
        if (d11 < aVarArr[0].f6968c) {
            d11 = aVarArr[0].f6968c;
        } else if (d11 > aVarArr[aVarArr.length - 1].f6969d) {
            d11 = aVarArr[aVarArr.length - 1].f6969d;
        }
        int i11 = 0;
        while (true) {
            C0017a[] aVarArr2 = this.f6963b;
            if (i11 >= aVarArr2.length) {
                return;
            }
            if (d11 > aVarArr2[i11].f6969d) {
                i11++;
            } else if (aVarArr2[i11].f6983r) {
                dArr[0] = aVarArr2[i11].d(d11);
                dArr[1] = this.f6963b[i11].e(d11);
                return;
            } else {
                aVarArr2[i11].k(d11);
                dArr[0] = this.f6963b[i11].b();
                dArr[1] = this.f6963b[i11].c();
                return;
            }
        }
    }

    public double[] h() {
        return this.f6962a;
    }
}
