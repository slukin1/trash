package com.iproov.sdk.p026return;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.iproov.sdk.return.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: do  reason: not valid java name */
    private long f1611do;

    /* renamed from: for  reason: not valid java name */
    private List<Cdo> f1612for = new ArrayList(10);

    /* renamed from: if  reason: not valid java name */
    private long f1613if;

    /* renamed from: new  reason: not valid java name */
    private Cdo f1614new;

    /* renamed from: do  reason: not valid java name */
    public final void m1580do(int i11) {
        Cdo doVar = this.f1614new;
        if (doVar != null) {
            doVar.m1438do(i11);
        }
    }

    /* renamed from: for  reason: not valid java name */
    public final List<Cdo> m1582for() {
        return this.f1612for;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m1583if() {
        this.f1611do = System.nanoTime();
    }

    /* renamed from: new  reason: not valid java name */
    public final long m1584new() {
        return this.f1613if;
    }

    /* renamed from: try  reason: not valid java name */
    public final void m1585try() {
        Cdo doVar = this.f1614new;
        Cdo doVar2 = new Cdo((doVar == null ? 0 : doVar.m1441if()) + 1);
        this.f1614new = doVar2;
        this.f1612for.add(doVar2);
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1581do(int i11, int i12) {
        Cdo doVar = this.f1614new;
        if (doVar != null) {
            doVar.m1439do(i11, i12);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1579do() {
        this.f1613if = System.nanoTime() - this.f1611do;
    }
}
