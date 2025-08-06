package com.sumsub.sns.internal.fingerprint.infoproviders;

import kotlin.jvm.internal.x;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f34598a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34599b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34600c;

    public d(String str, String str2, String str3) {
        this.f34598a = str;
        this.f34599b = str2;
        this.f34600c = str3;
    }

    public final String a() {
        return this.f34598a;
    }

    public final String b() {
        return this.f34599b;
    }

    public final String c() {
        return this.f34600c;
    }

    public final String d() {
        return this.f34598a;
    }

    public final String e() {
        return this.f34600c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return x.b(this.f34598a, dVar.f34598a) && x.b(this.f34599b, dVar.f34599b) && x.b(this.f34600c, dVar.f34600c);
    }

    public final String f() {
        return this.f34599b;
    }

    public int hashCode() {
        return (((this.f34598a.hashCode() * 31) + this.f34599b.hashCode()) * 31) + this.f34600c.hashCode();
    }

    public String toString() {
        return "CameraInfo(cameraName=" + this.f34598a + ", cameraType=" + this.f34599b + ", cameraOrientation=" + this.f34600c + ')';
    }

    public final d a(String str, String str2, String str3) {
        return new d(str, str2, str3);
    }

    public static /* synthetic */ d a(d dVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dVar.f34598a;
        }
        if ((i11 & 2) != 0) {
            str2 = dVar.f34599b;
        }
        if ((i11 & 4) != 0) {
            str3 = dVar.f34600c;
        }
        return dVar.a(str, str2, str3);
    }
}
