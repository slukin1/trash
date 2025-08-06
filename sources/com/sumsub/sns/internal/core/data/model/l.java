package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.x;

public final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f32640a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32641b;

    public static final class a implements Parcelable.Creator<l> {
        /* renamed from: a */
        public final l createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            boolean z11 = false;
            for (int i11 = 0; i11 != readInt; i11++) {
                arrayList.add(n.CREATOR.createFromParcel(parcel));
            }
            if (parcel.readInt() != 0) {
                z11 = true;
            }
            return new l(arrayList, z11);
        }

        /* renamed from: a */
        public final l[] newArray(int i11) {
            return new l[i11];
        }
    }

    public l(List<n> list, boolean z11) {
        this.f32640a = list;
        this.f32641b = z11;
    }

    public final List<n> a() {
        return this.f32640a;
    }

    public final boolean b() {
        return this.f32641b;
    }

    public final List<n> c() {
        return this.f32640a;
    }

    public final boolean d() {
        return this.f32641b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return x.b(this.f32640a, lVar.f32640a) && this.f32641b == lVar.f32641b;
    }

    public int hashCode() {
        int hashCode = this.f32640a.hashCode() * 31;
        boolean z11 = this.f32641b;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public String toString() {
        return "CompositeDocumentPickerResult(results=" + this.f32640a + ", isSeamless=" + this.f32641b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        List<n> list = this.f32640a;
        parcel.writeInt(list.size());
        for (n writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
        parcel.writeInt(this.f32641b ? 1 : 0);
    }

    public final l a(List<n> list, boolean z11) {
        return new l(list, z11);
    }

    public static /* synthetic */ l a(l lVar, List<n> list, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = lVar.f32640a;
        }
        if ((i11 & 2) != 0) {
            z11 = lVar.f32641b;
        }
        return lVar.a(list, z11);
    }
}
