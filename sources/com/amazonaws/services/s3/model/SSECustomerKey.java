package com.amazonaws.services.s3.model;

public class SSECustomerKey {

    /* renamed from: a  reason: collision with root package name */
    public final String f15347a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f15348b;

    /* renamed from: c  reason: collision with root package name */
    public String f15349c;

    private SSECustomerKey() {
    }

    public static SSECustomerKey a(String str) {
        if (str != null) {
            return new SSECustomerKey().f(str);
        }
        throw new IllegalArgumentException();
    }

    public String b() {
        return this.f15349c;
    }

    public String c() {
        return this.f15347a;
    }

    public String d() {
        return this.f15348b;
    }

    public void e(String str) {
        this.f15349c = str;
    }

    public SSECustomerKey f(String str) {
        e(str);
        return this;
    }
}
