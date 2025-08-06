package com.sumsub.sns.internal.core.data.source.dynamic;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.core.data.model.d;
import com.sumsub.sns.internal.core.data.model.e;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.t;
import com.sumsub.sns.internal.core.data.source.dynamic.e;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.flow.j1;

public interface b {

    public static final class a {

        /* renamed from: g  reason: collision with root package name */
        public static final C0364a f33291g = new C0364a((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final e<g> f33292a;

        /* renamed from: b  reason: collision with root package name */
        public final e<g> f33293b;

        /* renamed from: c  reason: collision with root package name */
        public final e<t> f33294c;

        /* renamed from: d  reason: collision with root package name */
        public final e<e> f33295d;

        /* renamed from: e  reason: collision with root package name */
        public final e<c> f33296e;

        /* renamed from: f  reason: collision with root package name */
        public final e<C0365b> f33297f;

        /* renamed from: com.sumsub.sns.internal.core.data.source.dynamic.b$a$a  reason: collision with other inner class name */
        public static final class C0364a {
            public /* synthetic */ C0364a(r rVar) {
                this();
            }

            public final a a() {
                return new a(new e.b(), new e.b(), new e.b(), new e.b(), new e.b(), new e.b());
            }

            public C0364a() {
            }
        }

        public a(e<g> eVar, e<g> eVar2, e<t> eVar3, e<com.sumsub.sns.internal.core.data.model.e> eVar4, e<c> eVar5, e<C0365b> eVar6) {
            this.f33292a = eVar;
            this.f33293b = eVar2;
            this.f33294c = eVar3;
            this.f33295d = eVar4;
            this.f33296e = eVar5;
            this.f33297f = eVar6;
        }

        public final e<g> a() {
            return this.f33292a;
        }

        public final e<g> b() {
            return this.f33293b;
        }

        public final e<t> c() {
            return this.f33294c;
        }

        public final e<com.sumsub.sns.internal.core.data.model.e> d() {
            return this.f33295d;
        }

        public final e<c> e() {
            return this.f33296e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f33292a, aVar.f33292a) && x.b(this.f33293b, aVar.f33293b) && x.b(this.f33294c, aVar.f33294c) && x.b(this.f33295d, aVar.f33295d) && x.b(this.f33296e, aVar.f33296e) && x.b(this.f33297f, aVar.f33297f);
        }

        public final e<C0365b> f() {
            return this.f33297f;
        }

        public final e<g> g() {
            return this.f33292a;
        }

        public final e<g> h() {
            return this.f33293b;
        }

        public int hashCode() {
            int hashCode = this.f33292a.hashCode() * 31;
            e<g> eVar = this.f33293b;
            return ((((((((hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31) + this.f33294c.hashCode()) * 31) + this.f33295d.hashCode()) * 31) + this.f33296e.hashCode()) * 31) + this.f33297f.hashCode();
        }

        public final e<com.sumsub.sns.internal.core.data.model.e> i() {
            return this.f33295d;
        }

        public final e<t> j() {
            return this.f33294c;
        }

        public final Throwable k() {
            Throwable a11 = this.f33292a.a();
            if (a11 != null) {
                return a11;
            }
            Throwable a12 = this.f33294c.a();
            return a12 == null ? this.f33295d.a() : a12;
        }

        public final e<C0365b> l() {
            return this.f33297f;
        }

        public final e<c> m() {
            return this.f33296e;
        }

        public final boolean n() {
            return !this.f33292a.b() && !this.f33294c.b() && !this.f33295d.b() && !this.f33296e.b();
        }

        public String toString() {
            return "Data(applicant=" + this.f33292a + ", applicantAction=" + this.f33293b + ", documentStatus=" + this.f33294c + ", config=" + this.f33295d + ", strings=" + this.f33296e + ", featureFlags=" + this.f33297f + ')';
        }

        public final a a(e<g> eVar, e<g> eVar2, e<t> eVar3, e<com.sumsub.sns.internal.core.data.model.e> eVar4, e<c> eVar5, e<C0365b> eVar6) {
            return new a(eVar, eVar2, eVar3, eVar4, eVar5, eVar6);
        }

        public static /* synthetic */ a a(a aVar, e<g> eVar, e<g> eVar2, e<t> eVar3, e<com.sumsub.sns.internal.core.data.model.e> eVar4, e<c> eVar5, e<C0365b> eVar6, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                eVar = aVar.f33292a;
            }
            if ((i11 & 2) != 0) {
                eVar2 = aVar.f33293b;
            }
            e<g> eVar7 = eVar2;
            if ((i11 & 4) != 0) {
                eVar3 = aVar.f33294c;
            }
            e<t> eVar8 = eVar3;
            if ((i11 & 8) != 0) {
                eVar4 = aVar.f33295d;
            }
            e<com.sumsub.sns.internal.core.data.model.e> eVar9 = eVar4;
            if ((i11 & 16) != 0) {
                eVar5 = aVar.f33296e;
            }
            e<c> eVar10 = eVar5;
            if ((i11 & 32) != 0) {
                eVar6 = aVar.f33297f;
            }
            return aVar.a(eVar, eVar7, eVar8, eVar9, eVar10, eVar6);
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.data.source.dynamic.b$b  reason: collision with other inner class name */
    public static final class C0365b {

        /* renamed from: a  reason: collision with root package name */
        public final List<a> f33298a;

        /* renamed from: com.sumsub.sns.internal.core.data.source.dynamic.b$b$a */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final String f33299a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f33300b;

            /* renamed from: c  reason: collision with root package name */
            public final String f33301c;

            public a(String str, boolean z11, String str2) {
                this.f33299a = str;
                this.f33300b = z11;
                this.f33301c = str2;
            }

            public final String a() {
                return this.f33299a;
            }

            public final boolean b() {
                return this.f33300b;
            }

            public final String c() {
                return this.f33301c;
            }

            public final String d() {
                return this.f33299a;
            }

            public final String e() {
                return this.f33301c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return x.b(this.f33299a, aVar.f33299a) && this.f33300b == aVar.f33300b && x.b(this.f33301c, aVar.f33301c);
            }

            public final boolean f() {
                return this.f33300b;
            }

            public int hashCode() {
                int hashCode = this.f33299a.hashCode() * 31;
                boolean z11 = this.f33300b;
                if (z11) {
                    z11 = true;
                }
                int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
                String str = this.f33301c;
                return i11 + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "FeatureFlag(name=" + this.f33299a + ", isEnabled=" + this.f33300b + ", value=" + this.f33301c + ')';
            }

            public final a a(String str, boolean z11, String str2) {
                return new a(str, z11, str2);
            }

            public static /* synthetic */ a a(a aVar, String str, boolean z11, String str2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = aVar.f33299a;
                }
                if ((i11 & 2) != 0) {
                    z11 = aVar.f33300b;
                }
                if ((i11 & 4) != 0) {
                    str2 = aVar.f33301c;
                }
                return aVar.a(str, z11, str2);
            }
        }

        public C0365b(List<a> list) {
            this.f33298a = list;
        }

        public final List<a> a() {
            return this.f33298a;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, String> f33302a;

        /* renamed from: b  reason: collision with root package name */
        public final List<d> f33303b;

        public c() {
            this((Map) null, (List) null, 3, (r) null);
        }

        public final Map<String, String> a() {
            return this.f33302a;
        }

        public final List<d> b() {
            return this.f33303b;
        }

        public final List<d> c() {
            return this.f33303b;
        }

        public final Map<String, String> d() {
            return this.f33302a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f33302a, cVar.f33302a) && x.b(this.f33303b, cVar.f33303b);
        }

        public int hashCode() {
            int hashCode = this.f33302a.hashCode() * 31;
            List<d> list = this.f33303b;
            return hashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "Strings(strings=" + this.f33302a + ", agreements=" + this.f33303b + ')';
        }

        public c(Map<String, String> map, List<d> list) {
            this.f33302a = map;
            this.f33303b = list;
        }

        public final c a(Map<String, String> map, List<d> list) {
            return new c(map, list);
        }

        public static /* synthetic */ c a(c cVar, Map<String, String> map, List<d> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                map = cVar.f33302a;
            }
            if ((i11 & 2) != 0) {
                list = cVar.f33303b;
            }
            return cVar.a(map, list);
        }

        public final String a(String... strArr) {
            String str;
            int length = strArr.length;
            int i11 = 0;
            while (true) {
                if (i11 < length) {
                    str = a(strArr[i11]);
                    if (str != null) {
                        break;
                    }
                    i11++;
                } else {
                    str = null;
                    break;
                }
            }
            return str == null ? "" : str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(Map map, List list, int i11, r rVar) {
            this((i11 & 1) != 0 ? MapsKt__MapsKt.h() : map, (i11 & 2) != 0 ? null : list);
        }

        public final String a(String str) {
            com.sumsub.sns.internal.ff.a aVar = com.sumsub.sns.internal.ff.a.f34215a;
            if (aVar.z().g() && StringsKt__StringsJVMKt.t(aVar.z().f(), UserMetadata.KEYDATA_FILENAME, true)) {
                return str;
            }
            String str2 = this.f33302a.get(str);
            if (str2 != null) {
                return str2;
            }
            com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.a(aVar2, a11, "DataRepository: " + str + " is not found", (Throwable) null, 4, (Object) null);
            if (aVar.z().g()) {
                return str;
            }
            return null;
        }
    }

    Object a(g gVar, kotlin.coroutines.c<? super Unit> cVar);

    Object a(String str, boolean z11, kotlin.coroutines.c<? super e<g>> cVar);

    Object a(kotlin.coroutines.c<? super e<c>> cVar);

    Object a(boolean z11, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e> cVar);

    kotlinx.coroutines.flow.d<SNSMessage.ServerMessage> a();

    Object b(g gVar, kotlin.coroutines.c<? super Unit> cVar);

    Object b(String str, boolean z11, kotlin.coroutines.c<? super g> cVar);

    Object b(kotlin.coroutines.c<? super Unit> cVar);

    Object b(boolean z11, kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.e>> cVar);

    j1<a> b();

    Object c(g gVar, kotlin.coroutines.c<? super Unit> cVar);

    Object c(String str, boolean z11, kotlin.coroutines.c<? super e<g>> cVar);

    Object c(kotlin.coroutines.c<? super e<C0365b>> cVar);

    Object c(boolean z11, kotlin.coroutines.c<? super e<t>> cVar);

    Object d(String str, boolean z11, kotlin.coroutines.c<? super g> cVar);

    Object d(kotlin.coroutines.c<? super c> cVar);

    Object d(boolean z11, kotlin.coroutines.c<? super e<g>> cVar);

    Object e(kotlin.coroutines.c<? super C0365b> cVar);

    Object e(boolean z11, kotlin.coroutines.c<? super g> cVar);
}
