package com.iproov.sdk.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.iproov.sdk.core.break  reason: invalid class name */
public class Cbreak {

    /* renamed from: do  reason: not valid java name */
    public static final Map<Ccatch, Cdo> f229do = new HashMap();

    /* renamed from: com.iproov.sdk.core.break$do  reason: invalid class name */
    public static class Cdo {

        /* renamed from: do  reason: not valid java name */
        private long f230do;

        /* renamed from: if  reason: not valid java name */
        public Boolean f231if = null;

        public Cdo(Ccatch catchR) {
        }

        /* renamed from: do  reason: not valid java name */
        public synchronized long m311do() {
            return this.f230do;
        }

        /* renamed from: do  reason: not valid java name */
        public synchronized void m312do(long j11) {
            this.f230do = j11;
        }
    }

    /* renamed from: com.iproov.sdk.core.break$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: do  reason: not valid java name */
        public final String f232do;

        /* renamed from: if  reason: not valid java name */
        public final String f233if;

        public Cif(StackTraceElement stackTraceElement) {
            this.f232do = stackTraceElement.getClassName();
            this.f233if = stackTraceElement.getMethodName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Cif.class != obj.getClass()) {
                return false;
            }
            Cif ifVar = (Cif) obj;
            if (!Objects.equals(this.f232do, ifVar.f232do) || !Objects.equals(this.f233if, ifVar.f233if)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f232do, this.f233if});
        }

        public String toString() {
            return "M{c='" + this.f232do + '\'' + ", m='" + this.f233if + '\'' + '}';
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m310do(Ccatch catchR) {
        boolean z11;
        boolean z12;
        Map<Ccatch, Cdo> map = f229do;
        Cdo doVar = map.get(catchR);
        long currentTimeMillis = System.currentTimeMillis();
        if (doVar == null) {
            doVar = new Cdo(catchR);
            map.put(catchR, doVar);
        } else if (doVar.f231if == Boolean.FALSE || doVar.m311do() > currentTimeMillis) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 5) {
            Cif ifVar = new Cif(stackTrace[3]);
            Cif ifVar2 = new Cif(stackTrace[4]);
            Iterator<String> it2 = catchR.m332if().iterator();
            while (true) {
                z11 = true;
                if (!it2.hasNext()) {
                    z12 = false;
                    break;
                }
                if (ifVar.f232do.startsWith(it2.next())) {
                    z12 = true;
                    break;
                }
            }
            boolean z13 = z12 && !ifVar.equals(ifVar2);
            Boolean bool = doVar.f231if;
            if (bool == null) {
                z11 = z13;
            } else if (!bool.booleanValue() || !z13) {
                z11 = false;
            }
            Boolean valueOf = Boolean.valueOf(z11);
            doVar.f231if = valueOf;
            Cfinal.m390do(catchR, valueOf);
        }
        doVar.m312do(currentTimeMillis + catchR.m331for());
    }
}
