package com.sumsub.sns.internal.fingerprint.signalproviders;

import java.util.Map;

public abstract class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f34660a;

    /* renamed from: b  reason: collision with root package name */
    public final T f34661b;

    public d(String str, T t11) {
        this.f34660a = str;
        this.f34661b = t11;
    }

    public final String a() {
        return this.f34660a;
    }

    public final T b() {
        return this.f34661b;
    }

    public abstract Map<String, Object> c();
}
