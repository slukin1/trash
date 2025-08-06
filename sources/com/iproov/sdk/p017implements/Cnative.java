package com.iproov.sdk.p017implements;

/* renamed from: com.iproov.sdk.implements.native  reason: invalid class name and invalid package */
public class Cnative {

    /* renamed from: do  reason: not valid java name */
    private final int f942do;

    /* renamed from: if  reason: not valid java name */
    private double[] f943if;

    public Cnative(int i11) {
        this.f942do = i11;
        this.f943if = new double[i11];
    }

    /* renamed from: do  reason: not valid java name */
    public int m1021do() {
        return this.f942do;
    }

    /* renamed from: for  reason: not valid java name */
    public Cnative m1024for(Cnative nativeR) {
        if (m1021do() == nativeR.m1021do()) {
            Cnative nativeR2 = new Cnative(this.f942do);
            for (int i11 = 0; i11 < this.f942do; i11++) {
                nativeR2.f943if[i11] = Math.min(nativeR.f943if[i11], this.f943if[i11]);
            }
            return nativeR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: if  reason: not valid java name */
    public double m1025if() {
        double d11 = 0.0d;
        for (int i11 = 0; i11 < this.f942do; i11++) {
            double[] dArr = this.f943if;
            d11 += dArr[i11] * dArr[i11];
        }
        return Math.sqrt(d11);
    }

    /* renamed from: new  reason: not valid java name */
    public Cnative m1027new(Cnative nativeR) {
        if (m1021do() == nativeR.m1021do()) {
            Cnative nativeR2 = new Cnative(this.f942do);
            for (int i11 = 0; i11 < this.f942do; i11++) {
                nativeR2.f943if[i11] = this.f943if[i11] - nativeR.f943if[i11];
            }
            return nativeR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        for (int i11 = 0; i11 < this.f942do; i11++) {
            sb2.append(this.f943if[i11]);
            if (i11 < this.f942do - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    /* renamed from: try  reason: not valid java name */
    public Cnative m1028try(Cnative nativeR) {
        if (m1021do() == nativeR.m1021do()) {
            Cnative nativeR2 = new Cnative(this.f942do);
            for (int i11 = 0; i11 < this.f942do; i11++) {
                nativeR2.f943if[i11] = nativeR.f943if[i11] * this.f943if[i11];
            }
            return nativeR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: do  reason: not valid java name */
    public double m1020do(Cnative nativeR) {
        if (m1021do() == nativeR.m1021do()) {
            double d11 = 0.0d;
            for (int i11 = 0; i11 < this.f942do; i11++) {
                d11 += this.f943if[i11] * nativeR.f943if[i11];
            }
            return d11;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    public Cnative(double... dArr) {
        int length = dArr.length;
        this.f942do = length;
        this.f943if = new double[length];
        for (int i11 = 0; i11 < this.f942do; i11++) {
            this.f943if[i11] = dArr[i11];
        }
    }

    /* renamed from: if  reason: not valid java name */
    public Cnative m1026if(Cnative nativeR) {
        if (m1021do() == nativeR.m1021do()) {
            Cnative nativeR2 = new Cnative(this.f942do);
            for (int i11 = 0; i11 < this.f942do; i11++) {
                nativeR2.f943if[i11] = Math.max(nativeR.f943if[i11], this.f943if[i11]);
            }
            return nativeR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: do  reason: not valid java name */
    public Cnative m1022do(double d11) {
        Cnative nativeR = new Cnative(this.f942do);
        for (int i11 = 0; i11 < this.f942do; i11++) {
            nativeR.f943if[i11] = this.f943if[i11] * d11;
        }
        return nativeR;
    }

    /* renamed from: do  reason: not valid java name */
    public Cnative m1023do(Cnative nativeR, Cnative nativeR2) {
        if (m1021do() == nativeR.m1021do() && m1021do() == nativeR2.m1021do()) {
            Cnative nativeR3 = new Cnative(this.f942do);
            for (int i11 = 0; i11 < this.f942do; i11++) {
                nativeR3.f943if[i11] = Cimport.m1012do(this.f943if[i11], nativeR.f943if[i11], nativeR2.f943if[i11]);
            }
            return nativeR3;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }
}
