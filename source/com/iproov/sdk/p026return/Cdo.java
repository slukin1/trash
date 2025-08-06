package com.iproov.sdk.p026return;

/* renamed from: com.iproov.sdk.return.do  reason: invalid class name and invalid package */
public final class Cdo {

    /* renamed from: do  reason: not valid java name */
    private final int f1396do;

    /* renamed from: for  reason: not valid java name */
    private int f1397for = 1;

    /* renamed from: if  reason: not valid java name */
    private int f1398if;

    /* renamed from: new  reason: not valid java name */
    private int f1399new = 1;

    public Cdo(int i11) {
        this.f1396do = i11;
    }

    /* renamed from: do  reason: not valid java name */
    public final int m1437do() {
        return this.f1397for;
    }

    /* renamed from: for  reason: not valid java name */
    public final int m1440for() {
        return this.f1398if;
    }

    /* renamed from: if  reason: not valid java name */
    public final int m1441if() {
        return this.f1396do;
    }

    /* renamed from: new  reason: not valid java name */
    public final int m1442new() {
        return this.f1399new;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1438do(int i11) {
        if (i11 > this.f1398if) {
            this.f1398if = i11;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1439do(int i11, int i12) {
        this.f1397for = i11;
        this.f1399new = i12;
    }
}
