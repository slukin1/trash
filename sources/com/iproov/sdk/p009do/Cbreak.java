package com.iproov.sdk.p009do;

import com.iproov.sdk.p017implements.Cthis;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.do.break  reason: invalid class name and invalid package */
public final class Cbreak {

    /* renamed from: do  reason: not valid java name */
    private final j1<Cthis> f455do;

    /* renamed from: for  reason: not valid java name */
    private final j1<Cthis> f456for;

    /* renamed from: if  reason: not valid java name */
    private final j1<Cthis> f457if;

    /* renamed from: new  reason: not valid java name */
    private final j1<Cthis> f458new;

    /* renamed from: com.iproov.sdk.do.break$do  reason: invalid class name */
    public static final class Cdo implements Cif {

        /* renamed from: do  reason: not valid java name */
        private final Cthis f459do;

        /* renamed from: for  reason: not valid java name */
        private final Cthis f460for;

        /* renamed from: if  reason: not valid java name */
        private final Cthis f461if;

        /* renamed from: new  reason: not valid java name */
        private final Cthis f462new;

        public Cdo(Cthis thisR, Cthis thisR2, Cthis thisR3, Cthis thisR4) {
            this.f459do = thisR;
            this.f461if = thisR2;
            this.f460for = thisR3;
            this.f462new = thisR4;
        }

        /* renamed from: do  reason: not valid java name */
        public JSONObject m559do() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ffs", this.f462new.m1041if());
            jSONObject.put("cfs", this.f459do.m1041if());
            jSONObject.put("tte", this.f460for.m1041if());
            jSONObject.put("rfs", this.f461if.m1041if());
            return jSONObject;
        }
    }

    /* renamed from: com.iproov.sdk.do.break$for  reason: invalid class name */
    public static final class Cfor implements Cif {

        /* renamed from: do  reason: not valid java name */
        private final Cdo f463do;

        public Cfor(Cdo doVar) {
            this.f463do = doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public JSONObject m560do() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("telemetry", this.f463do.m559do());
            return jSONObject;
        }

        /* renamed from: if  reason: not valid java name */
        public String m561if() {
            return Cif.Cdo.m563do(this);
        }
    }

    /* renamed from: com.iproov.sdk.do.break$if  reason: invalid class name */
    public interface Cif {

        /* renamed from: com.iproov.sdk.do.break$if$do  reason: invalid class name */
        public static final class Cdo {
            /* renamed from: do  reason: not valid java name */
            public static String m563do(Cif ifVar) {
                return ifVar.m562do().toString();
            }
        }

        /* renamed from: do  reason: not valid java name */
        JSONObject m562do();
    }

    public Cbreak(j1<Cthis> j1Var, j1<Cthis> j1Var2, j1<Cthis> j1Var3, j1<Cthis> j1Var4) {
        this.f455do = j1Var;
        this.f457if = j1Var2;
        this.f456for = j1Var3;
        this.f458new = j1Var4;
    }

    /* renamed from: do  reason: not valid java name */
    public final Cfor m558do() {
        return new Cfor(new Cdo(this.f455do.getValue(), this.f457if.getValue(), this.f456for.getValue(), this.f458new.getValue()));
    }
}
