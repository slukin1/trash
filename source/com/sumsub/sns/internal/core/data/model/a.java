package com.sumsub.sns.internal.core.data.model;

import com.sumsub.sns.core.data.model.FlowActionType;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f32501a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32502b;

    /* renamed from: c  reason: collision with root package name */
    public final FlowActionType f32503c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32504d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32505e;

    /* renamed from: f  reason: collision with root package name */
    public final List<C0336a> f32506f;

    /* renamed from: g  reason: collision with root package name */
    public final b f32507g;

    /* renamed from: com.sumsub.sns.internal.core.data.model.a$a  reason: collision with other inner class name */
    public static final class C0336a {

        /* renamed from: a  reason: collision with root package name */
        public final DocumentType f32508a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32509b;

        public C0336a(DocumentType documentType, String str) {
            this.f32508a = documentType;
            this.f32509b = str;
        }

        public static /* synthetic */ void d() {
        }

        public static /* synthetic */ void f() {
        }

        public final DocumentType a() {
            return this.f32508a;
        }

        public final String b() {
            return this.f32509b;
        }

        public final DocumentType c() {
            return this.f32508a;
        }

        public final String e() {
            return this.f32509b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0336a)) {
                return false;
            }
            C0336a aVar = (C0336a) obj;
            return x.b(this.f32508a, aVar.f32508a) && x.b(this.f32509b, aVar.f32509b);
        }

        public int hashCode() {
            int hashCode = this.f32508a.hashCode() * 31;
            String str = this.f32509b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "DocSetsItem(idDocSetType=" + this.f32508a + ", questionnaireDefId=" + this.f32509b + ')';
        }

        public final C0336a a(DocumentType documentType, String str) {
            return new C0336a(documentType, str);
        }

        public static /* synthetic */ C0336a a(C0336a aVar, DocumentType documentType, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                documentType = aVar.f32508a;
            }
            if ((i11 & 2) != 0) {
                str = aVar.f32509b;
            }
            return aVar.a(documentType, str);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0336a(DocumentType documentType, String str, int i11, r rVar) {
            this(documentType, (i11 & 2) != 0 ? null : str);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Boolean f32510a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f32511b;

        /* renamed from: c  reason: collision with root package name */
        public final String f32512c;

        /* renamed from: d  reason: collision with root package name */
        public final Boolean f32513d;

        /* renamed from: e  reason: collision with root package name */
        public final String f32514e;

        public b(Boolean bool, Integer num, String str, Boolean bool2, String str2) {
            this.f32510a = bool;
            this.f32511b = num;
            this.f32512c = str;
            this.f32513d = bool2;
            this.f32514e = str2;
        }

        public final Boolean a() {
            return this.f32510a;
        }

        public final Integer b() {
            return this.f32511b;
        }

        public final String c() {
            return this.f32512c;
        }

        public final Boolean d() {
            return this.f32513d;
        }

        public final String e() {
            return this.f32514e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f32510a, bVar.f32510a) && x.b(this.f32511b, bVar.f32511b) && x.b(this.f32512c, bVar.f32512c) && x.b(this.f32513d, bVar.f32513d) && x.b(this.f32514e, bVar.f32514e);
        }

        public final Boolean f() {
            return this.f32513d;
        }

        public final String g() {
            return this.f32514e;
        }

        public final Integer h() {
            return this.f32511b;
        }

        public int hashCode() {
            Boolean bool = this.f32510a;
            int i11 = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Integer num = this.f32511b;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.f32512c;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool2 = this.f32513d;
            int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str2 = this.f32514e;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode4 + i11;
        }

        public final Boolean i() {
            return this.f32510a;
        }

        public final String j() {
            return this.f32512c;
        }

        public String toString() {
            return "Review(reprocessing=" + this.f32510a + ", notificationFailureCnt=" + this.f32511b + ", reviewStatus=" + this.f32512c + ", autoChecked=" + this.f32513d + ", createDate=" + this.f32514e + ')';
        }

        public final b a(Boolean bool, Integer num, String str, Boolean bool2, String str2) {
            return new b(bool, num, str, bool2, str2);
        }

        public static /* synthetic */ b a(b bVar, Boolean bool, Integer num, String str, Boolean bool2, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bool = bVar.f32510a;
            }
            if ((i11 & 2) != 0) {
                num = bVar.f32511b;
            }
            Integer num2 = num;
            if ((i11 & 4) != 0) {
                str = bVar.f32512c;
            }
            String str3 = str;
            if ((i11 & 8) != 0) {
                bool2 = bVar.f32513d;
            }
            Boolean bool3 = bool2;
            if ((i11 & 16) != 0) {
                str2 = bVar.f32514e;
            }
            return bVar.a(bool, num2, str3, bool3, str2);
        }
    }

    public a(String str, String str2, FlowActionType flowActionType, String str3, String str4, List<C0336a> list, b bVar) {
        this.f32501a = str;
        this.f32502b = str2;
        this.f32503c = flowActionType;
        this.f32504d = str3;
        this.f32505e = str4;
        this.f32506f = list;
        this.f32507g = bVar;
    }

    public final String a() {
        return this.f32501a;
    }

    public final String b() {
        return this.f32502b;
    }

    public final FlowActionType c() {
        return this.f32503c;
    }

    public final String d() {
        return this.f32504d;
    }

    public final String e() {
        return this.f32505e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return x.b(this.f32501a, aVar.f32501a) && x.b(this.f32502b, aVar.f32502b) && x.b(this.f32503c, aVar.f32503c) && x.b(this.f32504d, aVar.f32504d) && x.b(this.f32505e, aVar.f32505e) && x.b(this.f32506f, aVar.f32506f) && x.b(this.f32507g, aVar.f32507g);
    }

    public final List<C0336a> f() {
        return this.f32506f;
    }

    public final b g() {
        return this.f32507g;
    }

    public final String h() {
        return this.f32502b;
    }

    public int hashCode() {
        return (((((((((((this.f32501a.hashCode() * 31) + this.f32502b.hashCode()) * 31) + this.f32503c.hashCode()) * 31) + this.f32504d.hashCode()) * 31) + this.f32505e.hashCode()) * 31) + this.f32506f.hashCode()) * 31) + this.f32507g.hashCode();
    }

    public final String i() {
        return this.f32504d;
    }

    public final List<C0336a> j() {
        return this.f32506f;
    }

    public final String k() {
        return this.f32505e;
    }

    public final String l() {
        return this.f32501a;
    }

    public final b m() {
        return this.f32507g;
    }

    public final FlowActionType n() {
        return this.f32503c;
    }

    public String toString() {
        return "Action(id=" + this.f32501a + ", applicantId=" + this.f32502b + ", type=" + this.f32503c + ", createdAt=" + this.f32504d + ", externalActionId=" + this.f32505e + ", docSets=" + this.f32506f + ", review=" + this.f32507g + ')';
    }

    public final a a(String str, String str2, FlowActionType flowActionType, String str3, String str4, List<C0336a> list, b bVar) {
        return new a(str, str2, flowActionType, str3, str4, list, bVar);
    }

    public static /* synthetic */ a a(a aVar, String str, String str2, FlowActionType flowActionType, String str3, String str4, List<C0336a> list, b bVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = aVar.f32501a;
        }
        if ((i11 & 2) != 0) {
            str2 = aVar.f32502b;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            flowActionType = aVar.f32503c;
        }
        FlowActionType flowActionType2 = flowActionType;
        if ((i11 & 8) != 0) {
            str3 = aVar.f32504d;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = aVar.f32505e;
        }
        String str7 = str4;
        if ((i11 & 32) != 0) {
            list = aVar.f32506f;
        }
        List<C0336a> list2 = list;
        if ((i11 & 64) != 0) {
            bVar = aVar.f32507g;
        }
        return aVar.a(str, str5, flowActionType2, str6, str7, list2, bVar);
    }
}
