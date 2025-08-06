package com.sumsub.sns.internal.core.presentation.form;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f33728a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f33729b;

    public static final class a implements Parcelable.Creator<c> {
        /* renamed from: a */
        public final c createFromParcel(Parcel parcel) {
            return new c(parcel.readString(), parcel.createStringArrayList());
        }

        /* renamed from: a */
        public final c[] newArray(int i11) {
            return new c[i11];
        }
    }

    public c() {
        this((String) null, (List) null, 3, (r) null);
    }

    public final String a() {
        return this.f33728a;
    }

    public final List<String> b() {
        return this.f33729b;
    }

    public final String c() {
        return this.f33728a;
    }

    public final List<String> d() {
        return this.f33729b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return x.b(this.f33728a, cVar.f33728a) && x.b(this.f33729b, cVar.f33729b);
    }

    public int hashCode() {
        String str = this.f33728a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.f33729b;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "ItemValue(value=" + this.f33728a + ", values=" + this.f33729b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33728a);
        parcel.writeStringList(this.f33729b);
    }

    public c(String str, List<String> list) {
        this.f33728a = str;
        this.f33729b = list;
    }

    public final c a(String str, List<String> list) {
        return new c(str, list);
    }

    public static /* synthetic */ c a(c cVar, String str, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cVar.f33728a;
        }
        if ((i11 & 2) != 0) {
            list = cVar.f33729b;
        }
        return cVar.a(str, list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : list);
    }
}
