package com.sumsub.sns.internal.geo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.model.h;
import kotlin.jvm.internal.x;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0395a();

    /* renamed from: a  reason: collision with root package name */
    public final h.d f34713a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34714b;

    /* renamed from: com.sumsub.sns.internal.geo.model.a$a  reason: collision with other inner class name */
    public static final class C0395a implements Parcelable.Creator<a> {
        /* renamed from: a */
        public final a createFromParcel(Parcel parcel) {
            return new a(h.d.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* renamed from: a */
        public final a[] newArray(int i11) {
            return new a[i11];
        }
    }

    public a(h.d dVar, String str) {
        this.f34713a = dVar;
        this.f34714b = str;
    }

    public final h.d a() {
        return this.f34713a;
    }

    public final String b() {
        return this.f34714b;
    }

    public final h.d c() {
        return this.f34713a;
    }

    public final String d() {
        return this.f34714b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return x.b(this.f34713a, aVar.f34713a) && x.b(this.f34714b, aVar.f34714b);
    }

    public int hashCode() {
        return (this.f34713a.hashCode() * 31) + this.f34714b.hashCode();
    }

    public String toString() {
        return "AddressItem(field=" + this.f34713a + ", value=" + this.f34714b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        this.f34713a.writeToParcel(parcel, i11);
        parcel.writeString(this.f34714b);
    }

    public final a a(h.d dVar, String str) {
        return new a(dVar, str);
    }

    public static /* synthetic */ a a(a aVar, h.d dVar, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            dVar = aVar.f34713a;
        }
        if ((i11 & 2) != 0) {
            str = aVar.f34714b;
        }
        return aVar.a(dVar, str);
    }
}
