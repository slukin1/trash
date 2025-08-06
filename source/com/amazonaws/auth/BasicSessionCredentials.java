package com.amazonaws.auth;

public class BasicSessionCredentials implements AWSSessionCredentials {

    /* renamed from: a  reason: collision with root package name */
    public final String f14838a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14839b;

    /* renamed from: c  reason: collision with root package name */
    public final String f14840c;

    public BasicSessionCredentials(String str, String str2, String str3) {
        this.f14838a = str;
        this.f14839b = str2;
        this.f14840c = str3;
    }

    public String a() {
        return this.f14838a;
    }

    public String b() {
        return this.f14839b;
    }

    public String getSessionToken() {
        return this.f14840c;
    }
}
