package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f32635a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32636b;

    /* renamed from: c  reason: collision with root package name */
    public final ConfirmationType f32637c;

    /* renamed from: d  reason: collision with root package name */
    public final List<h.d> f32638d;

    public static final class a implements Parcelable.Creator<j> {
        /* renamed from: a */
        public final j createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList arrayList = null;
            ConfirmationType valueOf = parcel.readInt() == 0 ? null : ConfirmationType.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList2.add(h.d.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new j(readString, readString2, valueOf, arrayList);
        }

        /* renamed from: a */
        public final j[] newArray(int i11) {
            return new j[i11];
        }
    }

    public j(String str, String str2, ConfirmationType confirmationType, List<h.d> list) {
        this.f32635a = str;
        this.f32636b = str2;
        this.f32637c = confirmationType;
        this.f32638d = list;
    }

    public final String a() {
        return this.f32635a;
    }

    public final String b() {
        return this.f32636b;
    }

    public final ConfirmationType c() {
        return this.f32637c;
    }

    public final List<h.d> d() {
        return this.f32638d;
    }

    public int describeContents() {
        return 0;
    }

    public final ConfirmationType e() {
        return this.f32637c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return x.b(this.f32635a, jVar.f32635a) && x.b(this.f32636b, jVar.f32636b) && this.f32637c == jVar.f32637c && x.b(this.f32638d, jVar.f32638d);
    }

    public final String f() {
        return this.f32636b;
    }

    public final List<h.d> g() {
        return this.f32638d;
    }

    public final String h() {
        return this.f32635a;
    }

    public int hashCode() {
        String str = this.f32635a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f32636b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ConfirmationType confirmationType = this.f32637c;
        int hashCode3 = (hashCode2 + (confirmationType == null ? 0 : confirmationType.hashCode())) * 31;
        List<h.d> list = this.f32638d;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "ApplicantDataSource(sourceId=" + this.f32635a + ", docType=" + this.f32636b + ", confirmationType=" + this.f32637c + ", fields=" + this.f32638d + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f32635a);
        parcel.writeString(this.f32636b);
        ConfirmationType confirmationType = this.f32637c;
        if (confirmationType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(confirmationType.name());
        }
        List<h.d> list = this.f32638d;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (h.d writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
    }

    public final j a(String str, String str2, ConfirmationType confirmationType, List<h.d> list) {
        return new j(str, str2, confirmationType, list);
    }

    public static /* synthetic */ j a(j jVar, String str, String str2, ConfirmationType confirmationType, List<h.d> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = jVar.f32635a;
        }
        if ((i11 & 2) != 0) {
            str2 = jVar.f32636b;
        }
        if ((i11 & 4) != 0) {
            confirmationType = jVar.f32637c;
        }
        if ((i11 & 8) != 0) {
            list = jVar.f32638d;
        }
        return jVar.a(str, str2, confirmationType, list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, String str2, ConfirmationType confirmationType, List list, int i11, r rVar) {
        this(str, str2, (i11 & 4) != 0 ? null : confirmationType, (i11 & 8) != 0 ? null : list);
    }
}
