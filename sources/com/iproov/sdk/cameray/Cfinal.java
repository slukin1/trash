package com.iproov.sdk.cameray;

import com.iproov.sdk.p021new.Ccase;
import java.util.List;

/* renamed from: com.iproov.sdk.cameray.final  reason: invalid class name */
public class Cfinal {

    /* renamed from: do  reason: not valid java name */
    private final Cconst f89do;

    /* renamed from: if  reason: not valid java name */
    private final List<Ccase> f90if;

    public Cfinal(Cconst constR, List<Ccase> list) {
        this.f89do = constR;
        this.f90if = list;
    }

    /* renamed from: do  reason: not valid java name */
    public Ccase m128do() {
        if (m130if()) {
            return null;
        }
        return this.f90if.get(0);
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m130if() {
        return this.f90if.isEmpty();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (Ccase next : this.f90if) {
            if (sb2.length() > 0) {
                sb2.append(", ");
            }
            sb2.append(next.toString());
        }
        return "CameraSpecs{cameraSDK=" + this.f89do + ", cameras=[" + sb2 + "]}";
    }

    /* renamed from: do  reason: not valid java name */
    public Ccase m129do(Cbreak... breakArr) {
        for (Cbreak breakR : breakArr) {
            for (Ccase next : this.f90if) {
                if (next.m1183if() == breakR) {
                    return next;
                }
            }
        }
        return null;
    }
}
