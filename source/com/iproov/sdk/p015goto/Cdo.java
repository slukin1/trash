package com.iproov.sdk.p015goto;

import com.iproov.sdk.p033throws.Cthis;

/* renamed from: com.iproov.sdk.goto.do  reason: invalid class name and invalid package */
public class Cdo {

    /* renamed from: do  reason: not valid java name */
    private final Cif f570do;

    /* renamed from: if  reason: not valid java name */
    private final Cthis f571if;

    public Cdo(Cif ifVar, Cthis thisR) {
        this.f570do = ifVar;
        this.f571if = thisR;
    }

    /* renamed from: do  reason: not valid java name */
    public Cthis m689do() {
        return this.f571if;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m690for() {
        return this.f570do == Cif.READY;
    }

    /* renamed from: if  reason: not valid java name */
    public Cif m691if() {
        return this.f570do;
    }
}
