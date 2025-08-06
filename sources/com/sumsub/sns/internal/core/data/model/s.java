package com.sumsub.sns.internal.core.data.model;

import kotlin.jvm.internal.x;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final String f32916a;

    /* renamed from: b  reason: collision with root package name */
    public final Document f32917b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32918c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32919d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32920e;

    /* renamed from: f  reason: collision with root package name */
    public final String f32921f;

    /* renamed from: g  reason: collision with root package name */
    public final String f32922g;

    public s(String str, Document document, String str2, String str3, String str4, String str5, String str6) {
        this.f32916a = str;
        this.f32917b = document;
        this.f32918c = str2;
        this.f32919d = str3;
        this.f32920e = str4;
        this.f32921f = str5;
        this.f32922g = str6;
    }

    public final String a() {
        return this.f32916a;
    }

    public final Document b() {
        return this.f32917b;
    }

    public final String c() {
        return this.f32918c;
    }

    public final String d() {
        return this.f32919d;
    }

    public final String e() {
        return this.f32920e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return x.b(this.f32916a, sVar.f32916a) && x.b(this.f32917b, sVar.f32917b) && x.b(this.f32918c, sVar.f32918c) && x.b(this.f32919d, sVar.f32919d) && x.b(this.f32920e, sVar.f32920e) && x.b(this.f32921f, sVar.f32921f) && x.b(this.f32922g, sVar.f32922g);
    }

    public final String f() {
        return this.f32921f;
    }

    public final String g() {
        return this.f32922g;
    }

    public final String h() {
        return this.f32916a;
    }

    public int hashCode() {
        int hashCode = ((this.f32916a.hashCode() * 31) + this.f32917b.hashCode()) * 31;
        String str = this.f32918c;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f32919d;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f32920e;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f32921f;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f32922g;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode5 + i11;
    }

    public final String i() {
        return this.f32919d;
    }

    public final Document j() {
        return this.f32917b;
    }

    public final String k() {
        return this.f32918c;
    }

    public final String l() {
        return this.f32922g;
    }

    public final String m() {
        return this.f32921f;
    }

    public final String n() {
        return this.f32920e;
    }

    public String toString() {
        return "MRTDDocument(applicantId=" + this.f32916a + ", document=" + this.f32917b + ", idDocType=" + this.f32918c + ", country=" + this.f32919d + ", mrtdSeed=" + this.f32920e + ", mrtdDataFilesToRead=" + this.f32921f + ", imageId=" + this.f32922g + ')';
    }

    public final s a(String str, Document document, String str2, String str3, String str4, String str5, String str6) {
        return new s(str, document, str2, str3, str4, str5, str6);
    }

    public static /* synthetic */ s a(s sVar, String str, Document document, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sVar.f32916a;
        }
        if ((i11 & 2) != 0) {
            document = sVar.f32917b;
        }
        Document document2 = document;
        if ((i11 & 4) != 0) {
            str2 = sVar.f32918c;
        }
        String str7 = str2;
        if ((i11 & 8) != 0) {
            str3 = sVar.f32919d;
        }
        String str8 = str3;
        if ((i11 & 16) != 0) {
            str4 = sVar.f32920e;
        }
        String str9 = str4;
        if ((i11 & 32) != 0) {
            str5 = sVar.f32921f;
        }
        String str10 = str5;
        if ((i11 & 64) != 0) {
            str6 = sVar.f32922g;
        }
        return sVar.a(str, document2, str7, str8, str9, str10, str6);
    }
}
