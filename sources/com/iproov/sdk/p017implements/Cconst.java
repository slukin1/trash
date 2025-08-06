package com.iproov.sdk.p017implements;

import android.graphics.RectF;
import com.iproov.sdk.utils.Cfor;

/* renamed from: com.iproov.sdk.implements.const  reason: invalid class name and invalid package */
public class Cconst {

    /* renamed from: case  reason: not valid java name */
    public double f922case;

    /* renamed from: do  reason: not valid java name */
    private final Cclass f923do;

    /* renamed from: else  reason: not valid java name */
    public double f924else;

    /* renamed from: for  reason: not valid java name */
    private final Cclass f925for;

    /* renamed from: goto  reason: not valid java name */
    public double f926goto;

    /* renamed from: if  reason: not valid java name */
    private final Cclass f927if;

    /* renamed from: new  reason: not valid java name */
    private final Cclass f928new;

    /* renamed from: try  reason: not valid java name */
    public double f929try;

    public Cconst(double d11) {
        this.f923do = new Cclass(d11);
        this.f927if = new Cclass(d11);
        this.f925for = new Cclass(d11);
        this.f928new = new Cclass(d11);
    }

    /* renamed from: do  reason: not valid java name */
    public void m989do(RectF rectF) {
        this.f923do.m986do(Double.valueOf(Cfor.m2231do(rectF.left)));
        this.f929try = this.f923do.m985do().doubleValue();
        this.f927if.m986do(Double.valueOf(Cfor.m2231do(rectF.top)));
        this.f922case = this.f927if.m985do().doubleValue();
        this.f925for.m986do(Double.valueOf(Cfor.m2231do(rectF.right)));
        this.f924else = this.f925for.m985do().doubleValue();
        this.f928new.m986do(Double.valueOf(Cfor.m2231do(rectF.bottom)));
        this.f926goto = this.f928new.m985do().doubleValue();
    }

    /* renamed from: if  reason: not valid java name */
    public RectF m990if() {
        return new RectF(Cfor.m2233do(this.f929try), Cfor.m2233do(this.f922case), Cfor.m2233do(this.f924else), Cfor.m2233do(this.f926goto));
    }

    /* renamed from: do  reason: not valid java name */
    public void m988do() {
        this.f923do.m987if();
        this.f927if.m987if();
        this.f925for.m987if();
        this.f928new.m987if();
    }
}
