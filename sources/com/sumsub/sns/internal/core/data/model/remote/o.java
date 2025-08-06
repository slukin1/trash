package com.sumsub.sns.internal.core.data.model.remote;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.jvm.internal.x;

public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f32796a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32797b;

    public static final class a implements Parcelable.Creator<o> {
        /* renamed from: a */
        public final o createFromParcel(Parcel parcel) {
            return new o(parcel.createStringArrayList(), parcel.readString());
        }

        /* renamed from: a */
        public final o[] newArray(int i11) {
            return new o[i11];
        }
    }

    public o(List<String> list, String str) {
        this.f32796a = list;
        this.f32797b = str;
    }

    public final List<String> a() {
        return this.f32796a;
    }

    public final String b() {
        return this.f32797b;
    }

    public final List<String> c() {
        return this.f32796a;
    }

    public final String d() {
        return this.f32797b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return x.b(this.f32796a, oVar.f32796a) && x.b(this.f32797b, oVar.f32797b);
    }

    public int hashCode() {
        List<String> list = this.f32796a;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.f32797b;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "TinInfo(placeHolders=" + this.f32796a + ", regex=" + this.f32797b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringList(this.f32796a);
        parcel.writeString(this.f32797b);
    }

    public final o a(List<String> list, String str) {
        return new o(list, str);
    }

    public static /* synthetic */ o a(o oVar, List<String> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = oVar.f32796a;
        }
        if ((i11 & 2) != 0) {
            str = oVar.f32797b;
        }
        return oVar.a(list, str);
    }
}
