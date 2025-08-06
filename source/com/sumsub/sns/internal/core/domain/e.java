package com.sumsub.sns.internal.core.domain;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.model.remote.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.x;

public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f33586a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, c> f33587b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f33588c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f33589d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, String> f33590e;

    /* renamed from: f  reason: collision with root package name */
    public final String f33591f;

    public static final class a implements Parcelable.Creator<e> {
        /* renamed from: a */
        public final e createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            LinkedHashMap linkedHashMap3;
            LinkedHashMap linkedHashMap4;
            LinkedHashMap linkedHashMap5 = null;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap6 = new LinkedHashMap(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    linkedHashMap6.put(parcel.readString(), parcel.readString());
                }
                linkedHashMap = linkedHashMap6;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap2 = null;
            } else {
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap7 = new LinkedHashMap(readInt2);
                for (int i12 = 0; i12 != readInt2; i12++) {
                    linkedHashMap7.put(parcel.readString(), c.CREATOR.createFromParcel(parcel));
                }
                linkedHashMap2 = linkedHashMap7;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap3 = null;
            } else {
                int readInt3 = parcel.readInt();
                LinkedHashMap linkedHashMap8 = new LinkedHashMap(readInt3);
                for (int i13 = 0; i13 != readInt3; i13++) {
                    linkedHashMap8.put(parcel.readString(), parcel.readString());
                }
                linkedHashMap3 = linkedHashMap8;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap4 = null;
            } else {
                int readInt4 = parcel.readInt();
                LinkedHashMap linkedHashMap9 = new LinkedHashMap(readInt4);
                for (int i14 = 0; i14 != readInt4; i14++) {
                    linkedHashMap9.put(parcel.readString(), parcel.readString());
                }
                linkedHashMap4 = linkedHashMap9;
            }
            if (parcel.readInt() != 0) {
                int readInt5 = parcel.readInt();
                linkedHashMap5 = new LinkedHashMap(readInt5);
                for (int i15 = 0; i15 != readInt5; i15++) {
                    linkedHashMap5.put(parcel.readString(), parcel.readString());
                }
            }
            return new e(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, linkedHashMap5, parcel.readString());
        }

        /* renamed from: a */
        public final e[] newArray(int i11) {
            return new e[i11];
        }
    }

    public e(Map<String, String> map, Map<String, c> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, String str) {
        this.f33586a = map;
        this.f33587b = map2;
        this.f33588c = map3;
        this.f33589d = map4;
        this.f33590e = map5;
        this.f33591f = str;
    }

    public final Map<String, String> a() {
        return this.f33586a;
    }

    public final Map<String, c> b() {
        return this.f33587b;
    }

    public final Map<String, String> c() {
        return this.f33588c;
    }

    public final Map<String, String> d() {
        return this.f33589d;
    }

    public int describeContents() {
        return 0;
    }

    public final Map<String, String> e() {
        return this.f33590e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return x.b(this.f33586a, eVar.f33586a) && x.b(this.f33587b, eVar.f33587b) && x.b(this.f33588c, eVar.f33588c) && x.b(this.f33589d, eVar.f33589d) && x.b(this.f33590e, eVar.f33590e) && x.b(this.f33591f, eVar.f33591f);
    }

    public final String f() {
        return this.f33591f;
    }

    public final Map<String, String> g() {
        return this.f33586a;
    }

    public final Map<String, String> h() {
        return this.f33588c;
    }

    public int hashCode() {
        Map<String, String> map = this.f33586a;
        int i11 = 0;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, c> map2 = this.f33587b;
        int hashCode2 = (hashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, String> map3 = this.f33588c;
        int hashCode3 = (hashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, String> map4 = this.f33589d;
        int hashCode4 = (hashCode3 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, String> map5 = this.f33590e;
        int hashCode5 = (hashCode4 + (map5 == null ? 0 : map5.hashCode())) * 31;
        String str = this.f33591f;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode5 + i11;
    }

    public final String i() {
        return this.f33591f;
    }

    public final Map<String, String> j() {
        return this.f33590e;
    }

    public final Map<String, c> k() {
        return this.f33587b;
    }

    public final Map<String, String> l() {
        return this.f33589d;
    }

    public String toString() {
        return "CountryResultData(countries=" + this.f33586a + ", phoneMasks=" + this.f33587b + ", countriesMap=" + this.f33588c + ", unfilteredCountriesMap=" + this.f33589d + ", includedCountries=" + this.f33590e + ", currentCountryKey=" + this.f33591f + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Map<String, String> map = this.f33586a;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }
        Map<String, c> map2 = this.f33587b;
        if (map2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map2.size());
            for (Map.Entry next2 : map2.entrySet()) {
                parcel.writeString((String) next2.getKey());
                ((c) next2.getValue()).writeToParcel(parcel, i11);
            }
        }
        Map<String, String> map3 = this.f33588c;
        if (map3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map3.size());
            for (Map.Entry next3 : map3.entrySet()) {
                parcel.writeString((String) next3.getKey());
                parcel.writeString((String) next3.getValue());
            }
        }
        Map<String, String> map4 = this.f33589d;
        if (map4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map4.size());
            for (Map.Entry next4 : map4.entrySet()) {
                parcel.writeString((String) next4.getKey());
                parcel.writeString((String) next4.getValue());
            }
        }
        Map<String, String> map5 = this.f33590e;
        if (map5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map5.size());
            for (Map.Entry next5 : map5.entrySet()) {
                parcel.writeString((String) next5.getKey());
                parcel.writeString((String) next5.getValue());
            }
        }
        parcel.writeString(this.f33591f);
    }

    public final e a(Map<String, String> map, Map<String, c> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, String str) {
        return new e(map, map2, map3, map4, map5, str);
    }

    public static /* synthetic */ e a(e eVar, Map<String, String> map, Map<String, c> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = eVar.f33586a;
        }
        if ((i11 & 2) != 0) {
            map2 = eVar.f33587b;
        }
        Map<String, c> map6 = map2;
        if ((i11 & 4) != 0) {
            map3 = eVar.f33588c;
        }
        Map<String, String> map7 = map3;
        if ((i11 & 8) != 0) {
            map4 = eVar.f33589d;
        }
        Map<String, String> map8 = map4;
        if ((i11 & 16) != 0) {
            map5 = eVar.f33590e;
        }
        Map<String, String> map9 = map5;
        if ((i11 & 32) != 0) {
            str = eVar.f33591f;
        }
        return eVar.a(map, map6, map7, map8, map9, str);
    }
}
