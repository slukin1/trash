package com.sumsub.sns.internal.fingerprint.infoproviders;

import kotlin.jvm.internal.x;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f34601a;

    public d0(String str) {
        this.f34601a = str;
    }

    public final String a() {
        return this.f34601a;
    }

    public final String b() {
        return this.f34601a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d0) && x.b(this.f34601a, ((d0) obj).f34601a);
    }

    public int hashCode() {
        return this.f34601a.hashCode();
    }

    public String toString() {
        return this.f34601a;
    }

    public final d0 a(String str) {
        return new d0(str);
    }

    public static /* synthetic */ d0 a(d0 d0Var, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = d0Var.f34601a;
        }
        return d0Var.a(str);
    }
}
