package com.iproov.sdk.p020native;

import com.iproov.sdk.p017implements.Ccatch;
import com.iproov.sdk.p017implements.Cthis;

/* renamed from: com.iproov.sdk.native.if  reason: invalid class name and invalid package */
public class Cif {

    /* renamed from: do  reason: not valid java name */
    private final Ccatch f1008do = new Ccatch(500);

    /* renamed from: for  reason: not valid java name */
    private volatile long f1009for = -1;

    /* renamed from: if  reason: not valid java name */
    private long f1010if = -1;

    /* renamed from: new  reason: not valid java name */
    private long f1011new = 0;

    /* renamed from: case  reason: not valid java name */
    public synchronized void m1147case() {
        if (!m1154try()) {
            long nanoTime = System.nanoTime();
            long j11 = this.f1010if;
            if (j11 != -1) {
                this.f1008do.m979do(((double) ((nanoTime - j11) - this.f1011new)) / 1.0E9d);
            }
            this.f1010if = nanoTime;
            this.f1011new = 0;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public float m1148do() {
        return 1.0f / this.f1008do.m978do();
    }

    /* renamed from: else  reason: not valid java name */
    public synchronized void m1149else() {
        if (!m1154try()) {
            this.f1009for = System.nanoTime();
        }
    }

    /* renamed from: for  reason: not valid java name */
    public double m1150for() {
        if (this.f1008do.m982new() == 0.0d) {
            return 0.0d;
        }
        return 1.0d / this.f1008do.m983try();
    }

    /* renamed from: goto  reason: not valid java name */
    public synchronized void m1151goto() {
        if (m1154try()) {
            this.f1011new = System.nanoTime() - this.f1009for;
            this.f1009for = -1;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public Cthis m1152if() {
        return new Cthis((double) m1148do(), m1153new(), m1150for(), this.f1008do.m980for());
    }

    /* renamed from: new  reason: not valid java name */
    public double m1153new() {
        if (this.f1008do.m983try() == 0.0d) {
            return 0.0d;
        }
        return 1.0d / this.f1008do.m982new();
    }

    /* renamed from: try  reason: not valid java name */
    public boolean m1154try() {
        return this.f1009for != -1;
    }
}
