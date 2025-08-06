package com.sumsub.sns.internal.core.data.model;

import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.core.data.model.FlowType;
import com.sumsub.sns.internal.core.data.model.remote.c;
import com.sumsub.sns.internal.core.data.model.remote.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f32530a;

    /* renamed from: b  reason: collision with root package name */
    public final FlowType f32531b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32532c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Object> f32533d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Object> f32534e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f32535f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, c> f32536g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, String> f32537h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, o> f32538i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, Map<String, String>> f32539j;

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, List<j>> f32540k;

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, Map<String, String>> f32541l;

    /* renamed from: m  reason: collision with root package name */
    public final Map<String, w> f32542m;

    /* renamed from: n  reason: collision with root package name */
    public final String f32543n;

    /* renamed from: o  reason: collision with root package name */
    public final String f32544o;

    /* renamed from: p  reason: collision with root package name */
    public a f32545p;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f32546a;

        /* renamed from: b  reason: collision with root package name */
        public final FlowActionType f32547b;

        public a(String str, FlowActionType flowActionType) {
            this.f32546a = str;
            this.f32547b = flowActionType;
        }

        public final String a() {
            return this.f32546a;
        }

        public final FlowActionType b() {
            return this.f32547b;
        }

        public final String c() {
            return this.f32546a;
        }

        public final FlowActionType d() {
            return this.f32547b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f32546a, aVar.f32546a) && x.b(this.f32547b, aVar.f32547b);
        }

        public int hashCode() {
            return (this.f32546a.hashCode() * 31) + this.f32547b.hashCode();
        }

        public String toString() {
            return "Action(id=" + this.f32546a + ", type=" + this.f32547b + ')';
        }

        public final a a(String str, FlowActionType flowActionType) {
            return new a(str, flowActionType);
        }

        public static /* synthetic */ a a(a aVar, String str, FlowActionType flowActionType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = aVar.f32546a;
            }
            if ((i11 & 2) != 0) {
                flowActionType = aVar.f32547b;
            }
            return aVar.a(str, flowActionType);
        }
    }

    public e(String str, FlowType flowType, String str2, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3, Map<String, c> map4, Map<String, String> map5, Map<String, o> map6, Map<String, ? extends Map<String, String>> map7, Map<String, ? extends List<j>> map8, Map<String, ? extends Map<String, String>> map9, Map<String, w> map10, String str3, String str4, a aVar) {
        this.f32530a = str;
        this.f32531b = flowType;
        this.f32532c = str2;
        this.f32533d = map;
        this.f32534e = map2;
        this.f32535f = map3;
        this.f32536g = map4;
        this.f32537h = map5;
        this.f32538i = map6;
        this.f32539j = map7;
        this.f32540k = map8;
        this.f32541l = map9;
        this.f32542m = map10;
        this.f32543n = str3;
        this.f32544o = str4;
        this.f32545p = aVar;
    }

    public final Map<String, String> A() {
        return this.f32537h;
    }

    public final Map<String, c> B() {
        return this.f32536g;
    }

    public final Map<String, Object> C() {
        return this.f32533d;
    }

    public final Map<String, o> D() {
        return this.f32538i;
    }

    public final Map<String, Object> E() {
        return this.f32535f;
    }

    public final String F() {
        return this.f32543n;
    }

    public final String a() {
        return this.f32530a;
    }

    public final Map<String, Map<String, String>> b() {
        return this.f32539j;
    }

    public final Map<String, List<j>> c() {
        return this.f32540k;
    }

    public final Map<String, Map<String, String>> d() {
        return this.f32541l;
    }

    public final Map<String, w> e() {
        return this.f32542m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return x.b(this.f32530a, eVar.f32530a) && this.f32531b == eVar.f32531b && x.b(this.f32532c, eVar.f32532c) && x.b(this.f32533d, eVar.f32533d) && x.b(this.f32534e, eVar.f32534e) && x.b(this.f32535f, eVar.f32535f) && x.b(this.f32536g, eVar.f32536g) && x.b(this.f32537h, eVar.f32537h) && x.b(this.f32538i, eVar.f32538i) && x.b(this.f32539j, eVar.f32539j) && x.b(this.f32540k, eVar.f32540k) && x.b(this.f32541l, eVar.f32541l) && x.b(this.f32542m, eVar.f32542m) && x.b(this.f32543n, eVar.f32543n) && x.b(this.f32544o, eVar.f32544o) && x.b(this.f32545p, eVar.f32545p);
    }

    public final String f() {
        return this.f32543n;
    }

    public final String g() {
        return this.f32544o;
    }

    public final a h() {
        return this.f32545p;
    }

    public int hashCode() {
        int hashCode = ((this.f32530a.hashCode() * 31) + this.f32531b.hashCode()) * 31;
        String str = this.f32532c;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Object> map = this.f32533d;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Object> map2 = this.f32534e;
        int hashCode4 = (hashCode3 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, Object> map3 = this.f32535f;
        int hashCode5 = (hashCode4 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, c> map4 = this.f32536g;
        int hashCode6 = (hashCode5 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, String> map5 = this.f32537h;
        int hashCode7 = (hashCode6 + (map5 == null ? 0 : map5.hashCode())) * 31;
        Map<String, o> map6 = this.f32538i;
        int hashCode8 = (hashCode7 + (map6 == null ? 0 : map6.hashCode())) * 31;
        Map<String, Map<String, String>> map7 = this.f32539j;
        int hashCode9 = (hashCode8 + (map7 == null ? 0 : map7.hashCode())) * 31;
        Map<String, List<j>> map8 = this.f32540k;
        int hashCode10 = (hashCode9 + (map8 == null ? 0 : map8.hashCode())) * 31;
        Map<String, Map<String, String>> map9 = this.f32541l;
        int hashCode11 = (hashCode10 + (map9 == null ? 0 : map9.hashCode())) * 31;
        Map<String, w> map10 = this.f32542m;
        int hashCode12 = (hashCode11 + (map10 == null ? 0 : map10.hashCode())) * 31;
        String str2 = this.f32543n;
        int hashCode13 = (hashCode12 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f32544o;
        int hashCode14 = (hashCode13 + (str3 == null ? 0 : str3.hashCode())) * 31;
        a aVar = this.f32545p;
        if (aVar != null) {
            i11 = aVar.hashCode();
        }
        return hashCode14 + i11;
    }

    public final FlowType i() {
        return this.f32531b;
    }

    public final String j() {
        return this.f32532c;
    }

    public final Map<String, Object> k() {
        return this.f32533d;
    }

    public final Map<String, Object> l() {
        return this.f32534e;
    }

    public final Map<String, Object> m() {
        return this.f32535f;
    }

    public final Map<String, c> n() {
        return this.f32536g;
    }

    public final Map<String, String> o() {
        return this.f32537h;
    }

    public final Map<String, o> p() {
        return this.f32538i;
    }

    public final String q() {
        return this.f32544o;
    }

    public final a r() {
        return this.f32545p;
    }

    public final String s() {
        return this.f32530a;
    }

    public final Map<String, Map<String, String>> t() {
        return this.f32541l;
    }

    public String toString() {
        return "AppConfig(applicantId=" + this.f32530a + ", flowType=" + this.f32531b + ", idDocSetType=" + this.f32532c + ", sdkDict=" + this.f32533d + ", documentsByCountries=" + this.f32534e + ", uiConf=" + this.f32535f + ", phoneCountryCodeWithMasks=" + this.f32536g + ", initMetadata=" + this.f32537h + ", tinCountryInfo=" + this.f32538i + ", countryStates=" + this.f32539j + ", eKycConfig=" + this.f32540k + ", countryDependingFields=" + this.f32541l + ", ekycSources=" + this.f32542m + ", verificationUrl=" + this.f32543n + ", accessToken=" + this.f32544o + ", action=" + this.f32545p + ')';
    }

    public final Map<String, Map<String, String>> u() {
        return this.f32539j;
    }

    public final Map<String, Object> v() {
        return this.f32534e;
    }

    public final Map<String, List<j>> w() {
        return this.f32540k;
    }

    public final Map<String, w> x() {
        return this.f32542m;
    }

    public final FlowType y() {
        return this.f32531b;
    }

    public final String z() {
        return this.f32532c;
    }

    public final e a(String str, FlowType flowType, String str2, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3, Map<String, c> map4, Map<String, String> map5, Map<String, o> map6, Map<String, ? extends Map<String, String>> map7, Map<String, ? extends List<j>> map8, Map<String, ? extends Map<String, String>> map9, Map<String, w> map10, String str3, String str4, a aVar) {
        return new e(str, flowType, str2, map, map2, map3, map4, map5, map6, map7, map8, map9, map10, str3, str4, aVar);
    }

    public static /* synthetic */ e a(e eVar, String str, FlowType flowType, String str2, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, Map map9, Map map10, String str3, String str4, a aVar, int i11, Object obj) {
        e eVar2 = eVar;
        int i12 = i11;
        return eVar.a((i12 & 1) != 0 ? eVar2.f32530a : str, (i12 & 2) != 0 ? eVar2.f32531b : flowType, (i12 & 4) != 0 ? eVar2.f32532c : str2, (i12 & 8) != 0 ? eVar2.f32533d : map, (i12 & 16) != 0 ? eVar2.f32534e : map2, (i12 & 32) != 0 ? eVar2.f32535f : map3, (i12 & 64) != 0 ? eVar2.f32536g : map4, (i12 & 128) != 0 ? eVar2.f32537h : map5, (i12 & 256) != 0 ? eVar2.f32538i : map6, (i12 & 512) != 0 ? eVar2.f32539j : map7, (i12 & 1024) != 0 ? eVar2.f32540k : map8, (i12 & 2048) != 0 ? eVar2.f32541l : map9, (i12 & 4096) != 0 ? eVar2.f32542m : map10, (i12 & 8192) != 0 ? eVar2.f32543n : str3, (i12 & 16384) != 0 ? eVar2.f32544o : str4, (i12 & 32768) != 0 ? eVar2.f32545p : aVar);
    }

    public final void a(a aVar) {
        this.f32545p = aVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(String str, FlowType flowType, String str2, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, Map map9, Map map10, String str3, String str4, a aVar, int i11, r rVar) {
        this(str, flowType, str2, map, map2, map3, map4, map5, map6, map7, map8, map9, map10, str3, str4, (i11 & 32768) != 0 ? null : aVar);
    }
}
