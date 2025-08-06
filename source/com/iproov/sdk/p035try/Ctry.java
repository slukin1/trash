package com.iproov.sdk.p035try;

import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.p021new.Cgoto;
import com.iproov.sdk.p025public.Cif;
import java.util.List;

/* renamed from: com.iproov.sdk.try.try  reason: invalid class name and invalid package */
public class Ctry implements Cgoto {

    /* renamed from: do  reason: not valid java name */
    private final Cif f2303do;

    /* renamed from: if  reason: not valid java name */
    private Double f2304if;

    public Ctry(Cif ifVar) {
        this.f2303do = ifVar;
    }

    /* renamed from: do  reason: not valid java name */
    private double m2147do(Cconst constR, Float f11, Double d11) {
        this.f2304if = d11;
        String.format("Zoom Selector (%s) zoom factor as %.1f given focal length of %.1f", new Object[]{constR, d11, f11});
        return d11.doubleValue();
    }

    /* renamed from: if  reason: not valid java name */
    private Double m2148if(Cconst constR, Float f11) {
        if (this.f2303do.m1298for() == null) {
            return Double.valueOf(1.0d);
        }
        String.format("Zoom Selector has zoom factor provided by device profile as %.1f", new Object[]{this.f2303do.m1298for()});
        return this.f2303do.m1298for();
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized Double m2151do() {
        return this.f2304if;
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized double m2149do(Cconst constR, Float f11) {
        if (this.f2304if == null) {
            Double d11 = m2148if(constR, f11);
            this.f2304if = d11;
            m2147do(constR, f11, d11);
        }
        return this.f2304if.doubleValue();
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized int m2150do(Cconst constR, Float f11, List<Integer> list) {
        int doubleValue = (int) (m2148if(constR, f11).doubleValue() * 100.0d);
        int i11 = 0;
        while (i11 < list.size()) {
            Integer num = list.get(i11);
            if (num == null || num.intValue() < doubleValue) {
                i11++;
            } else {
                m2147do(constR, f11, Double.valueOf(Double.valueOf((double) num.intValue()).doubleValue() / 100.0d));
                return i11;
            }
        }
        m2147do(constR, f11, (Double) null);
        return -1;
    }
}
