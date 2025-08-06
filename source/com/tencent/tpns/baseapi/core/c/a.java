package com.tencent.tpns.baseapi.core.c;

public class a {

    /* renamed from: com.tencent.tpns.baseapi.core.c.a$a  reason: collision with other inner class name */
    public enum C0632a {
        CLUSTER_DEFAULT("default", "tpns.tencent.com"),
        CLUSTER_SGP("sgp", "tpns.sgp.tencent.com"),
        CLUSTER_HK("hk", "tpns.hk.tencent.com");
        

        /* renamed from: d  reason: collision with root package name */
        private String f49875d;

        /* renamed from: e  reason: collision with root package name */
        private String f49876e;

        private C0632a(String str, String str2) {
            this.f49875d = str;
            this.f49876e = str2;
        }

        public String a() {
            return this.f49875d;
        }

        public String b() {
            return this.f49876e;
        }
    }
}
