package com.jumio.core.data.country;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import jumio.core.o;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class Country implements Comparable<Country>, Parcelable, Serializable {
    public static final Parcelable.Creator<Country> CREATOR = new Country$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public String f39092a;

    /* renamed from: b  reason: collision with root package name */
    public String f39093b;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public Country(String str) {
        this(str, false, 2, (r) null);
    }

    public Country(String str, String str2) {
        this.f39092a = str;
        this.f39093b = str2;
    }

    public final void a(String str, String str2) {
        this.f39092a = str;
        if (x.b(str2, "")) {
            this.f39093b = str;
        } else {
            this.f39093b = str2;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Country)) {
            return false;
        }
        Country country = (Country) obj;
        if (!x.b(country.f39093b, this.f39093b) || !x.b(country.f39092a, this.f39092a)) {
            return false;
        }
        return true;
    }

    public final String getIsoCode() {
        return this.f39092a;
    }

    public final String getName() {
        return this.f39093b;
    }

    public int hashCode() {
        return this.f39092a.hashCode() + o.a(this.f39093b, 31, 31);
    }

    public final void setIsoCode(String str) {
        this.f39092a = str;
    }

    public final void setName(String str) {
        this.f39093b = str;
    }

    public String toString() {
        d0 d0Var = d0.f56774a;
        return String.format("%s (%s)", Arrays.copyOf(new Object[]{this.f39093b, this.f39092a}, 2));
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f39092a);
        parcel.writeString(this.f39093b);
    }

    public int compareTo(Country country) {
        CollationKey collationKey = Collator.getInstance().getCollationKey(this.f39093b);
        country.getClass();
        return collationKey.compareTo(Collator.getInstance().getCollationKey(country.f39093b));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = com.jumio.sdk.util.IsoCountryConverter.convertToAlpha2(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Country(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            r3.<init>((java.lang.String) r0, (java.lang.String) r0)
            int r1 = r4.length()
            r2 = 3
            if (r1 != r2) goto L_0x0012
            java.lang.String r1 = com.jumio.sdk.util.IsoCountryConverter.convertToAlpha2(r4)
            if (r1 != 0) goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            if (r5 == 0) goto L_0x0022
            java.util.Locale r5 = new java.util.Locale
            r5.<init>(r0, r1)
            java.lang.String r5 = r5.getDisplayCountry()
            r3.a(r4, r5)
            goto L_0x0030
        L_0x0022:
            java.util.Locale r5 = new java.util.Locale
            r5.<init>(r0, r1)
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r5 = r5.getDisplayCountry(r0)
            r3.a(r4, r5)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.data.country.Country.<init>(java.lang.String, boolean):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Country(String str, boolean z11, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? true : z11);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Country(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            r2.<init>((java.lang.String) r0, (java.lang.String) r0)
            java.lang.String r1 = r3.readString()
            if (r1 != 0) goto L_0x000c
            r1 = r0
        L_0x000c:
            r2.f39092a = r1
            java.lang.String r3 = r3.readString()
            if (r3 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r3
        L_0x0016:
            r2.f39093b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.data.country.Country.<init>(android.os.Parcel):void");
    }
}
