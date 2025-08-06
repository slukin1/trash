package com.sumsub.sns.internal.fingerprint.infoproviders;

import kotlin.jvm.internal.x;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final String f34650a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34651b;

    public v(String str, String str2) {
        this.f34650a = str;
        this.f34651b = str2;
    }

    public final String a() {
        return this.f34650a;
    }

    public final String b() {
        return this.f34651b;
    }

    public final String c() {
        return this.f34650a;
    }

    public final String d() {
        return this.f34651b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return x.b(this.f34650a, vVar.f34650a) && x.b(this.f34651b, vVar.f34651b);
    }

    public int hashCode() {
        return (this.f34650a.hashCode() * 31) + this.f34651b.hashCode();
    }

    public String toString() {
        return "InputDeviceData(name=" + this.f34650a + ", vendor=" + this.f34651b + ')';
    }

    public final v a(String str, String str2) {
        return new v(str, str2);
    }

    public static /* synthetic */ v a(v vVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vVar.f34650a;
        }
        if ((i11 & 2) != 0) {
            str2 = vVar.f34651b;
        }
        return vVar.a(str, str2);
    }
}
