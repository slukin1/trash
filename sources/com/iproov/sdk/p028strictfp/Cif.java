package com.iproov.sdk.p028strictfp;

import com.iproov.sdk.core.Cconst;
import com.iproov.sdk.p013finally.Cdo;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.iproov.sdk.strictfp.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: do  reason: not valid java name */
    private final List<byte[]> f1968do = new ArrayList();

    /* renamed from: if  reason: not valid java name */
    private long f1969if;

    /* renamed from: do  reason: not valid java name */
    public final long m1844do() {
        return this.f1969if;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1845do(long j11) {
        this.f1969if = j11;
    }

    /* renamed from: do  reason: not valid java name */
    public final byte[] m1846do(byte[] bArr, boolean z11, String str) throws Cdo {
        this.f1968do.add(m1843do(bArr));
        return z11 ? Cconst.m354do(bArr, m1843do(com.iproov.sdk.p017implements.Cif.m1010do(str.getBytes(StandardCharsets.UTF_8), this.f1968do)), str) : bArr;
    }

    /* renamed from: do  reason: not valid java name */
    private final byte[] m1843do(byte[] bArr) throws Cdo {
        try {
            return com.iproov.sdk.utils.Cdo.m2230do(bArr);
        } catch (Exception e11) {
            throw new Cdo(e11);
        }
    }
}
