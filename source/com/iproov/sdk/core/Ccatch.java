package com.iproov.sdk.core;

import com.iproov.sdk.cameray.Cif;
import com.iproov.sdk.cameray.Cthrow;
import com.iproov.sdk.cameray.Cwhile;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import com.iproov.sdk.p026return.Cfinally;
import java.util.List;

/* renamed from: com.iproov.sdk.core.catch  reason: invalid class name */
public enum Ccatch {
    AND1(1000, CollectionsKt__CollectionsKt.n(Cwhile.class.getName(), Cthrow.class.getName())),
    AND2(1000, CollectionsKt__CollectionsKt.n(Cif.Cfor.class.getName(), r1.getName())),
    AND3(1000, CollectionsKt__CollectionsKt.n(Cif.Cnew.class.getName(), r1.getName())),
    AND4(1000, CollectionsKt__CollectionsJVMKt.e(OpenGLRenderer.class.getName())),
    AND5(1000, CollectionsKt__CollectionsJVMKt.e(Cfinally.class.getName())),
    AND6(1000, CollectionsKt__CollectionsJVMKt.e(r0.getName())),
    AND7(1000, CollectionsKt__CollectionsJVMKt.e(r0.getName())),
    AND8(1000, CollectionsKt__CollectionsJVMKt.e(r0.getName())),
    AND9(0, CollectionsKt__CollectionsJVMKt.e(r2.getName())),
    AND10(0, CollectionsKt__CollectionsJVMKt.e(r2.getName())),
    AND11(0, CollectionsKt__CollectionsJVMKt.e(r2.getName())),
    AND12(0, CollectionsKt__CollectionsJVMKt.e(r2.getName())),
    AND13(0, CollectionsKt__CollectionsJVMKt.e(r2.getName())),
    AND14(0, CollectionsKt__CollectionsKt.n(Cif.Cnew.class.getName(), r1.getName()));
    

    /* renamed from: do  reason: not valid java name */
    private final long f271do;

    /* renamed from: if  reason: not valid java name */
    private final List<String> f272if;

    private Ccatch(long j11, List<String> list) {
        this.f271do = j11;
        this.f272if = list;
    }

    /* renamed from: for  reason: not valid java name */
    public final long m331for() {
        return this.f271do;
    }

    /* renamed from: if  reason: not valid java name */
    public final List<String> m332if() {
        return this.f272if;
    }
}
