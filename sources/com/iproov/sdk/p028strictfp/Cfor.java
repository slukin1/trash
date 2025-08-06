package com.iproov.sdk.p028strictfp;

import com.iproov.sdk.p022package.Cfor;
import d10.l;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.c;

/* renamed from: com.iproov.sdk.strictfp.for  reason: invalid class name and invalid package */
public final class Cfor {

    /* renamed from: do  reason: not valid java name */
    private final HashMap<c<? extends com.iproov.sdk.p022package.Cfor>, l<com.iproov.sdk.p022package.Cfor, Unit>> f1967do;

    public Cfor(HashMap<c<? extends com.iproov.sdk.p022package.Cfor>, l<com.iproov.sdk.p022package.Cfor, Unit>> hashMap) {
        this.f1967do = hashMap;
    }

    /* renamed from: do  reason: not valid java name */
    public final HashMap<c<? extends com.iproov.sdk.p022package.Cfor>, l<com.iproov.sdk.p022package.Cfor, Unit>> m1841do() {
        return this.f1967do;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1842do(com.iproov.sdk.p022package.Cfor forR) {
        if ((forR instanceof Cfor.Ctry) || !this.f1967do.containsKey(Reflection.b(forR.getClass()))) {
            throw new Exception("Received unknown message");
        }
        l lVar = this.f1967do.get(Reflection.b(forR.getClass()));
        if (lVar != null) {
            lVar.invoke(forR);
        }
    }
}
