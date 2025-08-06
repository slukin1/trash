package com.iproov.sdk.p035try;

/* renamed from: com.iproov.sdk.try.do  reason: invalid class name and invalid package */
public final class Cdo {

    /* renamed from: do  reason: not valid java name */
    private String f2296do = "";

    /* renamed from: if  reason: not valid java name */
    private String f2297if;

    public Cdo(boolean z11, String str, String str2) {
        String str3;
        if (z11) {
            str3 = "Passed";
        } else {
            str3 = "";
        }
        this.f2296do = str3;
        this.f2297if = str.replaceFirst("ufc_", "");
    }

    /* renamed from: do  reason: not valid java name */
    public String m2126do() {
        return this.f2297if;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m2127if() {
        return this.f2296do.equals("Passed");
    }
}
