package com.iproov.sdk.p035try;

/* renamed from: com.iproov.sdk.try.else  reason: invalid class name and invalid package */
public class Celse {

    /* renamed from: do  reason: not valid java name */
    private int f2298do = 0;

    /* renamed from: for  reason: not valid java name */
    private Long f2299for;

    /* renamed from: if  reason: not valid java name */
    private int f2300if = 0;

    /* renamed from: new  reason: not valid java name */
    private boolean f2301new = false;

    /* renamed from: try  reason: not valid java name */
    private volatile boolean f2302try = false;

    /* renamed from: do  reason: not valid java name */
    public void m2128do(boolean z11) {
        this.f2301new = z11;
    }

    /* renamed from: if  reason: not valid java name */
    public void m2130if() {
        this.f2302try = true;
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized boolean m2129do() {
        Long l11;
        int i11;
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f2301new || (((l11 = this.f2299for) != null && l11.longValue() >= currentTimeMillis) || this.f2302try || (i11 = this.f2300if) >= 10)) {
            return false;
        }
        this.f2298do++;
        this.f2300if = i11 + 1;
        this.f2299for = Long.valueOf(currentTimeMillis + 1000);
        return true;
    }
}
