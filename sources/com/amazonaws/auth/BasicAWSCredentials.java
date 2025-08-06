package com.amazonaws.auth;

public class BasicAWSCredentials implements AWSCredentials {

    /* renamed from: a  reason: collision with root package name */
    public final String f14836a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14837b;

    public BasicAWSCredentials(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Access key cannot be null.");
        } else if (str2 != null) {
            this.f14836a = str;
            this.f14837b = str2;
        } else {
            throw new IllegalArgumentException("Secret key cannot be null.");
        }
    }

    public String a() {
        return this.f14836a;
    }

    public String b() {
        return this.f14837b;
    }
}
