package com.iproov.sdk.p001abstract;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.iproov.sdk.abstract.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: do  reason: not valid java name */
    private int f27do;

    /* renamed from: for  reason: not valid java name */
    private final AtomicInteger f28for = new AtomicInteger();

    /* renamed from: if  reason: not valid java name */
    private int f29if;

    /* renamed from: new  reason: not valid java name */
    private int f30new;

    /* renamed from: try  reason: not valid java name */
    private double f31try;

    /* renamed from: case  reason: not valid java name */
    public final int m80case() {
        int i11 = this.f27do;
        this.f27do = i11 + 1;
        return i11;
    }

    /* renamed from: do  reason: not valid java name */
    public final int m81do() {
        return this.f27do;
    }

    /* renamed from: else  reason: not valid java name */
    public final int m84else() {
        int i11 = this.f29if;
        this.f29if = i11 + 1;
        return i11;
    }

    /* renamed from: for  reason: not valid java name */
    public final int m85for() {
        return this.f30new;
    }

    /* renamed from: if  reason: not valid java name */
    public final double m86if() {
        return this.f31try;
    }

    /* renamed from: new  reason: not valid java name */
    public final AtomicInteger m87new() {
        return this.f28for;
    }

    /* renamed from: try  reason: not valid java name */
    public final int m88try() {
        return this.f29if;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m83do(int i11) {
        this.f30new = i11 + 1;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m82do(double d11) {
        this.f31try = d11;
    }
}
