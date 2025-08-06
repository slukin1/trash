package com.iproov.sdk.p022package;

import org.json.JSONObject;

/* renamed from: com.iproov.sdk.package.do  reason: invalid class name and invalid package */
public interface Cdo {

    /* renamed from: com.iproov.sdk.package.do$do  reason: invalid class name */
    public static final class Cdo implements Cdo {
        public Cdo(boolean z11) {
        }
    }

    /* renamed from: com.iproov.sdk.package.do$for  reason: invalid class name */
    public static final class Cfor implements Cdo {
        public Cfor(double d11) {
        }
    }

    /* renamed from: com.iproov.sdk.package.do$if  reason: invalid class name */
    public static final class Cif implements Cdo {

        /* renamed from: do  reason: not valid java name */
        private final JSONObject f1083do;

        public Cif(JSONObject jSONObject) {
            this.f1083do = jSONObject;
        }

        /* renamed from: do  reason: not valid java name */
        public final JSONObject m1229do() {
            return this.f1083do;
        }
    }

    /* renamed from: com.iproov.sdk.package.do$new  reason: invalid class name */
    public static final class Cnew implements Cdo {
        public Cnew(String str) {
        }
    }

    /* renamed from: com.iproov.sdk.package.do$try  reason: invalid class name */
    public static final class Ctry implements Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final Ctry f1084do = new Ctry();

        private Ctry() {
        }
    }
}
