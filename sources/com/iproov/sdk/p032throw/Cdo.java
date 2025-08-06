package com.iproov.sdk.p032throw;

/* renamed from: com.iproov.sdk.throw.do  reason: invalid class name and invalid package */
public class Cdo {

    /* renamed from: do  reason: not valid java name */
    private Cif f2018do;

    /* renamed from: for  reason: not valid java name */
    private final long f2019for;

    /* renamed from: if  reason: not valid java name */
    private final long f2020if;

    /* renamed from: new  reason: not valid java name */
    private final float[] f2021new;

    /* renamed from: try  reason: not valid java name */
    private final float[] f2022try;

    public Cdo(long j11, long j12, float[] fArr, float[] fArr2) {
        this.f2021new = fArr;
        this.f2022try = fArr2;
        this.f2020if = j11;
        this.f2019for = j12;
        this.f2018do = new Cif(j11, fArr2, fArr);
    }

    /* renamed from: do  reason: not valid java name */
    public float[] m1898do() {
        return (float[]) this.f2018do.m1901do();
    }

    /* renamed from: for  reason: not valid java name */
    public void m1899for() {
        Cif ifVar = new Cif(this.f2019for, this.f2021new, this.f2022try);
        this.f2018do = ifVar;
        ifVar.m1903if();
    }

    /* renamed from: if  reason: not valid java name */
    public void m1900if() {
        Cif ifVar = new Cif(this.f2020if, this.f2022try, this.f2021new);
        this.f2018do = ifVar;
        ifVar.m1903if();
    }
}
