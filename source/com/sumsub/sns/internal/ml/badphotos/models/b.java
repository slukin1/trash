package com.sumsub.sns.internal.ml.badphotos.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f34970a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34971b;

    /* renamed from: c  reason: collision with root package name */
    public final Float f34972c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f34973d;

    /* renamed from: e  reason: collision with root package name */
    public final Float f34974e;

    /* renamed from: f  reason: collision with root package name */
    public final Float f34975f;

    /* renamed from: g  reason: collision with root package name */
    public final Integer f34976g;

    /* renamed from: h  reason: collision with root package name */
    public final Integer f34977h;

    /* renamed from: i  reason: collision with root package name */
    public final Boolean f34978i;

    public static final class a implements Parcelable.Creator<b> {
        /* renamed from: a */
        public final b createFromParcel(Parcel parcel) {
            Boolean bool;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Float valueOf = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Float valueOf3 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf4 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Integer valueOf5 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf6 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new b(readString, readString2, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, bool);
        }

        /* renamed from: a */
        public final b[] newArray(int i11) {
            return new b[i11];
        }
    }

    public b() {
        this((String) null, (String) null, (Float) null, (Long) null, (Float) null, (Float) null, (Integer) null, (Integer) null, (Boolean) null, 511, (r) null);
    }

    public final String a() {
        return this.f34970a;
    }

    public final String b() {
        return this.f34971b;
    }

    public final Float c() {
        return this.f34972c;
    }

    public final Long d() {
        return this.f34973d;
    }

    public int describeContents() {
        return 0;
    }

    public final Float e() {
        return this.f34974e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f34970a, bVar.f34970a) && x.b(this.f34971b, bVar.f34971b) && x.b(this.f34972c, bVar.f34972c) && x.b(this.f34973d, bVar.f34973d) && x.b(this.f34974e, bVar.f34974e) && x.b(this.f34975f, bVar.f34975f) && x.b(this.f34976g, bVar.f34976g) && x.b(this.f34977h, bVar.f34977h) && x.b(this.f34978i, bVar.f34978i);
    }

    public final Float f() {
        return this.f34975f;
    }

    public final Integer g() {
        return this.f34976g;
    }

    public final Integer h() {
        return this.f34977h;
    }

    public int hashCode() {
        String str = this.f34970a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f34971b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f11 = this.f34972c;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Long l11 = this.f34973d;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Float f12 = this.f34974e;
        int hashCode5 = (hashCode4 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.f34975f;
        int hashCode6 = (hashCode5 + (f13 == null ? 0 : f13.hashCode())) * 31;
        Integer num = this.f34976g;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f34977h;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.f34978i;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode8 + i11;
    }

    public final Boolean i() {
        return this.f34978i;
    }

    public final Integer j() {
        return this.f34976g;
    }

    public final Integer k() {
        return this.f34977h;
    }

    public final String l() {
        return this.f34971b;
    }

    public final String m() {
        return this.f34970a;
    }

    public final Float n() {
        return this.f34972c;
    }

    public final Long o() {
        return this.f34973d;
    }

    public final Float p() {
        return this.f34975f;
    }

    public final Float q() {
        return this.f34974e;
    }

    public final Boolean r() {
        return this.f34978i;
    }

    public final boolean s() {
        String str = this.f34971b;
        return (str == null || StringsKt__StringsJVMKt.z(str)) || this.f34972c == null || this.f34973d == null;
    }

    public String toString() {
        return "CheckPhotoQualityResult(checkResult=" + this.f34970a + ", checkModel=" + this.f34971b + ", checkScore=" + this.f34972c + ", checkTime=" + this.f34973d + ", lowThreshold=" + this.f34974e + ", highThreshold=" + this.f34975f + ", badAttemptsCounter=" + this.f34976g + ", checkMaxBlockedAttempts=" + this.f34977h + ", isAutocaptured=" + this.f34978i + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f34970a);
        parcel.writeString(this.f34971b);
        Float f11 = this.f34972c;
        if (f11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f11.floatValue());
        }
        Long l11 = this.f34973d;
        if (l11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l11.longValue());
        }
        Float f12 = this.f34974e;
        if (f12 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f12.floatValue());
        }
        Float f13 = this.f34975f;
        if (f13 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f13.floatValue());
        }
        Integer num = this.f34976g;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.f34977h;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Boolean bool = this.f34978i;
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public b(String str, String str2, Float f11, Long l11, Float f12, Float f13, Integer num, Integer num2, Boolean bool) {
        this.f34970a = str;
        this.f34971b = str2;
        this.f34972c = f11;
        this.f34973d = l11;
        this.f34974e = f12;
        this.f34975f = f13;
        this.f34976g = num;
        this.f34977h = num2;
        this.f34978i = bool;
    }

    public final b a(String str, String str2, Float f11, Long l11, Float f12, Float f13, Integer num, Integer num2, Boolean bool) {
        return new b(str, str2, f11, l11, f12, f13, num, num2, bool);
    }

    public static /* synthetic */ b a(b bVar, String str, String str2, Float f11, Long l11, Float f12, Float f13, Integer num, Integer num2, Boolean bool, int i11, Object obj) {
        b bVar2 = bVar;
        int i12 = i11;
        return bVar.a((i12 & 1) != 0 ? bVar2.f34970a : str, (i12 & 2) != 0 ? bVar2.f34971b : str2, (i12 & 4) != 0 ? bVar2.f34972c : f11, (i12 & 8) != 0 ? bVar2.f34973d : l11, (i12 & 16) != 0 ? bVar2.f34974e : f12, (i12 & 32) != 0 ? bVar2.f34975f : f13, (i12 & 64) != 0 ? bVar2.f34976g : num, (i12 & 128) != 0 ? bVar2.f34977h : num2, (i12 & 256) != 0 ? bVar2.f34978i : bool);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.lang.String r11, java.lang.String r12, java.lang.Float r13, java.lang.Long r14, java.lang.Float r15, java.lang.Float r16, java.lang.Integer r17, java.lang.Integer r18, java.lang.Boolean r19, int r20, kotlin.jvm.internal.r r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.badphotos.models.b.<init>(java.lang.String, java.lang.String, java.lang.Float, java.lang.Long, java.lang.Float, java.lang.Float, java.lang.Integer, java.lang.Integer, java.lang.Boolean, int, kotlin.jvm.internal.r):void");
    }
}
