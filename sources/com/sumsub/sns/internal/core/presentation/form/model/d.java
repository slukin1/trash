package com.sumsub.sns.internal.core.presentation.form.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.model.remote.c;
import com.sumsub.sns.internal.core.domain.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.x;

public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f33836a;

    /* renamed from: b  reason: collision with root package name */
    public final e f33837b;

    public static final class a implements Parcelable.Creator<d> {
        /* renamed from: a */
        public final d createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    linkedHashMap2.put(parcel.readString(), c.CREATOR.createFromParcel(parcel));
                }
                linkedHashMap = linkedHashMap2;
            }
            return new d(linkedHashMap, e.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: a */
        public final d[] newArray(int i11) {
            return new d[i11];
        }
    }

    public d(Map<String, c> map, e eVar) {
        this.f33836a = map;
        this.f33837b = eVar;
    }

    public final Map<String, c> a() {
        return this.f33836a;
    }

    public final e b() {
        return this.f33837b;
    }

    public final e c() {
        return this.f33837b;
    }

    public final Map<String, c> d() {
        return this.f33836a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return x.b(this.f33836a, dVar.f33836a) && x.b(this.f33837b, dVar.f33837b);
    }

    public int hashCode() {
        Map<String, c> map = this.f33836a;
        return ((map == null ? 0 : map.hashCode()) * 31) + this.f33837b.hashCode();
    }

    public String toString() {
        return "CountriesData(phoneCountryCodeWithMasks=" + this.f33836a + ", countriesData=" + this.f33837b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Map<String, c> map = this.f33836a;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                ((c) next.getValue()).writeToParcel(parcel, i11);
            }
        }
        this.f33837b.writeToParcel(parcel, i11);
    }

    public final d a(Map<String, c> map, e eVar) {
        return new d(map, eVar);
    }

    public static /* synthetic */ d a(d dVar, Map<String, c> map, e eVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = dVar.f33836a;
        }
        if ((i11 & 2) != 0) {
            eVar = dVar.f33837b;
        }
        return dVar.a(map, eVar);
    }
}
