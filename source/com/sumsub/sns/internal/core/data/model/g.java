package com.sumsub.sns.internal.core.data.model;

import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f32548a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32549b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32550c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32551d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32552e;

    /* renamed from: f  reason: collision with root package name */
    public final String f32553f;

    /* renamed from: g  reason: collision with root package name */
    public final c f32554g;

    /* renamed from: h  reason: collision with root package name */
    public final String f32555h;

    /* renamed from: i  reason: collision with root package name */
    public final b f32556i;

    /* renamed from: j  reason: collision with root package name */
    public d f32557j;

    /* renamed from: k  reason: collision with root package name */
    public final String f32558k;

    /* renamed from: l  reason: collision with root package name */
    public final a f32559l;

    /* renamed from: m  reason: collision with root package name */
    public final String f32560m;

    /* renamed from: n  reason: collision with root package name */
    public final List<b> f32561n;

    /* renamed from: o  reason: collision with root package name */
    public final String f32562o;

    /* renamed from: p  reason: collision with root package name */
    public final String f32563p;

    /* renamed from: q  reason: collision with root package name */
    public final List<u> f32564q;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f32565a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32566b;

        /* renamed from: c  reason: collision with root package name */
        public final String f32567c;

        /* renamed from: d  reason: collision with root package name */
        public final String f32568d;

        /* renamed from: e  reason: collision with root package name */
        public final String f32569e;

        /* renamed from: f  reason: collision with root package name */
        public final String f32570f;

        /* renamed from: g  reason: collision with root package name */
        public final String f32571g;

        /* renamed from: h  reason: collision with root package name */
        public final String f32572h;

        /* renamed from: i  reason: collision with root package name */
        public final String f32573i;

        /* renamed from: j  reason: collision with root package name */
        public final String f32574j;

        /* renamed from: k  reason: collision with root package name */
        public final String f32575k;

        /* renamed from: l  reason: collision with root package name */
        public final List<Map<String, String>> f32576l;

        /* renamed from: m  reason: collision with root package name */
        public final String f32577m;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends Map<String, String>> list, String str12) {
            this.f32565a = str;
            this.f32566b = str2;
            this.f32567c = str3;
            this.f32568d = str4;
            this.f32569e = str5;
            this.f32570f = str6;
            this.f32571g = str7;
            this.f32572h = str8;
            this.f32573i = str9;
            this.f32574j = str10;
            this.f32575k = str11;
            this.f32576l = list;
            this.f32577m = str12;
        }

        public final String a() {
            return this.f32565a;
        }

        public final String b() {
            return this.f32574j;
        }

        public final String c() {
            return this.f32575k;
        }

        public final List<Map<String, String>> d() {
            return this.f32576l;
        }

        public final String e() {
            return this.f32577m;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f32565a, aVar.f32565a) && x.b(this.f32566b, aVar.f32566b) && x.b(this.f32567c, aVar.f32567c) && x.b(this.f32568d, aVar.f32568d) && x.b(this.f32569e, aVar.f32569e) && x.b(this.f32570f, aVar.f32570f) && x.b(this.f32571g, aVar.f32571g) && x.b(this.f32572h, aVar.f32572h) && x.b(this.f32573i, aVar.f32573i) && x.b(this.f32574j, aVar.f32574j) && x.b(this.f32575k, aVar.f32575k) && x.b(this.f32576l, aVar.f32576l) && x.b(this.f32577m, aVar.f32577m);
        }

        public final String f() {
            return this.f32566b;
        }

        public final String g() {
            return this.f32567c;
        }

        public final String h() {
            return this.f32568d;
        }

        public int hashCode() {
            String str = this.f32565a;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f32566b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f32567c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f32568d;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f32569e;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f32570f;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.f32571g;
            int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.f32572h;
            int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.f32573i;
            int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.f32574j;
            int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.f32575k;
            int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
            List<Map<String, String>> list = this.f32576l;
            int hashCode12 = (hashCode11 + (list == null ? 0 : list.hashCode())) * 31;
            String str12 = this.f32577m;
            if (str12 != null) {
                i11 = str12.hashCode();
            }
            return hashCode12 + i11;
        }

        public final String i() {
            return this.f32569e;
        }

        public final String j() {
            return this.f32570f;
        }

        public final String k() {
            return this.f32571g;
        }

        public final String l() {
            return this.f32572h;
        }

        public final String m() {
            return this.f32573i;
        }

        public final List<Map<String, String>> n() {
            return this.f32576l;
        }

        public final String o() {
            return this.f32565a;
        }

        public final String p() {
            return this.f32573i;
        }

        public final String q() {
            return this.f32571g;
        }

        public final String r() {
            return this.f32566b;
        }

        public final String s() {
            return this.f32570f;
        }

        public final String t() {
            return this.f32567c;
        }

        public String toString() {
            return "Info(country=" + this.f32565a + ", firstName=" + this.f32566b + ", lastName=" + this.f32567c + ", middleName=" + this.f32568d + ", legalName=" + this.f32569e + ", gender=" + this.f32570f + ", dob=" + this.f32571g + ", placeOfBirth=" + this.f32572h + ", countryOfBirth=" + this.f32573i + ", stateOfBirth=" + this.f32574j + ", nationality=" + this.f32575k + ", addresses=" + this.f32576l + ", tin=" + this.f32577m + ')';
        }

        public final String u() {
            return this.f32569e;
        }

        public final String v() {
            return this.f32568d;
        }

        public final String w() {
            return this.f32575k;
        }

        public final String x() {
            return this.f32572h;
        }

        public final String y() {
            return this.f32574j;
        }

        public final String z() {
            return this.f32577m;
        }

        public final a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends Map<String, String>> list, String str12) {
            return new a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, list, str12);
        }

        public static /* synthetic */ a a(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, String str12, int i11, Object obj) {
            a aVar2 = aVar;
            int i12 = i11;
            return aVar.a((i12 & 1) != 0 ? aVar2.f32565a : str, (i12 & 2) != 0 ? aVar2.f32566b : str2, (i12 & 4) != 0 ? aVar2.f32567c : str3, (i12 & 8) != 0 ? aVar2.f32568d : str4, (i12 & 16) != 0 ? aVar2.f32569e : str5, (i12 & 32) != 0 ? aVar2.f32570f : str6, (i12 & 64) != 0 ? aVar2.f32571g : str7, (i12 & 128) != 0 ? aVar2.f32572h : str8, (i12 & 256) != 0 ? aVar2.f32573i : str9, (i12 & 512) != 0 ? aVar2.f32574j : str10, (i12 & 1024) != 0 ? aVar2.f32575k : str11, (i12 & 2048) != 0 ? aVar2.f32576l : list, (i12 & 4096) != 0 ? aVar2.f32577m : str12);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f32578a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32579b;

        public b(String str, String str2) {
            this.f32578a = str;
            this.f32579b = str2;
        }

        public final String a() {
            return this.f32578a;
        }

        public final String b() {
            return this.f32579b;
        }

        public final String c() {
            return this.f32578a;
        }

        public final String d() {
            return this.f32579b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f32578a, bVar.f32578a) && x.b(this.f32579b, bVar.f32579b);
        }

        public int hashCode() {
            return (this.f32578a.hashCode() * 31) + this.f32579b.hashCode();
        }

        public String toString() {
            return "MetaValue(key=" + this.f32578a + ", value=" + this.f32579b + ')';
        }

        public final b a(String str, String str2) {
            return new b(str, str2);
        }

        public static /* synthetic */ b a(b bVar, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bVar.f32578a;
            }
            if ((i11 & 2) != 0) {
                str2 = bVar.f32579b;
            }
            return bVar.a(str, str2);
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final List<a> f32580a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32581b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f32582c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f32583d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f32584e;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f32585f;

        public static final class a {

            /* renamed from: j  reason: collision with root package name */
            public static final C0338a f32586j = new C0338a((r) null);

            /* renamed from: k  reason: collision with root package name */
            public static final String f32587k = "seamless";

            /* renamed from: l  reason: collision with root package name */
            public static final String f32588l = "manualonly";

            /* renamed from: m  reason: collision with root package name */
            public static final String f32589m = "manualandauto";

            /* renamed from: a  reason: collision with root package name */
            public final DocumentType f32590a;

            /* renamed from: b  reason: collision with root package name */
            public final List<String> f32591b;

            /* renamed from: c  reason: collision with root package name */
            public final List<IdentitySide> f32592c;

            /* renamed from: d  reason: collision with root package name */
            public final String f32593d;

            /* renamed from: e  reason: collision with root package name */
            public final List<h.d> f32594e;

            /* renamed from: f  reason: collision with root package name */
            public final List<h.c> f32595f;

            /* renamed from: g  reason: collision with root package name */
            public final String f32596g;

            /* renamed from: h  reason: collision with root package name */
            public final String f32597h;

            /* renamed from: i  reason: collision with root package name */
            public final String f32598i;

            /* renamed from: com.sumsub.sns.internal.core.data.model.g$c$a$a  reason: collision with other inner class name */
            public static final class C0338a {
                public /* synthetic */ C0338a(r rVar) {
                    this();
                }

                public C0338a() {
                }
            }

            public a(DocumentType documentType, List<String> list, List<? extends IdentitySide> list2, String str, List<h.d> list3, List<h.c> list4, String str2, String str3, String str4) {
                this.f32590a = documentType;
                this.f32591b = list;
                this.f32592c = list2;
                this.f32593d = str;
                this.f32594e = list3;
                this.f32595f = list4;
                this.f32596g = str2;
                this.f32597h = str3;
                this.f32598i = str4;
            }

            public final DocumentType a() {
                return this.f32590a;
            }

            public final List<String> b() {
                return this.f32591b;
            }

            public final List<IdentitySide> c() {
                return this.f32592c;
            }

            public final String d() {
                return this.f32593d;
            }

            public final List<h.d> e() {
                return this.f32594e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return x.b(this.f32590a, aVar.f32590a) && x.b(this.f32591b, aVar.f32591b) && x.b(this.f32592c, aVar.f32592c) && x.b(this.f32593d, aVar.f32593d) && x.b(this.f32594e, aVar.f32594e) && x.b(this.f32595f, aVar.f32595f) && x.b(this.f32596g, aVar.f32596g) && x.b(this.f32597h, aVar.f32597h) && x.b(this.f32598i, aVar.f32598i);
            }

            public final List<h.c> f() {
                return this.f32595f;
            }

            public final String g() {
                return this.f32596g;
            }

            public final String h() {
                return this.f32597h;
            }

            public int hashCode() {
                int hashCode = ((((this.f32590a.hashCode() * 31) + this.f32591b.hashCode()) * 31) + this.f32592c.hashCode()) * 31;
                String str = this.f32593d;
                int i11 = 0;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                List<h.d> list = this.f32594e;
                int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
                List<h.c> list2 = this.f32595f;
                int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
                String str2 = this.f32596g;
                int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f32597h;
                int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f32598i;
                if (str4 != null) {
                    i11 = str4.hashCode();
                }
                return hashCode6 + i11;
            }

            public final String i() {
                return this.f32598i;
            }

            public final String j() {
                return this.f32598i;
            }

            public final List<h.c> k() {
                return this.f32595f;
            }

            public final List<h.d> l() {
                return this.f32594e;
            }

            public final DocumentType m() {
                return this.f32590a;
            }

            public final String n() {
                return this.f32597h;
            }

            public final String o() {
                return this.f32596g;
            }

            public final List<IdentitySide> p() {
                return this.f32592c;
            }

            public final List<String> q() {
                return this.f32591b;
            }

            public final String r() {
                return this.f32593d;
            }

            public final boolean s() {
                String str = this.f32598i;
                return !x.b(str != null ? str.toLowerCase(Locale.ROOT) : null, f32588l);
            }

            public final boolean t() {
                String str = this.f32598i;
                return x.b(str != null ? str.toLowerCase(Locale.ROOT) : null, f32589m);
            }

            public String toString() {
                return "DocSetsItem(idDocSetType=" + this.f32590a + ", types=" + this.f32591b + ", sides=" + this.f32592c + ", videoRequired=" + this.f32593d + ", fields=" + this.f32594e + ", customField=" + this.f32595f + ", questionnaireId=" + this.f32596g + ", questionnaireDefId=" + this.f32597h + ", captureMode=" + this.f32598i + ')';
            }

            public final boolean u() {
                String str = this.f32598i;
                return x.b(str != null ? str.toLowerCase(Locale.ROOT) : null, f32587k) && x.b(this.f32593d, VideoRequiredType.DocCapture.getValue());
            }

            public final boolean v() {
                return this.f32590a.k() && x.b(this.f32593d, VideoRequiredType.PhotoRequired.getValue());
            }

            public final boolean w() {
                return this.f32590a.k() && x.b(this.f32593d, VideoRequiredType.Disabled.getValue());
            }

            public final a a(DocumentType documentType, List<String> list, List<? extends IdentitySide> list2, String str, List<h.d> list3, List<h.c> list4, String str2, String str3, String str4) {
                return new a(documentType, list, list2, str, list3, list4, str2, str3, str4);
            }

            public static /* synthetic */ a a(a aVar, DocumentType documentType, List list, List list2, String str, List list3, List list4, String str2, String str3, String str4, int i11, Object obj) {
                a aVar2 = aVar;
                int i12 = i11;
                return aVar.a((i12 & 1) != 0 ? aVar2.f32590a : documentType, (i12 & 2) != 0 ? aVar2.f32591b : list, (i12 & 4) != 0 ? aVar2.f32592c : list2, (i12 & 8) != 0 ? aVar2.f32593d : str, (i12 & 16) != 0 ? aVar2.f32594e : list3, (i12 & 32) != 0 ? aVar2.f32595f : list4, (i12 & 64) != 0 ? aVar2.f32596g : str2, (i12 & 128) != 0 ? aVar2.f32597h : str3, (i12 & 256) != 0 ? aVar2.f32598i : str4);
            }
        }

        public c(List<a> list, boolean z11, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
            this.f32580a = list;
            this.f32581b = z11;
            this.f32582c = list2;
            this.f32583d = list3;
            this.f32584e = list4;
            this.f32585f = list5;
        }

        public final List<a> a() {
            return this.f32580a;
        }

        public final boolean b() {
            return this.f32581b;
        }

        public final List<String> c() {
            return this.f32582c;
        }

        public final List<String> d() {
            return this.f32583d;
        }

        public final List<String> e() {
            return this.f32584e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f32580a, cVar.f32580a) && this.f32581b == cVar.f32581b && x.b(this.f32582c, cVar.f32582c) && x.b(this.f32583d, cVar.f32583d) && x.b(this.f32584e, cVar.f32584e) && x.b(this.f32585f, cVar.f32585f);
        }

        public final List<String> f() {
            return this.f32585f;
        }

        public final List<a> g() {
            return this.f32580a;
        }

        public final List<String> h() {
            return this.f32585f;
        }

        public int hashCode() {
            int hashCode = this.f32580a.hashCode() * 31;
            boolean z11 = this.f32581b;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            List<String> list = this.f32582c;
            int i12 = 0;
            int hashCode2 = (i11 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.f32583d;
            int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<String> list3 = this.f32584e;
            int hashCode4 = (hashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
            List<String> list4 = this.f32585f;
            if (list4 != null) {
                i12 = list4.hashCode();
            }
            return hashCode4 + i12;
        }

        public final List<String> i() {
            return this.f32584e;
        }

        public final List<String> j() {
            return this.f32583d;
        }

        public final boolean k() {
            return this.f32581b;
        }

        public final List<String> l() {
            return this.f32582c;
        }

        public String toString() {
            return "RequiredIdDocs(docSets=" + this.f32580a + ", videoIdent=" + this.f32581b + ", videoIdentUploadTypes=" + this.f32582c + ", stepsOutsideVideoId=" + this.f32583d + ", includedCountries=" + this.f32584e + ", excludedCountries=" + this.f32585f + ')';
        }

        public final c a(List<a> list, boolean z11, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
            return new c(list, z11, list2, list3, list4, list5);
        }

        public static /* synthetic */ c a(c cVar, List<a> list, boolean z11, List<String> list2, List<String> list3, List<String> list4, List<String> list5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = cVar.f32580a;
            }
            if ((i11 & 2) != 0) {
                z11 = cVar.f32581b;
            }
            boolean z12 = z11;
            if ((i11 & 4) != 0) {
                list2 = cVar.f32582c;
            }
            List<String> list6 = list2;
            if ((i11 & 8) != 0) {
                list3 = cVar.f32583d;
            }
            List<String> list7 = list3;
            if ((i11 & 16) != 0) {
                list4 = cVar.f32584e;
            }
            List<String> list8 = list4;
            if ((i11 & 32) != 0) {
                list5 = cVar.f32585f;
            }
            return cVar.a(list, z12, list6, list7, list8, list5);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(List list, boolean z11, List list2, List list3, List list4, List list5, int i11, r rVar) {
            this(list, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? null : list2, (i11 & 8) != 0 ? null : list3, (i11 & 16) != 0 ? null : list4, (i11 & 32) != 0 ? null : list5);
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f32599a;

        /* renamed from: b  reason: collision with root package name */
        public final ReviewStatusType f32600b;

        /* renamed from: c  reason: collision with root package name */
        public final Integer f32601c;

        /* renamed from: d  reason: collision with root package name */
        public final String f32602d;

        /* renamed from: e  reason: collision with root package name */
        public final a f32603e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f32604f;

        /* renamed from: g  reason: collision with root package name */
        public final Long f32605g;

        /* renamed from: h  reason: collision with root package name */
        public final String f32606h;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final String f32607a;

            /* renamed from: b  reason: collision with root package name */
            public final String f32608b;

            /* renamed from: c  reason: collision with root package name */
            public final ReviewAnswerType f32609c;

            /* renamed from: d  reason: collision with root package name */
            public final List<String> f32610d;

            /* renamed from: e  reason: collision with root package name */
            public final ReviewRejectType f32611e;

            public a(String str, String str2, ReviewAnswerType reviewAnswerType, List<String> list, ReviewRejectType reviewRejectType) {
                this.f32607a = str;
                this.f32608b = str2;
                this.f32609c = reviewAnswerType;
                this.f32610d = list;
                this.f32611e = reviewRejectType;
            }

            public final String a() {
                return this.f32607a;
            }

            public final String b() {
                return this.f32608b;
            }

            public final ReviewAnswerType c() {
                return this.f32609c;
            }

            public final List<String> d() {
                return this.f32610d;
            }

            public final ReviewRejectType e() {
                return this.f32611e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return x.b(this.f32607a, aVar.f32607a) && x.b(this.f32608b, aVar.f32608b) && this.f32609c == aVar.f32609c && x.b(this.f32610d, aVar.f32610d) && this.f32611e == aVar.f32611e;
            }

            public final String f() {
                return this.f32608b;
            }

            public final String g() {
                return this.f32607a;
            }

            public final List<String> h() {
                return this.f32610d;
            }

            public int hashCode() {
                String str = this.f32607a;
                int i11 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f32608b;
                if (str2 != null) {
                    i11 = str2.hashCode();
                }
                return ((((((hashCode + i11) * 31) + this.f32609c.hashCode()) * 31) + this.f32610d.hashCode()) * 31) + this.f32611e.hashCode();
            }

            public final ReviewAnswerType i() {
                return this.f32609c;
            }

            public final ReviewRejectType j() {
                return this.f32611e;
            }

            public String toString() {
                return "Result(moderationComment=" + this.f32607a + ", clientComment=" + this.f32608b + ", reviewAnswer=" + this.f32609c + ", rejectLabels=" + this.f32610d + ", reviewRejectType=" + this.f32611e + ')';
            }

            public final a a(String str, String str2, ReviewAnswerType reviewAnswerType, List<String> list, ReviewRejectType reviewRejectType) {
                return new a(str, str2, reviewAnswerType, list, reviewRejectType);
            }

            public static /* synthetic */ a a(a aVar, String str, String str2, ReviewAnswerType reviewAnswerType, List<String> list, ReviewRejectType reviewRejectType, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = aVar.f32607a;
                }
                if ((i11 & 2) != 0) {
                    str2 = aVar.f32608b;
                }
                String str3 = str2;
                if ((i11 & 4) != 0) {
                    reviewAnswerType = aVar.f32609c;
                }
                ReviewAnswerType reviewAnswerType2 = reviewAnswerType;
                if ((i11 & 8) != 0) {
                    list = aVar.f32610d;
                }
                List<String> list2 = list;
                if ((i11 & 16) != 0) {
                    reviewRejectType = aVar.f32611e;
                }
                return aVar.a(str, str3, reviewAnswerType2, list2, reviewRejectType);
            }
        }

        public d(Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, a aVar, Long l11, Long l12, String str2) {
            this.f32599a = num;
            this.f32600b = reviewStatusType;
            this.f32601c = num2;
            this.f32602d = str;
            this.f32603e = aVar;
            this.f32604f = l11;
            this.f32605g = l12;
            this.f32606h = str2;
        }

        public final Integer a() {
            return this.f32599a;
        }

        public final ReviewStatusType b() {
            return this.f32600b;
        }

        public final Integer c() {
            return this.f32601c;
        }

        public final String d() {
            return this.f32602d;
        }

        public final a e() {
            return this.f32603e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f32599a, dVar.f32599a) && this.f32600b == dVar.f32600b && x.b(this.f32601c, dVar.f32601c) && x.b(this.f32602d, dVar.f32602d) && x.b(this.f32603e, dVar.f32603e) && x.b(this.f32604f, dVar.f32604f) && x.b(this.f32605g, dVar.f32605g) && x.b(this.f32606h, dVar.f32606h);
        }

        public final Long f() {
            return this.f32604f;
        }

        public final Long g() {
            return this.f32605g;
        }

        public final String h() {
            return this.f32606h;
        }

        public int hashCode() {
            Integer num = this.f32599a;
            int i11 = 0;
            int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.f32600b.hashCode()) * 31;
            Integer num2 = this.f32601c;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.f32602d;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            a aVar = this.f32603e;
            int hashCode4 = (hashCode3 + (aVar == null ? 0 : aVar.hashCode())) * 31;
            Long l11 = this.f32604f;
            int hashCode5 = (hashCode4 + (l11 == null ? 0 : l11.hashCode())) * 31;
            Long l12 = this.f32605g;
            int hashCode6 = (hashCode5 + (l12 == null ? 0 : l12.hashCode())) * 31;
            String str2 = this.f32606h;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode6 + i11;
        }

        public final String i() {
            return this.f32602d;
        }

        public final Long j() {
            return this.f32605g;
        }

        public final Long k() {
            return this.f32604f;
        }

        public final String l() {
            return this.f32606h;
        }

        public final Integer m() {
            return this.f32599a;
        }

        public final Integer n() {
            return this.f32601c;
        }

        public final a o() {
            return this.f32603e;
        }

        public final ReviewStatusType p() {
            return this.f32600b;
        }

        public String toString() {
            return "Review(notificationFailureCnt=" + this.f32599a + ", status=" + this.f32600b + ", priority=" + this.f32601c + ", createDate=" + this.f32602d + ", result=" + this.f32603e + ", elapsedSinceQueuedMs=" + this.f32604f + ", elapsedSincePendingMs=" + this.f32605g + ", levelName=" + this.f32606h + ')';
        }

        public final d a(Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, a aVar, Long l11, Long l12, String str2) {
            return new d(num, reviewStatusType, num2, str, aVar, l11, l12, str2);
        }

        public static /* synthetic */ d a(d dVar, Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, a aVar, Long l11, Long l12, String str2, int i11, Object obj) {
            d dVar2 = dVar;
            int i12 = i11;
            return dVar.a((i12 & 1) != 0 ? dVar2.f32599a : num, (i12 & 2) != 0 ? dVar2.f32600b : reviewStatusType, (i12 & 4) != 0 ? dVar2.f32601c : num2, (i12 & 8) != 0 ? dVar2.f32602d : str, (i12 & 16) != 0 ? dVar2.f32603e : aVar, (i12 & 32) != 0 ? dVar2.f32604f : l11, (i12 & 64) != 0 ? dVar2.f32605g : l12, (i12 & 128) != 0 ? dVar2.f32606h : str2);
        }
    }

    public g(String str, String str2, String str3, String str4, String str5, String str6, c cVar, String str7, b bVar, d dVar, String str8, a aVar, String str9, List<b> list, String str10, String str11, List<u> list2) {
        this.f32548a = str;
        this.f32549b = str2;
        this.f32550c = str3;
        this.f32551d = str4;
        this.f32552e = str5;
        this.f32553f = str6;
        this.f32554g = cVar;
        this.f32555h = str7;
        this.f32556i = bVar;
        this.f32557j = dVar;
        this.f32558k = str8;
        this.f32559l = aVar;
        this.f32560m = str9;
        this.f32561n = list;
        this.f32562o = str10;
        this.f32563p = str11;
        this.f32564q = list2;
    }

    public final boolean A() {
        if (this.f32554g.k()) {
            List<String> j11 = this.f32554g.j();
            if (j11 == null || j11.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final String B() {
        return this.f32548a;
    }

    public final a C() {
        return this.f32559l;
    }

    public final String D() {
        return this.f32553f;
    }

    public final String E() {
        return this.f32560m;
    }

    public final List<b> F() {
        return this.f32561n;
    }

    public final String G() {
        return this.f32563p;
    }

    public final List<u> H() {
        return this.f32564q;
    }

    public final c I() {
        return this.f32554g;
    }

    public final d J() {
        return this.f32557j;
    }

    public final ReviewStatusType K() {
        return this.f32557j.p();
    }

    public final String L() {
        return this.f32550c;
    }

    public final boolean M() {
        d.a o11 = this.f32557j.o();
        return (o11 != null ? o11.i() : null) == ReviewAnswerType.Green;
    }

    public final boolean N() {
        return x.b(this.f32550c, FlowActionType.FaceEnrollment.INSTANCE.getValue());
    }

    public final boolean O() {
        d.a o11 = this.f32557j.o();
        ReviewRejectType reviewRejectType = null;
        if ((o11 != null ? o11.i() : null) == ReviewAnswerType.Red && this.f32557j.p() == ReviewStatusType.Completed) {
            d.a o12 = this.f32557j.o();
            if ((o12 != null ? o12.j() : null) != ReviewRejectType.Final) {
                d.a o13 = this.f32557j.o();
                if (o13 != null) {
                    reviewRejectType = o13.j();
                }
                if (reviewRejectType == ReviewRejectType.External) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean P() {
        d.a o11 = this.f32557j.o();
        ReviewRejectType reviewRejectType = null;
        if ((o11 != null ? o11.i() : null) == ReviewAnswerType.Red && this.f32557j.p() == ReviewStatusType.Completed) {
            d.a o12 = this.f32557j.o();
            if (o12 != null) {
                reviewRejectType = o12.j();
            }
            if (reviewRejectType == ReviewRejectType.Retry) {
                return true;
            }
        }
        return false;
    }

    public final String a() {
        return this.f32548a;
    }

    public final d b() {
        return this.f32557j;
    }

    public final String c() {
        return this.f32558k;
    }

    public final a d() {
        return this.f32559l;
    }

    public final String e() {
        return this.f32560m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return x.b(this.f32548a, gVar.f32548a) && x.b(this.f32549b, gVar.f32549b) && x.b(this.f32550c, gVar.f32550c) && x.b(this.f32551d, gVar.f32551d) && x.b(this.f32552e, gVar.f32552e) && x.b(this.f32553f, gVar.f32553f) && x.b(this.f32554g, gVar.f32554g) && x.b(this.f32555h, gVar.f32555h) && x.b(this.f32556i, gVar.f32556i) && x.b(this.f32557j, gVar.f32557j) && x.b(this.f32558k, gVar.f32558k) && x.b(this.f32559l, gVar.f32559l) && x.b(this.f32560m, gVar.f32560m) && x.b(this.f32561n, gVar.f32561n) && x.b(this.f32562o, gVar.f32562o) && x.b(this.f32563p, gVar.f32563p) && x.b(this.f32564q, gVar.f32564q);
    }

    public final List<b> f() {
        return this.f32561n;
    }

    public final String g() {
        return this.f32562o;
    }

    public final String h() {
        return this.f32563p;
    }

    public int hashCode() {
        int hashCode = this.f32548a.hashCode() * 31;
        String str = this.f32549b;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f32550c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f32551d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f32552e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f32553f;
        int hashCode6 = (((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f32554g.hashCode()) * 31;
        String str6 = this.f32555h;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        b bVar = this.f32556i;
        int hashCode8 = (((hashCode7 + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.f32557j.hashCode()) * 31;
        String str7 = this.f32558k;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        a aVar = this.f32559l;
        int hashCode10 = (hashCode9 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        String str8 = this.f32560m;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<b> list = this.f32561n;
        int hashCode12 = (hashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        String str9 = this.f32562o;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.f32563p;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<u> list2 = this.f32564q;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode14 + i11;
    }

    public final List<u> i() {
        return this.f32564q;
    }

    public final String j() {
        return this.f32549b;
    }

    public final String k() {
        return this.f32550c;
    }

    public final String l() {
        return this.f32551d;
    }

    public final String m() {
        return this.f32552e;
    }

    public final String n() {
        return this.f32553f;
    }

    public final c o() {
        return this.f32554g;
    }

    public final String p() {
        return this.f32555h;
    }

    public final b q() {
        return this.f32556i;
    }

    public final b r() {
        return this.f32556i;
    }

    public final String s() {
        return this.f32549b;
    }

    public final String t() {
        return this.f32551d;
    }

    public String toString() {
        return "Applicant(id=" + this.f32548a + ", applicantId=" + this.f32549b + ", type=" + this.f32550c + ", clientId=" + this.f32551d + ", createdAt=" + this.f32552e + ", inspectionId=" + this.f32553f + ", requiredIdDocs=" + this.f32554g + ", externalUserId=" + this.f32555h + ", agreement=" + this.f32556i + ", review=" + this.f32557j + ", env=" + this.f32558k + ", info=" + this.f32559l + ", lang=" + this.f32560m + ", metadata=" + this.f32561n + ", email=" + this.f32562o + ", phone=" + this.f32563p + ", questionnaires=" + this.f32564q + ')';
    }

    public final String u() {
        a aVar = this.f32559l;
        if (aVar != null) {
            return aVar.o();
        }
        return null;
    }

    public final String v() {
        return this.f32552e;
    }

    public final List<DocumentType> w() {
        List<c.a> g11 = this.f32554g.g();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(g11, 10));
        for (c.a m11 : g11) {
            arrayList.add(m11.m());
        }
        return arrayList;
    }

    public final String x() {
        return this.f32562o;
    }

    public final String y() {
        return this.f32558k;
    }

    public final String z() {
        return this.f32555h;
    }

    public final g a(String str, String str2, String str3, String str4, String str5, String str6, c cVar, String str7, b bVar, d dVar, String str8, a aVar, String str9, List<b> list, String str10, String str11, List<u> list2) {
        return new g(str, str2, str3, str4, str5, str6, cVar, str7, bVar, dVar, str8, aVar, str9, list, str10, str11, list2);
    }

    public final List<q> b(DocumentType documentType) {
        List<String> q11;
        c.a a11 = a(documentType);
        if (a11 == null || (q11 = a11.q()) == null) {
            return CollectionsKt__CollectionsKt.k();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(q11, 10));
        for (String a12 : q11) {
            arrayList.add(q.f32683c.a(a12));
        }
        return arrayList;
    }

    public static /* synthetic */ g a(g gVar, String str, String str2, String str3, String str4, String str5, String str6, c cVar, String str7, b bVar, d dVar, String str8, a aVar, String str9, List list, String str10, String str11, List list2, int i11, Object obj) {
        g gVar2 = gVar;
        int i12 = i11;
        return gVar.a((i12 & 1) != 0 ? gVar2.f32548a : str, (i12 & 2) != 0 ? gVar2.f32549b : str2, (i12 & 4) != 0 ? gVar2.f32550c : str3, (i12 & 8) != 0 ? gVar2.f32551d : str4, (i12 & 16) != 0 ? gVar2.f32552e : str5, (i12 & 32) != 0 ? gVar2.f32553f : str6, (i12 & 64) != 0 ? gVar2.f32554g : cVar, (i12 & 128) != 0 ? gVar2.f32555h : str7, (i12 & 256) != 0 ? gVar2.f32556i : bVar, (i12 & 512) != 0 ? gVar2.f32557j : dVar, (i12 & 1024) != 0 ? gVar2.f32558k : str8, (i12 & 2048) != 0 ? gVar2.f32559l : aVar, (i12 & 4096) != 0 ? gVar2.f32560m : str9, (i12 & 8192) != 0 ? gVar2.f32561n : list, (i12 & 16384) != 0 ? gVar2.f32562o : str10, (i12 & 32768) != 0 ? gVar2.f32563p : str11, (i12 & 65536) != 0 ? gVar2.f32564q : list2);
    }

    public final void a(d dVar) {
        this.f32557j = dVar;
    }

    public final c.a a(DocumentType documentType) {
        T t11;
        Iterator<T> it2 = this.f32554g.g().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((c.a) t11).m(), documentType)) {
                break;
            }
        }
        return (c.a) t11;
    }

    public final boolean a(String str) {
        if (this.f32554g.k()) {
            List<String> j11 = this.f32554g.j();
            if (j11 == null || !j11.contains(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ g(java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, com.sumsub.sns.internal.core.data.model.g.c r28, java.lang.String r29, com.sumsub.sns.internal.core.data.model.b r30, com.sumsub.sns.internal.core.data.model.g.d r31, java.lang.String r32, com.sumsub.sns.internal.core.data.model.g.a r33, java.lang.String r34, java.util.List r35, java.lang.String r36, java.lang.String r37, java.util.List r38, int r39, kotlin.jvm.internal.r r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r23
        L_0x000b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0011
            r12 = r2
            goto L_0x0013
        L_0x0011:
            r12 = r30
        L_0x0013:
            r3 = r21
            r4 = r22
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r29
            r13 = r31
            r14 = r32
            r15 = r33
            r16 = r34
            r17 = r35
            r18 = r36
            r19 = r37
            r20 = r38
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.g.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.sumsub.sns.internal.core.data.model.g$c, java.lang.String, com.sumsub.sns.internal.core.data.model.b, com.sumsub.sns.internal.core.data.model.g$d, java.lang.String, com.sumsub.sns.internal.core.data.model.g$a, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.r):void");
    }
}
