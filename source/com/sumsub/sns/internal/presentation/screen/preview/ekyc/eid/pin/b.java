package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final a f35863a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35864b;

    /* renamed from: c  reason: collision with root package name */
    public final String f35865c;

    /* renamed from: d  reason: collision with root package name */
    public final String f35866d;

    /* renamed from: e  reason: collision with root package name */
    public final String f35867e;

    public static final class a implements Parcelable.Creator<b> {
        /* renamed from: a */
        public final b createFromParcel(Parcel parcel) {
            return new b((a) parcel.readParcelable(b.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: a */
        public final b[] newArray(int i11) {
            return new b[i11];
        }
    }

    public b(a aVar, String str, String str2, String str3, String str4) {
        this.f35863a = aVar;
        this.f35864b = str;
        this.f35865c = str2;
        this.f35866d = str3;
        this.f35867e = str4;
    }

    public final a a() {
        return this.f35863a;
    }

    public final String b() {
        return this.f35864b;
    }

    public final String c() {
        return this.f35865c;
    }

    public final String d() {
        return this.f35866d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f35867e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f35863a, bVar.f35863a) && x.b(this.f35864b, bVar.f35864b) && x.b(this.f35865c, bVar.f35865c) && x.b(this.f35866d, bVar.f35866d) && x.b(this.f35867e, bVar.f35867e);
    }

    public final String f() {
        return this.f35866d;
    }

    public final String g() {
        return this.f35867e;
    }

    public final String h() {
        return this.f35865c;
    }

    public int hashCode() {
        int hashCode = this.f35863a.hashCode() * 31;
        String str = this.f35864b;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f35865c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f35866d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f35867e;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode4 + i11;
    }

    public final a i() {
        return this.f35863a;
    }

    public final String j() {
        return this.f35864b;
    }

    public String toString() {
        return "PinResult(pinMode=" + this.f35863a + ", secret=" + this.f35864b + ", oldPin=" + this.f35865c + ", can=" + this.f35866d + ", lastPinDigit=" + this.f35867e + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.f35863a, i11);
        parcel.writeString(this.f35864b);
        parcel.writeString(this.f35865c);
        parcel.writeString(this.f35866d);
        parcel.writeString(this.f35867e);
    }

    public final b a(a aVar, String str, String str2, String str3, String str4) {
        return new b(aVar, str, str2, str3, str4);
    }

    public static /* synthetic */ b a(b bVar, a aVar, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            aVar = bVar.f35863a;
        }
        if ((i11 & 2) != 0) {
            str = bVar.f35864b;
        }
        String str5 = str;
        if ((i11 & 4) != 0) {
            str2 = bVar.f35865c;
        }
        String str6 = str2;
        if ((i11 & 8) != 0) {
            str3 = bVar.f35866d;
        }
        String str7 = str3;
        if ((i11 & 16) != 0) {
            str4 = bVar.f35867e;
        }
        return bVar.a(aVar, str5, str6, str7, str4);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(a aVar, String str, String str2, String str3, String str4, int i11, r rVar) {
        this(aVar, str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4);
    }
}
