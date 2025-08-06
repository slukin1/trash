package com.sumsub.sns.internal.core.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f33641a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33642b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33643c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f33644d;

    public static final class a implements Parcelable.Creator<c> {
        /* renamed from: a */
        public final c createFromParcel(Parcel parcel) {
            return new c(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* renamed from: a */
        public final c[] newArray(int i11) {
            return new c[i11];
        }
    }

    public c(String str, String str2, String str3, boolean z11) {
        this.f33641a = str;
        this.f33642b = str2;
        this.f33643c = str3;
        this.f33644d = z11;
    }

    public final String a() {
        return this.f33641a;
    }

    public final String b() {
        return this.f33642b;
    }

    public final String c() {
        return this.f33643c;
    }

    public final boolean d() {
        return this.f33644d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f33643c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return x.b(this.f33641a, cVar.f33641a) && x.b(this.f33642b, cVar.f33642b) && x.b(this.f33643c, cVar.f33643c) && this.f33644d == cVar.f33644d;
    }

    public final String f() {
        return this.f33642b;
    }

    public final String g() {
        return this.f33641a;
    }

    public final boolean h() {
        return this.f33644d;
    }

    public int hashCode() {
        int hashCode = ((this.f33641a.hashCode() * 31) + this.f33642b.hashCode()) * 31;
        String str = this.f33643c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z11 = this.f33644d;
        if (z11) {
            z11 = true;
        }
        return hashCode2 + (z11 ? 1 : 0);
    }

    public String toString() {
        return "IntroParams(step=" + this.f33641a + ", scene=" + this.f33642b + ", idDocType=" + this.f33643c + ", isAction=" + this.f33644d + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33641a);
        parcel.writeString(this.f33642b);
        parcel.writeString(this.f33643c);
        parcel.writeInt(this.f33644d ? 1 : 0);
    }

    public final c a(String str, String str2, String str3, boolean z11) {
        return new c(str, str2, str3, z11);
    }

    public static /* synthetic */ c a(c cVar, String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cVar.f33641a;
        }
        if ((i11 & 2) != 0) {
            str2 = cVar.f33642b;
        }
        if ((i11 & 4) != 0) {
            str3 = cVar.f33643c;
        }
        if ((i11 & 8) != 0) {
            z11 = cVar.f33644d;
        }
        return cVar.a(str, str2, str3, z11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, String str2, String str3, boolean z11, int i11, r rVar) {
        this(str, str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? false : z11);
    }
}
