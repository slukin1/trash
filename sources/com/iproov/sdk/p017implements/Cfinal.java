package com.iproov.sdk.p017implements;

import com.iproov.sdk.p003case.Cif;
import com.iproov.sdk.p035try.Cdo;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.implements.final  reason: invalid class name and invalid package */
public final class Cfinal {
    /* renamed from: do  reason: not valid java name */
    public static final String m1002do(Cif ifVar) {
        return "Claim: type=" + ifVar.m235goto() + " assurance=" + ifVar.m232do();
    }

    /* renamed from: do  reason: not valid java name */
    public static final String m1003do(Cdo doVar) {
        if (doVar.m2127if()) {
            return "Success";
        }
        return x.i("Failure ", doVar.m2126do());
    }
}
