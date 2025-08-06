package com.sumsub.sns.internal.core.data.source.applicant.remote;

import kotlin.jvm.internal.x;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f33186a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33187b;

    public l(String str, String str2) {
        this.f33186a = str;
        this.f33187b = str2;
    }

    public final String a() {
        return this.f33186a;
    }

    public final String b() {
        return this.f33187b;
    }

    public final String c() {
        return this.f33186a;
    }

    public final String d() {
        return this.f33187b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return x.b(this.f33186a, lVar.f33186a) && x.b(this.f33187b, lVar.f33187b);
    }

    public int hashCode() {
        return (this.f33186a.hashCode() * 31) + this.f33187b.hashCode();
    }

    public String toString() {
        return "KeyValue(key=" + this.f33186a + ", value=" + this.f33187b + ')';
    }

    public final l a(String str, String str2) {
        return new l(str, str2);
    }

    public static /* synthetic */ l a(l lVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = lVar.f33186a;
        }
        if ((i11 & 2) != 0) {
            str2 = lVar.f33187b;
        }
        return lVar.a(str, str2);
    }
}
