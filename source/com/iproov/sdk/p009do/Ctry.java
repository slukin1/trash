package com.iproov.sdk.p009do;

import com.iproov.sdk.CommonApi;
import com.iproov.sdk.p031this.Cif;
import d10.l;

/* renamed from: com.iproov.sdk.do.try  reason: invalid class name and invalid package */
public final class Ctry implements CommonApi.KeyPair {

    /* renamed from: do  reason: not valid java name */
    private final Cif f507do;

    /* renamed from: if  reason: not valid java name */
    private final l<byte[], byte[]> f508if;

    public Ctry(Cif ifVar, l<? super byte[], byte[]> lVar) {
        this.f507do = ifVar;
        this.f508if = lVar;
    }

    public Cif getPublicKey() {
        return this.f507do;
    }

    public byte[] sign(byte[] bArr) {
        return this.f508if.invoke(bArr);
    }
}
