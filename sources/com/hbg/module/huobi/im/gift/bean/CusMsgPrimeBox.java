package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CusMsgPrimeBox implements Parcelable {
    public static final Parcelable.Creator<CusMsgPrimeBox> CREATOR = new Creator();
    private String account;
    private ArrayList<String> accounts;
    private Double airdropToken;
    private String currency;
    private String groupId;
    private String landingUrl;
    private String logo;
    private Integer participants;

    public static final class Creator implements Parcelable.Creator<CusMsgPrimeBox> {
        /* renamed from: a */
        public final CusMsgPrimeBox createFromParcel(Parcel parcel) {
            return new CusMsgPrimeBox(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.createStringArrayList());
        }

        /* renamed from: b */
        public final CusMsgPrimeBox[] newArray(int i11) {
            return new CusMsgPrimeBox[i11];
        }
    }

    public CusMsgPrimeBox(String str, String str2, Double d11, String str3, String str4, String str5, Integer num, ArrayList<String> arrayList) {
        this.groupId = str;
        this.account = str2;
        this.airdropToken = d11;
        this.logo = str3;
        this.currency = str4;
        this.landingUrl = str5;
        this.participants = num;
        this.accounts = arrayList;
    }

    public static /* synthetic */ CusMsgPrimeBox copy$default(CusMsgPrimeBox cusMsgPrimeBox, String str, String str2, Double d11, String str3, String str4, String str5, Integer num, ArrayList arrayList, int i11, Object obj) {
        CusMsgPrimeBox cusMsgPrimeBox2 = cusMsgPrimeBox;
        int i12 = i11;
        return cusMsgPrimeBox.copy((i12 & 1) != 0 ? cusMsgPrimeBox2.groupId : str, (i12 & 2) != 0 ? cusMsgPrimeBox2.account : str2, (i12 & 4) != 0 ? cusMsgPrimeBox2.airdropToken : d11, (i12 & 8) != 0 ? cusMsgPrimeBox2.logo : str3, (i12 & 16) != 0 ? cusMsgPrimeBox2.currency : str4, (i12 & 32) != 0 ? cusMsgPrimeBox2.landingUrl : str5, (i12 & 64) != 0 ? cusMsgPrimeBox2.participants : num, (i12 & 128) != 0 ? cusMsgPrimeBox2.accounts : arrayList);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.account;
    }

    public final Double component3() {
        return this.airdropToken;
    }

    public final String component4() {
        return this.logo;
    }

    public final String component5() {
        return this.currency;
    }

    public final String component6() {
        return this.landingUrl;
    }

    public final Integer component7() {
        return this.participants;
    }

    public final ArrayList<String> component8() {
        return this.accounts;
    }

    public final CusMsgPrimeBox copy(String str, String str2, Double d11, String str3, String str4, String str5, Integer num, ArrayList<String> arrayList) {
        return new CusMsgPrimeBox(str, str2, d11, str3, str4, str5, num, arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CusMsgPrimeBox)) {
            return false;
        }
        CusMsgPrimeBox cusMsgPrimeBox = (CusMsgPrimeBox) obj;
        return x.b(this.groupId, cusMsgPrimeBox.groupId) && x.b(this.account, cusMsgPrimeBox.account) && x.b(this.airdropToken, cusMsgPrimeBox.airdropToken) && x.b(this.logo, cusMsgPrimeBox.logo) && x.b(this.currency, cusMsgPrimeBox.currency) && x.b(this.landingUrl, cusMsgPrimeBox.landingUrl) && x.b(this.participants, cusMsgPrimeBox.participants) && x.b(this.accounts, cusMsgPrimeBox.accounts);
    }

    public final String getAccount() {
        return this.account;
    }

    public final ArrayList<String> getAccounts() {
        return this.accounts;
    }

    public final Double getAirdropToken() {
        return this.airdropToken;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getLandingUrl() {
        return this.landingUrl;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final Integer getParticipants() {
        return this.participants;
    }

    public int hashCode() {
        String str = this.groupId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.account;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d11 = this.airdropToken;
        int hashCode3 = (hashCode2 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str3 = this.logo;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.currency;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.landingUrl;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.participants;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        ArrayList<String> arrayList = this.accounts;
        if (arrayList != null) {
            i11 = arrayList.hashCode();
        }
        return hashCode7 + i11;
    }

    public final void setAccount(String str) {
        this.account = str;
    }

    public final void setAccounts(ArrayList<String> arrayList) {
        this.accounts = arrayList;
    }

    public final void setAirdropToken(Double d11) {
        this.airdropToken = d11;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setLandingUrl(String str) {
        this.landingUrl = str;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final void setParticipants(Integer num) {
        this.participants = num;
    }

    public String toString() {
        return "CusMsgPrimeBox(groupId=" + this.groupId + ", account=" + this.account + ", airdropToken=" + this.airdropToken + ", logo=" + this.logo + ", currency=" + this.currency + ", landingUrl=" + this.landingUrl + ", participants=" + this.participants + ", accounts=" + this.accounts + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.account);
        Double d11 = this.airdropToken;
        if (d11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d11.doubleValue());
        }
        parcel.writeString(this.logo);
        parcel.writeString(this.currency);
        parcel.writeString(this.landingUrl);
        Integer num = this.participants;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeStringList(this.accounts);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgPrimeBox(String str, String str2, Double d11, String str3, String str4, String str5, Integer num, ArrayList arrayList, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? Double.valueOf(0.0d) : d11, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : num, arrayList);
    }
}
