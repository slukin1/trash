package com.iproov.sdk.p017implements;

/* renamed from: com.iproov.sdk.implements.return  reason: invalid class name and invalid package */
public final class Creturn {

    /* renamed from: do  reason: not valid java name */
    public static final Creturn f944do = new Creturn();

    /* renamed from: if  reason: not valid java name */
    private static final long f945if = ((System.currentTimeMillis() * 1000000) - System.nanoTime());

    private Creturn() {
    }

    /* renamed from: do  reason: not valid java name */
    public final long m1035do(long j11) {
        return j11 + f945if;
    }

    /* renamed from: if  reason: not valid java name */
    public final long m1036if() {
        return m1035do(System.nanoTime());
    }

    /* renamed from: do  reason: not valid java name */
    public final long m1034do() {
        return m1036if() / 1000000;
    }
}
