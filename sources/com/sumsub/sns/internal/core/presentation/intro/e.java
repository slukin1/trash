package com.sumsub.sns.internal.core.presentation.intro;

import kotlin.jvm.internal.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f33868a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33869b;

    /* renamed from: c  reason: collision with root package name */
    public final c f33870c;

    /* renamed from: d  reason: collision with root package name */
    public final c f33871d;

    /* renamed from: e  reason: collision with root package name */
    public final c f33872e;

    /* renamed from: f  reason: collision with root package name */
    public final String f33873f;

    /* renamed from: g  reason: collision with root package name */
    public final String f33874g;

    /* renamed from: h  reason: collision with root package name */
    public final String f33875h;

    /* renamed from: i  reason: collision with root package name */
    public final String f33876i;

    public e(String str, String str2, c cVar, c cVar2, c cVar3, String str3, String str4, String str5, String str6) {
        this.f33868a = str;
        this.f33869b = str2;
        this.f33870c = cVar;
        this.f33871d = cVar2;
        this.f33872e = cVar3;
        this.f33873f = str3;
        this.f33874g = str4;
        this.f33875h = str5;
        this.f33876i = str6;
    }

    public final String a() {
        return this.f33868a;
    }

    public final String b() {
        return this.f33869b;
    }

    public final c c() {
        return this.f33870c;
    }

    public final c d() {
        return this.f33871d;
    }

    public final c e() {
        return this.f33872e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return x.b(this.f33868a, eVar.f33868a) && x.b(this.f33869b, eVar.f33869b) && x.b(this.f33870c, eVar.f33870c) && x.b(this.f33871d, eVar.f33871d) && x.b(this.f33872e, eVar.f33872e) && x.b(this.f33873f, eVar.f33873f) && x.b(this.f33874g, eVar.f33874g) && x.b(this.f33875h, eVar.f33875h) && x.b(this.f33876i, eVar.f33876i);
    }

    public final String f() {
        return this.f33873f;
    }

    public final String g() {
        return this.f33874g;
    }

    public final String h() {
        return this.f33875h;
    }

    public int hashCode() {
        String str = this.f33868a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f33869b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        c cVar = this.f33870c;
        int hashCode3 = (hashCode2 + (cVar == null ? 0 : cVar.hashCode())) * 31;
        c cVar2 = this.f33871d;
        int hashCode4 = (hashCode3 + (cVar2 == null ? 0 : cVar2.hashCode())) * 31;
        c cVar3 = this.f33872e;
        int hashCode5 = (hashCode4 + (cVar3 == null ? 0 : cVar3.hashCode())) * 31;
        String str3 = this.f33873f;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f33874g;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f33875h;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f33876i;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode8 + i11;
    }

    public final String i() {
        return this.f33876i;
    }

    public final String j() {
        return this.f33876i;
    }

    public final c k() {
        return this.f33871d;
    }

    public final c l() {
        return this.f33872e;
    }

    public final String m() {
        return this.f33874g;
    }

    public final String n() {
        return this.f33873f;
    }

    public final c o() {
        return this.f33870c;
    }

    public final String p() {
        return this.f33869b;
    }

    public final String q() {
        return this.f33875h;
    }

    public final String r() {
        return this.f33868a;
    }

    public String toString() {
        return "SNSIntroScreenInfo(title=" + this.f33868a + ", subTitle=" + this.f33869b + ", singleIntro=" + this.f33870c + ", doIntro=" + this.f33871d + ", doNotIntro=" + this.f33872e + ", image=" + this.f33873f + ", header=" + this.f33874g + ", text=" + this.f33875h + ", buttonText=" + this.f33876i + ')';
    }

    public final e a(String str, String str2, c cVar, c cVar2, c cVar3, String str3, String str4, String str5, String str6) {
        return new e(str, str2, cVar, cVar2, cVar3, str3, str4, str5, str6);
    }

    public static /* synthetic */ e a(e eVar, String str, String str2, c cVar, c cVar2, c cVar3, String str3, String str4, String str5, String str6, int i11, Object obj) {
        e eVar2 = eVar;
        int i12 = i11;
        return eVar.a((i12 & 1) != 0 ? eVar2.f33868a : str, (i12 & 2) != 0 ? eVar2.f33869b : str2, (i12 & 4) != 0 ? eVar2.f33870c : cVar, (i12 & 8) != 0 ? eVar2.f33871d : cVar2, (i12 & 16) != 0 ? eVar2.f33872e : cVar3, (i12 & 32) != 0 ? eVar2.f33873f : str3, (i12 & 64) != 0 ? eVar2.f33874g : str4, (i12 & 128) != 0 ? eVar2.f33875h : str5, (i12 & 256) != 0 ? eVar2.f33876i : str6);
    }
}
