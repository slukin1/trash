package com.sumsub.sns.internal.core.presentation.form.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

public abstract class FormItem implements Parcelable {

    /* renamed from: i  reason: collision with root package name */
    public static final b f33730i = new b((kotlin.jvm.internal.r) null);

    /* renamed from: j  reason: collision with root package name */
    public static final String f33731j = "section";

    /* renamed from: a  reason: collision with root package name */
    public final String f33732a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33733b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33734c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f33735d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f33736e;

    /* renamed from: f  reason: collision with root package name */
    public final CharSequence f33737f;

    /* renamed from: g  reason: collision with root package name */
    public String f33738g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f33739h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/internal/core/presentation/form/model/FormItem$ItemState;", "", "(Ljava/lang/String;I)V", "DEFAULT", "LOADING", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum ItemState {
        DEFAULT,
        LOADING
    }

    public static final class a extends FormItem {
        public static final Parcelable.Creator<a> CREATOR = new C0376a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33740k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33741l;

        /* renamed from: m  reason: collision with root package name */
        public final String f33742m;

        /* renamed from: n  reason: collision with root package name */
        public final CharSequence f33743n;

        /* renamed from: com.sumsub.sns.internal.core.presentation.form.model.FormItem$a$a  reason: collision with other inner class name */
        public static final class C0376a implements Parcelable.Creator<a> {
            /* renamed from: a */
            public final a createFromParcel(Parcel parcel) {
                return new a(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final a[] newArray(int i11) {
                return new a[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, str, str2, (i11 & 8) != 0 ? null : charSequence);
        }

        public final a a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence) {
            return new a(kVar, str, str2, charSequence);
        }

        public CharSequence b() {
            return this.f33743n;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33740k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33741l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(d(), aVar.d()) && x.b(e(), aVar.e()) && x.b(f(), aVar.f()) && x.b(b(), aVar.b());
        }

        public String f() {
            return this.f33742m;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return hashCode + i11;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return f();
        }

        public final CharSequence o() {
            return b();
        }

        public String toString() {
            return "Bool(item=" + d() + ", sectionId=" + e() + ", value=" + f() + ", error=" + b() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33740k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33741l);
            parcel.writeString(this.f33742m);
            TextUtils.writeToParcel(this.f33743n, parcel, i11);
        }

        public a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33740k = kVar;
            this.f33741l = str;
            this.f33742m = str2;
            this.f33743n = charSequence;
        }

        public static /* synthetic */ a a(a aVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = aVar.d();
            }
            if ((i11 & 2) != 0) {
                str = aVar.e();
            }
            if ((i11 & 4) != 0) {
                str2 = aVar.f();
            }
            if ((i11 & 8) != 0) {
                charSequence = aVar.b();
            }
            return aVar.a(kVar, str, str2, charSequence);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends FormItem {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final String f33744k;

        /* renamed from: l  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33745l;

        /* renamed from: m  reason: collision with root package name */
        public final Map<String, String> f33746m;

        /* renamed from: n  reason: collision with root package name */
        public final String f33747n;

        /* renamed from: o  reason: collision with root package name */
        public final boolean f33748o;

        /* renamed from: p  reason: collision with root package name */
        public final CharSequence f33749p;

        public static final class a implements Parcelable.Creator<c> {
            /* renamed from: a */
            public final c createFromParcel(Parcel parcel) {
                String readString = parcel.readString();
                com.sumsub.sns.internal.core.data.source.applicant.remote.k createFromParcel = com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
                return new c(readString, createFromParcel, linkedHashMap, parcel.readString(), parcel.readInt() != 0, (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final c[] newArray(int i11) {
                return new c[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, Map map, String str2, boolean z11, CharSequence charSequence, int i11, kotlin.jvm.internal.r rVar) {
            this(str, kVar, (i11 & 4) != 0 ? MapsKt__MapsKt.h() : map, str2, (i11 & 16) != 0 ? true : z11, (i11 & 32) != 0 ? null : charSequence);
        }

        public final c a(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, Map<String, String> map, String str2, boolean z11, CharSequence charSequence) {
            return new c(str, kVar, map, str2, z11, charSequence);
        }

        public CharSequence b() {
            return this.f33749p;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33745l;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33744k;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(e(), cVar.e()) && x.b(d(), cVar.d()) && x.b(this.f33746m, cVar.f33746m) && x.b(f(), cVar.f()) && h() == cVar.h() && x.b(b(), cVar.b());
        }

        public String f() {
            return this.f33747n;
        }

        public boolean h() {
            return this.f33748o;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((((e().hashCode() * 31) + d().hashCode()) * 31) + this.f33746m.hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            boolean h11 = h();
            if (h11) {
                h11 = true;
            }
            int i12 = (hashCode + (h11 ? 1 : 0)) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return i12 + i11;
        }

        public final String l() {
            return e();
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k m() {
            return d();
        }

        public final Map<String, String> n() {
            return this.f33746m;
        }

        public final String o() {
            return f();
        }

        public final boolean p() {
            return h();
        }

        public final CharSequence q() {
            return b();
        }

        public final Map<String, String> r() {
            return this.f33746m;
        }

        public String toString() {
            return com.sumsub.sns.internal.core.common.i.a((Object) this) + "(s=" + e() + ", i=" + d() + ", v=" + f() + ", countries=" + this.f33746m.size() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f33744k);
            this.f33745l.writeToParcel(parcel, i11);
            Map<String, String> map = this.f33746m;
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
            parcel.writeString(this.f33747n);
            parcel.writeInt(this.f33748o ? 1 : 0);
            TextUtils.writeToParcel(this.f33749p, parcel, i11);
        }

        public static /* synthetic */ c a(c cVar, String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, Map<String, String> map, String str2, boolean z11, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.e();
            }
            if ((i11 & 2) != 0) {
                kVar = cVar.d();
            }
            com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar2 = kVar;
            if ((i11 & 4) != 0) {
                map = cVar.f33746m;
            }
            Map<String, String> map2 = map;
            if ((i11 & 8) != 0) {
                str2 = cVar.f();
            }
            String str3 = str2;
            if ((i11 & 16) != 0) {
                z11 = cVar.h();
            }
            boolean z12 = z11;
            if ((i11 & 32) != 0) {
                charSequence = cVar.b();
            }
            return cVar.a(str, kVar2, map2, str3, z12, charSequence);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, Map<String, String> map, String str2, boolean z11, CharSequence charSequence) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33744k = str;
            this.f33745l = kVar;
            this.f33746m = map;
            this.f33747n = str2;
            this.f33748o = z11;
            this.f33749p = charSequence;
        }
    }

    public static final class d extends FormItem {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33750k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33751l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean f33752m;

        /* renamed from: n  reason: collision with root package name */
        public final String f33753n;

        /* renamed from: o  reason: collision with root package name */
        public final CharSequence f33754o;

        public static final class a implements Parcelable.Creator<d> {
            /* renamed from: a */
            public final d createFromParcel(Parcel parcel) {
                return new d(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0, parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final d[] newArray(int i11) {
                return new d[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, boolean z11, String str2, CharSequence charSequence, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, str, (i11 & 4) != 0 ? false : z11, str2, (i11 & 16) != 0 ? null : charSequence);
        }

        public final d a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, boolean z11, String str2, CharSequence charSequence) {
            return new d(kVar, str, z11, str2, charSequence);
        }

        public CharSequence b() {
            return this.f33754o;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33750k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33751l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(d(), dVar.d()) && x.b(e(), dVar.e()) && this.f33752m == dVar.f33752m && x.b(f(), dVar.f()) && x.b(b(), dVar.b());
        }

        public String f() {
            return this.f33753n;
        }

        public int hashCode() {
            int hashCode = ((d().hashCode() * 31) + e().hashCode()) * 31;
            boolean z11 = this.f33752m;
            if (z11) {
                z11 = true;
            }
            int i11 = 0;
            int hashCode2 = (((hashCode + (z11 ? 1 : 0)) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return hashCode2 + i11;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final boolean n() {
            return this.f33752m;
        }

        public final String o() {
            return f();
        }

        public final CharSequence p() {
            return b();
        }

        public final boolean q() {
            return this.f33752m;
        }

        public String toString() {
            return "Date(item=" + d() + ", sectionId=" + e() + ", onlyPastDates=" + this.f33752m + ", value=" + f() + ", error=" + b() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33750k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33751l);
            parcel.writeInt(this.f33752m ? 1 : 0);
            parcel.writeString(this.f33753n);
            TextUtils.writeToParcel(this.f33754o, parcel, i11);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, boolean z11, String str2, CharSequence charSequence) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33750k = kVar;
            this.f33751l = str;
            this.f33752m = z11;
            this.f33753n = str2;
            this.f33754o = charSequence;
        }

        public static /* synthetic */ d a(d dVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, boolean z11, String str2, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = dVar.d();
            }
            if ((i11 & 2) != 0) {
                str = dVar.e();
            }
            String str3 = str;
            if ((i11 & 4) != 0) {
                z11 = dVar.f33752m;
            }
            boolean z12 = z11;
            if ((i11 & 8) != 0) {
                str2 = dVar.f();
            }
            String str4 = str2;
            if ((i11 & 16) != 0) {
                charSequence = dVar.b();
            }
            return dVar.a(kVar, str3, z12, str4, charSequence);
        }
    }

    public static final class e extends FormItem {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33755k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33756l;

        /* renamed from: m  reason: collision with root package name */
        public final String f33757m;

        /* renamed from: n  reason: collision with root package name */
        public final CharSequence f33758n;

        public static final class a implements Parcelable.Creator<e> {
            /* renamed from: a */
            public final e createFromParcel(Parcel parcel) {
                return new e(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final e[] newArray(int i11) {
                return new e[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, str, str2, (i11 & 8) != 0 ? null : charSequence);
        }

        public final e a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence) {
            return new e(kVar, str, str2, charSequence);
        }

        public CharSequence b() {
            return this.f33758n;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33755k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33756l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return x.b(d(), eVar.d()) && x.b(e(), eVar.e()) && x.b(f(), eVar.f()) && x.b(b(), eVar.b());
        }

        public String f() {
            return this.f33757m;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return hashCode + i11;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return f();
        }

        public final CharSequence o() {
            return b();
        }

        public String toString() {
            return "DateTime(item=" + d() + ", sectionId=" + e() + ", value=" + f() + ", error=" + b() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33755k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33756l);
            parcel.writeString(this.f33757m);
            TextUtils.writeToParcel(this.f33758n, parcel, i11);
        }

        public e(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33755k = kVar;
            this.f33756l = str;
            this.f33757m = str2;
            this.f33758n = charSequence;
        }

        public static /* synthetic */ e a(e eVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = eVar.d();
            }
            if ((i11 & 2) != 0) {
                str = eVar.e();
            }
            if ((i11 & 4) != 0) {
                str2 = eVar.f();
            }
            if ((i11 & 8) != 0) {
                charSequence = eVar.b();
            }
            return eVar.a(kVar, str, str2, charSequence);
        }
    }

    public static final class f extends FormItem {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final String f33759k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33760l;

        public static final class a implements Parcelable.Creator<f> {
            /* renamed from: a */
            public final f createFromParcel(Parcel parcel) {
                return new f(parcel.readString(), parcel.readString());
            }

            /* renamed from: a */
            public final f[] newArray(int i11) {
                return new f[i11];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public f(java.lang.String r14, java.lang.String r15) {
            /*
                r13 = this;
                com.sumsub.sns.internal.core.data.source.applicant.remote.k r12 = new com.sumsub.sns.internal.core.data.source.applicant.remote.k
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "description_"
                r0.append(r1)
                com.sumsub.sns.internal.core.presentation.form.model.FormItem$b r1 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.f33730i
                java.lang.String r1 = com.sumsub.sns.internal.core.common.i.a((java.lang.Object) r1)
                r0.append(r1)
                java.lang.String r1 = r0.toString()
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 508(0x1fc, float:7.12E-43)
                r11 = 0
                r0 = r12
                r2 = r14
                r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.Boolean) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.util.List) r9, (int) r10, (kotlin.jvm.internal.r) r11)
                r5 = 0
                r8 = 0
                r9 = 252(0xfc, float:3.53E-43)
                r10 = 0
                r0 = r13
                r1 = r15
                r2 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                r13.f33759k = r14
                r13.f33760l = r15
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.FormItem.f.<init>(java.lang.String, java.lang.String):void");
        }

        public final f a(String str, String str2) {
            return new f(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33760l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return x.b(this.f33759k, fVar.f33759k) && x.b(e(), fVar.e());
        }

        public int hashCode() {
            String str = this.f33759k;
            return ((str == null ? 0 : str.hashCode()) * 31) + e().hashCode();
        }

        public final String l() {
            return this.f33759k;
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return this.f33759k;
        }

        public String toString() {
            return "Description(text=" + this.f33759k + ", sectionId=" + e() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f33759k);
            parcel.writeString(this.f33760l);
        }

        public static /* synthetic */ f a(f fVar, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = fVar.f33759k;
            }
            if ((i11 & 2) != 0) {
                str2 = fVar.e();
            }
            return fVar.a(str, str2);
        }
    }

    public static final class g extends FormItem {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33761k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33762l;

        /* renamed from: m  reason: collision with root package name */
        public final String f33763m;

        /* renamed from: n  reason: collision with root package name */
        public final String f33764n;

        /* renamed from: o  reason: collision with root package name */
        public final CharSequence f33765o;

        /* renamed from: p  reason: collision with root package name */
        public final ItemState f33766p;

        /* renamed from: q  reason: collision with root package name */
        public final ItemState f33767q;

        /* renamed from: r  reason: collision with root package name */
        public final String f33768r;

        public static final class a implements Parcelable.Creator<g> {
            /* renamed from: a */
            public final g createFromParcel(Parcel parcel) {
                return new g(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), ItemState.valueOf(parcel.readString()), ItemState.valueOf(parcel.readString()), parcel.readString());
            }

            /* renamed from: a */
            public final g[] newArray(int i11) {
                return new g[i11];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ g(com.sumsub.sns.internal.core.data.source.applicant.remote.k r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.CharSequence r17, com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState r18, com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState r19, java.lang.String r20, int r21, kotlin.jvm.internal.r r22) {
            /*
                r12 = this;
                r0 = r21
                r1 = r0 & 4
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r6 = r2
                goto L_0x000a
            L_0x0009:
                r6 = r15
            L_0x000a:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0010
                r8 = r2
                goto L_0x0012
            L_0x0010:
                r8 = r17
            L_0x0012:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x001a
                com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r1 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState.DEFAULT
                r9 = r1
                goto L_0x001c
            L_0x001a:
                r9 = r18
            L_0x001c:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0024
                com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r1 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState.DEFAULT
                r10 = r1
                goto L_0x0026
            L_0x0024:
                r10 = r19
            L_0x0026:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x002c
                r11 = r2
                goto L_0x002e
            L_0x002c:
                r11 = r20
            L_0x002e:
                r3 = r12
                r4 = r13
                r5 = r14
                r7 = r16
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.FormItem.g.<init>(com.sumsub.sns.internal.core.data.source.applicant.remote.k, java.lang.String, java.lang.String, java.lang.String, java.lang.CharSequence, com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState, com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState, java.lang.String, int, kotlin.jvm.internal.r):void");
        }

        public final g a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, String str3, CharSequence charSequence, ItemState itemState, ItemState itemState2, String str4) {
            return new g(kVar, str, str2, str3, charSequence, itemState, itemState2, str4);
        }

        public CharSequence b() {
            return this.f33765o;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33761k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33762l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return x.b(d(), gVar.d()) && x.b(e(), gVar.e()) && x.b(f(), gVar.f()) && x.b(this.f33764n, gVar.f33764n) && x.b(b(), gVar.b()) && this.f33766p == gVar.f33766p && this.f33767q == gVar.f33767q && x.b(this.f33768r, gVar.f33768r);
        }

        public String f() {
            return this.f33763m;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            String str = this.f33764n;
            int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + (b() == null ? 0 : b().hashCode())) * 31) + this.f33766p.hashCode()) * 31) + this.f33767q.hashCode()) * 31;
            String str2 = this.f33768r;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode2 + i11;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return f();
        }

        public final String o() {
            return this.f33764n;
        }

        public final CharSequence p() {
            return b();
        }

        public final ItemState q() {
            return this.f33766p;
        }

        public final ItemState r() {
            return this.f33767q;
        }

        public final String s() {
            return this.f33768r;
        }

        public final ItemState t() {
            return this.f33766p;
        }

        public String toString() {
            return "FileAttachment(item=" + d() + ", sectionId=" + e() + ", value=" + f() + ", hint=" + this.f33764n + ", error=" + b() + ", fileState=" + this.f33766p + ", state=" + this.f33767q + ", previewUrl=" + this.f33768r + ')';
        }

        public final String u() {
            return this.f33764n;
        }

        public final String v() {
            return this.f33768r;
        }

        public final ItemState w() {
            return this.f33767q;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33761k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33762l);
            parcel.writeString(this.f33763m);
            parcel.writeString(this.f33764n);
            TextUtils.writeToParcel(this.f33765o, parcel, i11);
            parcel.writeString(this.f33766p.name());
            parcel.writeString(this.f33767q.name());
            parcel.writeString(this.f33768r);
        }

        public static /* synthetic */ g a(g gVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, String str3, CharSequence charSequence, ItemState itemState, ItemState itemState2, String str4, int i11, Object obj) {
            g gVar2 = gVar;
            int i12 = i11;
            return gVar.a((i12 & 1) != 0 ? gVar.d() : kVar, (i12 & 2) != 0 ? gVar.e() : str, (i12 & 4) != 0 ? gVar.f() : str2, (i12 & 8) != 0 ? gVar2.f33764n : str3, (i12 & 16) != 0 ? gVar.b() : charSequence, (i12 & 32) != 0 ? gVar2.f33766p : itemState, (i12 & 64) != 0 ? gVar2.f33767q : itemState2, (i12 & 128) != 0 ? gVar2.f33768r : str4);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, String str3, CharSequence charSequence, ItemState itemState, ItemState itemState2, String str4) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33761k = kVar;
            this.f33762l = str;
            this.f33763m = str2;
            this.f33764n = str3;
            this.f33765o = charSequence;
            this.f33766p = itemState;
            this.f33767q = itemState2;
            this.f33768r = str4;
        }
    }

    public static final class h extends FormItem {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final String f33769k;

        /* renamed from: l  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33770l;

        public static final class a implements Parcelable.Creator<h> {
            /* renamed from: a */
            public final h createFromParcel(Parcel parcel) {
                return new h(parcel.readString(), com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final h[] newArray(int i11) {
                return new h[i11];
            }
        }

        public h(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33769k = str;
            this.f33770l = kVar;
        }

        public final h a(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar) {
            return new h(str, kVar);
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33770l;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33769k;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return x.b(e(), hVar.e()) && x.b(d(), hVar.d());
        }

        public int hashCode() {
            return (e().hashCode() * 31) + d().hashCode();
        }

        public final String l() {
            return e();
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k m() {
            return d();
        }

        public String toString() {
            return "Hidden(sectionId=" + e() + ", item=" + d() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f33769k);
            this.f33770l.writeToParcel(parcel, i11);
        }

        public static /* synthetic */ h a(h hVar, String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = hVar.e();
            }
            if ((i11 & 2) != 0) {
                kVar = hVar.d();
            }
            return hVar.a(str, kVar);
        }
    }

    public static final class i extends FormItem {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33771k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33772l;

        /* renamed from: m  reason: collision with root package name */
        public final List<String> f33773m;

        /* renamed from: n  reason: collision with root package name */
        public final String f33774n;

        /* renamed from: o  reason: collision with root package name */
        public final CharSequence f33775o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f33776p;

        /* renamed from: q  reason: collision with root package name */
        public final List<ItemState> f33777q;

        /* renamed from: r  reason: collision with root package name */
        public final ItemState f33778r;

        /* renamed from: s  reason: collision with root package name */
        public final Map<String, String> f33779s;

        public static final class a implements Parcelable.Creator<i> {
            /* renamed from: a */
            public final i createFromParcel(Parcel parcel) {
                LinkedHashMap linkedHashMap;
                com.sumsub.sns.internal.core.data.source.applicant.remote.k createFromParcel = com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel);
                String readString = parcel.readString();
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                String readString2 = parcel.readString();
                CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                boolean z11 = parcel.readInt() != 0;
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(ItemState.valueOf(parcel.readString()));
                }
                ItemState valueOf = ItemState.valueOf(parcel.readString());
                if (parcel.readInt() == 0) {
                    linkedHashMap = null;
                } else {
                    int readInt2 = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt2);
                    for (int i12 = 0; i12 != readInt2; i12++) {
                        linkedHashMap.put(parcel.readString(), parcel.readString());
                    }
                }
                return new i(createFromParcel, readString, createStringArrayList, readString2, charSequence, z11, arrayList, valueOf, linkedHashMap);
            }

            /* renamed from: a */
            public final i[] newArray(int i11) {
                return new i[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, List<String> list, String str2, CharSequence charSequence, boolean z11, List<? extends ItemState> list2, ItemState itemState, Map<String, String> map) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33771k = kVar;
            this.f33772l = str;
            this.f33773m = list;
            this.f33774n = str2;
            this.f33775o = charSequence;
            this.f33776p = z11;
            this.f33777q = list2;
            this.f33778r = itemState;
            this.f33779s = map;
        }

        public final i a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, List<String> list, String str2, CharSequence charSequence, boolean z11, List<? extends ItemState> list2, ItemState itemState, Map<String, String> map) {
            return new i(kVar, str, list, str2, charSequence, z11, list2, itemState, map);
        }

        public CharSequence b() {
            return this.f33775o;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33771k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33772l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return x.b(d(), iVar.d()) && x.b(e(), iVar.e()) && x.b(g(), iVar.g()) && x.b(this.f33774n, iVar.f33774n) && x.b(b(), iVar.b()) && i() == iVar.i() && x.b(this.f33777q, iVar.f33777q) && this.f33778r == iVar.f33778r && x.b(this.f33779s, iVar.f33779s);
        }

        public List<String> g() {
            return this.f33773m;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (g() == null ? 0 : g().hashCode())) * 31;
            String str = this.f33774n;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
            boolean i12 = i();
            if (i12) {
                i12 = true;
            }
            int hashCode3 = (((((hashCode2 + (i12 ? 1 : 0)) * 31) + this.f33777q.hashCode()) * 31) + this.f33778r.hashCode()) * 31;
            Map<String, String> map = this.f33779s;
            if (map != null) {
                i11 = map.hashCode();
            }
            return hashCode3 + i11;
        }

        public boolean i() {
            return this.f33776p;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final List<String> n() {
            return g();
        }

        public final String o() {
            return this.f33774n;
        }

        public final CharSequence p() {
            return b();
        }

        public final boolean q() {
            return i();
        }

        public final List<ItemState> r() {
            return this.f33777q;
        }

        public final ItemState s() {
            return this.f33778r;
        }

        public final Map<String, String> t() {
            return this.f33779s;
        }

        public String toString() {
            return "MultiFileAttachments(item=" + d() + ", sectionId=" + e() + ", values=" + g() + ", hint=" + this.f33774n + ", error=" + b() + ", isMultivalued=" + i() + ", fileStates=" + this.f33777q + ", state=" + this.f33778r + ", previewUrls=" + this.f33779s + ')';
        }

        public final List<ItemState> u() {
            return this.f33777q;
        }

        public final String v() {
            return this.f33774n;
        }

        public final Map<String, String> w() {
            return this.f33779s;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33771k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33772l);
            parcel.writeStringList(this.f33773m);
            parcel.writeString(this.f33774n);
            TextUtils.writeToParcel(this.f33775o, parcel, i11);
            parcel.writeInt(this.f33776p ? 1 : 0);
            List<ItemState> list = this.f33777q;
            parcel.writeInt(list.size());
            for (ItemState name : list) {
                parcel.writeString(name.name());
            }
            parcel.writeString(this.f33778r.name());
            Map<String, String> map = this.f33779s;
            if (map == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }

        public final ItemState x() {
            return this.f33778r;
        }

        public static /* synthetic */ i a(i iVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, List list, String str2, CharSequence charSequence, boolean z11, List list2, ItemState itemState, Map map, int i11, Object obj) {
            i iVar2 = iVar;
            int i12 = i11;
            return iVar.a((i12 & 1) != 0 ? iVar.d() : kVar, (i12 & 2) != 0 ? iVar.e() : str, (i12 & 4) != 0 ? iVar.g() : list, (i12 & 8) != 0 ? iVar2.f33774n : str2, (i12 & 16) != 0 ? iVar.b() : charSequence, (i12 & 32) != 0 ? iVar.i() : z11, (i12 & 64) != 0 ? iVar2.f33777q : list2, (i12 & 128) != 0 ? iVar2.f33778r : itemState, (i12 & 256) != 0 ? iVar2.f33779s : map);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ i(com.sumsub.sns.internal.core.data.source.applicant.remote.k r11, java.lang.String r12, java.util.List r13, java.lang.String r14, java.lang.CharSequence r15, boolean r16, java.util.List r17, com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState r18, java.util.Map r19, int r20, kotlin.jvm.internal.r r21) {
            /*
                r10 = this;
                r3 = r13
                r0 = r20
                r1 = r0 & 16
                r2 = 0
                if (r1 == 0) goto L_0x000a
                r5 = r2
                goto L_0x000b
            L_0x000a:
                r5 = r15
            L_0x000b:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0012
                r1 = 1
                r6 = r1
                goto L_0x0014
            L_0x0012:
                r6 = r16
            L_0x0014:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0041
                if (r3 == 0) goto L_0x003b
                java.util.ArrayList r1 = new java.util.ArrayList
                r4 = 10
                int r4 = kotlin.collections.CollectionsKt__IterablesKt.u(r13, r4)
                r1.<init>(r4)
                java.util.Iterator r4 = r13.iterator()
            L_0x0029:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto L_0x003f
                java.lang.Object r7 = r4.next()
                java.lang.String r7 = (java.lang.String) r7
                com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r7 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState.DEFAULT
                r1.add(r7)
                goto L_0x0029
            L_0x003b:
                java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            L_0x003f:
                r7 = r1
                goto L_0x0043
            L_0x0041:
                r7 = r17
            L_0x0043:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x004b
                com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r1 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState.DEFAULT
                r8 = r1
                goto L_0x004d
            L_0x004b:
                r8 = r18
            L_0x004d:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L_0x0053
                r9 = r2
                goto L_0x0055
            L_0x0053:
                r9 = r19
            L_0x0055:
                r0 = r10
                r1 = r11
                r2 = r12
                r3 = r13
                r4 = r14
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.FormItem.i.<init>(com.sumsub.sns.internal.core.data.source.applicant.remote.k, java.lang.String, java.util.List, java.lang.String, java.lang.CharSequence, boolean, java.util.List, com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState, java.util.Map, int, kotlin.jvm.internal.r):void");
        }
    }

    public static final class j extends FormItem {
        public static final Parcelable.Creator<j> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33780k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33781l;

        /* renamed from: m  reason: collision with root package name */
        public final List<String> f33782m;

        /* renamed from: n  reason: collision with root package name */
        public final CharSequence f33783n;

        /* renamed from: o  reason: collision with root package name */
        public final boolean f33784o;

        public static final class a implements Parcelable.Creator<j> {
            /* renamed from: a */
            public final j createFromParcel(Parcel parcel) {
                return new j(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.createStringArrayList(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
            }

            /* renamed from: a */
            public final j[] newArray(int i11) {
                return new j[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ j(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, List list, CharSequence charSequence, boolean z11, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, str, list, (i11 & 8) != 0 ? null : charSequence, (i11 & 16) != 0 ? true : z11);
        }

        public final j a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, List<String> list, CharSequence charSequence, boolean z11) {
            return new j(kVar, str, list, charSequence, z11);
        }

        public CharSequence b() {
            return this.f33783n;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33780k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33781l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return x.b(d(), jVar.d()) && x.b(e(), jVar.e()) && x.b(g(), jVar.g()) && x.b(b(), jVar.b()) && i() == jVar.i();
        }

        public List<String> g() {
            return this.f33782m;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (g() == null ? 0 : g().hashCode())) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            int i12 = (hashCode + i11) * 31;
            boolean i13 = i();
            if (i13) {
                i13 = true;
            }
            return i12 + (i13 ? 1 : 0);
        }

        public boolean i() {
            return this.f33784o;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final List<String> n() {
            return g();
        }

        public final CharSequence o() {
            return b();
        }

        public final boolean p() {
            return i();
        }

        public String toString() {
            return "MultiSelect(item=" + d() + ", sectionId=" + e() + ", values=" + g() + ", error=" + b() + ", isMultivalued=" + i() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33780k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33781l);
            parcel.writeStringList(this.f33782m);
            TextUtils.writeToParcel(this.f33783n, parcel, i11);
            parcel.writeInt(this.f33784o ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, List<String> list, CharSequence charSequence, boolean z11) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33780k = kVar;
            this.f33781l = str;
            this.f33782m = list;
            this.f33783n = charSequence;
            this.f33784o = z11;
        }

        public static /* synthetic */ j a(j jVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, List<String> list, CharSequence charSequence, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = jVar.d();
            }
            if ((i11 & 2) != 0) {
                str = jVar.e();
            }
            String str2 = str;
            if ((i11 & 4) != 0) {
                list = jVar.g();
            }
            List<String> list2 = list;
            if ((i11 & 8) != 0) {
                charSequence = jVar.b();
            }
            CharSequence charSequence2 = charSequence;
            if ((i11 & 16) != 0) {
                z11 = jVar.i();
            }
            return jVar.a(kVar, str2, list2, charSequence2, z11);
        }
    }

    public static final class k extends FormItem {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final String f33785k;

        /* renamed from: l  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33786l;

        /* renamed from: m  reason: collision with root package name */
        public final Map<String, String> f33787m;

        /* renamed from: n  reason: collision with root package name */
        public final Map<String, com.sumsub.sns.internal.core.data.model.remote.c> f33788n;

        /* renamed from: o  reason: collision with root package name */
        public final String f33789o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f33790p;

        /* renamed from: q  reason: collision with root package name */
        public final String f33791q;

        /* renamed from: r  reason: collision with root package name */
        public final CharSequence f33792r;

        public static final class a implements Parcelable.Creator<k> {
            /* renamed from: a */
            public final k createFromParcel(Parcel parcel) {
                String readString = parcel.readString();
                com.sumsub.sns.internal.core.data.source.applicant.remote.k createFromParcel = com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt2);
                for (int i12 = 0; i12 != readInt2; i12++) {
                    linkedHashMap2.put(parcel.readString(), com.sumsub.sns.internal.core.data.model.remote.c.CREATOR.createFromParcel(parcel));
                }
                return new k(readString, createFromParcel, linkedHashMap, linkedHashMap2, parcel.readString(), parcel.readInt() != 0, parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final k[] newArray(int i11) {
                return new k[i11];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ k(java.lang.String r12, com.sumsub.sns.internal.core.data.source.applicant.remote.k r13, java.util.Map r14, java.util.Map r15, java.lang.String r16, boolean r17, java.lang.String r18, java.lang.CharSequence r19, int r20, kotlin.jvm.internal.r r21) {
            /*
                r11 = this;
                r0 = r20
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0009
                r1 = 0
                r8 = r1
                goto L_0x000b
            L_0x0009:
                r8 = r17
            L_0x000b:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0012
                r0 = 0
                r10 = r0
                goto L_0x0014
            L_0x0012:
                r10 = r19
            L_0x0014:
                r2 = r11
                r3 = r12
                r4 = r13
                r5 = r14
                r6 = r15
                r7 = r16
                r9 = r18
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.FormItem.k.<init>(java.lang.String, com.sumsub.sns.internal.core.data.source.applicant.remote.k, java.util.Map, java.util.Map, java.lang.String, boolean, java.lang.String, java.lang.CharSequence, int, kotlin.jvm.internal.r):void");
        }

        public final k a(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, Map<String, String> map, Map<String, com.sumsub.sns.internal.core.data.model.remote.c> map2, String str2, boolean z11, String str3, CharSequence charSequence) {
            return new k(str, kVar, map, map2, str2, z11, str3, charSequence);
        }

        public CharSequence b() {
            return this.f33792r;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33786l;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33785k;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return x.b(e(), kVar.e()) && x.b(d(), kVar.d()) && x.b(this.f33787m, kVar.f33787m) && x.b(this.f33788n, kVar.f33788n) && x.b(this.f33789o, kVar.f33789o) && this.f33790p == kVar.f33790p && x.b(f(), kVar.f()) && x.b(b(), kVar.b());
        }

        public String f() {
            return this.f33791q;
        }

        public int hashCode() {
            int hashCode = ((((((e().hashCode() * 31) + d().hashCode()) * 31) + this.f33787m.hashCode()) * 31) + this.f33788n.hashCode()) * 31;
            String str = this.f33789o;
            int i11 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            boolean z11 = this.f33790p;
            if (z11) {
                z11 = true;
            }
            int hashCode3 = (((hashCode2 + (z11 ? 1 : 0)) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return hashCode3 + i11;
        }

        public final String l() {
            return e();
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k m() {
            return d();
        }

        public final Map<String, String> n() {
            return this.f33787m;
        }

        public final Map<String, com.sumsub.sns.internal.core.data.model.remote.c> o() {
            return this.f33788n;
        }

        public final String p() {
            return this.f33789o;
        }

        public final boolean q() {
            return this.f33790p;
        }

        public final String r() {
            return f();
        }

        public final CharSequence s() {
            return b();
        }

        public final Map<String, String> t() {
            return this.f33787m;
        }

        public String toString() {
            return com.sumsub.sns.internal.core.common.i.a((Object) this) + " (s=" + e() + ", i=" + d() + ", v=" + f() + ", countries=" + this.f33787m.size() + ')';
        }

        public final String u() {
            return this.f33789o;
        }

        public final Map<String, com.sumsub.sns.internal.core.data.model.remote.c> v() {
            return this.f33788n;
        }

        public final boolean w() {
            return this.f33790p;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f33785k);
            this.f33786l.writeToParcel(parcel, i11);
            Map<String, String> map = this.f33787m;
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
            Map<String, com.sumsub.sns.internal.core.data.model.remote.c> map2 = this.f33788n;
            parcel.writeInt(map2.size());
            for (Map.Entry next2 : map2.entrySet()) {
                parcel.writeString((String) next2.getKey());
                ((com.sumsub.sns.internal.core.data.model.remote.c) next2.getValue()).writeToParcel(parcel, i11);
            }
            parcel.writeString(this.f33789o);
            parcel.writeInt(this.f33790p ? 1 : 0);
            parcel.writeString(this.f33791q);
            TextUtils.writeToParcel(this.f33792r, parcel, i11);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, Map<String, String> map, Map<String, com.sumsub.sns.internal.core.data.model.remote.c> map2, String str2, boolean z11, String str3, CharSequence charSequence) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33785k = str;
            this.f33786l = kVar;
            this.f33787m = map;
            this.f33788n = map2;
            this.f33789o = str2;
            this.f33790p = z11;
            this.f33791q = str3;
            this.f33792r = charSequence;
        }

        public static /* synthetic */ k a(k kVar, String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar2, Map map, Map map2, String str2, boolean z11, String str3, CharSequence charSequence, int i11, Object obj) {
            k kVar3 = kVar;
            int i12 = i11;
            return kVar.a((i12 & 1) != 0 ? kVar.e() : str, (i12 & 2) != 0 ? kVar.d() : kVar2, (i12 & 4) != 0 ? kVar3.f33787m : map, (i12 & 8) != 0 ? kVar3.f33788n : map2, (i12 & 16) != 0 ? kVar3.f33789o : str2, (i12 & 32) != 0 ? kVar3.f33790p : z11, (i12 & 64) != 0 ? kVar.f() : str3, (i12 & 128) != 0 ? kVar.b() : charSequence);
        }
    }

    public static final class l extends FormItem {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33793k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33794l;

        public static final class a implements Parcelable.Creator<l> {
            /* renamed from: a */
            public final l createFromParcel(Parcel parcel) {
                return new l(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString());
            }

            /* renamed from: a */
            public final l[] newArray(int i11) {
                return new l[i11];
            }
        }

        public l(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33793k = kVar;
            this.f33794l = str;
        }

        public final l a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str) {
            return new l(kVar, str);
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33793k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33794l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return x.b(d(), lVar.d()) && x.b(e(), lVar.e());
        }

        public int hashCode() {
            return (d().hashCode() * 31) + e().hashCode();
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public String toString() {
            return "Section(item=" + d() + ", sectionId=" + e() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33793k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33794l);
        }

        public static /* synthetic */ l a(l lVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = lVar.d();
            }
            if ((i11 & 2) != 0) {
                str = lVar.e();
            }
            return lVar.a(kVar, str);
        }
    }

    public static final class m extends FormItem {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33795k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33796l;

        /* renamed from: m  reason: collision with root package name */
        public final String f33797m;

        /* renamed from: n  reason: collision with root package name */
        public final CharSequence f33798n;

        public static final class a implements Parcelable.Creator<m> {
            /* renamed from: a */
            public final m createFromParcel(Parcel parcel) {
                return new m(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final m[] newArray(int i11) {
                return new m[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ m(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, str, str2, (i11 & 8) != 0 ? null : charSequence);
        }

        public final m a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence) {
            return new m(kVar, str, str2, charSequence);
        }

        public CharSequence b() {
            return this.f33798n;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33795k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33796l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return x.b(d(), mVar.d()) && x.b(e(), mVar.e()) && x.b(f(), mVar.f()) && x.b(b(), mVar.b());
        }

        public String f() {
            return this.f33797m;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return hashCode + i11;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return f();
        }

        public final CharSequence o() {
            return b();
        }

        public String toString() {
            return "Select(item=" + d() + ", sectionId=" + e() + ", value=" + f() + ", error=" + b() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33795k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33796l);
            parcel.writeString(this.f33797m);
            TextUtils.writeToParcel(this.f33798n, parcel, i11);
        }

        public m(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33795k = kVar;
            this.f33796l = str;
            this.f33797m = str2;
            this.f33798n = charSequence;
        }

        public static /* synthetic */ m a(m mVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = mVar.d();
            }
            if ((i11 & 2) != 0) {
                str = mVar.e();
            }
            if ((i11 & 4) != 0) {
                str2 = mVar.f();
            }
            if ((i11 & 8) != 0) {
                charSequence = mVar.b();
            }
            return mVar.a(kVar, str, str2, charSequence);
        }
    }

    public static final class n extends FormItem {
        public static final Parcelable.Creator<n> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33799k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33800l;

        /* renamed from: m  reason: collision with root package name */
        public final String f33801m;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f33802n;

        /* renamed from: o  reason: collision with root package name */
        public final CharSequence f33803o;

        public static final class a implements Parcelable.Creator<n> {
            /* renamed from: a */
            public final n createFromParcel(Parcel parcel) {
                return new n(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final n[] newArray(int i11) {
                return new n[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ n(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, boolean z11, CharSequence charSequence, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, str, str2, (i11 & 8) != 0 ? true : z11, (i11 & 16) != 0 ? null : charSequence);
        }

        public final n a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, boolean z11, CharSequence charSequence) {
            return new n(kVar, str, str2, z11, charSequence);
        }

        public CharSequence b() {
            return this.f33803o;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33799k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33800l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return x.b(d(), nVar.d()) && x.b(e(), nVar.e()) && x.b(f(), nVar.f()) && h() == nVar.h() && x.b(b(), nVar.b());
        }

        public String f() {
            return this.f33801m;
        }

        public boolean h() {
            return this.f33802n;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            boolean h11 = h();
            if (h11) {
                h11 = true;
            }
            int i12 = (hashCode + (h11 ? 1 : 0)) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return i12 + i11;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return f();
        }

        public final boolean o() {
            return h();
        }

        public final CharSequence p() {
            return b();
        }

        public String toString() {
            return "SelectDropdown(item=" + d() + ", sectionId=" + e() + ", value=" + f() + ", isEnabled=" + h() + ", error=" + b() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33799k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33800l);
            parcel.writeString(this.f33801m);
            parcel.writeInt(this.f33802n ? 1 : 0);
            TextUtils.writeToParcel(this.f33803o, parcel, i11);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, boolean z11, CharSequence charSequence) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33799k = kVar;
            this.f33800l = str;
            this.f33801m = str2;
            this.f33802n = z11;
            this.f33803o = charSequence;
        }

        public static /* synthetic */ n a(n nVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, boolean z11, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = nVar.d();
            }
            if ((i11 & 2) != 0) {
                str = nVar.e();
            }
            String str3 = str;
            if ((i11 & 4) != 0) {
                str2 = nVar.f();
            }
            String str4 = str2;
            if ((i11 & 8) != 0) {
                z11 = nVar.h();
            }
            boolean z12 = z11;
            if ((i11 & 16) != 0) {
                charSequence = nVar.b();
            }
            return nVar.a(kVar, str3, str4, z12, charSequence);
        }
    }

    public static final class o extends FormItem {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final String f33804k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33805l;

        public static final class a implements Parcelable.Creator<o> {
            /* renamed from: a */
            public final o createFromParcel(Parcel parcel) {
                return new o(parcel.readString(), parcel.readString());
            }

            /* renamed from: a */
            public final o[] newArray(int i11) {
                return new o[i11];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public o(java.lang.String r14, java.lang.String r15) {
            /*
                r13 = this;
                com.sumsub.sns.internal.core.data.source.applicant.remote.k r12 = new com.sumsub.sns.internal.core.data.source.applicant.remote.k
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "subtitle_"
                r0.append(r1)
                com.sumsub.sns.internal.core.presentation.form.model.FormItem$b r1 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.f33730i
                java.lang.String r1 = com.sumsub.sns.internal.core.common.i.a((java.lang.Object) r1)
                r0.append(r1)
                java.lang.String r1 = r0.toString()
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 508(0x1fc, float:7.12E-43)
                r11 = 0
                r0 = r12
                r2 = r14
                r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.Boolean) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.util.List) r9, (int) r10, (kotlin.jvm.internal.r) r11)
                r5 = 0
                r8 = 0
                r9 = 252(0xfc, float:3.53E-43)
                r10 = 0
                r0 = r13
                r1 = r15
                r2 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                r13.f33804k = r14
                r13.f33805l = r15
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.FormItem.o.<init>(java.lang.String, java.lang.String):void");
        }

        public final o a(String str, String str2) {
            return new o(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33805l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return x.b(this.f33804k, oVar.f33804k) && x.b(e(), oVar.e());
        }

        public int hashCode() {
            String str = this.f33804k;
            return ((str == null ? 0 : str.hashCode()) * 31) + e().hashCode();
        }

        public final String l() {
            return this.f33804k;
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return this.f33804k;
        }

        public String toString() {
            return "Subtitle(text=" + this.f33804k + ", sectionId=" + e() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f33804k);
            parcel.writeString(this.f33805l);
        }

        public static /* synthetic */ o a(o oVar, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = oVar.f33804k;
            }
            if ((i11 & 2) != 0) {
                str2 = oVar.e();
            }
            return oVar.a(str, str2);
        }
    }

    public static final class p extends FormItem {
        public static final Parcelable.Creator<p> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33806k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33807l;

        /* renamed from: m  reason: collision with root package name */
        public final String f33808m;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f33809n;

        /* renamed from: o  reason: collision with root package name */
        public final CharSequence f33810o;

        /* renamed from: p  reason: collision with root package name */
        public final List<String> f33811p;

        public static final class a implements Parcelable.Creator<p> {
            /* renamed from: a */
            public final p createFromParcel(Parcel parcel) {
                return new p(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.createStringArrayList());
            }

            /* renamed from: a */
            public final p[] newArray(int i11) {
                return new p[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ p(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, boolean z11, CharSequence charSequence, List list, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, str, str2, (i11 & 8) != 0 ? true : z11, (i11 & 16) != 0 ? null : charSequence, (i11 & 32) != 0 ? null : list);
        }

        public final p a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, boolean z11, CharSequence charSequence, List<String> list) {
            return new p(kVar, str, str2, z11, charSequence, list);
        }

        public CharSequence b() {
            return this.f33810o;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33806k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33807l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            return x.b(d(), pVar.d()) && x.b(e(), pVar.e()) && x.b(f(), pVar.f()) && h() == pVar.h() && x.b(b(), pVar.b()) && x.b(this.f33811p, pVar.f33811p);
        }

        public String f() {
            return this.f33808m;
        }

        public boolean h() {
            return this.f33809n;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            boolean h11 = h();
            if (h11) {
                h11 = true;
            }
            int hashCode2 = (((hashCode + (h11 ? 1 : 0)) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
            List<String> list = this.f33811p;
            if (list != null) {
                i11 = list.hashCode();
            }
            return hashCode2 + i11;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return f();
        }

        public final boolean o() {
            return h();
        }

        public final CharSequence p() {
            return b();
        }

        public final List<String> q() {
            return this.f33811p;
        }

        public final List<String> r() {
            return this.f33811p;
        }

        public String toString() {
            return "Text(item=" + d() + ", sectionId=" + e() + ", value=" + f() + ", isEnabled=" + h() + ", error=" + b() + ", masks=" + this.f33811p + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33806k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33807l);
            parcel.writeString(this.f33808m);
            parcel.writeInt(this.f33809n ? 1 : 0);
            TextUtils.writeToParcel(this.f33810o, parcel, i11);
            parcel.writeStringList(this.f33811p);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, boolean z11, CharSequence charSequence, List<String> list) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33806k = kVar;
            this.f33807l = str;
            this.f33808m = str2;
            this.f33809n = z11;
            this.f33810o = charSequence;
            this.f33811p = list;
        }

        public static /* synthetic */ p a(p pVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, boolean z11, CharSequence charSequence, List<String> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = pVar.d();
            }
            if ((i11 & 2) != 0) {
                str = pVar.e();
            }
            String str3 = str;
            if ((i11 & 4) != 0) {
                str2 = pVar.f();
            }
            String str4 = str2;
            if ((i11 & 8) != 0) {
                z11 = pVar.h();
            }
            boolean z12 = z11;
            if ((i11 & 16) != 0) {
                charSequence = pVar.b();
            }
            CharSequence charSequence2 = charSequence;
            if ((i11 & 32) != 0) {
                list = pVar.f33811p;
            }
            return pVar.a(kVar, str3, str4, z12, charSequence2, list);
        }
    }

    public static final class q extends FormItem {
        public static final Parcelable.Creator<q> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k f33812k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33813l;

        /* renamed from: m  reason: collision with root package name */
        public final String f33814m;

        /* renamed from: n  reason: collision with root package name */
        public final CharSequence f33815n;

        public static final class a implements Parcelable.Creator<q> {
            /* renamed from: a */
            public final q createFromParcel(Parcel parcel) {
                return new q(com.sumsub.sns.internal.core.data.source.applicant.remote.k.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final q[] newArray(int i11) {
                return new q[i11];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ q(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, str, str2, (i11 & 8) != 0 ? null : charSequence);
        }

        public final q a(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence) {
            return new q(kVar, str, str2, charSequence);
        }

        public CharSequence b() {
            return this.f33815n;
        }

        public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
            return this.f33812k;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33813l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            q qVar = (q) obj;
            return x.b(d(), qVar.d()) && x.b(e(), qVar.e()) && x.b(f(), qVar.f()) && x.b(b(), qVar.b());
        }

        public String f() {
            return this.f33814m;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((((d().hashCode() * 31) + e().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return hashCode + i11;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.k l() {
            return d();
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return f();
        }

        public final CharSequence o() {
            return b();
        }

        public String toString() {
            return "TextArea(item=" + d() + ", sectionId=" + e() + ", value=" + f() + ", error=" + b() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f33812k.writeToParcel(parcel, i11);
            parcel.writeString(this.f33813l);
            parcel.writeString(this.f33814m);
            TextUtils.writeToParcel(this.f33815n, parcel, i11);
        }

        public q(com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence) {
            super(str, kVar, (String) null, (List) null, false, (CharSequence) null, (String) null, false, 252, (kotlin.jvm.internal.r) null);
            this.f33812k = kVar;
            this.f33813l = str;
            this.f33814m = str2;
            this.f33815n = charSequence;
        }

        public static /* synthetic */ q a(q qVar, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str, String str2, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = qVar.d();
            }
            if ((i11 & 2) != 0) {
                str = qVar.e();
            }
            if ((i11 & 4) != 0) {
                str2 = qVar.f();
            }
            if ((i11 & 8) != 0) {
                charSequence = qVar.b();
            }
            return qVar.a(kVar, str, str2, charSequence);
        }
    }

    public static final class r extends FormItem {
        public static final Parcelable.Creator<r> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public final String f33816k;

        /* renamed from: l  reason: collision with root package name */
        public final String f33817l;

        public static final class a implements Parcelable.Creator<r> {
            /* renamed from: a */
            public final r createFromParcel(Parcel parcel) {
                return new r(parcel.readString(), parcel.readString());
            }

            /* renamed from: a */
            public final r[] newArray(int i11) {
                return new r[i11];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public r(java.lang.String r14, java.lang.String r15) {
            /*
                r13 = this;
                com.sumsub.sns.internal.core.data.source.applicant.remote.k r12 = new com.sumsub.sns.internal.core.data.source.applicant.remote.k
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "title_"
                r0.append(r1)
                com.sumsub.sns.internal.core.presentation.form.model.FormItem$b r1 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.f33730i
                java.lang.String r1 = com.sumsub.sns.internal.core.common.i.a((java.lang.Object) r1)
                r0.append(r1)
                java.lang.String r1 = r0.toString()
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 508(0x1fc, float:7.12E-43)
                r11 = 0
                r0 = r12
                r2 = r14
                r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.Boolean) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.util.List) r9, (int) r10, (kotlin.jvm.internal.r) r11)
                r5 = 0
                r8 = 0
                r9 = 252(0xfc, float:3.53E-43)
                r10 = 0
                r0 = r13
                r1 = r15
                r2 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                r13.f33816k = r14
                r13.f33817l = r15
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.FormItem.r.<init>(java.lang.String, java.lang.String):void");
        }

        public final r a(String str, String str2) {
            return new r(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f33817l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof r)) {
                return false;
            }
            r rVar = (r) obj;
            return x.b(this.f33816k, rVar.f33816k) && x.b(e(), rVar.e());
        }

        public int hashCode() {
            String str = this.f33816k;
            return ((str == null ? 0 : str.hashCode()) * 31) + e().hashCode();
        }

        public final String l() {
            return this.f33816k;
        }

        public final String m() {
            return e();
        }

        public final String n() {
            return this.f33816k;
        }

        public String toString() {
            return "Title(text=" + this.f33816k + ", sectionId=" + e() + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f33816k);
            parcel.writeString(this.f33817l);
        }

        public static /* synthetic */ r a(r rVar, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = rVar.f33816k;
            }
            if ((i11 & 2) != 0) {
                str2 = rVar.e();
            }
            return rVar.a(str, str2);
        }
    }

    public /* synthetic */ FormItem(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str2, List list, boolean z11, CharSequence charSequence, String str3, boolean z12, kotlin.jvm.internal.r rVar) {
        this(str, kVar, str2, list, z11, charSequence, str3, z12);
    }

    public String a() {
        return this.f33738g;
    }

    public CharSequence b() {
        return this.f33737f;
    }

    public final String c() {
        String p11 = d().p();
        return p11 == null ? com.sumsub.sns.internal.core.common.i.a((Object) this) : p11;
    }

    public com.sumsub.sns.internal.core.data.source.applicant.remote.k d() {
        return this.f33733b;
    }

    public String e() {
        return this.f33732a;
    }

    public String f() {
        return this.f33734c;
    }

    public List<String> g() {
        return this.f33735d;
    }

    public boolean h() {
        return this.f33736e;
    }

    public boolean i() {
        return this.f33739h;
    }

    public final boolean j() {
        return x.b(d().v(), Boolean.TRUE);
    }

    public final String k() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.sumsub.sns.internal.core.common.i.a((Object) this));
        sb2.append(" (");
        sb2.append(e());
        sb2.append('.');
        sb2.append(d().p());
        sb2.append(", isRequired=");
        sb2.append(d().v());
        sb2.append(", hasValue=");
        String f11 = f();
        boolean z11 = false;
        sb2.append(!(f11 == null || f11.length() == 0));
        sb2.append("), hasValues=");
        List<String> g11 = g();
        if (g11 == null || g11.isEmpty()) {
            z11 = true;
        }
        sb2.append(!z11);
        sb2.append(')');
        return sb2.toString();
    }

    public String toString() {
        return com.sumsub.sns.internal.core.common.i.a((Object) this) + ", " + e() + '.' + d().p();
    }

    public FormItem(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.k kVar, String str2, List<String> list, boolean z11, CharSequence charSequence, String str3, boolean z12) {
        this.f33732a = str;
        this.f33733b = kVar;
        this.f33734c = str2;
        this.f33735d = list;
        this.f33736e = z11;
        this.f33737f = charSequence;
        this.f33738g = str3;
        this.f33739h = z12;
    }

    public void a(String str) {
        this.f33738g = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FormItem(java.lang.String r14, com.sumsub.sns.internal.core.data.source.applicant.remote.k r15, java.lang.String r16, java.util.List r17, boolean r18, java.lang.CharSequence r19, java.lang.String r20, boolean r21, int r22, kotlin.jvm.internal.r r23) {
        /*
            r13 = this;
            r0 = r22
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r16
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r17
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x001a
            r1 = 1
            r8 = r1
            goto L_0x001c
        L_0x001a:
            r8 = r18
        L_0x001c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0022
            r9 = r2
            goto L_0x0024
        L_0x0022:
            r9 = r19
        L_0x0024:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002a
            r10 = r2
            goto L_0x002c
        L_0x002a:
            r10 = r20
        L_0x002c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            r11 = r0
            goto L_0x0035
        L_0x0033:
            r11 = r21
        L_0x0035:
            r12 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.FormItem.<init>(java.lang.String, com.sumsub.sns.internal.core.data.source.applicant.remote.k, java.lang.String, java.util.List, boolean, java.lang.CharSequence, java.lang.String, boolean, int, kotlin.jvm.internal.r):void");
    }
}
