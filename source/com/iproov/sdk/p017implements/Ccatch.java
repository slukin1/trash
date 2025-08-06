package com.iproov.sdk.p017implements;

/* renamed from: com.iproov.sdk.implements.catch  reason: invalid class name and invalid package */
public class Ccatch {

    /* renamed from: do  reason: not valid java name */
    private final double[] f914do;

    /* renamed from: for  reason: not valid java name */
    private double f915for = 0.0d;

    /* renamed from: if  reason: not valid java name */
    private int f916if = 0;

    /* renamed from: new  reason: not valid java name */
    private double f917new = 0.0d;

    public Ccatch(int i11) {
        this.f914do = new double[i11];
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized void m979do(double d11) {
        double d12 = this.f915for;
        if (d11 < d12 || d12 == 0.0d) {
            this.f915for = d11;
        }
        if (d11 > this.f917new) {
            this.f917new = d11;
        }
        int i11 = this.f916if;
        this.f916if = i11 + 1;
        double[] dArr = this.f914do;
        dArr[i11 % dArr.length] = d11;
    }

    /* renamed from: for  reason: not valid java name */
    public synchronized int m980for() {
        return this.f916if;
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized double m981if() {
        return (double) m978do();
    }

    /* renamed from: new  reason: not valid java name */
    public synchronized double m982new() {
        return this.f917new;
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized double m983try() {
        return this.f915for;
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized float m978do() {
        float f11;
        f11 = 0.0f;
        for (double d11 : this.f914do) {
            f11 = (float) (((double) f11) + d11);
        }
        return f11 / ((float) Math.min(this.f916if, this.f914do.length));
    }
}
