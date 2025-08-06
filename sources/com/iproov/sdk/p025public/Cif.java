package com.iproov.sdk.p025public;

import com.iproov.sdk.cameray.Cbreak;
import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.p005class.Celse;

/* renamed from: com.iproov.sdk.public.if  reason: invalid class name and invalid package */
public class Cif {

    /* renamed from: case  reason: not valid java name */
    private final Double f1135case;

    /* renamed from: do  reason: not valid java name */
    private final String f1136do;

    /* renamed from: else  reason: not valid java name */
    private final Celse f1137else;

    /* renamed from: for  reason: not valid java name */
    private final String f1138for;

    /* renamed from: if  reason: not valid java name */
    private final String f1139if;

    /* renamed from: new  reason: not valid java name */
    private final Cbreak f1140new;

    /* renamed from: try  reason: not valid java name */
    private final Cconst f1141try;

    /* renamed from: com.iproov.sdk.public.if$do  reason: invalid class name */
    public static class Cdo {

        /* renamed from: case  reason: not valid java name */
        private Double f1142case;

        /* renamed from: do  reason: not valid java name */
        private String f1143do;

        /* renamed from: else  reason: not valid java name */
        private Celse f1144else;

        /* renamed from: for  reason: not valid java name */
        private String f1145for;

        /* renamed from: if  reason: not valid java name */
        private String f1146if;

        /* renamed from: new  reason: not valid java name */
        private Cbreak f1147new;

        /* renamed from: try  reason: not valid java name */
        private Cconst f1148try;

        public Cdo(String str, String str2, String str3) {
            this.f1143do = str;
            this.f1146if = str2;
            this.f1145for = str3;
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1303do(Cbreak breakR) {
            this.f1147new = breakR;
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1304do(Cconst constR) {
            this.f1148try = constR;
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1305do(Celse elseR) {
            this.f1144else = elseR;
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public Cif m1306do() {
            return new Cif(this.f1143do, this.f1146if, this.f1145for, this.f1147new, this.f1148try, this.f1142case, this.f1144else);
        }
    }

    public Cif(String str, String str2, String str3, Cbreak breakR, Cconst constR, Double d11, Celse elseR) {
        this.f1136do = str;
        this.f1139if = str2;
        this.f1138for = str3;
        this.f1140new = breakR;
        this.f1141try = constR;
        this.f1135case = d11;
        this.f1137else = elseR;
    }

    /* renamed from: case  reason: not valid java name */
    public String m1295case() {
        return this.f1136do;
    }

    /* renamed from: do  reason: not valid java name */
    public Cbreak m1296do() {
        return this.f1140new;
    }

    /* renamed from: else  reason: not valid java name */
    public String m1297else() {
        return this.f1139if;
    }

    /* renamed from: for  reason: not valid java name */
    public Double m1298for() {
        return this.f1135case;
    }

    /* renamed from: goto  reason: not valid java name */
    public boolean m1299goto() {
        return this.f1141try != null;
    }

    /* renamed from: if  reason: not valid java name */
    public Cconst m1300if() {
        return this.f1141try;
    }

    /* renamed from: new  reason: not valid java name */
    public Celse m1301new() {
        return this.f1137else;
    }

    public String toString() {
        return this.f1136do + " | " + this.f1139if + " | " + this.f1138for;
    }

    /* renamed from: try  reason: not valid java name */
    public String m1302try() {
        return this.f1138for;
    }
}
