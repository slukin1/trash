package com.iproov.sdk.p017implements;

import java.util.Date;

/* renamed from: com.iproov.sdk.implements.class  reason: invalid class name and invalid package */
public class Cclass {

    /* renamed from: do  reason: not valid java name */
    private final double f918do;

    /* renamed from: for  reason: not valid java name */
    private Double f919for;

    /* renamed from: if  reason: not valid java name */
    private Double f920if;

    /* renamed from: new  reason: not valid java name */
    private Date f921new;

    public Cclass(double d11) {
        this.f918do = d11;
    }

    /* renamed from: do  reason: not valid java name */
    public Double m986do(Double d11) {
        long time = new Date().getTime();
        Date date = this.f921new;
        if (date == null) {
            m984do(d11.doubleValue(), d11.doubleValue());
        } else {
            long time2 = time - date.getTime();
            if (time2 == 0) {
                return this.f920if;
            }
            double d12 = (((double) time2) / 1000.0d) / this.f918do;
            double exp = Math.exp(-d12);
            double d13 = (1.0d - exp) / d12;
            m984do((this.f920if.doubleValue() * exp) + ((d13 - exp) * this.f919for.doubleValue()) + ((1.0d - d13) * d11.doubleValue()), d11.doubleValue());
        }
        return this.f920if;
    }

    /* renamed from: if  reason: not valid java name */
    public void m987if() {
        this.f920if = null;
        this.f919for = null;
        this.f921new = null;
    }

    /* renamed from: do  reason: not valid java name */
    private void m984do(double d11, double d12) {
        this.f920if = Double.valueOf(d11);
        this.f919for = Double.valueOf(d12);
        this.f921new = new Date();
    }

    /* renamed from: do  reason: not valid java name */
    public Double m985do() {
        return this.f920if;
    }
}
