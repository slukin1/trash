package com.sumsub.sns.internal.core.presentation.intro;

import kotlin.jvm.internal.x;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f33865a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33866b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33867c;

    public c(String str, String str2, String str3) {
        this.f33865a = str;
        this.f33866b = str2;
        this.f33867c = str3;
    }

    public final String a() {
        return this.f33865a;
    }

    public final String b() {
        return this.f33866b;
    }

    public final String c() {
        return this.f33867c;
    }

    public final String d() {
        return this.f33867c;
    }

    public final String e() {
        return this.f33866b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return x.b(this.f33865a, cVar.f33865a) && x.b(this.f33866b, cVar.f33866b) && x.b(this.f33867c, cVar.f33867c);
    }

    public final String f() {
        return this.f33865a;
    }

    public int hashCode() {
        return (((this.f33865a.hashCode() * 31) + this.f33866b.hashCode()) * 31) + this.f33867c.hashCode();
    }

    public String toString() {
        return "SNSIntroItem(title=" + this.f33865a + ", subTitle=" + this.f33866b + ", iconKey=" + this.f33867c + ')';
    }

    public final c a(String str, String str2, String str3) {
        return new c(str, str2, str3);
    }

    public static /* synthetic */ c a(c cVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cVar.f33865a;
        }
        if ((i11 & 2) != 0) {
            str2 = cVar.f33866b;
        }
        if ((i11 & 4) != 0) {
            str3 = cVar.f33867c;
        }
        return cVar.a(str, str2, str3);
    }
}
