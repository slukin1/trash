package com.iproov.sdk.core;

import com.iproov.sdk.core.Cnew;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.iproov.sdk.core.final  reason: invalid class name */
class Cfinal {

    /* renamed from: do  reason: not valid java name */
    private static final Map<Ccatch, Boolean> f301do = new HashMap();

    /* renamed from: for  reason: not valid java name */
    private static final Map<Cgoto, Object> f302for = new HashMap();

    /* renamed from: if  reason: not valid java name */
    private static final Map<Cnew.Cdo, Boolean> f303if = new HashMap();

    /* renamed from: do  reason: not valid java name */
    public static synchronized void m389do() {
        synchronized (Cfinal.class) {
            f301do.clear();
            f303if.clear();
            f302for.clear();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static Boolean m386do(Ccatch catchR) {
        return f301do.get(catchR);
    }

    /* renamed from: do  reason: not valid java name */
    public static void m390do(Ccatch catchR, Boolean bool) {
        f301do.put(catchR, bool);
    }

    /* renamed from: do  reason: not valid java name */
    public static Boolean m387do(Cnew.Cdo doVar) {
        return f303if.get(doVar);
    }

    /* renamed from: do  reason: not valid java name */
    public static void m392do(Cnew.Cdo doVar, Boolean bool) {
        f303if.put(doVar, bool);
    }

    /* renamed from: do  reason: not valid java name */
    public static Object m388do(Cgoto gotoR) {
        return f302for.get(gotoR);
    }

    /* renamed from: do  reason: not valid java name */
    public static void m391do(Cgoto gotoR, Object obj) {
        f302for.put(gotoR, obj);
    }
}
