package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ`\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/kakao/sdk/template/model/Commerce;", "Landroid/os/Parcelable;", "regularPrice", "", "discountPrice", "fixedDiscountPrice", "discountRate", "productName", "", "currencyUnit", "currencyUnitPosition", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCurrencyUnit", "()Ljava/lang/String;", "getCurrencyUnitPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiscountPrice", "getDiscountRate", "getFixedDiscountPrice", "getProductName", "getRegularPrice", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/kakao/sdk/template/model/Commerce;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Commerce implements Parcelable {
    public static final Parcelable.Creator<Commerce> CREATOR = new Creator();
    private final String currencyUnit;
    private final Integer currencyUnitPosition;
    private final Integer discountPrice;
    private final Integer discountRate;
    private final Integer fixedDiscountPrice;
    private final String productName;
    private final int regularPrice;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Commerce> {
        /* renamed from: a */
        public final Commerce createFromParcel(Parcel parcel) {
            return new Commerce(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* renamed from: b */
        public final Commerce[] newArray(int i11) {
            return new Commerce[i11];
        }
    }

    public Commerce(int i11) {
        this(i11, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, 126, (r) null);
    }

    public Commerce(int i11, Integer num) {
        this(i11, num, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, 124, (r) null);
    }

    public Commerce(int i11, Integer num, Integer num2) {
        this(i11, num, num2, (Integer) null, (String) null, (String) null, (Integer) null, 120, (r) null);
    }

    public Commerce(int i11, Integer num, Integer num2, Integer num3) {
        this(i11, num, num2, num3, (String) null, (String) null, (Integer) null, 112, (r) null);
    }

    public Commerce(int i11, Integer num, Integer num2, Integer num3, String str) {
        this(i11, num, num2, num3, str, (String) null, (Integer) null, 96, (r) null);
    }

    public Commerce(int i11, Integer num, Integer num2, Integer num3, String str, String str2) {
        this(i11, num, num2, num3, str, str2, (Integer) null, 64, (r) null);
    }

    public Commerce(int i11, Integer num, Integer num2, Integer num3, String str, String str2, Integer num4) {
        this.regularPrice = i11;
        this.discountPrice = num;
        this.fixedDiscountPrice = num2;
        this.discountRate = num3;
        this.productName = str;
        this.currencyUnit = str2;
        this.currencyUnitPosition = num4;
    }

    public static /* synthetic */ Commerce copy$default(Commerce commerce, int i11, Integer num, Integer num2, Integer num3, String str, String str2, Integer num4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = commerce.regularPrice;
        }
        if ((i12 & 2) != 0) {
            num = commerce.discountPrice;
        }
        Integer num5 = num;
        if ((i12 & 4) != 0) {
            num2 = commerce.fixedDiscountPrice;
        }
        Integer num6 = num2;
        if ((i12 & 8) != 0) {
            num3 = commerce.discountRate;
        }
        Integer num7 = num3;
        if ((i12 & 16) != 0) {
            str = commerce.productName;
        }
        String str3 = str;
        if ((i12 & 32) != 0) {
            str2 = commerce.currencyUnit;
        }
        String str4 = str2;
        if ((i12 & 64) != 0) {
            num4 = commerce.currencyUnitPosition;
        }
        return commerce.copy(i11, num5, num6, num7, str3, str4, num4);
    }

    public final int component1() {
        return this.regularPrice;
    }

    public final Integer component2() {
        return this.discountPrice;
    }

    public final Integer component3() {
        return this.fixedDiscountPrice;
    }

    public final Integer component4() {
        return this.discountRate;
    }

    public final String component5() {
        return this.productName;
    }

    public final String component6() {
        return this.currencyUnit;
    }

    public final Integer component7() {
        return this.currencyUnitPosition;
    }

    public final Commerce copy(int i11, Integer num, Integer num2, Integer num3, String str, String str2, Integer num4) {
        return new Commerce(i11, num, num2, num3, str, str2, num4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Commerce)) {
            return false;
        }
        Commerce commerce = (Commerce) obj;
        return this.regularPrice == commerce.regularPrice && x.b(this.discountPrice, commerce.discountPrice) && x.b(this.fixedDiscountPrice, commerce.fixedDiscountPrice) && x.b(this.discountRate, commerce.discountRate) && x.b(this.productName, commerce.productName) && x.b(this.currencyUnit, commerce.currencyUnit) && x.b(this.currencyUnitPosition, commerce.currencyUnitPosition);
    }

    public final String getCurrencyUnit() {
        return this.currencyUnit;
    }

    public final Integer getCurrencyUnitPosition() {
        return this.currencyUnitPosition;
    }

    public final Integer getDiscountPrice() {
        return this.discountPrice;
    }

    public final Integer getDiscountRate() {
        return this.discountRate;
    }

    public final Integer getFixedDiscountPrice() {
        return this.fixedDiscountPrice;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final int getRegularPrice() {
        return this.regularPrice;
    }

    public int hashCode() {
        int i11 = this.regularPrice * 31;
        Integer num = this.discountPrice;
        int i12 = 0;
        int hashCode = (i11 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.fixedDiscountPrice;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.discountRate;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.productName;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.currencyUnit;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num4 = this.currencyUnitPosition;
        if (num4 != null) {
            i12 = num4.hashCode();
        }
        return hashCode5 + i12;
    }

    public String toString() {
        return "Commerce(regularPrice=" + this.regularPrice + ", discountPrice=" + this.discountPrice + ", fixedDiscountPrice=" + this.fixedDiscountPrice + ", discountRate=" + this.discountRate + ", productName=" + this.productName + ", currencyUnit=" + this.currencyUnit + ", currencyUnitPosition=" + this.currencyUnitPosition + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.regularPrice);
        Integer num = this.discountPrice;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.fixedDiscountPrice;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.discountRate;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.productName);
        parcel.writeString(this.currencyUnit);
        Integer num4 = this.currencyUnitPosition;
        if (num4 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num4.intValue());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Commerce(int r8, java.lang.Integer r9, java.lang.Integer r10, java.lang.Integer r11, java.lang.String r12, java.lang.String r13, java.lang.Integer r14, int r15, kotlin.jvm.internal.r r16) {
        /*
            r7 = this;
            r0 = r15 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r9
        L_0x0008:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r10
        L_0x000f:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r11
        L_0x0016:
            r4 = r15 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r12
        L_0x001d:
            r5 = r15 & 32
            if (r5 == 0) goto L_0x0023
            r5 = r1
            goto L_0x0024
        L_0x0023:
            r5 = r13
        L_0x0024:
            r6 = r15 & 64
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r14
        L_0x002a:
            r9 = r7
            r10 = r8
            r11 = r0
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.template.model.Commerce.<init>(int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.r):void");
    }
}
