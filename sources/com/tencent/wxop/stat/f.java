package com.tencent.wxop.stat;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private String f51064a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f51065b = null;

    /* renamed from: ba  reason: collision with root package name */
    private boolean f51066ba = false;

    /* renamed from: bb  reason: collision with root package name */
    private boolean f51067bb = false;

    /* renamed from: c  reason: collision with root package name */
    private String f51068c = null;

    public final boolean R() {
        return this.f51066ba;
    }

    public final String S() {
        return this.f51064a;
    }

    public final String T() {
        return this.f51065b;
    }

    public final boolean U() {
        return this.f51067bb;
    }

    public final String getVersion() {
        return this.f51068c;
    }

    public final void s(String str) {
        this.f51064a = str;
    }

    public final String toString() {
        return "StatSpecifyReportedInfo [appKey=" + this.f51064a + ", installChannel=" + this.f51065b + ", version=" + this.f51068c + ", sendImmediately=" + this.f51066ba + ", isImportant=" + this.f51067bb + "]";
    }
}
