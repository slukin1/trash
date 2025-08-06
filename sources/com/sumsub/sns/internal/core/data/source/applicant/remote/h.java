package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.x;

public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final double f33158a;

    /* renamed from: b  reason: collision with root package name */
    public final double f33159b;

    public static final class a implements Parcelable.Creator<h> {
        /* renamed from: a */
        public final h createFromParcel(Parcel parcel) {
            return new h(parcel.readDouble(), parcel.readDouble());
        }

        /* renamed from: a */
        public final h[] newArray(int i11) {
            return new h[i11];
        }
    }

    public h(double d11, double d12) {
        this.f33158a = d11;
        this.f33159b = d12;
    }

    public final double a() {
        return this.f33158a;
    }

    public final double b() {
        return this.f33159b;
    }

    public final double c() {
        return this.f33159b;
    }

    public final double d() {
        return this.f33158a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return x.b(Double.valueOf(this.f33158a), Double.valueOf(hVar.f33158a)) && x.b(Double.valueOf(this.f33159b), Double.valueOf(hVar.f33159b));
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this.f33158a) * 31) + Double.doubleToLongBits(this.f33159b);
    }

    public String toString() {
        return "DoubleRange(min=" + this.f33158a + ", max=" + this.f33159b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeDouble(this.f33158a);
        parcel.writeDouble(this.f33159b);
    }

    public final h a(double d11, double d12) {
        return new h(d11, d12);
    }

    public static /* synthetic */ h a(h hVar, double d11, double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = hVar.f33158a;
        }
        if ((i11 & 2) != 0) {
            d12 = hVar.f33159b;
        }
        return hVar.a(d11, d12);
    }

    public final boolean a(Double d11) {
        if (d11 == null) {
            return false;
        }
        return RangesKt__RangesKt.b(this.f33158a, this.f33159b).contains(d11);
    }
}
